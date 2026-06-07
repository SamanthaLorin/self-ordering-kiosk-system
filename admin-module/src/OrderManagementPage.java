import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;

public class OrderManagementPage extends javax.swing.JFrame {
    TableRowSorter<DefaultTableModel>sorter;

    public OrderManagementPage() {
    initComponents(); 
    this.setSize(950, 515);
    this.setLocationRelativeTo(null);
   
    ButtonGroup group = new ButtonGroup();
    group.add(allBtn);
    group.add(pendingBtn);
    group.add(progressBtn);
    group.add(completedBtn);
    allBtn.setSelected(true);
    
    jTable1.setRowHeight(75); 
    jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    
    overrideModelEditableProperty();
    customizeTable(); 
    loadOrdersTableFromDatabase();
    HeaderStats();
}
    
    private void customizeTable() {
        JTableHeader header = jTable1.getTableHeader();
        header.setPreferredSize(new Dimension(header.getWidth(), 40));
        header.setBackground(new Color(220, 220, 220));
        header.setForeground(Color.DARK_GRAY);
        header.setReorderingAllowed(false);
        header.setOpaque(false);
        
        jTable1.setRowHeight(75); 
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    }
    
    // Makes the table 'un-editable' so the admin cannot change or rewrite over the existing items already in the table. 
    private void overrideModelEditableProperty() {
        DefaultTableModel dynamicModel = new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] { "No.", "OrderID", "Food", "TotalAmount", "OrderMethod", "Status", "Time", "Action" }
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 7;
            }
        };
        jTable1.setModel(dynamicModel);
        
        sorter = new TableRowSorter<>(dynamicModel);
        jTable1.setRowSorter(sorter);
    }
    public void loadOrdersTableFromDatabase() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        String sql = "SELECT "
                   + "  o.order_id, o.order_method, o.total_amount, o.status, TIME(o.order_time) AS order_time_only, "
                   + "  GROUP_CONCAT(CONCAT(oi.quantity, 'x ', f.item_name) SEPARATOR ', ') AS food_details "
                   + "FROM orders o "
                   + "JOIN order_items oi ON o.order_id = oi.order_id "
                   + "JOIN food_items f ON oi.food_id = f.food_id "
                   + "GROUP BY o.order_id "
                   + "ORDER BY o.order_id DESC";

        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            int displayNo = 1;
            while (rs.next()) {
                int id = rs.getInt("order_id");
                String food = rs.getString("food_details");
                double amount = rs.getDouble("total_amount");
                String method = rs.getString("order_method");
                String status = rs.getString("status");
                String time = rs.getString("order_time_only");

                Object[] rowData = { displayNo++, id, food, amount, method, status, time, status };
                model.addRow(rowData);
            }
        } catch (Exception e) {
            System.out.println("Error loading Admin Orders Table: " + e.getMessage());
            e.printStackTrace();
        }

        try {
            jTable1.getColumnModel().getColumn(7).setCellRenderer(new OrderActionButtons());
            jTable1.getColumnModel().getColumn(7).setCellEditor(new OrderActionButtons());
            
            int[] preferredWidths = {40, 60, 200, 95, 100, 90, 85, 180}; 
            for (int i = 0; i < preferredWidths.length; i++) {
                if (i < jTable1.getColumnCount()) {
                    jTable1.getColumnModel().getColumn(i).setPreferredWidth(preferredWidths[i]);
                }
            }
        } catch (Exception ex) {
            System.out.println("Error binding buttons renderer: " + ex.getMessage());
        }
    }
    
    // Stats Update
    public void HeaderStats() {
        String todayStr = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());

        String summarySql = "SELECT "
                + "COUNT(CASE WHEN order_time LIKE '" + todayStr + "%' THEN 1 END) as total_today, "
                + "COUNT(CASE WHEN status = 'Pending' THEN 1 END) as pending, "
                + "COUNT(CASE WHEN status = 'In Progress' THEN 1 END) as preparing, "
                + "COUNT(CASE WHEN status = 'Completed' THEN 1 END) as completed "
                + "FROM orders";

        try (Connection conn = Database.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(summarySql)) {

            if (rs.next()) {
                totalOrdersTxt.setText(String.format("%04d", rs.getInt("total_today")));
                pendingOrdersTxt.setText(String.format("%04d", rs.getInt("pending")));
                currentlyPreparingTxt.setText(String.format("%04d", rs.getInt("preparing")));
                completedOrdersTxt.setText(String.format("%04d", rs.getInt("completed")));
            }
        } catch (Exception e) {
            System.out.println("Order Management Counter Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        yellowBG = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        logoImg = new javax.swing.JLabel();
        dashboardBtn = new javax.swing.JButton();
        menuBtn = new javax.swing.JButton();
        ordersBtn = new javax.swing.JButton();
        whiteBG = new javax.swing.JPanel();
        orderManagementLbl = new javax.swing.JLabel();
        totalOrdersTxt = new javax.swing.JLabel();
        TxtOrders = new javax.swing.JLabel();
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
        jTable1 = new javax.swing.JTable();
        allBtn = new javax.swing.JToggleButton();
        pendingBtn = new javax.swing.JToggleButton();
        progressBtn = new javax.swing.JToggleButton();
        completedBtn = new javax.swing.JToggleButton();
        addOrderBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        yellowBG.setBackground(new java.awt.Color(247, 246, 229));
        yellowBG.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logoImg, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addComponent(dashboardBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menuBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ordersBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoImg, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dashboardBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ordersBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(320, Short.MAX_VALUE))
        );

        yellowBG.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, -1));

        whiteBG.setBackground(new java.awt.Color(255, 255, 255));

        orderManagementLbl.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        orderManagementLbl.setForeground(new java.awt.Color(51, 51, 51));
        orderManagementLbl.setText("Order Management");

        javax.swing.GroupLayout whiteBGLayout = new javax.swing.GroupLayout(whiteBG);
        whiteBG.setLayout(whiteBGLayout);
        whiteBGLayout.setHorizontalGroup(
            whiteBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(whiteBGLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(orderManagementLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(490, Short.MAX_VALUE))
        );
        whiteBGLayout.setVerticalGroup(
            whiteBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(orderManagementLbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        yellowBG.add(whiteBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 0, 760, 50));

        totalOrdersTxt.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        totalOrdersTxt.setForeground(new java.awt.Color(0, 0, 0));
        totalOrdersTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalOrdersTxt.setText("0000");
        yellowBG.add(totalOrdersTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 150, 30));

        TxtOrders.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TxtOrders.setForeground(new java.awt.Color(0, 0, 0));
        TxtOrders.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TxtOrders.setText("Total Orders Today");
        yellowBG.add(TxtOrders, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 150, -1));

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
        yellowBG.add(completedOrdersTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 70, 150, 30));

        TxtOrders4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TxtOrders4.setForeground(new java.awt.Color(0, 0, 0));
        TxtOrders4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TxtOrders4.setText("Completed Orders");
        yellowBG.add(TxtOrders4, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 110, 150, -1));

        CompleteOrdersBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurantsystemforradmin/Images/Gradient.png"))); // NOI18N
        CompleteOrdersBG.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        yellowBG.add(CompleteOrdersBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 60, 170, 80));

        jScrollPane1.setBorder(null);

        jTable1.setBackground(new java.awt.Color(245, 243, 232));
        jTable1.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jTable1.setForeground(new java.awt.Color(0, 0, 0));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No.", "OrderID", "Food", "TotalAmount", "OrderMethod", "Status", "Time", "Action"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setFocusable(false);
        jTable1.setSelectionBackground(new java.awt.Color(230, 220, 220));
        jTable1.setShowGrid(false);
        jScrollPane1.setViewportView(jTable1);

        yellowBG.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 720, 250));

        allBtn.setBackground(new java.awt.Color(232, 219, 179));
        allBtn.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        allBtn.setForeground(new java.awt.Color(0, 0, 0));
        allBtn.setText("All Orders");
        allBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allBtnActionPerformed(evt);
            }
        });
        yellowBG.add(allBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 90, -1));

        pendingBtn.setBackground(new java.awt.Color(232, 219, 179));
        pendingBtn.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        pendingBtn.setForeground(new java.awt.Color(0, 0, 0));
        pendingBtn.setText("Pending");
        pendingBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pendingBtnActionPerformed(evt);
            }
        });
        yellowBG.add(pendingBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, 80, -1));

        progressBtn.setBackground(new java.awt.Color(232, 219, 179));
        progressBtn.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        progressBtn.setForeground(new java.awt.Color(0, 0, 0));
        progressBtn.setText("In Progress");
        progressBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                progressBtnActionPerformed(evt);
            }
        });
        yellowBG.add(progressBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 190, 100, -1));

        completedBtn.setBackground(new java.awt.Color(232, 219, 179));
        completedBtn.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        completedBtn.setForeground(new java.awt.Color(0, 0, 0));
        completedBtn.setText("Completed");
        completedBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                completedBtnActionPerformed(evt);
            }
        });
        yellowBG.add(completedBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, -1, -1));

        addOrderBtn.setBackground(new java.awt.Color(123, 72, 85));
        addOrderBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addOrderBtn.setForeground(new java.awt.Color(255, 255, 255));
        addOrderBtn.setText("+ Add Order");
        addOrderBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addOrderBtnActionPerformed(evt);
            }
        });
        yellowBG.add(addOrderBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 190, 130, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(yellowBG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(yellowBG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void allBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allBtnActionPerformed
        sorter.setRowFilter(null);
    }//GEN-LAST:event_allBtnActionPerformed

    private void pendingBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pendingBtnActionPerformed
        sorter.setRowFilter(RowFilter.regexFilter("Pending", 5));
    }//GEN-LAST:event_pendingBtnActionPerformed

    private void progressBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_progressBtnActionPerformed
        sorter.setRowFilter(RowFilter.regexFilter("In Progress", 5));
    }//GEN-LAST:event_progressBtnActionPerformed

    private void completedBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_completedBtnActionPerformed
        sorter.setRowFilter(RowFilter.regexFilter("Completed", 5));
    }//GEN-LAST:event_completedBtnActionPerformed

    private void dashboardBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardBtnActionPerformed
        DashboardPage nextPage = new DashboardPage();
        nextPage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_dashboardBtnActionPerformed

    private void menuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBtnActionPerformed
        MenuManagementPage nextPage = new MenuManagementPage();
        nextPage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuBtnActionPerformed

    private void addOrderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addOrderBtnActionPerformed
        AddOrderDialog dialog = new AddOrderDialog(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_addOrderBtnActionPerformed

    // CLASS FOR THE BUTTONS INSIDE THE TABLES :>
    class DynamicButtonRenderer extends javax.swing.JPanel implements TableCellRenderer {
        private JButton actionBtn = new JButton();
        private JButton cancelBtn = new JButton();
        private JButton updateBtn = new JButton("Update"); 

        public DynamicButtonRenderer() {
            setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 2));
            setOpaque(true);
            
            cancelBtn.setText("Cancel");
            cancelBtn.setBackground(new Color(220, 53, 69)); 
            cancelBtn.setForeground(Color.WHITE);

            updateBtn.setBackground(new Color(110, 60, 75)); 
            updateBtn.setForeground(Color.WHITE);
            
            add(actionBtn);
            add(cancelBtn);
            add(updateBtn); 
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            String status = (value != null) ? value.toString() : "";
            if (isSelected) {
                setBackground(table.getSelectionBackground());
            } else {
                setBackground(table.getBackground());
            }

            if (status.equalsIgnoreCase("Pending")) {
                actionBtn.setText("Prepare");
                actionBtn.setBackground(new Color(255, 193, 7)); 
                actionBtn.setForeground(Color.BLACK);
                actionBtn.setVisible(true);
                cancelBtn.setVisible(true);
                return this;
            } 
            
            if (status.equalsIgnoreCase("In Progress")) {
                actionBtn.setText("Complete");
                actionBtn.setBackground(new Color(40, 167, 69)); 
                actionBtn.setForeground(Color.WHITE);
                actionBtn.setVisible(true);
                cancelBtn.setVisible(true);
                return this;
            }

            actionBtn.setVisible(false);
            cancelBtn.setVisible(false);
            return this; 
        }
    }

    class DynamicButtonEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {
        private javax.swing.JPanel panel;
        private JButton actionBtn;
        private JButton cancelBtn;
        private JButton updateBtn; 
        private String currentStatus;
        private int currentOrderId;
        private OrderManagementPage parentPage;

        public DynamicButtonEditor(OrderManagementPage parentPage) {
            this.parentPage = parentPage;
            
            panel = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 2));
            actionBtn = new JButton();
            cancelBtn = new JButton("Cancel");
            updateBtn = new JButton("Update"); 
            
            cancelBtn.setBackground(new Color(220, 53, 69));
            cancelBtn.setForeground(Color.WHITE);

            updateBtn.setBackground(new Color(110, 60, 75));
            updateBtn.setForeground(Color.WHITE);
            
            actionBtn.addActionListener(this);
            cancelBtn.addActionListener(this);
            updateBtn.addActionListener(this);
            
            panel.add(actionBtn);
            panel.add(cancelBtn);
            panel.add(updateBtn);
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            currentStatus = (value != null) ? value.toString() : "";
            currentOrderId = Integer.parseInt(table.getValueAt(row, 1).toString());
            
            if (currentStatus.equalsIgnoreCase("Pending")) {
                actionBtn.setText("Prepare");
                actionBtn.setBackground(new Color(255, 193, 7));
                actionBtn.setForeground(Color.BLACK);
                actionBtn.setVisible(true);
                cancelBtn.setVisible(true);
            } else if (currentStatus.equalsIgnoreCase("In Progress")) {
                actionBtn.setText("Complete");
                actionBtn.setBackground(new Color(40, 167, 69));
                actionBtn.setForeground(Color.WHITE);
                actionBtn.setVisible(true);
                cancelBtn.setVisible(true);
            } else {
                actionBtn.setVisible(false);
                cancelBtn.setVisible(false);
            }
            return panel;
        }

        @Override
        public Object getCellEditorValue() {
            return currentStatus;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == updateBtn) {
                fireEditingStopped(); 

                UpdateOrderDialog dialog = new UpdateOrderDialog(parentPage, true, currentOrderId);
                dialog.setVisible(true);

                parentPage.loadOrdersTableFromDatabase(); 
                parentPage.HeaderStats();
                return; 
            }

            String targetNextStatus = "";
            if (e.getSource() == cancelBtn) {
                targetNextStatus = "Cancelled";
            } else if (e.getSource() == actionBtn) {
                if (currentStatus.equalsIgnoreCase("Pending")) {
                    targetNextStatus = "In Progress";
                } else if (currentStatus.equalsIgnoreCase("In Progress")) {
                    targetNextStatus = "Completed";
                }
            }

            if (!targetNextStatus.isEmpty()) {
                String updateSql = "UPDATE orders SET status = ? WHERE order_id = ?";
                try (Connection conn = Database.getConnection();
                     PreparedStatement pstmt = conn.prepareStatement(updateSql)) {
                    
                    pstmt.setString(1, targetNextStatus);
                    pstmt.setInt(2, currentOrderId);
                    pstmt.executeUpdate();
                    
                } catch (Exception ex) {
                    System.out.println("SQL Execution Error: " + ex.getMessage());
                }
            }
            fireEditingStopped(); 
            parentPage.loadOrdersTableFromDatabase(); 
            parentPage.HeaderStats();
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderManagementPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CompleteOrdersBG;
    private javax.swing.JLabel CurrentlyPreparingBG;
    private javax.swing.JLabel PendingOrdersBG;
    private javax.swing.JLabel TxtOrders;
    private javax.swing.JLabel TxtOrders2;
    private javax.swing.JLabel TxtOrders3;
    private javax.swing.JLabel TxtOrders4;
    private javax.swing.JButton addOrderBtn;
    private javax.swing.JToggleButton allBtn;
    private javax.swing.JToggleButton completedBtn;
    private javax.swing.JLabel completedOrdersTxt;
    private javax.swing.JLabel currentlyPreparingTxt;
    private javax.swing.JButton dashboardBtn;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel logoImg;
    private javax.swing.JButton menuBtn;
    private javax.swing.JLabel orderManagementLbl;
    private javax.swing.JButton ordersBtn;
    private javax.swing.JToggleButton pendingBtn;
    private javax.swing.JLabel pendingOrdersTxt;
    private javax.swing.JToggleButton progressBtn;
    private javax.swing.JLabel totalOrdersBG;
    private javax.swing.JLabel totalOrdersTxt;
    private javax.swing.JPanel whiteBG;
    private javax.swing.JPanel yellowBG;
    // End of variables declaration//GEN-END:variables
}
