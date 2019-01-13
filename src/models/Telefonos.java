package models;

public class Telefonos {
    private int telefonoId;
    private String telefono;

    public static final String TELEFONO_ID = "telefono_id";
    public static final String TELEFONO = "telefono";

    public Telefonos(int telefonoId, String telefono) {
        this.telefonoId = telefonoId;
        this.telefono = telefono;
    }

    public int getTelefonoId() {
        return telefonoId;
    }

    public void setTelefonoId(int telefonoId) {
        this.telefonoId = telefonoId;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
