import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.sql.*;
import java.util.Vector;

public class AddOrderDialog extends javax.swing.JDialog {
    private OrderManagementPage parentPage;
    private javax.swing.JRadioButton lastSelectedButton = null; 

    public AddOrderDialog(OrderManagementPage parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.parentPage = parent;
        this.setLocationRelativeTo(parent);

        currentOrderTable.getColumnModel().getColumn(0).setMinWidth(0);
        currentOrderTable.getColumnModel().getColumn(0).setMaxWidth(0);
        currentOrderTable.getColumnModel().getColumn(0).setPreferredWidth(0);

        ButtonGroup methodGroup = new ButtonGroup();
        methodGroup.add(dineInBtn);
        methodGroup.add(takeOutBtn);
        dineInBtn.setSelected(true);

        ButtonGroup paymentGroup = new ButtonGroup();
        paymentGroup.add(cashBtn);
        paymentGroup.add(cardBtn);
        cashBtn.setSelected(true);

        javax.swing.ButtonGroup discountGroup = new javax.swing.ButtonGroup();
        discountGroup.add(SCDiscountBtn);
        discountGroup.add(PWDDiscountBtn);
        discountGroup.clearSelection(); 
        
        setupDiscountToggleButton(SCDiscountBtn, discountGroup);
        setupDiscountToggleButton(PWDDiscountBtn, discountGroup);
        
        setupBasketTableListeners();
        loadCategories();
    }

    class FoodItemWrapper {
        int id;
        String name;
        double price;
        
        public FoodItemWrapper(int id, String name, double price) {
            this.id = id; 
            this.name = name; 
            this.price = price;
        }
        @Override
        public String toString() { 
            return name; 
        } 
    }

    private void loadCategories() {
        foodCategoryComboBox.removeAllItems();
        String sql = "SELECT DISTINCT category FROM food_items ORDER BY category ASC"; 
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                foodCategoryComboBox.addItem(rs.getString("category"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        whiteBG = new javax.swing.JPanel();
        FoodCategoryTxt = new javax.swing.JLabel();
        ItemTxt = new javax.swing.JLabel();
        foodCategoryComboBox = new javax.swing.JComboBox<>();
        itemComboBox = new javax.swing.JComboBox<>();
        currentOrderListTxt = new javax.swing.JLabel();
        orderMethodTxt = new javax.swing.JLabel();
        dineInBtn = new javax.swing.JRadioButton();
        takeOutBtn = new javax.swing.JRadioButton();
        Discounts = new javax.swing.JLabel();
        cashBtn = new javax.swing.JRadioButton();
        cardBtn = new javax.swing.JRadioButton();
        total = new javax.swing.JLabel();
        totalLbl = new javax.swing.JLabel();
        addToCartBtn = new javax.swing.JButton();
        confirmBtn = new javax.swing.JButton();
        CancelBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        currentOrderTable = new javax.swing.JTable();
        discount = new javax.swing.JLabel();
        DiscountLbl = new javax.swing.JLabel();
        subtotal = new javax.swing.JLabel();
        subtotalLbl = new javax.swing.JLabel();
        paymentMethodTxt1 = new javax.swing.JLabel();
        SCDiscountBtn = new javax.swing.JRadioButton();
        PWDDiscountBtn = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        addAnOrder = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        whiteBG.setBackground(new java.awt.Color(255, 255, 255));

        FoodCategoryTxt.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        FoodCategoryTxt.setForeground(new java.awt.Color(0, 0, 0));
        FoodCategoryTxt.setText("Select Food Category:");

        ItemTxt.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        ItemTxt.setForeground(new java.awt.Color(0, 0, 0));
        ItemTxt.setText("Select Item:");

        foodCategoryComboBox.setBackground(new java.awt.Color(232, 219, 179));
        foodCategoryComboBox.setForeground(new java.awt.Color(0, 0, 0));
        foodCategoryComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                foodCategoryComboBoxActionPerformed(evt);
            }
        });

        itemComboBox.setBackground(new java.awt.Color(232, 219, 179));
        itemComboBox.setForeground(new java.awt.Color(0, 0, 0));

        currentOrderListTxt.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        currentOrderListTxt.setForeground(new java.awt.Color(0, 0, 0));
        currentOrderListTxt.setText("Current Order List:");

        orderMethodTxt.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        orderMethodTxt.setForeground(new java.awt.Color(0, 0, 0));
        orderMethodTxt.setText("Order Method:");

        dineInBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        dineInBtn.setForeground(new java.awt.Color(0, 0, 0));
        dineInBtn.setText("Dine-in");
        dineInBtn.setContentAreaFilled(false);

        takeOutBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        takeOutBtn.setForeground(new java.awt.Color(0, 0, 0));
        takeOutBtn.setText("Take-Out");
        takeOutBtn.setContentAreaFilled(false);

