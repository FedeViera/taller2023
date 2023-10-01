package Persistencia;

import Entidades.Actividad;
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
import Entidades.Curso;
import Entidades.Estudiante;
import Entidades.Clase;
import Grafica.Login_ventana;
import java.util.ArrayList;
import java.util.List;


public class Persistencia_SQL {

    public Persistencia_SQL() {
        
    }
   
    
//MAPEAR 1 USUARIO - PARA LOGIN
    public Usuario mapearUsuario(String usuario, String contrasenia) {
        Usuario usuarioTemp = null;
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectarMySQL();

        if (conn != null) {
            try {
                String mapQuery = "SELECT cedula, nombre, apellido, usuario, contrasenia, cargo FROM usuario WHERE usuario=? AND contrasenia=?";
                PreparedStatement preparedStatement = conn.prepareStatement(mapQuery);
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
                String insertQuery = "INSERT INTO usuario (cedula, nombre, apellido, usuario, contrasenia, cargo) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);
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

    
//CHEQUEAR SI EL USUARIO EXISTE EN LA BD - PARA MODIFICAR CARGO DE USUARIO
    private boolean usuarioExiste(Connection conn, Integer cedula, String usuario) throws SQLException {
        String searchQuery = "SELECT COUNT(*) AS total FROM usuario WHERE cedula = ? OR usuario = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(searchQuery);
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

        String searchQuery = "SELECT cargo FROM usuario WHERE cedula = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(searchQuery);
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

                    String updateQuery = "UPDATE usuario SET contrasenia = ?, cargo = ? WHERE cedula = ?";
                    PreparedStatement preparedStatement = conn.prepareStatement(updateQuery);
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
    
    private void eliminarUsuario(Connection conn, int cedula) throws SQLException {
        String deleteQuery = "DELETE FROM usuario WHERE cedula = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(deleteQuery);
        preparedStatement.setInt(1, cedula);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }    
   
    private void eliminarAdministrador(Connection conn, int cedula) throws SQLException {
        String deleteQuery = "DELETE FROM administrador WHERE usuario_cedula = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(deleteQuery);
        preparedStatement.setInt(1, cedula);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    private void eliminarAdscripto(Connection conn, int cedula) throws SQLException {
        String deleteQuery = "DELETE FROM adscripto WHERE usuario_cedula = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(deleteQuery);
        preparedStatement.setInt(1, cedula);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    private void eliminarDocente(Connection conn, int cedula) throws SQLException {
        String deleteQuery = "DELETE FROM docente WHERE usuario_cedula = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(deleteQuery);
        preparedStatement.setInt(1, cedula);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

// ===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===   
    
//MAPEAR ADMINS
    public List<Administrador> mapearAdministradores() {
        List<Administrador> listaAdministradores = new ArrayList<>();
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectarMySQL();

        if (conn != null) {
            try {
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

//AGREGAR ADMINISTRADOR
    public void agregarAdministrador(Administrador administrador) {
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectarMySQL();
        
        Integer cedula = administrador.getCedula();

        if (conn != null) {
            try {
                String query = "INSERT INTO administrador (usuario_cedula) VALUES (?)";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setInt(1, cedula);
                preparedStatement.executeUpdate();
                preparedStatement.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                //JOptionPane.showMessageDialog(null, "Error al agregar el administrador.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            //JOptionPane.showMessageDialog(null, "Fallo al conectar con la base de datos.", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
        }
    }    

// ===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===
    
//MAPEAR ADSCRIPTOS
    public List<Adscripto> mapearAdscriptos() {
        List<Adscripto> listaAdscriptos = new ArrayList<>();
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectarMySQL();

        if (conn != null) {
            try {
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

//AGREGAR ADSCRIPTO
    public void agregarAdscripto(Adscripto adscripto) {
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectarMySQL();
        
        Integer cedula = adscripto.getCedula();
        Integer grado = adscripto.getGrado();

        if (conn != null) {
            try {
                String insertQuery = "INSERT INTO adscripto (usuario_cedula, grado) VALUES (?, ?)";
                PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);
                preparedStatement.setInt(1, cedula);
                preparedStatement.setInt(2, grado);
                preparedStatement.executeUpdate();
                preparedStatement.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                //JOptionPane.showMessageDialog(null, "Error al agregar el adscripto.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            //JOptionPane.showMessageDialog(null, "Fallo al conectar con la base de datos.", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
        }
    }    

// ===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===    
    
//MAPEAR DOCENTES
    public List<Docente> mapearDocentes() {
        List<Docente> listaDocentes = new ArrayList<>();
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectarMySQL();

        if (conn != null) {
            try {
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
    
//AGREGAR DOCENTE
    public void agregarDocente(Docente docente) {
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectarMySQL();

        Integer cedula = docente.getCedula();
        Integer grado = docente.getGrado();
        String asignatura = docente.getAsignatura();
        
        if (conn != null) {
            try {
                String query = "INSERT INTO docente (usuario_cedula, grado, asignatura) VALUES (?, ?, ?)";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setInt(1, cedula);
                preparedStatement.setInt(2, grado);
                preparedStatement.setString(3, asignatura);
                preparedStatement.executeUpdate();
                preparedStatement.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al agregar el docente.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Fallo al conectar con la base de datos.", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
        }
    }    

// ===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===    
    
//MAPEAR CURSOS
    public List<Curso> mapearCursos() {
        List<Curso> listaCursos = new ArrayList<>();
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectarMySQL();

        if (conn != null) {
            try {
                String query =  "SELECT * from curso";

                PreparedStatement preparedStatement = conn.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    Curso curso = new Curso();
                    curso.setId_curso(resultSet.getInt("id_curso"));
                    curso.setClaseYgrupo(resultSet.getString("claseYgrupo"));
                    curso.setAsignatura(resultSet.getString("asignatura"));

                    listaCursos.add(curso);
                }
                resultSet.close();
                preparedStatement.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("Ocurrió un error al mapear los cursos.");
            }
        }
        return listaCursos;
    }
    
    
//AGREGAR CURSO
    public void agregarCurso(Curso curso) {
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectarMySQL();
        
        String idclaseYgrupo = curso.getClaseYgrupo();
        String asignatura = curso.getAsignatura();

        if (conn != null) {
            try {
                String insertQuery = "INSERT INTO curso (claseYgrupo, asignatura) VALUES (?, ?)";
                PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);
                preparedStatement.setString(1, idclaseYgrupo);
                preparedStatement.setString(2, asignatura);
                preparedStatement.executeUpdate();
                preparedStatement.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al agregar el curso.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Fallo al conectar con la base de datos.", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
        }
    }    
    
    
//ELIMINAR CURSO
    public void eliminarCurso(Curso curso) {
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectarMySQL();
        
        int idCurso = curso.getId_curso();

        if (conn != null) {
            try {
                String deleteQuery = "DELETE FROM curso WHERE id_curso = ?";
                PreparedStatement preparedStatement = conn.prepareStatement(deleteQuery);
                preparedStatement.setInt(1, idCurso);
                preparedStatement.executeUpdate();
                preparedStatement.close();
                JOptionPane.showMessageDialog(null, "El curso  fue correctamente eliminado", "Curso eliminado", JOptionPane.WARNING_MESSAGE);
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al eliminar el curso.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Fallo al conectar con la base de datos.", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
        }
    }        

// ===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===    
    
//MAPEAR ESTUDIANTES
    public List<Estudiante> mapearEstudiantes() {
        List<Estudiante> listaEstudiantes = new ArrayList<>();
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectarMySQL();

        if (conn != null) {
            try {
                String query =  "SELECT * from estudiante";

                PreparedStatement preparedStatement = conn.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    Estudiante estudiante = new Estudiante();
                    estudiante.setId_estudiante(Integer.parseInt(resultSet.getString("id_estudiante")));
                    estudiante.setNombre(resultSet.getString("nombre"));
                    estudiante.setApellido(resultSet.getString("apellido"));
                    estudiante.setEdad(Integer.parseInt(resultSet.getString("edad")));

                    listaEstudiantes.add(estudiante);
                }
                resultSet.close();
                preparedStatement.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("Ocurrió un error al mapear los estudiantes.");
            }
        }
        return listaEstudiantes;
    }    
    
//AGREGAR ESTUDIANTE
    public void agregarEstudiante(Estudiante estudiante) {
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectarMySQL();
        
        int idEstudiante = estudiante.getId_estudiante();
        String nombreEstudiante = estudiante.getNombre();
        String apellidoEstudiante = estudiante.getApellido();
        int edadEstudiante = estudiante.getEdad();

        if (conn != null) {
            try {
                String insertQuery = "INSERT INTO estudiante (id_estudiante, nombre, apellido, edad) VALUES (?, ?, ?, ?)";
                PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);
                preparedStatement.setInt(1, idEstudiante);
                preparedStatement.setString(2, nombreEstudiante);
                preparedStatement.setString(3, apellidoEstudiante);
                preparedStatement.setInt(4, edadEstudiante);
                preparedStatement.executeUpdate();
                preparedStatement.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al agregar el estudiante.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Fallo al conectar con la base de datos.", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
        }
    }    
    
//ELIMINAR ESTUDIANTE
    public void eliminarEstudiante(Estudiante estudiante) {
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectarMySQL();
        
        int idEstudiante = estudiante.getId_estudiante();
        String nombre = estudiante.getNombre();
        String apellido = estudiante.getApellido();

        if (conn != null) {
            try {
                String deleteQuery = "DELETE FROM estudiante WHERE id_estudiante = ?";
                PreparedStatement preparedStatement = conn.prepareStatement(deleteQuery);
                preparedStatement.setInt(1, idEstudiante);
                preparedStatement.executeUpdate();
                preparedStatement.close();
                JOptionPane.showMessageDialog(null, "El estudiante "+nombre+" "+apellido+", CI: "+idEstudiante+" fue correctamente eliminado", "Estudiante eliminado", JOptionPane.WARNING_MESSAGE);
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al eliminar el curso.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Fallo al conectar con la base de datos.", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
        }
    }    
    
// ===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===    

    
//MAPEAR CURSOS
    public List<Clase> mapearClases() {
        List<Clase> listaClases = new ArrayList<>();
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectarMySQL();

        if (conn != null) {
            try {
                String query =  "SELECT * from clase";

                PreparedStatement preparedStatement = conn.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    Clase clase = new Clase();
                    clase.setId_clase(resultSet.getInt("id_clase"));
                    clase.setFecha(resultSet.getDate("fecha clase"));
                    clase.setDesarrollo(resultSet.getString("desarrollo"));
                    clase.setId_curso(resultSet.getInt("curso_id_curso"));

                    listaClases.add(clase);
                }
                resultSet.close();
                preparedStatement.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("Ocurrió un error al mapear las clases.");
            }
        }
        return listaClases;
    }    

//AGREGAR INFORME
    public void agregarClase(Clase clase) {
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectarMySQL();
        
        Integer idClase = clase.getId_clase();
        java.sql.Date fecha = clase.getFecha();
        String desarrollo = clase.getDesarrollo();
        Integer idCurso = clase.getId_curso();
        

        if (conn != null) {
            try {
                String insertQuery = "INSERT INTO clase (fecha_clase, desarrollo, curso_id_curso) VALUES (?, ?, ?)";
                PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);
                preparedStatement.setDate(1, fecha);
                preparedStatement.setString(2, desarrollo);
                preparedStatement.setInt(3, idCurso);
                preparedStatement.executeUpdate();
                preparedStatement.close();
                JOptionPane.showMessageDialog(null, "La clase se agrego correctamente.", "Agregar clase", JOptionPane.INFORMATION_MESSAGE);
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al agregar la clase.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Fallo al conectar con la base de datos.", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
        }
    }        
    
//ELIMINAR INFORME
    public void eliminarClase(Clase clase) {
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectarMySQL();
        
        int idClase = clase.getId_clase();
        

        if (conn != null) {
            try {
                String deleteQuery = "DELETE FROM clase WHERE id_clase = ?";
                PreparedStatement preparedStatement = conn.prepareStatement(deleteQuery);
                preparedStatement.setInt(1, idClase);
                preparedStatement.executeUpdate();
                preparedStatement.close();
                JOptionPane.showMessageDialog(null, "La clase fue correctamente eliminada", "Clase eliminada", JOptionPane.WARNING_MESSAGE);
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al eliminar la clase.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Fallo al conectar con la base de datos.", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
        }
    } 
 
// ===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===    
    
//MAPEAR ACTIVIDADES POR ESTUDIANTE
    public List<Actividad> mapearActividades_PorEstudiante(Estudiante estudiante) {
        List<Actividad> listaActividades = new ArrayList<>();
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectarMySQL();

        if (conn != null) {
            try {
                String query =  "SELECT * from actividad WHERE estudiante_id_estudiante = (?)";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setInt(1, estudiante.getId_estudiante()); // Establece el ID del estudiante en la consulta
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    Actividad actividad = new Actividad();
                    actividad.setId_actividad(resultSet.getInt("id_actividad"));
                    actividad.setId_estudiante(resultSet.getInt("estudiante_id_estudiante"));
                    actividad.setTipo(resultSet.getString("tipo"));
                    actividad.setDescripcion(resultSet.getString("descripcion"));
                    actividad.setCalificacion(resultSet.getFloat("calificacion"));
                    actividad.setFecha(resultSet.getDate("fecha"));

                    listaActividades.add(actividad);
                }
                resultSet.close();
                preparedStatement.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("Ocurrió un error al mapear los informes.");
            }
        }
        return listaActividades;
    }

//MAPEAR NOMBRE, APELLIDO Y TODAS LAS CALIFICACIONES DE UN ESTUDIANTE EN DETERMINADO CURSO    
    public List<Object[]> mapearCalificacionesCurso(int cursoId) {
        List<Object[]> datosEstudiantesCalificaciones = new ArrayList<>();
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectarMySQL();

        if (conn != null) {
            try {
                String query =  "SELECT\n" +
                            "    e.nombre AS Nombre,\n" +
                            "    e.apellido AS Apellido,\n" +
                            "    GROUP_CONCAT(a.calificacion SEPARATOR ' | ') AS Calificaciones\n" +
                            "FROM\n" +
                            "    estudiante e\n" +
                            "JOIN\n" +
                            "    actividad a ON e.id_estudiante = a.estudiante_id_estudiante\n" +
                            "JOIN\n" +
                            "    curso_has_estudiante ce ON e.id_estudiante = ce.estudiante_id_estudiante\n" +
                            "WHERE\n" +
                            "    ce.curso_id_curso = ?\n" +
                            "GROUP BY\n" +
                            "    e.nombre, e.apellido;";

                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setInt(1, cursoId);  // Establecemos el valor del cursoId en el marcador de posición

                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    String nombre = resultSet.getString("Nombre");
                    String apellido = resultSet.getString("Apellido");
                    String calificaciones = resultSet.getString("Calificaciones");  // Ahora es una cadena de texto

                    datosEstudiantesCalificaciones.add(new Object[]{nombre, apellido, calificaciones});
                }
                resultSet.close();
                preparedStatement.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("Ocurrió un error al obtener los datos de estudiantes y calificaciones.");
            }
        }
        return datosEstudiantesCalificaciones;
    }

    

    
//AGREGAR INFORME
    public void agregarActividad(Estudiante estudiante, Actividad actividad) {
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectarMySQL();
        
        int idEstudiante = estudiante.getId_estudiante();
        String tipo = actividad.getTipo();
        String descripcion = actividad.getDescripcion();
        float calificacion = actividad.getCalificacion();
        java.sql.Date fecha = actividad.getFecha();
  
        if (conn != null) {
            try {
                String insertQuery = "INSERT INTO actividad (estudiante_id_estudiante, tipo, descripcion, calificacion, fecha) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);
                preparedStatement.setInt(1, idEstudiante);
                preparedStatement.setString(2, tipo);
                preparedStatement.setString(3, descripcion);
                preparedStatement.setFloat(4, calificacion);
                preparedStatement.setDate(5, fecha);
                preparedStatement.executeUpdate();
                preparedStatement.close();
                JOptionPane.showMessageDialog(null, "La actividad fue correctamente agregada.", "Actividad agregada", JOptionPane.INFORMATION_MESSAGE);
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al agregar la actividad.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Fallo al conectar con la base de datos.", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
        }
    }         

//MODIFICAR ACTIVIDAD
    public void modificarActividad(Actividad actividad) {
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectarMySQL();

        int idActividad = actividad.getId_actividad();
        String tipo = actividad.getTipo();
        String descripcion = actividad.getDescripcion();
        float calificacion = actividad.getCalificacion();
        java.sql.Date fecha = actividad.getFecha();

        if (conn != null) {
            try {
                String updateQuery = "UPDATE actividad SET tipo = ?, descripcion = ?, calificacion = ?, fecha = ? WHERE id_actividad = ?";
                PreparedStatement preparedStatement = conn.prepareStatement(updateQuery);
                preparedStatement.setString(1, tipo);
                preparedStatement.setString(2, descripcion);
                preparedStatement.setFloat(3, calificacion);
                preparedStatement.setDate(4, fecha);
                preparedStatement.setInt(5, idActividad);

                int rowCount = preparedStatement.executeUpdate();
                preparedStatement.close();

                if (rowCount > 0) {
                    JOptionPane.showMessageDialog(null, "La actividad fue correctamente actualizada.", "Actividad actualizada", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró la actividad con el ID especificado.", "Actividad no encontrada", JOptionPane.WARNING_MESSAGE);
                }
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al actualizar la actividad.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Fallo al conectar con la base de datos.", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
        }
    }
    
//ELIMINAR ACTIVIDAD
    public void eliminarActividad(Actividad actividad) {
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectarMySQL();
        
        int idActividad = actividad.getId_actividad();

        if (conn != null) {
            try {
                String deleteQuery = "DELETE FROM actividad WHERE id_actividad = ?";
                PreparedStatement preparedStatement = conn.prepareStatement(deleteQuery);
                preparedStatement.setInt(1, idActividad);
                preparedStatement.executeUpdate();
                preparedStatement.close();
                JOptionPane.showMessageDialog(null, "La actividad fue correctamente eliminada.", "Actividad eliminada", JOptionPane.WARNING_MESSAGE);
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al eliminar la actividad.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Fallo al conectar con la base de datos.", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
        }
    }    
    
    
    
// ===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===    
//     TABLAS INTERMEDIAS RELACIONADAS CON CURSO    
    
//AGREGAR ESTUDIANTE A CURSO (TABLA curso_has_estudiane)
    public void agregarEstudianteACurso(Curso curso, Estudiante estudiante) {
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectarMySQL();
        
        int idCurso = curso.getId_curso();
        int idEstudiante = estudiante.getId_estudiante();

        if (conn != null) {
            try {
                String insertQuery = "INSERT INTO curso_has_estudiante (curso_id_curso, estudiante_id_estudiante) VALUES (?, ?)";
                PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);
                preparedStatement.setInt(1, idCurso);
                preparedStatement.setInt(2, idEstudiante);
                preparedStatement.executeUpdate();
                preparedStatement.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al agregar el estudiante al curso.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Fallo al conectar con la base de datos.", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
        }
    } 
    
//AGREGAR DOCENTE A CURSO (TABLA curso_has_docente)
    public void agregarDocenteACurso(Curso curso, Docente docente) {
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectarMySQL();
        
        int idCurso = curso.getId_curso();
        int cedulaDocente = docente.getCedula();

        if (conn != null) {
            try {
                String insertQuery = "INSERT INTO curso_has_docente (curso_id_curso, docente_usuario_cedula) VALUES (?, ?)";
                PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);
                preparedStatement.setInt(1, idCurso);
                preparedStatement.setInt(2, cedulaDocente);
                preparedStatement.executeUpdate();
                preparedStatement.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al agregar el docente al curso.", "Error Agregar Docente", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Fallo al conectar con la base de datos.", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
        }
    }     

//REASIGNAR DOCENTE A CURSO (TABLA curso_has_docente)    
    public void reasignarDocenteACurso(Docente docente, int nuevoDocente ) {
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectarMySQL();

        int viejaCedula = docente.getCedula();
        int nuevaCedula = nuevoDocente;
        

        if (conn != null) {
            try {
                String updateQuery = "UPDATE curso_has_docente SET docente_usuario_cedula = (?) WHERE docente_usuario_cedula = (?)";
                PreparedStatement preparedStatement = conn.prepareStatement(updateQuery);
                preparedStatement.setInt(1, nuevaCedula);
                preparedStatement.setInt(2, viejaCedula);
                preparedStatement.executeUpdate();
                preparedStatement.close();        
                
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al reasignar el docente", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Fallo al conectar con la base de datos.", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
        }
    }     
    
//ELIMINAR DOCENTE A CURSO (TABLA curso_has_docente)
    public void eliminarDocenteACurso(Docente docente) {
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectarMySQL();
        
        int cedula = docente.getCedula();

        if (conn != null) {
            try {
                String deleteQuery = "DELETE FROM curso_has_docente WHERE docente_usuario_cedula = ?";
                PreparedStatement preparedStatement = conn.prepareStatement(deleteQuery);
                preparedStatement.setInt(1, cedula);
                preparedStatement.executeUpdate();
                preparedStatement.close();
                JOptionPane.showMessageDialog(null, "El docente fue eliminado del curso", "Docente eliminado", JOptionPane.WARNING_MESSAGE);
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al eliminar el curso.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Fallo al conectar con la base de datos.", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
        }
    }  
    
//ELIMINAR CURSO CON DOCENTE (TABLA curso_has_docente)
    public void eliminarCursoConDocente(Curso curso) {
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectarMySQL();
        
        int cursoID = curso.getId_curso();

        if (conn != null) {
            try {
                String deleteQuery = "DELETE FROM curso_has_docente WHERE curso_id_curso = ?";
                PreparedStatement preparedStatement = conn.prepareStatement(deleteQuery);
                preparedStatement.setInt(1, cursoID);
                preparedStatement.executeUpdate();
                preparedStatement.close();
                //JOptionPane.showMessageDialog(null, "El curso fue correctamente eliminado", "Curso eliminado", JOptionPane.WARNING_MESSAGE);
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al eliminar el curso.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Fallo al conectar con la base de datos.", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
        }
    } 
    
//ELIMINAR CURSO CON DOCENTE (TABLA curso_has_docente)
    public void eliminarCursoConEstudiantes(Curso curso) {
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectarMySQL();
        
        int cursoID = curso.getId_curso();

        if (conn != null) {
            try {
                String deleteQuery = "DELETE FROM curso_has_estudiante WHERE curso_id_curso = ?";
                PreparedStatement preparedStatement = conn.prepareStatement(deleteQuery);
                preparedStatement.setInt(1, cursoID);
                preparedStatement.executeUpdate();
                preparedStatement.close();
                //JOptionPane.showMessageDialog(null, "El curso fue correctamente eliminado", "Curso eliminado", JOptionPane.WARNING_MESSAGE);
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al eliminar el curso.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Fallo al conectar con la base de datos.", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
        }
    }     
   
  
//VERIFICAR SI ESTUDIANTE EXISTE    
    private boolean existeEstudiante(Connection conn, int idCurso, int idEstudiante) throws SQLException {
        String query = "SELECT * FROM curso_has_estudiante WHERE curso_id_curso = ? AND estudiante_id_estudiante = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setInt(1, idCurso);
        preparedStatement.setInt(2, idEstudiante);
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean existe = resultSet.next(); // Si hay al menos una fila, ya existe la entrada
        resultSet.close();
        preparedStatement.close();
        return existe;
    }     

// AGREGAR ESTUDIANTES A CURSO (TABLA curso_has_estudiante)
    public void agregarEstudiantesACurso(Curso curso, List<Estudiante> estudiantes) {
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectarMySQL();
        int idCurso = curso.getId_curso();

        if (conn != null) {
            try {
                for (Estudiante estudiante : estudiantes) {
                    int idEstudiante = estudiante.getId_estudiante();

                    // Verificar si ya existe una entrada para este curso y estudiante
                    if (!existeEstudiante(conn, idCurso, idEstudiante)) {
                        String insertQuery = "INSERT INTO curso_has_estudiante (curso_id_curso, estudiante_id_estudiante) VALUES (?, ?)";
                        PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);
                        preparedStatement.setInt(1, idCurso);
                        preparedStatement.setInt(2, idEstudiante);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                    }
                }
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al agregar estudiantes al curso.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Fallo al conectar con la base de datos.", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
        }
    }
    
//MAPEAR ESTUDIANTES DE UN CURSO ESPECIFICO (PARA LLENAR TABLA tablaEstudiante_Quitar)
    public List<Estudiante> obtenerEstudiantesCursoEspecifico(Integer cursoID) {
        List<Estudiante> listaEstudiantesCursoEspecifico = new ArrayList<>();
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectarMySQL();

        if (conn != null) {
            try {
                String query = "SELECT e.id_estudiante, e.nombre, e.apellido, e.edad\n" +
                                "FROM estudiante e\n" +
                                "INNER JOIN curso_has_estudiante ce ON e.id_estudiante = ce.estudiante_id_estudiante\n" +
                                "WHERE ce.curso_id_curso = ?;";

                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setInt(1, cursoID); // Establecer el valor del parámetro curso_id_curso
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int idEstudiante = resultSet.getInt("id_estudiante");
                    String nombre = resultSet.getString("nombre");
                    String apellido = resultSet.getString("apellido");
                    int edad = resultSet.getInt("edad");

                    // Crear un objeto Estudiante y establecer solo el id_estudiante
                    Estudiante estudiante = new Estudiante();
                    estudiante.setId_estudiante(idEstudiante);
                    estudiante.setNombre(nombre);
                    estudiante.setApellido(apellido);
                    estudiante.setEdad(edad);

                    listaEstudiantesCursoEspecifico.add(estudiante);
                }

                resultSet.close();
                preparedStatement.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("Ocurrió un error al obtener los estudiantes del curso.");
            }
        }
        return listaEstudiantesCursoEspecifico;
    }

    
 // AGREGAR ESTUDIANTES A CURSO (TABLA curso_has_estudiante)
    public void quitarEstudiantesACurso(List<Estudiante> estudiantes) {
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectarMySQL();

        if (conn != null) {
            try {
                for (Estudiante estudiante : estudiantes) {
                    int idEstudiante = estudiante.getId_estudiante();
                    String deleteQuery = "DELETE FROM curso_has_estudiante WHERE estudiante_id_estudiante = ?";
                    PreparedStatement preparedStatement = conn.prepareStatement(deleteQuery);
                    preparedStatement.setInt(1, idEstudiante);
                    preparedStatement.executeUpdate();
                    preparedStatement.close();
                }
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al eliminar estudiantes del curso.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Fallo al conectar con la base de datos.", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
        }
    }
    
//OBTENER DATOS DEL DOCENTE VINCULADO A DETERMINADO CURSO (PARA LLENAR TABLA Curso_tablaCurso)    
    public Docente obtenerDatosDocenteParaCurso(Integer cursoID) {
        Docente docente = new Docente();
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectarMySQL();

        if (conn != null) {
            try {
                // Query SQL para obtener los datos del docente para un curso específico
                String query =  "SELECT u.cedula, u.nombre, u.apellido\n" +
                                "FROM usuario u\n" +
                                "INNER JOIN docente d ON u.cedula = d.usuario_cedula\n" +
                                "INNER JOIN curso_has_docente cd ON u.cedula = cd.docente_usuario_cedula\n" +
                                "WHERE cd.curso_id_curso = ?;"; // Ajusta la consulta según tu esquema de base de datos

                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setInt(1, cursoID); // Suponiendo que tienes un método getId() en la clase Curso

                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    int cedula = resultSet.getInt("cedula");
                    String nombre = resultSet.getString("nombre");
                    String apellido = resultSet.getString("apellido");

                    // Crea un objeto Docente con los datos obtenidos de la base de datos
                    docente.setCedula(cedula);
                    docente.setNombre(nombre);
                    docente.setApellido(apellido);
                }
                resultSet.close();
                preparedStatement.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("Ocurrió un error al obtener el docente para el curso.");
            }
        }
        return docente;
    }    
  
        
    
    
    
 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    


    
    

    



    
    


    
