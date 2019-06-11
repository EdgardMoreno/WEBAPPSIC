/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.service;

import com.general.dao.DaoMaestroCatalogoImpl;
import com.general.entity.Sic1general;
import com.general.util.ConexionBD;
import com.general.util.exceptions.CustomizerException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;

/**
 *
 * @author emoreno
 */
public class MaestroCatalogoServiceImpl {

    public String obtUrlPWA(String codVersudm) throws SQLException, Exception{
        
        Connection cnConexion = null;
        String resultado = null;
        
        try{
            cnConexion = ConexionBD.obtConexion();
            DaoMaestroCatalogoImpl objDao = new DaoMaestroCatalogoImpl();
            resultado = objDao.obtUrlPWA(cnConexion, codVersudm);
            
        }catch(Exception e){
            throw new Exception("Error: " + e.getMessage());
        }finally{
            if(cnConexion != null){
                cnConexion.close();
            }
        }

        return resultado;
    }
    
    public List<SelectItem> obtCatalogoPermisos() throws CustomizerException{
                        
        List<SelectItem> lstResult = new ArrayList();

        try{
            
            DaoMaestroCatalogoImpl objDao = new DaoMaestroCatalogoImpl();
            List<Sic1general> lst = objDao.obtCatalogoPermisos();

            SelectItem si;
            for(Sic1general obj : lst){
                si = new SelectItem();
                si.setLabel(obj.getDesGeneral());
                si.setValue(obj.getIdGeneral());
                lstResult.add(si);
            }
            
        } catch(Exception ex){
            throw new CustomizerException(ex.getMessage());
        }

        return lstResult;
    }
    
}
