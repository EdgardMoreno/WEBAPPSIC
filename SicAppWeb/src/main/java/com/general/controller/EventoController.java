/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.controller;

import com.general.entity.Sic1even;
import com.general.entity.Sic1ideneven;
import com.general.entity.Sic1pers;
import com.general.entity.Sic1sclaseeven;
import com.general.entity.Sic3evendocu;
import com.general.entity.Sic3evenesta;
import com.general.entity.Sic3evenestaPK;
import com.general.entity.Sic5evenesta;
import com.general.service.DocumentoServiceImpl;
import com.general.service.EventoServiceImpl;
import com.general.service.MaestroCatalogoServiceImpl;
import com.general.service.PersonaServiceImpl;
import com.general.service.SubClaseEventoServiceImpl;
import com.general.util.MessageUtil;
import com.general.util.beans.ConstantesSic;
import com.general.util.beans.UtilClass;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.model.SelectItem;
import javax.inject.Named;


/**
 *
 * @author emoreno
 */
@Named
@ManagedBean
//@ViewScoped
@SessionScoped
public class EventoController  implements Serializable{
    
//    @ManagedProperty("#{param.idEvenParam}")
    private String idEvenParam;
    
    private Sic1even evento;    
    private List<SelectItem> lstSubClaseEvento;
    private List<Sic1even> lstEventos;
    private List<Sic1even> lstDetEvento;
    private List<Sic3evendocu> lstDetDocumentos;
    private List<Sic5evenesta> lstDetEventoTareas;
    private String codExpe;    
    private Integer idEvenExterno;
    private String desPersAdmi;
    private String[] selectedFuncResp;
    private String[] selectedSubClaseEvento;
    private List<SelectItem> lstItemsFuncResp;
    private String desUrlPWA;
    private Integer idPersAdmi;
    private String desTitulopagina;
    private String strFecDesde;
    private String strFecHasta;
    private String codEstaEven;
    private boolean flgActivarFiltro;
    private Integer idEstaEven;
    
    
    /*PROPIEDADES*/
    
    public Sic1even getEvento() {
        return evento;
    }

    public void setEvento(Sic1even evento) {
        this.evento = evento;
    }

    public String[] getSelectedSubClaseEvento() {
        return selectedSubClaseEvento;
    }

    public void setSelectedSubClaseEvento(String[] selectedSubClaseEvento) {
        this.selectedSubClaseEvento = selectedSubClaseEvento;
    }

    public List<SelectItem> getLstSubClaseEvento() {
        return lstSubClaseEvento;
    }

    public void setLstSubClaseEvento(List<SelectItem> lstSubClaseEvento) {
        this.lstSubClaseEvento = lstSubClaseEvento;
    }

    public List<Sic1even> getLstEventos() {
        return lstEventos;
    }

    public void setLstEventos(List<Sic1even> lstEventos) {
        this.lstEventos = lstEventos;
    }

    public String getCodExpe() {
        return codExpe;
    }

    public void setCodExpe(String codExpe) {
        this.codExpe = codExpe;
    }
    
    public String[] getSelectedFuncResp() {
        return selectedFuncResp;
    }

    public void setSelectedFuncResp(String[] selectedFuncResp) {
        this.selectedFuncResp = selectedFuncResp;
    }

    public String getDesPersAdmi() {
        return desPersAdmi;
    }

    public void setDesPersAdmi(String desPersAdmi) {
        this.desPersAdmi = desPersAdmi;
    }    

    public List<SelectItem> getLstItemsFuncResp() {
        return lstItemsFuncResp;
    }

    public void setLstItemsFuncResp(List<SelectItem> lstItemsFuncResp) {
        this.lstItemsFuncResp = lstItemsFuncResp;
    }

    public List<Sic3evendocu> getLstDetDocumentos() {
        return lstDetDocumentos;
    }

    public void setLstDetDocumentos(List<Sic3evendocu> lstDetDocumentos) {
        this.lstDetDocumentos = lstDetDocumentos;
    }

