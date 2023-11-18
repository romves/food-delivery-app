/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FoodDelivery.gui.login;

import FoodDelivery.gui.styling.*;
import FoodDelivery.dao.RestaurantDAO;
import FoodDelivery.gui.restaurant.RestaurantDashboardPage;
import FoodDelivery.gui.signUp.SignUpRestaurant;

/**
 *
 * @author Naufal Romero
 */
public class LoginRestaurant extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public LoginRestaurant() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        emailFieldLoginRestaurant = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        passwordFieldLoginRestaurant = new javax.swing.JPasswordField();
        submitButtonLoginRestaurant = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        createAccountLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Email ");

        emailFieldLoginRestaurant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailFieldLoginRestaurantActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Password ");

        passwordFieldLoginRestaurant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldLoginRestaurantActionPerformed(evt);
            }
        });

        submitButtonLoginRestaurant.setBackground(new java.awt.Color(1, 127, 245));
        submitButtonLoginRestaurant.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        submitButtonLoginRestaurant.setForeground(new java.awt.Color(255, 255, 255));
        submitButtonLoginRestaurant.setText("Submit");
        submitButtonLoginRestaurant.setMaximumSize(new java.awt.Dimension(75, 25));
        submitButtonLoginRestaurant.setMinimumSize(new java.awt.Dimension(75, 25));
        submitButtonLoginRestaurant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonLoginRestaurantActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Dont have account?");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jLabel4.setText("For Restaurant");

        createAccountLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        createAccountLabel.setForeground(new java.awt.Color(1, 127, 245));
        createAccountLabel.setText("Create an account");
        createAccountLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createAccountLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(createAccountLabel))
                    .addComponent(jLabel4)
                    .addComponent(submitButtonLoginRestaurant, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(passwordFieldLoginRestaurant, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(emailFieldLoginRestaurant, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailFieldLoginRestaurant, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(9, 9, 9)
                .addComponent(passwordFieldLoginRestaurant, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(submitButtonLoginRestaurant, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createAccountLabel))
                .addGap(111, 111, 111))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonLoginRestaurantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonLoginRestaurantActionPerformed
        // TODO add your handling code here:
        String email = emailFieldLoginRestaurant.getText();
        String password = new String(passwordFieldLoginRestaurant.getPassword());
        RestaurantDAO restoDB = new RestaurantDAO();
        int restoId = restoDB.checkPasswordByEmail(email, password);
        if (restoId != -1) {
            RestaurantDashboardPage page = new RestaurantDashboardPage(restoId);
            page.setVisible(true);
            this.dispose();
        } else {
            System.out.println("Password is incorrect");
        }
    }//GEN-LAST:event_submitButtonLoginRestaurantActionPerformed

    private void passwordFieldLoginRestaurantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldLoginRestaurantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldLoginRestaurantActionPerformed

    private void emailFieldLoginRestaurantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailFieldLoginRestaurantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailFieldLoginRestaurantActionPerformed

    private void createAccountLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createAccountLabelMouseClicked
        // TODO add your handling code here:
        this.dispose();
        SignUpRestaurant signUp = new SignUpRestaurant();
        signUp.setVisible(true);

    }//GEN-LAST:event_createAccountLabelMouseClicked

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
            java.util.logging.Logger.getLogger(LoginRestaurant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginRestaurant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginRestaurant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginRestaurant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginRestaurant().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel createAccountLabel;
    private javax.swing.JTextField emailFieldLoginRestaurant;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField passwordFieldLoginRestaurant;
    private javax.swing.JButton submitButtonLoginRestaurant;
    // End of variables declaration//GEN-END:variables
}
