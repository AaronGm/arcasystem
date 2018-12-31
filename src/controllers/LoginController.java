/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.postgres.PostgresUsuario;
import excepciones.ExcepcionGeneral;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;
import models.Usuario;
import views.RegistrarProyecto;
import views.LoginView;
import views.admin.Admin;

/**
 *
 * @author aarongmx
 */
public class LoginController {
    
    private final LoginView view;
    
    public LoginController(LoginView view) {
        this.view = view;
    }

    
    /**
     * Verifica si el usuario tiene acceso a la aplicación 
     * @return  
     */
    public JFrame login() {
        IconFontSwing.register(FontAwesome.getIconFont());
        PostgresUsuario postgresUsuario = new PostgresUsuario();
        try {
            view.getBtnSend().addActionListener(( ActionEvent e ) -> {
                Usuario usuario = postgresUsuario.login(
                    view.getUserField().getText(),
                    String.valueOf(view.getPasswdField().getPassword())
                );
                
                if ( usuario == null) {
                    JOptionPane.showMessageDialog(null, "¡El usuario o la contraseña no coinciden!", "Error", JOptionPane.ERROR_MESSAGE);
                }

                if(usuario != null) {
                    if ( usuario.isAdmin() ) {
                        view.dispose();
                        new Admin().setVisible(true);
                    } else {
                        view.dispose();
                        new RegistrarProyecto().setVisible(true);
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