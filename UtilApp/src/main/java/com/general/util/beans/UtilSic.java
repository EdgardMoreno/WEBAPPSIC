/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.util.beans;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author emoreno
 */
public class UtilSic {
 
    public static String obtenerCodigoContent(   String strExpediente
                                                ,String strSufijo) throws Exception {

        String strCodigo = "";
        try {

            DateFormat df = new SimpleDateFormat("HHmmssSSS");
            String strFecha = df.format(UtilClass.getCurrentDateTime());

            strCodigo = "PWIEXP" + strExpediente + strSufijo + strFecha;

        } catch (Exception e) {                
            throw new Exception("getCodigoContent()-ERR:" + e.getMessage());
        }

        return strCodigo;
    }
    
    /**
     * METODO QUE CIERRAR LAS CONEXIONES
     * @param callStatement
     * @param rsConsulta
     * @param cnConexion
     * @throws Exception 
     */
    public static void cerrarConexiones(CallableStatement callStatement, ResultSet rsConsulta, Connection cnConexion) throws Exception{
        
        try{
            
            if(callStatement != null){
                callStatement.close();                
            }
            
            if(rsConsulta != null)
                rsConsulta.close();
            
            if(cnConexion != null){             
                cnConexion.close();                
            }
            
        }catch(SQLException ex){
            throw new Exception();
        }
    }
            
            
}
