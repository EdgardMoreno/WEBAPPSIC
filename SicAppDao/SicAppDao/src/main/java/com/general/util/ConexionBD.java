/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.util;


import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import org.apache.log4j.Logger;


public class ConexionBD implements Serializable{
    
    final static Logger log = Logger.getLogger(ConexionBD.class);
    
    private Connection cnConexion;
    private String _strNombreHost;
    private String _strNombreBD;
    private String _strUsuario;
    private String _strContrasenia;
    private int _intFilaError;
    private String _strError;
    
    public Connection getCnConexion() {
        return cnConexion;
    }

    public void setCnConexion(Connection cnConexion) {
        this.cnConexion = cnConexion;
    }
    
    public int getFilaError() {
        return _intFilaError;
    }

    public void setFilaError(int intFilaError) {
        _intFilaError = intFilaError;
    }   
    
    public String getNombreHost() {
        return _strNombreHost;
    }

    public void setNombreHost(String strNombreHost) {
        _strNombreHost = strNombreHost;
    }

    public String getNombreBD() {
        return _strNombreBD;
    }

    public void setNombreBD(String strNombreBD) {
        _strNombreBD = strNombreBD;
    }

    public String getUsuario() {
        return _strUsuario;
    }

    public void setUsuario(String strUsuario) {
        _strUsuario = strUsuario;
    }

    public String getContrasenia() {
        return _strContrasenia;
    }

    public void setContrasenia(String strContrasenia) {
        _strContrasenia = strContrasenia;
    }
    
    
    public String getError() {
        return _strError;
    }

    public void setError(String pstrOrigen, int pintFilaError, String pstrIden, String pstrErrorDesc) {
        _strError = pstrOrigen + "-FILAERROR:" + pintFilaError + "-IDENT: " + pstrIden + " ERRDESC:" + pstrErrorDesc;
    }        
    
    
    public void obtenerConexionDS() throws SQLException, Exception {

        int intFilaError = 0;
        try {
            
            log.debug("====== obtenerConexion =========");
            log.debug("<Antes de obtener conexion del pool>");
                       
            intFilaError = 220;
            Context ctx = null;
            intFilaError = 226;            
            ctx = new InitialContext();
            intFilaError = 228;
            javax.sql.DataSource ds  = (javax.sql.DataSource) ctx.lookup ("jdbc/minceturdb");
            intFilaError = 230;
            this.cnConexion = ds.getConnection();
            this.cnConexion.setAutoCommit(false);
            
            intFilaError = 300;
            
            if(this.cnConexion == null){
                throw new Exception("ConexiÓn nula");
            }
            
            log.debug("<Despues de obtener conexion del pool>");

        } catch (SQLException e){
            
            this.setError("obtenerConexion(SQLException)", intFilaError, "", e.getMessage());
            log.error(this.getError());
            throw new SQLException(this.getError());
        }
        catch(IOException e){
            
            this.setError("obtenerConexion(IOException)", intFilaError, "", e.getMessage());
            log.error(this.getError());
            throw new IOException(this.getError());
        }
        catch(Exception e){
            
            this.setError("obtenerConexion(Exception)", intFilaError, "", e.getMessage());
            log.error(this.getError());
            throw new Exception(this.getError());
        }
    }
    

//    public void obtConexion() throws SQLException, Exception {
//
//        int intFilaError = 0;        
//        
//        try {
//            
//            log.debug("====== obtenerConexion =========");
//            
//            this.setNombreHost("172.16.0.49");
//            this.setNombreBD("PREPRODU");
//            this.setUsuario("SICDBA");
//            this.setContrasenia("Oracle01");
//                        
//            String strCadenaCon = "jdbc:oracle:thin:@" + this.getNombreHost() + ":1521:" + this.getNombreBD();
//                        
//            intFilaError = 200;
//            
//            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());            
//            this.cnConexion =  DriverManager.getConnection(strCadenaCon, this.getUsuario(), this.getContrasenia());
//            
//            intFilaError = 300;
//            
//            if(this.cnConexion == null){
//                throw new Exception("ConexiÓn nula");
//            }
//
//        } catch (SQLException e){
//            
//            this.setError("obtenerConexion(SQLException)", intFilaError, "", e.getMessage());
//            log.error(this.getError());
//            throw new SQLException(this.getError());
//        }
//        catch(IOException e){
//            
//            this.setError("obtenerConexion(IOException)", intFilaError, "", e.getMessage());
//            log.error(this.getError());
//            throw new IOException(this.getError());
//        }
//        catch(Exception e){
//            
//            this.setError("obtenerConexion(Exception)", intFilaError, "", e.getMessage());
//            log.error(this.getError());
//            throw new Exception(this.getError());
//        }
//    }
    
    
    public static Connection obtConexion() throws SQLException, Exception {
        
        Connection cnConexion = null;
        try {
            
            log.debug("====== obtenerConexion =========");
            
            String strNombreHost = "172.16.0.49";
            String strNombreBD = "PREPRODU";
            String strUsuario = "SICDBA";
            String strContrasenia = "Oracle01";

            /*DESARROLLO*/
            String strCadenaCon = "jdbc:oracle:thin:@" + strNombreHost + ":1521:" + strNombreBD;
            
            /*PRUEBAS*/
//            strUsuario = "SICUSER";
//            strCadenaCon = "jdbc:oracle:thin:@172.16.0.175:1525:COM";
//            strContrasenia = "s3c5s2r";
            
//            strUsuario = "SICDBA";
//            strCadenaCon = "jdbc:oracle:thin:@172.16.0.175:1525:COM";
//            strContrasenia = "l5c1q5123";
            
            /*PRODUCCION*/
            strCadenaCon    = "jdbc:oracle:thin:@dborap-scan:1525/MINCETUR";
            strUsuario      = "SICUSER";
            strContrasenia  = "p2r51n42018";
            
//            strCadenaCon    = "jdbc:oracle:thin:@172.16.0.149:1525/MINCETUR";
//            strUsuario      = "SICDBA";
//            strContrasenia  = "WFYo7B8jA8UQcsvBsoJ9";
            
//          System.out.println("CONEXION:" + strCadenaCon);
                       
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            cnConexion =  DriverManager.getConnection(strCadenaCon, strUsuario, strContrasenia);
            cnConexion.setAutoCommit(false);

            if(cnConexion == null){
                throw new Exception("Conexión nula");
            }

        } catch (SQLException e){
            throw new SQLException(e.getMessage());
        }
        catch(Exception e){
            throw new Exception(e.getMessage());
        }

        return cnConexion;
    }
   
}
