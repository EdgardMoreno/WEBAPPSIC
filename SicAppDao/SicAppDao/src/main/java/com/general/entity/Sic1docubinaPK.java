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
public class Sic1docubinaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ID_DOCU")
    private BigInteger idDocu;
    @Basic(optional = false)
    @Column(name = "ID_TRELADOCU")
    private BigInteger idTreladocu;
    @Basic(optional = false)
    @Column(name = "COD_DOCUBINA")
    private String codDocubina;
    @Basic(optional = false)
    @Column(name = "FEC_DESDE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecDesde;

    public Sic1docubinaPK() {
    }

    public Sic1docubinaPK(BigInteger idDocu, BigInteger idTreladocu, String codDocubina, Date fecDesde) {
        this.idDocu = idDocu;
        this.idTreladocu = idTreladocu;
        this.codDocubina = codDocubina;
        this.fecDesde = fecDesde;
    }

    public BigInteger getIdDocu() {
        return idDocu;
    }

    public void setIdDocu(BigInteger idDocu) {
        this.idDocu = idDocu;
    }

    public BigInteger getIdTreladocu() {
        return idTreladocu;
    }

    public void setIdTreladocu(BigInteger idTreladocu) {
        this.idTreladocu = idTreladocu;
    }

    public String getCodDocubina() {
        return codDocubina;
    }

    public void setCodDocubina(String codDocubina) {
        this.codDocubina = codDocubina;
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
        hash += (idDocu != null ? idDocu.hashCode() : 0);
        hash += (idTreladocu != null ? idTreladocu.hashCode() : 0);
        hash += (codDocubina != null ? codDocubina.hashCode() : 0);
        hash += (fecDesde != null ? fecDesde.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sic1docubinaPK)) {
            return false;
        }
        Sic1docubinaPK other = (Sic1docubinaPK) object;
        if ((this.idDocu == null && other.idDocu != null) || (this.idDocu != null && !this.idDocu.equals(other.idDocu))) {
            return false;
        }
        if ((this.idTreladocu == null && other.idTreladocu != null) || (this.idTreladocu != null && !this.idTreladocu.equals(other.idTreladocu))) {
            return false;
        }
        if ((this.codDocubina == null && other.codDocubina != null) || (this.codDocubina != null && !this.codDocubina.equals(other.codDocubina))) {
            return false;
        }
        if ((this.fecDesde == null && other.fecDesde != null) || (this.fecDesde != null && !this.fecDesde.equals(other.fecDesde))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.general.sicappdao.Sic1docubinaPK[ idDocu=" + idDocu + ", idTreladocu=" + idTreladocu + ", codDocubina=" + codDocubina + ", fecDesde=" + fecDesde + " ]";
    }
    
}
