package com.co.lineadevida.apirest.controller;

import com.co.lineadevida.apirest.repository.EntityEmployee;
import com.co.lineadevida.apirest.repository.EntityEnterprise;
import com.co.lineadevida.apirest.services.ServicesEmployee;
import com.co.lineadevida.apirest.services.ServicesEnterprise;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@Api(tags = "Enterprise",description = "Metodos para el api empresa")
@RestController
@RequestMapping(value ="/lineadevida/Enterprise")
public class ControllerEnterprise {

    @Autowired
    ServicesEnterprise servicesEnterprise;

    @ApiOperation(value = "End point to Consult list enterprise create ")
    @GetMapping(path = "/listEnterprise",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> listEnterprise(){

        return new ResponseEntity<Object>(servicesEnterprise.toList(), HttpStatus.OK) ;
    }

    @ApiOperation(value = "End point permite crear una  enterprise")
    @PostMapping(path = "/insertEnterprise",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean>insertEnterprise(@RequestBody EntityEnterprise enterprise){
        return new ResponseEntity<Boolean>(servicesEnterprise.insertEnterprise(enterprise),HttpStatus.OK);
    }

    @ApiOperation(value = "End point to consult enterprise id")
    @GetMapping(path = "/searchEnterprise/{id}",produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<Object> searchEnterprise(@PathVariable Long idEnterprise){

        return new ResponseEntity<Object>(servicesEnterprise.searchEnterpriseId(idEnterprise), HttpStatus.OK) ;

    }
    @ApiOperation(value = "End point editar una empresa  por le iD")
    @PatchMapping(value = "/updateEnterprise",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateEnterpriseId(@RequestBody EntityEnterprise enterprise){
        servicesEnterprise.updateEnterprise(enterprise);

    }
    @ApiOperation(value = "End point delete enterprise por le iD")
    @DeleteMapping(value = "/deleteEnterprise/{id}")
    public void deleteEnterpriseId( @PathVariable Long id){
        servicesEnterprise.deleteEnterprise(id);


    }

}
