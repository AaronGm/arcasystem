package controllers;

import dao.postgres.HistorialAlumnoDB;
import models.Alumno;
import models.AsesorExterno;
import models.Empresa;
import models.HistorialAlumno;
import models.Proyecto;
import views.ConsultarHistorialAlumno;
import views.View;

public class HistorialAlumnoController implements Controller<HistorialAlumno> {

    private HistorialAlumno historialAlumno;

    @Override
    public View create() {
        return null;
    }

    @Override
    public View update(HistorialAlumno historialAlumno) {
        return null;
    }

    @Override
    public View show() {
        historialAlumno = new HistorialAlumnoDB().getById(1);
        Alumno alumno = historialAlumno.getAlumno();
        Proyecto proyecto = historialAlumno.getProyecto();
        Empresa empresa = historialAlumno.getEmpresa();
        AsesorExterno asesorExterno = historialAlumno.getAsesorExterno();

        ConsultarHistorialAlumno view = new ConsultarHistorialAlumno();
        view.getDatosAlumno().getLbNoControl().setText(alumno.getNoControl());
        view.getDatosAlumno().getLbNombreCompleto().setText(alumno.getNombreCompleto());
        view.getDatosAlumno().getLbCarrera().setText(alumno.getCarrera().getNombre() + " (" + alumno.getCarrera().getClaveCarrera() + ")");
        view.getDatosAlumno().getLbPeriodo().setText(alumno.getPeriodo());
        view.getDatosAlumno().getLbSemestre().setText(String.valueOf(alumno.getSemestre()));

        view.getDatosProyecto().getLbNombre().setText(proyecto.getNombre());
        view.getDatosProyecto().getLbSemanas().setText(String.valueOf(proyecto.getSemanas()));
        view.getDatosProyecto().getLbFechaInicio().setText(proyecto.getFechaInicio().toString());
        view.getDatosProyecto().getLbFechaTermino().setText(proyecto.getFechaTermino().toString());
        view.getDatosProyecto().getLbEstatus().setText(proyecto.getEstatus());
        view.getDatosProyecto().getLbPeriodo().setText(proyecto.getPeriodo());

        view.getDatosEmpresa().getLbRfc().setText(empresa.getRfc());
        view.getDatosEmpresa().getLbNombre().setText(empresa.getNombre());
        view.getDatosEmpresa().getLbDomicilio().setText(empresa.getDomicilio());
        view.getDatosEmpresa().getLbColonia().setText(empresa.getColonia());
        view.getDatosEmpresa().getLbAlcaldiaMunicipio().setText(empresa.getAlcaldiaMunicipio());
        view.getDatosEmpresa().getLbCodigoPostal().setText(empresa.getCodigoPostal());
        view.getDatosEmpresa().getLbPaginaWeb().setText(empresa.getPaginaWeb());
        view.getDatosEmpresa().getLbEncargado().setText(empresa.getEncargado());

        view.getDatosAsesorExterno().getLbNombreCompleto().setText(asesorExterno.getNombreCompleto());
        view.getDatosAsesorExterno().getLbCargo().setText(asesorExterno.getCargo());

        return view;
    }

    @Override
    public void destroy(HistorialAlumno historialAlumno) {

    }
}
