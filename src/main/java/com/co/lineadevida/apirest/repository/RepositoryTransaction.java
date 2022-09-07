package com.co.lineadevida.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryTransaction extends JpaRepository <EntityTransaction, Long> {

}
