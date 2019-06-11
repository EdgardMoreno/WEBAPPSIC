/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author emoreno
 */
@Entity
@Table(name = "SIC1STIPODOCU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sic1stipodocu.findAll", query = "SELECT s FROM Sic1stipodocu s")
    , @NamedQuery(name = "Sic1stipodocu.findByIdStipodocu", query = "SELECT s FROM Sic1stipodocu s WHERE s.idStipodocu = :idStipodocu")
    , @NamedQuery(name = "Sic1stipodocu.findByDesStipodocu", query = "SELECT s FROM Sic1stipodocu s WHERE s.desStipodocu = :desStipodocu")
    , @NamedQuery(name = "Sic1stipodocu.findByCodStipodocu", query = "SELECT s FROM Sic1stipodocu s WHERE s.codStipodocu = :codStipodocu")
    , @NamedQuery(name = "Sic1stipodocu.findByIdTipodocu", query = "SELECT s FROM Sic1stipodocu s WHERE s.idTipodocu = :idTipodocu")
    , @NamedQuery(name = "Sic1stipodocu.findByFlgVigencia", query = "SELECT s FROM Sic1stipodocu s WHERE s.flgVigencia = :flgVigencia")
    , @NamedQuery(name = "Sic1stipodocu.findByFlgDatos", query = "SELECT s FROM Sic1stipodocu s WHERE s.flgDatos = :flgDatos")
    , @NamedQuery(name = "Sic1stipodocu.findByDesUrlformdatos", query = "SELECT s FROM Sic1stipodocu s WHERE s.desUrlformdatos = :desUrlformdatos")
    , @NamedQuery(name = "Sic1stipodocu.findByFlgImportaexcel", query = "SELECT s FROM Sic1stipodocu s WHERE s.flgImportaexcel = :flgImportaexcel")
    , @NamedQuery(name = "Sic1stipodocu.findByFlgTienedocbinario", query = "SELECT s FROM Sic1stipodocu s WHERE s.flgTienedocbinario = :flgTienedocbinario")
    , @NamedQuery(name = "Sic1stipodocu.findByDesUriexcel", query = "SELECT s FROM Sic1stipodocu s WHERE s.desUriexcel = :desUriexcel")
    , @NamedQuery(name = "Sic1stipodocu.findByCodTipoexcel", query = "SELECT s FROM Sic1stipodocu s WHERE s.codTipoexcel = :codTipoexcel")
    , @NamedQuery(name = "Sic1stipodocu.findByIdTrolentigobi", query = "SELECT s FROM Sic1stipodocu s WHERE s.idTrolentigobi = :idTrolentigobi")
    , @NamedQuery(name = "Sic1stipodocu.findByIdEntigobi", query = "SELECT s FROM Sic1stipodocu s WHERE s.idEntigobi = :idEntigobi")
    , @NamedQuery(name = "Sic1stipodocu.findByFlgReusable", query = "SELECT s FROM Sic1stipodocu s WHERE s.flgReusable = :flgReusable")
    , @NamedQuery(name = "Sic1stipodocu.findByFlgPersnatu", query = "SELECT s FROM Sic1stipodocu s WHERE s.flgPersnatu = :flgPersnatu")
    , @NamedQuery(name = "Sic1stipodocu.findByFlgDomi", query = "SELECT s FROM Sic1stipodocu s WHERE s.flgDomi = :flgDomi")
    , @NamedQuery(name = "Sic1stipodocu.findByFlgPersjuri", query = "SELECT s FROM Sic1stipodocu s WHERE s.flgPersjuri = :flgPersjuri")
    , @NamedQuery(name = "Sic1stipodocu.findByFlgNodomi", query = "SELECT s FROM Sic1stipodocu s WHERE s.flgNodomi = :flgNodomi")
    , @NamedQuery(name = "Sic1stipodocu.findByDesPasoobte", query = "SELECT s FROM Sic1stipodocu s WHERE s.desPasoobte = :desPasoobte")
    , @NamedQuery(name = "Sic1stipodocu.findByDesTiempoprom", query = "SELECT s FROM Sic1stipodocu s WHERE s.desTiempoprom = :desTiempoprom")
    , @NamedQuery(name = "Sic1stipodocu.findByDesUrlentidad", query = "SELECT s FROM Sic1stipodocu s WHERE s.desUrlentidad = :desUrlentidad")
    , @NamedQuery(name = "Sic1stipodocu.findByFlgUrltipo", query = "SELECT s FROM Sic1stipodocu s WHERE s.flgUrltipo = :flgUrltipo")
    , @NamedQuery(name = "Sic1stipodocu.findByCodSclaseevenasoc", query = "SELECT s FROM Sic1stipodocu s WHERE s.codSclaseevenasoc = :codSclaseevenasoc")
    , @NamedQuery(name = "Sic1stipodocu.findByDesLeyfisc", query = "SELECT s FROM Sic1stipodocu s WHERE s.desLeyfisc = :desLeyfisc")
    , @NamedQuery(name = "Sic1stipodocu.findByFlgSancinca", query = "SELECT s FROM Sic1stipodocu s WHERE s.flgSancinca = :flgSancinca")
    , @NamedQuery(name = "Sic1stipodocu.findByFlgSancdias", query = "SELECT s FROM Sic1stipodocu s WHERE s.flgSancdias = :flgSancdias")
    , @NamedQuery(name = "Sic1stipodocu.findByFlgSancmulta", query = "SELECT s FROM Sic1stipodocu s WHERE s.flgSancmulta = :flgSancmulta")
    , @NamedQuery(name = "Sic1stipodocu.findByFlgSancotra", query = "SELECT s FROM Sic1stipodocu s WHERE s.flgSancotra = :flgSancotra")
    , @NamedQuery(name = "Sic1stipodocu.findByIdSanctipotras", query = "SELECT s FROM Sic1stipodocu s WHERE s.idSanctipotras = :idSanctipotras")
    , @NamedQuery(name = "Sic1stipodocu.findByIdSanctiposusp", query = "SELECT s FROM Sic1stipodocu s WHERE s.idSanctiposusp = :idSanctiposusp")
    , @NamedQuery(name = "Sic1stipodocu.findByNumSancmulta", query = "SELECT s FROM Sic1stipodocu s WHERE s.numSancmulta = :numSancmulta")
    , @NamedQuery(name = "Sic1stipodocu.findByNumSancdias", query = "SELECT s FROM Sic1stipodocu s WHERE s.numSancdias = :numSancdias")
    , @NamedQuery(name = "Sic1stipodocu.findByIdSancotras", query = "SELECT s FROM Sic1stipodocu s WHERE s.idSancotras = :idSancotras")
    , @NamedQuery(name = "Sic1stipodocu.findByIdStiposanc", query = "SELECT s FROM Sic1stipodocu s WHERE s.idStiposanc = :idStiposanc")
    , @NamedQuery(name = "Sic1stipodocu.findByIdSancmedicorr", query = "SELECT s FROM Sic1stipodocu s WHERE s.idSancmedicorr = :idSancmedicorr")
    , @NamedQuery(name = "Sic1stipodocu.findByIdSancambi", query = "SELECT s FROM Sic1stipodocu s WHERE s.idSancambi = :idSancambi")
    , @NamedQuery(name = "Sic1stipodocu.findByFlgDatogene", query = "SELECT s FROM Sic1stipodocu s WHERE s.flgDatogene = :flgDatogene")
    , @NamedQuery(name = "Sic1stipodocu.findByIdTrolesta", query = "SELECT s FROM Sic1stipodocu s WHERE s.idTrolesta = :idTrolesta")
    , @NamedQuery(name = "Sic1stipodocu.findByFlgCreacodiauto", query = "SELECT s FROM Sic1stipodocu s WHERE s.flgCreacodiauto = :flgCreacodiauto")
    , @NamedQuery(name = "Sic1stipodocu.findByFlgSolofunc", query = "SELECT s FROM Sic1stipodocu s WHERE s.flgSolofunc = :flgSolofunc")
    , @NamedQuery(name = "Sic1stipodocu.findByFlgAcepdina", query = "SELECT s FROM Sic1stipodocu s WHERE s.flgAcepdina = :flgAcepdina")
    , @NamedQuery(name = "Sic1stipodocu.findByCodTabldestino", query = "SELECT s FROM Sic1stipodocu s WHERE s.codTabldestino = :codTabldestino")
    , @NamedQuery(name = "Sic1stipodocu.findByCodSqltablorigen", query = "SELECT s FROM Sic1stipodocu s WHERE s.codSqltablorigen = :codSqltablorigen")
    , @NamedQuery(name = "Sic1stipodocu.findByCodTablorigen", query = "SELECT s FROM Sic1stipodocu s WHERE s.codTablorigen = :codTablorigen")
    , @NamedQuery(name = "Sic1stipodocu.findByCodSqlprep", query = "SELECT s FROM Sic1stipodocu s WHERE s.codSqlprep = :codSqlprep")})
