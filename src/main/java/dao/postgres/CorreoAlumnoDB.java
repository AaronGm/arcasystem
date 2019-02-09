package dao.postgres;

import config.ConnectionDB;
import enums.MensajesValidacion;
import excepciones.ExcepcionGeneral;
import interfaces.CorreosAlumnoDAO;
import models.Alumno;
import models.CorreoAlumno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CorreoAlumnoDB implements CorreosAlumnoDAO {

    private Connection conexion;
    private PreparedStatement sentencia;
    private ResultSet resultados;

    private final String INSERTAR;
    private final String ACTUALIZAR;
    private final String ELIMINAR;
    private final String OBTENER_POR_ID;
    private final String LISTAR;

    public CorreoAlumnoDB() {
        //language=POSTGRES-SQL
        INSERTAR = "INSERT INTO correos_alumno(correo, no_control) VALUES (?, ?) RETURNING correo_id;";
        //language=POSTGRES-SQL
        ACTUALIZAR = "UPDATE correos_alumno SET correo = ? WHERE no_control = ?;";
        //language=POSTGRES-SQL
        ELIMINAR = "DELETE FROM correos_alumno WHERE correo_id = ?;";
        //language=POSTGRES-SQL
        OBTENER_POR_ID = "SELECT correo FROM correos_alumno WHERE no_control = ?;";
        //language=POSTGRES-SQL
        LISTAR = "SELECT correo_id, correo, no_control FROM correos_alumno;";

    }

    @Override
    public void insert(CorreoAlumno correoAlumno) {
        conexion = new ConnectionDB().getConnection();
        try{
            sentencia = conexion.prepareStatement(INSERTAR);
            sentencia.setString(1, correoAlumno.getCorreo());
            sentencia.setString(2, correoAlumno.getNoControl());

            resultados = sentencia.executeQuery();
            if (resultados.next()) {
                correoAlumno.setCorreoId(resultados.getInt(CorreoAlumno.CORREO_ID));
            } else {
                throw new ExcepcionGeneral("No se agregó ningún registro!");
            }

        } catch (SQLException e) {
            throw new ExcepcionGeneral(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conexion, sentencia, resultados);
        }
    }

    @Override
    public void update(CorreoAlumno correoAlumno) {
        conexion = new ConnectionDB().getConnection();
        try{
            sentencia = conexion.prepareStatement(ACTUALIZAR);
            sentencia.setString(1, correoAlumno.getCorreo());
            sentencia.setString(2, correoAlumno.getNoControl());

            if (sentencia.executeUpdate() == 0) {
                throw new ExcepcionGeneral(MensajesValidacion.NO_SE_ACTUALIZO.getMensaje());
            }

        } catch (SQLException e) {
            throw new ExcepcionGeneral(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conexion, sentencia, resultados);
        }
    }

    @Override
    public void delete(CorreoAlumno correoAlumno) {
        conexion = new ConnectionDB().getConnection();
        try{
            sentencia = conexion.prepareStatement(ELIMINAR);
            sentencia.setInt(1, correoAlumno.getCorreoId());

            if (sentencia.executeUpdate() == 0) {
                throw new ExcepcionGeneral(MensajesValidacion.NO_SE_ELIMINO.getMensaje());
            }

        } catch (SQLException e) {
            throw new ExcepcionGeneral(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conexion, sentencia, resultados);
        }
    }

    @Override
    public CorreoAlumno getById(Alumno alumno) {
        CorreoAlumno correoAlumno;
        conexion = new ConnectionDB().getConnection();
        try{
            sentencia = conexion.prepareStatement(OBTENER_POR_ID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            sentencia.setString(1, alumno.getNoControl());

            resultados = sentencia.executeQuery();

            if (resultados.first()) {
                correoAlumno = new CorreoAlumno(
                    resultados.getInt(CorreoAlumno.CORREO_ID),
                    resultados.getString(CorreoAlumno.CORREO),
                    resultados.getString(CorreoAlumno.FK_NO_CONTROL)
                );
            } else {
                throw new ExcepcionGeneral(MensajesValidacion.NO_EXISTE.getMensaje());
            }

        } catch (SQLException e) {
            throw new ExcepcionGeneral(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conexion, sentencia, resultados);
        }
        return correoAlumno;
    }

    @Override
    public List<CorreoAlumno> list() {
        ArrayList<CorreoAlumno> lista = new ArrayList<>();
        conexion = new ConnectionDB().getConnection();
        try{
            sentencia = conexion.prepareStatement(LISTAR);

            resultados = sentencia.executeQuery();

            while(resultados.next()) {
                lista.add(
                    new CorreoAlumno(
                        resultados.getInt(CorreoAlumno.CORREO_ID),
                        resultados.getString(CorreoAlumno.CORREO),
                        resultados.getString(CorreoAlumno.FK_NO_CONTROL)
                    )
                );
            }

        } catch (SQLException e) {
            throw new ExcepcionGeneral(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conexion, sentencia, resultados);
        }
        return lista;
    }
}
