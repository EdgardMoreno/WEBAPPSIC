/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.dao;

import com.general.util.ConexionBD;
import com.general.util.beans.RptPlantilla;
import com.general.util.beans.UtilClass;
import com.general.util.beans.UtilSic;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author emoreno
 */
public class DaoReporteImpl {
    
    public HashMap<Integer, RptPlantilla>  generarRptProcedimientoAtendidos() throws SQLException, Exception{
        
        HashMap<Integer, RptPlantilla> hmap = new HashMap<>();
        CallableStatement statement = null;
        ResultSet rsConsulta = null;        
        Connection cnConexion = null;        
        
        
        
        try {
            
            cnConexion = ConexionBD.obtConexion();
        
         
         
            String sql = " SELECT  CLAS.DES_SCLASEEVEN AS DES_PROCEDIMIENTO " +
                         "       ,COUNT(1) AS NUM_CANTIDAD " +
                         " FROM SICDBA.SIC1EVEN T1\n" +
                         " JOIN SICDBA.SIC1SCLASEEVEN CLAS ON CLAS.ID_SCLASEEVEN = T1.ID_SCLASEEVEN\n" +
                         " JOIN SICDBA.SIC1DOCU T2 ON T1.ID_DOCURESO = T2.ID_DOCU\n" +
                         " JOIN SICDBA.SIC3DOCUESTA T3 ON T3.ID_DOCU = T2.ID_DOCU\n" +
                         " JOIN SICDBA.VI_SICESTA V1 ON V1.ID_ESTA = T3.ID_ESTADOCU\n" +
                         " JOIN SICDBA.SIC1DOCUBINA V2 ON V2.ID_DOCU = T2.ID_DOCU \n" +
                         "                                AND V2.NUM_DOCUBINA IS NOT NULL\n" +
                         " WHERE " +
                         "      T3.FEC_HASTA = TO_DATE('31/12/2400','DD/MM/YYYY')\n" +
                         "      AND V1.COD_ESTA = 'VI_SICESTANOTI'\n" +
                         "GROUP BY CLAS.DES_SCLASEEVEN ";
        
             statement = cnConexion.prepareCall(sql,
                                                   ResultSet.TYPE_SCROLL_SENSITIVE,
                                                   ResultSet.CONCUR_READ_ONLY,
                                                   ResultSet.CLOSE_CURSORS_AT_COMMIT);

            rsConsulta = statement.executeQuery();            
            int i=0;
            while(rsConsulta.next()){
                 
                RptPlantilla objRpt = new RptPlantilla();
                objRpt.setNumCantidad(rsConsulta.getDouble("NUM_CANTIDAD"));
                objRpt.setDesItem(rsConsulta.getString("DES_PROCEDIMIENTO"));
                 
                hmap.put(i, objRpt);
                i++;
            }
            
        } catch (SQLException e){
            throw new SQLException("generarRptProcedimientoAtendidos()-ERROR:" + e.getMessage());
        } catch (Exception e){
            throw new Exception("generarRptProcedimientoAtendidos()-ERROR:" + e.getMessage());
        }finally{
            if(cnConexion != null)
                cnConexion.close();
            if(rsConsulta != null)
                rsConsulta.close();
        }
         
        return hmap;
        
    }
    