public class Sic1stipodocu implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_STIPODOCU")
    private Integer idStipodocu;
    @Size(max = 4000)
    @Column(name = "DES_STIPODOCU")
    private String desStipodocu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "COD_STIPODOCU")
    private String codStipodocu;
    @Column(name = "ID_TIPODOCU")
    private Integer idTipodocu;
    @Column(name = "FLG_VIGENCIA")
    private Integer flgVigencia;
    @Column(name = "FLG_DATOS")
    private Integer flgDatos;
    @Size(max = 250)
    @Column(name = "DES_URLFORMDATOS")
    private String desUrlformdatos;
    @Column(name = "FLG_IMPORTAEXCEL")
    private Integer flgImportaexcel;
    @Column(name = "FLG_TIENEDOCBINARIO")
    private Integer flgTienedocbinario;
    @Size(max = 250)
    @Column(name = "DES_URIEXCEL")
    private String desUriexcel;
    @Size(max = 250)
    @Column(name = "COD_TIPOEXCEL")
    private String codTipoexcel;
    @Column(name = "ID_TROLENTIGOBI")
    private BigInteger idTrolentigobi;
    @Column(name = "ID_ENTIGOBI")
    private BigInteger idEntigobi;
    @Column(name = "FLG_REUSABLE")
    private Integer flgReusable;
    @Column(name = "FLG_PERSNATU")
    private Integer flgPersnatu;
    @Column(name = "FLG_DOMI")
    private Integer flgDomi;
    @Column(name = "FLG_PERSJURI")
    private Integer flgPersjuri;
    @Column(name = "FLG_NODOMI")
    private Integer flgNodomi;
    @Size(max = 4000)
    @Column(name = "DES_PASOOBTE")
    private String desPasoobte;
    @Size(max = 4000)
    @Column(name = "DES_TIEMPOPROM")
    private String desTiempoprom;
    @Size(max = 4000)
    @Column(name = "DES_URLENTIDAD")
    private String desUrlentidad;
    @Column(name = "FLG_URLTIPO")
    private Integer flgUrltipo;
    @Size(max = 250)
    @Column(name = "COD_SCLASEEVENASOC")
    private String codSclaseevenasoc;
    @Size(max = 4000)
    @Column(name = "DES_LEYFISC")
    private String desLeyfisc;
    @Column(name = "FLG_SANCINCA")
    private Integer flgSancinca;
    @Column(name = "FLG_SANCDIAS")
    private Integer flgSancdias;
    @Column(name = "FLG_SANCMULTA")
    private Integer flgSancmulta;
    @Column(name = "FLG_SANCOTRA")
    private Integer flgSancotra;
    @Column(name = "ID_SANCTIPOTRAS")
    private Integer idSanctipotras;
    @Column(name = "ID_SANCTIPOSUSP")
    private Integer idSanctiposusp;
    @Column(name = "NUM_SANCMULTA")
    private BigDecimal numSancmulta;
    @Column(name = "NUM_SANCDIAS")
    private Integer numSancdias;
    @Column(name = "ID_SANCOTRAS")
    private Integer idSancotras;
    @Column(name = "ID_STIPOSANC")
    private Integer idStiposanc;
    @Column(name = "ID_SANCMEDICORR")
    private Integer idSancmedicorr;
    @Column(name = "ID_SANCAMBI")
    private Integer idSancambi;
    @Column(name = "FLG_DATOGENE")
    private Short flgDatogene;
    @Column(name = "ID_TROLESTA")
    private Integer idTrolesta;
    @Column(name = "FLG_CREACODIAUTO")
    private Short flgCreacodiauto;
    @Column(name = "FLG_SOLOFUNC")
    private Short flgSolofunc;
    @Column(name = "FLG_ACEPDINA")
    private Short flgAcepdina;
    @Size(max = 30)
    @Column(name = "COD_TABLDESTINO")
    private String codTabldestino;
    @Size(max = 4000)
    @Column(name = "COD_SQLTABLORIGEN")
    private String codSqltablorigen;
    @Size(max = 500)
    @Column(name = "COD_TABLORIGEN")
    private String codTablorigen;
    @Size(max = 500)
    @Column(name = "COD_SQLPREP")
    private String codSqlprep;

    /*********************************/
    /*AGREGADO*/
    private String desTipodocu;
    
    
    
    public Sic1stipodocu() {
    }

    public Sic1stipodocu(Integer idStipodocu) {
        this.idStipodocu = idStipodocu;
    }

    public Sic1stipodocu(Integer idStipodocu, String codStipodocu) {
        this.idStipodocu = idStipodocu;
        this.codStipodocu = codStipodocu;
    }

    public Integer getIdStipodocu() {
        return idStipodocu;
    }

    public void setIdStipodocu(Integer idStipodocu) {
        this.idStipodocu = idStipodocu;
    }

    public String getDesStipodocu() {
        return desStipodocu;
    }

    public void setDesStipodocu(String desStipodocu) {
        this.desStipodocu = desStipodocu;
    }

    public String getCodStipodocu() {
        return codStipodocu;
    }

    public void setCodStipodocu(String codStipodocu) {
        this.codStipodocu = codStipodocu;
    }

    public Integer getIdTipodocu() {
        return idTipodocu;
    }

    public void setIdTipodocu(Integer idTipodocu) {
        this.idTipodocu = idTipodocu;
    }

    public Integer getFlgVigencia() {
        return flgVigencia;
    }

    public void setFlgVigencia(Integer flgVigencia) {
        this.flgVigencia = flgVigencia;
    }

    public Integer getFlgDatos() {
        return flgDatos;
    }

    public void setFlgDatos(Integer flgDatos) {
        this.flgDatos = flgDatos;
    }

    public String getDesUrlformdatos() {
        return desUrlformdatos;
    }

    public void setDesUrlformdatos(String desUrlformdatos) {
        this.desUrlformdatos = desUrlformdatos;
    }

    public Integer getFlgImportaexcel() {
        return flgImportaexcel;
    }

    public void setFlgImportaexcel(Integer flgImportaexcel) {
        this.flgImportaexcel = flgImportaexcel;
    }

    public Integer getFlgTienedocbinario() {
        return flgTienedocbinario;
    }

    public void setFlgTienedocbinario(Integer flgTienedocbinario) {
        this.flgTienedocbinario = flgTienedocbinario;
    }

    public String getDesUriexcel() {
        return desUriexcel;
    }

    public void setDesUriexcel(String desUriexcel) {
        this.desUriexcel = desUriexcel;
    }

    public String getCodTipoexcel() {
        return codTipoexcel;
    }

    public void setCodTipoexcel(String codTipoexcel) {
        this.codTipoexcel = codTipoexcel;
    }

    public BigInteger getIdTrolentigobi() {
        return idTrolentigobi;
    }

    public void setIdTrolentigobi(BigInteger idTrolentigobi) {
        this.idTrolentigobi = idTrolentigobi;
    }

    public BigInteger getIdEntigobi() {
        return idEntigobi;
    }

    public void setIdEntigobi(BigInteger idEntigobi) {
        this.idEntigobi = idEntigobi;
    }

    public Integer getFlgReusable() {
        return flgReusable;
    }

    public void setFlgReusable(Integer flgReusable) {
        this.flgReusable = flgReusable;
    }

    public Integer getFlgPersnatu() {
        return flgPersnatu;
    }

    public void setFlgPersnatu(Integer flgPersnatu) {
        this.flgPersnatu = flgPersnatu;
    }

    public Integer getFlgDomi() {
        return flgDomi;
    }

    public void setFlgDomi(Integer flgDomi) {
        this.flgDomi = flgDomi;
    }

    public Integer getFlgPersjuri() {
        return flgPersjuri;
    }

    public void setFlgPersjuri(Integer flgPersjuri) {
        this.flgPersjuri = flgPersjuri;
    }

    public Integer getFlgNodomi() {
        return flgNodomi;
    }

    public void setFlgNodomi(Integer flgNodomi) {
        this.flgNodomi = flgNodomi;
    }

    public String getDesPasoobte() {
        return desPasoobte;
    }

    public void setDesPasoobte(String desPasoobte) {
        this.desPasoobte = desPasoobte;
    }

    public String getDesTiempoprom() {
        return desTiempoprom;
    }

    public void setDesTiempoprom(String desTiempoprom) {
        this.desTiempoprom = desTiempoprom;
    }

    public String getDesUrlentidad() {
        return desUrlentidad;
    }

    public void setDesUrlentidad(String desUrlentidad) {
        this.desUrlentidad = desUrlentidad;
    }

    public Integer getFlgUrltipo() {
        return flgUrltipo;
    }

    public void setFlgUrltipo(Integer flgUrltipo) {
        this.flgUrltipo = flgUrltipo;
    }

    public String getCodSclaseevenasoc() {
        return codSclaseevenasoc;
    }

    public void setCodSclaseevenasoc(String codSclaseevenasoc) {
        this.codSclaseevenasoc = codSclaseevenasoc;
    }

    public String getDesLeyfisc() {
        return desLeyfisc;
    }

    public void setDesLeyfisc(String desLeyfisc) {
        this.desLeyfisc = desLeyfisc;
    }

    public Integer getFlgSancinca() {
        return flgSancinca;
    }

    public void setFlgSancinca(Integer flgSancinca) {
        this.flgSancinca = flgSancinca;
    }

    public Integer getFlgSancdias() {
        return flgSancdias;
    }

    public void setFlgSancdias(Integer flgSancdias) {
        this.flgSancdias = flgSancdias;
    }

    public Integer getFlgSancmulta() {
        return flgSancmulta;
    }

    public void setFlgSancmulta(Integer flgSancmulta) {
        this.flgSancmulta = flgSancmulta;
    }

    public Integer getFlgSancotra() {
        return flgSancotra;
    }

    public void setFlgSancotra(Integer flgSancotra) {
        this.flgSancotra = flgSancotra;
    }

    public Integer getIdSanctipotras() {
        return idSanctipotras;
    }

    public void setIdSanctipotras(Integer idSanctipotras) {
        this.idSanctipotras = idSanctipotras;
    }

    public Integer getIdSanctiposusp() {
        return idSanctiposusp;
    }

    public void setIdSanctiposusp(Integer idSanctiposusp) {
        this.idSanctiposusp = idSanctiposusp;
    }

    public BigDecimal getNumSancmulta() {
        return numSancmulta;
    }

    public void setNumSancmulta(BigDecimal numSancmulta) {
        this.numSancmulta = numSancmulta;
    }

    public Integer getNumSancdias() {
        return numSancdias;
    }

    public void setNumSancdias(Integer numSancdias) {
        this.numSancdias = numSancdias;
    }

    public Integer getIdSancotras() {
        return idSancotras;
    }

    public void setIdSancotras(Integer idSancotras) {
        this.idSancotras = idSancotras;
    }

    public Integer getIdStiposanc() {
        return idStiposanc;
    }

    public void setIdStiposanc(Integer idStiposanc) {
        this.idStiposanc = idStiposanc;
    }

    public Integer getIdSancmedicorr() {
        return idSancmedicorr;
    }

    public void setIdSancmedicorr(Integer idSancmedicorr) {
        this.idSancmedicorr = idSancmedicorr;
    }

    public Integer getIdSancambi() {
        return idSancambi;
    }

    public void setIdSancambi(Integer idSancambi) {
        this.idSancambi = idSancambi;
    }

    public Short getFlgDatogene() {
        return flgDatogene;
    }

    public void setFlgDatogene(Short flgDatogene) {
        this.flgDatogene = flgDatogene;
    }

    public Integer getIdTrolesta() {
        return idTrolesta;
    }

    public void setIdTrolesta(Integer idTrolesta) {
        this.idTrolesta = idTrolesta;
    }

    public Short getFlgCreacodiauto() {
        return flgCreacodiauto;
    }

    public void setFlgCreacodiauto(Short flgCreacodiauto) {
        this.flgCreacodiauto = flgCreacodiauto;
    }

    public Short getFlgSolofunc() {
        return flgSolofunc;
    }

    public void setFlgSolofunc(Short flgSolofunc) {
        this.flgSolofunc = flgSolofunc;
    }

    public Short getFlgAcepdina() {
        return flgAcepdina;
    }

    public void setFlgAcepdina(Short flgAcepdina) {
        this.flgAcepdina = flgAcepdina;
    }

    public String getCodTabldestino() {
        return codTabldestino;
    }

    public void setCodTabldestino(String codTabldestino) {
        this.codTabldestino = codTabldestino;
    }

    public String getCodSqltablorigen() {
        return codSqltablorigen;
    }

    public void setCodSqltablorigen(String codSqltablorigen) {
        this.codSqltablorigen = codSqltablorigen;
    }

    public String getCodTablorigen() {
        return codTablorigen;
    }

    public void setCodTablorigen(String codTablorigen) {
        this.codTablorigen = codTablorigen;
    }

    public String getCodSqlprep() {
        return codSqlprep;
    }

    public void setCodSqlprep(String codSqlprep) {
        this.codSqlprep = codSqlprep;
    }

    public String getDesTipodocu() {
        return desTipodocu;
    }

    public void setDesTipodocu(String desTipodocu) {
        this.desTipodocu = desTipodocu;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStipodocu != null ? idStipodocu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sic1stipodocu)) {
            return false;
        }
        Sic1stipodocu other = (Sic1stipodocu) object;
        if ((this.idStipodocu == null && other.idStipodocu != null) || (this.idStipodocu != null && !this.idStipodocu.equals(other.idStipodocu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.general.entity.Sic1stipodocu[ idStipodocu=" + idStipodocu + " ]";
    }
    
}
