  DECLARE L_ID_EVEN NUMBER;
          L_COD_EXPE VARCHAR2(20);

   CURSOR C_TEMPORAL
        IS
        SELECT COD_EXPE FROM SICDBA.SIC1EVEN WHERE COD_EXPE IN 
                                                  ('1126072');

   C  C_TEMPORAL%ROWTYPE;
  
   BEGIN
   
   FOR C IN C_TEMPORAL LOOP
    
        BEGIN
   
                   L_COD_EXPE := C.COD_EXPE;                                 
                    SELECT ID_EVEN INTO L_ID_EVEN FROM SICDBA.SIC1EVEN WHERE COD_EXPE_HIST = '1060331';                      

                    UPDATE SICDBA.SIC1EVEN SET COD_EXPE = NULL, ID_TAREA = NULL  WHERE COD_EXPE_HIST = '1060331';
                    
                    DELETE FROM SICDBA.SIC1DOCU WHERE ID_DOCU IN ( 
                    
                          SELECT T3.ID_DOCU
                          FROM SICDBA.SIC1EVEN T1
                          JOIN SICDBA.SIC3EVENDOCU T2 ON T1.ID_EVEN = T2.ID_EVEN
                          JOIN SICDBA.SIC1DOCU T3 ON T3.ID_DOCU = T2.ID_DOCU
                          JOIN SICDBA.SIC1STIPODOCU T4 ON T4.ID_STIPODOCU = T3.ID_STIPODOCU
                          JOIN SICDBA.SIC3DOCUESTA T5 ON T5.ID_DOCU = T3.ID_DOCU
                          WHERE T4.COD_STIPODOCU IN ('VI_SICSTIPODOCUCONSRECESOLI','VI_SICSTIPODOCUCARA','VI_SICSTIPODOCUINFOLEGA','VI_SICTIPODOCURESOFAVO','VI_SICSTIPODOCUOFICOBSE') 
                                AND T5.FEC_HASTA = TO_DATE('31/12/2400','DD/MM/YYYY')
                                AND T5.ID_ESTADOCU NOT IN (SELECT ID_ESTA FROM SICDBA.VI_SICESTA WHERE COD_ESTA = 'VI_SICESTANOTI')
                                AND T1.ID_EVEN = L_ID_EVEN );

          
            END;
        END LOOP;
        
   EXCEPTION
       WHEN OTHERS THEN
       DBMS_OUTPUT.put_line('ERROR: ' || SQLERRM);
       ROLLBACK;
   END;