package common.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    public static Connection getConnection() {

        Connection con= null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://chatting.cx3635ohpt8d.ap-northeast-2.rds.amazonaws.com/animal?autoReconnect=true",
                    "root","chat1234");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return con;
    }
}