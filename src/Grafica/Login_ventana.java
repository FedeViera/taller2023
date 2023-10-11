
package Grafica;

import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import Persistencia.Persistencia_SQL;
import Entidades.Usuario;
import Logica.GestorUsuarios;
import javax.swing.JTable;


public class Login_ventana extends javax.swing.JFrame {

    private JTable tablaCuentas;
    public static Integer cedulaDocente;
    
    public Login_ventana() {
        initComponents();
        this.setTitle("SDFA - Portafolio Docente");
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/logoPNG.png")).getImage());
        verPswd.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLogin = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        imgMaleta = new javax.swing.JLabel();
        textoPortafolioDocente = new javax.swing.JLabel();
        imgFondoMaleta = new javax.swing.JLabel();
        tituloUsuario = new javax.swing.JLabel();
        textoUsuario = new javax.swing.JTextField();
        separadorUsuario = new javax.swing.JSeparator();
        tituloContrasenia = new javax.swing.JLabel();
        textoContrasenia = new javax.swing.JPasswordField();
        separadorContrasenia = new javax.swing.JSeparator();
        botonEntrar = new javax.swing.JButton();
        logo = new javax.swing.JLabel();
        verPswd = new javax.swing.JLabel();
        ocultarPswd = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panelLogin.setBackground(new java.awt.Color(255, 255, 255));
        panelLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/0.jpg"))); // NOI18N
        panelLogin.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 40, 150));

        imgMaleta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/maletaBlanca.png"))); // NOI18N
        panelLogin.add(imgMaleta, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 220, -1, 130));

        textoPortafolioDocente.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        textoPortafolioDocente.setForeground(new java.awt.Color(255, 255, 255));
        textoPortafolioDocente.setText("PORTAFOLIO DOCENTE");
        panelLogin.add(textoPortafolioDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 370, 220, 40));

        imgFondoMaleta.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        imgFondoMaleta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/gradient-background-768x1024-10974.jpg"))); // NOI18N
        imgFondoMaleta.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panelLogin.add(imgFondoMaleta, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 0, 250, 670));

        tituloUsuario.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        tituloUsuario.setText("USUARIO:");
        panelLogin.add(tituloUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 130, 50));

        textoUsuario.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        textoUsuario.setForeground(new java.awt.Color(153, 153, 153));
        textoUsuario.setBorder(null);
        textoUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textoUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                textoUsuarioMousePressed(evt);
            }
        });
        textoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoUsuarioActionPerformed(evt);
            }
        });
        panelLogin.add(textoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 440, 50));

        separadorUsuario.setForeground(new java.awt.Color(0, 0, 0));
        panelLogin.add(separadorUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 440, 30));

        tituloContrasenia.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        tituloContrasenia.setText("CONTRASEÑA:");
        panelLogin.add(tituloContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 190, 50));

        textoContrasenia.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        textoContrasenia.setBorder(null);
        textoContrasenia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                textoContraseniaMousePressed(evt);
            }
        });
        textoContrasenia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoContraseniaActionPerformed(evt);
            }
        });
        textoContrasenia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textoContraseniaKeyPressed(evt);
            }
        });
        panelLogin.add(textoContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 440, 50));

        separadorContrasenia.setForeground(new java.awt.Color(0, 0, 0));
        panelLogin.add(separadorContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, 440, 30));

        botonEntrar.setBackground(new java.awt.Color(55, 208, 193));
        botonEntrar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        botonEntrar.setText("ENTRAR");
        botonEntrar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonEntrar.setFocusPainted(false);
        botonEntrar.setFocusable(false);
        botonEntrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonEntrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonEntrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonEntrarMouseExited(evt);
            }
        });
        botonEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEntrarActionPerformed(evt);
            }
        });
        botonEntrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botonEntrarKeyPressed(evt);
            }
        });
        panelLogin.add(botonEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, 170, 60));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoSDFA_3.gif"))); // NOI18N
        logo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panelLogin.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 410, 130));

        verPswd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonMostrar.png"))); // NOI18N
        verPswd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        verPswd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                verPswdMouseClicked(evt);
            }
        });
        panelLogin.add(verPswd, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 400, 30, 30));

        ocultarPswd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonOcultar.png"))); // NOI18N
        ocultarPswd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ocultarPswd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ocultarPswdMouseClicked(evt);
            }
        });
        panelLogin.add(ocultarPswd, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 400, 30, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void textoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoUsuarioActionPerformed
        String nickUsuario = textoUsuario.getText(); 
    }//GEN-LAST:event_textoUsuarioActionPerformed

    String nickUsuario;
    public String getnickUsuario() {
        return nickUsuario;
    }
    
    String contraseniaUsuario;
    public String getContraseniaUsuario() {
        return contraseniaUsuario;
    }
    
