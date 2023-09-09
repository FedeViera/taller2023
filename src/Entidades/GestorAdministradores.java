package Entidades;

import Persistencia.Persistencia_SQL;
import java.util.ArrayList;
import java.util.List;


public class GestorAdministradores {
    
    private List<Administrador> listaAdministradores;

    public GestorAdministradores() {
        this.listaAdministradores = new ArrayList<>();
    }

    public void agregarAdministrador(Administrador administrador) {
        listaAdministradores.add(administrador);
    }

    public void eliminarAdministrador(Administrador administrador) {
        listaAdministradores.remove(administrador);
    }

    public List<Administrador> obtenerTodosLosAdministradores() {
        return listaAdministradores;
    }

    // Puedes agregar más métodos según tus necesidades

    public Administrador buscarAdministradorPorCedula(int cedula) {
        for (Administrador administrador : listaAdministradores) {
            if (administrador.getCedula() == cedula) {
                return administrador;
            }
        }
        return null; // Administrador no encontrado
    }
    
    public void cargarAdscriptosDesdeBD() {
        Persistencia_SQL persistencia = new Persistencia_SQL();
        List<Administrador> administradoresDesdeBD = persistencia.mapearAdministradores();
        listaAdministradores.addAll(administradoresDesdeBD);
    }
    
    /*
    GestorAdscriptos gestionarAdscriptos = new GestorAdscripto();
    gestionarAdscriptos.cargarAdscriptosDesdeBD();*/
}


