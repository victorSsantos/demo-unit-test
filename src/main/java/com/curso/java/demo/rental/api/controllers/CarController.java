package com.curso.java.demo.rental.api.controllers;

import com.curso.java.demo.rental.api.entities.Car;
import com.curso.java.demo.rental.api.entities.Client;
import com.curso.java.demo.rental.api.services.CarService;
import com.curso.java.demo.rental.api.services.ClientService;
import com.curso.java.demo.rental.api.services.dto.CarDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService service;

    @GetMapping()
    public ResponseEntity<List<CarDTO>> get(){
        var cars = service.findAll();
        return ResponseEntity.ok(cars.stream().map(CarDTO::new).toList());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CarDTO> getById(@PathVariable Long id){
        var car = service.findById(id);
        return ResponseEntity.ok(new CarDTO(car));
    }

    @GetMapping(value = "/filter")
    public ResponseEntity<List<CarDTO>> getByName(@RequestParam(name = "category", value = "") String category){
        var cars = service.findByCategory(category);
        return ResponseEntity.ok(cars.stream().map(CarDTO::new).toList());
    }

    @PostMapping
    public ResponseEntity<Car> insert(@RequestBody CarDTO carDTO){
        var newCar = service.insert(carDTO.toEntity());
        return ResponseEntity.ok(newCar);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody CarDTO carDTO){
        service.update(id, carDTO.toEntity());
        return ResponseEntity.noContent().build();
    }
}
