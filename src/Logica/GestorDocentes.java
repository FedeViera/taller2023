package Logica;

import Entidades.Administrador;
import java.util.ArrayList;
import java.util.List;
import Persistencia.Persistencia_SQL;
import Entidades.Docente;
import Entidades.Docente;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GestorDocentes {
    
    private List<Docente> listaDocentes;
    private javax.swing.JTable tablaDocente;

    public GestorDocentes() {
        this.listaDocentes = new ArrayList<>();
    }

//BUSCAR DOCENTE    
    public Docente buscarDocentePorCedula(int cedula) {
        for (Docente docente : listaDocentes) {
            if (docente.getCedula() == cedula) {
                return docente;
            }
        }
        return null; // Docente no encontrado
    }
    
//DOCENTE EXISTE    
    public boolean docenteExiste(int cedula) {
    for (Docente docente : listaDocentes) {
        if (docente.getCedula() == cedula) {
            return true; // El docente existe en la lista
        }
    }
    return false; // El docente no existe en la lista
}

    
//LISTAR DOCENTES DESDE LA BD    
    public List<Docente> cargarDocentesDesdeBD() {
        Persistencia_SQL persistencia = new Persistencia_SQL();
        listaDocentes = persistencia.mapearDocentes();
        return listaDocentes;
    }
    

//MOSTRAR DOCENTES (PARA PRUEBAS)
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

/*    
//ELIMINAR DOCENTE (NO LO USAMOS POR AHORA, ELIMINAMOS DIRECTAMENTE CON USUARIO YA QUE TODOS LOS "CARGOS" SON USUARIOS)    
    public void eliminarDocente(Integer cedula, String cargo){
        Docente docente = new Docente();
        docente.setCedula(cedula);
        docente.setCargo(cargo);
        
        Persistencia_SQL persistencia = new Persistencia_SQL();
        persistencia.eliminarUsuario(docente.getCedula(), docente.getCargo());
    }
*/   
    
    public List<Docente> filtrarDocentesPorAsignatura(String asignatura) {
        List<Docente> docentesFiltrados = new ArrayList<>();

        for (Docente docente : listaDocentes) {
            if (docente.getAsignatura().equals(asignatura)) { // Filtrar por asignatura
                docentesFiltrados.add(docente);
            }
        }
        return docentesFiltrados;
    }
    
  
  


}
