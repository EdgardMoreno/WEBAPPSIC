/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.service;

import com.general.dao.DaoPersonaImpl;
import com.general.entity.Sic1pers;
import com.general.entity.Sic5persperm;
import com.general.util.ConexionBD;
import com.general.util.beans.ConstantesSic;
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
public class PersonaServiceImpl {
    
    
    public List<Sic1pers> obtAdministradoXNombre(String desPers) throws Exception{
        
        Connection cnConexion = null;
        List<Sic1pers> listObj = new ArrayList<>();

        try{            
            DaoPersonaImpl objDaoPersonaImpl = new DaoPersonaImpl();
            listObj = objDaoPersonaImpl.obtPersonasXNombre(ConstantesSic.CONS_COD_TROLADMINISTRADO ,desPers);
            
        }catch(Exception e){
            throw new Exception("Error: " + e.getMessage());
        }finally{
            if(cnConexion != null){
                cnConexion.close();
            }
        }

        return listObj;
    }
    
    public List<SelectItem> obtFuncionarios() throws Exception{        
        
        List<SelectItem> listObj = new ArrayList<>();

        try{
            
            DaoPersonaImpl objDao = new DaoPersonaImpl();
            List<Sic1pers> lista = objDao.obtFuncionarios(new Sic1pers());
            
            SelectItem si;
            for(Sic1pers obj : lista){
                
                si = new SelectItem();
                si.setLabel(obj.getSic7persrol().getSic7persrolPK().getDesTrolpers() + " - " + obj.getDesPers());
                si.setValue(obj.getIdPers());
                listObj.add(si);
            }
        
        }catch(Exception e){
            throw new Exception("Error: " + e.getMessage());
        }
        
        return listObj;
    }
    
    public List<SelectItem> obtFuncionariosAgrupado() throws Exception{        
        
        List<SelectItem> listObj = new ArrayList<>();

        try{
            
            DaoPersonaImpl objDao = new DaoPersonaImpl();
            List<Sic1pers> lista = objDao.obtFuncionarios(new Sic1pers());
            
            int idGrupoTmp = 0;                        
            SelectItemGroup objItemGroup;
            SelectItem si;
            List<SelectItem> lstItems;
            Sic1pers element = null;
            boolean lSiguiente = false;
            
            Iterator itr = lista.iterator();
            
             if(itr.hasNext()){
                lSiguiente = itr.hasNext();                    
                element = (Sic1pers)itr.next();
            }
            
            while(lSiguiente) {
                
                objItemGroup = new SelectItemGroup(element.getSic7persrol().getSic7persrolPK().getDesTrolpers());
                
//                System.out.println("idSgrupo:" + element.getSic7persrol().getSic7persrolPK().getIdTrolpers());
//                System.out.println("--> id: " + element.getIdPers()+ " -> " + element.getDesPers());
                
                lstItems = new ArrayList<>();
                si = new SelectItem();
                si.setLabel(element.getDesPers());
                si.setValue(element.getIdPers());
                lstItems.add(si);
                
                idGrupoTmp = element.getSic7persrol().getSic7persrolPK().getIdTrolpers();
                
                if(itr.hasNext()){
                    lSiguiente = itr.hasNext();
                    element = (Sic1pers)itr.next();
                }
                else{
                    lSiguiente = false;
                    continue;
                }
                //element = itr.hasNext()?(Sic1sclaseeven)itr.next():null;
                while(lSiguiente && idGrupoTmp == element.getSic7persrol().getSic7persrolPK().getIdTrolpers()){
                        
//                    System.out.println("--> id: " + element.getIdPers() + " -> " + element.getDesPers());

                    si = new SelectItem();
                    si.setLabel(element.getDesPers());
                    si.setValue(element.getIdPers());
                    lstItems.add(si);                        
                    
                    if(itr.hasNext()){
                        lSiguiente = itr.hasNext();
                        element = (Sic1pers)itr.next();
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
        }

        return listObj;
    }
    
    public void registrarPermisoFunc(Sic5persperm objPersperm) throws Exception{
        
        Connection cnConexion = null;        

        try{
            cnConexion = ConexionBD.obtConexion();
            DaoPersonaImpl objDaoPersonaImpl = new DaoPersonaImpl();
            objDaoPersonaImpl.registrarPermisoFunc(cnConexion, objPersperm);
            cnConexion.commit();
            
        }catch(Exception e){
            if(cnConexion != null)
                cnConexion.rollback();
            
            throw new Exception("Error: " + e.getMessage());            
        }finally{
            if(cnConexion != null){
                cnConexion.close();
            }
        }
        
    }
    
    
}
