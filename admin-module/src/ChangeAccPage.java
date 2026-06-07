import java.sql.*;
import javax.swing.JOptionPane;

public class ChangeAccPage extends javax.swing.JFrame {

    public ChangeAccPage() {
        initComponents();
        CallAdminData();
        this.setSize(425, 450);
        this.setLocationRelativeTo(null);
    }
    
    private void CallAdminData() {
        String querySql = "SELECT email, username, password FROM Admin WHERE admin_id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(querySql)) {
             
            pstmt.setInt(1, AdminManager.currentAdminId);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    EmailTxtField.setText(rs.getString("email"));
                    userNameTxtField.setText(rs.getString("username"));
                    passwordTxtField.setText(rs.getString("password"));
                }
            }
        } catch (Exception e) {
            System.out.println("Error Occured: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        AccountInformation = new javax.swing.JLabel();
        EmailTxtField = new javax.swing.JTextField();
        updateyouremail = new javax.swing.JLabel();
        userNameTxtField = new javax.swing.JTextField();
        updateyourusername = new javax.swing.JLabel();
        passwordTxtField = new javax.swing.JTextField();
        updateyourpassword = new javax.swing.JLabel();
        saveBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        AccountInformation.setFont(new java.awt.Font("Microsoft PhagsPa", 1, 18)); // NOI18N
        AccountInformation.setForeground(new java.awt.Color(255, 255, 255));
        AccountInformation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AccountInformation.setText("Account Information");

        updateyouremail.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        updateyouremail.setForeground(new java.awt.Color(0, 0, 0));
        updateyouremail.setText("Update your Email");

        updateyourusername.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        updateyourusername.setForeground(new java.awt.Color(0, 0, 0));
        updateyourusername.setText("Update your Username");

        updateyourpassword.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        updateyourpassword.setForeground(new java.awt.Color(0, 0, 0));
        updateyourpassword.setText("Update your Password");

        saveBtn.setBackground(new java.awt.Color(123, 72, 85));
        saveBtn.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        saveBtn.setForeground(new java.awt.Color(255, 255, 255));
        saveBtn.setText("Save Changes");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        cancelBtn.setBackground(new java.awt.Color(123, 72, 85));
        cancelBtn.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        cancelBtn.setForeground(new java.awt.Color(255, 255, 255));
        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(123, 72, 85));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(AccountInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(EmailTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(updateyouremail, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(userNameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(updateyourusername, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(passwordTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(updateyourpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(AccountInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(EmailTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(updateyouremail)
                .addGap(27, 27, 27)
                .addComponent(userNameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(updateyourusername)
                .addGap(26, 26, 26)
                .addComponent(passwordTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(updateyourpassword)
                .addGap(35, 35, 35)
                .addComponent(saveBtn)
                .addGap(6, 6, 6)
                .addComponent(cancelBtn))
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

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        String newEmail = EmailTxtField.getText().trim();
        String newUsername = userNameTxtField.getText().trim();
        String newPassword = passwordTxtField.getText().trim();

        if (newEmail.isEmpty() || newUsername.isEmpty() || newPassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields must be filled out.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String passwordPattern = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!@#$%^&*(),.?\":{}|<>_]).{8,16}$";

        if (!newPassword.matches(passwordPattern)) {
            JOptionPane.showMessageDialog(this, 
                "Password must meet the following criteria:\n" +
                "- Between 8 and 16 characters long\n" +
                "- Contain at least one letter\n" +
                "- Contain at least one number\n" +
                "- Contain at least one symbol (e.g., !, @, #, $, %, _, etc.)", 
                "Weak Password", 
                JOptionPane.WARNING_MESSAGE);
            return; 
        }

        String updateSql = "UPDATE Admin SET email = ?, username = ?, password = ? WHERE admin_id = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(updateSql)) {

            pstmt.setString(1, newEmail);
            pstmt.setString(2, newUsername);
            pstmt.setString(3, newPassword);
            pstmt.setInt(4, AdminManager.currentAdminId);

            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Account Details Updated Successfully!", "Account Updated!", JOptionPane.INFORMATION_MESSAGE);

                LoginPage nextPage = new LoginPage();
                nextPage.setVisible(true);
                this.dispose();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error saving updates: Username or Email might already be taken.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        UserPage nextPage = new UserPage();
        nextPage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelBtnActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChangeAccPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AccountInformation;
    private javax.swing.JTextField EmailTxtField;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField passwordTxtField;
    private javax.swing.JButton saveBtn;
    private javax.swing.JLabel updateyouremail;
    private javax.swing.JLabel updateyourpassword;
    private javax.swing.JLabel updateyourusername;
    private javax.swing.JTextField userNameTxtField;
    // End of variables declaration//GEN-END:variables
}
