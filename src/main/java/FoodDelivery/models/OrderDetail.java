/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FoodDelivery.models;

/**
 *
 * @author Kenzie Taqiyassar
 */
public class OrderDetail {

    private int orderId;
    private int productId;
    private int quantity;
    private double subTotal;

    public OrderDetail(int productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public OrderDetail(int orderId, int productId, int quantity) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
    }
    public OrderDetail(int orderId, int productId, int quantity, double subTotal){
        
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getSubTotal() {
        return subTotal;
    }
    

    // Getters and setters
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
