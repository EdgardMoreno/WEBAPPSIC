/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.dao;

import com.general.entity.Sic1sclaseeven;
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
public class DaoSubClaseEventoImpl implements Serializable{
    
    public List<Sic1sclaseeven> obtTodos ( Connection cnConexion, Sic1sclaseeven sic1sclaseeven ) throws SQLException, Exception{
        
        CallableStatement statement = null;
        ResultSet rsConsulta = null;
        List<Sic1sclaseeven> lista = new ArrayList<>();
        
        try {            
            
            
                String sql = 
                        "SELECT DISTINCT  T1.ID_SCLASEEVEN \n" +
                        "                ,T1.COD_SCLASEEVEN\n" +
                        "                ,T1.DES_SCLASEEVEN\n" +
                        "                ,NVL(T3.ID_SGRUSCLASEEVEN,99) AS ID_SGRUSCLASEEVEN " +
                        "                ,UPPER(NVL(T3.DES_SGRUSCLASEEVEN,'OTROS')) AS DES_SGRUSCLASEEVEN " +
                        " FROM SICDBA.SIC1SCLASEEVEN T1\n" +
                        " JOIN SICDBA.SIC1EVEN T2 ON T1.ID_SCLASEEVEN = T2.ID_SCLASEEVEN\n" +
                        " LEFT JOIN SICDBA.VI_SICSGRUSCLASEEVEN T3 ON T3.ID_SGRUSCLASEEVEN = T1.ID_SGRUPSCLASEEVEN " + 
                        " WHERE 1 = 1 ";

                if (sic1sclaseeven != null ){
                    
                    if(sic1sclaseeven.getCodSclaseeven()!= null)
                    
                            sql += " AND T1.COD_SCLASEEVEN = " + sic1sclaseeven.getCodSclaseeven();
                }
                
                sql += " ORDER BY ID_SGRUSCLASEEVEN, DES_SCLASEEVEN";

                statement = cnConexion.prepareCall(sql,
                                                   ResultSet.TYPE_SCROLL_SENSITIVE,
                                                   ResultSet.CONCUR_READ_ONLY,
                                                   ResultSet.CLOSE_CURSORS_AT_COMMIT);

                rsConsulta = statement.executeQuery();
                Sic1sclaseeven obj = null;                

                while(rsConsulta.next()){

                    obj = new Sic1sclaseeven();
                    obj.setIdSclaseeven(rsConsulta.getBigDecimal("ID_SCLASEEVEN"));
                    obj.setCodSclaseeven(rsConsulta.getString("COD_SCLASEEVEN"));
                    obj.setDesSclaseeven(rsConsulta.getString("DES_SCLASEEVEN"));
                    obj.setIdSgrupsclaseeven(rsConsulta.getInt("ID_SGRUSCLASEEVEN"));
                    obj.setDesSgrupsclaseeven(rsConsulta.getString("DES_SGRUSCLASEEVEN"));
                    
                    lista.add(obj);                       
                }
        
        } catch (SQLException e){
            throw new SQLException("obtTodos()-ERROR:" + e.getMessage());
        } catch (Exception e){
            throw new Exception("obtTodos()-ERROR:" + e.getMessage());
        }
        
        return lista;
    }  
    
}
