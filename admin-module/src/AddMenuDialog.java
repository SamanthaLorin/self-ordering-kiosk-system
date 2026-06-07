import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class AddMenuDialog extends javax.swing.JDialog {
    private DefaultTableModel tableModel;

    public AddMenuDialog(java.awt.Frame parent, boolean modal, DefaultTableModel tableModel) {
        super(parent, modal);
        this.tableModel = tableModel; 
        initComponents();
        this.setSize(540, 350);
        this.setLocationRelativeTo(parent); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        StatusLbl = new javax.swing.JLabel();
        AvailabilityComboBox = new javax.swing.JComboBox<>();
        addItemBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        editItemHeader = new javax.swing.JLabel();
        AddItemNameLbl = new javax.swing.JLabel();
        AddItemNameTxtField = new javax.swing.JTextField();
        AddPriceLbl1 = new javax.swing.JLabel();
        AddPriceTxtField = new javax.swing.JTextField();
        CategoryLbl = new javax.swing.JLabel();
        categoriesComboBox = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        StatusLbl.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        StatusLbl.setForeground(new java.awt.Color(51, 51, 51));
        StatusLbl.setText("Status:");
        jPanel1.add(StatusLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 167, 119, -1));

        AvailabilityComboBox.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        AvailabilityComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Available", "Not Available" }));
        jPanel1.add(AvailabilityComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 165, 317, -1));

        addItemBtn.setBackground(new java.awt.Color(123, 72, 85));
        addItemBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addItemBtn.setForeground(new java.awt.Color(255, 255, 255));
        addItemBtn.setText("Add New Item");
        addItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addItemBtnActionPerformed(evt);
            }
        });
        jPanel1.add(addItemBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 243, 162, -1));

        cancelBtn.setBackground(new java.awt.Color(123, 72, 85));
        cancelBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cancelBtn.setForeground(new java.awt.Color(255, 255, 255));
        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });
        jPanel1.add(cancelBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(237, 276, 112, -1));

        editItemHeader.setFont(new java.awt.Font("Microsoft PhagsPa", 1, 24)); // NOI18N
        editItemHeader.setForeground(new java.awt.Color(255, 255, 255));
        editItemHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        editItemHeader.setText("Add Item");
        jPanel1.add(editItemHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 5, 500, 40));

        AddItemNameLbl.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        AddItemNameLbl.setForeground(new java.awt.Color(51, 51, 51));
        AddItemNameLbl.setText("Item Name:");
        jPanel1.add(AddItemNameLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 67, 109, -1));
        jPanel1.add(AddItemNameTxtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 57, 337, 36));

        AddPriceLbl1.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        AddPriceLbl1.setForeground(new java.awt.Color(51, 51, 51));
        AddPriceLbl1.setText("Price (₱):");
        jPanel1.add(AddPriceLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 118, 109, -1));
        jPanel1.add(AddPriceTxtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 111, 337, 36));

        CategoryLbl.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        CategoryLbl.setForeground(new java.awt.Color(51, 51, 51));
        CategoryLbl.setText("Choose a Category");
        jPanel1.add(CategoryLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 205, 129, -1));

        categoriesComboBox.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        categoriesComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ULAM", "SILOG", "ADD-ONS", "DRINKS", " " }));
        jPanel1.add(categoriesComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 203, 285, -1));

        jPanel2.setBackground(new java.awt.Color(123, 72, 85));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItemBtnActionPerformed
        String name = AddItemNameTxtField.getText().trim();
        String priceText = AddPriceTxtField.getText().trim();
        String availability = AvailabilityComboBox.getSelectedItem().toString();
        String category = categoriesComboBox.getSelectedItem().toString();

        if (name.isEmpty() || priceText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fulfill all required fields!", "Incomplete Fields", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Condition: If an itemName is already in the system, it cannot be added anymore. 
        if (isItemDuplicate(name)) {
            JOptionPane.showMessageDialog(this, "The item '" + name + "' already exists in the menu!", "Duplicate Item", JOptionPane.ERROR_MESSAGE);
            return; // Stops execution so the duplicate isn't added
        }

        double price;
        try {
            price = Double.parseDouble(priceText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid decimal number for the price.", "Invalid Price", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int generatedId = generateFoodIdByCategory(category);

        // Database Code
        String sql = "INSERT INTO food_items (food_id, item_name, price, category, availability) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, generatedId);
            pstmt.setString(2, name);
            pstmt.setDouble(3, price);
            pstmt.setString(4, category);
            pstmt.setString(5, availability);

            pstmt.executeUpdate();

            tableModel.addRow(new Object[]{generatedId, name, price, category, availability, ""});

            JOptionPane.showMessageDialog(this, "Successfully added " + name + " (ID: " + generatedId + ")!");
            this.dispose(); 

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database Error: " + e.getMessage(), "Execution Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_addItemBtnActionPerformed

    private boolean isItemDuplicate(String itemName) {
        String sql = "SELECT COUNT(*) FROM food_items WHERE LOWER(item_name) = LOWER(?)";
        
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, itemName);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0; 
                }
            }
        } catch (Exception e) {
            System.out.println("Error validating unique food name: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
    
    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
       this.dispose();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private int generateFoodIdByCategory(String category) {
        int baseId = 1000;
        if (category.equals("SILOG")) baseId = 2000;
        else if (category.equals("ADD-ONS")) baseId = 3000;
        else if (category.equals("DRINKS")) baseId = 4000;

        String query = "SELECT MAX(food_id) FROM food_items WHERE category = '" + category + "'";
        
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
             
            if (rs.next()) {
                int maxId = rs.getInt(1);
                if (maxId > 0) {
                    return maxId + 1; 
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return baseId + 1; 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AddItemNameLbl;
    private javax.swing.JTextField AddItemNameTxtField;
    private javax.swing.JLabel AddPriceLbl1;
    private javax.swing.JTextField AddPriceTxtField;
    private javax.swing.JComboBox<String> AvailabilityComboBox;
    private javax.swing.JLabel CategoryLbl;
    private javax.swing.JLabel StatusLbl;
    private javax.swing.JButton addItemBtn;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JComboBox<String> categoriesComboBox;
    private javax.swing.JLabel editItemHeader;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
