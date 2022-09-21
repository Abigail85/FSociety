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
        servicesProfile.deleteProfile(idEmployee);
        try {
            repositoryEmployee.delete(idEmployee);

        }catch (Exception e){
            return "El id = " + idEmployee +" No existe";
        }

        return "El usuario se elimino exitosamente";

    }
    public String insertEmployeeRol(EntityEmployee employee){

        try{
            if(employee.getRole().equals(Enum_RoleName.ROLE_ADMIN)){
                EntityLicenses entityRol = new EntityLicenses(true,true,true,true,employee);
                repositoryLicenses.save(entityRol);
                employee.setPermisosCollection(entityRol.getIdEmployee().getPermisosCollection());
                repositoryEmployee.save(employee);
            }else if(employee.getRole().equals(Enum_RoleName.ROLE_OPERARIO)){
               EntityLicenses entityRol = new EntityLicenses(false,true,false,false,employee);
                repositoryLicenses.save(entityRol);
                employee.setPermisosCollection(entityRol.getIdEmployee().getPermisosCollection());
                repositoryEmployee.save(employee);

            }else{
                System.out.println("Este rol no existe" );
           }
        }catch (Exception e){
            return "Algo falló, por favor intente nuevamente";
        }
        return "Empleado creado existosamente";
    }
}











