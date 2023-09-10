package Entidades;

import javax.swing.table.DefaultTableModel;
import Grafica.Administrador_ventana;
import Entidades.GestorAdministradores;
import java.util.ArrayList;
import java.util.List;


public class GestorUsuarios {
    
    private javax.swing.JTable tablaUsuario;
    
    private List<Administrador> listaAdministradores;
    private List<Adscripto> listaAdscriptos;
    private List<Docente> listaDocentes;
    
    public GestorUsuarios(javax.swing.JTable tablaUsuario) {
        this.tablaUsuario = tablaUsuario;
        listaAdministradores = new ArrayList<Administrador>();
        listaAdscriptos = new ArrayList<Adscripto>();
        listaDocentes = new ArrayList<Docente>();
    }   
    
    public void cargarUsuariosEnTabla() {
        DefaultTableModel model = (DefaultTableModel) tablaUsuario.getModel();
        model.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos
        
        GestorAdministradores gestionarAdministradores = new GestorAdministradores();
        GestorDocentes gestionarDocentes = new GestorDocentes();
        GestorAdscriptos gestionarAdscriptos = new GestorAdscriptos();

        gestionarAdministradores.cargarAdministradoresDesdeBD();
        //gestionarAdministradores.mostrarAdministradores();
        
   
        gestionarDocentes.cargarDocentesDesdeBD();
        //gestionarDocentes.mostrarDocentes();
      
        gestionarAdscriptos.cargarAdscriptosDesdeBD();
        //gestionarAdscriptos.mostrarAdscriptos();


        // Agregar usuarios administradores
        for (Administrador admin : listaAdministradores) {
            Object[] fila = {
                admin.getCedula(),
                admin.getNombre(),
                admin.getApellido(),
                admin.getUsuario(),
                admin.getContrasenia(),
                admin.getCargo(),
                "", // Grado (vacío para no docentes)
                ""  // Asignatura (vacío para no docentes)
            };
            model.addRow(fila);
        }
        
        // Agregar usuarios adscriptos
        for (Adscripto adscripto : listaAdscriptos) {
            Object[] fila = {
                adscripto.getCedula(),
                adscripto.getNombre(),
                adscripto.getApellido(),
                adscripto.getUsuario(),
                adscripto.getContrasenia(),
                adscripto.getCargo(),
                adscripto.getGrado(),
                ""  // Asignatura (vacío para adscriptos)
            };
            model.addRow(fila);
        }

        // Agregar usuarios docentes
        for (Docente docente : listaDocentes) {
            Object[] fila = {
                docente.getCedula(),
                docente.getNombre(),
                docente.getApellido(),
                docente.getUsuario(),
                docente.getContrasenia(),
                docente.getCargo(),
                docente.getGrado(),
                docente.getAsignatura()
            };
            model.addRow(fila);
        }
        tablaUsuario.repaint();
    }

    
    
    


    
    
    
}
