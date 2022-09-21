package com.co.lineadevida.apirest.controller;


import com.co.lineadevida.apirest.models.EntityEmployee;
import com.co.lineadevida.apirest.models.EntityProfile;
import com.co.lineadevida.apirest.services.ServicesEmployee;

import com.co.lineadevida.apirest.services.ServicesProfile;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;




@Api(tags = "Employee",description = "Metodos para el api employee")
@RestController
@RequestMapping(value ="/lineadevida/Employee")
public class ControllerEmployee {

    @Autowired
    ServicesEmployee servicesEmployee;

    @Autowired
    ServicesProfile servicesProfile;


    @ApiOperation(value = "End point to list Employee ")
    @GetMapping(path = "/listOfAllEmployees",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> listOfAllEmployees(){

        return new ResponseEntity<Object>(servicesEmployee.listOfAllEmployees(), HttpStatus.OK) ;


    }

    @ApiOperation(value = "End point insert employee")
    @PostMapping(path = "/insertEmployee",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <EntityEmployee> insertEmployee(@RequestBody EntityEmployee employee){

        return new ResponseEntity(servicesEmployee.insertEmployee(employee),HttpStatus.OK);

    }

    @ApiOperation(value = "End point search employee")
    @GetMapping(path = "/searchEmployee/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchEmployee(@PathVariable Long id){

        return new ResponseEntity(servicesEmployee.searchEmployee(id), HttpStatus.OK) ;

    }
    @ApiOperation(value = "End point search employee")
    @GetMapping(path = "/searchEmployee/{id}/profile",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchEmployeeIdProfile(@PathVariable Long id){

        return new ResponseEntity(servicesProfile.searchProfile(id), HttpStatus.OK) ;

    }
    @ApiOperation(value = "End point search employee por le iD")
    @PatchMapping(value = "/updateEmployee",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public String updateEmployeeId( @RequestBody EntityEmployee employee){

       return servicesEmployee.updateEmployee(employee);

    }
    @ApiOperation(value = "End point delete employee por le iD")
    @DeleteMapping(value = "/deleteEmployee")
    public String deleteEmployeeId( @RequestBody EntityEmployee idEmployee){

       return servicesEmployee.deleteEmployee(idEmployee);


    }
    @ApiOperation(value = "End point insert employee")
    @PostMapping(path = "/insertEmployeeRol",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertEmployeeRol(@RequestBody EntityEmployee employee){
        servicesEmployee.insertEmployeeRol(employee);

    }

}
