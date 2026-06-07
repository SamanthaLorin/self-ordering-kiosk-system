import java.sql.*;

public class UserPage extends javax.swing.JFrame {

    public UserPage() {
        initComponents();
        this.setSize(410, 380);
        this.setLocationRelativeTo(null);
        CurrentProfile();
    }

    private void CurrentProfile() {
        String querySql = "SELECT email, username, password FROM Admin WHERE admin_id = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(querySql)) {
             
            pstmt.setInt(1, AdminManager.currentAdminId);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    emailLbl.setText(rs.getString("email"));
                    userNameLabel.setText(rs.getString("username"));
                    passwordLbl.setText(rs.getString("password")); 
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading profile view: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        goBackBtn = new javax.swing.JButton();
        AccountInformation = new javax.swing.JLabel();
        userNameLabel = new javax.swing.JLabel();
        passwordLbl = new javax.swing.JLabel();
        changeAccBtn = new javax.swing.JButton();
        emailLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        goBackBtn.setBackground(new java.awt.Color(123, 72, 85));
        goBackBtn.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        goBackBtn.setForeground(new java.awt.Color(255, 255, 255));
        goBackBtn.setText("Back to Dashboard");
        goBackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBackBtnActionPerformed(evt);
            }
        });

        AccountInformation.setFont(new java.awt.Font("Microsoft PhagsPa", 1, 18)); // NOI18N
        AccountInformation.setForeground(new java.awt.Color(51, 51, 51));
        AccountInformation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AccountInformation.setText("Account Information");

        userNameLabel.setBackground(new java.awt.Color(204, 204, 204));
        userNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userNameLabel.setForeground(new java.awt.Color(0, 0, 0));
        userNameLabel.setText("Username");
        userNameLabel.setOpaque(true);

        passwordLbl.setBackground(new java.awt.Color(204, 204, 204));
        passwordLbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        passwordLbl.setForeground(new java.awt.Color(0, 0, 0));
        passwordLbl.setText("Password");
        passwordLbl.setOpaque(true);

        changeAccBtn.setBackground(new java.awt.Color(195, 193, 171));
        changeAccBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        changeAccBtn.setForeground(new java.awt.Color(0, 0, 0));
        changeAccBtn.setText("Change Account Information");
        changeAccBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeAccBtnActionPerformed(evt);
            }
        });

        emailLbl.setBackground(new java.awt.Color(204, 204, 204));
        emailLbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        emailLbl.setForeground(new java.awt.Color(0, 0, 0));
        emailLbl.setText("Email");
        emailLbl.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(goBackBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(AccountInformation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userNameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordLbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailLbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(changeAccBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(goBackBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(AccountInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(emailLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(userNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(passwordLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(changeAccBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void goBackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackBtnActionPerformed
        DashboardPage nextPage = new DashboardPage();
        nextPage.setVisible(true);
        dispose();
    }//GEN-LAST:event_goBackBtnActionPerformed

    private void changeAccBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeAccBtnActionPerformed
        ChangeAccPage nextPage = new ChangeAccPage();
        nextPage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_changeAccBtnActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AccountInformation;
    private javax.swing.JButton changeAccBtn;
    private javax.swing.JLabel emailLbl;
    private javax.swing.JButton goBackBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel passwordLbl;
    private javax.swing.JLabel userNameLabel;
    // End of variables declaration//GEN-END:variables
}
