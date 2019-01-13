/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author aarongmx
 */
public class TelefonoEmpresa extends Telefonos {

    private int empresaId;

    public static final String FK_EMPRESA_ID = "empresa_id";

    public TelefonoEmpresa(int telefonoId, String telefono, int empresaId) {
        super(telefonoId, telefono);
        this.empresaId = empresaId;
    }

    public int getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(int empresaId) {
        this.empresaId = empresaId;
    }
}
