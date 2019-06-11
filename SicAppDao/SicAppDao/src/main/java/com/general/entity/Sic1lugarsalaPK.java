/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author emoreno
 */
@Embeddable
public class Sic1lugarsalaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_LUGARSALA")
    private BigInteger idLugarsala;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPOSALA")
    private BigInteger idTiposala;

    public Sic1lugarsalaPK() {
    }

    public Sic1lugarsalaPK(BigInteger idLugarsala, BigInteger idTiposala) {
        this.idLugarsala = idLugarsala;
        this.idTiposala = idTiposala;
    }

    public BigInteger getIdLugarsala() {
        return idLugarsala;
    }

    public void setIdLugarsala(BigInteger idLugarsala) {
        this.idLugarsala = idLugarsala;
    }

    public BigInteger getIdTiposala() {
        return idTiposala;
    }

    public void setIdTiposala(BigInteger idTiposala) {
        this.idTiposala = idTiposala;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLugarsala != null ? idLugarsala.hashCode() : 0);
        hash += (idTiposala != null ? idTiposala.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sic1lugarsalaPK)) {
            return false;
        }
        Sic1lugarsalaPK other = (Sic1lugarsalaPK) object;
        if ((this.idLugarsala == null && other.idLugarsala != null) || (this.idLugarsala != null && !this.idLugarsala.equals(other.idLugarsala))) {
            return false;
        }
        if ((this.idTiposala == null && other.idTiposala != null) || (this.idTiposala != null && !this.idTiposala.equals(other.idTiposala))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.general.entity.Sic1lugarsalaPK[ idLugarsala=" + idLugarsala + ", idTiposala=" + idTiposala + " ]";
    }
    
}
