/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.dao;

import com.general.entity.Sic1idenpers;
import com.general.entity.Sic1idenpersPK;
import com.general.entity.Sic1pers;
import com.general.entity.Sic5persperm;
import com.general.entity.Sic7persrol;
import com.general.entity.Sic7persrolPK;
import com.general.util.ConexionBD;
import com.general.util.beans.UtilClass;
import conexionbd.InParameter;
import conexionbd.OutParameter;
import conexionbd.StoredProcedure;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author emoreno
 */
public class DaoPersonaImpl {
    
    /**
     * DESCRIPCION: Metodo que devuelve un listado de Personas segun el nombre y rol.
     * @param codTrolpers
     * @param desPers
     * @return
     * @throws SQLException
     * @throws Exception 
     */
    public List<Sic1pers> obtPersonasXNombre (String codTrolpers
                                             ,String desPers) throws SQLException, Exception{
        
        CallableStatement statement = null;
        ResultSet rsConsulta = null;
        List<Sic1pers> lstPers = new ArrayList<>();
        Connection cnConexion = null;
        
        System.out.println("desPers: " + desPers);
        try {
            
            cnConexion = ConexionBD.obtConexion();
            
            if(desPers!= null && desPers.trim().length() > 0){
            
                String sql = 
                        "SELECT " +
                            "        T1.ID_PERS " +
                            "       ,V1.ID_TIPOIDEN " +
                            "       ,V1.DES_TIPOIDEN " +
                            "       ,IDEN.COD_IDEN AS COD_IDEN " +
                            "       ,UPPER(T4.DES_TIPOPERS) AS DES_TIPOPERS " +
                            "       ,T1.DES_PERS " +
                            " FROM SICDBA.SIC1PERS T1 " +
                            " JOIN SICDBA.SIC1IDENPERS IDEN ON IDEN.ID_PERS = T1.ID_PERS " +
                            "                          AND IDEN.ID_TIPOIDEN != 4353 " +
                            " JOIN SICDBA.VI_SICTIPOIDEN V1 ON V1.ID_TIPOIDEN = IDEN.ID_TIPOIDEN " +
                            " LEFT JOIN SICDBA.VI_SICTIPOPERS T4 ON T4.ID_TIPOPERS = T1.ID_TIPOPERS " +
                            " WHERE UPPER(T1.DES_PERS) LIKE '%" +  desPers.toUpperCase() + "%'";

                if (codTrolpers != null ){
                    sql += " AND EXISTS( SELECT 1 " +
    "                                   FROM SICDBA.SIC7PERSROL TMP2 " +
    "                                   LEFT JOIN SICDBA.VI_SICTROLPERS TMP3 ON TMP3.ID_TROLPERS = TMP2.ID_TROLPERS " +
    "                                   WHERE TMP2.ID_PERS = T1.ID_PERS AND TMP3.COD_TROLPERS = '" + codTrolpers + "' )";
                }

                statement = cnConexion.prepareCall(sql,
                                                        ResultSet.TYPE_SCROLL_SENSITIVE,
                                                        ResultSet.CONCUR_READ_ONLY,
                                                        ResultSet.CLOSE_CURSORS_AT_COMMIT);

                rsConsulta = statement.executeQuery();
                Sic1pers objPers = null;
                Sic1idenpers objIdenpers = null;
                Sic1idenpersPK objSic1idenpersPK = null;

                while(rsConsulta.next()){

                    objSic1idenpersPK = new Sic1idenpersPK();
                    objSic1idenpersPK.setCodIden(rsConsulta.getString("COD_IDEN"));
                    objSic1idenpersPK.setIdTipoiden(rsConsulta.getInt("ID_TIPOIDEN"));
                    objSic1idenpersPK.setDesTipoiden(rsConsulta.getString("DES_TIPOIDEN"));

                    objIdenpers = new Sic1idenpers();
                    objIdenpers.setSic1idenpersPK(objSic1idenpersPK);

                    objPers = new Sic1pers();
                    objPers.setIdPers(rsConsulta.getBigDecimal("ID_PERS"));
                    objPers.setDesPers(rsConsulta.getString("DES_PERS"));
                    objPers.setDesTipopers(rsConsulta.getString("DES_TIPOPERS"));
                    objPers.setSic1idenpers(objIdenpers);
                    
                    lstPers.add(objPers);

                }            
            }
        
        } catch (SQLException e){
            throw new SQLException("obtPersonasXNombre()-ERROR:" + e.getMessage());
        } catch (Exception e){
            throw new Exception("obtPersonasXNombre()-ERROR:" + e.getMessage());
        } finally{
            
            if(cnConexion != null)
                cnConexion.close();
            
            if(rsConsulta!=null)
                rsConsulta.close();
            
            if(statement!= null)
                statement.close();
        }
        
        return lstPers;
    }   
    
