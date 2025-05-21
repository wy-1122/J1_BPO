import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcTest {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/bpo?useSSL=false&serverTimezone=Asia/Shanghai";
        String username = "root";
        String password = "root";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("success");
            conn.close();
        } catch (Exception e) {
            System.out.println("fail");
            e.printStackTrace();
        }
    }
}

// 