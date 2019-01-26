package enums;

import helpers.Helpers;

import java.awt.Font;

public enum FontFamily {
    OPEN_SANS_LIGHT("OpenSans-Light.ttf", Font.TRUETYPE_FONT),
    OPEN_SANS("OpenSans-Regular.ttf", Font.TRUETYPE_FONT),
    OPEN_SANS_MEDIUM("OpenSans-SemiBold.ttf", Font.BOLD),
    ROBOTO("Roboto-Regular.ttf", Font.TRUETYPE_FONT),
    ROBOTO_MEDIUM("Roboto-Medium.ttf", Font.TRUETYPE_FONT),
    ROBOTO_BOLD("Roboto-Bold.ttf", Font.BOLD),
    RALEWAY_LIGHT("Raleway-Light.ttf", Font.TRUETYPE_FONT),
    RALEWAY("Raleway-Regular.ttf", Font.TRUETYPE_FONT),
    RALEWAY_MEDIUM("Raleway-Medium.ttf", Font.BOLD);

    private String family;
    private int style;

    FontFamily(String family, int style) {
        this.family = family;
        this.style = style;
    }

    public String getFamily() {
        return Helpers.FONTS_PATH + family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public int getStyle() {
        return style;
    }

    public void setStyle(int style) {
        this.style = style;
    }
}
