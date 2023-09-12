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

    public void agregarAdministrador(int cedula, String nombre, String apellido, String usuario, String contrasenia, String cargo) {
        Administrador nuevoAdministrador = new Administrador(cedula, nombre, apellido, usuario, contrasenia, cargo);
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
        listaAdministradores = persistencia.mapearAdministradores();
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
    
    /*
    public void insertarAdministradoresEnTabla(DefaultTableModel model) {
        // Verificar si la lista de administradores no está vacía
        if (!listaAdministradores.isEmpty()) {
            // Limpiar cualquier dato existente en el modelo de la tabla
            model.setRowCount(0);

            // Iterar a través de la lista de administradores y agregar cada uno al modelo de la tabla
            for (Administrador administrador : listaAdministradores) {
                Object[] fila = {
                    administrador.getCedula(),
                    administrador.getNombre(),
                    administrador.getApellido(),
                    administrador.getUsuario(),
                    administrador.getContrasenia(),
                    administrador.getCargo()
                };
                model.addRow(fila);
            }
        } else {
            // Si la lista de administradores está vacía, puedes mostrar un mensaje o realizar alguna acción adecuada.
        }
    }*/

    
    public void agregarAdministrador(Integer cedula, String nombre, String apellido, String usuario, String contrasenia, String cargo) {
        Administrador nuevoAdministrador = new Administrador();
        nuevoAdministrador.setCedula(cedula);
        nuevoAdministrador.setNombre(nombre);
        nuevoAdministrador.setApellido(apellido);
        nuevoAdministrador.setUsuario(usuario);
        nuevoAdministrador.setContrasenia(contrasenia);
        nuevoAdministrador.setCargo(cargo);

        // Llama a tu método de persistencia para agregar el Administrador
        Persistencia_SQL persistencia = new Persistencia_SQL();
        persistencia.agregarAdministrador(nuevoAdministrador);
    }
    

}


