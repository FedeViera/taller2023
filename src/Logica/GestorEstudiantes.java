package Logica;
import Entidades.Curso;
import Entidades.Estudiante;
import Persistencia.Persistencia_SQL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
    
//OBTENER ESTUDIANTE SELECIONADOS DE LA TablaEstudiantes (PARA LUEGO AGREGAR AL CURSO)     
    public List<Estudiante> obtenerEstudiantesSeleccionados(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int rowCount = model.getRowCount();
        List<Estudiante> estudiantesSeleccionados = new ArrayList<>();

        for (int i = 0; i < rowCount; i++) {
            Boolean seleccionado = (Boolean) model.getValueAt(i, 0); // La primera columna es la de casillas de verificación
            if (seleccionado) {
                int idEstudiante = (int) model.getValueAt(i, 1); // Obtén el ID del estudiante
                String nombre = (String) model.getValueAt(i, 2); // Obtén el nombre del estudiante
                String apellido = (String) model.getValueAt(i, 3); // Obtén el apellido del estudiante
                int edad = (int) model.getValueAt(i, 4); // Obtén la edad del estudiante

                Estudiante estudiante = new Estudiante(idEstudiante, nombre, apellido, edad);
                estudiantesSeleccionados.add(estudiante);
            }
        }
        return estudiantesSeleccionados;
    }

    
    
    
    
    
    
    
    

    
    
    
}
