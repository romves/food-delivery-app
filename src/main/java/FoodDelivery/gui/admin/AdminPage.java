/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FoodDelivery.gui.admin;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import FoodDelivery.dao.CourierDAO;
import FoodDelivery.dao.RestaurantDAO;
import FoodDelivery.models.Courier;
import FoodDelivery.models.Restaurant;

/**
 *
 * @author UsEr
 */
public class AdminPage extends javax.swing.JFrame {

    /**
     * Creates new form AdminPage
     */
    public AdminPage() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        initComponents();
        loadRestaurantTable();
        selectRestaurantRow();
        loadCourierTable();
        selectCourierRow();
    }


    public void clearRestaurantField() {
        restaurantIDField.setText("");
        restaurantNameField.setText("");
        restaurantAddressField.setText("");
        restaurantDescArea.setText("");
        restaurantPhoneField.setText("");
    }

    public void setRestaurantField(String restaurantID, String restaurantName, String restaurantEmail, String restaurantPassword, String restaurantAddress, String restaurantDesc, String restaurantPhone, String restaurantBalance) {
        restaurantIDField.setText(restaurantID);
        restaurantNameField.setText(restaurantName);
        restaurantEmailField.setText(restaurantEmail);
        restaurantPasswordField.setText(restaurantPassword);
        restaurantAddressField.setText(restaurantAddress);
        restaurantDescArea.setText(restaurantDesc);
        restaurantPhoneField.setText(restaurantPhone);
        restaurantBalanceField.setText(restaurantBalance);
    }

    public void setCourierField(String id, String courierName, String courierPhone, String courierPlate, double courierBalance) {
        courierIDField.setText(id);
        courierNameField.setText(courierName);
        courierPhoneField.setText(courierPhone);
        courierPlateField.setText(courierPlate);
        courierBalanceField.setText(Double.toString(courierBalance));
    };

    private void selectRestaurantRow() {
        restaurantTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = restaurantTable.getSelectedRow();

                    if (selectedRow != -1) {
                        DefaultTableModel model = (DefaultTableModel) restaurantTable.getModel();
                        Object restaurantIDObj = model.getValueAt(selectedRow, 0);
                        Object restaurantNameObj = model.getValueAt(selectedRow, 1);
                        Object restaurantEmailObj = model.getValueAt(selectedRow, 2);
                        Object restaurantPasswordObj = model.getValueAt(selectedRow, 3);
                        Object restaurantAddressObj = model.getValueAt(selectedRow, 4);
                        Object restaurantDescObj = model.getValueAt(selectedRow, 5);
                        Object restaurantPhoneObj = model.getValueAt(selectedRow, 6);
                        Object restaurantBalanceObj = model.getValueAt(selectedRow, 7);

                        // Check and convert to appropriate types
                        String restaurantID = (restaurantIDObj != null) ? restaurantIDObj.toString() : "";
                        String restaurantName = (restaurantNameObj != null) ? restaurantNameObj.toString() : "";
                        String restaurantAddress = (restaurantAddressObj != null) ? restaurantAddressObj.toString() : "";
                        String restaurantDesc = (restaurantDescObj != null) ? restaurantDescObj.toString() : "";
                        String restaurantPhone = (restaurantPhoneObj != null) ? restaurantPhoneObj.toString() : "";
                        String restaurantEmail = (restaurantEmailObj != null) ? restaurantEmailObj.toString() : "";
                        String restaurantPassword = (restaurantPasswordObj != null) ? restaurantPasswordObj.toString() : "";
                        String restaurantBalance = (restaurantBalanceObj != null) ? restaurantBalanceObj.toString() : "";

                        // Call the setRestaurantField method to populate the UI fields
                        setRestaurantField(restaurantID, restaurantName, restaurantEmail, restaurantPassword, restaurantAddress, restaurantDesc, restaurantPhone, restaurantBalance);
                    }
                }
            }
        });
    }

    private void selectCourierRow() {
        courierTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = courierTable.getSelectedRow();

                    if (selectedRow != -1) {
                        DefaultTableModel model = (DefaultTableModel) courierTable.getModel();
                        Object courierIDObj = model.getValueAt(selectedRow, 0);
                        Object courierNameObj = model.getValueAt(selectedRow, 1);
                        Object courierStatusObj = model.getValueAt(selectedRow, 2);
                        Object courierPhoneObj = model.getValueAt(selectedRow, 3);
                        Object courierPlateObj = model.getValueAt(selectedRow, 4);
                        
                        // Check and convert to appropriate types
                        String courierID = (courierIDObj != null) ? courierIDObj.toString() : "";
                        String courierName = (courierNameObj != null) ? courierNameObj.toString() : "";
                        String courierStatus = (courierStatusObj != null) ? courierStatusObj.toString() : "";
                        String courierPhone = (courierPhoneObj != null) ? courierPhoneObj.toString() : "";
                        String courierPlate = (courierPlateObj != null) ? courierPlateObj.toString() : "";
                        double courierBalance = Double.parseDouble(model.getValueAt(selectedRow, 5).toString());

                        // Call the setRestaurantField method to populate the UI fields
                        setCourierField(courierID, courierName, courierPhone, courierPlate, courierBalance);
                    }
                }
            }
        });
    }

    public void loadRestaurantTable() {
        DefaultTableModel model = (DefaultTableModel) restaurantTable.getModel();
        model.setRowCount(0); // Clear old data from the table

        RestaurantDAO restaurantDAO = new RestaurantDAO();
        List<Restaurant> restaurants = restaurantDAO.getAllRestaurants();

        for (Restaurant restaurant : restaurants) {
            model.addRow(new Object[]{
                restaurant.getId(),
                restaurant.getName(),
                restaurant.getEmail(),
                restaurant.getPassword(),
                restaurant.getAddress(),
                restaurant.getDescription(),
                restaurant.getPhoneNumber(),
                restaurant.getBalance()
            });
        }
    }

    public void loadCourierTable() {
        DefaultTableModel model = (DefaultTableModel) courierTable.getModel();
        model.setRowCount(0);
        CourierDAO courierDAO = new CourierDAO();
        List<Courier> couriers = courierDAO.getAllCouriers();
        for (Courier courier : couriers) {
            model.addRow(new Object[]{courier.getCourierId(), courier.getName(), courier.getDeliveryStatus(), courier.getPhoneNumber(), courier.getPlateNumber(), courier.getBalance()});
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        adminPanel = new javax.swing.JTabbedPane();
        restaurantPanel = new javax.swing.JPanel();
        restaurantNameLabel = new javax.swing.JLabel();
        restaurantNameField = new javax.swing.JTextField();
        restaurantIDLabel = new javax.swing.JLabel();
        restaurantIDField = new javax.swing.JTextField();
        restaurantDescLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        restaurantDescArea = new javax.swing.JTextArea();
        createRestaurantButton = new javax.swing.JButton();
        clearRestaurant = new javax.swing.JButton();
        updateRestaurantButton = new javax.swing.JButton();
        deleteRestaurantButton = new javax.swing.JButton();
        restaurantAddressLabel = new javax.swing.JLabel();
        restaurantAddressField = new javax.swing.JTextField();
        restaurantPhoneLabel = new javax.swing.JLabel();
        restaurantPhoneField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        restaurantEmailField = new javax.swing.JTextField();
        restaurantPasswordField = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        restaurantBalanceField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        restaurantTable = new javax.swing.JTable();
        courierPanel = new javax.swing.JPanel();
        courierNameField = new javax.swing.JTextField();
        courierIDField = new javax.swing.JTextField();
        createCourierButton = new javax.swing.JButton();
        clearCourier = new javax.swing.JButton();
        updateCourierButton = new javax.swing.JButton();
        courierDeleteButton = new javax.swing.JButton();
        courierPhoneField = new javax.swing.JTextField();
        courierPlateField = new javax.swing.JTextField();
        courierIDLabel = new javax.swing.JLabel();
        courierNameLabel = new javax.swing.JLabel();
        courierPhoneLabel = new javax.swing.JLabel();
        courierPlateLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        courierTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        courierBalanceField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(51, 102, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1439, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        adminPanel.setBackground(new java.awt.Color(255, 255, 255));

        restaurantPanel.setBackground(new java.awt.Color(255, 255, 255));
        restaurantPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                restaurantPanelMouseClicked(evt);
            }
        });
        restaurantPanel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                keyPressedRestaurantPanel(evt);
            }
        });

        restaurantNameLabel.setText("Name:");

        restaurantIDLabel.setText("ID:");

        restaurantDescLabel.setText("Description:");

        restaurantDescArea.setColumns(20);
        restaurantDescArea.setRows(5);
        jScrollPane1.setViewportView(restaurantDescArea);

        createRestaurantButton.setText("Create");
        createRestaurantButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createRestaurantButtonActionPerformed(evt);
            }
        });

        clearRestaurant.setText("Clear");
        clearRestaurant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearRestaurantActionPerformed(evt);
            }
        });

        updateRestaurantButton.setText("Update");
        updateRestaurantButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateRestaurantButtonActionPerformed(evt);
            }
        });

        deleteRestaurantButton.setText("Delete");
        deleteRestaurantButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteRestaurantButtonActionPerformed(evt);
            }
        });

        restaurantAddressLabel.setText("Address:");

        restaurantPhoneLabel.setText("Phone Number:");

        jLabel1.setText("Email");

        jLabel2.setText("Password:");

        jLabel3.setText("balance:");

        restaurantTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "name", "email", "password", "address", "description", "phone", "balance'"
            }
        ));
        jScrollPane2.setViewportView(restaurantTable);

        javax.swing.GroupLayout restaurantPanelLayout = new javax.swing.GroupLayout(restaurantPanel);
        restaurantPanel.setLayout(restaurantPanelLayout);
        restaurantPanelLayout.setHorizontalGroup(
            restaurantPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(restaurantPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(restaurantPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(restaurantPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(restaurantIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(restaurantNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(restaurantDescLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(restaurantAddressLabel)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(restaurantPhoneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75)
                .addGroup(restaurantPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(restaurantBalanceField, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(restaurantPanelLayout.createSequentialGroup()
                        .addGroup(restaurantPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(restaurantPhoneField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(restaurantPasswordField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(restaurantNameField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                            .addComponent(restaurantEmailField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(restaurantAddressField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                            .addComponent(restaurantIDField, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(44, 44, 44)
                        .addGroup(restaurantPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(restaurantPanelLayout.createSequentialGroup()
                                .addComponent(createRestaurantButton)
                                .addGap(18, 18, 18)
                                .addComponent(clearRestaurant))
                            .addGroup(restaurantPanelLayout.createSequentialGroup()
                                .addComponent(updateRestaurantButton)
                                .addGap(18, 18, 18)
                                .addComponent(deleteRestaurantButton)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        restaurantPanelLayout.setVerticalGroup(
            restaurantPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(restaurantPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(restaurantPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(restaurantPanelLayout.createSequentialGroup()
                        .addGroup(restaurantPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(createRestaurantButton)
                            .addComponent(restaurantIDLabel)
                            .addComponent(restaurantIDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clearRestaurant))
                        .addGap(18, 18, 18)
                        .addGroup(restaurantPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(restaurantNameLabel)
                            .addComponent(restaurantNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(updateRestaurantButton)
                            .addComponent(deleteRestaurantButton))
                        .addGap(18, 18, 18)
                        .addGroup(restaurantPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(restaurantEmailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(15, 15, 15)
                        .addGroup(restaurantPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(restaurantPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(restaurantPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(restaurantAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(restaurantAddressLabel))
                        .addGap(18, 18, 18)
                        .addGroup(restaurantPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(restaurantDescLabel))
                        .addGap(18, 18, 18)
                        .addGroup(restaurantPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(restaurantPhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(restaurantPhoneLabel))
                        .addGap(18, 18, 18)
                        .addGroup(restaurantPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(restaurantBalanceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(134, Short.MAX_VALUE))
        );

        adminPanel.addTab("Restaurant", restaurantPanel);

        courierPanel.setBackground(new java.awt.Color(255, 255, 255));

        createCourierButton.setText("Create");
        createCourierButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createCourierButtonActionPerformed(evt);
            }
        });

        clearCourier.setText("Clear");
        clearCourier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearCourierActionPerformed(evt);
            }
        });

        updateCourierButton.setText("Update");
        updateCourierButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateCourierButtonActionPerformed(evt);
            }
        });

        courierDeleteButton.setText("Delete");
        courierDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courierDeleteButtonActionPerformed(evt);
            }
        });

        courierPlateField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courierPlateFieldActionPerformed(evt);
            }
        });

        courierIDLabel.setText("ID:");

        courierNameLabel.setText("Name:");

        courierPhoneLabel.setText("Phone Number:");

        courierPlateLabel.setText("Plate Number:");

        courierTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "id", "name", "delivery_status", "phone_number", "plate_number", "balance"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(courierTable);

        jLabel4.setText("Balance:");

        courierBalanceField.setEnabled(false);

        javax.swing.GroupLayout courierPanelLayout = new javax.swing.GroupLayout(courierPanel);
        courierPanel.setLayout(courierPanelLayout);
        courierPanelLayout.setHorizontalGroup(
            courierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(courierPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(courierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(courierIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(courierNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(courierPhoneLabel)
                    .addComponent(courierPlateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(83, 83, 83)
                .addGroup(courierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(courierPanelLayout.createSequentialGroup()
                        .addGroup(courierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(courierPhoneField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(courierNameField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(courierPlateField)
                            .addComponent(courierIDField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(courierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(courierPanelLayout.createSequentialGroup()
                                .addComponent(createCourierButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(clearCourier))
                            .addGroup(courierPanelLayout.createSequentialGroup()
                                .addComponent(updateCourierButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(courierDeleteButton))))
                    .addComponent(courierBalanceField, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        courierPanelLayout.setVerticalGroup(
            courierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(courierPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(courierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(courierPanelLayout.createSequentialGroup()
                        .addGroup(courierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(createCourierButton)
                            .addComponent(courierIDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clearCourier)
                            .addComponent(courierIDLabel))
                        .addGap(18, 18, 18)
                        .addGroup(courierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(courierNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(updateCourierButton)
                            .addComponent(courierDeleteButton)
                            .addComponent(courierNameLabel))
                        .addGap(18, 18, 18)
                        .addGroup(courierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(courierPhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(courierPhoneLabel))
                        .addGap(18, 18, 18)
                        .addGroup(courierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(courierPlateLabel)
                            .addComponent(courierPlateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(courierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(courierBalanceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(134, Short.MAX_VALUE))
        );

        adminPanel.addTab("Courier", courierPanel);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(adminPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(adminPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(1455, 719));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void courierDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courierDeleteButtonActionPerformed
        // TODO add your handling code here:
        int id = Integer.parseInt(courierIDField.getText());
        CourierDAO courierDAO = new CourierDAO();
        courierDAO.deleteCourier(id);
        loadCourierTable();
    }//GEN-LAST:event_courierDeleteButtonActionPerformed

    private void updateCourierButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateCourierButtonActionPerformed
        int id = Integer.parseInt(courierIDField.getText());
        String courierName = courierNameField.getText();
        String courierStatus = "PENDING";
        String courierPhone = courierPhoneField.getText();
        String courierPlate = courierPlateField.getText();
        Courier courier = new Courier(id, courierStatus, courierName, courierPhone, courierPlate);
        CourierDAO courierDAO = new CourierDAO();
        courierDAO.updateCourier(courier);
        loadCourierTable();
    }//GEN-LAST:event_updateCourierButtonActionPerformed

    private void clearCourierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearCourierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clearCourierActionPerformed

    private void createCourierButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createCourierButtonActionPerformed
        // TODO add your handling code here:
        String courierName = courierNameField.getText();
        String courierStatus = "PENDING";
        String courierPhone = courierPhoneField.getText();
        String courierPlate = courierPlateField.getText();
        Courier courier = new Courier(courierStatus, courierName, courierPhone, courierPlate);
        CourierDAO courierDAO = new CourierDAO();
        courierDAO.addCourier(courier);

        loadCourierTable();
    }//GEN-LAST:event_createCourierButtonActionPerformed

    private void keyPressedRestaurantPanel(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_keyPressedRestaurantPanel
        // TODO add your handling code here:
        //        loadRestaurantTable();
    }//GEN-LAST:event_keyPressedRestaurantPanel

    private void restaurantPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restaurantPanelMouseClicked
        // TODO add your handling code here:
        //        loadRestaurantTable();
    }//GEN-LAST:event_restaurantPanelMouseClicked

    private void deleteRestaurantButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteRestaurantButtonActionPerformed
        int id = Integer.parseInt(restaurantIDField.getText());
        RestaurantDAO resDAO = new RestaurantDAO();
        resDAO.deleteRestaurant(id);
        loadRestaurantTable();
    }//GEN-LAST:event_deleteRestaurantButtonActionPerformed

    private void updateRestaurantButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateRestaurantButtonActionPerformed
        // TODO add your handling code here:
        int id = Integer.parseInt(restaurantIDField.getText());
        String name = restaurantNameField.getText();
        String email = restaurantEmailField.getText();
        String password = new String(restaurantPasswordField.getPassword());
        String address = restaurantAddressField.getText();
        String desc = restaurantDescArea.getText();
        String phone = restaurantPhoneField.getText();
        Restaurant restaurant = new Restaurant(id, name, email, password, address, desc, phone, 0.0);
        RestaurantDAO resDAO = new RestaurantDAO();
        resDAO.updateRestaurant(restaurant);
        loadRestaurantTable();
    }//GEN-LAST:event_updateRestaurantButtonActionPerformed

    private void clearRestaurantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearRestaurantActionPerformed
        // TODO add your handling code here:
        clearRestaurantField();
    }//GEN-LAST:event_clearRestaurantActionPerformed

    private void createRestaurantButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createRestaurantButtonActionPerformed
        String name = restaurantNameField.getText();
        String email = restaurantEmailField.getText();
        String password = new String(restaurantPasswordField.getPassword());
        String address = restaurantAddressField.getText();
        String desc = restaurantDescArea.getText();
        String phone = restaurantPhoneField.getText();
        Restaurant restaurant = new Restaurant(name, email, password, address, desc, phone);
        RestaurantDAO resDAO = new RestaurantDAO();
        resDAO.addRestaurant(restaurant);
        loadRestaurantTable();
    }//GEN-LAST:event_createRestaurantButtonActionPerformed

    private void courierPlateFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courierPlateFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_courierPlateFieldActionPerformed

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
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane adminPanel;
    private javax.swing.JButton clearCourier;
    private javax.swing.JButton clearRestaurant;
    private javax.swing.JTextField courierBalanceField;
    private javax.swing.JButton courierDeleteButton;
    private javax.swing.JTextField courierIDField;
    private javax.swing.JLabel courierIDLabel;
    private javax.swing.JTextField courierNameField;
    private javax.swing.JLabel courierNameLabel;
    private javax.swing.JPanel courierPanel;
    private javax.swing.JTextField courierPhoneField;
    private javax.swing.JLabel courierPhoneLabel;
    private javax.swing.JTextField courierPlateField;
    private javax.swing.JLabel courierPlateLabel;
    private javax.swing.JTable courierTable;
    private javax.swing.JButton createCourierButton;
    private javax.swing.JButton createRestaurantButton;
    private javax.swing.JButton deleteRestaurantButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField restaurantAddressField;
    private javax.swing.JLabel restaurantAddressLabel;
    private javax.swing.JTextField restaurantBalanceField;
    private javax.swing.JTextArea restaurantDescArea;
    private javax.swing.JLabel restaurantDescLabel;
    private javax.swing.JTextField restaurantEmailField;
    private javax.swing.JTextField restaurantIDField;
    private javax.swing.JLabel restaurantIDLabel;
    private javax.swing.JTextField restaurantNameField;
    private javax.swing.JLabel restaurantNameLabel;
    private javax.swing.JPanel restaurantPanel;
    private javax.swing.JPasswordField restaurantPasswordField;
    private javax.swing.JTextField restaurantPhoneField;
    private javax.swing.JLabel restaurantPhoneLabel;
    private javax.swing.JTable restaurantTable;
    private javax.swing.JButton updateCourierButton;
    private javax.swing.JButton updateRestaurantButton;
    // End of variables declaration//GEN-END:variables
}
