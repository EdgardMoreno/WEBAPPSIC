/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.dao;

import com.general.entity.Sic1codiauto;
import com.general.entity.Sic1pers;
import com.general.entity.Sic1prod;
import com.general.entity.Sic3prodpers;
import com.general.util.ConexionBD;
import java.math.BigDecimal;
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
public class DaoJuegoCasinoImpl {
    
    
    public List<Sic3prodpers> obtJuegosCasino(Sic1prod objJuegCas) throws SQLException, Exception{
        
        CallableStatement statement = null;
        ResultSet rsConsulta = null;
        List<Sic3prodpers> lstProd = new ArrayList<>();
        Connection cnConexion = null;
        
        try {
            
            cnConexion = ConexionBD.obtConexion();
            
            String sql =                       
                        " SELECT  \n" +
                        "      T3.ID_PROD \n" +
                        "     ,T3.COD_PROD \n" +
                        "     ,T3.COD_IDEN \n" +
                        "     ,T3.DES_PROD \n" +
                        "     ,RELSALA.ID_LUGAR AS ID_SALA\n" +
                        "     ,SALA.DES_NOMGIRO AS DES_NOMBSALA \n" +
                        "     ,NUM_CANTMESAS \n" +
                        " FROM SICDBA.SIC1PROD T3  \n" +
                        " JOIN SICDBA.SIC1CODIAUTO COD ON COD.ID_ENTIDAD = T3.ID_PROD \n" +
                        "                             AND COD.ID_STIPOCODIAUTO = 45528 /*Memorias*/ \n" +
                        " LEFT JOIN SICDBA.SIC3PRODPERS RELFAB ON  RELFAB.ID_PROD = T3.ID_PROD \n" +
                        "                                AND RELFAB.ID_TROLPERS = 4481 \n" +
                        "                                AND RELFAB.FEC_HASTA = TO_DATE('24001231','YYYYMMDD') \n" +
                        " LEFT JOIN SICDBA.SIC1PERS PERSFAB ON PERSFAB.ID_PERS = RELFAB.ID_PERS \n" +
                        " LEFT JOIN ( SELECT  ID_LUGAR \n" +
                        "                  ,ID_PROD \n" +
                        "                  ,SUM(NUM_MESAS) AS NUM_CANTMESAS\n" +
                        "            FROM SICDBA.SIC3LUGARPROD RELSALA  \n" +
                        "            WHERE ID_TRELALUGARPROD = 122\n" +
                        "                  AND RELSALA.FEC_HASTA = TO_DATE('24001231','YYYYMMDD') \n" +
                        "            GROUP BY  ID_LUGAR  \n" +
                        "                     ,ID_PROD) RELSALA ON T3.ID_PROD = RELSALA.ID_PROD                                                     \n" +
                        " LEFT JOIN SICDBA.SIC1LUGARSALA SALA ON SALA.ID_LUGARSALA = RELSALA.ID_LUGAR \n" +
                        " WHERE 1 = 1";
            
            
            if (objJuegCas.getSic1codiauto() != null && objJuegCas.getSic1codiauto().getIdSala() != null )
                sql +=  " AND RELSALA.ID_LUGAR = " + objJuegCas.getSic1codiauto().getIdSala();
            if (objJuegCas.getSic1codiauto() != null && objJuegCas.getSic1codiauto().getSic1even() != null 
                    && objJuegCas.getSic1codiauto().getSic1even().getCodExpe() != null 
                    && objJuegCas.getSic1codiauto().getSic1even().getCodExpe().trim().length() > 0)
                sql +=  " AND EVEN.COD_EXPE = '" + objJuegCas.getSic1codiauto().getSic1even().getCodExpe().trim() + "'";
            
                        
            sql += " ORDER BY T3.COD_PROD ASC";
            
            System.out.println("sql: " + sql);
            
            statement = cnConexion.prepareCall(sql,
                                                    ResultSet.TYPE_SCROLL_SENSITIVE,
                                                    ResultSet.CONCUR_READ_ONLY,
                                                    ResultSet.CLOSE_CURSORS_AT_COMMIT);            
            
            rsConsulta = statement.executeQuery();                       
                        
            while(rsConsulta.next()){
                
                BigDecimal idProd = rsConsulta.getBigDecimal("ID_PROD");                
                
                Sic1codiauto objCodiauto = new Sic1codiauto();
                objCodiauto.setIdSala(rsConsulta.getBigDecimal("ID_SALA"));
                objCodiauto.setDesNombSala(rsConsulta.getString("DES_NOMBSALA"));                
                
                //Bien Relacionado
                Sic1prod objSic1prod = new Sic1prod();
                objSic1prod.setIdProd(idProd);
                objSic1prod.setCodProd(rsConsulta.getString("COD_PROD"));
                objSic1prod.setCodIden(rsConsulta.getString("COD_IDEN"));
                objSic1prod.setDesProd(rsConsulta.getString("DES_PROD"));    
                objSic1prod.setNumCantMesas(rsConsulta.getInt("NUM_CANTMESAS"));
                objSic1prod.setSic1codiauto(objCodiauto);
                
                Sic3prodpers sic3prodpers = new Sic3prodpers();
                sic3prodpers.setSic1prod(objSic1prod);
                
                lstProd.add(sic3prodpers);
            }
        
        } catch (SQLException e){
            throw new SQLException("obtJuegosCasino()-FE:" + e.getMessage());
        } catch (Exception e){            
            throw new Exception("obtJuegosCasino()-FE:" + e.getMessage());
        } finally{
            if(statement != null){
                statement.close();                
            }
            
            if(rsConsulta!=null)
                rsConsulta.close();
            
            if(cnConexion != null)
                cnConexion.close();
        }
        
        return lstProd;
    }
}
