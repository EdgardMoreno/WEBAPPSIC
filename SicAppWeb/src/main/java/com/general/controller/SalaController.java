/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.controller;

import com.general.service.SalaServiceImpl;
import com.general.util.MessageUtil;
import com.general.views.ViComsala;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author emoreno
 */
@Named
@ManagedBean
@SessionScoped
public class SalaController implements Serializable{
    
    private List<ViComsala> lstSalas;    
    private String desPersAdmi;
    private String codCodAutoSala;
    private String codExpe;
    private String desSala;

    public List<ViComsala> getLstSalas() {
        return lstSalas;
    }

    public void setLstSalas(List<ViComsala> lstSalas) {
        this.lstSalas = lstSalas;
    }

    public String getDesPersAdmi() {
        return desPersAdmi;
    }

    public void setDesPersAdmi(String desPersAdmi) {
        this.desPersAdmi = desPersAdmi;
    }

    public String getCodCodAutoSala() {
        return codCodAutoSala;
    }

    public void setCodCodAutoSala(String codCodAutoSala) {
        this.codCodAutoSala = codCodAutoSala;
    }

    public String getCodExpe() {
        return codExpe;
    }

    public void setCodExpe(String codExpe) {
        this.codExpe = codExpe;
    }

    public String getDesSala() {
        return desSala;
    }

    public void setDesSala(String desSala) {
        this.desSala = desSala;
    }    
         
    public void buscarSalas() throws Exception{        
        
            if(this.lstSalas != null)
                this.lstSalas.clear();
            
            ViComsala viSala = new ViComsala();
            viSala.setNomEmpres(desPersAdmi);
            viSala.setNomSala(desSala);
            viSala.setCodSala(codCodAutoSala);
            viSala.setExpediente(codExpe);            
            

            SalaServiceImpl objService = new SalaServiceImpl();
            this.lstSalas = objService.obtSalas(viSala);
            
            if (lstSalas.isEmpty())
                MessageUtil.addInfoMessage("No se obtuvieron resultados");            
       
    }
    
     public void limpiar(){
        
        this.codExpe = null;
        this.desPersAdmi = null;
        this.codCodAutoSala = null;
        this.lstSalas = new ArrayList<>();
        
    }
     
    public String verDetalleMaquinas(ViComsala item) throws Exception{
        
        System.out.println("ID_SALA: " + item.getIdSala());
        
        String desTitulo = "DETALLE MAQUINAS EN SALA: " + item.getNomSala();
        
        FacesContext context = FacesContext.getCurrentInstance();
        /*Se limpia el objeto "orderController" que se tenga en el FACESCONTEXT*/
        context.getExternalContext().getSessionMap().put("maquinaController", null);
        /*Se instancia y crear el objecto "orderController" */
        MaquinaController objController = context.getApplication().evaluateExpressionGet(context, "#{maquinaController}", MaquinaController.class);
        objController.setIdSala(item.getIdSala());
        objController.setDesTitulopagina(desTitulo);
        objController.buscarMaquinas();
        
        return "listarMaquinas?faces-redirect=true";
        
    }
    
    public String verDetalleMemorias(ViComsala item) throws Exception{
        
        System.out.println("ID_SALA: " + item.getIdSala());
        
        String desTitulo = "DETALLE MEMORIAS EN SALA: " + item.getNomSala();
        
        FacesContext context = FacesContext.getCurrentInstance();        
        context.getExternalContext().getSessionMap().put("memoriaController", null);        
        MemoriaController objController = context.getApplication().evaluateExpressionGet(context, "#{memoriaController}", MemoriaController.class);
        objController.setIdSala(item.getIdSala());
        objController.setDesTitulopagina(desTitulo);
        objController.buscarMemorias();
        
        return "listarMemorias?faces-redirect=true";
        
    } 
    
    public String verDetalleJuegosCasino(ViComsala item) throws Exception{
        
        System.out.println("ID_SALA: " + item.getIdSala());
        
        String desTitulo = "DETALLE JUEGOS DE CASINO EN SALA: " + item.getNomSala();
        
        FacesContext context = FacesContext.getCurrentInstance();        
        context.getExternalContext().getSessionMap().put("juegoCasinoController", null);        
        JuegoCasinoController objController = context.getApplication().evaluateExpressionGet(context, "#{juegoCasinoController}", JuegoCasinoController.class);
        objController.setIdSala(item.getIdSala());
        objController.setDesTitulopagina(desTitulo);
        objController.buscarJuegosCasino();
        
        return "listarJuegosCasino?faces-redirect=true";
        
    } 
     
}