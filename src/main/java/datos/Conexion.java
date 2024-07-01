// Modulo de Java-JDBC 
package datos;

import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {

    private static final String JDBC_URLSys = DatabaseConfig.JDBC_URL;
    private static final String JDBC_USER = DatabaseConfig.JDBC_USER;
    private static final String JDBC_PASSWORD = DatabaseConfig.JDBC_PASSWORD; 

    private static final String JDBC_URL = JDBC_URLSys + "/control_clientes?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";

    public static DataSource getDataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(JDBC_URL); // Especificamos la URL para conectarnos a la base de datos 
        ds.setUsername(JDBC_USER);
        ds.setPassword(JDBC_PASSWORD);
        ds.setInitialSize(50); // 50 conexiones de manera inicial
        return ds;
    }

    // Definimos un metodo para establecer una conexion 
    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }

    public static void close(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void close(PreparedStatement stmt) {
        try {
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void close(Connection conn) {
        try {
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
