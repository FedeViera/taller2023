package Grafica;

import Entidades.Administrador;
import Entidades.Adscripto;
import Persistencia.Persistencia_SQL;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import Entidades.Docente;
import Entidades.Estudiante;
import Logica.GestorAdministradores;
import Logica.GestorAdscriptos;
import Logica.GestorDocentes;
import Logica.GestorUsuarios;
import Logica.GestorEstudiantes;
/*
import java.lang.System.Logger;
import java.util.logging.Level;
*/

//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;




public class Administrador_ventana extends javax.swing.JFrame 
{
   
    private DefaultTableModel model;
    
       
    
    public Administrador_ventana() {
        initComponents();
        this.setTitle("SDFA - Panel Administrador"); //Titulo de la ventana
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/logoPNG.png")).getImage()); //Logo de la ventana
        Cuenta_verPswd.setVisible(false);
        
        // DocumentListener - Validar el campo en tiempo real
        Cuenta_agregar_textoCedula.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                Alertas.checkCedula(Cuenta_agregar_textoCedula, Cuenta_mensajeAlertaCedula);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                Alertas.checkCedula(Cuenta_agregar_textoCedula, Cuenta_mensajeAlertaCedula);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // No es relevante para JTextField de texto simple
            }
        });
        
        Cuenta_agregar_textoNombre.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                Alertas.checkNombre(Cuenta_agregar_textoNombre, Cuenta_mensajeAlertaNombre);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                Alertas.checkNombre(Cuenta_agregar_textoNombre, Cuenta_mensajeAlertaNombre);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // No es relevante para JTextField de texto simple
            }
        });
        
        Cuenta_agregar_textoApellido.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                Alertas.checkApellido(Cuenta_agregar_textoApellido, Cuenta_mensajeAlertaApellido);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                Alertas.checkApellido(Cuenta_agregar_textoApellido, Cuenta_mensajeAlertaApellido);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // No es relevante para JTextField de texto simple
            }
        });
        
        
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
        opcionesCuentas = new javax.swing.JTabbedPane();
        crearCuenta = new javax.swing.JPanel();
        Cuenta_agregar_cedula = new javax.swing.JLabel();
        Cuenta_agregar_textoCedula = new javax.swing.JTextField();
        Cuenta_agregar_nombre = new javax.swing.JLabel();
        Cuenta_agregar_textoNombre = new javax.swing.JTextField();
        Cuenta_agregar_apellido = new javax.swing.JLabel();
        Cuenta_agregar_textoApellido = new javax.swing.JTextField();
        Cuenta_agregar_usuario = new javax.swing.JLabel();
        Cuenta_agregar_textoUsuario = new javax.swing.JTextField();
        Cuenta_agregar_contrasenia = new javax.swing.JLabel();
        Cuenta_agregar_textoContrasenia = new javax.swing.JPasswordField();
        Cuenta_agregar_cargo = new javax.swing.JLabel();
        Cuenta_agregar_opcionesCargo = new javax.swing.JComboBox<>();
        Cuenta_agregar_botonAgregar = new javax.swing.JButton();
        Cuenta_verPswd = new javax.swing.JLabel();
        Cuenta_ocultarPswd = new javax.swing.JLabel();
        Cuenta_agregar_grado = new javax.swing.JLabel();
        Cuenta_agregar_opcionesGrado = new javax.swing.JComboBox<>();
        Cuenta_agregar_asignatura = new javax.swing.JLabel();
        Cuenta_agregar_opcionesAsignatura = new javax.swing.JComboBox<>();
        Cuenta_mensajeAlertaCedula = new javax.swing.JLabel();
        Cuenta_mensajeAlertaNombre = new javax.swing.JLabel();
        Cuenta_mensajeAlertaApellido = new javax.swing.JLabel();
        modificarCuenta = new javax.swing.JPanel();
        Cuenta_cuentasRegistradas = new javax.swing.JLabel();
        Cuenta_modificar_cedula = new javax.swing.JLabel();
        Cuenta_modificar_textoCedula = new javax.swing.JTextField();
        Cuenta_modificar_usuario = new javax.swing.JLabel();
        Cuenta_modificar_textoUsuario = new javax.swing.JTextField();
        Cuenta_modificar_contrasenia = new javax.swing.JLabel();
        Cuenta_modificar_textoContrasenia = new javax.swing.JPasswordField();
        Cuenta_modificar_opcionesCargo = new javax.swing.JComboBox<>();
        Cuenta_modificar_cargo = new javax.swing.JLabel();
        Cuenta_modificar_botonModificar = new javax.swing.JButton();
        Cuenta_botonEliminar = new javax.swing.JButton();
        Cuenta_modificar_grado = new javax.swing.JLabel();
        Cuenta_modificar_opcionesGrado = new javax.swing.JComboBox<>();
        Cuenta_modificar_asignatura = new javax.swing.JLabel();
        Cuenta_modificar_opcionesAsignatura = new javax.swing.JComboBox<>();
        Cuenta_modificar_cedula1 = new javax.swing.JLabel();
        Cuenta_modificar_textoBuscar = new javax.swing.JTextField();
        Cuenta_botonBuscar = new javax.swing.JButton();
        Cuenta_tablaUsuarios = new javax.swing.JScrollPane();
        Cuenta_tablaUsuario = new javax.swing.JTable();
        pestaña1 = new javax.swing.JPanel();
        opcionesCursos = new javax.swing.JTabbedPane();
        agregarCurso = new javax.swing.JPanel();
        Curso_agregar_clase = new javax.swing.JLabel();
        Curso_agregar_opcionesClase = new javax.swing.JComboBox<>();
        Curso_agregar_grupo = new javax.swing.JLabel();
        Curso_agregar_opcionesGrupo = new javax.swing.JComboBox<>();
        Curso_agregar_asignatura = new javax.swing.JLabel();
        Curso_agregar_opcionesAsignatura = new javax.swing.JComboBox<>();
        Curso_agregar_botonAgregar = new javax.swing.JButton();
        Curso_agregar_docente = new javax.swing.JLabel();
        Curso_tablaDocentes = new javax.swing.JScrollPane();
        tablaDocente = new javax.swing.JTable();
        Curso_agregar_docente1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        Curso_tablaEstudiantes = new javax.swing.JScrollPane();
        tablaEstudiante = new javax.swing.JTable();
        Curso_agregar_estudiante = new javax.swing.JLabel();
        modificarCurso = new javax.swing.JPanel();
        cuentasRegistradas1 = new javax.swing.JLabel();
        modificar_cedula2 = new javax.swing.JLabel();
        modificar_textoCedula1 = new javax.swing.JTextField();
        modificar_usuario1 = new javax.swing.JLabel();
        modificar_textoUsuario1 = new javax.swing.JTextField();
        modificar_contrasenia1 = new javax.swing.JLabel();
        modificar_textoContrasenia1 = new javax.swing.JPasswordField();
        modificar_opcionesCargo1 = new javax.swing.JComboBox<>();
        modificar_cargo1 = new javax.swing.JLabel();
        modificar_botonModificar1 = new javax.swing.JButton();
        botonEliminar1 = new javax.swing.JButton();
        modificar_grado1 = new javax.swing.JLabel();
        modificar_opcionesGrado1 = new javax.swing.JComboBox<>();
        modificar_asignatura1 = new javax.swing.JLabel();
        modificar_opcionesAsignatura1 = new javax.swing.JComboBox<>();
        modificar_cedula3 = new javax.swing.JLabel();
        modificar_textoBuscar1 = new javax.swing.JTextField();
        botonBuscar1 = new javax.swing.JButton();
        tablaUsuarios1 = new javax.swing.JScrollPane();
        tablaUsuario1 = new javax.swing.JTable();
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

        pestaña0.setBackground(new java.awt.Color(52, 80, 86));
        pestaña0.setToolTipText("");

        opcionesCuentas.setBackground(new java.awt.Color(255, 255, 255));
        opcionesCuentas.setForeground(new java.awt.Color(0, 0, 0));
        opcionesCuentas.setToolTipText("");
        opcionesCuentas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        opcionesCuentas.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        opcionesCuentas.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                opcionesCuentasStateChanged(evt);
            }
        });

        crearCuenta.setBackground(new java.awt.Color(255, 255, 255));

        Cuenta_agregar_cedula.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Cuenta_agregar_cedula.setForeground(new java.awt.Color(0, 0, 0));
        Cuenta_agregar_cedula.setText("Cédula");

        Cuenta_agregar_textoCedula.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Cuenta_agregar_textoCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cuenta_agregar_textoCedulaActionPerformed(evt);
            }
        });

        Cuenta_agregar_nombre.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Cuenta_agregar_nombre.setForeground(new java.awt.Color(0, 0, 0));
        Cuenta_agregar_nombre.setText("Nombre");

        Cuenta_agregar_textoNombre.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Cuenta_agregar_textoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cuenta_agregar_textoNombreActionPerformed(evt);
            }
        });

        Cuenta_agregar_apellido.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Cuenta_agregar_apellido.setForeground(new java.awt.Color(0, 0, 0));
        Cuenta_agregar_apellido.setText("Apellido");

        Cuenta_agregar_textoApellido.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Cuenta_agregar_textoApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cuenta_agregar_textoApellidoActionPerformed(evt);
            }
        });

        Cuenta_agregar_usuario.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Cuenta_agregar_usuario.setForeground(new java.awt.Color(0, 0, 0));
        Cuenta_agregar_usuario.setText("Usuario");

        Cuenta_agregar_textoUsuario.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Cuenta_agregar_textoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cuenta_agregar_textoUsuarioActionPerformed(evt);
            }
        });

        Cuenta_agregar_contrasenia.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Cuenta_agregar_contrasenia.setForeground(new java.awt.Color(0, 0, 0));
        Cuenta_agregar_contrasenia.setText("Contraseña");

        Cuenta_agregar_textoContrasenia.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Cuenta_agregar_textoContrasenia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cuenta_agregar_textoContraseniaActionPerformed(evt);
            }
        });

        Cuenta_agregar_cargo.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Cuenta_agregar_cargo.setForeground(new java.awt.Color(0, 0, 0));
        Cuenta_agregar_cargo.setText("Cargo");

        Cuenta_agregar_opcionesCargo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Cuenta_agregar_opcionesCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Adscripto", "Docente" }));
        Cuenta_agregar_opcionesCargo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Cuenta_agregar_opcionesCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cuenta_agregar_opcionesCargoActionPerformed(evt);
            }
        });

        Cuenta_agregar_botonAgregar.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Cuenta_agregar_botonAgregar.setText("Agregar");
        Cuenta_agregar_botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cuenta_agregar_botonAgregarActionPerformed(evt);
            }
        });

        Cuenta_verPswd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonMostrar.png"))); // NOI18N
        Cuenta_verPswd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Cuenta_verPswd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Cuenta_verPswdMouseClicked(evt);
            }
        });

        Cuenta_ocultarPswd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonOcultar.png"))); // NOI18N
        Cuenta_ocultarPswd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Cuenta_ocultarPswd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Cuenta_ocultarPswdMouseClicked(evt);
            }
        });

        Cuenta_agregar_grado.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Cuenta_agregar_grado.setForeground(new java.awt.Color(0, 0, 0));
        Cuenta_agregar_grado.setText("Grado");

        Cuenta_agregar_opcionesGrado.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Cuenta_agregar_opcionesGrado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7" }));
        Cuenta_agregar_opcionesGrado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Cuenta_agregar_asignatura.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Cuenta_agregar_asignatura.setForeground(new java.awt.Color(0, 0, 0));
        Cuenta_agregar_asignatura.setText("Asignatura");

        Cuenta_agregar_opcionesAsignatura.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Cuenta_agregar_opcionesAsignatura.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Informática", "Idioma Español", "Matemática", "Inglés", "Historia", "Geografía", "Biología", "Ciencias Físicas", "Dibujo", "Música", "Educación Física" }));
        Cuenta_agregar_opcionesAsignatura.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Cuenta_agregar_opcionesAsignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cuenta_agregar_opcionesAsignaturaActionPerformed(evt);
            }
        });

        Cuenta_mensajeAlertaCedula.setForeground(new java.awt.Color(255, 51, 51));

        Cuenta_mensajeAlertaNombre.setForeground(new java.awt.Color(255, 51, 51));

        Cuenta_mensajeAlertaApellido.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout crearCuentaLayout = new javax.swing.GroupLayout(crearCuenta);
        crearCuenta.setLayout(crearCuentaLayout);
        crearCuentaLayout.setHorizontalGroup(
            crearCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(crearCuentaLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(crearCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(crearCuentaLayout.createSequentialGroup()
                        .addComponent(Cuenta_agregar_contrasenia)
                        .addGap(18, 18, 18)
                        .addComponent(Cuenta_agregar_textoContrasenia))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, crearCuentaLayout.createSequentialGroup()
                        .addComponent(Cuenta_agregar_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Cuenta_agregar_textoNombre))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, crearCuentaLayout.createSequentialGroup()
                        .addComponent(Cuenta_agregar_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addGroup(crearCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Cuenta_mensajeAlertaCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cuenta_mensajeAlertaApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cuenta_agregar_textoUsuario)))
                    .addGroup(crearCuentaLayout.createSequentialGroup()
                        .addComponent(Cuenta_agregar_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Cuenta_agregar_textoApellido))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, crearCuentaLayout.createSequentialGroup()
                        .addComponent(Cuenta_agregar_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Cuenta_agregar_textoCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(crearCuentaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Cuenta_mensajeAlertaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)))
                .addGroup(crearCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(crearCuentaLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(crearCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Cuenta_ocultarPswd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cuenta_verPswd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(crearCuentaLayout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addGroup(crearCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Cuenta_agregar_grado, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cuenta_agregar_asignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cuenta_agregar_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(crearCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Cuenta_agregar_opcionesCargo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Cuenta_agregar_opcionesAsignatura, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Cuenta_agregar_opcionesGrado, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(61, 61, 61))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, crearCuentaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Cuenta_agregar_botonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        crearCuentaLayout.setVerticalGroup(
            crearCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(crearCuentaLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(crearCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cuenta_agregar_textoCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cuenta_agregar_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cuenta_agregar_opcionesCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cuenta_agregar_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(crearCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(crearCuentaLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(Cuenta_mensajeAlertaCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(crearCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Cuenta_agregar_textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cuenta_agregar_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(crearCuentaLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(crearCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Cuenta_agregar_opcionesGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cuenta_agregar_grado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(crearCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, crearCuentaLayout.createSequentialGroup()
                        .addGroup(crearCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(crearCuentaLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(crearCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Cuenta_ocultarPswd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Cuenta_verPswd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(crearCuentaLayout.createSequentialGroup()
                                .addComponent(Cuenta_mensajeAlertaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addGroup(crearCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Cuenta_agregar_textoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Cuenta_agregar_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Cuenta_mensajeAlertaApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addGroup(crearCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Cuenta_agregar_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Cuenta_agregar_textoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addGroup(crearCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Cuenta_agregar_textoContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Cuenta_agregar_contrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(107, 107, 107))
                    .addGroup(crearCuentaLayout.createSequentialGroup()
                        .addGroup(crearCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Cuenta_agregar_asignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cuenta_agregar_opcionesAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Cuenta_agregar_botonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))))
        );

        opcionesCuentas.addTab("Crear Cuenta", crearCuenta);

        modificarCuenta.setBackground(new java.awt.Color(255, 255, 255));

        Cuenta_cuentasRegistradas.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        Cuenta_cuentasRegistradas.setForeground(new java.awt.Color(0, 0, 0));
        Cuenta_cuentasRegistradas.setText("Cuentas registradas:");

        Cuenta_modificar_cedula.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Cuenta_modificar_cedula.setForeground(new java.awt.Color(0, 0, 0));
        Cuenta_modificar_cedula.setText("Cédula");

        Cuenta_modificar_textoCedula.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Cuenta_modificar_textoCedula.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Cuenta_modificar_textoCedula.setFocusable(false);
        Cuenta_modificar_textoCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cuenta_modificar_textoCedulaActionPerformed(evt);
            }
        });

        Cuenta_modificar_usuario.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Cuenta_modificar_usuario.setForeground(new java.awt.Color(0, 0, 0));
        Cuenta_modificar_usuario.setText("Usuario");

        Cuenta_modificar_textoUsuario.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Cuenta_modificar_textoUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Cuenta_modificar_textoUsuario.setFocusable(false);
        Cuenta_modificar_textoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cuenta_modificar_textoUsuarioActionPerformed(evt);
            }
        });

        Cuenta_modificar_contrasenia.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Cuenta_modificar_contrasenia.setForeground(new java.awt.Color(0, 0, 0));
        Cuenta_modificar_contrasenia.setText("Cambiar contraseña");

        Cuenta_modificar_textoContrasenia.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        Cuenta_modificar_opcionesCargo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Cuenta_modificar_opcionesCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Adscripto", "Docente" }));
        Cuenta_modificar_opcionesCargo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Cuenta_modificar_opcionesCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cuenta_modificar_opcionesCargoActionPerformed(evt);
            }
        });

        Cuenta_modificar_cargo.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Cuenta_modificar_cargo.setForeground(new java.awt.Color(0, 0, 0));
        Cuenta_modificar_cargo.setText("Cambiar cargo");

        Cuenta_modificar_botonModificar.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Cuenta_modificar_botonModificar.setText("Modificar");
        Cuenta_modificar_botonModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Cuenta_modificar_botonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cuenta_modificar_botonModificarActionPerformed(evt);
            }
        });

        Cuenta_botonEliminar.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Cuenta_botonEliminar.setText("Eliminar");
        Cuenta_botonEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Cuenta_botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cuenta_botonEliminarActionPerformed(evt);
            }
        });

        Cuenta_modificar_grado.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Cuenta_modificar_grado.setForeground(new java.awt.Color(0, 0, 0));
        Cuenta_modificar_grado.setText("Cambiar grado");

        Cuenta_modificar_opcionesGrado.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Cuenta_modificar_opcionesGrado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7" }));
        Cuenta_modificar_opcionesGrado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Cuenta_modificar_asignatura.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Cuenta_modificar_asignatura.setForeground(new java.awt.Color(0, 0, 0));
        Cuenta_modificar_asignatura.setText("Cambiar asignatura");

        Cuenta_modificar_opcionesAsignatura.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Cuenta_modificar_opcionesAsignatura.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Informática", "Idioma Español", "Matemática", "Inglés", "Historia", "Geografía", "Biología", "Ciencias Físicas", "Dibujo", "Música", "Educación Física" }));
        Cuenta_modificar_opcionesAsignatura.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Cuenta_modificar_opcionesAsignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cuenta_modificar_opcionesAsignaturaActionPerformed(evt);
            }
        });

        Cuenta_modificar_cedula1.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Cuenta_modificar_cedula1.setForeground(new java.awt.Color(0, 0, 0));
        Cuenta_modificar_cedula1.setText("Buscar por cédula");

        Cuenta_modificar_textoBuscar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Cuenta_modificar_textoBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cuenta_modificar_textoBuscarActionPerformed(evt);
            }
        });

        Cuenta_botonBuscar.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Cuenta_botonBuscar.setText("Buscar");
        Cuenta_botonBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Cuenta_botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cuenta_botonBuscarActionPerformed(evt);
            }
        });

        Cuenta_tablaUsuario.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Cédula", "Nombre", "Apellido", "Usuario", "Contraseña", "Cargo", "Grado", "Asignatura"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Cuenta_tablaUsuarios.setViewportView(Cuenta_tablaUsuario);
        if (Cuenta_tablaUsuario.getColumnModel().getColumnCount() > 0) {
            Cuenta_tablaUsuario.getColumnModel().getColumn(0).setResizable(false);
            Cuenta_tablaUsuario.getColumnModel().getColumn(1).setResizable(false);
            Cuenta_tablaUsuario.getColumnModel().getColumn(2).setResizable(false);
            Cuenta_tablaUsuario.getColumnModel().getColumn(3).setResizable(false);
            Cuenta_tablaUsuario.getColumnModel().getColumn(4).setResizable(false);
            Cuenta_tablaUsuario.getColumnModel().getColumn(5).setResizable(false);
            Cuenta_tablaUsuario.getColumnModel().getColumn(6).setResizable(false);
            Cuenta_tablaUsuario.getColumnModel().getColumn(7).setResizable(false);
        }

        javax.swing.GroupLayout modificarCuentaLayout = new javax.swing.GroupLayout(modificarCuenta);
        modificarCuenta.setLayout(modificarCuentaLayout);
        modificarCuentaLayout.setHorizontalGroup(
            modificarCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modificarCuentaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(modificarCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(modificarCuentaLayout.createSequentialGroup()
                        .addComponent(Cuenta_cuentasRegistradas, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(modificarCuentaLayout.createSequentialGroup()
                        .addGroup(modificarCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Cuenta_tablaUsuarios, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(modificarCuentaLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(modificarCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(modificarCuentaLayout.createSequentialGroup()
                                        .addGroup(modificarCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(modificarCuentaLayout.createSequentialGroup()
                                                .addComponent(Cuenta_modificar_textoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(Cuenta_botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(Cuenta_modificar_cedula1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(59, 59, 59)
                                        .addGroup(modificarCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Cuenta_modificar_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Cuenta_modificar_grado)))
                                    .addGroup(modificarCuentaLayout.createSequentialGroup()
                                        .addGroup(modificarCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(modificarCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(modificarCuentaLayout.createSequentialGroup()
                                                    .addComponent(Cuenta_modificar_contrasenia)
                                                    .addGap(4, 4, 4)
                                                    .addComponent(Cuenta_modificar_textoContrasenia))
                                                .addGroup(modificarCuentaLayout.createSequentialGroup()
                                                    .addComponent(Cuenta_modificar_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(33, 33, 33)
                                                    .addGroup(modificarCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(Cuenta_modificar_textoUsuario)
                                                        .addComponent(Cuenta_modificar_textoCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addComponent(Cuenta_modificar_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(61, 61, 61)
                                        .addComponent(Cuenta_modificar_asignatura)))
                                .addGap(18, 18, 18)
                                .addGroup(modificarCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(modificarCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(Cuenta_modificar_opcionesGrado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Cuenta_modificar_opcionesCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(modificarCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(modificarCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Cuenta_modificar_botonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Cuenta_botonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(Cuenta_modificar_opcionesAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        modificarCuentaLayout.setVerticalGroup(
            modificarCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modificarCuentaLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(Cuenta_cuentasRegistradas, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Cuenta_tablaUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(modificarCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(modificarCuentaLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(modificarCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Cuenta_modificar_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cuenta_modificar_opcionesCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(modificarCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Cuenta_modificar_grado)
                            .addComponent(Cuenta_modificar_opcionesGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(modificarCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Cuenta_modificar_asignatura)
                            .addComponent(Cuenta_modificar_opcionesAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(Cuenta_modificar_botonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Cuenta_botonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(modificarCuentaLayout.createSequentialGroup()
                        .addComponent(Cuenta_modificar_cedula1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(modificarCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Cuenta_modificar_textoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cuenta_botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(modificarCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Cuenta_modificar_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cuenta_modificar_textoCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(modificarCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Cuenta_modificar_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cuenta_modificar_textoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(modificarCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Cuenta_modificar_contrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cuenta_modificar_textoContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        opcionesCuentas.addTab("Modificar Cuenta", modificarCuenta);

        javax.swing.GroupLayout pestaña0Layout = new javax.swing.GroupLayout(pestaña0);
        pestaña0.setLayout(pestaña0Layout);
        pestaña0Layout.setHorizontalGroup(
            pestaña0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pestaña0Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(opcionesCuentas))
        );
        pestaña0Layout.setVerticalGroup(
            pestaña0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pestaña0Layout.createSequentialGroup()
                .addGap(0, 14, Short.MAX_VALUE)
                .addComponent(opcionesCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelPestañas.addTab("tab1", pestaña0);

        pestaña1.setBackground(new java.awt.Color(52, 80, 86));

        opcionesCursos.setBackground(new java.awt.Color(255, 255, 255));
        opcionesCursos.setForeground(new java.awt.Color(0, 0, 0));
        opcionesCursos.setToolTipText("");
        opcionesCursos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        opcionesCursos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        opcionesCursos.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                opcionesCursosStateChanged(evt);
            }
        });

        agregarCurso.setBackground(new java.awt.Color(255, 255, 255));

        Curso_agregar_clase.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Curso_agregar_clase.setForeground(new java.awt.Color(0, 0, 0));
        Curso_agregar_clase.setText("Clase");

        Curso_agregar_opcionesClase.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Curso_agregar_opcionesClase.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1°", "2°" }));
        Curso_agregar_opcionesClase.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Curso_agregar_opcionesClase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Curso_agregar_opcionesClaseActionPerformed(evt);
            }
        });

        Curso_agregar_grupo.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Curso_agregar_grupo.setForeground(new java.awt.Color(0, 0, 0));
        Curso_agregar_grupo.setText("Grupo");

        Curso_agregar_opcionesGrupo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Curso_agregar_opcionesGrupo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));
        Curso_agregar_opcionesGrupo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Curso_agregar_opcionesGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Curso_agregar_opcionesGrupoActionPerformed(evt);
            }
        });

        Curso_agregar_asignatura.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Curso_agregar_asignatura.setForeground(new java.awt.Color(0, 0, 0));
        Curso_agregar_asignatura.setText("Asignatura");

        Curso_agregar_opcionesAsignatura.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Curso_agregar_opcionesAsignatura.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Informática", "Idioma Español", "Matemática", "Inglés", "Historia", "Geografía", "Biología", "Ciencias Físicas", "Dibujo", "Música", "Educación Física" }));
        Curso_agregar_opcionesAsignatura.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Curso_agregar_opcionesAsignatura.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Curso_agregar_opcionesAsignaturaItemStateChanged(evt);
            }
        });
        Curso_agregar_opcionesAsignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Curso_agregar_opcionesAsignaturaActionPerformed(evt);
            }
        });

        Curso_agregar_botonAgregar.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Curso_agregar_botonAgregar.setText("Agregar");
        Curso_agregar_botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Curso_agregar_botonAgregarActionPerformed(evt);
            }
        });

        Curso_agregar_docente.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Curso_agregar_docente.setForeground(new java.awt.Color(0, 0, 0));
        Curso_agregar_docente.setText("Agregar un curso:");

        tablaDocente.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null}
            },
            new String [] {
                "Cédula", "Nombre", "Apellido", "Asignatura"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Curso_tablaDocentes.setViewportView(tablaDocente);
        if (tablaDocente.getColumnModel().getColumnCount() > 0) {
            tablaDocente.getColumnModel().getColumn(0).setResizable(false);
            tablaDocente.getColumnModel().getColumn(1).setResizable(false);
            tablaDocente.getColumnModel().getColumn(2).setResizable(false);
            tablaDocente.getColumnModel().getColumn(3).setResizable(false);
        }

        Curso_agregar_docente1.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Curso_agregar_docente1.setForeground(new java.awt.Color(0, 0, 0));
        Curso_agregar_docente1.setText("Seleccione un docente");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        tablaEstudiante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Seleccionar", "Cédula", "Nombre", "Apellido", "Edad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Curso_tablaEstudiantes.setViewportView(tablaEstudiante);
        if (tablaEstudiante.getColumnModel().getColumnCount() > 0) {
            tablaEstudiante.getColumnModel().getColumn(0).setResizable(false);
            tablaEstudiante.getColumnModel().getColumn(1).setResizable(false);
            tablaEstudiante.getColumnModel().getColumn(2).setResizable(false);
            tablaEstudiante.getColumnModel().getColumn(3).setResizable(false);
            tablaEstudiante.getColumnModel().getColumn(4).setResizable(false);
        }

        Curso_agregar_estudiante.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Curso_agregar_estudiante.setForeground(new java.awt.Color(0, 0, 0));
        Curso_agregar_estudiante.setText("Seleccionar estudiantes:");

        javax.swing.GroupLayout agregarCursoLayout = new javax.swing.GroupLayout(agregarCurso);
        agregarCurso.setLayout(agregarCursoLayout);
        agregarCursoLayout.setHorizontalGroup(
            agregarCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(agregarCursoLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(agregarCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(agregarCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(agregarCursoLayout.createSequentialGroup()
                            .addComponent(Curso_agregar_grupo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(Curso_agregar_opcionesGrupo, 0, 174, Short.MAX_VALUE))
                        .addGroup(agregarCursoLayout.createSequentialGroup()
                            .addComponent(Curso_agregar_clase, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(Curso_agregar_opcionesClase, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(Curso_agregar_docente, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Curso_tablaDocentes, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Curso_agregar_docente1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(agregarCursoLayout.createSequentialGroup()
                        .addComponent(Curso_agregar_asignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Curso_agregar_opcionesAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(agregarCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(agregarCursoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 351, Short.MAX_VALUE)
                        .addComponent(Curso_agregar_botonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(agregarCursoLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(agregarCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Curso_agregar_estudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Curso_tablaEstudiantes, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        agregarCursoLayout.setVerticalGroup(
            agregarCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, agregarCursoLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(agregarCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(agregarCursoLayout.createSequentialGroup()
                        .addComponent(Curso_agregar_estudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Curso_tablaEstudiantes, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(Curso_agregar_botonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, agregarCursoLayout.createSequentialGroup()
                        .addComponent(Curso_agregar_docente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(agregarCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Curso_agregar_clase, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Curso_agregar_opcionesClase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(agregarCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Curso_agregar_grupo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Curso_agregar_opcionesGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addGroup(agregarCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Curso_agregar_asignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Curso_agregar_opcionesAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(Curso_agregar_docente1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Curso_tablaDocentes, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );

        opcionesCursos.addTab("Crear Curso", agregarCurso);

        modificarCurso.setBackground(new java.awt.Color(255, 255, 255));

        cuentasRegistradas1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        cuentasRegistradas1.setForeground(new java.awt.Color(0, 0, 0));
        cuentasRegistradas1.setText("Cuentas registradas:");

        modificar_cedula2.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        modificar_cedula2.setForeground(new java.awt.Color(0, 0, 0));
        modificar_cedula2.setText("Cédula");

        modificar_textoCedula1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        modificar_textoCedula1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        modificar_textoCedula1.setFocusable(false);
        modificar_textoCedula1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificar_textoCedula1ActionPerformed(evt);
            }
        });

        modificar_usuario1.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        modificar_usuario1.setForeground(new java.awt.Color(0, 0, 0));
        modificar_usuario1.setText("Usuario");

        modificar_textoUsuario1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        modificar_textoUsuario1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        modificar_textoUsuario1.setFocusable(false);
        modificar_textoUsuario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificar_textoUsuario1ActionPerformed(evt);
            }
        });

        modificar_contrasenia1.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        modificar_contrasenia1.setForeground(new java.awt.Color(0, 0, 0));
        modificar_contrasenia1.setText("Cambiar contraseña");

        modificar_textoContrasenia1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        modificar_opcionesCargo1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        modificar_opcionesCargo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Adscripto", "Docente" }));
        modificar_opcionesCargo1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        modificar_opcionesCargo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificar_opcionesCargo1ActionPerformed(evt);
            }
        });

        modificar_cargo1.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        modificar_cargo1.setForeground(new java.awt.Color(0, 0, 0));
        modificar_cargo1.setText("Cambiar cargo");

        modificar_botonModificar1.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        modificar_botonModificar1.setText("Modificar");
        modificar_botonModificar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        modificar_botonModificar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificar_botonModificar1ActionPerformed(evt);
            }
        });

        botonEliminar1.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        botonEliminar1.setText("Eliminar");
        botonEliminar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonEliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminar1ActionPerformed(evt);
            }
        });

        modificar_grado1.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        modificar_grado1.setForeground(new java.awt.Color(0, 0, 0));
        modificar_grado1.setText("Cambiar grado");

        modificar_opcionesGrado1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        modificar_opcionesGrado1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7" }));
        modificar_opcionesGrado1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        modificar_asignatura1.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        modificar_asignatura1.setForeground(new java.awt.Color(0, 0, 0));
        modificar_asignatura1.setText("Cambiar asignatura");

        modificar_opcionesAsignatura1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        modificar_opcionesAsignatura1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Informática", "Idioma Español", "Matemática", "Inglés", "Historia", "Geografía", "Biología", "Ciencias Físicas", "Dibujo", "Música", "Educación Física" }));
        modificar_opcionesAsignatura1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        modificar_opcionesAsignatura1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificar_opcionesAsignatura1ActionPerformed(evt);
            }
        });

        modificar_cedula3.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        modificar_cedula3.setForeground(new java.awt.Color(0, 0, 0));
        modificar_cedula3.setText("Buscar por cédula");

        modificar_textoBuscar1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        modificar_textoBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificar_textoBuscar1ActionPerformed(evt);
            }
        });

        botonBuscar1.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        botonBuscar1.setText("Buscar");
        botonBuscar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscar1ActionPerformed(evt);
            }
        });

        tablaUsuario1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Cédula", "Nombre", "Apellido", "Usuario", "Contraseña", "Cargo", "Grado", "Asignatura"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaUsuarios1.setViewportView(tablaUsuario1);
        if (tablaUsuario1.getColumnModel().getColumnCount() > 0) {
            tablaUsuario1.getColumnModel().getColumn(0).setResizable(false);
            tablaUsuario1.getColumnModel().getColumn(1).setResizable(false);
            tablaUsuario1.getColumnModel().getColumn(2).setResizable(false);
            tablaUsuario1.getColumnModel().getColumn(3).setResizable(false);
            tablaUsuario1.getColumnModel().getColumn(4).setResizable(false);
            tablaUsuario1.getColumnModel().getColumn(5).setResizable(false);
            tablaUsuario1.getColumnModel().getColumn(6).setResizable(false);
            tablaUsuario1.getColumnModel().getColumn(7).setResizable(false);
        }

        javax.swing.GroupLayout modificarCursoLayout = new javax.swing.GroupLayout(modificarCurso);
        modificarCurso.setLayout(modificarCursoLayout);
        modificarCursoLayout.setHorizontalGroup(
            modificarCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modificarCursoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(modificarCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(modificarCursoLayout.createSequentialGroup()
                        .addComponent(cuentasRegistradas1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(modificarCursoLayout.createSequentialGroup()
                        .addGroup(modificarCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tablaUsuarios1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(modificarCursoLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(modificarCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(modificarCursoLayout.createSequentialGroup()
                                        .addGroup(modificarCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(modificarCursoLayout.createSequentialGroup()
                                                .addComponent(modificar_textoBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(botonBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(modificar_cedula3, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(59, 59, 59)
                                        .addGroup(modificarCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(modificar_cargo1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(modificar_grado1)))
                                    .addGroup(modificarCursoLayout.createSequentialGroup()
                                        .addGroup(modificarCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(modificarCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(modificarCursoLayout.createSequentialGroup()
                                                    .addComponent(modificar_contrasenia1)
                                                    .addGap(4, 4, 4)
                                                    .addComponent(modificar_textoContrasenia1))
                                                .addGroup(modificarCursoLayout.createSequentialGroup()
                                                    .addComponent(modificar_cedula2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(33, 33, 33)
                                                    .addGroup(modificarCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(modificar_textoUsuario1)
                                                        .addComponent(modificar_textoCedula1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addComponent(modificar_usuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(61, 61, 61)
                                        .addComponent(modificar_asignatura1)))
                                .addGap(18, 18, 18)
                                .addGroup(modificarCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(modificarCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(modificar_opcionesGrado1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(modificar_opcionesCargo1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(modificarCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(modificarCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(modificar_botonModificar1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(botonEliminar1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(modificar_opcionesAsignatura1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        modificarCursoLayout.setVerticalGroup(
            modificarCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modificarCursoLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(cuentasRegistradas1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tablaUsuarios1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(modificarCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(modificarCursoLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(modificarCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(modificar_cargo1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modificar_opcionesCargo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(modificarCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(modificar_grado1)
                            .addComponent(modificar_opcionesGrado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(modificarCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(modificar_asignatura1)
                            .addComponent(modificar_opcionesAsignatura1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(modificar_botonModificar1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonEliminar1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(modificarCursoLayout.createSequentialGroup()
                        .addComponent(modificar_cedula3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(modificarCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(modificar_textoBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(modificarCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(modificar_cedula2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modificar_textoCedula1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(modificarCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(modificar_usuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modificar_textoUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(modificarCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(modificar_contrasenia1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modificar_textoContrasenia1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        opcionesCursos.addTab("Modificar Curso", modificarCurso);

        javax.swing.GroupLayout pestaña1Layout = new javax.swing.GroupLayout(pestaña1);
        pestaña1.setLayout(pestaña1Layout);
        pestaña1Layout.setHorizontalGroup(
            pestaña1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pestaña1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(opcionesCursos))
        );
        pestaña1Layout.setVerticalGroup(
            pestaña1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pestaña1Layout.createSequentialGroup()
                .addGap(0, 14, Short.MAX_VALUE)
                .addComponent(opcionesCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE))
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
  
    }//GEN-LAST:event_botonGestionCuentasMouseExited

    private void botonGestionCuentasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGestionCuentasMouseEntered

    }//GEN-LAST:event_botonGestionCuentasMouseEntered

    //CAMBIAR DE COLOR EL BOTON AL CLICKEAR
    private void cambiarEstadoBoton(JButton button, boolean isSelected) {
        if (isSelected) {
            button.setBackground(new Color(255, 255, 255));
            button.setForeground(new Color(0, 0, 0));
        } else {
            button.setBackground(new Color(52, 80, 86));
            button.setForeground(new Color(255, 255, 255));
        }
    }
    
    private void botonGestionCuentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGestionCuentasMouseClicked
        panelPestañas.setSelectedIndex(1);
        cambiarEstadoBoton(botonGestionCursos, false);
        cambiarEstadoBoton(botonGestionActividades, false);
        cambiarEstadoBoton(botonGestionCuentas, true);
    }//GEN-LAST:event_botonGestionCuentasMouseClicked

    private void botonGestionCursosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botonGestionCursosKeyPressed
  
    }//GEN-LAST:event_botonGestionCursosKeyPressed

    private void botonGestionCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGestionCursosActionPerformed
        cargarTablaEstudiantes();
    }//GEN-LAST:event_botonGestionCursosActionPerformed

    private void botonGestionCursosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGestionCursosMouseExited
   
    }//GEN-LAST:event_botonGestionCursosMouseExited

    private void botonGestionCursosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGestionCursosMouseEntered

    }//GEN-LAST:event_botonGestionCursosMouseEntered

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

//BOTON CERRAR Y VOLVER AL LOGIN
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

//Boton Gestion de Actividades
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

//PESTAÑA AGREGAR - DESHABILITA GRADO Y ASIGNATURA SI EL CARGO NO LO NECESITA
    private void Cuenta_agregar_opcionesCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cuenta_agregar_opcionesCargoActionPerformed
        String selectedCargo = (String) Cuenta_agregar_opcionesCargo.getSelectedItem();

        switch (selectedCargo) {
        case "Administrador":
            Cuenta_agregar_opcionesAsignatura.setEnabled(false);
            Cuenta_agregar_opcionesGrado.setEnabled(false);
            break;
        case "Adscripto":
            Cuenta_agregar_opcionesAsignatura.setEnabled(false);
            Cuenta_agregar_opcionesGrado.setEnabled(true);
            break;
        case "Docente":
            Cuenta_agregar_opcionesAsignatura.setEnabled(true);
            Cuenta_agregar_opcionesGrado.setEnabled(true);
            break;
        default:
            Cuenta_agregar_opcionesAsignatura.setEnabled(false);
            Cuenta_agregar_opcionesGrado.setEnabled(false); 
            break;
        }
    }//GEN-LAST:event_Cuenta_agregar_opcionesCargoActionPerformed

//BOTON AGREGAR
    private void Cuenta_agregar_botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cuenta_agregar_botonAgregarActionPerformed
        
        String cedulaText = Cuenta_agregar_textoCedula.getText();
        String nombre = Cuenta_agregar_textoNombre.getText();
        String apellido = Cuenta_agregar_textoApellido.getText();
        String usuario = Cuenta_agregar_textoUsuario.getText();
        String contrasenia = new String(Cuenta_agregar_textoContrasenia.getPassword());
        String cargo = Cuenta_agregar_opcionesCargo.getSelectedItem().toString();
        Integer grado = Integer.parseInt(Cuenta_agregar_opcionesGrado.getSelectedItem().toString());
        String asignatura = Cuenta_agregar_opcionesAsignatura.getSelectedItem().toString();

        // Validar la cédula
        if (cedulaText.length() != 8 || !cedulaText.matches("\\d{8}")) {
            JOptionPane.showMessageDialog(this, "La cédula debe tener 8 números.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Detener la ejecución si la cédula no es válida
        }
        Integer cedula = Integer.parseInt(cedulaText);

        // Validar nombre y apellido
        if (!nombre.matches("^[a-zA-Z]+$") || !apellido.matches("^[a-zA-Z]+$")) {
            JOptionPane.showMessageDialog(this, "El nombre y el apellido solo pueden contener letras.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Detener la ejecución si el nombre o el apellido no son válidos
        }
        
        // Validar que el usuario y la contraseña no estén vacíos
        if (usuario.isEmpty() || contrasenia.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El usuario y la contraseña no pueden estar vacíos.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Detener la ejecución si el usuario o la contraseña están vacíos
        }
        
        List<Object> listaGeneral = new ArrayList<>(); // Crea una lista vacía
        GestorUsuarios gestor = new GestorUsuarios();
        listaGeneral = gestor.obtenerTodosUsuarios();
        if(!gestor.usuarioExiste(listaGeneral, cedula, usuario)){
            gestor.agregarUsuario(cedula, nombre, apellido, usuario, contrasenia, cargo);
            // Borra los campos de los JTextField
            Cuenta_agregar_textoCedula.setText("");
            Cuenta_agregar_textoNombre.setText("");
            Cuenta_agregar_textoApellido.setText("");
            Cuenta_agregar_textoUsuario.setText("");
            Cuenta_agregar_textoContrasenia.setText("");
            if(cargo.equals("Administrador")){
                GestorAdministradores gestorAdmin = new GestorAdministradores();
                gestorAdmin.agregarAdministrador(cedula, nombre, apellido, usuario, contrasenia, cargo);
            }else if(cargo.equals("Adscripto")){
                GestorAdscriptos gestorAds = new GestorAdscriptos();
                gestorAds.agregarAdscripto(cedula, nombre, apellido, usuario, contrasenia, cargo, grado);
            }else if(cargo.equals("Docente")){
                GestorDocentes gestorDoce = new GestorDocentes();
                gestorDoce.agregarDocente(cedula, nombre, apellido, usuario, contrasenia, cargo, grado, asignatura);
            }
        } 
    }//GEN-LAST:event_Cuenta_agregar_botonAgregarActionPerformed

    private void Cuenta_agregar_textoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cuenta_agregar_textoUsuarioActionPerformed
        
    }//GEN-LAST:event_Cuenta_agregar_textoUsuarioActionPerformed

//BOTON ELIMINAR USUARIO
    private void Cuenta_botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cuenta_botonEliminarActionPerformed
        int filaSeleccionada = Cuenta_tablaUsuario.getSelectedRow();
    
        if (filaSeleccionada >= 0) {
            int cedula = (int) Cuenta_tablaUsuario.getValueAt(filaSeleccionada, 0); // Obtenemos el ID del usuario de la tabla
            String cargo = (String) Cuenta_tablaUsuario.getValueAt(filaSeleccionada, 5);            
            int respuesta = JOptionPane.showConfirmDialog(
                null,
                "¿Está seguro que desea eliminar el usuario con cedula: "+cedula+"?\nSe eliminaran todos los archivos relacionados a este Usuario",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION
            );
            if (respuesta == JOptionPane.YES_OPTION){
                GestorUsuarios gestor = new GestorUsuarios();
                gestor.eliminarUsuario(cedula, cargo);
                cargarTablaUsuarios(); // Después de eliminar, actualizar la tabla
            }else{
                System.out.println("Eliminación cancelada.");
            }   
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una fila de la tabla para eliminar.", "Fila no seleccionada", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_Cuenta_botonEliminarActionPerformed

//ACTUALIZAR JTable AL CAMBIAR PESATAÑA
    private void opcionesCuentasStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_opcionesCuentasStateChanged
        cargarTablaUsuarios();
    }//GEN-LAST:event_opcionesCuentasStateChanged

//BOTON MODIFICAR USUARIO
    private void Cuenta_modificar_botonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cuenta_modificar_botonModificarActionPerformed
        int filaSeleccionada = Cuenta_tablaUsuario.getSelectedRow();
        
        if (filaSeleccionada >= 0){
            int cedula = Integer.parseInt(Cuenta_modificar_textoCedula.getText()); // Convertir la cadena a entero
            String usuario = Cuenta_modificar_textoUsuario.getText();
            String nuevaContrasenia = new String(Cuenta_modificar_textoContrasenia.getPassword());
            String nuevoCargo = Cuenta_modificar_opcionesCargo.getSelectedItem().toString(); // Obtiene el cargo seleccionado
            int nuevoGrado = Integer.parseInt(Cuenta_modificar_opcionesGrado.getSelectedItem().toString()); // Convertir item a entero
            String nuevaAsignatura = Cuenta_modificar_opcionesAsignatura.getSelectedItem().toString();
            

            int respuesta = JOptionPane.showConfirmDialog(
                null,
                "¿Está seguro que desea modificar el usuario con cedula: "+cedula+"?\nSe eliminaran todos los archivos relacionados a este Usuario",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION
            );
            
            if (respuesta == JOptionPane.YES_OPTION) {
                GestorUsuarios user = new GestorUsuarios();
                user.modificarUsuario(cedula, nuevaContrasenia, nuevoCargo, nuevoGrado, nuevaAsignatura);              
                
                cargarTablaUsuarios();
                
                // Borra los campos de los JTextField
                Cuenta_modificar_textoCedula.setText("");
                Cuenta_modificar_textoUsuario.setText("");
                Cuenta_modificar_textoContrasenia.setText("");
            } else {
                System.out.println("Modificación cancelada.");
            }   
        } else {
        JOptionPane.showMessageDialog(this, "Seleccione una fila de la tabla para modificar.", "Fila no seleccionada", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_Cuenta_modificar_botonModificarActionPerformed

    private void Cuenta_modificar_opcionesCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cuenta_modificar_opcionesCargoActionPerformed
        String selectedCargo = (String) Cuenta_modificar_opcionesCargo.getSelectedItem();

        switch (selectedCargo) {
        case "Administrador":
            Cuenta_modificar_opcionesAsignatura.setEnabled(false);
            Cuenta_modificar_opcionesGrado.setEnabled(false);
            break;
        case "Adscripto":
            Cuenta_modificar_opcionesAsignatura.setEnabled(false);
            Cuenta_modificar_opcionesGrado.setEnabled(true);
            break;
        case "Docente":
            Cuenta_modificar_opcionesAsignatura.setEnabled(true);
            Cuenta_modificar_opcionesGrado.setEnabled(true);
            break;
        default:
            Cuenta_modificar_opcionesAsignatura.setEnabled(false);
            Cuenta_modificar_opcionesGrado.setEnabled(false); 
            break;
        }
    }//GEN-LAST:event_Cuenta_modificar_opcionesCargoActionPerformed

    private void Cuenta_modificar_textoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cuenta_modificar_textoUsuarioActionPerformed

    }//GEN-LAST:event_Cuenta_modificar_textoUsuarioActionPerformed

//VER CONTRASEÑA
    private char echoCharOriginal = '\u2022';
    private boolean contraseniaVisible = false;
    
    private void Cuenta_verPswdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Cuenta_verPswdMouseClicked
        Cuenta_ocultarPswd.setVisible(true);
        Cuenta_verPswd.setVisible(false);
        if (contraseniaVisible) {
            Cuenta_agregar_textoContrasenia.setEchoChar((char) 0); // Mostrar el texto de la contraseña
            contraseniaVisible = false;
        }
    }//GEN-LAST:event_Cuenta_verPswdMouseClicked

//OCULTAR CONTRASEÑA
    private void Cuenta_ocultarPswdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Cuenta_ocultarPswdMouseClicked
        Cuenta_ocultarPswd.setVisible(false);
        Cuenta_verPswd.setVisible(true);
        if (!contraseniaVisible) {
            Cuenta_agregar_textoContrasenia.setEchoChar(echoCharOriginal); // Ocultar el texto de la contraseña
            contraseniaVisible = true;
        }
    }//GEN-LAST:event_Cuenta_ocultarPswdMouseClicked

    
    
    private void Cuenta_agregar_textoContraseniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cuenta_agregar_textoContraseniaActionPerformed
        
    }//GEN-LAST:event_Cuenta_agregar_textoContraseniaActionPerformed
   
    private void Cuenta_agregar_textoApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cuenta_agregar_textoApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cuenta_agregar_textoApellidoActionPerformed

    private void Cuenta_agregar_textoNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cuenta_agregar_textoNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cuenta_agregar_textoNombreActionPerformed

    private void Cuenta_agregar_textoCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cuenta_agregar_textoCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cuenta_agregar_textoCedulaActionPerformed

    private void Cuenta_modificar_textoCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cuenta_modificar_textoCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cuenta_modificar_textoCedulaActionPerformed

    private void Cuenta_agregar_opcionesAsignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cuenta_agregar_opcionesAsignaturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cuenta_agregar_opcionesAsignaturaActionPerformed

    private void Cuenta_modificar_opcionesAsignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cuenta_modificar_opcionesAsignaturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cuenta_modificar_opcionesAsignaturaActionPerformed

    private void Cuenta_modificar_textoBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cuenta_modificar_textoBuscarActionPerformed
        
    }//GEN-LAST:event_Cuenta_modificar_textoBuscarActionPerformed
    
//BUSCAR USUARIO POR CEDULA
    private void Cuenta_botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cuenta_botonBuscarActionPerformed
        String busquedaCedula = Cuenta_modificar_textoBuscar.getText().trim();
        DefaultTableModel model = (DefaultTableModel) Cuenta_tablaUsuario.getModel();
        boolean encontrado = false;

        for (int row = 0; row < model.getRowCount(); row++) {
            Object cedulaValue = model.getValueAt(row, 0);
            if (cedulaValue != null && cedulaValue.toString().equalsIgnoreCase(busquedaCedula)) {
                Cuenta_tablaUsuario.setRowSelectionInterval(row, row);
                hacerVisible(Cuenta_tablaUsuario, row, 0);
                llenarCamposDesdeTabla(row);
                encontrado = true;
                break; 
            }
        }
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No se encontró ninguna cédula coincidente.", "Búsqueda", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_Cuenta_botonBuscarActionPerformed

    private void Curso_agregar_botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Curso_agregar_botonAgregarActionPerformed
        
    }//GEN-LAST:event_Curso_agregar_botonAgregarActionPerformed

    private void modificar_textoCedula1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificar_textoCedula1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modificar_textoCedula1ActionPerformed

    private void modificar_textoUsuario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificar_textoUsuario1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modificar_textoUsuario1ActionPerformed

    private void modificar_opcionesCargo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificar_opcionesCargo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modificar_opcionesCargo1ActionPerformed

    private void modificar_botonModificar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificar_botonModificar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modificar_botonModificar1ActionPerformed

    private void botonEliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonEliminar1ActionPerformed

    private void modificar_opcionesAsignatura1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificar_opcionesAsignatura1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modificar_opcionesAsignatura1ActionPerformed

    private void modificar_textoBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificar_textoBuscar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modificar_textoBuscar1ActionPerformed

    private void botonBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonBuscar1ActionPerformed

    private void opcionesCursosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_opcionesCursosStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_opcionesCursosStateChanged

    private void Curso_agregar_opcionesClaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Curso_agregar_opcionesClaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Curso_agregar_opcionesClaseActionPerformed

    private void Curso_agregar_opcionesGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Curso_agregar_opcionesGrupoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Curso_agregar_opcionesGrupoActionPerformed

    private void Curso_agregar_opcionesAsignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Curso_agregar_opcionesAsignaturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Curso_agregar_opcionesAsignaturaActionPerformed

    private void Curso_agregar_opcionesAsignaturaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Curso_agregar_opcionesAsignaturaItemStateChanged
        String asignatura = Curso_agregar_opcionesAsignatura.getSelectedItem().toString();
        cargarTablaDocentesPorAsignatura(asignatura);
    }//GEN-LAST:event_Curso_agregar_opcionesAsignaturaItemStateChanged
         
//HACER VISIBLE EN LA TABLA LA FILA DEL USUARIO ENCONTRADO
    private void hacerVisible(JTable table, int fila, int columna) {
        if (!(table.getParent() instanceof javax.swing.JViewport)) {
            return;
        }
        javax.swing.JViewport viewport = (javax.swing.JViewport) table.getParent();
        java.awt.Rectangle rect = table.getCellRect(fila, columna, true);
        java.awt.Point pt = viewport.getViewPosition();
        rect.setLocation(rect.x - pt.x, rect.y - pt.y);
        table.scrollRectToVisible(rect);
    }

//CARGAR TODOS LOS DATOS DE USUARIOS (ADMIN, ADS Y DOCENTES) EN EL JTable
    private void cargarTablaUsuarios(){
        GestorUsuarios gestor = new GestorUsuarios();
        List<Object> listaGeneral = gestor.obtenerTodosUsuarios();
        
        DefaultTableModel model = (DefaultTableModel) Cuenta_tablaUsuario.getModel();
        model.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos
        
        // Eliminar todas las filas vacías del modelo
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
        
        // Agregar datos de la lista general al modelo de la tabla
        for (Object usuario : listaGeneral) {
            if (usuario instanceof Administrador) {
                Administrador admin = (Administrador) usuario;
                model.addRow(new Object[]{
                    admin.getCedula(),
                    admin.getNombre(),
                    admin.getApellido(),
                    admin.getUsuario(),
                    admin.getContrasenia(),
                    admin.getCargo(),
                    "", // Grado (vacío para no docentes)
                    ""  // Asignatura (vacío para no docentes)
                });
            } else if (usuario instanceof Adscripto) {
                Adscripto adscripto = (Adscripto) usuario;
                model.addRow(new Object[]{
                    adscripto.getCedula(),
                    adscripto.getNombre(),
                    adscripto.getApellido(),
                    adscripto.getUsuario(),
                    adscripto.getContrasenia(),
                    adscripto.getCargo(),
                    adscripto.getGrado(),
                    ""  // Asignatura (vacío para adscriptos)
                });
            } else if (usuario instanceof Docente) {
                Docente docente = (Docente) usuario;
                model.addRow(new Object[]{
                    docente.getCedula(),
                    docente.getNombre(),
                    docente.getApellido(),
                    docente.getUsuario(),
                    docente.getContrasenia(),
                    docente.getCargo(),
                    docente.getGrado(),
                    docente.getAsignatura()
                });
            }
            Cuenta_tablaUsuario.repaint();
        }
        
//AL SELECCIONAR UNA FILA, TOMA LOS DATOS Y LOS COLOCA EN LOS CAMPOS PARA MODIFICAR
        Cuenta_tablaUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int filaSeleccionada = Cuenta_tablaUsuario.getSelectedRow();
                if (filaSeleccionada >= 0) {
                    Integer cedula = (Integer) Cuenta_tablaUsuario.getValueAt(filaSeleccionada, 0);
                    String usuario = Cuenta_tablaUsuario.getValueAt(filaSeleccionada, 3).toString(); 
                    String contrasenia = Cuenta_tablaUsuario.getValueAt(filaSeleccionada, 4).toString();
                    String cargo = Cuenta_tablaUsuario.getValueAt(filaSeleccionada, 5).toString();

                    Cuenta_modificar_textoUsuario.setText(usuario);
                    Cuenta_modificar_textoContrasenia.setText(contrasenia);
                    Cuenta_modificar_textoCedula.setText(cedula.toString());
                    Cuenta_modificar_opcionesCargo.setSelectedItem(cargo); 

                    if (cargo.equals("Docente")) {
                        String grado = Cuenta_tablaUsuario.getValueAt(filaSeleccionada, 6).toString();
                        Cuenta_modificar_opcionesGrado.setSelectedItem(grado); // Actualizar grado
                        String asignatura = Cuenta_tablaUsuario.getValueAt(filaSeleccionada, 7).toString();
                        Cuenta_modificar_opcionesAsignatura.setSelectedItem(asignatura); // Actualizar asignatura 
                    } else if (cargo.equals("Adscripto")) {
                        String grado = Cuenta_tablaUsuario.getValueAt(filaSeleccionada, 6).toString();
                        Cuenta_modificar_opcionesGrado.setSelectedItem(grado); // Actualizar grado
                        Cuenta_modificar_opcionesAsignatura.setSelectedIndex(0); // Vaciar asignatura para adscripto
                    } else {
                        // Otro cargo (como Administrador)
                        Cuenta_modificar_opcionesAsignatura.setSelectedIndex(0); // Vaciar asignatura
                        Cuenta_modificar_opcionesGrado.setSelectedIndex(0); // Vaciar grado
                    }
                }
            }
        });
    }
    
//CARGAR LOS DOCENTES EN EL JTable    
    private void cargarTablaDocentesPorAsignatura(String asignatura) {
        GestorDocentes gestor = new GestorDocentes();

        List<Docente> listaDocentes = gestor.cargarDocentesDesdeBD();
        listaDocentes = gestor.filtrarDocentesPorAsignatura(asignatura);

        DefaultTableModel model = (DefaultTableModel) tablaDocente.getModel();
        model.setRowCount(0);

        // Eliminar todas las filas vacías del modelo
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }

        // Agregar datos de la lista de docentes al modelo de la tabla
        for (Docente docente : listaDocentes) {
            model.addRow(new Object[]{
                docente.getCedula(),
                docente.getNombre(),
                docente.getApellido(),
                docente.getAsignatura()
            });
        }
        tablaDocente.repaint(); // Actualizar la tabla
        }        

//CARGAR LOS DOCENTES EN EL JTable    
    private void cargarTablaEstudiantes() {
        GestorEstudiantes gestor = new GestorEstudiantes();

        List<Estudiante> listaEstudiantes = gestor.cargarEstudiantesDesdeBD();

        DefaultTableModel model = (DefaultTableModel) tablaEstudiante.getModel();
        model.setRowCount(0);

        // Agregar datos de la lista de estudiantes al modelo de la tabla
        for (Estudiante estudiante : listaEstudiantes) {
            // Agregar un objeto Boolean.TRUE para representar una casilla de verificación marcada
            model.addRow(new Object[]{
                Boolean.FALSE, // Inicialmente, la casilla de verificación está desmarcada
                estudiante.getId_estudiante(),
                estudiante.getNombre(),
                estudiante.getApellido(),
                estudiante.getEdad()
            });
        }

        // Configurar la primera columna para que muestre casillas de verificación
        TableColumn seleccionColumn = tablaEstudiante.getColumnModel().getColumn(0);
        seleccionColumn.setCellRenderer(tablaEstudiante.getDefaultRenderer(Boolean.class));
        seleccionColumn.setCellEditor(new DefaultCellEditor(new JCheckBox()));

        tablaEstudiante.repaint(); // Actualizar la tabla
    }

    
    

    

//COMPLEMENTO DEL BOTON BUSCAR - LLENA CAMPOS CON DATOS DE USUARIO ENCONTRADO
    private void llenarCamposDesdeTabla(int fila) {
        Integer cedula = (Integer) Cuenta_tablaUsuario.getValueAt(fila, 0);
        String usuario = Cuenta_tablaUsuario.getValueAt(fila, 3).toString(); 
        String contrasenia = Cuenta_tablaUsuario.getValueAt(fila, 4).toString();
        String cargo = Cuenta_tablaUsuario.getValueAt(fila, 5).toString();

        Cuenta_modificar_textoUsuario.setText(usuario);
        Cuenta_modificar_textoContrasenia.setText(contrasenia);
        Cuenta_modificar_textoCedula.setText(cedula.toString());
        Cuenta_modificar_opcionesCargo.setSelectedItem(cargo); 

        if (cargo.equals("Docente")) {
            String grado = Cuenta_tablaUsuario.getValueAt(fila, 6).toString();
            Cuenta_modificar_opcionesGrado.setSelectedItem(grado); // Actualizar grado
            String asignatura = Cuenta_tablaUsuario.getValueAt(fila, 7).toString();
            Cuenta_modificar_opcionesAsignatura.setSelectedItem(asignatura); // Actualizar asignatura 
        } else if (cargo.equals("Adscripto")) {
            String grado = Cuenta_tablaUsuario.getValueAt(fila, 6).toString();
            Cuenta_modificar_opcionesGrado.setSelectedItem(grado); // Actualizar grado
            Cuenta_modificar_opcionesAsignatura.setSelectedIndex(0); // Vaciar asignatura para adscripto
        } else {
            Cuenta_modificar_opcionesAsignatura.setSelectedIndex(0); // Vaciar asignatura
            Cuenta_modificar_opcionesGrado.setSelectedIndex(0); // Vaciar grado
        }
    }


    //Bienvenida al usuario mostrando el cargo, nombre y apellido
    public void bienvenidaUsuario(String nombreyapellidoUsuario) {
        bienvenidaUsuario.setText("Bienvenido/a Administrador " + nombreyapellidoUsuario);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cuenta_agregar_apellido;
    private javax.swing.JLabel Cuenta_agregar_asignatura;
    private javax.swing.JButton Cuenta_agregar_botonAgregar;
    private javax.swing.JLabel Cuenta_agregar_cargo;
    private javax.swing.JLabel Cuenta_agregar_cedula;
    private javax.swing.JLabel Cuenta_agregar_contrasenia;
    private javax.swing.JLabel Cuenta_agregar_grado;
    private javax.swing.JLabel Cuenta_agregar_nombre;
    private javax.swing.JComboBox<String> Cuenta_agregar_opcionesAsignatura;
    private javax.swing.JComboBox<String> Cuenta_agregar_opcionesCargo;
    private javax.swing.JComboBox<String> Cuenta_agregar_opcionesGrado;
    private javax.swing.JTextField Cuenta_agregar_textoApellido;
    private javax.swing.JTextField Cuenta_agregar_textoCedula;
    private javax.swing.JPasswordField Cuenta_agregar_textoContrasenia;
    private javax.swing.JTextField Cuenta_agregar_textoNombre;
    private javax.swing.JTextField Cuenta_agregar_textoUsuario;
    private javax.swing.JLabel Cuenta_agregar_usuario;
    private javax.swing.JButton Cuenta_botonBuscar;
    private javax.swing.JButton Cuenta_botonEliminar;
    private javax.swing.JLabel Cuenta_cuentasRegistradas;
    private javax.swing.JLabel Cuenta_mensajeAlertaApellido;
    private javax.swing.JLabel Cuenta_mensajeAlertaCedula;
    private javax.swing.JLabel Cuenta_mensajeAlertaNombre;
    private javax.swing.JLabel Cuenta_modificar_asignatura;
    private javax.swing.JButton Cuenta_modificar_botonModificar;
    private javax.swing.JLabel Cuenta_modificar_cargo;
    private javax.swing.JLabel Cuenta_modificar_cedula;
    private javax.swing.JLabel Cuenta_modificar_cedula1;
    private javax.swing.JLabel Cuenta_modificar_contrasenia;
    private javax.swing.JLabel Cuenta_modificar_grado;
    private javax.swing.JComboBox<String> Cuenta_modificar_opcionesAsignatura;
    private javax.swing.JComboBox<String> Cuenta_modificar_opcionesCargo;
    private javax.swing.JComboBox<String> Cuenta_modificar_opcionesGrado;
    private javax.swing.JTextField Cuenta_modificar_textoBuscar;
    private javax.swing.JTextField Cuenta_modificar_textoCedula;
    private javax.swing.JPasswordField Cuenta_modificar_textoContrasenia;
    private javax.swing.JTextField Cuenta_modificar_textoUsuario;
    private javax.swing.JLabel Cuenta_modificar_usuario;
    private javax.swing.JLabel Cuenta_ocultarPswd;
    private javax.swing.JTable Cuenta_tablaUsuario;
    private javax.swing.JScrollPane Cuenta_tablaUsuarios;
    private javax.swing.JLabel Cuenta_verPswd;
    private javax.swing.JLabel Curso_agregar_asignatura;
    private javax.swing.JButton Curso_agregar_botonAgregar;
    private javax.swing.JLabel Curso_agregar_clase;
    private javax.swing.JLabel Curso_agregar_docente;
    private javax.swing.JLabel Curso_agregar_docente1;
    private javax.swing.JLabel Curso_agregar_estudiante;
    private javax.swing.JLabel Curso_agregar_grupo;
    private javax.swing.JComboBox<String> Curso_agregar_opcionesAsignatura;
    private javax.swing.JComboBox<String> Curso_agregar_opcionesClase;
    private javax.swing.JComboBox<String> Curso_agregar_opcionesGrupo;
    private javax.swing.JScrollPane Curso_tablaDocentes;
    private javax.swing.JScrollPane Curso_tablaEstudiantes;
    private javax.swing.JPanel agregarCurso;
    private javax.swing.JPanel banner;
    private javax.swing.JLabel bienvenidaUsuario;
    private javax.swing.JButton botonBuscar1;
    private javax.swing.JButton botonCerrarSesion;
    private javax.swing.JButton botonEliminar1;
    private javax.swing.JButton botonGestionActividades;
    private javax.swing.JButton botonGestionCuentas;
    private javax.swing.JButton botonGestionCursos;
    private javax.swing.JPanel crearCuenta;
    private javax.swing.JLabel cuentasRegistradas1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel logoSDFA;
    private javax.swing.JPanel modificarCuenta;
    private javax.swing.JPanel modificarCurso;
    private javax.swing.JLabel modificar_asignatura1;
    private javax.swing.JButton modificar_botonModificar1;
    private javax.swing.JLabel modificar_cargo1;
    private javax.swing.JLabel modificar_cedula2;
    private javax.swing.JLabel modificar_cedula3;
    private javax.swing.JLabel modificar_contrasenia1;
    private javax.swing.JLabel modificar_grado1;
    private javax.swing.JComboBox<String> modificar_opcionesAsignatura1;
    private javax.swing.JComboBox<String> modificar_opcionesCargo1;
    private javax.swing.JComboBox<String> modificar_opcionesGrado1;
    private javax.swing.JTextField modificar_textoBuscar1;
    private javax.swing.JTextField modificar_textoCedula1;
    private javax.swing.JPasswordField modificar_textoContrasenia1;
    private javax.swing.JTextField modificar_textoUsuario1;
    private javax.swing.JLabel modificar_usuario1;
    private javax.swing.JTabbedPane opcionesCuentas;
    private javax.swing.JTabbedPane opcionesCursos;
    private javax.swing.JPanel panelAdministrador;
    private javax.swing.JPanel panelOpciones;
    private javax.swing.JTabbedPane panelPestañas;
    private javax.swing.JPanel pestaña0;
    private javax.swing.JPanel pestaña1;
    private javax.swing.JPanel pestaña2;
    private javax.swing.JPanel pestaña3;
    private javax.swing.JPanel pestañaBienvenida;
    private javax.swing.JSeparator separador;
    private javax.swing.JTable tablaDocente;
    private javax.swing.JTable tablaEstudiante;
    private javax.swing.JTable tablaUsuario1;
    private javax.swing.JScrollPane tablaUsuarios1;
    // End of variables declaration//GEN-END:variables
}
