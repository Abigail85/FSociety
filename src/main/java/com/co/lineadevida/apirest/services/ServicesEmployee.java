package com.co.lineadevida.apirest.services;


import com.co.lineadevida.apirest.repository.EntityEmployee;
import com.co.lineadevida.apirest.repository.RepositoryEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicesEmployee {

@Autowired
RepositoryEmployee repositoryEmployee;

public List<EntityEmployee> toList(){
    List<EntityEmployee> listEmployee = repositoryEmployee.findAll();
    return listEmployee;
}

public Boolean insertEmployee(EntityEmployee employee){
    try{
        repositoryEmployee.save(employee);

    }catch (Exception e){
        return Boolean.FALSE;
    }
    return Boolean.TRUE;
}

public Optional<EntityEmployee> searchEmployee(Long idEmployee){
    Optional<EntityEmployee> listSearch = repositoryEmployee.findById(idEmployee);
    return listSearch;
}














}
