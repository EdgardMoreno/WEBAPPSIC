/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.service;

import com.general.dao.DaoDocumentoImpl;
import com.general.entity.Sic1docu;
import com.general.entity.Sic3evendocu;
import com.general.util.ConexionBD;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mincetur.sic.swServicioProxy;

/**
 *
 * @author emoreno
 */
public class DocumentoServiceImpl {
    
    public byte[] descargarDocuBina(String desLocauri) throws Exception{
        
        byte[] archivo = null;
        try {
            
            if(!desLocauri.equals("")){                
                swServicioProxy objswServicioProxy = new swServicioProxy();
                archivo = objswServicioProxy.ejecutarGetFileByName(desLocauri);
            }

        } catch (Exception e) {            
            throw new Exception("ERR: " + e.getMessage());
        }
        
        return archivo;
    }
    
    public Sic1docu obtDocuXidDocu(Integer idDocu) throws SQLException, Exception{     
        
        Connection cnConexion = null;
        Sic1docu objDocu;
        
        try{
            
            cnConexion = ConexionBD.obtConexion();
            DaoDocumentoImpl objDao = new DaoDocumentoImpl();
            objDocu = objDao.obtDocuXidDocu(cnConexion, idDocu);
        
        } catch (Exception e) {
            throw new Exception("ERR: " + e.getMessage());
        } finally{
            if(cnConexion != null){
                cnConexion.close();
            }
        }        
        
        return objDocu;
    }
    
    /**
     * Metodo para obtener los TODOS LOS DOCUMENTOS relacionados al EVENTO.
     * @param idEven Indica el numero de evento
     * @return
     */
    public List<Sic3evendocu> obtDocumentosXEvento(Integer idEven) throws Exception{
        
        Connection cnConexion = null;
        List<Sic3evendocu> lstResu = new ArrayList<>();
        
        try{
            
            cnConexion = ConexionBD.obtConexion();
            DaoDocumentoImpl objDao = new DaoDocumentoImpl();
            lstResu = objDao.obtDocumentosXEvento(cnConexion, idEven, null);
            
        }catch(Exception e){
            throw new Exception("Error: " + e.getMessage());
        }finally{
            
            if(cnConexion != null){
                cnConexion.close();
            }
        }

        return lstResu;
    }
    
    /**
     * Metodo para obtener los REQUISITOS RELACIONADOS AL EVENTO.
     * @param idEven Indica el numero de evento
     * @return
     */
    public List<Sic3evendocu> obtRequisitosXEvento(Integer idEven) throws Exception{
        
        Connection cnConexion = null;
        List<Sic3evendocu> lstResu = new ArrayList<>();
        
        try{
            
            cnConexion = ConexionBD.obtConexion();
            DaoDocumentoImpl objDao = new DaoDocumentoImpl();
            Integer idTipodocu = 97;
            lstResu = objDao.obtDocumentosXEvento(cnConexion, idEven, idTipodocu);
            
        }catch(Exception e){
            throw new Exception("Error: " + e.getMessage());
        }finally{
            if(cnConexion != null){
                cnConexion.close();
            }
        }

        return lstResu;
    }
    
    /**
     * Metodo para obtener los DOCUMENTOS GENERADOS EN TRAMITE relacionados al EVENTO.
     * @param idEven Indica el numero de evento
     * @return
     */
    public List<Sic3evendocu> obtDocuGeneTramiteXEvento(Integer idEven) throws Exception{
                
        Connection cnConexion = null;
        List<Sic3evendocu> lstResu = new ArrayList<>();
        
        try{
            
            cnConexion = ConexionBD.obtConexion();
            DaoDocumentoImpl objDao = new DaoDocumentoImpl();
            Integer idTipodocu = 98;
            lstResu = objDao.obtDocumentosXEvento(cnConexion, idEven, idTipodocu);
            
        }catch(Exception e){
            throw new Exception("Error: " + e.getMessage());
        }finally{
            if(cnConexion != null){
                cnConexion.close();
            }
        }

        return lstResu;
    }
    
     /**
     * Metodo para obtener un documento binario desde el UCM.
     * @param idDocu Indica el identificador del documento
     * @return
     */
    public InputStream obtenerDocuBinaUCM(BigDecimal idDocu ) throws Exception{
        
        InputStream stream = null;

        try {
            
            DocumentoServiceImpl objService = new DocumentoServiceImpl();
            Sic1docu objDocu = objService.obtDocuXidDocu(idDocu.intValue());
            
            System.out.println("LOCA_URI:" + objDocu.getSic1docubina().getDesLocauri());
            
            byte[] archivo = objService.descargarDocuBina(objDocu.getSic1docubina().getDesLocauri());
            stream = new ByteArrayInputStream(archivo);
            
        }catch(Exception e){
            throw new Exception(e.getMessage());            
        }
        
        return stream;
    }    
}
