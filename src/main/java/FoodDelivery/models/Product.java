/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FoodDeliveryApp.models;

/**
 *
 * @author Kenzie Taqiyassar
 */
enum ProductType {
    FOOD,
    DRINK
}

public class Product {
    String name;
    int id;
    double price;
    ProductType type;

    public Product( int id, String name, double price, String type) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.type =  type.equals("FOOD") ? ProductType.FOOD : ProductType.DRINK;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type.toString();
    }
}
