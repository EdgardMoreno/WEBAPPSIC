/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.service;

import com.general.dao.DaoDocumentoImpl;
import com.general.dao.DaoEventoImpl;
import com.general.entity.Sic1even;
import com.general.entity.Sic3evendocu;
import com.general.entity.Sic5evenesta;
import com.general.util.ConexionBD;
import com.general.util.beans.UtilClass;
import com.general.util.beans.UtilSic;
import com.general.util.dao.DaoFuncionesUtil;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import mincetur.sic.swServicioProxy;

/**
 *
 * @author emoreno
 */
public class EventoServiceImpl {
    
    
    public EventoServiceImpl(){
        
    }    
    
    public List<Sic1even> obtExpedientes(Sic1even even) throws Exception{
        
        
        List<Sic1even> lstResu = new ArrayList<>();
        
        try{
            
            DaoEventoImpl objDao = new DaoEventoImpl();
            lstResu = objDao.obtExpedientes(even);
            
        }catch(Exception e){
            throw new Exception("Error: " + e.getMessage());
        }

        return lstResu;
    }
    
    public List<Sic5evenesta> obtTareasEvento(Integer idEven) throws Exception{
        
        Connection cnConexion = null;
        List<Sic5evenesta> lstResu = new ArrayList<>();
        
        try{
            cnConexion = ConexionBD.obtConexion();
            DaoEventoImpl objDao = new DaoEventoImpl();
            lstResu = objDao.obtTareasEvento(cnConexion, idEven);
            
        }catch(Exception e){
            throw new Exception("Error: " + e.getMessage());
        }finally{
            if(cnConexion != null){
                cnConexion.close();
            }
        }

        return lstResu;
    }    
    
    
    public void crearTracking(  String codIdenpers
                               ,Integer idEven
                               ,String codTipoinst
                               ,String codTdettarea
                               ,String codTrolpers
                               ,String desNotas ) throws Exception{
        
        Connection cnConexion = null;
        String codEstaeven = "";
        
        try{
            cnConexion = ConexionBD.obtConexion();
            DaoEventoImpl objDao = new DaoEventoImpl();
            
            Integer idPers = DaoFuncionesUtil.FNC_SICOBTIDPERS(cnConexion, "BPM", codIdenpers.toUpperCase());
            Integer idTrolpers = DaoFuncionesUtil.FNC_SICOBTIDGEN(cnConexion, "VI_SICTROLPERS", codTrolpers);
            Integer idTrelTarea = DaoFuncionesUtil.FNC_SICOBTIDGEN(cnConexion, "VI_SICTRELA", "RELTAREAPERSONA");
            
            if(idTrolpers ==-1)                
                System.out.println("El ID del Rol Creador no es válido: " + idTrolpers);
            
            if(idPers ==-1)
                System.out.println("El ID de la persona no es válido: " + idPers);
            
            System.out.println("intIdPersona:" + idPers);
            System.out.println("intIdRolCreador:" + idTrolpers);
            System.out.println("intIdTrelTarea:" + idTrelTarea);
            
            if(desNotas.split(";")[0].equals("SICESTARECONSID"))
                codEstaeven = "VI_SICESTATRAMRECO";
            else if(desNotas.split(";")[0].equals("SICESTAAPELACIO"))
                codEstaeven = "VI_SICESTATRAMAPEL";
                
            /*============== OS: AUTO EXPRESA ====================
	    FECHA: 25/09/2016
	    COMENTARIO: Se agrega condición para que cuando se llegue a la pantalla de cierre del expediente no lo ponga como que está en TRAMITE sino
                        como RESUELTO.
            */
            else if(desNotas.split(";")[0].equals("SICESTACIERRE"))
                codEstaeven = "VI_SICESTARESU";
            /*FIN*/
            else codEstaeven = "VI_SICESTATRAM";
            
            System.out.println("pstrNotas:" + desNotas);
            System.out.println("strCodEstaEven:" + codEstaeven);
            
            objDao.crearTracking(cnConexion
                                ,idEven
                                ,null
                                ,codEstaeven
                                ,codTipoinst
                                ,codTdettarea
                                ,null
                                ,desNotas
                                ,idPers
                                ,idTrolpers
                                ,idTrelTarea);
            
        }catch(Exception e){
            if(cnConexion != null)
                cnConexion.rollback();
            throw new Exception("Error: " + e.getMessage());
        }finally{
            if(cnConexion != null){
                cnConexion.close();
            }
        }
    }
    
