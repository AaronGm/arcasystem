/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import helpers.Helpers;
import helpers.Colors;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;
import views.components.FlatButton;
import views.components.FlatComboBox;
import views.components.FlatLabel;
import views.components.FlatRadioButton;
import views.components.HeaderApp;

/**
 *
 * @author aarongmx
 */
public class RegistrarProyecto extends JFrame {
    private JPanel pnlForm;
    
    private FlatLabel lblNombreProyecto;
    private FlatLabel lblSeleccionProyecto;
    private FlatLabel lblNumeroResidentes;
    private FlatLabel lblPeriodoProyecto;
    
    private JTextField txfNombreProyecto;
    
    private FlatRadioButton rbtBanco;
    private FlatRadioButton rbtPropio;
    private FlatRadioButton rbtEmpleado;
    
    private FlatComboBox cmbPeriodo;
    private FlatComboBox cmbNumeroResidentes;
        
    private FlatButton btnNext;    
    
    public RegistrarProyecto() {
        super("Registro de Proyecto | " + config.Configuration.APP_NAME);
        initView();
    }
    
    
    private void initView() {
        setMinimumSize(Helpers.MINIMO_PANTALLA);
        initComponents();
        initForm();
        getContentPane().add(BorderLayout.CENTER, pnlForm);
        getContentPane().add(BorderLayout.NORTH ,new HeaderApp("Registro de proyectos"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    private void initComponents() {
        IconFontSwing.register(FontAwesome.getIconFont());
        pnlForm = new JPanel();

        lblNombreProyecto = new FlatLabel("Nombre del proyecto");
        lblNumeroResidentes = new FlatLabel("Cantidad de residentes");
        lblPeriodoProyecto = new FlatLabel("Periodo proyectado");
        lblSeleccionProyecto = new FlatLabel("Proyecto seleccionado");
        
        rbtBanco = new FlatRadioButton("Banco de proyectos");
        rbtEmpleado = new FlatRadioButton("Empleado");
        rbtPropio = new FlatRadioButton("Propuesta propia");
        
        txfNombreProyecto = new JTextField();
        txfNombreProyecto.setPreferredSize(new Dimension(390, 30));
        txfNombreProyecto.setBorder(new CompoundBorder(new MatteBorder(1, 1, 1, 1, Colors.BLACK_LIGHT), new EmptyBorder(4, 8, 4, 8)));
        txfNombreProyecto.setFont(helpers.Typography.addFont("Open Sans", "pr"));
        
        cmbPeriodo = new FlatComboBox();
        cmbNumeroResidentes = new FlatComboBox(new Integer[] {1, 2, 3, 4});
        
        btnNext = new FlatButton("SIGUIENTE", IconFontSwing.buildIcon(FontAwesome.ARROW_RIGHT, 18, Colors.BLUE_MEDIUM));
        
        btnNext.setFont(helpers.Typography.componentsFont());
        
    }
    
    private void initForm() {
        GridBagConstraints c = new GridBagConstraints();
        ButtonGroup btnG = new ButtonGroup();
        pnlForm.setLayout(new GridBagLayout());
        pnlForm.setBackground(Color.white);
        pnlForm.setBorder(helpers.Helpers.padding(32, 16));
        
        rbtBanco.setBackground(Color.white);
        rbtEmpleado.setBackground(rbtBanco.getBackground());
        rbtPropio.setBackground(rbtBanco.getBackground());
        
        helpers.Helpers.getPeriodo().forEach((item) -> {
            cmbPeriodo.addItem(item);
        });
        
        btnG.add(rbtBanco);
        btnG.add(rbtEmpleado);
        btnG.add(rbtPropio);
        
        // ------
        c.gridy = 0;
        c.gridx = 0;
//        c.insets = new Insets(8, 0, 8, 0);
        c.anchor = GridBagConstraints.WEST;
        pnlForm.add(lblNombreProyecto, c);
        
        c.gridy = 1;
        c.gridx = 0;
        c.gridwidth = 3;
        pnlForm.add(txfNombreProyecto, c);
        
        // ------
        c.gridy = 2;
        c.gridx = 0;
        c.gridwidth = 1;
        pnlForm.add(lblSeleccionProyecto, c);
        
        c.gridy = 3;
        c.gridx = 0;
        pnlForm.add(rbtBanco, c);
        
        c.gridx = 1;
        pnlForm.add(rbtEmpleado, c);
        
        c.gridx = 2;
        pnlForm.add(rbtPropio, c);

        // ------
        c.gridy = 4;
        c.gridx = 0;
        pnlForm.add(lblPeriodoProyecto, c);
        
        c.gridy = 5;
        c.gridx = 0;
        pnlForm.add(cmbPeriodo, c);
        
        // ------
        c.gridy = 6;
        c.gridx = 0;
        pnlForm.add(lblNumeroResidentes, c);
        
        c.gridy = 7;
        c.gridx = 0;
        pnlForm.add(cmbNumeroResidentes, c);
        
        c.gridy = 8;
        c.gridx = 0;
        pnlForm.add(btnNext, c);
    }
    
}