    /**
     * Metodo que devuelve las lista de funcionarios
     * @param sic1pers
     * @return
     * @throws SQLException
     * @throws Exception 
     */
    public List<Sic1pers> obtFuncionarios (Sic1pers sic1pers) throws SQLException, Exception{
        
        CallableStatement statement = null;
        ResultSet rsConsulta = null;
        List<Sic1pers> lstPers = new ArrayList<>();        
        Connection cnConexion = null;
        
        try {
            
        cnConexion = ConexionBD.obtConexion();    
            
            String sql = 
                    " SELECT \n" +
                        "   ID_PERS\n" +
                        "  ,DES_PERS\n" +
                        "  ,COD_IDEN\n" +
                        "  ,ID_TROLPERS\n" +
                        "  ,UPPER(DES_TROLPERS) AS DES_TROLPERS\n" +
                        "  ,COD_TROLPERS\n" +
                        " FROM SICDBA.VI_SICPERSBPM WHERE 1=1 ";

            sql += " ORDER BY DES_TROLPERS, COD_IDEN ";

            statement = cnConexion.prepareCall(sql,
                                                    ResultSet.TYPE_SCROLL_SENSITIVE,
                                                    ResultSet.CONCUR_READ_ONLY,
                                                    ResultSet.CLOSE_CURSORS_AT_COMMIT);

            rsConsulta = statement.executeQuery();
            Sic1pers objPers = null;
            Sic1idenpers objIdenpers = null;
            Sic1idenpersPK objSic1idenpersPK = null;

            while(rsConsulta.next()){

                objSic1idenpersPK = new Sic1idenpersPK();
                objSic1idenpersPK.setCodIden(rsConsulta.getString("COD_IDEN"));                

                objIdenpers = new Sic1idenpers();
                objIdenpers.setSic1idenpersPK(objSic1idenpersPK);
                
                Sic7persrolPK objPersrolpk = new Sic7persrolPK();
                objPersrolpk.setIdPers(rsConsulta.getBigDecimal("ID_PERS"));
                objPersrolpk.setIdTrolpers(rsConsulta.getInt("ID_TROLPERS"));
                objPersrolpk.setDesTrolpers(rsConsulta.getString("DES_TROLPERS"));
                objPersrolpk.setCodTrolpers(rsConsulta.getString("COD_TROLPERS"));
                
                Sic7persrol objPersrol = new Sic7persrol();
                objPersrol.setSic7persrolPK(objPersrolpk);
                
                objPers = new Sic1pers();
                objPers.setIdPers(rsConsulta.getBigDecimal("ID_PERS"));
                objPers.setDesPers(rsConsulta.getString("DES_PERS"));
                objPers.setSic1idenpers(objIdenpers);
                objPers.setSic7persrol(objPersrol);

                lstPers.add(objPers);

            }            
            
        
        } catch (SQLException e){
            throw new SQLException("obtFuncionarios()-ERROR:" + e.getMessage());
        } catch (Exception e){
            throw new Exception("obtFuncionarios()-ERROR:" + e.getMessage());
        } finally{
            if(statement!=null)
                statement.close();
            if(rsConsulta!=null)
                rsConsulta.close();
            if(cnConexion != null)
                cnConexion.close();
        }
        
        return lstPers;
    }
    