    public List<Sic5evenesta> getLstDetEventoTareas() {
        return lstDetEventoTareas;
    }

    public void setLstDetEventoTareas(List<Sic5evenesta> lstDetEventoTareas) {
        this.lstDetEventoTareas = lstDetEventoTareas;
    }    

    public String getIdEvenParam() {
        return idEvenParam;
    }

    public void setIdEvenParam(String idEvenParam) {
        this.idEvenParam = idEvenParam;
    }

    public List<Sic1even> getLstDetEvento() {
        return lstDetEvento;
    }

    public void setLstDetEvento(List<Sic1even> lstDetEvento) {
        this.lstDetEvento = lstDetEvento;
    }

    public String getDesUrlPWA() {
        return desUrlPWA;
    }

    public void setDesUrlPWA(String desUrlPWA) {
        this.desUrlPWA = desUrlPWA;
    }

    public Integer getIdPersAdmi() {
        return idPersAdmi;
    }

    public void setIdPersAdmi(Integer idPersAdmi) {
        this.idPersAdmi = idPersAdmi;
    }    

    public Integer getIdEvenExterno() {
        return idEvenExterno;
    }

    public void setIdEvenExterno(Integer idEvenExterno) {
        this.idEvenExterno = idEvenExterno;
    }

    public String getDesTitulopagina() {
        return desTitulopagina;
    }

