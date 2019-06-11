/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.controller;

import com.general.entity.Sic3prodpers;
import com.general.service.JuegoCasinoServiceImpl;
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
public class JuegoCasinoController implements Serializable{
    
    private List<Sic3prodpers> lstJuegosCasino;    
    private Integer idSala;
    private String desTitulopagina;

    public List<Sic3prodpers> getLstJuegosCasino() {
        return lstJuegosCasino;
    }

    public void setLstJuegosCasino(List<Sic3prodpers> lstJuegosCasino) {
        this.lstJuegosCasino = lstJuegosCasino;
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
    
    public void buscarJuegosCasino() throws Exception{
                       
        if(this.lstJuegosCasino != null)
            this.lstJuegosCasino.clear();

        JuegoCasinoServiceImpl objService = new JuegoCasinoServiceImpl();
        lstJuegosCasino = objService.obtJuegosCasinoXSala(this.idSala);

        if (lstJuegosCasino.isEmpty())
            MessageUtil.addErrorMessage("No se obtuvieron resultados");
            
        
    }
}