    public void cerrarTracking( String codIdenpers
                               ,Integer idEven
                               ,String codTipoinst
                               ,String codTdettarea
                               ,String codTrolpers
                               ,String desNotas) throws Exception{
        
        Connection cnConexion = null;        
        
        try{
            cnConexion = ConexionBD.obtConexion();
            DaoEventoImpl objDao = new DaoEventoImpl();            
            
            Integer idPers = DaoFuncionesUtil.FNC_SICOBTIDPERS(cnConexion, "BPM", codIdenpers.toUpperCase());
            Integer idTrolpers = DaoFuncionesUtil.FNC_SICOBTIDGEN(cnConexion, "VI_SICTROLPERS", codTrolpers);
            Integer idTrelTarea = DaoFuncionesUtil.FNC_SICOBTIDGEN(cnConexion, "VI_SICTRELA", "RELTAREAPERSONA");
            
            if(idTrolpers == -1)                
                System.out.println("El ID del Rol Creador no es válido: " + idTrolpers);            
            if(idPers == -1)
                System.out.println("El ID de la persona no es válido: " + idPers);
            
            System.out.println("intIdPersona:" + idPers);
            System.out.println("intIdRolCreador:" + idTrolpers);
            System.out.println("intIdTrelTarea:" + idTrelTarea);
            
            
            objDao.cerrarTracking(  cnConexion
                                   ,idEven
                                   ,codTipoinst
                                   ,codTdettarea
                                   ,idPers
                                   ,idTrolpers
                                   ,idTrelTarea
                                   ,desNotas);
            
        }catch(Exception e){
            if(cnConexion != null)
                cnConexion.rollback();
            throw new Exception("Error: " + e.getMessage());            
        }finally{
            if(cnConexion != null)
                cnConexion.close();            
        }
    }
    
    
     /**
     * METODO UTILIZADO PARA CERRAR Y CREAR EL TRACKING DEL EXPEDIENTE SEGUN SE VAYA EVALUANDO
     * @param cnConexion Indica la conexion
     * @param idEven Indica el numero de evento
     * @param codTipoInst Indica el CODIGO DE LA INSTANCIA (PRIMERA, SEGUNDA)
     * @param codTdeTtarea Indica el codigo de la decisión (CODIGO DE LA TAREA) del funcionario actual, (SEGUI.APPROVE, SEGUI.REJECT, ETC)
     * @param codIdenPersActual Indica el CODIDEN del funcionario actual
     * @param codTrolPersActual Indica el CODIGO DEL ROL del funcionario actual
     * @param codIdenPersSeleccionado Indica el CODIDEN del funcionario actual
     * @param codTrolPersSeleccionado Indica el CODIGO DEL ROL del funcionario actual
     * @param desNotas
     */
    public void cerrarYcrearTracking(   
                                         Connection cnConexion
                                        ,Integer idEven
                                        ,String codTipoInst
                                        ,String codTdeTtarea
                                        ,String codIdenPersActual
                                        ,String codTrolPersActual
                                        ,String codIdenPersSeleccionado
                                        ,String codTrolPersSeleccionado
                                        ,String desNotas ) throws Exception{
        
        try{
            
            DaoEventoImpl objDao = new DaoEventoImpl();
            String codEstaeven = null;
            
            Integer idPersActual = DaoFuncionesUtil.FNC_SICOBTIDPERS(cnConexion, "BPM", codIdenPersActual);
            Integer idTrolPersActual = DaoFuncionesUtil.FNC_SICOBTIDGEN(cnConexion, "VI_SICTROLPERS", codTrolPersActual);
            Integer idTrelTarea = DaoFuncionesUtil.FNC_SICOBTIDGEN(cnConexion, "VI_SICTRELA", "RELTAREAPERSONA");
            
            if(idTrolPersActual == -1)                
                System.out.println("El idTrolpers del funcionario actual no es válido: " + idTrolPersActual);            
            if(idPersActual == -1)
                System.out.println("El idPers del funcionario actual no es válido: " + idPersActual);
            
            System.out.println("intIdPersona:" + idPersActual);
            System.out.println("intIdRolCreador:" + idTrolPersActual);
            System.out.println("intIdTrelTarea:" + idTrelTarea);
            
            objDao.cerrarTracking(cnConexion
                                   ,idEven
                                   ,codTipoInst
                                   ,codTdeTtarea
                                   ,idPersActual
                                   ,idTrolPersActual
                                   ,idTrelTarea
                                   ,desNotas);
            
            /*Crear Tracking*/
            switch (desNotas.split(";")[0]) {
                case "SICESTARECONSID":
                    codEstaeven = "VI_SICESTATRAMRECO";
                    break;
                case "SICESTAAPELACIO":
                    codEstaeven = "VI_SICESTATRAMAPEL";
                    /*============== OS: AUTO EXPRESA ====================
                    FECHA: 25/09/2016
                    COMENTARIO: Se agrega condición para que cuando se llegue a la pantalla de cierre del expediente no lo ponga como que está en TRAMITE sino
                    como RESUELTO.
                    */      break;
                case "SICESTACIERRE":
                    codEstaeven = "VI_SICESTARESU";
                    /*FIN*/ break;
                default:
                    codEstaeven = "VI_SICESTATRAM";
                    break;
            }
            
            
            Integer idPersSeleccionado = DaoFuncionesUtil.FNC_SICOBTIDPERS(cnConexion, "BPM", codIdenPersSeleccionado.toUpperCase());
            Integer idTrolPersSeleccionado = DaoFuncionesUtil.FNC_SICOBTIDGEN(cnConexion, "VI_SICTROLPERS", codTrolPersSeleccionado);
            
            if(idTrolPersActual == -1)                
                System.out.println("El idTrolpers del funcionario seleccionado no es válido: " + idTrolPersActual);            
            if(idPersActual == -1)
                System.out.println("El idPers del funcionario seleccionado no es válido: " + idPersActual);
            
            objDao.crearTracking(cnConexion
                                ,idEven
                                ,null /*idSclaseeven*/
                                ,codEstaeven
                                ,codTipoInst
                                ,"SEGUI.REVISION"/*codTdeTtarea*/
                                ,null /*desTarea*/
                                ,desNotas
                                ,idPersSeleccionado
                                ,idTrolPersSeleccionado
                                ,idTrelTarea);
            
        }catch(Exception e){            
            throw new Exception("Error: " + e.getMessage());            
        }
    }
    
    
    public void evaluarExpedienteDirectorGeneral( Integer idEven) throws Exception{
        
        String strCodigoAuto = null;
        ResultSet rsCodigosAutorizacion = null;
        
        Connection cnConexion = ConexionBD.obtConexion();
        
        try{
            
            System.out.println("============= evaluarExpedienteDirectorGeneral() ==============");
            System.out.println("idEven: " + idEven);
            
            //Obtener los documentos.
            DaoDocumentoImpl objDaodocu = new DaoDocumentoImpl();
            List<Sic3evendocu> lstDocus = objDaodocu.obtDocumentosXEvento(cnConexion, idEven, 98);
            swServicioProxy objswServicioProxy = new swServicioProxy();
            
            DaoEventoImpl objDaoEven = new DaoEventoImpl();

            for( Sic3evendocu obj : lstDocus){
                
                Integer idDocu = obj.getSic1docu().getIdDocu().intValue();
                String strCodStipodocu = obj.getSic1docu().getSic1stipodocu().getCodStipodocu();
                String strCodEstaDocu = obj.getSic1docu().getSic3docuesta().getCodEstadocu();

                System.out.println("idDocu: " + idDocu);
                System.out.println("strCodStipodocu: " + strCodStipodocu);
                System.out.println("strCodEstaDocu: " + strCodEstaDocu);
                
                /*VI_SICESTATERCAPP (En Aprobacion 3er Nivel) => Estado que tiene el documento cuando esta siendo evaluado por la DIRECCION GENERAL*/
                if((strCodStipodocu.contains("VI_SICTIPODOCURESO") || strCodStipodocu.contains("VI_SICSTIPODOCUOFICOBSE")) &&
                        strCodEstaDocu.equalsIgnoreCase("VI_SICESTATERCAPP")){
                    
                    System.out.println("COD_STIPODOCU" + obj.getSic1docu().getSic1stipodocu().getCodStipodocu());                    
                    System.out.println("COD_ESTA:" + obj.getSic1docu().getSic3docuesta().getCodEstadocu());
                    
                    //reemplazar en la base de datos
                    String titulo = obj.getSic1docu().getDesTitulo();
                    String[] temp = titulo.split("XXXXX");
                    
                    String strCodExpe = obj.getSic1even().getCodExpe();
                    String strDesLocaUri = obj.getSic1docu().getSic1docubina().getDesLocauri();

                    if(!temp[0].equals(titulo)){
                        
                        //Numerar Resolucion u Oficio
                        String strNumero = objDaodocu.obtNumeracionSistemaNormativo(cnConexion, idEven, idDocu);
                        
                        String nuevoTitulo = temp[0] + strNumero + temp[1];
                        String strContentID = UtilSic.obtenerCodigoContent(strCodExpe, "");
                        
                        System.out.println("ID_DOCU: " + idDocu);
                        System.out.println("nuevoTitulo: " + nuevoTitulo);
                        System.out.println("strDesLocaUri: " + strDesLocaUri);
                        System.out.println("strContentID: " + strContentID);                        

                        //Actualizar el numero en la BD
                        objDaodocu.actualizarNumeroResolutivo(cnConexion, strContentID, nuevoTitulo, idDocu);
                        
                        DateFormat df = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy",new Locale("es","ES"));                        
                        String strArchivo = new String(objswServicioProxy.ejecutarGetFileByName(strDesLocaUri));
                        strArchivo = (strArchivo.replace("<NUM-INTERNO>", strNumero)).replace("<FEC-INTERNO>", df.format(UtilClass.getCurrentDateTime()));
                        
                        
                        if(strCodStipodocu.contains("VI_SICTIPODOCURESO") &&
                           //En APELACION no se genera codigo de autorizacion
                           !strCodStipodocu.equalsIgnoreCase("VI_SICTIPODOCURESOAPELFAVO") &&
                           !strCodStipodocu.equalsIgnoreCase("VI_SICTIPODOCURESOAPELPARC")){
                            
                            System.out.println("== RESOLUCION ==");
                        
                            //Generando los codigos de autorizacion
                            strCodigoAuto = objDaoEven.obtenerCodigoAutorizacion(cnConexion, idDocu);

                            System.out.println("strCodigoAuto:" + strCodigoAuto);

                            if(strCodigoAuto!= null && !strCodigoAuto.equals(""))
                                strArchivo = (strArchivo.replace("<CODAUTO-SALA>", strCodigoAuto));

                            String strEstadoInstancia = "SICESTANORM";                        


                            //OBTENER LA LISTA DE ITEMS RELACIONADOS AL EVENTO                        
                            rsCodigosAutorizacion = objDaoEven.obtenerListItemsXEvento(cnConexion
                                                                                      ,idEven
                                                                                      ,strEstadoInstancia);                       

                            if(rsCodigosAutorizacion.first()){

                                String strCodiAuto = "";
                                boolean boolImprimirCodigosAuto = false;


                                System.out.println("COD_STIPODOCU: " + obj.getSic1docu().getSic1stipodocu().getCodStipodocu());
                                if(obj.getSic1docu().getSic1stipodocu().getCodStipodocu().contains("VI_SICTIPODOCURESO")){
                                    boolImprimirCodigosAuto = true;
                                }

                                rsCodigosAutorizacion.beforeFirst();
                                while(rsCodigosAutorizacion.next() && boolImprimirCodigosAuto){

                                    System.out.println("COD_ITEMCODIAUTO:" + rsCodigosAutorizacion.getString("COD_ITEMCODIAUTO") );
                                    System.out.println("COD_CODIAUTO:" + rsCodigosAutorizacion.getString("COD_CODIAUTO") );

                                    strCodiAuto = "";

                                    if(rsCodigosAutorizacion.getString("COD_CODIAUTO") != null)
                                        strCodiAuto = rsCodigosAutorizacion.getString("COD_CODIAUTO");

                                    System.out.println("Reemplazar:" + rsCodigosAutorizacion.getString("GEN_CODIAUTO") + " POR:" + strCodiAuto);

                                    strArchivo = strArchivo.replace(rsCodigosAutorizacion.getString("GEN_CODIAUTO"), strCodiAuto);
                                }

                            } else {
                                strArchivo = strArchivo.replace("<COD-AUTORIZACION>", strCodigoAuto);
                            }
                        }

                        byte[] resultado = strArchivo.getBytes();

                        System.out.println("DES_NOMREAL: " + obj.getSic1docu().getSic1docubina().getDesNombreal());
                        
                        //SUBIENDO AL UCM, ARCHIVO CON EL NRO DE DOCUMENTO Y LOS CODIGOS DE AUTORIZACION DE LAS MAQUINAS
                        objswServicioProxy.checkin(strContentID, nuevoTitulo, "msanroman", resultado, obj.getSic1docu().getSic1docubina().getDesNombreal());
                        //filaDocumento.setAttribute("DES_LOCAURI_Attr", strContentID);                    
                        
                    }
                }
                                
                if((strCodStipodocu.contains("VI_SICTIPODOCURESO") || strCodStipodocu.contains("VI_SICSTIPODOCUOFICOBSE") || 
                        strCodStipodocu.contains("VI_SICSTIPODOCUINFOLEGA")) && strCodEstaDocu.equalsIgnoreCase("VI_SICESTATERCAPP")) {
                    
                    
                    //CAMBIAR DE ESTADO AL DOCUMENTO. RESOLUCION, OFICIO O INFORME
                    String strCodEstaDocuTmp = null;

                    if(strCodStipodocu.contains("VI_SICTIPODOCURESO") || strCodStipodocu.contains("VI_SICSTIPODOCUOFICOBSE")) //Resolucion
                        strCodEstaDocuTmp = null;
                    else if(strCodStipodocu.contains("VI_SICSTIPODOCUINFOLEGA")) //Informe Legal
                        strCodEstaDocuTmp = "VI_SICESTAPORNOTI";
                    else                    
                        throw new Exception("Tipo de documento inválido");
                    
                    
                    objDaodocu.cambiarEstaDocu(  cnConexion
                                                ,String.valueOf(idEven)
                                                ,idDocu
                                                ,"VI_SICESCA"//strCodRol
                                                ,"APP" //strCodDecision
                                                ,strCodStipodocu
                                                ,strCodEstaDocuTmp);
                
                
                }
                
            }
            
            cnConexion.commit();
            
        }catch(Exception ex){
            cnConexion.rollback();
            throw new Exception(ex.getMessage());
            
        }
    }
    
}
