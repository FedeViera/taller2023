/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package interfazGrafica;

/**
 *
 * @author Federico
 */
public class InterfazTaller2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Estan los 2 solo para prueba (luego utilziaremos solo el Login y desde ahi llamamos a las otros JFrames)
        
        //Mostrar Login
        
        Login sesion = new Login();
        sesion.setVisible(true);
        sesion.setLocationRelativeTo(null);
        
        //Mostrar Admin
        /*Administrador admin = new Administrador();
        admin.setVisible(true);
        admin.setLocationRelativeTo(null);*/
   
        
    }
    
}
