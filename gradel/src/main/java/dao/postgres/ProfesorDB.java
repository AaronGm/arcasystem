package dao.postgres;

import config.ConnectionDB;
import excepciones.ExcepcionGeneral;
import interfaces.ProfesorDAO;
import models.Profesor;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aarongmx
 */
public class ProfesorDB implements ProfesorDAO {
    
    private Connection conexion;
    private PreparedStatement sentencia;
    private ResultSet resultados;
    
    private final String INSERTAR = "INSERT INTO profesores(no_trabajador, nombres, apellido_paterno, apellido_materno, fecha_ingreso, grado_estudios, estatus_profesor, area_especialidad) VALUES (?, INITCAP(?), INITCAP(?), INITCAP(?), ?, ?::grado_estudios, ?::estado_profesor, UPPER(?)) RETURNING profesor_id;";
    private final String LISTAR = "SELECT profesor_id, no_trabajador, nombres, apellido_paterno, apellido_materno, fecha_ingreso, grado_estudios, estatus_profesor, area_especialidad FROM profesores;";
    private final String OBTENERPORID = "SELECT profesor_id, no_trabajador, nombres, apellido_paterno, apellido_materno, fecha_ingreso, grado_estudios, estatus_profesor, area_especialidad FROM profesores WHERE profesor_id = ?;";

    private final String ACTUALIZAR = "UPDATE profesores SET no_trabajador = ?, nombres = INITCAP(?), apellido_paterno = INITCAP(?), apellido_materno = INITCAP(?), fecha_ingreso = ?, grado_estudios = ?::grado_estudios, estatus_profesor = ?::estado_profesor, area_especialidad = UPPER(?) WHERE profesor_id = ?;";
    
    private final String ELIMINAR = "DELETE FROM profesores WHERE profesor_id = ?;";

    @Override
    public void insert(Profesor profesor) throws ExcepcionGeneral {
        conexion = new ConnectionDB().getConnection();
        try {
            sentencia = conexion.prepareStatement(INSERTAR);
            sentencia.setString(1, profesor.getNoTrabajador());
            sentencia.setString(2, profesor.getNombres());
            sentencia.setString(3, profesor.getApellidoPaterno());
            sentencia.setString(4, profesor.getApellidoMaterno());
            sentencia.setDate(5, (Date) profesor.getFechaIngreso());
            sentencia.setString(6, profesor.getGradoEstudio());
            sentencia.setString(7, profesor.getEstatusProfesor());
            sentencia.setString(8, profesor.getAreaEspecialidad());

            resultados = sentencia.executeQuery();

            if (resultados.next()) {
                profesor.setProfesorId(resultados.getInt(Profesor.PROFESOR_ID));
            } else {
                throw new ExcepcionGeneral("No se insertó ningún registro");
            }

        } catch (SQLException e) {
            throw new ExcepcionGeneral(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conexion, sentencia, resultados);
        }
    }

    @Override
    public void update(Profesor profesor) {
        conexion = new ConnectionDB().getConnection();
        try {
            sentencia = conexion.prepareStatement(ACTUALIZAR);
            sentencia.setString(1, profesor.getNoTrabajador());
            sentencia.setString(2, profesor.getNombres());
            sentencia.setString(3, profesor.getApellidoPaterno());
            sentencia.setString(4, profesor.getApellidoMaterno());
            sentencia.setDate(5, (Date) profesor.getFechaIngreso());
            sentencia.setString(6, profesor.getGradoEstudio());
            sentencia.setString(7, profesor.getEstatusProfesor());
            sentencia.setString(8, profesor.getAreaEspecialidad());
            sentencia.setInt(9, profesor.getProfesorId());

            if (sentencia.executeUpdate() == 0) {
                throw new ExcepcionGeneral("No se insertó ningún registro");
            }

        } catch (SQLException e) {
            throw new ExcepcionGeneral(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conexion, sentencia, resultados);
        }
    }

    @Override
    public void delete(Profesor profesor) {
       conexion = new ConnectionDB().getConnection();
       try {
            sentencia = conexion.prepareStatement(ELIMINAR);
            sentencia.setInt(1, profesor.getProfesorId());

           if (sentencia.executeUpdate() == 0) {
               throw new ExcepcionGeneral("No se eliminó ningún registro");
           }

       } catch (SQLException e) {
           throw new ExcepcionGeneral(e.getMessage());
       } finally {
           ConnectionDB.closeConnection(conexion, sentencia, resultados);
       }
    }

    @Override
    public Profesor getById(Integer id) {
        conexion = new ConnectionDB().getConnection();
        Profesor profesor = null;
        try {
            sentencia = conexion.prepareStatement(OBTENERPORID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            sentencia.setInt(1, id);
            resultados = sentencia.executeQuery();
            if (resultados.first()) {
                
                profesor = new Profesor(
                    id,
                    resultados.getString(Profesor.NO_TRABAJADOR),
                    resultados.getDate(Profesor.FECHA_INGRESO),
                    resultados.getString(Profesor.GRADO_ESTUDIOS),
                    resultados.getString(Profesor.ESTATUS_PROFESOR),
                    resultados.getString(Profesor.AREA_ESPECIALIDAD),
                    resultados.getString(Profesor.NOMBRES),
                    resultados.getString(Profesor.APELLIDO_PATERNO),
                    resultados.getString(Profesor.APELLIDO_MATERNO)
                );
            }
        } catch (SQLException e) {
            throw new ExcepcionGeneral(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conexion, sentencia, resultados);
        }
        return profesor;
    }

    @Override
    public List<Profesor> list() {
        ArrayList<Profesor> lista = new ArrayList<>();
        conexion = new ConnectionDB().getConnection();
        try {
            sentencia = conexion.prepareStatement(LISTAR);
            resultados = sentencia.executeQuery();
            while (resultados.next()) {
                lista.add(
                    new Profesor(
                        resultados.getInt(Profesor.PROFESOR_ID),
                        resultados.getString(Profesor.NO_TRABAJADOR),
                        resultados.getDate(Profesor.FECHA_INGRESO),
                        resultados.getString(Profesor.GRADO_ESTUDIOS),
                        resultados.getString(Profesor.ESTATUS_PROFESOR),
                        resultados.getString(Profesor.AREA_ESPECIALIDAD),
                        resultados.getString(Profesor.NOMBRES),
                        resultados.getString(Profesor.APELLIDO_PATERNO),
                        resultados.getString(Profesor.APELLIDO_MATERNO)
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
