/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.dao;

import com.general.entity.Sic1idenpers;
import com.general.entity.Sic1idenpersPK;
import com.general.entity.Sic1pers;
import com.general.entity.Sic1usuario;
import com.general.util.ConexionBD;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author emoreno
 */
public class DaoLoginImpl implements Serializable{
        

    /*CONSTRUCTORES*/
    public DaoLoginImpl(){
        
    }    
        
    /**
     * Procedimiento que valida si exista una persona según su USUARIO y su DOCUMENTO DE IDENTIDAD.
     * @param codUserName Indica el codigo del usuario. Ejem. RLLERENA
     * @param numDocuIden Indica el Numero de Documento de Identidad (DNI)
     * @return
     * @throws Exception 
     */
    public Sic1usuario validarPersona(String codUserName, String numDocuIden) throws Exception {
        
        CallableStatement statement = null;
        ResultSet rsConsulta = null;
        Sic1usuario objUsuario = null;        
        Connection cnConexion = null;
                
        try{    
            
            cnConexion = ConexionBD.obtConexion();
            
            String sql = " SELECT  T1.ID_PERS \n" +
                            "     ,T1.DES_PERS\n" +
                            "     ,PERSBPM.COD_IDEN AS COD_USUARIO\n" +
                            "     ,PERSDNI.COD_IDEN AS NUM_DOCUIDENTIDAD\n" +
                            " FROM SICDBA.SIC1PERS T1\n" +
                            " LEFT JOIN SICDBA.SIC1IDENPERS PERSDNI ON PERSDNI.ID_PERS = T1.ID_PERS \n" +
                            "                                          AND PERSDNI.FEC_HASTA = TO_DATE('24001231','YYYYMMDD') \n" +
                            "                                          AND PERSDNI.ID_TIPOIDEN = 124 \n" +
                            " LEFT JOIN SICDBA.SIC1IDENPERS PERSBPM ON PERSBPM.ID_PERS = T1.ID_PERS \n" +
                            "                                          AND PERSBPM.FEC_HASTA = TO_DATE('24001231','YYYYMMDD') \n" +
                            "                                          AND PERSBPM.ID_TIPOIDEN = 4023 \n" +
                            " JOIN SICDBA.VI_SICTIPOIDEN V1 ON V1.ID_TIPOIDEN = PERSDNI.ID_TIPOIDEN " +
                            " WHERE UPPER(PERSBPM.COD_IDEN) = UPPER('" + codUserName + "')";
            
            if(numDocuIden != null && numDocuIden.trim().length()>0)
                sql +=  " AND PERSDNI.COD_IDEN = '" + numDocuIden + "'";
            
            statement = cnConexion.prepareCall(sql,
                                                    ResultSet.TYPE_SCROLL_SENSITIVE,
                                                    ResultSet.CONCUR_READ_ONLY,
                                                    ResultSet.CLOSE_CURSORS_AT_COMMIT);            
            
            rsConsulta = statement.executeQuery();            
            
            
            while(rsConsulta.next()){
                                   
                Sic1idenpersPK k = new Sic1idenpersPK();
                k.setCodIden(rsConsulta.getString("NUM_DOCUIDENTIDAD"));
                //k.setIdTipoiden(rsConsulta.getInt("ID_TIPOIDEN"));

                Sic1idenpers objidenPers = new Sic1idenpers();
                objidenPers.setIdPers(rsConsulta.getBigDecimal("ID_PERS"));
                objidenPers.setSic1idenpersPK(k);

                Sic1pers objPers = new Sic1pers();
                objPers.setIdPers(rsConsulta.getBigDecimal("ID_PERS"));
                objPers.setDesPers(rsConsulta.getString("DES_PERS"));
                objPers.setSic1idenpers(objidenPers);
                
                objUsuario = new Sic1usuario();
                objUsuario.setIdUsuario(rsConsulta.getBigDecimal("ID_PERS"));
                objUsuario.setCodUsuario(rsConsulta.getString("COD_USUARIO"));
                objUsuario.setCodPwd(rsConsulta.getString("NUM_DOCUIDENTIDAD"));
                objUsuario.setSic1pers(objPers);
                
            }            
                    
        } catch (SQLException e){            
            throw new SQLException("validateUsernamePassword():" + e.getMessage());
        } catch (Exception e){          
            throw new Exception("validateUsernamePassword():" + e.getMessage());
        } finally{
            
            if(statement != null){
                statement.close();                
            }
            
            if(rsConsulta!=null)
                rsConsulta.close();
            
            if(cnConexion!=null)
                cnConexion.close();
        }
        
        return objUsuario;
    }
}
