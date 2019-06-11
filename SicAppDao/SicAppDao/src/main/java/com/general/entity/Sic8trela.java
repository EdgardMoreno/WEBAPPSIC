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
import javax.persistence.CascadeType;
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
@Table(name = "SIC8TRELA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sic8trela.findAll", query = "SELECT s FROM Sic8trela s")
    , @NamedQuery(name = "Sic8trela.findByIdTrela", query = "SELECT s FROM Sic8trela s WHERE s.idTrela = :idTrela")
    , @NamedQuery(name = "Sic8trela.findByDesTrela", query = "SELECT s FROM Sic8trela s WHERE s.desTrela = :desTrela")
    , @NamedQuery(name = "Sic8trela.findByCodTrela", query = "SELECT s FROM Sic8trela s WHERE s.codTrela = :codTrela")
    , @NamedQuery(name = "Sic8trela.findByIdClaserela", query = "SELECT s FROM Sic8trela s WHERE s.idClaserela = :idClaserela")
    , @NamedQuery(name = "Sic8trela.findByFlgModocarga", query = "SELECT s FROM Sic8trela s WHERE s.flgModocarga = :flgModocarga")
    , @NamedQuery(name = "Sic8trela.findByFlgCreaeven", query = "SELECT s FROM Sic8trela s WHERE s.flgCreaeven = :flgCreaeven")
    , @NamedQuery(name = "Sic8trela.findByIdClaserelavers", query = "SELECT s FROM Sic8trela s WHERE s.idClaserelavers = :idClaserelavers")
    , @NamedQuery(name = "Sic8trela.findByFlgEliminado", query = "SELECT s FROM Sic8trela s WHERE s.flgEliminado = :flgEliminado")})
public class Sic8trela implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_TRELA")
    private BigDecimal idTrela;
    @Column(name = "DES_TRELA")
    private String desTrela;
    @Basic(optional = false)
    @Column(name = "COD_TRELA")
    private String codTrela;
    @Basic(optional = false)
    @Column(name = "ID_CLASERELA")
    private BigInteger idClaserela;
    @Basic(optional = false)
    @Column(name = "FLG_MODOCARGA")
    private BigInteger flgModocarga;
    @Basic(optional = false)
    @Column(name = "FLG_CREAEVEN")
    private BigInteger flgCreaeven;
    @Column(name = "ID_CLASERELAVERS")
    private BigInteger idClaserelavers;
    @Column(name = "FLG_ELIMINADO")
    private BigInteger flgEliminado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sic8trela")
    private Collection<Sic3evendocu> sic3evendocuCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sic8trela")
    private Collection<Sic3proddocu> sic3proddocuCollection;

    public Sic8trela() {
    }

    public Sic8trela(BigDecimal idTrela) {
        this.idTrela = idTrela;
    }

    public Sic8trela(BigDecimal idTrela, String codTrela, BigInteger idClaserela, BigInteger flgModocarga, BigInteger flgCreaeven) {
        this.idTrela = idTrela;
        this.codTrela = codTrela;
        this.idClaserela = idClaserela;
        this.flgModocarga = flgModocarga;
        this.flgCreaeven = flgCreaeven;
    }

    public BigDecimal getIdTrela() {
        return idTrela;
    }

    public void setIdTrela(BigDecimal idTrela) {
        this.idTrela = idTrela;
    }

    public String getDesTrela() {
        return desTrela;
    }

    public void setDesTrela(String desTrela) {
        this.desTrela = desTrela;
    }

    public String getCodTrela() {
        return codTrela;
    }

    public void setCodTrela(String codTrela) {
        this.codTrela = codTrela;
    }

    public BigInteger getIdClaserela() {
        return idClaserela;
    }

    public void setIdClaserela(BigInteger idClaserela) {
        this.idClaserela = idClaserela;
    }

    public BigInteger getFlgModocarga() {
        return flgModocarga;
    }

    public void setFlgModocarga(BigInteger flgModocarga) {
        this.flgModocarga = flgModocarga;
    }

    public BigInteger getFlgCreaeven() {
        return flgCreaeven;
    }

    public void setFlgCreaeven(BigInteger flgCreaeven) {
        this.flgCreaeven = flgCreaeven;
    }

    public BigInteger getIdClaserelavers() {
        return idClaserelavers;
    }

    public void setIdClaserelavers(BigInteger idClaserelavers) {
        this.idClaserelavers = idClaserelavers;
    }

    public BigInteger getFlgEliminado() {
        return flgEliminado;
    }

    public void setFlgEliminado(BigInteger flgEliminado) {
        this.flgEliminado = flgEliminado;
    }

    @XmlTransient
    public Collection<Sic3evendocu> getSic3evendocuCollection() {
        return sic3evendocuCollection;
    }

    public void setSic3evendocuCollection(Collection<Sic3evendocu> sic3evendocuCollection) {
        this.sic3evendocuCollection = sic3evendocuCollection;
    }

    @XmlTransient
    public Collection<Sic3proddocu> getSic3proddocuCollection() {
        return sic3proddocuCollection;
    }

    public void setSic3proddocuCollection(Collection<Sic3proddocu> sic3proddocuCollection) {
        this.sic3proddocuCollection = sic3proddocuCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTrela != null ? idTrela.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sic8trela)) {
            return false;
        }
        Sic8trela other = (Sic8trela) object;
        if ((this.idTrela == null && other.idTrela != null) || (this.idTrela != null && !this.idTrela.equals(other.idTrela))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.general.entity.Sic8trela[ idTrela=" + idTrela + " ]";
    }
    
}
