/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FoodDelivery.gui.styling;

import FoodDelivery.dao.RestaurantDAO;
import FoodDelivery.dao.UserDAO;
import FoodDelivery.gui.login.LoginChooser;
import FoodDelivery.gui.payment.PaymentPopUp;
import FoodDelivery.gui.styling.components.RestoCard;
import FoodDelivery.gui.styling.eventlistener.RestoCardClickListener;
import FoodDelivery.models.Restaurant;
import FoodDelivery.models.User;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;
import javax.accessibility.AccessibleRole;
import javax.swing.JPanel;

/**
 *
 * @author Kenzie Taqiyassar
 */
public class Home extends javax.swing.JFrame implements RestoCardClickListener {

    /**
     * Creates new form Home
     */
    int x = 210;
    int y = 800;
    private int userId;
    private int restaurantId;
    private UserDAO userDB = new UserDAO();

    public Home() {
        this.setExtendedState(MAXIMIZED_BOTH);
        initComponents();
    }

    public Home(int userId) {
        this.setExtendedState(MAXIMIZED_BOTH);
        this.userId = userId;
        initComponents();
        updateUserData(userId);

        RestaurantDAO restoDB = new RestaurantDAO();
        RestaurantDAO restoDAO = new RestaurantDAO();

        List<Restaurant> topResto = restoDAO.getTop5RestaurantsBySales();
        List<Restaurant> restoList = restoDB.getAllRestaurants();

        JPanel restoPanel = new JPanel();
        JPanel restoPanel2 = new JPanel();

        restoPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        restoPanel2.setLayout(new GridLayout(0, 5, 10, 10));
        for (Restaurant resto : topResto) {
            int restoId = resto.getId();
            String restoName = resto.getName();
            String restoLocation = resto.getAddress();
            restoPanel.add(new RestoCard(this.userId, restoId, restoName, restoLocation, this));
        }

        for (Restaurant resto : restoList) {
            int restoId = resto.getId();
            String restoName = resto.getName();
            String restoLocation = resto.getAddress();

            restoPanel2.add(new RestoCard(this.userId, restoId, restoName, restoLocation, this));
        }

        jScrollPane.setViewportView(restoPanel);
        jScrollPane2.setViewportView(restoPanel2);
        setLocationRelativeTo(null);
    }

    public void updateUserData(int userId) {
        UserDAO userDAO = new UserDAO();
        this.userId = userId;
        System.out.println(userId);
        userName.setText(
                userDAO.getUserById(userId).getName()
        );
        userDAO = new UserDAO();
        User user = userDAO.getUserById(this.userId);
        emailField.setText(user.getEmail());
        passwordField.setText(user.getPassword());
        userNameField.setText(user.getName());
        addressField.setText(user.getAddress());
        phoneField.setText(user.getPhoneNumber());

    }

    @Override
    public void onRestoCardClick(int restoId) {
        dispose();
        PaymentPopUp payment = new PaymentPopUp();
        payment.setVisible(true);
    }

