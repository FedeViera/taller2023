package Persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Entidades.Conexion;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import Entidades.Usuario;
import Logica.Controlador;

public class Persistencia_SQL {

//VALIDAR USUARIO Y CONTRASEÑA
    public Usuario obtenerUsuarioYContrasenia(String usuario, String contrasenia, String nombre, String apellido, String cargo) {
        
        Usuario usuarioTemp = null;

        Conexion conexion = new Conexion();
        Connection conn = conexion.conectarMySQL();

        if (conn != null) {
            try {
                String query = "SELECT cedula, nombre, apellido, usuario, contrasenia, cargo FROM usuario WHERE usuario=? AND contrasenia=?";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, usuario);
                preparedStatement.setString(2, contrasenia);
                preparedStatement.setString(3, contrasenia);
                preparedStatement.setString(4, nombre);
                preparedStatement.setString(5, apellido);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    usuarioTemp = new Usuario();
                    usuarioTemp.setCedula(Integer.parseInt(resultSet.getString("cedula")));
                    usuarioTemp.setNombre(resultSet.getString("nombre"));
                    usuarioTemp.setApellido(resultSet.getString("apellido"));
                    usuarioTemp.setUsuario(resultSet.getString("usuario"));
                    usuarioTemp.setContrasenia(resultSet.getString("contrasenia"));
                    usuarioTemp.setCargo(resultSet.getString("cargo"));
                }

                resultSet.close();
                preparedStatement.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                // Aquí debes manejar la excepción apropiadamente (lanzar una excepción personalizada o retornar un valor de error).
            }
        }
        return usuarioTemp;
    }

//CHEQUEAR SI EL USUARIO EXISTE EN LA BD
    private boolean usuarioExiste(Connection conn, Integer cedula, String usuario) throws SQLException {
        String query = "SELECT COUNT(*) AS total FROM usuario WHERE cedula = ? OR usuario = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setInt(1, cedula);
        preparedStatement.setString(2, usuario);
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
                if (!usuarioExiste(conn, cedula, usuario)) {
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
                    JOptionPane.showMessageDialog(null,""+ cargo +": "+nombre+" "+apellido+"\nCI: "+cedula+", fue agregado correctamente.", "Usuario agregado", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    String mensaje = "Ya existe un usuario con ";
                    if (usuarioExiste(conn, cedula, usuario)) {
                        mensaje += "la misma cédula: " + cedula + " o nombre de usuario: " + usuario + "\nPor favor Verifique los datos.";
                    }
                    JOptionPane.showMessageDialog(null, mensaje, "Usuario Duplicado", JOptionPane.WARNING_MESSAGE);  
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
                if (usuarioExiste(conn, cedula, null)) {
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
                    JOptionPane.showMessageDialog(null, "El usuario con cedula: "+cedula+" fue correctamente modificado", "Usuario modificado", JOptionPane.WARNING_MESSAGE);
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
        } else if ("Administrador".equals(nuevoCargo)) {
            String insertQuery = "INSERT INTO " + nuevoCargo + " (usuario_cedula) VALUES (?)";
            PreparedStatement insertStatement = conn.prepareStatement(insertQuery);
            insertStatement.setInt(1, cedula);
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
                JOptionPane.showMessageDialog(null, "El "+cargo+" con cedula: "+cedula+" fue correctamente eliminado", "Usuario eliminado", JOptionPane.WARNING_MESSAGE);
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
        String query = "SELECT u.cedula, u.nombre, u.apellido, u.usuario, u.contrasenia, u.cargo,\n" +
        "CASE WHEN u.cargo = 'Docente' THEN d.grado WHEN u.cargo = 'Adscripto' THEN ad.grado ELSE NULL END AS grado,\n" +
        "CASE WHEN u.cargo = 'Docente' THEN d.asignatura ELSE NULL END AS asignatura\n" +
        "FROM usuario u\n" +
        "LEFT JOIN docente d ON u.cedula = d.usuario_cedula\n" +
        "LEFT JOIN adscripto ad ON u.cedula = ad.usuario_cedula;";
        return ejecutarConsulta(query);
    }

    //CHEQUEAR PORQUE TIRA ERROR AL TRAER NOMBRE Y APELLIDO AL LABEL BIENVENIDA
    /*public String obtenerNombreApellido(String usuario) {
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectarMySQL();

        if (conn != null) {
            try {
                String query = "SELECT nombre, apellido FROM usuario WHERE usuario=?";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, usuario);

                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    String nombre = resultSet.getString("nombre");
                    String apellido = resultSet.getString("apellido");
                    return nombre + " " + apellido;
                }

                resultSet.close();
                preparedStatement.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null; // Usuario no válido
    }*/
}
