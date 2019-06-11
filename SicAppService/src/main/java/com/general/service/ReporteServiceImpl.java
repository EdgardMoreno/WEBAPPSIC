/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.service;

import com.general.dao.DaoReporteImpl;
import com.general.util.beans.RptPlantilla;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author emoreno
 */
public class ReporteServiceImpl {
    
    public HashMap<Integer, RptPlantilla> generarRptProcedimientoAtendidos() throws Exception{
        
        HashMap<Integer, RptPlantilla> hmap = new HashMap<>();
        try{
            DaoReporteImpl objDao = new DaoReporteImpl();
            hmap = objDao.generarRptProcedimientoAtendidos();
            
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
        
        return hmap;
        
    }
    
    /**
     * METODO QUE LISTA LA CANTIDAD DE EXPEDIENTES EN TRAMITES Y RESUELTOS POR FUNCIONARIO
     * @param fecDesde
     * @param fecHasta
     * @return
     * @throws Exception 
     */
    public List<RptPlantilla>  listarExpedientesXResponsable(String strFecDesde, String strFecHasta) throws Exception{
        
        List<RptPlantilla> lstResult = new ArrayList<>();
                
        try {
            
            DaoReporteImpl objDao = new DaoReporteImpl();
            lstResult = objDao.listarExpedientesXResponsable(strFecDesde, strFecHasta);
            
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
        
        return lstResult;
    }
    
    /**
     * METODO QUE LISTA LA CANTIDAD DE EXPEDIENTES QUE TIENE CADA FUNCIONARIO EN SU BANDEJA DEL BPM
     * @param fecDesde
     * @param fecHasta
     * @return
     * @throws Exception 
     */
    public List<RptPlantilla>  objResumenExpedientesEnEvaluacionXFuncionario(String strFecDesde, String strFecHasta) throws Exception{
        
        List<RptPlantilla> lstResult = new ArrayList<>();

        try {
            
            DaoReporteImpl objDao = new DaoReporteImpl();
            lstResult = objDao.objResumenExpedientesEnEvaluacionXFuncionario(strFecDesde, strFecHasta);
            
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
        
        return lstResult;
    }
    
}
