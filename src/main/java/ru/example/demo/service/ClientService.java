package ru.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.example.demo.model.Client;
import ru.example.demo.repo.ClientRepository;

import java.util.List;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Transactional
    public Client getById(int id) {
        Client client = clientRepository.findClientById(id);
        client.getContracts().size();
        client.getRole().toString();
        return client;
    }

    @Transactional
    public Client getByEmail(String email){
        Client client = clientRepository.findClientByEmail(email);
        client.getContracts().size();
        client.getRole().getName();
        return client;
    }

    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    public void save(Client client) {
        clientRepository.save(client);
    }

    public void update(int id, Client client) {
        Client clientToUpdate = clientRepository.findClientById(id);
        clientToUpdate.setName(client.getName());
        clientToUpdate.setSurname(client.getSurname());
        clientRepository.save(clientToUpdate);
    }

    public void delete(int id) {
        clientRepository.delete(clientRepository.findClientById(id));
    }

}
