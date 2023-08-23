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
    public void agregarDato(Integer cedula, String nombre, String apellido, String usuario, String contrasenia, String cargo, String grado, String asignatura) {
        String cedulaStr = cedula.toString();

        if (!cedulaStr.matches("\\d{8}")) {
            JOptionPane.showMessageDialog(null, "La cédula debe contener exactamente 8 dígitos numéricos.", "Cédula Inválida", JOptionPane.WARNING_MESSAGE);
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
                    
                    // Insertar en la tabla correspondiente según el cargo
                    if ("Administrador".equals(cargo)) {
                        String queryAdmin = "INSERT INTO administrador (usuario_cedula) VALUES (?)";
                        PreparedStatement preparedStatementAdmin = conn.prepareStatement(queryAdmin);
                        preparedStatementAdmin.setInt(1, cedula);
                        preparedStatementAdmin.executeUpdate();
                        preparedStatementAdmin.close();
                    } else if ("Adscripto".equals(cargo)) {
                        String queryAdscripto = "INSERT INTO adscripto (usuario_cedula, grado) VALUES (?, ?)";
                        PreparedStatement preparedStatementAdscripto = conn.prepareStatement(queryAdscripto);
                        preparedStatementAdscripto.setInt(1, cedula);
                        preparedStatementAdscripto.setString(2, grado); // Corregido
                        preparedStatementAdscripto.executeUpdate();
                        preparedStatementAdscripto.close();
                    } else if ("Docente".equals(cargo)) {
                        String queryDocente = "INSERT INTO docente (usuario_cedula, grado, asignatura) VALUES (?, ?, ?)";
                        PreparedStatement preparedStatementDocente = conn.prepareStatement(queryDocente);
                        preparedStatementDocente.setInt(1, cedula);
                        preparedStatementDocente.setString(2, grado); // Corregido
                        preparedStatementDocente.setString(3, asignatura); // Corregido
                        preparedStatementDocente.executeUpdate();
                        preparedStatementDocente.close();
                    }
                    
                    JOptionPane.showMessageDialog(null, "" + cargo + " agregado exitosamente.", "Agregado correctamente", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "El usuario con cédula " + cedula + " ya existe en la base de datos.", "Usuario Duplicado", JOptionPane.WARNING_MESSAGE);
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

//CARGO ACTUAL    
    private String obtenerCargoActual(Connection conn, Integer cedula) throws SQLException {
        String cargoActual = null;

        String query = "SELECT cargo FROM usuario WHERE cedula = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setInt(1, cedula);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            cargoActual = resultSet.getString("cargo");
        }

        resultSet.close();
        preparedStatement.close();

        return cargoActual;
    }
    
//ACTUALIZAR DATO EN BD
    public void actualizarUsuario(Integer cedula, String nuevaContrasenia, String nuevoCargo, Integer grado, String asignatura) {
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectarMySQL();

        if (conn != null) {
            try {
                // Verificar si el usuario existe en la base de datos antes de actualizarlo
                if (usuarioExiste(conn, cedula)) {
                    // Obtener el cargo actual del usuario
                    String cargoActual = obtenerCargoActual(conn, cedula);

                    String query = "UPDATE usuario SET contrasenia = ?, cargo = ? WHERE cedula = ?";
                    PreparedStatement preparedStatement = conn.prepareStatement(query);
                    preparedStatement.setString(1, nuevaContrasenia);
                    preparedStatement.setString(2, nuevoCargo);
                    preparedStatement.setInt(3, cedula);

                    preparedStatement.executeUpdate();
                    preparedStatement.close();
                    
                    // Mover al usuario a la tabla correspondiente
                    moverUsuario(conn, cedula, cargoActual, nuevoCargo, grado, asignatura);
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

    private void moverUsuario(Connection conn, Integer cedula, String cargoActual, String nuevoCargo, Integer grado, String asignatura) throws SQLException {
        // Eliminar al usuario de la tabla actual
        String deleteQuery = "DELETE FROM " + cargoActual + " WHERE usuario_cedula = ?";
        PreparedStatement deleteStatement = conn.prepareStatement(deleteQuery);
        deleteStatement.setInt(1, cedula);
        deleteStatement.executeUpdate();
        
        //System.out.println("Valor de asignatura: " + asignatura);

        // Insertar al usuario en la nueva tabla correspondiente al nuevo cargo
        if ("Docente".equals(nuevoCargo)) {
            String insertQuery = "INSERT INTO " + nuevoCargo + " (usuario_cedula, grado, asignatura) VALUES (?, ?, ?)";
            PreparedStatement insertStatement = conn.prepareStatement(insertQuery);
            insertStatement.setInt(1, cedula);
            insertStatement.setInt(2, grado);
            insertStatement.setString(3, asignatura);
            insertStatement.executeUpdate();
        } else if ("Adscripto".equals(nuevoCargo)) {
            String insertQuery = "INSERT INTO " + nuevoCargo + " (usuario_cedula, grado) VALUES (?, ?)";
            PreparedStatement insertStatement = conn.prepareStatement(insertQuery);
            insertStatement.setInt(1, cedula);
            insertStatement.setInt(2, grado);
            insertStatement.executeUpdate();
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
    public void eliminarDato(int cedula, String cargo) {
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectarMySQL();

        if (conn != null) {
            try {
                if ("Administrador".equals(cargo)) {
                    eliminarAdministrador(conn, cedula);
                } else if ("Adscripto".equals(cargo)) {
                    eliminarAdscripto(conn, cedula);
                } else if ("Docente".equals(cargo)) {
                    eliminarDocente(conn, cedula);
                }

                eliminarUsuario(conn, cedula);

                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Fallo al conectar con la base de datos.", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void eliminarAdministrador(Connection conn, int cedula) throws SQLException {
        String query = "DELETE FROM administrador WHERE usuario_cedula = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setInt(1, cedula);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    private void eliminarAdscripto(Connection conn, int cedula) throws SQLException {
        String query = "DELETE FROM adscripto WHERE usuario_cedula = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setInt(1, cedula);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    private void eliminarDocente(Connection conn, int cedula) throws SQLException {
        String query = "DELETE FROM docente WHERE usuario_cedula = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setInt(1, cedula);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    private void eliminarUsuario(Connection conn, int cedula) throws SQLException {
        String query = "DELETE FROM usuario WHERE cedula = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setInt(1, cedula);
        preparedStatement.executeUpdate();
        preparedStatement.close();
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
