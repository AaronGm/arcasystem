/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author aarongmx
 */
public class Helpers {
    /**
     * Ruta a las fuentes tipográficas del proyecto
     * C:\Users\aarongmx\Documents\arcasystem\gradel\src\main\resources\fonts
     */
    public static String FONTS_PATH = ClassLoader.getSystemClassLoader().getResource("./fonts/").getPath();
    
    /**
     * Ruta a las imagenes del proyecto
     */
    public static String IMAGES_PATH = ClassLoader.getSystemClassLoader().getResource("./img/").getPath();
    
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
    public final static Dimension MINIMO_PANTALLA = new Dimension(PANTALLA.width - 260, PANTALLA.height - 80);
    
    /**
     * Dimension para las vistas
     */
    public final static Dimension SIZE_PANTALLA = new Dimension(PANTALLA.width - 20, PANTALLA.height);

    /**
     * Retorna un nuevo inset
     * @param padding
     * @return
     */
    public static Insets paddingInset(int padding) {
        return new Insets(padding, padding, padding, padding);
    }

    public static Insets paddingInset(int top, int right, int bottom, int left) {
        return new Insets(top, left, bottom, right);
    }

    public static Insets paddingInset(int topBottom, int leftRight) {
        return new Insets(topBottom, leftRight, topBottom, leftRight);
    }


    /**
     * Función para hacer un margen interno en los componentes
     * @param padding
     * @return 
     */
    public static Border padding(int padding) {
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
    public static Border padding(int top, int right, int bottom, int left) {
        return new EmptyBorder(paddingInset(top, right, bottom, left));
    }
    
    /**
     * Variación estilo CSS para los paddings
     * @param topBottom
     * @param leftRight
     * @return 
     */
    public static Border padding(int topBottom, int leftRight) {
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
     * Retorna un JLabel con la imagen seleccionada con un tamaño por defecto de 80x80
     * @param image
     * @return 
     */
    public static JLabel makeImage(String image) {
        JLabel label = new JLabel();
        label.setSize(80, 80);
        setImage(image, label);
        return label;
    }
    
    /**
     * Retorna un JLabel con la imagen seleccionada
     * @param image
     * @param size
     * @return 
     */
    public static JLabel makeImage(String image, Dimension size) {
        JLabel label = new JLabel();
        label.setSize(size.width, size.height);
        setImage(image, label);
        return label;
    }
    
    /**
     * Logotipo ITIZ
     * @param size
     * @return 
     */
    public static JLabel logoItiz(int size) {
        return makeImage("logo-itiz.png", new Dimension(size, size));
    }
    
    /**
     * Logotipo SEP
     * @param size
     * @return 
     */
    public static JLabel logoSep(Dimension size) {
        return makeImage("logo-sep.png", size);
    }
    
    /**
     * Logotipo TECNM
     * @param size
     * @return 
     */
    public static JLabel logoTecnm(Dimension size) {
        return makeImage("logo-tecnm.png", size);
    }
    
    public static void minScreenSize(JFrame frame) {
        ImageIcon icon = new ImageIcon(IMAGES_PATH + "logo-itiz64.png");
        frame.setIconImage(icon.getImage());
        frame.setMinimumSize(MINIMO_PANTALLA);
        frame.setSize(PANTALLA);
    }
    
    public static void centerCloseScreen(JFrame frame) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }
    
    /**
     * Este método retorna los siguientes periodos escolares, tomando como referencia el año actual
     * @return 
     */
    public static List<String> getPeriodo() {
        ArrayList<String> periodos = new ArrayList<>();
        LocalDate date = LocalDate.now();
        for (byte i = 0; i < 5; i++) {
            for (byte j = 0; j < 1; j++) {
                periodos.add("Enero - Junio " +  date.plusYears(i).getYear());
                periodos.add("Agosto - Diciembre " +  date.plusYears(i).getYear());
            }
        }
        return periodos;
    }

    public static void cleanFields(JTextField... fields) {
        Arrays.asList(fields).forEach(field -> {
            field.setText("");
        });
    }
    
    /**
     * Función para hacer log de Objetos
     * @param o 
     */
    public static void log(Object o) {
        System.out.println(o);
    }
    
    /**
     * Colorear background blanco de multiples componentes
     * @param component 
     */
    public static void setWhite(JComponent... component) {
        Arrays.asList(component).forEach(el -> {
            el.setBackground(Color.white);
        });
    }

    public static String fechaDocumentos() {
        String fecha = FECHA.format(DateTimeFormatter.ofPattern("dd/MMMM/YYYY"));
        String mes = FECHA.getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault());
        return fecha.replace(mes, capitalize(mes));
    }

    public static String capitalize(String word) {
        char wordC[] = word.toCharArray();
        wordC[0] = word.toUpperCase().charAt(0);
        return String.valueOf(wordC);
    }

    public static KeyAdapter onlyNumbers() {
        KeyAdapter keyAdapter = new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar()) && !(e.getKeyChar() != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
            }
        };
        return keyAdapter;
    }

    public static KeyAdapter onlyLetters() {
        KeyAdapter keyAdapter = new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isLetter(e.getKeyChar()) && !(e.getKeyChar() == KeyEvent.VK_SPACE) && !(e.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
            }
        };
        return keyAdapter;
    }

    public static String cleanField(JFormattedTextField formattedTextField) {
        String value = (String) formattedTextField.getValue();
        return value.trim();
    }

}
