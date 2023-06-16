package com.genspark.SpringBootdemoApplication.Entity;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;

@Entity
@Table(name="tbl_users")
public class User {
    @Id
    @Column(name="u_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(updatable = false/*, columnDefinition = "varchar(255) default ''ROLE_USER'"*/)
    private String role;
    private boolean enabled = true;
    @Column(updatable = false)
    private Date created_at = new Date();
    private Date removed_at;

    public User() {
    }

    public User(int userId, String username, String password, String role, boolean enabled, Date created_at, Date removed_at) {
        this.userId = userId;
        this.username = username;
//        System.out.println(passwordEncoder.encode("password"));
        this.password = password;
        this.role = role;
        this.enabled = enabled;
        this.created_at = created_at;
        this.removed_at = removed_at;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
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