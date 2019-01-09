/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.postgres;

import config.ConnectionDB;
import excepciones.ExcepcionGeneral;
import interfaces.UsuarioDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Usuario;

/**
 *
 * @author aarongmx
 */
public class ImplUsuario implements UsuarioDAO {
    private Connection conexion;
    private PreparedStatement sentencia;
    private ResultSet resultados;
    
    private final String LOGIN = "SELECT usuario, passwd, is_admin FROM usuarios WHERE usuario = ? AND passwd = crypt(?, passwd);";
    private final String INSERTAR = "INSERT INTO usuarios(usuario, passwd, is_admin) VALUES (?, crypt(?, gen_salt('xdes')), ?);";
    private final String ELIMINAR = "DELETE FROM usuarios WHERE usuario_id = ?;";
    private final String ACTUALIZAR = "UPDATE usuarios SET usuario = ?, passwd = ?, is_admin = ? WHERE usuario_id = ?;";
    private final String ID = "SELECT usuario_id, usuario, passwd, is_admin FROM usuarios WHERE usuario_id = ?;";
    private final String LISTAR = "SELECT usuario_id, usuario, passwd, is_admin FROM usuarios;";
    
    @Override
    public Usuario login( String usuario, String password ) {
        Usuario retUsuario = null;
        conexion = new ConnectionDB().getConnection();
        try {
            sentencia = conexion.prepareStatement(LOGIN, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            sentencia.setString(1, usuario);
            sentencia.setString(2, password);
            resultados = sentencia.executeQuery();
            if ( resultados.first() ) {
                retUsuario = new Usuario(
                    resultados.getString("usuario"),
                    resultados.getString("passwd"),
                    resultados.getBoolean("is_admin")
                );
            }
        } catch ( SQLException ex ) {
            throw new ExcepcionGeneral(ex.getMessage());
        } finally {
            ConnectionDB.closeConnection(conexion, sentencia, resultados);
        }
        return retUsuario;
    }
    
    @Override
    public void insertar( Usuario usuario ) throws ExcepcionGeneral {
        conexion = new ConnectionDB().getConnection();
        try {
            sentencia = conexion.prepareStatement(INSERTAR, Statement.RETURN_GENERATED_KEYS);
            sentencia.setString(1, usuario.getUsuario());
            sentencia.setString(2, usuario.getPasswd());
            sentencia.setBoolean(3, usuario.isAdmin());
            
            int filasAfectadas = sentencia.executeUpdate();
            if ( filasAfectadas > 0) {
                resultados = sentencia.getGeneratedKeys();
                if ( resultados.next() ) {
                    usuario.setUsuarioId(resultados.getInt(1));
                }
            }
        } catch ( SQLException ex ) {
            throw new ExcepcionGeneral(ex.getMessage());
        } finally {
            ConnectionDB.closeConnection(conexion, sentencia, resultados);
        }
    }

    @Override
    public void modificar( Usuario usuario ) {
        conexion = new ConnectionDB().getConnection();
        try {
            sentencia = conexion.prepareStatement(ACTUALIZAR);
            sentencia.setString(1, usuario.getUsuario());
            sentencia.setString(2, usuario.getPasswd());
            sentencia.setBoolean(3, usuario.isAdmin());
            if (sentencia.executeUpdate() == 0) {
                throw new ExcepcionGeneral("No se modificó ningun registro");
            }
        } catch ( SQLException ex ) {
            throw new ExcepcionGeneral(ex.getMessage());
        } finally {
            ConnectionDB.closeConnection(conexion, sentencia, resultados);
        }
    }

    @Override
    public void eliminar( Usuario usuario ) {
        conexion = new ConnectionDB().getConnection();
        try {
            sentencia = conexion.prepareStatement(ELIMINAR);
            sentencia.setInt(1, usuario.getUsuarioId());
            if (sentencia.executeUpdate() == 0) {
                throw new ExcepcionGeneral("No se eliminó ningun registro!");
            }
        } catch ( SQLException ex ) {
            throw new ExcepcionGeneral(ex.getMessage());
        } finally {
            ConnectionDB.closeConnection(conexion, sentencia, resultados);
        }
    }

    @Override
    public Usuario obtenerPorId( Integer key ) {
        Usuario usuario = null;
        conexion = new ConnectionDB().getConnection();
        try {
            sentencia = conexion.prepareStatement(ID);
            sentencia.setInt(1, key);
            resultados = sentencia.executeQuery();
            if ( resultados.first() ) {
                usuario = new Usuario(
                    resultados.getInt("usuario_id"),
                    resultados.getString("usuario"),
                    resultados.getString("passwd"),
                    resultados.getBoolean("is_admin")
                );
            }
        } catch ( SQLException ex ) {
            throw new ExcepcionGeneral(ex.getMessage());
        } finally {
            ConnectionDB.closeConnection(conexion, sentencia, resultados);
        }
        
        return usuario;
    }

    @Override
    public List<Usuario> listar() {
        List<Usuario> lista = new ArrayList<>();
        try {
            conexion = new ConnectionDB().getConnection();
            sentencia = conexion.prepareStatement(LISTAR);
            resultados = sentencia.executeQuery();
            while ( resultados.next() ) {
                lista.add(
                    new Usuario(
                        resultados.getInt("usuario_id"),
                        resultados.getString("usuario"), 
                        resultados.getString("passwd"),
                        resultados.getBoolean("is_admin")
                    )
                );
            }
        } catch ( SQLException ex ) {
            throw new ExcepcionGeneral(ex.getMessage());
        } finally {
            ConnectionDB.closeConnection(conexion, sentencia, resultados);
        }
        return lista;
    }
}
