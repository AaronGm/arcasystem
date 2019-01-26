package controllers;

import dao.postgres.UsuarioDB;
import views.components.AuthDialog;

import java.awt.Frame;

public class AuthController {

    private AuthDialog view;
    private Frame frame;
    private boolean isAuth;

    public AuthController(Frame frame) {
        this.frame = frame;
    }


    public boolean auth() {
        view = new AuthDialog(frame);
        view.setVisible(true);
        isAuth = false;
        view.getBtnAuth().addActionListener(l -> {
            String passwd = String.valueOf(view.getPasswd().getPassword());
            if (passwd.equals("123")) {
                isAuth = true;
                view.dispose();
            }
        });
        System.out.println(isAuth);
        return isAuth;
    }

    public boolean isAuth() {
        return isAuth;
    }
}
