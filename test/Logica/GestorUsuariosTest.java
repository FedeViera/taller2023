/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Logica;

import Entidades.Administrador;
import Entidades.Usuario;
import Entidades.UsuarioLogeo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Federico
 */
public class GestorUsuariosTest {
    
    public GestorUsuariosTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testValidarUsuario() {
        System.out.println("validarUsuario");
        String usuario = "1";
        String contrasenia = "1";
        GestorUsuarios instance = new GestorUsuarios();
        boolean expResult = true;
        boolean result = instance.validarUsuario(usuario, contrasenia);
        assertEquals(expResult, result);
      
    }

    @Test
    public void testObtenerCargo() {
        System.out.println("obtenerCargo");
        String usuario = "1";
        String contrasenia = "1";
        GestorUsuarios instance = new GestorUsuarios();
        String expResult = "Administrador";
        String result = instance.obtenerCargo(usuario, contrasenia);
        assertEquals(expResult, result);
    
    }

    @Test
    public void testObtenerCedula() {
        System.out.println("obtenerCedula");
        String usuario = "1";
        String contrasenia = "1";
        GestorUsuarios instance = new GestorUsuarios();
        Integer expResult = 11111111;
        Integer result = instance.obtenerCedula(usuario, contrasenia);
        assertEquals(expResult, result);
    }

    @Test
    public void testObtenerNombreyApellido() {
        System.out.println("obtenerNombreyApellido");
        String usuario = "1";
        String contrasenia = "1";
        GestorUsuarios instance = new GestorUsuarios();
        String expResult = "Admin Admin";
        String result = instance.obtenerNombreyApellido(usuario, contrasenia);
        assertEquals(expResult, result);
  
    }
    
/*    
    @Test
    public void testObtenerTodosUsuarios() {
        System.out.println("obtenerTodosUsuarios");
        GestorUsuarios instance = new GestorUsuarios();
        List<Object> expResult = null;
        List<Object> result = instance.obtenerTodosUsuarios();
        assertEquals(expResult, result);
    }
*/
    
/*
    @Test
    public void testUsuarioExiste() {
        System.out.println("usuarioExiste");
        List<Object> listaGeneral = new ArrayList<>();
        
        Administrador admin = new Administrador(11111111, "Admin", "Admin", "1", "1", "Administrador");
        listaGeneral.add(admin);
    
        int cedulaVerificar = 11111111;
        String usuarioVerificar = "1";

        GestorUsuarios instance = new GestorUsuarios();
        boolean expResult = true; // El usuario debería existir
        boolean result = instance.usuarioExiste(listaGeneral, cedulaVerificar, usuarioVerificar);
        assertEquals(expResult, result);
    }
*/

    @Test
    public void testAgregarUsuario() {
        System.out.println("agregarUsuario");
        Integer cedula = 999999999;
        String nombre = "Test";
        String apellido = "Test";
        String usuario = "test1";
        String contrasenia = "test1";
        String cargo = "Administrador";
        GestorUsuarios instance = new GestorUsuarios();
        instance.agregarUsuario(cedula, nombre, apellido, usuario, contrasenia, cargo);
    }
    
    @Test
    public void testModificarUsuario() {
        System.out.println("modificarUsuario");
        int cedula = 999999999;
        String nuevaContrasenia = "test2";
        String nuevoCargo = "Docente";
        int nuevoGrado = 0;
        String nuevaAsignatura = "";
        GestorUsuarios instance = new GestorUsuarios();
        instance.modificarUsuario(cedula, nuevaContrasenia, nuevoCargo, nuevoGrado, nuevaAsignatura);

    }
    @Test
    public void testEliminarUsuario() {
        System.out.println("eliminarUsuario");
        Integer cedula = 999999999;
        String cargo = "Docente";
        GestorUsuarios instance = new GestorUsuarios();
        instance.eliminarUsuario(cedula, cargo);
    }

/*
    @Test
    public void testCargarTablaUsuarios() {
        System.out.println("cargarTablaUsuarios");
        JTable table = null;
        GestorUsuarios instance = new GestorUsuarios();
        instance.cargarTablaUsuarios(table);
        fail("The test case is a prototype.");
    }
*/
    
}
