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
public class Sic3perspersPK implements Serializable {

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
    @Column(name = "ID_TROLPERS")
    private BigInteger idTrolpers;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PERS")
    private BigInteger idPers;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TROLPERSREL")
    private BigInteger idTrolpersrel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PERSREL")
    private BigInteger idPersrel;

    public Sic3perspersPK() {
    }

    public Sic3perspersPK(Date fecDesde, BigInteger idTrelapers, BigInteger idTrolpers, BigInteger idPers, BigInteger idTrolpersrel, BigInteger idPersrel) {
        this.fecDesde = fecDesde;
        this.idTrelapers = idTrelapers;
        this.idTrolpers = idTrolpers;
        this.idPers = idPers;
        this.idTrolpersrel = idTrolpersrel;
        this.idPersrel = idPersrel;
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

    public BigInteger getIdTrolpersrel() {
        return idTrolpersrel;
    }

    public void setIdTrolpersrel(BigInteger idTrolpersrel) {
        this.idTrolpersrel = idTrolpersrel;
    }

    public BigInteger getIdPersrel() {
        return idPersrel;
    }

    public void setIdPersrel(BigInteger idPersrel) {
        this.idPersrel = idPersrel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fecDesde != null ? fecDesde.hashCode() : 0);
        hash += (idTrelapers != null ? idTrelapers.hashCode() : 0);
        hash += (idTrolpers != null ? idTrolpers.hashCode() : 0);
        hash += (idPers != null ? idPers.hashCode() : 0);
        hash += (idTrolpersrel != null ? idTrolpersrel.hashCode() : 0);
        hash += (idPersrel != null ? idPersrel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sic3perspersPK)) {
            return false;
        }
        Sic3perspersPK other = (Sic3perspersPK) object;
        if ((this.fecDesde == null && other.fecDesde != null) || (this.fecDesde != null && !this.fecDesde.equals(other.fecDesde))) {
            return false;
        }
        if ((this.idTrelapers == null && other.idTrelapers != null) || (this.idTrelapers != null && !this.idTrelapers.equals(other.idTrelapers))) {
            return false;
        }
        if ((this.idTrolpers == null && other.idTrolpers != null) || (this.idTrolpers != null && !this.idTrolpers.equals(other.idTrolpers))) {
            return false;
        }
        if ((this.idPers == null && other.idPers != null) || (this.idPers != null && !this.idPers.equals(other.idPers))) {
            return false;
        }
        if ((this.idTrolpersrel == null && other.idTrolpersrel != null) || (this.idTrolpersrel != null && !this.idTrolpersrel.equals(other.idTrolpersrel))) {
            return false;
        }
        if ((this.idPersrel == null && other.idPersrel != null) || (this.idPersrel != null && !this.idPersrel.equals(other.idPersrel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.general.entity.Sic3perspersPK[ fecDesde=" + fecDesde + ", idTrelapers=" + idTrelapers + ", idTrolpers=" + idTrolpers + ", idPers=" + idPers + ", idTrolpersrel=" + idTrolpersrel + ", idPersrel=" + idPersrel + " ]";
    }
    
}
