/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author emoreno
 */
@Entity
@Table(name = "SIC1PERSINDI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sic1persindi.findAll", query = "SELECT s FROM Sic1persindi s")
    , @NamedQuery(name = "Sic1persindi.findByDesPrimnomb", query = "SELECT s FROM Sic1persindi s WHERE s.desPrimnomb = :desPrimnomb")
    , @NamedQuery(name = "Sic1persindi.findByDesApelmate", query = "SELECT s FROM Sic1persindi s WHERE s.desApelmate = :desApelmate")
    , @NamedQuery(name = "Sic1persindi.findByDesApelpate", query = "SELECT s FROM Sic1persindi s WHERE s.desApelpate = :desApelpate")
    , @NamedQuery(name = "Sic1persindi.findByIdGenero", query = "SELECT s FROM Sic1persindi s WHERE s.idGenero = :idGenero")
    , @NamedQuery(name = "Sic1persindi.findByDesSegunomb", query = "SELECT s FROM Sic1persindi s WHERE s.desSegunomb = :desSegunomb")
    , @NamedQuery(name = "Sic1persindi.findByFecNaci", query = "SELECT s FROM Sic1persindi s WHERE s.fecNaci = :fecNaci")
    , @NamedQuery(name = "Sic1persindi.findByIdPersindi", query = "SELECT s FROM Sic1persindi s WHERE s.idPersindi = :idPersindi")})
public class Sic1persindi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 250)
    @Column(name = "DES_PRIMNOMB")
    private String desPrimnomb;
    @Size(max = 250)
    @Column(name = "DES_APELMATE")
    private String desApelmate;
    @Size(max = 250)
    @Column(name = "DES_APELPATE")
    private String desApelpate;
    @Column(name = "ID_GENERO")
    private BigInteger idGenero;
    @Size(max = 250)
    @Column(name = "DES_SEGUNOMB")
    private String desSegunomb;
    @Column(name = "FEC_NACI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecNaci;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PERSINDI")
    private BigDecimal idPersindi;

    public Sic1persindi() {
    }

    public Sic1persindi(BigDecimal idPersindi) {
        this.idPersindi = idPersindi;
    }

    public String getDesPrimnomb() {
        return desPrimnomb;
    }

    public void setDesPrimnomb(String desPrimnomb) {
        this.desPrimnomb = desPrimnomb;
    }

    public String getDesApelmate() {
        return desApelmate;
    }

    public void setDesApelmate(String desApelmate) {
        this.desApelmate = desApelmate;
    }

    public String getDesApelpate() {
        return desApelpate;
    }

    public void setDesApelpate(String desApelpate) {
        this.desApelpate = desApelpate;
    }

    public BigInteger getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(BigInteger idGenero) {
        this.idGenero = idGenero;
    }

    public String getDesSegunomb() {
        return desSegunomb;
    }

    public void setDesSegunomb(String desSegunomb) {
        this.desSegunomb = desSegunomb;
    }

    public Date getFecNaci() {
        return fecNaci;
    }

    public void setFecNaci(Date fecNaci) {
        this.fecNaci = fecNaci;
    }

    public BigDecimal getIdPersindi() {
        return idPersindi;
    }

    public void setIdPersindi(BigDecimal idPersindi) {
        this.idPersindi = idPersindi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersindi != null ? idPersindi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sic1persindi)) {
            return false;
        }
        Sic1persindi other = (Sic1persindi) object;
        if ((this.idPersindi == null && other.idPersindi != null) || (this.idPersindi != null && !this.idPersindi.equals(other.idPersindi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.general.entity.Sic1persindi[ idPersindi=" + idPersindi + " ]";
    }
    
}
