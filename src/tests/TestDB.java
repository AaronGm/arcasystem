/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import dao.postgres.PostgresUsuario;
import java.awt.EventQueue;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import models.Usuario;
import views.admin.Admin;

/**
 *
 * @author aarongmx
 */
public class TestDB {
    public static void main( String[] args ) {
//        Usuario user = new Usuario("aarons", "azar", true);
//        PostgresUsuario postUser = new PostgresUsuario();
//        try {
//            postUser.insertar(user);
//            for ( Usuario usuario : postUser.listar()) {
//                System.out.println(usuario.toString());
//            }
//        } catch ( Exception e ) {
//        }
//        Runnable run = () -> {
//            new Admin().setVisible(true);
//        };
//        EventQueue.invokeLater(run);
//        DateFormat dateF = new SimpleDateFormat("dd/MM/yyyy");
//        Calendar calendar = Calendar.getInstance();
//        System.out.println(dateF.format(calendar.getTime()));
//        System.out.println(calendar.getTime().getMonth());
        helpers.Helpers.getPeriodo();
    }
}
