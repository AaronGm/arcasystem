package models;

public class CorreoAlumno extends Correos {

    private String noControl;

    public static String FK_NO_CONTROL = "no_control";

    public CorreoAlumno(String correo, String noControl) {
        super(correo);
        this.noControl = noControl;
    }

    public CorreoAlumno(int correoId, String correo, String noControl) {
        super(correoId, correo);
        this.noControl = noControl;
    }

    public String getNoControl() {
        return noControl;
    }

    public void setNoControl(String noControl) {
        this.noControl = noControl;
    }
}
