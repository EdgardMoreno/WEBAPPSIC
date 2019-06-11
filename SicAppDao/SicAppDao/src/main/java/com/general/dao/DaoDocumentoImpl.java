/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.dao;

import com.general.entity.Sic1docu;
import com.general.entity.Sic1docubina;
import com.general.entity.Sic1docubinaPK;
import com.general.entity.Sic1even;
import com.general.entity.Sic1stipodocu;
import com.general.entity.Sic3docuesta;
import com.general.entity.Sic3docuestaPK;
import com.general.entity.Sic3evendocu;
import com.general.util.ConexionBD;
import com.general.util.beans.ConstantesSic;
import com.general.util.beans.UtilClass;
import com.general.util.dao.DaoFuncionesUtil;
import conexionbd.InParameter;
import conexionbd.OutParameter;
import conexionbd.StoredProcedure;
import java.io.Serializable;
import java.math.BigInteger;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author emoreno
 */
public class DaoDocumentoImpl implements Serializable{
    
    final static Logger log = Logger.getLogger(DaoDocumentoImpl.class);
       
    
    /*
     * @param cnConexion
     * @param idDocu     
     * @return
     * @throws SQLException
     * @throws Exception 
     */
    public Sic1docu obtDocuXidDocu(Connection cnConexion, Integer idDocu) throws SQLException, Exception{
        
        CallableStatement statement = null;
        ResultSet rsConsulta = null;
        Sic1docu objDocu = null;
        
        System.out.println("idEven: " + idDocu);
        try {
            
            String sql = "SELECT  " +
                            "        V1.ID_DOCU         " +
                            "       ,V1.ID_ESTADOCU     " +
                            "       ,V1.DES_ESTADOCU    " +
                            "       ,V1.COD_ESTA AS COD_ESTADOCU " +
                            "       ,V1.FEC_DESDEESTA   " +
                            "       ,V1.FEC_HASTAESTA   " +
                            "       ,V1.DES_TITULO      " +
                            "       ,V1.FEC_DESDE       " +                            
                            "       ,V2.ID_TRELADOCU    " +
                            "       ,V2.COD_DOCUBINA    " +
                            "       ,V2.DES_LOCAURI     " +
                            "       ,V2.DES_NOMBREAL    " +
                            "       ,UPPER(V2.DES_EXTEDOCU) AS DES_EXTEDOCU " +
                            "       ,UPPER(V2.COD_EXTEDOCU) AS COD_EXTEDOCU " +
                            "       ,V1.ID_STIPODOCU " +
                            "       ,UPPER(V1.COD_STIPODOCU) AS COD_STIPODOCU " +
                            " FROM SICDBA.VI_SICDOCU V1        " +
                            " LEFT JOIN SICDBA.VI_SICDOCUBINA V2 ON V1.ID_DOCU = V2.ID_DOCU " +
                            "                               AND V2.FEC_HASTA = TO_DATE('24001231','YYYYMMDD') " +
                            " WHERE V1.ID_DOCU = " + idDocu;
            
            
            statement = cnConexion.prepareCall(sql,
                                                    ResultSet.TYPE_SCROLL_SENSITIVE,
                                                    ResultSet.CONCUR_READ_ONLY,
                                                    ResultSet.CLOSE_CURSORS_AT_COMMIT);            
            
            rsConsulta = statement.executeQuery();            
                        
            while(rsConsulta.next()){
                
                 /*ESTADOS DEL DOCUMENTO*/
                Sic3docuestaPK objEstaPK = new Sic3docuestaPK();
                objEstaPK.setIdEstadocu(rsConsulta.getInt("ID_ESTADOCU"));
                objEstaPK.setFecDesde(rsConsulta.getTimestamp("FEC_DESDEESTA"));
                
                Sic3docuesta objEsta = new Sic3docuesta();
                objEsta.setCodEstadocu(rsConsulta.getString("COD_ESTADOCU"));
                objEsta.setDesEstadocu(rsConsulta.getString("DES_ESTADOCU"));
                objEsta.setFecHasta(rsConsulta.getDate("FEC_HASTAESTA"));
                objEsta.setSic3docuestaPK(objEstaPK);
                
                /*SIC1STIPODOCU*/
                Sic1stipodocu objStipodocu = new Sic1stipodocu();
                objStipodocu.setIdStipodocu(rsConsulta.getInt("ID_STIPODOCU"));
                objStipodocu.setCodStipodocu(rsConsulta.getString("COD_STIPODOCU"));
                        
                
                objDocu = new Sic1docu();
                
                Sic1docubinaPK objDocubinaPK = new Sic1docubinaPK();
                objDocubinaPK.setCodDocubina(rsConsulta.getString("COD_DOCUBINA"));
                objDocubinaPK.setIdDocu(BigInteger.valueOf(rsConsulta.getInt("ID_DOCU")));
                
                objDocubinaPK.setIdTreladocu(BigInteger.valueOf(16));
                objDocubinaPK.setIdTreladocu(BigInteger.valueOf(rsConsulta.getInt("ID_TRELADOCU")));

                Sic1docubina objDocubina = new Sic1docubina();
                objDocubina.setDesLocauri(rsConsulta.getString("DES_LOCAURI"));
                //objDocubina.setNumDocubina(rsConsulta.getString("NUM_DOCUBINA"));
                objDocubina.setDesNombreal(rsConsulta.getString("DES_NOMBREAL"));
                objDocubina.setDesExtedocu(rsConsulta.getString("DES_EXTEDOCU"));
                objDocubina.setCodExtedocu(rsConsulta.getString("COD_EXTEDOCU"));
                objDocubina.setSic1docubinaPK(objDocubinaPK);
                        
                objDocu.setIdDocu(rsConsulta.getBigDecimal("ID_DOCU"));
                objDocu.setDesTitulo(rsConsulta.getString("DES_TITULO"));
                objDocu.setFecDesde(rsConsulta.getDate("FEC_DESDE"));
                objDocu.setSic3docuesta(objEsta);
                objDocu.setSic1docubina(objDocubina);
                objDocu.setSic1stipodocu(objStipodocu);
                
            }
        
        } catch (SQLException e){            
            throw new SQLException("obtDocumentoXIdDocu()-FE:" + e.getMessage());
        } catch (Exception e){          
            throw new Exception("obtDocumentoXIdDocu()-FE:" + e.getMessage());
        } finally{
            if(statement != null){
                statement.close();
                rsConsulta.close();
            }
        }
        
        return objDocu;
    }
    
