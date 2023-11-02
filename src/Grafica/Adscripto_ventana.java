package Grafica;

import Logica.GestorActividades;
import Logica.GestorClases;
import Logica.GestorCursos;
import Logica.GestorEstudiantes;
import java.awt.Color;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Adscripto_ventana extends javax.swing.JFrame {
    
    final Integer DebenDictar = 80;

    private String Adscripto_cursoSeleccionadoAgregarEstudiante_Curso, Adscripto_cursoSeleccionadoAgregarEstudiante_Asignatura;
    private String Adscripto_cursoSeleccionadoModificarActividad_Curso, Adscripto_cursoSeleccionadoModificarActividad_Asignatura;
    private Integer Adscripto_estudianteSeleccionado_cargarActividades;
    private String Adscripto_cursoSeleccionadoCalificacion_Curso, Adscripto_cursoSeleccionadoCalificacion_Asignatura;  
    private String Adscripto_cursoSeleccionadoEliminarClase_Curso, Adscripto_cursoSeleccionadoEliminarClase_Asignatura;
    
    
    public Adscripto_ventana() {
        initComponents();
        
        //Iniciamos todos los MouseListener para que se pueda interactuar con las JTable
        MouseListenerSeleccionarCurso_verEstudiantes_Curso();
        MouseListenerSeleccionarEstudiantes_ModificarActividad();
        MouseListenerSeleccionarEstudiantes_verActividades();
        MouseListenerSeleccionarEstudiantes_Calificaciones();
        MouseListenerSeleccionarCurso_Clase();
        
        MouseListenerDesarrollo();
        
        
        //Precargamos tablaCursos
        GestorCursos gestorC = new GestorCursos();
        gestorC.cargarCursosDesdeBD();
        gestorC.cargarTablaCursosFull(Adscripto_TablaCursos);
        gestorC.cargarTablaCursosFull(Adscripto_Actividad_TablaCursos);
        gestorC.cargarTablaCursosFull(Adscripto_calificaciones_TablaCursos);
        gestorC.cargarTablaCursosFull(Adscripto_Clase_TablaCursos);
        
        
        
        this.setTitle("SDFA - Panel Adscripto");
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/logoPNG.png")).getImage());
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelAdscripto = new javax.swing.JPanel();
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
        pestaña0_Cursos = new javax.swing.JPanel();
        tabla3 = new javax.swing.JScrollPane();
        Adscripto_TablaCursos = new javax.swing.JTable();
        cursosRegistrados = new javax.swing.JLabel();
        Curso_crear_textoEstudiantes1 = new javax.swing.JLabel();
        tabla6 = new javax.swing.JScrollPane();
        Adscripto_tablaEstudiante = new javax.swing.JTable();
        indicadorCurso = new javax.swing.JLabel();
        pestaña1_Actividades = new javax.swing.JPanel();
        opcionesActividades = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        Adscripto_textoSeleccionarCursoActividades = new javax.swing.JLabel();
        tabla9 = new javax.swing.JScrollPane();
        Adscripto_Actividad_TablaCursos = new javax.swing.JTable();
        Adscripto_textoSeleccionarEstudianteActividad = new javax.swing.JLabel();
        tabla10 = new javax.swing.JScrollPane();
        Adscripto_TablaEstudiantes = new javax.swing.JTable();
        jSeparator3 = new javax.swing.JSeparator();
        tabla11 = new javax.swing.JScrollPane();
        Adscripto_TablaActividades = new javax.swing.JTable();
        Adscripto_textoSeleccionarActividad = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Adscripto_textoSeleccionarCursoActividades_calificaciones = new javax.swing.JLabel();
        tabla12 = new javax.swing.JScrollPane();
        Adscripto_calificaciones_TablaCursos = new javax.swing.JTable();
        Adscripto_textoSeleccionarCursoActividades_calificaciones1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Adscripto_tablaCalificaciones = new javax.swing.JTable();
        indicadorCusoB = new javax.swing.JLabel();
        pestaña4_Clases = new javax.swing.JPanel();
        Adscripto_textoSeleccionarCursoClases = new javax.swing.JLabel();
        tabla14 = new javax.swing.JScrollPane();
        Adscripto_Clase_TablaCursos = new javax.swing.JTable();
        Adscripto_textoSeleccionarClases = new javax.swing.JLabel();
        tablaClase = new javax.swing.JScrollPane();
        tablaClases = new javax.swing.JTable();
        clasesDictadas = new javax.swing.JLabel();
        clasesNoDictadas = new javax.swing.JLabel();
        numeroClasesDictadas = new javax.swing.JLabel();
        numeroClasesNoDictadas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panelAdscripto.setBackground(new java.awt.Color(255, 255, 255));
        panelAdscripto.setMinimumSize(new java.awt.Dimension(1030, 670));
        panelAdscripto.setPreferredSize(new java.awt.Dimension(1030, 670));
        panelAdscripto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bienvenidaUsuario.setFont(new java.awt.Font("Gadugi", 3, 18)); // NOI18N
        bienvenidaUsuario.setForeground(new java.awt.Color(0, 0, 0));
        panelAdscripto.add(bienvenidaUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 470, 40));

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

        panelAdscripto.add(banner, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 950, 80));

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

        panelAdscripto.add(panelOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 670));

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

        pestaña0_Cursos.setBackground(new java.awt.Color(255, 255, 255));
        pestaña0_Cursos.setForeground(new java.awt.Color(0, 0, 0));
        pestaña0_Cursos.setToolTipText("");

        Adscripto_TablaCursos.setModel(new javax.swing.table.DefaultTableModel(
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
        tabla3.setViewportView(Adscripto_TablaCursos);

        cursosRegistrados.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        cursosRegistrados.setForeground(new java.awt.Color(0, 0, 0));
        cursosRegistrados.setText("Cursos registrados:");

        Curso_crear_textoEstudiantes1.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Curso_crear_textoEstudiantes1.setForeground(new java.awt.Color(0, 0, 0));
        Curso_crear_textoEstudiantes1.setText("Lista de estudiantes que integran:");

        Adscripto_tablaEstudiante.setModel(new javax.swing.table.DefaultTableModel(
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
        Adscripto_tablaEstudiante.getTableHeader().setReorderingAllowed(false);
        tabla6.setViewportView(Adscripto_tablaEstudiante);

        indicadorCurso.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        indicadorCurso.setForeground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout pestaña0_CursosLayout = new javax.swing.GroupLayout(pestaña0_Cursos);
        pestaña0_Cursos.setLayout(pestaña0_CursosLayout);
        pestaña0_CursosLayout.setHorizontalGroup(
            pestaña0_CursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pestaña0_CursosLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(pestaña0_CursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pestaña0_CursosLayout.createSequentialGroup()
                        .addComponent(Curso_crear_textoEstudiantes1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(indicadorCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tabla3, javax.swing.GroupLayout.DEFAULT_SIZE, 912, Short.MAX_VALUE)
                    .addComponent(cursosRegistrados, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tabla6))
                .addGap(18, 18, 18))
        );
        pestaña0_CursosLayout.setVerticalGroup(
            pestaña0_CursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pestaña0_CursosLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(cursosRegistrados, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tabla3, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(pestaña0_CursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Curso_crear_textoEstudiantes1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(indicadorCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tabla6, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        panelPestañas.addTab("tab0", pestaña0_Cursos);

        pestaña1_Actividades.setBackground(new java.awt.Color(255, 255, 255));

        opcionesActividades.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        Adscripto_textoSeleccionarCursoActividades.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Adscripto_textoSeleccionarCursoActividades.setForeground(new java.awt.Color(0, 0, 0));
        Adscripto_textoSeleccionarCursoActividades.setText("Seleccionar curso:");

        Adscripto_Actividad_TablaCursos.setModel(new javax.swing.table.DefaultTableModel(
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
        Adscripto_Actividad_TablaCursos.getTableHeader().setReorderingAllowed(false);
        tabla9.setViewportView(Adscripto_Actividad_TablaCursos);

        Adscripto_textoSeleccionarEstudianteActividad.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Adscripto_textoSeleccionarEstudianteActividad.setForeground(new java.awt.Color(0, 0, 0));
        Adscripto_textoSeleccionarEstudianteActividad.setText("Seleccionar un estudiante:");

        Adscripto_TablaEstudiantes.setModel(new javax.swing.table.DefaultTableModel(
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
        Adscripto_TablaEstudiantes.getTableHeader().setReorderingAllowed(false);
        tabla10.setViewportView(Adscripto_TablaEstudiantes);

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        Adscripto_TablaActividades.setModel(new javax.swing.table.DefaultTableModel(
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
        Adscripto_TablaActividades.getTableHeader().setReorderingAllowed(false);
        tabla11.setViewportView(Adscripto_TablaActividades);
        if (Adscripto_TablaActividades.getColumnModel().getColumnCount() > 0) {
            Adscripto_TablaActividades.getColumnModel().getColumn(0).setPreferredWidth(25);
            Adscripto_TablaActividades.getColumnModel().getColumn(3).setPreferredWidth(120);
        }

        Adscripto_textoSeleccionarActividad.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Adscripto_textoSeleccionarActividad.setForeground(new java.awt.Color(0, 0, 0));
        Adscripto_textoSeleccionarActividad.setText("Actividades por Estudiante:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 950, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tabla10, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tabla9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Adscripto_textoSeleccionarCursoActividades, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Adscripto_textoSeleccionarEstudianteActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(4, 4, 4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tabla11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Adscripto_textoSeleccionarActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(26, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 531, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(Adscripto_textoSeleccionarCursoActividades, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tabla9, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(Adscripto_textoSeleccionarEstudianteActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tabla10, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(89, 89, 89))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(Adscripto_textoSeleccionarActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tabla11, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );

        opcionesActividades.addTab("Actividades", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        Adscripto_textoSeleccionarCursoActividades_calificaciones.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Adscripto_textoSeleccionarCursoActividades_calificaciones.setForeground(new java.awt.Color(0, 0, 0));
        Adscripto_textoSeleccionarCursoActividades_calificaciones.setText("Seleccionar curso:");

        Adscripto_calificaciones_TablaCursos.setModel(new javax.swing.table.DefaultTableModel(
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
        Adscripto_calificaciones_TablaCursos.getTableHeader().setReorderingAllowed(false);
        tabla12.setViewportView(Adscripto_calificaciones_TablaCursos);

        Adscripto_textoSeleccionarCursoActividades_calificaciones1.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Adscripto_textoSeleccionarCursoActividades_calificaciones1.setForeground(new java.awt.Color(0, 0, 0));
        Adscripto_textoSeleccionarCursoActividades_calificaciones1.setText("Calificaciones de:");

        Adscripto_tablaCalificaciones.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(Adscripto_tablaCalificaciones);
        if (Adscripto_tablaCalificaciones.getColumnModel().getColumnCount() > 0) {
            Adscripto_tablaCalificaciones.getColumnModel().getColumn(0).setPreferredWidth(90);
            Adscripto_tablaCalificaciones.getColumnModel().getColumn(1).setPreferredWidth(90);
            Adscripto_tablaCalificaciones.getColumnModel().getColumn(2).setPreferredWidth(600);
        }

        indicadorCusoB.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        indicadorCusoB.setForeground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addComponent(indicadorCusoB, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(490, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Adscripto_textoSeleccionarCursoActividades_calificaciones1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tabla12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Adscripto_textoSeleccionarCursoActividades_calificaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 904, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(23, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(indicadorCusoB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(263, 263, 263))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addComponent(Adscripto_textoSeleccionarCursoActividades_calificaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(tabla12, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(24, 24, 24)
                    .addComponent(Adscripto_textoSeleccionarCursoActividades_calificaciones1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(12, Short.MAX_VALUE)))
        );

        opcionesActividades.addTab("Calificaciones", jPanel2);

        javax.swing.GroupLayout pestaña1_ActividadesLayout = new javax.swing.GroupLayout(pestaña1_Actividades);
        pestaña1_Actividades.setLayout(pestaña1_ActividadesLayout);
        pestaña1_ActividadesLayout.setHorizontalGroup(
            pestaña1_ActividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pestaña1_ActividadesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(opcionesActividades))
        );
        pestaña1_ActividadesLayout.setVerticalGroup(
            pestaña1_ActividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pestaña1_ActividadesLayout.createSequentialGroup()
                .addGap(0, 16, Short.MAX_VALUE)
                .addComponent(opcionesActividades, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelPestañas.addTab("tab2", pestaña1_Actividades);

        pestaña4_Clases.setBackground(new java.awt.Color(255, 255, 255));

        Adscripto_textoSeleccionarCursoClases.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Adscripto_textoSeleccionarCursoClases.setForeground(new java.awt.Color(0, 0, 0));
        Adscripto_textoSeleccionarCursoClases.setText("Seleccionar curso:");

        Adscripto_Clase_TablaCursos.setModel(new javax.swing.table.DefaultTableModel(
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
        Adscripto_Clase_TablaCursos.getTableHeader().setReorderingAllowed(false);
        tabla14.setViewportView(Adscripto_Clase_TablaCursos);

        Adscripto_textoSeleccionarClases.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Adscripto_textoSeleccionarClases.setForeground(new java.awt.Color(0, 0, 0));
        Adscripto_textoSeleccionarClases.setText("Seleccionar clase:");

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
            tablaClases.getColumnModel().getColumn(0).setPreferredWidth(20);
            tablaClases.getColumnModel().getColumn(1).setPreferredWidth(20);
            tablaClases.getColumnModel().getColumn(2).setPreferredWidth(500);
            tablaClases.getColumnModel().getColumn(3).setPreferredWidth(10);
        }

        clasesDictadas.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        clasesDictadas.setForeground(new java.awt.Color(0, 0, 255));
        clasesDictadas.setText("Clases dictadas: ");

        clasesNoDictadas.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        clasesNoDictadas.setForeground(new java.awt.Color(0, 0, 255));
        clasesNoDictadas.setText("Clases por dictar: ");

        numeroClasesDictadas.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        numeroClasesDictadas.setForeground(new java.awt.Color(0, 0, 255));
        numeroClasesDictadas.setText("0");

        numeroClasesNoDictadas.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        numeroClasesNoDictadas.setForeground(new java.awt.Color(0, 0, 255));
        numeroClasesNoDictadas.setText("0");

        javax.swing.GroupLayout pestaña4_ClasesLayout = new javax.swing.GroupLayout(pestaña4_Clases);
        pestaña4_Clases.setLayout(pestaña4_ClasesLayout);
        pestaña4_ClasesLayout.setHorizontalGroup(
            pestaña4_ClasesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pestaña4_ClasesLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(clasesDictadas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numeroClasesDictadas)
                .addGap(63, 63, 63)
                .addComponent(clasesNoDictadas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(numeroClasesNoDictadas)
                .addContainerGap(558, Short.MAX_VALUE))
            .addGroup(pestaña4_ClasesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pestaña4_ClasesLayout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addGroup(pestaña4_ClasesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pestaña4_ClasesLayout.createSequentialGroup()
                            .addGap(13, 13, 13)
                            .addGroup(pestaña4_ClasesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Adscripto_textoSeleccionarClases, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Adscripto_textoSeleccionarCursoClases, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(pestaña4_ClasesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tablaClase, javax.swing.GroupLayout.PREFERRED_SIZE, 913, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tabla14, javax.swing.GroupLayout.PREFERRED_SIZE, 913, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(23, Short.MAX_VALUE)))
        );
        pestaña4_ClasesLayout.setVerticalGroup(
            pestaña4_ClasesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pestaña4_ClasesLayout.createSequentialGroup()
                .addContainerGap(493, Short.MAX_VALUE)
                .addGroup(pestaña4_ClasesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clasesDictadas, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numeroClasesDictadas, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clasesNoDictadas, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numeroClasesNoDictadas, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(pestaña4_ClasesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pestaña4_ClasesLayout.createSequentialGroup()
                    .addGap(39, 39, 39)
                    .addComponent(Adscripto_textoSeleccionarCursoClases, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(tabla14, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(Adscripto_textoSeleccionarClases, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(tablaClase, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(55, 55, 55)))
        );

        panelPestañas.addTab("tab3", pestaña4_Clases);

        panelAdscripto.add(panelPestañas, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 960, 570));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelAdscripto, javax.swing.GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelAdscripto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void tablaClasesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClasesMouseClicked

    }//GEN-LAST:event_tablaClasesMouseClicked
     
    //Bienvenida al usuario mostrando el cargo, nombre y apellido
    public void bienvenidaUsuario(String nombreyapellidoUsuario) {
        bienvenidaUsuario.setText("Bienvenido/a Adscripto " + nombreyapellidoUsuario);
    }


//Curso: "Ver Estudiantes" - PERMITE SELECCIONAR UN CURSO Y VER LOS ESTUDIANTES QUE CONFORMAN ESE GRUPO SELECCIONADO 
    private void MouseListenerSeleccionarCurso_verEstudiantes_Curso() {
        Adscripto_TablaCursos.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int filaSeleccionada = Adscripto_TablaCursos.getSelectedRow();
                if (filaSeleccionada >= 0) {
                    //variables declaradas arriba fuera del metodo para usarla luego. GUARDA EL CURSO SELECCIONADO
                    Adscripto_cursoSeleccionadoAgregarEstudiante_Curso = Adscripto_TablaCursos.getValueAt(filaSeleccionada, 0).toString();
                    Adscripto_cursoSeleccionadoAgregarEstudiante_Asignatura = Adscripto_TablaCursos.getValueAt(filaSeleccionada, 1).toString();                    
                    //Tomo curso y asignatura de Curso_tablaCursoEstudiantes, le paso los valores, convierto el cursoID y completo la tabla tablaEstudiante_Quitar con estudiantes agregados a ese cursoEspecifico.
                    String curso = Adscripto_cursoSeleccionadoAgregarEstudiante_Curso;
                    String asignatura = Adscripto_cursoSeleccionadoAgregarEstudiante_Asignatura;
                    //Buscar curso por ID
                    GestorCursos gestorC = new GestorCursos();
                    gestorC.cargarCursosDesdeBD();
                    Integer cursoID = gestorC.buscarIDCurso(curso, asignatura);                   
                    //Refresco tabla de Estudiantes (quitar) con los estudiantes actuales en ese curso
                    GestorEstudiantes gestorE = new GestorEstudiantes();
                    gestorE.cargarTablaEstudiantesCursoEspecifico_Simple(cursoID, Adscripto_tablaEstudiante);
                    //Indicador de Curso y Asignatura Seleccionado.
                    indicadorCurso.setText(curso+" "+asignatura);
                }
            }
        });
    }    
    
//Actividades: "Ver Actividades" - SELECCIONAR UN CURSO Y VER LOS ESTUDIANTES QUE CONFORMAN ESE GRUPO SELECCIONADO 
    private void MouseListenerSeleccionarEstudiantes_ModificarActividad() {
        Adscripto_Actividad_TablaCursos.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int filaSeleccionada = Adscripto_Actividad_TablaCursos.getSelectedRow();
                if (filaSeleccionada >= 0) {
                    //variables declaradas arriba fuera del metodo para usarla luego. GUARDA EL CURSO SELECCIONADO
                    Adscripto_cursoSeleccionadoModificarActividad_Curso = Adscripto_Actividad_TablaCursos.getValueAt(filaSeleccionada, 0).toString();
                    Adscripto_cursoSeleccionadoModificarActividad_Asignatura = Adscripto_Actividad_TablaCursos.getValueAt(filaSeleccionada, 1).toString(); 
                    //Tomo curso y asignatura de Curso_tablaCursoEstudiantes, le paso los valores, convierto el cursoID y completo la tabla tablaEstudiante_Quitar con estudiantes agregados a ese cursoEspecifico.
                    String curso = Adscripto_cursoSeleccionadoModificarActividad_Curso;
                    String asignatura = Adscripto_cursoSeleccionadoModificarActividad_Asignatura;
                    //Buscar curso por ID
                    GestorCursos gestorC = new GestorCursos();
                    gestorC.cargarCursosDesdeBD();
                    Integer cursoID = gestorC.buscarIDCurso(curso, asignatura);
                    //Refresco la tabla tablaEstudiante_enCurso con los Estudiantes cargados a ese Curso.
                    GestorEstudiantes gestorE = new GestorEstudiantes();
                    gestorE.cargarTablaEstudiantesCursoEspecifico_Simple(cursoID, Adscripto_TablaEstudiantes);
                    
                    /*
                    DefaultTableModel model = (DefaultTableModel) Adscripto_TablaEstudiantes.getModel();
                    model.setRowCount(0);*/
                    
                    //Indicador de Curso y Asignatura Seleccionado.
                    //indicadorCurso2A.setText(curso+" "+asignatura);
                }
            }
        });
    }      
    
//Actividades: "Ver Actividad" - SELECCIONAR UN ESTUDIANTE, CARGAR SUS ACTIVIDADES
    private void MouseListenerSeleccionarEstudiantes_verActividades() {
        Adscripto_TablaEstudiantes.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int filaSeleccionada = Adscripto_TablaEstudiantes.getSelectedRow();
                if (filaSeleccionada >= 0) {
                    //variables declaradas arriba fuera del metodo para usarla luego.
                    Adscripto_estudianteSeleccionado_cargarActividades = Integer.parseInt(Adscripto_TablaEstudiantes.getValueAt(filaSeleccionada, 0).toString());
                    int idEstudiante = Adscripto_estudianteSeleccionado_cargarActividades;
                    
                    GestorCursos gestorC = new GestorCursos();
                    gestorC.cargarCursosDesdeBD();
                    int cursoID = gestorC.buscarIDCurso(Adscripto_cursoSeleccionadoModificarActividad_Curso, Adscripto_cursoSeleccionadoModificarActividad_Asignatura);
                    
                    GestorActividades gestorAct = new GestorActividades();
                    gestorAct.cargarTablaActividades_porEstudiantes(idEstudiante, cursoID, Adscripto_TablaActividades);
                }
            }
        });
    }             

//Actividades: "Calificaciones" - SELECCIONAR UN CURSO Y VER LAS CALIFICACIONES DE TODOS LOS ESTUDIANTES DEL CURSO
    private void MouseListenerSeleccionarEstudiantes_Calificaciones() {
        Adscripto_calificaciones_TablaCursos.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int filaSeleccionada = Adscripto_calificaciones_TablaCursos.getSelectedRow();
                if (filaSeleccionada >= 0) {
                    //variables declaradas arriba fuera del metodo para usarla luego. GUARDA EL CURSO SELECCIONADO
                    Adscripto_cursoSeleccionadoCalificacion_Curso = Adscripto_calificaciones_TablaCursos.getValueAt(filaSeleccionada, 0).toString();
                    Adscripto_cursoSeleccionadoCalificacion_Asignatura = Adscripto_calificaciones_TablaCursos.getValueAt(filaSeleccionada, 1).toString(); 
                    //Tomo curso y asignatura de Curso_tablaCursoEstudiantes, le paso los valores, convierto el cursoID y completo la tabla tablaEstudiante_Quitar con estudiantes agregados a ese cursoEspecifico.
                    String curso = Adscripto_cursoSeleccionadoCalificacion_Curso;
                    String asignatura = Adscripto_cursoSeleccionadoCalificacion_Asignatura;
                    //Buscar curso por ID
                    GestorCursos gestorC = new GestorCursos();
                    gestorC.cargarCursosDesdeBD();
                    Integer cursoID = gestorC.buscarIDCurso(curso, asignatura);
                    //Refresco la tabla tablaEstudiante_enCurso con los Estudiantes cargados a ese Curso.
                    GestorActividades gestorAct = new GestorActividades();
                    gestorAct.llenarTablaEstudiantesCalificaciones(cursoID, Adscripto_tablaCalificaciones);
                    //Indicador de Curso y Asignatura Seleccionado
                    indicadorCusoB.setText(curso+" "+asignatura);
                }
            }
        });
    }        
    
//Gest. Clases: "ELIMINAR CLASE" - TOMA LOS DATOS (CURSO Y ASIGNATURA) DE LA TABLA CURSO PARA ELIMINAR UNA CLASE
    private void MouseListenerSeleccionarCurso_Clase() {
        Adscripto_Clase_TablaCursos.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int filaSeleccionada = Adscripto_Clase_TablaCursos.getSelectedRow();
                if (filaSeleccionada >= 0) {
                    //variables declaradas arriba fuera del metodo para usarla luego.
                    Adscripto_cursoSeleccionadoEliminarClase_Curso = Adscripto_Clase_TablaCursos.getValueAt(filaSeleccionada, 0).toString();
                    Adscripto_cursoSeleccionadoEliminarClase_Asignatura = Adscripto_Clase_TablaCursos.getValueAt(filaSeleccionada, 1).toString();  
                    
                    String curso = Adscripto_cursoSeleccionadoEliminarClase_Curso;
                    String asignatura = Adscripto_cursoSeleccionadoEliminarClase_Asignatura;
                    
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

//Gest. Clases: "ELIMINAR CLASE" - CLICK DERECHO SE VE DESARROLLO COMPLETO    
    private void MouseListenerDesarrollo() {
        tablaClases.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getButton() == MouseEvent.BUTTON3) { // Doble clic
                    int column = tablaClases.getSelectedColumn();
                    int row = tablaClases.getSelectedRow();
                    
                    if (column == 2) { // Si se hace doble clic en la columna "Desarrollo"
                        String desarrollo = (String) tablaClases.getValueAt(row, column);
                        // Muestra el contenido completo en un cuadro de diálogo
                        JOptionPane.showMessageDialog(null, desarrollo, "Desarrollo completo", JOptionPane.INFORMATION_MESSAGE);
                    }
                }

            }
        });
    }        
    
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
    private javax.swing.JTable Adscripto_Actividad_TablaCursos;
    private javax.swing.JTable Adscripto_Clase_TablaCursos;
    private javax.swing.JTable Adscripto_TablaActividades;
    private javax.swing.JTable Adscripto_TablaCursos;
    private javax.swing.JTable Adscripto_TablaEstudiantes;
    private javax.swing.JTable Adscripto_calificaciones_TablaCursos;
    private javax.swing.JTable Adscripto_tablaCalificaciones;
    private javax.swing.JTable Adscripto_tablaEstudiante;
    private javax.swing.JLabel Adscripto_textoSeleccionarActividad;
    private javax.swing.JLabel Adscripto_textoSeleccionarClases;
    private javax.swing.JLabel Adscripto_textoSeleccionarCursoActividades;
    private javax.swing.JLabel Adscripto_textoSeleccionarCursoActividades_calificaciones;
    private javax.swing.JLabel Adscripto_textoSeleccionarCursoActividades_calificaciones1;
    private javax.swing.JLabel Adscripto_textoSeleccionarCursoClases;
    private javax.swing.JLabel Adscripto_textoSeleccionarEstudianteActividad;
    private javax.swing.JLabel Curso_crear_textoEstudiantes1;
    private javax.swing.JPanel banner;
    private javax.swing.JLabel bienvenidaUsuario;
    private javax.swing.JButton botonActividades;
    private javax.swing.JButton botonCerrarSesion;
    private javax.swing.JButton botonClases;
    private javax.swing.JButton botonCursos;
    private javax.swing.JLabel clasesDictadas;
    private javax.swing.JLabel clasesNoDictadas;
    private javax.swing.JLabel cursosRegistrados;
    private javax.swing.JLabel indicadorCurso;
    private javax.swing.JLabel indicadorCusoB;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel logoSDFA;
    private javax.swing.JLabel numeroClasesDictadas;
    private javax.swing.JLabel numeroClasesNoDictadas;
    private javax.swing.JTabbedPane opcionesActividades;
    private javax.swing.JPanel panelAdscripto;
    private javax.swing.JPanel panelOpciones;
    private javax.swing.JTabbedPane panelPestañas;
    private javax.swing.JPanel pestaña0_Cursos;
    private javax.swing.JPanel pestaña1_Actividades;
    private javax.swing.JPanel pestaña4_Clases;
    private javax.swing.JPanel pestañaBienvenida;
    private javax.swing.JSeparator separador;
    private javax.swing.JScrollPane tabla10;
    private javax.swing.JScrollPane tabla11;
    private javax.swing.JScrollPane tabla12;
    private javax.swing.JScrollPane tabla14;
    private javax.swing.JScrollPane tabla3;
    private javax.swing.JScrollPane tabla6;
    private javax.swing.JScrollPane tabla9;
    private javax.swing.JScrollPane tablaClase;
    private javax.swing.JTable tablaClases;
    // End of variables declaration//GEN-END:variables
}
