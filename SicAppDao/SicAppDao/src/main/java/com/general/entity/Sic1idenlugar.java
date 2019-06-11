/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.entity;

import java.io.Serializable;
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
@Table(name = "SIC1IDENLUGAR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sic1idenlugar.findAll", query = "SELECT s FROM Sic1idenlugar s")
    , @NamedQuery(name = "Sic1idenlugar.findByIdTipoiden", query = "SELECT s FROM Sic1idenlugar s WHERE s.sic1idenlugarPK.idTipoiden = :idTipoiden")
    , @NamedQuery(name = "Sic1idenlugar.findByCodIden", query = "SELECT s FROM Sic1idenlugar s WHERE s.sic1idenlugarPK.codIden = :codIden")
    , @NamedQuery(name = "Sic1idenlugar.findByFecDesde", query = "SELECT s FROM Sic1idenlugar s WHERE s.fecDesde = :fecDesde")
    , @NamedQuery(name = "Sic1idenlugar.findByFecHasta", query = "SELECT s FROM Sic1idenlugar s WHERE s.fecHasta = :fecHasta")
    , @NamedQuery(name = "Sic1idenlugar.findByIdLugar", query = "SELECT s FROM Sic1idenlugar s WHERE s.idLugar = :idLugar")})
public class Sic1idenlugar implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected Sic1idenlugarPK sic1idenlugarPK;
    @Column(name = "FEC_DESDE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecDesde;
    @Column(name = "FEC_HASTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecHasta;
    @Column(name = "ID_LUGAR")
    private BigInteger idLugar;

    public Sic1idenlugar() {
    }

    public Sic1idenlugar(Sic1idenlugarPK sic1idenlugarPK) {
        this.sic1idenlugarPK = sic1idenlugarPK;
    }

    public Sic1idenlugar(BigInteger idTipoiden, String codIden) {
        this.sic1idenlugarPK = new Sic1idenlugarPK(idTipoiden, codIden);
    }

    public Sic1idenlugarPK getSic1idenlugarPK() {
        return sic1idenlugarPK;
    }

    public void setSic1idenlugarPK(Sic1idenlugarPK sic1idenlugarPK) {
        this.sic1idenlugarPK = sic1idenlugarPK;
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

    public BigInteger getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(BigInteger idLugar) {
        this.idLugar = idLugar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sic1idenlugarPK != null ? sic1idenlugarPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sic1idenlugar)) {
            return false;
        }
        Sic1idenlugar other = (Sic1idenlugar) object;
        if ((this.sic1idenlugarPK == null && other.sic1idenlugarPK != null) || (this.sic1idenlugarPK != null && !this.sic1idenlugarPK.equals(other.sic1idenlugarPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.general.entity.Sic1idenlugar[ sic1idenlugarPK=" + sic1idenlugarPK + " ]";
    }
    
}
