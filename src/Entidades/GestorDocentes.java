package Entidades;

import java.util.ArrayList;
import java.util.List;
import Persistencia.Persistencia_SQL;
import Entidades.Docente;

public class GestorDocentes {
    
    private List<Docente> listaDocentes;

    public GestorDocentes() {
        this.listaDocentes = new ArrayList<>();
    }

    public void agregarDocente(Docente docente) {
        listaDocentes.add(docente);
    }

    public void eliminarDocente(Docente docente) {
        listaDocentes.remove(docente);
    }

    public List<Docente> obtenerTodosLosDocentes() {
        return listaDocentes;
    }

    // Puedes agregar más métodos según tus necesidades

    public Docente buscarDocentePorCedula(int cedula) {
        for (Docente docente : listaDocentes) {
            if (docente.getCedula() == cedula) {
                return docente;
            }
        }
        return null; // Docente no encontrado
    }
    
    public void cargarDocentesDesdeBD() {
        Persistencia_SQL persistencia = new Persistencia_SQL();
        List<Docente> docentesDesdeBD = persistencia.mapearDocentes();
        listaDocentes.addAll(docentesDesdeBD);
    }
    
    /*//LLAMAR PARA CARGAR DOCENTES
    GestorDocentes gestionarDocentes = new GestorDocentes();
    gestionarDocentes.cargarDocentesDesdeBD();*/
    
    //MOSTRAR DOCENTES
    public void mostrarDocentes() {
        for (Docente docente : listaDocentes) {
            System.out.println("Cédula: " + docente.getCedula());
            System.out.println("Nombre: " + docente.getNombre());
            System.out.println("Apellido: " + docente.getApellido());
            System.out.println("Usuario: " + docente.getUsuario());
            System.out.println("Contraseña: " + docente.getContrasenia());
            System.out.println("Grado: " + docente.getGrado());
            System.out.println("Asignatura: " + docente.getAsignatura());
        }
    }


}
