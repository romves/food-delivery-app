/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FoodDelivery.gui.user;

import FoodDelivery.dao.CourierDAO;
import FoodDelivery.dao.OrderDAO;
import FoodDelivery.dao.ReceiptDAO;
import FoodDelivery.gui.styling.Home;
import FoodDelivery.models.Courier;
import java.util.List;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kenzie Taqiyassar
 */
public class DeliveryPage extends javax.swing.JFrame {

    private int userId;
    private int courierId;
    private int orderId;
    private int restaurantId;
    private int paymentId;

    public DeliveryPage() {
        initComponents();
    }

    public DeliveryPage(Map<String, Integer> generatedIds) {
        initComponents();
        this.courierId = generatedIds.get("courierId");
        this.userId = generatedIds.get("userId");
        this.orderId = generatedIds.get("orderId");
        this.restaurantId = generatedIds.get("restaurantId");
        this.paymentId = generatedIds.get("paymentId");
        CourierDAO courierDAO = new CourierDAO();
        Courier courier = courierDAO.getCourierById(this.courierId);
        courierNameLable.setText("Name: " + courier.getName());
        courierPhoneLable.setText("Phone Number: " + courier.getPhoneNumber());
        courierPlateLable.setText("Plate Number: " + courier.getPlateNumber());
        finishedPanel.setVerifyInputWhenFocusTarget(false);
        deliveryPanel2.setVisible(true);
        ReceiptDAO receipt = new ReceiptDAO();
        Map<String, Object> receiptData = receipt.getReceiptDataForOrderId(orderId);
        courierNameReceipt.setText("Name: " + receiptData.get("courierName"));
        courierPlateNumber.setText("Plate Number: " + receiptData.get("courierPlateNumber"));
        userName.setText("username: " + receiptData.get("userName"));
        userPhone.setText("user phone: " + receiptData.get("userPhoneNumber"));

        userAddress.setText("address: " + receiptData.get("userAddress"));
        orderDate.setText("Order-date: " + receiptData.get("orderDate"));
        restaurantName.setText("restaurant name: " + receiptData.get("restaurantName"));
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Product Name", "Quantity", "Subtotal"});
        List<Map<String, Object>> itemList = (List<Map<String, Object>>) receiptData.get("items");
        for (Map<String, Object> item : itemList) {
            model.addRow(new Object[]{item.get("product_name"), item.get("quantity"), item.get("subtotal")});
        }
        orderDetailTable.setModel(model);
        shippingCost.setText("Shipping cost: " + receiptData.get("shippingCost"));
        orderTotal.setText("Order total: " + receiptData.get("orderTotal"));
        orderIdReceipt.setText("Order ID: " + receiptData.get("orderId"));
        paymentMethod.setText("Payment method: " + receiptData.get("paymentMethod"));
//        courierPlateLable.setText("Plate Number: "+receiptData.get("courierPlateNumber"));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        receiptPanel = new javax.swing.JPanel();
        courierNameReceipt = new javax.swing.JLabel();
        courierPlateNumber = new javax.swing.JLabel();
        restaurantName = new javax.swing.JLabel();
        orderTotal = new javax.swing.JLabel();
        userName = new javax.swing.JLabel();
        userPhone = new javax.swing.JLabel();
        userAddress = new javax.swing.JLabel();
        orderDate = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        shippingCost = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        orderDetailTable = new javax.swing.JTable();
        orderIdReceipt = new javax.swing.JLabel();
        paymentMethod = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        delivEatLable = new javax.swing.JLabel();
        panelContainer = new javax.swing.JPanel();
        deliveryPanel2 = new javax.swing.JPanel();
        courierNameLable = new javax.swing.JLabel();
        courierPhoneLable = new javax.swing.JLabel();
        confirmOrderButton2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        courierPlateLable = new javax.swing.JLabel();
        finishedPanel = new javax.swing.JPanel();
        thanksLabel = new javax.swing.JLabel();
        backToHomeButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        receiptPanel.setBackground(new java.awt.Color(255, 255, 255));
        receiptPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        courierNameReceipt.setText("courierName:");

        courierPlateNumber.setText("courier Plate Number:");

        restaurantName.setText("restaurant name:");

        orderTotal.setText("Order total:");

        userName.setText("username:");

        userPhone.setText("user phone:");

        userAddress.setText("address");

        orderDate.setText("Order Date:");

        shippingCost.setText("Shipping cost:");

        orderDetailTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "quantity", "name", "subtotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(orderDetailTable);

        orderIdReceipt.setText("Order Id:");

        paymentMethod.setText("Payment Method:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jLabel7.setText("Receipt");

        javax.swing.GroupLayout receiptPanelLayout = new javax.swing.GroupLayout(receiptPanel);
        receiptPanel.setLayout(receiptPanelLayout);
        receiptPanelLayout.setHorizontalGroup(
            receiptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(receiptPanelLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(receiptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(receiptPanelLayout.createSequentialGroup()
                        .addComponent(userAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(41, 41, 41))
                    .addGroup(receiptPanelLayout.createSequentialGroup()
                        .addGroup(receiptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(receiptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(courierNameReceipt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(courierPlateNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(userPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(restaurantName, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(orderDate, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(receiptPanelLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(receiptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(shippingCost, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(receiptPanelLayout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(orderTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(orderIdReceipt, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(paymentMethod, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 11, Short.MAX_VALUE))))
        );
        receiptPanelLayout.setVerticalGroup(
            receiptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(receiptPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(userName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userPhone)
                .addGap(18, 18, 18)
                .addComponent(userAddress)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(courierNameReceipt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(courierPlateNumber)
                .addGap(26, 26, 26)
                .addComponent(orderDate)
                .addGap(18, 18, 18)
                .addComponent(restaurantName)
                .addGroup(receiptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(receiptPanelLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel1))
                    .addGroup(receiptPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(shippingCost)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(orderTotal)
                .addGap(18, 18, 18)
                .addComponent(orderIdReceipt)
                .addGap(18, 18, 18)
                .addComponent(paymentMethod)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        delivEatLable.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        delivEatLable.setText("DelivEat");

        panelContainer.setLayout(new java.awt.CardLayout());

        deliveryPanel2.setBackground(new java.awt.Color(255, 255, 255));

        courierNameLable.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        courierNameLable.setText("Name: ");

        courierPhoneLable.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        courierPhoneLable.setText("Phone Number:");

        confirmOrderButton2.setBackground(new java.awt.Color(1, 127, 245));
        confirmOrderButton2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        confirmOrderButton2.setForeground(new java.awt.Color(255, 255, 255));
        confirmOrderButton2.setText("Confirm Order has been received");
        confirmOrderButton2.setMaximumSize(new java.awt.Dimension(75, 25));
        confirmOrderButton2.setMinimumSize(new java.awt.Dimension(75, 25));
        confirmOrderButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmOrderButton2ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jLabel10.setText("Your order is being delivered by:");

        courierPlateLable.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        javax.swing.GroupLayout deliveryPanel2Layout = new javax.swing.GroupLayout(deliveryPanel2);
        deliveryPanel2.setLayout(deliveryPanel2Layout);
        deliveryPanel2Layout.setHorizontalGroup(
            deliveryPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deliveryPanel2Layout.createSequentialGroup()
                .addGroup(deliveryPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(deliveryPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(deliveryPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(courierPlateLable)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(courierNameLable, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(courierPhoneLable, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(deliveryPanel2Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(confirmOrderButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        deliveryPanel2Layout.setVerticalGroup(
            deliveryPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deliveryPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(courierNameLable)
                .addGap(18, 18, 18)
                .addComponent(courierPhoneLable)
                .addGap(18, 18, 18)
                .addComponent(courierPlateLable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 455, Short.MAX_VALUE)
                .addComponent(confirmOrderButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        panelContainer.add(deliveryPanel2, "card2");

        finishedPanel.setBackground(new java.awt.Color(255, 255, 255));

        thanksLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        thanksLabel.setText("Thanks for the Order!");

        backToHomeButton.setBackground(new java.awt.Color(1, 127, 245));
        backToHomeButton.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        backToHomeButton.setForeground(new java.awt.Color(255, 255, 255));
        backToHomeButton.setText("Back to HomePage");
        backToHomeButton.setMaximumSize(new java.awt.Dimension(75, 25));
        backToHomeButton.setMinimumSize(new java.awt.Dimension(75, 25));
        backToHomeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToHomeButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jLabel4.setText("Order Finished");

        javax.swing.GroupLayout finishedPanelLayout = new javax.swing.GroupLayout(finishedPanel);
        finishedPanel.setLayout(finishedPanelLayout);
        finishedPanelLayout.setHorizontalGroup(
            finishedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(finishedPanelLayout.createSequentialGroup()
                .addGroup(finishedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(finishedPanelLayout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jLabel4))
                    .addGroup(finishedPanelLayout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(thanksLabel))
                    .addGroup(finishedPanelLayout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(backToHomeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        finishedPanelLayout.setVerticalGroup(
            finishedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, finishedPanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(thanksLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 507, Short.MAX_VALUE)
                .addComponent(backToHomeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        panelContainer.add(finishedPanel, "card2");

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(delivEatLable, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(receiptPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(999, 999, 999))))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(delivEatLable)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(receiptPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(panelContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(64, 64, 64))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1575, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void confirmOrderButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmOrderButton2ActionPerformed
        deliveryPanel2.setVisible(false);
        finishedPanel.setVisible(true);
        CourierDAO courier = new CourierDAO();
        courier.updateCourierStatusDelivered(this.orderId);
        OrderDAO order = new OrderDAO();
        order.setOrderStatusFinished(this.orderId);
        CourierDAO courierDAO = new CourierDAO();
        courierDAO.updateCourierStatusAvailable(this.courierId);
    }//GEN-LAST:event_confirmOrderButton2ActionPerformed

    private void backToHomeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToHomeButtonActionPerformed
        Home home = new Home(this.userId);
        this.dispose();
        home.setVisible(true);
    }//GEN-LAST:event_backToHomeButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DeliveryPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeliveryPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeliveryPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeliveryPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeliveryPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backToHomeButton;
    private javax.swing.JButton confirmOrderButton2;
    private javax.swing.JLabel courierNameLable;
    private javax.swing.JLabel courierNameReceipt;
    private javax.swing.JLabel courierPhoneLable;
    private javax.swing.JLabel courierPlateLable;
    private javax.swing.JLabel courierPlateNumber;
    private javax.swing.JLabel delivEatLable;
    private javax.swing.JPanel deliveryPanel2;
    private javax.swing.JPanel finishedPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel orderDate;
    private javax.swing.JTable orderDetailTable;
    private javax.swing.JLabel orderIdReceipt;
    private javax.swing.JLabel orderTotal;
    private javax.swing.JPanel panelContainer;
    private javax.swing.JLabel paymentMethod;
    private javax.swing.JPanel receiptPanel;
    private javax.swing.JLabel restaurantName;
    private javax.swing.JLabel shippingCost;
    private javax.swing.JLabel thanksLabel;
    private javax.swing.JLabel userAddress;
    private javax.swing.JLabel userName;
    private javax.swing.JLabel userPhone;
    // End of variables declaration//GEN-END:variables
}
