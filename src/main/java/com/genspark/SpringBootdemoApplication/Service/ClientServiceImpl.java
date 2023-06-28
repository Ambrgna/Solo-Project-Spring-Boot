package com.genspark.SpringBootdemoApplication.Service;

import com.genspark.SpringBootdemoApplication.Dao.ClientDeo;
import com.genspark.SpringBootdemoApplication.Entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientDeo clientDeo;

    @Override
    public List<Client> getAllClients() {
        return this.clientDeo.findAll();
    }
    @Override
    public List<Client> getAllByUserId(int userid) {
        return this.clientDeo.findAllByUserId(userid);
    }

    @Override
    public Client getClientById(int clientID) {
        Optional <Client> c = this.clientDeo.findById(clientID);
        Client client = null;
        if (c.isPresent()){
            client = c.get();
        } else {
            throw new RuntimeException(" Client not found for id :: " + clientID);
        }
        return client;
    }

    @Override
    public Client addClient(Client client) {
        return this.clientDeo.save(client);
    }

    @Override
    public Client updateClient(Client client) {
        return this.clientDeo.save(client);
    }

    @Override
    public String deleteClientById(int clientID) {
        Optional <Client> r = this.clientDeo.findById(clientID);
        Client client = null;
        if (r.isPresent()){
            client = r.get();
        } else {
            throw new RuntimeException(" Client not found for id :: " + clientID);
        }
        client.setDisabled(true);
        client.setRemoved_at(new Date());
        this.clientDeo.save(client);
//        this.clientDeo.deleteById(clientID);
        return "Removed Successfully";
    }
}
