package dao.postgres;

import config.ConnectionDB;
import models.Direcciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DireccionDB {

    private Connection conexion;
    private PreparedStatement sentencia;
    private ResultSet resultados;

    private final String SELECCIONAR_COLONIA;

    public DireccionDB() {
        SELECCIONAR_COLONIA = "SELECT colonia FROM direcciones WHERE cp = ?;";
    }

    public List<String> getColonias(Direcciones direccion) {
        conexion = new ConnectionDB().getConnection();
        ArrayList<String> lista = new ArrayList<>();
        try {
            sentencia = conexion.prepareStatement(SELECCIONAR_COLONIA);
            sentencia.setString(1, direccion.getCodigoPostal());
            resultados = sentencia.executeQuery();

            while (resultados.next()) {
                lista.add(resultados.getString("colonia"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conexion, sentencia, resultados);
        }
        return lista;
    }

    public List<Direcciones> selected(String codigoPostal) {
        conexion = new ConnectionDB().getConnection();
        ArrayList<Direcciones> direcciones = new ArrayList<>();
        try {
            sentencia = conexion.prepareStatement("SELECT id, colonia, asentamiento, municipio, estado, ciudad FROM direcciones WHERE cp = ?;");
            sentencia.setString(1, codigoPostal);
            resultados = sentencia.executeQuery();

            while (resultados.next()) {
                direcciones.add(
                    new Direcciones(
                        resultados.getInt("id"),
                        codigoPostal,
                        resultados.getString("colonia"),
                        resultados.getString("asentamiento"),
                        resultados.getString("municipio"),
                        resultados.getString("estado"),
                        resultados.getString("ciudad")
                    )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conexion, sentencia, resultados);
        }
        return direcciones;
    }
}
