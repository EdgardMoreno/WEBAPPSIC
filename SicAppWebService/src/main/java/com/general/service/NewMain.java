/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.service;

import com.stellent.getfile.GetFile;
import com.stellent.getfile.GetFileByNameResult;
import com.stellent.getfile.GetFileSoap;

/**
 *
 * @author emoreno
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GetFile objFile = new GetFile();
        GetFileSoap objSoap = objFile.getGetFileSoap();
        
        GetFileByNameResult obj = objSoap.getFileByName("PWIEXP1060684175707605", "LatestReleased", null, null);
        
        System.out.println("Archivo:" + obj.getDownloadFile().getFileName());
    }
    
}
