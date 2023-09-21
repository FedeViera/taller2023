
package Logica;

import Entidades.Curso;
import Entidades.Docente;
import Entidades.Estudiante;
import Persistencia.Persistencia_SQL;
import java.util.ArrayList;
import java.util.List;

public class GestorRelacional {
    
    List<Estudiante> estudiantes = new ArrayList<>();

    public void agregarDocenteACurso(Integer cedula, Integer idCurso){
        Docente docente = new Docente();
        docente.setCedula(cedula);
        Curso curso = new Curso();
        curso.setId_curso(idCurso);
        
        Persistencia_SQL persistencia = new Persistencia_SQL();
        persistencia.agregarDocenteACurso(curso, docente);
    }
    
    public void eliminarDocenteACurso (Integer cedula){
        Docente docente = new Docente();
        docente.setCedula(cedula);
        
        Persistencia_SQL persistencia = new Persistencia_SQL();
        persistencia.eliminarDocenteACurso(docente);
    }
    
    public void eliminarCursoConDocente(Integer cursoID){
        Curso curso = new Curso();
        curso.setId_curso(cursoID);
        
        Persistencia_SQL persistencia = new Persistencia_SQL();
        persistencia.eliminarCursoConDocente(curso);
        
    }
    
    public void eliminarCurso(Integer cursoID){
        Curso curso = new Curso();
        curso.setId_curso(cursoID);
        
        Persistencia_SQL persistencia = new Persistencia_SQL();
        
    }
    
    public void agregarEstudiantesACurso(int idCurso, List estudiantes){
        Curso curso = new Curso();
        curso.setId_curso(idCurso);

        Persistencia_SQL persistencia = new Persistencia_SQL();
        persistencia.agregarEstudiantesACurso(curso, estudiantes);
    }
    
    public void quitarEstudiantesACurso(int idCurso, List estudiantes){
        Curso curso = new Curso();
        curso.setId_curso(idCurso);

        Persistencia_SQL persistencia = new Persistencia_SQL();
        persistencia.quitarEstudiantesACurso(curso, estudiantes);
    }

    
   
    
}