    public void insertarDocuBina( Connection cnConexion
                                         ,Sic1docubina objDocubina ) throws SQLException, Exception {

       StoredProcedure sp = null;
       int intFilaError = 0;

       try {

           System.out.println("======================== insertarDocuBina ========================");           
           System.out.println("id_docu:" + objDocubina.getSic1docubinaPK().getIdDocu());
           System.out.println("id_Treladocu:" + objDocubina.getSic1docubinaPK().getIdTreladocu());
           System.out.println("COD_DOCUBINA:" + objDocubina.getSic1docubinaPK().getCodDocubina());
           System.out.println("titulo:" + objDocubina.getDesTitulo());
           System.out.println("tamanio:" + objDocubina.getNumBytes());
           System.out.println("numeroFolios:" + objDocubina.getNumFolios());
           System.out.println("uri:" + objDocubina.getDesLocauri());           
           System.out.println("nombreRealDocu:" + objDocubina.getDesNombreal());
           System.out.println("id_Extension:" + objDocubina.getIdExtedocu());
           System.out.println("id_lenguaje:" + objDocubina.getIdLengdocu());

           sp = new StoredProcedure("SICDBA.PKG_SICMANTDOCU.PRC_SICCREADOCUBINA");

           intFilaError = 10;
           
           Integer intNumBytes = null;
           Integer intNumFolios = null;
           Integer intIdExteDocu = null;
           Integer intIdLengDocu = null;
           
           if(objDocubina.getNumBytes()!= null)
               intNumBytes = objDocubina.getNumBytes().intValue();
           
           if(objDocubina.getNumFolios()!= null)
               intNumFolios = objDocubina.getNumFolios().intValue();
           
           if(objDocubina.getIdExtedocu()!= null)
               intIdExteDocu = objDocubina.getIdExtedocu().intValue();
           
           if(objDocubina.getIdLengdocu()!= null)
               intIdLengDocu = objDocubina.getIdLengdocu().intValue();

           sp.addParameter(new InParameter("X_ID_DOCU"      ,Types.NUMERIC, objDocubina.getSic1docubinaPK().getIdDocu().intValue()));
           sp.addParameter(new InParameter("X_ID_TRELADOCU" ,Types.NUMERIC, objDocubina.getSic1docubinaPK().getIdTreladocu().intValue()));
           sp.addParameter(new InParameter("X_COD_DOCUBINA" ,Types.VARCHAR, objDocubina.getSic1docubinaPK().getCodDocubina()));
           sp.addParameter(new InParameter("X_DES_TITULO"   ,Types.VARCHAR, objDocubina.getDesTitulo()));
           sp.addParameter(new InParameter("X_FEC_CREACION" ,Types.VARCHAR, null));
           sp.addParameter(new InParameter("X_NUM_BYTES"    ,Types.NUMERIC, intNumBytes));
           sp.addParameter(new InParameter("X_NUM_FOLIOS"   ,Types.NUMERIC, intNumFolios));
           sp.addParameter(new InParameter("X_DES_LOCAURI"  ,Types.VARCHAR, objDocubina.getDesLocauri()));
           sp.addParameter(new InParameter("X_DES_LOCACACHE",Types.VARCHAR, null));
           sp.addParameter(new InParameter("X_FEC_DESDE"    ,Types.VARCHAR, null));
           sp.addParameter(new InParameter("X_FEC_HASTA"    ,Types.VARCHAR, null));
           sp.addParameter(new InParameter("X_DES_NOMBREAL" ,Types.VARCHAR, objDocubina.getDesNombreal()));
           sp.addParameter(new InParameter("X_ID_EXTEDOCU"  ,Types.NUMERIC, intIdExteDocu));
           sp.addParameter(new InParameter("X_ID_LENGDOCU"  ,Types.NUMERIC, intIdLengDocu));

           sp.addParameter(new OutParameter("X_ID_ERROR"    ,Types.NUMERIC));
           sp.addParameter(new OutParameter("X_DES_ERROR"   ,Types.VARCHAR));
           sp.addParameter(new OutParameter("X_FEC_ERROR"   ,Types.DATE));

           intFilaError = 500;
           sp.ExecuteNonQuery(cnConexion);

           intFilaError = 560;           

           if (Integer.valueOf(sp.getParameter("X_ID_ERROR").toString()) != 0 ){
                throw new SQLException((String)sp.getParameter("X_DES_ERROR"));
            }
           intFilaError = 600;

       } catch (SQLException e){           
           throw new SQLException(e.getMessage());
       } catch (Exception e){
           throw new Exception(e.getMessage());
       }
   }    
    
