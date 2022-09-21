package com.co.lineadevida.apirest.services;

import com.co.lineadevida.apirest.models.*;
import com.co.lineadevida.apirest.repository.*;
import com.co.lineadevida.apirest.util.Enum_RoleName;
import org.apache.catalina.webresources.AbstractSingleArchiveResourceSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ServicesTransaction {
    private  String income;
    private String expenses;

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

public String insertTransaction(EntityTransaction transaction) {
    try{
        transaction.setCreatedAtTransaction(LocalDate.now());
        repositoryTransaction.save(transaction);


    }catch (Exception e){
        return "Algo falló, por favor intente nuevamente";
    }
    return "Empleado creado existosamente";
}





public String editTransaction(EntityTransaction transaction) {

    EntityTransaction editTransaction = repositoryTransaction.findById(transaction.getIdTransaction()).orElse(null);

    if (transaction.getConcept() != null) {
        editTransaction.setConcept((transaction.getConcept()));
        editTransaction.setUpdateAtTransaction(LocalDate.now());
    } else if (transaction.getAmount() != null) {
        editTransaction.setAmount(transaction.getAmount());
        editTransaction.setUpdateAtTransaction(LocalDate.now());
    }else {
        return "Algo fallo no se pudo altualizar la transacción";
    }
    repositoryTransaction.save(editTransaction);
    return "La transacción " + transaction.getIdTransaction() + " se actualizo existosamente";
}

public String deleteTransaction(EntityTransaction idTransaction) {
    if (idTransaction != null) {
        repositoryTransaction.delete(idTransaction);
        return "La transacciòn " + idTransaction + " se elimino exitosamente";
    } else {
        return "La Transaccion= " + idTransaction + " No existe";
    }

}


}
