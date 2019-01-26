package views;

import com.toedter.calendar.JDateChooser;
import enums.EstadoProfesor;
import enums.GradoEstudios;
import enums.SpacingPoints;
import helpers.Helpers;
import views.components.FlatButton;
import views.components.FlatComboBox;
import views.components.FlatLabel;
import views.components.FlatPanel;
import views.components.FlatTextField;

import javax.swing.Box;
import javax.swing.JComponent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

/**
 * @author aarongmx
 */
public class RegistrarProfesor extends View {

    private FlatPanel pnlForm;

    private FlatTextField txfNoContrato;
    private FlatTextField txfNombre;
    private FlatTextField txfApellidoPaterno;
    private FlatTextField txfApellidoMaterno;
    private FlatTextField txfEspecialidad;

    private FlatLabel lbErrNoTrabajador;
    private FlatLabel lbErrNombres;
    private FlatLabel lbErrApellidoPaterno;
    private FlatLabel lbErrApellidoMaterno;


    private JDateChooser jdtcFechaIngreso;

    private FlatComboBox cmbGradoEstudio;
    private FlatComboBox cmbEstatusProfesor;

    private FlatButton button;

    private FlatLabel lbErrEspecialidad;

    public RegistrarProfesor() {
        super("Registrar Profesor");
    }

    public RegistrarProfesor(String headerTitle) {
        super(headerTitle);
    }

    @Override
    protected void initComponents() {
        pnlForm = new FlatPanel(new GridBagLayout());

        txfNoContrato = new FlatTextField();
        txfNombre = new FlatTextField();
        txfApellidoMaterno = new FlatTextField();
        txfApellidoPaterno = new FlatTextField();
        txfEspecialidad = new FlatTextField();

        lbErrNoTrabajador = new FlatLabel(" ");
        lbErrNombres = new FlatLabel(" ");
        lbErrApellidoPaterno = new FlatLabel(" ");
        lbErrApellidoMaterno = new FlatLabel(" ");
        lbErrEspecialidad = new FlatLabel(" ");

        jdtcFechaIngreso = new JDateChooser();

        cmbGradoEstudio = new FlatComboBox(GradoEstudios.getGrados());
        cmbEstatusProfesor = new FlatComboBox(EstadoProfesor.getEstados());

        button = new FlatButton("Registrar");

        KeyAdapter keyAdapter = new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                FlatTextField txf = (FlatTextField) e.getSource();
                Map<FlatTextField, FlatLabel> map = new HashMap<>();
                map.put(txfNombre, lbErrNombres);
                map.put(txfApellidoPaterno, lbErrApellidoPaterno);
                map.put(txfApellidoMaterno, lbErrApellidoMaterno);
                map.put(txfEspecialidad, lbErrEspecialidad);

                map.forEach((k, v) -> {
                    if (k.equals(txf)) {
                        FlatTextField.escribirSoloLetrasYEspacios(e, v);
                    }
                });

                if (txf.equals(txfNoContrato)) {
                    FlatTextField.escribirSoloNumeros(e, lbErrNoTrabajador);
                }

            }
        };

        txfNoContrato.addKeyListener(keyAdapter);
        txfNombre.addKeyListener(keyAdapter);
        txfApellidoPaterno.addKeyListener(keyAdapter);
        txfApellidoMaterno.addKeyListener(keyAdapter);
        txfEspecialidad.addKeyListener(keyAdapter);

        FlatLabel.styleError(lbErrNoTrabajador, lbErrNombres, lbErrApellidoPaterno, lbErrApellidoMaterno, lbErrEspecialidad);
        initForm();
    }

    @Override
    protected void setComponents() {
        getContentPane().add(BorderLayout.CENTER, pnlForm);
    }

    private void initForm() {
        GridBagConstraints c = new GridBagConstraints();

        jdtcFechaIngreso.setPreferredSize(new Dimension(180, 28));
        jdtcFechaIngreso.setFont(helpers.Typography.paragraphFont());
        txfEspecialidad.setFont(helpers.Typography.paragraphFont());

        c.anchor = GridBagConstraints.WEST;

        c.gridy = 0;
        c.gridx = 0;
        c.insets = Helpers.paddingInset(SpacingPoints.SP_NONE, SpacingPoints.SP8, SpacingPoints.SP16, SpacingPoints.SP8);
        pnlForm.add(Helpers.groupElementsVertical(
            new FlatLabel("Número de trabajador"),
            txfNoContrato,
            lbErrNoTrabajador
            ), c
        );

        c.gridx = GridBagConstraints.RELATIVE;
        c.gridwidth = 2;
        pnlForm.add(Helpers.groupElementsVertical( new FlatLabel("Estatus de contrato"),cmbEstatusProfesor, (JComponent) Box.createVerticalStrut(16) ), c);

        c.gridy = 1;
        c.gridx = GridBagConstraints.RELATIVE;
        c.gridwidth = 1;
        pnlForm.add(Helpers.groupElementsVertical(new FlatLabel("Nombres"), txfNombre, lbErrNombres), c);

        c.gridx = GridBagConstraints.RELATIVE;
        pnlForm.add(Helpers.groupElementsVertical(new FlatLabel("Apellido Paterno"), txfApellidoPaterno, lbErrApellidoPaterno), c);

        c.gridx = GridBagConstraints.RELATIVE;
        pnlForm.add(Helpers.groupElementsVertical(new FlatLabel("Apellido Materno"), txfApellidoMaterno, lbErrApellidoMaterno), c);


        c.gridy = 2;
        c.gridx = GridBagConstraints.RELATIVE;
        pnlForm.add(Helpers.groupElementsVertical(new FlatLabel("Fecha de Ingreso"), jdtcFechaIngreso, (JComponent) Box.createVerticalStrut(16)), c);

        c.gridx = GridBagConstraints.RELATIVE;
        pnlForm.add(Helpers.groupElementsVertical(new FlatLabel("Grado de Estudios"), cmbGradoEstudio, (JComponent) Box.createVerticalStrut(16)), c);

        c.gridy = 3;
        c.gridx = GridBagConstraints.RELATIVE;
        pnlForm.add(Helpers.groupElementsVertical(new FlatLabel("Área de especialidad"), txfEspecialidad, lbErrEspecialidad), c);

        c.gridy = 4;
        c.gridwidth = 2;
        pnlForm.add(button, c);
    }

    public FlatTextField getTxfNoContrato() {
        return txfNoContrato;
    }

    public FlatTextField getTxfNombre() {
        return txfNombre;
    }

    public FlatTextField getTxfApellidoPaterno() {
        return txfApellidoPaterno;
    }

    public FlatTextField getTxfApellidoMaterno() {
        return txfApellidoMaterno;
    }

    public FlatTextField getTxfEspecialidad() {
        return txfEspecialidad;
    }

    public FlatLabel getLbErrNoTrabajador() {
        return lbErrNoTrabajador;
    }

    public FlatLabel getLbErrNombres() {
        return lbErrNombres;
    }

    public FlatLabel getLbErrApellidoPaterno() {
        return lbErrApellidoPaterno;
    }

    public FlatLabel getLbErrApellidoMaterno() {
        return lbErrApellidoMaterno;
    }

    public JDateChooser getJdtcFechaIngreso() {
        return jdtcFechaIngreso;
    }

    public FlatComboBox getCmbGradoEstudio() {
        return cmbGradoEstudio;
    }

    public FlatComboBox getCmbEstatusProfesor() {
        return cmbEstatusProfesor;
    }

    public FlatButton getButton() {
        return button;
    }
}
