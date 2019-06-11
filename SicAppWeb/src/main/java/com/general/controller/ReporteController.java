/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.controller;

import com.general.service.ReporteServiceImpl;
import com.general.util.beans.RptPlantilla;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author emoreno
 */
@Named
@ManagedBean
//@ViewScoped
@SessionScoped
public class ReporteController implements Serializable{
    
    private PieChartModel pieModel;
    private List<RptPlantilla> lstRptPlantilla;
    private String strFecDesde;
    private String strFecHasta;
    
    @PostConstruct
    public void init() {
        //createPieModel2();
        lstRptPlantilla = new ArrayList<>();
    }

    public PieChartModel getPieModel() {
        return pieModel;
    }

    public void setPieModel(PieChartModel pieModel) {
        this.pieModel = pieModel;
    }

    public List<RptPlantilla> getLstRptPlantilla() {
        return lstRptPlantilla;
    }

    public void setLstRptPlantilla(List<RptPlantilla> lstRptPlantilla) {
        this.lstRptPlantilla = lstRptPlantilla;
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
    
    
    
    public void createPieModel2() {

        pieModel = new PieChartModel();
         
        try{
            HashMap<Integer, RptPlantilla> hmap = new HashMap<>();
            
            ReporteServiceImpl objService = new ReporteServiceImpl();
            hmap = objService.generarRptProcedimientoAtendidos();
            
            Set set = hmap.entrySet();
            Iterator iterator = set.iterator();            
            while(iterator.hasNext()) {
               Map.Entry mentry = (Map.Entry)iterator.next();
               System.out.print("key is: "+ mentry.getKey().toString() + " & Value is: ");
               System.out.println(mentry.getValue());               
               
                pieModel.set(((RptPlantilla)mentry.getValue()).getDesItem() , ((RptPlantilla)mentry.getValue()).getNumCantidad());
               
            }            
            
            pieModel.setTitle("Cantidad de expedientes atendidos por procedimiento");
            pieModel.setLegendPosition("e");
            //pieModel.setFill(false);
            //pieModel.setShowDataLabels(true);
            //pieModel.setDiameter(150);
            //pieModel.setShadow(false);
            pieModel.setShowDatatip(true);
            //show labels inside pie chart
            pieModel.setShowDataLabels(true);
            //show label text  as 'value' (numeric) , others are 'label', 'percent' (default). Only one can be used.
            pieModel.setDataFormat("value");
            //format: %d for 'value', %s for 'label', %d%% for 'percent'
            pieModel.setDataLabelFormatString("%dK");

        }catch(Exception ex){
            //throw new Exception(ex.getMessage());
        }
    }
    
    public void  listarExpedientesXResponsable() throws Exception{
        
        try {
            
            this.lstRptPlantilla = new ArrayList<>();
            ReporteServiceImpl objService = new ReporteServiceImpl();
            this.lstRptPlantilla = objService.listarExpedientesXResponsable(this.strFecDesde, this.strFecHasta);

        } catch (Exception e){
            throw new Exception("generarRptExpedientesXResponsable()-ERROR:" + e.getMessage());
        }
    }
    
    
    public void  objResumenExpedientesEnEvaluacionXFuncionario() throws Exception{
        
        try {
            
            this.lstRptPlantilla = new ArrayList<>();
            ReporteServiceImpl objService = new ReporteServiceImpl();
            this.lstRptPlantilla = objService.objResumenExpedientesEnEvaluacionXFuncionario(this.strFecDesde, this.strFecHasta);

        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    
    
    
    
    /**
     * METODO QUE LISTA TODOS LOS EXPEDIENTES
     * @param item
     * @return
     * @throws Exception 
     */
    public String obtListaExpedientes(RptPlantilla item, String codEstaEven) throws Exception{
        
        String desTitulo = "Lista de Expedientes: Responsable: " + item.getDesFuncionario() + " => Procedimiento:" + item.getDesProcedimiento() + " => Fechas: " + strFecDesde + " - " + strFecHasta;
        
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().put("eventoController", null);
        EventoController objController = context.getApplication().evaluateExpressionGet(context, "#{eventoController}", EventoController.class);
        
        objController.setStrFecDesde(this.strFecDesde);
        objController.setStrFecHasta(this.strFecHasta);
        objController.setCodEstaEven(codEstaEven);
        
        String[] arrIdFuncResp = new String[1];
        arrIdFuncResp[0] = item.getIdFuncionario().toString();
        
        String[] arrIdProcedimientos = new String[1];
        arrIdProcedimientos[0] = item.getIdProcedimiento().toString();
        
        objController.setSelectedFuncResp(arrIdFuncResp);
        objController.setSelectedSubClaseEvento(arrIdProcedimientos);
        objController.setDesTitulopagina(desTitulo);
        objController.setFlgActivarFiltro(false);
        objController.buscarExpediente();
        
        return "listarExpedientes?faces-redirect=true";
        
    }
}
