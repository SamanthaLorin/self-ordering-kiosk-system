
public class AdminManager {
    public static int currentAdminId;
    public static String currentAdminName;
    
    public static void logout(javax.swing.JFrame currentFrame) {
        currentAdminId = 0;
        currentAdminName = null;
        
        new LoginPage().setVisible(true);
        currentFrame.dispose();
    }
}