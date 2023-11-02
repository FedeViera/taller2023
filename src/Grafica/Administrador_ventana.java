package Grafica;


import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;


import Entidades.Estudiante;
import Logica.GestorActividades;
import Logica.GestorAdministradores;
import Logica.GestorAdscriptos;
import Logica.GestorClases;
import Logica.GestorCursos;
import Logica.GestorDocentes;
import Logica.GestorUsuarios;
import Logica.GestorEstudiantes;
import Logica.GestorRelacional;
import java.awt.event.MouseEvent;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;




public class Administrador_ventana extends javax.swing.JFrame 
{
    final Integer DebenDictar = 80;
   
    private DefaultTableModel model;  
    private String asignaturaDocente, gradoDocente;
    private Integer docenteSeleccionadoAgregarACurso; //VARIABLE USADA EN MouseListenerDocentesPorAsignatura() PARA GUARDAR DOCENTE
    private String cursoSeleccionadoEliminarCurso_Curso, cursoSeleccionadoEliminarCurso_Asignatura; //VARIABLES USADA EN MouseListenerEliminarCurso() PARA GUARDAR CURSO Y ASIGNATURA A BORRAR
    private String cursoSeleccionadoAgregarEstudiante_Curso, cursoSeleccionadoAgregarEstudiante_Asignatura; //VARIABLE USADA EN MouseListenerSeleccionarCurso_AgregarEstudiante() PARA GUARDAR CURSO Y ASIGNATURA AL AGREGAR ESTUDIANTE A CURSO
    private String cursoSeleccionadoAgregarActividad_Curso, cursoSeleccionadoAgregarActividad_Asignatura; //VARIABLES USADAS EN MouseListenerSeleccionarCurso_AgregarActividad(); PARA GUARDAR CURSO Y ASIGNATURA AL COMPLETAR TABLA ESTUDIANTES Y LUEGO AGREGAR ACTIVIDAD
    private Integer cursoID = 0;//VARIABLE GUARDA ID CURSO SELECCIONADO      
    private Integer estudianteSeleccionadoAgregar_Actividad; //VARIABLE ESTUDIANTE SELECCIONADO PARA ASIGNARLE ACTIVIDAD
    private String cursoSeleccionadoModificarActividad_Curso, cursoSeleccionadoModificarActividad_Asignatura; //VARIABLE CURSO SELECCIONADO PARA MODIFICAR ACTIVIDAD
    private Integer estudianteSeleccionado_cargarActividades; //VARIABLE ESTUDIANTE SELECCIONADO PARA TRAER ACTIVIDADES
    private Integer idActividad_modificarActividad;
    private String cursoSeleccionadoAgregarClase_Curso, cursoSeleccionadoAgregarClase_Asignatura; //VARIABLE CURSO SELECCIONADO PARA CREAR CLASE
    private String cursoSeleccionadoEliminarClase_Curso, cursoSeleccionadoEliminarClase_Asignatura; //VARIABLE CURSO SELECCIONADO PARA ELIMINAR CLASE
    private Integer claseSeleccionadaEliminarClase_ID;
    private Integer docenteSeleccionadoModificar_Cedula;
    
                    
    
