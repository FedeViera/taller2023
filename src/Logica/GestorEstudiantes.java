package Logica;
import Entidades.Curso;
import Entidades.Estudiante;
import Persistencia.Persistencia_SQL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class GestorEstudiantes {
    
    private List<Estudiante> listaEstudiantes;

    public GestorEstudiantes() {
    }
        
//LISTAR ESTUDIANTES DESDE BD   
    public List<Estudiante>  cargarEstudiantesDesdeBD() {
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
 
//MOSTRAR ADMINISTRADORES (PARA PRUEBAS)
    public void mostrarEstudiantes(List<Estudiante> lista) {
        for (Estudiante estudiante : lista) {
            System.out.println("Cédula: " + estudiante.getId_estudiante());   
            System.out.println("Nombre: " + estudiante.getNombre());
            System.out.println("Apellido: " + estudiante.getApellido());
            System.out.println("Edad: " + estudiante.getEdad());
        }
    }    

//CARGAR LOS ESTUDIANTES EN EL JTable con checkbox   
    public void cargarTablaEstudiantes(JTable table) {
        GestorEstudiantes gestor = new GestorEstudiantes();
        
        List<Estudiante> listaEstudiantes = gestor.cargarEstudiantesDesdeBD();

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        // Agregar datos de la lista de estudiantes al modelo de la tabla
        for (Estudiante estudiante : listaEstudiantes) {
            // Agregar un objeto Boolean.TRUE para representar una casilla de verificación marcada
            model.addRow(new Object[]{
                Boolean.FALSE, // Inicialmente, la casilla de verificación está desmarcada
                estudiante.getId_estudiante(),
                estudiante.getNombre(),
                estudiante.getApellido(),
                estudiante.getEdad()
            });
        }

        // Configurar la primera columna para que muestre casillas de verificación
        TableColumn seleccionColumn = table.getColumnModel().getColumn(0);
        seleccionColumn.setCellRenderer(table.getDefaultRenderer(Boolean.class));
        seleccionColumn.setCellEditor(new DefaultCellEditor(new JCheckBox()));

        table.repaint(); // Actualizar la tabla
    }    
 
//CARGAR LOS ESTUDIANTES EN EL JTable - SIN Selector  
    public void cargarTablaEstudiantesCursoEspecifico_Simple(Integer cursoID, JTable table) {
        GestorEstudiantes gestor = new GestorEstudiantes();
        Persistencia_SQL persistencia = new Persistencia_SQL();
        
        List<Estudiante> listaEstudiantes = persistencia.obtenerEstudiantesCursoEspecifico(cursoID);

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        // Agregar datos de la lista de estudiantes al modelo de la tabla
        for (Estudiante estudiante : listaEstudiantes) {
            model.addRow(new Object[]{
                estudiante.getId_estudiante(),
                estudiante.getNombre(),
                estudiante.getApellido(),
                estudiante.getEdad()
            });
        }
        table.repaint(); // Actualizar la tabla
    }      

//CARGAR LOS ESTUDIANTES DE CURSO ESPECIFICO EN EL JTable - CON Selector   
    public void cargarTablaEstudiantesCursoEspecifico(Integer cursoID, JTable table) {
        Persistencia_SQL persistencia = new Persistencia_SQL();
        List<Estudiante> listaEstudiantesEspecifico = persistencia.obtenerEstudiantesCursoEspecifico(cursoID);

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        // Agregar datos de la lista de estudiantes al modelo de la tabla
        for (Estudiante estudiante : listaEstudiantesEspecifico) {
            // Agregar un objeto Boolean.TRUE para representar una casilla de verificación marcada
            model.addRow(new Object[]{
                Boolean.FALSE, // Inicialmente, la casilla de verificación está desmarcada
                estudiante.getId_estudiante(),
                estudiante.getNombre(),
                estudiante.getApellido(),
                estudiante.getEdad(),
            });
        }

        // Configurar la primera columna para que muestre casillas de verificación
        TableColumn seleccionColumn = table.getColumnModel().getColumn(0);
        seleccionColumn.setCellRenderer(table.getDefaultRenderer(Boolean.class));
        seleccionColumn.setCellEditor(new DefaultCellEditor(new JCheckBox()));

        table.repaint(); // Actualizar la tabla
    }      
    
//OBTENER ESTUDIANTE SELECIONADOS DE LA TablaEstudiantes (PARA LUEGO AGREGAR AL CURSO)     
    public List<Estudiante> obtenerEstudiantesSeleccionados_Agregar(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int rowCount = model.getRowCount();
        List<Estudiante> estudiantesSeleccionados_agregar = new ArrayList<>();

        for (int i = 0; i < rowCount; i++) {
            Boolean seleccionado = (Boolean) model.getValueAt(i, 0); // La primera columna es la de casillas de verificación
            if (seleccionado) {
                int idEstudiante = (int) model.getValueAt(i, 1); // Obtener el ID del estudiante
                String nombre = (String) model.getValueAt(i, 2); // Obtener el nombre del estudiante
                String apellido = (String) model.getValueAt(i, 3); // Obtener el apellido del estudiante
                int edad = (int) model.getValueAt(i, 4); // Obtener la edad del estudiante

                Estudiante estudiante = new Estudiante(idEstudiante, nombre, apellido, edad);
                estudiantesSeleccionados_agregar.add(estudiante);
            }
        }
        return estudiantesSeleccionados_agregar;
    }
 
//OBTENER ESTUDIANTE SELECIONADOS DE LA TablaEstudiantes (PARA LUEGO QUITAR ESTUDIANTES)     
    public List<Estudiante> obtenerEstudiantesSeleccionados_Quitar(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int rowCount = model.getRowCount();
        List<Estudiante> estudiantesSeleccionados_quitar = new ArrayList<>();

        for (int i = 0; i < rowCount; i++) {
            Boolean seleccionado = (Boolean) model.getValueAt(i, 0); // La primera columna es la de casillas de verificación
            if (seleccionado) {
                int idEstudiante = (int) model.getValueAt(i, 1); // Obtener el ID del estudiante
                Estudiante estudiante = new Estudiante();
                estudiante.setId_estudiante(idEstudiante);
                estudiantesSeleccionados_quitar.add(estudiante);
            }
        }
        return estudiantesSeleccionados_quitar;
    }    
    
    
    
    
    
    

    
    
    
}
