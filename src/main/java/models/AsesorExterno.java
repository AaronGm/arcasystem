
package models;

import java.util.ArrayList;

/**
 *
 * @author aarongmx
 */
public class AsesorExterno extends Persona {
    private int asesorExternoId;
    private String cargo;
    private int empresaId;
    private String[] telefonos;
    private String[] correos;

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

    public String[] getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(String[] telefonos) {
        this.telefonos = telefonos;
    }

    public String[] getCorreos() {
        return correos;
    }

    public void setCorreos(String[] correos) {
        this.correos = correos;
    }

    @Override
    public String toString() {
        return "AsesorExterno {" +
            "\n\tasesorExternoId: " + asesorExternoId +
            "\n\tnombres: '" + getNombres() + '\'' +
            "\n\tapellidoPaterno: '" + getApellidoPaterno() + '\'' +
            "\n\tapellidoMaterno: '" + getApellidoMaterno() + '\'' +
            "\n\tcargo: '" + cargo + '\'' +
            "\n\tempresaId: " + empresaId +
            "\n}";
    }
}
