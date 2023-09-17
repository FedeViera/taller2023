package Logica;

import Entidades.Administrador;
import Entidades.Curso;
import Persistencia.Persistencia_SQL;
import java.util.ArrayList;
import java.util.List;

public class GestorCursos {
    
    private List<Curso> listaCursos;
    
    public GestorCursos() {
        this.listaCursos = new ArrayList<>();
    }
    
//LISTAR CURSOS DESDE BD   
    public List<Curso>  cargarCursosDesdeBD() {
        Persistencia_SQL persistencia = new Persistencia_SQL();
        listaCursos = persistencia.mapearCursos();
        return listaCursos;
    }

//AGREGAR CURSO
    public void agregarCurso(String claseYgrupo, String asignatura) {
        Curso nuevoCurso = new Curso();
        nuevoCurso.setAsignatura(claseYgrupo);
        nuevoCurso.setAsignatura(asignatura);
        
        Persistencia_SQL persistencia = new Persistencia_SQL();
        persistencia.agregarCurso(nuevoCurso);
    }  
    
//ELIMINAR CURSO
    public void eliminarCurso(String id_curso){
        Curso curso = new Curso();
        curso.setAsignatura(id_curso);
        
        Persistencia_SQL persistencia = new Persistencia_SQL();
        persistencia.eliminarCurso(curso);
    }
    
}