        Discounts.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        Discounts.setForeground(new java.awt.Color(0, 0, 0));
        Discounts.setText("Available Discounts:");

        cashBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cashBtn.setForeground(new java.awt.Color(0, 0, 0));
        cashBtn.setText("Cash");
        cashBtn.setContentAreaFilled(false);

        cardBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cardBtn.setForeground(new java.awt.Color(0, 0, 0));
        cardBtn.setText("Card");
        cardBtn.setContentAreaFilled(false);

        total.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        total.setForeground(new java.awt.Color(0, 0, 0));
        total.setText("Total:");

        totalLbl.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        totalLbl.setForeground(new java.awt.Color(123, 72, 85));
        totalLbl.setText("0.00");

        addToCartBtn.setBackground(new java.awt.Color(123, 72, 85));
        addToCartBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addToCartBtn.setForeground(new java.awt.Color(255, 255, 255));
        addToCartBtn.setText("Add to Cart");
        addToCartBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToCartBtnActionPerformed(evt);
            }
        });

        confirmBtn.setBackground(new java.awt.Color(123, 72, 85));
        confirmBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        confirmBtn.setForeground(new java.awt.Color(255, 255, 255));
        confirmBtn.setText("Confirm");
        confirmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmBtnActionPerformed(evt);
            }
        });

        CancelBtn.setBackground(new java.awt.Color(123, 72, 85));
        CancelBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CancelBtn.setForeground(new java.awt.Color(255, 255, 255));
        CancelBtn.setText("Cancel");
        CancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBtnActionPerformed(evt);
            }
        });

        currentOrderTable.setBackground(new java.awt.Color(247, 246, 229));
        currentOrderTable.setForeground(new java.awt.Color(0, 0, 0));
        currentOrderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Price", "Quantity", "Subtotal", "Action"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(currentOrderTable);

        discount.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        discount.setForeground(new java.awt.Color(0, 0, 0));
        discount.setText("Discount:");

        DiscountLbl.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        DiscountLbl.setForeground(new java.awt.Color(123, 72, 85));
        DiscountLbl.setText("0.00");

        subtotal.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        subtotal.setForeground(new java.awt.Color(0, 0, 0));
        subtotal.setText("Subtotal:");

        subtotalLbl.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        subtotalLbl.setForeground(new java.awt.Color(123, 72, 85));
        subtotalLbl.setText("0.00");

        paymentMethodTxt1.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        paymentMethodTxt1.setForeground(new java.awt.Color(0, 0, 0));
        paymentMethodTxt1.setText("Payment Method:");

        SCDiscountBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SCDiscountBtn.setForeground(new java.awt.Color(0, 0, 0));
        SCDiscountBtn.setText("Senior Citizen Discount");

        PWDDiscountBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        PWDDiscountBtn.setForeground(new java.awt.Color(0, 0, 0));
        PWDDiscountBtn.setText("PWD Discount");

        jPanel1.setBackground(new java.awt.Color(123, 72, 85));

        addAnOrder.setFont(new java.awt.Font("Microsoft PhagsPa", 1, 24)); // NOI18N
        addAnOrder.setForeground(new java.awt.Color(255, 255, 255));
        addAnOrder.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addAnOrder.setText("Add Order");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(addAnOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(119, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addAnOrder, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout whiteBGLayout = new javax.swing.GroupLayout(whiteBG);
        whiteBG.setLayout(whiteBGLayout);
        whiteBGLayout.setHorizontalGroup(
            whiteBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(whiteBGLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(FoodCategoryTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(foodCategoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(whiteBGLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(ItemTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(itemComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(whiteBGLayout.createSequentialGroup()
                .addGap(249, 249, 249)
                .addComponent(addToCartBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(whiteBGLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(currentOrderListTxt))
            .addGroup(whiteBGLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(whiteBGLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(orderMethodTxt)
                .addGap(54, 54, 54)
                .addComponent(dineInBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(takeOutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(whiteBGLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(paymentMethodTxt1)
                .addGap(36, 36, 36)
                .addComponent(cashBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(cardBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(whiteBGLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(Discounts, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(SCDiscountBtn)
                .addGap(16, 16, 16)
                .addComponent(PWDDiscountBtn))
            .addGroup(whiteBGLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(subtotalLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(whiteBGLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(whiteBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(discount, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(whiteBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(whiteBGLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(DiscountLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(whiteBGLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(confirmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(CancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        whiteBGLayout.setVerticalGroup(
            whiteBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(whiteBGLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(whiteBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FoodCategoryTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(whiteBGLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(foodCategoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(whiteBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ItemTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(whiteBGLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(itemComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addComponent(addToCartBtn)
                .addGap(9, 9, 9)
                .addComponent(currentOrderListTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(whiteBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(orderMethodTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(whiteBGLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(whiteBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dineInBtn)
                            .addComponent(takeOutBtn))))
                .addGap(6, 6, 6)
                .addGroup(whiteBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(paymentMethodTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(whiteBGLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(cashBtn))
                    .addGroup(whiteBGLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(cardBtn)))
                .addGap(5, 5, 5)
                .addGroup(whiteBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Discounts, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SCDiscountBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PWDDiscountBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(whiteBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(subtotal)
                    .addComponent(subtotalLbl))
                .addGroup(whiteBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(whiteBGLayout.createSequentialGroup()
                        .addComponent(discount, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(total))
                    .addGroup(whiteBGLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(totalLbl))
                    .addComponent(DiscountLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(whiteBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(confirmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(whiteBG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(whiteBG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void foodCategoryComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_foodCategoryComboBoxActionPerformed
        Object selected = foodCategoryComboBox.getSelectedItem();
        if (selected == null) return;
        
        itemComboBox.removeAllItems();
        String sql = "SELECT food_id, item_name, price FROM food_items WHERE category = ? AND availability = 'Available' ORDER BY item_name ASC";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, selected.toString());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                itemComboBox.addItem(new FoodItemWrapper(
                    rs.getInt("food_id"), 
                    rs.getString("item_name"), 
                    rs.getDouble("price")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_foodCategoryComboBoxActionPerformed

    private void addToCartBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToCartBtnActionPerformed
       FoodItemWrapper selectedFood = (FoodItemWrapper) itemComboBox.getSelectedItem();
        if (selectedFood == null) return;

        DefaultTableModel model = (DefaultTableModel) currentOrderTable.getModel();

        for (int i = 0; i < model.getRowCount(); i++) {
            Object idValue = model.getValueAt(i, 0); 
            if (idValue != null && (int)idValue == selectedFood.id) {
                int currentQty = Integer.parseInt(model.getValueAt(i, 3).toString()); 
                model.setValueAt(currentQty + 1, i, 3); 
                return;
            }
        }
        
        Object[] rowData = {
            selectedFood.id,    
            selectedFood.name,  
            selectedFood.price, 
            1,                  
            selectedFood.price, 
            "Remove"           
        };
        model.addRow(rowData);
        recalculateCartTotal();          
    }//GEN-LAST:event_addToCartBtnActionPerformed

    private void confirmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmBtnActionPerformed
        DefaultTableModel model = (DefaultTableModel) currentOrderTable.getModel();
        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "This order is empty! Kindly add items to cart before confirming.");
            return;
        }
        
        String method = dineInBtn.isSelected() ? "Dine-In" : "Take-Out";
        String payment = cashBtn.isSelected() ? "CASH" : "CARD";
        
        String discountType = "None";
        if (SCDiscountBtn.isSelected()) {
            discountType = "Senior Citizen";
        } else if (PWDDiscountBtn.isSelected()) {
            discountType = "PWD";
        }

        double discountAmount = Double.parseDouble(DiscountLbl.getText().replace("₱", "").trim());
        double grandTotal = Double.parseDouble(totalLbl.getText().replace("₱", "").trim());

        String insertOrder = "INSERT INTO orders (order_method, payment_method, discount_type, discount_amount, total_amount, status, order_time) VALUES (?, ?, ?, ?, ?, 'Pending', NOW())";
        String insertItem = "INSERT INTO order_items (order_id, food_id, price, quantity) VALUES (?, ?, ?, ?)";

        try (Connection conn = Database.getConnection()) {
            conn.setAutoCommit(false); 

            try (PreparedStatement psOrder = conn.prepareStatement(insertOrder, Statement.RETURN_GENERATED_KEYS)) {
                psOrder.setString(1, method);
                psOrder.setString(2, payment);
                psOrder.setString(3, discountType);
                psOrder.setDouble(4, discountAmount);
                psOrder.setDouble(5, grandTotal);
                psOrder.executeUpdate();

                ResultSet generatedKeys = psOrder.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int nextOrderId = generatedKeys.getInt(1);

                    try (PreparedStatement psItem = conn.prepareStatement(insertItem)) {
                        for (int i = 0; i < model.getRowCount(); i++) {
                            int foodId = (int) model.getValueAt(i, 0);                                     
                            double price = Double.parseDouble(model.getValueAt(i, 2).toString());   
                            int qty = Integer.parseInt(model.getValueAt(i, 3).toString());         

                            psItem.setInt(1, nextOrderId);
                            psItem.setInt(2, foodId);
                            psItem.setDouble(3, price);
                            psItem.setInt(4, qty);
                            psItem.addBatch();
                        }
                        psItem.executeBatch();
                    }
                }
                conn.commit(); 
                JOptionPane.showMessageDialog(this, "Order Created!");
                
                this.dispose(); 
                if (parentPage != null) {
                    parentPage.loadOrdersTableFromDatabase(); 
                    parentPage.HeaderStats();                
                }
            } catch (Exception transactionEx) {
                conn.rollback(); 
                throw transactionEx;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error in Database: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_confirmBtnActionPerformed

    private void CancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_CancelBtnActionPerformed

    // MANUAL CODE
        private void setupDiscountToggleButton(javax.swing.JRadioButton button, javax.swing.ButtonGroup group) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (lastSelectedButton == button) {
                    group.clearSelection();
                    lastSelectedButton = null;
                } else {
                    lastSelectedButton = button;
                }
                recalculateCartTotal(); 
            }
        });
    }
    
    private void setupBasketTableListeners() {
        DefaultTableModel model = (DefaultTableModel) currentOrderTable.getModel();
        
        model.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE && e.getColumn() == 3) { 
                    int row = e.getFirstRow();
                    try {
                        int qty = Integer.parseInt(model.getValueAt(row, 3).toString());
                        if (qty <= 0) {
                            model.removeTableModelListener(this);
                            model.removeRow(row);
                            model.addTableModelListener(this);
                            recalculateCartTotal();
                            return;
                        }
                        double price = Double.parseDouble(model.getValueAt(row, 2).toString()); 
                        double subtotalVal = price * qty;
                        
                        model.removeTableModelListener(this);
                        model.setValueAt(subtotalVal, row, 4); 
                        model.addTableModelListener(this);
                        
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid numeric quantity.");
                        model.removeTableModelListener(this);
                        model.setValueAt(1, row, 3); 
                        model.addTableModelListener(this);
                    }
                    recalculateCartTotal();
                }
            }
        });

        currentOrderTable.getColumnModel().getColumn(5).setCellRenderer(new javax.swing.table.TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JButton btn = new JButton("Remove");
                btn.setBackground(new Color(220, 53, 69));
                btn.setForeground(Color.WHITE);
                return btn;
            }
        });

        currentOrderTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int column = currentOrderTable.getColumnModel().getColumnIndexAtX(e.getX());
                int row = currentOrderTable.rowAtPoint(e.getPoint());

                if (row >= 0 && row < currentOrderTable.getRowCount() && column == 5) {
                    ((DefaultTableModel) currentOrderTable.getModel()).removeRow(row);
                    recalculateCartTotal();
                }
            }
        });
    }

    private void recalculateCartTotal() {
        DefaultTableModel model = (DefaultTableModel) currentOrderTable.getModel();
        double baseSubtotal = 0.0;
        
        for (int i = 0; i < model.getRowCount(); i++) {
            baseSubtotal += Double.parseDouble(model.getValueAt(i, 4).toString()); 
        }
        double discountRate = 0.0;
        if (SCDiscountBtn.isSelected() || PWDDiscountBtn.isSelected()) {
            discountRate = 0.20;
        }
        double calculatedDiscount = baseSubtotal * discountRate;
        double finalGrandTotal = baseSubtotal - calculatedDiscount;
        
        if (finalGrandTotal < 0) finalGrandTotal = 0.0;

        subtotalLbl.setText(String.format("₱%.2f", baseSubtotal));
        DiscountLbl.setText(String.format("₱%.2f", calculatedDiscount));
        totalLbl.setText(String.format("₱%.2f", finalGrandTotal));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelBtn;
    private javax.swing.JLabel DiscountLbl;
    private javax.swing.JLabel Discounts;
    private javax.swing.JLabel FoodCategoryTxt;
    private javax.swing.JLabel ItemTxt;
    private javax.swing.JRadioButton PWDDiscountBtn;
    private javax.swing.JRadioButton SCDiscountBtn;
    private javax.swing.JLabel addAnOrder;
    private javax.swing.JButton addToCartBtn;
    private javax.swing.JRadioButton cardBtn;
    private javax.swing.JRadioButton cashBtn;
    private javax.swing.JButton confirmBtn;
    private javax.swing.JLabel currentOrderListTxt;
    private javax.swing.JTable currentOrderTable;
    private javax.swing.JRadioButton dineInBtn;
    private javax.swing.JLabel discount;
    private javax.swing.JComboBox<String> foodCategoryComboBox;
    private javax.swing.JComboBox<Object> itemComboBox;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel orderMethodTxt;
    private javax.swing.JLabel paymentMethodTxt1;
    private javax.swing.JLabel subtotal;
    private javax.swing.JLabel subtotalLbl;
    private javax.swing.JRadioButton takeOutBtn;
    private javax.swing.JLabel total;
    private javax.swing.JLabel totalLbl;
    private javax.swing.JPanel whiteBG;
    // End of variables declaration//GEN-END:variables
}
