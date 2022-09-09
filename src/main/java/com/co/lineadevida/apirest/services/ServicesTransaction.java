package com.co.lineadevida.apirest.services;

import com.co.lineadevida.apirest.repository.EntityEmployee;
import com.co.lineadevida.apirest.repository.EntityTransaction;
import com.co.lineadevida.apirest.repository.RepositoryTransaction;
import org.apache.catalina.webresources.AbstractSingleArchiveResourceSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicesTransaction {

@Autowired
RepositoryTransaction repositoryTransaction;

public List<EntityTransaction> toList(){
    List<EntityTransaction> listTransaction = repositoryTransaction.findAll();
    return listTransaction;
}

public Optional<EntityTransaction> searchEmployee(Long idTransaction){
    Optional<EntityTransaction> listSearch = repositoryTransaction.findById(idTransaction);
    return listSearch;
}

public Boolean insertTransaction(EntityTransaction transaction){
    try{
        repositoryTransaction.findById(transaction.getIdTransaction());
        repositoryTransaction.save(transaction);
    }catch (Exception e){
        return Boolean.FALSE;
    }
    return Boolean.TRUE;
}


    private Long income;
    private Long expenses;


}
