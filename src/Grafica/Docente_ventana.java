package Grafica;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Docente_ventana extends javax.swing.JFrame {

    
    
    
    
    public Docente_ventana() {
        initComponents();
        this.setTitle("SDFA - Panel Docente");
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
        bienvenidaUsuario = new javax.swing.JLabel();
        banner = new javax.swing.JPanel();
        panelOpciones = new javax.swing.JPanel();
        logoSDFA = new javax.swing.JLabel();
        separador = new javax.swing.JSeparator();
        botonCursos = new javax.swing.JButton();
        botonActividades = new javax.swing.JButton();
        botonClases = new javax.swing.JButton();
        botonCerrarSesion = new javax.swing.JButton();
        panelPestañas = new javax.swing.JTabbedPane();
        pestañaBienvenida = new javax.swing.JPanel();
        pestaña0 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        Docente_textoSeleccionarCursoEstudiantes = new javax.swing.JLabel();
        tabla4 = new javax.swing.JScrollPane();
        Docente_TablaCursos = new javax.swing.JTable();
        pestaña1 = new javax.swing.JPanel();
        pestaña2 = new javax.swing.JPanel();
        pestaña4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panelAdministrador.setBackground(new java.awt.Color(255, 255, 255));
        panelAdministrador.setMinimumSize(new java.awt.Dimension(1030, 670));
        panelAdministrador.setPreferredSize(new java.awt.Dimension(1030, 670));
        panelAdministrador.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bienvenidaUsuario.setFont(new java.awt.Font("Gadugi", 3, 18)); // NOI18N
        bienvenidaUsuario.setForeground(new java.awt.Color(0, 0, 0));
        panelAdministrador.add(bienvenidaUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 470, 40));

        banner.setBackground(new java.awt.Color(255, 102, 51));

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

        botonClases.setBackground(new java.awt.Color(52, 80, 86));
        botonClases.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        botonClases.setForeground(new java.awt.Color(204, 204, 204));
        botonClases.setText("    Clases");
        botonClases.setBorder(null);
        botonClases.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonClases.setFocusPainted(false);
        botonClases.setFocusable(false);
        botonClases.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        botonClases.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        botonClases.setIconTextGap(10);
        botonClases.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonClasesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonClasesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonClasesMouseExited(evt);
            }
        });
        botonClases.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonClasesActionPerformed(evt);
            }
        });
        botonClases.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botonClasesKeyPressed(evt);
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
                    .addComponent(botonClases, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addComponent(botonClases, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 292, Short.MAX_VALUE)
                .addComponent(botonCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelAdministrador.add(panelOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 670));

        pestañaBienvenida.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pestañaBienvenidaLayout = new javax.swing.GroupLayout(pestañaBienvenida);
        pestañaBienvenida.setLayout(pestañaBienvenidaLayout);
        pestañaBienvenidaLayout.setHorizontalGroup(
            pestañaBienvenidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 958, Short.MAX_VALUE)
        );
        pestañaBienvenidaLayout.setVerticalGroup(
            pestañaBienvenidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 544, Short.MAX_VALUE)
        );

        panelPestañas.addTab("intro", pestañaBienvenida);

        pestaña0.setBackground(new java.awt.Color(255, 255, 255));
        pestaña0.setForeground(new java.awt.Color(0, 0, 0));
        pestaña0.setToolTipText("");

        jTabbedPane1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        Docente_textoSeleccionarCursoEstudiantes.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Docente_textoSeleccionarCursoEstudiantes.setForeground(new java.awt.Color(0, 0, 0));
        Docente_textoSeleccionarCursoEstudiantes.setText("Seleccionar curso:");

        Docente_TablaCursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Curso", "Asignatura", "Cédula Docente", "Nombre Docente", "Apellido Docente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Docente_TablaCursos.getTableHeader().setReorderingAllowed(false);
        tabla4.setViewportView(Docente_TablaCursos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Docente_textoSeleccionarCursoEstudiantes, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tabla4, javax.swing.GroupLayout.PREFERRED_SIZE, 913, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Docente_textoSeleccionarCursoEstudiantes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabla4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(349, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cursos", jPanel1);

        javax.swing.GroupLayout pestaña0Layout = new javax.swing.GroupLayout(pestaña0);
        pestaña0.setLayout(pestaña0Layout);
        pestaña0Layout.setHorizontalGroup(
            pestaña0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pestaña0Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
        );
        pestaña0Layout.setVerticalGroup(
            pestaña0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pestaña0Layout.createSequentialGroup()
                .addGap(0, 15, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelPestañas.addTab("tab0", pestaña0);

        pestaña1.setBackground(new java.awt.Color(255, 255, 255));
        pestaña1.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout pestaña1Layout = new javax.swing.GroupLayout(pestaña1);
        pestaña1.setLayout(pestaña1Layout);
        pestaña1Layout.setHorizontalGroup(
            pestaña1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 958, Short.MAX_VALUE)
        );
        pestaña1Layout.setVerticalGroup(
            pestaña1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 544, Short.MAX_VALUE)
        );

        panelPestañas.addTab("tab1", pestaña1);

        pestaña2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pestaña2Layout = new javax.swing.GroupLayout(pestaña2);
        pestaña2.setLayout(pestaña2Layout);
        pestaña2Layout.setHorizontalGroup(
            pestaña2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 958, Short.MAX_VALUE)
        );
        pestaña2Layout.setVerticalGroup(
            pestaña2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 544, Short.MAX_VALUE)
        );

        panelPestañas.addTab("tab2", pestaña2);

        pestaña4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pestaña4Layout = new javax.swing.GroupLayout(pestaña4);
        pestaña4.setLayout(pestaña4Layout);
        pestaña4Layout.setHorizontalGroup(
            pestaña4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 958, Short.MAX_VALUE)
        );
        pestaña4Layout.setVerticalGroup(
            pestaña4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 544, Short.MAX_VALUE)
        );

        panelPestañas.addTab("tab3", pestaña4);

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

    private void botonClasesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botonClasesKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonClasesKeyPressed

    private void botonClasesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonClasesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonClasesActionPerformed

    private void botonClasesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonClasesMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_botonClasesMouseExited

    private void botonClasesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonClasesMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_botonClasesMouseEntered

    private void cambiarEstadoBoton(JButton button, boolean isSelected) {
        if (isSelected) {
            button.setBackground(new Color(255, 255, 255));
            button.setForeground(new Color(0, 0, 0));
        } else {
            button.setBackground(new Color(52, 80, 86));
            button.setForeground(new Color(255, 255, 255));
        }
    }
    
    private void botonClasesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonClasesMouseClicked
        panelPestañas.setSelectedIndex(3);
        cambiarEstadoBoton(botonClases, true);
        cambiarEstadoBoton(botonCursos, false);
        cambiarEstadoBoton(botonActividades, false);
    }//GEN-LAST:event_botonClasesMouseClicked

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
        cambiarEstadoBoton(botonClases, false);
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
        cambiarEstadoBoton(botonClases, false);
    }//GEN-LAST:event_botonCursosMouseClicked
     
    //Bienvenida al usuario mostrando el cargo, nombre y apellido
    public void bienvenidaUsuario(String nombreyapellidoUsuario) {
        bienvenidaUsuario.setText("Bienvenido/a Docente " + nombreyapellidoUsuario);
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
            java.util.logging.Logger.getLogger(Docente_ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Docente_ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Docente_ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Docente_ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new Docente_ventana().setVisible(true);
            }
        });
    }

    void setVisibile(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Docente_TablaCursos;
    private javax.swing.JLabel Docente_textoSeleccionarCursoEstudiantes;
    private javax.swing.JPanel banner;
    private javax.swing.JLabel bienvenidaUsuario;
    private javax.swing.JButton botonActividades;
    private javax.swing.JButton botonCerrarSesion;
    private javax.swing.JButton botonClases;
    private javax.swing.JButton botonCursos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
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
    private javax.swing.JScrollPane tabla4;
    // End of variables declaration//GEN-END:variables
}
