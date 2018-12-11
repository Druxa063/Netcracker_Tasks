package jdbc.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    private DBUtil() {}

    public static Connection getConnection() {
        Connection connection = null;
        try {
//            pool tomcat
            Context context = new InitialContext();
            Context envContext  = (Context)context.lookup("java:/comp/env");
            DataSource dataSource = (DataSource) envContext.lookup("jdbc/employee");
            connection = dataSource.getConnection();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (connection == null) {
            try {
                Class.forName("oracle.jdbc.OracleDriver");
                connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "password");
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
