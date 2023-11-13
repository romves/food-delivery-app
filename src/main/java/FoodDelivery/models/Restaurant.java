/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FoodDelivery.models;

import java.math.BigDecimal;

/**
 *
 * @author Kenzie Taqiyassar
 */
public class Restaurant {

    private int id;
    private String name;
    private String email;
    private String password;
    private String address;
    private String description;
    private String phoneNumber;
    private Double balance;

    // Constructors, getters, and setters
    public Restaurant() {
        // Default constructor
    }

    public Restaurant(String name, String email, String password, String address, String description, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.description = description;
        this.phoneNumber = phoneNumber;
        this.balance = 0.0; // Default balance is set to 0.0
    }

    public Restaurant(int restaurantId, String restaurantName, String restaurantEmail, String restaurantPassword, String restaurantAddress, String restaurantDescription, String restaurantPhoneNumber, double balance) {
        this.id = restaurantId;
        this.name = restaurantName;
        this.email = restaurantEmail;
        this.password = restaurantPassword;
        this.address = restaurantAddress;
        this.description = restaurantDescription;
        this.phoneNumber = restaurantPhoneNumber;
    }

    // Getters and Setters for all fields
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}
