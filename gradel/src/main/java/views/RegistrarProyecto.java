/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;
import views.components.FlatButton;
import views.components.FlatComboBox;
import views.components.FlatLabel;
import views.components.FlatRadioButton;
import views.components.FlatTextField;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

/**
 *
 * @author aarongmx
 */
public class RegistrarProyecto extends View {
    private JPanel pnlForm;

    private FlatTextField txfNombreProyecto;
    
    private FlatRadioButton rbtBanco;
    private FlatRadioButton rbtPropio;
    private FlatRadioButton rbtEmpleado;
    
    private FlatComboBox cmbPeriodo;
    private FlatComboBox cmbNumeroResidentes;
        
    private FlatButton btnNext;    
    
    public RegistrarProyecto() {
        super("Registrar Proyecto | " + config.Configuration.APP_NAME, "Registrar Proyecto");
    }
    
    @Override
    protected void initComponents() {
        IconFontSwing.register(FontAwesome.getIconFont());
        pnlForm = new JPanel();

        rbtBanco = new FlatRadioButton("Banco de proyectos");
        rbtEmpleado = new FlatRadioButton("Empleado");
        rbtPropio = new FlatRadioButton("Propuesta propia");
        
        txfNombreProyecto = new FlatTextField();

        cmbPeriodo = new FlatComboBox();
        cmbNumeroResidentes = new FlatComboBox(new Integer[] {1, 2, 3, 4});
        
        btnNext = new FlatButton("SIGUIENTE");

        initForm();
    }

    @Override
    protected void setComponents() {
        getContentPane().add(BorderLayout.CENTER, pnlForm);
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
        c.insets = new Insets(8, 0, 8, 0);
        c.anchor = GridBagConstraints.WEST;
        pnlForm.add(new FlatLabel("Nombre del Proyecto"), c);

        c.gridy = 1;
        c.gridx = 0;
        c.gridwidth = 3;
        pnlForm.add(txfNombreProyecto, c);
        
        // ------
        c.gridy = 2;
        c.gridx = 0;
        c.gridwidth = 1;
        pnlForm.add(new FlatLabel("Selección del proyecto"), c);
        
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
        pnlForm.add(new FlatLabel("Periodo proyectado"), c);
        
        c.gridy = 5;
        c.gridx = 0;
        pnlForm.add(cmbPeriodo, c);
        
        // ------
        c.gridy = 6;
        c.gridx = 0;
        pnlForm.add(new FlatLabel("Número de residentes"), c);
        
        c.gridy = 7;
        c.gridx = 0;
        pnlForm.add(cmbNumeroResidentes, c);
        
        c.gridy = 8;
        c.gridx = 0;
        pnlForm.add(btnNext, c);
    }
    
}
