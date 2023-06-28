package com.genspark.SpringBootdemoApplication.Service;

import com.genspark.SpringBootdemoApplication.Entity.Project;

import java.util.List;

public interface ProjectService {

    List<Project> getAllProjects();
    List<Project> getAllByClientId(int clientID);
    Project getProjectById(int clientID);
    Project addProject(Project client);
    Project updateProject(Project client);
    String deleteProjectById(int clientID);
}
