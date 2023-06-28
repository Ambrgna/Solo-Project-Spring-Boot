package com.genspark.SpringBootdemoApplication.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="tbl_clients")
public class Client {
    @Id
    @Column(name="c_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int clientId;
    @Column(nullable = false)
    private int userId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String agreementPath;
    private boolean disabled = false;
    @Column(updatable = false)
    private Date created_at = new Date();
    private Date removed_at;

    public Client() {
    }

    public Client(int clientId, int userId, String name, String agreementPath, boolean disabled, Date created_at, Date removed_at) {
        this.clientId = clientId;
        this.userId = userId;
        this.name = name;
        this.agreementPath = agreementPath;
        this.disabled = disabled;
        this.created_at = created_at;
        this.removed_at = removed_at;
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

    public String getAgreementPath() {
        return agreementPath;
    }

    public void setAgreementPath(String agreementPath) {
        this.agreementPath = agreementPath;
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
