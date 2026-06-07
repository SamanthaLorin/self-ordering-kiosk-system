import java.awt.event.*;

public class Checkout extends javax.swing.JFrame {
    private java.util.ArrayList<CartItems> localCart;
    private javax.swing.JRadioButton lastSelectedButton = null;
  
    public Checkout() {
        initComponents();
        this.setSize(460, 840);
        this.setLocationRelativeTo(null);

        // RadioButtons Group
        javax.swing.ButtonGroup discountGroup = new javax.swing.ButtonGroup();
        discountGroup.add(SCDiscountBtn);
        discountGroup.add(PWDDiscountBtn);
        discountGroup.clearSelection();
        setupDiscountToggleButton(SCDiscountBtn, discountGroup);
        setupDiscountToggleButton(PWDDiscountBtn, discountGroup);
        
        displayCartItems();
    }
    
    private void displayCartItems() {
        cartContainer.removeAll();
        cartContainer.setLayout(new javax.swing.BoxLayout(cartContainer, javax.swing.BoxLayout.Y_AXIS));
    
        for (CartItems item : CartManager.getInstance().getCartList()) {
            CartRowPanel row = new CartRowPanel(item, () -> displayCartItems());
            cartContainer.add(row);
        }

        updatePrice();
        cartContainer.revalidate();
        cartContainer.repaint();
    }
    
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
                updatePrice();
            }
        });
    }

    private void updatePrice() {
        float subtotal = CartManager.getInstance().calculateTotal();
        float discountRate = 0.0f;
        
        if (SCDiscountBtn.isSelected() || PWDDiscountBtn.isSelected()) {
            discountRate = 0.20f;
        }
        
        float discountAmount = subtotal * discountRate;
        float finalTotal = subtotal - discountAmount;
        
        SubtotalTxt.setText(String.format("₱%.2f", subtotal));
        DiscountTxt.setText(String.format("₱%.2f", discountAmount));
        totalLbl.setText(String.format("₱%.2f", finalTotal));
        
        if (totalLbl != null) {
            totalLbl.setText(String.format("₱%.2f", finalTotal));
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        goBackBtn = new javax.swing.JButton();
        CancelBtn = new javax.swing.JButton();
        CheckoutBtn = new javax.swing.JButton();
        totalLbl = new javax.swing.JLabel();
        TotalTxt = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        HeaderTxt = new javax.swing.JLabel();
        Txt1 = new javax.swing.JLabel();
        Txt2 = new javax.swing.JLabel();
        SubtotalTxt = new javax.swing.JLabel();
        DiscountTxt = new javax.swing.JLabel();
        AvailableDiscounts = new javax.swing.JLabel();
        SCDiscountBtn = new javax.swing.JRadioButton();
        PWDDiscountBtn = new javax.swing.JRadioButton();
        greyRectangle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cartContainer = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        goBackBtn.setBackground(new java.awt.Color(112, 40, 58));
        goBackBtn.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        goBackBtn.setForeground(new java.awt.Color(255, 255, 255));
        goBackBtn.setText("Go Back");
        goBackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBackBtnActionPerformed(evt);
            }
        });
        jPanel1.add(goBackBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 700, 110, 40));

        CancelBtn.setBackground(new java.awt.Color(112, 40, 58));
        CancelBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        CancelBtn.setForeground(new java.awt.Color(255, 255, 255));
        CancelBtn.setText("Cancel Order");
        CancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBtnActionPerformed(evt);
            }
        });
        jPanel1.add(CancelBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 750, 110, 40));

        CheckoutBtn.setBackground(new java.awt.Color(112, 40, 58));
        CheckoutBtn.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        CheckoutBtn.setForeground(new java.awt.Color(255, 255, 255));
        CheckoutBtn.setText("Checkout");
        CheckoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckoutBtnActionPerformed(evt);
            }
        });
        jPanel1.add(CheckoutBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 700, 120, 90));

        totalLbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        totalLbl.setForeground(new java.awt.Color(0, 0, 0));
        totalLbl.setText("₱0.00");
        jPanel1.add(totalLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 760, 90, 30));

        TotalTxt.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TotalTxt.setForeground(new java.awt.Color(0, 0, 0));
        TotalTxt.setText("Total:");
        jPanel1.add(TotalTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 760, 50, 30));

        jPanel2.setBackground(new java.awt.Color(112, 40, 58));

        HeaderTxt.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        HeaderTxt.setForeground(new java.awt.Color(255, 255, 255));
        HeaderTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        HeaderTxt.setText("TOTAL ITEMS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HeaderTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(HeaderTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, -1));

        Txt1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Txt1.setForeground(new java.awt.Color(0, 0, 0));
        Txt1.setText("Subtotal:");
        jPanel1.add(Txt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 700, 70, 30));

        Txt2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Txt2.setForeground(new java.awt.Color(0, 0, 0));
        Txt2.setText("Discount:");
        jPanel1.add(Txt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 730, 70, 30));

        SubtotalTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        SubtotalTxt.setForeground(new java.awt.Color(0, 0, 0));
        SubtotalTxt.setText("₱0.00");
        jPanel1.add(SubtotalTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 700, 80, 30));

        DiscountTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DiscountTxt.setForeground(new java.awt.Color(0, 0, 0));
        DiscountTxt.setText("₱0.00");
        jPanel1.add(DiscountTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 730, 90, 30));

        AvailableDiscounts.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        AvailableDiscounts.setForeground(new java.awt.Color(112, 40, 58));
        AvailableDiscounts.setText("Available Discounts:");
        jPanel1.add(AvailableDiscounts, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 630, 160, 20));

        SCDiscountBtn.setForeground(new java.awt.Color(0, 0, 0));
        SCDiscountBtn.setText("Senior Citizen Discount (20%)");
        jPanel1.add(SCDiscountBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 660, 210, -1));

        PWDDiscountBtn.setForeground(new java.awt.Color(0, 0, 0));
        PWDDiscountBtn.setText("PWD Discount (20%)");
        jPanel1.add(PWDDiscountBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 660, 200, -1));

        greyRectangle.setBackground(new java.awt.Color(204, 204, 204));
        greyRectangle.setOpaque(true);
        jPanel1.add(greyRectangle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 690, 450, 110));

        cartContainer.setBackground(new java.awt.Color(255, 255, 255));
        cartContainer.setLayout(new javax.swing.BoxLayout(cartContainer, javax.swing.BoxLayout.LINE_AXIS));
        jScrollPane1.setViewportView(cartContainer);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 450, 490));

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

    private void goBackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackBtnActionPerformed
        Menu nextPage = new Menu();
        nextPage.setVisible(true);
        dispose();
    }//GEN-LAST:event_goBackBtnActionPerformed

    private void CancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtnActionPerformed
        ModeOfOrderPage nextPage = new ModeOfOrderPage();
        nextPage.setVisible(true);
        dispose();
        CartManager.getInstance().clearCart();
    }//GEN-LAST:event_CancelBtnActionPerformed

    private void CheckoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckoutBtnActionPerformed
        if (CartManager.getInstance().getCartList().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(
                this, 
                "Your cart is empty! Please add items to your cart before checking out.", 
                "Empty Cart", 
                javax.swing.JOptionPane.WARNING_MESSAGE
            );
            return; 
        }

        String discountName = "";
        if (SCDiscountBtn.isSelected()) {
            discountName = "Senior Citizen";
        } else if (PWDDiscountBtn.isSelected()) {
            discountName = "PWD";
        }

        float subtotal = CartManager.getInstance().calculateTotal();
        float discountRate = (!discountName.isEmpty()) ? 0.20f : 0.0f;
        
        CartManager.discountType = discountName;               
        CartManager.discountAmount = subtotal * discountRate;  


        if (!discountName.isEmpty()) {
            String message = "You've selected the " + discountName + " discount.\n"
                           + "Please provide your ID on the counter for verification.";
            
            int choice = javax.swing.JOptionPane.showConfirmDialog(
                this, 
                message, 
                "Discount Verification Required", 
                javax.swing.JOptionPane.OK_CANCEL_OPTION, 
                javax.swing.JOptionPane.INFORMATION_MESSAGE
            );
            
            if (choice != javax.swing.JOptionPane.OK_OPTION) {
                return; 
            }
        }

        PaymentOptionPage nextPage = new PaymentOptionPage();
        nextPage.setVisible(true);
        dispose();
    }//GEN-LAST:event_CheckoutBtnActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Checkout().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AvailableDiscounts;
    private javax.swing.JButton CancelBtn;
    private javax.swing.JButton CheckoutBtn;
    private javax.swing.JLabel DiscountTxt;
    private javax.swing.JLabel HeaderTxt;
    private javax.swing.JRadioButton PWDDiscountBtn;
    private javax.swing.JRadioButton SCDiscountBtn;
    private javax.swing.JLabel SubtotalTxt;
    private javax.swing.JLabel TotalTxt;
    private javax.swing.JLabel Txt1;
    private javax.swing.JLabel Txt2;
    private javax.swing.JPanel cartContainer;
    private javax.swing.JButton goBackBtn;
    private javax.swing.JLabel greyRectangle;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel totalLbl;
    // End of variables declaration//GEN-END:variables
}
