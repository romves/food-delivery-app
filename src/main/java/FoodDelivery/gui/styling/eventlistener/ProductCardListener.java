/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package FoodDelivery.gui.styling.eventlistener;

import FoodDelivery.models.Product;

/**
 *
 * @author PC
 */
public interface ProductCardListener {
    void onAddToCart(int productId, int quantity, Product product);
}
