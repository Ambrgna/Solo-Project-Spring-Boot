package com.genspark.SpringBootdemoApplication.Entity;

import jakarta.persistence.*;

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
    private String name;
    private String description;
    private boolean disabled = false;
    @Column(updatable = false)
    private Date created_at = new Date();
    private Date removed_at;

    public Project() {
    }

    public Project(int projectId, int clientId, String name, String description, boolean disabled, Date created_at, Date removed_at) {
        this.projectId = projectId;
        this.clientId = clientId;
        this.name = name;
        this.description = description;
        this.disabled = disabled;
        this.created_at = created_at;
        this.removed_at = removed_at;
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
}