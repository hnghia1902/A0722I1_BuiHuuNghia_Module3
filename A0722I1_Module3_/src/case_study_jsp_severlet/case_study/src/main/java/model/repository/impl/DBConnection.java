package model.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public class DBConnection {
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "";
    private static final String HOST = "127.0.0.1";
    private static final String DATABASE = "mysql";
    private static final String PORT = "3306";
    private static Connection connection;
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://"+HOST+":"+PORT+"/"+DATABASE, USER_NAME, PASSWORD);

        } catch (ClassNotFoundException e) {
          throw new RuntimeException(e);
        } catch (SQLException e) {
             throw new RuntimeException(e);
         }

         return connection;
        }
        public static void close(){
            if (connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }


}
