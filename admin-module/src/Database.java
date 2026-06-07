import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/ordering_kiosk_db";
    private static final String USER = "root"; 
    private static final String PASSWORD = "";
    
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to XAMPP successfully!");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver Error: Did you link the JAR to the Libraries folder?");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database Error: Is your XAMPP Control Panel running MySQL?");
            e.printStackTrace();
        }
        return conn;
    }
}
