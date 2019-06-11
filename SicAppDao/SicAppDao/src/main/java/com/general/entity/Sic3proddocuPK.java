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
public class Sic3proddocuPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ID_PROD")
    private BigInteger idProd;
    @Basic(optional = false)
    @Column(name = "ID_DOCU")
    private BigInteger idDocu;
    @Basic(optional = false)
    @Column(name = "ID_TRELAPROD")
    private BigInteger idTrelaprod;
    @Basic(optional = false)
    @Column(name = "FEC_DESDE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecDesde;

    public Sic3proddocuPK() {
    }

    public Sic3proddocuPK(BigInteger idProd, BigInteger idDocu, BigInteger idTrelaprod, Date fecDesde) {
        this.idProd = idProd;
        this.idDocu = idDocu;
        this.idTrelaprod = idTrelaprod;
        this.fecDesde = fecDesde;
    }

    public BigInteger getIdProd() {
        return idProd;
    }

    public void setIdProd(BigInteger idProd) {
        this.idProd = idProd;
    }

    public BigInteger getIdDocu() {
        return idDocu;
    }

    public void setIdDocu(BigInteger idDocu) {
        this.idDocu = idDocu;
    }

    public BigInteger getIdTrelaprod() {
        return idTrelaprod;
    }

    public void setIdTrelaprod(BigInteger idTrelaprod) {
        this.idTrelaprod = idTrelaprod;
    }

    public Date getFecDesde() {
        return fecDesde;
    }

    public void setFecDesde(Date fecDesde) {
        this.fecDesde = fecDesde;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProd != null ? idProd.hashCode() : 0);
        hash += (idDocu != null ? idDocu.hashCode() : 0);
        hash += (idTrelaprod != null ? idTrelaprod.hashCode() : 0);
        hash += (fecDesde != null ? fecDesde.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sic3proddocuPK)) {
            return false;
        }
        Sic3proddocuPK other = (Sic3proddocuPK) object;
        if ((this.idProd == null && other.idProd != null) || (this.idProd != null && !this.idProd.equals(other.idProd))) {
            return false;
        }
        if ((this.idDocu == null && other.idDocu != null) || (this.idDocu != null && !this.idDocu.equals(other.idDocu))) {
            return false;
        }
        if ((this.idTrelaprod == null && other.idTrelaprod != null) || (this.idTrelaprod != null && !this.idTrelaprod.equals(other.idTrelaprod))) {
            return false;
        }
        if ((this.fecDesde == null && other.fecDesde != null) || (this.fecDesde != null && !this.fecDesde.equals(other.fecDesde))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.general.entity.Sic3proddocuPK[ idProd=" + idProd + ", idDocu=" + idDocu + ", idTrelaprod=" + idTrelaprod + ", fecDesde=" + fecDesde + " ]";
    }
    
}
