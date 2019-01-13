/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arcasystem;

import models.Profesor;
import views.ConsultarProfesor;
import views.EditarProfesor;
import views.PanelControl;

import java.awt.EventQueue;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aarongmx
 */
public class ArcaSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Runnable run;
        run = () -> {
            System.setProperty("awt.useSystemAAFontSettings","on");
            System.setProperty("swing.aatext", "true");
            boolean isAlive = false;
            SocketAddress address = new InetSocketAddress("localhost", 5432);
            Socket socket = new Socket();
            try {
                socket.connect(address, 2000);
                socket.close();
                isAlive = true;

                new PanelControl().setVisible(true);

//                LoginController loginController = new LoginController(new LoginView());
//                loginController.login().setVisible(true);
//                new SplashScreen().setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(ArcaSystem.class.getName()).log(Level.SEVERE, null, ex);
            }
//            new PanelControl().setVisible(true);
//            new RegistrarEmpresa().setVisible(true);
//            new RegistrarProyecto().setVisible(true);
//            new RegistrarResidente().setVisible(true);
//            new RegistrarExpediente().setVisible(true);
//            new InicioUsuario().setVisible(true);
//            ProfesorController regProfController = new ProfesorController(new RegistrarProfesor());
//            regProfController.registrarProfesor().setVisible(true);
//            Date d = new Date();
//
//            Profesor prof = new Profesor(1, "090", d,"Ingeniería", "Clave 20", "#web", "Juan", "Torres", "Quintero");
////            new EditarProfesor(prof).setVisible(true);
//            new ConsultarProfesor().setVisible(true);
            
        };
        EventQueue.invokeLater(run);
    }
    
}
