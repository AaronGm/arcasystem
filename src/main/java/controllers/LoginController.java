
package controllers;

import dao.postgres.UsuarioDB;
import excepciones.ExcepcionGeneral;
import models.Usuario;
import views.old.LoginView;
import views.old.admin.Admin;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;

/**
 *
 * @author aarongmx
 */
public class LoginController {

    public static String CURRENT_USER;

    /**
     * Acceso a la aplicación
     * @return view
     */
    public JFrame login() {
        UsuarioDB usuarioDB = new UsuarioDB();
        LoginView view = new LoginView();
        try {
            view.getBtnSend().addActionListener(( ActionEvent e ) -> {
                Usuario usuario = usuarioDB.login(
                    view.getUserField().getText(),
                    String.valueOf(view.getPasswdField().getPassword())
                );
                
                if ( usuario == null) {
                    JOptionPane.showMessageDialog(null, "¡El usuario o la contraseña no coinciden!", "Error", JOptionPane.ERROR_MESSAGE);
                }

                if(usuario != null) {
                    CURRENT_USER = usuario.getUsuario();
                    if ( usuario.isAdmin() ) {
                        view.dispose();
                        new Admin().setVisible(true);
                    } else {
                        view.dispose();
//                        new PanelController().show().setVisible(true);
                    }
                }
            });
            
        } catch ( ExcepcionGeneral e ) {
            System.out.println(e.getMessage());
        }
        return view;
    }
}
