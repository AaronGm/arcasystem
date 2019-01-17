package dao.postgres;

import config.ConnectionDB;
import excepciones.ExcepcionGeneral;
import interfaces.ExpedienteDAO;
import models.Expediente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExpedienteDB implements ExpedienteDAO {

    private Connection conexion;
    private PreparedStatement sentencia;
    private ResultSet resultados;

    private final String INSERTAR = "INSERT INTO expedientes(carta_inicio, cronograma, asesorias, evaluacion_seguimiento, formato_evaluacion, discos, carta_termino, carta_liberacion, observaciones, estatus, no_control) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING expediente_id;";
    private final String ACTUALIZAR = "UPDATE expedientes SET carta_inicio = ?, cronograma = ?, asesorias = ?, " +
            "evaluacion_seguimiento = ?, formato_evaluacion = ?, discos, carta_termino = ?, carta_liberacion = ?, " +
            "observaciones = ?," +
            " estatus = ? WHERE expediente_id = ?;";

    private final String OBTENERPORID = "SELECT carta_inicio, cronograma, asesorias, evaluacion_seguimiento, formato_evaluacion, discos, carta_termino, carta_liberacion, observaciones, estatus, no_control FROM expedientes WHERE expediente_id = ?;";

    private final String ELIMINAR = "DELETE FROM expedientes WHERE expediente_id = ?;";

    private final String LISTAR = "SELECT expediente_id, carta_inicio, cronograma, asesorias, evaluacion_seguimiento," +
            " " +
            "formato_evaluacion, discos, carta_termino, carta_liberacion, observaciones, estatus, no_control FROM " +
            "expedientes;";

    @Override
    public void insert(Expediente expediente) throws ExcepcionGeneral {
        conexion = new ConnectionDB().getConnection();
        try {
            sentencia = conexion.prepareStatement(INSERTAR);
            sentencia.setBoolean(1, expediente.isCartaInicio());
            sentencia.setBoolean(2, expediente.isCronograma());
            sentencia.setBoolean(3, expediente.isAsesorias());
            sentencia.setBoolean(4, expediente.isEvaluacionSeguimiento());
            sentencia.setBoolean(5, expediente.isFormatoEvaluacion());
            sentencia.setBoolean(6, expediente.isDiscos());
            sentencia.setBoolean(7, expediente.isCartaTermino());
            sentencia.setBoolean(8, expediente.isCartaLiberacion());
            sentencia.setString(9, expediente.getObservaciones());
            sentencia.setString(10, expediente.getEstatus());
            sentencia.setString(11, expediente.getNoControl());

            resultados = sentencia.executeQuery();

            if (resultados.next()) {
                expediente.setExpedienteId(resultados.getInt(Expediente.EXPEDIENTE_ID));
            } else {
                throw new ExcepcionGeneral("No se agregó ningún registro");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conexion, sentencia, resultados);
        }
    }

        @Override
    public void update(Expediente expediente) {
        conexion = new ConnectionDB().getConnection();
        try {
            sentencia = conexion.prepareStatement(ACTUALIZAR);
            sentencia.setBoolean(1, expediente.isCartaInicio());
            sentencia.setBoolean(2, expediente.isCronograma());
            sentencia.setBoolean(3, expediente.isAsesorias());
            sentencia.setBoolean(4, expediente.isEvaluacionSeguimiento());
            sentencia.setBoolean(5, expediente.isFormatoEvaluacion());
            sentencia.setBoolean(6, expediente.isDiscos());
            sentencia.setBoolean(7, expediente.isCartaTermino());
            sentencia.setBoolean(8, expediente.isCartaLiberacion());
            sentencia.setString(9, expediente.getObservaciones());
            sentencia.setString(10, expediente.getEstatus());

            if (sentencia.executeUpdate() == 0) {
                throw new ExcepcionGeneral("No se actualizó ningún registro");
            }

        } catch (SQLException e) {
            throw new ExcepcionGeneral(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conexion, sentencia, resultados);
        }
    }

    @Override
    public void delete(Expediente expediente) {
        conexion = new ConnectionDB().getConnection();
        try {
            sentencia = conexion.prepareStatement(ELIMINAR);
            sentencia.setInt(1, expediente.getExpedienteId());

            if (sentencia.executeUpdate() == 0) {
                throw new ExcepcionGeneral("No se eliminó ningún registro");
            }

        }catch (SQLException e) {
            throw new ExcepcionGeneral(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conexion, sentencia, resultados);
        }
    }

    @Override
    public Expediente getById(Integer id) {
        conexion = new ConnectionDB().getConnection();
        Expediente expediente = null;
        try {
            sentencia = conexion.prepareStatement(OBTENERPORID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            sentencia.setInt(1, id);
            resultados = sentencia.executeQuery();

            if (resultados.first()) {
                expediente = new Expediente(
                        id,
                        resultados.getBoolean(Expediente.CARTA_INICIO),
                        resultados.getBoolean(Expediente.CRONOGRAMA),
                        resultados.getBoolean(Expediente.ASESORIAS),
                        resultados.getBoolean(Expediente.EVALUACION_SEGUIMIENTO),
                        resultados.getBoolean(Expediente.FORMATO_EVALUACION),
                        resultados.getBoolean(Expediente.DISCOS),
                        resultados.getBoolean(Expediente.CARTA_TERMINO),
                        resultados.getBoolean(Expediente.CARTA_LIBERACION),
                        resultados.getString(Expediente.OBSERVACIONES),
                        resultados.getString(Expediente.ESTATUS),
                        resultados.getString(Expediente.FK_NO_CONTROL)
                );
            }
        }catch (SQLException e) {
            throw new ExcepcionGeneral(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conexion, sentencia, resultados);
        }
        return expediente;
    }

    @Override
    public List<Expediente> list() {
        ArrayList<Expediente> list = new ArrayList<>();
        conexion = new ConnectionDB().getConnection();
        try {
            sentencia = conexion.prepareStatement(LISTAR);

            resultados = sentencia.executeQuery();

            while (resultados.next()) {
                list.add(new Expediente(
                        resultados.getInt(Expediente.EXPEDIENTE_ID),
                        resultados.getBoolean(Expediente.CARTA_INICIO),
                        resultados.getBoolean(Expediente.CRONOGRAMA),
                        resultados.getBoolean(Expediente.ASESORIAS),
                        resultados.getBoolean(Expediente.EVALUACION_SEGUIMIENTO),
                        resultados.getBoolean(Expediente.FORMATO_EVALUACION),
                        resultados.getBoolean(Expediente.DISCOS),
                        resultados.getBoolean(Expediente.CARTA_TERMINO),
                        resultados.getBoolean(Expediente.CARTA_LIBERACION),
                        resultados.getString(Expediente.OBSERVACIONES),
                        resultados.getString(Expediente.ESTATUS),
                        resultados.getString(Expediente.FK_NO_CONTROL)
                ));
            }

        }catch (SQLException e) {
            throw new ExcepcionGeneral(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conexion, sentencia, resultados);
        }
        return list;
    }
}
