package com.curso.java.demo.rental.api.controllers;

import com.curso.java.demo.rental.api.entities.Rental;
import com.curso.java.demo.rental.api.services.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rental")
public class RentalController {

    @Autowired
    private RentalService service;

    @GetMapping()
    public ResponseEntity<List<Rental>> get(){
        var rentals = service.findAll();
        return ResponseEntity.ok(rentals);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Rental> getById(@PathVariable Long id){
        var rental = service.findById(id);
        return ResponseEntity.ok(rental);
    }

    @PostMapping
    public ResponseEntity<Rental> post(@RequestBody Rental rental){
        rental = service.insert(rental);
        return ResponseEntity.ok(rental);
    }
}