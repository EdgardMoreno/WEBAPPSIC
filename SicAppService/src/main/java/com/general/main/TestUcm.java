/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.main;

import com.general.service.SoaService;
import static com.general.util.beans.UtilClass.getBytes;
import com.general.util.beans.UtilSic;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import mincetur.sic.swServicioProxy;

/**
 *
 * @author emoreno
 */
public class TestUcm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            //subirDocumentoFirmado("gespinoza");
            
            
            ///GENERAR PLANTILLA Y SUBIR AL UCM //
            int pintIdEvento = 11357;
            String strCodExpe = "1060582";
            String pstrUsuario = "ratencio";
            String pstrTitulo = "Oficio_EXP_1060582 Nro XXXXX-2018-MINCETUR/VMT/DGJCMT-ratencio";
            String pstrFormato = "rtf";
            String pstrIdiomaLocal = "es-ES";
            String pstrPlantilla = "PlanObseGeneral";
            String pstrRutaAbsoluta = "/Mincetur/Plantillas/1.Operadores/Oficio/RutaDocuObse.xdo";
            String pstrNombreArchivo = "Oficio_EXP_1060582.doc";
            String pstrContentID = UtilSic.obtenerCodigoContent(strCodExpe, "");
            String pstrCodSTipodocu = "VI_SICSTIPODOCUOFICOBSE";
            String pstrRolCreador = "VI_SICADAR";            
            
            HashMap<String,String> hmParametros = new HashMap<>();
            hmParametros.put("ID_EVEN", String.valueOf(pintIdEvento));
            
            if(pstrCodSTipodocu.equals("VI_SICSTIPODOCUOFICOBSE"))
                hmParametros.put("FLG_CUMPLE", "0");//Solo se muestra observados
            
            SoaService objService = new SoaService();
            objService.generarPlantillaYSubirContent(0
                                                    ,pstrUsuario
                                                    ,pstrTitulo
                                                    ,pstrFormato
                                                    ,pstrIdiomaLocal
                                                    ,pstrPlantilla
                                                    ,pstrRutaAbsoluta
                                                    ,pstrNombreArchivo
                                                    ,pstrContentID
                                                    ,pstrCodSTipodocu
                                                    ,pstrRolCreador
                                                    ,hmParametros);
            
            
        } catch (Exception ex) {
            System.out.println("Error:" + ex.getMessage());
        }
        
    }
    
    
    public static void subirDocumentoFirmado( String strCodUsuario) throws Exception{
        
        int intFilaError = 0;
        String strCodExpe = "12346";
        System.out.println("---INICIO: subirDocumentoFirmado---");
        
        try{            
            //LEYENDO EL ARCHIVO
            File ifArchivo = new File("C:\\Users\\emoreno\\Downloads\\pwa1528180328556302964243.pdf");
            String strTitulo = "Probando";            
            InputStream istreamArchivo = new FileInputStream(ifArchivo);
            String strContentID = UtilSic.obtenerCodigoContent(strCodExpe, "");            
            
            System.out.println("Nombre Archivo:" + ifArchivo.getName());
            System.out.println("strContentID:" + strContentID);          
            
            
            //SUBIR AL UCM
            if(ifArchivo != null){
                swServicioProxy objswServicioProxy=new swServicioProxy();
                objswServicioProxy.checkin(strContentID, strTitulo, strCodUsuario, getBytes(istreamArchivo), ifArchivo.getName());
            }
            
            System.out.println("-Se Grabó con exito-");            
        
        }catch(Exception e){            
            System.out.println("Error:" + e.getMessage() + " FE: " + intFilaError);
        }
    }
    
}
