package views.old.components;

import enums.FontAwesome5;
import enums.SpacingPoints;
import helpers.Colors;
import helpers.Helpers;
import helpers.Typography;
import jiconfont.swing.IconFontSwing;

import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ItemEvent;

public class FlatToggleButton extends JToggleButton implements Component {

    private Border defaultBorder;
    private FontAwesome5 icono;
    private Color colorIcono;

    public FlatToggleButton(String text, FontAwesome5 icono, Color colorIcono) {
        super(text);
        this.icono = icono;
        this.colorIcono = colorIcono;
        setIcon(IconFontSwing.buildIcon(icono, 18, colorIcono));
        initComponent();
    }

    @Override
    public void initComponent() {
        defaultBorder = new CompoundBorder(null, Helpers.padding(SpacingPoints.SP8, SpacingPoints.SP16));
        setHorizontalAlignment(SwingConstants.LEFT);
        setPreferredSize(new Dimension(220, 30));
        setFont(Typography.componentsFont());
        setForeground(Colors.TEXT_COLOR);
        setBorder(defaultBorder);
        setBackground(null);
        setFocusPainted(false);
        initSubComponents();
        setSubComponents();
        addItemListener(((ItemEvent e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                setBorder(new CompoundBorder(new MatteBorder(0, 2, 0, 0, Colors.BLUE_LIGHT), Helpers.padding(SpacingPoints.SP8, SpacingPoints.SP16)));
                setForeground(Colors.INDIGO);
                setIcon(IconFontSwing.buildIcon(icono, 18, Colors.INDIGO));
            } else {
                setBorder(defaultBorder);
                setForeground(Colors.TEXT_COLOR);
                setIcon(IconFontSwing.buildIcon(icono, 18, colorIcono));
            }
        }));
    }

    @Override
    public void initSubComponents() {

    }

    @Override
    public void setSubComponents() {

    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        if (this.isSelected()) {
            g.setColor(Color.orange);
        } else {
            g.setColor(getBackground());
        }
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}
