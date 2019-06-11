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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "SIC3PRODITEMPERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sic3proditempers.findAll", query = "SELECT s FROM Sic3proditempers s")
    , @NamedQuery(name = "Sic3proditempers.findByIdProditem", query = "SELECT s FROM Sic3proditempers s WHERE s.sic3proditempersPK.idProditem = :idProditem")
    , @NamedQuery(name = "Sic3proditempers.findByIdPers", query = "SELECT s FROM Sic3proditempers s WHERE s.sic3proditempersPK.idPers = :idPers")
    , @NamedQuery(name = "Sic3proditempers.findByIdTrelaproditem", query = "SELECT s FROM Sic3proditempers s WHERE s.sic3proditempersPK.idTrelaproditem = :idTrelaproditem")
    , @NamedQuery(name = "Sic3proditempers.findByFecDesde", query = "SELECT s FROM Sic3proditempers s WHERE s.fecDesde = :fecDesde")
    , @NamedQuery(name = "Sic3proditempers.findByFecHasta", query = "SELECT s FROM Sic3proditempers s WHERE s.sic3proditempersPK.fecHasta = :fecHasta")
    , @NamedQuery(name = "Sic3proditempers.findByDesNotas", query = "SELECT s FROM Sic3proditempers s WHERE s.desNotas = :desNotas")
    , @NamedQuery(name = "Sic3proditempers.findByIdTrolpers", query = "SELECT s FROM Sic3proditempers s WHERE s.idTrolpers = :idTrolpers")})
public class Sic3proditempers implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected Sic3proditempersPK sic3proditempersPK;
    @Basic(optional = false)
    @Column(name = "FEC_DESDE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecDesde;
    @Column(name = "DES_NOTAS")
    private String desNotas;
    @Basic(optional = false)
    @Column(name = "ID_TROLPERS")
    private BigInteger idTrolpers;
    @JoinColumn(name = "ID_PRODITEM", referencedColumnName = "ID_PRODITEM", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Sic1proditem sic1proditem;
    
    /*AGREGADOS*/
    private Sic1pers sic1pers;

    public Sic3proditempers() {
    }

    public Sic3proditempers(Sic3proditempersPK sic3proditempersPK) {
        this.sic3proditempersPK = sic3proditempersPK;
    }

    public Sic3proditempers(Sic3proditempersPK sic3proditempersPK, Date fecDesde, BigInteger idTrolpers) {
        this.sic3proditempersPK = sic3proditempersPK;
        this.fecDesde = fecDesde;
        this.idTrolpers = idTrolpers;
    }

    public Sic3proditempers(BigDecimal idProditem,  BigDecimal idPers, Integer idTrelaproditem, Date fecHasta) {
        this.sic3proditempersPK = new Sic3proditempersPK(idProditem, idPers, idTrelaproditem, fecHasta);
    }

    public Sic3proditempersPK getSic3proditempersPK() {
        return sic3proditempersPK;
    }

    public void setSic3proditempersPK(Sic3proditempersPK sic3proditempersPK) {
        this.sic3proditempersPK = sic3proditempersPK;
    }

    public Date getFecDesde() {
        return fecDesde;
    }

    public void setFecDesde(Date fecDesde) {
        this.fecDesde = fecDesde;
    }

    public String getDesNotas() {
        return desNotas;
    }

    public void setDesNotas(String desNotas) {
        this.desNotas = desNotas;
    }

    public BigInteger getIdTrolpers() {
        return idTrolpers;
    }

    public void setIdTrolpers(BigInteger idTrolpers) {
        this.idTrolpers = idTrolpers;
    }

    public Sic1proditem getSic1proditem() {
        return sic1proditem;
    }

    public void setSic1proditem(Sic1proditem sic1proditem) {
        this.sic1proditem = sic1proditem;
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
        hash += (sic3proditempersPK != null ? sic3proditempersPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sic3proditempers)) {
            return false;
        }
        Sic3proditempers other = (Sic3proditempers) object;
        if ((this.sic3proditempersPK == null && other.sic3proditempersPK != null) || (this.sic3proditempersPK != null && !this.sic3proditempersPK.equals(other.sic3proditempersPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.general.entity.Sic3proditempers[ sic3proditempersPK=" + sic3proditempersPK + " ]";
    }
    
}
