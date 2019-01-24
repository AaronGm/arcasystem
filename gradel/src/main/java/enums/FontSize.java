package enums;

public enum FontSize {
    H1(31f),
    H2(26f),
    H3(18f),
    P(16f),
    SM(13f),
    SL(11f);

    private float size;

    FontSize(float size) {
        this.size = size;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }
}
