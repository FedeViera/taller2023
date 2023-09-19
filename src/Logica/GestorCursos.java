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
    
    public int buscarIDCurso(String claseYgrupo, String asignatura) {
        for (Curso curso : listaCursos) {
            if (curso.getClaseYgrupo().equals(claseYgrupo) && curso.getAsignatura().equals(asignatura)) {
                return curso.getId_curso(); // Devuelve el ID del curso encontrado como int
            }
        }
        return -1; // Retorna -1 (o cualquier otro valor que indique que el curso no se encontró) si el curso no se encuentra
    }




//AGREGAR CURSO
    public void agregarCurso(String claseYgrupo, String asignatura) {
        Curso nuevoCurso = new Curso();
        nuevoCurso.setClaseYgrupo(claseYgrupo);
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

//CURSO EXISTE
    public boolean cursoExiste(String claseYgrupo, String asignatura) {
        for (Curso curso : listaCursos) {
            if (curso.getClaseYgrupo().equals(claseYgrupo)&&curso.getAsignatura().equals(asignatura)) {
                return true; // El curso existe en la lista
            }
        }
        return false; // El curso no existe en la lista
    }

    
    
}
