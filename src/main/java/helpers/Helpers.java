
package helpers;

import enums.SpacingPoints;
import views.old.components.FlatLabel;
import views.old.components.FlatPanel;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/**
 *
 * @author aarongmx
 */
public class Helpers {
    /**
     * Ruta a las fuentes tipográficas del proyecto
     */
    public static String FONTS_PATH = Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResource("./fonts/")).getPath();
    
    /**
     * Ruta a las imagenes del proyecto
     */
    public static String IMAGES_PATH = Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResource("./img/")).getPath();
    
    /**
     * Fecha actual
     */
    public static LocalDate FECHA = LocalDate.now();
    
    /**
     * Tamaño de la pantalla actual
     */
    public static Dimension PANTALLA = Toolkit.getDefaultToolkit().getScreenSize();
    
    /**
     * Dimension mínima para las vistas
     */
    public final static Dimension MINIMO_PANTALLA = new Dimension(PANTALLA.width - 220, PANTALLA.height - 80);
    
    /**
     * Dimension para las vistas
     */
    public final static Dimension SIZE_PANTALLA = new Dimension(PANTALLA.width - 120, PANTALLA.height - 60);

    /**
     * Tamaño para los iconos de los componentes customizados
     */
    public final static int ICON_SIZE = 18;


    /**
     * Retorna un nuevo inset
     * @param padding
     * @return
     */
    public static Insets paddingInset(SpacingPoints padding) {
        return new Insets(padding.getSize(), padding.getSize(), padding.getSize(), padding.getSize());
    }

    public static Insets paddingInset(SpacingPoints top, SpacingPoints right, SpacingPoints bottom, SpacingPoints left) {
        return new Insets(top.getSize(), left.getSize(), bottom.getSize(), right.getSize());
    }

    public static Insets paddingInset(SpacingPoints topBottom, SpacingPoints leftRight) {
        return new Insets(topBottom.getSize(), leftRight.getSize(), topBottom.getSize(), leftRight.getSize());
    }


    /**
     * Función para hacer un margen interno en los componentes
     * @param padding
     * @return 
     */
    public static Border padding(SpacingPoints padding) {
        return new EmptyBorder(paddingInset(padding));
    }
    
    /**
     * Variación estilo CSS para los padding con 4 medidas independientes
     * @param top
     * @param right
     * @param bottom
     * @param left
     * @return 
     */
    public static Border padding(SpacingPoints top, SpacingPoints right, SpacingPoints bottom, SpacingPoints left) {
        return new EmptyBorder(paddingInset(top, right, bottom, left));
    }
    
    /**
     * Variación estilo CSS para los paddings
     * @param topBottom
     * @param leftRight
     * @return 
     */
    public static Border padding(SpacingPoints topBottom, SpacingPoints leftRight) {
        return new EmptyBorder(paddingInset(topBottom, leftRight));
    }
    
    /**
     * Funcion para crear una imagen dentro de una etiqueta(JLabel)
     * @param imagen
     * @param label 
     */
    public static void setImage(String imagen, JLabel label) {
        ImageIcon icon = new ImageIcon(IMAGES_PATH + imagen);
        ImageIcon icn = new ImageIcon(icon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH));
        label.setIcon(icn);
    }
    
    /**
     * Retorna un JLabel con la imagen seleccionada
     * @param image
     * @param width
     * @param height
     * @return label
     */
    public static JLabel makeImage(String image, int width, int height) {
        JLabel label = new JLabel();
        label.setSize(new Dimension(width, height));
        setImage(image, label);
        return label;
    }
    
    /**
     * Logotipo ITIZ
     * @param size
     * @return 
     */
    public static JLabel logoItiz(int size) {
        return makeImage("logo-itiz.png",size, size);
    }
    
    /**
     * Logotipo SEP
     * @param width
     * @param height
     * @return
     */
    public static JLabel logoSep(int width, int height) {
        return makeImage("logo-sep.png", width, height);
    }
    
    /**
     * Logotipo TECNM
     * @param width
     * @param height
     * @return 
     */
    public static JLabel logoTecnm(int width, int height) {
        return makeImage("logo-tecnm.png", width, height);
    }
    
    public static void minScreenSize(JFrame frame) {
        ImageIcon icon = new ImageIcon(IMAGES_PATH + "logo-itiz64.png");
        frame.setIconImage(icon.getImage());
        frame.setMinimumSize(MINIMO_PANTALLA);
        frame.setSize(SIZE_PANTALLA);
    }
    
    public static void centerCloseScreen(JFrame frame) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }
    
    /**
     * Este método retorna los siguientes periodos escolares, tomando como referencia el año actual
     * @return 
     */
    public static List<String> getPeriodos() {
        ArrayList<String> periodos = new ArrayList<>();
        LocalDate date = FECHA.minusYears(1);
        for (byte i = 0; i < 5; i++) {
            for (byte j = 0; j < 1; j++) {
                periodos.add("Enero - Junio " +  date.plusYears(i).getYear());
                periodos.add("Agosto - Diciembre " +  date.plusYears(i).getYear());
            }
        }
        return periodos;
    }

    public static String currentPeriodo() {
        String periodoActual = null;
        byte mes = (byte) FECHA.getMonthValue();
        short year = (short) FECHA.getYear();
        for (byte i = 0; i < getPeriodos().size(); i++) {
            if (mes <= 7) {
                if (((i == 0) || ((i % 2) == 0)) && getPeriodos().get(i).contains(String.valueOf(year))) {
                    periodoActual = getPeriodos().get(i);
                }
            } else {
                if (getPeriodos().get(i).contains(String.valueOf(year))) {
                    periodoActual = getPeriodos().get(i);
                }
            }
        }
        return periodoActual;
    }

    public static FlatPanel groupElementsVertical(JComponent... components) {
        FlatPanel panel = new FlatPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        List<JComponent> lista = Arrays.asList(components);

        c.anchor = GridBagConstraints.WEST;
        c.insets = Helpers.paddingInset(SpacingPoints.SP_NONE, SpacingPoints.SP_NONE, SpacingPoints.SP24, SpacingPoints.SP_NONE);
        for (int i = 0; i < lista.size(); i++) {
            c.gridy = i;
            c.insets = Helpers.paddingInset(SpacingPoints.SP_NONE, SpacingPoints.SP_NONE);
            panel.add(lista.get(i), c);
        }
        return panel;
    }

    public static FlatPanel groupElementsHorizontal(JComponent... components) {
        FlatPanel panel = new FlatPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        List<JComponent> lista = Arrays.asList(components);

        for (int i = 0; i < lista.size(); i++) {
            c.gridx = i;
            c.anchor = GridBagConstraints.WEST;
            c.insets = Helpers.paddingInset(SpacingPoints.SP_NONE, SpacingPoints.SP8);
            panel.add(lista.get(i), c);
        }
        return panel;
    }


    public static FlatLabel labelIcon(Icon icon, Dimension size) {
        FlatLabel iconL = new FlatLabel(icon);
        iconL.setPreferredSize(size);
        return iconL;
    }

    public static JPanel panelHidde(int orientation, JComponent... components) {
        FlatPanel panel = new FlatPanel(new FlowLayout(orientation));
        Arrays.asList(components).forEach(panel::add);
        return panel;
    }

    public static String fechaDocumentos() {
        String fecha = FECHA.format(DateTimeFormatter.ofPattern("dd/MMMM/YYYY"));
        String mes = FECHA.getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault());
        return fecha.replace(mes, capitalize(mes));
    }

    public static String capitalize(String word) {
        char[] wordC = word.toCharArray();
        wordC[0] = word.toUpperCase().charAt(0);
        return String.valueOf(wordC);
    }

    public static FlatPanel centerAbsolute(JComponent... components) {
        FlatPanel horizontalPanel = new FlatPanel();
        FlatPanel verticalPanel = new FlatPanel();

        verticalPanel.setLayout(new BoxLayout(verticalPanel, BoxLayout.Y_AXIS));
        horizontalPanel.setLayout(new BoxLayout(horizontalPanel, BoxLayout.X_AXIS));

        Arrays.asList(components).forEach(el -> {
            FlatPanel internalPane = new FlatPanel(new FlowLayout());
            internalPane.add(el);
            verticalPanel.add(internalPane);
        });

        horizontalPanel.add(verticalPanel);

        return horizontalPanel;
    }

    public static JComponent noErrLabel() {
        return (JComponent) Box.createVerticalStrut(SpacingPoints.SP16.getSize());
    }
}
