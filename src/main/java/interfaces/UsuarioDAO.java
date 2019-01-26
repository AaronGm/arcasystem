
package interfaces;

import models.Usuario;

/**
 *
 * @author aarongmx
 */
public interface UsuarioDAO extends DAO<Integer, Usuario> {
    Usuario login(String usuario, String password);
    boolean auth(String usuario, String password);
}
