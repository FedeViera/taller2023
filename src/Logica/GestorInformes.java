package Logica;

import Entidades.Informe;
import Persistencia.Persistencia_SQL;
import java.util.ArrayList;
import java.util.List;


public class GestorInformes {
    
    private List<Informe> listaInformes;

    public GestorInformes() {
        this.listaInformes = new ArrayList<>();
    }

//BUSCAR ADMINISTRADOR    
    public Informe buscarInforme(int idInforme) {
        for (Informe informe : listaInformes) {
            if (informe.getId_informe() == idInforme) {
                return informe;
            }
        }
        return null; // Administrador no encontrado
    }
    
//ADMINISTRADOR EXISTE
    public boolean informeExiste(int idInforme) {
        for (Informe informe : listaInformes) {
            if (informe.getId_informe()== idInforme) {
                return true; // El administrador existe en la lista
            }
        }
        return false; // El administrador no existe en la lista
    }
    
//LISTAR ADMINISTRADORES DESDE BD
    public List<Informe>  cargarInformesDesdeBD() {
        Persistencia_SQL persistencia = new Persistencia_SQL();
        listaInformes = persistencia.mapearInformes();
        return listaInformes;
    }
    

//MOSTRAR INFORMES (PARA PRUEBAS)
    public void mostrarInformes() {
        for (Informe informe : listaInformes) {
            System.out.println("idInforme: "+informe.getId_informe());
            System.out.println("Diagnostico: "+informe.getDiagnostico());
        }
    }
    
//LOGICA AGREGAR ADMINISTRADOR    
    public void agregarInforme(String descripcion, String fecha) {
        Informe nuevoInforme = new Informe();
        nuevoInforme.setDiagnostico(descripcion);

        Persistencia_SQL persistencia = new Persistencia_SQL();
        persistencia.agregarInforme(nuevoInforme);
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
