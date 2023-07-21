/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

//NO ANDA ALGO FALLA AL CONECTAR
package Clases;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import interfazGrafica.Login;

/**
 *
 * @author Federico
 */
public class Validacion {
    
    public void validarUsuario (JTextField usuario, JPasswordField contrasenia){
        
        try {
            ResultSet rs=null;
            PreparedStatement ps=null;
            
            Clases.Conexion objetoConexion = new Clases.Conexion();
            
            String consulta="SELECT * FROM Usuarios WHERE Usuarios.ingresoUsuario=(?) AND Usuarios.ingresoContrasenia=(?);";
            ps=objetoConexion.conectarMySQL().prepareStatement(consulta);
            
            String contra = String.valueOf(contrasenia.getPassword());
            ps.setString(1, usuario.getText());
            ps.setString(2, contra);
            
            rs=ps.executeQuery();
            
            if(rs.next()){
                // Usuario Correcto, abrir la ventana correspondiente
                Login login = new Login();
                login.abrirVentanaCorrespondiente();
            }
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+e.toString());
        }
 
    }
    
}
