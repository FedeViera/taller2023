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
    
    public List<Object> obtenerTodosUsuarios() {
        List<Object> listaGeneral = new ArrayList<>();     

        GestorAdministradores gestionarAdministradores = new GestorAdministradores();
        GestorDocentes gestionarDocentes = new GestorDocentes();
        GestorAdscriptos gestionarAdscriptos = new GestorAdscriptos();

        gestionarAdministradores.cargarAdministradoresDesdeBD();
        listaGeneral.addAll(gestionarAdministradores.obtenerTodosLosAdministradores());

        gestionarDocentes.cargarDocentesDesdeBD();
        listaGeneral.addAll(gestionarDocentes.obtenerTodosLosDocentes());

        gestionarAdscriptos.cargarAdscriptosDesdeBD();
        listaGeneral.addAll(gestionarAdscriptos.obtenerTodosLosAdscriptores());

        return listaGeneral;
    }

//BUSCAR SI USUARIO EXISTE
    public boolean usuarioExiste(List<Object> listaGeneral, int cedulaAVerificar, String usuarioAVerificar) {
        for (Object usuario : listaGeneral) {
            if (usuario instanceof Administrador) {
                Administrador administrador = (Administrador) usuario;
                int cedulaUsuario = administrador.getCedula();
                String usuarioUsuario = administrador.getUsuario();

                if (cedulaUsuario == cedulaAVerificar || usuarioUsuario.equals(usuarioAVerificar)) {
                    return true; 
                }
            } else if (usuario instanceof Adscripto) {
                Adscripto adscripto = (Adscripto) usuario;
                int cedulaUsuario = adscripto.getCedula();
                String usuarioUsuario = adscripto.getUsuario();

                if (cedulaUsuario == cedulaAVerificar || usuarioUsuario.equals(usuarioAVerificar)) {
                    return true; 
                }
            } else if (usuario instanceof Docente) {
                Docente docente = (Docente) usuario;
                int cedulaUsuario = docente.getCedula();
                String usuarioUsuario = docente.getUsuario();

                if (cedulaUsuario == cedulaAVerificar || usuarioUsuario.equals(usuarioAVerificar)) {
                    return true; 
                }
            }
        }
        return false; 
                              
    }
    
    public void agregarUsuario(List<Object> listaGeneral, Integer cedula, String nombre, String apellido, String usuario, String contrasenia, String cargo){
        
        boolean usuarioExiste = usuarioExiste(listaGeneral, cedula, usuario);
        
        if (usuarioExiste) {
            JOptionPane.showMessageDialog(null, "Ya existe usuario con la misma cedula o nombre de usuario", "Usuario Duplicado", JOptionPane.WARNING_MESSAGE);  
        } else {
            //Crea obj nuevoUsuario y asigna valores
            Usuario nuevoUsuario = new Usuario();
            nuevoUsuario.setCedula(cedula);
            nuevoUsuario.setNombre(nombre);
            nuevoUsuario.setApellido(apellido);
            nuevoUsuario.setUsuario(usuario);
            nuevoUsuario.setContrasenia(contrasenia);
            nuevoUsuario.setCargo(cargo);
            
            Persistencia_SQL persist = new Persistencia_SQL();
            persist.agregarUsuarioGenerico(nuevoUsuario);
        }
    }



    
    
    
}
