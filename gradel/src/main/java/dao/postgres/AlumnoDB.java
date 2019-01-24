package dao.postgres;

import config.ConnectionDB;
import excepciones.ExcepcionGeneral;
import interfaces.AlumnoDAO;
import models.Alumno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDB implements AlumnoDAO {

    private Connection conexion;
    private PreparedStatement sentencia;
    private ResultSet resultados;

    private final String INSERTAR = "INSERT INTO alumnos(no_control, nombres, apellido_paterno, apellido_materno, semestre, clave_carrera, periodo) VALUES (?, ?, ?, ?, ?, ?, ?) RETURNING no_control;";

    private final String LISTAR = "SELECT no_control, nombres, apellido_paterno, apellido_materno, semestre, clave_carrera, periodo FROM alumnos;";

    private final String ELIMINAR = "DELETE FROM alumnos WHERE no_control = ?;";

    private final String ACTUALIZAR = "UPDATE alumnos SET nombres = ?, apellido_paterno = ?, apellido_materno = ?, semestre = ?, clave_carrera = ?, periodo = ?  WHERE no_control = ?;";

    private final String OBTENERPORID = "SELECT nombres, apellido_paterno, apellido_materno, semestre, clave_carrera, periodo FROM alumnos WHERE no_control = ?;";

    @Override
    public void insert(Alumno alumno) {
        conexion = new ConnectionDB().getConnection();
        try {
            sentencia = conexion.prepareStatement(INSERTAR);
            sentencia.setString(1, alumno.getNoControl());
            sentencia.setString(2, alumno.getNombres());
            sentencia.setString(3, alumno.getApellidoPaterno());
            sentencia.setString(4, alumno.getApellidoMaterno());
            sentencia.setInt(5, alumno.getSemestre());
            sentencia.setString(6, alumno.getCarrera().getClaveCarrera());
            sentencia.setString(7, alumno.getPeriodo());

            resultados = sentencia.executeQuery();
            if (resultados.next()) {
                alumno.setNoControl(resultados.getString(Alumno.NO_CONTROL));
            } else {
                throw new ExcepcionGeneral("No se insertó ningún registro");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conexion, sentencia, resultados);
        }
    }

    @Override
    public void update(Alumno alumno) {
        conexion = new ConnectionDB().getConnection();
        try {
            sentencia = conexion.prepareStatement(ACTUALIZAR);

            sentencia.setString(1, alumno.getNombres());
            sentencia.setString(2, alumno.getApellidoPaterno());
            sentencia.setString(3, alumno.getApellidoMaterno());
            sentencia.setInt(4, alumno.getSemestre());
            sentencia.setString(5, alumno.getCarrera().getClaveCarrera());
            sentencia.setString(6, alumno.getPeriodo());
            sentencia.setString(7, alumno.getNoControl());

            if (sentencia.executeUpdate() == 0) {
                throw new ExcepcionGeneral("No se modificó ningún registro");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conexion, sentencia, resultados);
        }
    }

    @Override
    public void delete(Alumno alumno) {
        conexion = new ConnectionDB().getConnection();
        try {
            sentencia = conexion.prepareStatement(ELIMINAR);
            sentencia.setString(1, alumno.getNoControl());

            if (sentencia.executeUpdate() == 0) {
                throw new ExcepcionGeneral("No se modificó ningún registro");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conexion, sentencia, resultados);
        }
    }

    @Override
    public Alumno getById(String noControl) {
        conexion = new ConnectionDB().getConnection();
        Alumno alumno = null;
        try {
            sentencia = conexion.prepareStatement(OBTENERPORID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            sentencia.setString(1, noControl);
            resultados = sentencia.executeQuery();

            if (resultados.first()) {
                alumno = new Alumno(
                    resultados.getString(Alumno.NOMBRES),
                    resultados.getString(Alumno.APELLIDO_PATERNO),
                    resultados.getString(Alumno.APELLIDO_MATERNO),
                    noControl,
                    resultados.getInt(Alumno.SEMESTRE),
                    resultados.getString(Alumno.PERIODO),
                    new CarreraDB().getById(resultados.getString(Alumno.CLAVE_CARRERA))
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conexion, sentencia, resultados);
        }
        return alumno;
    }

    @Override
    public List<Alumno> list() {
        ArrayList<Alumno> list = new ArrayList<>();
        conexion = new ConnectionDB().getConnection();
        try {
            sentencia = conexion.prepareStatement(LISTAR);
            resultados = sentencia.executeQuery();
            while (resultados.next()) {
                list.add(new Alumno(
                    resultados.getString(Alumno.NOMBRES),
                    resultados.getString(Alumno.APELLIDO_PATERNO),
                    resultados.getString(Alumno.APELLIDO_MATERNO),
                    resultados.getString(Alumno.NO_CONTROL),
                    resultados.getInt(Alumno.SEMESTRE),
                    resultados.getString(Alumno.PERIODO),
                    new CarreraDB().getById(resultados.getString(Alumno.CLAVE_CARRERA))
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conexion, sentencia, resultados);
        }

        return list;
    }
}
