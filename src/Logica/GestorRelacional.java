
package Logica;

import Entidades.Curso;
import Entidades.Docente;
import Entidades.Estudiante;
import Persistencia.Persistencia_SQL;
import java.util.ArrayList;
import java.util.List;

public class GestorRelacional {
    
    List<Estudiante> estudiantes = new ArrayList<>();

//AGREGAR DOCENTE A UN CURSO    
    public void agregarDocenteACurso(Integer cedula, Integer idCurso){
        Docente docente = new Docente();
        docente.setCedula(cedula);
        Curso curso = new Curso();
        curso.setId_curso(idCurso);
        
        Persistencia_SQL persistencia = new Persistencia_SQL();
        persistencia.agregarDocenteACurso(curso, docente);
    }
    
//ELIMINAR DOCENTE DE UN CURSO    
    public void eliminarDocenteACurso (Integer cedula){
        Docente docente = new Docente();
        docente.setCedula(cedula);
        
        Persistencia_SQL persistencia = new Persistencia_SQL();
        persistencia.eliminarDocenteACurso(docente);
    }

//ELIMINAR UN CURSO CON DOCENTE ASIGNADO    
    public void eliminarCursoConDocente(Integer cursoID){
        Curso curso = new Curso();
        curso.setId_curso(cursoID);
        
        Persistencia_SQL persistencia = new Persistencia_SQL();
        persistencia.eliminarCursoConDocente(curso);
    }

//ELIMINAR UN CURSO CON ESTUDIANTES ASIGNADOS    
    public void eliminarCursoConEstudiantes(Integer cursoID){
        Curso curso = new Curso();
        curso.setId_curso(cursoID);
        
        Persistencia_SQL persistencia = new Persistencia_SQL();
        persistencia.eliminarCursoConEstudiantes(curso);
    }
    
//AGREGAR ESTUDIANTES A UN CURSO    
    public void agregarEstudiantesACurso(int idCurso, List estudiantes){
        Curso curso = new Curso();
        curso.setId_curso(idCurso);

        Persistencia_SQL persistencia = new Persistencia_SQL();
        persistencia.agregarEstudiantesACurso(curso, estudiantes);
    }
    
//ELIMINAR ESTUDIANTES DE UN CURSO    
    public void quitarEstudiantesACurso(List estudiantes){
        Persistencia_SQL persistencia = new Persistencia_SQL();
        persistencia.quitarEstudiantesACurso(estudiantes);
    }
    


    
   
    
}
