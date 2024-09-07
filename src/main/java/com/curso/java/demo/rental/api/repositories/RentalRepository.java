package com.curso.java.demo.rental.api.repositories;

import com.curso.java.demo.rental.api.entities.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentalRepository extends JpaRepository<Rental,Long> {

    List<Rental> findByClientId(Long id);
    List<Rental> findByCarId(Long id);
}
