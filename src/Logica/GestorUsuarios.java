package Logica;

import Entidades.Administrador;
import Entidades.Adscripto;
import Entidades.Docente;
import javax.swing.table.DefaultTableModel;
import Grafica.Administrador_ventana;
import Logica.GestorAdministradores;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import Entidades.Usuario;
import Entidades.UsuarioLogeo;
import javax.swing.JOptionPane;
import Persistencia.Persistencia_SQL;


public class GestorUsuarios {
    
    private javax.swing.JTable tablaUsuario;
    
    private List<Administrador> listaAdministradores;
    private List<Adscripto> listaAdscriptos;
    private List<Docente> listaDocentes;
    
    public GestorUsuarios(javax.swing.JTable tablaUsuario) {
        this.tablaUsuario = tablaUsuario;
    }   
    
    public GestorUsuarios() {
        
    }
    
//VALIDAR USUARIO
    public boolean validarUsuario(String usuario, String contrasenia) {
        // Instancia de Persistencia_SQL
        Persistencia_SQL persistencia = new Persistencia_SQL();

        Usuario usuarioObtenido = persistencia.mapearUsuario(usuario, contrasenia);

        if (usuarioObtenido != null && usuario.equals(usuarioObtenido.getUsuario()) && contrasenia.equals(usuarioObtenido.getContrasenia())) {
            return true;
        } else {
            return false;
        }
    }
   
    
    
//OBTENER CARGO
    public String obtenerCargo(String usuario, String contrasenia) {
        String cargo = null;
        Persistencia_SQL persistencia = new Persistencia_SQL();
        Usuario cargoUsuario = persistencia.mapearUsuario(usuario, contrasenia);

        if (cargoUsuario != null) {
            cargo = cargoUsuario.getCargo();
        }

        return cargo;
    }
    
//OBTENER CEDULA
    public Integer obtenerCedula(String usuario, String contrasenia) {
        Integer cedula = null;
        Persistencia_SQL persistencia = new Persistencia_SQL();
        Usuario cedulaUsuario = persistencia.mapearUsuario(usuario, contrasenia);

        if (cedulaUsuario != null) {
            cedula = cedulaUsuario.getCedula();
        }
        return cedula;
    }    


//OBTENER NOMBRE Y APELLIDO    
    public String obtenerNombreyApellido(String usuario, String contrasenia) {
        String nombreApellido = null;
        Persistencia_SQL persistencia = new Persistencia_SQL();
        Usuario nombreYapellido = persistencia.mapearUsuario(usuario, contrasenia);

        if (nombreYapellido != null) {
            // Combina el nombre y el apellido en una sola cadena
            nombreApellido = nombreYapellido.getNombre() + " " + nombreYapellido.getApellido();
        }

        return nombreApellido;
    }

//TRAER TODOS LOS USUARIOS DE TODOS LOS CARGOS A LA listaGeneral    
    public List<Object> obtenerTodosUsuarios() {
        List<Object> listaGeneral = new ArrayList<>();     

        GestorAdministradores gestorAdministradores = new GestorAdministradores();
        GestorDocentes gestorDocentes = new GestorDocentes();
        GestorAdscriptos gestorAdscriptos = new GestorAdscriptos();
        listaGeneral.addAll(gestorAdministradores.cargarAdministradoresDesdeBD());
        listaGeneral.addAll(gestorDocentes.cargarDocentesDesdeBD());
        listaGeneral.addAll(gestorAdscriptos.cargarAdscriptosDesdeBD());
        return listaGeneral;
    }


//BUSCAR SI USUARIO EXISTE
    public boolean usuarioExiste(List<Object> listaGeneral, int cedulaVerificar, String usuarioVerificar) {
        for (Object usuario : listaGeneral) {
            if (usuario instanceof Administrador) {
                Administrador administrador = (Administrador) usuario;
                int cedulaUsuario = administrador.getCedula();
                String usuarioUsuario = administrador.getUsuario();

                if (cedulaUsuario == cedulaVerificar || usuarioUsuario.equals(usuarioVerificar)) {
                    JOptionPane.showMessageDialog(null, "La cédula o usuario ya esta registrado como Administrador", "Error", JOptionPane.ERROR_MESSAGE);
                    return true;
                }
            } else if (usuario instanceof Adscripto) {
                Adscripto adscripto = (Adscripto) usuario;
                int cedulaUsuario = adscripto.getCedula();
                String usuarioUsuario = adscripto.getUsuario();

                if (cedulaUsuario == cedulaVerificar || usuarioUsuario.equals(usuarioVerificar)) {
                    JOptionPane.showMessageDialog(null, "La cédula o usuario ya esta registrado como Adscripto", "Error", JOptionPane.ERROR_MESSAGE);
                    return true; 
                }
            } else if (usuario instanceof Docente) {
                Docente docente = (Docente) usuario;
                int cedulaUsuario = docente.getCedula();
                String usuarioUsuario = docente.getUsuario();

                if (cedulaUsuario == cedulaVerificar || usuarioUsuario.equals(usuarioVerificar)) {
                    JOptionPane.showMessageDialog(null, "La cédula o usuario ya esta registrado como Docente", "Error", JOptionPane.ERROR_MESSAGE);
                    return true; 
                }
            }
        }
        return false;                             
    }
    
