/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafica;

import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Federico
 */
public class Alertas {
    
    //CHEQUEA NUMERICOS
    public static boolean esNumerico(String texto) {
        try {
            Long.parseLong(texto);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    //CHEQUEA CARACTERES ESPECIALES
    public static boolean contieneCaracteresEspeciales(String texto) {
        // verificar caracteres especiales
        String patron = "[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?]+";

        // Comprueba si el texto contiene caracteres especiales
        return texto.matches(".*" + patron + ".*");
    }
    
    //CHEQUEA CEDULA -8 CARACTERES Y SOLO NÚMERICOS
    public static void checkCedula(JTextField campo, JLabel mensajeAlertaCedula) {
        String texto = campo.getText();

        // Realiza la validación solo si la longitud es mayor a 0
        if (texto.length() > 0) {
            if (texto.length() > 8 || !esNumerico(texto)) {
                mensajeAlertaCedula.setText("La cédula debe tener 8 dígitos numéricos.");
            } else {
                mensajeAlertaCedula.setText(""); // Limpia el mensaje si es válido
            }
        } else {
            mensajeAlertaCedula.setText(""); // Limpia el mensaje si no hay texto
        }
    }
    
    //CHEQUEA NOMBRE SOLO LETRAS
    public static void checkNombre(JTextField campo, JLabel mensajeAlertaNombre) {
        String texto = campo.getText();

        // Realiza la validación solo si la longitud es mayor a 0
        if (texto.length() > 0) {
            if (esNumerico(texto)||contieneCaracteresEspeciales(texto)) {
                mensajeAlertaNombre.setText("El campo Nombre solo acepta letras.");
            } else {
                mensajeAlertaNombre.setText(""); // Limpia el mensaje si es válido
            }
        } else {
            mensajeAlertaNombre.setText(""); // Limpia el mensaje si no hay texto
        }
    }
    
    //CHEQUEA APELLIDO SOLO LETRAS
    public static void checkApellido(JTextField campo, JLabel mensajeAlertaApellido) {
        String texto = campo.getText();

        // Realiza la validación solo si la longitud es mayor a 0
        if (texto.length() > 0) {
            if (esNumerico(texto)||contieneCaracteresEspeciales(texto)) {
                mensajeAlertaApellido.setText("El campo Apellido solo acepta letras.");
            } else {
                mensajeAlertaApellido.setText(""); // Limpia el mensaje si es válido
            }
        } else {
            mensajeAlertaApellido.setText(""); // Limpia el mensaje si no hay texto
        }
    }


}
