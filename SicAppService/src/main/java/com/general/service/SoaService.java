/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.service;

import com.general.dao.DaoEventoImpl;
import com.general.entity.Sic1docu;
import com.general.entity.Sic1docubina;
import com.general.entity.Sic1docubinaPK;
import com.general.entity.Sic1even;
import com.general.entity.Sic1pers;
import com.general.entity.Sic3evendocu;
import com.general.util.ConexionBD;
import com.general.util.beans.UtilClass;
import com.general.util.dao.DaoFuncionesUtil;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.util.HashMap;
import mincetur.sic.swServicioBiPublisher;
import mincetur.sic.swServicioProxy;
import org.apache.log4j.Logger;

/**
 *
 * @author emoreno
 */
public class SoaService {
    
    final static Logger log = Logger.getLogger(SoaService.class);
    
    
    public int simularServicioBI(   int pintIdEvento 
                                ,String pstrUsuario
                                ,String pstrTitulo
                                ,String pstrFormato
                                ,String pstrIdiomaLocal
                                ,String pstrPlantilla
                                ,String pstrRutaAbsoluta
                                ,String pstrNombreArchivo
                                ,String pstrContentID
                                ,String pstrCodSTipodocu
                                ,String pstrRolCreador
                                ,HashMap<String,String> phmParametros) throws Exception {
        
        int intIdDocumento = 0;
        int intFilaError = 0;
        Connection cnConexion = null;        
        
        try {            
            
            log.debug("=================== SIMULARSERVICIOBI ======================");
            log.debug("pintIdEvento:" + pintIdEvento);
            log.debug("npstrUsuario:" + pstrUsuario);
            log.debug("nvsTitulo:" + pstrTitulo);
            log.debug("nvFormato:" + pstrFormato);
            log.debug("nvIdiomaLocal:" + pstrIdiomaLocal);
            log.debug("nvPlantilla:" + pstrPlantilla);
            log.debug("nEvento:" + pintIdEvento);
            log.debug("nvRutaAbsoluta:" + pstrRutaAbsoluta);
            log.debug("nvNombreArchivo:" + pstrNombreArchivo);
            log.debug("nvsContentID:" + pstrContentID);
            log.debug("nvsCodSTipodocu:" + pstrCodSTipodocu);
            log.debug("nvsRolCreador:" + pstrRolCreador);
            
            cnConexion = ConexionBD.obtConexion();
                        
            swServicioProxy objswServicioProxy = new swServicioProxy();
                        
            /* ASUNTO: BIPUBLISHER 
             * DESCRIPCION: Utilizamos el servicio del BI Publisher para crear en documento
             * en la base a la plantilla relacionada.
             */
            intFilaError = 10;
            swServicioBiPublisher publisherProxy = new swServicioBiPublisher();
            intFilaError = 15;
            
            String[] arr = new String[2];
            arr[0] = "BI_SIC";
            arr[1] = "Oracle01";
            intFilaError = 18;
            
            byte[] archivo = publisherProxy.descargarPlantillaEnBytes_BIPublisher(pstrFormato
                                                                                 ,pstrIdiomaLocal
                                                                                 ,pstrPlantilla
                                                                                 ,pstrRutaAbsoluta
                                                                                 ,phmParametros
                                                                                 ,arr[0]
                                                                                 ,arr[1] );
            intFilaError = 20;
            if(archivo == null)
                throw new Exception("BIP: NO SE PUDO CARGAR LA PLANTILLA");
            
            String strExtension = UtilClass.getExtensionArchivo(pstrNombreArchivo);
            intFilaError = 25;
            int intTamanio = archivo.length;

            log.info("intTamanio:" + intTamanio);

            /* ASUNTO: GUARDAR BD
             * DESCRIPCION: Se inserta el documento en la base de datos
             */
                        
            //Persona
            Sic1pers objPers = new Sic1pers();
            objPers.setIdPers(new BigDecimal(DaoFuncionesUtil.FNC_SICOBTIDPERS(cnConexion, "BPM", pstrUsuario.toUpperCase())));            
            
            //Evento
            Sic1even objEven = new Sic1even();
            objEven.setIdEven(new BigDecimal(pintIdEvento));            
            
            //Documento Binario
            Sic1docubinaPK objDocubinaPk = new Sic1docubinaPK();            
            objDocubinaPk.setCodDocubina(pstrContentID);
            
            Sic1docubina objDocubina = new Sic1docubina();            
            objDocubina.setDesLocauri(pstrContentID);
            objDocubina.setNumBytes(BigInteger.valueOf(intTamanio));
            objDocubina.setDesNombreal(pstrNombreArchivo);
            objDocubina.setIdExtedocu(BigInteger.valueOf(DaoFuncionesUtil.FNC_SICOBTIDGEN(cnConexion, "VI_SICEXTEDOCU", strExtension.toUpperCase())));
            objDocubina.setIdLengdocu(BigInteger.valueOf(DaoFuncionesUtil.FNC_SICOBTIDGEN(cnConexion, "VI_SICLENGDOCU", "ES")));
            objDocubina.setSic1docubinaPK(objDocubinaPk);
            
            //Documento
            Sic1docu objDocu = new Sic1docu();
            objDocu.setCodIden("PWI"  + DaoFuncionesUtil.obtCodIdenAleatorio(cnConexion));            
            objDocu.setDesDocu(pstrTitulo);
            objDocu.setDesTitulo(pstrTitulo);
            objDocu.setIdStipodocu(DaoFuncionesUtil.FNC_SICOBTIDGEN(cnConexion, "VI_SICSTIPODOCU", pstrCodSTipodocu));
            objDocu.setIdTrolpers(DaoFuncionesUtil.FNC_SICOBTIDGEN(cnConexion, "VI_SICTROLPERS", pstrRolCreador));
            objDocu.setSic1docubina(objDocubina);
            objDocu.setIdPers(objPers);
            
            log.debug("CODIDEN:" + objDocu.getCodIden());
            
            //CREANDO OBJETO PRINCIPAL
            Sic3evendocu objRelEvenDocu = new Sic3evendocu();
            objRelEvenDocu.setIdTrelaeven(DaoFuncionesUtil.FNC_SICOBTIDGEN(cnConexion, "VI_SICTRELA", "RELDOCUMENTOGENERADO"));            
            objRelEvenDocu.setSic1even(objEven);
            objRelEvenDocu.setSic1docu(objDocu);
            
            
            DaoEventoImpl objDaoEventoImpl = new DaoEventoImpl();
            intIdDocumento = objDaoEventoImpl.relacionarEvenDocu(cnConexion, objRelEvenDocu);
            intFilaError = 40;

            if(intIdDocumento<=0){
                throw new Exception("Código de documento inválido");
            }

            log.info("intIdDocumento:" + intIdDocumento);
            
            
            /* ASUNTO: UCM
             * DESCRIPCION: Se sube el documento al Content Manager
             */
            intFilaError = 50;            
            String[] arrResultado = objswServicioProxy.checkin(pstrContentID, pstrTitulo, pstrUsuario, archivo, pstrNombreArchivo);
            
            if(!arrResultado[0].equals("0")){
                throw new Exception("UCM:" + arrResultado[1]);
            }
            
            log.info("Mensaje Content:" + arrResultado[1]);

            cnConexion.commit();

        } catch (Exception e) {
            cnConexion.rollback();
            log.error(e.getMessage());
            throw new Exception(e.getMessage());
        }
        
        return intIdDocumento;
    }
    
