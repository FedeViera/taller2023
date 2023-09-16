package Logica;

import Entidades.Administrador;
import Persistencia.Persistencia_SQL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



public class GestorAdministradores {
    
    private List<Administrador> listaAdministradores;

    public GestorAdministradores() {
        this.listaAdministradores = new ArrayList<>();
    }

    
    public Administrador buscarAdministradorPorCedula(int cedula) {
        for (Administrador administrador : listaAdministradores) {
            if (administrador.getCedula() == cedula) {
                return administrador;
            }
        }
        return null; // Administrador no encontrado
    }
    
//LISTAR ADMINISTRADORES DESDE BD
    public List<Administrador>  cargarAdministradoresDesdeBD() {
        Persistencia_SQL persistencia = new Persistencia_SQL();
        listaAdministradores = persistencia.mapearAdministradores();
        return listaAdministradores;
    }
    
    /*//LLAMAR PARA CARGAR ADMINISTRADORES
    GestorAdministradores gestionarAdministradores = new GestorAdministradores();
    gestionarAdministradores.cargarAdministradoresDesdeBD();*/
    
    //MOSTRAR ADMINISTRADORES
    public void mostrarAdministradores() {
        for (Administrador administrador : listaAdministradores) {
            System.out.println("Cédula: " + administrador.getCedula());
            System.out.println("Nombre: " + administrador.getNombre());
            System.out.println("Apellido: " + administrador.getApellido());
            System.out.println("Usuario: " + administrador.getUsuario());
            System.out.println("Contrasenia: " + administrador.getContrasenia());
            System.out.println("Cargo: " + administrador.getCargo());
        }
    }
    
//LOGICA AGREGAR ADMINISTRADOR    
    public void agregarAdministrador(Integer cedula, String nombre, String apellido, String usuario, String contrasenia, String cargo) {
        Administrador nuevoAdministrador = new Administrador();
        nuevoAdministrador.setCedula(cedula);
        nuevoAdministrador.setNombre(nombre);
        nuevoAdministrador.setApellido(apellido);
        nuevoAdministrador.setUsuario(usuario);
        nuevoAdministrador.setContrasenia(contrasenia);
        nuevoAdministrador.setCargo(cargo);

        Persistencia_SQL persistencia = new Persistencia_SQL();
        persistencia.agregarAdministrador(nuevoAdministrador);
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


