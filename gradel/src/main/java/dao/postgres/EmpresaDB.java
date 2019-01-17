package dao.postgres;

import config.ConnectionDB;
import excepciones.ExcepcionGeneral;
import interfaces.EmpresaDAO;
import models.Empresa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpresaDB implements EmpresaDAO {

    private Connection conexion;
    private PreparedStatement sentencia;
    private ResultSet resultados;
    
    private final String INSERTAR = "INSERT INTO empresas(rfc, nombre, encargado, domicilio, colonia, codigo_postal, alcaldia_municipio, pagina_web) VALUES (?, ?, ?, ?) RETURNING empresa_id;";
    private final String ACTUALIZAR = "UPDATE empresas SET rfc = ?, nombre = ?, encargado = ?, domicilio = ?, colonia = ?, codigo_postal = ?, alcaldia_municipio = ?, pagina_web = ? WHERE empresa_id = ?;";
    private final String OBTENERPORID = "SELECT rfc, nombre, encargado, domicilio, colonia, codigo_postal, alcaldia_municipio, pagina_web FROM empresas WHERE empresa_id = ?;";
    private final String ELIMINAR = "DELETE FROM empresas WHERE empresa_id = ?;";
    private final String LISTAR = "SELECT rfc, nombre, encargado, domicilio, colonia, codigo_postal, alcaldia_municipio, pagina_web FROM empresas;";

    @Override
    public void insert(Empresa empresa) {
        conexion = new ConnectionDB().getConnection();
        try {
            sentencia = conexion.prepareStatement(INSERTAR);
            sentencia.setString(1, empresa.getNombre());
            sentencia.setString(2, empresa.getEncargado());
            sentencia.setString(3, empresa.getDomicilio());
            sentencia.setString(4, empresa.getPaginaWeb());

            resultados = sentencia.executeQuery();

            if (resultados.next()) {
                empresa.setEmpresaId(resultados.getInt(Empresa.EMPRESA_ID));
            } else {
                throw new ExcepcionGeneral("No se insertó nignún registro");
            }

        } catch (SQLException e) {
            throw new ExcepcionGeneral(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conexion, sentencia, resultados);
        }
    }

    @Override
    public void update(Empresa empresa) {
        conexion = new ConnectionDB().getConnection();
        try {
            sentencia = conexion.prepareStatement(ACTUALIZAR);
            sentencia.setString(1, empresa.getNombre());
            sentencia.setString(2, empresa.getEncargado());
            sentencia.setString(3, empresa.getDomicilio());
            sentencia.setString(4, empresa.getPaginaWeb());

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
    public void delete(Empresa empresa) {
        conexion = new ConnectionDB().getConnection();
        try {
            sentencia = conexion.prepareStatement(ELIMINAR);
            sentencia.setInt(1, empresa.getEmpresaId());

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
    public Empresa getById(Integer id) {
        conexion = new ConnectionDB().getConnection();
        Empresa empresa = null;
        try {
            sentencia = conexion.prepareStatement(OBTENERPORID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            sentencia.setInt(1, id);

            resultados = sentencia.executeQuery();

            if (resultados.first()) {
                empresa = new Empresa(
                    id,
                    resultados.getString(Empresa.RFC),
                    resultados.getString(Empresa.NOMBRE),
                    resultados.getString(Empresa.ENCARGADO),
                    resultados.getString(Empresa.DOMICILIO),
                    resultados.getString(Empresa.COLONIA),
                    resultados.getString(Empresa.CODIGO_POSTAL),
                    resultados.getString(Empresa.ALCALDIA_MUNICIPIO),
                    resultados.getString(Empresa.PAGINA_WEB)
                );
            }

        } catch (SQLException e) {
            throw new ExcepcionGeneral(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conexion, sentencia, resultados);
        }
        return empresa;
    }

    @Override
    public List<Empresa> list() {
        ArrayList<Empresa> list = new ArrayList<>();
        conexion = new ConnectionDB().getConnection();
        try {
            sentencia = conexion.prepareStatement(LISTAR);

            resultados = sentencia.executeQuery();
            while (resultados.next()) {
                list.add(
                    new Empresa(
                        resultados.getInt(Empresa.EMPRESA_ID),
                        resultados.getString(Empresa.RFC),
                        resultados.getString(Empresa.NOMBRE),
                        resultados.getString(Empresa.ENCARGADO),
                        resultados.getString(Empresa.DOMICILIO),
                        resultados.getString(Empresa.COLONIA),
                        resultados.getString(Empresa.CODIGO_POSTAL),
                        resultados.getString(Empresa.ALCALDIA_MUNICIPIO),
                        resultados.getString(Empresa.PAGINA_WEB)
                    )
                );
            }
        } catch (SQLException e) {
            throw new ExcepcionGeneral(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conexion, sentencia, resultados);
        }
        return null;
    }
}
