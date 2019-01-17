package models;

public class HistorialAlumno {
    private int id;
    private String noControl;
    private int empresaId;
    private int proyectoId;
    private int asesorExternoId;

    public static final String TABLE = "historial_residentes";
    public static final String ID = "historial_id";
    public static final String FK_NO_CONTROL = "no_control";
    public static final String FK_EMPRESA_ID = "empresa_id";
    public static final String FK_PROYECTO_ID = "proyecto_id";
    public static final String FK_ASESOR_EXTERNO_ID = "asesor_externo_id";

    public HistorialAlumno(int id, String noControl, int empresaId, int proyectoId, int asesorExternoId) {
        this.id = id;
        this.noControl = noControl;
        this.empresaId = empresaId;
        this.proyectoId = proyectoId;
        this.asesorExternoId = asesorExternoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoControl() {
        return noControl;
    }

    public void setNoControl(String noControl) {
        this.noControl = noControl;
    }

    public int getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(int empresaId) {
        this.empresaId = empresaId;
    }

    public int getProyectoId() {
        return proyectoId;
    }

    public void setProyectoId(int proyectoId) {
        this.proyectoId = proyectoId;
    }

    public int getAsesorExternoId() {
        return asesorExternoId;
    }

    public void setAsesorExternoId(int asesorExternoId) {
        this.asesorExternoId = asesorExternoId;
    }
}
