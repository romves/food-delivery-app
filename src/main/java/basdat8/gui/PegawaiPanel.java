/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package basdat8.gui;

/**
 *
 * @author PC
 */
public class PegawaiPanel extends javax.swing.JFrame {

    /**
     * Creates new form PegawaiPanel
     */
    public PegawaiPanel() {
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

        jLabel1 = new javax.swing.JLabel();
        txtMenuPrice = new javax.swing.JTextField();
        buttonClearMenu = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        backToAdminHome = new javax.swing.JButton();
        txtMenuInfo = new javax.swing.JTextField();
        txtMenuID = new javax.swing.JTextField();
        buttonSubmitMenu = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        buttonEditMenu = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        DataTableMcDonald = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        menuTypeSelect = new javax.swing.JComboBox<>();
        txtMenuName = new javax.swing.JTextField();
        buttonDeleteMenu = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Menu ID");

        buttonClearMenu.setText("Clear");
        buttonClearMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClearMenuActionPerformed(evt);
            }
        });

        jLabel4.setText("Additional");

        backToAdminHome.setText("< Back");
        backToAdminHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToAdminHomeActionPerformed(evt);
            }
        });

        txtMenuInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMenuInfoActionPerformed(evt);
            }
        });

        txtMenuID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtMenuIDMouseClicked(evt);
            }
        });
        txtMenuID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMenuIDActionPerformed(evt);
            }
        });

        buttonSubmitMenu.setText("Create");
        buttonSubmitMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSubmitMenuActionPerformed(evt);
            }
        });

        jLabel5.setText("Menu Type");

        buttonEditMenu.setText("Save Changes");
        buttonEditMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditMenuActionPerformed(evt);
            }
        });

        DataTableMcDonald.setAutoCreateRowSorter(true);
        DataTableMcDonald.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idPegawai", "Nama", "NoTelp", "CabangMcd"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DataTableMcDonald.setShowGrid(true);
        DataTableMcDonald.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(DataTableMcDonald);

        jLabel2.setText("Menu Name");

        menuTypeSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cetak", "Fotokopi" }));
        menuTypeSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTypeSelectActionPerformed(evt);
            }
        });

        txtMenuName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMenuNameActionPerformed(evt);
            }
        });

        buttonDeleteMenu.setText("Delete");
        buttonDeleteMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteMenuActionPerformed(evt);
            }
        });

        jLabel3.setText("Menu Price");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(backToAdminHome))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(menuTypeSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4))
                                    .addGap(48, 48, 48)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtMenuID, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtMenuName)
                                            .addComponent(txtMenuPrice)
                                            .addComponent(txtMenuInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(buttonSubmitMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(buttonEditMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(buttonDeleteMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(buttonClearMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backToAdminHome)
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(menuTypeSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMenuID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMenuName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMenuPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMenuInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonSubmitMenu)
                            .addComponent(buttonEditMenu))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonDeleteMenu)
                            .addComponent(buttonClearMenu)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonClearMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonClearMenuActionPerformed

    private void backToAdminHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToAdminHomeActionPerformed
        // TODO add your handling code here:
        AdminPanel adminPanel = new AdminPanel();
        adminPanel.setVisible(true);
        dispose();
    }//GEN-LAST:event_backToAdminHomeActionPerformed

    private void txtMenuInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMenuInfoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMenuInfoActionPerformed

    private void txtMenuIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMenuIDMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMenuIDMouseClicked

    private void txtMenuIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMenuIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMenuIDActionPerformed

    private void buttonSubmitMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSubmitMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonSubmitMenuActionPerformed

    private void buttonEditMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonEditMenuActionPerformed

    private void menuTypeSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTypeSelectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuTypeSelectActionPerformed

    private void txtMenuNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMenuNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMenuNameActionPerformed

    private void buttonDeleteMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonDeleteMenuActionPerformed

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
            java.util.logging.Logger.getLogger(PegawaiPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PegawaiPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PegawaiPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PegawaiPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PegawaiPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable DataTableMcDonald;
    private javax.swing.JButton backToAdminHome;
    private javax.swing.JButton buttonClearMenu;
    private javax.swing.JButton buttonDeleteMenu;
    private javax.swing.JButton buttonEditMenu;
    private javax.swing.JButton buttonSubmitMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> menuTypeSelect;
    private javax.swing.JTextField txtMenuID;
    private javax.swing.JTextField txtMenuInfo;
    private javax.swing.JTextField txtMenuName;
    private javax.swing.JTextField txtMenuPrice;
    // End of variables declaration//GEN-END:variables
}
