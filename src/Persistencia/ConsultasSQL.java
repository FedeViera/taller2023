package Persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Entidades.Conexion;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;


public class ConsultasSQL {
    
//VALIDAR USUARIO Y CONTRASEÑA
    public String validarUsuarioYContraseña(String usuario, String contrasenia) {
    String cargo = null;
    Conexion conexion = new Conexion();
    Connection conn = conexion.conectarMySQL();

    if (conn != null) {
        try {
            String query = "SELECT cargo, nombre, apellido FROM persona WHERE usuario=? AND contrasenia=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, usuario);
            preparedStatement.setString(2, contrasenia);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                cargo = resultSet.getString("cargo");
            }

            resultSet.close();
            preparedStatement.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    return cargo;
}


//CHEQUEAR SI EL USUARIO EXISTE EN LA BD
    private boolean usuarioExiste(Connection conn, String usuario) throws SQLException {
        String query = "SELECT COUNT(*) AS total FROM persona WHERE usuario = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setString(1, usuario);
        ResultSet resultSet = preparedStatement.executeQuery();

        int total = 0;
        if (resultSet.next()) {
            total = resultSet.getInt("total");
        }

        resultSet.close();
        preparedStatement.close();

        return total > 0;
    }
    
//AGREGAR DATO EN BD
    public void agregarDato(Integer cedula, String nombre, String apellido, String usuario, String contrasenia, String cargo) {
    Conexion conexion = new Conexion();
    Connection conn = conexion.conectarMySQL();
    
        if (conn != null) {
            try {
                // Verifica si el usuario ya existe en la base de datos.
                if (!usuarioExiste(conn, usuario)) {
                    String query = "INSERT INTO persona (cedula, nombre, apellido, usuario, contrasenia, cargo) VALUES (?, ?, ?, ?, ?, ?)";
                    PreparedStatement preparedStatement = conn.prepareStatement(query);
                    preparedStatement.setInt(1, cedula);
                    preparedStatement.setString(2, nombre);
                    preparedStatement.setString(3, apellido);
                    preparedStatement.setString(4, usuario);
                    preparedStatement.setString(5, contrasenia);
                    preparedStatement.setString(6, cargo);

                    preparedStatement.executeUpdate();

                    preparedStatement.close();
                } else {
                    JOptionPane.showMessageDialog(null, "El usuario ya existe en la base de datos.", "Usuario Duplicado", JOptionPane.WARNING_MESSAGE);
                }
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Fallo al conectar con la base de datos.", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    
//ACTUALIZAR DATO EN BD
    public void actualizarUsuario(String usuario, String nuevaContrasenia, String nuevoCargo) {
    Conexion conexion = new Conexion();
    Connection conn = conexion.conectarMySQL();
        
        if (conn != null) {
            try {
                // Verificar si el usuario existe en la base de datos antes de actualizarlo
                if (usuarioExiste(conn, usuario)) {
                    String query = "UPDATE persona SET contrasenia = ?, cargo = ? WHERE usuario = ?";
                    PreparedStatement preparedStatement = conn.prepareStatement(query);
                    preparedStatement.setString(1, nuevaContrasenia);
                    preparedStatement.setString(2, nuevoCargo);
                    preparedStatement.setString(3, usuario);

                    preparedStatement.executeUpdate();

                    preparedStatement.close();
                } else {
                    JOptionPane.showMessageDialog(null, "El usuario no existe en la base de datos.", "Usuario no encontrado", JOptionPane.WARNING_MESSAGE);
                }
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Fallo al conectar con la base de datos.", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
        }
    }

/*//OBTENER ID POR USUARIO 
    public int obtenerIDUsuarioPorCorreo(String correo) {
    Conexion conexion = new Conexion();
    Connection conn = conexion.conectarMySQL();

    Integer idUsuario = -1;

    if (conn != null) {
        try {
            String query = "SELECT id FROM Usuarios WHERE ingresoUsuario = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, correo);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                idUsuario = resultSet.getInt("id"); // Convertimos el valor a un entero
            }

            resultSet.close();
            preparedStatement.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    } else {
        JOptionPane.showMessageDialog(null, "Fallo al conectar con la base de datos.", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
    }
    return idUsuario;
}*/
    
//ELIMINAR DATOS DE LA BD    
    public void eliminarDato(int cedula) {
    Conexion conexion = new Conexion();
    Connection conn = conexion.conectarMySQL();

    if (conn != null) {
        try {
            String query = "DELETE FROM persona WHERE cedula = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, cedula);

            preparedStatement.executeUpdate();

            preparedStatement.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    } else {
        JOptionPane.showMessageDialog(null, "Fallo al conectar con la base de datos.", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
    }
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
            javax.swing.JOptionPane.showMessageDialog(null, "Fallo al conectar con la base de datos.", "Error de Conexión", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        return datos;
    }
    
    
//OBTENER USUARIOS DE LA BD
    public Object[][] obtenerUsuarios() {
        String query = "SELECT cedula, nombre, apellido, usuario, contrasenia, cargo FROM persona";
        return ejecutarConsulta(query);
    }

    /*
    //PARA TABLA
    public Object[][] obtenerOtrosDatos() {
        String query = "SELECT campo1, campo2, campo3 FROM OtraTabla";
        return ejecutarConsulta(query);
    }
    */

    
    
    
    
    
    
}

