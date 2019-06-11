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
@Table(name = "SIC3PRODITEMDOCU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sic3proditemdocu.findAll", query = "SELECT s FROM Sic3proditemdocu s")
    , @NamedQuery(name = "Sic3proditemdocu.findByIdProditem", query = "SELECT s FROM Sic3proditemdocu s WHERE s.sic3proditemdocuPK.idProditem = :idProditem")
    , @NamedQuery(name = "Sic3proditemdocu.findByIdTrelaproditem", query = "SELECT s FROM Sic3proditemdocu s WHERE s.sic3proditemdocuPK.idTrelaproditem = :idTrelaproditem")
    , @NamedQuery(name = "Sic3proditemdocu.findByIdDocu", query = "SELECT s FROM Sic3proditemdocu s WHERE s.sic3proditemdocuPK.idDocu = :idDocu")
    , @NamedQuery(name = "Sic3proditemdocu.findByFecDesde", query = "SELECT s FROM Sic3proditemdocu s WHERE s.fecDesde = :fecDesde")
    , @NamedQuery(name = "Sic3proditemdocu.findByFecHasta", query = "SELECT s FROM Sic3proditemdocu s WHERE s.fecHasta = :fecHasta")
    , @NamedQuery(name = "Sic3proditemdocu.findByDesNotas", query = "SELECT s FROM Sic3proditemdocu s WHERE s.desNotas = :desNotas")})
public class Sic3proditemdocu implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected Sic3proditemdocuPK sic3proditemdocuPK;
    @Basic(optional = false)
    @Column(name = "FEC_DESDE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecDesde;
    @Column(name = "FEC_HASTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecHasta;
    @Column(name = "DES_NOTAS")
    private String desNotas;
    @JoinColumn(name = "ID_DOCU", referencedColumnName = "ID_DOCU", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Sic1docu sic1docu;
    @JoinColumn(name = "ID_PRODITEM", referencedColumnName = "ID_PRODITEM", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Sic1proditem sic1proditem;

    public Sic3proditemdocu() {
    }

    public Sic3proditemdocu(Sic3proditemdocuPK sic3proditemdocuPK) {
        this.sic3proditemdocuPK = sic3proditemdocuPK;
    }

    public Sic3proditemdocu(Sic3proditemdocuPK sic3proditemdocuPK, Date fecDesde) {
        this.sic3proditemdocuPK = sic3proditemdocuPK;
        this.fecDesde = fecDesde;
    }

    public Sic3proditemdocu(BigInteger idProditem, BigInteger idTrelaproditem, BigInteger idDocu) {
        this.sic3proditemdocuPK = new Sic3proditemdocuPK(idProditem, idTrelaproditem, idDocu);
    }

    public Sic3proditemdocuPK getSic3proditemdocuPK() {
        return sic3proditemdocuPK;
    }

    public void setSic3proditemdocuPK(Sic3proditemdocuPK sic3proditemdocuPK) {
        this.sic3proditemdocuPK = sic3proditemdocuPK;
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

    public String getDesNotas() {
        return desNotas;
    }

    public void setDesNotas(String desNotas) {
        this.desNotas = desNotas;
    }

    public Sic1docu getSic1docu() {
        return sic1docu;
    }

    public void setSic1docu(Sic1docu sic1docu) {
        this.sic1docu = sic1docu;
    }

    public Sic1proditem getSic1proditem() {
        return sic1proditem;
    }

    public void setSic1proditem(Sic1proditem sic1proditem) {
        this.sic1proditem = sic1proditem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sic3proditemdocuPK != null ? sic3proditemdocuPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sic3proditemdocu)) {
            return false;
        }
        Sic3proditemdocu other = (Sic3proditemdocu) object;
        if ((this.sic3proditemdocuPK == null && other.sic3proditemdocuPK != null) || (this.sic3proditemdocuPK != null && !this.sic3proditemdocuPK.equals(other.sic3proditemdocuPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.general.entity.Sic3proditemdocu[ sic3proditemdocuPK=" + sic3proditemdocuPK + " ]";
    }
    
}
