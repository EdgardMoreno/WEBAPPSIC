/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.controller;


import com.general.entity.Sic1usuario;
import com.general.entity.Sic7persrol;
import com.general.security.SessionUtils;
import com.general.util.MessageUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author emoreno
 */
@ManagedBean
@RequestScoped
//@SessionScoped
public class MasterPageController implements Serializable{    
    
    public String desLoginUser;
    public String desTituloPagina;    
    public String desNombrePagina;
    public String codClaseeven;
    public String codSClaseeven;
    public String codTRolpers;
    
    private Double numTotalVentasMetaMes;
    private Double numTotalVentasMes;
    private Double numPorcAlcanzado;
    

    public MasterPageController()  {        
       
        this.desLoginUser = SessionUtils.getUserCompleteName();
        
    }
    
    /***** PROPIEDADES *****/
    
    public String getDesLoginUser() {
        return desLoginUser;
    }

    public void setDesLoginUser(String desLoginUser) {
        this.desLoginUser = desLoginUser;
    }

    public Double getNumTotalVentasMetaMes() {
        return numTotalVentasMetaMes;
    }

    public void setNumTotalVentasMetaMes(Double numTotalVentasMetaMes) {
        this.numTotalVentasMetaMes = numTotalVentasMetaMes;
    }

    public Double getNumTotalVentasMes() {
        return numTotalVentasMes;
    }

    public void setNumTotalVentasMes(Double numTotalVentasMes) {
        this.numTotalVentasMes = numTotalVentasMes;
    }

    public Double getNumPorcAlcanzado() {
        return numPorcAlcanzado;
    }

    public void setNumPorcAlcanzado(Double numPorcAlcanzado) {
        this.numPorcAlcanzado = numPorcAlcanzado;
    }
       
        
    /***** METODOS *****/
    
    //logout event, invalidate session
    public String logout() {
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return "login";
    }
    
    public void validarDatos(){
            
        FacesContext context = FacesContext.getCurrentInstance();
        
        /*Se limpia los controladores que se tenga en el FACESCONTEXT*/
        context.getExternalContext().getSessionMap().put("maquinaController", null);
        context.getExternalContext().getSessionMap().put("eventoController", null);
        context.getExternalContext().getSessionMap().put("salaController", null);
        context.getExternalContext().getSessionMap().put("memoriaController", null);
        context.getExternalContext().getSessionMap().put("reporteController", null);

        /*Se obtiene los parametros vinculados a los links*/
        desNombrePagina  = context.getExternalContext().getRequestParameterMap().get("paramNombrePagina");
        desTituloPagina  = context.getExternalContext().getRequestParameterMap().get("paramTituloPagina");
        
        
        
    }
    
    public String irPagina(){
        
        String strError = null;
        
        if (desNombrePagina.equalsIgnoreCase("faces/listarMaquinas")){
            FacesContext context = FacesContext.getCurrentInstance();
            MaquinaController objController = context.getApplication().evaluateExpressionGet(context, "#{maquinaController}", MaquinaController.class);
            objController.setDesTitulopagina(desTituloPagina);
        }else if(desNombrePagina.equalsIgnoreCase("faces/listarExpedientes")){
            FacesContext context = FacesContext.getCurrentInstance();
            EventoController objController = context.getApplication().evaluateExpressionGet(context, "#{eventoController}", EventoController.class);
            objController.setDesTitulopagina(desTituloPagina);
            objController.setFlgActivarFiltro(true);
            
        }else if (desNombrePagina.equalsIgnoreCase("faces/rptExpeAtendidos")){
            
            int flgPermiso = 0;
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            Sic1usuario objUsu = ((Sic1usuario)session.getAttribute("user"));
            
            List<Sic7persrol> lstRolesPers = objUsu.getSic1pers().getLstSic7persrol();            
            if(lstRolesPers != null){
                for (Sic7persrol objRol : lstRolesPers){
                    if(objRol.getSic7persrolPK().getCodTrolpers().equalsIgnoreCase("VI_SICADMISIST")){
                        System.out.println("Rol:" + objRol.getSic7persrolPK().getCodTrolpers());
                        flgPermiso = 1;
                        break;
                    }
                }
            }
            
            if(flgPermiso==0)
                strError = "Usuario no tiene privilegios.";
        }
            
        if(strError == null)
            return  desNombrePagina + "?faces-redirect=true";
        else{
            MessageUtil.addErrorMessage(strError);
            return "";
        }
    }
    
    
    
}
