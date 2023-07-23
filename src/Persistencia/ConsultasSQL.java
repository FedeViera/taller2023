package Persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Clases.Conexion;
import javax.swing.JOptionPane;


public class ConsultasSQL {
    
    //VALIDAR USUARIO Y CONTRASEÑA
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
    
    //AGREGAR DATO EN BD
    public void agregarDato(String usuario, String contraseña, String cargo) {
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectarMySQL();

        if (conn != null) {
            try {
                Statement statement = (Statement) conn.createStatement();
                String query = "INSERT INTO Usuarios (ingresoUsuario, ingresoContrasenia, cargo) "+"VALUES ('" + usuario + "', '" + contraseña + "', '" + cargo + "')";
                statement.executeUpdate(query);
                
                statement.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Fallo al conectar con la BD.", "Connection Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //ACTUALIZAR DATO EN BD
    public void actualizarDato(String usuario, String nuevoCargo) {
        // Lógica de conexión a la base de datos, si es necesario
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectarMySQL();
        
        if (conn != null) {
            try {
                Statement statement = (Statement) conn.createStatement();
                String query = "UPDATE Usuarios SET cargo = '" + nuevoCargo + "' WHERE ingresoUsuario = '" + usuario + "'";
                statement.executeUpdate(query);
                
                statement.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Fallo al conectar con la BD.", "Connection Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public Object[][] obtenerUsuarios() {
        String query = "SELECT id, cargo, ingresoUsuario, ingresoContrasenia FROM Usuarios";
        return ejecutarConsulta(query);
    }

    public Object[][] obtenerOtrosDatos() {
        // Aquí puedes escribir otras consultas para obtener diferentes datos de la base de datos
        String query = "SELECT campo1, campo2, campo3 FROM OtraTabla";
        return ejecutarConsulta(query);
    }

    //TRAER DATOS DE LA BASE DE DATOS Y MOSTRARLOS EN TABLA
    private Object[][] ejecutarConsulta(String query) {
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectarMySQL();
        Object[][] datos = null;

        if (conn != null) {
            try {
                Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet resultSet = statement.executeQuery(query);

                // Obtener la cantidad de filas en el ResultSet
                resultSet.last();
                int numRows = resultSet.getRow();
                resultSet.beforeFirst();

                // Obtener la cantidad de columnas en el ResultSet
                int numCols = resultSet.getMetaData().getColumnCount();

                datos = new Object[numRows][numCols];
                int row = 0;
                while (resultSet.next()) {
                    for (int col = 0; col < numCols; col++) {
                        datos[row][col] = resultSet.getObject(col + 1);
                    }
                    row++;
                }

                resultSet.close();
                statement.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(null, "Fallo al conectar con la BD.", "Connection Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        return datos;
    }
    
    
    
    
    
}

