/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfazGrafica;

import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
//Taller 1v1

/**
 *
 * @author SDFA
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        this.setTitle("SDFA - Portafolio Docente");
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/logoPNG.png")).getImage());
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
        imgMaleta = new javax.swing.JLabel();
        textoPortafolioDocente = new javax.swing.JLabel();
        imgFondoMaleta = new javax.swing.JLabel();
        tituloUsuario = new javax.swing.JLabel();
        textoUsuario = new javax.swing.JTextField();
        separadorUsuario = new javax.swing.JSeparator();
        tituloContraseña = new javax.swing.JLabel();
        textoContraseña = new javax.swing.JPasswordField();
        separadorContraseña = new javax.swing.JSeparator();
        botonEntrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panelLogin.setBackground(new java.awt.Color(255, 255, 255));
        panelLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        tituloContraseña.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        tituloContraseña.setText("CONTRASEÑA:");
        panelLogin.add(tituloContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 190, 50));

        textoContraseña.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        textoContraseña.setBorder(null);
        textoContraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                textoContraseñaMousePressed(evt);
            }
        });
        textoContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoContraseñaActionPerformed(evt);
            }
        });
        textoContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textoContraseñaKeyPressed(evt);
            }
        });
        panelLogin.add(textoContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 440, 50));

        separadorContraseña.setForeground(new java.awt.Color(0, 0, 0));
        panelLogin.add(separadorContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, 440, 30));

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

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoSDFA.png"))); // NOI18N
        panelLogin.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 410, 130));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Número: 1, 2 o 3 - no precisa contraseña");
        panelLogin.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 400, -1));

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
        String nombreUsuario = textoUsuario.getText();
    }//GEN-LAST:event_textoUsuarioActionPerformed

    // Boton ENTRAR del panel Login (ahora inicia el Panel Administrador, luego dependiendo de quien logee ira a distintos paneles)
    private void botonEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEntrarActionPerformed
        abrirVentanaCorrespondiente();
    }//GEN-LAST:event_botonEntrarActionPerformed

    
    private void textoUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textoUsuarioMousePressed
            
    }//GEN-LAST:event_textoUsuarioMousePressed

    private void textoContraseñaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textoContraseñaMousePressed
        
    }//GEN-LAST:event_textoContraseñaMousePressed

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

    private void textoContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoContraseñaActionPerformed

    //AL PRESIONAR ENTER EN EL CAMPO DE CONTRASEÑA LEVANTA METODO abrirVentanaCorrespondiente()
    private void textoContraseñaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoContraseñaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        abrirVentanaCorrespondiente();
        }
    }//GEN-LAST:event_textoContraseñaKeyPressed

    //Chequeo el usuario y Abre la ventana Correspondiente (FALTA VER EL CHEQUEO CON LA BASE DE DATOS)
    private void abrirVentanaCorrespondiente() {
        // Guarda la posición del Panel Login para abrir el otro en las mismas coordenadas
        int x = getLocation().x;
        int y = getLocation().y;
        this.setVisible(false);

        String usuario = textoUsuario.getText(); // Obtener el contenido de la casilla de usuario

        if (usuario.equals("1")) {
            Administrador admin = new Administrador();
            admin.bienvenidaUsuario(usuario); // Llama al método bienvenidaUsuario() y pasa el nombre de usuario
            admin.setVisible(true);
            admin.setLocationRelativeTo(null);
            admin.setLocation(x, y);
        } else if (usuario.equals("2")) {
            Docente docente = new Docente();
            docente.bienvenidaUsuario(usuario);
            docente.setVisible(true);
            docente.setLocationRelativeTo(null);
            docente.setLocation(x, y);
        } else if (usuario.equals("3")){
            Adscripto adscripto = new Adscripto();
            adscripto.bienvenidaUsuario(usuario);
            adscripto.setVisible(true);
            adscripto.setLocationRelativeTo(null);
            adscripto.setLocation(x, y);
        } else {
            // Manejar el caso en que el usuario no sea ni Administrador ni Docente
            JOptionPane.showMessageDialog(null, "El usuario no existe, intente con otro usuario", "Error", JOptionPane.ERROR_MESSAGE);
            this.setVisible(true);
        }
    }
    
    
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JSeparator separadorContraseña;
    private javax.swing.JSeparator separadorUsuario;
    private javax.swing.JPasswordField textoContraseña;
    private javax.swing.JLabel textoPortafolioDocente;
    private javax.swing.JTextField textoUsuario;
    private javax.swing.JLabel tituloContraseña;
    private javax.swing.JLabel tituloUsuario;
    // End of variables declaration//GEN-END:variables
}
