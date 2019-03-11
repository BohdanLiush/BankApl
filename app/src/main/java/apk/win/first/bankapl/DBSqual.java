package apk.win.first.bankapl;

//import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBSqual {

    private static final String URL = "jdbc:mysql://localhost:3306/mydbtesttwoo";
    //private static final String URL = "jdbc:mysql://192.168.0.192:3306/mydbtesttwoo";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        Connection connection;
        {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                //Driver driver = new FabricMySQLDriver();
                //DriverManager.registerDriver(driver);
                connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
                if (!connection.isClosed()){
                    System.out.println("connection with database is fine");
                    connection.close();
                    if (connection.isClosed())
                        System.out.println("connection with database is closed");
                }
            } catch (SQLException e) {
                System.err.println("There is no posobility to load class driver");
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }
}
