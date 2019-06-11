/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author emoreno
 */
public class MessageUtil {
    
    public static void addInfoMessage(/*String summary,*/ String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", detail);
        FacesContext.getCurrentInstance().addMessage(null, message);        
    }
    
    public static void addErrorMessage(String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public static void addWarnMessage(String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia", detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
}
