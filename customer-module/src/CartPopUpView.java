
public class CartPopUpView extends javax.swing.JDialog {
    private java.util.ArrayList<CartItems> localCart;
 

    public CartPopUpView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setSize(345, 429);
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
        Header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        totalTxt = new javax.swing.JLabel();
        totalLbl = new javax.swing.JLabel();
        CloseCartBtn = new javax.swing.JButton();
        CheckoutBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        cartContainer = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        Header.setBackground(new java.awt.Color(112, 40, 58));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("MY CART");

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );

        totalTxt.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        totalTxt.setForeground(new java.awt.Color(0, 0, 0));
        totalTxt.setText("TOTAL:");

        totalLbl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        totalLbl.setForeground(new java.awt.Color(112, 40, 58));
        totalLbl.setText("₱0.00");

        CloseCartBtn.setBackground(new java.awt.Color(112, 40, 58));
        CloseCartBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        CloseCartBtn.setForeground(new java.awt.Color(255, 255, 255));
        CloseCartBtn.setText("Close Cart");
        CloseCartBtn.setBorderPainted(false);
        CloseCartBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseCartBtnActionPerformed(evt);
            }
        });

        CheckoutBtn.setBackground(new java.awt.Color(112, 40, 58));
        CheckoutBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        CheckoutBtn.setForeground(new java.awt.Color(255, 255, 255));
        CheckoutBtn.setText("Checkout");
        CheckoutBtn.setBorderPainted(false);
        CheckoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckoutBtnActionPerformed(evt);
            }
        });

        cartContainer.setBackground(new java.awt.Color(255, 255, 255));
        cartContainer.setLayout(new javax.swing.BoxLayout(cartContainer, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(cartContainer);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(CloseCartBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(totalTxt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(totalLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(CheckoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(totalTxt)
                        .addComponent(totalLbl))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CloseCartBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CheckoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
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

    private void CloseCartBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseCartBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_CloseCartBtnActionPerformed

    private void CheckoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckoutBtnActionPerformed
        java.awt.Window parentWindow = javax.swing.SwingUtilities.getWindowAncestor(this);
        this.dispose();
        CheckoutPopUpView checkoutDialog = new CheckoutPopUpView((java.awt.Frame) this.getParent(), true);
        checkoutDialog.setVisible(true);
    }//GEN-LAST:event_CheckoutBtnActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CartPopUpView dialog = new CartPopUpView(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CheckoutBtn;
    private javax.swing.JButton CloseCartBtn;
    private javax.swing.JPanel Header;
    private javax.swing.JPanel cartContainer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel totalLbl;
    private javax.swing.JLabel totalTxt;
    // End of variables declaration//GEN-END:variables
}
