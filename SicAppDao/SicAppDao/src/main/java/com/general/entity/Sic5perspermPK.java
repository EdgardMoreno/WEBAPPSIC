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
public class Sic5perspermPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PERS")
    private Integer idPers;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_CORR")
    private BigInteger numCorr;

    public Sic5perspermPK() {
    }

    public Sic5perspermPK(Integer idPers, BigInteger numCorr) {
        this.idPers = idPers;
        this.numCorr = numCorr;
    }

    public Integer getIdPers() {
        return idPers;
    }

    public void setIdPers(Integer idPers) {
        this.idPers = idPers;
    }

    public BigInteger getNumCorr() {
        return numCorr;
    }

    public void setNumCorr(BigInteger numCorr) {
        this.numCorr = numCorr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPers != null ? idPers.hashCode() : 0);
        hash += (numCorr != null ? numCorr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sic5perspermPK)) {
            return false;
        }
        Sic5perspermPK other = (Sic5perspermPK) object;
        if ((this.idPers == null && other.idPers != null) || (this.idPers != null && !this.idPers.equals(other.idPers))) {
            return false;
        }
        if ((this.numCorr == null && other.numCorr != null) || (this.numCorr != null && !this.numCorr.equals(other.numCorr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.general.entity.Sic5perspermPK[ idPers=" + idPers + ", numCorr=" + numCorr + " ]";
    }
    
}
