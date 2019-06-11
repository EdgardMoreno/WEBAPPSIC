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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author emoreno
 */
@Entity
@Table(name = "SIC1LUGARDIRE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sic1lugardire.findAll", query = "SELECT s FROM Sic1lugardire s")
    , @NamedQuery(name = "Sic1lugardire.findByIdLugardire", query = "SELECT s FROM Sic1lugardire s WHERE s.idLugardire = :idLugardire")
    , @NamedQuery(name = "Sic1lugardire.findByNumLatitud", query = "SELECT s FROM Sic1lugardire s WHERE s.numLatitud = :numLatitud")
    , @NamedQuery(name = "Sic1lugardire.findByNumLongitud", query = "SELECT s FROM Sic1lugardire s WHERE s.numLongitud = :numLongitud")
    , @NamedQuery(name = "Sic1lugardire.findByNumAltitud", query = "SELECT s FROM Sic1lugardire s WHERE s.numAltitud = :numAltitud")
    , @NamedQuery(name = "Sic1lugardire.findByDesVia", query = "SELECT s FROM Sic1lugardire s WHERE s.desVia = :desVia")
    , @NamedQuery(name = "Sic1lugardire.findByDesZona", query = "SELECT s FROM Sic1lugardire s WHERE s.desZona = :desZona")
    , @NamedQuery(name = "Sic1lugardire.findByNumDire", query = "SELECT s FROM Sic1lugardire s WHERE s.numDire = :numDire")
    , @NamedQuery(name = "Sic1lugardire.findByNumInterior", query = "SELECT s FROM Sic1lugardire s WHERE s.numInterior = :numInterior")
    , @NamedQuery(name = "Sic1lugardire.findByCodNumdire", query = "SELECT s FROM Sic1lugardire s WHERE s.codNumdire = :codNumdire")
    , @NamedQuery(name = "Sic1lugardire.findByCodNuminterior", query = "SELECT s FROM Sic1lugardire s WHERE s.codNuminterior = :codNuminterior")})
public class Sic1lugardire implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_LUGARDIRE")
    private BigDecimal idLugardire;
    @Size(max = 15)
    @Column(name = "NUM_LATITUD")
    private String numLatitud;
    @Size(max = 15)
    @Column(name = "NUM_LONGITUD")
    private String numLongitud;
    @Column(name = "NUM_ALTITUD")
    private BigInteger numAltitud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "DES_VIA")
    private String desVia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "DES_ZONA")
    private String desZona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "NUM_DIRE")
    private String numDire;
    @Size(max = 250)
    @Column(name = "NUM_INTERIOR")
    private String numInterior;
    @Size(max = 5)
    @Column(name = "COD_NUMDIRE")
    private String codNumdire;
    @Size(max = 5)
    @Column(name = "COD_NUMINTERIOR")
    private String codNuminterior;
    @JoinColumn(name = "ID_LUGARDIRE", referencedColumnName = "ID_LUGAR", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Sic1lugar sic1lugar;
    @JoinColumn(name = "ID_DISTRITO", referencedColumnName = "ID_LUGAR")
    @ManyToOne
    private Sic1lugar idDistrito;

    public Sic1lugardire() {
    }

    public Sic1lugardire(BigDecimal idLugardire) {
        this.idLugardire = idLugardire;
    }

    public Sic1lugardire(BigDecimal idLugardire, String desVia, String desZona, String numDire) {
        this.idLugardire = idLugardire;
        this.desVia = desVia;
        this.desZona = desZona;
        this.numDire = numDire;
    }

    public BigDecimal getIdLugardire() {
        return idLugardire;
    }

    public void setIdLugardire(BigDecimal idLugardire) {
        this.idLugardire = idLugardire;
    }

    public String getNumLatitud() {
        return numLatitud;
    }

    public void setNumLatitud(String numLatitud) {
        this.numLatitud = numLatitud;
    }

    public String getNumLongitud() {
        return numLongitud;
    }

    public void setNumLongitud(String numLongitud) {
        this.numLongitud = numLongitud;
    }

    public BigInteger getNumAltitud() {
        return numAltitud;
    }

    public void setNumAltitud(BigInteger numAltitud) {
        this.numAltitud = numAltitud;
    }

    public String getDesVia() {
        return desVia;
    }

    public void setDesVia(String desVia) {
        this.desVia = desVia;
    }

    public String getDesZona() {
        return desZona;
    }

    public void setDesZona(String desZona) {
        this.desZona = desZona;
    }

    public String getNumDire() {
        return numDire;
    }

    public void setNumDire(String numDire) {
        this.numDire = numDire;
    }

    public String getNumInterior() {
        return numInterior;
    }

    public void setNumInterior(String numInterior) {
        this.numInterior = numInterior;
    }

    public String getCodNumdire() {
        return codNumdire;
    }

    public void setCodNumdire(String codNumdire) {
        this.codNumdire = codNumdire;
    }

    public String getCodNuminterior() {
        return codNuminterior;
    }

    public void setCodNuminterior(String codNuminterior) {
        this.codNuminterior = codNuminterior;
    }

    public Sic1lugar getSic1lugar() {
        return sic1lugar;
    }

    public void setSic1lugar(Sic1lugar sic1lugar) {
        this.sic1lugar = sic1lugar;
    }

    public Sic1lugar getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(Sic1lugar idDistrito) {
        this.idDistrito = idDistrito;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLugardire != null ? idLugardire.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sic1lugardire)) {
            return false;
        }
        Sic1lugardire other = (Sic1lugardire) object;
        if ((this.idLugardire == null && other.idLugardire != null) || (this.idLugardire != null && !this.idLugardire.equals(other.idLugardire))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.general.entity.Sic1lugardire[ idLugardire=" + idLugardire + " ]";
    }
    
}
