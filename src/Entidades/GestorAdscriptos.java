package Entidades;

import java.util.ArrayList;
import java.util.List;
import Persistencia.Persistencia_SQL;

public class GestorAdscriptos {
    
    private List<Adscripto> listaAdscriptos;

    public GestorAdscriptos() {
        this.listaAdscriptos = new ArrayList<>();
    }

    public void agregarAdscripto(Adscripto adscripto) {
        listaAdscriptos.add(adscripto);
    }

    public void eliminarAdscripto(Adscripto adscripto) {
        listaAdscriptos.remove(adscripto);
    }

    public List<Adscripto> obtenerTodosLosAdscriptores() {
        return listaAdscriptos;
    }

    // Puedes agregar más métodos según tus necesidades

    public Adscripto buscarAdscriptoPorCedula(int cedula) {
        for (Adscripto adscripto : listaAdscriptos) {
            if (adscripto.getCedula() == cedula) {
                return adscripto;
            }
        }
        return null; // Adscripto no encontrado
    }
    
    public void cargarAdscriptosDesdeBD() {
        Persistencia_SQL persistencia = new Persistencia_SQL();
        List<Adscripto> adscriptosDesdeBD = persistencia.mapearAdscriptos();
        listaAdscriptos.addAll(adscriptosDesdeBD);
    }
    
    /*
    GestorAdscriptos gestionarAdscriptos = new GestorAdscripto();
    gestionarAdscriptos.cargarAdscriptosDesdeBD();*/

    
}

