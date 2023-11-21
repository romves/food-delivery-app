/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FoodDelivery.models;

/**
 *
 * @author Kenzie Taqiyassar
 */
public class Courier {

    private int courierId;
    private String deliveryStatus;
    private String name;
    private String phoneNumber;
    private String plateNumber;
    private double balance;

    public Courier(String deliveryStatus, String name, String phoneNumber, String plateNumber) {
        this.deliveryStatus = deliveryStatus;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.plateNumber = plateNumber;
    }

    public Courier(int courierId, String deliveryStatus, String name, String phoneNumber, String plateNumber) {
        this.courierId = courierId;
        this.deliveryStatus = deliveryStatus;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.plateNumber = plateNumber;
    }

    public Courier(int courierId, String deliveryStatus, String name, String phoneNumber, String plateNumber, double balance) {
        this.courierId = courierId;
        this.deliveryStatus = deliveryStatus;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.plateNumber = plateNumber;
        this.balance = balance;

    }

    public Courier(String name, String phoneNumber, String plateNumber) {
        this.courierId = courierId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.plateNumber = plateNumber;

    }

    public int getCourierId() {
        return courierId;
    }

    public void setCourierId(int courierId) {
        this.courierId = courierId;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}
