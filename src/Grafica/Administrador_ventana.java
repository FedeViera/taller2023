package Grafica;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import Persistencia.Usuario_SQL;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import Entidades.Docente;
import Entidades.Conexion;
import java.lang.System.Logger;
import java.sql.SQLException;
import java.util.logging.Level;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


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
        panelPestañas = new javax.swing.JTabbedPane();
        pestañaBienvenida = new javax.swing.JPanel();
        pestaña0 = new javax.swing.JPanel();
        pestañaOpcionesCuentas = new javax.swing.JTabbedPane();
        agregar = new javax.swing.JPanel();
        agregar_cedula = new javax.swing.JLabel();
        agregar_textoCedula = new javax.swing.JTextField();
        agregar_nombre = new javax.swing.JLabel();
        agregar_textoNombre = new javax.swing.JTextField();
        agregar_apellido = new javax.swing.JLabel();
        agregar_textoApellido = new javax.swing.JTextField();
        agregar_usuario = new javax.swing.JLabel();
        agregar_textoUsuario = new javax.swing.JTextField();
        agregar_contrasenia = new javax.swing.JLabel();
        agregar_textoContrasenia = new javax.swing.JPasswordField();
        agregar_cargo = new javax.swing.JLabel();
        agregar_opcionesCargo = new javax.swing.JComboBox<>();
        agregar_botonAgregar = new javax.swing.JButton();
        verPswd = new javax.swing.JLabel();
        ocultarPswd = new javax.swing.JLabel();
        agregar_grado = new javax.swing.JLabel();
        agregar_opcionesGrado = new javax.swing.JComboBox<>();
        agregar_asignatura = new javax.swing.JLabel();
        agregar_opcionesAsignatura = new javax.swing.JComboBox<>();
        ver_modificar = new javax.swing.JPanel();
        cuentasRegistradas = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCuentas = new javax.swing.JTable();
        modificar_cedula = new javax.swing.JLabel();
        modificar_textoCedula = new javax.swing.JTextField();
        modificar_usuario = new javax.swing.JLabel();
        modificar_textoUsuario = new javax.swing.JTextField();
        modificar_contrasenia = new javax.swing.JLabel();
        modificar_textoContrasenia = new javax.swing.JPasswordField();
        modificar_opcionesCargo = new javax.swing.JComboBox<>();
        modificar_cargo = new javax.swing.JLabel();
        modificar_botonModificar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        modificar_grado = new javax.swing.JLabel();
        modificar_opcionesGrado = new javax.swing.JComboBox<>();
        modificar_asignatura = new javax.swing.JLabel();
        modificar_opcionesAsignatura = new javax.swing.JComboBox<>();
        modificar_cedula1 = new javax.swing.JLabel();
        modificar_textoBuscar = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        pestaña1 = new javax.swing.JPanel();
        pestaña2 = new javax.swing.JPanel();
        pestaña3 = new javax.swing.JPanel();

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
                    .addComponent(botonGestionActividades, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

        agregar_cedula.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        agregar_cedula.setForeground(new java.awt.Color(0, 0, 0));
        agregar_cedula.setText("Cédula");

        agregar_textoCedula.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        agregar_textoCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregar_textoCedulaActionPerformed(evt);
            }
        });

        agregar_nombre.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        agregar_nombre.setForeground(new java.awt.Color(0, 0, 0));
        agregar_nombre.setText("Nombre");

        agregar_textoNombre.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        agregar_textoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregar_textoNombreActionPerformed(evt);
            }
        });

        agregar_apellido.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        agregar_apellido.setForeground(new java.awt.Color(0, 0, 0));
        agregar_apellido.setText("Apellido");

        agregar_textoApellido.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        agregar_textoApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregar_textoApellidoActionPerformed(evt);
            }
        });

        agregar_usuario.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        agregar_usuario.setForeground(new java.awt.Color(0, 0, 0));
        agregar_usuario.setText("Usuario");

        agregar_textoUsuario.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        agregar_textoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregar_textoUsuarioActionPerformed(evt);
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

        agregar_opcionesCargo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        agregar_opcionesCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Adscripto", "Docente" }));
        agregar_opcionesCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregar_opcionesCargoActionPerformed(evt);
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

        agregar_grado.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        agregar_grado.setForeground(new java.awt.Color(0, 0, 0));
        agregar_grado.setText("Grado");

        agregar_opcionesGrado.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        agregar_opcionesGrado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7" }));

        agregar_asignatura.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        agregar_asignatura.setForeground(new java.awt.Color(0, 0, 0));
        agregar_asignatura.setText("Asignatura");

        agregar_opcionesAsignatura.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        agregar_opcionesAsignatura.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Informática", "Idioma Español", "Matemática", "Inglés", "Historia", "Geografía", "Biología", "Ciencias Físicas", "Dibujo", "Música", "Educación Física" }));
        agregar_opcionesAsignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregar_opcionesAsignaturaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout agregarLayout = new javax.swing.GroupLayout(agregar);
        agregar.setLayout(agregarLayout);
        agregarLayout.setHorizontalGroup(
            agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(agregarLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(agregar_botonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(agregarLayout.createSequentialGroup()
                        .addGroup(agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(agregar_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(agregar_contrasenia)
                            .addComponent(agregar_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(agregar_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(agregar_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(agregar_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(agregar_opcionesCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(agregarLayout.createSequentialGroup()
                                .addGroup(agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(agregar_textoContrasenia, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                                    .addComponent(agregar_textoUsuario, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(agregar_textoApellido, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(agregar_textoNombre, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(agregar_textoCedula, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGroup(agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(agregarLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ocultarPswd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(verPswd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, agregarLayout.createSequentialGroup()
                                        .addGap(71, 71, 71)
                                        .addGroup(agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(agregar_grado, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(agregar_asignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(agregar_opcionesAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(agregar_opcionesGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(0, 159, Short.MAX_VALUE))
        );
        agregarLayout.setVerticalGroup(
            agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(agregarLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(agregarLayout.createSequentialGroup()
                        .addGroup(agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(agregar_textoCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(agregar_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(agregar_grado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(agregar_opcionesGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(agregarLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(agregar_textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(agregar_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(agregar_textoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(agregar_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(agregarLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(agregar_asignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(agregar_opcionesAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(22, 22, 22)
                        .addComponent(agregar_textoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(agregar_usuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(agregar_textoContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(agregar_contrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(ocultarPswd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(verPswd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregar_opcionesCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(agregar_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(agregar_botonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        pestañaOpcionesCuentas.addTab("Agregar", agregar);

        ver_modificar.setBackground(new java.awt.Color(255, 255, 255));

        cuentasRegistradas.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        cuentasRegistradas.setForeground(new java.awt.Color(0, 0, 0));
        cuentasRegistradas.setText("Cuentas registradas:");

        tablaCuentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Cedula", "Nombre", "Apellido", "Usuario", "Contraseña", "Cargo", "Grado", "Asignatura"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
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
            tablaCuentas.getColumnModel().getColumn(4).setResizable(false);
            tablaCuentas.getColumnModel().getColumn(5).setResizable(false);
            tablaCuentas.getColumnModel().getColumn(6).setResizable(false);
            tablaCuentas.getColumnModel().getColumn(7).setResizable(false);
        }

        modificar_cedula.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        modificar_cedula.setForeground(new java.awt.Color(0, 0, 0));
        modificar_cedula.setText("Cédula");

        modificar_textoCedula.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        modificar_textoCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificar_textoCedulaActionPerformed(evt);
            }
        });

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
        modificar_contrasenia.setText("Cambiar contraseña");

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
        modificar_cargo.setText("Cambiar cargo");

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

        modificar_grado.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        modificar_grado.setForeground(new java.awt.Color(0, 0, 0));
        modificar_grado.setText("Cambiar grado");

        modificar_opcionesGrado.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        modificar_opcionesGrado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7" }));

        modificar_asignatura.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        modificar_asignatura.setForeground(new java.awt.Color(0, 0, 0));
        modificar_asignatura.setText("Cambiar asignatura");

        modificar_opcionesAsignatura.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        modificar_opcionesAsignatura.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Informática", "Idioma Español", "Matemática", "Inglés", "Historia", "Geografía", "Biología", "Ciencias Físicas", "Dibujo", "Música", "Educación Física" }));
        modificar_opcionesAsignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificar_opcionesAsignaturaActionPerformed(evt);
            }
        });

        modificar_cedula1.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        modificar_cedula1.setForeground(new java.awt.Color(0, 0, 0));
        modificar_cedula1.setText("Buscar por cédula");

        modificar_textoBuscar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        modificar_textoBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificar_textoBuscarActionPerformed(evt);
            }
        });

        botonBuscar.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ver_modificarLayout = new javax.swing.GroupLayout(ver_modificar);
        ver_modificar.setLayout(ver_modificarLayout);
        ver_modificarLayout.setHorizontalGroup(
            ver_modificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ver_modificarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(ver_modificarLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(ver_modificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ver_modificarLayout.createSequentialGroup()
                        .addComponent(cuentasRegistradas, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(ver_modificarLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(ver_modificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ver_modificarLayout.createSequentialGroup()
                                .addGroup(ver_modificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ver_modificarLayout.createSequentialGroup()
                                        .addComponent(modificar_textoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(modificar_cedula1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(59, 59, 59)
                                .addGroup(ver_modificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(modificar_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(modificar_grado)))
                            .addGroup(ver_modificarLayout.createSequentialGroup()
                                .addGroup(ver_modificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ver_modificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(ver_modificarLayout.createSequentialGroup()
                                            .addComponent(modificar_contrasenia)
                                            .addGap(4, 4, 4)
                                            .addComponent(modificar_textoContrasenia))
                                        .addGroup(ver_modificarLayout.createSequentialGroup()
                                            .addComponent(modificar_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(33, 33, 33)
                                            .addGroup(ver_modificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(modificar_textoUsuario)
                                                .addComponent(modificar_textoCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(modificar_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(61, 61, 61)
                                .addComponent(modificar_asignatura)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ver_modificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ver_modificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(modificar_opcionesGrado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(modificar_opcionesCargo, 0, 171, Short.MAX_VALUE))
                            .addGroup(ver_modificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(ver_modificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(modificar_botonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(botonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(modificar_opcionesAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        ver_modificarLayout.setVerticalGroup(
            ver_modificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ver_modificarLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(cuentasRegistradas, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(ver_modificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(ver_modificarLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(ver_modificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(modificar_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modificar_opcionesCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ver_modificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(modificar_grado)
                            .addComponent(modificar_opcionesGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ver_modificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(modificar_asignatura)
                            .addComponent(modificar_opcionesAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(modificar_botonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ver_modificarLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(modificar_cedula1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ver_modificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(modificar_textoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(ver_modificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(modificar_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modificar_textoCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ver_modificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(modificar_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modificar_textoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ver_modificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(modificar_contrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modificar_textoContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pestañaOpcionesCuentas.addTab("Ver / Modificar", ver_modificar);

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

        panelPestañas.addTab("tab2", pestaña1);

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

        panelPestañas.addTab("tab3", pestaña2);

        pestaña3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pestaña3Layout = new javax.swing.GroupLayout(pestaña3);
        pestaña3.setLayout(pestaña3Layout);
        pestaña3Layout.setHorizontalGroup(
            pestaña3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 958, Short.MAX_VALUE)
        );
        pestaña3Layout.setVerticalGroup(
            pestaña3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 544, Short.MAX_VALUE)
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
 
    private void agregar_opcionesCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregar_opcionesCargoActionPerformed
        String selectedCargo = (String) agregar_opcionesCargo.getSelectedItem();

        switch (selectedCargo) {
        case "Administrador":
            agregar_opcionesAsignatura.setEnabled(false);
            agregar_opcionesGrado.setEnabled(false);
            break;
        case "Adscripto":
            agregar_opcionesAsignatura.setEnabled(false);
            agregar_opcionesGrado.setEnabled(true);
            break;
        case "Docente":
            agregar_opcionesAsignatura.setEnabled(true);
            agregar_opcionesGrado.setEnabled(true);
            break;
        default:
            agregar_opcionesAsignatura.setEnabled(false);
            agregar_opcionesGrado.setEnabled(false); 
            break;
    }

    }//GEN-LAST:event_agregar_opcionesCargoActionPerformed
    
    private void agregar_botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregar_botonAgregarActionPerformed
       
        String cedulaStr = agregar_textoCedula.getText();  // Obtener la cédula como cadena

        // Convertir la cédula a un número entero
        try {
            Integer cedula = Integer.parseInt(cedulaStr);  
            String nombre = agregar_textoNombre.getText();
            String apellido = agregar_textoApellido.getText();
            String usuario = agregar_textoUsuario.getText();
            String contrasenia = new String(agregar_textoContrasenia.getPassword());
            String cargo = agregar_opcionesCargo.getSelectedItem().toString(); // Obtener el cargo
            String grado = agregar_opcionesGrado.getSelectedItem().toString();
            String asignatura = agregar_opcionesAsignatura.getSelectedItem().toString();

            Usuario_SQL consultasSQL = new Usuario_SQL();
            consultasSQL.agregarDato(cedula, nombre, apellido, usuario, contrasenia, cargo, grado, asignatura);

            // Borra los campos de los JTextField
            agregar_textoCedula.setText("");
            agregar_textoNombre.setText("");
            agregar_textoApellido.setText("");
            agregar_textoUsuario.setText("");
            agregar_textoContrasenia.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "La cédula debe ser un número válido.", "Cédula Inválida", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_agregar_botonAgregarActionPerformed

    private void mostrarUsuariosEnTabla() {
        Usuario_SQL consultasSQL = new Usuario_SQL();
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
                        Integer cedula = (Integer) tablaCuentas.getValueAt(filaSeleccionada, 0);
                        String usuario = tablaCuentas.getValueAt(filaSeleccionada, 3).toString(); 
                        String contrasenia = tablaCuentas.getValueAt(filaSeleccionada, 4).toString();
                        String cargo = tablaCuentas.getValueAt(filaSeleccionada, 5).toString();

                        modificar_textoUsuario.setText(usuario);
                        modificar_textoContrasenia.setText(contrasenia);
                        modificar_textoCedula.setText(cedula.toString());
                        modificar_opcionesCargo.setSelectedItem(cargo); 
                        
                        if (cargo.equals("Docente")) {
                            String grado = tablaCuentas.getValueAt(filaSeleccionada, 6).toString();
                            modificar_opcionesGrado.setSelectedItem(grado); // Actualizar grado
                            String asignatura = tablaCuentas.getValueAt(filaSeleccionada, 7).toString();
                            modificar_opcionesAsignatura.setSelectedItem(asignatura); // Actualizar asignatura 
                            /*modificar_opcionesAsignatura.setEnabled(true);
                            modificar_opcionesGrado.setEnabled(true);*/
                        } else if (cargo.equals("Adscripto")) {
                            String grado = tablaCuentas.getValueAt(filaSeleccionada, 6).toString();
                            modificar_opcionesGrado.setSelectedItem(grado); // Actualizar grado
                            modificar_opcionesAsignatura.setSelectedIndex(0); // Vaciar asignatura para adscripto
                            /*modificar_opcionesGrado.setEnabled(true);
                            modificar_opcionesAsignatura.setEnabled(false);*/
                        } else {
                            // Otro cargo (como Administrador)
                            modificar_opcionesAsignatura.setSelectedIndex(0); // Vaciar asignatura
                            modificar_opcionesGrado.setSelectedIndex(0); // Vaciar grado
                            /*modificar_opcionesAsignatura.setEnabled(false);
                            modificar_opcionesGrado.setEnabled(false);*/
                        }
                    }
                }
            });  
        
        }

    private void agregar_textoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregar_textoUsuarioActionPerformed
        
    }//GEN-LAST:event_agregar_textoUsuarioActionPerformed

    
    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        int filaSeleccionada = tablaCuentas.getSelectedRow();
    
        if (filaSeleccionada >= 0) {
            int cedula = (int) tablaCuentas.getValueAt(filaSeleccionada, 0); // Obtenemos el ID del usuario de la tabla
            String cargo = (String) tablaCuentas.getValueAt(filaSeleccionada, 5);
            Usuario_SQL consultasSQL = new Usuario_SQL();
            consultasSQL.eliminarDato(cedula, cargo); // Eliminar el usuario utilizando el ID
            mostrarUsuariosEnTabla(); // Después de eliminar, actualizar la tabla
            JOptionPane.showMessageDialog(this, "El "+cargo+" con cedula: "+cedula+" fue correctamente eliminado", "Fila no seleccionada", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una fila de la tabla para eliminar.", "Fila no seleccionada", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void pestañaOpcionesCuentasStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_pestañaOpcionesCuentasStateChanged
        mostrarUsuariosEnTabla();
        modificar_textoContrasenia.setEchoChar((char) 0);
    }//GEN-LAST:event_pestañaOpcionesCuentasStateChanged

    private void modificar_botonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificar_botonModificarActionPerformed
        String cedulaStr = modificar_textoCedula.getText();
        String nuevoGradoStr = modificar_opcionesGrado.getSelectedItem().toString();
        Integer cedula = Integer.parseInt(cedulaStr); // Convertir la cadena a Integer
        String usuario = modificar_textoUsuario.getText();
        String nuevaContrasenia = new String(modificar_textoContrasenia.getPassword());
        String nuevoCargo = modificar_opcionesCargo.getSelectedItem().toString(); // Obtiene el cargo seleccionado
        int nuevoGrado = Integer.parseInt(nuevoGradoStr);
        String nuevaAsignatura = modificar_opcionesAsignatura.getSelectedItem().toString();

        Usuario_SQL consultasSQL = new Usuario_SQL();
        consultasSQL.actualizarUsuario(cedula, nuevaContrasenia, nuevoCargo, nuevoGrado, nuevaAsignatura);
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

    private void agregar_textoApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregar_textoApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_agregar_textoApellidoActionPerformed

    private void agregar_textoNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregar_textoNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_agregar_textoNombreActionPerformed

    private void agregar_textoCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregar_textoCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_agregar_textoCedulaActionPerformed

    private void modificar_textoCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificar_textoCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modificar_textoCedulaActionPerformed

    private void agregar_opcionesAsignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregar_opcionesAsignaturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_agregar_opcionesAsignaturaActionPerformed

    private void modificar_opcionesAsignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificar_opcionesAsignaturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modificar_opcionesAsignaturaActionPerformed

    private void modificar_textoBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificar_textoBuscarActionPerformed
        
    }//GEN-LAST:event_modificar_textoBuscarActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        String busquedaCedula = modificar_textoBuscar.getText().trim();
        DefaultTableModel model = (DefaultTableModel) tablaCuentas.getModel();
        boolean encontrado = false;

        for (int row = 0; row < model.getRowCount(); row++) {
            Object cedulaValue = model.getValueAt(row, 0);
            if (cedulaValue != null && cedulaValue.toString().equalsIgnoreCase(busquedaCedula)) {
                tablaCuentas.setRowSelectionInterval(row, row);
                hacerVisible(tablaCuentas, row, 0);
                llenarCamposDesdeTabla(row);
                encontrado = true;
                break; 
            }
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No se encontró ninguna cédula coincidente.", "Búsqueda", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_botonBuscarActionPerformed
     
//HACER VISIBLE LA FILA ENCONTRADA
    private void hacerVisible(JTable table, int rowIndex, int vColIndex) {
        if (!(table.getParent() instanceof javax.swing.JViewport)) {
            return;
        }
        javax.swing.JViewport viewport = (javax.swing.JViewport) table.getParent();
        java.awt.Rectangle rect = table.getCellRect(rowIndex, vColIndex, true);
        java.awt.Point pt = viewport.getViewPosition();
        rect.setLocation(rect.x - pt.x, rect.y - pt.y);
        table.scrollRectToVisible(rect);
    }
    
    private void llenarCamposDesdeTabla(int fila) {
        Integer cedula = (Integer) tablaCuentas.getValueAt(fila, 0);
        String usuario = tablaCuentas.getValueAt(fila, 3).toString(); 
        String contrasenia = tablaCuentas.getValueAt(fila, 4).toString();
        String cargo = tablaCuentas.getValueAt(fila, 5).toString();

        modificar_textoUsuario.setText(usuario);
        modificar_textoContrasenia.setText(contrasenia);
        modificar_textoCedula.setText(cedula.toString());
        modificar_opcionesCargo.setSelectedItem(cargo); 

        if (cargo.equals("Docente")) {
            String grado = tablaCuentas.getValueAt(fila, 6).toString();
            modificar_opcionesGrado.setSelectedItem(grado); // Actualizar grado
            String asignatura = tablaCuentas.getValueAt(fila, 7).toString();
            modificar_opcionesAsignatura.setSelectedItem(asignatura); // Actualizar asignatura 
        } else if (cargo.equals("Adscripto")) {
            String grado = tablaCuentas.getValueAt(fila, 6).toString();
            modificar_opcionesGrado.setSelectedItem(grado); // Actualizar grado
            modificar_opcionesAsignatura.setSelectedIndex(0); // Vaciar asignatura para adscripto
        } else {
            modificar_opcionesAsignatura.setSelectedIndex(0); // Vaciar asignatura
            modificar_opcionesGrado.setSelectedIndex(0); // Vaciar grado
        }
    }

    
    //Bienvenida al usuario mostrando el nick de USUARIO (LUEGO TRAER EL NOMBRE VERDADERO DE BASE DE DATOS Y CAMBIARLO)
    public void bienvenidaUsuario(String nombreUsuario) {
        bienvenidaUsuario.setText("Bienvenido/a Administrador/a " + nombreUsuario);
        /*String nombreApellido = obtenerNombreApellido(nombreUsuario);
        if (nombreApellido != null) {
            bienvenidaUsuario.setText("Bienvenido/a " + nombreApellido);
        } else {
            bienvenidaUsuario.setText("Bienvenido/a " + nombreUsuario);
        }*/
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
    private javax.swing.JPanel agregar;
    private javax.swing.JLabel agregar_apellido;
    private javax.swing.JLabel agregar_asignatura;
    private javax.swing.JButton agregar_botonAgregar;
    private javax.swing.JLabel agregar_cargo;
    private javax.swing.JLabel agregar_cedula;
    private javax.swing.JLabel agregar_contrasenia;
    private javax.swing.JLabel agregar_grado;
    private javax.swing.JLabel agregar_nombre;
    private javax.swing.JComboBox<String> agregar_opcionesAsignatura;
    private javax.swing.JComboBox<String> agregar_opcionesCargo;
    private javax.swing.JComboBox<String> agregar_opcionesGrado;
    private javax.swing.JTextField agregar_textoApellido;
    private javax.swing.JTextField agregar_textoCedula;
    private javax.swing.JPasswordField agregar_textoContrasenia;
    private javax.swing.JTextField agregar_textoNombre;
    private javax.swing.JTextField agregar_textoUsuario;
    private javax.swing.JLabel agregar_usuario;
    private javax.swing.JPanel banner;
    private javax.swing.JLabel bienvenidaUsuario;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonCerrarSesion;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonGestionActividades;
    private javax.swing.JButton botonGestionCuentas;
    private javax.swing.JButton botonGestionCursos;
    private javax.swing.JLabel cuentasRegistradas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logoSDFA;
    private javax.swing.JLabel modificar_asignatura;
    private javax.swing.JButton modificar_botonModificar;
    private javax.swing.JLabel modificar_cargo;
    private javax.swing.JLabel modificar_cedula;
    private javax.swing.JLabel modificar_cedula1;
    private javax.swing.JLabel modificar_contrasenia;
    private javax.swing.JLabel modificar_grado;
    private javax.swing.JComboBox<String> modificar_opcionesAsignatura;
    private javax.swing.JComboBox<String> modificar_opcionesCargo;
    private javax.swing.JComboBox<String> modificar_opcionesGrado;
    private javax.swing.JTextField modificar_textoBuscar;
    private javax.swing.JTextField modificar_textoCedula;
    private javax.swing.JPasswordField modificar_textoContrasenia;
    private javax.swing.JTextField modificar_textoUsuario;
    private javax.swing.JLabel modificar_usuario;
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
    private javax.swing.JPanel ver_modificar;
    // End of variables declaration//GEN-END:variables
}
