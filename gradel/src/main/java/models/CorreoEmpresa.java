package models;

public class CorreoEmpresa extends Correos {

    private int empresaId;

    public static final String FK_EMPRESA_ID = "empresa_id";

    public CorreoEmpresa(int correoId, String correo, int empresaId) {
        super(correoId, correo);
        this.empresaId = empresaId;
    }

    public int getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(int empresaId) {
        this.empresaId = empresaId;
    }
}
