package models;

public class HistorialAlumno {
    private int id;
    private Alumno alumno;
    private Empresa empresa;
    private Proyecto proyecto;
    private AsesorExterno asesorExterno;

    public static final String TABLE = "historial_residentes";
    public static final String ID = "historial_id";
    public static final String FK_NO_CONTROL = "no_control";
    public static final String FK_EMPRESA_ID = "empresa_id";
    public static final String FK_PROYECTO_ID = "proyecto_id";
    public static final String FK_ASESOR_EXTERNO_ID = "asesor_externo_id";

    public HistorialAlumno(int id, Alumno alumno, Empresa empresa, Proyecto proyecto, AsesorExterno asesorExterno) {
        this.id = id;
        this.alumno = alumno;
        this.empresa = empresa;
        this.proyecto = proyecto;
        this.asesorExterno = asesorExterno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public AsesorExterno getAsesorExterno() {
        return asesorExterno;
    }

    public void setAsesorExterno(AsesorExterno asesorExterno) {
        this.asesorExterno = asesorExterno;
    }
}
