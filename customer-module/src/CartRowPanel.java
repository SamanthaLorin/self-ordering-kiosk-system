public class CartRowPanel extends javax.swing.JPanel {
    private CartItems currentItem;
    private Runnable refreshParentCallback;
    
    public CartRowPanel(CartItems item, Runnable refreshAction) {
        initComponents();
        this.currentItem = item;
        this.refreshParentCallback = refreshAction;
        updateRowDisplay();
    }
    private void updateRowDisplay() {
        ItemName.setText(currentItem.getName());
        priceLbl.setText(String.format("₱%.2f", currentItem.getTotalPrice()));
        Quantity.setText(String.valueOf(currentItem.getQuantity())); 
        
        try {
            java.net.URL imgURL = getClass().getResource("/images/" + currentItem.getImageName());
            if (imgURL != null) {
                javax.swing.ImageIcon icon = new javax.swing.ImageIcon(imgURL);
                java.awt.Image img = icon.getImage().getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
                imgLbl.setIcon(new javax.swing.ImageIcon(img));
            }
        } catch (Exception e) { 
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imgLbl = new javax.swing.JLabel();
        ItemName = new javax.swing.JLabel();
        priceLbl = new javax.swing.JLabel();
        quantityTxt = new javax.swing.JLabel();
        addQtyBtn = new javax.swing.JButton();
        reduceQtyBtn = new javax.swing.JButton();
        Quantity = new javax.swing.JLabel();
        removeBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(imgLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 6, 100, 100));

        ItemName.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        ItemName.setForeground(new java.awt.Color(0, 0, 0));
        ItemName.setText("Untitled");
        add(ItemName, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 6, 163, 30));

        priceLbl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        priceLbl.setForeground(new java.awt.Color(0, 0, 0));
        priceLbl.setText("0.00 ");
        add(priceLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 42, 163, 32));

        quantityTxt.setFont(new java.awt.Font("Trebuchet MS", 1, 13)); // NOI18N
        quantityTxt.setForeground(new java.awt.Color(0, 0, 0));
        quantityTxt.setText("Quantity");
        add(quantityTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 76, -1, 30));

        addQtyBtn.setBackground(new java.awt.Color(153, 153, 153));
        addQtyBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addQtyBtn.setForeground(new java.awt.Color(0, 0, 0));
        addQtyBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/addButton.png"))); // NOI18N
        addQtyBtn.setBorderPainted(false);
        addQtyBtn.setContentAreaFilled(false);
        addQtyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addQtyBtnActionPerformed(evt);
            }
        });
        add(addQtyBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 76, 36, 38));

        reduceQtyBtn.setBackground(new java.awt.Color(153, 153, 153));
        reduceQtyBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        reduceQtyBtn.setForeground(new java.awt.Color(0, 0, 0));
        reduceQtyBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/minusButton.png"))); // NOI18N
        reduceQtyBtn.setBorderPainted(false);
        reduceQtyBtn.setContentAreaFilled(false);
        reduceQtyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reduceQtyBtnActionPerformed(evt);
            }
        });
        add(reduceQtyBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 76, 36, 38));

        Quantity.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        Quantity.setForeground(new java.awt.Color(0, 0, 0));
        Quantity.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Quantity.setText("0");
        add(Quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 76, 25, 38));

        removeBtn.setBackground(new java.awt.Color(112, 40, 58));
        removeBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        removeBtn.setForeground(new java.awt.Color(255, 255, 255));
        removeBtn.setText("Remove Item");
        removeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeBtnActionPerformed(evt);
            }
        });
        add(removeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 76, 115, 38));
    }// </editor-fold>//GEN-END:initComponents

    private void addQtyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addQtyBtnActionPerformed
        CartManager.getInstance().updateQuantityUp(currentItem.getFoodId());
        updateRowDisplay();
        if (refreshParentCallback != null) {
            refreshParentCallback.run();
        }
    }//GEN-LAST:event_addQtyBtnActionPerformed

    private void reduceQtyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reduceQtyBtnActionPerformed
        CartManager.getInstance().updateQuantityDown(currentItem.getFoodId());
        updateRowDisplay();
        if (refreshParentCallback != null) {
            refreshParentCallback.run();
        }
    }//GEN-LAST:event_reduceQtyBtnActionPerformed

    private void removeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeBtnActionPerformed
        CartManager.getInstance().removeItem(currentItem.getFoodId());
        if (refreshParentCallback != null) {
            refreshParentCallback.run();
        }
    }//GEN-LAST:event_removeBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ItemName;
    private javax.swing.JLabel Quantity;
    private javax.swing.JButton addQtyBtn;
    private javax.swing.JLabel imgLbl;
    private javax.swing.JLabel priceLbl;
    private javax.swing.JLabel quantityTxt;
    private javax.swing.JButton reduceQtyBtn;
    private javax.swing.JButton removeBtn;
    // End of variables declaration//GEN-END:variables
}
