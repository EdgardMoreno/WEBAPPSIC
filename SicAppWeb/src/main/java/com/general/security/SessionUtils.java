package com.general.security;

/**
 *
 * @author emoreno
 */

import com.general.entity.Sic1usuario;
import java.math.BigDecimal;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtils {

    public static HttpSession getSession() {
        return (HttpSession) FacesContext.getCurrentInstance()
                        .getExternalContext().getSession(false);//True: Si no existe la sesion, la crea.
                                                                //False: Obtiene la session existente, si no hay devuelve null.
    }

    public static HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.getCurrentInstance()
                        .getExternalContext().getRequest();
    }

    public static String getUserName() {
        String userName;
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        userName = ((Sic1usuario)session.getAttribute("user")).getCodUsuario();
        return userName;
    }
    
    public static String getUserCompleteName() {
        String value;                
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        value = ((Sic1usuario)session.getAttribute("user")).getSic1pers().getDesPers();
        return value;
    }

    public static BigDecimal getUserId() {
        BigDecimal userId;
        HttpSession session = getSession();
        if (session != null){
            userId = ((Sic1usuario)session.getAttribute("user")).getIdUsuario();
            return userId;
        }
        else
            return null;
    }    
       
    
    public static String getCodTRolPers() {
        String val;
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        val = ((Sic1usuario)session.getAttribute("user")).getCodTrolpers();
        return val;
    }    
    
}
