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
import javax.validation.constraints.NotNull;

/**
 *
 * @author emoreno
 */
@Embeddable
public class Sic7persrolPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "FEC_DESDE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecDesde;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TROLPERS")
    private Integer idTrolpers;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PERS")
    private BigDecimal idPers;
    
    /*Agregado*/
    private String desTrolpers;
    private String codTrolpers;

    public Sic7persrolPK() {
    }

    public Sic7persrolPK(Date fecDesde, Integer idTrolpers, BigDecimal idPers) {
        this.fecDesde = fecDesde;
        this.idTrolpers = idTrolpers;
        this.idPers = idPers;
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

    public BigDecimal getIdPers() {
        return idPers;
    }

    public void setIdPers(BigDecimal idPers) {
        this.idPers = idPers;
    }

    public String getDesTrolpers() {
        return desTrolpers;
    }

    public void setDesTrolpers(String desTrolpers) {
        this.desTrolpers = desTrolpers;
    }  

    public String getCodTrolpers() {
        return codTrolpers;
    }

    public void setCodTrolpers(String codTrolpers) {
        this.codTrolpers = codTrolpers;
    }
    
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fecDesde != null ? fecDesde.hashCode() : 0);
        hash += (idTrolpers != null ? idTrolpers.hashCode() : 0);
        hash += (idPers != null ? idPers.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sic7persrolPK)) {
            return false;
        }
        Sic7persrolPK other = (Sic7persrolPK) object;
        if ((this.fecDesde == null && other.fecDesde != null) || (this.fecDesde != null && !this.fecDesde.equals(other.fecDesde))) {
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
        return "com.general.entity.Sic7persrolPK[ fecDesde=" + fecDesde + ", idTrolpers=" + idTrolpers + ", idPers=" + idPers + " ]";
    }
    
}
