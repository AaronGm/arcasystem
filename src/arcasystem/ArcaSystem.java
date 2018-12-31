/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arcasystem;

import controllers.LoginController;
import java.awt.EventQueue;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.logging.Level;
import java.util.logging.Logger;
import views.RegistrarProyecto;
import views.LoginView;
import views.RegistrarEmpresa;
import views.RegistrarExpediente;
import views.RegistrarResidente;

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
//            boolean isAlive = false;
//            SocketAddress address = new InetSocketAddress("localhost", 5432);
//            Socket socket = new Socket();
//            try {
//                socket.connect(address, 2000);
//                socket.close();
//                isAlive = true;
//            } catch (IOException ex) {
//                Logger.getLogger(ArcaSystem.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            LoginController loginController = new LoginController(new LoginView());
//            loginController.login().setVisible(true);
//            new RegistrarEmpresa().setVisible(true);
//            new RegistrarProyecto().setVisible(true);
//            new RegistrarResidente().setVisible(true);
            new RegistrarExpediente().setVisible(true);
        };
        EventQueue.invokeLater(run);
    }
    
}
