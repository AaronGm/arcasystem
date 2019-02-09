
package arcasystem;

import controllers.ExpedienteController;
import models.Alumno;
import views.old.CrearExpediente;

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
//            boolean isAlive = false;
//            SocketAddress address = new InetSocketAddress("localhost", 5432);
//            Socket socket = new Socket();
//            try {
//                socket.connect(address, 2000);
//                socket.close();
//                isAlive = true;

//               new AlumnoController().create().setVisible(true);
//                LoginController loginController = new LoginController();
//                loginController.login().setVisible(true);
            CrearExpediente crearExpediente = new CrearExpediente();
            ExpedienteController expedienteController = new ExpedienteController(crearExpediente, new Alumno("Aarón", "Gómez", "Méndez"));
            expedienteController.getView().setVisible(true);


//            new ProfesorController().create().setVisible(true);
//            new SplashScreen().setVisible(true);

//                new AsignarAsesorInterno().setVisible(true);
//            new AsignarAsesorInterno().setVisible(true);
//            new PanelControl().setVisible(true);
//            new HistorialAlumnoController().show().setVisible(true);
//            } catch (IOException ex) {
//                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
//            }
        };
        EventQueue.invokeLater(run);
    }

}
