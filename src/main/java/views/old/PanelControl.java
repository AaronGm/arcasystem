
package views.old;

import controllers.LoginController;
import enums.FontAwesome5;
import helpers.Colors;
import helpers.Helpers;
import jiconfont.swing.IconFontSwing;
import views.View;
import views.old.components.FlatLabel;
import views.old.components.FlatPanel;
import views.old.components.FlatToggleButton;
import views.old.components.controlpanel.AlertTicketInspector;
import views.old.components.controlpanel.CreateRecord;
import views.old.components.controlpanel.DocumentsSettings;
import views.old.components.controlpanel.ProjectsBank;
import views.old.panels.Estadisticas;

import javax.swing.ButtonGroup;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;

/**
 *
 * @author aarongmx
 */
public class PanelControl extends View {

    private FlatPanel pnlMenu;
    private FlatPanel pnlMain;

    private FlatToggleButton tBtnCalendario;
    private FlatToggleButton tBtnConfiguracion;
    private FlatToggleButton tBtnExpedientes;
    private FlatToggleButton tBtnBancoProyectos;
    private FlatToggleButton tBtnEstadistica;

    private AlertTicketInspector alertTicketInspector;
    private DocumentsSettings documentsSettings;
    private CreateRecord createRecord;
    private ProjectsBank projectsBank;
    private Estadisticas estadisticas;


    private CardLayout cardLayout;

    public PanelControl() throws HeadlessException {
        super("Inicio");
    }

    @Override
    protected void initComponents() {
        IconFontSwing.register(FontAwesome5.getIconFont());
        pnlMenu = new FlatPanel();

        cardLayout = new CardLayout();
        pnlMain = new FlatPanel(cardLayout);

        tBtnEstadistica = new FlatToggleButton("Estadistica", FontAwesome5.FA_CHART_BAR, Colors.BLACK_MEDIUM);
        tBtnCalendario = new FlatToggleButton("Fechas revisores", FontAwesome5.FA_CALENDAR_DAY, Colors.BLACK_MEDIUM);
        tBtnConfiguracion = new FlatToggleButton("Plantillas", FontAwesome5.FA_FILE, Colors.BLACK_MEDIUM);
        tBtnExpedientes = new FlatToggleButton("Expedientes", FontAwesome5.FA_FOLDER, Colors.BLACK_MEDIUM);
        tBtnBancoProyectos = new FlatToggleButton("Banco de proyectos", FontAwesome5.FA_ARCHIVE, Colors.BLACK_MEDIUM);

        alertTicketInspector = new AlertTicketInspector();
        documentsSettings = new DocumentsSettings();
        createRecord = new CreateRecord();
        projectsBank = new ProjectsBank();
        estadisticas = new Estadisticas();

        initMain();
        initMenu();
    }

    @Override
    protected void setComponents() {
        getContentPane().add(BorderLayout.WEST, pnlMenu);
        getContentPane().add(BorderLayout.CENTER, pnlMain);
    }

    private void initMain() {
        pnlMain.add(estadisticas, Estadisticas.NAME);
        pnlMain.add(alertTicketInspector, AlertTicketInspector.NAME);
        pnlMain.add(documentsSettings, DocumentsSettings.NAME);
        pnlMain.add(createRecord, CreateRecord.NAME);
        pnlMain.add(projectsBank, ProjectsBank.NAME);
    }
    
    private void initMenu() {
        pnlMenu.setPreferredSize(new Dimension(220, HEIGHT));
        pnlMenu.setLayout(new FlowLayout());
        
        ButtonGroup group = new ButtonGroup();

        tBtnEstadistica.setSelected(true);

        group.add(tBtnEstadistica);
        group.add(tBtnCalendario);
        group.add(tBtnConfiguracion);
        group.add(tBtnExpedientes);
        group.add(tBtnBancoProyectos);

        FlatLabel lbUsername = new FlatLabel(LoginController.CURRENT_USER.toUpperCase());

        pnlMenu.add(Helpers.centerAbsolute(Helpers.logoItiz(120), lbUsername));
        pnlMenu.adds(
            tBtnEstadistica,
            tBtnCalendario,
            tBtnExpedientes,
            tBtnBancoProyectos,
            tBtnConfiguracion
        );
    }
}
