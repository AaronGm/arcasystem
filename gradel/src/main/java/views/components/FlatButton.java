
package views.components;

import enums.SpacingPoints;
import helpers.Colors;
import helpers.Helpers;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 *
 * @author aarongmx
 */
public class FlatButton extends JButton {
    
    private Color pressedColor;

    public FlatButton() {
        initComponent();
    }

    public FlatButton(Icon icon) {
        super(icon);
        initComponent();
    }

    public FlatButton(String text) {
        super(text.toUpperCase());
        initComponent();
    }

    public FlatButton(Action a) {
        super(a);
        initComponent();
    }
    
    public FlatButton(Icon icon, ActionListener action) {
        super(icon);
        super.addActionListener(action);
        initComponent();
    }

    public FlatButton(String text, Icon icon) {
        super(text.toUpperCase(), icon);
        super.setContentAreaFilled(false);
        initComponent();
    }
    
    public FlatButton(String text, Icon icon, Action action) {
        super(text, icon);
        super.setAction(action);
        initComponent();
    }

    private void initComponent() {
        setBackground(Colors.SELECTED_COMPONENT);
        setForeground(Color.white);
        setFont(helpers.Typography.componentsFont());
        setBorder(Helpers.padding(SpacingPoints.SP8, SpacingPoints.SP16));
        setFocusPainted(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        addFocusListener(new FocusListener() {
            Color originalBG = getBackground();
            @Override
            public void focusGained(FocusEvent e) {

                setBackground(originalBG.brighter());
            }

            @Override
            public void focusLost(FocusEvent e) {
                setBackground(originalBG);
            }
        });
    }
    
    public void styleGhost() {
        setBackground(Color.white);
        setForeground(Colors.BLACK_MEDIUM);
        setPressedColor(Colors.GHOST);
        addFocusListener(new FocusListener() {
            Color originalBG = getBackground();
            @Override
            public void focusGained(FocusEvent e) {
                setBackground(originalBG);
            }

            @Override
            public void focusLost(FocusEvent e) {
                setBackground(originalBG);
            }
        });
    }

    public Color getPressedColor() {
        return (pressedColor == null) ? getBackground().brighter() : pressedColor;
    }

    public void setPressedColor(Color pressedColor) {
        this.pressedColor = pressedColor;
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isPressed()) {
            g.setColor(getPressedColor());
        } else {
            g.setColor(getBackground());
        }
                
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }

    @Override
    public void setContentAreaFilled(boolean b) {
    }

}
