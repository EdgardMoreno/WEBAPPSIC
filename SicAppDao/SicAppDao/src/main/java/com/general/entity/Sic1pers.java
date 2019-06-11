/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
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
@Table(name = "SIC1PERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sic1pers.findAll", query = "SELECT s FROM Sic1pers s")
    , @NamedQuery(name = "Sic1pers.findByDesPers", query = "SELECT s FROM Sic1pers s WHERE s.desPers = :desPers")
    , @NamedQuery(name = "Sic1pers.findByIdTipopers", query = "SELECT s FROM Sic1pers s WHERE s.idTipopers = :idTipopers")
    , @NamedQuery(name = "Sic1pers.findByIdPers", query = "SELECT s FROM Sic1pers s WHERE s.idPers = :idPers")
    , @NamedQuery(name = "Sic1pers.findByIdTipodomi", query = "SELECT s FROM Sic1pers s WHERE s.idTipodomi = :idTipodomi")
    , @NamedQuery(name = "Sic1pers.findByIdPaisresi", query = "SELECT s FROM Sic1pers s WHERE s.idPaisresi = :idPaisresi")
    , @NamedQuery(name = "Sic1pers.findByDesCargoRep", query = "SELECT s FROM Sic1pers s WHERE s.desCargoRep = :desCargoRep")})
public class Sic1pers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "DES_PERS")
    private String desPers;
    @Column(name = "ID_TIPOPERS")
    private Integer idTipopers;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PERS")
    private BigDecimal idPers;
    @Column(name = "ID_TIPODOMI")
    private BigInteger idTipodomi;
    @Column(name = "ID_PAISRESI")
    private BigInteger idPaisresi;
    @Column(name = "DES_CARGO_REP")
    private String desCargoRep;
    @OneToMany(mappedBy = "idPers")
    private List<Sic1docu> sic1docuList;
    
    private String desTipopers;
    
    /*AGREGADO*/
    private Sic1idenpers sic1idenpers;
    private String[] arrIdpers; //Para consultar varios IdPers a la vez
    private Sic7persrol sic7persrol;
    private List<Sic7persrol> lstSic7persrol;
    

    public Sic1pers() {
    }

    public Sic1pers(BigDecimal idPers) {
        this.idPers = idPers;
    }

    public String getDesPers() {
        return desPers;
    }

    public void setDesPers(String desPers) {
        this.desPers = desPers;
    }

    public Integer getIdTipopers() {
        return idTipopers;
    }

    public void setIdTipopers(Integer idTipopers) {
        this.idTipopers = idTipopers;
    }

    public BigDecimal getIdPers() {
        return idPers;
    }

    public void setIdPers(BigDecimal idPers) {
        this.idPers = idPers;
    }

    public BigInteger getIdTipodomi() {
        return idTipodomi;
    }

    public void setIdTipodomi(BigInteger idTipodomi) {
        this.idTipodomi = idTipodomi;
    }

    public BigInteger getIdPaisresi() {
        return idPaisresi;
    }

    public void setIdPaisresi(BigInteger idPaisresi) {
        this.idPaisresi = idPaisresi;
    }

    public String getDesCargoRep() {
        return desCargoRep;
    }

    public void setDesCargoRep(String desCargoRep) {
        this.desCargoRep = desCargoRep;
    }

    @XmlTransient
    public List<Sic1docu> getSic1docuList() {
        return sic1docuList;
    }

    public void setSic1docuList(List<Sic1docu> sic1docuList) {
        this.sic1docuList = sic1docuList;
    }

    public Sic1idenpers getSic1idenpers() {
        return sic1idenpers;
    }

    public void setSic1idenpers(Sic1idenpers sic1idenpers) {
        this.sic1idenpers = sic1idenpers;
    }

    public String getDesTipopers() {
        return desTipopers;
    }

    public void setDesTipopers(String desTipopers) {
        this.desTipopers = desTipopers;
    }

    public String[] getArrIdpers() {
        return arrIdpers;
    }

    public void setArrIdpers(String[] arrIdpers) {
        this.arrIdpers = arrIdpers;
    }

    public Sic7persrol getSic7persrol() {
        return sic7persrol;
    }

    public void setSic7persrol(Sic7persrol sic7persrol) {
        this.sic7persrol = sic7persrol;
    }

    public List<Sic7persrol> getLstSic7persrol() {
        return lstSic7persrol;
    }

    public void setLstSic7persrol(List<Sic7persrol> lstSic7persrol) {
        this.lstSic7persrol = lstSic7persrol;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPers != null ? idPers.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sic1pers)) {
            return false;
        }
        Sic1pers other = (Sic1pers) object;
        if ((this.idPers == null && other.idPers != null) || (this.idPers != null && !this.idPers.equals(other.idPers))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.general.sicappdao.Sic1pers[ idPers=" + idPers + " ]";
    }
    
}
