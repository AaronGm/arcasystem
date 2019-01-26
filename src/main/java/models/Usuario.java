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
public class Usuario {
    private int usuarioId;
    private String usuario;
    private String passwd;
    private boolean admin;

    public static final String USUARIO_ID = "usuario_id";
    public static final String USUARIO = "usuario";
    public static final String PASSWD = "passwd";
    public static final String IS_ADMIN = "is_admin";

    public Usuario() {
        
    }

    public Usuario( String usuario, String passwd, boolean admin ) {
        this.usuario = usuario;
        this.passwd = passwd;
        this.admin = admin;
    }

    public Usuario( int usuarioId, String usuario, String passwd, boolean admin ) {
        this.usuarioId = usuarioId;
        this.usuario = usuario;
        this.passwd = passwd;
        this.admin = admin;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId( int usuarioId ) {
        this.usuarioId = usuarioId;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario( String usuario ) {
        this.usuario = usuario;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd( String passwd ) {
        this.passwd = passwd;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin( boolean admin ) {
        this.admin = admin;
    }
    
    @Override
    public String toString() {
        return "Usuario: " + this.usuario + "\nContraseña: " + this.passwd + "\nEs administrador: " + this.admin;
    }
}
