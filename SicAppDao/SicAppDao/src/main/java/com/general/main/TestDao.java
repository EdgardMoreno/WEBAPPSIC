/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.main;

import com.general.dao.DaoDocumentoImpl;
import com.general.dao.DaoEventoImpl;
import com.general.dao.DaoMaquinaImpl;
import com.general.dao.DaoPersonaImpl;
import com.general.dao.DaoSoporte;
import com.general.entity.Sic1even;
import com.general.entity.Sic1pers;
import com.general.entity.Sic1proditem;
import com.general.entity.Sic1sclaseeven;
import com.general.entity.Sic3docuesta;
import com.general.entity.Sic3docuestaPK;
import com.general.entity.Sic3evendocu;
import com.general.entity.Sic5persperm;
import com.general.entity.Sic5perspermPK;
import com.general.util.ConexionBD;
import com.general.util.beans.ConstantesSic;
import com.general.util.beans.UtilClass;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author emoreno
 */
public class TestDao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
                
        Connection cnConexion = null;
        try{
            
            System.out.println("Inicio");
            
            cnConexion = ConexionBD.obtConexion();
            DaoEventoImpl evento = new DaoEventoImpl();
            //evento.obtenerEvenDocu(cnConexion, 10379);            

            //NOTIFICAR OFICIO
            try{
                
                if(true){
                    
                    DaoMaquinaImpl objDao = new DaoMaquinaImpl();
                    Sic1proditem objItem = new Sic1proditem();
                    objItem.setNumSerie("6847");
                    objDao.obtMaquinasEnTramite(objItem);
                    System.out.println("");
                    
                    
                }
                
                if(false){
                    Sic5perspermPK objPersPK = new Sic5perspermPK();
                    objPersPK.setIdPers(2385);
                    
                    Sic5persperm objPers = new Sic5persperm();
                    objPers.setSic5perspermPK(objPersPK);
                    objPers.setIdMotiperm(45489);
                    objPers.setDesPerm("Vacaciones");
                    objPers.setFecDesde(UtilClass.getCurrentDateTime());
                    objPers.setFecHasta(UtilClass.getCurrentDateTime());
                    
                    DaoPersonaImpl objDao = new DaoPersonaImpl();
                    objDao.registrarPermisoFunc(cnConexion, objPers);
                }
                
                if(false){
                    /*Obtener todos los documentos*/
                    DaoDocumentoImpl objDaodocu = new DaoDocumentoImpl();
                    List<Sic3evendocu> lstDocus = objDaodocu.obtDocumentosXEvento(5034, null);
                }
                
                if(false){
                    
                    System.out.println("Inicio:" + new Date());

                    Integer idEvento = 11093;
                    String codRol = null;
                    String codDecision = "APP";
                    String codEstaDocu = "VI_SICESTAPORNOTIM";
                    Integer idPersAbogado = 2384;

                    //Obtener los documentos.
                    DaoDocumentoImpl objDaodocu = new DaoDocumentoImpl();
                    List<Sic3evendocu> lstDocus = objDaodocu.obtDocumentosXEvento( idEvento, 98);

                    for( Sic3evendocu obj : lstDocus){

                        System.out.println("COD_STIPODOCU" + obj.getSic1docu().getSic1stipodocu().getCodStipodocu());
                        System.out.println("ID_DOCU:" + obj.getSic1docu().getIdDocu().intValue());
                        System.out.println("COD_ESTA:" + obj.getSic1docu().getSic3docuesta().getCodEstadocu());

                        if(obj.getSic1docu().getSic3docuesta().getCodEstadocu().equalsIgnoreCase("VI_SICESTAFIRMA")){                       

                            //CAMBIAR ESTADOS SOLO DE RESOLUCION U OFICIO
                            objDaodocu.cambiarEstaDocu(cnConexion
                                                      ,idEvento.toString()
                                                      ,obj.getSic1docu().getIdDocu().intValue()
                                                      ,codRol
                                                      ,codDecision
                                                      ,obj.getSic1docu().getSic1stipodocu().getCodStipodocu()
                                                      ,codEstaDocu);
                            break;
                        }
                    }
                    
                    //CREAR ESTADO TRACKING
                    
                    DaoEventoImpl obj = new DaoEventoImpl();

                    /*YA NO SE UTILIZA
                    Integer idTarea = obj.crearTracking(     cnConexion
                                                            ,idEvento
                                                            ,null
                                                            ,"VI_SICESTATRAM"
                                                            ,"PRIMERA"
                                                            ,"SEGUI.APPROVE"
                                                            ,null //desTarea
                                                            ,"SICESTANORM;" //desNotas
                                                            ,idPersAbogado //idPers
                                                            ,-1 //idTrolpes
                                                            ,71 //idTrelatarea);                    

                    System.out.println("idTarea: " + idTarea); */                    

                    //NOTIFICAR EVENTO
                    obj.notiObservacion( cnConexion
                                        ,idEvento
                                        ,null //idSclaseeven
                                        ,"VI_SICESTATRAM"
                                        ,"PRIMERA"
                                        ,"EXPEDIENTE.VI_SICSTIPODOCUOFICOBSE"
                                        ,null /*desTarea*/
                                        ,null /*desNotas*/
                                        ,null /*idPers*/
                                        ,null /*idTrolpes*/
                                        ,null /*idTrelatarea*/);

                    cnConexion.rollback();
                
                    System.out.println("Fin:" + new Date());
                    
                }
            }catch(Exception ex){
                cnConexion.rollback();
                cnConexion.close();
                System.out.println("Error:" + ex.getMessage());
            }
            
            //RESETEAR EXPEDIENTE PARA RECUPERAR
            if(false){
                DaoSoporte objDao = new DaoSoporte();
                objDao.resetearExpediente(cnConexion, "1060331");
                cnConexion.commit();
            }
            
            
            //Leer un archivo y convertirlo a String
            if(false) {
                String theString2 = IOUtils.toString(new FileInputStream(new File("src\\main\\java\\SQLRecuperarExpediente.sql")), "UTF-8");                
                System.out.println(theString2);
            }
            
            //LISTAR PERSONAS
            if(false){
                DaoPersonaImpl obj = new DaoPersonaImpl();
                List<Sic1pers> lstPers = obj.obtPersonasXNombre(ConstantesSic.CONS_COD_TROLADMINISTRADO, "royal");
                System.out.println("Resultado");
            }
            
            //
            if(false){
                DaoEventoImpl obj = new DaoEventoImpl();
                Sic1even objEven = new Sic1even();
                String[] myStrings = { "55", "62" };
                Sic1sclaseeven objSclaseeven = new Sic1sclaseeven();
                objSclaseeven.setArrIdSclaseeven(myStrings);
                objEven.setIdSclaseeven(objSclaseeven);
                
                System.out.println("Array:" + Arrays.toString(myStrings));
                System.out.println("Array:" + String.join("," ,myStrings));
                
                List<Sic1even>  lista = obj.obtExpedientes(objEven);
                System.out.println("Resultado");
            }
            
            if(false){
                
                DaoDocumentoImpl dao = new DaoDocumentoImpl();
                
                Sic3docuestaPK sic3docuestaPK = new Sic3docuestaPK();
                sic3docuestaPK.setIdDocu(new BigDecimal(46617));
                        
                Sic3docuesta sic3docuesta = new Sic3docuesta();
                sic3docuesta.setCodTrolestadocu("VI_SICESTADOCUOFIRES");//Estados del documento de Tipo Oficio o Resolucion
                sic3docuesta.setCodEstadocu("VI_SICESTAPORNOTIM");
                sic3docuesta.setDesNotas("SOPORTE");
                sic3docuesta.setSic3docuestaPK(sic3docuestaPK);
                
                dao.relaDocuEsta(cnConexion, sic3docuesta);
                
            }
            
        }catch(Exception e){
            System.out.println("Error:" + e.getMessage());
            if(cnConexion!=null){
                cnConexion.rollback();
                cnConexion.close();
            }
        }finally{
            if(cnConexion!=null){
                cnConexion.close();
            }
        }
    }
}
