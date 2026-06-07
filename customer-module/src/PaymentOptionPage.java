import javax.swing.JOptionPane;
import java.sql.*;

public class PaymentOptionPage extends javax.swing.JFrame {

    public PaymentOptionPage() {
        initComponents();
        this.setSize(445, 800);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        CashBtn = new javax.swing.JButton();
        CardBtn = new javax.swing.JButton();
        BackgroundImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        CashBtn.setBorderPainted(false);
        CashBtn.setContentAreaFilled(false);
        CashBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CashBtnActionPerformed(evt);
            }
        });

        CardBtn.setBorderPainted(false);
        CardBtn.setContentAreaFilled(false);
        CardBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CardBtnActionPerformed(evt);
            }
        });

        BackgroundImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/PaymentMethodBG.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(CashBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(CardBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(BackgroundImage, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackgroundImage)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(370, 370, 370)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CashBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CardBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

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

    private void CashBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CashBtnActionPerformed
        processOrderTransaction("CASH");
    }//GEN-LAST:event_CashBtnActionPerformed

    
    private void CardBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CardBtnActionPerformed
        processOrderTransaction("CARD");
    }//GEN-LAST:event_CardBtnActionPerformed
    
    private void processOrderTransaction(String paymentMethod) {
        if (CartManager.getInstance().getCartList().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Your cart is currently empty!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String orderQuery = "INSERT INTO orders (order_method, payment_method, discount_type, discount_amount, total_amount) VALUES (?, ?, ?, ?, ?)";
        String itemQuery = "INSERT INTO order_items (order_id, food_id, price, quantity) VALUES (?, ?, ?, ?)";

        try {
            Connection conn = Database.getConnection();
            if (conn != null) {
                PreparedStatement orderStatement = conn.prepareStatement(orderQuery, Statement.RETURN_GENERATED_KEYS);

                orderStatement.setString(1, CartManager.orderMethod);
                orderStatement.setString(2, paymentMethod);

                float subtotal = CartManager.getInstance().calculateTotal();
                float discountAmt = CartManager.discountAmount;
                float finalTotal = subtotal - discountAmt;

                if (CartManager.discountType != null && !CartManager.discountType.isEmpty()) {
                    orderStatement.setString(3, CartManager.discountType);
                    orderStatement.setFloat(4, discountAmt);
                } else {
                    orderStatement.setNull(3, java.sql.Types.VARCHAR);
                    orderStatement.setFloat(4, 0.00f);
                }

                orderStatement.setFloat(5, finalTotal);

                orderStatement.executeUpdate();

                int generatedOrderId = -1;
                ResultSet rs = orderStatement.getGeneratedKeys();
                if (rs.next()) {
                    generatedOrderId = rs.getInt(1);
                }
                orderStatement.close();

                if (generatedOrderId != -1) {
                    PreparedStatement itemStatement = conn.prepareStatement(itemQuery);

                    for (CartItems item : CartManager.getInstance().getCartList()) {
                        itemStatement.setInt(1, generatedOrderId);
                        itemStatement.setInt(2, item.getFoodId());
                        itemStatement.setFloat(3, item.getPrice());
                        itemStatement.setInt(4, item.getQuantity());

                        itemStatement.addBatch();
                    }
                    itemStatement.executeBatch();
                    itemStatement.close();
                }
                conn.close();

                JOptionPane.showMessageDialog(this, "Order processed successfully via " + paymentMethod + "! Total saved: ₱" + String.format("%.2f", finalTotal));

                CartManager.getInstance().clearCart();

                PrintReceiptPage nextPage = new PrintReceiptPage();
                nextPage.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Error: Could not connect to XAMPP database server.", "Connection Failure", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database Error: " + e.getMessage(), "SQL Exception Exception", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaymentOptionPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackgroundImage;
    private javax.swing.JButton CardBtn;
    private javax.swing.JButton CashBtn;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
