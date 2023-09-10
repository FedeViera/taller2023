package Entidades;

import javax.swing.table.DefaultTableModel;
import Grafica.Administrador_ventana;
import Entidades.GestorAdministradores;
import java.util.ArrayList;
import java.util.List;


public class GestorUsuarios {
    
    private List<Administrador> listaAdministradores;
    private List<Adscripto> listaAdscriptos;
    private List<Docente> listaDocentes;
    private javax.swing.JTable tablaCuentas;
    
    public GestorUsuarios() {
    listaAdministradores = new ArrayList<Administrador>();
    listaAdscriptos = new ArrayList<Adscripto>();
    listaDocentes = new ArrayList<Docente>();
    }

    
    public GestorUsuarios(javax.swing.JTable tablaCuentas) {
        this.tablaCuentas = tablaCuentas;
    }
    
    
    
    


    
    
    
}
