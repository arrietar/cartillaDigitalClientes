/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema.clientesDAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author renea
 */
public class conexion {
    String strConexionDB="jdbc:sqlite:D:/Mis Documentos/Java Projects/proyecto_cartillaDigital/src/clientes.s3db";
    Connection conn = null;
    
    public conexion(){
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(strConexionDB);
            
            System.out.println("Conexion Establecida");
        } catch (Exception e) {
            System.out.println("Error de conexion "+e);
        }
    }
    
    public int executeSQL(String sentenciaSQL){
        
        try {
            PreparedStatement pstm = conn.prepareStatement(sentenciaSQL);
            pstm.execute();
            return 1;
        } catch (SQLException e) {
            System.out.println("e");
            return 0;
        }
    }
    
    public ResultSet consultarRegistros(String sentenciaSQL){
        
        try {
            PreparedStatement pstm = conn.prepareStatement(sentenciaSQL);
            ResultSet respuesta = pstm.executeQuery();
            return respuesta;
        } catch (Exception e) {
            System.out.println("e");
            return null;
        }
        
    }
    
}
