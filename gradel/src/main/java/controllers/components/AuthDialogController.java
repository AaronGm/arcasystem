package controllers.components;

import controllers.LoginController;
import dao.postgres.UsuarioDB;
import views.components.AuthDialog;

import javax.swing.JDialog;
import java.awt.Frame;

public class AuthDialogController {

    private UsuarioDB usuarioDB;
    private AuthDialog authDialog;

    public boolean authUser(Frame frame) {
        final boolean[] isAuth = {false};
        usuarioDB = new UsuarioDB();
        authDialog = new AuthDialog(frame, "Autorización", JDialog.ModalityType.APPLICATION_MODAL);
        authDialog.setVisible(true);
        authDialog.getBtnAuth().addActionListener(l -> {
            System.out.println(LoginController.CURRENT_USER);
            isAuth[0] = usuarioDB.auth(LoginController.CURRENT_USER, String.valueOf(authDialog.getPasswd()));
        });
        return isAuth[0];
    }

}
