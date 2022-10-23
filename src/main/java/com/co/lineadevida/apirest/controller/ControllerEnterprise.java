package com.co.lineadevida.apirest.controller;

import com.co.lineadevida.apirest.models.EntityEnterprise;
import com.co.lineadevida.apirest.services.ServicesEnterprise;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;


@Api(tags = "Enterprise",description = "Metodos para el api empresa")
@RestController
@RequestMapping(value ="/lineadevida/Enterprise")
public class ControllerEnterprise {

    @Autowired
    ServicesEnterprise servicesEnterprise;

    @ApiOperation(value = "End point to Consult list enterprise create ")
    @GetMapping(path = "/listOfAllEnterprises",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> listOfAllEnterprises(){

        return new ResponseEntity<Object>(servicesEnterprise.listOfAllEnterprises(), HttpStatus.OK) ;
    }

    @ApiOperation(value = "End point permite crear una  enterprise")
    @PostMapping(path = "/insertEnterprise",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String>insertEnterprise(@RequestBody EntityEnterprise enterprise){
        return new ResponseEntity<String>(servicesEnterprise.insertEnterprise(enterprise),HttpStatus.OK);
    }

    @ApiOperation(value = "End point to consult enterprise id")
    @GetMapping(path = "/searchEnterprise/{id}",produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity searchEnterprise(@PathVariable Long id){

        return new ResponseEntity(servicesEnterprise.searchEnterpriseId(id), HttpStatus.OK) ;

    }
    @ApiOperation(value = "End point editar una empresa  por le iD")
    @PutMapping(value = "/updateEnterprise")
    public RedirectView updateEnterprise(@ModelAttribute EntityEnterprise enterprise, Model model){

        model.addAttribute(enterprise);
        if(servicesEnterprise.updateEnterprise(enterprise).equals(Boolean.TRUE)){
            return new RedirectView("enterprise");
        }else {
            return new RedirectView("404");
        }

    }
    @ApiOperation(value = "End point delete enterprise por le iD")
    @DeleteMapping(value = "/deleteEnterprise/{id}")
    public String deleteEnterpriseId( @PathVariable Long id){

        return servicesEnterprise.deleteEnterprise(id);


    }

}
