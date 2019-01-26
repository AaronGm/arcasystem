
package views;

import controllers.LoginController;
import enums.FontAwesome5;
import helpers.Colors;
import helpers.Helpers;
import jiconfont.swing.IconFontSwing;
import views.components.FlatLabel;
import views.components.FlatPanel;
import views.components.FlatToggleButton;
import views.components.controlpanel.AlertTicketInspector;
import views.components.controlpanel.CreateRecord;
import views.components.controlpanel.DocumentsSettings;

import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

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

    private AlertTicketInspector alertTicketInspector;
    private DocumentsSettings documentsSettings;
    private CreateRecord createRecord;

    private CardLayout cardLayout;

    public PanelControl() throws HeadlessException {
        super("Panel de Control");
    }

    @Override
    protected void initComponents() {
        IconFontSwing.register(FontAwesome5.getIconFont());
        pnlMenu = new FlatPanel();

        cardLayout = new CardLayout();
        pnlMain = new FlatPanel(cardLayout);

        tBtnCalendario = new FlatToggleButton("Calendario", FontAwesome5.FA_CALENDAR_ALT, Colors.BLACK_MEDIUM);
        tBtnConfiguracion = new FlatToggleButton("Plantillas", FontAwesome5.FA_FILE, Colors.BLACK_MEDIUM);
        tBtnExpedientes = new FlatToggleButton("Expedientes", FontAwesome5.FA_FOLDER, Colors.BLACK_MEDIUM);

        alertTicketInspector = new AlertTicketInspector();
        documentsSettings = new DocumentsSettings();
        createRecord = new CreateRecord();

        initMain();
        initMenu();
    }

    @Override
    protected void setComponents() {
        getContentPane().add(BorderLayout.WEST, pnlMenu);
        getContentPane().add(BorderLayout.CENTER, pnlMain);
    }

    private void initMain() {
        pnlMain.add(alertTicketInspector, AlertTicketInspector.NAME);
        pnlMain.add(documentsSettings, DocumentsSettings.NAME);
        pnlMain.add(createRecord, CreateRecord.NAME);
    }
    
    private void initMenu() {
        pnlMenu.setPreferredSize(new Dimension(220, HEIGHT));
        pnlMenu.setLayout(new FlowLayout());
        
        ButtonGroup group = new ButtonGroup();

        tBtnCalendario.setSelected(true);
        
        group.add(tBtnCalendario);
        group.add(tBtnConfiguracion);
        group.add(tBtnExpedientes);

        ActionListener actionListener = (ActionEvent e) -> {
            JToggleButton tbtn = (JToggleButton)e.getSource();
            if (Objects.equals(tbtn, tBtnCalendario)) {
                cardLayout.show(pnlMain, AlertTicketInspector.NAME);
            }
            if (Objects.equals(tbtn, tBtnConfiguracion)) {
                cardLayout.show(pnlMain, DocumentsSettings.NAME);
            }
            if (Objects.equals(tbtn, tBtnExpedientes)) {
                cardLayout.show(pnlMain, CreateRecord.NAME);
            }
        };
        
        tBtnCalendario.addActionListener(actionListener);
        tBtnConfiguracion.addActionListener(actionListener);
        tBtnExpedientes.addActionListener(actionListener);

        FlatLabel lbUsername = new FlatLabel(LoginController.CURRENT_USER.toUpperCase());

        pnlMenu.add(Helpers.centerAbsolute(Helpers.logoItiz(120), lbUsername));
        pnlMenu.add(tBtnCalendario);
        pnlMenu.add(tBtnConfiguracion);
        pnlMenu.add(tBtnExpedientes);
    }

    public AlertTicketInspector getAlertTicketInspector() {
        return alertTicketInspector;
    }

    public DocumentsSettings getDocumentsSettings() {
        return documentsSettings;
    }

    public CreateRecord getCreateRecord() {
        return createRecord;
    }
}
