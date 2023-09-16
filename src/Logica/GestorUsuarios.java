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


//OBTENER NOMBRE Y APELLIDO    
    public String obtenerNombreyApellido(String usuario, String contrasenia) {
        String nombreApellido = null;
        Persistencia_SQL persistencia = new Persistencia_SQL();
        Usuario cargoUsuario = persistencia.mapearUsuario(usuario, contrasenia);

        if (cargoUsuario != null) {
            // Combina el nombre y el apellido en una sola cadena
            nombreApellido = cargoUsuario.getNombre() + " " + cargoUsuario.getApellido();
        }

        return nombreApellido;
    }
    
    public List<Object> obtenerTodosUsuarios() {
        List<Object> listaGeneral = new ArrayList<>();     

        GestorAdministradores gestionarAdministradores = new GestorAdministradores();
        GestorDocentes gestionarDocentes = new GestorDocentes();
        GestorAdscriptos gestionarAdscriptos = new GestorAdscriptos();

        listaGeneral.addAll(gestionarAdministradores.cargarAdministradoresDesdeBD());

        gestionarDocentes.cargarDocentesDesdeBD();
        listaGeneral.addAll(gestionarDocentes.cargarDocentesDesdeBD());

        gestionarAdscriptos.cargarAdscriptosDesdeBD();
        listaGeneral.addAll(gestionarAdscriptos.cargarAdscriptosDesdeBD());

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
                    JOptionPane.showMessageDialog(null, "La cedula o Usuario ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                    return true;
                }
            } else if (usuario instanceof Adscripto) {
                Adscripto adscripto = (Adscripto) usuario;
                int cedulaUsuario = adscripto.getCedula();
                String usuarioUsuario = adscripto.getUsuario();

                if (cedulaUsuario == cedulaVerificar || usuarioUsuario.equals(usuarioVerificar)) {
                    JOptionPane.showMessageDialog(null, "La cedula o Usuario ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                    return true; 
                }
            } else if (usuario instanceof Docente) {
                Docente docente = (Docente) usuario;
                int cedulaUsuario = docente.getCedula();
                String usuarioUsuario = docente.getUsuario();

                if (cedulaUsuario == cedulaVerificar || usuarioUsuario.equals(usuarioVerificar)) {
                    JOptionPane.showMessageDialog(null, "La cedula o Usuario ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                    return true; 
                }
            }
        }
        return false;                             
    }
    
    public void agregarUsuario(Integer cedula, String nombre, String apellido, String usuario, String contrasenia, String cargo){
        //Creo obj nuevoUsuario y asigna valores
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setCedula(cedula);
        nuevoUsuario.setNombre(nombre);
        nuevoUsuario.setApellido(apellido);
        nuevoUsuario.setUsuario(usuario);
        nuevoUsuario.setContrasenia(contrasenia);
        nuevoUsuario.setCargo(cargo);
            
        Persistencia_SQL persist = new Persistencia_SQL();
        persist.agregarUsuario(nuevoUsuario);         
        
    }
    
    public void eliminarUsuario(Integer cedula, String cargo){
        
        Usuario usuario = new Usuario();
        usuario.setCedula(cedula);
        usuario.setCargo(cargo);
       
        Persistencia_SQL persistencia = new Persistencia_SQL();
        
        persistencia.eliminarUsuario(usuario.getCedula(), usuario.getCargo());       
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


    
    
    
}
