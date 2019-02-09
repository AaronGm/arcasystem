package views.old;

import enums.SpacingPoints;
import views.View;
import views.old.components.FlatComboBox;
import views.old.components.FlatPanel;
import views.old.components.historial.DatosAlumno;

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
