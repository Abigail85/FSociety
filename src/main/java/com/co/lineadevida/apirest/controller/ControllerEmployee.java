package com.co.lineadevida.apirest.controller;

import com.co.lineadevida.apirest.models.Employee;
import com.co.lineadevida.apirest.repository.EntityEmployee;
import com.co.lineadevida.apirest.services.ServicesEmployee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Api(tags = "Employee",description = "Metodos para el api persona")
@RestController
@RequestMapping(value ="/lineadevida/Employee")
public class ControllerEmployee {

    @Autowired
    ServicesEmployee servicesEmployee;

    @ApiOperation(value = "End point to list Employee ")
    @GetMapping(path = "/listEmployee",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> listEmployee(){

        return new ResponseEntity<Object>(servicesEmployee.toList(), HttpStatus.OK) ;
    }

    @ApiOperation(value = "End point insert employee")
    @PostMapping(path = "/insertEmployee",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean>insertEmployee(@RequestBody EntityEmployee employee){
        return new ResponseEntity<Boolean>(servicesEmployee.insertEmployee(employee),HttpStatus.OK);
    }

    @ApiOperation(value = "End ponit search employee")
    @GetMapping(path = "/searchEmployee/{id}",produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<Object> searchEmployee(@PathVariable Long id){

        return new ResponseEntity<Object>(servicesEmployee.searchEmployee(id), HttpStatus.OK) ;

    }

}
