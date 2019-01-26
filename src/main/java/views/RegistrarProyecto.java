
package views;

import enums.FontAwesome5;
import enums.SpacingPoints;
import helpers.Helpers;
import jiconfont.swing.IconFontSwing;
import views.components.FlatButton;
import views.components.FlatComboBox;
import views.components.FlatLabel;
import views.components.FlatPanel;
import views.components.FlatRadioButton;
import views.components.FlatTextField;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JComponent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author aarongmx
 */
public class RegistrarProyecto extends View {
    private FlatPanel pnlForm;

    private FlatTextField txfNombreProyecto;
    
    private FlatRadioButton rbtBanco;
    private FlatRadioButton rbtPropio;
    private FlatRadioButton rbtEmpleado;
    
    private FlatComboBox cmbPeriodo;
    private FlatComboBox cmbNumeroResidentes;
    private FlatComboBox cmbSemanas;
        
    private FlatButton btnNext;
    private FlatLabel lbErrNombreProyecto;
    private FlatLabel lbErrSeleccion;

    ButtonGroup btnG;

    public RegistrarProyecto() {
        super("Registrar Proyecto");
    }
    
    @Override
    protected void initComponents() {
        IconFontSwing.register(FontAwesome5.getIconFont());
        pnlForm = new FlatPanel();
        btnG = new ButtonGroup();

        rbtBanco = new FlatRadioButton("Banco de proyectos");
        rbtEmpleado = new FlatRadioButton("Empleado");
        rbtPropio = new FlatRadioButton("Propuesta propia");
        
        txfNombreProyecto = new FlatTextField();
        lbErrNombreProyecto = new FlatLabel(" ");
        lbErrSeleccion = new FlatLabel(" ");


        cmbPeriodo = new FlatComboBox();
        cmbNumeroResidentes = new FlatComboBox(new Integer[] {1, 2, 3, 4});
        cmbSemanas = new FlatComboBox(new Integer[] { 16, 24 });
        
        btnNext = new FlatButton("SIGUIENTE");

        FlatLabel.styleError(lbErrNombreProyecto, lbErrSeleccion);

        initForm();


        txfNombreProyecto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                FlatTextField.escribirSoloLetrasYEspacios(e, lbErrNombreProyecto);
            }
        });
    }

    @Override
    protected void setComponents() {
        getContentPane().add(BorderLayout.CENTER, pnlForm);
    }

    private void initForm() {
        GridBagConstraints c = new GridBagConstraints();

        pnlForm.setLayout(new GridBagLayout());
        pnlForm.setPadding(SpacingPoints.SP24, SpacingPoints.SP16);
        
        rbtBanco.setBackground(Color.white);
        rbtEmpleado.setBackground(rbtBanco.getBackground());
        rbtPropio.setBackground(rbtBanco.getBackground());
        
        helpers.Helpers.getPeriodo().forEach((item) -> cmbPeriodo.addItem(item));
        
        btnG.add(rbtBanco);
        btnG.add(rbtEmpleado);
        btnG.add(rbtPropio);
        
        // ------
        c.gridy = 0;
        c.gridx = 0;
        c.anchor = GridBagConstraints.WEST;
        c.gridwidth = 2;
        c.insets = Helpers.paddingInset(SpacingPoints.SP_NONE, SpacingPoints.SP8, SpacingPoints.SP16, SpacingPoints.SP8);
        pnlForm.add(Helpers.groupElementsVertical(new FlatLabel("Nombre del proyecto"), txfNombreProyecto, lbErrNombreProyecto), c);

        c.gridy = 1;
        pnlForm.add( Helpers.groupElementsVertical(new FlatLabel("Selección del proyecto"), Helpers.groupElementsHorizontal(rbtBanco, rbtEmpleado, rbtPropio), lbErrSeleccion), c);

        c.gridy = 2;
        c.gridwidth = 1;
        pnlForm.add(Helpers.groupElementsVertical(new FlatLabel("Periodo escolar"), cmbPeriodo, (JComponent) Box.createVerticalStrut(16)), c);

        c.gridx = GridBagConstraints.RELATIVE;
        pnlForm.add(Helpers.groupElementsVertical(new FlatLabel("Cantidad de residentes"), cmbNumeroResidentes, (JComponent) Box.createVerticalStrut(16)), c);

        c.gridy = 3;
        c.gridx = GridBagConstraints.RELATIVE;
        pnlForm.add(Helpers.groupElementsVertical(new FlatLabel("Semanas"), cmbSemanas, (JComponent) Box.createVerticalStrut(16)), c);

        c.gridy = 4;
        pnlForm.add(btnNext, c);
    }

    public FlatTextField getTxfNombreProyecto() {
        return txfNombreProyecto;
    }

    public FlatRadioButton getRbtBanco() {
        return rbtBanco;
    }

    public FlatRadioButton getRbtPropio() {
        return rbtPropio;
    }

    public FlatRadioButton getRbtEmpleado() {
        return rbtEmpleado;
    }

    public FlatComboBox getCmbPeriodo() {
        return cmbPeriodo;
    }

    public FlatComboBox getCmbNumeroResidentes() {
        return cmbNumeroResidentes;
    }

    public FlatButton getBtnNext() {
        return btnNext;
    }

    public FlatLabel getLbErrNombreProyecto() {
        return lbErrNombreProyecto;
    }

    public FlatComboBox getCmbSemanas() {
        return cmbSemanas;
    }

    public ButtonGroup getBtnG() {
        return btnG;
    }

    public FlatLabel getLbErrSeleccion() {
        return lbErrSeleccion;
    }
}
