package com.curso.java.demo.rental.api.repositories;

import com.curso.java.demo.rental.api.entities.RentalStatus;
import com.curso.java.demo.rental.api.entities.enums.RentalStatusType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalStatusRepository extends JpaRepository<RentalStatus, Long> {
    RentalStatus findByType(RentalStatusType statusType);
}
