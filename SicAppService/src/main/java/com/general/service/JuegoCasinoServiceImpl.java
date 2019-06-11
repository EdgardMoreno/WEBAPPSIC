/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.service;

import com.general.dao.DaoJuegoCasinoImpl;
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
public class JuegoCasinoServiceImpl {
    
    
    public List<Sic3prodpers> obtJuegosCasinoXSala(Integer idSala) throws Exception{        

        List<Sic3prodpers> lstJuegosCasino = new ArrayList<>();
        
        try{
            
            Sic1codiauto s = new Sic1codiauto();
            s.setIdSala(new BigDecimal(idSala));
            
            DaoJuegoCasinoImpl objDao = new DaoJuegoCasinoImpl();
            
            Sic1prod obj = new Sic1prod();
            obj.setSic1codiauto(s);
            lstJuegosCasino = objDao.obtJuegosCasino(obj);
            
        }catch(Exception e){
            throw new Exception("Error: " + e.getMessage());
        }

        return lstJuegosCasino;
    }
    
    public List<Sic3prodpers> obtJuegosCasino(Sic1prod objJuegCas) throws Exception{        
        
        List<Sic3prodpers> lstJuegosCasino = new ArrayList<>();

        try{
            
            DaoJuegoCasinoImpl objDao = new DaoJuegoCasinoImpl();
            Sic1prod obj = new Sic1prod();
            lstJuegosCasino = objDao.obtJuegosCasino(obj);

        }catch(Exception e){
            throw new Exception("Error: " + e.getMessage());
        }

        return lstJuegosCasino;
    }
}
