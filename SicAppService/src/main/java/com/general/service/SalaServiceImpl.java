/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.service;

import com.general.dao.DaoSalaImpl;
import com.general.entity.Sic1docu;
import com.general.util.ConexionBD;
import com.general.views.ViComsala;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author emoreno
 */
public class SalaServiceImpl {
    
    
    public List<ViComsala> obtSalas(ViComsala obj) throws Exception{
                
        List<ViComsala> lstSalas = new ArrayList<>();        
                
        try{
            
            DaoSalaImpl objDao = new DaoSalaImpl();
            
            lstSalas = objDao.obtSalas(obj);
            
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
        
        return lstSalas;
    }
    
}
