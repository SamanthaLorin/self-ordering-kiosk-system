public class ModeOfOrderPage extends javax.swing.JFrame {

    public ModeOfOrderPage() {
        initComponents();
        this.setSize(445, 800);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        DineInBtn = new javax.swing.JButton();
        TakeOutBtn = new javax.swing.JButton();
        BackgroundImg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DineInBtn.setBorderPainted(false);
        DineInBtn.setContentAreaFilled(false);
        DineInBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DineInBtnActionPerformed(evt);
            }
        });
        jPanel1.add(DineInBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, 230, 190));

        TakeOutBtn.setBorderPainted(false);
        TakeOutBtn.setContentAreaFilled(false);
        TakeOutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TakeOutBtnActionPerformed(evt);
            }
        });
        jPanel1.add(TakeOutBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 500, 230, 180));

        BackgroundImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/Mode of Order Page.png"))); // NOI18N
        jPanel1.add(BackgroundImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 800));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DineInBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DineInBtnActionPerformed
        CartManager.orderMethod = "Dine-In";    // Sets the order type to "Dine-In"
        Menu nextPage = new Menu();
        nextPage.setVisible(true);
        dispose();
    }//GEN-LAST:event_DineInBtnActionPerformed

    private void TakeOutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TakeOutBtnActionPerformed
        CartManager.orderMethod = "Take-Out";   //Sets the order type to "Take-Out"
        Menu nextPage = new Menu();
        nextPage.setVisible(true);
        dispose();
    }//GEN-LAST:event_TakeOutBtnActionPerformed

    public static void main(String args[]) {
  
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModeOfOrderPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackgroundImg;
    private javax.swing.JButton DineInBtn;
    private javax.swing.JButton TakeOutBtn;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
