/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import static helpers.Helpers.FONTS_PATH;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aarongmx
 */
public class Typography {
    private static Map<String, String> fontFamilies;
    private static Map<String, Float> fontSizes;
    
    private static void initFontFamilies() {
        fontFamilies = new HashMap<>();
        fontFamilies.put("Open Sans Light", FONTS_PATH + "OpenSans-Light.ttf");
        fontFamilies.put("Open Sans", FONTS_PATH + "OpenSans-Regular.ttf");
        fontFamilies.put("Open Sans Medium", FONTS_PATH + "OpenSans-SemiBold.ttf");
        
        fontFamilies.put("Raleway Light", FONTS_PATH + "Raleway-Light.ttf");
        fontFamilies.put("Raleway", FONTS_PATH + "Raleway-Regular.ttf");
        fontFamilies.put("Raleway Medium", FONTS_PATH + "Raleway-Medium.ttf");
        
        fontFamilies.put("Roboto", FONTS_PATH + "Roboto-Regular.ttf");
        fontFamilies.put("Roboto Medium", FONTS_PATH + "Roboto-Medium.ttf");
        fontFamilies.put("Roboto Bold", FONTS_PATH + "Roboto-Bold.ttf");
    }
    
    private static void initFontSizes() {
        fontSizes = new HashMap<>();
        fontSizes.put("h1", 31F);
        fontSizes.put("h2", 26F);
        fontSizes.put("h3", 18F);
        fontSizes.put("pr", 16F);
        fontSizes.put("sm", 13F);
        fontSizes.put("sl", 11F);
    }
    
    public static Font addFont(String fontName, String fontSize) {
        Font font = null;
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File(getFontName(fontName)));
            font = font.deriveFont(getFontSize(fontSize));
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(Typography.class.getName()).log(Level.SEVERE, null, ex);
        }
        return font;
    }
    
    public static Font addFont(String fontName, float fontSize) {
        Font font = null;
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File(getFontName(fontName)));
            font = font.deriveFont(fontSize);
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(Typography.class.getName()).log(Level.SEVERE, null, ex);
        }
        return font;
    }
    
    public static String getFontName(String font) {
        initFontFamilies();
        return fontFamilies.get(font);
    }
    
    public static float getFontSize(String font) {
        initFontSizes();
        return fontSizes.get(font);
    }

    public static Font paragraphFont() {
        Font font = addFont("Open Sans", "pr");
        return font;
    }

    public static Font titleFont(String fontSize) {
        Font font = addFont("Raleway", fontSize);
        return font;
    }
    
    public static Font componentsFont() {
        Font font = addFont("Roboto Medium", "sm");
        return font;
    }
    
    public static Font componentsFont(String size) {
        Font font = addFont("Roboto Medium", size);
        return font;
    }
    
    public static Font componentsFont(float size) {
        Font font = addFont("Roboto Medium", size);
        return font;
    }
}
