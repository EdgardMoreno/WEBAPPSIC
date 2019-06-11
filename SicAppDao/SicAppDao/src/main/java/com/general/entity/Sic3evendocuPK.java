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

/**
 *
 * @author emoreno
 */
@Embeddable
public class Sic3evendocuPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "FEC_DESDE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecDesde;
    @Basic(optional = false)
    @Column(name = "ID_EVEN")
    private BigInteger idEven;
    @Basic(optional = false)
    @Column(name = "ID_TRELAEVEN")
    private BigInteger idTrelaeven;
    @Basic(optional = false)
    @Column(name = "ID_DOCU")
    private BigInteger idDocu;

    public Sic3evendocuPK() {
    }

    public Sic3evendocuPK(Date fecDesde, BigInteger idEven, BigInteger idTrelaeven, BigInteger idDocu) {
        this.fecDesde = fecDesde;
        this.idEven = idEven;
        this.idTrelaeven = idTrelaeven;
        this.idDocu = idDocu;
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

    public BigInteger getIdDocu() {
        return idDocu;
    }

    public void setIdDocu(BigInteger idDocu) {
        this.idDocu = idDocu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fecDesde != null ? fecDesde.hashCode() : 0);
        hash += (idEven != null ? idEven.hashCode() : 0);
        hash += (idTrelaeven != null ? idTrelaeven.hashCode() : 0);
        hash += (idDocu != null ? idDocu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sic3evendocuPK)) {
            return false;
        }
        Sic3evendocuPK other = (Sic3evendocuPK) object;
        if ((this.fecDesde == null && other.fecDesde != null) || (this.fecDesde != null && !this.fecDesde.equals(other.fecDesde))) {
            return false;
        }
        if ((this.idEven == null && other.idEven != null) || (this.idEven != null && !this.idEven.equals(other.idEven))) {
            return false;
        }
        if ((this.idTrelaeven == null && other.idTrelaeven != null) || (this.idTrelaeven != null && !this.idTrelaeven.equals(other.idTrelaeven))) {
            return false;
        }
        if ((this.idDocu == null && other.idDocu != null) || (this.idDocu != null && !this.idDocu.equals(other.idDocu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.general.entity.Sic3evendocuPK[ fecDesde=" + fecDesde + ", idEven=" + idEven + ", idTrelaeven=" + idTrelaeven + ", idDocu=" + idDocu + " ]";
    }
    
}
