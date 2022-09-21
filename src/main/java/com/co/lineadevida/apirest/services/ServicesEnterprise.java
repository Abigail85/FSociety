package com.co.lineadevida.apirest.services;


import com.co.lineadevida.apirest.models.EntityEnterprise;
import com.co.lineadevida.apirest.repository.RepositoryEnterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServicesEnterprise {


 @Autowired
    RepositoryEnterprise repositoryEnterprise;



    public List<EntityEnterprise> listOfAllEnterprises(){
    List<EntityEnterprise> listEnterprises = repositoryEnterprise.findAll();
    return listEnterprises;
    }


public String insertEnterprise(EntityEnterprise enterprise){
    try{
        enterprise.setCreatedAtEnterprise(LocalDate.now());
        repositoryEnterprise.save(enterprise);

    }catch (Exception e){
        return "Algo falló, por gavor intente nuevamente";
    }
    return "Empresa creada exitosamente";
}

    public EntityEnterprise searchEnterpriseId(Long idEnterprise) {
        EntityEnterprise searchId = repositoryEnterprise.findById(idEnterprise).orElse(null);
        return searchId;

    }


    public String updateEnterprise(EntityEnterprise enterprise) {

        EntityEnterprise updateEnterprise = repositoryEnterprise.findById(enterprise.getIdEnterprise()).orElse(null);

        if (enterprise.getNameEnterprise() != null) {
            updateEnterprise.setNameEnterprise(enterprise.getNameEnterprise());
            updateEnterprise.setUpdateAtEnterprise(LocalDate.now());
        } else if (enterprise.getNroDocumentEnterprise() != null) {
            updateEnterprise.setNroDocumentEnterprise(enterprise.getNroDocumentEnterprise());
            updateEnterprise.setUpdateAtEnterprise(LocalDate.now());
        } else if (enterprise.getAddressEnterprise() != null) {
            updateEnterprise.setAddressEnterprise(enterprise.getAddressEnterprise());
            updateEnterprise.setUpdateAtEnterprise(LocalDate.now());
        } else if (enterprise.getPhoneEnterprise() != null) {
            updateEnterprise.setPhoneEnterprise(enterprise.getPhoneEnterprise());
            updateEnterprise.setUpdateAtEnterprise(LocalDate.now());

        }else {
           return  "Algo falló no se pudo realizar la actualizaciòn";
        }
        repositoryEnterprise.save(updateEnterprise);
        return "Se actualizo exitosamente";
    }
    public String deleteEnterprise(Long idEnterprise){
        try {
            repositoryEnterprise.deleteById(idEnterprise);
        }catch (Exception e){
          return "Algo falló, por favor intente nuevamente";

        }
         return "Empresa Eliminada exitosamente";
    }
}
