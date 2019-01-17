
package views.components;

import helpers.Colors;
import helpers.Helpers;

import javax.swing.JFormattedTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.text.JTextComponent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.Format;

/**
 *
 * @author aarongmx
 */
public class FlatTextField extends JFormattedTextField {

    private static Insets sizeBorderMaterial = Helpers.paddingInset(0, 0, 2, 0);
    private static Border defaultBorderMaterial = new CompoundBorder(
        new MatteBorder(sizeBorderMaterial, Colors.DEFAULT_COMPONENT),
        helpers.Helpers.padding(0, 8)
    );

    public FlatTextField() {
        initComponent();
    }

    public FlatTextField(Object value) {
        super(value);
        initComponent();
    }

    public FlatTextField(Format format) {
        super(format);
        initComponent();
    }

    public FlatTextField(AbstractFormatter formatter) {
        super(formatter);
        initComponent();
    }

    public FlatTextField(AbstractFormatterFactory factory) {
        super(factory);
        initComponent();
    }

    public FlatTextField(AbstractFormatterFactory factory, Object currentValue) {
        super(factory, currentValue);
        initComponent();
    }
    
    private void initComponent() {
        Border defaultBorder = new CompoundBorder(
                new MatteBorder(Helpers.paddingInset(1), Colors.DEFAULT_COMPONENT),
                helpers.Helpers.padding(0, 8)
        );
        setMinimumSize(new Dimension(300, 30));
        setPreferredSize(new Dimension(330, 30));
        setFont(helpers.Typography.paragraphFont());
        setForeground(Colors.BLACK);
        setSelectionColor(Colors.SELECTED_COMPONENT);
        setSelectedTextColor(Color.white);
        setBorder(defaultBorder);
        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                    setBorder(new CompoundBorder(
                        new MatteBorder(Helpers.paddingInset(2), Colors.SELECTED_COMPONENT),
                        helpers.Helpers.padding(0, 8)
                    ));
            }

            @Override
            public void focusLost(FocusEvent e) {
                setBorder(defaultBorder);
            }
        });
    }

    public static void styleMaterial(JTextComponent component) {
        component.setBorder(defaultBorderMaterial);
        component.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                component.setBorder(new CompoundBorder(
                    new MatteBorder(sizeBorderMaterial, Colors.SELECTED_COMPONENT),
                    helpers.Helpers.padding(0, 8)
                ));
            }

            @Override
            public void focusLost(FocusEvent e) {
                component.setBorder(defaultBorderMaterial);
            }
        });

    }

    public static void styleMaterial(JTextComponent component, Color color) {
        component.setBorder(defaultBorderMaterial);
        component.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                component.setBorder(new CompoundBorder(
                    new MatteBorder(sizeBorderMaterial, color),
                    helpers.Helpers.padding(0, 8)
                ));
            }

            @Override
            public void focusLost(FocusEvent e) {
                component.setBorder(defaultBorderMaterial);
            }
        });
    }
}
