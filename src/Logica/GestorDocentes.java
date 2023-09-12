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
    
//LOGICA AGREGAR DOCENTE    
    public void agregarDocente(Integer cedula, String nombre, String apellido, String usuario, String contrasenia, String cargo, Integer grado, String asignatura) {
        Docente nuevoDocente = new Docente();
        nuevoDocente.setCedula(cedula);
        nuevoDocente.setNombre(nombre);
        nuevoDocente.setApellido(apellido);
        nuevoDocente.setUsuario(usuario);
        nuevoDocente.setContrasenia(contrasenia);
        nuevoDocente.setCargo(cargo);
        nuevoDocente.setGrado(grado);
        nuevoDocente.setAsignatura(asignatura);

        // Llama a tu método de persistencia para agregar el Administrador
        Persistencia_SQL persistencia = new Persistencia_SQL();
        persistencia.agregarDocente(nuevoDocente);
    }

//ELIMINAR DOCENTE (NO LO USAMOS POR AHORA, ELIMINAMOS DIRECTAMENTE CON USUARIO YA QUE TODOS LOS "CARGOS" SON USUARIOS)    
    public void eliminarDocente(Integer cedula, String cargo){
        Docente docente = new Docente();
        docente.setCedula(cedula);
        docente.setCargo(cargo);
        
        Persistencia_SQL persistencia = new Persistencia_SQL();
        persistencia.eliminarUsuario(docente.getCedula(), docente.getCargo());
    }
    
  


}
