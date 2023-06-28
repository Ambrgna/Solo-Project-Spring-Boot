package com.genspark.SpringBootdemoApplication.Controller;

import com.genspark.SpringBootdemoApplication.Entity.Project;
import com.genspark.SpringBootdemoApplication.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class ProjectController {
    @Autowired
    private ProjectService projectService;
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
}
