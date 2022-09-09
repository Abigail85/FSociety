package com.co.lineadevida.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoryEmployee extends JpaRepository <EntityEmployee, Long> {
    //List<EntityEmployee> enterprise(Long enterprise);


}
