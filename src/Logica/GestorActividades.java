package Logica;
import Entidades.Actividad;
import Entidades.Administrador;
import Entidades.Curso;
import Entidades.Estudiante;
import Persistencia.Persistencia_SQL;
import java.util.Date;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GestorActividades {
    
    private List<Actividad> listaActividades;

    public GestorActividades() {
    }

    
    
    public GestorActividades(List<Actividad> listaActividades) {
        this.listaActividades = listaActividades;
    }
    
//AGREGAR ACTIVIDAD    
    public int agregarActividad(Integer idEstudiante, String tipo, String descripcion, float calificacion, java.sql.Date fecha, Integer cursoID) {
        Estudiante nuevoEstudiante = new Estudiante();
        nuevoEstudiante.setId_estudiante(idEstudiante);

        Actividad nuevaActividad = new Actividad();
        nuevaActividad.setTipo(tipo);
        nuevaActividad.setDescripcion(descripcion);
        nuevaActividad.setCalificacion(calificacion);
        nuevaActividad.setFecha(fecha);

        Curso curso = new Curso();
        curso.setId_curso(cursoID);

        Persistencia_SQL persistencia = new Persistencia_SQL();
        int actividadID = persistencia.agregarActividad(nuevoEstudiante, nuevaActividad);
        
        nuevaActividad.setId_actividad(actividadID);

        // Asociar la actividad al curso utilizando el ID de la actividad generado
        persistencia.asociarActividadACurso(nuevoEstudiante, nuevaActividad, curso);

        return actividadID; // Devuelve el ID de la actividad agregada
    }

    
//MODIFICAR ACTIVIDAD    
    public void modificarActividad(Integer id_actividad, String nuevoTipo, String nuevaDescripcion, float nuevaCalificacion, java.sql.Date nuevaFecha){
        
        Actividad actividad = new Actividad();
        actividad.setId_actividad(id_actividad);
        actividad.setTipo(nuevoTipo);
        actividad.setDescripcion(nuevaDescripcion);
        actividad.setCalificacion(nuevaCalificacion);
        actividad.setFecha(nuevaFecha);
        
        Persistencia_SQL persistencia = new Persistencia_SQL();
        persistencia.modificarActividad(actividad);
    }    
    
//ELIMINAR ACTIVIDAD
    public void eliminarActividad(Integer id_actividad){
        Actividad actividad = new Actividad();
        actividad.setId_actividad(id_actividad);
        
        Persistencia_SQL persistencia = new Persistencia_SQL();
        persistencia.eliminarActividad(actividad);
    }
    
    public void cargarTablaActividades_porEstudiantes(Integer idEstudiante, Integer cursoID, JTable table) {
        GestorActividades actividades = new GestorActividades();
        Estudiante estudiante = new Estudiante();
        Persistencia_SQL persistencia = new Persistencia_SQL();
        
        estudiante.setId_estudiante(idEstudiante);
        
        Curso curso = new Curso();
        curso.setId_curso(cursoID);
        
        List<Actividad> listaActividades = persistencia.mapearActividades_PorEstudiante(estudiante, curso);

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        // Agregar datos de la lista de estudiantes al modelo de la tabla
        for (Actividad actividad : listaActividades) {
            // Agregar un objeto Boolean.TRUE para representar una casilla de verificación marcada
            model.addRow(new Object[]{
                actividad.getId_actividad(),
                actividad.getId_estudiante(),
                actividad.getTipo(),
                actividad.getDescripcion(),
                actividad.getCalificacion(),
                actividad.getFecha(),
            });
        }
        table.repaint(); // Actualizar la tabla
    }    
    

    public void llenarTablaEstudiantesCalificaciones(Integer cursoID, JTable table) {
        Persistencia_SQL persistencia = new Persistencia_SQL();

        List<Object[]> datosEstudiantesCalificaciones = persistencia.mapearCalificacionesCurso(cursoID);
        
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        for (Object[] datos : datosEstudiantesCalificaciones) {
            model.addRow(datos);
        }
        table.setModel(model);
    }

 
}
