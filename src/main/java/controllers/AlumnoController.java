package controllers;

import dao.postgres.AlumnoDB;
import dao.postgres.CarreraDB;
import models.Alumno;
import views.old.RegistrarAlumno;
import views.View;
import views.old.components.AuthDialog;

public class AlumnoController implements Controller<Alumno> {

    private final AlumnoDB alumnoDB = new AlumnoDB();
    private Alumno alumno;
    private AuthController authController;

    @Override
    public View create() {
        RegistrarAlumno view = new RegistrarAlumno();
        AuthDialog authDialog = new AuthDialog(view, "Autorización");
        alumno = null;
        view.getBtnSig().addActionListener(l -> {
            alumno = new Alumno(
                view.getTxfNombre().getText(),
                view.getTxfApellidoPaterno().getText(),
                view.getTxfApellidoMaterno().getText(),
                view.getTxfNoControl().getText(),
                Integer.parseInt(view.getCmbSemestre().getSelectedItem().toString()),
                view.getCmbPeriodo().getSelectedItem().toString(),
                new CarreraDB().getById(view.getCmbCarrera().getSelectedItem().toString())
            );

            authController = new AuthController(view);

            if (authController.auth()) {
                System.out.println("Autorizado");
            }

           /* authDialog.setVisible(true);
            authDialog.getBtnAuth().addActionListener(ls -> {
                String passwd = String.valueOf(authDialog.getPasswd().getPassword());
                if (new UsuarioDB().auth(LoginController.CURRENT_USER, passwd)) {
                    alumnoDB.insert(alumno);
                    view.clearFields(
                        view.getTxfNoControl(),
                        view.getTxfNombre(),
                        view.getTxfApellidoPaterno(),
                        view.getTxfApellidoMaterno()
                    );
                    view.clearCombos(
                        view.getCmbCarrera(),
                        view.getCmbPeriodo(),
                        view.getCmbSemestre()
                    );
                    authDialog.dispose();
                } else {
                    JOptionPane.showConfirmDialog(null, MensajesValidacion.ERROR_AUTORIZACION);
                }
            });*/




        });
        return view;
    }

    @Override
    public View update(Alumno alumno) {
        return null;
    }

    @Override
    public View show() {
        return null;
    }

    @Override
    public void destroy(Alumno alumno) {

    }


}
