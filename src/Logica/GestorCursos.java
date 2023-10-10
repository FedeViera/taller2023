package Logica;

import Entidades.Administrador;
import Entidades.Curso;
import Entidades.Docente;
import Persistencia.Persistencia_SQL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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

//LISTAR CURSOS DE UN DOCENTE DESDE BD   
    public List<Curso>  cargarCursosDeDocenteEspecificoDesdeBD(Integer cedula) {
        Persistencia_SQL persistencia = new Persistencia_SQL();
        listaCursos = persistencia.mapearCursosDeDocenteEspecifico(cedula);
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

    public void mostrarCursos() {
        for (Curso curso : listaCursos) {
            System.out.println(curso.getClaseYgrupo());
            System.out.println(curso.getAsignatura());
        }
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
    public void eliminarCurso(int id_curso){
        Curso curso = new Curso();
        curso.setId_curso(id_curso);
        
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
    
//CARGAR LOS DOCENTES EN EL JTable - Tabla Full (curso, asignatura, cedulaDocente, nombreDocente, apellidoDocente)   
    public void cargarTablaCursosFull(JTable table) {
        Persistencia_SQL persistencia = new Persistencia_SQL();
        GestorCursos gestorCursos = new GestorCursos();
        Docente docente = new Docente();

        List<Curso> listaCursos = gestorCursos.cargarCursosDesdeBD();

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        // Eliminar todas las filas vacías del modelo
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }

        // Agregar datos de la lista de cursos al modelo de la tabla
        for (Curso curso : listaCursos) {
            // Obtener los datos del docente para el curso actual
            docente = persistencia.obtenerDatosDocenteParaCurso(curso.getId_curso());

            // Agregar una fila con los datos del curso y del docente.
            model.addRow(new Object[]{
                curso.getClaseYgrupo(),
                curso.getAsignatura(),
                docente.getCedula(),
                docente.getNombre(),
                docente.getApellido()
            });
        }

        table.repaint(); // Actualizar la tabla
    }

//CARGAR LOS DOCENTES EN EL JTable - Tabla Full (curso, asignatura)   
    public void cargarTablaCursosSimple(JTable table) {
        Persistencia_SQL persistencia = new Persistencia_SQL();
        GestorCursos gestorCursos = new GestorCursos();
        Docente docente = new Docente();

        List<Curso> listaCursos = gestorCursos.cargarCursosDesdeBD();

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        // Eliminar todas las filas vacías del modelo
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }

        // Agregar datos de la lista de cursos al modelo de la tabla
        for (Curso curso : listaCursos) {
            // Obtener los datos del docente para el curso actual
            //docente = persistencia.obtenerDatosDocenteParaCurso(curso.getId_curso());
            // Agregar una fila con los datos del curso y del docente.
            model.addRow(new Object[]{
                curso.getClaseYgrupo(),
                curso.getAsignatura(),
            });
        }

        table.repaint(); // Actualizar la tabla
    }

//CARGAR LOS DOCENTES EN EL JTable - Tabla Full (curso, asignatura)   
    public void cargarTablaCursosSimpleDeDocenteEspecifico(JTable table, Integer cedula) {
        Persistencia_SQL persistencia = new Persistencia_SQL();
        GestorCursos gestorCursos = new GestorCursos();
        Docente docente = new Docente();

        List<Curso> listaCursos = gestorCursos.cargarCursosDeDocenteEspecificoDesdeBD(cedula);

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        // Eliminar todas las filas vacías del modelo
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }

        // Agregar datos de la lista de cursos al modelo de la tabla
        for (Curso curso : listaCursos) {
            // Obtener los datos del docente para el curso actual
            //docente = persistencia.obtenerDatosDocenteParaCurso(curso.getId_curso());
            // Agregar una fila con los datos del curso y del docente.
            model.addRow(new Object[]{
                curso.getClaseYgrupo(),
                curso.getAsignatura(),
            });
        }

        table.repaint(); // Actualizar la tabla
    }    





    
    
}
