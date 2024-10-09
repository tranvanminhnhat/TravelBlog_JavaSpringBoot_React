package com.travel.shahara.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Users {
    /**
     * User ID
     */
    @Id
    private int id;

    /**
     * Username
     */
    private String username;

    /**
     * Password
     */
    private String password;

    /**
     * Getter ID
     * @return ID
     */
    public int getId() {
        return id;
    }

    /**
     * Setter User ID
     * @param userId User ID
     */
    public void setId(int userId) {
        this.id = userId;
    }

    /**
     * Getter Username
     * @return Username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter Username
     * @param username Username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Getter Password
     * @return Password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter Password
     * @param password Password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
