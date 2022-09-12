package com.co.lineadevida.apirest.services;


import com.co.lineadevida.apirest.models.EntityEmployee;
import com.co.lineadevida.apirest.models.EntityLicenses;
import com.co.lineadevida.apirest.models.EntityProfile;
import com.co.lineadevida.apirest.repository.*;
import com.co.lineadevida.apirest.util.Enum_RoleName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServicesEmployee {


    @Autowired
     RepositoryEmployee repositoryEmployee;


    @Autowired
    RepositoryProfile repositoryProfile;
    @Autowired
    RepositoryLicenses repositoryLicenses;



@Autowired
ServicesProfile servicesProfile;



    public List<EntityEmployee> listOfAllEmployees() {
        List<EntityEmployee> listEmployees = repositoryEmployee.findAll();
        return listEmployees;
    }


    public String insertEmployee(EntityEmployee employee){
            EntityEmployee entityEmployee = new EntityEmployee();


        try{
            employee.setCreatedAtEmployee(LocalDate.now());
            repositoryEmployee.save(employee);
            servicesProfile.insertProfile(employee);
            EntityProfile profile =servicesProfile.insertProfile(employee);
            employee.setIdProfile(profile);






        }catch (Exception e){
            return "Algo falló, por favor intente nuevamente";
        }
        return "Empleado creado existosamente";
    }


    public EntityEmployee searchEmployee(Long idEmployee) {
        EntityEmployee searchEmployeeId;
        if(idEmployee != null) {
            searchEmployeeId = repositoryEmployee.findById(idEmployee).orElse(null);
        }else {
           searchEmployeeId = searchEmployee(null);
        }
        return searchEmployeeId;

    }

    public String updateEmployee(EntityEmployee employee) {

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
        }else {
            return "Algo fallo no se pudo altualizar el empleado";
        }
        repositoryEmployee.save(updateEmployee);
        return "El empleado " + employee.getNameEmployee() + " se actualizo existosamente";
    }

    public String deleteEmployee(EntityEmployee idEmployee){
        EntityProfile profile = null;
        if(idEmployee !=null) {
             repositoryEmployee.delete(idEmployee);
            // repositoryProfile.delete(idEmployee.setProfile(););
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










