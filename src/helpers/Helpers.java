/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author aarongmx
 */
public class Helpers {
    /**
     * Ruta a las fuentes tipográficas del proyecto
     */
    public static String FONTS_PATH = "src/assets/fonts/";
    
    /**
     * Ruta a las imagenes del proyecto
     */
    public static String IMAGES_PATH = "src/assets/img/";
    
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
    public final static Dimension MINIMO_PANTALLA = new Dimension(PANTALLA.width - 400, PANTALLA.height - 100);
    
        
    /**
     * Función para hacer un margen interno en los componentes
     * @param padding
     * @return 
     */
    public static Border padding(int padding) {
        return new EmptyBorder(padding, padding, padding, padding);
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
        return new EmptyBorder(top, left, bottom, right);
    }
    
    /**
     * Variación estilo CSS para los paddings
     * @param topBottom
     * @param leftRight
     * @return 
     */
    public static Border padding(int topBottom, int leftRight) {
        return new EmptyBorder(topBottom, leftRight, topBottom, leftRight);
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
        frame.setMinimumSize(MINIMO_PANTALLA);
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
    
}
