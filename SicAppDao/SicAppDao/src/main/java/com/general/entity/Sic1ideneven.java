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
@Table(name = "SIC1IDENEVEN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sic1ideneven.findAll", query = "SELECT s FROM Sic1ideneven s")
    , @NamedQuery(name = "Sic1ideneven.findByIdTipoiden", query = "SELECT s FROM Sic1ideneven s WHERE s.sic1idenevenPK.idTipoiden = :idTipoiden")
    , @NamedQuery(name = "Sic1ideneven.findByCodIden", query = "SELECT s FROM Sic1ideneven s WHERE s.sic1idenevenPK.codIden = :codIden")
    , @NamedQuery(name = "Sic1ideneven.findByFecDesde", query = "SELECT s FROM Sic1ideneven s WHERE s.fecDesde = :fecDesde")
    , @NamedQuery(name = "Sic1ideneven.findByFecHasta", query = "SELECT s FROM Sic1ideneven s WHERE s.fecHasta = :fecHasta")
    , @NamedQuery(name = "Sic1ideneven.findByIdEven", query = "SELECT s FROM Sic1ideneven s WHERE s.idEven = :idEven")
    , @NamedQuery(name = "Sic1ideneven.findByIdTrelapers", query = "SELECT s FROM Sic1ideneven s WHERE s.idTrelapers = :idTrelapers")
    , @NamedQuery(name = "Sic1ideneven.findByIdTrolpers", query = "SELECT s FROM Sic1ideneven s WHERE s.idTrolpers = :idTrolpers")
    , @NamedQuery(name = "Sic1ideneven.findByIdPers", query = "SELECT s FROM Sic1ideneven s WHERE s.idPers = :idPers")
    , @NamedQuery(name = "Sic1ideneven.findByIdTrolpersrel", query = "SELECT s FROM Sic1ideneven s WHERE s.idTrolpersrel = :idTrolpersrel")
    , @NamedQuery(name = "Sic1ideneven.findByIdPersrel", query = "SELECT s FROM Sic1ideneven s WHERE s.idPersrel = :idPersrel")})
public class Sic1ideneven implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected Sic1idenevenPK sic1idenevenPK;
    @Column(name = "FEC_DESDE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecDesde;
    @Column(name = "FEC_HASTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecHasta;
    @Column(name = "ID_EVEN")
    private BigDecimal idEven;
    @Column(name = "ID_TRELAPERS")
    private Integer idTrelapers;
    @Column(name = "ID_TROLPERS")
    private Integer idTrolpers;
    @Column(name = "ID_PERS")
    private BigDecimal idPers;
    @Column(name = "ID_TROLPERSREL")
    private Integer idTrolpersrel;
    @Column(name = "ID_PERSREL")
    private Integer idPersrel;

    /*AGREGADO*/    
    private Sic1pers sic1pers;
    
    public Sic1ideneven() {
    }

    public Sic1ideneven(Sic1idenevenPK sic1idenevenPK) {
        this.sic1idenevenPK = sic1idenevenPK;
    }

    public Sic1ideneven(BigInteger idTipoiden, String codIden) {
        this.sic1idenevenPK = new Sic1idenevenPK(idTipoiden, codIden);
    }

    public Sic1idenevenPK getSic1idenevenPK() {
        return sic1idenevenPK;
    }

    public void setSic1idenevenPK(Sic1idenevenPK sic1idenevenPK) {
        this.sic1idenevenPK = sic1idenevenPK;
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

    public BigDecimal getIdEven() {
        return idEven;
    }

    public void setIdEven(BigDecimal idEven) {
        this.idEven = idEven;
    }

    public Integer getIdTrelapers() {
        return idTrelapers;
    }

    public void setIdTrelapers(Integer idTrelapers) {
        this.idTrelapers = idTrelapers;
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

    public Integer getIdTrolpersrel() {
        return idTrolpersrel;
    }

    public void setIdTrolpersrel(Integer idTrolpersrel) {
        this.idTrolpersrel = idTrolpersrel;
    }

    public Integer getIdPersrel() {
        return idPersrel;
    }

    public void setIdPersrel(Integer idPersrel) {
        this.idPersrel = idPersrel;
    }

    public Sic1pers getSic1pers() {
        return sic1pers;
    }

    public void setSic1pers(Sic1pers sic1pers) {
        this.sic1pers = sic1pers;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sic1idenevenPK != null ? sic1idenevenPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sic1ideneven)) {
            return false;
        }
        Sic1ideneven other = (Sic1ideneven) object;
        if ((this.sic1idenevenPK == null && other.sic1idenevenPK != null) || (this.sic1idenevenPK != null && !this.sic1idenevenPK.equals(other.sic1idenevenPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.general.entity.Sic1ideneven[ sic1idenevenPK=" + sic1idenevenPK + " ]";
    }
    
}
