/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.dao;

import com.general.util.ConexionBD;
import com.general.views.ViComsala;
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
public class DaoSalaImpl {
    
    
    public List<ViComsala> obtSalas(ViComsala obj) throws Exception{
        
        List<ViComsala> lstSalas = new ArrayList<>();
        ResultSet rsConsulta = null;
        CallableStatement statement = null;        
        Connection cnConexion = null;
                
        try {
            
            cnConexion = ConexionBD.obtConexion();
            
            //String sql = "SELECT * FROM SICDBA.VI_COMSALA WHERE 1 = 1 ";
            
            String sql = "SELECT " +
                        "        S1.ID_SALA\n" +
                        "       ,S1.ID_EVEN " +
                        "       ,S1.COD_SALA\n" +
                        "       ,S1.ID_EMPRESA\n" +
                        "       ,S1.NOM_EMPRES\n" +
                        "       ,S1.NOM_SALA\n" +
                        "       ,S1.DES_TIPOGIRO\n" +
                        "       ,S1.RESOLUCION\n" +
                        "       ,S1.FEC_INICIO\n" +
                        "       ,S1.FEC_FIN\n" +
                        "       ,S1.DIRECCION_HTML\n" +
                        "       ,S1.DISTRITO\n" +
                        "       ,S1.PROVINCIA\n" +
                        "       ,S1.DEPARTAMENTO\n" +
                        "       ,S1.DES_TIPOSALA " +
                        "       ,S1.EXPEDIENTE " +
                        "       ,S1.FEC_NOTIFICACION " +

                        "       ,(SELECT COUNT(1)          " +
                        "         FROM SICDBA.SIC3LUGARPROD MEMO          " +
                        "         WHERE S1.ID_SALA = MEMO.ID_LUGAR        " +
                        "         AND MEMO.ID_TRELALUGARPROD = 121 /*MEMORIAS*/ " +
                        "         AND MEMO.FEC_HASTA = TO_DATE('24001231','YYYYMMDD')) AS NUM_CANTMEMORIAS\n" +
                        
                        "       ,(SELECT COUNT(1)         " +
                        "         FROM SICDBA.SIC3LUGARPROD MESA         " +
                        "         WHERE S1.ID_SALA = MESA.ID_LUGAR         " +
                        "         AND MESA.ID_TRELALUGARPROD = 122 /*MESAS*/    " +
                        "         AND MESA.FEC_HASTA = TO_DATE('24001231','YYYYMMDD')) AS NUM_CANTMESAS  " +
                        
                        "       ,(SELECT COUNT(1)" +
                        "         FROM SICDBA.SIC3LUGARPRODITEM MT        " +
                        "         WHERE S1.ID_SALA = MT.ID_LUGAR          " +
                        "         AND MT.FEC_HASTA = TO_DATE('24001231','YYYYMMDD')) AS NUM_CANTMAQUINAS " +

                        " FROM ( SELECT * FROM SICDBA.VI_COMSALA <FILTRO> ) S1 ";
            
            String fitro = " WHERE ID_TRELALUGAR = 130 ";
            
            if(obj.getCodSala() != null && obj.getCodSala().trim().length() > 0)
                fitro += " AND COD_SALA = '" + obj.getCodSala() + "'";
            if(obj.getNomEmpres()!= null && obj.getNomEmpres().trim().length() > 0)
                fitro += " AND NOM_EMPRES LIKE '%" + obj.getNomEmpres()+ "%'";
            if(obj.getNomSala()!= null && obj.getNomSala().trim().length() > 0)
                fitro += " AND NOM_SALA LIKE '%" + obj.getNomSala() + "%'";
            if(obj.getExpediente()!= null && obj.getExpediente().trim().length() > 0)
                fitro += " AND EXPEDIENTE = " + obj.getExpediente();
            
            sql = sql.replace("<FILTRO>", fitro);
            sql += " ORDER BY COD_SALA";                        
                
            System.out.println("sql: " + sql);

            statement = cnConexion.prepareCall(sql,
                                               ResultSet.TYPE_SCROLL_SENSITIVE,
                                               ResultSet.CONCUR_READ_ONLY,
                                               ResultSet.CLOSE_CURSORS_AT_COMMIT);

            rsConsulta = statement.executeQuery();            

            ViComsala objSala;

            while(rsConsulta.next()){

                objSala = new ViComsala();
                objSala.setIdSala(rsConsulta.getInt("ID_SALA"));
                objSala.setIdEven(rsConsulta.getBigDecimal("ID_EVEN"));                
                objSala.setCodSala(rsConsulta.getString("COD_SALA"));
                objSala.setNomSala(rsConsulta.getString("NOM_SALA"));
                objSala.setIdEmpresa(rsConsulta.getInt("ID_EMPRESA"));
                objSala.setNomEmpres(rsConsulta.getString("NOM_EMPRES"));                
                objSala.setDesTiposala(rsConsulta.getString("DES_TIPOSALA"));
                objSala.setDesTipogiro(rsConsulta.getString("DES_TIPOGIRO"));
                objSala.setDireccionHtml(rsConsulta.getString("DIRECCION_HTML"));
                objSala.setDistrito(rsConsulta.getString("DISTRITO"));
                objSala.setProvincia(rsConsulta.getString("PROVINCIA"));
                objSala.setDepartamento(rsConsulta.getString("DEPARTAMENTO"));
                objSala.setFecInicio(rsConsulta.getDate("FEC_INICIO"));
                objSala.setFecFin(rsConsulta.getDate("FEC_FIN"));
                objSala.setExpediente(rsConsulta.getString("EXPEDIENTE"));
                objSala.setResolucion(rsConsulta.getString("RESOLUCION"));
                objSala.setFecNotificacion(rsConsulta.getDate("FEC_NOTIFICACION"));
                
                objSala.setNum_cantMemorias(rsConsulta.getInt("NUM_CANTMEMORIAS"));
                objSala.setNum_cantMaquinas(rsConsulta.getInt("NUM_CANTMAQUINAS"));
                objSala.setNum_cantMesas(rsConsulta.getInt("NUM_CANTMESAS"));

                lstSalas.add(objSala);

            }
            
        }catch(SQLException ex){
            throw new Exception(ex.getMessage());
        }finally{
            if(statement != null){
                statement.close();
                rsConsulta.close();
            }
            if(cnConexion != null)
                cnConexion.close();
        }
        
        return lstSalas;
    }
    
}
