package com.curso.java.demo.rental.api.services;

import com.curso.java.demo.rental.api.entities.Client;
import com.curso.java.demo.rental.api.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepo;

    public List<Client> findAll(){
        return clientRepo.findAll();
    }

    public Client findById(Long id){
        return clientRepo.findById(id).orElse(null);
    }

    public List<Client> findByName(String name){
        return clientRepo.findByNameIgnoreCaseContaining(name);
    }

    public Client insert(Client newClient){
        return clientRepo.save(newClient);
    }

    public void delete(Long id){
        clientRepo.delete(findById(id));
    }

    public void update(Long id, Client client){
        if(findById(id)!=null){
            client.setId(id);
            clientRepo.save(client);
        }
    }
}
