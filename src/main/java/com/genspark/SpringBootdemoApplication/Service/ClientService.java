package com.genspark.SpringBootdemoApplication.Service;

import com.genspark.SpringBootdemoApplication.Entity.Client;

import java.util.List;

public interface ClientService {

    List<Client> getAllClients();
    List<Client> getAllByUserId(int userid);
    Client getClientById(int clientID);
    Client addClient(Client client);
    Client updateClient(Client client);
    String disableClientById(int clientID);
    String deleteClientById(int clientID);
}
