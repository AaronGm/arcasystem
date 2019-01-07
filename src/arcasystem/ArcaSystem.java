/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arcasystem;

import controllers.LoginController;
import java.awt.EventQueue;
import views.*;

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
//            new PanelControl().setVisible(true);
//            new RegistrarEmpresa().setVisible(true);
//            new RegistrarProyecto().setVisible(true);
//            new RegistrarResidente().setVisible(true);
//            new RegistrarExpediente().setVisible(true);
//            new InicioUsuario().setVisible(true);
            new RegistrarProfesor().setVisible(true);
            
        };
        EventQueue.invokeLater(run);
    }
    
}
