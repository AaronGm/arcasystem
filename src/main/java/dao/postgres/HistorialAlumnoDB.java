package dao.postgres;

import config.ConnectionDB;
import enums.MensajesValidacion;
import excepciones.ExcepcionGeneral;
import interfaces.HistorialAlumnoDAO;
import models.HistorialAlumno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HistorialAlumnoDB implements HistorialAlumnoDAO {
    private final String INSERTAR = "INSERT INTO historial_residentes(no_control, empresa_id, proyecto_id, asesor_externo_id) VALUES (?, ?, ?, ?) RETURNING historial_id;";

    private final String ELIMINAR = "DELETE FROM historial_residentes WHERE historial_id = ?;";

    private final String OBTENERPORID = "SELECT no_control, empresa_id, proyecto_id, asesor_externo_id FROM historial_residentes WHERE historial_id = ?;";

    private final String LISTAR = "SELECT historial_id, no_control, empresa_id, proyecto_id, asesor_externo_id FROM historial_residentes;";

    private final String ACTUALIZAR = "UPDATE historial_residentes SET no_control = ?, empresa_id = ?, proyecto_id = ?, asesor_externo_id = ? WHERE historial_id = ?;";


    private Connection conexion;
    private PreparedStatement sentencia;
    private ResultSet resultados;

    @Override
    public void insert(HistorialAlumno historialAlumno) {
        conexion = new ConnectionDB().getConnection();
        try {
            sentencia = conexion.prepareStatement(INSERTAR);
            sentencia.setString(1, historialAlumno.getAlumno().getNoControl());
            sentencia.setInt(2, historialAlumno.getEmpresa().getEmpresaId());
            sentencia.setInt(3, historialAlumno.getProyecto().getProyectoId());
            sentencia.setInt(4, historialAlumno.getAsesorExterno().getAsesorExternoId());

            resultados = sentencia.executeQuery();
            if (resultados.next()) {
                historialAlumno.setId(resultados.getInt(HistorialAlumno.ID));
            } else {
                throw new ExcepcionGeneral("¡No se insertó ningún registro!");
            }

        } catch (SQLException e) {
            throw new ExcepcionGeneral(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conexion, sentencia, resultados);
        }
    }

    @Override
    public void update(HistorialAlumno historialAlumno) {
        conexion = new ConnectionDB().getConnection();
        try {
            sentencia = conexion.prepareStatement(ACTUALIZAR);
            sentencia.setString(1, historialAlumno.getAlumno().getNoControl());
            sentencia.setInt(2, historialAlumno.getEmpresa().getEmpresaId());
            sentencia.setInt(3, historialAlumno.getProyecto().getProyectoId());
            sentencia.setInt(4, historialAlumno.getAsesorExterno().getAsesorExternoId());
            sentencia.setInt(5, historialAlumno.getId());

            if (sentencia.executeUpdate() == 0) {
                throw new ExcepcionGeneral(MensajesValidacion.NO_HAY_ELEMENTOS_ACTUALIZAR.getMensaje());
            }
        } catch (SQLException e) {
            throw new ExcepcionGeneral(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conexion, sentencia, resultados);
        }
    }

    @Override
    public void delete(HistorialAlumno historialAlumno) {
        conexion = new ConnectionDB().getConnection();
        try {
            sentencia = conexion.prepareStatement(ELIMINAR);
            sentencia.setInt(1, historialAlumno.getId());

            if (sentencia.executeUpdate() == 0) {
                throw new ExcepcionGeneral(MensajesValidacion.NO_HAY_ELEMENTOS_ELIMINAR.getMensaje());
            }

        } catch (SQLException e) {
            throw new ExcepcionGeneral(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conexion, sentencia, resultados);
        }
    }

    @Override
    public HistorialAlumno getById(Integer id) {
        HistorialAlumno historialAlumno;
        conexion = new ConnectionDB().getConnection();
        try {
            sentencia = conexion.prepareStatement(OBTENERPORID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            sentencia.setInt(1, id);
            resultados = sentencia.executeQuery();
            if (resultados.first()) {
                historialAlumno = new HistorialAlumno(
                    id,
                    new AlumnoDB().getById(resultados.getString(HistorialAlumno.FK_NO_CONTROL)),
                    new EmpresaDB().getById(resultados.getInt(HistorialAlumno.FK_EMPRESA_ID)),
                    new ProyectoDB().getById(resultados.getInt(HistorialAlumno.FK_PROYECTO_ID)),
                    new AsesorExternoDB().getById(resultados.getInt(HistorialAlumno.FK_ASESOR_EXTERNO_ID))
                );
            } else {
                throw new ExcepcionGeneral("No existe el registro con id = " + id);
            }

        } catch (SQLException e) {
            throw new ExcepcionGeneral(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conexion, sentencia, resultados);
        }
        return historialAlumno;
    }

    @Override
    public List<HistorialAlumno> list() {
        ArrayList<HistorialAlumno> lista = new ArrayList<>();
        conexion = new ConnectionDB().getConnection();
        try {
            sentencia = conexion.prepareStatement(LISTAR);
            resultados = sentencia.executeQuery();

            while (resultados.next()) {
                lista.add(
                    new HistorialAlumno(
                        resultados.getInt(HistorialAlumno.ID),
                        new AlumnoDB().getById(resultados.getString(HistorialAlumno.FK_NO_CONTROL)),
                        new EmpresaDB().getById(resultados.getInt(HistorialAlumno.FK_EMPRESA_ID)),
                        new ProyectoDB().getById(resultados.getInt(HistorialAlumno.FK_PROYECTO_ID)),
                        new AsesorExternoDB().getById(resultados.getInt(HistorialAlumno.FK_ASESOR_EXTERNO_ID))
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
