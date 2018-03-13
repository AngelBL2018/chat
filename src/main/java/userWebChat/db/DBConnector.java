package userWebChat.db;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

   private static DBConnector dbConnector = new DBConnector();
   private Connection connection;
    private String url = "jdbc:mysql://localhost:3306/userWebChat";
    private String login = "root";
    private String password = "root";

    private DBConnector(){

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    public static DBConnector getDBConnector(){
        return dbConnector;
    }

    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()){
                connection = DriverManager.getConnection(url,login,password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
