package com.curso.java.demo.rental.api.services;

import com.curso.java.demo.rental.api.entities.Car;
import com.curso.java.demo.rental.api.entities.Category;
import com.curso.java.demo.rental.api.repositories.CarRepository;
import com.curso.java.demo.rental.api.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepo;

    @Autowired
    private CategoryRepository categoryRepo;

    public List<Car> findAll(){
        return carRepo.findAll();
    }

    public Car findById(Long id){
        return carRepo.findById(id).orElse(null);
    }

    public List<Car> findByCategory(String categoryType){
        var category = categoryRepo.findByType(categoryType);
        return carRepo.findByCategory(category);
    }

    public Car insert(Car newCar){
        return carRepo.save(newCar);
    }

    public void delete(Long id){
        carRepo.delete(findById(id));
    }

    public void update(Long id, Car car){
        if(findById(id)!=null){
            car.setId(id);
            carRepo.save(car);
        }
    }
}