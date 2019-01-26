package enums;

public enum SpacingPoints {
    /**
     * 16 Spacing Points
     * 8
     * 16
     * 24
     * 36
     * 64
     * 128
     */
    SP_NONE(0),
    SP8(8),
    SP16(16),
    SP24(24),
    SP36(36),
    SP64(64),
    SP128(128);

    private int size;

    SpacingPoints(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
