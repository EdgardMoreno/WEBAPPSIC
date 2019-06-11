/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.controller;

import com.general.entity.Sic1pers;
import com.general.entity.Sic1usuario;
import com.general.security.SessionUtils;
import com.general.service.LoginServiceImpl;
import com.general.util.MessageUtil;
import com.general.util.exceptions.ValidationException;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author emoreno
 */

@ManagedBean
@SessionScoped
public class LoginController implements Serializable{
    
    
    private String userName;
    private String passWord;
    private Sic1usuario user;
    
    public LoginController(){
        //https://www.journaldev.com/7252/jsf-authentication-login-logout-database-example
    }
    
    @PostConstruct
    public void init(){
        user = new Sic1usuario();
    }
    
    /*ATRIBUTOS*/

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Sic1usuario getUser() {
        return user;
    }

    public void setUser(Sic1usuario user) {
        this.user = user;
    }

        
    /*METODOS*/
    public String validateUsernamePassword() throws Exception, ValidationException{
        
        System.out.println("Login:" + SessionUtils.getSession());
        System.out.println("Validate Usuario:");
        System.out.println("Usuario: " + this.userName);
        System.out.println("PWD: " + this.passWord);
        
        try{
            LoginServiceImpl loginServiceImpl = new LoginServiceImpl();
            this.user = loginServiceImpl.validarPersonaXUsuarioYDocIdentidad(this.userName, this.passWord);
            
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("user", user);
                       
        }catch(ValidationException ex){
            MessageUtil.addErrorMessage(ex.getMessage());
            return "";
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
        
        String desTituloPagina = "Reporte de Expedientes";
        
        FacesContext context = FacesContext.getCurrentInstance();
        EventoController objController = context.getApplication().evaluateExpressionGet(context, "#{eventoController}", EventoController.class);
        objController.setDesTitulopagina(desTituloPagina);
        objController.setFlgActivarFiltro(true);
        
        return "faces/listarExpedientes?faces-redirect=true";
    }
    
    public String validarPersonaXUsuarioWindows() throws Exception, ValidationException{
        
        
        System.out.println("Login:" + SessionUtils.getSession());
        System.out.println("Validate Usuario de windows:");
        
//        String strUsuario = System.getProperty("user.name");
//        System.out.println("Usuario: " + strUsuario);
        
        try{
            //LoginServiceImpl loginServiceImpl = new LoginServiceImpl();
            //this.user = loginServiceImpl.validarPersonaXUsuario(strUsuario);
            
            this.user.setCodUsuario("INVITADO");
            this.user.setIdUsuario(new BigDecimal("-1"));
            
            Sic1pers objPers = new Sic1pers();
            objPers.setIdPers(new BigDecimal("-1"));
            objPers.setDesPers("Invitado");            

            Sic1usuario objUsuario = new Sic1usuario();
            objUsuario.setIdUsuario(new BigDecimal("-1"));
            objUsuario.setCodUsuario("INVITADO");
            objUsuario.setCodPwd("INVITADO");
            objUsuario.setSic1pers(objPers);
            
            this.user = objUsuario;
            
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("user", user);
                       
//        }catch(ValidationException ex){
//            MessageUtil.addErrorMessage(ex.getMessage());
//            return "";
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
        
        String desTituloPagina = "Reporte de Expedientes";
        
        FacesContext context = FacesContext.getCurrentInstance();
        EventoController objController = context.getApplication().evaluateExpressionGet(context, "#{eventoController}", EventoController.class);
        objController.setDesTitulopagina(desTituloPagina);
        objController.setFlgActivarFiltro(true);
        
        return "faces/listarExpedientes?faces-redirect=true";
    }
    
}
