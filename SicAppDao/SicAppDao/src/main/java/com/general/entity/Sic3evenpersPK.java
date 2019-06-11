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
public class Sic3evenpersPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "FEC_DESDE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecDesde;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_EVEN")
    private BigInteger idEven;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TRELAEVEN")
    private BigInteger idTrelaeven;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TROLPERS")
    private BigInteger idTrolpers;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PERS")
    private BigInteger idPers;

    public Sic3evenpersPK() {
    }

    public Sic3evenpersPK(Date fecDesde, BigInteger idEven, BigInteger idTrelaeven, BigInteger idTrolpers, BigInteger idPers) {
        this.fecDesde = fecDesde;
        this.idEven = idEven;
        this.idTrelaeven = idTrelaeven;
        this.idTrolpers = idTrolpers;
        this.idPers = idPers;
    }

    public Date getFecDesde() {
        return fecDesde;
    }

    public void setFecDesde(Date fecDesde) {
        this.fecDesde = fecDesde;
    }

    public BigInteger getIdEven() {
        return idEven;
    }

    public void setIdEven(BigInteger idEven) {
        this.idEven = idEven;
    }

    public BigInteger getIdTrelaeven() {
        return idTrelaeven;
    }

    public void setIdTrelaeven(BigInteger idTrelaeven) {
        this.idTrelaeven = idTrelaeven;
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
        hash += (idEven != null ? idEven.hashCode() : 0);
        hash += (idTrelaeven != null ? idTrelaeven.hashCode() : 0);
        hash += (idTrolpers != null ? idTrolpers.hashCode() : 0);
        hash += (idPers != null ? idPers.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sic3evenpersPK)) {
            return false;
        }
        Sic3evenpersPK other = (Sic3evenpersPK) object;
        if ((this.fecDesde == null && other.fecDesde != null) || (this.fecDesde != null && !this.fecDesde.equals(other.fecDesde))) {
            return false;
        }
        if ((this.idEven == null && other.idEven != null) || (this.idEven != null && !this.idEven.equals(other.idEven))) {
            return false;
        }
        if ((this.idTrelaeven == null && other.idTrelaeven != null) || (this.idTrelaeven != null && !this.idTrelaeven.equals(other.idTrelaeven))) {
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
        return "com.general.entity.Sic3evenpersPK[ fecDesde=" + fecDesde + ", idEven=" + idEven + ", idTrelaeven=" + idTrelaeven + ", idTrolpers=" + idTrolpers + ", idPers=" + idPers + " ]";
    }
    
}
