import java.sql.*;
import javax.swing.JOptionPane;

public class LoginPage extends javax.swing.JFrame {

    public LoginPage() {
        initComponents();
        this.setSize(950, 515);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        usernameTxtField = new javax.swing.JTextField();
        passwordTxtField = new javax.swing.JTextField();
        SignInBtn = new javax.swing.JButton();
        backgroundImg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usernameTxtField.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        usernameTxtField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        usernameTxtField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                usernameTxtFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                usernameTxtFieldFocusLost(evt);
            }
        });
        jPanel1.add(usernameTxtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 270, 370, 40));

        passwordTxtField.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        passwordTxtField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordTxtFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordTxtFieldFocusLost(evt);
            }
        });
        jPanel1.add(passwordTxtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 320, 370, 40));

        SignInBtn.setBackground(new java.awt.Color(123, 72, 85));
        SignInBtn.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        SignInBtn.setForeground(new java.awt.Color(255, 255, 255));
        SignInBtn.setText("Sign-in");
        SignInBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignInBtnActionPerformed(evt);
            }
        });
        jPanel1.add(SignInBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 370, 150, 40));

        backgroundImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurantsystemforradmin/Images/Pages.png"))); // NOI18N
        jPanel1.add(backgroundImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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

    private void usernameTxtFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameTxtFieldFocusGained
        if (usernameTxtField.getText().equals("Enter username...")) {
            usernameTxtField.setText("");
        }
    }//GEN-LAST:event_usernameTxtFieldFocusGained

    private void passwordTxtFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordTxtFieldFocusGained
        if (passwordTxtField.getText().equals("Enter password")) {
            passwordTxtField.setText("");
        }
    }//GEN-LAST:event_passwordTxtFieldFocusGained

    private void usernameTxtFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameTxtFieldFocusLost
        if (usernameTxtField.getText().equals("")) {
            usernameTxtField.setText("Enter username...");
        }
    }//GEN-LAST:event_usernameTxtFieldFocusLost

    private void passwordTxtFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordTxtFieldFocusLost
        if (passwordTxtField.getText().equals("")) {
            passwordTxtField.setText("Enter password");
        }
    }//GEN-LAST:event_passwordTxtFieldFocusLost

    private void SignInBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignInBtnActionPerformed
        String inputUser = usernameTxtField.getText().trim();
        String inputPass = passwordTxtField.getText().trim();

        boolean isUserEmpty = inputUser.isEmpty() || inputUser.equals("Enter username...");
        boolean isPassEmpty = inputPass.isEmpty() || inputPass.equals("Enter password");

        if (isUserEmpty && isPassEmpty) {
            JOptionPane.showMessageDialog(this, "Please enter your username and password.", "Missing Username & Password", JOptionPane.WARNING_MESSAGE);
            return; 
        }
        if (isUserEmpty) {
            JOptionPane.showMessageDialog(this, "Username is empty! Please Enter your Username.", "Missing Username", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (isPassEmpty) {
            JOptionPane.showMessageDialog(this, 
                "Password is empty! Please Enter your Password.", "Missing Password", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Database Code
        String loginSql = "SELECT admin_id FROM Admin WHERE username = ? AND password = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(loginSql)) {

            pstmt.setString(1, inputUser);
            pstmt.setString(2, inputPass);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    AdminManager.currentAdminId = rs.getInt("admin_id");        // Pag nakuha niya yung AdminID sa database magp-proceed siya sa Dashboard.

                    DashboardPage dashboard = new DashboardPage();
                    dashboard.setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid Username or Password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            System.out.println("Login Database Error: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_SignInBtnActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SignInBtn;
    private javax.swing.JLabel backgroundImg;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField passwordTxtField;
    private javax.swing.JTextField usernameTxtField;
    // End of variables declaration//GEN-END:variables
}
