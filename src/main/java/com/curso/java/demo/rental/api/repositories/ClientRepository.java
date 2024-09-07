package com.curso.java.demo.rental.api.repositories;

import com.curso.java.demo.rental.api.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {

    List<Client> findByNameIgnoreCaseContaining(String name);
}

