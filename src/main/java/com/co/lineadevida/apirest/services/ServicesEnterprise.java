package com.co.lineadevida.apirest.services;


import com.co.lineadevida.apirest.repository.EntityEmployee;
import com.co.lineadevida.apirest.repository.EntityEnterprise;
import com.co.lineadevida.apirest.repository.RepositoryEnterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ServicesEnterprise {

@Autowired
RepositoryEnterprise repositoryEnterprise;

    public ServicesEnterprise() {
    }

    public List<EntityEnterprise> toList(){
    List<EntityEnterprise> listEnterprise = repositoryEnterprise.findAll();
    return listEnterprise;
}


public Boolean insertEnterprise(EntityEnterprise enterprise){
    try{
        repositoryEnterprise.save(enterprise);

    }catch (Exception e){
        return Boolean.FALSE;
    }
    return Boolean.TRUE;
}

    public EntityEnterprise searchEnterpriseId(Long idEnterprise) {
        EntityEnterprise searchId = repositoryEnterprise.findById(idEnterprise).orElse(null);
        return searchId;

    }

    public void updateEnterprise(EntityEnterprise enterprise) {

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

        }
        repositoryEnterprise.save(updateEnterprise);
    }
    public void deleteEnterprise(Long idEnterprise){
       repositoryEnterprise.deleteById(idEnterprise);

    }
}
