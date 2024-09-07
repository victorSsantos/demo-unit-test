package com.curso.java.demo.rental.api.repositories;

import com.curso.java.demo.rental.api.entities.Category;
import com.curso.java.demo.rental.api.entities.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category findByType(String type);
}
