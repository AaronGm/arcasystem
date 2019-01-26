package views.components;

import controllers.AlumnoController;
import controllers.PanelController;
import controllers.ProfesorController;
import controllers.ProyectoController;
import enums.FontAwesome5;
import helpers.Colors;
import helpers.Helpers;
import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;
import views.ConsultarProfesor;
import views.PanelControl;
import views.RegistrarAlumno;
import views.RegistrarEmpresa;
import views.RegistrarExpediente;
import views.RegistrarProfesor;
import views.RegistrarProyecto;

import javax.swing.Box;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

/**
 *
 * @author aarongmx
 */
public class MenuApp extends JMenuBar implements ActionListener {
        
    private JMenu inicio;
    private JMenu registrar;
    private JMenu consultar;
    private JMenu estadisticas;
    private JMenu cuenta;
    
    private FlatMenuItem regProfesor;
    private FlatMenuItem regEmpresa;
    private FlatMenuItem regAlumno;
    private FlatMenuItem regProyecto;
    private FlatMenuItem regAsesorInterno;
    private FlatMenuItem regAsesorExterno;
    private FlatMenuItem regExpediente;
    
    private FlatMenuItem cnsProfesor;
    private FlatMenuItem cnsEmpresa;
    private FlatMenuItem cnsAlumno;
    private FlatMenuItem cnsProyecto;
    private FlatMenuItem cnsAsesorInterno;
    private FlatMenuItem cnsAsesorExterno;
    private FlatMenuItem cnsExpediente;

    private FlatMenuItem panelDeControl;
    private FlatMenuItem cerrarSesion;

    FlatMenuItem itemsConsulta[];
    FlatMenuItem itemsRegistro[];

    ProfesorController profesorController;
    AlumnoController alumnoController;
    ProyectoController proyectoController;
    
    public MenuApp() {
        initView();
    }
    
    private void initView() {
        setBackground(Colors.BLACK_LIGHT);
        setBorderPainted(false);
        setPreferredSize(new Dimension(0, 36));
        initComponents();
        add(inicio);
        add(registrar);
        add(consultar);
        add(estadisticas);
        add(Box.createVerticalStrut(36));
        add(cuenta);
    }

    private void initComponents() {
        IconFontSwing.register(FontAwesome5.getIconFont());
        inicio = new JMenu("Inicio");
        registrar = new JMenu("Registrar");
        consultar = new JMenu("Consultar");
        estadisticas = new JMenu("Estadísticas");
        cuenta = new JMenu("Cuenta");
        
        regProfesor = new FlatMenuItem("Profesor");
        regEmpresa = new FlatMenuItem("Empresa");
        regAlumno = new FlatMenuItem("Alumno");
        regProyecto = new FlatMenuItem("Proyecto");
        regAsesorInterno = new FlatMenuItem("Asesor Interno");
        regAsesorExterno = new FlatMenuItem("Asesor Externo");
        regExpediente = new FlatMenuItem("Expediente");
        
        cnsProfesor = new FlatMenuItem("Profesores");
        cnsEmpresa = new FlatMenuItem("Empresas");
        cnsProyecto = new FlatMenuItem("Proyectos");
        cnsAlumno = new FlatMenuItem("Alumno");
        cnsAsesorInterno = new FlatMenuItem("Asesores Internos");
        cnsAsesorExterno = new FlatMenuItem("Asesores Externos");
        cnsExpediente = new FlatMenuItem("Expediente");

        panelDeControl = new FlatMenuItem("Panel de Control", IconFontSwing.buildIcon(FontAwesome5.FA_USER_COG, 16, Colors.BLACK_MEDIUM));
        cerrarSesion = new FlatMenuItem("Cerrar Sesión", IconFontSwing.buildIcon(FontAwesome5.FA_SIGN_OUT_ALT, 16 , Colors.BLACK_MEDIUM));

        initRegistrar();
    }
    
    private void initRegistrar() {
        JComponent menus[] = {
            inicio,
            registrar,
            consultar,
            estadisticas,
            cuenta
        };
        
         itemsConsulta = new FlatMenuItem[]{
            cnsProfesor,
            cnsProyecto,
            cnsEmpresa,
            cnsAsesorExterno,
             cnsAlumno,
            cnsAsesorInterno,
            cnsExpediente
        };
        
        itemsRegistro = new FlatMenuItem[] {
            regProfesor,
            regProyecto, 
            regEmpresa, 
            regAsesorExterno,
            regAlumno,
            regAsesorInterno,
            regExpediente
        };

        Arrays.asList(menus).forEach(el -> {
            el.setForeground(Color.white);
            el.setBorder(null);
            el.setFont(helpers.Typography.componentsFont());
        });
        
        Arrays.asList(itemsRegistro).forEach(el -> {
            el.addActionListener(this);
            registrar.add(el);
        });
        
        Arrays.asList(itemsConsulta).forEach(el -> {
            el.addActionListener(this);
            consultar.add(el);
        });

        Arrays.asList(new JMenuItem[] { panelDeControl, cerrarSesion }).forEach(el -> {
            cuenta.add(el);
        });

        panelDeControl.addActionListener(e -> {
            JFrame jFrame = (JFrame) getTopLevelAncestor();
            if (!(jFrame instanceof PanelControl)) {
                new PanelController().show().setVisible(true);
                jFrame.dispose();
            }
        });
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem item = (JMenuItem)e.getSource();
        JFrame jFrame = (JFrame) getTopLevelAncestor();
        
        if (item == null) {
            return;
        }


                
        if (item == regProfesor) {
            if (!(jFrame instanceof RegistrarProfesor)) {
                profesorController = new ProfesorController();
                profesorController.create().setVisible(true);
                jFrame.dispose();
            }
        } else if (item == regProyecto) {
            if (!(jFrame instanceof RegistrarProyecto)) {
                proyectoController = new ProyectoController();
                proyectoController.create().setVisible(true);
                jFrame.dispose();
            }
        } else if (item == regEmpresa) {
            if (!(jFrame instanceof RegistrarEmpresa)) {
                new RegistrarEmpresa().setVisible(true);
                jFrame.dispose();
            }
        } else if (item == regAlumno) {
            if (!(jFrame instanceof RegistrarAlumno)) {
                alumnoController = new AlumnoController();
                alumnoController.create().setVisible(true);
                jFrame.dispose();
            }
        } else if (item == regExpediente) {
            if (!(jFrame instanceof RegistrarExpediente)) {
                new RegistrarExpediente().setVisible(true);
                jFrame.dispose();
            }
        } else if (item == cnsProfesor) {
            if (!(jFrame instanceof ConsultarProfesor)) {
                profesorController = new ProfesorController();
                profesorController.show().setVisible(true);
                jFrame.dispose();
            }
        }
        
    }

    
}