    public void agregarUsuario(Integer cedula, String nombre, String apellido, String usuario, String contrasenia, String cargo){
        //Creo obj nuevoUsuario y asigna valores
        // Creo una instancia de UsuarioConcreto y asigna valores
        UsuarioLogeo nuevoUsuario = new UsuarioLogeo(cedula, nombre, apellido, usuario, contrasenia, cargo);

        Persistencia_SQL persist = new Persistencia_SQL();
        persist.agregarUsuario(nuevoUsuario);         
        
    }
    
    public void eliminarUsuario(Integer cedula, String cargo){
    Persistencia_SQL persistencia = new Persistencia_SQL();
    persistencia.eliminarUsuario(cedula, cargo); 
    }

    public void modificarUsuario(int cedula, String nuevaContrasenia, String nuevoCargo, int nuevoGrado, String nuevaAsignatura){
        //SE USA DOCENTE YA QUE ES LA ENTIDAD CON TODOS LOS ATRIBUTOS - POR ESO USUARIO FULL
        Docente usuarioFull = new Docente();
        usuarioFull.setCedula(cedula);
        usuarioFull.setContrasenia(nuevaContrasenia);
        usuarioFull.setCargo(nuevoCargo);
        usuarioFull.setGrado(nuevoGrado);
        usuarioFull.setAsignatura(nuevaAsignatura);
        
        Persistencia_SQL persistencia = new Persistencia_SQL();
        persistencia.actualizarUsuario(usuarioFull);
    }
    
    //CARGAR TODOS LOS DATOS DE USUARIOS (ADMIN, ADS Y DOCENTES) EN EL JTable
    public void cargarTablaUsuarios(JTable table){
        GestorUsuarios gestorUsuarios = new GestorUsuarios();
        List<Object> listaGeneral = gestorUsuarios.obtenerTodosUsuarios();
        
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos
        
        // Eliminar todas las filas vacías del modelo
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
        
        // Agregar datos de la lista general al modelo de la tabla
        for (Object usuario : listaGeneral) {
            if (usuario instanceof Administrador) {
                Administrador admin = (Administrador) usuario;
                model.addRow(new Object[]{
                    admin.getCedula(),
                    admin.getNombre(),
                    admin.getApellido(),
                    admin.getUsuario(),
                    admin.getContrasenia(),
                    admin.getCargo(),
                    "", // Grado (vacío para no docentes)
                    ""  // Asignatura (vacío para no docentes)
                });
            } else if (usuario instanceof Adscripto) {
                Adscripto adscripto = (Adscripto) usuario;
                model.addRow(new Object[]{
                    adscripto.getCedula(),
                    adscripto.getNombre(),
                    adscripto.getApellido(),
                    adscripto.getUsuario(),
                    adscripto.getContrasenia(),
                    adscripto.getCargo(),
                    adscripto.getGrado(),
                    ""  // Asignatura (vacío para adscriptos)
                });
            } else if (usuario instanceof Docente) {
                Docente docente = (Docente) usuario;
                model.addRow(new Object[]{
                    docente.getCedula(),
                    docente.getNombre(),
                    docente.getApellido(),
                    docente.getUsuario(),
                    docente.getContrasenia(),
                    docente.getCargo(),
                    docente.getGrado(),
                    docente.getAsignatura()
                });
            }
            table.repaint();
        }
    } 
    
    
    
  
    
    
    
}
