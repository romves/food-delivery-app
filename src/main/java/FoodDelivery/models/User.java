/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FoodDelivery.models;

/**
 *
 * @author UsEr
 */
public class User {

    private int userId;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;
    private String password;

    public User() {
        // Default constructor
    }

    public User(String userName, String userEmail, String userAddress, String userPhoneNumber, String userPassword) {
        this.name = userName;
        this.email = userEmail;
        this.address = userAddress;
        this.phoneNumber = userPhoneNumber;
        this.password = userPassword;
    }

    public User(int userId, String userName, String userEmail, String userAddress, String userPhoneNumber, String userPassword) {
        this.userId = userId;
        this.name = userName;
        this.email = userEmail;
        this.address = userAddress;
        this.phoneNumber = userPhoneNumber;
        this.password = userPassword;
    }

    // Getters and Setters for all fields
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    

}
