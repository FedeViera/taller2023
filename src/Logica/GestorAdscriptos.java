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

//BUSCAR ADSCRIPTO    
    public Adscripto buscarAdscriptoPorCedula(int cedula) {
        for (Adscripto adscripto : listaAdscriptos) {
            if (adscripto.getCedula() == cedula) {
                return adscripto;
            }
        }
        return null; // Adscripto no encontrado
    }
    
//ADSCRIPTO EXISTE    
    public boolean adscriptoExiste(int cedula) {
    for (Adscripto adscripto : listaAdscriptos) {
        if (adscripto.getCedula() == cedula) {
            return true; // El adscripto existe en la lista
        }
    }
    return false; // El adscripto no existe en la lista
}

//LISTAR ADSCRIPTOS DESDE LA BD    
    public List<Adscripto> cargarAdscriptosDesdeBD() {
        Persistencia_SQL persistencia = new Persistencia_SQL();
        listaAdscriptos = persistencia.mapearAdscriptos();
        return listaAdscriptos;
    }
       
//MOSTRAR ADSCRIPTOS (PARA PRUEBAS)
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
    
//LOGICA AGREGAR ADSCRIPTO
    public void agregarAdscripto(Integer cedula, String nombre, String apellido, String usuario, String contrasenia, String cargo, Integer grado) {
        Adscripto nuevoAdscripto = new Adscripto();
        nuevoAdscripto.setCedula(cedula);
        nuevoAdscripto.setNombre(nombre);
        nuevoAdscripto.setApellido(apellido);
        nuevoAdscripto.setUsuario(usuario);
        nuevoAdscripto.setContrasenia(contrasenia);
        nuevoAdscripto.setCargo(cargo);
        nuevoAdscripto.setGrado(grado);

        // Llama a tu método de persistencia para agregar el Administrador
        Persistencia_SQL persistencia = new Persistencia_SQL();
        persistencia.agregarAdscripto(nuevoAdscripto);
    }
    
/*    
//ELIMINAR ADSCRIPTO (NO LO USAMOS POR AHORA, ELIMINAMOS DIRECTAMENTE CON USUARIO YA QUE TODOS LOS "CARGOS" SON USUARIOS)    
    public void eliminarAdscripto(Integer cedula, String cargo){
        Adscripto adscripto = new Adscripto();
        adscripto.setCedula(cedula);
        adscripto.setCargo(cargo);
        
        Persistencia_SQL persistencia = new Persistencia_SQL();
        persistencia.eliminarUsuario(adscripto.getCedula(), adscripto.getCargo());
    }
*/

    
}

