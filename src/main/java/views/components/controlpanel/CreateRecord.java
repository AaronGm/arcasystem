package views.components.controlpanel;

import enums.FontAwesome5;
import enums.FontSize;
import helpers.Colors;
import jiconfont.swing.IconFontSwing;
import views.components.Component;
import views.components.FlatBigButton;
import views.components.FlatLabel;
import views.components.FlatPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CreateRecord extends FlatPanel implements Component {

    public static final String NAME = "Card Create Record";

    private FlatPanel pnlMain;

    private FlatBigButton btnNewRecord;
    private FlatBigButton btnQueryRecord;

    public CreateRecord() {
        super(new BorderLayout());
        initComponent();
    }

    @Override
    public void initComponent() {
        initSubComponents();
        setSubComponents();
    }

    @Override
    public void initSubComponents() {
        pnlMain = new FlatPanel(new FlowLayout(FlowLayout.LEFT));
        btnNewRecord = new FlatBigButton(IconFontSwing.buildIcon(FontAwesome5.FA_FOLDER_PLUS, 60, Color.white), "Crear Expediente", Color.white);
        btnQueryRecord = new FlatBigButton(Colors.INDIGO, IconFontSwing.buildIcon(FontAwesome5.FA_FOLDER_OPEN, 60, Color.white), "Consultar Expediente", Color.white);

        pnlMain.add(btnNewRecord);
        pnlMain.add(btnQueryRecord);
    }

    @Override
    public void setSubComponents() {
        add(BorderLayout.NORTH, new FlatLabel("Expedientes", FontSize.H2));
        add(BorderLayout.CENTER, pnlMain);
    }

    public FlatBigButton getBtnNewRecord() {
        return btnNewRecord;
    }

    public FlatBigButton getBtnQueryRecord() {
        return btnQueryRecord;
    }
}
