package controllers;

import dao.postgres.ImplProfesor;
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

    private ImplProfesor implProfesor = new ImplProfesor();
    private Profesor profesor;

    @Override
    public View create(View view) {
        RegistrarProfesor v = (RegistrarProfesor) view;
        profesor = null;

        v.getButton().addActionListener(l -> {
            profesor = new Profesor(
                v.getTxfNoContrato().getText(),
                v.getJdtcFechaIngreso().getDate(),
                v.getCmbGradoEstudio().getSelectedItem().toString(),
                v.getCmbEstatusProfesor().getSelectedItem().toString(),
                v.getTxfEspecialidad().getText(),
                v.getTxfNombre().getText(),
                v.getTxfApellidoPaterno().getText(),
                v.getTxfApellidoMaterno().getText()
            );

            implProfesor.insert(profesor);
        });

        return v;
    }

    @Override
    public View update(View view, Integer id) {
        EditarProfesor v = (EditarProfesor) view;
        profesor = implProfesor.getById(id);
        v.setProfesor(profesor);

        v.getButton().addActionListener(l -> {
            Profesor tmpProfesor = new Profesor(
                profesor.getProfesorId(),
                v.getTxfNoContrato().getText(),
                v.getJdtcFechaIngreso().getDate(),
                v.getCmbGradoEstudio().getSelectedItem().toString(),
                v.getCmbEstatusProfesor().getSelectedItem().toString(),
                v.getTxfEspecialidad().getText(),
                v.getTxfNombre().getText(),
                v.getTxfApellidoPaterno().getText(),
                v.getTxfApellidoMaterno().getText()
            );

            try {
                implProfesor.update(tmpProfesor);
                this.show(new ConsultarProfesor()).setVisible(true);
                v.dispose();
            } catch (ExcepcionGeneral e) {
                System.out.println(e.getMessage());
            }

        });

        return v;
    }


    @Override
    public View show(View view) {
        ConsultarProfesor v = (ConsultarProfesor) view;
        FlatTable table = v.getTabla();

        v.getBtnEditar().addActionListener(l -> {
            try {
                int id = (int) table.getModel().getValueAt(table.getSelectedRow(), 0);
                // Nos manda a una nueva vista de actualización para el profesor
                this.update(new EditarProfesor(), id).setVisible(true);
                v.dispose();
            } catch (ArrayIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "No hay elementos para actualizar");
            }
        });

        v.getBtnEliminar().addActionListener(l -> {
            try {
                int id = (int) table.getModel().getValueAt(table.getSelectedRow(), 0);
                this.destroy(id);
                v.loadData();
            } catch (ArrayIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "No hay elementos para eliminar");
            }

        });

        return v;
    }

    @Override
    public void destroy(Integer id) {
        profesor = implProfesor.getById(id);
        implProfesor.delete(profesor);
    }
}
