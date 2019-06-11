/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author emoreno
 */
@Entity
@Table(name = "SIC1SCLASEEVEN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sic1sclaseeven.findAll", query = "SELECT s FROM Sic1sclaseeven s")
    , @NamedQuery(name = "Sic1sclaseeven.findByIdSclaseeven", query = "SELECT s FROM Sic1sclaseeven s WHERE s.idSclaseeven = :idSclaseeven")
    , @NamedQuery(name = "Sic1sclaseeven.findByDesSclaseeven", query = "SELECT s FROM Sic1sclaseeven s WHERE s.desSclaseeven = :desSclaseeven")
    , @NamedQuery(name = "Sic1sclaseeven.findByCodSclaseeven", query = "SELECT s FROM Sic1sclaseeven s WHERE s.codSclaseeven = :codSclaseeven")
    , @NamedQuery(name = "Sic1sclaseeven.findByIdTipoformato", query = "SELECT s FROM Sic1sclaseeven s WHERE s.idTipoformato = :idTipoformato")
    , @NamedQuery(name = "Sic1sclaseeven.findByIdTiposoli", query = "SELECT s FROM Sic1sclaseeven s WHERE s.idTiposoli = :idTiposoli")
    , @NamedQuery(name = "Sic1sclaseeven.findByIdClaseeven", query = "SELECT s FROM Sic1sclaseeven s WHERE s.idClaseeven = :idClaseeven")
    , @NamedQuery(name = "Sic1sclaseeven.findByDesNotas", query = "SELECT s FROM Sic1sclaseeven s WHERE s.desNotas = :desNotas")
    , @NamedQuery(name = "Sic1sclaseeven.findByCodNumtupa", query = "SELECT s FROM Sic1sclaseeven s WHERE s.codNumtupa = :codNumtupa")
    , @NamedQuery(name = "Sic1sclaseeven.findByNumDiaplazo", query = "SELECT s FROM Sic1sclaseeven s WHERE s.numDiaplazo = :numDiaplazo")
    , @NamedQuery(name = "Sic1sclaseeven.findByFlgSileadmi", query = "SELECT s FROM Sic1sclaseeven s WHERE s.flgSileadmi = :flgSileadmi")
    , @NamedQuery(name = "Sic1sclaseeven.findByFlgEvallega", query = "SELECT s FROM Sic1sclaseeven s WHERE s.flgEvallega = :flgEvallega")
    , @NamedQuery(name = "Sic1sclaseeven.findByFlgEvalfina", query = "SELECT s FROM Sic1sclaseeven s WHERE s.flgEvalfina = :flgEvalfina")
    , @NamedQuery(name = "Sic1sclaseeven.findByFlgEvaltecn", query = "SELECT s FROM Sic1sclaseeven s WHERE s.flgEvaltecn = :flgEvaltecn")
    , @NamedQuery(name = "Sic1sclaseeven.findByFlgEvalinsp", query = "SELECT s FROM Sic1sclaseeven s WHERE s.flgEvalinsp = :flgEvalinsp")
    , @NamedQuery(name = "Sic1sclaseeven.findByFlgSineval", query = "SELECT s FROM Sic1sclaseeven s WHERE s.flgSineval = :flgSineval")
    , @NamedQuery(name = "Sic1sclaseeven.findByFlgMultinst", query = "SELECT s FROM Sic1sclaseeven s WHERE s.flgMultinst = :flgMultinst")
    , @NamedQuery(name = "Sic1sclaseeven.findByRutaInfolega", query = "SELECT s FROM Sic1sclaseeven s WHERE s.rutaInfolega = :rutaInfolega")
    , @NamedQuery(name = "Sic1sclaseeven.findByRutaInfofina", query = "SELECT s FROM Sic1sclaseeven s WHERE s.rutaInfofina = :rutaInfofina")
    , @NamedQuery(name = "Sic1sclaseeven.findByRutaInfotecn", query = "SELECT s FROM Sic1sclaseeven s WHERE s.rutaInfotecn = :rutaInfotecn")
    , @NamedQuery(name = "Sic1sclaseeven.findByRutaReso", query = "SELECT s FROM Sic1sclaseeven s WHERE s.rutaReso = :rutaReso")
    , @NamedQuery(name = "Sic1sclaseeven.findByRutaObse", query = "SELECT s FROM Sic1sclaseeven s WHERE s.rutaObse = :rutaObse")
    , @NamedQuery(name = "Sic1sclaseeven.findByPlantInfolega", query = "SELECT s FROM Sic1sclaseeven s WHERE s.plantInfolega = :plantInfolega")
    , @NamedQuery(name = "Sic1sclaseeven.findByPlantInfofina", query = "SELECT s FROM Sic1sclaseeven s WHERE s.plantInfofina = :plantInfofina")
    , @NamedQuery(name = "Sic1sclaseeven.findByPlantInfotecn", query = "SELECT s FROM Sic1sclaseeven s WHERE s.plantInfotecn = :plantInfotecn")
    , @NamedQuery(name = "Sic1sclaseeven.findByPlantReso", query = "SELECT s FROM Sic1sclaseeven s WHERE s.plantReso = :plantReso")
    , @NamedQuery(name = "Sic1sclaseeven.findByPlantObse", query = "SELECT s FROM Sic1sclaseeven s WHERE s.plantObse = :plantObse")
    , @NamedQuery(name = "Sic1sclaseeven.findByFlgEliminado", query = "SELECT s FROM Sic1sclaseeven s WHERE s.flgEliminado = :flgEliminado")
    , @NamedQuery(name = "Sic1sclaseeven.findByFlgReso", query = "SELECT s FROM Sic1sclaseeven s WHERE s.flgReso = :flgReso")
    , @NamedQuery(name = "Sic1sclaseeven.findByFlgPlan", query = "SELECT s FROM Sic1sclaseeven s WHERE s.flgPlan = :flgPlan")
    , @NamedQuery(name = "Sic1sclaseeven.findByIdTpantplan", query = "SELECT s FROM Sic1sclaseeven s WHERE s.idTpantplan = :idTpantplan")
    , @NamedQuery(name = "Sic1sclaseeven.findByIdTdettarea", query = "SELECT s FROM Sic1sclaseeven s WHERE s.idTdettarea = :idTdettarea")
    , @NamedQuery(name = "Sic1sclaseeven.findByNumMaxiplazobse", query = "SELECT s FROM Sic1sclaseeven s WHERE s.numMaxiplazobse = :numMaxiplazobse")
    , @NamedQuery(name = "Sic1sclaseeven.findByDesBaselegal", query = "SELECT s FROM Sic1sclaseeven s WHERE s.desBaselegal = :desBaselegal")
    , @NamedQuery(name = "Sic1sclaseeven.findByIdSgrupsclaseeven", query = "SELECT s FROM Sic1sclaseeven s WHERE s.idSgrupsclaseeven = :idSgrupsclaseeven")
    , @NamedQuery(name = "Sic1sclaseeven.findByCodMenunive0", query = "SELECT s FROM Sic1sclaseeven s WHERE s.codMenunive0 = :codMenunive0")
    , @NamedQuery(name = "Sic1sclaseeven.findByFlgMenunive0", query = "SELECT s FROM Sic1sclaseeven s WHERE s.flgMenunive0 = :flgMenunive0")
    , @NamedQuery(name = "Sic1sclaseeven.findByCodMenunive1", query = "SELECT s FROM Sic1sclaseeven s WHERE s.codMenunive1 = :codMenunive1")
    , @NamedQuery(name = "Sic1sclaseeven.findByFlgMenunive1", query = "SELECT s FROM Sic1sclaseeven s WHERE s.flgMenunive1 = :flgMenunive1")
    , @NamedQuery(name = "Sic1sclaseeven.findByCodMenunive2", query = "SELECT s FROM Sic1sclaseeven s WHERE s.codMenunive2 = :codMenunive2")
    , @NamedQuery(name = "Sic1sclaseeven.findByFlgMenunive2", query = "SELECT s FROM Sic1sclaseeven s WHERE s.flgMenunive2 = :flgMenunive2")
    , @NamedQuery(name = "Sic1sclaseeven.findByDesMenu", query = "SELECT s FROM Sic1sclaseeven s WHERE s.desMenu = :desMenu")
    , @NamedQuery(name = "Sic1sclaseeven.findByNumOrdenmenu", query = "SELECT s FROM Sic1sclaseeven s WHERE s.numOrdenmenu = :numOrdenmenu")
    , @NamedQuery(name = "Sic1sclaseeven.findByFlgEselim", query = "SELECT s FROM Sic1sclaseeven s WHERE s.flgEselim = :flgEselim")
    , @NamedQuery(name = "Sic1sclaseeven.findByNumDiasexteplaz", query = "SELECT s FROM Sic1sclaseeven s WHERE s.numDiasexteplaz = :numDiasexteplaz")
    , @NamedQuery(name = "Sic1sclaseeven.findByNumDiaspresrecu", query = "SELECT s FROM Sic1sclaseeven s WHERE s.numDiaspresrecu = :numDiaspresrecu")
    , @NamedQuery(name = "Sic1sclaseeven.findByFlgResoofic", query = "SELECT s FROM Sic1sclaseeven s WHERE s.flgResoofic = :flgResoofic")
    , @NamedQuery(name = "Sic1sclaseeven.findByIdStipocodiautoasig", query = "SELECT s FROM Sic1sclaseeven s WHERE s.idStipocodiautoasig = :idStipocodiautoasig")
    , @NamedQuery(name = "Sic1sclaseeven.findByNumMesesvige", query = "SELECT s FROM Sic1sclaseeven s WHERE s.numMesesvige = :numMesesvige")
    , @NamedQuery(name = "Sic1sclaseeven.findByFlgEjecproc", query = "SELECT s FROM Sic1sclaseeven s WHERE s.flgEjecproc = :flgEjecproc")
    , @NamedQuery(name = "Sic1sclaseeven.findByCodProc", query = "SELECT s FROM Sic1sclaseeven s WHERE s.codProc = :codProc")
    , @NamedQuery(name = "Sic1sclaseeven.findByFlgCreacodiauto", query = "SELECT s FROM Sic1sclaseeven s WHERE s.flgCreacodiauto = :flgCreacodiauto")
    , @NamedQuery(name = "Sic1sclaseeven.findByDesVistcodiauto", query = "SELECT s FROM Sic1sclaseeven s WHERE s.desVistcodiauto = :desVistcodiauto")
    , @NamedQuery(name = "Sic1sclaseeven.findByFlgVistcodiauto", query = "SELECT s FROM Sic1sclaseeven s WHERE s.flgVistcodiauto = :flgVistcodiauto")
    , @NamedQuery(name = "Sic1sclaseeven.findByDesVistsele", query = "SELECT s FROM Sic1sclaseeven s WHERE s.desVistsele = :desVistsele")
    , @NamedQuery(name = "Sic1sclaseeven.findByFlgVistsele", query = "SELECT s FROM Sic1sclaseeven s WHERE s.flgVistsele = :flgVistsele")
    , @NamedQuery(name = "Sic1sclaseeven.findByRutaResodesf", query = "SELECT s FROM Sic1sclaseeven s WHERE s.rutaResodesf = :rutaResodesf")
    , @NamedQuery(name = "Sic1sclaseeven.findByPlantResodesf", query = "SELECT s FROM Sic1sclaseeven s WHERE s.plantResodesf = :plantResodesf")
    , @NamedQuery(name = "Sic1sclaseeven.findByRutaResoerromate", query = "SELECT s FROM Sic1sclaseeven s WHERE s.rutaResoerromate = :rutaResoerromate")
    , @NamedQuery(name = "Sic1sclaseeven.findByPlantResoerromate", query = "SELECT s FROM Sic1sclaseeven s WHERE s.plantResoerromate = :plantResoerromate")
    , @NamedQuery(name = "Sic1sclaseeven.findByDesNotititulo", query = "SELECT s FROM Sic1sclaseeven s WHERE s.desNotititulo = :desNotititulo")
    , @NamedQuery(name = "Sic1sclaseeven.findByFlgNoti", query = "SELECT s FROM Sic1sclaseeven s WHERE s.flgNoti = :flgNoti")
    , @NamedQuery(name = "Sic1sclaseeven.findByNumPorcuit", query = "SELECT s FROM Sic1sclaseeven s WHERE s.numPorcuit = :numPorcuit")
    , @NamedQuery(name = "Sic1sclaseeven.findByNumPeso", query = "SELECT s FROM Sic1sclaseeven s WHERE s.numPeso = :numPeso")
    , @NamedQuery(name = "Sic1sclaseeven.findByDesNotimensaje", query = "SELECT s FROM Sic1sclaseeven s WHERE s.desNotimensaje = :desNotimensaje")
    , @NamedQuery(name = "Sic1sclaseeven.findByFlgInicinsp", query = "SELECT s FROM Sic1sclaseeven s WHERE s.flgInicinsp = :flgInicinsp")
    , @NamedQuery(name = "Sic1sclaseeven.findByFlgModautoexp", query = "SELECT s FROM Sic1sclaseeven s WHERE s.flgModautoexp = :flgModautoexp")
    , @NamedQuery(name = "Sic1sclaseeven.findByFlgTipoaccCodAuto", query = "SELECT s FROM Sic1sclaseeven s WHERE s.flgTipoaccCodAuto = :flgTipoaccCodAuto")
    , @NamedQuery(name = "Sic1sclaseeven.findByFlgTiposala", query = "SELECT s FROM Sic1sclaseeven s WHERE s.flgTiposala = :flgTiposala")})
