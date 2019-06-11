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
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author emoreno
 */
@Entity
@Table(name = "SIC1IDENPERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sic1idenpers.findAll", query = "SELECT s FROM Sic1idenpers s")
    , @NamedQuery(name = "Sic1idenpers.findByIdTipoiden", query = "SELECT s FROM Sic1idenpers s WHERE s.sic1idenpersPK.idTipoiden = :idTipoiden")
    , @NamedQuery(name = "Sic1idenpers.findByCodIden", query = "SELECT s FROM Sic1idenpers s WHERE s.sic1idenpersPK.codIden = :codIden")
    , @NamedQuery(name = "Sic1idenpers.findByFecDesde", query = "SELECT s FROM Sic1idenpers s WHERE s.fecDesde = :fecDesde")
    , @NamedQuery(name = "Sic1idenpers.findByFecHasta", query = "SELECT s FROM Sic1idenpers s WHERE s.fecHasta = :fecHasta")
    , @NamedQuery(name = "Sic1idenpers.findByIdPers", query = "SELECT s FROM Sic1idenpers s WHERE s.idPers = :idPers")})
public class Sic1idenpers implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected Sic1idenpersPK sic1idenpersPK;
    @Column(name = "FEC_DESDE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecDesde;
    @Column(name = "FEC_HASTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecHasta;
    @Column(name = "ID_PERS")
    private BigDecimal idPers;

    public Sic1idenpers() {
    }

    public Sic1idenpers(Sic1idenpersPK sic1idenpersPK) {
        this.sic1idenpersPK = sic1idenpersPK;
    }

    public Sic1idenpers(Integer idTipoiden, String codIden) {
        this.sic1idenpersPK = new Sic1idenpersPK(idTipoiden, codIden);
    }

    public Sic1idenpersPK getSic1idenpersPK() {
        return sic1idenpersPK;
    }

    public void setSic1idenpersPK(Sic1idenpersPK sic1idenpersPK) {
        this.sic1idenpersPK = sic1idenpersPK;
    }

    public Date getFecDesde() {
        return fecDesde;
    }

    public void setFecDesde(Date fecDesde) {
        this.fecDesde = fecDesde;
    }

    public Date getFecHasta() {
        return fecHasta;
    }

    public void setFecHasta(Date fecHasta) {
        this.fecHasta = fecHasta;
    }

    public BigDecimal getIdPers() {
        return idPers;
    }

    public void setIdPers(BigDecimal idPers) {
        this.idPers = idPers;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sic1idenpersPK != null ? sic1idenpersPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sic1idenpers)) {
            return false;
        }
        Sic1idenpers other = (Sic1idenpers) object;
        if ((this.sic1idenpersPK == null && other.sic1idenpersPK != null) || (this.sic1idenpersPK != null && !this.sic1idenpersPK.equals(other.sic1idenpersPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.general.entity.Sic1idenpers[ sic1idenpersPK=" + sic1idenpersPK + " ]";
    }
    
}
