
public class StartUpPage extends javax.swing.JFrame {

    public StartUpPage() {
        initComponents();
        this.setSize(445, 800);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TapToOrder_btn = new javax.swing.JButton();
        BGImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TapToOrder_btn.setBorderPainted(false);
        TapToOrder_btn.setContentAreaFilled(false);
        TapToOrder_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TapToOrder_btnActionPerformed(evt);
            }
        });
        jPanel1.add(TapToOrder_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 480, 240, 60));

        BGImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/Start Up Page Background.png"))); // NOI18N
        jPanel1.add(BGImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 800));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TapToOrder_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TapToOrder_btnActionPerformed
        ModeOfOrderPage nextPage = new ModeOfOrderPage();
        nextPage.setVisible(true);
        dispose();
    }//GEN-LAST:event_TapToOrder_btnActionPerformed

  
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartUpPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BGImage;
    private javax.swing.JButton TapToOrder_btn;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
