package views;

import dao.postgres.CarreraDB;
import helpers.Colors;
import helpers.Helpers;
import models.Carrera;
import views.components.FlatButton;
import views.components.FlatComboBox;
import views.components.FlatLabel;
import views.components.FlatPanel;
import views.components.FlatTextField;

import javax.swing.GroupLayout;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.ArrayList;

public class RegistrarAlumno extends View {

    private FlatPanel pnlForm;

    private FlatTextField txfNoControl;
    private FlatTextField txfNombre;
    private FlatTextField txfApellidoPaterno;
    private FlatTextField txfApellidoMaterno;

    private FlatComboBox cmbSemestre;
    private FlatComboBox cmbPeriodo;
    private FlatComboBox cmbCarrera;

    private FlatButton btnSig;


    public RegistrarAlumno() {
        super("Registrar Alumno");
    }

    @Override
    protected void initComponents() {
        pnlForm = new FlatPanel();

        txfNoControl = new FlatTextField();
        txfNombre = new FlatTextField();
        txfApellidoPaterno = new FlatTextField();
        txfApellidoMaterno = new FlatTextField();
        ArrayList<Carrera> carreraDB = (ArrayList<Carrera>) new CarreraDB().list();
        String[] carreras = new String[carreraDB.size()];

        for (int i = 0; i < carreraDB.size(); i++) {
            carreras[i] = carreraDB.get(i).getClaveCarrera();
        }

        cmbCarrera = new FlatComboBox(carreras);
        cmbPeriodo = new FlatComboBox(Helpers.getPeriodo().toArray());
        cmbSemestre = new FlatComboBox(new Integer[] { 9, 10, 11, 12 });

        btnSig = new FlatButton("Registrar");

        Helpers.setWhite(pnlForm);
        initForm();
    }

    private void initForm() {
        GroupLayout layout = new GroupLayout(pnlForm);
        pnlForm.setLayout(layout);

        JPanel pNoControl = Helpers.groupElementsVertical(new FlatLabel("Número de Control"), txfNoControl, new FlatLabel("Solo Numeros", Colors.RED));
        JPanel pNombre = Helpers.groupElementsVertical(new FlatLabel("Nombre"), txfNombre, new FlatLabel(" ", Colors.RED));
        JPanel pApellidoPaterno = Helpers.groupElementsVertical(new FlatLabel("Apellido Paterno"), txfApellidoPaterno, new FlatLabel(" ", Colors.RED));
        JPanel pApellidoMaterno = Helpers.groupElementsVertical(new FlatLabel("Apellido Materno"), txfApellidoMaterno, new FlatLabel(" ", Colors.RED));
        JPanel pCarrera = Helpers.groupElementsVertical(new FlatLabel("Carrera"), cmbCarrera, new FlatLabel(" ", Colors.RED));
        JPanel pSemestre = Helpers.groupElementsVertical(new FlatLabel("Semestre"), cmbSemestre, new FlatLabel(" ", Colors.RED));
        JPanel pPeriodo = Helpers.groupElementsVertical(new FlatLabel("Periodo"), cmbPeriodo, new FlatLabel(" ", Colors.RED));

        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)

            .addComponent(pNoControl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)

            .addGroup(layout.createSequentialGroup()
                .addComponent(pNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(pApellidoPaterno, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(pApellidoMaterno, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
            )

            .addGroup(layout.createSequentialGroup()
                .addComponent(pCarrera, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(pSemestre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(pPeriodo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            )

            .addComponent(btnSig, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)

            .addGroup(layout.createSequentialGroup()
                .addComponent(pNoControl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)

                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(pNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(pApellidoPaterno, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(pApellidoMaterno, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                )

                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(pCarrera, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(pSemestre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(pPeriodo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                )

                .addComponent(btnSig, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            )
        );

    }

    @Override
    protected void setComponents() {
        getContentPane().add(BorderLayout.CENTER, pnlForm);
    }

    public FlatTextField getTxfNoControl() {
        return txfNoControl;
    }

    public void setTxfNoControl(FlatTextField txfNoControl) {
        this.txfNoControl = txfNoControl;
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

    public FlatComboBox getCmbSemestre() {
        return cmbSemestre;
    }

    public void setCmbSemestre(FlatComboBox cmbSemestre) {
        this.cmbSemestre = cmbSemestre;
    }

    public FlatComboBox getCmbPeriodo() {
        return cmbPeriodo;
    }

    public void setCmbPeriodo(FlatComboBox cmbPeriodo) {
        this.cmbPeriodo = cmbPeriodo;
    }

    public FlatComboBox getCmbCarrera() {
        return cmbCarrera;
    }

    public void setCmbCarrera(FlatComboBox cmbCarrera) {
        this.cmbCarrera = cmbCarrera;
    }

    public FlatButton getBtnSig() {
        return btnSig;
    }

    public void setBtnSig(FlatButton btnSig) {
        this.btnSig = btnSig;
    }
}
