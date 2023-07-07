package com.genspark.SpringBootdemoApplication.Controller;

import com.genspark.SpringBootdemoApplication.Entity.Client;
import com.genspark.SpringBootdemoApplication.Entity.Project;
import com.genspark.SpringBootdemoApplication.Entity.User;
import com.genspark.SpringBootdemoApplication.Service.ClientService;
import com.genspark.SpringBootdemoApplication.Service.FileService;
import com.genspark.SpringBootdemoApplication.Service.ProjectService;
import com.genspark.SpringBootdemoApplication.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class Controller {
    @Autowired
    private UserService userService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private FileService fileService;

    /* Users Request */
    @GetMapping("/authentication")
    public boolean login(){
        return true;
    }
    @GetMapping("/users")
    public List<User> getUsers(){
        return this.userService.getAllUsers();
    }
    @GetMapping("/users/{username}")
    public User getUser(@PathVariable String username){
        return this.userService.getUserByUsername(username);
    }
    @GetMapping("/users/id/{id}")
    public User getUserById(@PathVariable String id){
        return this.userService.getUserById(Integer.parseInt(id));
    }
    @PostMapping("/users")
    public User addUser(@RequestBody User user){
        return this.userService.addUser(user);
    }
    @PutMapping("/users")
    public User updateUser(@RequestBody User user){
        return this.userService.updateUser(user);
    }
    @DeleteMapping("/users/{userID}")
    public String deleteUser(@PathVariable String userID){
        return this.userService.deleteUserById(Integer.parseInt(userID));
    }

    /* End of Users Request */

    /* Clients Request */
    @GetMapping("/clients")
    public List<Client> getClients(){
        return this.clientService.getAllClients();
    }
    @GetMapping("/clients/userid/{userID}")
    public List<Client> getClientsByUserId(@PathVariable String userID){
        return this.clientService.getAllByUserId(Integer.parseInt(userID));
    }
    @GetMapping("/clients/{clientID}")
    public Client getClient(@PathVariable String clientID){
        return this.clientService.getClientById(Integer.parseInt(clientID));
    }
    @PostMapping("/clients")
    public Client addClient(@RequestBody Client client){
        return this.clientService.addClient(client);
    }
    @PutMapping("/clients")
    public Client updateClient(@RequestBody Client client){
        return this.clientService.updateClient(client);
    }
    @DeleteMapping("/clients/{clientID}")
    public String deleteClient(@PathVariable String clientID) {
        return this.clientService.deleteClientById(Integer.parseInt(clientID));
    }

    /* End of Clients Request */

    /* Projects Request */
    @GetMapping("/{clientID}/projects")
    public List<Project> getProjectsByID(@PathVariable String clientID){
        return this.projectService.getAllByClientId(Integer.parseInt(clientID));
    }
    @GetMapping("/projects/{projectID}")
    public Project getProject(@PathVariable String projectID){
        return this.projectService.getProjectById(Integer.parseInt(projectID));
    }
    @PostMapping("/projects")
    public Project addProject(@RequestBody Project project){
        return this.projectService.addProject(project);
    }
    @PutMapping("/projects")
    public Project updateProject(@RequestBody Project project){
        return this.projectService.updateProject(project);
    }
    @DeleteMapping("/projects/{projectID}")
    public String deleteProject(@PathVariable String projectID){
        return this.projectService.deleteProjectById(Integer.parseInt(projectID));
    }

    /* End of Projects Request */

    /*  File Request */

    @PostMapping("/upload/pdf")
    public String handleUploadPDF(Model model,
                                      @RequestParam("file") MultipartFile multipart) {
        return this.fileService.handleUploadPDF(model, multipart);
    }

    @PostMapping("/upload/jpg")
    public String handleUploadImage(Model model,
                                   @RequestParam("file") MultipartFile multipart) {
        return this.fileService.handleUploadImage(model, multipart);
    }

    /* End of File Request */

    @GetMapping("/access-denied")
    public String getAccessDenied() {
        System.out.println("/error/accessDenied");
        return "/error/accessDenied";
    }
}
