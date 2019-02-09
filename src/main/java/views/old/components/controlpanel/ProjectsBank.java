package views.old.components.controlpanel;

import enums.FontSize;
import views.old.components.Component;
import views.old.components.FlatLabel;
import views.old.components.FlatPanel;
import views.old.panels.Estadisticas;
import views.old.panels.RegistrarEmpresa;
import views.old.panels.RegistrarProyecto;

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

        layout.show(pnlMain, RegistrarEmpresa.PANEL_NAME);

        registrarEmpresa.getBtnNext().addActionListener(l -> layout.next(pnlMain));
        registrarProyecto.getBtnLast().addActionListener(l -> layout.previous(pnlMain));
    }


    @Override
    public void setSubComponents() {
        add(BorderLayout.NORTH, new FlatLabel("Banco de proyectos", FontSize.H2));
        add(BorderLayout.CENTER, pnlMain);
    }

    public RegistrarEmpresa getRegistrarEmpresa() {
        return registrarEmpresa;
    }

    public RegistrarProyecto getRegistrarProyecto() {
        return registrarProyecto;
    }
}
