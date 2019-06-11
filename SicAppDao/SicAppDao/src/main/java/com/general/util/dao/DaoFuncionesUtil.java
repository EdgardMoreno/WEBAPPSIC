/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.util.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import conexionbd.StoredProcedure;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;


/**
 *
 * @author emoreno
 */
public class DaoFuncionesUtil implements Serializable{
    
    public static Integer FNC_SICOBTIDGEN(Connection conexion, String X_COD_VALORTIPOGENERAL, String X_COD_VALORGENERAL) throws Exception {
        
        Integer result;
        
        try{
        
            CallableStatement call = conexion.prepareCall("{ ? = call SICDBA.PKG_SICCONSGENERAL.FNC_SICOBTIDGEN(?,?) }");
            call.registerOutParameter( 1, Types.INTEGER ); // or whatever it is
            call.setString(2, X_COD_VALORTIPOGENERAL);
            call.setString(3, X_COD_VALORGENERAL);
            call.execute();

            result =  call.getInt(1);
        
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
        return result;
        
    } 
    
    public static ResultSet FNC_OBTLISTGENERAL(Connection cnConexion, String strQuery) throws SQLException{
        
        ResultSet rsConsulta = null;        
        StoredProcedure Sp = null;        
        Sp = new StoredProcedure("");
        rsConsulta= Sp.ExecuteResultSet(cnConexion, strQuery);
        
        return rsConsulta;
    }     
    
    
    /*--------------------------------------------------------------------------------------------------------------
    --DESCRIPCION:   FUNCION GENERICA QUE RETORNA EL INDENTIFICADOR PRINCIPAL.
    --PARAMETROS:    X_DES_IDEN(VARIABLE DE INGRESO QUE CONTIENE PARTE DEL NOMBRE DE LA TABLA)
    --               X_ID_TIPOIDEN(VARIABLE DE INGRESO QUE CONTIENE EL TIPO DE IDENTIFICADOR PRINCIPAL)
    --               X_COD_IDEN(VARIABLE DE INGRESO QUE CONTIENE EL CODIGO DE IDENTIFICACION)
    -------------------------------------------------------------------------------------------------------------- */
    public static Integer FNC_SICOBTIDIDEN(    Connection cnConexion
                                                , String X_DES_IDEN
                                                , Integer X_ID_TIPOIDEN
                                                , String X_COD_IDEN) throws SQLException, Exception{        
        
        //Connection cnConexion = null;
        Integer result = null;
        try{
           
            CallableStatement call = cnConexion.prepareCall("{ ? = call SICDBA.PKG_SICCONSGENERAL.FNC_SICOBTIDIDEN(?,?,?) }");
            call.registerOutParameter( 1, Types.INTEGER ); // or whatever it is
            call.setString(2, X_DES_IDEN);
            call.setInt(3, X_ID_TIPOIDEN);
            call.setString(4, X_COD_IDEN);
            call.execute();
            
            result = call.getInt(1);
            
        }catch(Exception ex){            
            throw new Exception(ex.getMessage());
        }
        return result; // propagate this back to enclosing class
        
    }
    
    public static Integer FNC_SICOBTIDPERS(Connection conexion, String X_COD_TIPOIDEN, String X_COD_IDEN) throws Exception {
        
        Integer result;
        try{        
            CallableStatement call = conexion.prepareCall("{ ? = call SICDBA.PKG_SICCONSPERS.FNC_SICOBTIDPERS(?,?) }");
            call.registerOutParameter( 1, Types.INTEGER ); // or whatever it is
            call.setString(2, X_COD_TIPOIDEN);
            call.setString(3, X_COD_IDEN);
            call.execute();

            result =  call.getInt(1);
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
        return result;        
    }
    
    public static String obtCodIdenAleatorio(Connection conexion) throws SQLException, Exception {
        
        String strCodIden;
        CallableStatement statement = null;
        int nFilaError = 0;
        
        try { 
            
              String sql="begin ? :=SICDBA.FNC_SICOBTCOD(); end;";

              statement = conexion.prepareCall(sql);
              
              statement.registerOutParameter(1, Types.VARCHAR);
              statement.executeUpdate();
              strCodIden = statement.getString(1);

            } catch (SQLException e){
                throw new SQLException("obtCodIdenAleatorio(): " + e.getMessage() + " FilaErr: " + nFilaError);
            } catch (Exception e){
                throw new Exception("obtCodIdenAleatorio(): " + e.getMessage() + " FilaErr: " + nFilaError);
            }
        
        return strCodIden;
    }  
    
}
