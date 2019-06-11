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
@Table(name = "SIC1IDENDOCU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sic1idendocu.findAll", query = "SELECT s FROM Sic1idendocu s")
    , @NamedQuery(name = "Sic1idendocu.findByIdTipoiden", query = "SELECT s FROM Sic1idendocu s WHERE s.sic1idendocuPK.idTipoiden = :idTipoiden")
    , @NamedQuery(name = "Sic1idendocu.findByCodIden", query = "SELECT s FROM Sic1idendocu s WHERE s.sic1idendocuPK.codIden = :codIden")
    , @NamedQuery(name = "Sic1idendocu.findByFecDesde", query = "SELECT s FROM Sic1idendocu s WHERE s.fecDesde = :fecDesde")
    , @NamedQuery(name = "Sic1idendocu.findByFecHasta", query = "SELECT s FROM Sic1idendocu s WHERE s.fecHasta = :fecHasta")
    , @NamedQuery(name = "Sic1idendocu.findByIdDocu", query = "SELECT s FROM Sic1idendocu s WHERE s.idDocu = :idDocu")})
public class Sic1idendocu implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected Sic1idendocuPK sic1idendocuPK;
    @Column(name = "FEC_DESDE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecDesde;
    @Column(name = "FEC_HASTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecHasta;
    @Basic(optional = false)
    @Column(name = "ID_DOCU")
    private BigInteger idDocu;

    public Sic1idendocu() {
    }

    public Sic1idendocu(Sic1idendocuPK sic1idendocuPK) {
        this.sic1idendocuPK = sic1idendocuPK;
    }

    public Sic1idendocu(Sic1idendocuPK sic1idendocuPK, BigInteger idDocu) {
        this.sic1idendocuPK = sic1idendocuPK;
        this.idDocu = idDocu;
    }

    public Sic1idendocu(Integer idTipoiden, String codIden) {
        this.sic1idendocuPK = new Sic1idendocuPK(idTipoiden, codIden);
    }

    public Sic1idendocuPK getSic1idendocuPK() {
        return sic1idendocuPK;
    }

    public void setSic1idendocuPK(Sic1idendocuPK sic1idendocuPK) {
        this.sic1idendocuPK = sic1idendocuPK;
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

    public BigInteger getIdDocu() {
        return idDocu;
    }

    public void setIdDocu(BigInteger idDocu) {
        this.idDocu = idDocu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sic1idendocuPK != null ? sic1idendocuPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sic1idendocu)) {
            return false;
        }
        Sic1idendocu other = (Sic1idendocu) object;
        if ((this.sic1idendocuPK == null && other.sic1idendocuPK != null) || (this.sic1idendocuPK != null && !this.sic1idendocuPK.equals(other.sic1idendocuPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.general.sicappdao.Sic1idendocu[ sic1idendocuPK=" + sic1idendocuPK + " ]";
    }
    
}
