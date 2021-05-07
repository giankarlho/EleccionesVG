package dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexion {

    public static Connection cnx = null;

    public static Connection conectar() throws Exception {

        try {
            String user = "sa";
            String pwd = "@abc123@";
            String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=eleccionesvg";
            Class.forName(driver).newInstance();
            cnx = DriverManager.getConnection(url, user, pwd);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión, revise xfa");
            System.out.println("error de conexion " + e.getMessage());
        }
        return cnx;
    }

    public void cerrar() throws Exception {
        if (cnx != null) {
            cnx.close();
        }
    }

    public static void main(String[] args) throws Exception {
        conectar();
        if (cnx != null) {
            System.out.println("esta abierta, jojolete");
        } else {
            System.out.println("algo anda mal, fijate el driver, conexión, etc....");
        }
    }
}
