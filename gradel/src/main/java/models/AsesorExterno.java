
package models;

/**
 *
 * @author aarongmx
 */
public class AsesorExterno extends Persona {
    private int asesorExternoId;
    private String cargo;
    private int empresaId;

    public static final String ASESOR_EXTERNO_ID = "asesor_externo_id";
    public static final String CARGO = "cargo";
    public static final String FK_EMPRESA_ID = "empresa_id";

    public AsesorExterno( int asesorExternoId, String cargo, int empresaId, String nombres, String apellidoPaterno, String apellidoMaterno ) {
        super(nombres, apellidoPaterno, apellidoMaterno);
        this.asesorExternoId = asesorExternoId;
        this.cargo = cargo;
        this.empresaId = empresaId;
    }

    public int getAsesorExternoId() {
        return asesorExternoId;
    }

    public void setAsesorExternoId( int asesorExternoId ) {
        this.asesorExternoId = asesorExternoId;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo( String cargo ) {
        this.cargo = cargo;
    }

    public int getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId( int empresaId ) {
        this.empresaId = empresaId;
    }
    
}
