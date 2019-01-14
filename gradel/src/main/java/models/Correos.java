package models;

public class Correos {
    private int correoId;
    private String correo;

    public static final String CORREO_ID ="correo_id";
    public static final String CORREO ="correo";


    public Correos(int correoId, String correo) {
        this.correoId = correoId;
        this.correo = correo;
    }

    public int getCorreoId() {
        return correoId;
    }

    public void setCorreoId(int correoId) {
        this.correoId = correoId;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