    public Administrador_ventana() {
        initComponents();
        
        //Iniciamos todos los MouseListener para que se pueda interactuar con las JTable
        MouseListenerSeleccionarUsuario_verUsuario();
        MouseListenerSeleccionarDocente_paraCrearCurso(); //Seleccionar docentes por asignatura
        MouseListenerSeleccionarCurso_Eliminar(); //Seleccionar curso para eliminarlo
        MouseListenerSeleccionarCurso_AsignarDocente_CursoVacio(); //Seleccionar un curso para VACIO para agregarle docente
        MouseListenerSeleccionarCurso_verEstudiantes_Curso(); //Seleccionar curso para Agregar Estudiante a un Curso
        MouseListenerSeleccionarCurso_verEstudiantes_Actividades(); //Seleccionar Curso y cargar Estudiantes (para luego asignar actividad)
        MouseListenerSeleccionarEstudiantes_crearActividad(); //Seleccionar estudiantes para Agregar Actividad
        MouseListenerSeleccionarEstudiantes_ModificarActividad(); //Seleccionar estudiantes para Modificar Actividad
        MouseListenerSeleccionarEstudiantes_verActividades(); //Seleccionar estudiantes para Ver sus Actividades
        MouseListenerSeleccionarActividades(); //Seleccionar Actividades
        MouseListenerSeleccionarEstudiantes_Calificaciones(); //Seleccionar estudiantes para Ver Calificaciones
        MouseListenerSeleccionarCurso_crearClase();
        MouseListenerSeleccionarCurso_eliminarClase();
        MouseListenerSeleccionarClase_eliminarClase();
        
        MouseListenerVerCalificacionesCompleto();
        MouseListenerVerDesarrolloCompleto();
        
        
        
        //Precargamos tablaCursos
        GestorCursos gestorC = new GestorCursos();
        gestorC.cargarCursosDesdeBD();
        gestorC.cargarTablaCursosFull(modificarCurso_TablaCursos);
        gestorC.cargarTablaCursosFull(modificarEstudiantes_TablaCursos);
        gestorC.cargarTablaCursosFull(crearActividad_TablaCursos);
        gestorC.cargarTablaCursosFull(modificarActividad_TablaCursos);
        gestorC.cargarTablaCursosFull(calificaciones_TablaCursos);
        gestorC.cargarTablaCursosFull(crearClase_TablaCursos);
        gestorC.cargarTablaCursosFull(eliminarClase_TablaCursos);
        
        
        //Precargamos tablaEstudiantes
        GestorEstudiantes gestorE = new GestorEstudiantes();
        gestorE.cargarTablaEstudiantes(tablaEstudiante_Agregar);
        
        
        this.setTitle("SDFA - Panel Administrador"); //Titulo de la ventana
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/logoPNG.png")).getImage()); //Logo de la ventana
       
            
        // DocumentListener - Validar el campo en tiempo real en Crear Cuentas
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
        botonGestionClases = new javax.swing.JButton();
        panelPestañas = new javax.swing.JTabbedPane();
        pestañaBienvenida = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
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
        tabla1 = new javax.swing.JScrollPane();
        modificarCuenta_TablaCuentas = new javax.swing.JTable();
        pestaña1_Cursos = new javax.swing.JPanel();
        opcionesCursos = new javax.swing.JTabbedPane();
        crearCurso = new javax.swing.JPanel();
        Curso_crear_clase = new javax.swing.JLabel();
        Curso_crear_opcionesClase = new javax.swing.JComboBox<>();
        Curso_crear_grupo = new javax.swing.JLabel();
        Curso_crear_opcionesGrupo = new javax.swing.JComboBox<>();
        Curso_crear_asignatura = new javax.swing.JLabel();
        Curso_crear_opcionesAsignatura = new javax.swing.JComboBox<>();
        Curso_crear_botonCrearCurso = new javax.swing.JButton();
        tabla2 = new javax.swing.JScrollPane();
        crearCurso_TablaDocentes = new javax.swing.JTable();
        Curso_crear_textoAsignarDocente = new javax.swing.JLabel();
        modificarCurso = new javax.swing.JPanel();
        cursosRegistrados = new javax.swing.JLabel();
        tabla3 = new javax.swing.JScrollPane();
        modificarCurso_TablaCursos = new javax.swing.JTable();
        Curso_modificar_botonEliminarCurso = new javax.swing.JButton();
        tabla15 = new javax.swing.JScrollPane();
        modificarCurso_TablaDocentes = new javax.swing.JTable();
        Curso_modificar_botonModificarDocente = new javax.swing.JButton();
        modificarEstudiantes = new javax.swing.JPanel();
        tabla4 = new javax.swing.JScrollPane();
        modificarEstudiantes_TablaCursos = new javax.swing.JTable();
        tabla5 = new javax.swing.JScrollPane();
        tablaEstudiante_Agregar = new javax.swing.JTable();
        tabla6 = new javax.swing.JScrollPane();
        tablaEstudiante_Quitar = new javax.swing.JTable();
        Curso_crear_textoSeleccionarCursoEstudiantes = new javax.swing.JLabel();
        Curso_crear_textoEstudiantes = new javax.swing.JLabel();
        Curso_crear_botonAgregarEstudiante = new javax.swing.JButton();
        Curso_crear_botonQuitarEstudiante = new javax.swing.JButton();
        Curso_crear_textoEstudiantes1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        indicadorCurso = new javax.swing.JLabel();
        indicadorCurso1A = new javax.swing.JLabel();
        pestaña2_Actividades = new javax.swing.JPanel();
        opcionesActividades = new javax.swing.JTabbedPane();
        crearActividad = new javax.swing.JPanel();
        Actividad_textoSeleccionarCursoActividades = new javax.swing.JLabel();
        tabla7 = new javax.swing.JScrollPane();
        crearActividad_TablaCursos = new javax.swing.JTable();
        Actividad_textoTipoActividad = new javax.swing.JLabel();
        tabla8 = new javax.swing.JScrollPane();
        CrearActividad_tablaEstudiantes = new javax.swing.JTable();
        Actividad_crear_tipoActividad = new javax.swing.JComboBox<>();
        Actividad_textoSeleccionarEstudianteActividad = new javax.swing.JLabel();
        Actividad_textoFecha = new javax.swing.JLabel();
        txtFecha = new com.toedter.calendar.JDateChooser();
        Actividad_textoDescripcion = new javax.swing.JLabel();
        Actividad_crear_botonAgregarActividad = new javax.swing.JButton();
        Actividad_textoCalificacion = new javax.swing.JLabel();
        Actividad_calificacion = new javax.swing.JTextField();
        indicadorCurso2A = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        descripcionActividad = new javax.swing.JTextArea();
        modificarActividad = new javax.swing.JPanel();
        tabla9 = new javax.swing.JScrollPane();
        modificarActividad_TablaCursos = new javax.swing.JTable();
        tabla10 = new javax.swing.JScrollPane();
        modificarActividad_TablaEstudiantes = new javax.swing.JTable();
        tabla11 = new javax.swing.JScrollPane();
        modificarActividad_TablaActividades = new javax.swing.JTable();
        Actividad_crear_botonModificarActividad = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        Actividad_textoSeleccionarCursoActividades_modificar = new javax.swing.JLabel();
        Actividad_textoSeleccionarActividad_modificar = new javax.swing.JLabel();
        Actividad_textoSeleccionarEstudianteActividad_modificar1 = new javax.swing.JLabel();
        Actividad_textoTipoActividad1 = new javax.swing.JLabel();
        Actividad_textoFecha1 = new javax.swing.JLabel();
        txtFecha_modificar = new com.toedter.calendar.JDateChooser();
        Actividad_textoDescripcion1 = new javax.swing.JLabel();
        Actividad_crear_botonEliminarActividad = new javax.swing.JButton();
        Actividad_calificacion_modificar = new javax.swing.JTextField();
        Actividad_textoCalificacion_miodificar = new javax.swing.JLabel();
        Actividad_modificar_tipoActividad = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        DescripcionActividad_modificar = new javax.swing.JTextArea();
        verActividades = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCalificaciones = new javax.swing.JTable();
        Actividad_textoSeleccionarCursoActividades_calificaciones = new javax.swing.JLabel();
        tabla12 = new javax.swing.JScrollPane();
        calificaciones_TablaCursos = new javax.swing.JTable();
        Actividad_textoSeleccionarCursoActividades_calificaciones1 = new javax.swing.JLabel();
        indicadorCusoB = new javax.swing.JLabel();
        pestaña3_Clases = new javax.swing.JPanel();
        opcionesClases = new javax.swing.JTabbedPane();
        crearClase = new javax.swing.JPanel();
        Clase_textoFecha = new javax.swing.JLabel();
        txtFecha_Clase = new com.toedter.calendar.JDateChooser();
        ActividadClase_textoDescripcion = new javax.swing.JLabel();
        Clase_crear_botonCrearClase = new javax.swing.JButton();
        Clase_textoSeleccionarCursoClases = new javax.swing.JLabel();
        tabla13 = new javax.swing.JScrollPane();
        crearClase_TablaCursos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        desarrolloClase = new javax.swing.JTextArea();
        eliminarClase = new javax.swing.JPanel();
        tablaClase = new javax.swing.JScrollPane();
        tablaClases = new javax.swing.JTable();
        Clase_eliminar_botonEliminarClase = new javax.swing.JButton();
        Clase_textoSeleccionarClases = new javax.swing.JLabel();
        tabla14 = new javax.swing.JScrollPane();
        eliminarClase_TablaCursos = new javax.swing.JTable();
        Clase_textoSeleccionarCursoClases1 = new javax.swing.JLabel();
        numeroClasesDictadas = new javax.swing.JLabel();
        clasesDictadas = new javax.swing.JLabel();
        clasesNoDictadas = new javax.swing.JLabel();
        numeroClasesNoDictadas = new javax.swing.JLabel();

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
        botonCerrarSesion.setText("Cerrar Sesión");
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

        botonGestionClases.setBackground(new java.awt.Color(52, 80, 86));
        botonGestionClases.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        botonGestionClases.setForeground(new java.awt.Color(204, 204, 204));
        botonGestionClases.setText("    Gestión de Clases");
        botonGestionClases.setBorder(null);
        botonGestionClases.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonGestionClases.setFocusPainted(false);
        botonGestionClases.setFocusable(false);
        botonGestionClases.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        botonGestionClases.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        botonGestionClases.setIconTextGap(10);
        botonGestionClases.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonGestionClasesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonGestionClasesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonGestionClasesMouseExited(evt);
            }
        });
        botonGestionClases.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGestionClasesActionPerformed(evt);
            }
        });
        botonGestionClases.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botonGestionClasesKeyPressed(evt);
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
                    .addComponent(botonGestionClases, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addComponent(botonGestionClases, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 232, Short.MAX_VALUE)
                .addComponent(botonCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelAdministrador.add(panelOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 670));

        pestañaBienvenida.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoPNG.png"))); // NOI18N

        javax.swing.GroupLayout pestañaBienvenidaLayout = new javax.swing.GroupLayout(pestañaBienvenida);
        pestañaBienvenida.setLayout(pestañaBienvenidaLayout);
        pestañaBienvenidaLayout.setHorizontalGroup(
            pestañaBienvenidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pestañaBienvenidaLayout.createSequentialGroup()
                .addGap(379, 379, 379)
                .addComponent(jLabel1)
                .addContainerGap(393, Short.MAX_VALUE))
        );
        pestañaBienvenidaLayout.setVerticalGroup(
            pestañaBienvenidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pestañaBienvenidaLayout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(jLabel1)
                .addContainerGap(183, Short.MAX_VALUE))
        );

        panelPestañas.addTab("tab0", pestañaBienvenida);

        pestaña0_Cuentas.setBackground(new java.awt.Color(255, 255, 255));
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
                                        .addGap(0, 0, Short.MAX_VALUE)
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
                    .addGroup(crearCuentaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Cuenta_crear_contrasenia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Cuenta_crear_textoContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(357, 357, 357))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, crearCuentaLayout.createSequentialGroup()
                        .addGroup(crearCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, crearCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
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
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, crearCuentaLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(Cuenta_crear_botonCrearCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                        .addGap(40, 40, 40)
                        .addComponent(Cuenta_crear_botonCrearCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
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

        modificarCuenta_TablaCuentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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
        modificarCuenta_TablaCuentas.getTableHeader().setReorderingAllowed(false);
        tabla1.setViewportView(modificarCuenta_TablaCuentas);

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
                            .addComponent(tabla1, javax.swing.GroupLayout.Alignment.LEADING)
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
                .addComponent(tabla1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        pestaña1_Cursos.setBackground(new java.awt.Color(255, 255, 255));

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

        crearCurso.setBackground(new java.awt.Color(255, 255, 255));

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

        crearCurso_TablaDocentes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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
        tabla2.setViewportView(crearCurso_TablaDocentes);

        Curso_crear_textoAsignarDocente.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        Curso_crear_textoAsignarDocente.setForeground(new java.awt.Color(0, 0, 0));
        Curso_crear_textoAsignarDocente.setText("Asignar un docente al curso:");

        javax.swing.GroupLayout crearCursoLayout = new javax.swing.GroupLayout(crearCurso);
        crearCurso.setLayout(crearCursoLayout);
        crearCursoLayout.setHorizontalGroup(
            crearCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(crearCursoLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(crearCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(crearCursoLayout.createSequentialGroup()
                        .addComponent(Curso_crear_asignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Curso_crear_opcionesAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Curso_crear_botonCrearCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(crearCursoLayout.createSequentialGroup()
                        .addComponent(Curso_crear_grupo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Curso_crear_opcionesGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(crearCursoLayout.createSequentialGroup()
                        .addComponent(Curso_crear_clase, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Curso_crear_opcionesClase, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Curso_crear_textoAsignarDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tabla2, javax.swing.GroupLayout.PREFERRED_SIZE, 885, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        crearCursoLayout.setVerticalGroup(
            crearCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(crearCursoLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(crearCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Curso_crear_clase, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Curso_crear_opcionesClase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(crearCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Curso_crear_grupo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Curso_crear_opcionesGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(crearCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Curso_crear_asignatura, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Curso_crear_opcionesAsignatura, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(Curso_crear_textoAsignarDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabla2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Curso_crear_botonCrearCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        opcionesCursos.addTab("Crear Curso", crearCurso);

        modificarCurso.setBackground(new java.awt.Color(255, 255, 255));

        cursosRegistrados.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        cursosRegistrados.setForeground(new java.awt.Color(0, 0, 0));
        cursosRegistrados.setText("Cursos registrados:");

        modificarCurso_TablaCursos.setModel(new javax.swing.table.DefaultTableModel(
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
        tabla3.setViewportView(modificarCurso_TablaCursos);

        Curso_modificar_botonEliminarCurso.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Curso_modificar_botonEliminarCurso.setText("Eliminar curso");
        Curso_modificar_botonEliminarCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Curso_modificar_botonEliminarCursoActionPerformed(evt);
            }
        });

        modificarCurso_TablaDocentes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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
        tabla15.setViewportView(modificarCurso_TablaDocentes);

        Curso_modificar_botonModificarDocente.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Curso_modificar_botonModificarDocente.setText("Reasignar Docente");
        Curso_modificar_botonModificarDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Curso_modificar_botonModificarDocenteActionPerformed(evt);
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
                        .addGroup(modificarCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tabla3, javax.swing.GroupLayout.DEFAULT_SIZE, 907, Short.MAX_VALUE)
                            .addComponent(Curso_modificar_botonEliminarCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Curso_modificar_botonModificarDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tabla15))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        modificarCursoLayout.setVerticalGroup(
            modificarCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modificarCursoLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(cursosRegistrados, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabla3, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Curso_modificar_botonEliminarCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tabla15, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Curso_modificar_botonModificarDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        opcionesCursos.addTab("Modificar Curso", modificarCurso);

        modificarEstudiantes.setBackground(new java.awt.Color(255, 255, 255));

        modificarEstudiantes_TablaCursos.setModel(new javax.swing.table.DefaultTableModel(
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
        modificarEstudiantes_TablaCursos.getTableHeader().setReorderingAllowed(false);
        tabla4.setViewportView(modificarEstudiantes_TablaCursos);

        tablaEstudiante_Agregar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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
        tablaEstudiante_Agregar.getTableHeader().setReorderingAllowed(false);
        tabla5.setViewportView(tablaEstudiante_Agregar);

        tablaEstudiante_Quitar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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
        tablaEstudiante_Quitar.getTableHeader().setReorderingAllowed(false);
        tabla6.setViewportView(tablaEstudiante_Quitar);

        Curso_crear_textoSeleccionarCursoEstudiantes.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Curso_crear_textoSeleccionarCursoEstudiantes.setForeground(new java.awt.Color(0, 0, 0));
        Curso_crear_textoSeleccionarCursoEstudiantes.setText("Seleccionar curso:");

        Curso_crear_textoEstudiantes.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Curso_crear_textoEstudiantes.setForeground(new java.awt.Color(0, 0, 0));
        Curso_crear_textoEstudiantes.setText("Seleccionar estudiantes:");

        Curso_crear_botonAgregarEstudiante.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Curso_crear_botonAgregarEstudiante.setText("Agregar");
        Curso_crear_botonAgregarEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Curso_crear_botonAgregarEstudianteActionPerformed(evt);
            }
        });

        Curso_crear_botonQuitarEstudiante.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Curso_crear_botonQuitarEstudiante.setText("Quitar");
        Curso_crear_botonQuitarEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Curso_crear_botonQuitarEstudianteActionPerformed(evt);
            }
        });

        Curso_crear_textoEstudiantes1.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Curso_crear_textoEstudiantes1.setForeground(new java.awt.Color(0, 0, 0));
        Curso_crear_textoEstudiantes1.setText("Lista de estudiantes que integran:");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        indicadorCurso.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        indicadorCurso.setForeground(new java.awt.Color(102, 102, 102));
        indicadorCurso.setText("Lista estudiantes general");

        indicadorCurso1A.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        indicadorCurso1A.setForeground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout modificarEstudiantesLayout = new javax.swing.GroupLayout(modificarEstudiantes);
        modificarEstudiantes.setLayout(modificarEstudiantesLayout);
        modificarEstudiantesLayout.setHorizontalGroup(
            modificarEstudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modificarEstudiantesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(modificarEstudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Curso_crear_textoSeleccionarCursoEstudiantes, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(modificarEstudiantesLayout.createSequentialGroup()
                        .addGroup(modificarEstudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tabla5, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                            .addComponent(Curso_crear_botonAgregarEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(indicadorCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Curso_crear_textoEstudiantes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(modificarEstudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tabla6, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Curso_crear_botonQuitarEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(modificarEstudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(Curso_crear_textoEstudiantes1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(indicadorCurso1A, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(tabla4, javax.swing.GroupLayout.PREFERRED_SIZE, 891, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        modificarEstudiantesLayout.setVerticalGroup(
            modificarEstudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modificarEstudiantesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Curso_crear_textoSeleccionarCursoEstudiantes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabla4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(modificarEstudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(modificarEstudiantesLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(modificarEstudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Curso_crear_textoEstudiantes, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Curso_crear_textoEstudiantes1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(modificarEstudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(indicadorCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(indicadorCurso1A, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(modificarEstudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tabla5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tabla6, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(modificarEstudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(modificarEstudiantesLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Curso_crear_botonQuitarEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(modificarEstudiantesLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Curso_crear_botonAgregarEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, modificarEstudiantesLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        opcionesCursos.addTab("Agregar/Quitar Estudiantes", modificarEstudiantes);

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

        pestaña2_Actividades.setBackground(new java.awt.Color(255, 255, 255));

        opcionesActividades.setBackground(new java.awt.Color(255, 255, 255));
        opcionesActividades.setForeground(new java.awt.Color(0, 0, 0));
        opcionesActividades.setToolTipText("");
        opcionesActividades.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        opcionesActividades.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        opcionesActividades.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                opcionesActividadesStateChanged(evt);
            }
        });

        crearActividad.setBackground(new java.awt.Color(255, 255, 255));

        Actividad_textoSeleccionarCursoActividades.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Actividad_textoSeleccionarCursoActividades.setForeground(new java.awt.Color(0, 0, 0));
        Actividad_textoSeleccionarCursoActividades.setText("Seleccionar curso:");

        crearActividad_TablaCursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Curso", "Asignatura", "Cédula Docente", "Nombre", "Apellido"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        crearActividad_TablaCursos.getTableHeader().setReorderingAllowed(false);
        tabla7.setViewportView(crearActividad_TablaCursos);

        Actividad_textoTipoActividad.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Actividad_textoTipoActividad.setForeground(new java.awt.Color(0, 0, 0));
        Actividad_textoTipoActividad.setText("Tipo ");

        CrearActividad_tablaEstudiantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cédula", "Nombre", "Apellido", "Edad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        CrearActividad_tablaEstudiantes.getTableHeader().setReorderingAllowed(false);
        tabla8.setViewportView(CrearActividad_tablaEstudiantes);

        Actividad_crear_tipoActividad.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Actividad_crear_tipoActividad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Actividad", "Evaluación", "Orales" }));
        Actividad_crear_tipoActividad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Actividad_crear_tipoActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Actividad_crear_tipoActividadActionPerformed(evt);
            }
        });

        Actividad_textoSeleccionarEstudianteActividad.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Actividad_textoSeleccionarEstudianteActividad.setForeground(new java.awt.Color(0, 0, 0));
        Actividad_textoSeleccionarEstudianteActividad.setText("Seleccionar un estudiante:");

        Actividad_textoFecha.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Actividad_textoFecha.setForeground(new java.awt.Color(0, 0, 0));
        Actividad_textoFecha.setText("Fecha");

        txtFecha.setDateFormatString("yyyy-MM-dd");

        Actividad_textoDescripcion.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Actividad_textoDescripcion.setForeground(new java.awt.Color(0, 0, 0));
        Actividad_textoDescripcion.setText("Descripción");

        Actividad_crear_botonAgregarActividad.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Actividad_crear_botonAgregarActividad.setText("Agregar");
        Actividad_crear_botonAgregarActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Actividad_crear_botonAgregarActividadActionPerformed(evt);
            }
        });

        Actividad_textoCalificacion.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Actividad_textoCalificacion.setForeground(new java.awt.Color(0, 0, 0));
        Actividad_textoCalificacion.setText("Calificación");

        Actividad_calificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Actividad_calificacionActionPerformed(evt);
            }
        });

        indicadorCurso2A.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        indicadorCurso2A.setForeground(new java.awt.Color(102, 102, 102));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        descripcionActividad.setColumns(20);
        descripcionActividad.setLineWrap(true);
        descripcionActividad.setRows(5);
        jScrollPane3.setViewportView(descripcionActividad);

        javax.swing.GroupLayout crearActividadLayout = new javax.swing.GroupLayout(crearActividad);
        crearActividad.setLayout(crearActividadLayout);
        crearActividadLayout.setHorizontalGroup(
            crearActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, crearActividadLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(crearActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(crearActividadLayout.createSequentialGroup()
                        .addGroup(crearActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Actividad_textoSeleccionarEstudianteActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(indicadorCurso2A, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tabla8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(crearActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(crearActividadLayout.createSequentialGroup()
                                .addGroup(crearActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Actividad_textoFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Actividad_textoTipoActividad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(72, 72, 72)
                                .addGroup(crearActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Actividad_crear_tipoActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(crearActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(crearActividadLayout.createSequentialGroup()
                                    .addGap(127, 127, 127)
                                    .addComponent(jScrollPane3))
                                .addGroup(crearActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Actividad_textoDescripcion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(crearActividadLayout.createSequentialGroup()
                                        .addComponent(Actividad_textoCalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Actividad_calificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(89, 89, 89)
                                        .addComponent(Actividad_crear_botonAgregarActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(23, 23, 23))
                    .addGroup(crearActividadLayout.createSequentialGroup()
                        .addGroup(crearActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Actividad_textoSeleccionarCursoActividades, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tabla7, javax.swing.GroupLayout.PREFERRED_SIZE, 914, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))))
        );
        crearActividadLayout.setVerticalGroup(
            crearActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(crearActividadLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Actividad_textoSeleccionarCursoActividades, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabla7, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(crearActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(crearActividadLayout.createSequentialGroup()
                        .addGroup(crearActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2)
                            .addGroup(crearActividadLayout.createSequentialGroup()
                                .addComponent(Actividad_textoSeleccionarEstudianteActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(indicadorCurso2A, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tabla8, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 12, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(crearActividadLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(crearActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Actividad_crear_tipoActividad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Actividad_textoTipoActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(crearActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Actividad_textoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(crearActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(crearActividadLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Actividad_textoDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(crearActividadLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(crearActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Actividad_calificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Actividad_textoCalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Actividad_crear_botonAgregarActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5))))
        );

        opcionesActividades.addTab("Crear Actividad", crearActividad);

        modificarActividad.setBackground(new java.awt.Color(255, 255, 255));

        modificarActividad_TablaCursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Curso", "Asignatura", "Cédula", "Nombre", "Apellido"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        modificarActividad_TablaCursos.getTableHeader().setReorderingAllowed(false);
        tabla9.setViewportView(modificarActividad_TablaCursos);

        modificarActividad_TablaEstudiantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cédula", "Nombre", "Apellido", "Edad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        modificarActividad_TablaEstudiantes.getTableHeader().setReorderingAllowed(false);
        tabla10.setViewportView(modificarActividad_TablaEstudiantes);

        modificarActividad_TablaActividades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Estudiante", "Tipo", "Descripción", "Calificación", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        modificarActividad_TablaActividades.getTableHeader().setReorderingAllowed(false);
        tabla11.setViewportView(modificarActividad_TablaActividades);
        if (modificarActividad_TablaActividades.getColumnModel().getColumnCount() > 0) {
            modificarActividad_TablaActividades.getColumnModel().getColumn(0).setPreferredWidth(25);
            modificarActividad_TablaActividades.getColumnModel().getColumn(3).setPreferredWidth(120);
        }

        Actividad_crear_botonModificarActividad.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Actividad_crear_botonModificarActividad.setText("Modificar");
        Actividad_crear_botonModificarActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Actividad_crear_botonModificarActividadActionPerformed(evt);
            }
        });

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        Actividad_textoSeleccionarCursoActividades_modificar.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Actividad_textoSeleccionarCursoActividades_modificar.setForeground(new java.awt.Color(0, 0, 0));
        Actividad_textoSeleccionarCursoActividades_modificar.setText("Seleccionar curso:");

        Actividad_textoSeleccionarActividad_modificar.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Actividad_textoSeleccionarActividad_modificar.setForeground(new java.awt.Color(0, 0, 0));
        Actividad_textoSeleccionarActividad_modificar.setText("Seleccionar actividad:");

        Actividad_textoSeleccionarEstudianteActividad_modificar1.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Actividad_textoSeleccionarEstudianteActividad_modificar1.setForeground(new java.awt.Color(0, 0, 0));
        Actividad_textoSeleccionarEstudianteActividad_modificar1.setText("Seleccionar un estudiante:");

        Actividad_textoTipoActividad1.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Actividad_textoTipoActividad1.setForeground(new java.awt.Color(0, 0, 0));
        Actividad_textoTipoActividad1.setText("Tipo ");

        Actividad_textoFecha1.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Actividad_textoFecha1.setForeground(new java.awt.Color(0, 0, 0));
        Actividad_textoFecha1.setText("Fecha");

        txtFecha_modificar.setDateFormatString("yyyy-MM-dd");

        Actividad_textoDescripcion1.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Actividad_textoDescripcion1.setForeground(new java.awt.Color(0, 0, 0));
        Actividad_textoDescripcion1.setText("Descripción");

        Actividad_crear_botonEliminarActividad.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Actividad_crear_botonEliminarActividad.setText("Eliminar");
        Actividad_crear_botonEliminarActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Actividad_crear_botonEliminarActividadActionPerformed(evt);
            }
        });

        Actividad_calificacion_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Actividad_calificacion_modificarActionPerformed(evt);
            }
        });

        Actividad_textoCalificacion_miodificar.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Actividad_textoCalificacion_miodificar.setForeground(new java.awt.Color(0, 0, 0));
        Actividad_textoCalificacion_miodificar.setText("Calificación");

        Actividad_modificar_tipoActividad.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Actividad_modificar_tipoActividad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Actividad", "Evaluación", "Orales" }));
        Actividad_modificar_tipoActividad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Actividad_modificar_tipoActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Actividad_modificar_tipoActividadActionPerformed(evt);
            }
        });

        DescripcionActividad_modificar.setColumns(20);
        DescripcionActividad_modificar.setLineWrap(true);
        DescripcionActividad_modificar.setRows(5);
        jScrollPane4.setViewportView(DescripcionActividad_modificar);

        javax.swing.GroupLayout modificarActividadLayout = new javax.swing.GroupLayout(modificarActividad);
        modificarActividad.setLayout(modificarActividadLayout);
        modificarActividadLayout.setHorizontalGroup(
            modificarActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modificarActividadLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(modificarActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabla10, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tabla9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Actividad_textoSeleccionarCursoActividades_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Actividad_textoSeleccionarEstudianteActividad_modificar1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(modificarActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(modificarActividadLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(modificarActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Actividad_textoSeleccionarActividad_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tabla11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(modificarActividadLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(modificarActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(modificarActividadLayout.createSequentialGroup()
                                .addComponent(Actividad_crear_botonModificarActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Actividad_crear_botonEliminarActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(modificarActividadLayout.createSequentialGroup()
                                .addComponent(Actividad_textoCalificacion_miodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Actividad_calificacion_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(modificarActividadLayout.createSequentialGroup()
                                .addGroup(modificarActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Actividad_textoFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Actividad_textoTipoActividad1)
                                    .addComponent(Actividad_textoDescripcion1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(modificarActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, modificarActividadLayout.createSequentialGroup()
                                        .addGroup(modificarActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(Actividad_modificar_tipoActividad, javax.swing.GroupLayout.Alignment.LEADING, 0, 186, Short.MAX_VALUE)
                                            .addComponent(txtFecha_modificar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        modificarActividadLayout.setVerticalGroup(
            modificarActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modificarActividadLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(Actividad_textoSeleccionarCursoActividades_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabla9, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Actividad_textoSeleccionarEstudianteActividad_modificar1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tabla10, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
            .addGroup(modificarActividadLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(modificarActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(modificarActividadLayout.createSequentialGroup()
                        .addComponent(jSeparator3)
                        .addContainerGap())
                    .addGroup(modificarActividadLayout.createSequentialGroup()
                        .addComponent(Actividad_textoSeleccionarActividad_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tabla11, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(modificarActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Actividad_textoTipoActividad1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Actividad_modificar_tipoActividad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(modificarActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFecha_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Actividad_textoFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addGroup(modificarActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Actividad_textoDescripcion1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(modificarActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Actividad_calificacion_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Actividad_textoCalificacion_miodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(modificarActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Actividad_crear_botonEliminarActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Actividad_crear_botonModificarActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46))))
        );

        opcionesActividades.addTab("Modificar Actividad", modificarActividad);

        verActividades.setBackground(new java.awt.Color(255, 255, 255));

        tablaCalificaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido", "Calificaciones", "Promedio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaCalificaciones);
        if (tablaCalificaciones.getColumnModel().getColumnCount() > 0) {
            tablaCalificaciones.getColumnModel().getColumn(0).setPreferredWidth(90);
            tablaCalificaciones.getColumnModel().getColumn(1).setPreferredWidth(90);
            tablaCalificaciones.getColumnModel().getColumn(2).setPreferredWidth(600);
        }

        Actividad_textoSeleccionarCursoActividades_calificaciones.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Actividad_textoSeleccionarCursoActividades_calificaciones.setForeground(new java.awt.Color(0, 0, 0));
        Actividad_textoSeleccionarCursoActividades_calificaciones.setText("Seleccionar curso:");

        calificaciones_TablaCursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Curso", "Asignatura", "Cédula", "Nombre", "Apellido"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        calificaciones_TablaCursos.getTableHeader().setReorderingAllowed(false);
        tabla12.setViewportView(calificaciones_TablaCursos);

        Actividad_textoSeleccionarCursoActividades_calificaciones1.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Actividad_textoSeleccionarCursoActividades_calificaciones1.setForeground(new java.awt.Color(0, 0, 0));
        Actividad_textoSeleccionarCursoActividades_calificaciones1.setText("Calificaciones de:");

        indicadorCusoB.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        indicadorCusoB.setForeground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout verActividadesLayout = new javax.swing.GroupLayout(verActividades);
        verActividades.setLayout(verActividadesLayout);
        verActividadesLayout.setHorizontalGroup(
            verActividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(verActividadesLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(verActividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(verActividadesLayout.createSequentialGroup()
                        .addComponent(Actividad_textoSeleccionarCursoActividades_calificaciones1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(indicadorCusoB, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(verActividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tabla12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Actividad_textoSeleccionarCursoActividades_calificaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 904, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        verActividadesLayout.setVerticalGroup(
            verActividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(verActividadesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Actividad_textoSeleccionarCursoActividades_calificaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabla12, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(verActividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Actividad_textoSeleccionarCursoActividades_calificaciones1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(indicadorCusoB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        opcionesActividades.addTab("Calificaciones", verActividades);

        javax.swing.GroupLayout pestaña2_ActividadesLayout = new javax.swing.GroupLayout(pestaña2_Actividades);
        pestaña2_Actividades.setLayout(pestaña2_ActividadesLayout);
        pestaña2_ActividadesLayout.setHorizontalGroup(
            pestaña2_ActividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pestaña2_ActividadesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(opcionesActividades))
        );
        pestaña2_ActividadesLayout.setVerticalGroup(
            pestaña2_ActividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pestaña2_ActividadesLayout.createSequentialGroup()
                .addGap(0, 14, Short.MAX_VALUE)
                .addComponent(opcionesActividades, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelPestañas.addTab("tab3", pestaña2_Actividades);

        pestaña3_Clases.setBackground(new java.awt.Color(255, 255, 255));

        opcionesClases.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        opcionesClases.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                opcionesClasesStateChanged(evt);
            }
        });

        crearClase.setBackground(new java.awt.Color(255, 255, 255));

        Clase_textoFecha.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Clase_textoFecha.setForeground(new java.awt.Color(0, 0, 0));
        Clase_textoFecha.setText("Fecha");

        txtFecha_Clase.setDateFormatString("yyyy-MM-dd");

        ActividadClase_textoDescripcion.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        ActividadClase_textoDescripcion.setForeground(new java.awt.Color(0, 0, 0));
        ActividadClase_textoDescripcion.setText("Desarrollo");

        Clase_crear_botonCrearClase.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Clase_crear_botonCrearClase.setText("Agregar");
        Clase_crear_botonCrearClase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Clase_crear_botonCrearClaseActionPerformed(evt);
            }
        });

        Clase_textoSeleccionarCursoClases.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Clase_textoSeleccionarCursoClases.setForeground(new java.awt.Color(0, 0, 0));
        Clase_textoSeleccionarCursoClases.setText("Seleccionar curso:");

        crearClase_TablaCursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Curso", "Asignatura", "Cédula Docente", "Nombre", "Apellido"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        crearClase_TablaCursos.getTableHeader().setReorderingAllowed(false);
        tabla13.setViewportView(crearClase_TablaCursos);

        desarrolloClase.setColumns(20);
        desarrolloClase.setLineWrap(true);
        desarrolloClase.setRows(5);
        jScrollPane2.setViewportView(desarrolloClase);

        javax.swing.GroupLayout crearClaseLayout = new javax.swing.GroupLayout(crearClase);
        crearClase.setLayout(crearClaseLayout);
        crearClaseLayout.setHorizontalGroup(
            crearClaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(crearClaseLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(crearClaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Clase_textoSeleccionarCursoClases, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tabla13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 914, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, crearClaseLayout.createSequentialGroup()
                        .addGroup(crearClaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, crearClaseLayout.createSequentialGroup()
                                .addComponent(ActividadClase_textoDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34))
                            .addGroup(crearClaseLayout.createSequentialGroup()
                                .addComponent(Clase_textoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)))
                        .addGroup(crearClaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFecha_Clase, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 767, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Clase_crear_botonCrearClase, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        crearClaseLayout.setVerticalGroup(
            crearClaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, crearClaseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Clase_textoSeleccionarCursoClases, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabla13, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(crearClaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFecha_Clase, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Clase_textoFecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(crearClaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(crearClaseLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(ActividadClase_textoDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(crearClaseLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(Clase_crear_botonCrearClase, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        opcionesClases.addTab("Crear clase", crearClase);

        eliminarClase.setBackground(new java.awt.Color(255, 255, 255));

        tablaClases.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Clase ID", "Fecha", "Desarrollo", "Curso ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaClases.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaClasesMouseClicked(evt);
            }
        });
        tablaClase.setViewportView(tablaClases);
        if (tablaClases.getColumnModel().getColumnCount() > 0) {
            tablaClases.getColumnModel().getColumn(0).setResizable(false);
            tablaClases.getColumnModel().getColumn(0).setPreferredWidth(20);
            tablaClases.getColumnModel().getColumn(1).setResizable(false);
            tablaClases.getColumnModel().getColumn(1).setPreferredWidth(20);
            tablaClases.getColumnModel().getColumn(2).setResizable(false);
            tablaClases.getColumnModel().getColumn(2).setPreferredWidth(500);
            tablaClases.getColumnModel().getColumn(3).setResizable(false);
            tablaClases.getColumnModel().getColumn(3).setPreferredWidth(10);
        }

        Clase_eliminar_botonEliminarClase.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Clase_eliminar_botonEliminarClase.setText("Eliminar");
        Clase_eliminar_botonEliminarClase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Clase_eliminar_botonEliminarClaseActionPerformed(evt);
            }
        });

        Clase_textoSeleccionarClases.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Clase_textoSeleccionarClases.setForeground(new java.awt.Color(0, 0, 0));
        Clase_textoSeleccionarClases.setText("Seleccionar clase:");

        eliminarClase_TablaCursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Curso", "Asignatura", "Cédula Docente", "Nombre", "Apellido"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        eliminarClase_TablaCursos.getTableHeader().setReorderingAllowed(false);
        tabla14.setViewportView(eliminarClase_TablaCursos);

        Clase_textoSeleccionarCursoClases1.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Clase_textoSeleccionarCursoClases1.setForeground(new java.awt.Color(0, 0, 0));
        Clase_textoSeleccionarCursoClases1.setText("Seleccionar curso:");

        numeroClasesDictadas.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        numeroClasesDictadas.setForeground(new java.awt.Color(0, 0, 255));
        numeroClasesDictadas.setText("0");

        clasesDictadas.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        clasesDictadas.setForeground(new java.awt.Color(0, 0, 255));
        clasesDictadas.setText("Clases dictadas: ");

        clasesNoDictadas.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        clasesNoDictadas.setForeground(new java.awt.Color(0, 0, 255));
        clasesNoDictadas.setText("Clases por dictar: ");

        numeroClasesNoDictadas.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        numeroClasesNoDictadas.setForeground(new java.awt.Color(0, 0, 255));
        numeroClasesNoDictadas.setText("0");

        javax.swing.GroupLayout eliminarClaseLayout = new javax.swing.GroupLayout(eliminarClase);
        eliminarClase.setLayout(eliminarClaseLayout);
        eliminarClaseLayout.setHorizontalGroup(
            eliminarClaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eliminarClaseLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(eliminarClaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(eliminarClaseLayout.createSequentialGroup()
                        .addComponent(clasesDictadas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numeroClasesDictadas)
                        .addGap(63, 63, 63)
                        .addComponent(clasesNoDictadas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(numeroClasesNoDictadas))
                    .addGroup(eliminarClaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(tablaClase, javax.swing.GroupLayout.PREFERRED_SIZE, 913, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tabla14, javax.swing.GroupLayout.PREFERRED_SIZE, 913, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Clase_eliminar_botonEliminarClase, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Clase_textoSeleccionarCursoClases1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Clase_textoSeleccionarClases, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );
        eliminarClaseLayout.setVerticalGroup(
            eliminarClaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eliminarClaseLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(Clase_textoSeleccionarCursoClases1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tabla14, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Clase_textoSeleccionarClases, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tablaClase, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(eliminarClaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(eliminarClaseLayout.createSequentialGroup()
                        .addComponent(Clase_eliminar_botonEliminarClase, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eliminarClaseLayout.createSequentialGroup()
                        .addGroup(eliminarClaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(clasesDictadas, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numeroClasesDictadas, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clasesNoDictadas, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numeroClasesNoDictadas, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22))))
        );

        opcionesClases.addTab("Eliminar clase", eliminarClase);

        javax.swing.GroupLayout pestaña3_ClasesLayout = new javax.swing.GroupLayout(pestaña3_Clases);
        pestaña3_Clases.setLayout(pestaña3_ClasesLayout);
        pestaña3_ClasesLayout.setHorizontalGroup(
            pestaña3_ClasesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pestaña3_ClasesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(opcionesClases))
        );
        pestaña3_ClasesLayout.setVerticalGroup(
            pestaña3_ClasesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pestaña3_ClasesLayout.createSequentialGroup()
                .addGap(0, 15, Short.MAX_VALUE)
                .addComponent(opcionesClases, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelPestañas.addTab("tab4", pestaña3_Clases);

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
        cambiarEstadoBoton(botonGestionCuentas, true);
        cambiarEstadoBoton(botonGestionCursos, false);
        cambiarEstadoBoton(botonGestionActividades, false);
        cambiarEstadoBoton(botonGestionClases, false);
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
                cambiarEstadoBoton(botonGestionCuentas, false);
        cambiarEstadoBoton(botonGestionCursos, true);
        cambiarEstadoBoton(botonGestionActividades, false);
        cambiarEstadoBoton(botonGestionClases, false);
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
        cambiarEstadoBoton(botonGestionCuentas, false);
        cambiarEstadoBoton(botonGestionCursos, false);
        cambiarEstadoBoton(botonGestionActividades, true);
        cambiarEstadoBoton(botonGestionClases, false);
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
            JOptionPane.showMessageDialog(this, "La cédula debe tener 8 números.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return; // Detener la ejecución si la cédula no es válida
        }
        Integer cedula = Integer.parseInt(cedulaText);
        
        if (nombre.length() > 30 || apellido.length() > 30 || usuario.length() > 30 || contrasenia.length() > 30) {
            JOptionPane.showMessageDialog(this, "Los campos de nombre, apellido, usuario y contraseña no pueden tener más de 30 caracteres.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return; // Detiene la ejecución si la longitud es demasiado larga
        }
        
        // Validar nombre y apellido
        if (!nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ ]+$") || !apellido.matches("^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ ]+$")) {
            JOptionPane.showMessageDialog(this, "El nombre y el apellido solo pueden contener letras y ser menores a 30 caracteres.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return; // Detener la ejecución si el nombre o el apellido no son válidos
        }
        
        // Validar que el usuario y la contraseña no estén vacíos y que la contraseña no contenga espacios en blanco
        if (usuario.trim().isEmpty() || contrasenia.trim().isEmpty() || contrasenia.contains(" ")) {
            JOptionPane.showMessageDialog(this, "El usuario y la contraseña no pueden estar vacíos, y la contraseña no puede contener espacios en blanco.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return; // Detener la ejecución si el usuario o la contraseña no son válidos
        }

        
        List<Object> listaGeneral = new ArrayList<>(); // Crea una lista vacía
        GestorUsuarios gestor = new GestorUsuarios();
        listaGeneral = gestor.obtenerTodosUsuarios();
        if(!gestor.usuarioExiste(listaGeneral, cedula, usuario)){
            gestor.agregarUsuario(cedula, nombre, apellido, usuario, contrasenia, cargo); //Agrega un usuario
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
        int filaSeleccionada = modificarCuenta_TablaCuentas.getSelectedRow();
    
        if (filaSeleccionada >= 0) {
            int cedula = (int) modificarCuenta_TablaCuentas.getValueAt(filaSeleccionada, 0); // Obtenemos el ID del usuario de la tabla
            String cargo = (String) modificarCuenta_TablaCuentas.getValueAt(filaSeleccionada, 5);            
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
                gestorU.cargarTablaUsuarios(modificarCuenta_TablaCuentas); // Después de eliminar, actualizar la tabla
                
                GestorCursos gestorC = new GestorCursos();
                gestorC.cargarCursosDesdeBD();
                //Se recargan las tablas de curso con el docente Reasignado
                gestorC.cargarTablaCursosFull(modificarCurso_TablaCursos);
                gestorC.cargarTablaCursosFull(modificarEstudiantes_TablaCursos);
                gestorC.cargarTablaCursosFull(crearActividad_TablaCursos);
                gestorC.cargarTablaCursosFull(modificarActividad_TablaCursos);
                gestorC.cargarTablaCursosFull(calificaciones_TablaCursos);
                gestorC.cargarTablaCursosFull(crearClase_TablaCursos);
                gestorC.cargarTablaCursosFull(eliminarClase_TablaCursos);
            }else{
                System.out.println("Eliminación cancelada.");
            }   
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una fila de la tabla para eliminar.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_Cuenta_botonEliminarActionPerformed

//ACTUALIZAR JTable AL CAMBIAR PESATAÑA
    private void opcionesCuentasStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_opcionesCuentasStateChanged
        GestorUsuarios gestorU = new GestorUsuarios();
        gestorU.cargarTablaUsuarios(modificarCuenta_TablaCuentas); //Refresco TablaUsuarios
        
        
    }//GEN-LAST:event_opcionesCuentasStateChanged

//BOTON MODIFICAR USUARIO
    private void Cuenta_modificar_botonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cuenta_modificar_botonModificarActionPerformed
        int filaSeleccionada = modificarCuenta_TablaCuentas.getSelectedRow();
        
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
                gestorU.cargarTablaUsuarios(modificarCuenta_TablaCuentas); //Refresca tabla Usuarios
                GestorCursos gestorC = new GestorCursos();
                gestorC.cargarCursosDesdeBD();
                gestorC.cargarTablaCursosFull(modificarCurso_TablaCursos);
                gestorC.cargarTablaCursosFull(modificarEstudiantes_TablaCursos);
                gestorC.cargarTablaCursosFull(crearActividad_TablaCursos);
                gestorC.cargarTablaCursosFull(modificarActividad_TablaCursos);
                gestorC.cargarTablaCursosFull(calificaciones_TablaCursos);
                gestorC.cargarTablaCursosFull(crearClase_TablaCursos);
                gestorC.cargarTablaCursosFull(eliminarClase_TablaCursos);
              
                
                // Borra los campos de los JTextField
                Cuenta_modificar_textoCedula.setText("");
                Cuenta_modificar_textoUsuario.setText("");
                Cuenta_modificar_textoContrasenia.setText("");
            } else {
                System.out.println("Modificación cancelada.");
            }   
        } else {
        JOptionPane.showMessageDialog(this, "Seleccione una fila de la tabla para modificar.", "Aviso", JOptionPane.WARNING_MESSAGE);
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
        DefaultTableModel model = (DefaultTableModel) modificarCuenta_TablaCuentas.getModel();
        boolean encontrado = false;

        for (int row = 0; row < model.getRowCount(); row++) {
            Object cedulaValue = model.getValueAt(row, 0);
            if (cedulaValue != null && cedulaValue.toString().equalsIgnoreCase(busquedaCedula)) {
                modificarCuenta_TablaCuentas.setRowSelectionInterval(row, row);
                hacerVisibleFilaEncontrada(modificarCuenta_TablaCuentas, row, 0); //Llama a metodo para que seleccione la fila buscada en la Tabla
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
        Integer cedula = (Integer) modificarCuenta_TablaCuentas.getValueAt(fila, 0);
        String usuario = modificarCuenta_TablaCuentas.getValueAt(fila, 3).toString(); 
        String contrasenia = modificarCuenta_TablaCuentas.getValueAt(fila, 4).toString();
        String cargo = modificarCuenta_TablaCuentas.getValueAt(fila, 5).toString();

        Cuenta_modificar_textoUsuario.setText(usuario);
        Cuenta_modificar_textoContrasenia.setText(contrasenia);
        Cuenta_modificar_textoCedula.setText(cedula.toString());
        Cuenta_modificar_opcionesCargo.setSelectedItem(cargo); 

        if (cargo.equals("Docente")) {
            String grado = modificarCuenta_TablaCuentas.getValueAt(fila, 6).toString();
            Cuenta_modificar_opcionesGrado.setSelectedItem(grado); // Actualizar grado
            String asignatura = modificarCuenta_TablaCuentas.getValueAt(fila, 7).toString();
            Cuenta_modificar_opcionesAsignatura.setSelectedItem(asignatura); // Actualizar asignatura 
        } else if (cargo.equals("Adscripto")) {
            String grado = modificarCuenta_TablaCuentas.getValueAt(fila, 6).toString();
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
            JOptionPane.showMessageDialog(null, "El Curso "+claseYgrupo+" de la Asignatura "+asignatura+" ya se encuentra creado o no Selecciono ningún Docente.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        gestorCursos.cargarCursosDesdeBD();
        int idCurso1 = gestorCursos.buscarIDCurso(claseYgrupo, asignatura);  //Trae el ID del curso a partir de Clase y Grupo 
        //Si se pudo crear el grupo, Agrega el docente a ese grupo
        if (realizado) {
            int cedulaDocente = docenteSeleccionadoAgregarACurso.intValue();
            GestorRelacional gestorRelacional = new GestorRelacional();
            gestorRelacional.agregarDocenteACurso(cedulaDocente, idCurso1);//Agrega docente al grupo
            
            //Refrescamos las tablas para que aparezca nuevo curso
            GestorCursos gestorC = new GestorCursos();
            gestorC.cargarTablaCursosFull(modificarCurso_TablaCursos);
            gestorC.cargarTablaCursosFull(modificarEstudiantes_TablaCursos);
            gestorC.cargarTablaCursosFull(crearActividad_TablaCursos);
            gestorC.cargarTablaCursosFull(modificarActividad_TablaCursos);
            gestorC.cargarTablaCursosFull(calificaciones_TablaCursos);
            gestorC.cargarTablaCursosFull(crearClase_TablaCursos);
            gestorC.cargarTablaCursosFull(eliminarClase_TablaCursos);
            
            /*DefaultTableModel model = (DefaultTableModel) tablaCalificaciones.getModel();
            model.setRowCount(0);*/
            
            tablaCalificaciones.repaint();
            
        } else {
            //JOptionPane.showMessageDialog(null, "No se selecciono ningun docente para el curso.", "Aviso", JOptionPane.WARNING_MESSAGE);
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
        gestorD.cargarTablaDocentesPorAsignatura(asignatura, crearCurso_TablaDocentes);
    }//GEN-LAST:event_Curso_crear_opcionesAsignaturaItemStateChanged

    private void Curso_modificar_botonEliminarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Curso_modificar_botonEliminarCursoActionPerformed
        //Traemos seleccion de Curso desde el MouseListener - MouseListenerEliminarCurso()
        String curso_ClaseyGrupo = cursoSeleccionadoEliminarCurso_Curso;
        String asignatura = cursoSeleccionadoEliminarCurso_Asignatura;
      
        if(curso_ClaseyGrupo == null || asignatura == null){
            JOptionPane.showMessageDialog(null, "Para borrar un curso debe seleccionarlo.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }else{
        
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
                
                GestorClases gestorClases = new GestorClases();
                gestorClases.eliminarClaseDeCurso(cursoID);//Eliminar priero las clases vinculadas ese curso
                
                GestorRelacional gestorR = new GestorRelacional();
                gestorR.eliminarCursoConDocente(cursoID); 
                gestorR.eliminarCursoConEstudiantes(cursoID); 
                gestorC.eliminarCurso(cursoID);
                
                

                //Refrescar tablas luego de eliminar
                gestorC.cargarCursosDesdeBD();
                gestorC.cargarTablaCursosFull(modificarCurso_TablaCursos);
                gestorC.cargarTablaCursosFull(modificarEstudiantes_TablaCursos);
                gestorC.cargarTablaCursosFull(tablaEstudiante_Quitar);
                gestorC.cargarTablaCursosFull(crearActividad_TablaCursos);
                gestorC.cargarTablaCursosFull(modificarActividad_TablaCursos);
                gestorC.cargarTablaCursosFull(calificaciones_TablaCursos);
                gestorC.cargarTablaCursosFull(crearClase_TablaCursos);
                gestorC.cargarTablaCursosFull(eliminarClase_TablaCursos);
                
                DefaultTableModel model = (DefaultTableModel) tablaCalificaciones.getModel();
                model.setRowCount(0);
                
            }else{
                System.out.println("Eliminación cancelada.");
            }  
        }
    }//GEN-LAST:event_Curso_modificar_botonEliminarCursoActionPerformed

//AGREGAR ESTUDIANTES A CURSO    
    private void Curso_crear_botonAgregarEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Curso_crear_botonAgregarEstudianteActionPerformed
        //Traemos seleccion de curso desde MouseListener - MouseListenerSeleccionarCurso_AgregarEstudiante()
        String curso = cursoSeleccionadoAgregarEstudiante_Curso;
        String asignatura = cursoSeleccionadoAgregarEstudiante_Asignatura;

        GestorCursos gestorC = new GestorCursos();
        gestorC.cargarCursosDesdeBD();
        int cursoID = gestorC.buscarIDCurso(curso, asignatura);
        
            if(cursoID!=-1){
                GestorEstudiantes gestorE = new GestorEstudiantes();
                List<Estudiante> estudiantesSeleccionadosAgregar = gestorE.obtenerEstudiantesSeleccionados_Agregar(tablaEstudiante_Agregar); //Estudiantes seleccionados en la JTable

                GestorRelacional gestorR = new GestorRelacional();
                gestorR.agregarEstudiantesACurso(cursoID, estudiantesSeleccionadosAgregar); //AGREGAR ESTUDIANTES AL CURSO*/     

                //Actualizo la tabla tablaEstudiante_Quitar con los nuevos estudiantes agregados.
                gestorE.cargarTablaEstudiantesCursoEspecifico(cursoID, tablaEstudiante_Quitar);
            }
            else{
                JOptionPane.showMessageDialog(null, "Para agregar Estudiantes primero debe seleccionar un Curso.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
    }//GEN-LAST:event_Curso_crear_botonAgregarEstudianteActionPerformed

//QUITAR ESTUDIANTES DE CURSO    
    private void Curso_crear_botonQuitarEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Curso_crear_botonQuitarEstudianteActionPerformed
        String curso = cursoSeleccionadoAgregarEstudiante_Curso;
        String asignatura = cursoSeleccionadoAgregarEstudiante_Asignatura;
                       
        GestorCursos gestorC = new GestorCursos();
        gestorC.cargarCursosDesdeBD();
        int cursoID = gestorC.buscarIDCurso(curso, asignatura);
        
        if(cursoID!=-1){
            GestorEstudiantes gestorE = new GestorEstudiantes();
            List<Estudiante> estudiantesSeleccionadosQuitar = gestorE.obtenerEstudiantesSeleccionados_Quitar(tablaEstudiante_Quitar); //Estudiantes seleccionados en la JTable

            GestorRelacional gestorR = new GestorRelacional();
            gestorR.quitarEstudiantesACurso(estudiantesSeleccionadosQuitar); //AGREGAR ESTUDIANTES AL CURSO     

            //Actualizo la tabla tablaEstudiante_Quitar con los nuevos estudiantes quitados.
            gestorE.cargarTablaEstudiantesCursoEspecifico(cursoID, tablaEstudiante_Quitar);
            
            DefaultTableModel model = (DefaultTableModel) tablaCalificaciones.getModel();
            model.setRowCount(0);
            
        }else{
            JOptionPane.showMessageDialog(null, "Para quitar Estudiantes primero debe seleccionar un Curso.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_Curso_crear_botonQuitarEstudianteActionPerformed

    private void opcionesActividadesStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_opcionesActividadesStateChanged

    }//GEN-LAST:event_opcionesActividadesStateChanged

    private void Actividad_crear_tipoActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Actividad_crear_tipoActividadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Actividad_crear_tipoActividadActionPerformed

    private void Actividad_crear_botonAgregarActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Actividad_crear_botonAgregarActividadActionPerformed
        Integer estudianteSeleccionado = estudianteSeleccionadoAgregar_Actividad;
        String tipo = Actividad_crear_tipoActividad.getSelectedItem().toString();
        java.util.Date fechaUtil = txtFecha.getDate();
        String descripcion = descripcionActividad.getText();
        String calificacionTexto = Actividad_calificacion.getText();
        
        GestorCursos gestorC = new GestorCursos();
        gestorC.cargarCursosDesdeBD();
        int cursoID = gestorC.buscarIDCurso(cursoSeleccionadoAgregarActividad_Curso, cursoSeleccionadoAgregarActividad_Asignatura);

        if (estudianteSeleccionado == null || estudianteSeleccionado == 0) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un estudiante.", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else if (fechaUtil == null) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una fecha.", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else if (descripcion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese una descripción.", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else if (descripcion.length() > 300){
            JOptionPane.showMessageDialog(this, "La descripción no debe superar los 300 caracteres.", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else if (calificacionTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese una calificación.", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                float calificacion = Float.parseFloat(calificacionTexto);

                // Verifica que la calificación esté en el rango válido (1 - 12)
                if (calificacion >= 1 && calificacion <= 12) {
                    // Si llegas a este punto, todos los campos están completos y la calificación está dentro del rango válido.
                    GestorActividades gestorAct = new GestorActividades();
                    gestorAct.agregarActividad(estudianteSeleccionado.intValue(), tipo, descripcion, calificacion, new java.sql.Date(fechaUtil.getTime()), cursoID);
                    //gestorAct.cargarTablaActividades_porEstudiantes(estudianteSeleccionado.intValue(), cursoID, modificarActividad_TablaActividades); //Refresco tabla actividades
                } else {
                    JOptionPane.showMessageDialog(this, "La calificación debe estar en el rango de 1 a 12.", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "La calificación no es un número válido.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_Actividad_crear_botonAgregarActividadActionPerformed

    private void Actividad_calificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Actividad_calificacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Actividad_calificacionActionPerformed

    private void Actividad_crear_botonModificarActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Actividad_crear_botonModificarActividadActionPerformed
        Integer estudianteSeleccionado = this.estudianteSeleccionadoAgregar_Actividad;
        Integer idActividad = idActividad_modificarActividad;
        String nuevoTipo = Actividad_modificar_tipoActividad.getSelectedItem().toString();
        String nuevaDescripcion = DescripcionActividad_modificar.getText();
        String calificacionTexto = Actividad_calificacion_modificar.getText();
        calificacionTexto = calificacionTexto.replace(",", "."); // Reemplaza comas por puntos
        
        GestorCursos gestorC = new GestorCursos();
        gestorC.cargarCursosDesdeBD();
        int cursoID = gestorC.buscarIDCurso(cursoSeleccionadoAgregarActividad_Curso, cursoSeleccionadoAgregarActividad_Asignatura);

            if (idActividad != null && !nuevaDescripcion.isEmpty() && !calificacionTexto.isEmpty() && txtFecha_modificar.getDate() != null) {
        try {
            float nuevaCalificacion = Float.parseFloat(calificacionTexto);

            // Verifica que la calificación esté en el rango válido (1 - 12)
            if (nuevaCalificacion >= 1 && nuevaCalificacion <= 12) {
                // Conversión de util.Date a sql.Date
                java.util.Date fechaUtil = txtFecha_modificar.getDate();
                java.sql.Date nuevafecha = new java.sql.Date(fechaUtil.getTime());

                if (nuevaDescripcion.length() > 300) { // Corregir la condición
                    JOptionPane.showMessageDialog(this, "La descripción no debe superar los 300 caracteres.", "Aviso", JOptionPane.WARNING_MESSAGE);
                } else {
                    GestorActividades gestorAct = new GestorActividades();
                    gestorAct.modificarActividad(idActividad, nuevoTipo, nuevaDescripcion, nuevaCalificacion, nuevafecha);

                    Integer idEstudiante = estudianteSeleccionado_cargarActividades;
                    gestorAct.cargarTablaActividades_porEstudiantes(idEstudiante, cursoID, modificarActividad_TablaActividades); // Refrescar tabla
                    idActividad_modificarActividad = null;
                }
            } else {
                JOptionPane.showMessageDialog(this, "La calificación debe estar en el rango de 1 a 12.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La calificación no es un número válido.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(this, "Por favor, seleccione una actividad a modificar.", "Aviso", JOptionPane.WARNING_MESSAGE);
    }

    }//GEN-LAST:event_Actividad_crear_botonModificarActividadActionPerformed

    private void Actividad_crear_botonEliminarActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Actividad_crear_botonEliminarActividadActionPerformed
        Integer estudianteSeleccionado = this.estudianteSeleccionadoAgregar_Actividad;
        
        GestorCursos gestorC = new GestorCursos();
        gestorC.cargarCursosDesdeBD();
        int cursoID = gestorC.buscarIDCurso(cursoSeleccionadoAgregarActividad_Curso, cursoSeleccionadoAgregarActividad_Asignatura);
        
        if(idActividad_modificarActividad != null){
            int respuesta = JOptionPane.showConfirmDialog(
                null,
                "¿Está seguro que desea eliminar la Actividad "+idActividad_modificarActividad+" ?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION){
                GestorActividades gestorAct = new GestorActividades();
                gestorAct.eliminarActividad(idActividad_modificarActividad); //Eliminamos actividad
                Integer idEstudiante = estudianteSeleccionado_cargarActividades;
                gestorAct.cargarTablaActividades_porEstudiantes(idEstudiante, cursoID, modificarActividad_TablaActividades); //Refresco tabla
                idActividad_modificarActividad = null;
                
  
            }else{
                System.out.println("Eliminación cancelada.");
            }  
        }else{
            JOptionPane.showMessageDialog(this, "Por favor, selecione una actividad a eliminar.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
         
    }//GEN-LAST:event_Actividad_crear_botonEliminarActividadActionPerformed

    private void Actividad_calificacion_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Actividad_calificacion_modificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Actividad_calificacion_modificarActionPerformed

    private void Actividad_modificar_tipoActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Actividad_modificar_tipoActividadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Actividad_modificar_tipoActividadActionPerformed

    private void botonGestionClasesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGestionClasesMouseClicked
        panelPestañas.setSelectedIndex(4);
        cambiarEstadoBoton(botonGestionCuentas, false);
        cambiarEstadoBoton(botonGestionCursos, false);
        cambiarEstadoBoton(botonGestionActividades, false);
        cambiarEstadoBoton(botonGestionClases, true);
    }//GEN-LAST:event_botonGestionClasesMouseClicked

    private void botonGestionClasesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGestionClasesMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_botonGestionClasesMouseEntered

    private void botonGestionClasesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGestionClasesMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_botonGestionClasesMouseExited

    private void botonGestionClasesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGestionClasesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonGestionClasesActionPerformed

    private void botonGestionClasesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botonGestionClasesKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonGestionClasesKeyPressed

    private void Clase_crear_botonCrearClaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Clase_crear_botonCrearClaseActionPerformed
        String curso = cursoSeleccionadoAgregarClase_Curso;
        String asignatura = cursoSeleccionadoAgregarClase_Asignatura;

        GestorCursos gestorC = new GestorCursos();
        gestorC.cargarCursosDesdeBD();

        int cursoID = gestorC.buscarIDCurso(curso, asignatura);
        java.util.Date fechaUtil = txtFecha_Clase.getDate();
        String desarrollo = desarrolloClase.getText();

        if (cursoID == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un curso.", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else if (fechaUtil == null) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una fecha.", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else if (desarrollo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese una descripción.", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else if (desarrollo.length() > 300){
            JOptionPane.showMessageDialog(this, "La descripción no debe superar los 300 caracteres.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }else{
            GestorClases gestorClases = new GestorClases();
            gestorClases.cargarClasesDesdeBD(cursoID);

            // Crear un objeto java.sql.Date a partir de la fechaUtil
            java.sql.Date fechaSQL = new java.sql.Date(fechaUtil.getTime());

            // Utilizar el nuevo método existeClaseConFecha en la capa lógica
            if (gestorClases.existeClaseConFecha(fechaSQL, cursoID)) {
                JOptionPane.showMessageDialog(this, "Ya existe una clase con la misma fecha.", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else {
                gestorClases.agregarClase(fechaSQL, desarrollo, cursoID);
                DefaultTableModel model = (DefaultTableModel) tablaClases.getModel();
                model.setRowCount(0); // Limpiar el modelo de la tabla
            }
        }
    }//GEN-LAST:event_Clase_crear_botonCrearClaseActionPerformed

    private void Clase_eliminar_botonEliminarClaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Clase_eliminar_botonEliminarClaseActionPerformed
        Integer idClase = claseSeleccionadaEliminarClase_ID;

        if(idClase == null){
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una clase.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }else{
            GestorClases gestorClases = new GestorClases();
            gestorClases.eliminarClaseIndividual(idClase);
            
            claseSeleccionadaEliminarClase_ID = null;
            
            String curso = cursoSeleccionadoEliminarClase_Curso;
            String asignatura = cursoSeleccionadoEliminarClase_Asignatura;
                    
            GestorCursos gestorC = new GestorCursos();
            gestorC.cargarCursosDesdeBD();
                    
            Integer idCurso = gestorC.buscarIDCurso(curso, asignatura);

            gestorClases.cargarTablaClases(tablaClases, idCurso);
        }
        
    }//GEN-LAST:event_Clase_eliminar_botonEliminarClaseActionPerformed

    private void opcionesClasesStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_opcionesClasesStateChanged

        String curso = cursoSeleccionadoEliminarClase_Curso;
        String asignatura = cursoSeleccionadoEliminarClase_Asignatura;
        
        GestorCursos gestorCursos = new GestorCursos();
        gestorCursos.cargarCursosDesdeBD();
        Integer idCurso = gestorCursos.buscarIDCurso(curso, asignatura);

        GestorClases gestorClases = new GestorClases();
        Integer dictadas = gestorClases.contarClasesDictadas(idCurso);
        
        int resultado = DebenDictar-dictadas;
     
        numeroClasesDictadas.setText(String.valueOf(dictadas));
        numeroClasesNoDictadas.setText(String.valueOf(resultado));
    }//GEN-LAST:event_opcionesClasesStateChanged

    private void tablaClasesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClasesMouseClicked
        
    }//GEN-LAST:event_tablaClasesMouseClicked

//REASIGNAR DOCENTE A CURSO    
    private void Curso_modificar_botonModificarDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Curso_modificar_botonModificarDocenteActionPerformed

        String curso = cursoSeleccionadoEliminarCurso_Curso;
        String asignatura = cursoSeleccionadoEliminarCurso_Asignatura;
        
        GestorCursos gestorCursos = new GestorCursos();
        gestorCursos.cargarCursosDesdeBD();
        int cursoID = gestorCursos.buscarIDCurso(curso, asignatura);
        
        
        Integer cedula = docenteSeleccionadoModificar_Cedula;
        
        if(cedula != null){
            GestorRelacional gestorR = new GestorRelacional();
            gestorR.agregarDocenteACurso(cedula, cursoID);
            //gestorCursos.cargarCursosDesdeBD();
            gestorCursos.cargarTablaCursosFull(modificarCurso_TablaCursos);
            JOptionPane.showMessageDialog(this, "Se reasignó el docente correctamente.", "Aviso", JOptionPane.WARNING_MESSAGE);
            
            GestorCursos gestorC = new GestorCursos();
            gestorC.cargarCursosDesdeBD();
            gestorC.cargarTablaCursosFull(modificarEstudiantes_TablaCursos);
            gestorC.cargarTablaCursosFull(crearActividad_TablaCursos);
            gestorC.cargarTablaCursosFull(modificarActividad_TablaCursos);
            gestorC.cargarTablaCursosFull(calificaciones_TablaCursos);
            gestorC.cargarTablaCursosFull(crearClase_TablaCursos);
            gestorC.cargarTablaCursosFull(eliminarClase_TablaCursos);
        }else{
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un docente.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
        
        
        
        
    }//GEN-LAST:event_Curso_modificar_botonModificarDocenteActionPerformed
    
    
// ===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===
    
//Gest. Cuenta: "Modificar Cuenta" - TOMA DATOS DE TABLA USUARIO PARA RELLENAR LOS CAMPOS AL MODIFICAR UNA CUENTA  
    private void MouseListenerSeleccionarUsuario_verUsuario() {
        modificarCuenta_TablaCuentas.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int filaSeleccionada = modificarCuenta_TablaCuentas.getSelectedRow();
                if (filaSeleccionada >= 0) {
                    Integer cedula = (Integer) modificarCuenta_TablaCuentas.getValueAt(filaSeleccionada, 0);
                    String usuario = modificarCuenta_TablaCuentas.getValueAt(filaSeleccionada, 3).toString(); 
                    String contrasenia = modificarCuenta_TablaCuentas.getValueAt(filaSeleccionada, 4).toString();
                    String cargo = modificarCuenta_TablaCuentas.getValueAt(filaSeleccionada, 5).toString();
                    gradoDocente = modificarCuenta_TablaCuentas.getValueAt(filaSeleccionada, 6).toString();
                    asignaturaDocente = modificarCuenta_TablaCuentas.getValueAt(filaSeleccionada, 7).toString();

                    Cuenta_modificar_textoUsuario.setText(usuario);
                    Cuenta_modificar_textoContrasenia.setText(contrasenia);
                    Cuenta_modificar_textoCedula.setText(cedula.toString());
                    Cuenta_modificar_opcionesCargo.setSelectedItem(cargo); 

                    if (cargo.equals("Docente")) {
                        String grado = modificarCuenta_TablaCuentas.getValueAt(filaSeleccionada, 6).toString();
                        Cuenta_modificar_opcionesGrado.setSelectedItem(grado); // Actualizar grado
                        String asignatura = modificarCuenta_TablaCuentas.getValueAt(filaSeleccionada, 7).toString();
                        Cuenta_modificar_opcionesAsignatura.setSelectedItem(asignatura); // Actualizar asignatura 
                    } else if (cargo.equals("Adscripto")) {
                        String grado = modificarCuenta_TablaCuentas.getValueAt(filaSeleccionada, 6).toString();
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
    
//Gest. Curso: "Crear Curso" - SELECCIONAR UN DOCENTE DE LA TABLA DOCENTES PARA CREAR UN CURSO
    private void MouseListenerSeleccionarDocente_paraCrearCurso() {
        crearCurso_TablaDocentes.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int filaSeleccionada = crearCurso_TablaDocentes.getSelectedRow();
                if (filaSeleccionada >= 0) {
                    //variable declarada arriba fuera del metodo para usarla luego.
                    docenteSeleccionadoAgregarACurso = (Integer) crearCurso_TablaDocentes.getValueAt(filaSeleccionada, 0);
                }
            }
        });
    }

//Gest. Curso: "MODIFICAR CURSO" - TOMA LOS DATOS (CURSO Y ASIGNATURA) DE LA TABLA CURSO PARA USARLOS EN EL BOTON ELIMINAR CURSO
    private void MouseListenerSeleccionarCurso_Eliminar() {
        modificarCurso_TablaCursos.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int filaSeleccionada = modificarCurso_TablaCursos.getSelectedRow();
                if (filaSeleccionada >= 0) {
                    //variables declaradas arriba fuera del metodo para usarla luego.
                    cursoSeleccionadoEliminarCurso_Curso = modificarCurso_TablaCursos.getValueAt(filaSeleccionada, 0).toString();
                    cursoSeleccionadoEliminarCurso_Asignatura = modificarCurso_TablaCursos.getValueAt(filaSeleccionada, 1).toString(); 

                    int cedula = Integer.parseInt(modificarCurso_TablaCursos.getValueAt(filaSeleccionada, 2).toString()); 
                  
                    if(cedula == 0){
                       GestorDocentes gestorD = new GestorDocentes();
                       gestorD.cargarTablaDocentesPorAsignatura(cursoSeleccionadoEliminarCurso_Asignatura, modificarCurso_TablaDocentes); 
                    }else{
                        // Borrar datos de la tabla modificarCurso_TablaDocentes
                        DefaultTableModel model = (DefaultTableModel) modificarCurso_TablaDocentes.getModel();
                        model.setRowCount(0); // Elimina todas las filas de la tabla
                    }
                    
                    
                }
            }
        });
    }    
    
//Gest. Curso: "MODIFICAR CURSO" - TOMA LOS DATOS (CURSO Y ASIGNATURA) DE LA TABLA CURSO PARA CARGAR DOCENTES EN TABLA modificarCurso_TablaDocentes
    private void MouseListenerSeleccionarCurso_AsignarDocente_CursoVacio() {
        modificarCurso_TablaDocentes.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int filaSeleccionada = modificarCurso_TablaDocentes.getSelectedRow();
                if (filaSeleccionada >= 0) {
                    //Obtenemos la cedula del docente
                    docenteSeleccionadoModificar_Cedula = Integer.parseInt(modificarCurso_TablaDocentes.getValueAt(filaSeleccionada, 0).toString());
                }
            }
        });
    }       
    
//Gest. Curso: "Agregar/Quitar Estudiantes" - PERMITE SELECCIONAR UN CURSO Y VER LOS ESTUDIANTES QUE CONFORMAN ESE GRUPO SELECCIONADO 
    private void MouseListenerSeleccionarCurso_verEstudiantes_Curso() {
        modificarEstudiantes_TablaCursos.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int filaSeleccionada = modificarEstudiantes_TablaCursos.getSelectedRow();
                if (filaSeleccionada >= 0) {
                    //variables declaradas arriba fuera del metodo para usarla luego. GUARDA EL CURSO SELECCIONADO
                    cursoSeleccionadoAgregarEstudiante_Curso = modificarEstudiantes_TablaCursos.getValueAt(filaSeleccionada, 0).toString();
                    cursoSeleccionadoAgregarEstudiante_Asignatura = modificarEstudiantes_TablaCursos.getValueAt(filaSeleccionada, 1).toString();                    
                    //Tomo curso y asignatura de Curso_tablaCursoEstudiantes, le paso los valores, convierto el cursoID y completo la tabla tablaEstudiante_Quitar con estudiantes agregados a ese cursoEspecifico.
                    String curso = cursoSeleccionadoAgregarEstudiante_Curso;
                    String asignatura = cursoSeleccionadoAgregarEstudiante_Asignatura;
                    //Buscar curso por ID
                    GestorCursos gestorC = new GestorCursos();
                    gestorC.cargarCursosDesdeBD();
                    Integer cursoID = gestorC.buscarIDCurso(curso, asignatura);                   
                    //Refresco tabla de Estudiantes (quitar) con los estudiantes actuales en ese curso
                    GestorEstudiantes gestorE = new GestorEstudiantes();
                    gestorE.cargarTablaEstudiantesCursoEspecifico(cursoID, tablaEstudiante_Quitar);
                    //Indicador de Curso y Asignatura Seleccionado.
                    indicadorCurso1A.setText(curso+" "+asignatura);
                }
            }
        });
    }    
    
//Gest. Act: "Crear Actividad", SELECCIONAR UN CURSO Y VER LOS ESTUDIANTES QUE CONFORMAN ESE GRUPO SELECCIONADO 
    private void MouseListenerSeleccionarCurso_verEstudiantes_Actividades() {
        crearActividad_TablaCursos.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int filaSeleccionada = crearActividad_TablaCursos.getSelectedRow();
                if (filaSeleccionada >= 0) {
                    //variables declaradas arriba fuera del metodo para usarla luego. GUARDA EL CURSO SELECCIONADO
                    cursoSeleccionadoAgregarActividad_Curso = crearActividad_TablaCursos.getValueAt(filaSeleccionada, 0).toString();
                    cursoSeleccionadoAgregarActividad_Asignatura = crearActividad_TablaCursos.getValueAt(filaSeleccionada, 1).toString(); 
                    //Tomo curso y asignatura de Curso_tablaCursoEstudiantes, le paso los valores, convierto el cursoID y completo la tabla tablaEstudiante_Quitar con estudiantes agregados a ese cursoEspecifico.
                    String curso = cursoSeleccionadoAgregarActividad_Curso;
                    String asignatura = cursoSeleccionadoAgregarActividad_Asignatura;
                    //Buscar curso por ID
                    GestorCursos gestorC = new GestorCursos();
                    gestorC.cargarCursosDesdeBD();
                    Integer cursoID = gestorC.buscarIDCurso(curso, asignatura);
                    //Refresco la tabla tablaEstudiante_enCurso con los Estudiantes cargados a ese Curso.
                    GestorEstudiantes gestorE = new GestorEstudiantes();
                    gestorE.cargarTablaEstudiantesCursoEspecifico_Simple(cursoID, CrearActividad_tablaEstudiantes);
                    //Indicador de Curso y Asignatura Seleccionado.
                    indicadorCurso2A.setText(curso+" "+asignatura);
                    estudianteSeleccionadoAgregar_Actividad = 0;
                }
            }
        });
    }    

//Gest. Act: "Crear actividad" - SELECCIONAR UN ESTUDIANTE PARA USARLO EN EL BOTON AGREGAR ACTIVIDAD
    private void MouseListenerSeleccionarEstudiantes_crearActividad() {
        CrearActividad_tablaEstudiantes.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int filaSeleccionada = CrearActividad_tablaEstudiantes.getSelectedRow();
                if (filaSeleccionada >= 0) {
                    Object valorCelda = CrearActividad_tablaEstudiantes.getValueAt(filaSeleccionada, 0);
                    if (valorCelda != null) {
                        estudianteSeleccionadoAgregar_Actividad = Integer.parseInt(valorCelda.toString());
                    }
                }
            }
        });
    }     

//Gest. Act: "Modificar Actividad" - SELECCIONAR UN CURSO Y VER LOS ESTUDIANTES QUE CONFORMAN ESE GRUPO SELECCIONADO 
    private void MouseListenerSeleccionarEstudiantes_ModificarActividad() {
        modificarActividad_TablaCursos.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int filaSeleccionada = modificarActividad_TablaCursos.getSelectedRow();
                if (filaSeleccionada >= 0) {
                    //variables declaradas arriba fuera del metodo para usarla luego. GUARDA EL CURSO SELECCIONADO
                    cursoSeleccionadoModificarActividad_Curso = modificarActividad_TablaCursos.getValueAt(filaSeleccionada, 0).toString();
                    cursoSeleccionadoModificarActividad_Asignatura = modificarActividad_TablaCursos.getValueAt(filaSeleccionada, 1).toString(); 
                    //Tomo curso y asignatura de Curso_tablaCursoEstudiantes, le paso los valores, convierto el cursoID y completo la tabla tablaEstudiante_Quitar con estudiantes agregados a ese cursoEspecifico.
                    String curso = cursoSeleccionadoModificarActividad_Curso;
                    String asignatura = cursoSeleccionadoModificarActividad_Asignatura;
                    //Buscar curso por ID
                    GestorCursos gestorC = new GestorCursos();
                    gestorC.cargarCursosDesdeBD();
                    Integer cursoID = gestorC.buscarIDCurso(curso, asignatura);
                    //Refresco la tabla tablaEstudiante_enCurso con los Estudiantes cargados a ese Curso.
                    GestorEstudiantes gestorE = new GestorEstudiantes();
                    gestorE.cargarTablaEstudiantesCursoEspecifico_Simple(cursoID, modificarActividad_TablaEstudiantes);
                    
                    DefaultTableModel model = (DefaultTableModel) modificarActividad_TablaActividades.getModel();
                    model.setRowCount(0);
                    
                    //Indicador de Curso y Asignatura Seleccionado.
                    indicadorCurso2A.setText(curso+" "+asignatura);
                    
                    estudianteSeleccionado_cargarActividades = 0;
                    idActividad_modificarActividad = null;
                    
                    
                    
                }
            }
        });
    }     

//Gest. Act: "Modificar Actividad" - SELECCIONAR UN ESTUDIANTE, CARGAR SUS ACTIVIDADES
    private void MouseListenerSeleccionarEstudiantes_verActividades() {
        modificarActividad_TablaEstudiantes.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int filaSeleccionada = modificarActividad_TablaEstudiantes.getSelectedRow();
                if (filaSeleccionada >= 0) {
                    //variables declaradas arriba fuera del metodo para usarla luego.
                    estudianteSeleccionado_cargarActividades = Integer.parseInt(modificarActividad_TablaEstudiantes.getValueAt(filaSeleccionada, 0).toString());
                    int idEstudiante = estudianteSeleccionado_cargarActividades;
                    
                    GestorCursos gestorC = new GestorCursos();
                    gestorC.cargarCursosDesdeBD();
                    int cursoID = gestorC.buscarIDCurso(cursoSeleccionadoModificarActividad_Curso, cursoSeleccionadoModificarActividad_Asignatura);
                    
                    GestorActividades gestorAct = new GestorActividades();
                    gestorAct.cargarTablaActividades_porEstudiantes(idEstudiante, cursoID, modificarActividad_TablaActividades);
                    idActividad_modificarActividad = null;
                }
            }
        });
    } 
    
//Gest. Act: "Modificar Actividad" - SELECCIONAR UNA ACTIVIDAD PARA MODIFICAR O ELIMINAR
    private void MouseListenerSeleccionarActividades() {
        modificarActividad_TablaActividades.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int filaSeleccionada = modificarActividad_TablaActividades.getSelectedRow();
                if (filaSeleccionada >= 0) {
                    //variables declaradas arriba fuera del metodo para usarla luego.
                    idActividad_modificarActividad = Integer.parseInt(modificarActividad_TablaActividades.getValueAt(filaSeleccionada, 0).toString());  
                    String tipo = modificarActividad_TablaActividades.getValueAt(filaSeleccionada, 2).toString();
                    String descripcion = modificarActividad_TablaActividades.getValueAt(filaSeleccionada, 3).toString(); 
                    float calificacion = Float.parseFloat(modificarActividad_TablaActividades.getValueAt(filaSeleccionada, 4).toString());
                    String fecha = modificarActividad_TablaActividades.getValueAt(filaSeleccionada, 5).toString();
                    
                    Actividad_modificar_tipoActividad.setSelectedItem(tipo);
                    DescripcionActividad_modificar.setText(descripcion);
                    Actividad_calificacion_modificar.setText(String.valueOf(calificacion));
                    
                    try {
                        // Creamos un objeto SimpleDateFormat para analizar la cadena de fecha
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        Date fechaDate = sdf.parse(fecha);
                        // Convierte el objeto Date a un objeto Calendar
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(fechaDate);
                        // Configuramos el JCalendar con la fecha obtenida
                        txtFecha_modificar.setDate(calendar.getTime());
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }    
    
//Gest. Act: "Calificaciones" - SELECCIONAR UN CURSO Y VER LAS CALIFICACIONES DE TODOS LOS ESTUDIANTES DEL CURSO
    private void MouseListenerSeleccionarEstudiantes_Calificaciones() {
        calificaciones_TablaCursos.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int filaSeleccionada = calificaciones_TablaCursos.getSelectedRow();
                if (filaSeleccionada >= 0) {
                    //variables declaradas arriba fuera del metodo para usarla luego. GUARDA EL CURSO SELECCIONADO
                    cursoSeleccionadoModificarActividad_Curso = calificaciones_TablaCursos.getValueAt(filaSeleccionada, 0).toString();
                    cursoSeleccionadoModificarActividad_Asignatura = calificaciones_TablaCursos.getValueAt(filaSeleccionada, 1).toString(); 
                    //Tomo curso y asignatura de Curso_tablaCursoEstudiantes, le paso los valores, convierto el cursoID y completo la tabla tablaEstudiante_Quitar con estudiantes agregados a ese cursoEspecifico.
                    String curso = cursoSeleccionadoModificarActividad_Curso;
                    String asignatura = cursoSeleccionadoModificarActividad_Asignatura;
                    //Buscar curso por ID
                    GestorCursos gestorC = new GestorCursos();
                    gestorC.cargarCursosDesdeBD();
                    Integer cursoID = gestorC.buscarIDCurso(curso, asignatura);
                    //Refresco la tabla tablaEstudiante_enCurso con los Estudiantes cargados a ese Curso.
                    GestorActividades gestorAct = new GestorActividades();
                    gestorAct.llenarTablaEstudiantesCalificaciones(cursoID, tablaCalificaciones);
                    //Indicador de Curso y Asignatura Seleccionado
                    indicadorCusoB.setText(curso+" "+asignatura);
                }
            }
        });
    }    
    
    
//Gest. Clases: "CREAR CLASE" - TOMA LOS DATOS (CURSO Y ASIGNATURA) DE LA TABLA CURSO PARA CREAR UNA CLASE
    private void MouseListenerSeleccionarCurso_crearClase() {
        crearClase_TablaCursos.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int filaSeleccionada = crearClase_TablaCursos.getSelectedRow();
                if (filaSeleccionada >= 0) {
                    //variables declaradas arriba fuera del metodo para usarla luego.
                    cursoSeleccionadoAgregarClase_Curso = crearClase_TablaCursos.getValueAt(filaSeleccionada, 0).toString();
                    cursoSeleccionadoAgregarClase_Asignatura = crearClase_TablaCursos.getValueAt(filaSeleccionada, 1).toString();  
                }
            }
        });
    }    
    
//Gest. Clases: "ELIMINAR CLASE" - TOMA LOS DATOS (CURSO Y ASIGNATURA) DE LA TABLA CURSO PARA ELIMINAR UNA CLASE
    private void MouseListenerSeleccionarCurso_eliminarClase() {
        eliminarClase_TablaCursos.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int filaSeleccionada = eliminarClase_TablaCursos.getSelectedRow();
                if (filaSeleccionada >= 0) {
                    //variables declaradas arriba fuera del metodo para usarla luego.
                    cursoSeleccionadoEliminarClase_Curso = eliminarClase_TablaCursos.getValueAt(filaSeleccionada, 0).toString();
                    cursoSeleccionadoEliminarClase_Asignatura = eliminarClase_TablaCursos.getValueAt(filaSeleccionada, 1).toString();  
                    
                    String curso = cursoSeleccionadoEliminarClase_Curso;
                    String asignatura = cursoSeleccionadoEliminarClase_Asignatura;
                    
                    GestorCursos gestorC = new GestorCursos();
                    gestorC.cargarCursosDesdeBD();
                    
                    Integer idCurso = gestorC.buscarIDCurso(curso, asignatura);
                    
                    GestorClases gestorClases = new GestorClases();
                    gestorClases.cargarTablaClases(tablaClases, idCurso);

                    
                   
                    GestorCursos gestorCursos = new GestorCursos();
                    gestorCursos.cargarCursosDesdeBD();
    
                    Integer dictadas = gestorClases.contarClasesDictadas(idCurso);

                    int resultado = DebenDictar-dictadas;

                    numeroClasesDictadas.setText(String.valueOf(dictadas));
                    numeroClasesNoDictadas.setText(String.valueOf(resultado));
                }
            }
        });
    }    

//Gest. Clases: "ELIMINAR CLASE" - TOMA EL ID DE CLASE PARA ELIMINAR
    private void MouseListenerSeleccionarClase_eliminarClase() {
        tablaClases.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int filaSeleccionada = tablaClases.getSelectedRow();
                if (filaSeleccionada >= 0) {
                    //variables declaradas arriba fuera del metodo para usarla luego.
                    claseSeleccionadaEliminarClase_ID = Integer.parseInt(tablaClases.getValueAt(filaSeleccionada, 0).toString()); 
                    Integer idCurso = Integer.parseInt(tablaClases.getValueAt(filaSeleccionada, 3).toString()); 
                    
                    int idClase = claseSeleccionadaEliminarClase_ID;
                    
                    GestorClases gestorClases = new GestorClases();
                    Integer dictadas = gestorClases.contarClasesDictadas(idCurso);

                    int resultado = DebenDictar-dictadas;

                    numeroClasesDictadas.setText(String.valueOf(dictadas));
                    numeroClasesNoDictadas.setText(String.valueOf(resultado));
                    
                }
            }
        });
    }    

//Gest. Clases: "CALIFICACIONES" - CLICK DERECHO SE VE DESARROLLO COMPLETO    
    private void MouseListenerVerCalificacionesCompleto() {
        tablaCalificaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getButton() == MouseEvent.BUTTON3) { // Doble clic
                    int column = tablaCalificaciones.getSelectedColumn();
                    int row = tablaCalificaciones.getSelectedRow();
                    
                    if (column == 2) { // Si se hace doble clic en la columna "Desarrollo"
                        String desarrollo = (String) tablaCalificaciones.getValueAt(row, column);
                        // Muestra el contenido completo en un cuadro de diálogo
                        JOptionPane.showMessageDialog(null, desarrollo, "Calificaciones", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
    }     
    
//Gest. Clases: "CALIFICACIONES" - CLICK DERECHO SE VE DESARROLLO COMPLETO    
    private void MouseListenerVerDesarrolloCompleto() {
        tablaClases.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getButton() == MouseEvent.BUTTON3) { // Doble clic
                    int column = tablaClases.getSelectedColumn();
                    int row = tablaClases.getSelectedRow();
                    
                    if (column == 2) { // Si se hace doble clic en la columna "Desarrollo"
                        String desarrollo = (String) tablaClases.getValueAt(row, column);
                        // Muestra el contenido completo en un cuadro de diálogo
                        JOptionPane.showMessageDialog(null, desarrollo, "Desarrollo", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
    }  
    
    
    
    
// ===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===|===    



    //Bienvenida al usuario mostrando el cargo, nombre y apellido
    public void bienvenidaUsuario(String nombreyapellidoUsuario) {
        bienvenidaUsuario.setText("Administrador " + nombreyapellidoUsuario);
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
    private javax.swing.JLabel ActividadClase_textoDescripcion;
    private javax.swing.JTextField Actividad_calificacion;
    private javax.swing.JTextField Actividad_calificacion_modificar;
    private javax.swing.JButton Actividad_crear_botonAgregarActividad;
    private javax.swing.JButton Actividad_crear_botonEliminarActividad;
    private javax.swing.JButton Actividad_crear_botonModificarActividad;
    private javax.swing.JComboBox<String> Actividad_crear_tipoActividad;
    private javax.swing.JComboBox<String> Actividad_modificar_tipoActividad;
    private javax.swing.JLabel Actividad_textoCalificacion;
    private javax.swing.JLabel Actividad_textoCalificacion_miodificar;
    private javax.swing.JLabel Actividad_textoDescripcion;
    private javax.swing.JLabel Actividad_textoDescripcion1;
    private javax.swing.JLabel Actividad_textoFecha;
    private javax.swing.JLabel Actividad_textoFecha1;
    private javax.swing.JLabel Actividad_textoSeleccionarActividad_modificar;
    private javax.swing.JLabel Actividad_textoSeleccionarCursoActividades;
    private javax.swing.JLabel Actividad_textoSeleccionarCursoActividades_calificaciones;
    private javax.swing.JLabel Actividad_textoSeleccionarCursoActividades_calificaciones1;
    private javax.swing.JLabel Actividad_textoSeleccionarCursoActividades_modificar;
    private javax.swing.JLabel Actividad_textoSeleccionarEstudianteActividad;
    private javax.swing.JLabel Actividad_textoSeleccionarEstudianteActividad_modificar1;
    private javax.swing.JLabel Actividad_textoTipoActividad;
    private javax.swing.JLabel Actividad_textoTipoActividad1;
    private javax.swing.JButton Clase_crear_botonCrearClase;
    private javax.swing.JButton Clase_eliminar_botonEliminarClase;
    private javax.swing.JLabel Clase_textoFecha;
    private javax.swing.JLabel Clase_textoSeleccionarClases;
    private javax.swing.JLabel Clase_textoSeleccionarCursoClases;
    private javax.swing.JLabel Clase_textoSeleccionarCursoClases1;
    private javax.swing.JTable CrearActividad_tablaEstudiantes;
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
    private javax.swing.JLabel Curso_crear_asignatura;
    private javax.swing.JButton Curso_crear_botonAgregarEstudiante;
    private javax.swing.JButton Curso_crear_botonCrearCurso;
    private javax.swing.JButton Curso_crear_botonQuitarEstudiante;
    private javax.swing.JLabel Curso_crear_clase;
    private javax.swing.JLabel Curso_crear_grupo;
    private javax.swing.JComboBox<String> Curso_crear_opcionesAsignatura;
    private javax.swing.JComboBox<String> Curso_crear_opcionesClase;
    private javax.swing.JComboBox<String> Curso_crear_opcionesGrupo;
    private javax.swing.JLabel Curso_crear_textoAsignarDocente;
    private javax.swing.JLabel Curso_crear_textoEstudiantes;
    private javax.swing.JLabel Curso_crear_textoEstudiantes1;
    private javax.swing.JLabel Curso_crear_textoSeleccionarCursoEstudiantes;
    private javax.swing.JButton Curso_modificar_botonEliminarCurso;
    private javax.swing.JButton Curso_modificar_botonModificarDocente;
    private javax.swing.JTextArea DescripcionActividad_modificar;
    private javax.swing.JPanel banner;
    private javax.swing.JLabel bienvenidaUsuario;
    private javax.swing.JButton botonCerrarSesion;
    private javax.swing.JButton botonGestionActividades;
    private javax.swing.JButton botonGestionClases;
    private javax.swing.JButton botonGestionCuentas;
    private javax.swing.JButton botonGestionCursos;
    private javax.swing.JTable calificaciones_TablaCursos;
    private javax.swing.JLabel clasesDictadas;
    private javax.swing.JLabel clasesNoDictadas;
    private javax.swing.JPanel crearActividad;
    private javax.swing.JTable crearActividad_TablaCursos;
    private javax.swing.JPanel crearClase;
    private javax.swing.JTable crearClase_TablaCursos;
    private javax.swing.JPanel crearCuenta;
    private javax.swing.JPanel crearCurso;
    private javax.swing.JTable crearCurso_TablaDocentes;
    private javax.swing.JLabel cursosRegistrados;
    private javax.swing.JTextArea desarrolloClase;
    private javax.swing.JTextArea descripcionActividad;
    private javax.swing.JPanel eliminarClase;
    private javax.swing.JTable eliminarClase_TablaCursos;
    private javax.swing.JLabel indicadorCurso;
    private javax.swing.JLabel indicadorCurso1A;
    private javax.swing.JLabel indicadorCurso2A;
    private javax.swing.JLabel indicadorCusoB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel logoSDFA;
    private javax.swing.JPanel modificarActividad;
    private javax.swing.JTable modificarActividad_TablaActividades;
    private javax.swing.JTable modificarActividad_TablaCursos;
    private javax.swing.JTable modificarActividad_TablaEstudiantes;
    private javax.swing.JPanel modificarCuenta;
    private javax.swing.JTable modificarCuenta_TablaCuentas;
    private javax.swing.JPanel modificarCurso;
    private javax.swing.JTable modificarCurso_TablaCursos;
    private javax.swing.JTable modificarCurso_TablaDocentes;
    private javax.swing.JPanel modificarEstudiantes;
    private javax.swing.JTable modificarEstudiantes_TablaCursos;
    private javax.swing.JLabel numeroClasesDictadas;
    private javax.swing.JLabel numeroClasesNoDictadas;
    private javax.swing.JTabbedPane opcionesActividades;
    private javax.swing.JTabbedPane opcionesClases;
    private javax.swing.JTabbedPane opcionesCuentas;
    private javax.swing.JTabbedPane opcionesCursos;
    private javax.swing.JPanel panelAdministrador;
    private javax.swing.JPanel panelOpciones;
    private javax.swing.JTabbedPane panelPestañas;
    private javax.swing.JPanel pestaña0_Cuentas;
    private javax.swing.JPanel pestaña1_Cursos;
    private javax.swing.JPanel pestaña2_Actividades;
    private javax.swing.JPanel pestaña3_Clases;
    private javax.swing.JPanel pestañaBienvenida;
    private javax.swing.JSeparator separador;
    private javax.swing.JScrollPane tabla1;
    private javax.swing.JScrollPane tabla10;
    private javax.swing.JScrollPane tabla11;
    private javax.swing.JScrollPane tabla12;
    private javax.swing.JScrollPane tabla13;
    private javax.swing.JScrollPane tabla14;
    private javax.swing.JScrollPane tabla15;
    private javax.swing.JScrollPane tabla2;
    private javax.swing.JScrollPane tabla3;
    private javax.swing.JScrollPane tabla4;
    private javax.swing.JScrollPane tabla5;
    private javax.swing.JScrollPane tabla6;
    private javax.swing.JScrollPane tabla7;
    private javax.swing.JScrollPane tabla8;
    private javax.swing.JScrollPane tabla9;
    private javax.swing.JTable tablaCalificaciones;
    private javax.swing.JScrollPane tablaClase;
    private javax.swing.JTable tablaClases;
    private javax.swing.JTable tablaEstudiante_Agregar;
    private javax.swing.JTable tablaEstudiante_Quitar;
    private com.toedter.calendar.JDateChooser txtFecha;
    private com.toedter.calendar.JDateChooser txtFecha_Clase;
    private com.toedter.calendar.JDateChooser txtFecha_modificar;
    private javax.swing.JPanel verActividades;
    // End of variables declaration//GEN-END:variables
}
