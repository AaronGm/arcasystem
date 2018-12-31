/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.components;

import helpers.Colors;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Arrays;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author aarongmx
 */
public class MenuApp extends JMenuBar {
    
    private JMenu inicio;
    private JMenu registrar;
    private JMenu consultar;
    private JMenu estadisticas;
    
    private JMenuItem regEmpresa;
    private JMenuItem regResidente;
    private JMenuItem regProyecto;
    private JMenuItem regAsesorInterno;
    private JMenuItem regAsesorExterno;
    
    private JMenuItem cnsEmpresa;
    private JMenuItem cnsResidente;
    private JMenuItem cnsProyecto;
    private JMenuItem cnsAsesorInterno;
    private JMenuItem cnsAsesorExterno;

    public MenuApp() {
        initView();
    }

    private void initView() {
        setBackground(Colors.BLUE_MEDIUM);
        setBorderPainted(false);
        setPreferredSize(new Dimension(0, 32));
        initComponents();
        add(inicio);
        add(registrar);
        add(consultar);
        add(estadisticas);
    }

    private void initComponents() {
        inicio = new JMenu("Inicio");
        registrar = new JMenu("Registrar");
        consultar = new JMenu("Consultar");
        estadisticas = new JMenu("Estadisticas");
        
        regEmpresa = new JMenuItem("Empresas");
        regResidente = new JMenuItem("Residente");
        regProyecto = new JMenuItem("Proyecto");
        regAsesorInterno = new JMenuItem("Asesor Interno");
        regAsesorExterno = new JMenuItem("Asesor Externo");
        
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
        
        JComponent itemsConsulta[] = {
            cnsProyecto,
            cnsEmpresa,
            cnsAsesorExterno,
            cnsResidente,
            cnsAsesorInterno
        };
        
        JComponent itemsRegistro[] = { 
            regProyecto, 
            regEmpresa, 
            regAsesorExterno, 
            regResidente, 
            regAsesorInterno 
        };
        
        Arrays.asList(menus).forEach(el -> {
            el.setForeground(Color.white);
            el.setFont(helpers.Typography.componentsFont());
        });
        
        Arrays.asList(itemsRegistro).forEach(el -> {
            el.setFont(helpers.Typography.componentsFont());
            registrar.add(el);
        });
        
        Arrays.asList(itemsConsulta).forEach(el -> {
            el.setFont(helpers.Typography.componentsFont());
            consultar.add(el);
        });
    }
    
}
