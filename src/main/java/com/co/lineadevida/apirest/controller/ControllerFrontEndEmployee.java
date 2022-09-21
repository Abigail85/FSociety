package com.co.lineadevida.apirest.controller;

import com.co.lineadevida.apirest.models.EntityEnterprise;
import com.co.lineadevida.apirest.services.ServicesEnterprise;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ControllerFrontEndEmployee {

    @Autowired
    ServicesEnterprise servicesEnterprise;

    @GetMapping(path = "/")
    public String home(){

        return "index";
    }

    @GetMapping (path = "/listaEmpresas")
    public String pagina2(Model modelo){

        List<EntityEnterprise> listEnterprise = servicesEnterprise.listOfAllEnterprises();
        modelo.addAttribute("listaEmpresas", listEnterprise);

        return "listaEmpresas";
    }

    @PostMapping (path = "enterprise")
    public String insertEnterprise (Model modelo){

        modelo.addAttribute("insertEnterprise", new EntityEnterprise() );

        return "enterprise";

    }

    @GetMapping (path = "/editarPersona/{id}")
    public String editarPersona (Model modelo, @PathVariable("id") Long id){

        EntityEnterprise pTemp = servicesEnterprise.searchEnterpriseId(id);
        modelo.addAttribute("Epersona", pTemp );

        return "editarPersona";

    }

}
