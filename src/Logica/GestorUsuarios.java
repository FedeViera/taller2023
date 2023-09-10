package Logica;

import Entidades.Administrador;
import Entidades.Adscripto;
import Entidades.Docente;
import javax.swing.table.DefaultTableModel;
import Grafica.Administrador_ventana;
import Logica.GestorAdministradores;
import java.util.ArrayList;
import java.util.List;


public class GestorUsuarios {
    
    private javax.swing.JTable tablaUsuario;
    
    private List<Administrador> listaAdministradores;
    private List<Adscripto> listaAdscriptos;
    private List<Docente> listaDocentes;
    
    public GestorUsuarios(javax.swing.JTable tablaUsuario) {
        this.tablaUsuario = tablaUsuario;
    }   
    
    public List<Object> cargarUsuariosEnTabla() {
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

    public GestorUsuarios() {
    }
    
    
    
}
