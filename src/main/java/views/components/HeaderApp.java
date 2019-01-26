
package views.components;

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
    private JLabel subtituloVentana;
    
    public HeaderApp(String titulo) {
        tituloVentana = new JLabel(titulo);
        initComponent();
    }
    
    private void initComponent() {
        tituloVentana.setFont(Typography.addFont(FontFamily.RALEWAY, FontSize.H1));
        setBackground(Color.white);
        setLayout(new BorderLayout());
        setBorder(Helpers.padding(SpacingPoints.SP16, SpacingPoints.SP36));
        add(tituloVentana, BorderLayout.WEST);
        add(Helpers.logoItiz(60), BorderLayout.EAST);
    }

    public JLabel getTituloVentana() {
        return tituloVentana;
    }

    public void setTituloVentana(JLabel tituloVentana) {
        this.tituloVentana = tituloVentana;
    }

    public JLabel getSubtituloVentana() {
        return subtituloVentana;
    }

    public void setSubtituloVentana(JLabel subtituloVentana) {
        this.subtituloVentana = subtituloVentana;
    }    
}
