/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import enums.FontFamily;
import enums.FontSize;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aarongmx
 */
public class Typography {

    public static Font addFont(FontFamily fontFamily, FontSize fontSize) {
        Font font = null;
        try {
            font = Font.createFont(fontFamily.getStyle(), new File(fontFamily.getFamily()));
            font = font.deriveFont(fontSize.getSize());
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(Typography.class.getName()).log(Level.SEVERE, null, ex);
        }
        return font;
    }

    public static Font paragraphFont() {
        return addFont(FontFamily.OPEN_SANS, FontSize.P);
    }

    public static Font titleFont(FontSize fontSize) {
        return addFont(FontFamily.RALEWAY, fontSize);
    }
    
    public static Font componentsFont() {
        return addFont(FontFamily.ROBOTO_MEDIUM, FontSize.SM);
    }

    public static Font componentsFont(FontSize fontSize) {
        return addFont(FontFamily.ROBOTO_MEDIUM, fontSize);
    }
}
