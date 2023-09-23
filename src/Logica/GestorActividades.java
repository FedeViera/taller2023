package Logica;
import Entidades.Actividad;
import Entidades.Administrador;
import Entidades.Estudiante;
import Persistencia.Persistencia_SQL;
import java.util.Date;
import java.util.List;

public class GestorActividades {
    
    private List<Actividad> listaActividades;

    public GestorActividades() {
    }

    
    
    public GestorActividades(List<Actividad> listaActividades) {
        this.listaActividades = listaActividades;
    }
    
    public void agregarActividad(Integer idEstudiante, String tipo, String descripcion, float calificacion, java.sql.Date fecha){
        Estudiante nuevoEstudiante = new Estudiante();
        nuevoEstudiante.setId_estudiante(idEstudiante);
        
        Actividad nuevaActividad = new Actividad();
        nuevaActividad.setTipo(tipo);
        nuevaActividad.setDescripcion(descripcion);
        nuevaActividad.setCalificacion(calificacion);
        nuevaActividad.setFecha(fecha);
       
        
        Persistencia_SQL persistencia = new Persistencia_SQL();
        persistencia.agregarActividad(nuevoEstudiante, nuevaActividad);
    }
 
}
