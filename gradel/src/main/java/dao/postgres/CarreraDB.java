
package dao.postgres;

import config.ConnectionDB;
import excepciones.ExcepcionGeneral;
import interfaces.CarreraDAO;
import models.Carrera;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aarongmx
 */
public class CarreraDB implements CarreraDAO {
    
    private Connection conexion;
    private PreparedStatement sentencia;
    private ResultSet resultados;
    
    private final String INSERTAR = "INSERT INTO carreras(clave_carrera, nombre, plan_estudios) VALUES (?, ?, ?) " +
            "RETURNING clave_carrera;";
    private final String ACTUALIZAR = "UPDATE carreras SET nombre = ?, plan_estudio = ? WHERE " +
            "clave_carrera" +
            " = " +
            "?;";
    private final String ELIMINAR = "DELETE FROM carreras WHERE clave_carrera = ?;";
    private final String LISTAR = "SELECT clave_carrera, nombre, plan_estudios FROM carreras;";
    private final String OBTENERPORID = "SELECT nombre, plan_estudios FROM carreras WHERE clave_carrera" +
            " = ?;";
    
    @Override
    public void insert(Carrera carrera) {
        conexion = new ConnectionDB().getConnection();
        try {
            sentencia = conexion.prepareStatement(INSERTAR);
            sentencia.setString(1, carrera.getClaveCarrera());
            sentencia.setString(2, carrera.getNombre());
            sentencia.setString(3, carrera.getPlanEstudios());

            resultados = sentencia.executeQuery();

            if (resultados.next()) {
                carrera.setClaveCarrera(resultados.getString(Carrera.CLAVE_CARRERA));
            } else {
                throw new ExcepcionGeneral("No se insertó ningún registro");
            }

        } catch (SQLException e) {
            throw new excepciones.ExcepcionGeneral(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conexion, sentencia, resultados);
        }
    }

    @Override
    public void update(Carrera carrera) {
        conexion = new ConnectionDB().getConnection();
        try {
            sentencia = conexion.prepareStatement(ACTUALIZAR);
            sentencia.setString(1, carrera.getNombre());
            sentencia.setString(2, carrera.getPlanEstudios());
            sentencia.setString(3, carrera.getClaveCarrera());

            if(sentencia.executeUpdate() == 0) {
              throw new ExcepcionGeneral("No se actualizó ningún registro");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conexion, sentencia, resultados);
        }
    }

    @Override
    public void delete(Carrera carrera) {
        conexion = new ConnectionDB().getConnection();
        try {
            sentencia = conexion.prepareStatement(ELIMINAR);
            sentencia.setString(1, carrera.getClaveCarrera());

            if(sentencia.executeUpdate() == 0) {
                throw new ExcepcionGeneral("No se eliminó ningún registro");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conexion, sentencia, resultados);
        }
    }

    @Override
    public Carrera getById(String claveCarrera) {
        conexion = new ConnectionDB().getConnection();
        Carrera carrera = null;
        try {
            sentencia = conexion.prepareStatement(OBTENERPORID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            sentencia.setString(1, claveCarrera);

            resultados = sentencia.executeQuery();
            if (resultados.first()) {
                carrera = new Carrera(
                        resultados.getString(claveCarrera),
                        resultados.getString(Carrera.NOMBRE),
                        resultados.getString(Carrera.PLAN_ESTUDIOS)
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conexion, sentencia, resultados);
        }
        return carrera;
    }

        @Override
    public List<Carrera> list() {
        ArrayList<Carrera> list = new ArrayList<>();
        conexion = new ConnectionDB().getConnection();
        try {
            sentencia = conexion.prepareStatement(LISTAR);
            resultados = sentencia.executeQuery();

            while (resultados.next()) {
                list.add(new Carrera(
                    resultados.getString(Carrera.CLAVE_CARRERA),
                    resultados.getString(Carrera.NOMBRE),
                    resultados.getString(Carrera.PLAN_ESTUDIOS)
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
