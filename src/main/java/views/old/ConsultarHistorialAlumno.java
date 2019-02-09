package views.old;

import views.View;
import views.old.components.FlatPanel;
import views.old.components.FlatScrollBar;
import views.old.components.historial.DatosAlumno;
import views.old.components.historial.DatosAsesorExterno;
import views.old.components.historial.DatosEmpresa;
import views.old.components.historial.DatosProyecto;

import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;

public class ConsultarHistorialAlumno extends View {

    private FlatPanel pnlMain;
    private DatosAlumno datosAlumno;
    private DatosProyecto datosProyecto;
    private DatosEmpresa datosEmpresa;
    private DatosAsesorExterno datosAsesorExterno;
    private JScrollPane scrollPane;

    public ConsultarHistorialAlumno() {
        super("Historial Residente");
    }

    @Override
    protected void initComponents() {
        pnlMain = new FlatPanel();
        datosAlumno = new DatosAlumno();
        datosProyecto = new DatosProyecto();
        datosEmpresa = new DatosEmpresa();
        datosAsesorExterno = new DatosAsesorExterno();

        scrollPane = new JScrollPane(pnlMain);
        scrollPane.setWheelScrollingEnabled(true);
        scrollPane.setVerticalScrollBar(new FlatScrollBar());
        scrollPane.setBorder(null);

        initMain();
    }

    private void initMain() {
        pnlMain.setLayout(new BoxLayout(pnlMain, BoxLayout.Y_AXIS));

        pnlMain.add(datosAlumno);
        pnlMain.add(datosProyecto);
        pnlMain.add(datosEmpresa);
        pnlMain.add(datosAsesorExterno);
    }


    @Override
    protected void setComponents() {
        getContentPane().add(BorderLayout.CENTER, scrollPane);
    }

    public DatosAlumno getDatosAlumno() {
        return datosAlumno;
    }

    public DatosProyecto getDatosProyecto() {
        return datosProyecto;
    }

    public DatosEmpresa getDatosEmpresa() {
        return datosEmpresa;
    }

    public DatosAsesorExterno getDatosAsesorExterno() {
        return datosAsesorExterno;
    }
}
