package views;

import helpers.Helpers;
import views.components.FlatLabel;

import javax.swing.JPanel;
import java.awt.BorderLayout;

public class RegistrarAlumno extends View {

    private JPanel pnlForm;

    public RegistrarAlumno() {
        super("Registrar Alumno");
    }

    @Override
    protected void initComponents() {
        pnlForm = new JPanel();
        Helpers.setWhite(pnlForm);

        pnlForm.add(new FlatLabel("Hola"));
    }

    @Override
    protected void setComponents() {
        getContentPane().add(BorderLayout.CENTER, pnlForm);
    }
}