    public void openMenu() {
        slideBar.setSize(x, y);
        if (x == 0) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int i = 0; i <= 210; i++) {
                            slideBar.setSize(i, y);
                            Thread.sleep(1);
                        }
                    } catch (Exception e) {
                    }
                }
            }).start();
            x = 210;
        }
    }

    public void closeMenu() {
        slideBar.setSize(x, y);
        if (x == 210) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int i = 210; i >= 0; i--) {
                            slideBar.setSize(i, y);
                            Thread.sleep(2);
                        }
                    } catch (Exception e) {
                    }
                }
            }).start();
            x = 0;
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

        mainPanel = new javax.swing.JPanel();
        slideBar = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        userName = new javax.swing.JLabel();
        lblCloseMenu = new javax.swing.JLabel();
        logoutBar = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        homeBar = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        profileBar = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        historyBar = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        sidebarIcon = new javax.swing.JLabel();
        panelContainer = new javax.swing.JPanel();
        home = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane = new javax.swing.JScrollPane();
        allRestaurantsLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        profile = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        editProfileButton = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        userNameField = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        addressField = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        Email3 = new javax.swing.JLabel();
        phoneField = new javax.swing.JTextField();
        history = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        slideBar.setBackground(new java.awt.Color(255, 255, 255));
        slideBar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        slideBar.setPreferredSize(new java.awt.Dimension(190, 800));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        userName.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        lblCloseMenu.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblCloseMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCloseMenu.setText("X");
        lblCloseMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCloseMenuMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblCloseMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblCloseMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        logoutBar.setBackground(new java.awt.Color(255, 255, 255));
        logoutBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutBarMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FoodDelivery/assets/logout-icon.png"))); // NOI18N
        jLabel3.setText("Logout");

        javax.swing.GroupLayout logoutBarLayout = new javax.swing.GroupLayout(logoutBar);
        logoutBar.setLayout(logoutBarLayout);
        logoutBarLayout.setHorizontalGroup(
            logoutBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoutBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(169, Short.MAX_VALUE))
        );
        logoutBarLayout.setVerticalGroup(
            logoutBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logoutBarLayout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        homeBar.setBackground(new java.awt.Color(255, 255, 255));
        homeBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeBarMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FoodDelivery/assets/home-icon.png"))); // NOI18N
        jLabel4.setText("   Home");

        javax.swing.GroupLayout homeBarLayout = new javax.swing.GroupLayout(homeBar);
        homeBar.setLayout(homeBarLayout);
        homeBarLayout.setHorizontalGroup(
            homeBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeBarLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        homeBarLayout.setVerticalGroup(
            homeBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeBarLayout.createSequentialGroup()
                .addGap(0, 15, Short.MAX_VALUE)
                .addComponent(jLabel4))
        );

        profileBar.setBackground(new java.awt.Color(255, 255, 255));
        profileBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profileBarMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FoodDelivery/assets/account-icon.png"))); // NOI18N
        jLabel6.setText("  Edit Profile");

        javax.swing.GroupLayout profileBarLayout = new javax.swing.GroupLayout(profileBar);
        profileBar.setLayout(profileBarLayout);
        profileBarLayout.setHorizontalGroup(
            profileBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profileBarLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        profileBarLayout.setVerticalGroup(
            profileBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profileBarLayout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        historyBar.setBackground(new java.awt.Color(255, 255, 255));
        historyBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                historyBarMouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FoodDelivery/assets/history icon.png"))); // NOI18N
        jLabel8.setText("   History");

        javax.swing.GroupLayout historyBarLayout = new javax.swing.GroupLayout(historyBar);
        historyBar.setLayout(historyBarLayout);
        historyBarLayout.setHorizontalGroup(
            historyBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(historyBarLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        historyBarLayout.setVerticalGroup(
            historyBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(historyBarLayout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout slideBarLayout = new javax.swing.GroupLayout(slideBar);
        slideBar.setLayout(slideBarLayout);
        slideBarLayout.setHorizontalGroup(
            slideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, slideBarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(slideBarLayout.createSequentialGroup()
                .addComponent(historyBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(slideBarLayout.createSequentialGroup()
                .addGroup(slideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(profileBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(homeBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        slideBarLayout.setVerticalGroup(
            slideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(slideBarLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122)
                .addComponent(homeBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(profileBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(historyBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 278, Short.MAX_VALUE)
                .addComponent(logoutBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        sidebarIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FoodDelivery/assets/sidebar-icon.png"))); // NOI18N
        sidebarIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sidebarIconMouseClicked(evt);
            }
        });

        panelContainer.setLayout(new java.awt.CardLayout());

        home.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel9.setText("Restaurants with the highest sales in the last 10 days");

        jScrollPane.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane.setMaximumSize(new java.awt.Dimension(300, 300));

        allRestaurantsLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        allRestaurantsLabel.setText("All Restaurants");

        jScrollPane2.setMaximumSize(new java.awt.Dimension(300, 300));

        javax.swing.GroupLayout homeLayout = new javax.swing.GroupLayout(home);
        home.setLayout(homeLayout);
        homeLayout.setHorizontalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27))
            .addGroup(homeLayout.createSequentialGroup()
                .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(homeLayout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel9))
                    .addGroup(homeLayout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(allRestaurantsLabel)))
                .addContainerGap(762, Short.MAX_VALUE))
        );
        homeLayout.setVerticalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeLayout.createSequentialGroup()
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(allRestaurantsLabel)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        panelContainer.add(home, "card2");

        profile.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel13.setText("Email ");

        emailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailFieldActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel14.setText("Password ");

        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });

        editProfileButton.setBackground(new java.awt.Color(1, 127, 245));
        editProfileButton.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        editProfileButton.setForeground(new java.awt.Color(255, 255, 255));
        editProfileButton.setText("Edit");
        editProfileButton.setMaximumSize(new java.awt.Dimension(75, 25));
        editProfileButton.setMinimumSize(new java.awt.Dimension(75, 25));
        editProfileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editProfileButtonActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jLabel16.setText("Edit Profile");

        userNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameFieldActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel17.setText("Username");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel18.setText("Address");

        Email3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Email3.setText("Phone Number:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(phoneField, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                    .addComponent(Email3)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(editProfileButton, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                    .addComponent(passwordField)
                    .addComponent(emailField)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addressField)
                    .addComponent(userNameField))
                .addGap(40, 40, 40))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addGap(22, 22, 22)
                .addComponent(userNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Email3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(editProfileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout profileLayout = new javax.swing.GroupLayout(profile);
        profile.setLayout(profileLayout);
        profileLayout.setHorizontalGroup(
            profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, profileLayout.createSequentialGroup()
                .addContainerGap(481, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(475, 475, 475))
        );
        profileLayout.setVerticalGroup(
            profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, profileLayout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );

        panelContainer.add(profile, "card3");

        javax.swing.GroupLayout historyLayout = new javax.swing.GroupLayout(history);
        history.setLayout(historyLayout);
        historyLayout.setHorizontalGroup(
            historyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1403, Short.MAX_VALUE)
        );
        historyLayout.setVerticalGroup(
            historyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 759, Short.MAX_VALUE)
        );

        panelContainer.add(history, "card4");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel12.setText("DelivEat");

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(slideBar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 1403, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(sidebarIcon)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel12)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sidebarIcon)
                    .addComponent(jLabel12))
                .addGap(43, 43, 43)
                .addComponent(panelContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(slideBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBounds(0, 0, 1421, 878);
    }// </editor-fold>//GEN-END:initComponents

    private void lblCloseMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMenuMouseClicked
        closeMenu();
    }//GEN-LAST:event_lblCloseMenuMouseClicked

    private void sidebarIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sidebarIconMouseClicked
        openMenu();
    }//GEN-LAST:event_sidebarIconMouseClicked

    private void homeBarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeBarMouseClicked
        home.setVisible(true);
        profile.setVisible(false);
        history.setVisible(false);
        closeMenu();
    }//GEN-LAST:event_homeBarMouseClicked

    private void logoutBarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutBarMouseClicked
        this.dispose();
        LoginChooser login = new LoginChooser();
        login.setVisible(true);
    }//GEN-LAST:event_logoutBarMouseClicked

    private void profileBarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileBarMouseClicked
        profile.setVisible(true);
        home.setVisible(false);
        history.setVisible(false);
        closeMenu();    }//GEN-LAST:event_profileBarMouseClicked

    private void historyBarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historyBarMouseClicked
        history.setVisible(true);
        profile.setVisible(false);
        home.setVisible(false);
        closeMenu();
    }//GEN-LAST:event_historyBarMouseClicked

    private void emailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailFieldActionPerformed

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void editProfileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editProfileButtonActionPerformed
        int userId = this.userId;
        String username = userNameField.getText();
        String email = emailField.getText();
        String address = addressField.getText();
        String phoneNumber = phoneField.getText();
        String password = new String(passwordField.getPassword());
        UserDAO userDB = new UserDAO();
        User user = new User(userId, username, email, address, phoneNumber, password);
        userDB.updateUser(user);
        updateUserData(userId);
    }//GEN-LAST:event_editProfileButtonActionPerformed

    private void userNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameFieldActionPerformed

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Email3;
    private javax.swing.JTextField addressField;
    private javax.swing.JLabel allRestaurantsLabel;
    private javax.swing.JButton editProfileButton;
    private javax.swing.JTextField emailField;
    private javax.swing.JPanel history;
    private javax.swing.JPanel historyBar;
    private javax.swing.JPanel home;
    private javax.swing.JPanel homeBar;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCloseMenu;
    private javax.swing.JPanel logoutBar;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel panelContainer;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField phoneField;
    private javax.swing.JPanel profile;
    private javax.swing.JPanel profileBar;
    private javax.swing.JLabel sidebarIcon;
    private javax.swing.JPanel slideBar;
    private javax.swing.JLabel userName;
    private javax.swing.JTextField userNameField;
    // End of variables declaration//GEN-END:variables
}
