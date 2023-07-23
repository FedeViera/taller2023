package Persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Clases.Conexion;


public class ConsultasSQL {
    
    public String validarUsuarioYContraseña(String usuario, String contrasenia){
        String cargo = null;
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectarMySQL();

        if (conn != null) {
            try {
                Statement statement = (Statement) conn.createStatement();
                String query = "SELECT cargo FROM Usuarios WHERE ingresoUsuario='" + usuario + "' AND ingresoContrasenia='" + contrasenia + "'";
                ResultSet resultSet = statement.executeQuery(query);
                if (resultSet.next()) {
                    cargo = resultSet.getString("cargo");
                }
                resultSet.close();
                statement.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return cargo;
    }
}
