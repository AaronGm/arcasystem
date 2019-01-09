/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.postgres;

import config.ConnectionDB;
import excepciones.ExcepcionGeneral;
import interfaces.ProfesorDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.Persona;
import models.Profesor;

/**
 *
 * @author aarongmx
 */
public class ImplProfesor implements ProfesorDAO {
    
    private Connection conexion;
    private PreparedStatement sentencia;
    private ResultSet resultados;
    
    private final String INSERTAR = "INSERT INTO profesores(no_trabajador, nombres, apellido_paterno, apellido_materno, fecha_ingreso, grado_estudios, estatus_profesor, area_especialidad) VALUES (?, ?, ?, ?, ?, ?::grado_estudios, ?::estado_profesor, ?);";
    private final String LISTAR = "SELECT profesor_id, no_trabajador, nombres, apellido_paterno, apellido_materno, fecha_ingreso, grado_estudios, estatus_profesor, area_especialidad FROM profesores;";

    @Override
    public void insertar(Profesor profesor) {
        conexion = new ConnectionDB().getConnection();
        try {
            sentencia = conexion.prepareStatement(INSERTAR, Statement.RETURN_GENERATED_KEYS);
            sentencia.setString(1, profesor.getNoContrato());
            sentencia.setString(2, profesor.getNombres());
            sentencia.setString(3, profesor.getApellidoPaterno());
            sentencia.setString(4, profesor.getApellidoMaterno());
            sentencia.setDate(5, (Date) profesor.getFechaIngreso());
            sentencia.setString(6, profesor.getGradoEstudio());
            sentencia.setString(7, profesor.getEstatusProfesor());
            sentencia.setString(8, profesor.getAreaEspecialidad());
            
            int filasAfectadas = sentencia.executeUpdate();
            
            if ( filasAfectadas > 0 ) {
                resultados = sentencia.getGeneratedKeys();
                if (resultados.next()) {
                    profesor.setProfesorId(resultados.getInt(Profesor.PROFESOR_ID));
                }
            } else {
                JOptionPane.showConfirmDialog(null, "Error");
            }
        } catch (SQLException e) {
            throw new ExcepcionGeneral(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conexion, sentencia, resultados);
        }
    }

    @Override
    public void modificar(Profesor profesor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Profesor profesor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Profesor obtenerPorId(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Profesor> listar() {
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
                        resultados.getString(Persona.NOMBRES),
                        resultados.getString(Persona.APELLIDO_PATERNO),
                        resultados.getString(Persona.APELLIDO_MATERNO)
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
