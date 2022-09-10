package com.co.lineadevida.apirest.services;


import com.co.lineadevida.apirest.repository.*;
import com.co.lineadevida.apirest.util.Enum_RoleName;
import com.google.common.collect.ObjectArrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServicesEmployee {


    private RepositoryEmployee repositoryEmployee;


    @Autowired
    public void setRepository (RepositoryEmployee repositoryEmployee){
        this.repositoryEmployee = repositoryEmployee;
    }



    @Autowired
    RepositoryProfile repositoryProfile;
    @Autowired
    RepositoryLicenses repositoryLicenses;

    @Autowired
    RepositoryEnterprise repositoryEnterprise;

    public List<EntityEmployee> toList() {
        List<EntityEmployee> list = repositoryEmployee.findAll();
        return list;
    }

    public Boolean insertEmployee(EntityEmployee employee){
        try{
            repositoryEmployee.save(employee);

        }catch (Exception e){
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }


    public Optional<EntityEmployee> searchEmployee(Long idEmployee) {
        return repositoryEmployee.findById(idEmployee);

    }

    public void updateEmployee(EntityEmployee employee) {

        EntityEmployee updateEmployee = repositoryEmployee.findById(employee.getIdEmployee()).orElse(null);

        if (employee.getNameEmployee() != null) {
            updateEmployee.setNameEmployee((employee.getNameEmployee()));
            updateEmployee.setUpdateAtEmployee(LocalDate.now());
        } else if (employee.getLastNameEmployee() != null) {
            updateEmployee.setLastNameEmployee((employee.getLastNameEmployee()));
            updateEmployee.setUpdateAtEmployee(LocalDate.now());
        } else if (employee.getNroDocumentEmployee() != null) {
            updateEmployee.setNroDocumentEmployee(employee.getNroDocumentEmployee());
            updateEmployee.setUpdateAtEmployee(LocalDate.now());
        } else if (employee.getEmailEmployee() != null) {
            updateEmployee.setEmailEmployee(employee.getEmailEmployee());
            updateEmployee.setUpdateAtEmployee(LocalDate.now());
        } else if (employee.getRole() != null) {
            updateEmployee.setRole(employee.getRole());
            updateEmployee.setUpdateAtEmployee(LocalDate.now());


        }
        repositoryEmployee.save(updateEmployee);
    }

    public String deleteEmployee(EntityEmployee idEmployee){
        if(idEmployee !=null) {
             repositoryEmployee.delete(idEmployee);
             return "El usuario se elimino exitosamente";
        }else{
            return "El id = " + idEmployee +" No existe";
        }


    }
    public void insertEmployeeRol(EntityEmployee employee){

        if(employee.getRole().equals(Enum_RoleName.ROLE_ADMIN)){
            repositoryEmployee.save(employee);
            EntityLicenses entityRol = new EntityLicenses(true,true,true,true,employee);
            repositoryLicenses.save(entityRol);

        }else if(employee.getRole().equals(Enum_RoleName.ROLE_OPERARIO)){
            repositoryEmployee.save(employee);
            EntityLicenses entityRol = new EntityLicenses(true,false,false,false,employee);
            repositoryLicenses.save(entityRol);

        }else{
            System.out.println("Este rol no existe" );
        }
    }
}










