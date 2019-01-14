package interfaces;

import models.Alumno;
import models.Carrera;

public interface AlumnoDAO extends DAO<String, Alumno> {
    Carrera getCarrera(Alumno alumno);
}
