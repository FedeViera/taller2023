package Persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Entidades.Conexion;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import Entidades.Usuario;


public class Usuario_SQL {
    
//VALIDAR USUARIO Y CONTRASEÑA
    public String validarUsuarioYContraseña(String usuario, String contrasenia) {
    
        String cargo = null;
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectarMySQL();

        if (conn != null) {
            try {
                String query = "SELECT cargo, nombre, apellido FROM usuario WHERE usuario=? AND contrasenia=?";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, usuario);
                preparedStatement.setString(2, contrasenia);

                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    cargo = resultSet.getString("cargo");
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrectos", "Error de autenticación", JOptionPane.ERROR_MESSAGE);
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
    private boolean usuarioExiste(Connection conn, Integer cedula) throws SQLException {
        String query = "SELECT COUNT(*) AS total FROM usuario WHERE cedula = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setInt(1, cedula);
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
        String cedulaStr = cedula.toString();
        if (cedulaStr.length() != 8) {
            JOptionPane.showMessageDialog(null, "La cédula debe tener exactamente 8 caracteres.", "Cédula Inválida", JOptionPane.WARNING_MESSAGE);
            return; // Salir del método si la cédula es inválida
        }

        Conexion conexion = new Conexion();
        Connection conn = conexion.conectarMySQL();

        if (conn != null) {
            try {
                // Verificar si el usuario ya existe en la base de datos.
                if (!usuarioExiste(conn, cedula)) {
                    String query = "INSERT INTO usuario (cedula, nombre, apellido, usuario, contrasenia, cargo) VALUES (?, ?, ?, ?, ?, ?)";
                    PreparedStatement preparedStatement = conn.prepareStatement(query);
                    preparedStatement.setInt(1, cedula);
                    preparedStatement.setString(2, nombre);
                    preparedStatement.setString(3, apellido);
                    preparedStatement.setString(4, usuario);
                    preparedStatement.setString(5, contrasenia);
                    preparedStatement.setString(6, cargo);

                    preparedStatement.executeUpdate();

                    preparedStatement.close();
                    JOptionPane.showMessageDialog(null, "Usuario "+cargo+" agregado exitosamente.", "Agregado correctamente", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "El usuario con cédula "+cedula+" ya existe en la base de datos.", "Usuario Duplicado", JOptionPane.WARNING_MESSAGE);
                }
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al agregar el usuario.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Fallo al conectar con la base de datos.", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    
    
//ACTUALIZAR DATO EN BD
    public void actualizarUsuario(Integer cedula, String nuevaContrasenia, String nuevoCargo) {
    Conexion conexion = new Conexion();
    Connection conn = conexion.conectarMySQL();
        
        if (conn != null) {
            try {
                // Verificar si el usuario existe en la base de datos antes de actualizarlo
                if (usuarioExiste(conn, cedula)) {
                    String query = "UPDATE usuario SET contrasenia = ?, cargo = ? WHERE cedula = ?";
                    PreparedStatement preparedStatement = conn.prepareStatement(query);
                    preparedStatement.setString(1, nuevaContrasenia);
                    preparedStatement.setString(2, nuevoCargo);
                    preparedStatement.setInt(3, cedula);

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
            String query = "DELETE FROM usuario WHERE cedula = ?";
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
        String query = "SELECT cedula, nombre, apellido, usuario, contrasenia, cargo FROM usuario";
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

