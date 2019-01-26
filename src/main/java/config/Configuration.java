/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

/**
 *
 * @author aarongmx
 */
public interface Configuration {
    String APP_NAME = "Sistema de Control de Residencias";
    
    /**
     * Database DATA
     */
    String HOST_DB = "localhost";
    String USER_DB = "postgres";
    String PASS_DB = "dbadmin";
    String NAME_DB = "arca";
    String PORT_DB = "5432";
    String FULL_CONNECTION = "jdbc:postgresql://" + HOST_DB + ":" + PORT_DB + "/" + NAME_DB;
}
