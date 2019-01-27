package models;

public class TelefonosAsesorExterno {

    private int id;
    private String telefono;
    private int idAsesor;


    public TelefonosAsesorExterno(String telefono, int idAsesor) {
        this.telefono = telefono;
        this.idAsesor = idAsesor;
    }

    public TelefonosAsesorExterno(int id, String telefono, int idAsesor) {
        this.id = id;
        this.telefono = telefono;
        this.idAsesor = idAsesor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getIdAsesor() {
        return idAsesor;
    }

    public void setIdAsesor(int idAsesor) {
        this.idAsesor = idAsesor;
    }
}