// Boton ENTRAR del panel Login (ahora inicia el Panel Administrador, luego dependiendo de quien logee ira a distintos paneles)
    private void botonEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEntrarActionPerformed
        // Obtener el nombre de usuario y contraseña ingresados por el usuario
        String nickUsuario = textoUsuario.getText();
        String contraseniaUsuario = textoContrasenia.getText(); 
        // Instancia de la capa lógica
        GestorUsuarios control = new GestorUsuarios(); 

        boolean usuarioValido = control.validarUsuario(nickUsuario, contraseniaUsuario);

        if (usuarioValido) {
            // Obtener el cargo del usuario
            String cargo = control.obtenerCargo(nickUsuario, contraseniaUsuario);
            String nombreyApellido = control.obtenerNombreyApellido(nickUsuario, contraseniaUsuario);
            
            cedulaDocente = control.obtenerCedula(nickUsuario, contraseniaUsuario);

            if (cargo != null) {
                int x = getLocation().x;
                int y = getLocation().y;
                this.setVisible(false);
                switch (cargo) {
                    case "Administrador":
                        // Abre la ventana de Administrador
                        Administrador_ventana admin = new Administrador_ventana();
                        admin.bienvenidaUsuario(nombreyApellido);
                        admin.setVisible(true);
                        admin.setLocationRelativeTo(null);
                        admin.setLocation(x, y);
                        break;
                    case "Adscripto":
                        // Abre la ventana de Adscripto
                        Adscripto_ventana adscripto = new Adscripto_ventana();
                        adscripto.bienvenidaUsuario(nombreyApellido);
                        adscripto.setVisible(true);
                        adscripto.setLocationRelativeTo(null);
                        adscripto.setLocation(x, y);
                        break;
                    case "Docente":
                        // Abre la ventana de Docente
                        Docente_ventana docente = new Docente_ventana();
                        docente.bienvenidaUsuario(nombreyApellido);
                        docente.setVisible(true);
                        docente.setLocationRelativeTo(null);
                        docente.setLocation(x, y);
                        break;
                    default:
                        JOptionPane.showMessageDialog(this, "Cargo desconocido", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                }
            } else {
                // Mostrar un mensaje de error en caso de que no se pueda obtener el cargo del usuario
                JOptionPane.showMessageDialog(this, "No se pudo obtener el cargo del usuario", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            // Mostrar un mensaje de error en caso de que el usuario no sea válido.
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos");
        }
    }//GEN-LAST:event_botonEntrarActionPerformed

    
    private void textoUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textoUsuarioMousePressed
            
    }//GEN-LAST:event_textoUsuarioMousePressed

    private void textoContraseniaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textoContraseniaMousePressed

    }//GEN-LAST:event_textoContraseniaMousePressed

    private void botonEntrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEntrarMouseClicked

    }//GEN-LAST:event_botonEntrarMouseClicked

    private void botonEntrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botonEntrarKeyPressed
        
    }//GEN-LAST:event_botonEntrarKeyPressed

    //Al pasar el mouse por encima del boton ENTRAR cambia el color
    private void botonEntrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEntrarMouseEntered
        botonEntrar.setBackground(new Color(55,208,193));
    }//GEN-LAST:event_botonEntrarMouseEntered

    //Al quitar el mouse por encima del boton ENTRAR vuelve al color original
    private void botonEntrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEntrarMouseExited
        botonEntrar.setBackground(new Color(45,196,181));
    }//GEN-LAST:event_botonEntrarMouseExited

    private void textoContraseniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoContraseniaActionPerformed
        String contrasenia = new String(textoContrasenia.getPassword());
    }//GEN-LAST:event_textoContraseniaActionPerformed

