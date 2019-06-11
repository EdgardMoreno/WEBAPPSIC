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
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author emoreno
 */
@Embeddable
public class Sic3prodpersPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PROD")
    private BigDecimal idProd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PERS")
    private BigDecimal idPers;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TRELAPROD")
    private Integer idTrelaprod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FEC_DESDE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecDesde;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TROLPERS")
    private Integer idTrolpers;

    public Sic3prodpersPK() {
    }

    public Sic3prodpersPK(BigDecimal idProd, BigDecimal idPers, Integer idTrelaprod, Date fecDesde, Integer idTrolpers) {
        this.idProd = idProd;
        this.idPers = idPers;
        this.idTrelaprod = idTrelaprod;
        this.fecDesde = fecDesde;
        this.idTrolpers = idTrolpers;
    }

    public BigDecimal getIdProd() {
        return idProd;
    }

    public void setIdProd(BigDecimal idProd) {
        this.idProd = idProd;
    }

    public BigDecimal getIdPers() {
        return idPers;
    }

    public void setIdPers(BigDecimal idPers) {
        this.idPers = idPers;
    }

    public Integer getIdTrelaprod() {
        return idTrelaprod;
    }

    public void setIdTrelaprod(Integer idTrelaprod) {
        this.idTrelaprod = idTrelaprod;
    }

    public Date getFecDesde() {
        return fecDesde;
    }

    public void setFecDesde(Date fecDesde) {
        this.fecDesde = fecDesde;
    }

    public Integer getIdTrolpers() {
        return idTrolpers;
    }

    public void setIdTrolpers(Integer idTrolpers) {
        this.idTrolpers = idTrolpers;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProd != null ? idProd.hashCode() : 0);
        hash += (idPers != null ? idPers.hashCode() : 0);
        hash += (idTrelaprod != null ? idTrelaprod.hashCode() : 0);
        hash += (fecDesde != null ? fecDesde.hashCode() : 0);
        hash += (idTrolpers != null ? idTrolpers.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sic3prodpersPK)) {
            return false;
        }
        Sic3prodpersPK other = (Sic3prodpersPK) object;
        if ((this.idProd == null && other.idProd != null) || (this.idProd != null && !this.idProd.equals(other.idProd))) {
            return false;
        }
        if ((this.idPers == null && other.idPers != null) || (this.idPers != null && !this.idPers.equals(other.idPers))) {
            return false;
        }
        if ((this.idTrelaprod == null && other.idTrelaprod != null) || (this.idTrelaprod != null && !this.idTrelaprod.equals(other.idTrelaprod))) {
            return false;
        }
        if ((this.fecDesde == null && other.fecDesde != null) || (this.fecDesde != null && !this.fecDesde.equals(other.fecDesde))) {
            return false;
        }
        if ((this.idTrolpers == null && other.idTrolpers != null) || (this.idTrolpers != null && !this.idTrolpers.equals(other.idTrolpers))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.general.entity.Sic3prodpersPK[ idProd=" + idProd + ", idPers=" + idPers + ", idTrelaprod=" + idTrelaprod + ", fecDesde=" + fecDesde + ", idTrolpers=" + idTrolpers + " ]";
    }
    
}
