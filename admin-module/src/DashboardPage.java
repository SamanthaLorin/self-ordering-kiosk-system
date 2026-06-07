import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class DashboardPage extends javax.swing.JFrame {

    public DashboardPage() {
        initComponents();
        this.setSize(950, 515);
        this.setLocationRelativeTo(null);
        DashboardStatistics();
    }
    
    private void DashboardStatistics() {
        String summarySql = "SELECT " +
                "COUNT(CASE WHEN DATE(order_time) = CURDATE() THEN 1 END) as total_today, " +
                "COUNT(CASE WHEN status = 'Pending' THEN 1 END) as pending, " +
                "COUNT(CASE WHEN status = 'In Progress' THEN 1 END) as preparing, " + 
                "COUNT(CASE WHEN status = 'Completed' THEN 1 END) as completed " +
                "FROM orders";
    
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(summarySql)) {
             
            if (rs.next()) {
                totalOrdersTxt.setText(String.format("%04d", rs.getInt("total_today")));
                pendingOrdersTxt.setText(String.format("%04d", rs.getInt("pending")));
                currentlyPreparingTxt.setText(String.format("%04d", rs.getInt("preparing")));
                completedOrdersTxt.setText(String.format("%04d", rs.getInt("completed")));
            }
        } catch (Exception e) {
            System.out.println("Dashboard Card Error: " + e.getMessage());
            e.printStackTrace();
        }
        DefaultTableModel mostOrderedModel = (DefaultTableModel) mostOrderedTable.getModel();
        mostOrderedModel.setRowCount(0); 
        
        String popularFoodSql = "SELECT fi.item_name, fi.category, SUM(oi.quantity) as total_sold " +
                                "FROM order_items oi " +
                                "JOIN food_items fi ON oi.food_id = fi.food_id " +
                                "GROUP BY fi.item_name, fi.category " + 
                                "ORDER BY total_sold DESC LIMIT 5";
                                
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(popularFoodSql)) {
             
            int rank = 1;
            while (rs.next()) {
                mostOrderedModel.addRow(new Object[]{
                    rank++,
                    rs.getString("item_name"),
                    rs.getString("category"),
                    rs.getInt("total_sold")
                });
            }
        } catch (Exception e) {
            System.out.println("Most Ordered Table Error: " + e.getMessage());
            e.printStackTrace();
        }
        DefaultTableModel recentOrdersModel = (DefaultTableModel) recentOrdersTable.getModel();
        recentOrdersModel.setRowCount(0); 
        
        String recentOrdersSql = "SELECT o.order_id, o.total_amount, o.status, " +
                                 "COALESCE(GROUP_CONCAT(fi.item_name SEPARATOR ', '), 'No Items Specified') as foods " +
                                 "FROM orders o " +
                                 "LEFT JOIN order_items oi ON o.order_id = oi.order_id " +
                                 "LEFT JOIN food_items fi ON oi.food_id = fi.food_id " +
                                 "GROUP BY o.order_id, o.total_amount, o.status, o.order_time " + 
                                 "ORDER BY o.order_time DESC LIMIT 5";
                                 
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(recentOrdersSql)) {
             
            while (rs.next()) {
                recentOrdersModel.addRow(new Object[]{
                    rs.getInt("order_id"),
                    rs.getString("foods"),
                    rs.getDouble("total_amount"), 
                    rs.getString("status")
                });
            }
        } catch (Exception e) {
            System.out.println("Recent Orders Table Error: " + e.getMessage());
            e.printStackTrace();
        }

        // TABLE UI Edit 
        javax.swing.table.DefaultTableCellRenderer leftRenderer = new javax.swing.table.DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.table.DefaultTableCellRenderer centerRenderer = new javax.swing.table.DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        mostOrderedTable.setRowHeight(35); 
        mostOrderedTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer); 
        mostOrderedTable.getColumnModel().getColumn(1).setCellRenderer(leftRenderer);  
        mostOrderedTable.getColumnModel().getColumn(2).setCellRenderer(leftRenderer);  
        mostOrderedTable.getColumnModel().getColumn(3).setCellRenderer(centerRenderer); 

        recentOrdersTable.setRowHeight(35);
        recentOrdersTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer); 
        recentOrdersTable.getColumnModel().getColumn(1).setCellRenderer(leftRenderer);   
        recentOrdersTable.getColumnModel().getColumn(2).setCellRenderer(leftRenderer);   
        recentOrdersTable.getColumnModel().getColumn(3).setCellRenderer(leftRenderer);     
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        yellowBG = new javax.swing.JPanel();
        whiteHeaderBG = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        UserBtn = new javax.swing.JButton();
        whiteBG = new javax.swing.JPanel();
        logoImg = new javax.swing.JLabel();
        dashboardBtn = new javax.swing.JButton();
        menuBtn = new javax.swing.JButton();
        ordersBtn = new javax.swing.JButton();
        totalOrdersTxt = new javax.swing.JLabel();
        TxtOrders1 = new javax.swing.JLabel();
        totalOrdersBG = new javax.swing.JLabel();
        pendingOrdersTxt = new javax.swing.JLabel();
        TxtOrders2 = new javax.swing.JLabel();
        PendingOrdersBG = new javax.swing.JLabel();
        currentlyPreparingTxt = new javax.swing.JLabel();
        TxtOrders3 = new javax.swing.JLabel();
        CurrentlyPreparingBG = new javax.swing.JLabel();
        completedOrdersTxt = new javax.swing.JLabel();
        TxtOrders4 = new javax.swing.JLabel();
        CompleteOrdersBG = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mostOrderedTable = new javax.swing.JTable();
        MostOrderedFoods = new javax.swing.JLabel();
        RecentOrders = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        recentOrdersTable = new javax.swing.JTable();
        seeAllBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        yellowBG.setBackground(new java.awt.Color(247, 246, 229));
        yellowBG.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        whiteHeaderBG.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Dashboard");

        UserBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurantsystemforradmin/Images/user.png"))); // NOI18N
        UserBtn.setBorderPainted(false);
        UserBtn.setContentAreaFilled(false);
        UserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout whiteHeaderBGLayout = new javax.swing.GroupLayout(whiteHeaderBG);
        whiteHeaderBG.setLayout(whiteHeaderBGLayout);
        whiteHeaderBGLayout.setHorizontalGroup(
            whiteHeaderBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(whiteHeaderBGLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 436, Short.MAX_VALUE)
                .addComponent(UserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        whiteHeaderBGLayout.setVerticalGroup(
            whiteHeaderBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(whiteHeaderBGLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(whiteHeaderBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(UserBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        yellowBG.add(whiteHeaderBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 0, 760, 50));

        whiteBG.setBackground(new java.awt.Color(255, 255, 255));

        logoImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurantsystemforradmin/Images/Logo.png"))); // NOI18N

        dashboardBtn.setBackground(new java.awt.Color(204, 204, 204));
        dashboardBtn.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        dashboardBtn.setForeground(new java.awt.Color(0, 0, 0));
        dashboardBtn.setText("Dashboard");
        dashboardBtn.setBorderPainted(false);
        dashboardBtn.setContentAreaFilled(false);
        dashboardBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dashboardBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardBtnActionPerformed(evt);
            }
        });

        menuBtn.setBackground(new java.awt.Color(204, 204, 204));
        menuBtn.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        menuBtn.setForeground(new java.awt.Color(0, 0, 0));
        menuBtn.setText("Menu");
        menuBtn.setBorderPainted(false);
        menuBtn.setContentAreaFilled(false);
        menuBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        menuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBtnActionPerformed(evt);
            }
        });

        ordersBtn.setBackground(new java.awt.Color(204, 204, 204));
        ordersBtn.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        ordersBtn.setForeground(new java.awt.Color(0, 0, 0));
        ordersBtn.setText("Orders");
        ordersBtn.setBorderPainted(false);
        ordersBtn.setContentAreaFilled(false);
        ordersBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ordersBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordersBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout whiteBGLayout = new javax.swing.GroupLayout(whiteBG);
        whiteBG.setLayout(whiteBGLayout);
        whiteBGLayout.setHorizontalGroup(
            whiteBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(whiteBGLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(whiteBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logoImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dashboardBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menuBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ordersBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        whiteBGLayout.setVerticalGroup(
            whiteBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(whiteBGLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoImg, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dashboardBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ordersBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        yellowBG.add(whiteBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 480));

        totalOrdersTxt.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        totalOrdersTxt.setForeground(new java.awt.Color(0, 0, 0));
        totalOrdersTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalOrdersTxt.setText("0000");
        yellowBG.add(totalOrdersTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 150, 30));

        TxtOrders1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TxtOrders1.setForeground(new java.awt.Color(0, 0, 0));
        TxtOrders1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TxtOrders1.setText("Total Orders Today");
        yellowBG.add(TxtOrders1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 150, -1));

        totalOrdersBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurantsystemforradmin/Images/Gradient.png"))); // NOI18N
        totalOrdersBG.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        yellowBG.add(totalOrdersBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 170, 80));

        pendingOrdersTxt.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        pendingOrdersTxt.setForeground(new java.awt.Color(0, 0, 0));
        pendingOrdersTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pendingOrdersTxt.setText("0000");
        yellowBG.add(pendingOrdersTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 150, 30));

        TxtOrders2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TxtOrders2.setForeground(new java.awt.Color(0, 0, 0));
        TxtOrders2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TxtOrders2.setText("Pending Orders");
        yellowBG.add(TxtOrders2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, 150, -1));

        PendingOrdersBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurantsystemforradmin/Images/Gradient.png"))); // NOI18N
        PendingOrdersBG.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        yellowBG.add(PendingOrdersBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 170, 80));

        currentlyPreparingTxt.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        currentlyPreparingTxt.setForeground(new java.awt.Color(0, 0, 0));
        currentlyPreparingTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        currentlyPreparingTxt.setText("0000");
        yellowBG.add(currentlyPreparingTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 70, 150, 30));

        TxtOrders3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TxtOrders3.setForeground(new java.awt.Color(0, 0, 0));
        TxtOrders3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TxtOrders3.setText("Currently Preparing");
        yellowBG.add(TxtOrders3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 110, 150, -1));

        CurrentlyPreparingBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurantsystemforradmin/Images/Gradient.png"))); // NOI18N
        CurrentlyPreparingBG.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        yellowBG.add(CurrentlyPreparingBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 60, 170, 80));

        completedOrdersTxt.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        completedOrdersTxt.setForeground(new java.awt.Color(0, 0, 0));
        completedOrdersTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        completedOrdersTxt.setText("0000");
        yellowBG.add(completedOrdersTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 70, 130, 30));

        TxtOrders4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TxtOrders4.setForeground(new java.awt.Color(0, 0, 0));
        TxtOrders4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TxtOrders4.setText("Completed Orders");
        yellowBG.add(TxtOrders4, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 110, 150, -1));

        CompleteOrdersBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurantsystemforradmin/Images/Gradient.png"))); // NOI18N
        CompleteOrdersBG.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        yellowBG.add(CompleteOrdersBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 60, 170, 80));

        mostOrderedTable.setBackground(new java.awt.Color(245, 243, 232));
        mostOrderedTable.setForeground(new java.awt.Color(0, 0, 0));
        mostOrderedTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Rank", "Food Name", "Category", "Quantity Sold"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
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
        jScrollPane1.setViewportView(mostOrderedTable);

        yellowBG.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 350, 170));

        MostOrderedFoods.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        MostOrderedFoods.setForeground(new java.awt.Color(123, 72, 85));
        MostOrderedFoods.setText("Most Ordered Items");
        yellowBG.add(MostOrderedFoods, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 200, 30));

        RecentOrders.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        RecentOrders.setForeground(new java.awt.Color(123, 72, 85));
        RecentOrders.setText("Recent Orders");
        yellowBG.add(RecentOrders, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 170, -1, -1));

        recentOrdersTable.setBackground(new java.awt.Color(245, 243, 232));
        recentOrdersTable.setForeground(new java.awt.Color(0, 0, 0));
        recentOrdersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Food", "Total Amount", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
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
        jScrollPane2.setViewportView(recentOrdersTable);

        yellowBG.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(556, 190, 370, 170));

        seeAllBtn.setBackground(new java.awt.Color(232, 219, 179));
        seeAllBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        seeAllBtn.setForeground(new java.awt.Color(0, 0, 0));
        seeAllBtn.setText("See All");
        seeAllBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seeAllBtnActionPerformed(evt);
            }
        });
        yellowBG.add(seeAllBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(819, 157, 90, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(yellowBG, javax.swing.GroupLayout.DEFAULT_SIZE, 943, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(yellowBG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserBtnActionPerformed
        UserPage nextPage = new UserPage();
        nextPage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_UserBtnActionPerformed

    private void dashboardBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardBtnActionPerformed
        DashboardStatistics();
    }//GEN-LAST:event_dashboardBtnActionPerformed

    private void menuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBtnActionPerformed
        MenuManagementPage nextPage = new MenuManagementPage();
        nextPage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuBtnActionPerformed

    private void ordersBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordersBtnActionPerformed
        OrderManagementPage nextPage = new OrderManagementPage();
        nextPage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ordersBtnActionPerformed

    private void seeAllBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seeAllBtnActionPerformed
        OrderManagementPage nextPage = new OrderManagementPage();
        nextPage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_seeAllBtnActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CompleteOrdersBG;
    private javax.swing.JLabel CurrentlyPreparingBG;
    private javax.swing.JLabel MostOrderedFoods;
    private javax.swing.JLabel PendingOrdersBG;
    private javax.swing.JLabel RecentOrders;
    private javax.swing.JLabel TxtOrders1;
    private javax.swing.JLabel TxtOrders2;
    private javax.swing.JLabel TxtOrders3;
    private javax.swing.JLabel TxtOrders4;
    private javax.swing.JButton UserBtn;
    private javax.swing.JLabel completedOrdersTxt;
    private javax.swing.JLabel currentlyPreparingTxt;
    private javax.swing.JButton dashboardBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel logoImg;
    private javax.swing.JButton menuBtn;
    private javax.swing.JTable mostOrderedTable;
    private javax.swing.JButton ordersBtn;
    private javax.swing.JLabel pendingOrdersTxt;
    private javax.swing.JTable recentOrdersTable;
    private javax.swing.JButton seeAllBtn;
    private javax.swing.JLabel totalOrdersBG;
    private javax.swing.JLabel totalOrdersTxt;
    private javax.swing.JPanel whiteBG;
    private javax.swing.JPanel whiteHeaderBG;
    private javax.swing.JPanel yellowBG;
    // End of variables declaration//GEN-END:variables
}
