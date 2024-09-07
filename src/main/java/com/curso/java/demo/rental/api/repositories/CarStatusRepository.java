package com.curso.java.demo.rental.api.repositories;

import com.curso.java.demo.rental.api.entities.CarStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarStatusRepository extends JpaRepository<CarStatus, Long> {
    CarStatus findByType(String type);
}
