package com.co.lineadevida.apirest.controller;

import com.co.lineadevida.apirest.models.EntityEmployee;
import com.co.lineadevida.apirest.models.EntityEnterprise;
import com.co.lineadevida.apirest.models.EntityTransaction;
import com.co.lineadevida.apirest.services.ServicesEnterprise;
import com.co.lineadevida.apirest.services.ServicesTransaction;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Transaction",description = "Metodos para el api transaction")
@RestController
@RequestMapping(value ="/lineadevida/Transaction")
public class ControllerTransaction {

    @Autowired
    ServicesTransaction servicesTransaction;

    @Autowired
    ServicesEnterprise servicesEnterprise;

    @ApiOperation(value = "End point to list Transaction ")
    @GetMapping(path = "/listTransaction",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> listTransaction(){
        return new ResponseEntity<Object>(servicesTransaction.listOfAllTransactions(), HttpStatus.OK) ;
    }

    @ApiOperation(value = "End point insert Transaction")
    @PostMapping(path = "/insertTransaction",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EntityTransaction>insertTransaction(@RequestBody EntityTransaction transaction){

        return new ResponseEntity(servicesTransaction.insertTransaction(transaction),HttpStatus.OK);

    }

    @ApiOperation(value = "End ponit search transaction")
    @GetMapping(path = "/searchTransaction/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> searchTransaction(@PathVariable Long id){
        return new ResponseEntity<Object>(servicesTransaction.searchTransaction(id), HttpStatus.OK) ;
    }

    @ApiOperation(value = "End ponit edit transaction")
    @PatchMapping(value = "/editTransaction",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public String editTransaction( @RequestBody EntityTransaction transaction){

        return servicesTransaction.editTransaction(transaction);

    }

    @ApiOperation(value = "End ponit delete transaction")
    @DeleteMapping(path = "/deleteTransaction",produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteTransactionId( @RequestBody EntityTransaction idTransaction){

        return servicesTransaction.deleteTransaction(idTransaction);


    }

}
