
package views.old.components;

import enums.MensajesValidacion;
import enums.SpacingPoints;
import helpers.Colors;

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
import java.awt.event.KeyEvent;
import java.text.Format;

/**
 *
 * @author aarongmx
 */
public class FlatTextField extends JFormattedTextField {
    private FlatLabel lbError;

    private static final Insets sizeBorderMaterial = new Insets(0, 0, 2, 0);
    private static final Border defaultBorderMaterial = new CompoundBorder(
        new MatteBorder(sizeBorderMaterial, Colors.DEFAULT_COMPONENT),
        helpers.Helpers.padding(SpacingPoints.SP_NONE, SpacingPoints.SP8)
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
        lbError = new FlatLabel(" ");
        lbError.styleError();
        Insets sizeBorderDefault = new Insets(1, 1, 1, 1);
        Border defaultBorder = new CompoundBorder(
                new MatteBorder(new Insets(1,1,1,1), Colors.DEFAULT_COMPONENT),
                helpers.Helpers.padding(SpacingPoints.SP_NONE, SpacingPoints.SP8)
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
                        new MatteBorder(sizeBorderDefault, Colors.SELECTED_COMPONENT),
                        helpers.Helpers.padding(SpacingPoints.SP_NONE, SpacingPoints.SP8)
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
                    helpers.Helpers.padding(SpacingPoints.SP_NONE, SpacingPoints.SP8)
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
                    helpers.Helpers.padding(SpacingPoints.SP_NONE, SpacingPoints.SP8)
                ));
            }

            @Override
            public void focusLost(FocusEvent e) {
                component.setBorder(defaultBorderMaterial);
            }
        });
    }

    public static boolean validarCampoVacio(JTextComponent textComponent, FlatLabel lbError) {
        boolean isEmpty = false;
        if (textComponent.getText().isEmpty() || textComponent.getText().equals(" ")) {
            lbError.setText(MensajesValidacion.CAMPO_VACIO.getMensaje());
            lbError.styleError();
            isEmpty = true;
        }
        return isEmpty;
    }

    public static void escribirSoloLetrasYEspacios(KeyEvent evt, FlatLabel etiquetaError){
        if(!Character.isLetter(evt.getKeyChar()) && !(evt.getKeyChar() == KeyEvent.VK_SPACE) && !(evt.getKeyChar() == KeyEvent.VK_BACK_SPACE) && !(evt.getKeyChar() == KeyEvent.VK_COMMA) && !(evt.getKeyChar() == KeyEvent.VK_QUOTE)){
            evt.consume();
            etiquetaError.setText(MensajesValidacion.SOLO_LETRAS.getMensaje());
            etiquetaError.styleError();
        } else {
            etiquetaError.setText(" ");
        }
    }

    public static void escribirSoloNumeros(KeyEvent evt, FlatLabel etiquetaError){
        if(!Character.isDigit(evt.getKeyChar()) && !(evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)){
            evt.consume();
            etiquetaError.setText(MensajesValidacion.SOLO_NUMEROS.getMensaje());
            etiquetaError.styleError();
        } else {
            etiquetaError.setText(" ");
        }
    }

    public FlatLabel getLbError() {
        return lbError;
    }
}
