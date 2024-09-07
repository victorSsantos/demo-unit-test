package com.curso.java.demo.rental.api.repositories;

import com.curso.java.demo.rental.api.entities.Car;
import com.curso.java.demo.rental.api.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {

    List<Car> findByCategory(Category category);
}
