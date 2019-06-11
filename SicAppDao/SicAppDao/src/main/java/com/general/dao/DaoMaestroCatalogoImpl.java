/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.dao;

import com.general.entity.Sic1general;
import com.general.entity.Sic3proditempers;
import com.general.util.ConexionBD;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author emoreno
 */
public class DaoMaestroCatalogoImpl implements Serializable{

    
    public String obtUrlPWA(Connection cnConexion, String codVersudm) throws SQLException, Exception{
        
        CallableStatement statement = null;
        ResultSet rsConsulta = null;        
        String resultado = null;
        
        try {
            
            String sql = "SELECT DES_VALOR FROM SICDBA.VI_SICVERSUDM WHERE COD_VERSUDM = '" + codVersudm + "'";
                    
            statement = cnConexion.prepareCall(sql,
                                            ResultSet.TYPE_SCROLL_SENSITIVE,
                                            ResultSet.CONCUR_READ_ONLY,
                                            ResultSet.CLOSE_CURSORS_AT_COMMIT);            
            
            rsConsulta = statement.executeQuery();                       
                        
            while(rsConsulta.next()){
                
                resultado = rsConsulta.getString("DES_VALOR");                
                     
            }
        
        } catch (SQLException e){            
            throw new SQLException("obtUrlPWA()-FE:" + e.getMessage());
        } catch (Exception e){            
            throw new Exception("obtUrlPWA()-FE:" + e.getMessage());
        } finally{
            if(statement != null){
                statement.close();                
            }
            if(rsConsulta != null)
                rsConsulta.close();
        }
        
        return resultado;
        
    }
    
    public List<Sic1general> obtCatalogoPermisos() throws SQLException, Exception{
        
        CallableStatement statement = null;
        ResultSet rsConsulta = null;
        List<Sic1general> lst = new ArrayList<>();
        Connection cnConexion = null;
        
        try {
            
            String sql = "SELECT * FROM SICDBA.VI_SICSTIPOEVEN WHERE COD_VALORGENERALREL = 'PERMISOS'";

            cnConexion = ConexionBD.obtConexion();
            statement = cnConexion.prepareCall(sql,
                                            ResultSet.TYPE_SCROLL_SENSITIVE,
                                            ResultSet.CONCUR_READ_ONLY,
                                            ResultSet.CLOSE_CURSORS_AT_COMMIT);            
            
            rsConsulta = statement.executeQuery();                       
            
            while(rsConsulta.next()){
                
                Sic1general obj = new Sic1general();
                obj.setIdGeneral(rsConsulta.getBigDecimal("ID_STIPOEVEN"));
                obj.setDesGeneral(rsConsulta.getString("DES_STIPOEVEN"));                
                lst.add(obj);
            }
        
        } catch (SQLException e){            
            throw new SQLException("obtCatalogoPermisos()-FE:" + e.getMessage());
        } catch (Exception e){            
            throw new Exception("obtCatalogoPermisos()-FE:" + e.getMessage());
        } finally{
            
            if(cnConexion!=null)
                cnConexion.close();
            
            if(statement != null){
                statement.close();                
            }
            
            if(rsConsulta != null)
                rsConsulta.close();
        }
        
        return lst;        
    }    
    
}
