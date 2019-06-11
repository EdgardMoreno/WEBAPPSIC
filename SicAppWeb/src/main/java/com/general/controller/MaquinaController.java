/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.controller;

import com.general.entity.Sic1codiauto;
import com.general.entity.Sic1even;
import com.general.entity.Sic1pers;
import com.general.entity.Sic1proditem;
import com.general.entity.Sic3proditempers;
import com.general.service.MaquinaServiceImpl;
import com.general.service.PersonaServiceImpl;
import com.general.util.MessageUtil;
import com.general.util.exceptions.ValidationException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

/**
 *
 * @author emoreno
 */
@Named
@ManagedBean
@SessionScoped
public class MaquinaController implements Serializable{
    
    private List<Sic3proditempers> lstMaquinas;
    private List<Sic1pers> lstPersonas;
    private String desNombrepers;
    private String codIdenpers;
    private String numSerie;
    private String codCodiauto;
    private String codRegimode;
    private String codIdenmode;
    private String codExpe;
    private Integer idSala;
    private String desTitulopagina;

    public List<Sic3proditempers> getLstMaquinas() {
        return lstMaquinas;
    }

    public void setLstMaquinas(List<Sic3proditempers> lstMaquinas) {
        this.lstMaquinas = lstMaquinas;
    }

    public List<Sic1pers> getLstPersonas() {
        return lstPersonas;
    }

    public void setLstPersonas(List<Sic1pers> lstPersonas) {
        this.lstPersonas = lstPersonas;
    }

    public String getDesNombrepers() {
        return desNombrepers;
    }

    public void setDesNombrepers(String desNombrepers) {
        this.desNombrepers = desNombrepers;
    }

    public String getCodIdenpers() {
        return codIdenpers;
    }

    public void setCodIdenpers(String codIdenpers) {
        this.codIdenpers = codIdenpers;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public String getCodCodiauto() {
        return codCodiauto;
    }

    public void setCodCodiauto(String codCodiauto) {
        this.codCodiauto = codCodiauto;
    }

    public String getCodExpe() {
        return codExpe;
    }

    public void setCodExpe(String codExpe) {
        this.codExpe = codExpe;
    }

    public Integer getIdSala() {
        return idSala;
    }

    public void setIdSala(Integer idSala) {
        this.idSala = idSala;
    }

    public String getDesTitulopagina() {
        return desTitulopagina;
    }

    public void setDesTitulopagina(String desTitulopagina) {
        this.desTitulopagina = desTitulopagina;
    }

    public String getCodRegimode() {
        return codRegimode;
    }

    public void setCodRegimode(String codRegimode) {
        this.codRegimode = codRegimode;
    }

    public String getCodIdenmode() {
        return codIdenmode;
    }

    public void setCodIdenmode(String codIdenmode) {
        this.codIdenmode = codIdenmode;
    }

   
    
       
    public void buscarAdministrado() throws Exception{
                
        String strDesPers = this.desNombrepers;
        
        System.out.println("strDesPers:" + strDesPers);
        
        if(this.lstMaquinas != null)
            this.lstMaquinas.clear();
        
        if(lstPersonas!= null)
            lstPersonas.clear();

        if (strDesPers!= null && strDesPers.trim().length() > 2){
            
            PersonaServiceImpl objService = new PersonaServiceImpl();
            lstPersonas = objService.obtAdministradoXNombre(strDesPers);
            System.out.println("Cantidad: " + lstPersonas.size());
            
            if (lstPersonas.isEmpty())
                MessageUtil.addErrorMessage("No se obtuvieron resultados");
            
        }else{
            MessageUtil.addErrorMessage("Debe ingresar el administrado");
        }
    }
    
    public void seleccionarPersona(Sic1pers sic1pers) throws Exception{     
        
        if(this.lstMaquinas != null)
            this.lstMaquinas.clear();
        
        this.lstPersonas.clear();
        this.desNombrepers = sic1pers.getDesPers();
        this.codIdenpers = sic1pers.getSic1idenpers().getSic1idenpersPK().getCodIden();
        MaquinaServiceImpl objService = new MaquinaServiceImpl();
        lstMaquinas = objService.obtMaquinasXAdmi(sic1pers.getIdPers().intValue());
        System.out.println("");
        
    }
    
    public void buscarMaquinas() throws Exception{
        
        try{
        
            if(     (idSala != null && idSala > 0) ||
                    (numSerie != null && numSerie.trim().length() > 0) ||
                    (codCodiauto != null && codCodiauto.trim().length() > 0) ||
                    (codExpe != null && codExpe.trim().length() > 0) ||
                    (codRegimode != null && codRegimode.trim().length() > 0) ||
                    (codIdenmode != null && codIdenmode.trim().length() > 0)){

                if(this.lstMaquinas != null)
                    this.lstMaquinas.clear();

                if(this.lstPersonas != null)
                    this.lstPersonas.clear();


                if (codIdenmode !=null && codIdenmode.trim().length() > 0 && codIdenmode.trim().length() < 3){
                    throw new ValidationException("Para buscar por el CODIGO DE IDENTIFICACION DEL MODELO, se debe ingresar como mínimo 3 caracteres.");
                }


                Sic1even sic1even = new Sic1even();
                sic1even.setCodExpe(this.codExpe);
                Sic1codiauto sic1codiauto = new Sic1codiauto();
                sic1codiauto.setSic1even(sic1even);
                if (idSala != null)
                    sic1codiauto.setIdSala(new BigDecimal(this.idSala));

                Sic1proditem objMaq = new Sic1proditem();
                objMaq.setNumSerie(this.numSerie);
                objMaq.setCodCodiauto(this.codCodiauto);            
                objMaq.setCodRegimode(this.codRegimode);
                objMaq.setCodIdenmode(this.codIdenmode);
                objMaq.setSic1codiauto(sic1codiauto);

                MaquinaServiceImpl objService = new MaquinaServiceImpl();
                lstMaquinas = objService.obtMaquinasAutorizadasYTramite(objMaq);

                if (lstMaquinas.isEmpty())
                    MessageUtil.addErrorMessage("No se obtuvieron resultados");

            }else{

                MessageUtil.addErrorMessage("Debe ingresar algún criterio de búsqueda");
            }
            
        }catch(ValidationException ex){
            MessageUtil.addErrorMessage(ex.getMessage());
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }        
    }
}