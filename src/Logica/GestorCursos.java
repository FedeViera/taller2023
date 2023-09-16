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
            
    public void cargarCursosDesdeBD(){
        Persistencia_SQL persistencia = new Persistencia_SQL();
    }
    
    public void mostrarAdministradores() {
        for (Curso curso : listaCursos) {
            System.out.println("Asignatura: " + curso.getAsignatura());
        }
    }
    
//LOGICA AGREGAR CURSO    
    public void agregarCurso(String asitnagura) {
        Curso nuevoCurso = new Curso();
        nuevoCurso.setAsignatura(asitnagura);

        // Llama a tu método de persistencia para agregar el Administrador
        Persistencia_SQL persistencia = new Persistencia_SQL();
        persistencia.agregarCurso(nuevoCurso);
    }
}
