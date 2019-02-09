package views.old.components.controlpanel;

import enums.FontAwesome5;
import enums.FontSize;
import jiconfont.swing.IconFontSwing;
import views.old.components.Component;
import views.old.components.FlatButton;
import views.old.components.FlatLabel;
import views.old.components.FlatPanel;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.BorderLayout;
import java.awt.Color;

public class DocumentsSettings extends FlatPanel implements Component {

    public static final String NAME = "Card Documents Settings";

    private FlatLabel lbAsesores;
    private FlatLabel lbRevisores;
    private FlatLabel lbSinodales;

    private FlatButton btnAsesores;
    private FlatButton btnRevisores;
    private FlatButton btnSinodales;

    private JFileChooser fileChooser;
    private FlatButton btnSave;

    public DocumentsSettings() {
        super();
        initComponent();
    }

    @Override
    public void initComponent() {
        setName(NAME);
        setLayout(new BorderLayout());
        initSubComponents();
        setSubComponents();
    }

    @Override
    public void initSubComponents() {
        IconFontSwing.register(FontAwesome5.getIconFont());
        lbAsesores = new FlatLabel(" ",FontSize.P);
        lbRevisores = new FlatLabel(" ", FontSize.P);
        lbSinodales = new FlatLabel(" ", FontSize.P);

        btnAsesores = new FlatButton(IconFontSwing.buildIcon(FontAwesome5.FA_FILE_UPLOAD, 18, Color.white));
        btnRevisores = new FlatButton(IconFontSwing.buildIcon(FontAwesome5.FA_FILE_UPLOAD, 18, Color.white));
        btnSinodales = new FlatButton(IconFontSwing.buildIcon(FontAwesome5.FA_FILE_UPLOAD, 18, Color.white));

        fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Documentos Office Word",  "doc", "docx"));

        btnSave = new FlatButton("Guardar Configuración", IconFontSwing.buildIcon(FontAwesome5.FA_SAVE, 18, Color.white));

        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        initList();
    }

    @Override
    public void setSubComponents() {
        add(BorderLayout.NORTH, new FlatLabel("Configuración de plantillas", FontSize.H2));
        add(BorderLayout.SOUTH, btnSave);
    }

    private void initList() {
        FlatPanel pnlMain = new FlatPanel(new BorderLayout());

        add(BorderLayout.CENTER, pnlMain);
    }
}