    public void setDesTitulopagina(String desTitulopagina) {
        this.desTitulopagina = desTitulopagina;
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

    public String getCodEstaEven() {
        return codEstaEven;
    }

    public void setCodEstaEven(String codEstaEven) {
        this.codEstaEven = codEstaEven;
    }

    public boolean isFlgActivarFiltro() {
        return flgActivarFiltro;
    }

    public void setFlgActivarFiltro(boolean flgActivarFiltro) {
        this.flgActivarFiltro = flgActivarFiltro;
    }

    public Integer getIdEstaEven() {
        return idEstaEven;
    }

    public void setIdEstaEven(Integer idEstaEven) {
        this.idEstaEven = idEstaEven;
    }

    
    
    
    
    
    
    /*************************************/
    /**** METODOS *****/
    /*************************************/
    
   
    public EventoController(){
         if(!FacesContext.getCurrentInstance().isPostback()){
             System.out.println("Aqui");
         }
         
//         HttpServletRequest origRequest = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
//         String url = origRequest.getRequestURL().toString();
//         System.out.println("RequestURI:" + origRequest.getRequestURI());    
//         System.out.println("RequestURL:" + url);
//         System.out.println(url.substring(0, url.length() - origRequest.getRequestURI().length()) + origRequest.getContextPath() + "/");         
       
         System.out.println("afuera");
    }
    
    @PostConstruct
    public void init()  {
        
        try{
            
            //lstEventos = new ArrayList<>();
            
//            HttpServletRequest origRequest = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
//         String url = origRequest.getRequestURL().toString();
//         System.out.println("RequestURI:" + origRequest.getRequestURI());
//         System.out.println("RequestURL:" + url);
//         System.out.println(url.substring(0, url.length() - origRequest.getRequestURI().length()) + origRequest.getContextPath() + "/");
            
            SubClaseEventoServiceImpl obj = new SubClaseEventoServiceImpl();
            this.lstSubClaseEvento = obj.obtSubClaseEventoAgrupado();
            
            PersonaServiceImpl objPersService = new PersonaServiceImpl();
            lstItemsFuncResp = objPersService.obtFuncionariosAgrupado();
            
            if(this.desTitulopagina == null || this.desTitulopagina.trim().length() == 0)
               this.desTitulopagina = "REPORTE DE EXPEDIENTE";
            
            this.setFlgActivarFiltro(true);
        
        }catch(Exception e){
            System.out.println("Error:" + e.getMessage());
        }    
    }
    
    public void limpiar(){
        
        this.codExpe = null;
        this.desPersAdmi = null;
        this.selectedFuncResp = new String[0];
        this.selectedSubClaseEvento = new String[0];
        this.strFecDesde = null;
        this.strFecHasta = null;
        this.idEstaEven = -1;
        lstEventos = new ArrayList<>();
        
    }
    
    public void buscarExpediente() throws Exception{
        
        
        if(selectedSubClaseEvento.length==0 && 
                (desPersAdmi==null || desPersAdmi.isEmpty()) &&
                (codExpe==null || codExpe.isEmpty()) &&
                selectedFuncResp.length==0 && 
                (strFecDesde==null || strFecDesde.isEmpty()) &&
                (strFecHasta==null || strFecHasta.isEmpty()) &&
                idEstaEven==-1){
            MessageUtil.addErrorMessage("Se debe ingresar algún filtro.");
        }else{
            
            //Lista de Funcionarios seleccionados
            Sic1pers objFuncResp = new Sic1pers();
            if(selectedFuncResp.length > 0){
                objFuncResp.setArrIdpers(selectedFuncResp);
            }

            //Datos Administrado
            Sic1pers objAdmi = new Sic1pers();
            objAdmi.setDesPers(desPersAdmi!=null?desPersAdmi.trim():null);
            
            Sic1ideneven objIdeneven = new Sic1ideneven();
            objIdeneven.setSic1pers(objAdmi);

            //Datos del Evento
            Sic1even objEven = new Sic1even();
            Sic1sclaseeven objSclaseeven = new Sic1sclaseeven();        
            
            //Lista de Procedimientos seleccionados
            if(this.selectedSubClaseEvento.length >0 )
                objSclaseeven.setArrIdSclaseeven(this.selectedSubClaseEvento);

            objEven.setIdSclaseeven(objSclaseeven);
            objEven.setCodExpe(this.codExpe);
            objEven.setSic1ideneven(objIdeneven);
            objEven.setSic1persfuncresp(objFuncResp);        

            /*ESTADO DEL EVENTO*/
            Sic3evenestaPK objEvenestaPK = new Sic3evenestaPK();
            if(!this.strFecDesde.isEmpty())
                objEvenestaPK.setFecDesde(UtilClass.convertStringToDate(this.strFecDesde));
            objEvenestaPK.setIdEstaeven(this.idEstaEven);

            Sic3evenesta objEvenesta = new Sic3evenesta();
            if(!this.strFecHasta.isEmpty())
                objEvenesta.setFecHasta(UtilClass.convertStringToDate(this.strFecHasta));
            objEvenesta.setCodEstaeven(this.codEstaEven);
            objEvenesta.setSic3evenestaPK(objEvenestaPK);
            objEven.setSic3evenesta(objEvenesta);
            /**/

            EventoServiceImpl objService = new EventoServiceImpl();
            this.lstEventos = objService.obtExpedientes(objEven);

            if (this.lstEventos.isEmpty())
                MessageUtil.addInfoMessage("No se obtuvieron resultados");
            
        }
    }    
    
    public String obtenerSubEventos(String codExpeLocal ) throws Exception{
             
                
        this.lstDetEvento = new ArrayList<>();
        this.lstDetDocumentos = new ArrayList<>();
        this.lstDetEventoTareas = new ArrayList<>();
        
        //-- obtener los eventos relacionados.
        EventoServiceImpl objService = new EventoServiceImpl();       
        this.lstDetEvento = objService.obtEventosRelacionados(codExpeLocal);
        
        if(this.lstDetEvento!= null && this.lstDetEvento.isEmpty()){
            MessageUtil.addInfoMessage("No se pudo obtener detalle del expediente.");
            return "";
        }
        
        this.idPersAdmi = this.lstDetEvento.get(0).getSic1persadmi().getIdPers().intValue();
        this.idEvenExterno = null;
        
        
        /*Obtener el seguimiento del expediente*/
        //this.lstDetEventoTareas = objService.obtTareasEvento(idEven);

        /*Obtener documentos relacionados*/
//        DocumentoServiceImpl objDocuService = new DocumentoServiceImpl();
//        this.lstDetDocumentos = objDocuService.obtDocumentosXEvento(idEven);

        this.obtenerDetalleEvento(this.lstDetEvento.get(0));
        
        MaestroCatalogoServiceImpl objMaeCataService = new MaestroCatalogoServiceImpl();
        this.desUrlPWA = objMaeCataService.obtUrlPWA(ConstantesSic.CONS_COD_VERSUDM_URLPWA);
        
        System.out.println("desUrlPWA: " + this.desUrlPWA);
        
        return "faces/detalleExpediente?faces-redirect=true";
        //return "faces/detalleExpediente?cod_expe=" + idEven;
    }
    
    public void obtenerDetalleEvento(Sic1even objEven) throws Exception{
        
        try{
            
            this.lstDetDocumentos = new ArrayList<>();
            this.lstDetEventoTareas = new ArrayList<>();
            
            Integer idEven = objEven.getIdEven().intValue();
            Integer idEvenPadre = objEven.getIdEventopadre().intValue();
            
            /*Obtener el seguimiento del expediente*/
            EventoServiceImpl objService = new EventoServiceImpl();
            this.lstDetEventoTareas = objService.obtTareasEvento(idEven);

            /*Obtener documentos relacionados*/
              DocumentoServiceImpl objDocuService = new DocumentoServiceImpl();
            
            if(Objects.equals(idEven, idEvenPadre)){
                /*Obtener los requisitos*/
                this.lstDetDocumentos = objDocuService.obtDocumentosXEvento(idEven);

            }else{
                
                /*En caso los eventos sean diferentes se obtiene los requisitos del evento padre*/                
                this.lstDetDocumentos.addAll(objDocuService.obtDocuSustentoXEvento(idEven));
                this.lstDetDocumentos.addAll(objDocuService.obtDocuGeneTramiteXEvento(idEven));
                this.lstDetDocumentos.addAll(objDocuService.obtRequisitosXEvento(idEvenPadre));
            }
            
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
        
    }
    
    /*Utilizado para obtener los parametros enviados desde una aplicacion externa, desde la url con 
      formato: http://localhost:27961/SicAppWeb/faces/listarExpedientes.xhtml?evento=123546*/
    public void getParamsExternalPage(ComponentSystemEvent event) throws Exception{
        
        System.out.println("idEvenExterno:" + this.idEvenExterno);
        
        if( this.idEvenExterno!=null && this.idEvenExterno > 0){
            
//            FacesContext context = FacesContext.getCurrentInstance();        
//            context.getExternalContext().getSessionMap().put("eventoController", null);

            this.lstDetEvento = new ArrayList<>();
            this.lstDetDocumentos = new ArrayList<>();
            this.lstDetEventoTareas = new ArrayList<>();

            //---------------
            EventoServiceImpl objService = new EventoServiceImpl();
            Sic1even objEven = new Sic1even();
            objEven.setIdEven(new BigDecimal(idEvenExterno));
            this.lstDetEvento = objService.obtExpedientes(objEven);
            
            if (this.lstDetEvento.size() > 0 ){
                
                this.idPersAdmi = this.lstDetEvento.get(0).getSic1ideneven().getIdPers().intValue();

                /*Obtener el seguimiento del expediente*/
                this.lstDetEventoTareas = objService.obtTareasEvento(idEvenExterno);

                /*Obtener documentos relacionados*/
                DocumentoServiceImpl objDocuService = new DocumentoServiceImpl();
                this.lstDetDocumentos = objDocuService.obtDocumentosXEvento(idEvenExterno);

                MaestroCatalogoServiceImpl objMaeCataService = new MaestroCatalogoServiceImpl();
                this.desUrlPWA = objMaeCataService.obtUrlPWA(ConstantesSic.CONS_COD_VERSUDM_URLPWA);

                System.out.println("desUrlPWA: " + this.desUrlPWA);
                
            }
        }        
    }
}
