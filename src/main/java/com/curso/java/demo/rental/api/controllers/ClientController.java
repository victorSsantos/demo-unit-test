package com.curso.java.demo.rental.api.controllers;

import com.curso.java.demo.rental.api.entities.Client;
import com.curso.java.demo.rental.api.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping()
    public ResponseEntity<List<Client>> get(){
        var users = service.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Client> getById(@PathVariable Long id){
        var user = service.findById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping(value = "/filter")
    public ResponseEntity<List<Client>> getByName(@RequestParam(name = "name", value = "") String name){
        var user = service.findByName(name);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<Client> insert(@RequestBody Client client){
        client = service.insert(client);
        return ResponseEntity.ok(client);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Client client){
        service.update(id, client);
        return ResponseEntity.noContent().build();
    }
}
