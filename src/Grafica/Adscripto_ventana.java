package Grafica;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Adscripto_ventana extends javax.swing.JFrame {


    public Adscripto_ventana() {
        initComponents();
        this.setTitle("SDFA - Panel Adscripto");
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/logoPNG.png")).getImage());
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelAdministrador = new javax.swing.JPanel();
        bienvenidaUsuario = new javax.swing.JLabel();
        banner = new javax.swing.JPanel();
        panelOpciones = new javax.swing.JPanel();
        logoSDFA = new javax.swing.JLabel();
        separador = new javax.swing.JSeparator();
        botonCursos = new javax.swing.JButton();
        botonActividades = new javax.swing.JButton();
        botonEvaluaciones = new javax.swing.JButton();
        botonInformes = new javax.swing.JButton();
        botonCerrarSesion = new javax.swing.JButton();
        panelPestañas = new javax.swing.JTabbedPane();
        pestañaBienvenida = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        pestaña0 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pestaña1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        pestaña2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        pestaña4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panelAdministrador.setBackground(new java.awt.Color(255, 255, 255));
        panelAdministrador.setMinimumSize(new java.awt.Dimension(1030, 670));
        panelAdministrador.setPreferredSize(new java.awt.Dimension(1030, 670));
        panelAdministrador.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bienvenidaUsuario.setFont(new java.awt.Font("Gadugi", 3, 18)); // NOI18N
        bienvenidaUsuario.setForeground(new java.awt.Color(0, 0, 0));
        panelAdministrador.add(bienvenidaUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 470, 40));

        banner.setBackground(new java.awt.Color(0, 153, 51));

        javax.swing.GroupLayout bannerLayout = new javax.swing.GroupLayout(banner);
        banner.setLayout(bannerLayout);
        bannerLayout.setHorizontalGroup(
            bannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 950, Short.MAX_VALUE)
        );
        bannerLayout.setVerticalGroup(
            bannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        panelAdministrador.add(banner, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 950, 80));

        panelOpciones.setBackground(new java.awt.Color(38, 56, 63));

        logoSDFA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoSDFA-gris-chico.png"))); // NOI18N

        botonCursos.setBackground(new java.awt.Color(52, 80, 86));
        botonCursos.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        botonCursos.setForeground(new java.awt.Color(204, 204, 204));
        botonCursos.setText("    Cursos");
        botonCursos.setToolTipText("");
        botonCursos.setBorder(null);
        botonCursos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonCursos.setFocusPainted(false);
        botonCursos.setFocusable(false);
        botonCursos.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        botonCursos.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        botonCursos.setIconTextGap(10);
        botonCursos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonCursosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonCursosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonCursosMouseExited(evt);
            }
        });
        botonCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCursosActionPerformed(evt);
            }
        });
        botonCursos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botonCursosKeyPressed(evt);
            }
        });

        botonActividades.setBackground(new java.awt.Color(52, 80, 86));
        botonActividades.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        botonActividades.setForeground(new java.awt.Color(204, 204, 204));
        botonActividades.setText("    Actividades");
        botonActividades.setBorder(null);
        botonActividades.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonActividades.setFocusPainted(false);
        botonActividades.setFocusable(false);
        botonActividades.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        botonActividades.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        botonActividades.setIconTextGap(10);
        botonActividades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonActividadesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonActividadesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonActividadesMouseExited(evt);
            }
        });
        botonActividades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActividadesActionPerformed(evt);
            }
        });
        botonActividades.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botonActividadesKeyPressed(evt);
            }
        });

        botonEvaluaciones.setBackground(new java.awt.Color(52, 80, 86));
        botonEvaluaciones.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        botonEvaluaciones.setForeground(new java.awt.Color(204, 204, 204));
        botonEvaluaciones.setText("    Evaluaciones");
        botonEvaluaciones.setBorder(null);
        botonEvaluaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonEvaluaciones.setFocusPainted(false);
        botonEvaluaciones.setFocusable(false);
        botonEvaluaciones.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        botonEvaluaciones.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        botonEvaluaciones.setIconTextGap(10);
        botonEvaluaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonEvaluacionesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonEvaluacionesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonEvaluacionesMouseExited(evt);
            }
        });
        botonEvaluaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEvaluacionesActionPerformed(evt);
            }
        });
        botonEvaluaciones.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botonEvaluacionesKeyPressed(evt);
            }
        });

        botonInformes.setBackground(new java.awt.Color(52, 80, 86));
        botonInformes.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        botonInformes.setForeground(new java.awt.Color(204, 204, 204));
        botonInformes.setText("    Informes");
        botonInformes.setBorder(null);
        botonInformes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonInformes.setFocusPainted(false);
        botonInformes.setFocusable(false);
        botonInformes.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        botonInformes.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        botonInformes.setIconTextGap(10);
        botonInformes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonInformesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonInformesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonInformesMouseExited(evt);
            }
        });
        botonInformes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInformesActionPerformed(evt);
            }
        });
        botonInformes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botonInformesKeyPressed(evt);
            }
        });

        botonCerrarSesion.setBackground(new java.awt.Color(52, 80, 86));
        botonCerrarSesion.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        botonCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        botonCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Contacts.png"))); // NOI18N
        botonCerrarSesion.setText("Cerrar Sesion");
        botonCerrarSesion.setBorder(null);
        botonCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonCerrarSesion.setFocusPainted(false);
        botonCerrarSesion.setFocusable(false);
        botonCerrarSesion.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        botonCerrarSesion.setIconTextGap(10);
        botonCerrarSesion.setMargin(new java.awt.Insets(2, 14, 2, 20));
        botonCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonCerrarSesionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonCerrarSesionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonCerrarSesionMouseExited(evt);
            }
        });
        botonCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCerrarSesionActionPerformed(evt);
            }
        });
        botonCerrarSesion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botonCerrarSesionKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout panelOpcionesLayout = new javax.swing.GroupLayout(panelOpciones);
        panelOpciones.setLayout(panelOpcionesLayout);
        panelOpcionesLayout.setHorizontalGroup(
            panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botonCerrarSesion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelOpcionesLayout.createSequentialGroup()
                .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelOpcionesLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(logoSDFA, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(botonCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOpcionesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonActividades, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonEvaluaciones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonInformes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        panelOpcionesLayout.setVerticalGroup(
            panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOpcionesLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(logoSDFA, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(botonActividades, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(botonEvaluaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(botonInformes, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 232, Short.MAX_VALUE)
                .addComponent(botonCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelAdministrador.add(panelOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 670));

        pestañaBienvenida.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Dream Team.jpg"))); // NOI18N
        jLabel6.setText("jLabel6");

        javax.swing.GroupLayout pestañaBienvenidaLayout = new javax.swing.GroupLayout(pestañaBienvenida);
        pestañaBienvenida.setLayout(pestañaBienvenidaLayout);
        pestañaBienvenidaLayout.setHorizontalGroup(
            pestañaBienvenidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pestañaBienvenidaLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 915, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        pestañaBienvenidaLayout.setVerticalGroup(
            pestañaBienvenidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pestañaBienvenidaLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelPestañas.addTab("tab5", pestañaBienvenida);

        pestaña0.setBackground(new java.awt.Color(255, 255, 255));
        pestaña0.setForeground(new java.awt.Color(0, 0, 0));
        pestaña0.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Dialog", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/img/lacalle.jpg"))); // NOI18N
        jLabel1.setText("PANEL CURSOS");

        javax.swing.GroupLayout pestaña0Layout = new javax.swing.GroupLayout(pestaña0);
        pestaña0.setLayout(pestaña0Layout);
        pestaña0Layout.setHorizontalGroup(
            pestaña0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pestaña0Layout.createSequentialGroup()
                .addContainerGap(223, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );
        pestaña0Layout.setVerticalGroup(
            pestaña0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pestaña0Layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(151, Short.MAX_VALUE))
        );

        panelPestañas.addTab("tab1", pestaña0);

        pestaña1.setBackground(new java.awt.Color(255, 255, 255));
        pestaña1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Dialog", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/img/descarga (1).jpeg"))); // NOI18N
        jLabel2.setText("PANEL ACTIVIDADES");

        javax.swing.GroupLayout pestaña1Layout = new javax.swing.GroupLayout(pestaña1);
        pestaña1.setLayout(pestaña1Layout);
        pestaña1Layout.setHorizontalGroup(
            pestaña1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pestaña1Layout.createSequentialGroup()
                .addContainerGap(176, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125))
        );
        pestaña1Layout.setVerticalGroup(
            pestaña1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pestaña1Layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(211, Short.MAX_VALUE))
        );

        panelPestañas.addTab("tab2", pestaña1);

        pestaña2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Dialog", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/img/descarga.jpeg"))); // NOI18N
        jLabel3.setText("PANEL EVALUACIONES");

        javax.swing.GroupLayout pestaña2Layout = new javax.swing.GroupLayout(pestaña2);
        pestaña2.setLayout(pestaña2Layout);
        pestaña2Layout.setHorizontalGroup(
            pestaña2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pestaña2Layout.createSequentialGroup()
                .addContainerGap(176, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        pestaña2Layout.setVerticalGroup(
            pestaña2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pestaña2Layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(211, Short.MAX_VALUE))
        );

        panelPestañas.addTab("tab3", pestaña2);

        pestaña4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Dialog", 3, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/img/descarga_1.jpeg"))); // NOI18N
        jLabel4.setText("PANEL INFORMES");

        javax.swing.GroupLayout pestaña4Layout = new javax.swing.GroupLayout(pestaña4);
        pestaña4.setLayout(pestaña4Layout);
        pestaña4Layout.setHorizontalGroup(
            pestaña4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pestaña4Layout.createSequentialGroup()
                .addContainerGap(211, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );
        pestaña4Layout.setVerticalGroup(
            pestaña4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pestaña4Layout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(178, Short.MAX_VALUE))
        );

        panelPestañas.addTab("tab4", pestaña4);

        panelAdministrador.add(panelPestañas, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 960, 570));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelAdministrador, javax.swing.GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCerrarSesionMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_botonCerrarSesionMouseClicked

    private void botonCerrarSesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCerrarSesionMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_botonCerrarSesionMouseEntered

    private void botonCerrarSesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCerrarSesionMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_botonCerrarSesionMouseExited

    private void botonCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCerrarSesionActionPerformed
        int x = getLocation().x;
        int y = getLocation().y;
        this.setVisible(false);
        Login_ventana login = new Login_ventana();
        login.setVisible(true);
        login.setLocationRelativeTo(null); 
        login.setLocation(x, y);
    }//GEN-LAST:event_botonCerrarSesionActionPerformed

    private void botonCerrarSesionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botonCerrarSesionKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonCerrarSesionKeyPressed

    private void botonEvaluacionesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botonEvaluacionesKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonEvaluacionesKeyPressed

    private void botonEvaluacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEvaluacionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonEvaluacionesActionPerformed

    private void botonEvaluacionesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEvaluacionesMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_botonEvaluacionesMouseExited

    private void botonEvaluacionesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEvaluacionesMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_botonEvaluacionesMouseEntered

    private void cambiarEstadoBoton(JButton button, boolean isSelected) {
        if (isSelected) {
            button.setBackground(new Color(255, 255, 255));
            button.setForeground(new Color(0, 0, 0));
        } else {
            button.setBackground(new Color(52, 80, 86));
            button.setForeground(new Color(255, 255, 255));
        }
    }
    
    private void botonEvaluacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEvaluacionesMouseClicked
        panelPestañas.setSelectedIndex(3);
        cambiarEstadoBoton(botonEvaluaciones, true);
        cambiarEstadoBoton(botonCursos, false);
        cambiarEstadoBoton(botonActividades, false);
        cambiarEstadoBoton(botonInformes, false);
    }//GEN-LAST:event_botonEvaluacionesMouseClicked

    private void botonActividadesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botonActividadesKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonActividadesKeyPressed

    private void botonActividadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActividadesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonActividadesActionPerformed

    private void botonActividadesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonActividadesMouseExited
        //botonGenerarAdscriptor.setBackground(new Color(45,196,181));
    }//GEN-LAST:event_botonActividadesMouseExited

    private void botonActividadesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonActividadesMouseEntered
        //botonGenerarAdscriptor.setBackground(new Color(55,208,193));
    }//GEN-LAST:event_botonActividadesMouseEntered

    private void botonActividadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonActividadesMouseClicked
        panelPestañas.setSelectedIndex(2);
        cambiarEstadoBoton(botonActividades, true);
        cambiarEstadoBoton(botonCursos, false);
        cambiarEstadoBoton(botonEvaluaciones, false);
        cambiarEstadoBoton(botonInformes, false);
    }//GEN-LAST:event_botonActividadesMouseClicked

    private void botonCursosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botonCursosKeyPressed

    }//GEN-LAST:event_botonCursosKeyPressed

    private void botonCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCursosActionPerformed

    }//GEN-LAST:event_botonCursosActionPerformed

    private void botonCursosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCursosMouseExited
        //botonGenerarCurso.setBackground(new Color(45,196,181));
    }//GEN-LAST:event_botonCursosMouseExited

    private void botonCursosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCursosMouseEntered
        //botonGenerarCurso.setBackground(new Color(55,208,193));
    }//GEN-LAST:event_botonCursosMouseEntered

    private void botonCursosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCursosMouseClicked
        panelPestañas.setSelectedIndex(1);
        cambiarEstadoBoton(botonCursos, true);
        cambiarEstadoBoton(botonActividades, false);
        cambiarEstadoBoton(botonEvaluaciones, false);
        cambiarEstadoBoton(botonInformes, false);
    }//GEN-LAST:event_botonCursosMouseClicked

    private void botonInformesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonInformesMouseClicked
        panelPestañas.setSelectedIndex(4);
        cambiarEstadoBoton(botonInformes, true);
        cambiarEstadoBoton(botonCursos, false);
        cambiarEstadoBoton(botonActividades, false);
        cambiarEstadoBoton(botonEvaluaciones, false);
    }//GEN-LAST:event_botonInformesMouseClicked

    private void botonInformesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonInformesMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_botonInformesMouseEntered

    private void botonInformesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonInformesMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_botonInformesMouseExited

    private void botonInformesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonInformesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonInformesActionPerformed

    private void botonInformesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botonInformesKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonInformesKeyPressed
     
    //Metodo para cambiar el nombre en la bienvenida
    public void bienvenidaUsuario(String nombreUsuario) {
    bienvenidaUsuario.setText("Bienvenido/a Adscripto " + nombreUsuario);
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
            java.util.logging.Logger.getLogger(Adscripto_ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Adscripto_ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Adscripto_ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Adscripto_ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Adscripto_ventana().setVisible(true);
            }
        });
    }

    void setVisibile(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel banner;
    private javax.swing.JLabel bienvenidaUsuario;
    private javax.swing.JButton botonActividades;
    private javax.swing.JButton botonCerrarSesion;
    private javax.swing.JButton botonCursos;
    private javax.swing.JButton botonEvaluaciones;
    private javax.swing.JButton botonInformes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel logoSDFA;
    private javax.swing.JPanel panelAdministrador;
    private javax.swing.JPanel panelOpciones;
    private javax.swing.JTabbedPane panelPestañas;
    private javax.swing.JPanel pestaña0;
    private javax.swing.JPanel pestaña1;
    private javax.swing.JPanel pestaña2;
    private javax.swing.JPanel pestaña4;
    private javax.swing.JPanel pestañaBienvenida;
    private javax.swing.JSeparator separador;
    // End of variables declaration//GEN-END:variables
}
