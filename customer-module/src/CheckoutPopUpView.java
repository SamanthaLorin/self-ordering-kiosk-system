
public class CheckoutPopUpView extends javax.swing.JDialog {

    public CheckoutPopUpView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setSize(400, 180);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        Text1 = new javax.swing.JLabel();
        Text2 = new javax.swing.JLabel();
        ProceedToCheckout = new javax.swing.JButton();
        BackToCart = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(112, 40, 58));

        Text1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        Text1.setForeground(new java.awt.Color(255, 255, 255));
        Text1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Text1.setText("Are you sure you want to");

        Text2.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        Text2.setForeground(new java.awt.Color(255, 255, 255));
        Text2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Text2.setText("proceed to checkout?");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Text1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Text2, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Text1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Text2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 80));

        ProceedToCheckout.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        ProceedToCheckout.setForeground(new java.awt.Color(0, 0, 0));
        ProceedToCheckout.setText("Yes, proceed to checkout");
        ProceedToCheckout.setToolTipText("");
        ProceedToCheckout.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 3));
        ProceedToCheckout.setContentAreaFilled(false);
        ProceedToCheckout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProceedToCheckoutActionPerformed(evt);
            }
        });
        jPanel1.add(ProceedToCheckout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 400, 50));

        BackToCart.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        BackToCart.setForeground(new java.awt.Color(0, 0, 0));
        BackToCart.setText("No, continue browsing");
        BackToCart.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 3));
        BackToCart.setContentAreaFilled(false);
        BackToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackToCartActionPerformed(evt);
            }
        });
        jPanel1.add(BackToCart, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 400, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ProceedToCheckoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProceedToCheckoutActionPerformed
        java.awt.Window parentWindow = javax.swing.SwingUtilities.getWindowAncestor(this);
        Checkout nextPage = new Checkout();
        nextPage.setVisible(true);
        dispose();
        if (parentWindow != null) {
            parentWindow.dispose();
        }
    }//GEN-LAST:event_ProceedToCheckoutActionPerformed

    private void BackToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackToCartActionPerformed
        this.dispose();
        CartPopUpView cartDialog = new CartPopUpView((java.awt.Frame) this.getParent(), true);
        cartDialog.setVisible(true);
    }//GEN-LAST:event_BackToCartActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CheckoutPopUpView dialog = new CheckoutPopUpView(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton BackToCart;
    private javax.swing.JButton ProceedToCheckout;
    private javax.swing.JLabel Text1;
    private javax.swing.JLabel Text2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
