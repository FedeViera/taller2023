package Logica;
import Entidades.Curso;
import Entidades.Estudiante;
import Persistencia.Persistencia_SQL;
import java.util.ArrayList;
import java.util.List;

public class GestorEstudiantes {
    
    private List<Estudiante> listaEstudiantes;

    public GestorEstudiantes() {
    }
        
//LISTAR ESTUDIANTES DESDE BD   
    public List<Estudiante>  cargarCursosDesdeBD() {
        Persistencia_SQL persistencia = new Persistencia_SQL();
        listaEstudiantes = persistencia.mapearEstudiantes();
        return listaEstudiantes;
    }

//AGREGAR ESTUDIANTE    
    public void agregarEstudiante(int id_estudiante, String nombre, String apellido, int edad) {
        Estudiante nuevoEstudiante = new Estudiante();
        nuevoEstudiante.setId_estudiante(id_estudiante);
        nuevoEstudiante.setNombre(nombre);
        nuevoEstudiante.setApellido(apellido);
        nuevoEstudiante.setEdad(edad);
        
        Persistencia_SQL persistencia = new Persistencia_SQL();
        persistencia.agregarEstudiante(nuevoEstudiante);
    }

//ELIMINAR ESTUDIANTE
    public void eliminarEstudiante(int id_estudiante){
        Estudiante estudiante = new Estudiante();
        estudiante.setId_estudiante(id_estudiante);
        
        Persistencia_SQL persistencia = new Persistencia_SQL();
        persistencia.eliminarEstudiante(estudiante);
    }    
    
    

    
    
    
    
    
}
