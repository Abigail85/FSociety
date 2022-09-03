package com.co.lineadevida.apirest.services;


import com.co.lineadevida.apirest.repository.EntityEnterprise;
import com.co.lineadevida.apirest.repository.RepositoryEnterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicesEnterprise {

@Autowired
RepositoryEnterprise repositoryEnterprise;

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

public Optional<EntityEnterprise> searchEnterprise(Long idEnterprise){
    Optional<EntityEnterprise> listSearch = repositoryEnterprise.findById(idEnterprise);
    return listSearch;
}

}
