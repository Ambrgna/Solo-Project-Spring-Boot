package com.genspark.SpringBootdemoApplication.Entity;

import jakarta.persistence.*;

import java.util.Arrays;
import java.util.Date;

@Entity
@Table(name="tbl_projects")
public class Project {
    @Id
    @Column(name = "p_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int projectId;
    @Column(nullable = false)
    private int clientId;
    @Column(nullable = false)
    private int owner;
    @Column(nullable = false)
    private int[] teamLeads;
    @Column
    private int[] teamMembers;
    @Column(nullable = false)
    private String name;
    private String description;
    private boolean disabled = false;
    @Column(updatable = false)
    private Date created_at = new Date();
    private Date removed_at;

    public Project() {
    }

    public Project(int clientId,int owner, int[] teamLeads, int[] teamMembers, String name, String description) {
        this.clientId = clientId;
        this.owner = owner;
        this.teamLeads = teamLeads;
        this.teamMembers = teamMembers;
        this.name = name;
        this.description = description;
    }
    public Project(int projectId, int clientId,int owner, int[] teamLeads, int[] teamMembers, String name, String description) {
        this.projectId = projectId;
        this.clientId = clientId;
        this.owner = owner;
        this.teamLeads = teamLeads;
        this.teamMembers = teamMembers;
        this.name = name;
        this.description = description;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getOwner() {return owner;}

    public void setOwner(int owner) {this.owner = owner;}

    public int[] getTeamLeads() {
        return teamLeads;
    }

    public void setTeamLeads(int[] teamLeads) {
        this.teamLeads = teamLeads;
    }

    public int[] getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(int[] teamMembers) {
        this.teamMembers = teamMembers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getRemoved_at() {
        return removed_at;
    }

    public void setRemoved_at(Date removed_at) {
        this.removed_at = removed_at;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", clientId=" + clientId +
                ", owner=" + owner +
                ", teamLeads=" + Arrays.toString(teamLeads) +
                ", teamMembers=" + Arrays.toString(teamMembers) +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", disabled=" + disabled +
                ", removed_at=" + removed_at +
                '}';
    }
}