/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.postgres;

import config.ConnectionDB;
import interfaces.CarreraDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import models.Carrera;

/**
 *
 * @author aarongmx
 */
public class ImplCarrera implements CarreraDAO {
    
    private Connection conexion;
    private PreparedStatement sentencia;
    private ResultSet resultados;
    
    private final String INSERTAR = "INSERT INTO carreras(clave_carrera, nombre, plan_estudios) VALUES (?, ?, ?);";
    private final String ELIMINAR = "DELETE FROM carreras WHERE clave_carrera = ?;";
    private final String LISTAR = "SELECT clave_carrera, nombre, plan_estudio FROM carreras;";
    
    @Override
    public void insertar(Carrera carrera) {
        conexion = new ConnectionDB().getConnection();
        try {
            sentencia = conexion.prepareStatement(INSERTAR, Statement.RETURN_GENERATED_KEYS);
            sentencia.setString(1, carrera.getClaveCarrera());
            sentencia.setString(2, carrera.getNombre());
            sentencia.setString(3, carrera.getPlanCarrera());
            if (sentencia.executeUpdate() > 0) {
                resultados = sentencia.getGeneratedKeys();
                if (resultados.next()) {
                    carrera.setClaveCarrera(resultados.getString("clave_carrera"));
                }
            }
            
        } catch (SQLException e) {
            throw new excepciones.ExcepcionGeneral(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conexion, sentencia, resultados);
        }
    }

    @Override
    public void modificar(Carrera carrera) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Carrera carrera) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Carrera obtenerPorId(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Carrera> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
