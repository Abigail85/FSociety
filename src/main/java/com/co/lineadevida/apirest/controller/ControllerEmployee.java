package com.co.lineadevida.apirest.controller;


import com.co.lineadevida.apirest.repository.EntityEmployee;
import com.co.lineadevida.apirest.repository.EntityEnterprise;
import com.co.lineadevida.apirest.repository.EntityLicenses;
import com.co.lineadevida.apirest.repository.EntityProfile;
import com.co.lineadevida.apirest.services.ServicesEmployee;
import com.co.lineadevida.apirest.services.ServicesEnterprise;
import com.co.lineadevida.apirest.services.ServicesProfile;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.json.GsonJsonParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Api(tags = "Employee",description = "Metodos para el api employee")
@RestController
@RequestMapping(value ="/lineadevida/Employee")
public class ControllerEmployee {

    @Autowired
    ServicesEmployee servicesEmployee;

    @Autowired
    ServicesProfile servicesProfile;

    @Autowired
    ServicesEnterprise servicesEnterprise;
    @ApiOperation(value = "End point to list Employee ")
    @GetMapping(path = "/listEmployee",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EntityEmployee> listEmployee(){

        return  servicesEmployee.toList();

    }

    @ApiOperation(value = "End point insert employee")
    @PostMapping(path = "/insertEmployee",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean>insertEmployee(@RequestBody EntityEmployee employee){

        return new ResponseEntity<Boolean>(servicesEmployee.insertEmployee(employee),HttpStatus.OK);

    }

    @ApiOperation(value = "End point search employee")
    @GetMapping(path = "/searchEmployee/{id}",produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<Object> searchEmployee(@PathVariable Long id){

        return new ResponseEntity(servicesEmployee.searchEmployee(id), HttpStatus.OK) ;

    }
    @ApiOperation(value = "End point search employee por le iD")
    @PatchMapping(value = "/updateEmployee",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateEmployeeId( @RequestBody EntityEmployee employee){
        servicesEmployee.updateEmployee(employee);

    }
    @ApiOperation(value = "End point delete employee por le iD")
    @DeleteMapping(value = "/deleteEmployee", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteEmployeeId( @RequestBody EntityEmployee idEmployee){
        servicesEmployee.deleteEmployee(idEmployee);


    }
    @ApiOperation(value = "End point insert employee")
    @PostMapping(path = "/insertEmployeeRol",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertEmployeeRol(@RequestBody EntityEmployee employee){
        servicesEmployee.insertEmployeeRol(employee);

    }

}
