/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.dao;

import com.general.entity.Sic1docu;
import com.general.entity.Sic1docubina;
import com.general.entity.Sic1even;
import com.general.entity.Sic1general;
import com.general.entity.Sic1ideneven;
import com.general.entity.Sic1pers;
import com.general.entity.Sic1sclaseeven;
import com.general.entity.Sic3docuesta;
import com.general.entity.Sic3evendocu;
import com.general.entity.Sic3evenesta;
import com.general.entity.Sic3evenestaPK;
import com.general.entity.Sic5evenesta;
import com.general.entity.Sic5evenestaPK;
import com.general.util.ConexionBD;
import com.general.util.beans.ConstantesSic;
import com.general.util.beans.UtilClass;
import com.general.util.beans.UtilSic;
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
import oracle.jdbc.OracleTypes;
import org.apache.log4j.Logger;

/**
 *
 * @author emoreno
 */
public class DaoEventoImpl implements Serializable{
    
    final static Logger log = Logger.getLogger(DaoEventoImpl.class);    
    
    public int relacionarEvenDocu( Connection cnConexion
                                  ,Sic3evendocu relEvenDocu) throws SQLException, Exception {
        
        int intIdDocumento = 0;
        StoredProcedure sp = null;
        
        try {
            
            Sic1docu objDocu = relEvenDocu.getSic1docu();            
            Sic1docubina objDocubina = objDocu.getSic1docubinaList().get(0);
            String strCodIden = objDocu.getSic1idendocu().getSic1idendocuPK().getCodIden();
            
            System.out.println("============== insertarDocumentoEven =====================");
            System.out.println("cod_iden: " + strCodIden);
            System.out.println("titulo: " + objDocu.getDesTitulo());
            System.out.println("des_dOCU: " + objDocu.getDesDocu());
            System.out.println("id_RolCreador: " + objDocu.getIdTrolpers());
            System.out.println("id_subTipoDocu: " + objDocu.getIdStipodocu());
            System.out.println("id_Persona: " + objDocu.getIdPers());
            System.out.println("id_even: " + relEvenDocu.getSic1even().getIdEven());
            System.out.println("id_Trelaeven: " + relEvenDocu.getIdTrelaeven());
            System.out.println("_COD_DOCUBINA: " + objDocubina.getSic1docubinaPK().getCodDocubina());
            System.out.println("LOCAL_URI: " + objDocubina.getDesLocauri());
            System.out.println("nombreRealDocu: " + objDocubina.getDesNombreal());
            System.out.println("id_Extension: " + objDocubina.getIdExtedocu());
            System.out.println("id_lenguaje: " + objDocubina.getIdLengdocu());
            
            log.debug("<I>");
            
            sp = new StoredProcedure("SICDBA.PKG_SICMANTDOCU.PRC_SICCREADOCUEVEN");            
            
            sp.addParameter(new InParameter("X_ID_TIPOIDEN", Types.INTEGER, null));
            sp.addParameter(new InParameter("X_COD_IDEN", Types.VARCHAR, strCodIden));
            sp.addParameter(new InParameter("X_DES_TITULO", Types.VARCHAR, objDocu.getDesTitulo()));
            sp.addParameter(new InParameter("X_DES_NOTAS", Types.VARCHAR, null));
            sp.addParameter(new InParameter("X_FEC_CREACION", Types.VARCHAR, null));
            sp.addParameter(new InParameter("X_DES_DOCU", Types.VARCHAR, objDocu.getDesDocu()));
            sp.addParameter(new InParameter("X_ID_TROLPERS", Types.INTEGER, objDocu.getIdTrolpers()));
            sp.addParameter(new InParameter("X_ID_STIPODOCU", Types.INTEGER, objDocu.getIdStipodocu()));
            sp.addParameter(new InParameter("X_ID_PERS", Types.INTEGER, objDocu.getIdPers()));
            sp.addParameter(new InParameter("X_FEC_DESDE", Types.VARCHAR, null));
            sp.addParameter(new InParameter("X_FEC_HASTA", Types.VARCHAR, null));            
            sp.addParameter(new InParameter("X_ID_EVEN", Types.INTEGER, relEvenDocu.getSic1even().getIdEven()));            
            sp.addParameter(new InParameter("X_ID_TRELAEVEN", Types.INTEGER, relEvenDocu.getIdTrelaeven()));
            sp.addParameter(new InParameter("X_ID_TRELADOCU", Types.INTEGER, null));            
            sp.addParameter(new InParameter("X_COD_DOCUBINA", Types.VARCHAR, objDocubina.getSic1docubinaPK().getCodDocubina()));
            sp.addParameter(new InParameter("X_NUM_BYTES", Types.INTEGER, objDocubina.getNumBytes()));
            sp.addParameter(new InParameter("X_NUM_FOLIOS", Types.INTEGER, objDocubina.getNumFolios()));
            sp.addParameter(new InParameter("X_DES_LOCAURI", Types.VARCHAR, objDocubina.getDesLocauri()));
            sp.addParameter(new InParameter("X_DES_LOCACACHE", Types.VARCHAR, null));
            sp.addParameter(new InParameter("X_DES_NOMBREAL", Types.VARCHAR, objDocubina.getDesNombreal()));
            sp.addParameter(new InParameter("X_ID_EXTEDOCU", Types.INTEGER, objDocubina.getIdExtedocu()));
            sp.addParameter(new InParameter("X_ID_LENGDOCU", Types.INTEGER, objDocubina.getIdLengdocu()));
            sp.addParameter(new InParameter("X_ID_ESTAREL", Types.INTEGER, null));
            sp.addParameter(new InParameter("X_ID_TROLESTADOCU", Types.INTEGER, null));
            sp.addParameter(new InParameter("X_ID_TRELADOCUESTA", Types.INTEGER, null));
            sp.addParameter(new InParameter("X_DES_NOTASESTA", Types.VARCHAR, null));
            
            sp.addParameter(new OutParameter("X_ID_DOCU", Types.INTEGER));
            sp.addParameter(new OutParameter("X_ID_ERROR", Types.INTEGER));
            sp.addParameter(new OutParameter("X_DES_ERROR", Types.VARCHAR));
            sp.addParameter(new OutParameter("X_FEC_ERROR", Types.DATE));
            
            sp.ExecuteNonQuery(cnConexion);
            
            intIdDocumento   = Integer.valueOf(sp.getParameter("X_ID_DOCU").toString());
            
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
        
        return intIdDocumento;
    }
    
    
    public int creaEvenEsta( Connection cnConexion
                            ,Integer idEvento
                            ,Integer idSclaseeven
                            ,String codEstaeven
                            ,String codTipoinst
                            ,String codTdettarea
                            ,String desTarea
                            ,String desNotas
                            ,Integer idPers
                            ,Integer idTrolpers
                            ,Integer idTrelatarea ) throws SQLException, Exception {
        
        int intIdDocumento = 0;
        StoredProcedure sp = null;
        
        try {
            
            System.out.println("============== creaEvenEsta =====================");
            System.out.println("idEvento: "     + idEvento);
            System.out.println("idSclaseeven: " + idSclaseeven);
            System.out.println("codEstaeven: "  + codEstaeven);
            System.out.println("codTipoinst: "  + codTipoinst);
            System.out.println("codTdettarea: " + codTdettarea);
            System.out.println("desTarea: "     + desTarea);
            System.out.println("desNotas: "     + desNotas);
            System.out.println("idPers: "       + idPers);
            System.out.println("idTrolpers: "   + idTrolpers);
            System.out.println("idTrelatarea: " + idTrelatarea);            
            
            log.debug("<I>");
            
            sp = new StoredProcedure("SICDBA.PRC_SICCREAEVENESTA");
            
            sp.addParameter(new InParameter("X_ID_EVEN",        Types.INTEGER, idEvento));
            sp.addParameter(new InParameter("X_ID_SCLASEEVEN",  Types.VARCHAR, idSclaseeven));
            sp.addParameter(new InParameter("X_COD_ESTAEVEN",   Types.VARCHAR, codEstaeven));
            sp.addParameter(new InParameter("X_COD_TIPOINST",   Types.VARCHAR, codTipoinst));
            sp.addParameter(new InParameter("X_COD_TDETTAREA",  Types.VARCHAR, codTdettarea));
            sp.addParameter(new InParameter("X_DES_TAREA",      Types.VARCHAR, desTarea));
            sp.addParameter(new InParameter("X_DES_NOTAS",      Types.INTEGER, desNotas));
            sp.addParameter(new InParameter("X_ID_PERS",        Types.INTEGER, idPers));
            sp.addParameter(new InParameter("X_ID_TROLPERS",    Types.INTEGER, idTrolpers));
            sp.addParameter(new InParameter("X_ID_TRELATAREA",  Types.VARCHAR, idTrelatarea));
            
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
        
        return intIdDocumento;
    }
    
    
    public List<Sic1even> obtExpedientes ( Sic1even sic1even ) throws SQLException, Exception{
        
        CallableStatement callStatement = null;
        ResultSet rsConsulta = null;
        List<Sic1even> lista = new ArrayList<>();
        String strDesPersAdmi = "";
        Connection cnConexion = null;
                
        try {
            
                cnConexion = ConexionBD.obtConexion();
            
                /*Filtrar por la fecha del estado del evento: TRAMITE, RESUELTO, ETC*/
                //Sic3evenesta objEvenesta = sic1even.getSic3evenesta()!=null?sic1even.getSic3evenesta():null;
                Sic3evenesta objEvenEsta     = sic1even.getSic3evenesta();
                Sic3evenestaPK objEvenEstaPK = objEvenEsta!=null?objEvenEsta.getSic3evenestaPK():null;
                Integer numFecDesde          = 0;
                Integer numFecHasta          = 0;
                Integer idEvenEsta           = -1;

                if(objEvenEsta != null && objEvenEsta.getFecHasta() != null){
                    numFecHasta = UtilClass.convertDateToNumber(objEvenEsta.getFecHasta()).intValue();
                }
                if(objEvenEstaPK != null && objEvenEstaPK.getFecDesde()!= null){
                    numFecDesde = UtilClass.convertDateToNumber(objEvenEstaPK.getFecDesde()).intValue();
                }
                if(objEvenEstaPK != null && objEvenEstaPK.getIdEstaeven() != null){
                    idEvenEsta = objEvenEstaPK.getIdEstaeven();
                }else if(objEvenEsta != null && objEvenEsta.getCodEstaeven() != null){
                    idEvenEsta = DaoFuncionesUtil.FNC_SICOBTIDGEN(cnConexion, ConstantesSic.CONS_COD_ESTA, objEvenEsta.getCodEstaeven());
                }
            
                String sql = "SELECT * FROM SICDBA.VI_SICREPORTE002 WHERE 1 = 1 ";
                
                if (sic1even.getSic1ideneven() != null && 
                        sic1even.getSic1ideneven().getSic1pers() != null && 
                        sic1even.getSic1ideneven().getSic1pers().getDesPers() != null){
                    
                    strDesPersAdmi = sic1even.getSic1ideneven().getSic1pers().getDesPers().trim();
                }

                if (sic1even != null ){
                    
                    if(sic1even.getIdEven()!= null && sic1even.getIdEven().intValue() > 0)
                        sql += " AND ID_EVEN = " + sic1even.getIdEven();
                    if(sic1even.getCodExpe()!= null && sic1even.getCodExpe().trim().length() > 0)
                        sql += " AND COD_EXPE = '" + sic1even.getCodExpe().trim()+ "'";
                    if(sic1even.getIdSclaseeven() != null && sic1even.getIdSclaseeven().getArrIdSclaseeven() != null )
                        sql += " AND ID_PROCEDIMIENTO IN (" + String.join("," , sic1even.getIdSclaseeven().getArrIdSclaseeven()) + ")";
                    if(sic1even.getSic1persfuncresp()!= null && sic1even.getSic1persfuncresp().getArrIdpers() != null )
                        sql += " AND ID_PERSFUNCIONARIO IN (" + String.join("," , sic1even.getSic1persfuncresp().getArrIdpers()) + ")";
                    if(sic1even.getSic1ideneven()!= null && strDesPersAdmi != null && strDesPersAdmi.length() > 0)
                        sql += " AND DES_ADMINISTRADO LIKE '%" + strDesPersAdmi.toUpperCase() + "%'";
                    if(numFecDesde > 0 && numFecHasta > 0)
                        sql += " AND TO_NUMBER(TO_CHAR(FEC_DESDEESTAEVEN,'YYYYMMDD')) BETWEEN " + numFecDesde + " AND " + numFecHasta;
                    if(idEvenEsta > 0 )
                        sql += " AND ID_ESTA = " + idEvenEsta;
                }
                
                sql += " ORDER BY DES_PROCEDIMIENTO, TO_NUMBER(COD_EXPE)";
                
                System.out.println("sql: " + sql);

                callStatement = cnConexion.prepareCall(sql,
                                                   ResultSet.TYPE_SCROLL_SENSITIVE,
                                                   ResultSet.CONCUR_READ_ONLY,
                                                   ResultSet.CLOSE_CURSORS_AT_COMMIT);

                rsConsulta = callStatement.executeQuery();
                Sic1even objEven;                

                while(rsConsulta.next()){

                    Sic1sclaseeven objSclaseeven = new Sic1sclaseeven();
                    objSclaseeven.setIdSclaseeven(rsConsulta.getBigDecimal("ID_PROCEDIMIENTO"));
                    objSclaseeven.setDesSclaseeven(rsConsulta.getString("DES_PROCEDIMIENTO"));

                    //Administrado
                    Sic1pers objSic1persadmi = new Sic1pers();
                    objSic1persadmi.setIdPers(rsConsulta.getBigDecimal("ID_PERS"));
                    objSic1persadmi.setDesPers(rsConsulta.getString("DES_ADMINISTRADO"));
                    
                    Sic1ideneven objSic1ideneven = new Sic1ideneven();
                    objSic1ideneven.setIdPers(rsConsulta.getBigDecimal("ID_PERS"));
                    objSic1ideneven.setSic1pers(objSic1persadmi);

                    Sic1docubina objDocubina = new Sic1docubina();
                    objDocubina.setNumDocubina(rsConsulta.getString("NRO_RD"));
                    
                    //ESTADO DEL DOCUMENTO
                    Sic3docuesta sic3docuesta = new Sic3docuesta();
                    sic3docuesta.setDesEstadocu(rsConsulta.getString("DES_ESTADO_RD"));
                    
                    //DOCUMENTO
                    Sic1docu objDocu = new Sic1docu();
                    objDocu.setIdDocu(rsConsulta.getBigDecimal("ID_DOCU"));
                    objDocu.setDesTitulo(rsConsulta.getString("DES_TITULO_RD"));
                    objDocu.setFecDesde(rsConsulta.getDate("FEC_RESOLUCION"));
                    objDocu.setSic1docubina(objDocubina);
                    objDocu.setSic3docuesta(sic3docuesta);
                    
                    //Funcionario
                    Sic1pers objSic1persfuncresp = new Sic1pers();
                    objSic1persfuncresp.setDesPers(rsConsulta.getString("DES_FUNCIONARIO"));
                    
                    objEven = new Sic1even();
                    objEven.setIdEven(rsConsulta.getBigDecimal("ID_EVEN"));
                    objEven.setCodExpe(rsConsulta.getString("COD_EXPE"));
                    objEven.setDesNotas(rsConsulta.getString("DES_NOTAS"));
                    objEven.setFlgMigrado(rsConsulta.getInt("FLG_MIGRADO"));
                    objEven.setFecCreacion(rsConsulta.getTimestamp("FEC_CREACION"));
                    objEven.setFecDesde(rsConsulta.getTimestamp("FEC_ENVIO"));
                    objEven.setIdEven(rsConsulta.getBigDecimal("ID_EVEN"));
                    objEven.setSic1persfuncresp(objSic1persfuncresp);
                    objEven.setSic1docu(objDocu);
                    objEven.setSic1ideneven(objSic1ideneven);
                    objEven.setIdSclaseeven(objSclaseeven);
                    objEven.setDesEstaeven(rsConsulta.getString("ESTADO_EXPEDIENTE"));
                    
                    lista.add(objEven);
                }
        
        } catch (SQLException e){
            throw new SQLException(e.getMessage());
        } catch (Exception e){
            throw new Exception(e.getMessage());
        } finally{            
            UtilSic.cerrarConexiones(callStatement, rsConsulta, cnConexion);
        }
        
        return lista;
    }  
    
    public List<Sic1even> obtEventosRelacionados( String codExpe ) throws SQLException, Exception{
        
        CallableStatement statement = null;
        ResultSet rsConsulta = null;
        List<Sic1even> lista = new ArrayList<>();        
        Connection cnConexion = null;
                
        try {  
            
                cnConexion = ConexionBD.obtConexion();
            
                String sql = " SELECT\n" +
                    "        T1.ID_EVEN\n" +
                    "       ,T1.ID_STIPOEVEN\n" +
                    "       ,V1.COD_STIPOEVEN \n" +
                    "       ,UPPER(V1.DES_STIPOEVEN) AS DES_STIPOEVEN\n" +
                    "       ,T1.COD_EXPE\n" +
                    "       ,T1.FEC_CREACION\n" +
                    "       ,T1.FEC_DESDE AS FEC_ENVIO\n" +
                    "       ,T1.DES_NOTAS\n" +

                    "       ,PERSADMI.ID_PERS AS ID_PERSADMIN\n" +
                    "       ,PERSADMI.DES_PERS AS DES_PERSADMIN\n" +

                    "       ,T3.ID_SCLASEEVEN AS ID_PROCEDIMIENTO\n" +
                    "       ,T3.DES_SCLASEEVEN AS DES_PROCEDIMIENTO\n" +

                    "       ,BINA.ID_DOCU AS ID_DOCURESO\n" +
                    "       ,BINA.DES_TITULO AS DES_TITULORD\n" +
                    "       ,BINA.NUM_DOCUBINA AS NUM_NUMERORD\n" +
                    
                    "       ,VIESTA.ID_ESTA AS ID_ESTAEVEN\n" +
                    "       ,VIESTA.COD_ESTA AS COD_ESTAEVEN\n" +
                    "       ,UPPER(VIESTA.DES_ESTA) AS DES_ESTAEVEN\n" +

                    "       ,EVENPERS.ID_PERS AS ID_PERSFUNC " +
                    "       ,PERSFUNC.DES_PERS AS DES_PERSFUNC " +
                    "       ,IDENPERSFUNC.COD_IDEN AS COD_IDENPERSFUNC " +
                    "       ,NVL(T1.FLG_SUBEVENTO,0) AS FLG_SUBEVENTO" +
                    "       ,NVL(RELEVEN.ID_EVENREL,T1.ID_EVEN ) AS ID_EVENPADRE " + 
                    
                    " FROM sicdba.SIC1EVEN T1\n" +
                    " JOIN SICDBA.VI_SICSTIPOEVEN V1 ON V1.ID_STIPOEVEN = T1.ID_STIPOEVEN\n" +
                    " JOIN sicdba.SIC1IDENEVEN T5 ON T5.ID_EVEN = T1.ID_EVEN\n" +
                    " JOIN sicdba.SIC1PERS PERSADMI ON PERSADMI.ID_PERS = T5.ID_PERS\n" +
                    " JOIN sicdba.SIC1SCLASEEVEN T3 ON T3.ID_SCLASEEVEN = T1.ID_SCLASEEVEN\n" +
                    " JOIN sicdba.SIC3EVENESTA ESTAEVEN ON ESTAEVEN.ID_EVEN = T1.ID_EVEN\n" +
                    "                                     AND ESTAEVEN.FEC_HASTA = TO_DATE('31/12/2400','DD/MM/YYYY')\n" +
                    " LEFT JOIN sicdba.VI_SICESTA VIESTA ON VIESTA.ID_ESTA = ESTAEVEN.ID_ESTAEVEN\n" +
                    " LEFT JOIN SIC1DOCUBINA BINA ON BINA.ID_DOCU = T1.ID_DOCURESO\n" +
                    "                               AND BINA.NUM_DOCUBINA IS NOT NULL\n" +
                    " LEFT JOIN SIC3EVENPERS EVENPERS ON EVENPERS.ID_EVEN = T1.ID_EVEN\n" +
                    "                               AND EVENPERS.FEC_HASTA = TO_DATE('31/12/2400','DD/MM/YYYY')\n" +
                    "                               AND EVENPERS.ID_TROLPERS = 4382\n" +
                    " LEFT JOIN SIC1PERS PERSFUNC ON PERSFUNC.ID_PERS = EVENPERS.ID_PERS\n" +
                    " LEFT JOIN SIC1IDENPERS IDENPERSFUNC ON IDENPERSFUNC.ID_PERS = PERSFUNC.ID_PERS\n" +
                    "                                       AND IDENPERSFUNC.ID_TIPOIDEN = 4023\n" +
                    
                    " LEFT JOIN SIC3EVENEVEN RELEVEN ON RELEVEN.ID_EVEN = T1.ID_EVEN " +                      
                    "              AND RELEVEN.FEC_HASTA = TO_DATE('31/12/2400','DD/MM/YYYY') " +
                        
                    " WHERE T1.COD_EXPE = '" + codExpe + "' ";

                sql += " ORDER BY ID_EVEN ";
                
                System.out.println("sql: " + sql);

                statement = cnConexion.prepareCall(sql,
                                                   ResultSet.TYPE_SCROLL_SENSITIVE,
                                                   ResultSet.CONCUR_READ_ONLY,
                                                   ResultSet.CLOSE_CURSORS_AT_COMMIT);

                rsConsulta = statement.executeQuery();
                Sic1even objEven;                

                while(rsConsulta.next()){

                    Sic1sclaseeven objSclaseeven = new Sic1sclaseeven();
                    objSclaseeven.setIdSclaseeven(rsConsulta.getBigDecimal("ID_PROCEDIMIENTO"));
                    objSclaseeven.setDesSclaseeven(rsConsulta.getString("DES_PROCEDIMIENTO"));

                    //ADMINISTRADO
                    Sic1pers objSic1persadmi = new Sic1pers();
                    objSic1persadmi.setIdPers(rsConsulta.getBigDecimal("ID_PERSADMIN"));
                    objSic1persadmi.setDesPers(rsConsulta.getString("DES_PERSADMIN"));                    
                    
                    //DOCUMENTO                    
                    Sic1docubina objDocubina = new Sic1docubina();
                    objDocubina.setNumDocubina(rsConsulta.getString("NUM_NUMERORD"));
                    
                    Sic1docu objDocu = new Sic1docu();
                    objDocu.setIdDocu(rsConsulta.getBigDecimal("ID_DOCURESO"));
                    objDocu.setDesTitulo(rsConsulta.getString("DES_TITULORD"));                    
                    objDocu.setSic1docubina(objDocubina);                    
                    
                    //FUNCIONARIO
                    Sic1pers objSic1persfuncresp = new Sic1pers();
                    objSic1persfuncresp.setIdPers(rsConsulta.getBigDecimal("ID_PERSFUNC"));
                    objSic1persfuncresp.setDesPers(rsConsulta.getString("DES_PERSFUNC"));
                    objSic1persfuncresp.setCodIden(rsConsulta.getString("COD_IDENPERSFUNC"));
                    
                    //SUBTIPOEVEN
                    Sic1general objStipoeven = new Sic1general();
                    objStipoeven.setIdGeneral(rsConsulta.getBigDecimal("ID_STIPOEVEN"));
                    objStipoeven.setCodValorgeneral(rsConsulta.getString("COD_STIPOEVEN"));
                    objStipoeven.setDesGeneral(rsConsulta.getString("DES_STIPOEVEN"));
                    
                    //ESTADO EVENTO                    
                    Sic3evenesta sic3evenesta = new Sic3evenesta();
                    sic3evenesta.setDesEstaeven(rsConsulta.getString("DES_ESTAEVEN"));
                    sic3evenesta.setCodEstaeven(rsConsulta.getString("COD_ESTAEVEN"));
                    
                    //EVENTO
                    objEven = new Sic1even();
                    objEven.setIdEven(rsConsulta.getBigDecimal("ID_EVEN"));
                    objEven.setIdEventopadre(rsConsulta.getBigDecimal("ID_EVENPADRE"));
                    objEven.setCodExpe(rsConsulta.getString("COD_EXPE"));
                    objEven.setDesNotas(rsConsulta.getString("DES_NOTAS"));
                    objEven.setFecCreacion(rsConsulta.getTimestamp("FEC_CREACION"));
                    objEven.setFecDesde(rsConsulta.getTimestamp("FEC_ENVIO"));
                    objEven.setIdEven(rsConsulta.getBigDecimal("ID_EVEN"));
                    objEven.setSic1persfuncresp(objSic1persfuncresp);
                    objEven.setSic1docu(objDocu);
                    objEven.setSic1persadmi(objSic1persadmi);
                    objEven.setIdSclaseeven(objSclaseeven);
                    objEven.setDesEstaeven(rsConsulta.getString("DES_ESTAEVEN"));
                    objEven.setObjStipoeven(objStipoeven);
                    objEven.setFlgSubevento(rsConsulta.getInt("FLG_SUBEVENTO"));
                    
                    lista.add(objEven);
                }
        
        } catch (SQLException e){
            throw new SQLException("obtEventosRelacionados()-ERROR:" + e.getMessage());
        } catch (Exception e){
            throw new Exception("obtEventosRelacionados()-ERROR:" + e.getMessage());
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
        
        return lista;
    }  
    
    
    public List<Sic5evenesta> obtTareasEvento ( Connection cnConexion, Integer idEven ) throws SQLException, Exception{
        
        CallableStatement statement = null;
        ResultSet rsConsulta = null;
        List<Sic5evenesta> lista = new ArrayList<>();        
                
        try {
            
                String sql = 
                        "  SELECT   CASE WHEN PERS.DES_PERS IS NOT NULL THEN PERS.DES_PERS \n" +
                        "                WHEN T6.FLG_ESENTRANTE = 1 THEN 'ADMINSTRADO' ELSE 'MINCETUR' END AS DES_PERS\n" +
                        "          ,CASE WHEN PERS.COD_IDEN IS NOT NULL THEN PERS.DES_PERS \n" +
                        "                WHEN T6.FLG_ESENTRANTE = 1 THEN 'ADMINSTRADO' ELSE 'MINCETUR' END AS COD_IDENPERS \n" +
                        "          ,UPPER(PERS.DES_TROLPERS) AS DES_TROLPERS " +
                        "          ,NVL(T3.FEC_DESDE,FEC_DESDEESTAEVEN) AS FEC_DESDEESTAEVEN " +
                        "          ,NVL(T3.FEC_HASTA,FEC_HASTAESTAEVEN) AS FEC_HASTAESTAEVEN " +
                        "          ,T0.ID_EVEN " +
                        "          ,T0.ID_ESTAEVEN " +
                        "          ,T0.DES_ESTAEVEN " +
                        "          ,T0.ID_TDETTAREA " +
                        "          ,T0.DES_TDETTAREA " +
                        "          ,T0.COD_TDETTAREA " +
                        "          ,T0.DES_TAREA " +                        
                        "          ,T0.NUM_DIAS " +                        
                        "   FROM SICDBA.SIC1IDENACTIVIDAD T1 " +
                        "   JOIN SICDBA.SIC1IDENTAREA IDENT ON IDENT.ID_ACTIVIDAD = T1.ID_ACTIVIDAD " +
                        "   JOIN SICDBA.SIC5EVENESTA T0 ON T0.ID_EVEN = T1.ID_EVEN " +
                        "                                  AND T0.ID_TAREA = IDENT.ID_TAREA   " +
                        "   JOIN SICDBA.SIC8TDETTAREA T6 ON T6.ID_TDETTAREA = T0.ID_TDETTAREA " +
                        "   LEFT JOIN SICDBA.SIC3TAREAPERS T3 ON T3.ID_TAREA = IDENT.ID_TAREA " +
                        "   LEFT JOIN SICDBA.VI_SICPERSBPM PERS ON PERS.ID_PERS = T3.ID_PERS  " +
                        "                                       AND PERS.ID_TROLPERS = T3.ID_TROLPERS " +
                        "   WHERE T0.ID_EVEN =  " + idEven ;
                        
                                
                sql += " ORDER BY T1.ID_ACTIVIDAD ASC";
                
                System.out.println("sql: " + sql);

                statement = cnConexion.prepareCall(sql,
                                                   ResultSet.TYPE_SCROLL_SENSITIVE,
                                                   ResultSet.CONCUR_READ_ONLY,
                                                   ResultSet.CLOSE_CURSORS_AT_COMMIT);

                rsConsulta = statement.executeQuery();
                Sic5evenesta objEven;

                while(rsConsulta.next()){

                    Sic5evenestaPK objPk = new Sic5evenestaPK();

                    objPk.setIdEven(BigInteger.valueOf(rsConsulta.getInt("ID_EVEN")));
                    objPk.setIdEstaeven(rsConsulta.getInt("ID_ESTAEVEN"));                                        
                    
                    Sic1pers objPers = new Sic1pers();
                    objPers.setDesPers(rsConsulta.getString("COD_IDENPERS"));

                    objEven = new Sic5evenesta();
                    objEven.setDesEstaeven(rsConsulta.getString("DES_ESTAEVEN"));
                    objEven.setDesTdettarea(rsConsulta.getString("DES_TDETTAREA"));
                    objEven.setCodTdettarea(rsConsulta.getString("COD_TDETTAREA"));
                    objEven.setDesTarea(rsConsulta.getString("DES_TAREA"));
                    objEven.setFecDesdeestaeven(rsConsulta.getTimestamp("FEC_DESDEESTAEVEN"));
                    objEven.setFecHastaestaeven(rsConsulta.getTimestamp("FEC_HASTAESTAEVEN"));
                    objEven.setNumDias(rsConsulta.getInt("NUM_DIAS"));
                    objEven.setSic5evenestaPK(objPk);
                    objEven.setSic1pers(objPers);

                    lista.add(objEven);
                }
        
        } catch (SQLException e){
            throw new SQLException("obtSeguimiento()-ERROR:" + e.getMessage());
        } catch (Exception e){
            throw new Exception("obtSeguimiento()-ERROR:" + e.getMessage());
        }
        
        return lista;
    } 
    
    /**
     * METODO PARA NOTIFICAR UN OFICIO 
     * @param cnConexion Indica la conexion
     * @param idEven Indica el numero de evento
     * @param idSclaseeven Indica el tipo de documento
     * @param codEstaeven Indica el tipo de documento
     * @param codTipoinst Indica el tipo de documento
     * @param codTdettarea Indica el tipo de documento
     * @param desTarea Indica el tipo de documento
     * @param desNotas Indica el tipo de documento
     * @param idPers Indica el tipo de documento
     * @param idTrolpers Indica el tipo de documento
     * @param idTrelatarea Indica el tipo de documento     
     * @throws Exception
     */
    public void notiObservacion( Connection cnConexion
                                ,Integer idEven
                                ,Integer idSclaseeven
                                ,String codEstaeven
                                ,String codTipoinst
                                ,String codTdettarea
                                ,String desTarea
                                ,String desNotas
                                ,Integer idPers
                                ,Integer idTrolpers
                                ,Integer idTrelatarea ) throws Exception {
        
        
        StoredProcedure sp = null;
        
        try {            
            
            
            System.out.println("============== notiObservacion =====================");
            System.out.println("idEvento: "     + idEven);
            System.out.println("idSclaseeven: " + idSclaseeven);
            System.out.println("codEstaeven: "  + codEstaeven);
            System.out.println("codTipoinst: "  + codTipoinst);
            System.out.println("codTdettarea: " + codTdettarea);
            System.out.println("desTarea: "     + desTarea);
            System.out.println("desNotas: "     + desNotas);
            System.out.println("idPers: "       + idPers);
            System.out.println("idTrolpers: "   + idTrolpers);
            System.out.println("idTrelatarea: " + idTrelatarea);  
            
            log.debug("<I>");
            
            sp = new StoredProcedure("SICDBA.PRC_SICNOTIOBSERVACION");            
            
            sp.addParameter(new InParameter("X_ID_EVEN",        Types.INTEGER, idEven));
            sp.addParameter(new InParameter("X_ID_SCLASEEVEN",  Types.INTEGER, idSclaseeven));
            sp.addParameter(new InParameter("X_COD_ESTAEVEN",   Types.VARCHAR, codEstaeven));
            sp.addParameter(new InParameter("X_COD_TIPOINST",   Types.VARCHAR, codTipoinst));
            sp.addParameter(new InParameter("X_COD_TDETTAREA",  Types.VARCHAR, codTdettarea));
            sp.addParameter(new InParameter("X_DES_TAREA",      Types.VARCHAR, desTarea));
            sp.addParameter(new InParameter("X_DES_NOTAS",      Types.INTEGER, desNotas));
            sp.addParameter(new InParameter("X_ID_PERS",        Types.INTEGER, idPers));
            sp.addParameter(new InParameter("X_ID_TROLPERS",    Types.INTEGER, idTrolpers));
            sp.addParameter(new InParameter("X_ID_TRELATAREA",  Types.VARCHAR, idTrelatarea));
            
            sp.addParameter(new OutParameter("X_ID_ERROR",  Types.INTEGER));
            sp.addParameter(new OutParameter("X_DES_ERROR", Types.VARCHAR));   
            
            sp.ExecuteNonQuery(cnConexion);            
            
            
            if (Integer.valueOf(sp.getParameter("X_ID_ERROR").toString()) != 0 ){
                throw new SQLException((String)sp.getParameter("X_DES_ERROR"));
            }

        
        } catch (SQLException e){            
            throw new Exception(e.getMessage());
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }        
    }
    
    /**
     * METODO PARA NOTIFICAR UN OFICIO O RESOLUCION
     * @param cnConexion Indica la conexion
     * @param idEven Indica el numero de evento
     * @param idSclaseeven Indica el tipo de documento
     * @param codEstaeven Indica el tipo de documento
     * @param codTipoinst Indica el tipo de documento
     * @param codTdettarea Indica el tipo de documento
     * @param desTarea Indica el tipo de documento
     * @param desNotas Indica el tipo de documento
     * @param idPers Indica el tipo de documento
     * @param idTrolpers Indica el tipo de documento
     * @param idTrelatarea Indica el tipo de documento
     * @return
     */
    public Integer crearTracking(    Connection cnConexion
                                    ,Integer idEven
                                    ,Integer idSclaseeven
                                    ,String codEstaeven
                                    ,String codTipoinst
                                    ,String codTdettarea
                                    ,String desTarea
                                    ,String desNotas
                                    ,Integer idPers
                                    ,Integer idTrolpers
                                    ,Integer idTrelatarea ) throws Exception {
        
        int idTarea = 0;
        StoredProcedure sp = null;
        
        try {
            
            System.out.println("============== crearTracking =====================");
            System.out.println("idEvento: "     + idEven);
            System.out.println("idSclaseeven: " + idSclaseeven);
            System.out.println("codEstaeven: "  + codEstaeven);
            System.out.println("codTipoinst: "  + codTipoinst);
            System.out.println("codTdettarea: " + codTdettarea);
            System.out.println("desTarea: "     + desTarea);
            System.out.println("desNotas: "     + desNotas);
            System.out.println("idPers: "       + idPers);
            System.out.println("idTrolpers: "   + idTrolpers);
            System.out.println("idTrelatarea: " + idTrelatarea);  
            
            log.debug("<I>");
            
            sp = new StoredProcedure("SICDBA.PRC_SICCREATRACKING");            
            
            sp.addParameter(new InParameter("X_ID_EVEN",        Types.INTEGER, idEven));
            sp.addParameter(new InParameter("X_ID_SCLASEEVEN",  Types.INTEGER, idSclaseeven));
            sp.addParameter(new InParameter("X_COD_ESTAEVEN",   Types.VARCHAR, codEstaeven));
            sp.addParameter(new InParameter("X_COD_TIPOINST",   Types.VARCHAR, codTipoinst));
            sp.addParameter(new InParameter("X_COD_TDETTAREA",  Types.VARCHAR, codTdettarea));
            sp.addParameter(new InParameter("X_DES_TAREA",      Types.VARCHAR, desTarea));
            sp.addParameter(new InParameter("X_DES_NOTAS",      Types.INTEGER, desNotas));
            sp.addParameter(new InParameter("X_ID_PERS",        Types.INTEGER, idPers));
            sp.addParameter(new InParameter("X_ID_TROLPERS",    Types.INTEGER, idTrolpers));
            sp.addParameter(new InParameter("X_ID_TRELATAREA",  Types.VARCHAR, idTrelatarea));
            
            sp.addParameter(new OutParameter("X_ID_TAREA",  Types.INTEGER));
            sp.addParameter(new OutParameter("X_ID_ERROR",  Types.INTEGER));
            sp.addParameter(new OutParameter("X_DES_ERROR", Types.VARCHAR));
            
            sp.ExecuteNonQuery(cnConexion);
            
            if (Integer.valueOf(sp.getParameter("X_ID_ERROR").toString()) != 0 ){
                throw new SQLException((String)sp.getParameter("X_DES_ERROR"));
            }
            
            idTarea = Integer.valueOf(sp.getParameter("X_ID_TAREA").toString());

        
        } catch (SQLException e){            
            throw new SQLException(e.getMessage());
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
        
        return idTarea;
    }
    
    
    public void cerrarTracking(  Connection cnConexion
                                ,Integer idEven
                                ,String codTipoinst
                                ,String codTdettarea
                                ,Integer idPers
                                ,Integer idTrolpers
                                ,Integer idTrelatarea 
                                ,String desNotas ) throws Exception {
                
        StoredProcedure sp = null;
        
        try {
            
            log.debug("========= cerrarTracking() ==========");
            log.debug("ID_EVEN:" + idEven);
            
            sp = new StoredProcedure("PRC_SICCERRARTRACKING");            
            sp.addParameter(new InParameter("X_ID_EVEN",        Types.INTEGER, idEven));
            sp.addParameter(new InParameter("X_COD_TIPOINST",   Types.VARCHAR, codTipoinst));
            sp.addParameter(new InParameter("X_COD_TDETTAREA",  Types.VARCHAR, codTdettarea));
            sp.addParameter(new InParameter("X_ID_PERS",        Types.INTEGER, idPers));
            sp.addParameter(new InParameter("X_ID_TROLPERS",    Types.INTEGER, idTrolpers));
            sp.addParameter(new InParameter("X_ID_TRELATAREA",  Types.INTEGER, idTrelatarea));
            sp.addParameter(new InParameter("X_DES_NOTAS",      Types.VARCHAR, desNotas));
            
            sp.addParameter(new OutParameter("X_ID_ERROR",      Types.INTEGER));
            sp.addParameter(new OutParameter("X_DES_ERROR",     Types.VARCHAR));
            sp.addParameter(new OutParameter("X_FEC_ERROR",     Types.VARCHAR));
            
            sp.ExecuteNonQuery(cnConexion);            
            
           if (Integer.valueOf(sp.getParameter("X_ID_ERROR").toString()) != 0 ){
                throw new SQLException((String)sp.getParameter("X_DES_ERROR"));
            }            
            
         } catch (SQLException e){            
            throw new SQLException(e.getMessage());
        } catch (NumberFormatException e){
            throw new Exception(e.getMessage());
        }
    }
    
    public String obtenerCodigoAutorizacion(  Connection cnConexion
                                            ,Integer idDocu ) throws Exception {
                
        StoredProcedure sp = null;
        String strCodAuto = "";
        try {
            
            log.debug("========= cerrarTracking() ==========");
            log.debug("ID_DOCU:" + idDocu);
            
            sp = new StoredProcedure("PRC_SICOBTCODIAUTO");
            sp.addParameter(new InParameter("X_ID_DOCU",        Types.INTEGER, idDocu));
            
            sp.addParameter(new OutParameter("X_PARAM",         Types.VARCHAR));
            sp.addParameter(new OutParameter("X_ID_ERROR",      Types.INTEGER));
            sp.addParameter(new OutParameter("X_DES_ERROR",     Types.VARCHAR));
            sp.addParameter(new OutParameter("X_FEC_ERROR",     Types.VARCHAR));
            
            sp.ExecuteNonQuery(cnConexion); 
            
            strCodAuto = (String)sp.getParameter("X_PARAM");
            
           if (Integer.valueOf(sp.getParameter("X_ID_ERROR").toString()) != 0 ){
                throw new SQLException((String)sp.getParameter("X_DES_ERROR"));
            }
            
        } catch (SQLException e){
            throw new SQLException(e.getMessage());
        } catch (NumberFormatException e){
            throw new Exception(e.getMessage());
        }
        
        return strCodAuto;
    }
    
    public ResultSet obtenerListItemsXEvento(   Connection cnConexion
                                                ,int idEven
                                                ,String desEstadoInstancia ) throws Exception {
                
        StoredProcedure sp = null;
        ResultSet rsConsulta = null;
        
        try {
            
            log.debug("========= obtenerListItemsXEvento() ==========");
            log.debug("ID_EVEN:" + idEven);
            
            sp = new StoredProcedure("PRC_SICOBTLISTITEMSXEVENTO");
            sp.addParameter(new InParameter("X_ID_EVEN",        Types.INTEGER, idEven));            
            sp.addParameter(new InParameter("X_COD_ESTADOEXPEDIENTE",        Types.INTEGER, desEstadoInstancia));            
            
            sp.addParameter(new OutParameter("X_CURSOR",         OracleTypes.CURSOR));
            sp.addParameter(new OutParameter("X_ID_ERROR",      Types.INTEGER));
            sp.addParameter(new OutParameter("X_DES_ERROR",     Types.VARCHAR));
            sp.addParameter(new OutParameter("X_FEC_ERROR",     Types.VARCHAR));
            
            sp.ExecuteNonQuery(cnConexion); 
            
            rsConsulta = sp.ExecuteResultCursor(cnConexion, 3);            
            
           if (Integer.valueOf(sp.getParameter("X_ID_ERROR").toString()) != 0 ){
                throw new SQLException((String)sp.getParameter("X_DES_ERROR"));
            }            
            
         } catch (SQLException e){            
            throw new SQLException(e.getMessage());
        } catch (NumberFormatException e){
            throw new Exception(e.getMessage());
        }
        
        return rsConsulta;
    }
}
