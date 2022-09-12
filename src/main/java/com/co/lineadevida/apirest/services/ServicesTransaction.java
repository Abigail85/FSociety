package com.co.lineadevida.apirest.services;

import com.co.lineadevida.apirest.models.EntityEnterprise;
import com.co.lineadevida.apirest.models.EntityProfile;
import com.co.lineadevida.apirest.models.EntityTransaction;
import com.co.lineadevida.apirest.repository.*;
import org.apache.catalina.webresources.AbstractSingleArchiveResourceSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicesTransaction {
    private Long income;
    private Long expenses;
@Autowired
RepositoryTransaction repositoryTransaction;

    @Autowired
    RepositoryEnterprise repositoryEnterprise;

public List<EntityTransaction> toList(){
    List<EntityTransaction> listTransaction = repositoryTransaction.findAll();
    return listTransaction;
}

public Optional<EntityTransaction> searchTransaction(Long idTransaction){
    Optional<EntityTransaction> listSearch = repositoryTransaction.findById(idTransaction);
    return listSearch;
}

public Boolean insertTransaction(EntityTransaction transaction){
    try{

        repositoryTransaction.save(transaction);
    }catch (Exception e){
        return Boolean.FALSE;
    }
    return Boolean.TRUE;
}
public Boolean editTransaction(EntityTransaction transaction){
    try{
        repositoryTransaction.save(transaction);
    }catch (Exception e){
        return Boolean.FALSE;
    }
    return Boolean.TRUE;
}

public String deleteTransaction(EntityTransaction idTransaction) {

    if (idTransaction != null) {
        repositoryTransaction.delete(idTransaction);
        return "La transacciòn se elimino exitosamente";
    } else {
        return "La Transaccion= " + idTransaction + " No existe";
    }

}


}
