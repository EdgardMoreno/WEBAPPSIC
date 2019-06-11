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
public class Sic3persdocuPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "FEC_DESDE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecDesde;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TROLPERS")
    private BigInteger idTrolpers;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TRELAPERS")
    private BigInteger idTrelapers;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_DOCU")
    private BigInteger idDocu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PERS")
    private BigInteger idPers;

    public Sic3persdocuPK() {
    }

    public Sic3persdocuPK(Date fecDesde, BigInteger idTrolpers, BigInteger idTrelapers, BigInteger idDocu, BigInteger idPers) {
        this.fecDesde = fecDesde;
        this.idTrolpers = idTrolpers;
        this.idTrelapers = idTrelapers;
        this.idDocu = idDocu;
        this.idPers = idPers;
    }

    public Date getFecDesde() {
        return fecDesde;
    }

    public void setFecDesde(Date fecDesde) {
        this.fecDesde = fecDesde;
    }

    public BigInteger getIdTrolpers() {
        return idTrolpers;
    }

    public void setIdTrolpers(BigInteger idTrolpers) {
        this.idTrolpers = idTrolpers;
    }

    public BigInteger getIdTrelapers() {
        return idTrelapers;
    }

    public void setIdTrelapers(BigInteger idTrelapers) {
        this.idTrelapers = idTrelapers;
    }

    public BigInteger getIdDocu() {
        return idDocu;
    }

    public void setIdDocu(BigInteger idDocu) {
        this.idDocu = idDocu;
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
        hash += (idTrolpers != null ? idTrolpers.hashCode() : 0);
        hash += (idTrelapers != null ? idTrelapers.hashCode() : 0);
        hash += (idDocu != null ? idDocu.hashCode() : 0);
        hash += (idPers != null ? idPers.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sic3persdocuPK)) {
            return false;
        }
        Sic3persdocuPK other = (Sic3persdocuPK) object;
        if ((this.fecDesde == null && other.fecDesde != null) || (this.fecDesde != null && !this.fecDesde.equals(other.fecDesde))) {
            return false;
        }
        if ((this.idTrolpers == null && other.idTrolpers != null) || (this.idTrolpers != null && !this.idTrolpers.equals(other.idTrolpers))) {
            return false;
        }
        if ((this.idTrelapers == null && other.idTrelapers != null) || (this.idTrelapers != null && !this.idTrelapers.equals(other.idTrelapers))) {
            return false;
        }
        if ((this.idDocu == null && other.idDocu != null) || (this.idDocu != null && !this.idDocu.equals(other.idDocu))) {
            return false;
        }
        if ((this.idPers == null && other.idPers != null) || (this.idPers != null && !this.idPers.equals(other.idPers))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.general.entity.Sic3persdocuPK[ fecDesde=" + fecDesde + ", idTrolpers=" + idTrolpers + ", idTrelapers=" + idTrelapers + ", idDocu=" + idDocu + ", idPers=" + idPers + " ]";
    }
    
}
