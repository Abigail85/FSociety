package com.co.lineadevida.apirest.services;

import com.co.lineadevida.apirest.repository.*;
import org.apache.catalina.webresources.AbstractSingleArchiveResourceSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicesTransaction {

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

public Boolean insertTransaction(EntityTransaction transaction, EntityEnterprise id){
    try{
        repositoryEnterprise.findById(id.getIdEnterprise());
        repositoryTransaction.save(transaction);
    }catch (Exception e){
        return Boolean.FALSE;
    }
    return Boolean.TRUE;
}
public Boolean editTransaction(EntityTransaction transaction){
    try{
        repositoryTransaction.findById(transaction.getIdTransaction());
        repositoryTransaction.save(transaction);
    }catch (Exception e){
        return Boolean.FALSE;
    }
    return Boolean.TRUE;
}

public Boolean deleteTransaction(EntityTransaction transaction){
    try{

        repositoryTransaction.delete(transaction);
    }catch (Exception e){
        return Boolean.FALSE;
    }
    return Boolean.TRUE;
}


    private Long income;
    private Long expenses;


}
