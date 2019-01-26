package dao.postgres;

import config.ConnectionDB;
import excepciones.ExcepcionGeneral;
import interfaces.AsesorExternoDAO;
import models.AsesorExterno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AsesorExternoDB implements AsesorExternoDAO {

    private Connection conexion;
    private PreparedStatement sentencia;
    private ResultSet resultados;

    private final String INSERTAR = "INSERT INTO asesores_externos(cargo, empresa_id, nombres, apellido_paterno, apellido_materno) VALUES (?, ?, ?, ?, ?) RETURNING asesor_externo_id;";

    private final String ELIMINAR = "DELETE FROM asesores_externos WHERE asesor_externo_id = ?;";

    private final String ACTUALIZAR = "UPDATE asesores_externos SET cargo = ?, empresa_id = ?, nombres = ?, apellido_paterno = ?, apellido_materno = ? WHERE asesor_externo_id = ?;";

    private final String LISTAR = "SELECT asesor_externo_id, cargo, empresa_id, nombres, apellido_paterno, apellido_materno FROM asesores_externos;";

    private final String OBTENERPORID = "SELECT cargo, empresa_id, nombres, apellido_paterno, apellido_materno FROM asesores_externos WHERE asesor_externo_id = ?;";


    @Override
    public void insert(AsesorExterno asesorExterno) {
        conexion = new ConnectionDB().getConnection();
        try {
            sentencia = conexion.prepareStatement(INSERTAR);
            sentencia.setString(1, asesorExterno.getCargo());
            sentencia.setInt(2, asesorExterno.getEmpresaId());
            sentencia.setString(3, asesorExterno.getNombres());
            sentencia.setString(4, asesorExterno.getApellidoPaterno());
            sentencia.setString(4, asesorExterno.getApellidoMaterno());

            resultados = sentencia.executeQuery();

            if (resultados.next()) {
                asesorExterno.setAsesorExternoId(resultados.getInt(AsesorExterno.ASESOR_EXTERNO_ID));
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
    public void update(AsesorExterno asesorExterno) {
        conexion = new ConnectionDB().getConnection();
        try {
            sentencia = conexion.prepareStatement(ACTUALIZAR);
            sentencia.setString(1, asesorExterno.getCargo());
            sentencia.setInt(2, asesorExterno.getEmpresaId());
            sentencia.setString(3, asesorExterno.getNombres());
            sentencia.setString(4, asesorExterno.getApellidoPaterno());
            sentencia.setString(5, asesorExterno.getApellidoMaterno());
            sentencia.setInt(6, asesorExterno.getAsesorExternoId());

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
    public void delete(AsesorExterno asesorExterno) {
        conexion = new ConnectionDB().getConnection();
        try {
            sentencia = conexion.prepareStatement(ELIMINAR);
            sentencia.setInt(1, asesorExterno.getAsesorExternoId());

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
    public AsesorExterno getById(Integer id) {
        AsesorExterno asesorExterno = null;
        conexion = new ConnectionDB().getConnection();
        try {
            sentencia = conexion.prepareStatement(OBTENERPORID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            sentencia.setInt(1, id);

            resultados = sentencia.executeQuery();

            if (resultados.first()) {
                asesorExterno = new AsesorExterno(
                    id,
                    resultados.getString(AsesorExterno.CARGO),
                    resultados.getInt(AsesorExterno.FK_EMPRESA_ID),
                    resultados.getString(AsesorExterno.NOMBRES),
                    resultados.getString(AsesorExterno.APELLIDO_PATERNO),
                    resultados.getString(AsesorExterno.APELLIDO_MATERNO)
                );
            }

        } catch (SQLException e) {
            throw new ExcepcionGeneral(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conexion, sentencia, resultados);
        }
        return asesorExterno;
    }

    @Override
    public List<AsesorExterno> list() {
        ArrayList<AsesorExterno> lista = new ArrayList<>();
        conexion = new ConnectionDB().getConnection();
        try {
            sentencia = conexion.prepareStatement(LISTAR);
            resultados = sentencia.executeQuery();

            while (resultados.next()) {
                lista.add(new AsesorExterno(
                    resultados.getInt(AsesorExterno.ASESOR_EXTERNO_ID),
                    resultados.getString(AsesorExterno.CARGO),
                    resultados.getInt(AsesorExterno.FK_EMPRESA_ID),
                    resultados.getString(AsesorExterno.NOMBRES),
                    resultados.getString(AsesorExterno.APELLIDO_PATERNO),
                    resultados.getString(AsesorExterno.APELLIDO_MATERNO)
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
