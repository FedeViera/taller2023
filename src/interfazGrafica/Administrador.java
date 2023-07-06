/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfazGrafica;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author SDFA
 */
public class Administrador extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Administrador() {
        initComponents();
        this.setTitle("SDFA - Panel Administrador");
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

        panelAdministrador = new javax.swing.JPanel();
        banner = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        cerrarSesion = new javax.swing.JLabel();
        panelPestañas = new javax.swing.JTabbedPane();
        pestaña1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pestaña2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        botonGenerarCurso = new javax.swing.JButton();
        botonGenerarAdscriptor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelAdministrador.setBackground(new java.awt.Color(255, 255, 255));
        panelAdministrador.setMinimumSize(new java.awt.Dimension(1030, 670));
        panelAdministrador.setPreferredSize(new java.awt.Dimension(1030, 670));
        panelAdministrador.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        banner.setBackground(new java.awt.Color(38, 56, 63));

        titulo.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setText("Panel Administrador");

        cerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerrar-sesion.png"))); // NOI18N
        cerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarSesionMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout bannerLayout = new javax.swing.GroupLayout(banner);
        banner.setLayout(bannerLayout);
        bannerLayout.setHorizontalGroup(
            bannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bannerLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 428, Short.MAX_VALUE)
                .addComponent(cerrarSesion)
                .addGap(55, 55, 55))
        );
        bannerLayout.setVerticalGroup(
            bannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bannerLayout.createSequentialGroup()
                .addGroup(bannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bannerLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bannerLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(cerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        panelAdministrador.add(banner, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 110));

        pestaña1.setBackground(new java.awt.Color(255, 255, 255));
        pestaña1.setForeground(new java.awt.Color(0, 0, 0));
        pestaña1.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Dialog", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("PANEL GENERAR CURSO");

        javax.swing.GroupLayout pestaña1Layout = new javax.swing.GroupLayout(pestaña1);
        pestaña1.setLayout(pestaña1Layout);
        pestaña1Layout.setHorizontalGroup(
            pestaña1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pestaña1Layout.createSequentialGroup()
                .addGap(259, 259, 259)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(190, Short.MAX_VALUE))
        );
        pestaña1Layout.setVerticalGroup(
            pestaña1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pestaña1Layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(301, Short.MAX_VALUE))
        );

        panelPestañas.addTab("tab1", pestaña1);

        pestaña2.setBackground(new java.awt.Color(255, 255, 255));
        pestaña2.setForeground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Dialog", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("PANEL GENERAR CUENTA ADSCRIPTOR");

        javax.swing.GroupLayout pestaña2Layout = new javax.swing.GroupLayout(pestaña2);
        pestaña2.setLayout(pestaña2Layout);
        pestaña2Layout.setHorizontalGroup(
            pestaña2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pestaña2Layout.createSequentialGroup()
                .addContainerGap(185, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
        );
        pestaña2Layout.setVerticalGroup(
            pestaña2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pestaña2Layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(292, Short.MAX_VALUE))
        );

        panelPestañas.addTab("tab2", pestaña2);

        panelAdministrador.add(panelPestañas, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 790, 590));

        botonGenerarCurso.setBackground(new java.awt.Color(55, 208, 193));
        botonGenerarCurso.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        botonGenerarCurso.setText("Generar Curso");
        botonGenerarCurso.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonGenerarCurso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonGenerarCurso.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonGenerarCurso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonGenerarCursoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonGenerarCursoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonGenerarCursoMouseExited(evt);
            }
        });
        botonGenerarCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGenerarCursoActionPerformed(evt);
            }
        });
        botonGenerarCurso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botonGenerarCursoKeyPressed(evt);
            }
        });
        panelAdministrador.add(botonGenerarCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 240, 60));

        botonGenerarAdscriptor.setBackground(new java.awt.Color(55, 208, 193));
        botonGenerarAdscriptor.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        botonGenerarAdscriptor.setText("Generar Adscriptor");
        botonGenerarAdscriptor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonGenerarAdscriptor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonGenerarAdscriptor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonGenerarAdscriptor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonGenerarAdscriptorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonGenerarAdscriptorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonGenerarAdscriptorMouseExited(evt);
            }
        });
        botonGenerarAdscriptor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGenerarAdscriptorActionPerformed(evt);
            }
        });
        botonGenerarAdscriptor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botonGenerarAdscriptorKeyPressed(evt);
            }
        });
        panelAdministrador.add(botonGenerarAdscriptor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 240, 60));

        getContentPane().add(panelAdministrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarSesionMouseClicked
        int x = getLocation().x;
        int y = getLocation().y;
        this.setVisible(false);
        Login login = new Login();
        login.setVisible(true);
        login.setLocationRelativeTo(null);
        login.setLocation(x, y);
    }//GEN-LAST:event_cerrarSesionMouseClicked

    private void botonGenerarCursoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGenerarCursoMouseClicked
        panelPestañas.setSelectedIndex(0);
    }//GEN-LAST:event_botonGenerarCursoMouseClicked

    private void botonGenerarCursoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGenerarCursoMouseEntered
        botonGenerarCurso.setBackground(new Color(55,208,193));
    }//GEN-LAST:event_botonGenerarCursoMouseEntered

    private void botonGenerarCursoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGenerarCursoMouseExited
        botonGenerarCurso.setBackground(new Color(45,196,181));
    }//GEN-LAST:event_botonGenerarCursoMouseExited

    private void botonGenerarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGenerarCursoActionPerformed

    }//GEN-LAST:event_botonGenerarCursoActionPerformed

    private void botonGenerarCursoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botonGenerarCursoKeyPressed

    }//GEN-LAST:event_botonGenerarCursoKeyPressed

    private void botonGenerarAdscriptorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGenerarAdscriptorMouseClicked
        panelPestañas.setSelectedIndex(1);
    }//GEN-LAST:event_botonGenerarAdscriptorMouseClicked

    private void botonGenerarAdscriptorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGenerarAdscriptorMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_botonGenerarAdscriptorMouseEntered

    private void botonGenerarAdscriptorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGenerarAdscriptorMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_botonGenerarAdscriptorMouseExited

    private void botonGenerarAdscriptorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGenerarAdscriptorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonGenerarAdscriptorActionPerformed

    private void botonGenerarAdscriptorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botonGenerarAdscriptorKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonGenerarAdscriptorKeyPressed

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
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Administrador().setVisible(true);
            }
        });
    }

    void setVisibile(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel banner;
    private javax.swing.JButton botonGenerarAdscriptor;
    private javax.swing.JButton botonGenerarCurso;
    private javax.swing.JLabel cerrarSesion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel panelAdministrador;
    private javax.swing.JTabbedPane panelPestañas;
    private javax.swing.JPanel pestaña1;
    private javax.swing.JPanel pestaña2;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
