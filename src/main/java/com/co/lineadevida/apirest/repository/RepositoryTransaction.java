package com.co.lineadevida.apirest.repository;

import com.co.lineadevida.apirest.models.EntityTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryTransaction extends JpaRepository <EntityTransaction, Long> {

}
