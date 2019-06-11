/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.main;

import com.general.dao.DaoDocumentoImpl;
import com.general.dao.DaoEventoImpl;
import com.general.dao.DaoMaquinaImpl;
import com.general.entity.Sic1docu;
import com.general.entity.Sic1docubina;
import com.general.entity.Sic1proditem;
import com.general.entity.Sic3docuesta;
import com.general.entity.Sic3docuestaPK;
import com.general.entity.Sic3evendocu;
import com.general.entity.Sic3proditempers;
import com.general.service.EventoServiceImpl;
import com.general.service.PersonaServiceImpl;
import com.general.service.SubClaseEventoServiceImpl;
import com.general.util.ConexionBD;
import static com.general.util.beans.UtilClass.getBytes;
import com.general.util.beans.UtilSic;
import com.general.util.dao.DaoFuncionesUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import mincetur.sic.swServicioProxy;

/**
 *
 * @author emoreno
 */
public class TestService {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here        
        try{
            
            if(false){
                
                reemplazarDocumentoFirmado(  "978640"
                                            ,"GCARBAJAL"
                                            ,"PWIEXP978640141646131"
                                            ,"ResolucionDirectoral(favorable) Nro 2065-2016-MINCETUR/VMT/DGJCMT-dsolis - Firmado"
                                            ,"RD N° 2065-2016_EXP 978640.pdf");
            }
            
            if(false){
                EventoServiceImpl objService = new EventoServiceImpl();
                Connection cnConexion = ConexionBD.obtConexion();
                objService.cerrarYcrearTracking( cnConexion
                                                ,11015
                                                ,"PRIMERA"
                                                ,"SEGUI.APPROVE"
                                                ,"GESPINOZA" /*codIdenPersActual*/
                                                ,"VI_SICADAR" /*codTrolPersActual*/
                                                ,"VPAULET"
                                                ,"VI_SICDDAR" /*codTrolPersSeleccionado*/
                                                ,"SICESTANORM" /*desNotas*/);
            }
            
            
            //LISTAR TODOS LOS FUNCIONARIOS RESPONSABLES AGRUPADOS
            if(false){
                PersonaServiceImpl obj = new PersonaServiceImpl();
                obj.obtFuncionariosAgrupado();
            }
            
            //LISTAR TODOS LOS PROCEDIMIENTOS DE MANERA AGRUPADA
            if(false){
                SubClaseEventoServiceImpl obj = new SubClaseEventoServiceImpl();
                obj.obtSubClaseEventoAgrupado();
            }
            
            //NUMERAR EL INFORME LEGAL
            if(false){
                Integer idEven = 4940;
                String codIdenAbogado = "gespinoza";
                EventoServiceImpl objService = new EventoServiceImpl();
                objService.evaluarExpedienteAbogado(idEven, codIdenAbogado);
            }
            
            //SIMULAR LA EVALUCION DEL DIRECTOR GENERAL
            if(false){
                Integer idEven = 4940;
                EventoServiceImpl objService = new EventoServiceImpl();
                objService.evaluarExpedienteDirectorGeneral(idEven);
            }
            
            //// NOTIFICAR EXPEDIENTES PERDIDOS CON ESTADO DE RESOLUCION U OFICIO "POR FIRMAR"
            if(true){
                
                Integer intIdEven = 4940;
                Integer intIdDocuOriginal = 25682;
                String strCodExpe = "1082151";
                String strCodUsuario = "GESPINOZA";
                String strEstadoDocu = "VI_SICESTAFIRMA";

                //Subir PDF Firmado
                subirDocumentoFirmado(intIdDocuOriginal, strCodExpe, strCodUsuario, strEstadoDocu);

                cambiarEstadoDocumento(/*IdDocu Reso*/ intIdDocuOriginal, "VI_SICESTAPORNOTIM");
//
                cambiarEstadoEvento(intIdEven);//Evento
            }
        
            ///// LISTAR MAQUINAS
            if(false){
                
                Connection cnConexion = null;

                cnConexion = ConexionBD.obtConexion();
                DaoMaquinaImpl objDaoMaquinaImpl = new DaoMaquinaImpl();
                Sic1proditem objMaq = new Sic1proditem();
                objMaq.setIdPersadmin(364);
                List<Sic3proditempers> lstMaquinas = objDaoMaquinaImpl.obtMaquinasAutorizadas(objMaq);
                System.out.println("");
            } 
            
            // 
            
        }catch(Exception e){
            System.out.println("Error:" + e.getMessage());
        }
        
    }   
    
    
    public static void reemplazarDocumentoFirmado(   String strCodExpe
                                                    ,String strCodUsuario
                                                    ,String strContentID 
                                                    ,String strTitulo
                                                    ,String strNombReal){
        try{
            
            File ifArchivo = new File("C:\\Users\\emoreno\\Desktop\\SOPORTE\\RECUPERAR\\" + strCodExpe + ".pdf");
            InputStream istreamArchivo = new FileInputStream(ifArchivo);
            //strTitulo = "ResolucionDirectoral_EXP_1174782(parcial) Nro 611 - 2019-MINCETUR/VMT/DGJCMT-ratencio-Firmado";
            
            if(ifArchivo != null){
                swServicioProxy objswServicioProxy=new swServicioProxy();
                objswServicioProxy.checkin(strContentID, strTitulo, strCodUsuario, getBytes(istreamArchivo), strNombReal);
            }
        
        }catch(Exception ex){
            System.out.println("error:" + ex.getMessage());
        }        
    }
    
    
    
    public static void subirDocumentoFirmado(Integer intIdDocuOriginal
                                             ,String strCodExpe
                                             ,String strCodUsuario
                                             ,String strEstadoDocu) throws SQLException, Exception{
        
        int intFilaError = 0;
        Connection cnConexion = null;
        System.out.println("---INICIO: subirDocumentoFirmado---");
        
        try{           
            //DATOS DE INGRESO
            
            //CASO WALTER
//            Integer intIdDocuOriginal = 87964;
//            String strCodExpe = "1130633";
//            String strCodUsuario = "CALMIRON";
//            String strEstadoDocu = "VI_SICESTAFIRMA";            
            //----------------------------------
            
            //CASO LUZ
//            Integer intIdDocuOriginal = 37545;
//            String strCodExpe = "1120420";
//            String strCodUsuario = "CALMIRON";            
//            String strEstadoDocu = "VI_SICESTAFIRMA";
            //----------------------------------
            
            
            String strDesNotas = "SISTEMA SOPORTE";
            System.out.println("Expediente:" +  strCodExpe);
            
            //LEYENDO EL ARCHIVO
            File ifArchivo = new File("C:\\Users\\emoreno\\Desktop\\SOPORTE\\RECUPERAR\\" + strCodExpe + ".pdf");
            String strNombreArchivoReal = ifArchivo.getName();
            Long lngTamanio  = ifArchivo.length();
            InputStream istreamArchivo = new FileInputStream(ifArchivo);
            String strContentID = UtilSic.obtenerCodigoContent(strCodExpe, "");            
            
            System.out.println("Nombre Archivo:" + ifArchivo.getName());
            System.out.println("strContentID:" + strContentID);
            
            //SE OBTIENE DOCUMENTO
            DaoDocumentoImpl objDaoDocumentoImpl = new DaoDocumentoImpl();
            cnConexion = ConexionBD.obtConexion();

            //CONSULTAR EN BD
            Sic1docu objDocu = objDaoDocumentoImpl.obtDocuXidDocu(cnConexion, intIdDocuOriginal);
            String strCodStipodocu = objDocu.getSic1stipodocu().getCodStipodocu();
            String strTitulo = objDocu.getDesTitulo() +" - Firmado";
            System.out.println("COD_DOCUBINA: " + objDocu.getSic1docubina().getSic1docubinaPK().getCodDocubina());

            //DATOS DOCUMENTO BINARIO
            intFilaError = 3030;
            Sic1docubina objDocubina = objDocu.getSic1docubina();
            objDocubina.setNumBytes(BigInteger.valueOf(lngTamanio));
            objDocubina.setNumFolios(BigInteger.ZERO);
            objDocubina.setDesLocauri(strContentID);
            objDocubina.setDesTitulo(strTitulo);
            objDocubina.setDesNombreal(strNombreArchivoReal);            
            objDocubina.setIdExtedocu(BigInteger.valueOf(DaoFuncionesUtil.FNC_SICOBTIDGEN(cnConexion, "VI_SICEXTEDOCU", "PDF")));
            objDocubina.setIdLengdocu(BigInteger.valueOf(DaoFuncionesUtil.FNC_SICOBTIDGEN(cnConexion, "VI_SICLENGDOCU", "ES")));

            //INSERTAR DOCUMENTO BINARIO
            objDocu.setDesTitulo(strTitulo);
            objDaoDocumentoImpl.insertarDocuBina(cnConexion, objDocubina);            
            
            //VERSIONAR DE ESTADO
            if(strEstadoDocu != null){
                
                String codTrolestadocu = null;
                
                if(strCodStipodocu.contains("VI_SICTIPODOCURESO") || strCodStipodocu.contains("VI_SICSTIPODOCUOFICOBSE")) //Resolucion
                    codTrolestadocu = "VI_SICESTADOCUOFIRES";
                else if(strCodStipodocu.contains("VI_SICSTIPODOCUINFOLEGA") || strCodStipodocu.contains("VI_SICSTIPODOCUINFOTECN")) //Informe Legal
                    codTrolestadocu = "VI_SICESTADOCUINF";
                else                    
                    throw new Exception("Tipo de documento inválido");
                
                Sic3docuestaPK sic3docuestaPK = new Sic3docuestaPK();
                sic3docuestaPK.setIdDocu(objDocu.getIdDocu());
                        
                Sic3docuesta sic3docuesta = new Sic3docuesta();
                sic3docuesta.setCodTrolestadocu(codTrolestadocu); //Estados del documento de Tipo Oficio o Resolucion O INFORME
                sic3docuesta.setCodEstadocu(strEstadoDocu);
                sic3docuesta.setDesNotas(strDesNotas);
                sic3docuesta.setSic3docuestaPK(sic3docuestaPK);
                
                objDaoDocumentoImpl.relaDocuEsta(cnConexion, sic3docuesta);
            
            }            
            
            System.out.println("--Subiendo archivo al UCM");
            
            //SUBIR AL UCM
            if(ifArchivo != null){
                swServicioProxy objswServicioProxy=new swServicioProxy();
                objswServicioProxy.checkin(strContentID, strTitulo, strCodUsuario, getBytes(istreamArchivo), ifArchivo.getName());
            }

            cnConexion.commit();
            System.out.println("-Se Grabó con exito-");
            
        }catch(SQLException e){
            cnConexion.rollback();
            System.out.println("Error:" + e.getMessage() + " FE: " + intFilaError);
            throw new Exception(e.getMessage());
        }catch(Exception e){
            cnConexion.rollback();
            System.out.println("Error:" + e.getMessage() + " FE: " + intFilaError);
            throw new Exception(e.getMessage());
        }finally{
            if(cnConexion != null)
                cnConexion.close();                        
        }        
    }
    
    
    public static void cambiarEstadoDocumento(Integer idDocu, String codEstadocu) throws SQLException, Exception{
        
        Connection cnConexion = null;
        String strDesNotas = "SISTEMA SOPORTE";
        try{
            
            System.out.println("=========== cambiarEstadoDocumento ================");
            
            DaoDocumentoImpl objDaoDocumentoImpl = new DaoDocumentoImpl();
            cnConexion = ConexionBD.obtConexion();
            
            if(codEstadocu != null){
                
                Sic3docuestaPK sic3docuestaPK = new Sic3docuestaPK();
                sic3docuestaPK.setIdDocu(new BigDecimal(idDocu));
                        
                Sic3docuesta sic3docuesta = new Sic3docuesta();
                sic3docuesta.setCodTrolestadocu("VI_SICESTADOCUOFIRES");//Estados del documento de Tipo Oficio o Resolucion
                sic3docuesta.setCodEstadocu(codEstadocu);
                sic3docuesta.setDesNotas(strDesNotas);
                sic3docuesta.setSic3docuestaPK(sic3docuestaPK);
                
                objDaoDocumentoImpl.relaDocuEsta(cnConexion, sic3docuesta);
            
                cnConexion.commit();
            }            
            
            System.out.println("Se cambió el estado del DOCUMENTO con éxito.");
        
        }catch(SQLException e){
            cnConexion.rollback();
            System.out.println("Error:" + e.getMessage());
            throw new Exception(e.getMessage());
        }catch(Exception e){
            cnConexion.rollback();
            System.out.println("Error:" + e.getMessage());
            throw new Exception(e.getMessage());
        }finally{
            if(cnConexion != null)
                cnConexion.close();                        
        }
    }
    
    public static void cambiarEstadoEvento(Integer idEvento) throws SQLException, Exception{
        
        Connection cnConexion = null;
        String strDesNotas = "SISTEMA SOPORTE";
        String strCodstipodocu = "";
        
        try{
            
            System.out.println("============= cambiarEstadoEvento =================");
            
            cnConexion = ConexionBD.obtConexion();
            
            DaoDocumentoImpl objDaoDocumentoImpl = new DaoDocumentoImpl();
            List<Sic3evendocu> lstDocus = objDaoDocumentoImpl.obtDocumentosXEvento(idEvento, null);
            
            for(Sic3evendocu objDocu : lstDocus){
                if(objDocu.getSic1docu().getSic1stipodocu().getCodStipodocu().contains("VI_SICTIPODOCURESO")){
                    strCodstipodocu = objDocu.getSic1docu().getSic1stipodocu().getCodStipodocu();
                    break;
                }
            }
            
            if(strCodstipodocu.equals("") || strCodstipodocu == ""){
                throw new Exception("NO SE PUDO CARGAR EL SUBTIPO DEL DOCUMENTO.");
            }
            
            Integer idSclaseeven = null;
            String codEstaeven = "VI_SICESTARESU";
            String codTipoinst = "PRIMERA";
            String codTdettarea = "EXPEDIENTE." + strCodstipodocu;
            String desTarea = null;
            String desNotas = strDesNotas;
            Integer idPers = null;
            Integer idTrolpers = null;
            Integer idTrelatarea = null;
            
            System.out.println("codTdettarea:" + codTdettarea);
             
            DaoEventoImpl objDaoEventoImpl = new DaoEventoImpl();
            objDaoEventoImpl.creaEvenEsta(  cnConexion
                                           ,idEvento
                                           ,idSclaseeven
                                           ,codEstaeven
                                           ,codTipoinst
                                           ,codTdettarea
                                           ,desTarea
                                           ,desNotas
                                           ,idPers
                                           ,idTrolpers
                                           ,idTrelatarea);
            
            cnConexion.commit();
            System.out.println("Se cambió el estado del evento con éxito.");
        
         }catch(SQLException e){
            cnConexion.rollback();
            System.out.println("Error:" + e.getMessage());
            throw new Exception(e.getMessage());
        }catch(Exception e){
            cnConexion.rollback();
            System.out.println("Error:" + e.getMessage());
            throw new Exception(e.getMessage());
        }finally{
            if(cnConexion != null)
                cnConexion.close();                        
        }
    }
}
