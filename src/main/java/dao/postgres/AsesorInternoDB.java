package dao.postgres;

import config.ConnectionDB;
import excepciones.ExcepcionGeneral;
import interfaces.AsesorInternoDAO;
import models.AsesorInterno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AsesorInternoDB implements AsesorInternoDAO {

    private Connection conexion;
    private PreparedStatement sentencia;
    private ResultSet resultados;

    private final String INSERTAR = "INSERT INTO asesores_internos(profesor_id) VALUES (?) RETURNING asesor_interno_id;";
    private final String ELIMINAR = "DELETE FROM aesores_internos WHERE asesor_interno_id = ?;";
    private final String ACTUALIZAR = "UPDATE asesores_internos SET profesor_id = ?;";
    private final String LISTAR = "SELECT asesor_interno_id, profesor_id FROM asesores_internos;";
    private final String OBTENERPORID = "SELECT profesor_id FROM asesores_internos WHERE asesor_interno_id = ?;";


    @Override
    public void insert(AsesorInterno asesorInterno) {
        conexion = new ConnectionDB().getConnection();
        try {
            sentencia = conexion.prepareStatement(INSERTAR);

            resultados = sentencia.executeQuery();

            if (resultados.next()) {
                asesorInterno.setAsesorInternoId(resultados.getInt(AsesorInterno.ASESOR_INTERNO_ID));
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
    public void update(AsesorInterno asesorInterno) {
        conexion = new ConnectionDB().getConnection();
        try {
            sentencia = conexion.prepareStatement(ACTUALIZAR);
            sentencia.setInt(1, asesorInterno.getProfesorId());
            sentencia.setInt(2, asesorInterno.getAsesorInternoId());

            if (sentencia.executeUpdate() == 0) {
                throw new ExcepcionGeneral("No se actualizó ningún registro!");
            }

        } catch (SQLException e) {
            throw new ExcepcionGeneral(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conexion, sentencia, resultados);
        }
    }

    @Override
    public void delete(AsesorInterno asesorInterno) {
        conexion = new ConnectionDB().getConnection();
        try {
            sentencia = conexion.prepareStatement(ELIMINAR);
            sentencia.setInt(1, asesorInterno.getAsesorInternoId());

            if (sentencia.executeUpdate() == 0) {
                throw new ExcepcionGeneral("No se eliminó ningún registro!");
            }

        } catch (SQLException e) {
            throw new ExcepcionGeneral(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conexion, sentencia, resultados);
        }
    }

    @Override
    public AsesorInterno getById(Integer id) {
        AsesorInterno asesorInterno = null;
        conexion = new ConnectionDB().getConnection();
        try {
            sentencia = conexion.prepareStatement(OBTENERPORID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            resultados = sentencia.executeQuery();

            if (resultados.first()) {
                asesorInterno = new AsesorInterno(
                    id,
                    resultados.getInt(AsesorInterno.FK_PROFESOR_ID)
                );
            }

        } catch (SQLException e) {
            throw new ExcepcionGeneral(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conexion, sentencia, resultados);
        }
        return asesorInterno;
    }

    @Override
    public List<AsesorInterno> list() {
        conexion = new ConnectionDB().getConnection();
        try {
            sentencia = conexion.prepareStatement(LISTAR);

            resultados = sentencia.executeQuery();

            while (resultados.next()) {

            }



        } catch (SQLException e) {
            throw new ExcepcionGeneral(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conexion, sentencia, resultados);
        }
        return null;
    }
}
