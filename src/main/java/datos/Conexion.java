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

    // Para optimizar la creacion de objetos DataSource
    private static BasicDataSource dataSource;

    public static DataSource getDataSource() {
        if (dataSource == null) {
            dataSource = new BasicDataSource();
            dataSource.setUrl(JDBC_URL); // Especificamos la URL para conectarnos a la base de datos 
            dataSource.setUsername(JDBC_USER);
            dataSource.setPassword(JDBC_PASSWORD);
            dataSource.setInitialSize(50); // 50 conexiones de manera inicial   
        }

        return dataSource;
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
