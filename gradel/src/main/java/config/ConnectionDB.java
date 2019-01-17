/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aarongmx
 */
public class ConnectionDB implements Configuration {
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(FULL_CONNECTION, USER_DB, PASS_DB);
        } catch ( ClassNotFoundException | SQLException ex ) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
    
    public static void closeConnection(Connection c, PreparedStatement pstm, ResultSet rs) {
        try {
            if ( pstm != null ) {
                pstm.close();
            }
            if ( rs != null ) {
                rs.close();
            }
            
            if ( c != null) {
                c.close();
            }
        } catch ( SQLException e ) {
            System.out.println(e.getMessage());
        }
    }
    
}
