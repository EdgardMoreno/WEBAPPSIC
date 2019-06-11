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
public class Sic3evenestaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_EVEN")
    private BigDecimal idEven;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TRELAEVEN")
    private Integer idTrelaeven;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ESTAEVEN")
    private Integer idEstaeven;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TROLESTAEVEN")
    private Integer idTrolestaeven;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPOINST")
    private Integer idTipoinst;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FEC_DESDE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecDesde;
    
    /**/

    public Sic3evenestaPK() {
    }

    public Sic3evenestaPK(BigDecimal idEven, Integer idTrelaeven, Integer idEstaeven, Integer idTrolestaeven, Integer idTipoinst, Date fecDesde) {
        this.idEven = idEven;
        this.idTrelaeven = idTrelaeven;
        this.idEstaeven = idEstaeven;
        this.idTrolestaeven = idTrolestaeven;
        this.idTipoinst = idTipoinst;
        this.fecDesde = fecDesde;
    }

    public BigDecimal getIdEven() {
        return idEven;
    }

    public void setIdEven(BigDecimal idEven) {
        this.idEven = idEven;
    }

    public Integer getIdTrelaeven() {
        return idTrelaeven;
    }

    public void setIdTrelaeven(Integer idTrelaeven) {
        this.idTrelaeven = idTrelaeven;
    }

    public Integer getIdEstaeven() {
        return idEstaeven;
    }

    public void setIdEstaeven(Integer idEstaeven) {
        this.idEstaeven = idEstaeven;
    }

    public Integer getIdTrolestaeven() {
        return idTrolestaeven;
    }

    public void setIdTrolestaeven(Integer idTrolestaeven) {
        this.idTrolestaeven = idTrolestaeven;
    }

    public Integer getIdTipoinst() {
        return idTipoinst;
    }

    public void setIdTipoinst(Integer idTipoinst) {
        this.idTipoinst = idTipoinst;
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
        hash += (idEven != null ? idEven.hashCode() : 0);
        hash += (idTrelaeven != null ? idTrelaeven.hashCode() : 0);
        hash += (idEstaeven != null ? idEstaeven.hashCode() : 0);
        hash += (idTrolestaeven != null ? idTrolestaeven.hashCode() : 0);
        hash += (idTipoinst != null ? idTipoinst.hashCode() : 0);
        hash += (fecDesde != null ? fecDesde.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sic3evenestaPK)) {
            return false;
        }
        Sic3evenestaPK other = (Sic3evenestaPK) object;
        if ((this.idEven == null && other.idEven != null) || (this.idEven != null && !this.idEven.equals(other.idEven))) {
            return false;
        }
        if ((this.idTrelaeven == null && other.idTrelaeven != null) || (this.idTrelaeven != null && !this.idTrelaeven.equals(other.idTrelaeven))) {
            return false;
        }
        if ((this.idEstaeven == null && other.idEstaeven != null) || (this.idEstaeven != null && !this.idEstaeven.equals(other.idEstaeven))) {
            return false;
        }
        if ((this.idTrolestaeven == null && other.idTrolestaeven != null) || (this.idTrolestaeven != null && !this.idTrolestaeven.equals(other.idTrolestaeven))) {
            return false;
        }
        if ((this.idTipoinst == null && other.idTipoinst != null) || (this.idTipoinst != null && !this.idTipoinst.equals(other.idTipoinst))) {
            return false;
        }
        if ((this.fecDesde == null && other.fecDesde != null) || (this.fecDesde != null && !this.fecDesde.equals(other.fecDesde))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.general.entity.Sic3evenestaPK[ idEven=" + idEven + ", idTrelaeven=" + idTrelaeven + ", idEstaeven=" + idEstaeven + ", idTrolestaeven=" + idTrolestaeven + ", idTipoinst=" + idTipoinst + ", fecDesde=" + fecDesde + " ]";
    }
    
}
