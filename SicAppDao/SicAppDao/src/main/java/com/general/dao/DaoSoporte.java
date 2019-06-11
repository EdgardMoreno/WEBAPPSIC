/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.dao;

import static com.general.dao.DaoEventoImpl.log;
import conexionbd.InParameter;
import conexionbd.OutParameter;
import conexionbd.StoredProcedure;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

/**
 *
 * @author emoreno
 */
public class DaoSoporte implements Serializable{
    
    
    public void resetearExpediente(  Connection cnConexion                            
                                    ,String codExpe ) throws SQLException, Exception {
        
        StoredProcedure sp = null;
        
        try {
            
            log.info("============== resetearExpediente =====================");
            log.info("codExpe: "     + codExpe);
            
            sp = new StoredProcedure("SICDBA.PKG_SICSOPORTE.PRC_SICRESETEXPE");                        
            sp.addParameter(new InParameter("X_COD_EXPE",  Types.VARCHAR, codExpe));            
            
            sp.addParameter(new OutParameter("X_ID_ERROR",  Types.INTEGER));
            sp.addParameter(new OutParameter("X_DES_ERROR", Types.VARCHAR));            
            
            sp.ExecuteNonQuery(cnConexion);
            
            if (Integer.valueOf(sp.getParameter("X_ID_ERROR").toString()) != 0 ){
                throw new SQLException((String)sp.getParameter("X_DES_ERROR"));
            }
        
        } catch (SQLException e){                        
            log.error(e.getMessage());
            throw new SQLException(e.getMessage());
        } catch (Exception e){                        
            log.error(e.getMessage());
            throw new Exception(e.getMessage());
        }        
    }
    
}
