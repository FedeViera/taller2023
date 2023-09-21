package Grafica;

import Entidades.Administrador;
import Entidades.Adscripto;
import Entidades.Curso;
import Persistencia.Persistencia_SQL;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import Entidades.Docente;
import Entidades.Estudiante;
import Logica.GestorAdministradores;
import Logica.GestorAdscriptos;
import Logica.GestorCursos;
import Logica.GestorDocentes;
import Logica.GestorUsuarios;
import Logica.GestorEstudiantes;
import Logica.GestorRelacional;

import java.lang.System.Logger;
import java.util.logging.Level;


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
    private Integer docenteSeleccionadoAgregarACurso; //VARIABLE UTILIZADA EN MOUSELISTENNER MouseListenerDocentesPorAsignatura()
    private String cursoSeleccionadoEliminarCurso_Curso, cursoSeleccionadoEliminarCurso_Asignatura; //VARIABLE UTILIZADA EN MOUSELISTENNER MouseListenerEliminarCurso()
    private String cursoSeleccionadoAgregarEstudiante_Curso, cursoSeleccionadoAgregarEstudiante_Asignatura; //VARIABLE UTILIZADA EN MOUSELISTENNER MouseListenerSeleccionarCurso_AgregarEstudiante()
    private Integer cursoID;                
    
    public Administrador_ventana() {
        initComponents();
        
        //Iniciamos todos los MouseListener para que se pueda interactuar con las JTable
        MouseListenerUsuarios(); //tablaUsuarios
        MouseListenerDocentesPorAsignatura(); //Seleccionar docentes por asignatura
        MouseListenerEliminarCurso(); //Seleccionar curso para eliminarlo
        MouseListenerSeleccionarCurso_AgregarEstudiante(); //Seleccionar curso para Agregar Estudiante
        
        
        //Precargamos tablaCursos
        GestorCursos gestorC = new GestorCursos();
        gestorC.cargarCursosDesdeBD();
        gestorC.cargarTablaCursos(Curso_tablaCurso);
        gestorC.cargarTablaCursos(Curso_tablaCursoEstudiantes);
        //Precargamos tablaEstudiantes
        GestorEstudiantes gestorE = new GestorEstudiantes();
        gestorE.cargarTablaEstudiantes(tablaEstudiante_Agregar);
        
        
        
        
        
        //VARIABLE PARA GUARDAR DOCENTE SELECCIONADO EN TABLA PARA AGREGAR CURSO
        
        
        this.setTitle("SDFA - Panel Administrador"); //Titulo de la ventana
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/logoPNG.png")).getImage()); //Logo de la ventana
       
            
        // DocumentListener - Validar el campo en tiempo real
        Cuenta_crear_textoCedula.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                Alertas.checkCedula(Cuenta_crear_textoCedula, Cuenta_mensajeAlertaCedula);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                Alertas.checkCedula(Cuenta_crear_textoCedula, Cuenta_mensajeAlertaCedula);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
             
            }
        });
        
        Cuenta_crear_textoNombre.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                Alertas.checkNombre(Cuenta_crear_textoNombre, Cuenta_mensajeAlertaNombre);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                Alertas.checkNombre(Cuenta_crear_textoNombre, Cuenta_mensajeAlertaNombre);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // No es relevante para JTextField de texto simple
            }
        });
        
        Cuenta_crear_textoApellido.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                Alertas.checkApellido(Cuenta_crear_textoApellido, Cuenta_mensajeAlertaApellido);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                Alertas.checkApellido(Cuenta_crear_textoApellido, Cuenta_mensajeAlertaApellido);
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
        pestaña0_Cuentas = new javax.swing.JPanel();
        opcionesCuentas = new javax.swing.JTabbedPane();
        crearCuenta = new javax.swing.JPanel();
        Cuenta_crear_cedula = new javax.swing.JLabel();
        Cuenta_crear_textoCedula = new javax.swing.JTextField();
        Cuenta_crear_nombre = new javax.swing.JLabel();
        Cuenta_crear_textoNombre = new javax.swing.JTextField();
        Cuenta_crear_apellido = new javax.swing.JLabel();
        Cuenta_crear_textoApellido = new javax.swing.JTextField();
        Cuenta_crear_usuario = new javax.swing.JLabel();
        Cuenta_crear_textoUsuario = new javax.swing.JTextField();
        Cuenta_crear_contrasenia = new javax.swing.JLabel();
        Cuenta_crear_textoContrasenia = new javax.swing.JPasswordField();
        Cuenta_crear_cargo = new javax.swing.JLabel();
        Cuenta_crear_opcionesCargo = new javax.swing.JComboBox<>();
        Cuenta_crear_botonCrearCuenta = new javax.swing.JButton();
        Cuenta_crear_grado = new javax.swing.JLabel();
        Cuenta_crear_opcionesGrado = new javax.swing.JComboBox<>();
        Cuenta_crear_asignatura = new javax.swing.JLabel();
        Cuenta_crear_opcionesAsignatura = new javax.swing.JComboBox<>();
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
        pestaña1_Cursos = new javax.swing.JPanel();
        opcionesCursos = new javax.swing.JTabbedPane();
        agregarCurso = new javax.swing.JPanel();
        Curso_crear_clase = new javax.swing.JLabel();
        Curso_crear_opcionesClase = new javax.swing.JComboBox<>();
        Curso_crear_grupo = new javax.swing.JLabel();
        Curso_crear_opcionesGrupo = new javax.swing.JComboBox<>();
        Curso_crear_asignatura = new javax.swing.JLabel();
        Curso_crear_opcionesAsignatura = new javax.swing.JComboBox<>();
        Curso_crear_botonCrearCurso = new javax.swing.JButton();
        Curso_tablaDocentes = new javax.swing.JScrollPane();
        Curso_tablaDocente = new javax.swing.JTable();
        Curso_crear_textoAsignarDocente = new javax.swing.JLabel();
        modificarCurso = new javax.swing.JPanel();
        cursosRegistrados = new javax.swing.JLabel();
        Curso_tablaCursos = new javax.swing.JScrollPane();
        Curso_tablaCurso = new javax.swing.JTable();
        Curso_crear_botonEliminarCurso = new javax.swing.JButton();
        Estudiantes = new javax.swing.JPanel();
        Curso_tablaEstudiantes = new javax.swing.JScrollPane();
        tablaEstudiante_Agregar = new javax.swing.JTable();
        Curso_crear_textoSeleccionarCursoEstudiantes = new javax.swing.JLabel();
        Curso_tablaCursos2 = new javax.swing.JScrollPane();
        Curso_tablaCursoEstudiantes = new javax.swing.JTable();
        Curso_crear_textoEstudiantes = new javax.swing.JLabel();
        Curso_crear_agregarEstudiante = new javax.swing.JButton();
        Curso_crear_quitarEstudiante = new javax.swing.JButton();
        Curso_tablaEstudiantes1 = new javax.swing.JScrollPane();
        tablaEstudiante_Quitar = new javax.swing.JTable();
        Curso_crear_textoEstudiantes1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
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

        pestaña0_Cuentas.setBackground(new java.awt.Color(52, 80, 86));
        pestaña0_Cuentas.setToolTipText("");

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

        Cuenta_crear_cedula.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Cuenta_crear_cedula.setForeground(new java.awt.Color(0, 0, 0));
        Cuenta_crear_cedula.setText("Cédula");

        Cuenta_crear_textoCedula.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Cuenta_crear_textoCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cuenta_crear_textoCedulaActionPerformed(evt);
            }
        });

        Cuenta_crear_nombre.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Cuenta_crear_nombre.setForeground(new java.awt.Color(0, 0, 0));
        Cuenta_crear_nombre.setText("Nombre");

        Cuenta_crear_textoNombre.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Cuenta_crear_textoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cuenta_crear_textoNombreActionPerformed(evt);
            }
        });

        Cuenta_crear_apellido.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Cuenta_crear_apellido.setForeground(new java.awt.Color(0, 0, 0));
        Cuenta_crear_apellido.setText("Apellido");

        Cuenta_crear_textoApellido.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Cuenta_crear_textoApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cuenta_crear_textoApellidoActionPerformed(evt);
            }
        });

        Cuenta_crear_usuario.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Cuenta_crear_usuario.setForeground(new java.awt.Color(0, 0, 0));
        Cuenta_crear_usuario.setText("Usuario");

        Cuenta_crear_textoUsuario.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Cuenta_crear_textoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cuenta_crear_textoUsuarioActionPerformed(evt);
            }
        });

        Cuenta_crear_contrasenia.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Cuenta_crear_contrasenia.setForeground(new java.awt.Color(0, 0, 0));
        Cuenta_crear_contrasenia.setText("Contraseña");

        Cuenta_crear_textoContrasenia.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Cuenta_crear_textoContrasenia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cuenta_crear_textoContraseniaActionPerformed(evt);
            }
        });

        Cuenta_crear_cargo.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Cuenta_crear_cargo.setForeground(new java.awt.Color(0, 0, 0));
        Cuenta_crear_cargo.setText("Cargo");

        Cuenta_crear_opcionesCargo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Cuenta_crear_opcionesCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Adscripto", "Docente" }));
        Cuenta_crear_opcionesCargo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Cuenta_crear_opcionesCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cuenta_crear_opcionesCargoActionPerformed(evt);
            }
        });

        Cuenta_crear_botonCrearCuenta.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Cuenta_crear_botonCrearCuenta.setText("Crear cuenta");
        Cuenta_crear_botonCrearCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cuenta_crear_botonCrearCuentaActionPerformed(evt);
            }
        });

        Cuenta_crear_grado.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Cuenta_crear_grado.setForeground(new java.awt.Color(0, 0, 0));
        Cuenta_crear_grado.setText("Grado");

        Cuenta_crear_opcionesGrado.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Cuenta_crear_opcionesGrado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7" }));
        Cuenta_crear_opcionesGrado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Cuenta_crear_asignatura.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Cuenta_crear_asignatura.setForeground(new java.awt.Color(0, 0, 0));
        Cuenta_crear_asignatura.setText("Asignatura");

        Cuenta_crear_opcionesAsignatura.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Cuenta_crear_opcionesAsignatura.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Informática", "Idioma Español", "Matemática", "Inglés", "Historia", "Geografía", "Biología", "Ciencias Físicas", "Dibujo", "Música", "Educación Física" }));
        Cuenta_crear_opcionesAsignatura.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Cuenta_crear_opcionesAsignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cuenta_crear_opcionesAsignaturaActionPerformed(evt);
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
                        .addGap(116, 116, 116)
                        .addGroup(crearCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Cuenta_crear_textoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(crearCuentaLayout.createSequentialGroup()
                                .addGroup(crearCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(crearCuentaLayout.createSequentialGroup()
                                        .addComponent(Cuenta_mensajeAlertaCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(crearCuentaLayout.createSequentialGroup()
                                        .addGap(0, 3, Short.MAX_VALUE)
                                        .addComponent(Cuenta_mensajeAlertaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(155, 155, 155)))
                                .addGroup(crearCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Cuenta_crear_grado, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Cuenta_crear_asignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Cuenta_crear_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(crearCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Cuenta_crear_opcionesCargo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Cuenta_crear_opcionesAsignatura, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Cuenta_crear_opcionesGrado, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, crearCuentaLayout.createSequentialGroup()
                        .addGroup(crearCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Cuenta_crear_usuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(crearCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(crearCuentaLayout.createSequentialGroup()
                                    .addComponent(Cuenta_crear_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(Cuenta_crear_textoNombre))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, crearCuentaLayout.createSequentialGroup()
                                    .addComponent(Cuenta_crear_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(Cuenta_crear_textoCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, crearCuentaLayout.createSequentialGroup()
                                .addComponent(Cuenta_crear_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(crearCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Cuenta_mensajeAlertaApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Cuenta_crear_textoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(crearCuentaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(crearCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Cuenta_crear_botonCrearCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(crearCuentaLayout.createSequentialGroup()
                                .addComponent(Cuenta_crear_contrasenia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Cuenta_crear_textoContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(357, 357, 357)))
                .addGap(72, 72, 72))
        );
        crearCuentaLayout.setVerticalGroup(
            crearCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(crearCuentaLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(crearCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(crearCuentaLayout.createSequentialGroup()
                        .addGroup(crearCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Cuenta_crear_textoCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cuenta_crear_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addComponent(Cuenta_mensajeAlertaCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(crearCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Cuenta_crear_textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cuenta_crear_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Cuenta_mensajeAlertaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(crearCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Cuenta_crear_textoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cuenta_crear_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Cuenta_mensajeAlertaApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(crearCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Cuenta_crear_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cuenta_crear_textoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(crearCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Cuenta_crear_textoContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cuenta_crear_contrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addComponent(Cuenta_crear_botonCrearCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(crearCuentaLayout.createSequentialGroup()
                        .addGroup(crearCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Cuenta_crear_opcionesCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cuenta_crear_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(crearCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Cuenta_crear_opcionesGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cuenta_crear_grado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(crearCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Cuenta_crear_asignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cuenta_crear_opcionesAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(305, 305, 305))))
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
        Cuenta_modificar_botonModificar.setText("Modificar cuenta");
        Cuenta_modificar_botonModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Cuenta_modificar_botonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cuenta_modificar_botonModificarActionPerformed(evt);
            }
        });

        Cuenta_botonEliminar.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Cuenta_botonEliminar.setText("Eliminar cuenta");
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
        Cuenta_botonBuscar.setText("Buscar cuenta");
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
                                            .addComponent(Cuenta_modificar_cedula1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(modificarCuentaLayout.createSequentialGroup()
                                                .addComponent(Cuenta_modificar_textoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(Cuenta_botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                                .addGroup(modificarCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Cuenta_modificar_opcionesGrado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Cuenta_modificar_opcionesAsignatura, javax.swing.GroupLayout.Alignment.TRAILING, 0, 171, Short.MAX_VALUE)
                                    .addComponent(Cuenta_modificar_botonModificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Cuenta_botonEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Cuenta_modificar_opcionesCargo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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

        javax.swing.GroupLayout pestaña0_CuentasLayout = new javax.swing.GroupLayout(pestaña0_Cuentas);
        pestaña0_Cuentas.setLayout(pestaña0_CuentasLayout);
        pestaña0_CuentasLayout.setHorizontalGroup(
            pestaña0_CuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pestaña0_CuentasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(opcionesCuentas))
        );
        pestaña0_CuentasLayout.setVerticalGroup(
            pestaña0_CuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pestaña0_CuentasLayout.createSequentialGroup()
                .addGap(0, 14, Short.MAX_VALUE)
                .addComponent(opcionesCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelPestañas.addTab("tab1", pestaña0_Cuentas);

        pestaña1_Cursos.setBackground(new java.awt.Color(52, 80, 86));

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

        Curso_crear_clase.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Curso_crear_clase.setForeground(new java.awt.Color(0, 0, 0));
        Curso_crear_clase.setText("Clase");

        Curso_crear_opcionesClase.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Curso_crear_opcionesClase.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1°", "2°" }));
        Curso_crear_opcionesClase.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Curso_crear_opcionesClase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Curso_crear_opcionesClaseActionPerformed(evt);
            }
        });

        Curso_crear_grupo.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Curso_crear_grupo.setForeground(new java.awt.Color(0, 0, 0));
        Curso_crear_grupo.setText("Grupo");

        Curso_crear_opcionesGrupo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Curso_crear_opcionesGrupo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));
        Curso_crear_opcionesGrupo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Curso_crear_opcionesGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Curso_crear_opcionesGrupoActionPerformed(evt);
            }
        });

        Curso_crear_asignatura.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Curso_crear_asignatura.setForeground(new java.awt.Color(0, 0, 0));
        Curso_crear_asignatura.setText("Asignatura");

        Curso_crear_opcionesAsignatura.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Curso_crear_opcionesAsignatura.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Informática", "Idioma Español", "Matemática", "Inglés", "Historia", "Geografía", "Biología", "Ciencias Físicas", "Dibujo", "Música", "Educación Física" }));
        Curso_crear_opcionesAsignatura.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Curso_crear_opcionesAsignatura.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Curso_crear_opcionesAsignaturaItemStateChanged(evt);
            }
        });
        Curso_crear_opcionesAsignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Curso_crear_opcionesAsignaturaActionPerformed(evt);
            }
        });

        Curso_crear_botonCrearCurso.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Curso_crear_botonCrearCurso.setText("Crear curso");
        Curso_crear_botonCrearCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Curso_crear_botonCrearCursoActionPerformed(evt);
            }
        });

        Curso_tablaDocente.setModel(new javax.swing.table.DefaultTableModel(
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
        Curso_tablaDocentes.setViewportView(Curso_tablaDocente);
        if (Curso_tablaDocente.getColumnModel().getColumnCount() > 0) {
            Curso_tablaDocente.getColumnModel().getColumn(0).setResizable(false);
            Curso_tablaDocente.getColumnModel().getColumn(1).setResizable(false);
            Curso_tablaDocente.getColumnModel().getColumn(2).setResizable(false);
            Curso_tablaDocente.getColumnModel().getColumn(3).setResizable(false);
        }

        Curso_crear_textoAsignarDocente.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        Curso_crear_textoAsignarDocente.setForeground(new java.awt.Color(0, 0, 0));
        Curso_crear_textoAsignarDocente.setText("Asignar un docente al curso:");

        javax.swing.GroupLayout agregarCursoLayout = new javax.swing.GroupLayout(agregarCurso);
        agregarCurso.setLayout(agregarCursoLayout);
        agregarCursoLayout.setHorizontalGroup(
            agregarCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(agregarCursoLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(agregarCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(agregarCursoLayout.createSequentialGroup()
                        .addComponent(Curso_crear_asignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Curso_crear_opcionesAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Curso_crear_botonCrearCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(agregarCursoLayout.createSequentialGroup()
                        .addComponent(Curso_crear_grupo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Curso_crear_opcionesGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(agregarCursoLayout.createSequentialGroup()
                        .addComponent(Curso_crear_clase, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Curso_crear_opcionesClase, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Curso_crear_textoAsignarDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Curso_tablaDocentes, javax.swing.GroupLayout.PREFERRED_SIZE, 885, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        agregarCursoLayout.setVerticalGroup(
            agregarCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(agregarCursoLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(agregarCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Curso_crear_clase, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Curso_crear_opcionesClase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(agregarCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Curso_crear_grupo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Curso_crear_opcionesGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(agregarCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Curso_crear_asignatura, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Curso_crear_opcionesAsignatura, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(Curso_crear_textoAsignarDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Curso_tablaDocentes, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Curso_crear_botonCrearCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        opcionesCursos.addTab("Crear Curso", agregarCurso);

        modificarCurso.setBackground(new java.awt.Color(255, 255, 255));

        cursosRegistrados.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        cursosRegistrados.setForeground(new java.awt.Color(0, 0, 0));
        cursosRegistrados.setText("Cursos registrados:");

        Curso_tablaCurso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Curso", "Asignatura"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Curso_tablaCursos.setViewportView(Curso_tablaCurso);
        if (Curso_tablaCurso.getColumnModel().getColumnCount() > 0) {
            Curso_tablaCurso.getColumnModel().getColumn(0).setResizable(false);
            Curso_tablaCurso.getColumnModel().getColumn(1).setResizable(false);
        }

        Curso_crear_botonEliminarCurso.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Curso_crear_botonEliminarCurso.setText("Eliminar curso");
        Curso_crear_botonEliminarCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Curso_crear_botonEliminarCursoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout modificarCursoLayout = new javax.swing.GroupLayout(modificarCurso);
        modificarCurso.setLayout(modificarCursoLayout);
        modificarCursoLayout.setHorizontalGroup(
            modificarCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modificarCursoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(modificarCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(modificarCursoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cursosRegistrados, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(528, 528, 528))
                    .addGroup(modificarCursoLayout.createSequentialGroup()
                        .addGroup(modificarCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Curso_tablaCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 906, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Curso_crear_botonEliminarCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        modificarCursoLayout.setVerticalGroup(
            modificarCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modificarCursoLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(cursosRegistrados, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Curso_tablaCursos, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Curso_crear_botonEliminarCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        opcionesCursos.addTab("Modificar Curso", modificarCurso);

        Estudiantes.setBackground(new java.awt.Color(255, 255, 255));

        tablaEstudiante_Agregar.setModel(new javax.swing.table.DefaultTableModel(
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
        Curso_tablaEstudiantes.setViewportView(tablaEstudiante_Agregar);
        if (tablaEstudiante_Agregar.getColumnModel().getColumnCount() > 0) {
            tablaEstudiante_Agregar.getColumnModel().getColumn(0).setResizable(false);
            tablaEstudiante_Agregar.getColumnModel().getColumn(1).setResizable(false);
            tablaEstudiante_Agregar.getColumnModel().getColumn(2).setResizable(false);
            tablaEstudiante_Agregar.getColumnModel().getColumn(3).setResizable(false);
            tablaEstudiante_Agregar.getColumnModel().getColumn(4).setResizable(false);
        }

        Curso_crear_textoSeleccionarCursoEstudiantes.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        Curso_crear_textoSeleccionarCursoEstudiantes.setForeground(new java.awt.Color(0, 0, 0));
        Curso_crear_textoSeleccionarCursoEstudiantes.setText("Seleccionar curso:");

        Curso_tablaCursoEstudiantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Curso", "Asignatura"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Curso_tablaCursos2.setViewportView(Curso_tablaCursoEstudiantes);
        if (Curso_tablaCursoEstudiantes.getColumnModel().getColumnCount() > 0) {
            Curso_tablaCursoEstudiantes.getColumnModel().getColumn(0).setResizable(false);
            Curso_tablaCursoEstudiantes.getColumnModel().getColumn(1).setResizable(false);
        }

        Curso_crear_textoEstudiantes.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        Curso_crear_textoEstudiantes.setForeground(new java.awt.Color(0, 0, 0));
        Curso_crear_textoEstudiantes.setText("Seleccionar estudiantes para agregar al curso:");

        Curso_crear_agregarEstudiante.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Curso_crear_agregarEstudiante.setText("Agregar");
        Curso_crear_agregarEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Curso_crear_agregarEstudianteActionPerformed(evt);
            }
        });

        Curso_crear_quitarEstudiante.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Curso_crear_quitarEstudiante.setText("Quitar");
        Curso_crear_quitarEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Curso_crear_quitarEstudianteActionPerformed(evt);
            }
        });

        tablaEstudiante_Quitar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Seleccionar", "Cédula Estudiante"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Curso_tablaEstudiantes1.setViewportView(tablaEstudiante_Quitar);
        if (tablaEstudiante_Quitar.getColumnModel().getColumnCount() > 0) {
            tablaEstudiante_Quitar.getColumnModel().getColumn(0).setResizable(false);
            tablaEstudiante_Quitar.getColumnModel().getColumn(1).setResizable(false);
        }

        Curso_crear_textoEstudiantes1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        Curso_crear_textoEstudiantes1.setForeground(new java.awt.Color(0, 0, 0));
        Curso_crear_textoEstudiantes1.setText("Seleccionar estudiantes para quitar del curso:");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout EstudiantesLayout = new javax.swing.GroupLayout(Estudiantes);
        Estudiantes.setLayout(EstudiantesLayout);
        EstudiantesLayout.setHorizontalGroup(
            EstudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EstudiantesLayout.createSequentialGroup()
                .addGroup(EstudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EstudiantesLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(EstudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Curso_crear_agregarEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Curso_crear_textoEstudiantes, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Curso_tablaEstudiantes, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(EstudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Curso_tablaEstudiantes1, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Curso_crear_textoEstudiantes1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Curso_crear_quitarEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EstudiantesLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(EstudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Curso_crear_textoSeleccionarCursoEstudiantes, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Curso_tablaCursos2, javax.swing.GroupLayout.PREFERRED_SIZE, 910, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        EstudiantesLayout.setVerticalGroup(
            EstudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EstudiantesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Curso_crear_textoSeleccionarCursoEstudiantes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Curso_tablaCursos2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(EstudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EstudiantesLayout.createSequentialGroup()
                        .addGroup(EstudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Curso_crear_textoEstudiantes1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Curso_crear_textoEstudiantes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(EstudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Curso_tablaEstudiantes, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Curso_tablaEstudiantes1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addGroup(EstudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Curso_crear_agregarEstudiante, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Curso_crear_quitarEstudiante, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jSeparator1))
                .addGap(25, 25, 25))
        );

        opcionesCursos.addTab("Agregar/Quitar Estudiantes", Estudiantes);

        javax.swing.GroupLayout pestaña1_CursosLayout = new javax.swing.GroupLayout(pestaña1_Cursos);
        pestaña1_Cursos.setLayout(pestaña1_CursosLayout);
        pestaña1_CursosLayout.setHorizontalGroup(
            pestaña1_CursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pestaña1_CursosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(opcionesCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 952, Short.MAX_VALUE))
        );
        pestaña1_CursosLayout.setVerticalGroup(
            pestaña1_CursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pestaña1_CursosLayout.createSequentialGroup()
                .addGap(0, 14, Short.MAX_VALUE)
                .addComponent(opcionesCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelPestañas.addTab("tab2", pestaña1_Cursos);

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
    private void Cuenta_crear_opcionesCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cuenta_crear_opcionesCargoActionPerformed
        String selectedCargo = (String) Cuenta_crear_opcionesCargo.getSelectedItem();

        switch (selectedCargo) {
        case "Administrador":
            Cuenta_crear_opcionesAsignatura.setEnabled(false);
            Cuenta_crear_opcionesGrado.setEnabled(false);
            break;
        case "Adscripto":
            Cuenta_crear_opcionesAsignatura.setEnabled(false);
            Cuenta_crear_opcionesGrado.setEnabled(true);
            break;
        case "Docente":
            Cuenta_crear_opcionesAsignatura.setEnabled(true);
            Cuenta_crear_opcionesGrado.setEnabled(true);
            break;
        default:
            Cuenta_crear_opcionesAsignatura.setEnabled(false);
            Cuenta_crear_opcionesGrado.setEnabled(false); 
            break;
        }
    }//GEN-LAST:event_Cuenta_crear_opcionesCargoActionPerformed

//BOTON AGREGAR
    private void Cuenta_crear_botonCrearCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cuenta_crear_botonCrearCuentaActionPerformed
        
        String cedulaText = Cuenta_crear_textoCedula.getText();
        String nombre = Cuenta_crear_textoNombre.getText();
        String apellido = Cuenta_crear_textoApellido.getText();
        String usuario = Cuenta_crear_textoUsuario.getText();
        String contrasenia = new String(Cuenta_crear_textoContrasenia.getPassword());
        String cargo = Cuenta_crear_opcionesCargo.getSelectedItem().toString();
        Integer grado = Integer.parseInt(Cuenta_crear_opcionesGrado.getSelectedItem().toString());
        String asignatura = Cuenta_crear_opcionesAsignatura.getSelectedItem().toString();

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
            Cuenta_crear_textoCedula.setText("");
            Cuenta_crear_textoNombre.setText("");
            Cuenta_crear_textoApellido.setText("");
            Cuenta_crear_textoUsuario.setText("");
            Cuenta_crear_textoContrasenia.setText("");
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
    }//GEN-LAST:event_Cuenta_crear_botonCrearCuentaActionPerformed

    private void Cuenta_crear_textoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cuenta_crear_textoUsuarioActionPerformed
        
    }//GEN-LAST:event_Cuenta_crear_textoUsuarioActionPerformed

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
                GestorRelacional gestorR = new GestorRelacional();
                gestorR.eliminarDocenteACurso(cedula); //PRIMERO ELIMINAR EL DOCENTE RELACIONADO A LA CURSO
                GestorUsuarios gestorU = new GestorUsuarios();
                gestorU.eliminarUsuario(cedula, cargo); //LUEGO ELIMINAR EL DOCENTE
                
                
                gestorU.cargarTablaUsuarios(Cuenta_tablaUsuario); // Después de eliminar, actualizar la tabla
            }else{
                System.out.println("Eliminación cancelada.");
            }   
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una fila de la tabla para eliminar.", "Fila no seleccionada", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_Cuenta_botonEliminarActionPerformed

//ACTUALIZAR JTable AL CAMBIAR PESATAÑA
    private void opcionesCuentasStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_opcionesCuentasStateChanged
        GestorUsuarios gestorU = new GestorUsuarios();
        gestorU.cargarTablaUsuarios(Cuenta_tablaUsuario); //Refresco TablaUsuarios
        
        
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
            
            //Aviso antes de Borrar Usuario (Borrar todo lo relacionado a ese usuario)
            int respuesta = JOptionPane.showConfirmDialog(
                null,
                "¿Está seguro que desea modificar el usuario con cedula: "+cedula+"?\nSe eliminaran todos los archivos relacionados a este Usuario",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION
            );
            
            if (respuesta == JOptionPane.YES_OPTION) {
                GestorRelacional gestorR = new GestorRelacional();
                gestorR.eliminarDocenteACurso(cedula); //Primero elimina docente relacionado a un Curso
                GestorUsuarios gestorU = new GestorUsuarios();
                gestorU.modificarUsuario(cedula, nuevaContrasenia, nuevoCargo, nuevoGrado, nuevaAsignatura); //Modifica usuario "libre"             
                
                gestorU.cargarTablaUsuarios(Cuenta_tablaUsuario); //Refresca tabla Usuarios
                
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

//APAGA LOS BOTONES SI NO ES NECESARIO USARLOS PARA DETERMINADO USUARIO    
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
     
    private void Cuenta_crear_textoContraseniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cuenta_crear_textoContraseniaActionPerformed
        
    }//GEN-LAST:event_Cuenta_crear_textoContraseniaActionPerformed
   
    private void Cuenta_crear_textoApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cuenta_crear_textoApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cuenta_crear_textoApellidoActionPerformed

    private void Cuenta_crear_textoNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cuenta_crear_textoNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cuenta_crear_textoNombreActionPerformed

    private void Cuenta_crear_textoCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cuenta_crear_textoCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cuenta_crear_textoCedulaActionPerformed

    private void Cuenta_modificar_textoCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cuenta_modificar_textoCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cuenta_modificar_textoCedulaActionPerformed

    private void Cuenta_crear_opcionesAsignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cuenta_crear_opcionesAsignaturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cuenta_crear_opcionesAsignaturaActionPerformed

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
                hacerVisibleFilaEncontrada(Cuenta_tablaUsuario, row, 0); //Llama a metodo para que seleccione la fila buscada en la Tabla
                llenarCamposDesdeTabla(row); //Completa los campos a modificar
                encontrado = true;
                break; 
            }
        }
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No se encontró ninguna cédula coincidente.", "Búsqueda", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_Cuenta_botonBuscarActionPerformed

//HACER VISIBLE EN LA TABLA LA FILA DEL USUARIO ENCONTRADO
    private void hacerVisibleFilaEncontrada(JTable table, int fila, int columna) {
        if (!(table.getParent() instanceof javax.swing.JViewport)) {
            return;
        }
        javax.swing.JViewport viewport = (javax.swing.JViewport) table.getParent();
        java.awt.Rectangle rect = table.getCellRect(fila, columna, true);
        java.awt.Point pt = viewport.getViewPosition();
        rect.setLocation(rect.x - pt.x, rect.y - pt.y);
        table.scrollRectToVisible(rect);
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
    
//AGREGAR UN CURSO (VINCULAR DOCENTE Y AGREGAR ALUMNOS)
    private void Curso_crear_botonCrearCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Curso_crear_botonCrearCursoActionPerformed
        String clase = Curso_crear_opcionesClase.getSelectedItem().toString(); //Guardar clase
        String grupo = Curso_crear_opcionesGrupo.getSelectedItem().toString(); //Guardar grupo
        
        String claseYgrupo = clase+grupo; //Concatenar claseygrupo
        String asignatura = Curso_crear_opcionesAsignatura.getSelectedItem().toString(); //Guardar asignatura
        
        GestorCursos gestorCursos = new GestorCursos();
        gestorCursos.cargarCursosDesdeBD(); //Refresca datos desde BD
        boolean realizado = false;
        if(!gestorCursos.cursoExiste(claseYgrupo, asignatura) && docenteSeleccionadoAgregarACurso != null){
            gestorCursos.agregarCurso(claseYgrupo, asignatura); //Agrega un Curso
            JOptionPane.showMessageDialog(null, "Curso "+claseYgrupo+" - "+asignatura+" creado correctamente", "Curso Creado", JOptionPane.INFORMATION_MESSAGE);
            realizado = true; //Si se creo el grupo correctamente devuelve true
        }else{
            JOptionPane.showMessageDialog(null, "El Curso "+claseYgrupo+" de la Asignatura "+asignatura+" ya se encuentra creado o no Selecciono ningún Docente", "Error", JOptionPane.ERROR_MESSAGE);
        }
        gestorCursos.cargarCursosDesdeBD();
        int idCurso1 = gestorCursos.buscarIDCurso(claseYgrupo, asignatura);  //Trae el ID del curso a partir de Clase y Grupo 
        //Si se pudo crear el grupo, Agrega el docente a ese grupo
        if (realizado) {
            int cedulaDocente = docenteSeleccionadoAgregarACurso.intValue();
            GestorRelacional gestorRelacional = new GestorRelacional();
            gestorRelacional.agregarDocenteACurso(cedulaDocente, idCurso1);//Agrega docente al grupo
            
            GestorCursos gestorC = new GestorCursos();
            gestorC.cargarTablaCursos(Curso_tablaCurso);
        } else {
            JOptionPane.showMessageDialog(null, "No se selecciono ningun docente para el curso.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }    
    }//GEN-LAST:event_Curso_crear_botonCrearCursoActionPerformed
  
    private void opcionesCursosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_opcionesCursosStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_opcionesCursosStateChanged

    private void Curso_crear_opcionesClaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Curso_crear_opcionesClaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Curso_crear_opcionesClaseActionPerformed

    private void Curso_crear_opcionesGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Curso_crear_opcionesGrupoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Curso_crear_opcionesGrupoActionPerformed

    private void Curso_crear_opcionesAsignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Curso_crear_opcionesAsignaturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Curso_crear_opcionesAsignaturaActionPerformed

    private void Curso_crear_opcionesAsignaturaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Curso_crear_opcionesAsignaturaItemStateChanged
        //Cuando seleccionamos otra Asignatura al crear Curso, actualiza la tabla mostrando docentes de esa Asignatura
        String asignatura = Curso_crear_opcionesAsignatura.getSelectedItem().toString();
        GestorDocentes gestorD = new GestorDocentes();
        gestorD.cargarTablaDocentesPorAsignatura(asignatura, Curso_tablaDocente);
    }//GEN-LAST:event_Curso_crear_opcionesAsignaturaItemStateChanged

    private void Curso_crear_botonEliminarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Curso_crear_botonEliminarCursoActionPerformed
        //Traemos seleccion de Curso desde el MouseListener - MouseListenerEliminarCurso()
        String curso_ClaseyGrupo = cursoSeleccionadoEliminarCurso_Curso;
        String asignatura = cursoSeleccionadoEliminarCurso_Asignatura;
    
        int respuesta = JOptionPane.showConfirmDialog(
                null,
                "¿Está seguro que desea eliminar el curso "+curso_ClaseyGrupo+" de " +asignatura+" ?\nSe eliminaran todos los archivos relacionados a este Curso",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION
            );
            if (respuesta == JOptionPane.YES_OPTION){
                GestorCursos gestorC = new GestorCursos();
                gestorC.cargarCursosDesdeBD();
                int cursoID = gestorC.buscarIDCurso(curso_ClaseyGrupo, asignatura);
                
                GestorRelacional gestorR = new GestorRelacional();
                gestorR.eliminarCursoConDocente(cursoID);
                gestorC.eliminarCurso(cursoID);

                gestorC.cargarCursosDesdeBD();
                gestorC.cargarTablaCursos(Curso_tablaCurso);
            }else{
                System.out.println("Eliminación cancelada.");
            }  
    }//GEN-LAST:event_Curso_crear_botonEliminarCursoActionPerformed

//AGREGAR ESTUDIANTES A CURSO    
    private void Curso_crear_agregarEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Curso_crear_agregarEstudianteActionPerformed
        //Traemos seleccion de curso desde MouseListener - MouseListenerSeleccionarCurso_AgregarEstudiante()
        String curso_ClaseyGrupo = cursoSeleccionadoAgregarEstudiante_Curso;
        String asignatura = cursoSeleccionadoAgregarEstudiante_Asignatura;
                       
        GestorCursos gestorC = new GestorCursos();
        gestorC.cargarCursosDesdeBD();
        int cursoID = gestorC.buscarIDCurso(curso_ClaseyGrupo, asignatura);
            
        GestorEstudiantes gestorE = new GestorEstudiantes();
        List<Estudiante> estudiantesSeleccionados = gestorE.obtenerEstudiantesSeleccionados_Agregar(tablaEstudiante_Agregar); //Estudiantes seleccionados en la JTable

        GestorRelacional gestorR = new GestorRelacional();
        gestorR.agregarEstudiantesACurso(cursoID, estudiantesSeleccionados); //AGREGAR ESTUDIANTES AL CURSO*/        
    }//GEN-LAST:event_Curso_crear_agregarEstudianteActionPerformed

//QUITAR ESTUDIANTES DE CURSO    
    private void Curso_crear_quitarEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Curso_crear_quitarEstudianteActionPerformed
        String curso_ClaseyGrupo = cursoSeleccionadoAgregarEstudiante_Curso;
        String asignatura = cursoSeleccionadoAgregarEstudiante_Asignatura;
                       
        GestorCursos gestorC = new GestorCursos();
        gestorC.cargarCursosDesdeBD();
        int cursoID = gestorC.buscarIDCurso(curso_ClaseyGrupo, asignatura);
        
        
            
        /*GestorEstudiantes gestorE = new GestorEstudiantes();
        List<Estudiante> estudiantesSeleccionados = gestorE.obtenerEstudiantesSeleccionados_Quitar(tablaEstudiante_Quitar); //Estudiantes seleccionados en la JTable

        
        GestorRelacional gestorR = new GestorRelacional();
        gestorR.quitarEstudiantesACurso(cursoID, estudiantesSeleccionados); //QUITAR ESTUDIANTES AL CURSO  */
    }//GEN-LAST:event_Curso_crear_quitarEstudianteActionPerformed
         
// ===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===
    
//MOUSE LISTENER PARA TOMAR DATOS DE LA TABLA CUENTAS USUARIOS    
    private void MouseListenerUsuarios() {
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
    
//MOUSE LISTENER PARA TOMAR DATOS DE TABLA DOCENTES (PARA AGREGAR DOCENTE A CURSO)
    private void MouseListenerDocentesPorAsignatura() {
        Curso_tablaDocente.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int filaSeleccionada = Curso_tablaDocente.getSelectedRow();
                if (filaSeleccionada >= 0) {
                    //variable declarada arriba fuera del metodo para usarla luego. GUARDA LA CEDULA DEL DOCENTE SELECCIONADO PARA CREAR EL CURSO
                    docenteSeleccionadoAgregarACurso = (Integer) Curso_tablaDocente.getValueAt(filaSeleccionada, 0);
                }
            }
        });
    }

//MOUSE LISTENER PARA TOMAR DATOS DE TABLA CURSOS (PARA ELIMINAR CURSO)
    private void MouseListenerEliminarCurso() {
        Curso_tablaCurso.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int filaSeleccionada = Curso_tablaCurso.getSelectedRow();
                if (filaSeleccionada >= 0) {
                    //variables declaradas arriba fuera del metodo para usarla luego. GUARDA EL CURSO SELECCIONADO
                    cursoSeleccionadoEliminarCurso_Curso = Curso_tablaCurso.getValueAt(filaSeleccionada, 0).toString();
                    cursoSeleccionadoEliminarCurso_Asignatura = Curso_tablaCurso.getValueAt(filaSeleccionada, 1).toString();                   
                }
            }
        });
    }    
    
//MOUSE LISTENER PARA TOMAR DATOS DE TABLA CURSOS
    private void MouseListenerSeleccionarCurso_AgregarEstudiante() {
        Curso_tablaCursoEstudiantes.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int filaSeleccionada = Curso_tablaCursoEstudiantes.getSelectedRow();
                if (filaSeleccionada >= 0) {
                    //variables declaradas arriba fuera del metodo para usarla luego. GUARDA EL CURSO SELECCIONADO
                    cursoSeleccionadoAgregarEstudiante_Curso = Curso_tablaCursoEstudiantes.getValueAt(filaSeleccionada, 0).toString();
                    cursoSeleccionadoAgregarEstudiante_Asignatura = Curso_tablaCursoEstudiantes.getValueAt(filaSeleccionada, 1).toString(); 
                    
                    
                    //PASARLO A BOTON
                    GestorCursos gestorC = new GestorCursos();
                    cursoID = gestorC.buscarIDCurso(curso_ClaseyGrupo, asignatura);
                    System.out.println(cursoID);
                }
            }
        });
    }    
   

    
// ===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===    
    





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
    private javax.swing.JButton Cuenta_botonBuscar;
    private javax.swing.JButton Cuenta_botonEliminar;
    private javax.swing.JLabel Cuenta_crear_apellido;
    private javax.swing.JLabel Cuenta_crear_asignatura;
    private javax.swing.JButton Cuenta_crear_botonCrearCuenta;
    private javax.swing.JLabel Cuenta_crear_cargo;
    private javax.swing.JLabel Cuenta_crear_cedula;
    private javax.swing.JLabel Cuenta_crear_contrasenia;
    private javax.swing.JLabel Cuenta_crear_grado;
    private javax.swing.JLabel Cuenta_crear_nombre;
    private javax.swing.JComboBox<String> Cuenta_crear_opcionesAsignatura;
    private javax.swing.JComboBox<String> Cuenta_crear_opcionesCargo;
    private javax.swing.JComboBox<String> Cuenta_crear_opcionesGrado;
    private javax.swing.JTextField Cuenta_crear_textoApellido;
    private javax.swing.JTextField Cuenta_crear_textoCedula;
    private javax.swing.JPasswordField Cuenta_crear_textoContrasenia;
    private javax.swing.JTextField Cuenta_crear_textoNombre;
    private javax.swing.JTextField Cuenta_crear_textoUsuario;
    private javax.swing.JLabel Cuenta_crear_usuario;
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
    private javax.swing.JTable Cuenta_tablaUsuario;
    private javax.swing.JScrollPane Cuenta_tablaUsuarios;
    private javax.swing.JButton Curso_crear_agregarEstudiante;
    private javax.swing.JLabel Curso_crear_asignatura;
    private javax.swing.JButton Curso_crear_botonCrearCurso;
    private javax.swing.JButton Curso_crear_botonEliminarCurso;
    private javax.swing.JLabel Curso_crear_clase;
    private javax.swing.JLabel Curso_crear_grupo;
    private javax.swing.JComboBox<String> Curso_crear_opcionesAsignatura;
    private javax.swing.JComboBox<String> Curso_crear_opcionesClase;
    private javax.swing.JComboBox<String> Curso_crear_opcionesGrupo;
    private javax.swing.JButton Curso_crear_quitarEstudiante;
    private javax.swing.JLabel Curso_crear_textoAsignarDocente;
    private javax.swing.JLabel Curso_crear_textoEstudiantes;
    private javax.swing.JLabel Curso_crear_textoEstudiantes1;
    private javax.swing.JLabel Curso_crear_textoSeleccionarCursoEstudiantes;
    private javax.swing.JTable Curso_tablaCurso;
    private javax.swing.JTable Curso_tablaCursoEstudiantes;
    private javax.swing.JScrollPane Curso_tablaCursos;
    private javax.swing.JScrollPane Curso_tablaCursos2;
    private javax.swing.JTable Curso_tablaDocente;
    private javax.swing.JScrollPane Curso_tablaDocentes;
    private javax.swing.JScrollPane Curso_tablaEstudiantes;
    private javax.swing.JScrollPane Curso_tablaEstudiantes1;
    private javax.swing.JPanel Estudiantes;
    private javax.swing.JPanel agregarCurso;
    private javax.swing.JPanel banner;
    private javax.swing.JLabel bienvenidaUsuario;
    private javax.swing.JButton botonCerrarSesion;
    private javax.swing.JButton botonGestionActividades;
    private javax.swing.JButton botonGestionCuentas;
    private javax.swing.JButton botonGestionCursos;
    private javax.swing.JPanel crearCuenta;
    private javax.swing.JLabel cursosRegistrados;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel logoSDFA;
    private javax.swing.JPanel modificarCuenta;
    private javax.swing.JPanel modificarCurso;
    private javax.swing.JTabbedPane opcionesCuentas;
    private javax.swing.JTabbedPane opcionesCursos;
    private javax.swing.JPanel panelAdministrador;
    private javax.swing.JPanel panelOpciones;
    private javax.swing.JTabbedPane panelPestañas;
    private javax.swing.JPanel pestaña0_Cuentas;
    private javax.swing.JPanel pestaña1_Cursos;
    private javax.swing.JPanel pestaña2;
    private javax.swing.JPanel pestaña3;
    private javax.swing.JPanel pestañaBienvenida;
    private javax.swing.JSeparator separador;
    private javax.swing.JTable tablaEstudiante_Agregar;
    private javax.swing.JTable tablaEstudiante_Quitar;
    // End of variables declaration//GEN-END:variables
}
