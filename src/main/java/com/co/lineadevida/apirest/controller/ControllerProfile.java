package com.co.lineadevida.apirest.controller;

import com.co.lineadevida.apirest.repository.EntityProfile;
import com.co.lineadevida.apirest.services.ServicesProfile;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "profile", description = "metodos para la api Profile")
@RestController
@RequestMapping(value = "/lineadevida/Profile")


public class ControllerProfile {

    @Autowired
    ServicesProfile servicesProfile;


    @ApiOperation(value = "End ponit search profile")
    @GetMapping(path = "/searchProfile/{id}",produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<Object> searchProfile(@PathVariable Long id){

        return new ResponseEntity<Object>(servicesProfile.searchProfile(id), HttpStatus.OK) ;

    }

    @ApiOperation(value = "end point to update a profile")
    @PatchMapping(path = "/updateProfile",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<EntityProfile>updateProfile(@RequestBody EntityProfile profile){

        return new ResponseEntity<EntityProfile>(servicesProfile.updateProfile(profile), HttpStatus.OK);
    }


}
