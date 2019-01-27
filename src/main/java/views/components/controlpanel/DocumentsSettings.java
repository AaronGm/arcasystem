package views.components.controlpanel;

import enums.FontAwesome5;
import enums.FontSize;
import enums.SpacingPoints;
import helpers.Helpers;
import jiconfont.swing.IconFontSwing;
import org.yaml.snakeyaml.Yaml;
import views.components.Component;
import views.components.FlatButton;
import views.components.FlatLabel;
import views.components.FlatPanel;

import javax.swing.BoxLayout;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

    private Yaml yaml;
    private Map<String, Object> yamlMap;
    private FileWriter fileWriter;

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
        lbAsesores = new FlatLabel(FontSize.P);
        lbRevisores = new FlatLabel(FontSize.P);
        lbSinodales = new FlatLabel(FontSize.P);

        btnAsesores = new FlatButton(IconFontSwing.buildIcon(FontAwesome5.FA_FILE_UPLOAD, 18, Color.white));
        btnRevisores = new FlatButton(IconFontSwing.buildIcon(FontAwesome5.FA_FILE_UPLOAD, 18, Color.white));
        btnSinodales = new FlatButton(IconFontSwing.buildIcon(FontAwesome5.FA_FILE_UPLOAD, 18, Color.white));

        fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Documentos Office Word", "txt", "text", "doc", "docx"));

        btnSave = new FlatButton("Guardar Configuración", IconFontSwing.buildIcon(FontAwesome5.FA_SAVE, 18, Color.white));
        yaml = new Yaml();
        yamlMap = new HashMap<>();
        try {
            fileWriter = new FileWriter("C:/Users/aarongmx/config.yaml");
        } catch (IOException e) {
            e.printStackTrace();
        }

        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        initList();
    }

    @Override
    public void setSubComponents() {
        add(BorderLayout.NORTH, new FlatLabel("Configuración de plantillas", FontSize.H2));
        add(BorderLayout.SOUTH, btnSave);
    }

    private void initList() {
        FlatPanel flatPanel = new FlatPanel(SpacingPoints.SP_NONE);
        flatPanel.setLayout(new BoxLayout(flatPanel, BoxLayout.Y_AXIS));

        FlatPanel pAsesores = new FlatPanel(new BorderLayout());
        pAsesores.add(BorderLayout.WEST, Helpers.groupElementsVertical(new FlatLabel("Plantilla para asesores: "), lbAsesores));
        pAsesores.add(BorderLayout.EAST, btnAsesores);

        FlatPanel pRevisores = new FlatPanel(new BorderLayout());
        pRevisores.add(BorderLayout.WEST, Helpers.groupElementsVertical(new FlatLabel("Plantilla para revisores: "), lbRevisores));
        pRevisores.add(BorderLayout.EAST, btnRevisores);

        FlatPanel pSinodales = new FlatPanel(new BorderLayout());
        pSinodales.add(BorderLayout.WEST, Helpers.groupElementsVertical(new FlatLabel("Plantilla para sinodales: "), lbSinodales));
        pSinodales.add(BorderLayout.EAST, btnSinodales);

        flatPanel.add(pAsesores);
        flatPanel.add(pRevisores);
        flatPanel.add(pSinodales);


        ActionListener actionListener = e -> {
            FlatButton btn = (FlatButton) e.getSource();
            fileChooser.showOpenDialog(null);
            String archivo = fileChooser.getSelectedFile().getPath();;

            if (btn == btnAsesores) {
                lbAsesores.setText(archivo);
            } else if (btn == btnRevisores) {
                lbRevisores.setText(archivo);
            } else if (btn == btnSinodales) {
                lbSinodales.setText(archivo);
            }
        };

        btnAsesores.addActionListener(actionListener);
        btnRevisores.addActionListener(actionListener);
        btnSinodales.addActionListener(actionListener);

        add(BorderLayout.CENTER, flatPanel);
    }
}
