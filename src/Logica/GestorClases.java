package Logica;

import Entidades.Clase;
import Persistencia.Persistencia_SQL;
import java.util.ArrayList;
import java.util.List;


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
    public boolean informeExiste(int idClase) {
        for (Clase clase : listaClases) {
            if (clase.getId_clase()== idClase) {
                return true; 
            }
        }
        return false;
    }
    
//LISTAR ADMINISTRADORES DESDE BD
    public List<Clase>  cargarInformesDesdeBD() {
        Persistencia_SQL persistencia = new Persistencia_SQL();
        listaClases = persistencia.mapearClases();
        return listaClases;
    }
    

//MOSTRAR INFORMES (PARA PRUEBAS)
    public void mostrarClasess() {
        for (Clase clase : listaClases) {
            System.out.println("idClase: "+clase.getId_clase());
            System.out.println("Desarrollo: "+clase.getDesarrollo());
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
