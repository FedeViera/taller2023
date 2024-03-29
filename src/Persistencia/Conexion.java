package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.sql.Statement;


public class Conexion 
{
                      
String url = "jdbc:mysql://localhost:3306/";
String user = "root";
String pass = "";

   // Librería de MySQL
    public String driver = "com.mysql.cj.jdbc.Driver";

    // Nombre de la base de datos
    public String database = "bd-taller2";

    // Host 127.0.0.1
    public String hostname = "localhost";

    // Puerto
    public String port = "3306";

    // Ruta de nuestra base de datos (desactivamos el uso de SSL con "?useSSL=false")
    public String urls = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";

    // Nombre de usuario
    public String username = "root";

    // Clave de usuario
    public String password = "";
    
     Connection conn = null;
     
     Statement st=null;
     
    public Connection conectarMySQL() 
    {
        
        
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            conn.setCatalog(database);
            //System.out.print("Conexion establecida");
        } 
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            //System.out.print("Conexion No establecida");
        }

        return conn;
    }

}
