package views.components.controlpanel;

import enums.FontAwesome5;
import helpers.Colors;
import jiconfont.swing.IconFontSwing;
import views.components.Component;
import views.components.FlatBigButton;
import views.components.FlatPanel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CreateRecord extends FlatPanel implements Component {

    public static final String NAME = "Card Create Record";

    private FlatBigButton btnNewRecord;
    private FlatBigButton btnQueryRecord;

    public CreateRecord() {
        super();
        initComponent();
    }

    @Override
    public void initComponent() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        initSubComponents();
        setSubComponents();
    }

    @Override
    public void initSubComponents() {
        btnNewRecord = new FlatBigButton(IconFontSwing.buildIcon(FontAwesome5.FA_FOLDER_PLUS, 60, Color.white), "Crear Expediente", Color.white);
        btnQueryRecord = new FlatBigButton(Colors.INDIGO, IconFontSwing.buildIcon(FontAwesome5.FA_FOLDER_OPEN, 60, Color.white), "Consultar Expediente", Color.white);
    }

    @Override
    public void setSubComponents() {
        add(btnNewRecord);
        add(btnQueryRecord);
    }

    public FlatBigButton getBtnNewRecord() {
        return btnNewRecord;
    }

    public FlatBigButton getBtnQueryRecord() {
        return btnQueryRecord;
    }
}
