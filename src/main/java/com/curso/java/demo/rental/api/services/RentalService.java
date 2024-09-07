package com.curso.java.demo.rental.api.services;

import com.curso.java.demo.rental.api.entities.Rental;
import com.curso.java.demo.rental.api.repositories.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalService {

    @Autowired
    private RentalRepository rentalRepo;

    public List<Rental> findAll(){
        return rentalRepo.findAll();
    }

    public Rental findById(Long id){
        return rentalRepo.findById(id).orElse(null);
    }

    public List<Rental> findByUserId(Long id){
        return rentalRepo.findByClientId(id);
    }

    public List<Rental> findByMovieId(Long id){
        return rentalRepo.findByCarId(id);
    }

    public Rental insert(Rental newRental){
        return rentalRepo.save(newRental);
    }

    public void delete(Long id){
        rentalRepo.delete(findById(id));
    }
}
