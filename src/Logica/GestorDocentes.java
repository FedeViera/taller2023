package Logica;

import Entidades.Administrador;
import java.util.ArrayList;
import java.util.List;
import Persistencia.Persistencia_SQL;
import Entidades.Docente;
import Entidades.Docente;
import javax.swing.table.DefaultTableModel;

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
        listaDocentes = persistencia.mapearDocentes();
  
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
            System.out.println("Cargo: " + docente.getCargo());
            System.out.println("Grado: " + docente.getGrado());
            System.out.println("Asignatura: " + docente.getAsignatura());
        }
    }
    
    /*
    public void insertarDocentesEnTabla(DefaultTableModel model) {
        // Verificar si la lista de administradores no está vacía
        if (!listaDocentes.isEmpty()) {
            // Limpiar cualquier dato existente en el modelo de la tabla
            model.setRowCount(0);

            // Iterar a través de la lista de administradores y agregar cada uno al modelo de la tabla
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
        } else {
            // Si la lista de administradores está vacía, puedes mostrar un mensaje o realizar alguna acción adecuada.
        }
    }*/


}
