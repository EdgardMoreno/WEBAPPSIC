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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author emoreno
 */
@Entity
@Table(name = "SIC1LUGAR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sic1lugar.findAll", query = "SELECT s FROM Sic1lugar s")
    , @NamedQuery(name = "Sic1lugar.findByDesLugar", query = "SELECT s FROM Sic1lugar s WHERE s.desLugar = :desLugar")
    , @NamedQuery(name = "Sic1lugar.findByIdTipolugar", query = "SELECT s FROM Sic1lugar s WHERE s.idTipolugar = :idTipolugar")
    , @NamedQuery(name = "Sic1lugar.findByIdLugar", query = "SELECT s FROM Sic1lugar s WHERE s.idLugar = :idLugar")
    , @NamedQuery(name = "Sic1lugar.findByCodCodiauto", query = "SELECT s FROM Sic1lugar s WHERE s.codCodiauto = :codCodiauto")
    , @NamedQuery(name = "Sic1lugar.findByDesDireccion", query = "SELECT s FROM Sic1lugar s WHERE s.desDireccion = :desDireccion")})
public class Sic1lugar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 4000)
    @Column(name = "DES_LUGAR")
    private String desLugar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPOLUGAR")
    private BigInteger idTipolugar;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_LUGAR")
    private BigDecimal idLugar;
    @Size(max = 50)
    @Column(name = "COD_CODIAUTO")
    private String codCodiauto;
    @Size(max = 4000)
    @Column(name = "DES_DIRECCION")
    private String desDireccion;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "sic1lugar")
    private Sic1lugardire sic1lugardire;
    @OneToMany(mappedBy = "idDistrito")
    private List<Sic1lugardire> sic1lugardireList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sic1lugar")
    private List<Sic1lugarsala> sic1lugarsalaList;

    public Sic1lugar() {
    }

    public Sic1lugar(BigDecimal idLugar) {
        this.idLugar = idLugar;
    }

    public Sic1lugar(BigDecimal idLugar, BigInteger idTipolugar) {
        this.idLugar = idLugar;
        this.idTipolugar = idTipolugar;
    }

    public String getDesLugar() {
        return desLugar;
    }

    public void setDesLugar(String desLugar) {
        this.desLugar = desLugar;
    }

    public BigInteger getIdTipolugar() {
        return idTipolugar;
    }

    public void setIdTipolugar(BigInteger idTipolugar) {
        this.idTipolugar = idTipolugar;
    }

    public BigDecimal getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(BigDecimal idLugar) {
        this.idLugar = idLugar;
    }

    public String getCodCodiauto() {
        return codCodiauto;
    }

    public void setCodCodiauto(String codCodiauto) {
        this.codCodiauto = codCodiauto;
    }

    public String getDesDireccion() {
        return desDireccion;
    }

    public void setDesDireccion(String desDireccion) {
        this.desDireccion = desDireccion;
    }

    public Sic1lugardire getSic1lugardire() {
        return sic1lugardire;
    }

    public void setSic1lugardire(Sic1lugardire sic1lugardire) {
        this.sic1lugardire = sic1lugardire;
    }

    @XmlTransient
    public List<Sic1lugardire> getSic1lugardireList() {
        return sic1lugardireList;
    }

    public void setSic1lugardireList(List<Sic1lugardire> sic1lugardireList) {
        this.sic1lugardireList = sic1lugardireList;
    }

    @XmlTransient
    public List<Sic1lugarsala> getSic1lugarsalaList() {
        return sic1lugarsalaList;
    }

    public void setSic1lugarsalaList(List<Sic1lugarsala> sic1lugarsalaList) {
        this.sic1lugarsalaList = sic1lugarsalaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLugar != null ? idLugar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sic1lugar)) {
            return false;
        }
        Sic1lugar other = (Sic1lugar) object;
        if ((this.idLugar == null && other.idLugar != null) || (this.idLugar != null && !this.idLugar.equals(other.idLugar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.general.entity.Sic1lugar[ idLugar=" + idLugar + " ]";
    }
    
}