    /**
     * Metodo que permite registrar permisos(vacaciones) para el administrado.
     * @param cnConexion
     * @param sic5persperm
     * @throws SQLException
     * @throws Exception 
     */
    public void registrarPermisoFunc( Connection cnConexion
                                 ,Sic5persperm sic5persperm ) throws SQLException, Exception {

        StoredProcedure sp = null;
        String strFecDesde = null;
        String strFecHasta = null;
        
        try {

            System.out.println("======================== insertarDocuBina ========================");           
            System.out.println("x_id_pers:" + sic5persperm.getSic5perspermPK().getIdPers());
            System.out.println("x_id_motiperm:" + sic5persperm.getIdMotiperm());
            System.out.println("x_fec_desde:" + sic5persperm.getFecDesde());
            System.out.println("x_fec_hasta:" + sic5persperm.getFecHasta());
            System.out.println("x_des_notas:" + sic5persperm.getDesNotas());
            System.out.println("x_des_perm:" + sic5persperm.getDesPerm());           
           
//            if (sic5persperm.getFecCreacion() != null){
//                strFecCreacion = UtilClass.convertDateToString(sic5persperm.getFecCreacion());
//            }
            if (sic5persperm.getFecDesde()!= null){
                strFecDesde = UtilClass.convertDateToString(sic5persperm.getFecDesde());
            }
            if (sic5persperm.getFecHasta()!= null){
                strFecHasta = UtilClass.convertDateToString(sic5persperm.getFecHasta());
            }
           
            sp = new StoredProcedure("SICDBA.PKG_SICMANTPERMFUNC.PRC_SICCREAPERM");
           
            sp.addParameter(new InParameter("X_ID_PERS"      ,Types.INTEGER, sic5persperm.getSic5perspermPK().getIdPers()));
            sp.addParameter(new InParameter("X_ID_MOTIPERM"  ,Types.INTEGER, sic5persperm.getIdMotiperm()));
            sp.addParameter(new InParameter("X_FEC_DESDE"    ,Types.VARCHAR, strFecDesde));
            sp.addParameter(new InParameter("X_FEC_HASTA"    ,Types.VARCHAR, strFecHasta));
            sp.addParameter(new InParameter("X_DES_NOTAS"    ,Types.VARCHAR, sic5persperm.getDesNotas()));
            sp.addParameter(new InParameter("X_DES_PERM"     ,Types.VARCHAR, sic5persperm.getDesPerm()));

            sp.addParameter(new OutParameter("X_NUM_PERM"    ,Types.NUMERIC));
            sp.addParameter(new OutParameter("X_ID_ERROR"    ,Types.NUMERIC));
            sp.addParameter(new OutParameter("X_DES_ERROR"   ,Types.VARCHAR));
            sp.addParameter(new OutParameter("X_FEC_ERROR"   ,Types.DATE));

            sp.ExecuteNonQuery(cnConexion);

            if (Integer.valueOf(sp.getParameter("X_ID_ERROR").toString()) != 0 ){
                throw new SQLException((String)sp.getParameter("X_DES_ERROR"));
            }           

       } catch (SQLException e){           
           throw new SQLException(e.getMessage());
       } catch (Exception e){
           throw new Exception(e.getMessage());
       }
   }  
    
    /**
     * Metodo que devuelve la lista de roles asignamos a la persona
     * @param idPers Indica el identificador de la persona     
     * @return
     * @throws SQLException
     * @throws Exception 
     */
    public List<Sic7persrol> obtRolesPersona( BigDecimal idPers ) throws SQLException, Exception {

        CallableStatement statement = null;
        ResultSet rsConsulta = null;
        List<Sic7persrol> lstRolPers = new ArrayList<>();        
        Connection cnConexion = null;
        
        
        try {
            
        cnConexion = ConexionBD.obtConexion();    
            
            String sql = 
                    " SELECT  T2.ID_PERS\n" +
                    "       ,T2.ID_TROLPERS  \n" +
                    "       ,T2.FEC_DESDE\n" +
                    "       ,T2.FEC_HASTA\n" +
                    "       ,V1.COD_TROLPERS \n" +
                    "       ,UPPER(V1.DES_TROLPERS) AS DES_TROLPERS\n" +
                    " FROM SICDBA.SIC7PERSROL T2\n" +
                    " JOIN SICDBA.VI_SICTROLPERS V1 ON V1.ID_TROLPERS = T2.ID_TROLPERS \n" +
                    " WHERE T2.ID_PERS = " + idPers + " AND TO_NUMBER(TO_CHAR(T2.FEC_HASTA,'YYYYMMDD')) =  24001231";

            statement = cnConexion.prepareCall(sql,
                                                    ResultSet.TYPE_SCROLL_SENSITIVE,
                                                    ResultSet.CONCUR_READ_ONLY,
                                                    ResultSet.CLOSE_CURSORS_AT_COMMIT);

            rsConsulta = statement.executeQuery();            

            while(rsConsulta.next()){
                
                Sic7persrolPK objRolPk = new Sic7persrolPK();
                objRolPk.setIdPers(rsConsulta.getBigDecimal("ID_PERS"));
                objRolPk.setIdTrolpers(rsConsulta.getInt("ID_TROLPERS"));
                objRolPk.setCodTrolpers(rsConsulta.getString("COD_TROLPERS"));
                objRolPk.setDesTrolpers(rsConsulta.getString("DES_TROLPERS"));
                objRolPk.setFecDesde(rsConsulta.getDate("FEC_DESDE"));                
                
                Sic7persrol objRol = new Sic7persrol();
                objRol.setSic7persrolPK(objRolPk);
                objRol.setFecHasta(rsConsulta.getDate("FEC_HASTA"));
                lstRolPers.add(objRol);

            }
        
        } catch (SQLException e){
            throw new SQLException("obtRolesPersona()-ERROR:" + e.getMessage());
        } catch (Exception e){
            throw new Exception("obtRolesPersona()-ERROR:" + e.getMessage());
        } finally{
            if(statement!=null)
                statement.close();
            if(rsConsulta!=null)
                rsConsulta.close();
            if(cnConexion != null)
                cnConexion.close();
        }
        
        return lstRolPers;
   }  
    
}
