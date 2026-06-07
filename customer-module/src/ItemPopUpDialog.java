public class ItemPopUpDialog extends javax.swing.JDialog {
    
    private int Quantity = 1;
    private boolean isAddedToCart = false;
    private int foodId;
    private String itemName;
    private String itemImageName;
    private float itemPrice;


    public ItemPopUpDialog(java.awt.Frame parent, boolean modal, int foodId, String itemName, float itemPrice, String itemImageName) {
        super(parent, modal);
        initComponents();
        this.foodId = foodId; 
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemImageName = itemImageName;
        this.setSize(415, 195);
        this.setLocationRelativeTo(null);
        
        ItemName.setText(itemName); 
        priceLbl.setText(String.format("₱%.2f", itemPrice));
        itemAmountLbl.setText(String.valueOf(Quantity));
        
        try {
        java.net.URL imgURL = getClass().getResource("/images/" + itemImageName);       //Ita-try niyang i-call yung images (dapat tugma yung name) ng nasa iamges package)
        if (imgURL != null) {
            javax.swing.ImageIcon icon = new javax.swing.ImageIcon(imgURL);
            java.awt.Image img = icon.getImage().getScaledInstance(
                imgLbl.getWidth() > 0 ? imgLbl.getWidth() : 110, 
                imgLbl.getHeight() > 0 ? imgLbl.getHeight() : 110, 
                java.awt.Image.SCALE_SMOOTH
            );
            imgLbl.setIcon(new javax.swing.ImageIcon(img));
        } else {
            System.out.println("Could not find image: " + itemImageName);           // Most likely, mali yung name/spelling or Wala naimport na ganong item.
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        imgLbl = new javax.swing.JLabel();
        ItemName = new javax.swing.JLabel();
        priceLbl = new javax.swing.JLabel();
        quantityTxt = new javax.swing.JLabel();
        addQtyBtn = new javax.swing.JButton();
        reduceQtyBtn = new javax.swing.JButton();
        itemAmountLbl = new javax.swing.JLabel();
        addToCartBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        ItemName.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        ItemName.setForeground(new java.awt.Color(0, 0, 0));
        ItemName.setText("Untitled");

        priceLbl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        priceLbl.setForeground(new java.awt.Color(0, 0, 0));
        priceLbl.setText("0.00 ");

        quantityTxt.setFont(new java.awt.Font("Trebuchet MS", 1, 13)); // NOI18N
        quantityTxt.setForeground(new java.awt.Color(0, 0, 0));
        quantityTxt.setText("Quantity");

        addQtyBtn.setBackground(new java.awt.Color(153, 153, 153));
        addQtyBtn.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        addQtyBtn.setForeground(new java.awt.Color(0, 0, 0));
        addQtyBtn.setText("+");
        addQtyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addQtyBtnActionPerformed(evt);
            }
        });

        reduceQtyBtn.setBackground(new java.awt.Color(153, 153, 153));
        reduceQtyBtn.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        reduceQtyBtn.setForeground(new java.awt.Color(0, 0, 0));
        reduceQtyBtn.setText("-");
        reduceQtyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reduceQtyBtnActionPerformed(evt);
            }
        });

        itemAmountLbl.setBackground(new java.awt.Color(153, 153, 153));
        itemAmountLbl.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        itemAmountLbl.setForeground(new java.awt.Color(0, 0, 0));
        itemAmountLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        itemAmountLbl.setText("0");
        itemAmountLbl.setOpaque(true);

        addToCartBtn.setBackground(new java.awt.Color(112, 40, 58));
        addToCartBtn.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        addToCartBtn.setForeground(new java.awt.Color(255, 255, 255));
        addToCartBtn.setText("Add To Cart");
        addToCartBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToCartBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(imgLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(quantityTxt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(addQtyBtn)
                                .addGap(4, 4, 4)
                                .addComponent(itemAmountLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(reduceQtyBtn))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(priceLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(280, 280, 280)
                        .addComponent(addToCartBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(priceLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(quantityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(reduceQtyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(itemAmountLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(addQtyBtn))))))
                .addGap(10, 10, 10)
                .addComponent(addToCartBtn))
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

    private void reduceQtyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reduceQtyBtnActionPerformed
        if (Quantity > 1) {         // Condition: Bawal Mag-0 ang QTY kasi wala namang naga-add to cart ng zero items :> 
            Quantity--;
            itemAmountLbl.setText(String.valueOf(Quantity)); 
        }
    }//GEN-LAST:event_reduceQtyBtnActionPerformed

    private void addQtyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addQtyBtnActionPerformed
        Quantity++;                 
        itemAmountLbl.setText(String.valueOf(Quantity));
        
    }//GEN-LAST:event_addQtyBtnActionPerformed

    private void addToCartBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToCartBtnActionPerformed
        isAddedToCart = true;       // Boolean Check: Kapag na-add to cart --> yung 'variables' mapupunta kay CartManager. 
        this.dispose();
        CartManager.getInstance().addItem(foodId, itemName, itemPrice, Quantity, itemImageName);
    }//GEN-LAST:event_addToCartBtnActionPerformed

    public boolean isAdded() { 
        return isAddedToCart; 
    }
    
    public int getFinalQuantity() { 
        return Quantity; 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ItemName;
    private javax.swing.JButton addQtyBtn;
    private javax.swing.JButton addToCartBtn;
    private javax.swing.JLabel imgLbl;
    private javax.swing.JLabel itemAmountLbl;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel priceLbl;
    private javax.swing.JLabel quantityTxt;
    private javax.swing.JButton reduceQtyBtn;
    // End of variables declaration//GEN-END:variables
}
