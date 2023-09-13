package Persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Entidades.Conexion;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import Entidades.Usuario;
import Entidades.Administrador;
import Entidades.Adscripto;
import Entidades.Docente;
import Grafica.Login_ventana;
import java.util.ArrayList;
import java.util.List;


public class Persistencia_SQL {

    public Persistencia_SQL() {
        
    }

    
//MAPEAR USUARIO - PARA LOGIN
    public Usuario mapearUsuario(String usuario, String contrasenia) {
        
        Usuario usuarioTemp = null;
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectarMySQL();

        if (conn != null) {
            try {
                String query = "SELECT cedula, nombre, apellido, usuario, contrasenia, cargo FROM usuario WHERE usuario=? AND contrasenia=?";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, usuario);
                preparedStatement.setString(2, contrasenia);
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
                System.out.println("Ocurrió un error al mapear el usuario para el login.");
            }
        }
        return usuarioTemp;
    }

//MAPEAR ADMINS
    public List<Administrador> mapearAdministradores() {

        List<Administrador> listaAdministradores = new ArrayList<>();
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectarMySQL();

        if (conn != null) {
            try {
                // Consulta para traer todos los Administradores
                String query = "SELECT\n" +
                                "    u.cedula,\n" +
                                "    u.nombre,\n" +
                                "    u.apellido,\n" +
                                "    u.usuario,\n" +
                                "    u.contrasenia,\n" +
                                "    u.cargo\n" +
                                "FROM\n" +
                                "    usuario u\n" +
                                "INNER JOIN\n" +
                                "    administrador a ON u.cedula = a.usuario_cedula;";

                PreparedStatement preparedStatement = conn.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    Administrador admin = new Administrador();

                    admin.setCedula(resultSet.getInt("cedula"));
                    admin.setNombre(resultSet.getString("nombre"));
                    admin.setApellido(resultSet.getString("apellido"));
                    admin.setUsuario(resultSet.getString("usuario"));
                    admin.setContrasenia(resultSet.getString("contrasenia"));
                    admin.setCargo(resultSet.getString("cargo"));

                    listaAdministradores.add(admin);
                }
                resultSet.close();
                preparedStatement.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("Ocurrió un error al mapear los administradores.");
            }
        }
        return listaAdministradores;
    }

//MAPEAR ADSCRIPTOS
    public List<Adscripto> mapearAdscriptos() {

        List<Adscripto> listaAdscriptos = new ArrayList<>();
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectarMySQL();

        if (conn != null) {
            try {
                // Consulta para traer todos los Adscriptos
                String query =  "SELECT\n" +
                                "    u.cedula,\n" +
                                "    u.nombre,\n" +
                                "    u.apellido,\n" +
                                "    u.usuario,\n" +
                                "    u.contrasenia,\n" +
                                "    u.cargo,\n" +
                                "    ad.grado\n" +
                                "FROM\n" +
                                "    usuario u\n" +
                                "INNER JOIN\n" +
                                "    adscripto ad ON u.cedula = ad.usuario_cedula;";

                PreparedStatement preparedStatement = conn.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    Adscripto adscriptor = new Adscripto();

                    adscriptor.setCedula(resultSet.getInt("cedula"));
                    adscriptor.setNombre(resultSet.getString("nombre"));
                    adscriptor.setApellido(resultSet.getString("apellido"));
                    adscriptor.setUsuario(resultSet.getString("usuario"));
                    adscriptor.setContrasenia(resultSet.getString("contrasenia"));
                    adscriptor.setCargo(resultSet.getString("cargo"));
                    adscriptor.setGrado(resultSet.getInt("grado"));

                    listaAdscriptos.add(adscriptor);
                }
                resultSet.close();
                preparedStatement.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("Ocurrió un error al mapear los adscriptos.");
            }
        }
        return listaAdscriptos;
    }


//MAPEAR DOCENTES
    public List<Docente> mapearDocentes() {

        List<Docente> listaDocentes = new ArrayList<>();
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectarMySQL();

        if (conn != null) {
            try {
                // Consulta para traer todos los Docentes
                String query =  "SELECT\n" +
                                "    u.cedula,\n" +
                                "    u.nombre,\n" +
                                "    u.apellido,\n" +
                                "    u.usuario,\n" +
                                "    u.contrasenia,\n" +
                                "    u.cargo,\n" +
                                "    d.grado,\n" +
                                "    d.asignatura\n" +
                                "FROM\n" +
                                "    usuario u\n" +
                                "INNER JOIN\n" +
                                "    docente d ON u.cedula = d.usuario_cedula;";

                PreparedStatement preparedStatement = conn.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    Docente docente = new Docente();

                    docente.setCedula(resultSet.getInt("cedula"));
                    docente.setNombre(resultSet.getString("nombre"));
                    docente.setApellido(resultSet.getString("apellido"));
                    docente.setUsuario(resultSet.getString("usuario"));
                    docente.setContrasenia(resultSet.getString("contrasenia"));
                    docente.setCargo(resultSet.getString("cargo"));
                    docente.setGrado(resultSet.getInt("grado"));
                    docente.setAsignatura(resultSet.getString("asignatura"));

                    listaDocentes.add(docente);
                }
                resultSet.close();
                preparedStatement.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("Ocurrió un error al mapear los docentes.");
            }
        }
        return listaDocentes;
    }
    

