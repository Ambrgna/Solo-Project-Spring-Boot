package com.genspark.SpringBootdemoApplication.Controller;

import com.genspark.SpringBootdemoApplication.Entity.Client;
import com.genspark.SpringBootdemoApplication.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("clients")
public class ClientController {
    @Autowired
    private ClientService clientService;
    @GetMapping
    public List<Client> getClients(){
        return this.clientService.getAllClients();
    }
    @GetMapping("/userid/{userID}")
    public List<Client> getClientsByUserId(@PathVariable String userID){
        return this.clientService.getAllByUserId(Integer.parseInt(userID));
    }
    @GetMapping("/{clientID}")
    public Client getClient(@PathVariable String clientID){
        return this.clientService.getClientById(Integer.parseInt(clientID));
    }
    @PostMapping
    public Client addClient(@RequestBody Client client){
        return this.clientService.addClient(client);
    }
    @PutMapping
    public Client updateClient(@RequestBody Client client){
        return this.clientService.updateClient(client);
    }
    @DeleteMapping("/{clientID}")
    public String deleteClient(@PathVariable String clientID){
        return this.clientService.deleteClientById(Integer.parseInt(clientID));
    }
}
