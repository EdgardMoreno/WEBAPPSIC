/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.dao;

import com.general.entity.Sic1codiauto;
import com.general.entity.Sic1docu;
import com.general.entity.Sic1docubina;
import com.general.entity.Sic1even;
import com.general.entity.Sic1pers;
import com.general.entity.Sic1proditem;
import com.general.entity.Sic3proditempers;
import com.general.entity.Sic3proditempersPK;
import com.general.util.ConexionBD;
import com.general.util.beans.ComprobantePago;
import com.general.util.beans.UtilSic;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author emoreno
 */
public class DaoMaquinaImpl implements Serializable{
    
    final static Logger log = Logger.getLogger(DaoDocumentoImpl.class);
    
    /**
     * METODO QUE LISTA LAS MAQUINAS QUE YA TIENEN CODIGO DE AUTORIZACION
     * @param objMaq
     * @return
     * @throws SQLException
     * @throws Exception 
     */
    public List<Sic3proditempers> obtMaquinasAutorizadas(Sic1proditem objMaq) throws SQLException, Exception{
        
        CallableStatement callStatement = null;
        ResultSet rsConsulta = null;
        List<Sic3proditempers> lstMaquinas = new ArrayList<>();
        Connection cnConexion = null;
        
        System.out.println("idPers: " + objMaq.getIdPersadmin());
        try {
            
            cnConexion = ConexionBD.obtConexion();
            
            String sql =                       
                        " SELECT " +
                        "      T3.ID_PRODITEM \n" +
                        "     ,T3.NUM_SERIE\n" +
                        "     ,T3.COD_CODIAUTO AS COD_REGIMT\n" +
                        "     ,TIPOMAQ.ID_TIPOMAQU\n" +
                        "     ,UPPER(TIPOMAQ.DES_TIPOMAQU) AS DES_TIPOMAQU \n" +
                        "     ,PERSADMIREGI.ID_PERS AS ID_PERSADMIREGISTRO\n" +
                        "     ,PERSADMIREGI.DES_PERS AS DES_PERSADMIREGISTRO\n" +
                        "     ,T3.FEC_FABR\n" +
                        "     ,T3.NUM_MTPRIN\n" +
                        "     ,T3.NUM_COMP\n" +
                        
                        "     ,PERSADMIRELA.ID_PERS AS ID_PERSADMIRELA \n" +
                        "     ,PERSADMIRELA.DES_PERS AS DES_PERSADMIRELA \n" +
                        "     ,T4.FEC_DESDE AS FEC_REGISTROMT \n" +
                        "     ,T4.FEC_HASTA AS FEC_HASTAMT \n" +
                        
                        "     --,COD.ID_DOCURESO       \n" +
                        "     ,T9.ID_DOCU AS ID_DOCURESO\n" +
                        "     ,DOCUBINA.NUM_DOCUBINA AS COD_NUMRESO  \n" +
                        "     ,DOCUBINA.DES_LOCAURI  \n" +
                                                
                        "     ,EVEN.ID_EVEN  \n" +
                        "     ,EVEN.COD_EXPE \n" +
                        
                        "     ,MODELO.ID_PROD AS ID_PRODMODE \n" +
                        "     ,T3.COD_REGIMODE \n" +
                        "     ,T3.COD_IDENMODE \n" +
                        
                        "     ,PERSFAB.ID_PERS AS ID_PERSFAB \n" +
                        "     ,PERSFAB.DES_PERS AS DES_PERSFAB \n" +
                        "     ,RELSALA.ID_LUGAR AS ID_SALA  \n" +
                        "     ,SALA.DES_NOMGIRO AS DES_NOMBSALA  \n" +
                        
                        "     ,COMPAGO.NUM_COMPROBANTE\n" +
                        "     ,COMPAGO.DES_LOCAURI AS DES_LOCAURI_COMPAGO " +
                        "     ,COMPAGO.DES_TITULO AS DES_TITULO_COMPAGO " +
                        " FROM SICDBA.SIC3PRODITEMPERS T4\n" +
                        " LEFT JOIN SICDBA.SIC3PRODITEMDOCU T9 ON T9.ID_PRODITEM = T4.ID_PRODITEM\n" +
                        "                                   AND T9.FEC_HASTA = TO_DATE('24001231','YYYYMMDD')                                    \n" +
                        " JOIN SICDBA.SIC1CODIAUTO COD ON COD.ID_ENTIDAD = T4.ID_PRODITEM \n" +
                        "                                 AND COD.ID_STIPOCODIAUTO = 45777 \n" +
                        " JOIN SICDBA.SIC1PRODITEM T3 ON T3.ID_PRODITEM = T4.ID_PRODITEM \n" +
                        "                                AND T4.ID_TROLPERS = 91 \n" +
                        " LEFT JOIN SICDBA.SIC1PERS PERSADMIRELA ON PERSADMIRELA.ID_PERS = T4.ID_PERS \n" +
                        " LEFT JOIN SICDBA.VI_SICTIPOMAQU TIPOMAQ ON TIPOMAQ.ID_TIPOMAQU = T3.ID_TIPOMAQ \n" +
                        
                        " LEFT JOIN SICDBA.SIC1PROD MODELO  ON MODELO.COD_PROD = T3.COD_REGIMODE \n" +
                        " LEFT JOIN SICDBA.SIC1PERS PERSFAB ON PERSFAB.ID_PERS = T3.ID_PERSFABR \n" +
                        " LEFT JOIN SICDBA.SIC1DOCUBINA DOCUBINA ON DOCUBINA.ID_DOCU = T9.ID_DOCU\n" +
                        "                                    AND DOCUBINA.NUM_DOCUBINA IS NOT NULL \n" +
                        " LEFT JOIN SICDBA.SIC1EVEN EVEN ON T9.ID_DOCU = EVEN.ID_DOCURESO --COD.ID_EVEN = EVEN.ID_EVEN \n" +
                        " LEFT JOIN SICDBA.SIC1PERS PERSADMIREGI ON PERSADMIREGI.ID_PERS = T3.ID_PERSADMIN  \n" +
                        " LEFT JOIN SICDBA.SIC3LUGARPRODITEM RELSALA ON T4.ID_PRODITEM = RELSALA.ID_PRODITEM\n" +
                        "                                             AND TRUNC(RELSALA.FEC_HASTA) >= TRUNC(SYSDATE)\n" +
                        " LEFT JOIN SICDBA.SIC1LUGARSALA SALA ON SALA.ID_LUGARSALA = RELSALA.ID_LUGAR  \n" +
                        " LEFT JOIN SICDBA.VI_SICOBTCOMPRPAGO COMPAGO ON COMPAGO.ID_EVEN = COD.ID_EVEN\n" +
                        "                                              AND T3.NUM_COMP = COMPAGO.NUM_COMPROBANTE\n" +
                        " WHERE T4.FEC_HASTA = TO_DATE('24001231','YYYYMMDD') AND 1 = 1 ";
                    
                    //sql += " AND COD.FLG_CODIAUTONOTI = 1";
            
            if (objMaq.getIdPersadmin() != null)
                sql +=  " AND T3.ID_PERSADMIN = " + objMaq.getIdPersadmin();
            if (objMaq.getNumSerie() != null && objMaq.getNumSerie().trim().length() > 0)
                sql +=  " AND UPPER(T3.NUM_SERIE) = '" + objMaq.getNumSerie().trim().toUpperCase() + "'";
            if (objMaq.getCodCodiauto()!= null && objMaq.getCodCodiauto().trim().length() > 0)
                sql +=  " AND UPPER(T3.COD_CODIAUTO) = '" + objMaq.getCodCodiauto().trim() + "'";
            if (objMaq.getCodRegimode()!= null && objMaq.getCodRegimode().trim().length() > 0)
                sql +=  " AND UPPER(T3.COD_REGIMODE) = '" + objMaq.getCodRegimode().trim() + "'";
            if (objMaq.getCodIdenmode()!= null && objMaq.getCodIdenmode().trim().length() > 0)
                sql +=  " AND UPPER(T3.COD_IDENMODE) like '" + objMaq.getCodIdenmode().trim() + "%'";
            if (objMaq.getSic1codiauto() != null && objMaq.getSic1codiauto().getIdSala() != null )
                sql +=  " AND RELSALA.ID_LUGAR = " + objMaq.getSic1codiauto().getIdSala();
            if (objMaq.getSic1codiauto() != null && objMaq.getSic1codiauto().getSic1even() != null 
                    && objMaq.getSic1codiauto().getSic1even().getCodExpe() != null 
                    && objMaq.getSic1codiauto().getSic1even().getCodExpe().trim().length() > 0)
                sql +=  " AND EVEN.COD_EXPE = '" + objMaq.getSic1codiauto().getSic1even().getCodExpe().trim() + "'";            

            
            sql += " ORDER BY ID_EVEN, COD_REGIMODE, NUM_SERIE ";
            
            System.out.println("sql:" + sql);
            
            callStatement = cnConexion.prepareCall(sql,
                                                    ResultSet.TYPE_SCROLL_SENSITIVE,
                                                    ResultSet.CONCUR_READ_ONLY,
                                                    ResultSet.CLOSE_CURSORS_AT_COMMIT);            
            
            rsConsulta = callStatement.executeQuery();                       
                        
            while(rsConsulta.next()){
                
                BigDecimal idProditem = rsConsulta.getBigDecimal("ID_PRODITEM");
                BigDecimal idPersrela = rsConsulta.getBigDecimal("ID_PERSADMIRELA"); //Identificado del administrado dueño de la maquina
                Integer idPersregi = rsConsulta.getInt("ID_PERSADMIREGISTRO"); //identificador del administrado que hizo el registro de la maquina
                
                //Modelo Relacionado
                //Sic1prod objSic1prod = new Sic1prod();
                
                Sic1docubina objDocubina = new Sic1docubina();
                objDocubina.setNumDocubina(rsConsulta.getString("COD_NUMRESO"));
                objDocubina.setDesLocauri(rsConsulta.getString("DES_LOCAURI"));
                
                Sic1docu objDocu = new Sic1docu();
                objDocu.setIdDocu(rsConsulta.getBigDecimal("ID_DOCURESO"));
                objDocu.setSic1docubina(objDocubina);
                
                Sic1even objEven = new Sic1even();
                objEven.setIdEven(rsConsulta.getBigDecimal("ID_EVEN"));
                objEven.setCodExpe(rsConsulta.getString("COD_EXPE"));
                
                Sic1codiauto objCodiauto = new Sic1codiauto();
                objCodiauto.setIdSala(rsConsulta.getBigDecimal("ID_SALA"));
                objCodiauto.setDesNombSala(rsConsulta.getString("DES_NOMBSALA"));
                objCodiauto.setSic1even(objEven);
                objCodiauto.setSic1docu(objDocu);
                
                //COMPROBANTE DE PAGO
                ComprobantePago objCompPago = new ComprobantePago();
                objCompPago.setDesLocauri(rsConsulta.getString("DES_LOCAURI_COMPAGO"));
                objCompPago.setDesNombreal(rsConsulta.getString("DES_TITULO_COMPAGO"));
                objCompPago.setNumComprobante(rsConsulta.getString("NUM_COMPROBANTE"));
                
                //Bien Relacionado
                Sic1proditem objSic1proditem = new Sic1proditem();
                objSic1proditem.setIdProditem(idProditem);
                objSic1proditem.setNumSerie(rsConsulta.getString("NUM_SERIE"));
                objSic1proditem.setCodCodiauto(rsConsulta.getString("COD_REGIMT"));
                objSic1proditem.setIdTipomaq(rsConsulta.getInt("ID_TIPOMAQU"));
                objSic1proditem.setDesTipomaq(rsConsulta.getString("DES_TIPOMAQU"));
                objSic1proditem.setIdPersadmin(idPersregi);
                objSic1proditem.setDesPersadmin(rsConsulta.getString("DES_PERSADMIREGISTRO"));
                objSic1proditem.setFecFabr(rsConsulta.getString("FEC_FABR"));
                objSic1proditem.setNumMtprin(rsConsulta.getString("NUM_MTPRIN"));
                objSic1proditem.setNumComp(rsConsulta.getString("NUM_COMP"));
                objSic1proditem.setCodRegimode(rsConsulta.getString("COD_REGIMODE"));
                objSic1proditem.setCodIdenmode(rsConsulta.getString("COD_IDENMODE"));
                objSic1proditem.setIdPersfabr(rsConsulta.getInt("ID_PERSFAB"));
                objSic1proditem.setDesPersfab(rsConsulta.getString("DES_PERSFAB"));
                objSic1proditem.setCompPago(objCompPago);
                objSic1proditem.setSic1codiauto(objCodiauto);
                
                //Administrado Relacionado
                Sic1pers objSic1pers = new Sic1pers();
                objSic1pers.setIdPers(rsConsulta.getBigDecimal("ID_PERSADMIRELA"));
                objSic1pers.setDesPers(rsConsulta.getString("DES_PERSADMIRELA"));

                //
                Sic3proditempersPK objSic3proditempersPK = new Sic3proditempersPK();
                objSic3proditempersPK.setIdProditem(idProditem);
                objSic3proditempersPK.setIdPers(idPersrela);
                objSic3proditempersPK.setFecHasta(rsConsulta.getTimestamp("FEC_HASTAMT"));
                
                //Uniendo objetos
                Sic3proditempers objSic3proditempers = new Sic3proditempers();
                objSic3proditempers.setFecDesde(rsConsulta.getTimestamp("FEC_REGISTROMT"));
                objSic3proditempers.setSic3proditempersPK(objSic3proditempersPK);
                objSic3proditempers.setSic1proditem(objSic1proditem);
                objSic3proditempers.setSic1pers(objSic1pers);
                
                lstMaquinas.add(objSic3proditempers);
            }
        
        } catch (SQLException e){
            throw new SQLException("obtMaquinasXAdmi()-FE:" + e.getMessage());
        } catch (Exception e){            
            throw new Exception("obtMaquinasXAdmi()-FE:" + e.getMessage());
        } finally{            
            UtilSic.cerrarConexiones(callStatement, rsConsulta, cnConexion);
        }
        
        return lstMaquinas;
    }
    