public class Sic1sclaseeven implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_SCLASEEVEN")
    private BigDecimal idSclaseeven;
    @Column(name = "DES_SCLASEEVEN")
    private String desSclaseeven;
    @Basic(optional = false)
    @Column(name = "COD_SCLASEEVEN")
    private String codSclaseeven;
    @Column(name = "ID_TIPOFORMATO")
    private BigInteger idTipoformato;
    @Column(name = "ID_TIPOSOLI")
    private BigInteger idTiposoli;
    @Column(name = "ID_CLASEEVEN")
    private BigInteger idClaseeven;
    @Column(name = "DES_NOTAS")
    private String desNotas;
    @Column(name = "COD_NUMTUPA")
    private String codNumtupa;
    @Column(name = "NUM_DIAPLAZO")
    private BigInteger numDiaplazo;
    @Column(name = "FLG_SILEADMI")
    private BigInteger flgSileadmi;
    @Column(name = "FLG_EVALLEGA")
    private BigInteger flgEvallega;
    @Column(name = "FLG_EVALFINA")
    private BigInteger flgEvalfina;
    @Column(name = "FLG_EVALTECN")
    private BigInteger flgEvaltecn;
    @Column(name = "FLG_EVALINSP")
    private BigInteger flgEvalinsp;
    @Column(name = "FLG_SINEVAL")
    private BigInteger flgSineval;
    @Column(name = "FLG_MULTINST")
    private BigInteger flgMultinst;
    @Column(name = "RUTA_INFOLEGA")
    private String rutaInfolega;
    @Column(name = "RUTA_INFOFINA")
    private String rutaInfofina;
    @Column(name = "RUTA_INFOTECN")
    private String rutaInfotecn;
    @Column(name = "RUTA_RESO")
    private String rutaReso;
    @Column(name = "RUTA_OBSE")
    private String rutaObse;
    @Column(name = "PLANT_INFOLEGA")
    private String plantInfolega;
    @Column(name = "PLANT_INFOFINA")
    private String plantInfofina;
    @Column(name = "PLANT_INFOTECN")
    private String plantInfotecn;
    @Column(name = "PLANT_RESO")
    private String plantReso;
    @Column(name = "PLANT_OBSE")
    private String plantObse;
    @Column(name = "FLG_ELIMINADO")
    private BigInteger flgEliminado;
    @Column(name = "FLG_RESO")
    private BigInteger flgReso;
    @Column(name = "FLG_PLAN")
    private BigInteger flgPlan;
    @Column(name = "ID_TPANTPLAN")
    private BigInteger idTpantplan;
    @Column(name = "ID_TDETTAREA")
    private BigInteger idTdettarea;
    @Column(name = "NUM_MAXIPLAZOBSE")
    private BigInteger numMaxiplazobse;
    @Column(name = "DES_BASELEGAL")
    private String desBaselegal;
    @Column(name = "ID_SGRUPSCLASEEVEN")
    private Integer idSgrupsclaseeven;
    @Column(name = "COD_MENUNIVE0")
    private String codMenunive0;
    @Column(name = "FLG_MENUNIVE0")
    private BigInteger flgMenunive0;
    @Column(name = "COD_MENUNIVE1")
    private String codMenunive1;
    @Column(name = "FLG_MENUNIVE1")
    private BigInteger flgMenunive1;
    @Column(name = "COD_MENUNIVE2")
    private String codMenunive2;
    @Column(name = "FLG_MENUNIVE2")
    private BigInteger flgMenunive2;
    @Column(name = "DES_MENU")
    private String desMenu;
    @Column(name = "NUM_ORDENMENU")
    private BigInteger numOrdenmenu;
    @Column(name = "FLG_ESELIM")
    private BigInteger flgEselim;
    @Column(name = "NUM_DIASEXTEPLAZ")
    private BigInteger numDiasexteplaz;
    @Column(name = "NUM_DIASPRESRECU")
    private BigInteger numDiaspresrecu;
    @Column(name = "FLG_RESOOFIC")
    private Short flgResoofic;
    @Column(name = "ID_STIPOCODIAUTOASIG")
    private BigInteger idStipocodiautoasig;
    @Column(name = "NUM_MESESVIGE")
    private BigInteger numMesesvige;
    @Column(name = "FLG_EJECPROC")
    private BigInteger flgEjecproc;
    @Column(name = "COD_PROC")
    private String codProc;
    @Column(name = "FLG_CREACODIAUTO")
    private BigInteger flgCreacodiauto;
    @Column(name = "DES_VISTCODIAUTO")
    private String desVistcodiauto;
    @Column(name = "FLG_VISTCODIAUTO")
    private BigInteger flgVistcodiauto;
    @Column(name = "DES_VISTSELE")
    private String desVistsele;
    @Column(name = "FLG_VISTSELE")
    private BigInteger flgVistsele;
    @Column(name = "RUTA_RESODESF")
    private String rutaResodesf;
    @Column(name = "PLANT_RESODESF")
    private String plantResodesf;
    @Column(name = "RUTA_RESOERROMATE")
    private String rutaResoerromate;
    @Column(name = "PLANT_RESOERROMATE")
    private String plantResoerromate;
    @Column(name = "DES_NOTITITULO")
    private String desNotititulo;
    @Column(name = "FLG_NOTI")
    private Short flgNoti;
    @Column(name = "NUM_PORCUIT")
    private BigInteger numPorcuit;
    @Column(name = "NUM_PESO")
    private BigInteger numPeso;
    @Column(name = "DES_NOTIMENSAJE")
    private String desNotimensaje;
    @Column(name = "FLG_INICINSP")
    private Short flgInicinsp;
    @Column(name = "FLG_MODAUTOEXP")
    private Short flgModautoexp;
    @Column(name = "FLG_TIPOACC_COD_AUTO")
    private Short flgTipoaccCodAuto;
    @Column(name = "FLG_TIPOSALA")
    private Short flgTiposala;
    @OneToMany(mappedBy = "idSclaseeven")
    private Collection<Sic1even> sic1evenCollection;
    
    /*Agregado*/
    private String desSgrupsclaseeven;
    private String[] arrIdSclaseeven; //Se utiliza como parametro para reporte

    public Sic1sclaseeven() {
    }

    public Sic1sclaseeven(BigDecimal idSclaseeven) {
        this.idSclaseeven = idSclaseeven;
    }

    public Sic1sclaseeven(BigDecimal idSclaseeven, String codSclaseeven) {
        this.idSclaseeven = idSclaseeven;
        this.codSclaseeven = codSclaseeven;
    }

    public BigDecimal getIdSclaseeven() {
        return idSclaseeven;
    }

    public void setIdSclaseeven(BigDecimal idSclaseeven) {
        this.idSclaseeven = idSclaseeven;
    }

    public String getDesSclaseeven() {
        return desSclaseeven;
    }

    public void setDesSclaseeven(String desSclaseeven) {
        this.desSclaseeven = desSclaseeven;
    }

    public String getCodSclaseeven() {
        return codSclaseeven;
    }

    public void setCodSclaseeven(String codSclaseeven) {
        this.codSclaseeven = codSclaseeven;
    }

    public BigInteger getIdTipoformato() {
        return idTipoformato;
    }

    public void setIdTipoformato(BigInteger idTipoformato) {
        this.idTipoformato = idTipoformato;
    }

    public BigInteger getIdTiposoli() {
        return idTiposoli;
    }

    public void setIdTiposoli(BigInteger idTiposoli) {
        this.idTiposoli = idTiposoli;
    }

    public BigInteger getIdClaseeven() {
        return idClaseeven;
    }

    public void setIdClaseeven(BigInteger idClaseeven) {
        this.idClaseeven = idClaseeven;
    }

    public String getDesNotas() {
        return desNotas;
    }

    public void setDesNotas(String desNotas) {
        this.desNotas = desNotas;
    }

    public String getCodNumtupa() {
        return codNumtupa;
    }

    public void setCodNumtupa(String codNumtupa) {
        this.codNumtupa = codNumtupa;
    }

    public BigInteger getNumDiaplazo() {
        return numDiaplazo;
    }

    public void setNumDiaplazo(BigInteger numDiaplazo) {
        this.numDiaplazo = numDiaplazo;
    }

    public BigInteger getFlgSileadmi() {
        return flgSileadmi;
    }

    public void setFlgSileadmi(BigInteger flgSileadmi) {
        this.flgSileadmi = flgSileadmi;
    }

    public BigInteger getFlgEvallega() {
        return flgEvallega;
    }

    public void setFlgEvallega(BigInteger flgEvallega) {
        this.flgEvallega = flgEvallega;
    }

    public BigInteger getFlgEvalfina() {
        return flgEvalfina;
    }

    public void setFlgEvalfina(BigInteger flgEvalfina) {
        this.flgEvalfina = flgEvalfina;
    }

    public BigInteger getFlgEvaltecn() {
        return flgEvaltecn;
    }

    public void setFlgEvaltecn(BigInteger flgEvaltecn) {
        this.flgEvaltecn = flgEvaltecn;
    }

    public BigInteger getFlgEvalinsp() {
        return flgEvalinsp;
    }

    public void setFlgEvalinsp(BigInteger flgEvalinsp) {
        this.flgEvalinsp = flgEvalinsp;
    }

    public BigInteger getFlgSineval() {
        return flgSineval;
    }

    public void setFlgSineval(BigInteger flgSineval) {
        this.flgSineval = flgSineval;
    }

    public BigInteger getFlgMultinst() {
        return flgMultinst;
    }

    public void setFlgMultinst(BigInteger flgMultinst) {
        this.flgMultinst = flgMultinst;
    }

    public String getRutaInfolega() {
        return rutaInfolega;
    }

    public void setRutaInfolega(String rutaInfolega) {
        this.rutaInfolega = rutaInfolega;
    }

    public String getRutaInfofina() {
        return rutaInfofina;
    }

    public void setRutaInfofina(String rutaInfofina) {
        this.rutaInfofina = rutaInfofina;
    }

    public String getRutaInfotecn() {
        return rutaInfotecn;
    }

    public void setRutaInfotecn(String rutaInfotecn) {
        this.rutaInfotecn = rutaInfotecn;
    }

    public String getRutaReso() {
        return rutaReso;
    }

    public void setRutaReso(String rutaReso) {
        this.rutaReso = rutaReso;
    }

    public String getRutaObse() {
        return rutaObse;
    }

    public void setRutaObse(String rutaObse) {
        this.rutaObse = rutaObse;
    }

    public String getPlantInfolega() {
        return plantInfolega;
    }

    public void setPlantInfolega(String plantInfolega) {
        this.plantInfolega = plantInfolega;
    }

    public String getPlantInfofina() {
        return plantInfofina;
    }

    public void setPlantInfofina(String plantInfofina) {
        this.plantInfofina = plantInfofina;
    }

    public String getPlantInfotecn() {
        return plantInfotecn;
    }

    public void setPlantInfotecn(String plantInfotecn) {
        this.plantInfotecn = plantInfotecn;
    }

    public String getPlantReso() {
        return plantReso;
    }

    public void setPlantReso(String plantReso) {
        this.plantReso = plantReso;
    }

    public String getPlantObse() {
        return plantObse;
    }

    public void setPlantObse(String plantObse) {
        this.plantObse = plantObse;
    }

    public BigInteger getFlgEliminado() {
        return flgEliminado;
    }

    public void setFlgEliminado(BigInteger flgEliminado) {
        this.flgEliminado = flgEliminado;
    }

    public BigInteger getFlgReso() {
        return flgReso;
    }

    public void setFlgReso(BigInteger flgReso) {
        this.flgReso = flgReso;
    }

    public BigInteger getFlgPlan() {
        return flgPlan;
    }

    public void setFlgPlan(BigInteger flgPlan) {
        this.flgPlan = flgPlan;
    }

    public BigInteger getIdTpantplan() {
        return idTpantplan;
    }

    public void setIdTpantplan(BigInteger idTpantplan) {
        this.idTpantplan = idTpantplan;
    }

    public BigInteger getIdTdettarea() {
        return idTdettarea;
    }

    public void setIdTdettarea(BigInteger idTdettarea) {
        this.idTdettarea = idTdettarea;
    }

    public BigInteger getNumMaxiplazobse() {
        return numMaxiplazobse;
    }

    public void setNumMaxiplazobse(BigInteger numMaxiplazobse) {
        this.numMaxiplazobse = numMaxiplazobse;
    }

    public String getDesBaselegal() {
        return desBaselegal;
    }

    public void setDesBaselegal(String desBaselegal) {
        this.desBaselegal = desBaselegal;
    }

    public Integer getIdSgrupsclaseeven() {
        return idSgrupsclaseeven;
    }

    public void setIdSgrupsclaseeven(Integer idSgrupsclaseeven) {
        this.idSgrupsclaseeven = idSgrupsclaseeven;
    }

    public String getCodMenunive0() {
        return codMenunive0;
    }

    public void setCodMenunive0(String codMenunive0) {
        this.codMenunive0 = codMenunive0;
    }

    public BigInteger getFlgMenunive0() {
        return flgMenunive0;
    }

    public void setFlgMenunive0(BigInteger flgMenunive0) {
        this.flgMenunive0 = flgMenunive0;
    }

    public String getCodMenunive1() {
        return codMenunive1;
    }

    public void setCodMenunive1(String codMenunive1) {
        this.codMenunive1 = codMenunive1;
    }

    public BigInteger getFlgMenunive1() {
        return flgMenunive1;
    }

    public void setFlgMenunive1(BigInteger flgMenunive1) {
        this.flgMenunive1 = flgMenunive1;
    }

    public String getCodMenunive2() {
        return codMenunive2;
    }

    public void setCodMenunive2(String codMenunive2) {
        this.codMenunive2 = codMenunive2;
    }

    public BigInteger getFlgMenunive2() {
        return flgMenunive2;
    }

    public void setFlgMenunive2(BigInteger flgMenunive2) {
        this.flgMenunive2 = flgMenunive2;
    }

    public String getDesMenu() {
        return desMenu;
    }

    public void setDesMenu(String desMenu) {
        this.desMenu = desMenu;
    }

    public BigInteger getNumOrdenmenu() {
        return numOrdenmenu;
    }

    public void setNumOrdenmenu(BigInteger numOrdenmenu) {
        this.numOrdenmenu = numOrdenmenu;
    }

    public BigInteger getFlgEselim() {
        return flgEselim;
    }

    public void setFlgEselim(BigInteger flgEselim) {
        this.flgEselim = flgEselim;
    }

    public BigInteger getNumDiasexteplaz() {
        return numDiasexteplaz;
    }

    public void setNumDiasexteplaz(BigInteger numDiasexteplaz) {
        this.numDiasexteplaz = numDiasexteplaz;
    }

    public BigInteger getNumDiaspresrecu() {
        return numDiaspresrecu;
    }

    public void setNumDiaspresrecu(BigInteger numDiaspresrecu) {
        this.numDiaspresrecu = numDiaspresrecu;
    }

    public Short getFlgResoofic() {
        return flgResoofic;
    }

    public void setFlgResoofic(Short flgResoofic) {
        this.flgResoofic = flgResoofic;
    }

    public BigInteger getIdStipocodiautoasig() {
        return idStipocodiautoasig;
    }

    public void setIdStipocodiautoasig(BigInteger idStipocodiautoasig) {
        this.idStipocodiautoasig = idStipocodiautoasig;
    }

    public BigInteger getNumMesesvige() {
        return numMesesvige;
    }

    public void setNumMesesvige(BigInteger numMesesvige) {
        this.numMesesvige = numMesesvige;
    }

    public BigInteger getFlgEjecproc() {
        return flgEjecproc;
    }

    public void setFlgEjecproc(BigInteger flgEjecproc) {
        this.flgEjecproc = flgEjecproc;
    }

    public String getCodProc() {
        return codProc;
    }

    public void setCodProc(String codProc) {
        this.codProc = codProc;
    }

    public BigInteger getFlgCreacodiauto() {
        return flgCreacodiauto;
    }

    public void setFlgCreacodiauto(BigInteger flgCreacodiauto) {
        this.flgCreacodiauto = flgCreacodiauto;
    }

    public String getDesVistcodiauto() {
        return desVistcodiauto;
    }

    public void setDesVistcodiauto(String desVistcodiauto) {
        this.desVistcodiauto = desVistcodiauto;
    }

    public BigInteger getFlgVistcodiauto() {
        return flgVistcodiauto;
    }

    public void setFlgVistcodiauto(BigInteger flgVistcodiauto) {
        this.flgVistcodiauto = flgVistcodiauto;
    }

    public String getDesVistsele() {
        return desVistsele;
    }

    public void setDesVistsele(String desVistsele) {
        this.desVistsele = desVistsele;
    }

    public BigInteger getFlgVistsele() {
        return flgVistsele;
    }

    public void setFlgVistsele(BigInteger flgVistsele) {
        this.flgVistsele = flgVistsele;
    }

    public String getRutaResodesf() {
        return rutaResodesf;
    }

    public void setRutaResodesf(String rutaResodesf) {
        this.rutaResodesf = rutaResodesf;
    }

    public String getPlantResodesf() {
        return plantResodesf;
    }

    public void setPlantResodesf(String plantResodesf) {
        this.plantResodesf = plantResodesf;
    }

    public String getRutaResoerromate() {
        return rutaResoerromate;
    }

    public void setRutaResoerromate(String rutaResoerromate) {
        this.rutaResoerromate = rutaResoerromate;
    }

    public String getPlantResoerromate() {
        return plantResoerromate;
    }

    public void setPlantResoerromate(String plantResoerromate) {
        this.plantResoerromate = plantResoerromate;
    }

    public String getDesNotititulo() {
        return desNotititulo;
    }

    public void setDesNotititulo(String desNotititulo) {
        this.desNotititulo = desNotititulo;
    }

    public Short getFlgNoti() {
        return flgNoti;
    }

    public void setFlgNoti(Short flgNoti) {
        this.flgNoti = flgNoti;
    }

    public BigInteger getNumPorcuit() {
        return numPorcuit;
    }

    public void setNumPorcuit(BigInteger numPorcuit) {
        this.numPorcuit = numPorcuit;
    }

    public BigInteger getNumPeso() {
        return numPeso;
    }

    public void setNumPeso(BigInteger numPeso) {
        this.numPeso = numPeso;
    }

    public String getDesNotimensaje() {
        return desNotimensaje;
    }

    public void setDesNotimensaje(String desNotimensaje) {
        this.desNotimensaje = desNotimensaje;
    }

    public Short getFlgInicinsp() {
        return flgInicinsp;
    }

    public void setFlgInicinsp(Short flgInicinsp) {
        this.flgInicinsp = flgInicinsp;
    }

    public Short getFlgModautoexp() {
        return flgModautoexp;
    }

    public void setFlgModautoexp(Short flgModautoexp) {
        this.flgModautoexp = flgModautoexp;
    }

    public Short getFlgTipoaccCodAuto() {
        return flgTipoaccCodAuto;
    }

    public void setFlgTipoaccCodAuto(Short flgTipoaccCodAuto) {
        this.flgTipoaccCodAuto = flgTipoaccCodAuto;
    }

    public Short getFlgTiposala() {
        return flgTiposala;
    }

    public void setFlgTiposala(Short flgTiposala) {
        this.flgTiposala = flgTiposala;
    }

    public String getDesSgrupsclaseeven() {
        return desSgrupsclaseeven;
    }

    public void setDesSgrupsclaseeven(String desSgrupsclaseeven) {
        this.desSgrupsclaseeven = desSgrupsclaseeven;
    }

    public String[] getArrIdSclaseeven() {
        return arrIdSclaseeven;
    }

    public void setArrIdSclaseeven(String[] arrIdSclaseeven) {
        this.arrIdSclaseeven = arrIdSclaseeven;
    }
    
    
    

    @XmlTransient
    public Collection<Sic1even> getSic1evenCollection() {
        return sic1evenCollection;
    }

    public void setSic1evenCollection(Collection<Sic1even> sic1evenCollection) {
        this.sic1evenCollection = sic1evenCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSclaseeven != null ? idSclaseeven.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sic1sclaseeven)) {
            return false;
        }
        Sic1sclaseeven other = (Sic1sclaseeven) object;
        if ((this.idSclaseeven == null && other.idSclaseeven != null) || (this.idSclaseeven != null && !this.idSclaseeven.equals(other.idSclaseeven))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.general.entity.Sic1sclaseeven[ idSclaseeven=" + idSclaseeven + " ]";
    }
    
}
