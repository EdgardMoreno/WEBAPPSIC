/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.controller;

import com.general.entity.Sic5persperm;
import com.general.entity.Sic5perspermPK;
import com.general.service.MaestroCatalogoServiceImpl;
import com.general.service.PersonaServiceImpl;
import com.general.util.MessageUtil;
import com.general.util.beans.ConstantesSic;
import com.general.util.beans.UtilClass;
import com.general.util.exceptions.ValidationException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

/**
 *
 * @author emoreno
 */
@Named
@ManagedBean
@ViewScoped
public class FuncionarioController implements Serializable{
    
    private Sic5persperm objPermiso;
    private String strFecDesde;
    private String strFecHasta;
    private List<SelectItem> itemPermisos  = new ArrayList();
    private List<SelectItem> itemFuncionarios  = new ArrayList();
    
    

    public Sic5persperm getObjPermiso() {
        return objPermiso;
    }

    public void setObjPermiso(Sic5persperm objPermiso) {
        this.objPermiso = objPermiso;
    }    

    public String getStrFecDesde() {
        return strFecDesde;
    }

    public void setStrFecDesde(String strFecDesde) {
        this.strFecDesde = strFecDesde;
    }

    public String getStrFecHasta() {
        return strFecHasta;
    }

    public void setStrFecHasta(String strFecHasta) {
        this.strFecHasta = strFecHasta;
    }

    public List<SelectItem> getItemPermisos() {
        return itemPermisos;
    }

    public void setItemPermisos(List<SelectItem> itemPermisos) {
        this.itemPermisos = itemPermisos;
    }       

    public List<SelectItem> getItemFuncionarios() {
        return itemFuncionarios;
    }

    public void setItemFuncionarios(List<SelectItem> itemFuncionarios) {
        this.itemFuncionarios = itemFuncionarios;
    }
    
    
    
    @PostConstruct
    public void init()  {
        
        try{            
            
            Sic5perspermPK pK = new Sic5perspermPK();
            this.objPermiso = new Sic5persperm();
            this.objPermiso.setSic5perspermPK(pK);
            
            MaestroCatalogoServiceImpl objService = new MaestroCatalogoServiceImpl();
            this.itemPermisos = objService.obtCatalogoPermisos();
            
            PersonaServiceImpl persService = new PersonaServiceImpl();
            this.itemFuncionarios = persService.obtFuncionarios();           
                       
        
        }catch(Exception e){
            System.out.println("Error:" + e.getMessage());
        }    
    }
    
    public void grabarPermisoFunc() throws Exception{

        try{
            String strMensaje = null;
            
            if(this.objPermiso.getSic5perspermPK().getIdPers() == -1)
                strMensaje = "Debe seleccionar el Funcionario.";
            else if(this.objPermiso.getIdMotiperm() == -1)
                strMensaje = "Debe seleccionar tipo de permiso.";
            else if(this.strFecDesde == null || this.strFecDesde.trim().length() == 0 )
                strMensaje = "Debe ingresar la fecha desde.";
            else if(this.strFecHasta == null || this.strFecHasta.trim().length() == 0 )
                strMensaje = "Debe ingresar la fecha hasta.";
            else if(this.objPermiso.getDesPerm() == null || this.objPermiso.getDesPerm().trim().length() == 0 )
                strMensaje = "Debe ingresar la descripción del permiso.";
            
            if (strMensaje != null)
                throw new ValidationException(strMensaje);
            
            PersonaServiceImpl objService = new PersonaServiceImpl();
            this.objPermiso.setFecDesde(UtilClass.convertStringToDate(this.strFecDesde));
            this.objPermiso.setFecHasta(UtilClass.convertStringToDate(this.strFecHasta));
            
            objService.registrarPermisoFunc(this.objPermiso);
            
            this.objPermiso = new Sic5persperm();
            this.strFecDesde = null;
            this.strFecHasta = null;

            MessageUtil.addInfoMessage(ConstantesSic.CONS_SUCCESS_EMAIL_MESSAGE);
        
        }catch(ValidationException ex ){
            MessageUtil.addErrorMessage(ex.getMessage());
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
    
    
}
