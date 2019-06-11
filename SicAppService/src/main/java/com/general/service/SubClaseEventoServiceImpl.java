/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.service;

import com.general.dao.DaoSubClaseEventoImpl;
import com.general.entity.Sic1sclaseeven;
import com.general.util.ConexionBD;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

/**
 *
 * @author emoreno
 */
public class SubClaseEventoServiceImpl {
    
    public List<SelectItem> obtSubClaseEventoAgrupado() throws Exception{
        
        Connection cnConexion = null;
        List<SelectItem> listObj = new ArrayList<>();

        try{
            cnConexion = ConexionBD.obtConexion();
            DaoSubClaseEventoImpl objDao = new DaoSubClaseEventoImpl();
            List<Sic1sclaseeven> lista = objDao.obtTodos(cnConexion, new Sic1sclaseeven());
            
            int idGrupoTmp = 0;                        
            SelectItemGroup objItemGroup;
            SelectItem si;
            List<SelectItem> lstItems;
            Sic1sclaseeven element = null;
            boolean lSiguiente = false;
            
            Iterator itr = lista.iterator();
            
             if(itr.hasNext()){
                lSiguiente = itr.hasNext();                    
                element = (Sic1sclaseeven)itr.next();
            }
            
            while(lSiguiente) {                
                
                objItemGroup = new SelectItemGroup(element.getDesSgrupsclaseeven());
                
//                System.out.println("idSgrupo:" + element.getIdSgrupsclaseeven());
//                System.out.println("--> id: " + element.getIdSclaseeven() + " -> " + element.getDesSclaseeven());
                
                lstItems = new ArrayList<>();
                si = new SelectItem();
                si.setLabel(element.getDesSclaseeven());
                si.setValue(element.getIdSclaseeven());
                lstItems.add(si);
                
                idGrupoTmp = element.getIdSgrupsclaseeven();
                
                if(itr.hasNext()){
                    lSiguiente = itr.hasNext();
                    element = (Sic1sclaseeven)itr.next();
                }
                else{
                    lSiguiente = false;
                    continue;
                }
                //element = itr.hasNext()?(Sic1sclaseeven)itr.next():null;
                while(lSiguiente && idGrupoTmp == element.getIdSgrupsclaseeven()){
                        
//                    System.out.println("--> id: " + element.getIdSclaseeven() + " -> " + element.getDesSclaseeven());

                    si = new SelectItem();
                    si.setLabel(element.getDesSclaseeven());
                    si.setValue(element.getIdSclaseeven());
                    lstItems.add(si);                        
                    
                    if(itr.hasNext()){
                        lSiguiente = itr.hasNext();
                        element = (Sic1sclaseeven)itr.next();
                    }
                    else{
                        lSiguiente = false;
                        continue;
                    }
                }
                
                objItemGroup.setSelectItems(lstItems.toArray(new SelectItem[0]));
                listObj.add(objItemGroup);
            }
            
        }catch(Exception e){
            throw new Exception("Error: " + e.getMessage());
        }finally{
            if(cnConexion != null){
                cnConexion.close();
            }
        }

        return listObj;
    }
    
    
}
