/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.util.beans;

/**
 *
 * @author emoreno
 */
public class ComprobantePago {
 
    private String numComprobante;
    private String desLocauri;
    private String desNombreal;

    public String getNumComprobante() {
        return numComprobante;
    }

    public void setNumComprobante(String numComprobante) {
        this.numComprobante = numComprobante;
    }
    
    /**
     * @return the desLocauri
     */
    public String getDesLocauri() {
        return desLocauri;
    }

    /**
     * @param desLocauri the desLocauri to set
     */
    public void setDesLocauri(String desLocauri) {
        this.desLocauri = desLocauri;
    }

    /**
     * @return the desNombreal
     */
    public String getDesNombreal() {
        return desNombreal;
    }

    /**
     * @param desNombreal the desNombreal to set
     */
    public void setDesNombreal(String desNombreal) {
        this.desNombreal = desNombreal;
    }
    
    
    
    
}
