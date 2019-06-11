/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
public class Sic3proditempersPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ID_PRODITEM")
    private BigDecimal idProditem;
    @Basic(optional = false)
    @Column(name = "ID_PERS")
    private BigDecimal idPers;
    @Basic(optional = false)
    @Column(name = "ID_TRELAPRODITEM")
    private Integer idTrelaproditem;
    @Basic(optional = false)
    @Column(name = "FEC_HASTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecHasta;

    public Sic3proditempersPK() {
    }

    public Sic3proditempersPK(BigDecimal idProditem, BigDecimal idPers, Integer idTrelaproditem, Date fecHasta) {
        this.idProditem = idProditem;
        this.idPers = idPers;
        this.idTrelaproditem = idTrelaproditem;
        this.fecHasta = fecHasta;
    }

    public BigDecimal getIdProditem() {
        return idProditem;
    }

    public void setIdProditem(BigDecimal idProditem) {
        this.idProditem = idProditem;
    }

    public BigDecimal getIdPers() {
        return idPers;
    }

    public void setIdPers(BigDecimal idPers) {
        this.idPers = idPers;
    }

    public Integer getIdTrelaproditem() {
        return idTrelaproditem;
    }

    public void setIdTrelaproditem(Integer idTrelaproditem) {
        this.idTrelaproditem = idTrelaproditem;
    }

    public Date getFecHasta() {
        return fecHasta;
    }

    public void setFecHasta(Date fecHasta) {
        this.fecHasta = fecHasta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProditem != null ? idProditem.hashCode() : 0);
        hash += (idPers != null ? idPers.hashCode() : 0);
        hash += (idTrelaproditem != null ? idTrelaproditem.hashCode() : 0);
        hash += (fecHasta != null ? fecHasta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sic3proditempersPK)) {
            return false;
        }
        Sic3proditempersPK other = (Sic3proditempersPK) object;
        if ((this.idProditem == null && other.idProditem != null) || (this.idProditem != null && !this.idProditem.equals(other.idProditem))) {
            return false;
        }
        if ((this.idPers == null && other.idPers != null) || (this.idPers != null && !this.idPers.equals(other.idPers))) {
            return false;
        }
        if ((this.idTrelaproditem == null && other.idTrelaproditem != null) || (this.idTrelaproditem != null && !this.idTrelaproditem.equals(other.idTrelaproditem))) {
            return false;
        }
        if ((this.fecHasta == null && other.fecHasta != null) || (this.fecHasta != null && !this.fecHasta.equals(other.fecHasta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.general.entity.Sic3proditempersPK[ idProditem=" + idProditem + ", idPers=" + idPers + ", idTrelaproditem=" + idTrelaproditem + ", fecHasta=" + fecHasta + " ]";
    }
    
}
