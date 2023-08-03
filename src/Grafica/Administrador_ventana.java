/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Grafica;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import Persistencia.ConsultasSQL;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import Entidades.Docente;
import Entidades.Conexion;
import java.lang.System.Logger;
import java.sql.SQLException;
import java.util.logging.Level;


public class Administrador_ventana extends javax.swing.JFrame 
{
       
    Conexion con=new Conexion();
    Connection cn = con.conectarMySQL();
           
    public Administrador_ventana() {
        initComponents();
        this.setTitle("SDFA - Panel Administrador"); //Titulo de la ventana
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/logoPNG.png")).getImage()); //Logo de la ventana
        verPswd.setVisible(false);
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
        botonGestionCuentas = new javax.swing.JButton();
        botonGestionCursos = new javax.swing.JButton();
        botonCerrarSesion = new javax.swing.JButton();
        botonGestionActividades = new javax.swing.JButton();
        botonGestionEvaluaciones = new javax.swing.JButton();
        panelPestañas = new javax.swing.JTabbedPane();
        pestañaBienvenida = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        pestaña0 = new javax.swing.JPanel();
        pestañaOpcionesCuentas = new javax.swing.JTabbedPane();
        agregar = new javax.swing.JPanel();
        agregar_correo = new javax.swing.JLabel();
        agregar_textoCorreo = new javax.swing.JTextField();
        agregar_contrasenia = new javax.swing.JLabel();
        agregar_textoContrasenia = new javax.swing.JPasswordField();
        agregar_cargo = new javax.swing.JLabel();
        agegar_opcionesCargo = new javax.swing.JComboBox<>();
        agregar_botonAgregar = new javax.swing.JButton();
        verPswd = new javax.swing.JLabel();
        ocultarPswd = new javax.swing.JLabel();
        observar = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCuentas = new javax.swing.JTable();
        modificar_usuario = new javax.swing.JLabel();
        modificar_textoUsuario = new javax.swing.JTextField();
        modificar_contrasenia = new javax.swing.JLabel();
        modificar_textoContrasenia = new javax.swing.JPasswordField();
        modificar_opcionesCargo = new javax.swing.JComboBox<>();
        modificar_cargo = new javax.swing.JLabel();
        modificar_botonModificar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        pestaña1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        pestaña2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        pestaña3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panelAdministrador.setBackground(new java.awt.Color(255, 255, 255));
        panelAdministrador.setMinimumSize(new java.awt.Dimension(1030, 670));
        panelAdministrador.setPreferredSize(new java.awt.Dimension(1030, 670));
        panelAdministrador.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bienvenidaUsuario.setFont(new java.awt.Font("Gadugi", 3, 18)); // NOI18N
        panelAdministrador.add(bienvenidaUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 470, 40));

        banner.setBackground(new java.awt.Color(28, 100, 208));

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

