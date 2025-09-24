
import util.DbConnection;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection conn = DbConnection.getConnection();
        if (conn != null) {
            System.out.println("Connection is working!");
        } else {
            System.out.println("Failed to connect!");
        }
    }
}
