package com.co.lineadevida.apirest.services;

import com.co.lineadevida.apirest.models.EntityEmployee;
import com.co.lineadevida.apirest.models.EntityEnterprise;
import com.co.lineadevida.apirest.models.EntityProfile;
import com.co.lineadevida.apirest.models.EntityTransaction;
import com.co.lineadevida.apirest.repository.*;
import org.apache.catalina.webresources.AbstractSingleArchiveResourceSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    @Autowired
    RepositoryEnterprise repositoryLicenses;

    @Autowired
    RepositoryProfile repositoryProfile;

    @Autowired
    ServicesProfile servicesProfile;

public List<EntityTransaction> listOfAllTransactions() {
    List<EntityTransaction> listTransaction = repositoryTransaction.findAll();
    return listTransaction;
}

public EntityTransaction searchTransaction(Long idTransaction) {
    EntityTransaction searchTransactionId;
    if(idTransaction != null) {
        searchTransactionId = repositoryTransaction.findById(idTransaction).orElse(null);
    }else {
        searchTransactionId = searchTransaction(null);
    }
    return searchTransactionId;

}

public String insertTransaction(EntityTransaction transaction){
    EntityTransaction entityTransaction = new EntityTransaction();

    try{
        transaction.setCreatedAtTransaction(LocalDate.now());
        repositoryTransaction.save(transaction);

    }catch (Exception e){
        return "Algo falló, por favor intente nuevamente";
    }
    return "Transacción creada existosamente";
}

public String editTransaction(EntityTransaction transaction) {

    EntityTransaction updateTransaction = repositoryTransaction.findById(transaction.getIdTransaction()).orElse(null);

    if (transaction.getIdTransaction() != null) {
        updateTransaction.setIdTransaction((transaction.getIdTransaction()));
        updateTransaction.setUpdateAtTransaction(LocalDate.now());
    } else if (transaction.getConcept() != null) {
        updateTransaction.setConcept((transaction.getConcept()));
        updateTransaction.setUpdateAtTransaction(LocalDate.now());
    } else if (transaction.getAmount() != null) {
        updateTransaction.setAmount(transaction.getAmount());
        updateTransaction.setUpdateAtTransaction(LocalDate.now());
    }else {
        return "Algo fallo no se pudo altualizar la transacción";
    }
    repositoryTransaction.save(updateTransaction);
    return "La transacción " + transaction.getIdTransaction() + " se actualizo existosamente";
}

public String deleteTransaction(EntityTransaction idTransaction) {
    EntityProfile profile = null;
    if (idTransaction != null) {
        repositoryTransaction.delete(idTransaction);
        return "La transacciòn se elimino exitosamente";
    } else {
        return "La Transaccion= " + idTransaction + " No existe";
    }

}


}