    public String relaDocuEsta(  Connection cnConexion
                                ,Sic3docuesta sic3docuesta) throws Exception {

        try {
            
            String strFecHasta = null;
            String strFecDesde = null;
                                
            /*CONVERSION DE FECHAS*/            
            if (sic3docuesta.getSic3docuestaPK().getFecDesde() != null){
                strFecDesde = UtilClass.convertDateToString(sic3docuesta.getSic3docuestaPK().getFecDesde());
            }
            if (sic3docuesta.getFecHasta()!= null){
                strFecHasta = UtilClass.convertDateToString(sic3docuesta.getFecHasta());
            }
            /**/
            
            Integer intIdTRolEsta = sic3docuesta.getSic3docuestaPK().getIdTrolestadocu();
            if(sic3docuesta.getCodTrolestadocu() != null ){
                intIdTRolEsta  = DaoFuncionesUtil.FNC_SICOBTIDGEN(cnConexion
                                                                    ,ConstantesSic.CONS_COD_TIPOROLESTA
                                                                    ,sic3docuesta.getCodTrolestadocu());
            }
            
            Integer intIdEsta = sic3docuesta.getSic3docuestaPK().getIdEstadocu();
            if(sic3docuesta.getCodEstadocu() != null){
                intIdEsta = DaoFuncionesUtil.FNC_SICOBTIDGEN( cnConexion
                                                             ,ConstantesSic.CONS_COD_ESTA
                                                             ,sic3docuesta.getCodEstadocu());
            }

            Integer idTreladocuesta = DaoFuncionesUtil.FNC_SICOBTIDGEN(cnConexion, "VI_SICTRELA", "RELESTADODOCUMENTO");

            System.out.println("idTreladocuesta:" + idTreladocuesta);
            System.out.println("intIdTRolEsta:" + intIdTRolEsta);
            System.out.println("intIdEsta:" + intIdEsta);
            
            StoredProcedure sp = new StoredProcedure("SICDBA.PKG_SICMANTDOCU.PRC_SICRELADOCUESTA");

            sp.addParameter(new InParameter("X_ID_DOCU",            Types.INTEGER, sic3docuesta.getSic3docuestaPK().getIdDocu().intValue()));
            sp.addParameter(new InParameter("X_ID_ESTAREL",         Types.INTEGER, intIdEsta));
            sp.addParameter(new InParameter("X_ID_TROLESTADOCU",    Types.INTEGER, intIdTRolEsta));
            sp.addParameter(new InParameter("X_ID_TRELADOCU",       Types.INTEGER, idTreladocuesta));
            sp.addParameter(new InParameter("X_DES_NOTAS",          Types.VARCHAR, sic3docuesta.getDesNotas()));
            sp.addParameter(new InParameter("X_FEC_DESDE",          Types.VARCHAR, strFecDesde));
            sp.addParameter(new InParameter("X_FEC_HASTA",          Types.VARCHAR, strFecHasta));

            sp.addParameter(new OutParameter("X_ID_ERROR",          Types.INTEGER));
            sp.addParameter(new OutParameter("X_DES_ERROR",         Types.VARCHAR));
            sp.addParameter(new OutParameter("X_FEC_ERROR",         Types.DATE));

            sp.ExecuteNonQuery(cnConexion);

            if (Integer.valueOf(sp.getParameter("X_ID_ERROR").toString()) != 0) {
                throw new SQLException((String) sp.getParameter("X_DES_ERROR"));
            }
            
        } catch (SQLException ex) {
            throw new SQLException(ex.getMessage());
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        
        return null;
    }
    
    public String cambiarEstaDocu( Connection cnConexion
                                            ,String pintIdEvento
                                            ,int pintIdDocu
                                            ,String pstrCodRol
                                            ,String pstrCodDecision
                                            ,String pstrCodSTipoDocu
                                            ,String pstrCodEstaDocu ) throws SQLException, Exception{
        
        StoredProcedure sp = null;        
        
        String strDesEstaDocu = "";
        
        log.info("==================== obtenerAsignarEstadoDocumento ====================");
        log.info("pintIdEvento:" + pintIdEvento);
        log.info("intIdDocu:" + pintIdDocu);
        log.info("pstrCodRol:" + pstrCodRol);
        log.info("pstrCodDecision:" + pstrCodDecision);
        log.info("pstrCodSTipoDocu:" + pstrCodSTipoDocu);
        log.info("pstrCodEstaDocu:" + pstrCodEstaDocu);
        log.debug("<I>");
        
        try {
            
            sp = new StoredProcedure("PRC_SICMANTDOCUESTA");                        
            
            sp.addParameter(new InParameter("X_ID_DOCU", Types.INTEGER, pintIdDocu));
            sp.addParameter(new InParameter("X_COD_ROL", Types.VARCHAR, pstrCodRol));
            sp.addParameter(new InParameter("X_COD_DECISION", Types.VARCHAR, pstrCodDecision));
            sp.addParameter(new InParameter("X_COD_STIPODOCU", Types.VARCHAR, pstrCodSTipoDocu));
            sp.addParameter(new InParameter("X_COD_ESTADOCU", Types.VARCHAR, pstrCodEstaDocu));
            sp.addParameter(new InParameter("X_DES_NOTASESTA", Types.VARCHAR, "SOPORTE"));
            sp.addParameter(new InParameter("X_FEC_DESDE", Types.VARCHAR, null));
            sp.addParameter(new InParameter("X_FEC_HASTA", Types.VARCHAR, null));
            
            sp.addParameter(new OutParameter("X_DES_ESTADOCU", Types.VARCHAR));            
            sp.addParameter(new OutParameter("X_ID_ERROR", Types.INTEGER));
            sp.addParameter(new OutParameter("X_DES_ERROR", Types.VARCHAR));
            sp.addParameter(new OutParameter("X_FEC_ERROR", Types.DATE));
            
            sp.ExecuteNonQuery(cnConexion);            
            
            strDesEstaDocu = (String)sp.getParameter("X_DES_ESTADOCU");            
            
            if (Integer.valueOf(sp.getParameter("X_ID_ERROR").toString()) != 0) {
                throw new SQLException((String) sp.getParameter("X_DES_ERROR"));
            }
            
            System.out.println("strDesEstaDocu:" + strDesEstaDocu);
            
        } catch (SQLException ex) {
            throw new SQLException(ex.getMessage());
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        
        return strDesEstaDocu;
    }
    
    /**
     * METODO PARA OBTENER LOS DOCUMENTOS RELACIONADOS AL EVENTO.
     * @param cnConexion Indica la conexion
     * @param idEven Indica el numero de evento
     * @param idTipodocu Indica el tipo de documento
     * @return
     */
    public List<Sic3evendocu> obtDocumentosXEvento(  Integer idEven
                                                    ,Integer idTipodocu) throws Exception{
    

        Connection cnConexion           = null;
        CallableStatement statement     = null;
        ResultSet rsConsulta            = null;
        List<Sic3evendocu> lstEvenDocu  = new ArrayList<>();
        
        System.out.println("idEven: " + idEven);
        try {                        
            
            cnConexion = ConexionBD.obtConexion();
            
            String sql = "SELECT DISTINCT\n" +
                            "         T2.ID_DOCU\n" +
                            "        ,EVEN.COD_EXPE\n" +
                            "        ,EVEN.ID_EVEN\n" +
                            "        ,IDENEVEN.ID_PERS AS ID_PERSADMI\n" +
                            "        ,T5.DES_LOCAURI\n" +
                            "        ,(SELECT NUM_DOCUBINA FROM SICDBA.SIC1DOCUBINA TMP1 WHERE TMP1.ID_DOCU = T1.ID_DOCU AND NUM_DOCUBINA IS NOT NULL )AS NUM_DOCUBINA \n" +
                            "        ,UPPER(T5.DES_NOMBREAL) AS DES_NOMBREAL\n" +
                            "        ,T4.ID_ESTA \n" +
                            "        ,T4.COD_ESTA\n" +
                            "        ,T4.DES_ESTA\n" +
                            "        ,T3.FEC_DESDE AS FEC_DESDE_ESTA\n" +
                            "        ,T3.FEC_HASTA AS FEC_HASTA_ESTA\n" +
                            "        ,T3.ID_TROLESTADOCU\n" +
                            "        ,T9.NUM_ORDEN\n" +
                            "        ,T2.DES_DOCU\n" +
                            "        ,T2.DES_TITULO\n" +
                            "        ,T2.ID_STIPODOCU\n" +
                            "        ,T8.DES_STIPODOCU\n" +
                            "        ,T8.COD_STIPODOCU\n" +
                            "        ,T8.ID_TIPODOCU\n" +                    
                            "        ,V1.DES_TIPODOCU\n" +
                            "        ,T2.FEC_DESDE AS FEC_DESDE_DOCU\n" +
                            "        ,T2.FEC_CREACION AS FEC_CREACION_DOCU\n" +
                            " FROM SICDBA.SIC1EVEN EVEN\n" +
                            " JOIN SICDBA.SIC1IDENEVEN IDENEVEN ON IDENEVEN.ID_EVEN = EVEN.ID_EVEN " +
                            " JOIN SICDBA.SIC3EVENDOCU T1 ON EVEN.ID_EVEN = T1.ID_EVEN\n" +
                            " JOIN SICDBA.SIC1DOCU T2 ON T1.ID_DOCU = T2.ID_DOCU\n" +
                            " JOIN SICDBA.SIC1STIPODOCU T8 ON T8.ID_STIPODOCU = T2.ID_STIPODOCU\n" +
                            " JOIN SICDBA.VI_SICTIPODOCU V1 ON V1.ID_TIPODOCU = T8.ID_TIPODOCU\n" +
                            " LEFT JOIN SICDBA.SIC3DOCUESTA T3 ON T3.ID_DOCU = T2.ID_DOCU \n" +
                            "                               AND T3.ID_TROLESTADOCU NOT IN (46101,46102)/*NO SE CONSIDERA ESTADOS POR EVALUACION TECNICA NI FINANCIERA*/\n" +
                            " LEFT JOIN SICDBA.VI_SICESTA T4 ON T4.ID_ESTA = T3.ID_ESTADOCU\n" +
                            " LEFT JOIN SICDBA.SIC1DOCUBINA T5 ON T5.ID_DOCU = T1.ID_DOCU\n" +
                            "                                     AND T5.FEC_HASTA = TO_DATE('24001231','YYYYMMDD')\n" +
                            " LEFT JOIN SICDBA.SIC3SCLASEEVENSTIPODOCU T9 ON T9.ID_SCLASEEVEN = EVEN.ID_SCLASEEVEN\n" +
                            "                                  AND T9.ID_STIPODOCU = T2.ID_STIPODOCU\n" +
                            "                                  AND T9.FEC_HASTA = TO_DATE('24001231','YYYYMMDD')\n" +
                            " WHERE EVEN.ID_EVEN = " + idEven +
                            " AND T3.FEC_HASTA = TO_DATE('24001231','YYYYMMDD') ";
            
            if(idTipodocu!= null && idTipodocu > 0)
                sql += " AND T8.ID_TIPODOCU = " + idTipodocu;
            
            sql += " ORDER BY DES_TIPODOCU, NVL(NUM_ORDEN,999), ID_DOCU DESC, FEC_DESDE_ESTA DESC";

            statement = cnConexion.prepareCall(sql,
                                                    ResultSet.TYPE_SCROLL_SENSITIVE,
                                                    ResultSet.CONCUR_READ_ONLY,
                                                    ResultSet.CLOSE_CURSORS_AT_COMMIT);
            
            rsConsulta = statement.executeQuery();
            Sic3evendocu objEvendocu = null;
                        
            while(rsConsulta.next()){
                
                /*ESTADOS DEL DOCUMENTO*/
                Sic3docuestaPK objEstaPK = new Sic3docuestaPK();
                objEstaPK.setIdDocu(rsConsulta.getBigDecimal("ID_ESTA"));
                objEstaPK.setFecDesde(rsConsulta.getTimestamp("FEC_DESDE_ESTA"));
                
                Sic3docuesta objEsta = new Sic3docuesta();
                objEsta.setCodEstadocu(rsConsulta.getString("COD_ESTA"));
                objEsta.setDesEstadocu(rsConsulta.getString("DES_ESTA"));
                objEsta.setFecHasta(rsConsulta.getDate("FEC_HASTA_ESTA"));
                objEsta.setSic3docuestaPK(objEstaPK);
                
                /*DOCUMENTO BINARIO*/
                Sic1docubina objDocubina = new Sic1docubina();                
                objDocubina.setDesLocauri(rsConsulta.getString("DES_LOCAURI"));
                objDocubina.setNumDocubina(rsConsulta.getString("NUM_DOCUBINA"));
                objDocubina.setDesNombreal(rsConsulta.getString("DES_NOMBREAL"));
                
                /*SIC1STIPODOCU*/
                Sic1stipodocu objStipodocu = new Sic1stipodocu();
                objStipodocu.setIdStipodocu(rsConsulta.getInt("ID_STIPODOCU"));
                objStipodocu.setDesStipodocu(rsConsulta.getString("DES_STIPODOCU"));
                objStipodocu.setCodStipodocu(rsConsulta.getString("COD_STIPODOCU"));
                objStipodocu.setIdTipodocu(rsConsulta.getInt("ID_TIPODOCU"));
                objStipodocu.setDesTipodocu(rsConsulta.getString("DES_TIPODOCU"));
                
                /*DOCUMENTO*/
                Sic1docu objDocu = new Sic1docu();
                objDocu.setIdDocu(rsConsulta.getBigDecimal("ID_DOCU"));
                objDocu.setDesTitulo(rsConsulta.getString("DES_TITULO"));
                objDocu.setDesDocu(rsConsulta.getString("DES_TITULO"));
                objDocu.setIdStipodocu(rsConsulta.getInt("ID_STIPODOCU"));
                objDocu.setFecDesde(rsConsulta.getDate("FEC_DESDE_DOCU"));
                objDocu.setFecCreacion(rsConsulta.getDate("FEC_CREACION_DOCU"));
                objDocu.setNumOrden(rsConsulta.getInt("NUM_ORDEN"));
                objDocu.setSic3docuesta(objEsta);
                objDocu.setSic1docubina(objDocubina);
                objDocu.setSic1stipodocu(objStipodocu);
                
                /*EVENTO*/
                Sic1even objEven = new Sic1even();
                objEven.setIdEven(rsConsulta.getBigDecimal("ID_EVEN"));
                objEven.setCodExpe(rsConsulta.getString("COD_EXPE"));

                /*SIC3EVENDOCU*/
                objEvendocu = new Sic3evendocu();
                objEvendocu.setSic1docu(objDocu);
                objEvendocu.setSic1even(objEven);                
                                
                lstEvenDocu.add(objEvendocu);
            }
        
        } catch (SQLException e){            
            throw new SQLException("obtDocumentosXEvento()-ERROR:" + e.getMessage());
        } catch (Exception e){            
            throw new Exception("obtDocumentosXEvento()-ERROR:" + e.getMessage());
        }finally{
            
            if(statement != null){
                statement.close();
            }
            
            if(rsConsulta != null){
                rsConsulta.close();
            }
            
            if(cnConexion != null){
                cnConexion.close();
            }
        }
        
        return lstEvenDocu;
    }
    
    /**
     * METODO PARA OBTENER LOS DOCUMENTOS RELACIONADOS AL EVENTO.
     * @param cnConexion Indica la conexion
     * @param idEven Indica el identificador del evento
     * @param idDocu Indica el identificador del documento
     * @return
     */
    public String obtNumeracionSistemaNormativo( Connection cnConexion
                                                ,Integer idEven
                                                ,Integer idDocu ) throws SQLException, Exception{
        
        StoredProcedure sp = null;        
        
        String strNumero = "";
        
        log.info("==================== obtNumeracionSistemaNormativo ====================");
        log.info("pintIdEvento:" + idEven);
        log.info("intIdDocu:" + idDocu);        
        
        try {
            
            sp = new StoredProcedure("PRC_SICOBTNUMERACION");
            
            sp.addParameter(new InParameter("X_ID_EVEN", Types.INTEGER, idEven));
            sp.addParameter(new InParameter("X_ID_DOCU", Types.INTEGER, idDocu));
            sp.addParameter(new OutParameter("X_NUMERO", Types.VARCHAR));
            sp.addParameter(new OutParameter("X_ID_ERROR", Types.INTEGER));
            sp.addParameter(new OutParameter("X_DES_ERROR", Types.VARCHAR));
            sp.addParameter(new OutParameter("X_FEC_ERROR", Types.DATE));
            
            sp.ExecuteNonQuery(cnConexion);            
            
            strNumero = (String)sp.getParameter("X_NUMERO");            
            
            if (Integer.valueOf(sp.getParameter("X_ID_ERROR").toString()) != 0) {
                throw new SQLException((String) sp.getParameter("X_DES_ERROR"));
            }
            
            System.out.println("strNumero:" + strNumero);
            
        } catch (SQLException ex) {
            throw new SQLException(ex.getMessage());
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        
        return strNumero;
    }
    
    /**
     * METODO PARA GUARDAR EL NUMERO DE LA RESOLUCION U OFICIO QUE SE OBTUVO DEL SISTEMA NORMATIVO
     * @param cnConexion Indica la conexion
     * @param desLocaUri Indica el codigo del content manager
     * @param desTitulo Indica el nuevo titulo del documento
     * @param idDocu Indica el identificador del documento     
     */
    public void actualizarNumeroResolutivo(  Connection cnConexion
                                            ,String desLocaUri 
                                            ,String desTitulo 
                                            ,int idDocu ) throws SQLException, Exception{
        
        StoredProcedure sp = null;        
        
        log.info("==================== obtActualizarNumero ====================");
        log.info("strLocarUri:" + desLocaUri);
        log.info("strTitulo:" + desTitulo);        
        log.info("intIddocu:" + idDocu);        
        
        try {
            
            sp = new StoredProcedure("PRC_SICACTUDOCUBINABPM");
            
            sp.addParameter(new InParameter("X_ID_DOCU", Types.INTEGER, idDocu));
            sp.addParameter(new InParameter("X_DES_TITULO", Types.VARCHAR, desTitulo));
            sp.addParameter(new InParameter("X_DES_DOCU", Types.VARCHAR, desLocaUri));
            sp.addParameter(new InParameter("X_NUM_FOLIOS", Types.INTEGER, 0));
            
            sp.addParameter(new OutParameter("X_ID_ERROR", Types.INTEGER));
            sp.addParameter(new OutParameter("X_DES_ERROR", Types.VARCHAR));
            sp.addParameter(new OutParameter("X_FEC_ERROR", Types.DATE));
            
            sp.ExecuteNonQuery(cnConexion);                                    
            
            if (Integer.valueOf(sp.getParameter("X_ID_ERROR").toString()) != 0) {
                throw new SQLException((String) sp.getParameter("X_DES_ERROR"));
            }
            
        } catch (SQLException ex) {
            throw new SQLException(ex.getMessage());
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
}
