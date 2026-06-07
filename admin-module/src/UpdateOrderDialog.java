import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class UpdateOrderDialog extends javax.swing.JDialog {
    private int orderId;
    private double currentSubtotal = 0.0; 
    
    public UpdateOrderDialog(java.awt.Frame parent, boolean modal, int orderId) {
        super(parent, modal);
        initComponents();
        this.orderId = orderId;
        this.setLocationRelativeTo(parent);

        loadOrderDetails();
        loadOrderItems();
        
        DiscountComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculateUpdatedTotals();
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        discount = new javax.swing.JLabel();
        DiscountLbl = new javax.swing.JLabel();
        subtotal = new javax.swing.JLabel();
        subtotalLbl = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        totalLbl = new javax.swing.JLabel();
        SaveBtn = new javax.swing.JButton();
        CancelBtn = new javax.swing.JButton();
        StatusComboBox = new javax.swing.JComboBox<>();
        PaymentMethodComboBox = new javax.swing.JComboBox<>();
        OrderMethodComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        ItemsTable = new javax.swing.JTable();
        DiscountComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(123, 72, 85));

        jLabel1.setFont(new java.awt.Font("Microsoft PhagsPa", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Update Order");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Order Details:");

        jLabel3.setFont(new java.awt.Font("Yu Gothic", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Items:");

        jLabel4.setFont(new java.awt.Font("Yu Gothic", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Order Method:");

        jLabel5.setFont(new java.awt.Font("Yu Gothic", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Payment Method:");

        jLabel6.setFont(new java.awt.Font("Yu Gothic", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Status:");

        jLabel7.setFont(new java.awt.Font("Yu Gothic", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Discount:");

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

        total.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        total.setForeground(new java.awt.Color(0, 0, 0));
        total.setText("Total:");

        totalLbl.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        totalLbl.setForeground(new java.awt.Color(123, 72, 85));
        totalLbl.setText("0.00");

        SaveBtn.setBackground(new java.awt.Color(123, 72, 85));
        SaveBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        SaveBtn.setForeground(new java.awt.Color(255, 255, 255));
        SaveBtn.setText("Save");
        SaveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveBtnActionPerformed(evt);
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

        StatusComboBox.setBackground(new java.awt.Color(232, 219, 179));
        StatusComboBox.setForeground(new java.awt.Color(0, 0, 0));
        StatusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pending", "In Progress", "Complete", "Cancelled" }));

        PaymentMethodComboBox.setBackground(new java.awt.Color(232, 219, 179));
        PaymentMethodComboBox.setForeground(new java.awt.Color(0, 0, 0));
        PaymentMethodComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash", "Card" }));

        OrderMethodComboBox.setBackground(new java.awt.Color(232, 219, 179));
        OrderMethodComboBox.setForeground(new java.awt.Color(0, 0, 0));
        OrderMethodComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dine-In", "Take-Out" }));

        ItemsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Food Item", "Quantity", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(ItemsTable);

        DiscountComboBox.setBackground(new java.awt.Color(232, 219, 179));
        DiscountComboBox.setForeground(new java.awt.Color(0, 0, 0));
        DiscountComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Senior Citizen", "PWD" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(50, 50, 50)
                                .addComponent(OrderMethodComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addComponent(PaymentMethodComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(subtotalLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(discount, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(DiscountLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(totalLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(SaveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(CancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(71, 71, 71)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(StatusComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(DiscountComboBox, 0, 208, Short.MAX_VALUE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(OrderMethodComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PaymentMethodComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(DiscountComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(subtotal)
                    .addComponent(subtotalLbl))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(discount, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DiscountLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(total)
                    .addComponent(totalLbl))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SaveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadOrderDetails() {
        String query = "SELECT order_method, payment_method, discount_type, discount_amount, total_amount, status FROM orders WHERE order_id = ?";
        
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setInt(1, this.orderId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    OrderMethodComboBox.setSelectedItem(rs.getString("order_method"));
                    PaymentMethodComboBox.setSelectedItem(rs.getString("payment_method"));
                    StatusComboBox.setSelectedItem(rs.getString("status"));
                    
                    double discountAmt = rs.getDouble("discount_amount");
                    double finalTotal = rs.getDouble("total_amount");
                    
                    this.currentSubtotal = finalTotal + discountAmt; 
                    
                    
                    String dbDiscountType = rs.getString("discount_type");
                    if (dbDiscountType == null || dbDiscountType.trim().isEmpty()) {
                        dbDiscountType = "None";
                    }
                    DiscountComboBox.setSelectedItem(dbDiscountType);

                    calculateUpdatedTotals();
                } else {
                    JOptionPane.showMessageDialog(this, "Order records not found.", "Database Error", JOptionPane.ERROR_MESSAGE);
                    this.dispose();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to connect to database: " + e.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadOrderItems() {
        String query = "SELECT f.item_name, oi.quantity, oi.price FROM order_items oi " +
                       "JOIN food_items f ON oi.food_id = f.food_id WHERE oi.order_id = ?";

        DefaultTableModel model = (DefaultTableModel) ItemsTable.getModel();
        model.setRowCount(0); 

        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, this.orderId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String foodName = rs.getString("item_name"); 
                    int qty = rs.getInt("quantity");
                    double price = rs.getDouble("price");
                    String formattedPrice = String.format("₱%.2f", price);

                    model.addRow(new Object[]{foodName, qty, formattedPrice});
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void calculateUpdatedTotals() {
        String selectedDiscount = DiscountComboBox.getSelectedItem().toString();
        double calculatedDiscount = 0.0;

        if ("Senior".equalsIgnoreCase(selectedDiscount) || 
        "Senior Citizen".equalsIgnoreCase(selectedDiscount) || 
        "SeniorCitizen".equalsIgnoreCase(selectedDiscount) || 
        "PWD".equalsIgnoreCase(selectedDiscount)) {
        
        calculatedDiscount = this.currentSubtotal * 0.20;
        } else if ("Student".equalsIgnoreCase(selectedDiscount)) {
            calculatedDiscount = this.currentSubtotal * 0.10;
        }

        double updatedTotal = this.currentSubtotal - calculatedDiscount;
 
        subtotalLbl.setText(String.format("₱%.2f", this.currentSubtotal));
        DiscountLbl.setText(String.format("₱%.2f", calculatedDiscount));
        totalLbl.setText(String.format("₱%.2f", updatedTotal));
    }
    
    private void SaveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveBtnActionPerformed
        String updateQuery = "UPDATE orders SET order_method = ?, payment_method = ?, status = ?, discount_type = ?, discount_amount = ?, total_amount = ? WHERE order_id = ?";
        
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {

            String selectedDiscountType = DiscountComboBox.getSelectedItem().toString();
            String rawDiscountText = DiscountLbl.getText().replace("₱", "").trim();
            String rawTotalText = totalLbl.getText().replace("₱", "").trim();
            
            double discountAmount = Double.parseDouble(rawDiscountText);
            double totalAmount = Double.parseDouble(rawTotalText);

            pstmt.setString(1, OrderMethodComboBox.getSelectedItem().toString());
            pstmt.setString(2, PaymentMethodComboBox.getSelectedItem().toString());
            pstmt.setString(3, StatusComboBox.getSelectedItem().toString());
            pstmt.setString(4, selectedDiscountType);
            pstmt.setDouble(5, discountAmount);
            pstmt.setDouble(6, totalAmount);
            pstmt.setInt(7, this.orderId);
            
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Order #" + this.orderId + " details & discounts updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                this.dispose(); 
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database update failed: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error processing numeric values: " + e.getMessage(), "Formatting Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_SaveBtnActionPerformed

    private void CancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_CancelBtnActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelBtn;
    private javax.swing.JComboBox<String> DiscountComboBox;
    private javax.swing.JLabel DiscountLbl;
    private javax.swing.JTable ItemsTable;
    private javax.swing.JComboBox<String> OrderMethodComboBox;
    private javax.swing.JComboBox<String> PaymentMethodComboBox;
    private javax.swing.JButton SaveBtn;
    private javax.swing.JComboBox<String> StatusComboBox;
    private javax.swing.JLabel discount;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel subtotal;
    private javax.swing.JLabel subtotalLbl;
    private javax.swing.JLabel total;
    private javax.swing.JLabel totalLbl;
    // End of variables declaration//GEN-END:variables
}
