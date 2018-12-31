/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author aarongmx
 */
public class Helpers {
    /**
     * Rutas a los recursos del proyecto
     */
    public static String FONTS_PATH = "src/assets/fonts/";
    public static String IMAGES_PATH = "src/assets/img/";
    public static LocalDate FECHA = LocalDate.now();
    public static Dimension PANTALLA = Toolkit.getDefaultToolkit().getScreenSize();
    public final static Dimension MINIMO_PANTALLA = new Dimension(PANTALLA.width - 300, PANTALLA.height - 150);
    
        
    /**
     * Funcion para hacer un margen interno en los componentes
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
    
    public static JLabel logoItiz(int size) {
        JLabel icon = new JLabel();
        icon.setSize(size, size);
        setImage("logo-itiz.png", icon);
        return icon;
    }
    
    public static JLabel logoSep(int size) {
        JLabel icon = new JLabel();
        icon.setSize(size * 2 + 20, size);
        setImage("logo-sep.png", icon);
        return icon;
    }
    
    public static JLabel logoTecnm(int size) {
        JLabel icon = new JLabel();
        icon.setSize(size * 2 + 10, size);
        setImage("logo-tecnm.png", icon);
        return icon;
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
    
}
