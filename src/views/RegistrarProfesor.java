package views;

import com.toedter.calendar.JDateChooser;
import helpers.Colors;
import helpers.Helpers;
import models.Profesor;
import views.components.FlatButton;
import views.components.FlatComboBox;
import views.components.FlatLabel;
import views.components.FlatTextField;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

/**
 *
 * @author aarongmx
 */
public class RegistrarProfesor extends View {
    
    private JPanel pnlForm;
    
    private FlatTextField txfNoContrato;
    private FlatTextField txfNombre;
    private FlatTextField txfApellidoPaterno;
    private FlatTextField txfApellidoMaterno;
    private FlatTextField txfEspecialidad;

    private FlatLabel labelError;
    
    private JDateChooser jdtcFechaIngreso;
    
    private FlatComboBox cmbGradoEstudio;
    private FlatComboBox cmbEstatusProfesor;
    
    private FlatButton button;
    
    private String headerTitle;

    public RegistrarProfesor() {
        super("Registrar Profesor");
    }

    public RegistrarProfesor(String title) {
        super(title);
    }

    public RegistrarProfesor(String title, String titleBar) {
        super(title, titleBar);
    }

    @Override
    protected void initComponents() {
        pnlForm = new JPanel(new GridBagLayout());
                
        txfNoContrato = new FlatTextField();
        txfNombre = new FlatTextField();
        txfApellidoMaterno = new FlatTextField();
        txfApellidoPaterno = new FlatTextField();
        txfEspecialidad = new FlatTextField();

        labelError = new FlatLabel(" ", "Roboto Medium", "sm", Colors.RED);
        
        jdtcFechaIngreso = new JDateChooser();
        
        cmbGradoEstudio = new FlatComboBox(Profesor.TYPE_GRADOS_ESTUDIO);
        cmbEstatusProfesor = new FlatComboBox(Profesor.TYPE_ESTATUS_PROFESOR);
        
        button = new FlatButton("Registrar");
        
        helpers.Helpers.setWhite(pnlForm);
        
        initForm();
    }

    @Override
    protected void setComponents() {
        getContentPane().add(BorderLayout.CENTER, pnlForm);
    }

    private void initForm() {
        GridBagConstraints c = new GridBagConstraints();
        Insets mt = new Insets(16, 8, 0, 0);

        jdtcFechaIngreso.setPreferredSize(new Dimension(180, 28));
        jdtcFechaIngreso.setFont(helpers.Typography.paragraphFont());
        txfEspecialidad.setFont(helpers.Typography.paragraphFont());
                
        c.insets = mt;
        c.anchor = GridBagConstraints.WEST;
        
        c.gridy = 0;
        c.gridx = 0;
        pnlForm.add(new FlatLabel("Número de trabajador"), c);
        c.gridx = 1;
        pnlForm.add(txfNoContrato, c);
        c.gridy = 1;
        c.insets = Helpers.paddingInset(0, 8, 16, 8);
        pnlForm.add(labelError, c);


        c.gridy = 2;
        c.gridx = 0;
        pnlForm.add(new FlatLabel("Estatus de Contrato"), c);
        c.gridx = GridBagConstraints.RELATIVE;
        pnlForm.add(cmbEstatusProfesor, c);
        
        c.gridy = 3;
        c.gridx = 0;
        pnlForm.add(new FlatLabel("Nombres"), c);
        c.gridx = GridBagConstraints.RELATIVE;
        pnlForm.add(txfNombre, c);
        
        c.gridy = 4;
        c.gridx = 0;
        pnlForm.add(new FlatLabel("Apellido Paterno"), c);
        c.gridx = GridBagConstraints.RELATIVE;
        pnlForm.add(txfApellidoPaterno, c);
        
        c.gridy = 5;
        c.gridx = 0;
        pnlForm.add(new FlatLabel("Apellido Materno"), c);
        c.gridx = GridBagConstraints.RELATIVE;
        pnlForm.add(txfApellidoMaterno, c);
        
        c.gridy = 6;
        c.gridx = 0;
        pnlForm.add(new FlatLabel("Fecha de Ingreso"), c);
        c.gridx = GridBagConstraints.RELATIVE;
        pnlForm.add(jdtcFechaIngreso, c);
        
        c.gridy = 7;
        c.gridx = 0;
        pnlForm.add(new FlatLabel("Grado de estudios"), c);
        c.gridx = GridBagConstraints.RELATIVE;
        pnlForm.add(cmbGradoEstudio, c);
        
        c.gridy = 8;
        c.gridx = 0;
        pnlForm.add(new FlatLabel("Áreas de especialidad"), c);
        c.gridx = GridBagConstraints.RELATIVE;
        pnlForm.add(txfEspecialidad, c);
        
        
        c.gridy = GridBagConstraints.RELATIVE;
        c.gridwidth = 2;
        c.gridx = 1;
        pnlForm.add(button, c);
    }

    public String getHeaderTitle() {
        return headerTitle;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }
    
    public FlatTextField getTxfNoContrato() {
        return txfNoContrato;
    }

    public void setTxfNoContrato(FlatTextField txfNoContrato) {
        this.txfNoContrato = txfNoContrato;
    }

    public FlatTextField getTxfNombre() {
        return txfNombre;
    }

    public void setTxfNombre(FlatTextField txfNombre) {
        this.txfNombre = txfNombre;
    }

    public FlatTextField getTxfApellidoPaterno() {
        return txfApellidoPaterno;
    }

    public void setTxfApellidoPaterno(FlatTextField txfApellidoPaterno) {
        this.txfApellidoPaterno = txfApellidoPaterno;
    }

    public FlatTextField getTxfApellidoMaterno() {
        return txfApellidoMaterno;
    }

    public void setTxfApellidoMaterno(FlatTextField txfApellidoMaterno) {
        this.txfApellidoMaterno = txfApellidoMaterno;
    }

    public FlatTextField getTxfEspecialidad() {
        return txfEspecialidad;
    }

    public void setTxfEspecialidad(FlatTextField txfEspecialidad) {
        this.txfEspecialidad = txfEspecialidad;
    }
    
    public JDateChooser getJdtcFechaIngreso() {
        return jdtcFechaIngreso;
    }

    public void setJdtcFechaIngreso(JDateChooser jdtcFechaIngreso) {
        this.jdtcFechaIngreso = jdtcFechaIngreso;
    }

    public FlatComboBox getCmbGradoEstudio() {
        return cmbGradoEstudio;
    }

    public void setCmbGradoEstudio(FlatComboBox cmbGradoEstudio) {
        this.cmbGradoEstudio = cmbGradoEstudio;
    }

    public FlatComboBox getCmbEstatusProfesor() {
        return cmbEstatusProfesor;
    }

    public void setCmbEstatusProfesor(FlatComboBox cmbEstatusProfesor) {
        this.cmbEstatusProfesor = cmbEstatusProfesor;
    }

    public FlatButton getButton() {
        return button;
    }

    public void setButton(FlatButton button) {
        this.button = button;
    }    
}