        botonGestionCuentas.setBackground(new java.awt.Color(52, 80, 86));
        botonGestionCuentas.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        botonGestionCuentas.setForeground(new java.awt.Color(204, 204, 204));
        botonGestionCuentas.setText("    Gestión de Cuentas");
        botonGestionCuentas.setToolTipText("");
        botonGestionCuentas.setBorder(null);
        botonGestionCuentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonGestionCuentas.setFocusPainted(false);
        botonGestionCuentas.setFocusable(false);
        botonGestionCuentas.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        botonGestionCuentas.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        botonGestionCuentas.setIconTextGap(10);
        botonGestionCuentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonGestionCuentasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonGestionCuentasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonGestionCuentasMouseExited(evt);
            }
        });
        botonGestionCuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGestionCuentasActionPerformed(evt);
            }
        });
        botonGestionCuentas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botonGestionCuentasKeyPressed(evt);
            }
        });

        botonGestionCursos.setBackground(new java.awt.Color(52, 80, 86));
        botonGestionCursos.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        botonGestionCursos.setForeground(new java.awt.Color(204, 204, 204));
        botonGestionCursos.setText("    Gestión de Cursos");
        botonGestionCursos.setBorder(null);
        botonGestionCursos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonGestionCursos.setFocusPainted(false);
        botonGestionCursos.setFocusable(false);
        botonGestionCursos.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        botonGestionCursos.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        botonGestionCursos.setIconTextGap(10);
        botonGestionCursos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonGestionCursosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonGestionCursosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonGestionCursosMouseExited(evt);
            }
        });
        botonGestionCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGestionCursosActionPerformed(evt);
            }
        });
        botonGestionCursos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botonGestionCursosKeyPressed(evt);
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

        botonGestionActividades.setBackground(new java.awt.Color(52, 80, 86));
        botonGestionActividades.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        botonGestionActividades.setForeground(new java.awt.Color(204, 204, 204));
        botonGestionActividades.setText("    Gestión de Actividades");
        botonGestionActividades.setBorder(null);
        botonGestionActividades.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonGestionActividades.setFocusPainted(false);
        botonGestionActividades.setFocusable(false);
        botonGestionActividades.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        botonGestionActividades.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        botonGestionActividades.setIconTextGap(10);
        botonGestionActividades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonGestionActividadesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonGestionActividadesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonGestionActividadesMouseExited(evt);
            }
        });
        botonGestionActividades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGestionActividadesActionPerformed(evt);
            }
        });
        botonGestionActividades.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botonGestionActividadesKeyPressed(evt);
            }
        });

        botonGestionEvaluaciones.setBackground(new java.awt.Color(52, 80, 86));
        botonGestionEvaluaciones.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        botonGestionEvaluaciones.setForeground(new java.awt.Color(204, 204, 204));
        botonGestionEvaluaciones.setText("    Gestión de Evaluaciones");
        botonGestionEvaluaciones.setBorder(null);
        botonGestionEvaluaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonGestionEvaluaciones.setFocusPainted(false);
        botonGestionEvaluaciones.setFocusable(false);
        botonGestionEvaluaciones.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        botonGestionEvaluaciones.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        botonGestionEvaluaciones.setIconTextGap(10);
        botonGestionEvaluaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonGestionEvaluacionesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonGestionEvaluacionesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonGestionEvaluacionesMouseExited(evt);
            }
        });
        botonGestionEvaluaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGestionEvaluacionesActionPerformed(evt);
            }
        });
        botonGestionEvaluaciones.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botonGestionEvaluacionesKeyPressed(evt);
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
                    .addComponent(botonGestionCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOpcionesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonGestionCursos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonGestionActividades, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonGestionEvaluaciones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        panelOpcionesLayout.setVerticalGroup(
            panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOpcionesLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(logoSDFA, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonGestionCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(botonGestionCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(botonGestionActividades, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(botonGestionEvaluaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(24, 24, 24)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 910, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        pestañaBienvenidaLayout.setVerticalGroup(
            pestañaBienvenidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pestañaBienvenidaLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        panelPestañas.addTab("tab5", pestañaBienvenida);

        pestaña0.setBackground(new java.awt.Color(38, 56, 63));
        pestaña0.setToolTipText("");

        pestañaOpcionesCuentas.setBackground(new java.awt.Color(255, 255, 255));
        pestañaOpcionesCuentas.setForeground(new java.awt.Color(0, 0, 0));
        pestañaOpcionesCuentas.setToolTipText("");
        pestañaOpcionesCuentas.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        pestañaOpcionesCuentas.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                pestañaOpcionesCuentasStateChanged(evt);
            }
        });

        agregar.setBackground(new java.awt.Color(255, 255, 255));

        agregar_correo.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        agregar_correo.setForeground(new java.awt.Color(0, 0, 0));
        agregar_correo.setText("Correo");

        agregar_textoCorreo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        agregar_textoCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregar_textoCorreoActionPerformed(evt);
            }
        });

        agregar_contrasenia.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        agregar_contrasenia.setForeground(new java.awt.Color(0, 0, 0));
        agregar_contrasenia.setText("Contraseña");

        agregar_textoContrasenia.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        agregar_textoContrasenia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregar_textoContraseniaActionPerformed(evt);
            }
        });

        agregar_cargo.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        agregar_cargo.setForeground(new java.awt.Color(0, 0, 0));
        agregar_cargo.setText("Cargo");

        agegar_opcionesCargo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        agegar_opcionesCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Adscripto", "Docente" }));
        agegar_opcionesCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agegar_opcionesCargoActionPerformed(evt);
            }
        });

        agregar_botonAgregar.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        agregar_botonAgregar.setText("Agregar");
        agregar_botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregar_botonAgregarActionPerformed(evt);
            }
        });

        verPswd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonMostrar.png"))); // NOI18N
        verPswd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                verPswdMouseClicked(evt);
            }
        });

        ocultarPswd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonOcultar.png"))); // NOI18N
        ocultarPswd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ocultarPswdMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout agregarLayout = new javax.swing.GroupLayout(agregar);
        agregar.setLayout(agregarLayout);
        agregarLayout.setHorizontalGroup(
            agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(agregarLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(agregarLayout.createSequentialGroup()
                        .addComponent(agregar_correo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(agregar_textoCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(agregar_botonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(agregarLayout.createSequentialGroup()
                        .addComponent(agregar_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(agegar_opcionesCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(agregarLayout.createSequentialGroup()
                        .addComponent(agregar_contrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(agregar_textoContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ocultarPswd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(verPswd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(368, Short.MAX_VALUE))
        );
        agregarLayout.setVerticalGroup(
            agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(agregarLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregar_correo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(agregar_textoCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(agregar_contrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(agregar_textoContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(ocultarPswd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(verPswd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregar_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(agegar_opcionesCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(agregar_botonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(207, Short.MAX_VALUE))
        );

        pestañaOpcionesCuentas.addTab("Agregar", agregar);

        observar.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Cuentas registradas:");

        tablaCuentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Cargo", "Usuario", "Contraseña"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaCuentas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaCuentas);
        if (tablaCuentas.getColumnModel().getColumnCount() > 0) {
            tablaCuentas.getColumnModel().getColumn(0).setResizable(false);
            tablaCuentas.getColumnModel().getColumn(1).setResizable(false);
            tablaCuentas.getColumnModel().getColumn(2).setResizable(false);
            tablaCuentas.getColumnModel().getColumn(3).setResizable(false);
        }

        modificar_usuario.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        modificar_usuario.setForeground(new java.awt.Color(0, 0, 0));
        modificar_usuario.setText("Usuario");

        modificar_textoUsuario.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        modificar_textoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificar_textoUsuarioActionPerformed(evt);
            }
        });

        modificar_contrasenia.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        modificar_contrasenia.setForeground(new java.awt.Color(0, 0, 0));
        modificar_contrasenia.setText("Nueva contraseña");

        modificar_textoContrasenia.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        modificar_opcionesCargo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        modificar_opcionesCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Adscripto", "Docente" }));
        modificar_opcionesCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificar_opcionesCargoActionPerformed(evt);
            }
        });

        modificar_cargo.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        modificar_cargo.setForeground(new java.awt.Color(0, 0, 0));
        modificar_cargo.setText("Seleccione el Cargo");

        modificar_botonModificar.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        modificar_botonModificar.setText("Modificar");
        modificar_botonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificar_botonModificarActionPerformed(evt);
            }
        });

        botonEliminar.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        botonEliminar.setText("Eliminar");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout observarLayout = new javax.swing.GroupLayout(observar);
        observar.setLayout(observarLayout);
        observarLayout.setHorizontalGroup(
            observarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(observarLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(observarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(observarLayout.createSequentialGroup()
                        .addGroup(observarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modificar_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(observarLayout.createSequentialGroup()
                        .addGroup(observarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modificar_botonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(observarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(modificar_textoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(observarLayout.createSequentialGroup()
                                    .addComponent(modificar_contrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(modificar_textoContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(observarLayout.createSequentialGroup()
                                .addComponent(modificar_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(modificar_opcionesCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 352, Short.MAX_VALUE))))
            .addGroup(observarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        observarLayout.setVerticalGroup(
            observarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(observarLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(observarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modificar_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modificar_textoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(observarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modificar_contrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modificar_textoContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(observarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modificar_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modificar_opcionesCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(modificar_botonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pestañaOpcionesCuentas.addTab("Ver Usuarios", observar);

        javax.swing.GroupLayout pestaña0Layout = new javax.swing.GroupLayout(pestaña0);
        pestaña0.setLayout(pestaña0Layout);
        pestaña0Layout.setHorizontalGroup(
            pestaña0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pestaña0Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pestañaOpcionesCuentas))
        );
        pestaña0Layout.setVerticalGroup(
            pestaña0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pestaña0Layout.createSequentialGroup()
                .addGap(0, 14, Short.MAX_VALUE)
                .addComponent(pestañaOpcionesCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelPestañas.addTab("tab1", pestaña0);

        pestaña1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Dialog", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/img/descarga (1).jpeg"))); // NOI18N
        jLabel2.setText("PANEL GESTION DE CURSOS");

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
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/img/descarga_1.jpeg"))); // NOI18N
        jLabel3.setText("PANEL GESTION DE ACTIVIDADES");

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

        pestaña3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Dialog", 3, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/img/descarga.jpeg"))); // NOI18N
        jLabel4.setText("PANEL GESTION DE EVALUACIONES");

        javax.swing.GroupLayout pestaña3Layout = new javax.swing.GroupLayout(pestaña3);
        pestaña3.setLayout(pestaña3Layout);
        pestaña3Layout.setHorizontalGroup(
            pestaña3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pestaña3Layout.createSequentialGroup()
                .addContainerGap(176, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        pestaña3Layout.setVerticalGroup(
            pestaña3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pestaña3Layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(211, Short.MAX_VALUE))
        );

        panelPestañas.addTab("tab4", pestaña3);

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

    private void botonGestionCuentasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botonGestionCuentasKeyPressed

    }//GEN-LAST:event_botonGestionCuentasKeyPressed

    private void botonGestionCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGestionCuentasActionPerformed

    }//GEN-LAST:event_botonGestionCuentasActionPerformed

    private void botonGestionCuentasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGestionCuentasMouseExited
        //botonGenerarCurso.setBackground(new Color(45,196,181));
    }//GEN-LAST:event_botonGestionCuentasMouseExited

    private void botonGestionCuentasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGestionCuentasMouseEntered
        //botonGenerarCurso.setBackground(new Color(55,208,193));
    }//GEN-LAST:event_botonGestionCuentasMouseEntered

    //CAMBIAR DE COLOR BOTONES AL CLICKEARLOS
    private void cambiarEstadoBoton(JButton button, boolean isSelected) {
        if (isSelected) {
            button.setBackground(new Color(255, 255, 255));
            button.setForeground(new Color(0, 0, 0));
        } else {
            button.setBackground(new Color(52, 80, 86));
            button.setForeground(new Color(255, 255, 255));
        }
    }
    
    //Cambio de colores al hacer click Cambia a Blanco y muestra otra pestaña del Tabbed Panel
    private void botonGestionCuentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGestionCuentasMouseClicked
        panelPestañas.setSelectedIndex(1);
        cambiarEstadoBoton(botonGestionEvaluaciones, false);
        cambiarEstadoBoton(botonGestionCursos, false);
        cambiarEstadoBoton(botonGestionActividades, false);
        cambiarEstadoBoton(botonGestionCuentas, true);
    }//GEN-LAST:event_botonGestionCuentasMouseClicked

    private void botonGestionCursosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botonGestionCursosKeyPressed
  
    }//GEN-LAST:event_botonGestionCursosKeyPressed

    private void botonGestionCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGestionCursosActionPerformed
 
    }//GEN-LAST:event_botonGestionCursosActionPerformed

    private void botonGestionCursosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGestionCursosMouseExited
   
    }//GEN-LAST:event_botonGestionCursosMouseExited

    private void botonGestionCursosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGestionCursosMouseEntered

    }//GEN-LAST:event_botonGestionCursosMouseEntered

    //Cambio de colores al hacer click Cambia a Blanco y muestra otra pestaña del Tabbed Panel
    private void botonGestionCursosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGestionCursosMouseClicked
        panelPestañas.setSelectedIndex(2);
        cambiarEstadoBoton(botonGestionEvaluaciones, false);
        cambiarEstadoBoton(botonGestionCursos, true);
        cambiarEstadoBoton(botonGestionActividades, false);
        cambiarEstadoBoton(botonGestionCuentas, false);
    }//GEN-LAST:event_botonGestionCursosMouseClicked

    private void botonCerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCerrarSesionMouseClicked
    
    }//GEN-LAST:event_botonCerrarSesionMouseClicked

    private void botonCerrarSesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCerrarSesionMouseEntered
     
    }//GEN-LAST:event_botonCerrarSesionMouseEntered

    private void botonCerrarSesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCerrarSesionMouseExited
       
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
      
    }//GEN-LAST:event_botonCerrarSesionKeyPressed

    private void botonGestionActividadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGestionActividadesMouseClicked
        panelPestañas.setSelectedIndex(3);
        panelPestañas.setSelectedIndex(3);
        cambiarEstadoBoton(botonGestionEvaluaciones, false);
        cambiarEstadoBoton(botonGestionCursos, false);
        cambiarEstadoBoton(botonGestionActividades, true);
        cambiarEstadoBoton(botonGestionCuentas, false);
    }//GEN-LAST:event_botonGestionActividadesMouseClicked

    private void botonGestionActividadesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGestionActividadesMouseEntered
     
    }//GEN-LAST:event_botonGestionActividadesMouseEntered

    private void botonGestionActividadesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGestionActividadesMouseExited
    
    }//GEN-LAST:event_botonGestionActividadesMouseExited

    private void botonGestionActividadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGestionActividadesActionPerformed
      
    }//GEN-LAST:event_botonGestionActividadesActionPerformed

    private void botonGestionActividadesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botonGestionActividadesKeyPressed
     
    }//GEN-LAST:event_botonGestionActividadesKeyPressed

    private void botonGestionEvaluacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGestionEvaluacionesMouseClicked
        panelPestañas.setSelectedIndex(4);
        cambiarEstadoBoton(botonGestionEvaluaciones, true);
        cambiarEstadoBoton(botonGestionCursos, false);
        cambiarEstadoBoton(botonGestionActividades, false);
        cambiarEstadoBoton(botonGestionCuentas, false);
    }//GEN-LAST:event_botonGestionEvaluacionesMouseClicked

    
    
    private void botonGestionEvaluacionesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGestionEvaluacionesMouseEntered
       
    }//GEN-LAST:event_botonGestionEvaluacionesMouseEntered

    private void botonGestionEvaluacionesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGestionEvaluacionesMouseExited
     
    }//GEN-LAST:event_botonGestionEvaluacionesMouseExited

    private void botonGestionEvaluacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGestionEvaluacionesActionPerformed
     
    }//GEN-LAST:event_botonGestionEvaluacionesActionPerformed

    private void botonGestionEvaluacionesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botonGestionEvaluacionesKeyPressed
     
    }//GEN-LAST:event_botonGestionEvaluacionesKeyPressed

    private void agegar_opcionesCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agegar_opcionesCargoActionPerformed
      
    }//GEN-LAST:event_agegar_opcionesCargoActionPerformed

    private void agregar_botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregar_botonAgregarActionPerformed
        String usuario = agregar_textoCorreo.getText();
        String contrasenia = new String(agregar_textoContrasenia.getPassword());
        String cargo = agegar_opcionesCargo.getSelectedItem().toString(); // Obtiene el cargo seleccionado
        
        // Lógica para validar los datos, si es necesario
        ConsultasSQL consultasSQL = new ConsultasSQL();
        consultasSQL.agregarDato(usuario, contrasenia, cargo);

        //mostrarUsuariosEnTabla();
    }//GEN-LAST:event_agregar_botonAgregarActionPerformed

    private void mostrarUsuariosEnTabla() {
        ConsultasSQL consultasSQL = new ConsultasSQL();
        Object[][] datos = consultasSQL.obtenerUsuarios();

        // Llenar la tabla con los datos obtenidos
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tablaCuentas.getModel();
        model.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos
        for (Object[] fila : datos) {
            model.addRow(fila);
        }

        // Agregar el MouseListener a la tabla
        tablaCuentas.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int filaSeleccionada = tablaCuentas.getSelectedRow();
                if (filaSeleccionada >= 0) {
                    String usuario = tablaCuentas.getValueAt(filaSeleccionada, 2).toString(); 
                    String contrasenia = tablaCuentas.getValueAt(filaSeleccionada, 3).toString();

                    modificar_textoUsuario.setText(usuario);
                    modificar_textoContrasenia.setText(contrasenia);
                }
            }
        });  
        
    }

    private void agregar_textoCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregar_textoCorreoActionPerformed
        
    }//GEN-LAST:event_agregar_textoCorreoActionPerformed

    
    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        int filaSeleccionada = tablaCuentas.getSelectedRow();
    
        if (filaSeleccionada >= 0) {
            int idUsuario = (int) tablaCuentas.getValueAt(filaSeleccionada, 0); // Obtenemos el ID del usuario de la tabla
            ConsultasSQL consultasSQL = new ConsultasSQL();
            consultasSQL.eliminarDato(idUsuario); // Eliminar el usuario utilizando el ID
            mostrarUsuariosEnTabla(); // Después de eliminar, actualizar la tabla
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una fila de la tabla para eliminar.", "Fila no seleccionada", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void pestañaOpcionesCuentasStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_pestañaOpcionesCuentasStateChanged
        mostrarUsuariosEnTabla();
        modificar_textoContrasenia.setEchoChar((char) 0);
    }//GEN-LAST:event_pestañaOpcionesCuentasStateChanged

    private void modificar_botonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificar_botonModificarActionPerformed
        String usuario = modificar_textoUsuario.getText();
        String nuevaContrasenia = new String(modificar_textoContrasenia.getPassword());
        String nuevoCargo = modificar_opcionesCargo.getSelectedItem().toString(); // Obtiene el cargo seleccionado

        ConsultasSQL consultasSQL = new ConsultasSQL();
        consultasSQL.actualizarUsuario(usuario, nuevaContrasenia, nuevoCargo);
        mostrarUsuariosEnTabla();
    }//GEN-LAST:event_modificar_botonModificarActionPerformed

    private void modificar_opcionesCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificar_opcionesCargoActionPerformed

    }//GEN-LAST:event_modificar_opcionesCargoActionPerformed

    private void modificar_textoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificar_textoUsuarioActionPerformed

    }//GEN-LAST:event_modificar_textoUsuarioActionPerformed
   
    private char echoCharOriginal = '\u2022';
    private boolean contraseniaVisible = false;
    
    private void verPswdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verPswdMouseClicked
        ocultarPswd.setVisible(true);
        verPswd.setVisible(false);
        if (contraseniaVisible) {
            agregar_textoContrasenia.setEchoChar((char) 0); // Mostrar el texto de la contraseña
            contraseniaVisible = false;
        }
    }//GEN-LAST:event_verPswdMouseClicked

    private void ocultarPswdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ocultarPswdMouseClicked
        ocultarPswd.setVisible(false);
        verPswd.setVisible(true);
        if (!contraseniaVisible) {
            agregar_textoContrasenia.setEchoChar(echoCharOriginal); // Ocultar el texto de la contraseña
            contraseniaVisible = true;
        }
    }//GEN-LAST:event_ocultarPswdMouseClicked

    private void agregar_textoContraseniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregar_textoContraseniaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_agregar_textoContraseniaActionPerformed
     
    //Bienvenida al usuario mostrando el nick de USUARIO (LUEGO TRAER EL NOMBRE VERDADERO DE BASE DE DATOS Y CAMBIARLO)
    public void bienvenidaUsuario(String nombreUsuario) {
    bienvenidaUsuario.setText("Bienvenido/a Administrador/a " + nombreUsuario);
    }

 
     public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Administrador_ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Administrador_ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Administrador_ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Administrador_ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Administrador_ventana().setVisible(true);
            }
        });
    }

    void setVisibile(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> agegar_opcionesCargo;
    private javax.swing.JPanel agregar;
    private javax.swing.JButton agregar_botonAgregar;
    private javax.swing.JLabel agregar_cargo;
    private javax.swing.JLabel agregar_contrasenia;
    private javax.swing.JLabel agregar_correo;
    private javax.swing.JPasswordField agregar_textoContrasenia;
    private javax.swing.JTextField agregar_textoCorreo;
    private javax.swing.JPanel banner;
    private javax.swing.JLabel bienvenidaUsuario;
    private javax.swing.JButton botonCerrarSesion;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonGestionActividades;
    private javax.swing.JButton botonGestionCuentas;
    private javax.swing.JButton botonGestionCursos;
    private javax.swing.JButton botonGestionEvaluaciones;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logoSDFA;
    private javax.swing.JButton modificar_botonModificar;
    private javax.swing.JLabel modificar_cargo;
    private javax.swing.JLabel modificar_contrasenia;
    private javax.swing.JComboBox<String> modificar_opcionesCargo;
    private javax.swing.JPasswordField modificar_textoContrasenia;
    private javax.swing.JTextField modificar_textoUsuario;
    private javax.swing.JLabel modificar_usuario;
    private javax.swing.JPanel observar;
    private javax.swing.JLabel ocultarPswd;
    private javax.swing.JPanel panelAdministrador;
    private javax.swing.JPanel panelOpciones;
    private javax.swing.JTabbedPane panelPestañas;
    private javax.swing.JPanel pestaña0;
    private javax.swing.JPanel pestaña1;
    private javax.swing.JPanel pestaña2;
    private javax.swing.JPanel pestaña3;
    private javax.swing.JPanel pestañaBienvenida;
    private javax.swing.JTabbedPane pestañaOpcionesCuentas;
    private javax.swing.JSeparator separador;
    private javax.swing.JTable tablaCuentas;
    private javax.swing.JLabel verPswd;
    // End of variables declaration//GEN-END:variables
}
