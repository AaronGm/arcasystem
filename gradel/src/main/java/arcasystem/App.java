
package arcasystem;

import controllers.LoginController;
import views.AsignarAsesorInterno;
import views.ConsultarHistorialAlumno;
import views.LoginView;

import java.awt.EventQueue;

/**
 *
 * @author aarongmx
 */
public class App {

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
                LoginController loginController = new LoginController();
                loginController.login().setVisible(true);
//                new AsignarAsesorInterno().setVisible(true);
//            new AsignarAsesorInterno().setVisible(true);
//            new PanelControl().setVisible(true);
//            new ConsultarHistorialAlumno().setVisible(true);
//            } catch (IOException ex) {
//                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
//            }
        };
        EventQueue.invokeLater(run);
    }

}
