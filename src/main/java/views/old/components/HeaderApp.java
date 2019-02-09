
package views.old.components;

import enums.FontFamily;
import enums.FontSize;
import enums.SpacingPoints;
import helpers.Helpers;
import helpers.Typography;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

/**
 *
 * @author aarongmx
 */
public class HeaderApp extends JPanel {
    
    private JLabel tituloVentana;

    public HeaderApp(String titulo) {
        tituloVentana = new JLabel(titulo);
        initComponent();
    }
    
    private void initComponent() {
        tituloVentana.setFont(Typography.addFont(FontFamily.RALEWAY, FontSize.H1));
        setBackground(Color.white);
        setLayout(new BorderLayout());
        setBorder(Helpers.padding(SpacingPoints.SP16, SpacingPoints.SP36));
        add(BorderLayout.WEST, tituloVentana);
        add(BorderLayout.EAST, Helpers.logoTecnm(96, 60));
    }
}
