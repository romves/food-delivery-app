/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FoodDelivery.gui.styling;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import FoodDelivery.dao.CourierDAO;
import FoodDelivery.dao.OrderDAO;
import FoodDelivery.dao.OrderDetailDAO;
import FoodDelivery.dao.PaymentDAO;
import FoodDelivery.dao.ProductDAO;
import FoodDelivery.dao.RestaurantDAO;
import FoodDelivery.gui.styling.components.ProductCard;
import FoodDelivery.gui.styling.eventlistener.ProductCardListener;
import FoodDelivery.gui.user.DeliveryPage;
import FoodDelivery.models.Product;

/**
 *
 * @author Naufal Romero
 */
public class ProductSelectionPage extends javax.swing.JFrame implements ProductCardListener {

    private int restoId;
    private int userId;
    DefaultTableModel cartTableModel;
    private int paymentId;

    /**
     * Creates new form Home
     */
    public ProductSelectionPage(int restoId, int userId) {
        this.setExtendedState(MAXIMIZED_BOTH);
        this.userId = userId;
        this.restoId = restoId;
        initComponents();
        ProductDAO productDB = new ProductDAO();
        RestaurantDAO restoDB = new RestaurantDAO();
        ProductDAO productDAO = new ProductDAO();
//        productDAO.getTop3FrequentlyBoughtTogetherProducts(restoId);
        RestoNameLabel.setText(restoDB.getRestaurantName(restoId));

        this.cartTableModel = (DefaultTableModel) cartTable.getModel();

        ArrayList<Product> productResto = productDB.getAllProductsByResto(restoId);

        JPanel productPanel = new JPanel();
        JPanel productPanel2 = new JPanel();

        productPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        productPanel2.setLayout(new GridLayout(0, 3, 10, 10));

        for (Product product : productResto) {
            int productId = product.getId();
            String productName = product.getName();
            double productPrice = product.getPrice();

            productPanel.add(new ProductCard(productId, productName, productPrice, this));
            productPanel2.add(new ProductCard(productId, productName, productPrice, this));
        }

        jScrollPane.setViewportView(productPanel);
        jScrollPane2.setViewportView(productPanel2);
        setLocationRelativeTo(null);
    }

    public ArrayList<Object[]> getIdAndQuantityData() {
        ArrayList<Object[]> idAndQuantityData = new ArrayList<>();

        for (int row = 0; row < cartTableModel.getRowCount(); row++) {
            Object[] rowData = new Object[2]; // Array to store ID and Quantity
            rowData[0] = cartTableModel.getValueAt(row, 0); // ID (column index 0)
            rowData[1] = cartTableModel.getValueAt(row, 2); // Quantity (column index 2)
            idAndQuantityData.add(rowData);
        }

        return idAndQuantityData;
    }

    @Override
    public void onAddToCart(int productId, int quantity, Product product) {
        // Implement the logic to update the cart table here
        // For example, you can add a new row to the cartTableModel
        int existingRow = findProductRow(productId);
        if (existingRow != -1) {
            // Product already exists, update the quantity
            int existingQuantity = Integer.parseInt(cartTableModel.getValueAt(existingRow, 2).toString());
            cartTableModel.setValueAt(existingQuantity + quantity, existingRow, 2);

            double price = product.getPrice();
            double total = (existingQuantity + quantity) * price;
            cartTableModel.setValueAt(total, existingRow, 3);
        } else if (quantity != 0) {
            // Product doesn't exist, add a new row
            String name = product.getName();
            double total = product.getPrice() * quantity;
            Object[] rowData = {productId, name, quantity, total};
            cartTableModel.addRow(rowData);
        }

        updateTotalLabel();

    }

    private int findProductRow(int productId) {
        for (int row = 0; row < cartTableModel.getRowCount(); row++) {
            int tableProductId = Integer.parseInt(cartTableModel.getValueAt(row, 0).toString());
            if (tableProductId == productId) {
                return row;
            }
        }
        return -1; // Product not found in the cartTable
    }