//AL PRESIONAR ENTER EN EL CAMPO DE CONTRASEÑA LEVANTA EL LOGIN
    private void textoContraseniaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoContraseniaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            // Obtener el nombre de usuario y contraseña ingresados por el usuario
            String nickUsuario = textoUsuario.getText();
            String contraseniaUsuario = textoContrasenia.getText(); 
            // Instancia de la capa lógica
            GestorUsuarios control = new GestorUsuarios(); 

            boolean usuarioValido = control.validarUsuario(nickUsuario, contraseniaUsuario);

            if (usuarioValido) {
                // Obtener el cargo del usuario
                String cargo = control.obtenerCargo(nickUsuario, contraseniaUsuario);
                String nombreyApellido = control.obtenerNombreyApellido(nickUsuario, contraseniaUsuario);

                if (cargo != null) {
                    int x = getLocation().x;
                    int y = getLocation().y;
                    this.setVisible(false);
                    switch (cargo) {
                        case "Administrador":
                            // Abre la ventana de Administrador
                            Administrador_ventana admin = new Administrador_ventana();
                            admin.bienvenidaUsuario(nombreyApellido);
                            admin.setVisible(true);
                            admin.setLocationRelativeTo(null);
                            admin.setLocation(x, y);
                            break;
                        case "Docente":
                            // Abre la ventana de Adscripto
                            Adscripto_ventana adscripto = new Adscripto_ventana();
                            adscripto.bienvenidaUsuario(nombreyApellido);
                            adscripto.setVisible(true);
                            adscripto.setLocationRelativeTo(null);
                            adscripto.setLocation(x, y);
                            break;
                        case "Adscripto":
                            // Abre la ventana de Docente
                            Docente_ventana docente = new Docente_ventana();
                            docente.bienvenidaUsuario(nombreyApellido);
                            docente.setVisible(true);
                            docente.setLocationRelativeTo(null);
                            docente.setLocation(x, y);
                            break;
                        default:
                            // Cargo desconocido o inválido
                            JOptionPane.showMessageDialog(this, "Cargo desconocido", "Error", JOptionPane.ERROR_MESSAGE);
                            break;
                    }
                } else {
                    // Mostrar un mensaje de error en caso de que no se pueda obtener el cargo del usuario
                    JOptionPane.showMessageDialog(this, "No se pudo obtener el cargo del usuario", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                // Mostrar un mensaje de error en caso de que el usuario no sea válido.
                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos");
            }
        }
    }//GEN-LAST:event_textoContraseniaKeyPressed
 
    private char echoCharOriginal = '\u2022';
    private boolean contraseniaVisible = false;
    
    private void ocultarPswdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ocultarPswdMouseClicked
        ocultarPswd.setVisible(false);
        verPswd.setVisible(true);
        if (!contraseniaVisible) {
            textoContrasenia.setEchoChar(echoCharOriginal); // Ocultar el texto de la contraseña
            contraseniaVisible = true;
        }
    }//GEN-LAST:event_ocultarPswdMouseClicked

    private void verPswdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verPswdMouseClicked
        ocultarPswd.setVisible(true);
        verPswd.setVisible(false);
        if (contraseniaVisible) {
            textoContrasenia.setEchoChar((char) 0); // Mostrar el texto de la contraseña
            contraseniaVisible = false;
        }
    }//GEN-LAST:event_verPswdMouseClicked
    
//Chequeo el usuario y Abre la ventana Correspondiente
/*    public void abrirVentanaCorrespondiente(Usuario usuario) {
        String cargo = usuario.getCargo();
        String nombre = usuario.getNombre();
        //String apellido = usuario.getApellido();

        if (cargo != null) {
            int x = getLocation().x;
            int y = getLocation().y;
            this.setVisible(false);
            switch (cargo) {
                case "Administrador":
                    Administrador_ventana admin = new Administrador_ventana();
                    admin.bienvenidaUsuario(nombre);
                    admin.setVisible(true);
                    admin.setLocationRelativeTo(null);
                    admin.setLocation(x, y);
                    break;
                case "Docente":
                    Docente_ventana docente = new Docente_ventana();
                    docente.bienvenidaUsuario(nombre);
                    docente.setVisible(true);
                    docente.setLocationRelativeTo(null);
                    docente.setLocation(x, y);
                    break;
                case "Adscripto":
                    Adscripto_ventana adscripto = new Adscripto_ventana();
                    adscripto.bienvenidaUsuario(nombre);
                    adscripto.setVisible(true);
                    adscripto.setLocationRelativeTo(null);
                    adscripto.setLocation(x, y);
                    break;
                default:
                    // Cargo desconocido o inválido
                    JOptionPane.showMessageDialog(null, "Cargo desconocido", "Error", JOptionPane.ERROR_MESSAGE);
                    this.setVisible(true);
                    break;
            }
        }
    }*/
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login_ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login_ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login_ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login_ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login_ventana().setVisible(true);
            }
        });
    }

    void setVisibile(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonEntrar;
    private javax.swing.JLabel imgFondoMaleta;
    private javax.swing.JLabel imgMaleta;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel ocultarPswd;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JSeparator separadorContrasenia;
    private javax.swing.JSeparator separadorUsuario;
    private javax.swing.JPasswordField textoContrasenia;
    private javax.swing.JLabel textoPortafolioDocente;
    private javax.swing.JTextField textoUsuario;
    private javax.swing.JLabel tituloContrasenia;
    private javax.swing.JLabel tituloUsuario;
    private javax.swing.JLabel verPswd;
    // End of variables declaration//GEN-END:variables
}
