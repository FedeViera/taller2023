package Logica;

import Entidades.Clase;
import Entidades.Curso;
import Persistencia.Persistencia_SQL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class GestorClases {
    
    private List<Clase> listaClases;

    public GestorClases() {
        this.listaClases = new ArrayList<>();
    }

//BUSCAR ADMINISTRADOR    
    public Clase buscarClase(int idClase) {
        for (Clase clase : listaClases) {
            if (clase.getId_clase() == idClase) {
                return clase;
            }
        }
        return null;
    }
    
//ADMINISTRADOR EXISTE
    public boolean claseExiste(int idClase) {
        for (Clase clase : listaClases) {
            if (clase.getId_clase()== idClase) {
                return true; 
            }
        }
        return false;
    }
    
//LISTAR ADMINISTRADORES DESDE BD
    public List<Clase>  cargarClasesDesdeBD(Integer idCurso) {
        Persistencia_SQL persistencia = new Persistencia_SQL();
        listaClases = persistencia.mapearClasesEspecificos(idCurso);
        return listaClases;
    }
    

//MOSTRAR INFORMES (PARA PRUEBAS)
    public void mostrarClases() {
        for (Clase clase : listaClases) {
            System.out.println("idClase: "+clase.getId_clase());
            System.out.println("Desarrollo: "+clase.getDesarrollo());
            System.out.println("Fecha: "+clase.getFecha());
            System.out.println("idCurso: "+clase.getId_curso());
        }
    }
    
//LOGICA AGREGAR ADMINISTRADOR    
    public void agregarClase(java.sql.Date fecha, String desarrollo, Integer idCurso){
        Clase clase = new Clase();
        clase.setFecha(fecha);
        clase.setDesarrollo(desarrollo);
        clase.setId_curso(idCurso);
       
        
        Persistencia_SQL persistencia = new Persistencia_SQL();
        persistencia.agregarClase(clase);
    }
    
//ELIMINAR CLASE INDIVIDUAL
    public void eliminarClaseIndividual(Integer id_clase){
        Clase clase = new Clase();
        clase.setId_clase(id_clase);
        
        Persistencia_SQL persistencia = new Persistencia_SQL();
        persistencia.eliminarClaseIndividual(clase);
    }    
    
//ELIMINAR TODAS LAS CLASES DE UN CURSO
    public void eliminarClaseDeCurso(Integer id_curso){
        Clase clase = new Clase();
        clase.setId_curso(id_curso);
        
        Persistencia_SQL persistencia = new Persistencia_SQL();
        persistencia.eliminarClaseDeCurso(clase);
    }      
    
//CARGAR LOS DOCENTES EN EL JTable - Tabla Full (curso, asignatura, cedulaDocente, nombreDocente, apellidoDocente)   
    public void cargarTablaClases(JTable table, Integer idCurso) {
        Persistencia_SQL persistencia = new Persistencia_SQL();
        GestorClases gestorClases = new GestorClases();

        List<Clase> listaClases = gestorClases.cargarClasesDesdeBD(idCurso);

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Limpiar el modelo de la tabla

        // Agregar datos de la lista de clases al modelo de la tabla
        for (Clase clase : listaClases) {
            model.addRow(new Object[]{
                clase.getId_clase(),
                clase.getFecha(),
                clase.getDesarrollo(),
                clase.getId_curso(),
            });
        }

        table.repaint(); // Actualizar la tabla visualmente
    }   
    
    public Integer contarClasesDictadas(Integer idCurso){
        Curso curso = new Curso();
        curso.setId_curso(idCurso);
        
        Integer clasesDictadas = 0;
        
        Persistencia_SQL persistencia = new Persistencia_SQL();
        clasesDictadas = persistencia.contarClasesDictadas(curso);
        
        return clasesDictadas;
    }
    
    
    
/*
//ELIMINAR ADMINISTRADOR (NO LO USAMOS POR AHORA, ELIMINAMOS DIRECTAMENTE CON USUARIO YA QUE TODOS LOS "CARGOS" SON USUARIOS)
    public void eliminarAdministrador(Integer cedula, String cargo){
        Administrador administrador = new Administrador();
        administrador.setCedula(cedula);
        administrador.setCargo(cargo);
        
        Persistencia_SQL persistencia = new Persistencia_SQL();
        persistencia.eliminarUsuario(administrador.getCedula(), administrador.getCargo());    
    }
*/  
    
}
