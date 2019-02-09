
package views.old.components;

import enums.SpacingPoints;
import helpers.Colors;

import javax.swing.JScrollBar;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;

/**
 *
 * @author aarongmx
 */
public class FlatScrollBar extends JScrollBar {

    public FlatScrollBar() {
        initComponent();
    }
    
    private void initComponent() {
        setOpaque(false);
        setPreferredSize(new Dimension(12, 120));
        setBorder(new EmptyBorder(0, 0, 0, 0));
        setBackground(Colors.GHOST);
        setUnitIncrement(SpacingPoints.SP36.getSize());
    }

}
