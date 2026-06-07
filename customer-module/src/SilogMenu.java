import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SilogMenu extends javax.swing.JFrame {
    private float priceHotsilog = 100.00f;
    private float priceTapsilog = 130.00f;
    private float priceTocilog = 120.00f;
    private float priceBangsilog = 120.00f;
    
    private int idHatsilog = 2001;
    private int idTapsilog = 2002;
    private int idTocilog = 2003;
    private int idBangsilog = 2004;

    public SilogMenu() {
        initComponents();
        this.setSize(445, 835);
        this.setLocationRelativeTo(null);
        updateFooterTotal();
        updateKioskMenuFromDatabase();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Header = new javax.swing.JLabel();
        silogItem1 = new javax.swing.JLabel();
        silogItem2 = new javax.swing.JLabel();
        silogItem3 = new javax.swing.JLabel();
        silogItem4 = new javax.swing.JLabel();
        silogPrice1 = new javax.swing.JLabel();
        silogPrice2 = new javax.swing.JLabel();
        silogPrice3 = new javax.swing.JLabel();
        silogPrice4 = new javax.swing.JLabel();
        ulamBtn = new javax.swing.JButton();
        silogBtn = new javax.swing.JButton();
        addOnsBtn = new javax.swing.JButton();
        drinksBtn = new javax.swing.JButton();
        TotalTxt = new javax.swing.JLabel();
        totalLbl = new javax.swing.JLabel();
        CheckoutBtn = new javax.swing.JButton();
        ViewCartBtn = new javax.swing.JButton();
        goBackBtn = new javax.swing.JButton();
        greyRectangle = new javax.swing.JLabel();
        TapsilogBtn = new javax.swing.JButton();
        HotsilogBtn = new javax.swing.JButton();
        TocilogBtn = new javax.swing.JButton();
        BangsilogBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Header.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/Header.png"))); // NOI18N
        jPanel1.add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 161));

        silogItem1.setBackground(new java.awt.Color(239, 239, 239));
        silogItem1.setFont(new java.awt.Font("Trebuchet MS", 1, 10)); // NOI18N
        silogItem1.setForeground(new java.awt.Color(0, 0, 0));
        silogItem1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        silogItem1.setText("Tapsilog");
        silogItem1.setOpaque(true);
        jPanel1.add(silogItem1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 80, 20));

        silogItem2.setBackground(new java.awt.Color(239, 239, 239));
        silogItem2.setFont(new java.awt.Font("Trebuchet MS", 1, 10)); // NOI18N
        silogItem2.setForeground(new java.awt.Color(0, 0, 0));
        silogItem2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        silogItem2.setText("Hotsilog");
        silogItem2.setOpaque(true);
        jPanel1.add(silogItem2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, 80, 20));

        silogItem3.setBackground(new java.awt.Color(239, 239, 239));
        silogItem3.setFont(new java.awt.Font("Trebuchet MS", 1, 10)); // NOI18N
        silogItem3.setForeground(new java.awt.Color(0, 0, 0));
        silogItem3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        silogItem3.setText("Tocilog");
        silogItem3.setOpaque(true);
        jPanel1.add(silogItem3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 250, 80, 20));

        silogItem4.setBackground(new java.awt.Color(239, 239, 239));
        silogItem4.setFont(new java.awt.Font("Trebuchet MS", 1, 10)); // NOI18N
        silogItem4.setForeground(new java.awt.Color(0, 0, 0));
        silogItem4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        silogItem4.setText("Bangsilog");
        silogItem4.setOpaque(true);
        jPanel1.add(silogItem4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 80, 20));

        silogPrice1.setBackground(new java.awt.Color(239, 239, 239));
        silogPrice1.setFont(new java.awt.Font("Segoe UI", 1, 9)); // NOI18N
        silogPrice1.setForeground(new java.awt.Color(0, 0, 0));
        silogPrice1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        silogPrice1.setText("₱130.00");
        silogPrice1.setOpaque(true);
        jPanel1.add(silogPrice1, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 270, 80, -1));

        silogPrice2.setBackground(new java.awt.Color(239, 239, 239));
        silogPrice2.setFont(new java.awt.Font("Segoe UI", 1, 9)); // NOI18N
        silogPrice2.setForeground(new java.awt.Color(0, 0, 0));
        silogPrice2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        silogPrice2.setText("₱100.00");
        silogPrice2.setOpaque(true);
        jPanel1.add(silogPrice2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, 80, -1));

        silogPrice3.setBackground(new java.awt.Color(239, 239, 239));
        silogPrice3.setFont(new java.awt.Font("Segoe UI", 1, 9)); // NOI18N
        silogPrice3.setForeground(new java.awt.Color(0, 0, 0));
        silogPrice3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        silogPrice3.setText("₱120.00");
        silogPrice3.setOpaque(true);
        jPanel1.add(silogPrice3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 270, 80, -1));

        silogPrice4.setBackground(new java.awt.Color(239, 239, 239));
        silogPrice4.setFont(new java.awt.Font("Segoe UI", 1, 9)); // NOI18N
        silogPrice4.setForeground(new java.awt.Color(0, 0, 0));
        silogPrice4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        silogPrice4.setText("₱130.00");
        silogPrice4.setOpaque(true);
        jPanel1.add(silogPrice4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 380, 80, -1));

        ulamBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/UlamBtn.png"))); // NOI18N
        ulamBtn.setBorderPainted(false);
        ulamBtn.setContentAreaFilled(false);
        ulamBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ulamBtnActionPerformed(evt);
            }
        });
        jPanel1.add(ulamBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 80, 80));

        silogBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/SilogBtn.png"))); // NOI18N
        silogBtn.setBorderPainted(false);
        silogBtn.setContentAreaFilled(false);
        silogBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                silogBtnActionPerformed(evt);
            }
        });
        jPanel1.add(silogBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 80, 80));

        addOnsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/Add-OnsBtn.png"))); // NOI18N
        addOnsBtn.setBorderPainted(false);
        addOnsBtn.setContentAreaFilled(false);
        addOnsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addOnsBtnActionPerformed(evt);
            }
        });
        jPanel1.add(addOnsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 80, 80));

        drinksBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/DrinksBtn.png"))); // NOI18N
        drinksBtn.setBorderPainted(false);
        drinksBtn.setContentAreaFilled(false);
        drinksBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drinksBtnActionPerformed(evt);
            }
        });
        jPanel1.add(drinksBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 80, 80));

        TotalTxt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TotalTxt.setForeground(new java.awt.Color(0, 0, 0));
        TotalTxt.setText("Total:");
        jPanel1.add(TotalTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 770, 50, -1));

        totalLbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        totalLbl.setForeground(new java.awt.Color(0, 0, 0));
        totalLbl.setText("₱0.00");
        jPanel1.add(totalLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 760, 120, 40));

        CheckoutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/Checkout.png"))); // NOI18N
        CheckoutBtn.setBorderPainted(false);
        CheckoutBtn.setContentAreaFilled(false);
        CheckoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckoutBtnActionPerformed(evt);
            }
        });
        jPanel1.add(CheckoutBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 700, 140, 100));

        ViewCartBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/ViewCartBtn (1).png"))); // NOI18N
        ViewCartBtn.setBorderPainted(false);
        ViewCartBtn.setContentAreaFilled(false);
        ViewCartBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewCartBtnActionPerformed(evt);
            }
        });
        jPanel1.add(ViewCartBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 700, 140, 100));

        goBackBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/GoBackBtn.png"))); // NOI18N
        goBackBtn.setBorderPainted(false);
        goBackBtn.setContentAreaFilled(false);
        goBackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBackBtnActionPerformed(evt);
            }
        });
        jPanel1.add(goBackBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 700, 100, 40));

        greyRectangle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/GreyRectangle.png"))); // NOI18N
        jPanel1.add(greyRectangle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 690, -1, 110));

        TapsilogBtn.setBackground(new java.awt.Color(239, 239, 239));
        TapsilogBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/TapsilogIcon.png"))); // NOI18N
        TapsilogBtn.setBorderPainted(false);
        TapsilogBtn.setContentAreaFilled(false);
        TapsilogBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TapsilogBtnActionPerformed(evt);
            }
        });
        jPanel1.add(TapsilogBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 100, 100));

        HotsilogBtn.setBackground(new java.awt.Color(239, 239, 239));
        HotsilogBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/HotsilogIcon.png"))); // NOI18N
        HotsilogBtn.setBorderPainted(false);
        HotsilogBtn.setContentAreaFilled(false);
        HotsilogBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HotsilogBtnActionPerformed(evt);
            }
        });
        jPanel1.add(HotsilogBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 100, 100));

        TocilogBtn.setBackground(new java.awt.Color(239, 239, 239));
        TocilogBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/TocilogIcon.png"))); // NOI18N
        TocilogBtn.setBorderPainted(false);
        TocilogBtn.setContentAreaFilled(false);
        TocilogBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TocilogBtnActionPerformed(evt);
            }
        });
        jPanel1.add(TocilogBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, 100, 100));

        BangsilogBtn.setBackground(new java.awt.Color(239, 239, 239));
        BangsilogBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/BangsilogIcon.png"))); // NOI18N
        BangsilogBtn.setBorderPainted(false);
        BangsilogBtn.setContentAreaFilled(false);
        BangsilogBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BangsilogBtnActionPerformed(evt);
            }
        });
        jPanel1.add(BangsilogBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, 100, 100));

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

    private void updateFooterTotal() {
        float runningTotal = CartManager.getInstance().calculateTotal(); 
        totalLbl.setText(String.format("₱%.2f", runningTotal));
    }
    private void goBackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackBtnActionPerformed
        ModeOfOrderPage nextPage = new ModeOfOrderPage();
        nextPage.setVisible(true);
        dispose();
        CartManager.getInstance().clearCart();
    }//GEN-LAST:event_goBackBtnActionPerformed

    private void TapsilogBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TapsilogBtnActionPerformed
        ItemPopUpDialog popUp = new ItemPopUpDialog(this, true, idTapsilog, "Tapsilog", priceTapsilog, "tapsilog.png");
        popUp.setVisible(true);
        updateFooterTotal();
    }//GEN-LAST:event_TapsilogBtnActionPerformed

    private void HotsilogBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HotsilogBtnActionPerformed
        ItemPopUpDialog popUp = new ItemPopUpDialog(this, true, idHatsilog, "Hotsilog", priceHotsilog, "hotsilog.png");
        popUp.setVisible(true);
        updateFooterTotal();
    }//GEN-LAST:event_HotsilogBtnActionPerformed

    private void TocilogBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TocilogBtnActionPerformed
        ItemPopUpDialog popUp = new ItemPopUpDialog(this, true, idTocilog, "Tocilog", priceTocilog, "tocilog.png");
        popUp.setVisible(true);
        updateFooterTotal();
    }//GEN-LAST:event_TocilogBtnActionPerformed

    private void BangsilogBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BangsilogBtnActionPerformed
        ItemPopUpDialog popUp = new ItemPopUpDialog(this, true, idBangsilog, "Bangsilog", priceBangsilog, "bangsilog.png");
        popUp.setVisible(true);
        updateFooterTotal();
    }//GEN-LAST:event_BangsilogBtnActionPerformed

    private void ulamBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ulamBtnActionPerformed
        Menu nextPage = new Menu();
        nextPage.setVisible(true);
        dispose();
    }//GEN-LAST:event_ulamBtnActionPerformed

    private void silogBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_silogBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_silogBtnActionPerformed

    private void addOnsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addOnsBtnActionPerformed
        AddOnsPage nextPage = new AddOnsPage();
        nextPage.setVisible(true);
        dispose();
    }//GEN-LAST:event_addOnsBtnActionPerformed

    private void drinksBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drinksBtnActionPerformed
        DrinksPage nextPage = new DrinksPage();
        nextPage.setVisible(true);
        dispose();
    }//GEN-LAST:event_drinksBtnActionPerformed

    private void ViewCartBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewCartBtnActionPerformed
        CartPopUpView cart = new CartPopUpView(this, true);
        cart.setVisible(true);
        updateFooterTotal();
    }//GEN-LAST:event_ViewCartBtnActionPerformed

    private void CheckoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckoutBtnActionPerformed
        Checkout nextPage = new Checkout();
        nextPage.setVisible(true);
        dispose();
    }//GEN-LAST:event_CheckoutBtnActionPerformed

    public void updateKioskMenuFromDatabase() {
        String sql = "SELECT food_id, item_name, price, availability FROM food_items WHERE category = 'SILOG'";
        String dbUrl = "jdbc:mysql://localhost:3306/ordering_kiosk_db"; 
        String dbUser = "root";
        String dbPass = "";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
             
            while (rs.next()) {
                int foodId = rs.getInt("food_id"); 
                String name = rs.getString("item_name");
                double price = rs.getDouble("price");
                String status = rs.getString("availability");
                boolean isAvailable = status.equalsIgnoreCase("Available");
                String buttonText = name + " - ₱" + price;

                switch (foodId) {
                    case 2002: 
                        idTapsilog = foodId; 
                        priceTapsilog = (float) price;
                        silogItem1.setText(name);
                        silogPrice1.setText(String.format("₱%.2f", price));
                        TapsilogBtn.setEnabled(isAvailable);
                        break;
                    case 2001: 
                        idHatsilog = foodId; 
                        priceHotsilog = (float) price;
                        silogItem2.setText(name);
                        silogPrice2.setText(String.format("₱%.2f", price));
                        HotsilogBtn.setEnabled(isAvailable);
                        break;
                    case 2003: 
                        idTocilog = foodId; 
                        priceTocilog = (float) price;
                        silogItem3.setText(name);
                        silogPrice3.setText(String.format("₱%.2f", price));
                        TocilogBtn.setEnabled(isAvailable);
                        break;
                    case 2004: 
                        idBangsilog = foodId;
                        priceBangsilog = (float) price;
                        silogItem4.setText(name);
                        silogPrice4.setText(String.format("₱%.2f", price));
                        BangsilogBtn.setEnabled(isAvailable);
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error syncing Silog Menu layout UI: " + e.getMessage());
        }
    }
    
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SilogMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BangsilogBtn;
    private javax.swing.JButton CheckoutBtn;
    private javax.swing.JLabel Header;
    private javax.swing.JButton HotsilogBtn;
    private javax.swing.JButton TapsilogBtn;
    private javax.swing.JButton TocilogBtn;
    private javax.swing.JLabel TotalTxt;
    private javax.swing.JButton ViewCartBtn;
    private javax.swing.JButton addOnsBtn;
    private javax.swing.JButton drinksBtn;
    private javax.swing.JButton goBackBtn;
    private javax.swing.JLabel greyRectangle;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton silogBtn;
    private javax.swing.JLabel silogItem1;
    private javax.swing.JLabel silogItem2;
    private javax.swing.JLabel silogItem3;
    private javax.swing.JLabel silogItem4;
    private javax.swing.JLabel silogPrice1;
    private javax.swing.JLabel silogPrice2;
    private javax.swing.JLabel silogPrice3;
    private javax.swing.JLabel silogPrice4;
    private javax.swing.JLabel totalLbl;
    private javax.swing.JButton ulamBtn;
    // End of variables declaration//GEN-END:variables
}
