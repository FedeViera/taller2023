package Logica;

import Entidades.Adscripto;
import Entidades.Docente;
import java.util.ArrayList;
import java.util.List;
import Persistencia.Persistencia_SQL;
import javax.swing.table.DefaultTableModel;

public class GestorAdscriptos {
    
    private List<Adscripto> listaAdscriptos;

    public GestorAdscriptos() {
        this.listaAdscriptos = new ArrayList<>();
    }

    public void agregarAdscripto(Adscripto adscripto) {
        listaAdscriptos.add(adscripto);
    }

    public void eliminarAdscripto(Adscripto adscripto) {
        listaAdscriptos.remove(adscripto);
    }

    public List<Adscripto> obtenerTodosLosAdscriptores() {
        return listaAdscriptos;
    }

    // Puedes agregar más métodos según tus necesidades

    public Adscripto buscarAdscriptoPorCedula(int cedula) {
        for (Adscripto adscripto : listaAdscriptos) {
            if (adscripto.getCedula() == cedula) {
                return adscripto;
            }
        }
        return null; // Adscripto no encontrado
    }
    
    public void cargarAdscriptosDesdeBD() {
        Persistencia_SQL persistencia = new Persistencia_SQL();
        listaAdscriptos = persistencia.mapearAdscriptos();
  
    }
    
    /*//LLAMAR PARA CARGAR ADSCRIPTOS
    GestorAdscriptos gestionarAdscriptos = new GestorAdscriptos();
    gestionarAdscriptos.cargarAdscriptosDesdeBD();*/
    
    //MOSTRAR ADSCRIPTOS
    public void mostrarAdscriptos() {
        for (Adscripto adscripto : listaAdscriptos) {
            System.out.println("Cédula: " + adscripto.getCedula());
            System.out.println("Nombre: " + adscripto.getNombre());
            System.out.println("Apellido: " + adscripto.getApellido());
            System.out.println("Usuario: " + adscripto.getUsuario());
            System.out.println("Contraseña: " + adscripto.getContrasenia());
            System.out.println("Cargo: " + adscripto.getCargo());
            System.out.println("Grado: " + adscripto.getGrado());
        }
    }

    public void insertarAdscriptosEnTabla(DefaultTableModel model) {
        // Verificar si la lista de administradores no está vacía
        if (!listaAdscriptos.isEmpty()) {
            // Limpiar cualquier dato existente en el modelo de la tabla
            model.setRowCount(0);

            // Iterar a través de la lista de administradores y agregar cada uno al modelo de la tabla
            for (Adscripto adscripto : listaAdscriptos) {
                Object[] fila = {
                    adscripto.getCedula(),
                    adscripto.getNombre(),
                    adscripto.getApellido(),
                    adscripto.getUsuario(),
                    adscripto.getContrasenia(),
                    adscripto.getCargo(),
                    adscripto.getGrado(),
                };
                model.addRow(fila);
            }
        } else {
            // Si la lista de administradores está vacía, puedes mostrar un mensaje o realizar alguna acción adecuada.
        }
    }

    
}