    /**
     * METODO QUE LISTA LA CANTIDAD DE EXPEDIENTES EN TRAMITES Y RESUELTOS POR FUNCIONARIO
     * @param fecDesde
     * @param fecHasta
     * @return
     * @throws SQLException
     * @throws Exception 
     */
    public List<RptPlantilla> listarExpedientesXResponsable(String strFecDesde, String strFecHasta) throws SQLException, Exception{
        
        List<RptPlantilla> lstResult = new ArrayList<>();
        CallableStatement callStatement = null;
        ResultSet rsConsulta = null;        
        Connection cnConexion = null;
        Integer numFecDesde = 0;
        Integer numFecHasta = 0;
                
        try {
            
             if(strFecDesde == null || strFecDesde.trim().length() == 0)
                numFecDesde = UtilClass.getObtFecIni_YYYYMMDD();
            else 
                numFecDesde = UtilClass.convertDateToNumber(UtilClass.convertStringToDate(strFecDesde)).intValue();
            
            if(strFecHasta == null || strFecHasta.trim().length() == 0)
                numFecHasta = UtilClass.getObtFecInf_YYYYMMDD();
            else 
                numFecHasta = UtilClass.convertDateToNumber(UtilClass.convertStringToDate(strFecHasta)).intValue();
            
            cnConexion = ConexionBD.obtConexion();
            
            String sql = " SELECT    DECODE(COD_NUMTUPA,NULL,'NO TUPA','TUPA') AS DES_TUPA\n" +
                            "       ,PERS.ID_PERS " +
                            "       ,PERS.DES_PERS\n" +
                            "       ,CLAS.ID_SCLASEEVEN " +
                            "       ,UPPER(CLAS.DES_SCLASEEVEN) AS DES_PROCEDIMIENTO\n" +
                            "       ,COUNT(1) AS NUM_CANTIDAD\n" +
                            "       ,SUM(CASE WHEN V1.COD_ESTA <> 'VI_SICESTARESU' THEN 1 ELSE 0 END ) NUM_CANTTRAMITE\n" +
                            "       ,SUM(CASE WHEN V1.COD_ESTA = 'VI_SICESTARESU' THEN 1 ELSE 0 END ) NUM_CANTRESUELTO\n" +
                            " FROM SICDBA.SIC1EVEN T1\n" +
                            " JOIN SICDBA.SIC3EVENPERS T4 ON T4.ID_EVEN = T1.ID_EVEN\n" +
                            "                               AND T4.FEC_HASTA = TO_DATE('31/12/2400','DD/MM/YYYY')\n" +
                            "                               AND T4.ID_TROLPERS = 4382\n" +
                            " JOIN SICDBA.SIC1PERS PERS ON PERS.ID_PERS = T4.ID_PERS\n" +
                            " JOIN SICDBA.SIC1SCLASEEVEN CLAS ON CLAS.ID_SCLASEEVEN = T1.ID_SCLASEEVEN\n" +
                            " JOIN SICDBA.SIC3EVENESTA T2 ON T1.ID_EVEN = T2.ID_EVEN\n" +
                            " JOIN SICDBA.VI_SICESTA V1 ON V1.ID_ESTA = T2.ID_ESTAEVEN\n" +
                            " WHERE T2.FEC_HASTA = TO_DATE('31/12/2400','DD/MM/YYYY')\n" +
                            "      AND V1.COD_ESTA IN ('VI_SICESTATRAM','VI_SICESTARESU')\n" +
                            "      AND T1.ID_EVEN NOT IN (SELECT ID_EVEN FROM SICDBA.SIC1IDENEVEN WHERE ID_PERS = 2397) " + /*Se excluye DGJCMT*/
                            "      AND TO_NUMBER(TO_CHAR(T2.FEC_DESDE,'YYYYMMDD')) BETWEEN " + numFecDesde + " AND " + numFecHasta +                             
                            " GROUP BY  DECODE(COD_NUMTUPA,NULL,'NO TUPA','TUPA') " +
                            "         ,CLAS.DES_SCLASEEVEN " +
                            "         ,PERS.DES_PERS " +
                            "         ,PERS.ID_PERS " +
                            "         ,CLAS.ID_SCLASEEVEN " +
                            " ORDER BY DES_TUPA DESC, PERS.DES_PERS ASC ";
        
             callStatement = cnConexion.prepareCall( sql,
                                                 ResultSet.TYPE_SCROLL_SENSITIVE,
                                                 ResultSet.CONCUR_READ_ONLY,
                                                 ResultSet.CLOSE_CURSORS_AT_COMMIT);

            rsConsulta = callStatement.executeQuery();            
            while(rsConsulta.next()){
                 
                RptPlantilla objRpt = new RptPlantilla();
                objRpt.setDesTupa(rsConsulta.getString("DES_TUPA"));
                objRpt.setIdFuncionario(rsConsulta.getInt("ID_PERS"));
                objRpt.setDesFuncionario(rsConsulta.getString("DES_PERS"));
                objRpt.setIdProcedimiento(rsConsulta.getInt("ID_SCLASEEVEN"));
                objRpt.setDesProcedimiento(rsConsulta.getString("DES_PROCEDIMIENTO"));
                objRpt.setNumCantidad(rsConsulta.getDouble("NUM_CANTIDAD"));
                objRpt.setNumCanttramite(rsConsulta.getDouble("NUM_CANTTRAMITE"));
                objRpt.setNumCantresuelto(rsConsulta.getDouble("NUM_CANTRESUELTO"));
                lstResult.add(objRpt);
            }

        } catch (SQLException e){
            throw new SQLException(e.getMessage());
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }finally{
            
            UtilSic.cerrarConexiones(callStatement, rsConsulta, cnConexion);
        }
         
        return lstResult;
        
    }
}
