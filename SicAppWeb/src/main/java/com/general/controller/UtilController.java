/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.controller;

import com.general.entity.Sic1docu;
import com.general.service.DocumentoServiceImpl;
import com.general.util.beans.UtilClass;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author emoreno
 */

@Named
@ManagedBean
@ViewScoped
public class UtilController {
 
    
    public StreamedContent descargarDocumento(BigDecimal idDocu ) throws Exception{        
        
        System.out.println("idDocu:" + idDocu);        
        StreamedContent file = null;                

        try {
            
            DocumentoServiceImpl objService = new DocumentoServiceImpl();
            Sic1docu objDocu = objService.obtDocuXidDocu(idDocu.intValue());
            
            String strContentType = "";
            String strNombReal = objDocu.getSic1docubina().getDesNombreal();
            String strCodExteDocu = objDocu.getSic1docubina().getCodExtedocu();
            
            System.out.println("LOCA_URI:" + objDocu.getSic1docubina().getDesLocauri());
            System.out.println("EXTE_DOCU:" + strCodExteDocu);
            System.out.println("NOMB_REAL:" + strNombReal);
            
            if(strCodExteDocu.equalsIgnoreCase("PDF"))
                strContentType = "application/pdf";
            else if(strCodExteDocu.equalsIgnoreCase("DOC") || strCodExteDocu.equalsIgnoreCase("DOCX") || strCodExteDocu.equalsIgnoreCase("RTF"))
                strContentType = "application/msword";
            else if(strCodExteDocu.equalsIgnoreCase("XLS") || strCodExteDocu.equalsIgnoreCase("XLSX"))
                strContentType = "application/vnd.ms-excel";
            else if(strCodExteDocu.equalsIgnoreCase("JPG") || strCodExteDocu.equalsIgnoreCase("PNG"))
                strContentType = "image/jpg";
            else if(strCodExteDocu.equalsIgnoreCase("ZIP") || strCodExteDocu.equalsIgnoreCase("7ZIP")|| strCodExteDocu.equalsIgnoreCase("RAR"))
                strContentType = "application/zip";
            else
                throw new Exception("Extensión del documento desconocida.");
            
            System.out.println("strContentType:" + strContentType);
            
            byte[] archivo = objService.descargarDocuBina(objDocu.getSic1docubina().getDesLocauri());
            InputStream stream = new ByteArrayInputStream(archivo);

            //file = new DefaultStreamedContent(stream, "image/jpg", "downloaded_boromir.jpg");            
            file = new DefaultStreamedContent(stream, strContentType, strNombReal);            

        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
        
        return file;
    }
    
    public StreamedContent descargarDocumentoXDesLocaUri(String desLocaUri, String desTitulo ) throws Exception{
        
        StreamedContent file = null;        

        try {
            
            DocumentoServiceImpl objService = new DocumentoServiceImpl();
            String strContentType = "";            
            String strCodExteDocu = UtilClass.getExtensionArchivo(desTitulo);
            String strNombReal = desTitulo;
            
            System.out.println("LOCA_URI:" + desLocaUri);
            System.out.println("EXTE_DOCU:" + strCodExteDocu);
            System.out.println("NOMB_REAL:" + strNombReal);
            
            if(strCodExteDocu.equalsIgnoreCase("PDF"))
                strContentType = "application/pdf";
            else if(strCodExteDocu.equalsIgnoreCase("DOC") || strCodExteDocu.equalsIgnoreCase("DOCX") || strCodExteDocu.equalsIgnoreCase("RTF"))
                strContentType = "application/msword";
            else if(strCodExteDocu.equalsIgnoreCase("XLS") || strCodExteDocu.equalsIgnoreCase("XLSX"))
                strContentType = "application/vnd.ms-excel";
            else if(strCodExteDocu.equalsIgnoreCase("JPG") || strCodExteDocu.equalsIgnoreCase("PNG") || strCodExteDocu.equalsIgnoreCase("JPEG"))
                strContentType = "image/jpg";
            else if(strCodExteDocu.equalsIgnoreCase("ZIP") || strCodExteDocu.equalsIgnoreCase("7ZIP")|| strCodExteDocu.equalsIgnoreCase("RAR"))
                strContentType = "application/zip";
            else
                throw new Exception("Extensión del documento desconocida.");
            
            System.out.println("strContentType:" + strContentType);
            
            byte[] archivo = objService.descargarDocuBina(desLocaUri);
            InputStream stream = new ByteArrayInputStream(archivo);

            //file = new DefaultStreamedContent(stream, "image/jpg", "downloaded_boromir.jpg");            
            file = new DefaultStreamedContent(stream, strContentType, strNombReal);            

        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
        
        return file;
    }    
}
