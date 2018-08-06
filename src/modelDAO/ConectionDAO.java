package modelDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

abstract public class ConectionDAO {

    private static String USUARIO = "root";
    private static String SENHA = "";
    private static String URL = "jdbc:mysql://127.0.0.1:3306/cadastrocliente";

    public static Connection openConnection() throws ClassNotFoundException, SQLException {
        Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
        return conn;
    }

}
