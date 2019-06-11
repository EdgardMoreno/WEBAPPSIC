/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.util.main;

import com.general.util.security.EncryptUtils;

/**
 *
 * @author emoreno
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        System.out.println(EncryptUtils.encrypt("yguerra"));
        System.out.println(EncryptUtils.decrypt("APyp+GxLZXUd72EC9NKKKQ=="));
    }
    
}
