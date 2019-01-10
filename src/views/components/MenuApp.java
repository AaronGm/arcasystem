/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.components;

import controllers.ProfesorController;
import helpers.Colors;
import helpers.Helpers;
import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;
import views.ConsultarProfesor;
import views.PanelControl;
import views.RegistrarEmpresa;
import views.RegistrarExpediente;
import views.RegistrarProfesor;
import views.RegistrarProyecto;
import views.RegistrarResidente;

import javax.swing.Box;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
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
    
    private JMenuItem regProfesor;
    private JMenuItem regEmpresa;
    private JMenuItem regResidente;
    private JMenuItem regProyecto;
    private JMenuItem regAsesorInterno;
    private JMenuItem regAsesorExterno;
    private JMenuItem regExpediente;
    
    private JMenuItem cnsProfesor;
    private JMenuItem cnsEmpresa;
    private JMenuItem cnsResidente;
    private JMenuItem cnsProyecto;
    private JMenuItem cnsAsesorInterno;
    private JMenuItem cnsAsesorExterno;
    private JMenuItem cnsExpediente;

    JMenuItem itemsConsulta[];
    JMenuItem itemsRegistro[];
    
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
        IconFontSwing.register(FontAwesome.getIconFont());
        inicio = new JMenu("Inicio");
        registrar = new JMenu("Registrar");
        consultar = new JMenu("Consultar");
        estadisticas = new JMenu("Estadísticas");
        
        cuenta = new JMenu("Cuenta");
        
        regProfesor = new JMenuItem("Profesor");
        regEmpresa = new JMenuItem("Empresa");
        regResidente = new JMenuItem("Residente");
        regProyecto = new JMenuItem("Proyecto");
        regAsesorInterno = new JMenuItem("Asesor Interno");
        regAsesorExterno = new JMenuItem("Asesor Externo");
        regExpediente = new JMenuItem("Expediente");
        
        cnsProfesor = new JMenuItem("Profesores");
        cnsEmpresa = new JMenuItem("Empresas");
        cnsProyecto = new JMenuItem("Proyectos");
        cnsResidente = new JMenuItem("Residentes");
        cnsAsesorInterno = new JMenuItem("Asesores Internos");
        cnsAsesorExterno = new JMenuItem("Asesores Externos");
        cnsExpediente = new JMenuItem("Expediente");
        
        initRegistrar();
    }
    
    private void initRegistrar() {
        JComponent menus[] = {
            inicio,
            registrar,
            consultar,
            estadisticas
        };
        
         itemsConsulta = new JMenuItem[]{
            cnsProfesor,
            cnsProyecto,
            cnsEmpresa,
            cnsAsesorExterno,
            cnsResidente,
            cnsAsesorInterno,
            cnsExpediente
        };
        
        itemsRegistro = new JMenuItem[] {
            regProfesor,
            regProyecto, 
            regEmpresa, 
            regAsesorExterno, 
            regResidente, 
            regAsesorInterno,
            regExpediente
        };
        
        Arrays.asList(menus).forEach(el -> {
            el.setForeground(Color.white);
            el.setBorder(new EmptyBorder(Helpers.paddingInset(0)));
            el.setFont(helpers.Typography.componentsFont());
        });
        
        Arrays.asList(itemsRegistro).forEach(el -> {
            el.setFont(helpers.Typography.componentsFont());
            el.addActionListener(this);
            registrar.add(el);
        });
        
        Arrays.asList(itemsConsulta).forEach(el -> {
            el.setFont(helpers.Typography.componentsFont());
            el.addActionListener(this);
            consultar.add(el);
        });
        
        cuenta.setFont(helpers.Typography.componentsFont());
        cuenta.setForeground(Color.white);
        cuenta.setIcon(IconFontSwing.buildIcon(FontAwesome.WRENCH, 16, Color.white));
        cuenta.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                JFrame jFrame = (JFrame) getTopLevelAncestor();
                if (!(jFrame instanceof PanelControl)) {
                    new PanelControl().setVisible(true);
                    jFrame.dispose();
                }
            }

            @Override
            public void menuDeselected(MenuEvent e) {}

            @Override
            public void menuCanceled(MenuEvent e) {}
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
                ProfesorController rc = new ProfesorController(new RegistrarProfesor());
                rc.registrarProfesor().setVisible(true);
                jFrame.dispose();
            }
        } else if (item == regProyecto) {
            if (!(jFrame instanceof RegistrarProyecto)) {
                new RegistrarProyecto().setVisible(true);
                jFrame.dispose();
            }
        } else if (item == regEmpresa) {
            if (!(jFrame instanceof RegistrarEmpresa)) {
                new RegistrarEmpresa().setVisible(true);
                jFrame.dispose();
            }
        } else if (item == regResidente) {
            if (!(jFrame instanceof RegistrarResidente)) {
                new RegistrarResidente().setVisible(true);
                jFrame.dispose();
            }
        } else if (item == regExpediente) {
            if (!(jFrame instanceof RegistrarExpediente)) {
                new RegistrarExpediente().setVisible(true);
                jFrame.dispose();
            }
        }
        
        if (item == cnsProfesor) {
            if (!(jFrame instanceof ConsultarProfesor)) {
                ConsultarProfesor cp = new ConsultarProfesor();
                cp.setVisible(true);
                jFrame.dispose();
            }
        }
        
    }

    
}
