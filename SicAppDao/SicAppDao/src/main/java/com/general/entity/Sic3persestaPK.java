/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author emoreno
 */
@Embeddable
public class Sic3persestaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "FEC_DESDE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecDesde;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TRELAPERS")
    private BigInteger idTrelapers;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ESTAPERS")
    private BigInteger idEstapers;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TROLESTAPERS")
    private BigInteger idTrolestapers;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TROLPERS")
    private BigInteger idTrolpers;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PERS")
    private BigInteger idPers;

    public Sic3persestaPK() {
    }

    public Sic3persestaPK(Date fecDesde, BigInteger idTrelapers, BigInteger idEstapers, BigInteger idTrolestapers, BigInteger idTrolpers, BigInteger idPers) {
        this.fecDesde = fecDesde;
        this.idTrelapers = idTrelapers;
        this.idEstapers = idEstapers;
        this.idTrolestapers = idTrolestapers;
        this.idTrolpers = idTrolpers;
        this.idPers = idPers;
    }

    public Date getFecDesde() {
        return fecDesde;
    }

    public void setFecDesde(Date fecDesde) {
        this.fecDesde = fecDesde;
    }

    public BigInteger getIdTrelapers() {
        return idTrelapers;
    }

    public void setIdTrelapers(BigInteger idTrelapers) {
        this.idTrelapers = idTrelapers;
    }

    public BigInteger getIdEstapers() {
        return idEstapers;
    }

    public void setIdEstapers(BigInteger idEstapers) {
        this.idEstapers = idEstapers;
    }

    public BigInteger getIdTrolestapers() {
        return idTrolestapers;
    }

    public void setIdTrolestapers(BigInteger idTrolestapers) {
        this.idTrolestapers = idTrolestapers;
    }

    public BigInteger getIdTrolpers() {
        return idTrolpers;
    }

    public void setIdTrolpers(BigInteger idTrolpers) {
        this.idTrolpers = idTrolpers;
    }

    public BigInteger getIdPers() {
        return idPers;
    }

    public void setIdPers(BigInteger idPers) {
        this.idPers = idPers;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fecDesde != null ? fecDesde.hashCode() : 0);
        hash += (idTrelapers != null ? idTrelapers.hashCode() : 0);
        hash += (idEstapers != null ? idEstapers.hashCode() : 0);
        hash += (idTrolestapers != null ? idTrolestapers.hashCode() : 0);
        hash += (idTrolpers != null ? idTrolpers.hashCode() : 0);
        hash += (idPers != null ? idPers.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sic3persestaPK)) {
            return false;
        }
        Sic3persestaPK other = (Sic3persestaPK) object;
        if ((this.fecDesde == null && other.fecDesde != null) || (this.fecDesde != null && !this.fecDesde.equals(other.fecDesde))) {
            return false;
        }
        if ((this.idTrelapers == null && other.idTrelapers != null) || (this.idTrelapers != null && !this.idTrelapers.equals(other.idTrelapers))) {
            return false;
        }
        if ((this.idEstapers == null && other.idEstapers != null) || (this.idEstapers != null && !this.idEstapers.equals(other.idEstapers))) {
            return false;
        }
        if ((this.idTrolestapers == null && other.idTrolestapers != null) || (this.idTrolestapers != null && !this.idTrolestapers.equals(other.idTrolestapers))) {
            return false;
        }
        if ((this.idTrolpers == null && other.idTrolpers != null) || (this.idTrolpers != null && !this.idTrolpers.equals(other.idTrolpers))) {
            return false;
        }
        if ((this.idPers == null && other.idPers != null) || (this.idPers != null && !this.idPers.equals(other.idPers))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.general.entity.Sic3persestaPK[ fecDesde=" + fecDesde + ", idTrelapers=" + idTrelapers + ", idEstapers=" + idEstapers + ", idTrolestapers=" + idTrolestapers + ", idTrolpers=" + idTrolpers + ", idPers=" + idPers + " ]";
    }
    
}