    /**
     * METODO QUE OBTIENE LAS MAQUINAS QUE ESTAN EN TRAMITE, SIEMPRE Y CUANDO NO HAYAN SIDO AUTORIZADAS
     * @param objMaq
     * @return
     * @throws SQLException
     * @throws Exception 
     */
    public List<Sic3proditempers> obtMaquinasEnTramite(Sic1proditem objMaq) throws SQLException, Exception{
        
        CallableStatement callStatement = null;
        ResultSet rsConsulta = null;
        List<Sic3proditempers> lstMaquinas = new ArrayList<>();
        Connection cnConexion = null;
        Boolean flgFiltro = false;
        
        System.out.println("idPers: " + objMaq.getIdPersadmin());
        try {
            
            cnConexion = ConexionBD.obtConexion();
            
            String sql =                       
                        "   SELECT   \n" +
                        "      T4.NUM_SERIE  \n" +
                        "     ,TIPOMAQ.ID_TIPOMAQU  \n" +
                        "     ,UPPER(TIPOMAQ.DES_TIPOMAQU) AS DES_TIPOMAQU   \n" +
                        "      \n" +
                        "     ,PERSADMINREGISTRO.ID_PERS AS ID_PERSADMINREGISTRO \n" +
                        "     ,PERSADMINREGISTRO.DES_PERS AS DES_PERSADMINREGISTRO \n" +
                        "     ,T4.FEC_REGI AS FEC_FABRICACION \n" +
                        "     ,T4.NUM_MTPRIN \n" +
                        "     ,T4.NUM_COMP \n" +
                        "                         \n" +
                        "     ,EVEN.ID_EVEN    \n" +
                        "     ,EVEN.COD_EXPE   \n" +
                        "  \n" +
                        "     ,MODELO.ID_PROD AS ID_PRODMODE \n" +
                        "     ,T4.COD_PROD AS COD_REGIMODE   \n" +
                        "     ,T4.COD_MODEMAQU AS COD_IDENMODE   \n" +
                        "  \n" +
                        "     ,PERSFAB.ID_PERS AS ID_PERSFAB   \n" +
                        "     ,PERSFAB.DES_PERS AS DES_PERSFAB   \n" +
                        "  \n" +
                        "     ,COMPAGO.NUM_COMPROBANTE  \n" +
                        "     ,COMPAGO.DES_LOCAURI AS DES_LOCAURI_COMPAGO   \n" +
                        "     ,COMPAGO.DES_TITULO AS DES_TITULO_COMPAGO \n" +
                        "     \n" +
                        "     ,EVEN.ID_DOCURESO\n" +
                        "     ,BINA.NUM_DOCUBINA AS COD_NUMRESO\n" +
                        "     ,BINA.DES_LOCAURI\n" +
                        "  \n" +
                        "  FROM SICDBA.SIC4REGMAQUTRAG T4       \n" +
                        "  LEFT JOIN SICDBA.VI_SICTIPOMAQU TIPOMAQ ON UPPER(TIPOMAQ.DES_TIPOMAQU) = UPPER(T4.DES_TIPMAQ) \n" +
                        "  \n" +
                        "  LEFT JOIN SICDBA.SIC1PROD MODELO  ON MODELO.COD_PROD = T4.COD_PROD \n" +
                        "  LEFT JOIN SICDBA.SIC1PERS PERSFAB ON UPPER(PERSFAB.DES_PERS) = UPPER(T4.DES_PERSFAB) \n" +
                        "  \n" +
                        "  LEFT JOIN SICDBA.SIC1EVEN EVEN ON EVEN.ID_EVEN = T4.ID_EVEN \n" +
                        "  LEFT JOIN SICDBA.SIC1PERS PERSADMINREGISTRO ON PERSADMINREGISTRO.ID_PERS = T4.ID_PERS \n" +
                        "  \n" +
                        "  LEFT JOIN SICDBA.VI_SICOBTCOMPRPAGO COMPAGO ON COMPAGO.ID_EVEN = T4.ID_EVEN\n" +
                        "                                                AND COMPAGO.NUM_COMPROBANTE  = T4.NUM_COMP \n" +
                        "  \n" +
                        "  LEFT JOIN SICDBA.SIC1DOCUBINA BINA ON BINA.ID_DOCU = EVEN.ID_DOCURESO\n" +
                        "                                       AND NVL(BINA.NUM_DOCUBINA,'0') <> '0'\n" +
                        "  \n" +
                        "  WHERE T4.FLG_ACTIVO IN (1,3) AND NOT EXISTS ( SELECT 1  \n" +
                        "                                               FROM SICDBA.SIC1PRODITEM TMP1  \n" +
                        "                                               WHERE TMP1.NUM_SERIE = T4.NUM_SERIE  \n" +
                        "                                                     AND TMP1.ID_PERSFABR =  PERSFAB.ID_PERS  \n" +
                        "                                                     AND UPPER(REPLACE(TMP1.COD_IDENMODE,' ','')) = UPPER(REPLACE(T4.COD_MODEMAQU,' ',''))) ";
                    
            
            if (objMaq.getIdPersadmin() != null){
                sql +=  " AND PERSADMINREGISTRO.ID_PERSADMINREGISTRO = " + objMaq.getIdPersadmin();
                flgFiltro = true;
            }
            if (objMaq.getNumSerie() != null && objMaq.getNumSerie().trim().length() > 0){
                sql +=  " AND UPPER(T4.NUM_SERIE) = '" + objMaq.getNumSerie().trim().toUpperCase() + "'";
                flgFiltro = true;
            }
            if (objMaq.getCodRegimode()!= null && objMaq.getCodRegimode().trim().length() > 0){
                sql +=  " AND UPPER(T4.COD_PROD) = '" + objMaq.getCodRegimode().trim() + "'";
                flgFiltro = true;
            }
            if (objMaq.getCodIdenmode()!= null && objMaq.getCodIdenmode().trim().length() > 0){
                sql +=  " AND UPPER(T4.COD_MODEMAQU) LIKE '" + objMaq.getCodIdenmode().trim() + "%'";            
                flgFiltro = true;
            }
            if (objMaq.getSic1codiauto() != null && objMaq.getSic1codiauto().getSic1even() != null 
                    && objMaq.getSic1codiauto().getSic1even().getCodExpe() != null 
                    && objMaq.getSic1codiauto().getSic1even().getCodExpe().trim().length() > 0){
                sql +=  " AND EVEN.COD_EXPE = '" + objMaq.getSic1codiauto().getSic1even().getCodExpe().trim() + "'";
                flgFiltro = true;
            }
            
            /*Si no hay ningun filtro no se muestra nada*/
            if(!flgFiltro)
                sql +=  " AND 1 = 2 ";
            
            sql += " ORDER BY ID_EVEN, COD_REGIMODE, NUM_SERIE ";
            
            callStatement = cnConexion.prepareCall( sql,
                                                    ResultSet.TYPE_SCROLL_SENSITIVE,
                                                    ResultSet.CONCUR_READ_ONLY,
                                                    ResultSet.CLOSE_CURSORS_AT_COMMIT );            
            
            rsConsulta = callStatement.executeQuery();                       
                        
            while(rsConsulta.next()){                
                
                Integer idPersregi = rsConsulta.getInt("ID_PERSADMINREGISTRO"); //identificador del administrado que hizo el registro de la maquina
                
                //Modelo Relacionado
                //Sic1prod objSic1prod = new Sic1prod();
                
                
                Sic1docubina objDocubina = new Sic1docubina();
                objDocubina.setNumDocubina(rsConsulta.getString("COD_NUMRESO"));
                objDocubina.setDesLocauri(rsConsulta.getString("DES_LOCAURI"));
                
                Sic1docu objDocu = new Sic1docu();
                objDocu.setIdDocu(rsConsulta.getBigDecimal("ID_DOCURESO"));
                objDocu.setSic1docubina(objDocubina);
                
                
                Sic1even objEven = new Sic1even();
                objEven.setIdEven(rsConsulta.getBigDecimal("ID_EVEN"));
                objEven.setCodExpe(rsConsulta.getString("COD_EXPE"));
                
                Sic1codiauto objCodiauto = new Sic1codiauto();
                objCodiauto.setSic1even(objEven);
                objCodiauto.setSic1docu(objDocu);
                
                //COMPROBANTE DE PAGO
                ComprobantePago objCompPago = new ComprobantePago();
                objCompPago.setDesLocauri(rsConsulta.getString("DES_LOCAURI_COMPAGO"));
                objCompPago.setDesNombreal(rsConsulta.getString("DES_TITULO_COMPAGO"));
                objCompPago.setNumComprobante(rsConsulta.getString("NUM_COMPROBANTE"));
                
                //Bien Relacionado
                Sic1proditem objSic1proditem = new Sic1proditem();                
                objSic1proditem.setNumSerie(rsConsulta.getString("NUM_SERIE"));
                objSic1proditem.setCodCodiauto("SIN CODIGO");
                objSic1proditem.setIdTipomaq(rsConsulta.getInt("ID_TIPOMAQU"));
                objSic1proditem.setDesTipomaq(rsConsulta.getString("DES_TIPOMAQU"));
                objSic1proditem.setIdPersadmin(idPersregi);
                objSic1proditem.setDesPersadmin(rsConsulta.getString("DES_PERSADMINREGISTRO"));
                objSic1proditem.setFecFabr(rsConsulta.getString("FEC_FABRICACION"));
                objSic1proditem.setNumMtprin(rsConsulta.getString("NUM_MTPRIN"));
                objSic1proditem.setNumComp(rsConsulta.getString("NUM_COMP"));
                objSic1proditem.setCodRegimode(rsConsulta.getString("COD_REGIMODE"));
                objSic1proditem.setCodIdenmode(rsConsulta.getString("COD_IDENMODE"));
                objSic1proditem.setIdPersfabr(rsConsulta.getInt("ID_PERSFAB"));
                objSic1proditem.setDesPersfab(rsConsulta.getString("DES_PERSFAB"));
                objSic1proditem.setCompPago(objCompPago);
                objSic1proditem.setSic1codiauto(objCodiauto);
                
                //Administrado Relacionado
                Sic1pers objPropietarioActual = new Sic1pers();
                objPropietarioActual.setIdPers(rsConsulta.getBigDecimal("ID_PERSADMINREGISTRO"));
                objPropietarioActual.setDesPers(rsConsulta.getString("DES_PERSADMINREGISTRO"));

                //
                Sic3proditempersPK objSic3proditempersPK = new Sic3proditempersPK();
                objSic3proditempersPK.setIdPers(objPropietarioActual.getIdPers());

                //Uniendo objetos
                Sic3proditempers objSic3proditempers = new Sic3proditempers();
                objSic3proditempers.setSic1proditem(objSic1proditem);
                objSic3proditempers.setSic1pers(objPropietarioActual);
                objSic3proditempers.setSic3proditempersPK(objSic3proditempersPK);                

                lstMaquinas.add(objSic3proditempers);
            }
        
        } catch (SQLException e){
            throw new SQLException(e.getMessage());
        } catch (Exception e){            
            throw new Exception(e.getMessage());
        } finally{            
            UtilSic.cerrarConexiones(callStatement, rsConsulta, cnConexion);
        }
        
        return lstMaquinas;
    }
}
