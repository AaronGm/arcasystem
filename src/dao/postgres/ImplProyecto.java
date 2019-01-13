package dao.postgres;

import config.ConnectionDB;
import excepciones.ExcepcionGeneral;
import interfaces.ProyectoDAO;
import models.Proyecto;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImplProyecto implements ProyectoDAO {
    
    private Connection conexion;
    private PreparedStatement sentencia;
    private ResultSet resultados;
    
    private final String INSERTAR = "INSERT INTO proyectos(nombre, semanas_proyecto, periodo, fecha_inicio, fecha_termino, estatus) VALUES (?, ?, ?, ?, ?, ?) RETURNING proyecto_id;";

    private final String ACTUALIZAR = "UPDATE proyectos SET nombre = ?, semanas_proyecto = ?, periodo = ?, fecha_inicio = ?, fecha_termino = ?, estatus = ? WHERE proyecto_id = ?;";
    
    private final String OBTENERPORID = "SELECT nombre, semanas_proyecto, periodo, fecha_inicio, fecha_termino, estatus FROM proyectos WHERE proyecto_id = ?;";
    
    private final String ELIMINAR = "DELETE FROM proyectos WHERE proyecto_id = ?;";
    
    private final String LISTAR = "SELECT proyecto_id, nombre, semanas_proyecto, periodo, fecha_inicio, fecha_termino, estatus FROM proyectos;";

    @Override
    public void insert(Proyecto proyecto) {
        conexion = new ConnectionDB().getConnection();
        try {
            sentencia = conexion.prepareStatement(INSERTAR);
            sentencia.setString(1, proyecto.getNombre());
            sentencia.setInt(2, proyecto.getSemanas());
            sentencia.setString(3, proyecto.getPeriodo());
            sentencia.setDate(4, (Date) proyecto.getFechaInicio());
            sentencia.setDate(5, (Date) proyecto.getFechaTermino());
            sentencia.setString(6, proyecto.getEstatus());

            resultados = sentencia.executeQuery();

            if (resultados.next()) {
                proyecto.setProyectoId(resultados.getInt(Proyecto.PROYECTO_ID));
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
    public void update(Proyecto proyecto) {
    conexion = new ConnectionDB().getConnection();
        try {
            sentencia = conexion.prepareStatement(ACTUALIZAR);
            sentencia.setString(1, proyecto.getNombre());
            sentencia.setInt(2, proyecto.getSemanas());
            sentencia.setString(3, proyecto.getPeriodo());
            sentencia.setDate(4, (Date) proyecto.getFechaInicio());
            sentencia.setDate(5, (Date) proyecto.getFechaTermino());
            sentencia.setString(6, proyecto.getEstatus());

            if (sentencia.executeUpdate() == 0) {
                throw new ExcepcionGeneral("No se actualizó ningun registro");
            }

        } catch (SQLException e) {
            throw new ExcepcionGeneral(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conexion, sentencia, resultados);
        }
    }

    @Override
    public void delete(Proyecto proyecto) {
        conexion = new ConnectionDB().getConnection();
        try {
            sentencia = conexion.prepareStatement(ELIMINAR);
            sentencia.setInt(1, proyecto.getProyectoId());

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
    public Proyecto getById(Integer id) {
        Proyecto proyecto = null;
        conexion = new ConnectionDB().getConnection();
        try {
            sentencia = conexion.prepareStatement(OBTENERPORID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            sentencia.setInt(1, id);
            resultados = sentencia.executeQuery();

            if (resultados.first()) {
                proyecto = new Proyecto(
                    id,
                    resultados.getString(Proyecto.NOMBRE),
                    resultados.getInt(Proyecto.SEMANAS_PROYECTO),
                    resultados.getString(Proyecto.PERIODO),
                    resultados.getDate(Proyecto.FECHA_INICIO),
                    resultados.getDate(Proyecto.FECHA_TERMINO),
                    resultados.getString(Proyecto.ESTATUS)
                );
            }

        } catch (SQLException e) {
            throw new ExcepcionGeneral(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conexion, sentencia, resultados);
        }
        return proyecto;
    }

    @Override
    public List<Proyecto> list() {
        ArrayList<Proyecto> lista = new ArrayList<>();
        conexion = new ConnectionDB().getConnection();
        try {
            sentencia = conexion.prepareStatement(LISTAR);
            resultados = sentencia.executeQuery();

            while (resultados.next()) {
                lista.add(new Proyecto(
                    resultados.getInt(Proyecto.PROYECTO_ID),
                    resultados.getString(Proyecto.NOMBRE),
                    resultados.getInt(Proyecto.SEMANAS_PROYECTO),
                    resultados.getString(Proyecto.PERIODO),
                    resultados.getDate(Proyecto.FECHA_INICIO),
                    resultados.getDate(Proyecto.FECHA_TERMINO),
                    resultados.getString(Proyecto.ESTATUS)
                ));
            }

        } catch (SQLException e) {
            throw new ExcepcionGeneral(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conexion, sentencia, resultados);
        }
        return lista;
    }
}
