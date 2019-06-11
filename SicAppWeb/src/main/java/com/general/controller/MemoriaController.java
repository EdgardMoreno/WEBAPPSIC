/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.controller;

import com.general.entity.Sic3prodpers;
import com.general.service.MemoriaServiceImpl;
import com.general.util.MessageUtil;
import java.io.Serializable;
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
public class MemoriaController implements Serializable{
    
    private List<Sic3prodpers> lstMemorias;    
    private Integer idSala;
    private String desTitulopagina;

    public List<Sic3prodpers> getLstMemorias() {
        return lstMemorias;
    }

    public void setLstMemorias(List<Sic3prodpers> lstMemorias) {
        this.lstMemorias = lstMemorias;
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
    
    public void buscarMemorias() throws Exception{
                       
        if(this.lstMemorias != null)
            this.lstMemorias.clear();

        MemoriaServiceImpl objService = new MemoriaServiceImpl();
        lstMemorias = objService.obtMemoriasXSala(this.idSala);

        if (lstMemorias.isEmpty())
            MessageUtil.addErrorMessage("No se obtuvieron resultados");
            
        
    }
}