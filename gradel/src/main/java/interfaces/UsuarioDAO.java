/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import models.Usuario;

/**
 *
 * @author aarongmx
 */
public interface UsuarioDAO extends DAO<Integer, Usuario> {
    Usuario login(String usuario, String password);
}