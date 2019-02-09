package controllers;

import dao.postgres.ProfesorDB;
import enums.MensajesValidacion;
import excepciones.ExcepcionGeneral;
import models.Profesor;
import views.old.ConsultarProfesor;
import views.old.EditarProfesor;
import views.old.RegistrarProfesor;
import views.View;
import views.old.components.AuthDialog;
import views.old.components.FlatTable;
import views.old.components.FlatTextField;

import javax.swing.JOptionPane;
import java.util.Objects;

/**
 * @author aarongmx
 */
public class ProfesorController implements Controller<Integer> {

    private ProfesorDB profesorDB = new ProfesorDB();
    private Profesor profesor;
    private AuthDialog authDialog;

    @Override
    public View create() {
        RegistrarProfesor view = new RegistrarProfesor();
        authDialog = new AuthDialog(view, "Autorización");
        profesor = null;

        view.getButton().addActionListener(l -> {
            profesor = new Profesor(
                view.getTxfNoContrato().getText(),
                view.getJdtcFechaIngreso().getDate(),
                Objects.requireNonNull(view.getCmbGradoEstudio().getSelectedItem()).toString(),
                Objects.requireNonNull(view.getCmbEstatusProfesor().getSelectedItem()).toString(),
                view.getTxfEspecialidad().getText(),
                view.getTxfNombre().getText(),
                view.getTxfApellidoPaterno().getText(),
                view.getTxfApellidoMaterno().getText()
            );

            boolean existEmptyFields = FlatTextField.validarCampoVacio(view.getTxfNoContrato(), view.getLbErrNoTrabajador())
                && FlatTextField.validarCampoVacio(view.getTxfNombre(), view.getLbErrNombres())
                && FlatTextField.validarCampoVacio(view.getTxfApellidoPaterno(), view.getLbErrApellidoPaterno())
                && FlatTextField.validarCampoVacio(view.getTxfApellidoMaterno(), view.getLbErrApellidoMaterno());

            // No deben haber campos vacios para poder guardarlos en la base de datos
            if (!existEmptyFields) {
                authDialog.setVisible(true);

                authDialog.getBtnAuth().addActionListener(evt -> {
                    if (authDialog.isAuth(authDialog.getPasswd().getPassword())) {
                        profesorDB.insert(profesor);
                        JOptionPane.showMessageDialog(null, "¡Profesor agregado correctamente!");
                        view.clearFields(
                            view.getTxfNoContrato(),
                            view.getTxfNombre(),
                            view.getTxfApellidoPaterno(),
                            view.getTxfApellidoMaterno(),
                            view.getTxfEspecialidad()
                        );
                        view.getJdtcFechaIngreso().cleanup();
                        view.clearCombos(
                            view.getCmbEstatusProfesor(),
                            view.getCmbGradoEstudio()
                        );
                        authDialog.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, MensajesValidacion.ERROR_AUTORIZACION.getMensaje());
                    }
                });
            }
        });

        return view;
    }

    @Override
    public View update(Integer id) {
        EditarProfesor view = new EditarProfesor();
        profesor = profesorDB.getById(id);
        view.setProfesor(profesor);

        view.getButton().addActionListener(l -> {
            Profesor tmpProfesor = new Profesor(
                profesor.getProfesorId(),
                view.getTxfNoContrato().getText(),
                view.getJdtcFechaIngreso().getDate(),
                Objects.requireNonNull(view.getCmbGradoEstudio().getSelectedItem()).toString(),
                Objects.requireNonNull(view.getCmbEstatusProfesor().getSelectedItem()).toString(),
                view.getTxfEspecialidad().getText(),
                view.getTxfNombre().getText(),
                view.getTxfApellidoPaterno().getText(),
                view.getTxfApellidoMaterno().getText()
            );

            try {
                profesorDB.update(tmpProfesor);
                this.show().setVisible(true);
                view.dispose();
            } catch (ExcepcionGeneral e) {
                System.out.println(e.getMessage());
            }

        });

        return view;
    }


    @Override
    public View show() {
        ConsultarProfesor view = new ConsultarProfesor();
        FlatTable table = view.getTabla();

        view.getBtnEditar().addActionListener(l -> {
            try {
                int id = (int) table.getModel().getValueAt(table.getSelectedRow(), 0);
                // Nos manda a una nueva vista de actualización para el profesor
                this.update(id).setVisible(true);
                view.dispose();
            } catch (ArrayIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "No hay elementos para actualizar");
            }
        });

        view.getBtnEliminar().addActionListener(l -> {
            try {
                int id = (int) table.getModel().getValueAt(table.getSelectedRow(), 0);
                this.destroy(id);
                view.loadData();
            } catch (ArrayIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "No hay elementos para eliminar");
            }

        });

        return view;
    }

    @Override
    public void destroy(Integer id) {
        profesor = profesorDB.getById(id);
        profesorDB.delete(profesor);
    }

}
