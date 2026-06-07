// Deprecated checkout page. No longer in use.

public class CheckOutPage extends javax.swing.JFrame {
    private java.util.ArrayList<CartItems> localCart;
  
    public CheckOutPage() {
        initComponents();
        this.setSize(455, 845);
        this.setLocationRelativeTo(null);
        displayCartItems();
    }
    
    private void displayCartItems() {
        cartContainer.removeAll();
        cartContainer.setLayout(new javax.swing.BoxLayout(cartContainer, javax.swing.BoxLayout.Y_AXIS));
    
        for (CartItems item : CartManager.getInstance().getCartList()) {
            CartRowPanel row = new CartRowPanel(item, () -> displayCartItems());
            cartContainer.add(row);
        }

        float grandTotal = CartManager.getInstance().calculateTotal();
        totalLbl.setText(String.format("₱%.2f", grandTotal));
        cartContainer.revalidate();
        cartContainer.repaint();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TotalTxt = new javax.swing.JLabel();
        totalLbl = new javax.swing.JLabel();
        CheckoutBtn = new javax.swing.JButton();
        goBackBtn = new javax.swing.JButton();
        GrayRectangle = new javax.swing.JLabel();
        Header = new javax.swing.JPanel();
        HeaderTxt = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cartContainer = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        TotalTxt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TotalTxt.setForeground(new java.awt.Color(0, 0, 0));
        TotalTxt.setText("Total:");

        totalLbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        totalLbl.setForeground(new java.awt.Color(0, 0, 0));
        totalLbl.setText("₱0.00");

        CheckoutBtn.setBackground(new java.awt.Color(112, 40, 58));
        CheckoutBtn.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        CheckoutBtn.setForeground(new java.awt.Color(255, 255, 255));
        CheckoutBtn.setText("Checkout");
        CheckoutBtn.setBorderPainted(false);
        CheckoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckoutBtnActionPerformed(evt);
            }
        });

        goBackBtn.setBackground(new java.awt.Color(112, 40, 58));
        goBackBtn.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        goBackBtn.setForeground(new java.awt.Color(255, 255, 255));
        goBackBtn.setText("Go Back");
        goBackBtn.setBorderPainted(false);
        goBackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBackBtnActionPerformed(evt);
            }
        });

        GrayRectangle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/CartRectangle.png"))); // NOI18N

        Header.setBackground(new java.awt.Color(112, 40, 58));

        HeaderTxt.setFont(new java.awt.Font("Microsoft PhagsPa", 1, 36)); // NOI18N
        HeaderTxt.setForeground(new java.awt.Color(255, 255, 255));
        HeaderTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        HeaderTxt.setText("TOTAL ITEMS");

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(HeaderTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(HeaderTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        cartContainer.setBackground(new java.awt.Color(255, 255, 255));
        cartContainer.setLayout(new javax.swing.BoxLayout(cartContainer, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(cartContainer);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(GrayRectangle)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(goBackBtn)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addComponent(CheckoutBtn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(totalLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(TotalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(CheckoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(totalLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(TotalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(GrayRectangle, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(goBackBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
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

    private void goBackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackBtnActionPerformed
        Menu nextPage = new Menu();
        nextPage.setVisible(true);
        dispose();
    }//GEN-LAST:event_goBackBtnActionPerformed

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
        PaymentOptionPage nextPage = new PaymentOptionPage();
        nextPage.setVisible(true);
        dispose();
    }//GEN-LAST:event_CheckoutBtnActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CheckOutPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CheckoutBtn;
    private javax.swing.JLabel GrayRectangle;
    private javax.swing.JPanel Header;
    private javax.swing.JLabel HeaderTxt;
    private javax.swing.JLabel TotalTxt;
    private javax.swing.JPanel cartContainer;
    private javax.swing.JButton goBackBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel totalLbl;
    // End of variables declaration//GEN-END:variables
}
