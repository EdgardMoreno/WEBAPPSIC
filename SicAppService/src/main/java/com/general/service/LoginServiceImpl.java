/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.service;


import com.general.dao.DaoLoginImpl;
import com.general.dao.DaoPersonaImpl;
import com.general.entity.Sic1usuario;
import com.general.entity.Sic7persrol;
import com.general.util.exceptions.ValidationException;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author emoreno
 */
public class LoginServiceImpl implements Serializable{
    
    private final DaoLoginImpl daoLoginImpl;
    
    
    /*CONSTRUCTORES*/
    public LoginServiceImpl(){
        this.daoLoginImpl  = new DaoLoginImpl();
    }

    /*METODOS*/    
//    public Sic1usuario getByCodIden(String codIden) throws CustomizerException{
//        
//        Sic1usuario result;
//        try{
//            session = HibernateUtil.getSessionFactory().openSession();
//            result = daoLoginImpl.getByCodIden(session, codIden);
//        }catch(Exception ex){
//            throw new CustomizerException(ex.getMessage());
//        }finally{
//            session.close();
//        }
//        return result;
//    }
    
    /**
     * Procedimiento que valida usuario y contraseña. Además se obtiene los roles de la personas logueada.
     * @param codUserName
     * @param codDocuIden
     * @return
     * @throws Exception 
     */
    public Sic1usuario validarPersonaXUsuarioYDocIdentidad(String codUserName, String codDocuIden) throws Exception {       
        
        Sic1usuario objUsuario = null;
        
        try{
            
            if(codUserName.isEmpty())
                throw new ValidationException("Debe Ingresar el usuario.");
            if(codDocuIden.isEmpty())
                throw new ValidationException("Debe Ingresar la contraseña.");
            
            objUsuario = daoLoginImpl.validarPersona(codUserName, codDocuIden);

            /*Se obtiene los roles*/
            if(objUsuario != null){
                
                DaoPersonaImpl objDaoPers = new DaoPersonaImpl();
                List<Sic7persrol> lstRolPers = objDaoPers.obtRolesPersona(objUsuario.getIdUsuario());
                objUsuario.getSic1pers().setLstSic7persrol(lstRolPers);
                                
            }else
                throw new ValidationException("Usuario inválido o sin permisos.");
            
        } catch(ValidationException ex){
            throw new ValidationException(ex.getMessage());
        } catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
            
        return objUsuario;        
    }
    
    /**
     * Metodo que devuelve una persona con sus roles vigentes
     * @param codUserName Indica el codigo del usuario. Ejem. RLLERENA
     * @return
     * @throws Exception 
     */
    public Sic1usuario validarPersonaXUsuario(String codUserName) throws Exception {               
        
        Sic1usuario objUsuario = null;
        
        try{
            
            if(codUserName.isEmpty())
                throw new ValidationException("Debe Ingresar el usuario.");
            
            objUsuario = daoLoginImpl.validarPersona(codUserName, null);

            /*Se obtiene los roles*/
            if(objUsuario != null){
                
                DaoPersonaImpl objDaoPers = new DaoPersonaImpl();
                List<Sic7persrol> lstRolPers = objDaoPers.obtRolesPersona(objUsuario.getIdUsuario());
                objUsuario.getSic1pers().setLstSic7persrol(lstRolPers);
                
                
            }else
                throw new ValidationException("Usuario inválido o sin permisos.");
            
        } catch(ValidationException ex){
            throw new ValidationException(ex.getMessage());
        } catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
            
        return objUsuario;        
    }
}
