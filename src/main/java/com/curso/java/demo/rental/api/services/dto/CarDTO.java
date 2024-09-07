package com.curso.java.demo.rental.api.services.dto;

import com.curso.java.demo.rental.api.entities.Car;
import com.curso.java.demo.rental.api.entities.enums.CarStatusType;
import com.curso.java.demo.rental.api.entities.enums.CategoryType;
import com.curso.java.demo.rental.api.repositories.CarStatusRepository;
import com.curso.java.demo.rental.api.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class CarDTO implements Serializable {

    @Autowired
    private CategoryRepository categoryRepo;

    @Autowired
    private CarStatusRepository statusRepo;

    private Long id;
    private String model;
    private Double pricePerDay;
    private Integer year;
    private CarStatusType statusType;
    private CategoryType categoryType;

    public CarDTO() {
    }

    public CarDTO(Long id, String model, Double pricePerDay, Integer year, CarStatusType statusType, CategoryType categoryType) {
        this.id = id;
        this.model = model;
        this.pricePerDay = pricePerDay;
        this.year = year;
        this.statusType = statusType;
        this.categoryType = categoryType;
    }

    public CarDTO(Car car) {
        this.id = car.getId();
        this.model = car.getModel();
        this.pricePerDay = car.getPricePerDay();
        this.year = car.getYear();
        this.statusType = car.getStatus().getType();
        this.categoryType = car.getCategory().getType();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public CarStatusType getStatus() {
        return statusType;
    }

    public void setStatus(CarStatusType statusType) {
        this.statusType = statusType;
    }

    public CategoryType getCategory() {
        return categoryType;
    }

    public void setCategory(CategoryType categoryType) {
        this.categoryType = categoryType;
    }

    public Car toEntity(){
        var category = categoryRepo.findByType(categoryType.name());
        var status = statusRepo.findByType(statusType.name());
        return new Car(id,model,category,year,pricePerDay,status);
    }
}