    /**
     * Metodo para generar un plantilla desde el BI Publisher y luego subirla al Conten Manager
     * @param pintIdEvento
     * @param pstrUsuario
     * @param pstrTitulo
     * @param pstrFormato
     * @param pstrIdiomaLocal
     * @param pstrPlantilla
     * @param pstrRutaAbsoluta
     * @param pstrNombreArchivo
     * @param pstrContentID
     * @param pstrCodSTipodocu
     * @param pstrRolCreador
     * @param phmParametros
     * @throws Exception 
     */
    public void generarPlantillaYSubirContent(   int pintIdEvento 
                                                ,String pstrUsuario
                                                ,String pstrTitulo
                                                ,String pstrFormato
                                                ,String pstrIdiomaLocal
                                                ,String pstrPlantilla
                                                ,String pstrRutaAbsoluta
                                                ,String pstrNombreArchivo
                                                ,String pstrContentID
                                                ,String pstrCodSTipodocu
                                                ,String pstrRolCreador
                                                ,HashMap<String,String> phmParametros) throws Exception {
        
        int intIdDocumento = 0;
        int intFilaError = 0;        
        
        try {            
            
            log.debug("=================== generarPlantillaYSubirContent ======================");
            log.debug("pintIdEvento:" + pintIdEvento);
            log.debug("npstrUsuario:" + pstrUsuario);
            log.debug("nvsTitulo:" + pstrTitulo);
            log.debug("nvFormato:" + pstrFormato);
            log.debug("nvIdiomaLocal:" + pstrIdiomaLocal);
            log.debug("nvPlantilla:" + pstrPlantilla);
            log.debug("nEvento:" + pintIdEvento);
            log.debug("nvRutaAbsoluta:" + pstrRutaAbsoluta);
            log.debug("nvNombreArchivo:" + pstrNombreArchivo);
            log.debug("nvsContentID:" + pstrContentID);
            log.debug("nvsCodSTipodocu:" + pstrCodSTipodocu);
            log.debug("nvsRolCreador:" + pstrRolCreador);            
                                    
            swServicioProxy objswServicioProxy = new swServicioProxy();
                        
            /* ASUNTO: BIPUBLISHER 
             * DESCRIPCION: Utilizamos el servicio del BI Publisher para crear en documento
             * en la base a la plantilla relacionada.
             */
            intFilaError = 10;
            swServicioBiPublisher publisherProxy = new swServicioBiPublisher();
            intFilaError = 15;
            
            String[] arr = new String[2];
            arr[0] = "BI_SIC";
            arr[1] = "Oracle01";
            intFilaError = 18;
            
            byte[] archivo = publisherProxy.descargarPlantillaEnBytes_BIPublisher(pstrFormato
                                                                                 ,pstrIdiomaLocal
                                                                                 ,pstrPlantilla
                                                                                 ,pstrRutaAbsoluta
                                                                                 ,phmParametros
                                                                                 ,arr[0]
                                                                                 ,arr[1] );
            intFilaError = 20;
            if(archivo == null)
                throw new Exception("BIP: NO SE PUDO CARGAR LA PLANTILLA");
            
            
            /* ASUNTO: UCM
             * DESCRIPCION: Se sube el documento al Content Manager
             */
            intFilaError = 50;            
            String[] arrResultado = objswServicioProxy.checkin(pstrContentID, pstrTitulo, pstrUsuario, archivo, pstrNombreArchivo);
            
            if(!arrResultado[0].equals("0")){
                throw new Exception("UCM:" + arrResultado[1]);
            }
            
            log.info("Mensaje Content:" + arrResultado[1]);

        } catch (Exception e) {            
            
            log.error(e.getMessage());
            throw new Exception(e.getMessage());
        }
        
        
    }
    
}
