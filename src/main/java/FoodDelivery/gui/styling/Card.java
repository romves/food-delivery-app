/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package FoodDelivery.gui.styling;

/**
 *
 * @author Naufal Romero
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Card extends JPanel {
    private JLabel nameLabel;
    private JLabel priceLabel;
    private JButton plusButton;
    private JButton minusButton;
    private JLabel quantityLabel;
    private JButton addToCartButton;

    private int productId;
    private int quantity;

    public Card(int productId, String productName, double productPrice) {
        this.productId = productId;
        this.quantity = 0;

        nameLabel = new JLabel(productName);
        priceLabel = new JLabel("Price: $" + productPrice);
        plusButton = new JButton("+");
        minusButton = new JButton("-");
        quantityLabel = new JLabel("Quantity: " + quantity);
        addToCartButton = new JButton("Add to Cart");

        setLayout(new GridLayout(5, 1));

        add(nameLabel);
        add(priceLabel);
        add(plusButton);
        add(minusButton);
        add(quantityLabel);
        add(addToCartButton);

        plusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quantity++;
                updateQuantityLabel();
            }
        });

        minusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (quantity > 0) {
                    quantity--;
                    updateQuantityLabel();
                }
            }
        });

        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add the product to the cart (you need to implement this part)
                addToCart();
            }
        });
    }

    private void updateQuantityLabel() {
        quantityLabel.setText("Quantity: " + quantity);
    }

    private void addToCart() {
        // // Implement adding the product to the cart or updating the database
        // // You might want to use the productId and quantity variables for this
        // // Example:
        // // Assuming you have a database connection, you can execute an update query
        // try (Connection connection =
        // DriverManager.getConnection("jdbc:mysql://your_database_url", "username",
        // "password")) {
        // String updateQuery = "UPDATE products SET quantity = quantity + ? WHERE id =
        // ?";
        // try (PreparedStatement preparedStatement =
        // connection.prepareStatement(updateQuery)) {
        // preparedStatement.setInt(1, quantity);
        // preparedStatement.setInt(2, productId);
        // preparedStatement.executeUpdate();
        // }
        // } catch (SQLException ex) {
        // ex.printStackTrace();
        // // Handle the exception appropriately
        // }
        System.out.println(quantity + " " + productId);
    }

    public static void main(String[] args) {
        // Example of usage
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Product Card Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Replace this with your actual list of products from the database
            ArrayList<Card> productCards = new ArrayList<>();
            productCards.add(new Card(1, "Product A", 19.99));
            productCards.add(new Card(2, "Product B", 29.99));
            productCards.add(new Card(3, "Product C", 39.99));

            JPanel productPanel = new JPanel();
            productPanel.setLayout(new BoxLayout(productPanel, BoxLayout.Y_AXIS));

            for (Card productCard : productCards) {
                productPanel.add(productCard);
                productPanel.add(Box.createRigidArea(new Dimension(0, 10)));
            }

            JScrollPane scrollPane = new JScrollPane(productPanel);

            frame.getContentPane().add(scrollPane);

            frame.pack();
            frame.setSize(400, 300);
            frame.setVisible(true);
        });
    }
}
