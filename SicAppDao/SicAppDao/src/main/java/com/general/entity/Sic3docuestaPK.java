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
public class Sic3docuestaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "FEC_DESDE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecDesde;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TRELADOCU")
    private Integer idTreladocu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ESTADOCU")
    private Integer idEstadocu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TROLESTADOCU")
    private Integer idTrolestadocu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_DOCU")
    private BigDecimal idDocu;

    public Sic3docuestaPK() {
    }

    public Sic3docuestaPK(Date fecDesde, Integer idTreladocu, Integer idEstadocu, Integer idTrolestadocu, BigDecimal idDocu) {
        this.fecDesde = fecDesde;
        this.idTreladocu = idTreladocu;
        this.idEstadocu = idEstadocu;
        this.idTrolestadocu = idTrolestadocu;
        this.idDocu = idDocu;
    }

    public Date getFecDesde() {
        return fecDesde;
    }

    public void setFecDesde(Date fecDesde) {
        this.fecDesde = fecDesde;
    }

    public Integer getIdTreladocu() {
        return idTreladocu;
    }

    public void setIdTreladocu(Integer idTreladocu) {
        this.idTreladocu = idTreladocu;
    }

    public Integer getIdEstadocu() {
        return idEstadocu;
    }

    public void setIdEstadocu(Integer idEstadocu) {
        this.idEstadocu = idEstadocu;
    }

    public Integer getIdTrolestadocu() {
        return idTrolestadocu;
    }

    public void setIdTrolestadocu(Integer idTrolestadocu) {
        this.idTrolestadocu = idTrolestadocu;
    }

    public BigDecimal getIdDocu() {
        return idDocu;
    }

    public void setIdDocu(BigDecimal idDocu) {
        this.idDocu = idDocu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fecDesde != null ? fecDesde.hashCode() : 0);
        hash += (idTreladocu != null ? idTreladocu.hashCode() : 0);
        hash += (idEstadocu != null ? idEstadocu.hashCode() : 0);
        hash += (idTrolestadocu != null ? idTrolestadocu.hashCode() : 0);
        hash += (idDocu != null ? idDocu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sic3docuestaPK)) {
            return false;
        }
        Sic3docuestaPK other = (Sic3docuestaPK) object;
        if ((this.fecDesde == null && other.fecDesde != null) || (this.fecDesde != null && !this.fecDesde.equals(other.fecDesde))) {
            return false;
        }
        if ((this.idTreladocu == null && other.idTreladocu != null) || (this.idTreladocu != null && !this.idTreladocu.equals(other.idTreladocu))) {
            return false;
        }
        if ((this.idEstadocu == null && other.idEstadocu != null) || (this.idEstadocu != null && !this.idEstadocu.equals(other.idEstadocu))) {
            return false;
        }
        if ((this.idTrolestadocu == null && other.idTrolestadocu != null) || (this.idTrolestadocu != null && !this.idTrolestadocu.equals(other.idTrolestadocu))) {
            return false;
        }
        if ((this.idDocu == null && other.idDocu != null) || (this.idDocu != null && !this.idDocu.equals(other.idDocu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.general.entity.Sic3docuestaPK[ fecDesde=" + fecDesde + ", idTreladocu=" + idTreladocu + ", idEstadocu=" + idEstadocu + ", idTrolestadocu=" + idTrolestadocu + ", idDocu=" + idDocu + " ]";
    }
    
}
