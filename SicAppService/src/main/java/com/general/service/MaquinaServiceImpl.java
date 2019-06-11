/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.service;

import com.general.dao.DaoMaquinaImpl;
import com.general.entity.Sic1codiauto;
import com.general.entity.Sic1proditem;
import com.general.entity.Sic3proditempers;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author emoreno
 */
public class MaquinaServiceImpl {
    
    
    public List<Sic3proditempers> obtMaquinasXAdmi(Integer idPers) throws Exception{        
        
        List<Sic3proditempers> lstMaquinas = new ArrayList<>();
        
        try{
            
            DaoMaquinaImpl objDaoMaquinaImpl = new DaoMaquinaImpl();
            Sic1proditem objMaq = new Sic1proditem();
            objMaq.setIdPersadmin(idPers);
            lstMaquinas = objDaoMaquinaImpl.obtMaquinasAutorizadas(objMaq);
            
        }catch(Exception e){
            throw new Exception("Error: " + e.getMessage());
        }

        return lstMaquinas;
    }
    
    /**
     * METODO QUE LISTA LAS MAQUINAS QUE YA TIENEN CODIGO DE AUTORIZACION Y EN TRAMITE
     * @param objMaq
     * @return
     * @throws Exception 
     */
    public List<Sic3proditempers> obtMaquinasAutorizadasYTramite(Sic1proditem objMaq) throws Exception{        
        
        List<Sic3proditempers> lstMaquinas = new ArrayList<>();
        try{            
            DaoMaquinaImpl objDaoMaquinaImpl = new DaoMaquinaImpl();
            lstMaquinas = objDaoMaquinaImpl.obtMaquinasAutorizadas(objMaq);
            
            List<Sic3proditempers> lstMaquinasTramite = objDaoMaquinaImpl.obtMaquinasEnTramite(objMaq);
            
            if(lstMaquinasTramite.size() > 0)
                lstMaquinas.addAll(lstMaquinasTramite);
            
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
        return lstMaquinas;
    }
    
    /**
     * METODO QUE LISTA LAS MAQUINAS QUE YA TIENEN CODIGO DE AUTORIZACION
     * @param objMaq
     * @return
     * @throws Exception 
     */
    public List<Sic3proditempers> obtMaquinasAutorizadas(Sic1proditem objMaq) throws Exception{        
        
        List<Sic3proditempers> lstMaquinas = new ArrayList<>();
        try{            
            DaoMaquinaImpl objDaoMaquinaImpl = new DaoMaquinaImpl();
            lstMaquinas = objDaoMaquinaImpl.obtMaquinasAutorizadas(objMaq);
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
        return lstMaquinas;
    }
    
    /**
     * METODO QUE OBTIENE LAS MAQUINAS QUE ESTAN EN TRAMITE, SIEMPRE Y CUANDO NO HAYAN SIDO AUTORIZADAS
     * @param objMaq
     * @return
     * @throws Exception 
     */
    public List<Sic3proditempers> obtMaquinasEnTramite(Sic1proditem objMaq) throws Exception{        
        
        List<Sic3proditempers> lstMaquinas = new ArrayList<>();        
        try{            
            DaoMaquinaImpl objDaoMaquinaImpl = new DaoMaquinaImpl();
            lstMaquinas = objDaoMaquinaImpl.obtMaquinasEnTramite(objMaq);            
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
        return lstMaquinas;
    }
    
    
    public List<Sic3proditempers> obtMaquinasXSala(Integer idSala) throws Exception{        
        
        List<Sic3proditempers> lstMaquinas = new ArrayList<>();
        
        try{
            
            Sic1codiauto s = new Sic1codiauto();
            s.setIdSala(new BigDecimal(idSala));
            
            Sic1proditem objMaq = new Sic1proditem();
            objMaq.setSic1codiauto(s);
            
            DaoMaquinaImpl objDaoMaquinaImpl = new DaoMaquinaImpl();
            lstMaquinas = objDaoMaquinaImpl.obtMaquinasAutorizadas(objMaq);
            
        }catch(Exception e){
            throw new Exception("Error: " + e.getMessage());
        }

        return lstMaquinas;
    }
    
    
}