//AGREGAR SOLO USUARIO
    public void agregarUsuario(Usuario usuario) {
        // Obtén la información del usuario
        Integer cedula = usuario.getCedula();
        String nombre = usuario.getNombre();
        String apellido = usuario.getApellido();
        String nickUsuario = usuario.getUsuario();
        String contrasenia = usuario.getContrasenia();
        String cargo = usuario.getCargo();

        Conexion conexion = new Conexion();
        Connection conn = conexion.conectarMySQL();

        if (conn != null) {
            try {
                // Verificar si el usuario ya existe en la base de datos.
                String query = "INSERT INTO usuario (cedula, nombre, apellido, usuario, contrasenia, cargo) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setInt(1, cedula);
                preparedStatement.setString(2, nombre);
                preparedStatement.setString(3, apellido);
                preparedStatement.setString(4, nickUsuario);
                preparedStatement.setString(5, contrasenia);
                preparedStatement.setString(6, cargo);

                preparedStatement.executeUpdate();
                preparedStatement.close();

                JOptionPane.showMessageDialog(null, "" + cargo + ": " + nombre + " " + apellido + "\nCI: " + cedula + ", fue agregado correctamente.", "Usuario agregado", JOptionPane.INFORMATION_MESSAGE);
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                //JOptionPane.showMessageDialog(null, "Error al agregar el usuario.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            //JOptionPane.showMessageDialog(null, "Fallo al conectar con la base de datos.", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
        }
    }

//AGREGAR ADMINISTRADOR
    public void agregarAdministrador(Administrador administrador) {
        // Insertar en la tabla correspondiente según el cargo
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectarMySQL();

        if (conn != null) {
            try {
                Integer cedula = administrador.getCedula();
                String queryAdmin = "INSERT INTO administrador (usuario_cedula) VALUES (?)";
                PreparedStatement preparedStatementAdmin = conn.prepareStatement(queryAdmin);
                preparedStatementAdmin.setInt(1, cedula);
                preparedStatementAdmin.executeUpdate();
                preparedStatementAdmin.close();

                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                //JOptionPane.showMessageDialog(null, "Error al agregar el administrador.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            //JOptionPane.showMessageDialog(null, "Fallo al conectar con la base de datos.", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
        }
    }

//AGREGAR ADSCRIPTO
    public void agregarAdscripto(Adscripto adscripto) {
        // Insertar en la tabla correspondiente según el cargo
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectarMySQL();

        if (conn != null) {
            try {
                Integer cedula = adscripto.getCedula();
                Integer grado = adscripto.getGrado();
                String queryAdscripto = "INSERT INTO adscripto (usuario_cedula, grado) VALUES (?, ?)";
                PreparedStatement preparedStatementAdscripto = conn.prepareStatement(queryAdscripto);
                preparedStatementAdscripto.setInt(1, cedula);
                preparedStatementAdscripto.setInt(2, grado);
                preparedStatementAdscripto.executeUpdate();
                preparedStatementAdscripto.close();

                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                //JOptionPane.showMessageDialog(null, "Error al agregar el adscripto.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            //JOptionPane.showMessageDialog(null, "Fallo al conectar con la base de datos.", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
        }
    }

//AGREGAR DOCENTE
    public void agregarDocente(Docente docente) {
        // Insertar en la tabla correspondiente según el cargo
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectarMySQL();

        if (conn != null) {
            try {
                Integer cedula = docente.getCedula();
                Integer grado = docente.getGrado();
                String asignatura = docente.getAsignatura();
                String queryDocente = "INSERT INTO docente (usuario_cedula, grado, asignatura) VALUES (?, ?, ?)";
                PreparedStatement preparedStatementDocente = conn.prepareStatement(queryDocente);
                preparedStatementDocente.setInt(1, cedula);
                preparedStatementDocente.setInt(2, grado);
                preparedStatementDocente.setString(3, asignatura);
                preparedStatementDocente.executeUpdate();
                preparedStatementDocente.close();

                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al agregar el docente.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Fallo al conectar con la base de datos.", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
        }
    }

//ELIMINAR DUSUARIOS DE LA BASE DE DATOS (Y SU RELACION CON TABLA ADMINISTRADOR, ADSCRIPTO O DOCENTE)  
    public void eliminarUsuario(int cedula, String cargo) {
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
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

//CHEQUEAR SI EL USUARIO EXISTE EN LA BD - PARA MODIFICAR CARGO DE USUARIO
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

    
    
//OBTENER CARGO ACTUAL - PARA MODIFICAR CARGO DE USUARIO    
    private String obtenerCargoActual(Connection conn, int cedula) throws SQLException {

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
    
    

    private void moverUsuario(Integer cedula, String cargoActual, String nuevoCargo, Integer grado, String asignatura) throws SQLException {
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectarMySQL();
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
    
    
//ACTUALIZAR DATO EN BD
    public void actualizarUsuario(Docente docente) {
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectarMySQL();
        
        Integer cedula = docente.getCedula();
        String nuevaContrasenia = docente.getContrasenia();
        String nuevoCargo = docente.getCargo();
        Integer nuevoGrado = docente.getGrado();
        String nuevaAsignatura = docente.getAsignatura();

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
                    moverUsuario(cedula, cargoActual, nuevoCargo, nuevoGrado, nuevaAsignatura);
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