    private void updateTotalLabel() {
        int rowCount = cartTableModel.getRowCount();
        int totalQuantity = 0;
        int subtotal = 0;

        for (int row = 0; row < rowCount; row++) {
            totalQuantity += Integer.parseInt(cartTableModel.getValueAt(row, 2).toString());
            subtotal += Double.parseDouble(cartTableModel.getValueAt(row, 3).toString());
        }

        TotalPriceLabel.setText("Subtotal: " + subtotal);
        TotalQtyLabel.setText("Total item: " + totalQuantity);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        totalLabel = new javax.swing.JPanel();
        jScrollPane = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        cartTable = new javax.swing.JTable();
        updateOrder = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        RestoNameLabel = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        TotalPriceLabel = new javax.swing.JLabel();
        TotalQtyLabel = new javax.swing.JLabel();
        orderButton = new javax.swing.JButton();
        paymentMethodCombo = new javax.swing.JComboBox<>();
        incrementQtyBtn = new javax.swing.JButton();
        decrementQtyBtn = new javax.swing.JButton();
        removeItemBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        totalLabel.setDoubleBuffered(false);

        jScrollPane.setMaximumSize(new java.awt.Dimension(300, 300));

        cartTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Qty", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(cartTable);
        if (cartTable.getColumnModel().getColumnCount() > 0) {
            cartTable.getColumnModel().getColumn(0).setResizable(false);
            cartTable.getColumnModel().getColumn(0).setPreferredWidth(10);
            cartTable.getColumnModel().getColumn(1).setResizable(false);
            cartTable.getColumnModel().getColumn(1).setPreferredWidth(120);
            cartTable.getColumnModel().getColumn(2).setResizable(false);
            cartTable.getColumnModel().getColumn(2).setPreferredWidth(10);
            cartTable.getColumnModel().getColumn(3).setResizable(false);
            cartTable.getColumnModel().getColumn(3).setPreferredWidth(60);
        }

        updateOrder.setText("Update Order");
        updateOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateOrderActionPerformed(evt);
            }
        });

        jScrollPane2.setMaximumSize(new java.awt.Dimension(300, 300));

        RestoNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        RestoNameLabel.setText("DelivEat");

        backButton.setText("< Back to Home");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        TotalPriceLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        TotalPriceLabel.setText("Total");
        TotalPriceLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        TotalQtyLabel.setText("Qty");
        TotalQtyLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        orderButton.setText("Order Now");
        orderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderButtonActionPerformed(evt);
            }
        });

        paymentMethodCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DANA", "CC", "OVO", "CASH" }));

        incrementQtyBtn.setText("+");
        incrementQtyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                incrementQtyBtnActionPerformed(evt);
            }
        });

        decrementQtyBtn.setText("-");
        decrementQtyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decrementQtyBtnActionPerformed(evt);
            }
        });

        removeItemBtn.setText("remove");
        removeItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeItemBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout totalLabelLayout = new javax.swing.GroupLayout(totalLabel);
        totalLabel.setLayout(totalLabelLayout);
        totalLabelLayout.setHorizontalGroup(
            totalLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalLabelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(totalLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(totalLabelLayout.createSequentialGroup()
                        .addGroup(totalLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(337, 337, 337))
                    .addGroup(totalLabelLayout.createSequentialGroup()
                        .addGroup(totalLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RestoNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(backButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 541, Short.MAX_VALUE)))
                .addGroup(totalLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(totalLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(TotalQtyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                        .addComponent(TotalPriceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(updateOrder, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                        .addComponent(orderButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(paymentMethodCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(totalLabelLayout.createSequentialGroup()
                        .addComponent(incrementQtyBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(decrementQtyBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeItemBtn)))
                .addGap(24, 24, 24))
        );
        totalLabelLayout.setVerticalGroup(
            totalLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalLabelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(backButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(totalLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RestoNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(incrementQtyBtn)
                    .addComponent(decrementQtyBtn)
                    .addComponent(removeItemBtn))
                .addGap(7, 7, 7)
                .addGroup(totalLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(totalLabelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(TotalQtyLabel)
                        .addGap(12, 12, 12)
                        .addComponent(TotalPriceLabel)
                        .addGap(18, 18, 18)
                        .addComponent(paymentMethodCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(updateOrder)
                        .addGap(18, 18, 18)
                        .addComponent(orderButton))
                    .addGroup(totalLabelLayout.createSequentialGroup()
                        .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(totalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(totalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBounds(0, 0, 1418, 857);
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        Home home = new Home(this.userId);
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void orderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderButtonActionPerformed
        String method = (String) paymentMethodCombo.getSelectedItem();
        PaymentDAO paymentDAO = new PaymentDAO();
        OrderDAO orderDAO = new OrderDAO();
        int paymentID;
        int orderId;
        if (method.equals("CASH")) {
            paymentID = paymentDAO.insertPayment("UNPAID", method);
            orderId = orderDAO.createOrderFromPayment(paymentID, this.userId, this.restoId);
            OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
            for (int row = 0; row < cartTableModel.getRowCount(); row++) {
                int productID = (int) cartTableModel.getValueAt(row, 0);
                int qty = (int) cartTableModel.getValueAt(row, 2);
                orderDetailDAO.insertOrderDetail(orderId, productID, qty);

            }
            CourierDAO courier = new CourierDAO();
            int courierId = courier.assignCourierToOrder(orderId);
            DeliveryPage delivery = new DeliveryPage(restoId, userId, paymentId, orderId, courierId);
            delivery.setVisible(true);
        } else {
            paymentID = paymentDAO.insertPayment("PAID", method);
            orderId = orderDAO.createOrderFromPayment(paymentID, this.userId, this.restoId);
            OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
            for (int row = 0; row < cartTableModel.getRowCount(); row++) {
                int productID = (int) cartTableModel.getValueAt(row, 0);
                int qty = (int) cartTableModel.getValueAt(row, 2);
                orderDetailDAO.insertOrderDetail(orderId, productID, qty);
            }
            CourierDAO courier = new CourierDAO();
            int courierId = courier.assignCourierToOrder(orderId);
            DeliveryPage delivery = new DeliveryPage(restoId, userId, paymentId, orderId, courierId);
            delivery.setVisible(true);
        }
        this.dispose();
    }//GEN-LAST:event_orderButtonActionPerformed

    private void updateOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateOrderActionPerformed

    }//GEN-LAST:event_updateOrderActionPerformed

    private void decrementQtyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decrementQtyBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = cartTable.getSelectedRow();
        int currentQty = Integer.parseInt(cartTableModel.getValueAt(selectedRow, 2).toString());
        if (currentQty > 1) {
            cartTable.setValueAt(--currentQty, selectedRow, 2);
        } else {
            cartTableModel.removeRow(selectedRow);
        }
    }//GEN-LAST:event_decrementQtyBtnActionPerformed

    private void removeItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeItemBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = cartTable.getSelectedRow();
        cartTableModel.removeRow(selectedRow);
    }//GEN-LAST:event_removeItemBtnActionPerformed

    private void incrementQtyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_incrementQtyBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = cartTable.getSelectedRow();
        int currentQty = Integer.parseInt(cartTableModel.getValueAt(selectedRow, 2).toString());
        cartTable.setValueAt(++currentQty, selectedRow, 2);
    }//GEN-LAST:event_incrementQtyBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel RestoNameLabel;
    private javax.swing.JLabel TotalPriceLabel;
    private javax.swing.JLabel TotalQtyLabel;
    private javax.swing.JButton backButton;
    private javax.swing.JTable cartTable;
    private javax.swing.JButton decrementQtyBtn;
    private javax.swing.JButton incrementQtyBtn;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton orderButton;
    private javax.swing.JComboBox<String> paymentMethodCombo;
    private javax.swing.JButton removeItemBtn;
    private javax.swing.JPanel totalLabel;
    private javax.swing.JButton updateOrder;
    // End of variables declaration//GEN-END:variables

}
