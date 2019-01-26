package views;

import enums.SpacingPoints;
import helpers.Helpers;
import views.components.FlatComboBox;
import views.components.FlatLabel;
import views.components.FlatPanel;
import views.components.FlatTextField;
import views.components.historial.DatosAlumno;

import java.awt.FlowLayout;

public class AsignarAsesorInterno extends View {

    private FlatPanel pnlMain;
    private FlatComboBox cmbProfesor;
    private DatosAlumno datosAlumno;

    public AsignarAsesorInterno() {
        super("Asignación de asesor interno");
    }

    @Override
    protected void initComponents() {
        pnlMain = new FlatPanel(SpacingPoints.SP24, SpacingPoints.SP16);
        datosAlumno = new DatosAlumno();
        initMain();
    }

    private void initMain() {
        pnlMain.setLayout(new FlowLayout(FlowLayout.LEFT));
        pnlMain.add(datosAlumno);
    }

    @Override
    protected void setComponents() {
        add(pnlMain);
    }
}
