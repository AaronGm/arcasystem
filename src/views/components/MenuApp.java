/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.components;

import controllers.RegistrarProfesorController;
import helpers.Colors;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.Box;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;
import views.ConsultarProfesor;
import views.InicioUsuario;
import views.PanelControl;
import views.RegistrarProfesor;

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
    
    private JMenuItem cnsProfesor;
    private JMenuItem cnsEmpresa;
    private JMenuItem cnsResidente;
    private JMenuItem cnsProyecto;
    private JMenuItem cnsAsesorInterno;
    private JMenuItem cnsAsesorExterno;
    
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
        
        cnsProfesor = new JMenuItem("Profesores");
        cnsEmpresa = new JMenuItem("Empresas");
        cnsProyecto = new JMenuItem("Proyectos");
        cnsResidente = new JMenuItem("Residentes");
        cnsAsesorInterno = new JMenuItem("Asesores Internos");
        cnsAsesorExterno = new JMenuItem("Asesores Externos");
        
        initRegistrar();
    }
    
    private void initRegistrar() {
        JComponent menus[] = {
            inicio,
            registrar,
            consultar,
            estadisticas
        };
        
        JMenuItem itemsConsulta[] = {
            cnsProfesor,
            cnsProyecto,
            cnsEmpresa,
            cnsAsesorExterno,
            cnsResidente,
            cnsAsesorInterno
        };
        
        JMenuItem itemsRegistro[] = { 
            regProfesor,
            regProyecto, 
            regEmpresa, 
            regAsesorExterno, 
            regResidente, 
            regAsesorInterno 
        };
        
        Arrays.asList(menus).forEach(el -> {
            el.setForeground(Color.white);
            el.setBorder(new EmptyBorder(0, 0, 0, 0));
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
                new PanelControl().setVisible(true);
                jFrame.dispose();
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
            RegistrarProfesorController rc = new RegistrarProfesorController(new RegistrarProfesor());
            rc.registrarProfesor().setVisible(true);
            jFrame.dispose();
        } else if (item == cnsProfesor) {
            new ConsultarProfesor().setVisible(true);
            jFrame.dispose();
        }
        
    }
    
}
