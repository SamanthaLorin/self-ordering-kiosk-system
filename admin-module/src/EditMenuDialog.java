import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;

public class EditMenuDialog extends javax.swing.JDialog {
    private DefaultTableModel model;
    private int rowIdx;
    private String foodId;
    

    // Carries food item from MenuManagementPage
    public EditMenuDialog(java.awt.Frame parent, boolean modal, String id, String name, String price, String category, String availability, javax.swing.table.DefaultTableModel model, int rowIdx) {
        super(parent, modal);
        initComponents();
        this.setSize(530, 350);
        this.setLocationRelativeTo(null);
        
        this.model = model;
        this.rowIdx = rowIdx;
        this.foodId = id;
        
        changeNameTxtField.setText(name);
        changePriceTxtField.setText(price);
        categoriesComboBox.setSelectedItem(category.toUpperCase()); 
        AvailabilityComboBox.setSelectedItem(availability);
        setLocationRelativeTo(parent);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        editItemHeader = new javax.swing.JLabel();
        changeNameLbl = new javax.swing.JLabel();
        changeNameTxtField = new javax.swing.JTextField();
        changeNameLbl1 = new javax.swing.JLabel();
        changePriceTxtField = new javax.swing.JTextField();
        changeNameLbl2 = new javax.swing.JLabel();
        categoriesComboBox = new javax.swing.JComboBox<>();
        changeNameLbl3 = new javax.swing.JLabel();
        AvailabilityComboBox = new javax.swing.JComboBox<>();
        addBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        editItemHeader.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        editItemHeader.setForeground(new java.awt.Color(123, 72, 85));
        editItemHeader.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        editItemHeader.setText("Edit Item");

        changeNameLbl.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        changeNameLbl.setForeground(new java.awt.Color(51, 51, 51));
        changeNameLbl.setText("Change Name: ");

        changeNameLbl1.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        changeNameLbl1.setForeground(new java.awt.Color(51, 51, 51));
        changeNameLbl1.setText("New Price (₱):");

        changeNameLbl2.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        changeNameLbl2.setForeground(new java.awt.Color(51, 51, 51));
        changeNameLbl2.setText("Change Category:");

        categoriesComboBox.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        categoriesComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ULAM", "SILOG", "ADD-ONS", "DRINKS", " " }));

        changeNameLbl3.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        changeNameLbl3.setForeground(new java.awt.Color(51, 51, 51));
        changeNameLbl3.setText("Status:");

        AvailabilityComboBox.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        AvailabilityComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Available", "Not Available" }));

        addBtn.setBackground(new java.awt.Color(123, 72, 85));
        addBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addBtn.setForeground(new java.awt.Color(255, 255, 255));
        addBtn.setText("Confirm & Save");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        cancelBtn.setBackground(new java.awt.Color(123, 72, 85));
        cancelBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cancelBtn.setForeground(new java.awt.Color(255, 255, 255));
        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(editItemHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(changeNameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(changeNameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(changeNameLbl3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(AvailabilityComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(changeNameLbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(changePriceTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(changeNameLbl2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(categoriesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(63, 63, 63))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(editItemHeader)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(changeNameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(changeNameLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(changePriceTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(changeNameLbl1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(changeNameLbl3)
                    .addComponent(AvailabilityComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoriesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(changeNameLbl2))
                .addGap(14, 14, 14)
                .addComponent(addBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelBtn)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        String updatedName = changeNameTxtField.getText().trim();
        String updatedPrice = changePriceTxtField.getText().trim();
        String updatedCategory = categoriesComboBox.getSelectedItem().toString();
        String updatedAvail = AvailabilityComboBox.getSelectedItem().toString();

            if (updatedName.isEmpty() || updatedPrice.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill out all fields before saving.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String sql = "UPDATE food_items SET item_name=?, price=?, category=?, availability=? WHERE food_id=?";

            try (Connection conn = Database.getConnection();
                 java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, updatedName);
                pstmt.setDouble(2, Double.parseDouble(updatedPrice));
                pstmt.setString(3, updatedCategory.toUpperCase()); 
                pstmt.setString(4, updatedAvail);
                pstmt.setInt(5, Integer.parseInt(this.foodId)); 

                pstmt.executeUpdate(); 

                model.setValueAt(updatedName, rowIdx, 1);    
                model.setValueAt(updatedPrice, rowIdx, 2);   
                model.setValueAt(updatedCategory, rowIdx, 3);
                model.setValueAt(updatedAvail, rowIdx, 4);   

                this.dispose();
                JOptionPane.showMessageDialog(this, "Menu changes successfully updated in the database!");

            } catch (java.sql.SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Database Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid number for the price.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
    }//GEN-LAST:event_addBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> AvailabilityComboBox;
    private javax.swing.JButton addBtn;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JComboBox<String> categoriesComboBox;
    private javax.swing.JLabel changeNameLbl;
    private javax.swing.JLabel changeNameLbl1;
    private javax.swing.JLabel changeNameLbl2;
    private javax.swing.JLabel changeNameLbl3;
    private javax.swing.JTextField changeNameTxtField;
    private javax.swing.JTextField changePriceTxtField;
    private javax.swing.JLabel editItemHeader;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
