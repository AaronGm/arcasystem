
package views.components;

import enums.FontFamily;
import enums.FontSize;
import helpers.Colors;
import helpers.Typography;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.text.JTextComponent;
import java.awt.Color;

/**
 *
 * @author aarongmx
 */
public class FlatLabel extends JLabel {

    public FlatLabel(String text, Icon icon, int horizontalAlignment) {
        super(text, icon, horizontalAlignment);
        initComponent();
    }

    public FlatLabel(FontFamily fontFamily, FontSize fontSize, Color fontColor) {
        super();
        initComponent();
        setForeground(fontColor);
        setFont(Typography.addFont(fontFamily, fontSize));
    }

    public FlatLabel(String text, FontFamily fontFamily, FontSize fontSize, Color fontColor) {
        super(text);
        initComponent();
        setForeground(fontColor);
        setFont(Typography.addFont(fontFamily, fontSize));
    }
    
    public FlatLabel(String text, FontFamily fontFamily, FontSize fontSize) {
        super(text);
        initComponent();
        setFont(Typography.addFont(fontFamily, fontSize));
    }

    public FlatLabel(FontFamily fontFamily, FontSize fontSize) {
        super();
        initComponent();
        setFont(Typography.addFont(fontFamily, fontSize));
    }

    public FlatLabel(String text, Color fontColor) {
        super(text);
        initComponent();
        setForeground(fontColor);
    }

    public FlatLabel(String text, FontSize fontSize, Color fontColor) {
        super(text);
        initComponent();
        setForeground(fontColor);
        switch(fontSize) {
            case H1:
            case H2:
            case H3:
                setFont(helpers.Typography.addFont(FontFamily.RALEWAY, fontSize));
                break;
            case P:
            case SM:
            case SL:
                setFont(helpers.Typography.addFont(FontFamily.OPEN_SANS, fontSize));
                break;
        }
    }

    public FlatLabel(FontSize fontSize) {
        super();
        initComponent();
        setFont(Typography.addFont(FontFamily.OPEN_SANS, fontSize));
    }
    
    public FlatLabel(String text, FontSize fontSize) {
        super(text);
        initComponent();
        switch(fontSize) {
            case H1:
            case H2:
            case H3:
                setFont(helpers.Typography.addFont(FontFamily.RALEWAY, fontSize));
                break;
            case P:
            case SM:
            case SL:
                setFont(helpers.Typography.addFont(FontFamily.OPEN_SANS, fontSize));
                break;
        }
    }

    public FlatLabel(String text, int horizontalAlignment) {
        super(text, horizontalAlignment);
        initComponent();
    }
    
    public FlatLabel(String text) {
        super(text);
        initComponent();
    }

    public FlatLabel(Icon image, int horizontalAlignment) {
        super(image, horizontalAlignment);
        initComponent();
    }

    public FlatLabel(Icon image) {
        super(image);
        initComponent();
    }

    public FlatLabel() {
        initComponent();
    }

    private void initComponent() {
        setFont(Typography.componentsFont());
        setForeground(Colors.BLACK_MEDIUM);
    }

    public void styleError() {
        setForeground(Colors.RED);
    }

    public static void styleError(FlatLabel... flatLabels) {
        for (FlatLabel flatLabel : flatLabels) {
            flatLabel.setForeground(Colors.RED);
        }
    }
    
}
