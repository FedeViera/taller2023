package Logica;

import Entidades.Administrador;
import Persistencia.Persistencia_SQL;
import java.util.ArrayList;
import java.util.List;


public class GestorAdministradores {
    
    private List<Administrador> listaAdministradores;

    public GestorAdministradores() {
        this.listaAdministradores = new ArrayList<>();
    }

    public void agregarAdministrador(Administrador administrador) {
        listaAdministradores.add(administrador);
    }

    public void eliminarAdministrador(Administrador administrador) {
        listaAdministradores.remove(administrador);
    }

    public List<Administrador> obtenerTodosLosAdministradores() {
        return listaAdministradores;
    }

    // Puedes agregar más métodos según tus necesidades

    public Administrador buscarAdministradorPorCedula(int cedula) {
        for (Administrador administrador : listaAdministradores) {
            if (administrador.getCedula() == cedula) {
                return administrador;
            }
        }
        return null; // Administrador no encontrado
    }
    
    public void cargarAdministradoresDesdeBD() {
        Persistencia_SQL persistencia = new Persistencia_SQL();
        List<Administrador> administradoresDesdeBD = persistencia.mapearAdministradores();
        listaAdministradores.addAll(administradoresDesdeBD);
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

}


