package com.co.lineadevida.apirest.repository;

import com.co.lineadevida.apirest.models.EntityEmployee;
import org.springframework.data.jpa.repository.JpaRepository;



public interface RepositoryEmployee extends JpaRepository <EntityEmployee, Long> {



}
