
package controllers;

import dao.postgres.UsuarioDB;
import excepciones.ExcepcionGeneral;
import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;
import models.Usuario;
import views.LoginView;
import views.PanelControl;
import views.admin.Admin;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;

/**
 *
 * @author aarongmx
 */
public class LoginController {

    public static String CURRENT_USER;
    
    private final LoginView view;
    
    public LoginController(LoginView view) {
        IconFontSwing.register(FontAwesome.getIconFont());
        this.view = view;
    }

    
    /**
     * Verifica si el usuario tiene acceso a la aplicación 
     * @return  
     */
    public JFrame login() {
        UsuarioDB usuarioDB = new UsuarioDB();
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
                        new PanelControl().setVisible(true);
                    }
                }
            });
            
        } catch ( ExcepcionGeneral e ) {
            System.out.println(e.getMessage());
        }
        return this.view;
    }

    public void limpiarCampos() {
        view.getUserField().setText("");
        view.getPasswdField().setText("");
    }
}
