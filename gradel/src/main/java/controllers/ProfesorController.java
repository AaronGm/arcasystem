package controllers;

import dao.postgres.ProfesorDB;
import excepciones.ExcepcionGeneral;
import models.Profesor;
import views.ConsultarProfesor;
import views.EditarProfesor;
import views.RegistrarProfesor;
import views.View;
import views.components.FlatTable;

import javax.swing.JOptionPane;

/**
 *
 * @author aarongmx
 */
public class ProfesorController implements Controller<Integer> {

    private ProfesorDB profesorDB = new ProfesorDB();
    private Profesor profesor;

    @Override
    public View create() {
        RegistrarProfesor view = new RegistrarProfesor();
        profesor = null;

        view.getButton().addActionListener(l -> {
            profesor = new Profesor(
                view.getTxfNoContrato().getText(),
                view.getJdtcFechaIngreso().getDate(),
                view.getCmbGradoEstudio().getSelectedItem().toString(),
                view.getCmbEstatusProfesor().getSelectedItem().toString(),
                view.getTxfEspecialidad().getText(),
                view.getTxfNombre().getText(),
                view.getTxfApellidoPaterno().getText(),
                view.getTxfApellidoMaterno().getText()
            );

            profesorDB.insert(profesor);
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
                view.getCmbGradoEstudio().getSelectedItem().toString(),
                view.getCmbEstatusProfesor().getSelectedItem().toString(),
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
