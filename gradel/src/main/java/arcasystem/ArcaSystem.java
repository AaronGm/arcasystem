/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arcasystem;

import controllers.LoginController;
import views.LoginView;

import java.awt.EventQueue;

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
//            SocketAddress address = new InetSocketAddress("localhost", 5432);
//            Socket socket = new Socket();
//            try {
//                socket.connect(address, 2000);
//                socket.close();
//                isAlive = true;

//               new AlumnoController().create().setVisible(true);
                LoginController loginController = new LoginController(new LoginView());
                loginController.login().setVisible(true);

//            } catch (IOException ex) {
//                Logger.getLogger(ArcaSystem.class.getName()).log(Level.SEVERE, null, ex);
//            }
        };
        EventQueue.invokeLater(run);
    }

}
