package views.components.controlpanel;

import enums.FontSize;
import views.components.Component;
import views.components.FlatLabel;
import views.components.FlatPanel;
import views.panels.Estadisticas;
import views.panels.RegistrarEmpresa;
import views.panels.RegistrarProyecto;

import java.awt.BorderLayout;
import java.awt.CardLayout;

public class ProjectsBank extends FlatPanel implements Component {

    public static final String NAME = "Card Projects Bank";

    private CardLayout layout;
    private FlatPanel pnlMain;

    private RegistrarEmpresa registrarEmpresa;
    private RegistrarProyecto registrarProyecto;
    private Estadisticas estadisticas;

    public ProjectsBank() {
        initComponent();
    }

    @Override
    public void initComponent() {
        setLayout(new BorderLayout());
        initSubComponents();
        setSubComponents();
    }

    @Override
    public void initSubComponents() {
        layout = new CardLayout();
        pnlMain = new FlatPanel(layout);
        registrarEmpresa = new RegistrarEmpresa();
        registrarProyecto = new RegistrarProyecto();
        estadisticas = new Estadisticas();
        initMain();
    }

    private void initMain() {
        pnlMain.add(registrarEmpresa, RegistrarEmpresa.PANEL_NAME);
        pnlMain.add(registrarProyecto, RegistrarProyecto.PANEL_NAME);
        pnlMain.add(estadisticas, Estadisticas.PANEL_NAME);

        layout.show(pnlMain, Estadisticas.PANEL_NAME);

        registrarEmpresa.getBtnNext().addActionListener(l -> layout.next(pnlMain));
        registrarProyecto.getBtnLast().addActionListener(l -> layout.previous(pnlMain));
    }


    @Override
    public void setSubComponents() {
        add(BorderLayout.NORTH, new FlatLabel("Banco de proyectos", FontSize.H2));
        add(BorderLayout.CENTER, pnlMain);
    }
}
