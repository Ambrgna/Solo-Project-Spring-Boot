package com.genspark.SpringBootdemoApplication.Entity;

import jakarta.persistence.*;

import java.util.Arrays;
import java.util.Date;

@Entity
@Table(name="tbl_clients")
public class Client {
    @Id
    @Column(name = "c_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int clientId;
    @Column(nullable = false)
    private int userId;
    @Column(nullable = false)
    private String name;
    @Column(columnDefinition = "varchar(250)")
    private String description;
    @Column(nullable = false)
    private boolean visibility;
    @Column(nullable = false)
    private int[] canView;
    @Column(nullable = false)
    private String agreementPath;
    @Column
    private String logoPath;
    private boolean disabled = false;
    @Column(updatable = false)
    private Date created_at = new Date();
    private Date removed_at;

    public Client() {
    }

    public Client(int userId, String name, String description, boolean visibility, int[] canView, String agreementPath, String logoPath) {
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.visibility = visibility;
        this.canView = canView;
        this.agreementPath = agreementPath;
        this.logoPath = logoPath;
    }
    public Client(int clientId, int userId, String name, String description, boolean visibility, int[] canView, String agreementPath, String logoPath) {
        this.clientId = clientId;
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.visibility = visibility;
        this.canView = canView;
        this.agreementPath = agreementPath;
        this.logoPath = logoPath;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    public int[] getCanView() {
        return canView;
    }

    public void setCanView(int[] canView) {
        this.canView = canView;
    }

    public String getAgreementPath() {
        return agreementPath;
    }

    public void setAgreementPath(String agreementPath) {
        this.agreementPath = agreementPath;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
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
        return "Client{" +
                "clientId=" + clientId +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", visibility=" + visibility +
                ", canView=" + Arrays.toString(canView) +
                ", agreementPath='" + agreementPath + '\'' +
                ", logoPath='" + logoPath + '\'' +
                ", disabled=" + disabled +
                ", removed_at=" + removed_at +
                '}';
    }
}