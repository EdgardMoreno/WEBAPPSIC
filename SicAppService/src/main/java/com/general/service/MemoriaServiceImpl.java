/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.service;

import com.general.dao.DaoMemoriaImpl;
import com.general.entity.Sic1codiauto;
import com.general.entity.Sic1prod;
import com.general.entity.Sic3prodpers;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author emoreno
 */
public class MemoriaServiceImpl {
    
    
    public List<Sic3prodpers> obtMemoriasXSala(Integer idSala) throws Exception{        

        List<Sic3prodpers> lstMemorias = new ArrayList<>();
        
        try{
            
            Sic1codiauto s = new Sic1codiauto();
            s.setIdSala(new BigDecimal(idSala));
            
            DaoMemoriaImpl objDao = new DaoMemoriaImpl();
            
            Sic1prod obj = new Sic1prod();
            obj.setSic1codiauto(s);
            lstMemorias = objDao.obtMemorias(obj);
            
        }catch(Exception e){
            throw new Exception("Error: " + e.getMessage());
        }

        return lstMemorias;
    }
    
    public List<Sic3prodpers> obtMemorias(Sic1prod objMaq) throws Exception{        
        
        List<Sic3prodpers> lstMemorias = new ArrayList<>();

        try{
            
            DaoMemoriaImpl objDao = new DaoMemoriaImpl();
            Sic1prod obj = new Sic1prod();
            lstMemorias = objDao.obtMemorias(obj);

        }catch(Exception e){
            throw new Exception("Error: " + e.getMessage());
        }

        return lstMemorias;
    }
}
