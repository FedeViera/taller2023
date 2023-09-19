
package Logica;

import Entidades.Curso;
import Entidades.Docente;
import Persistencia.Persistencia_SQL;

public class GestorIntermedio {
    
    public void agregarDocenteACurso(Integer cedula, Integer idCurso){
        Docente docente = new Docente();
        docente.setCedula(cedula);
        Curso curso = new Curso();
        curso.setId_curso(idCurso);
        
        Persistencia_SQL persistencia = new Persistencia_SQL();
        persistencia.agregarDocenteACurso(curso, docente);
    }
    
   
    
}
