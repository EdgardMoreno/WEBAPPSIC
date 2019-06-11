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
@Table(name = "SIC3PRODDOCU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sic3proddocu.findAll", query = "SELECT s FROM Sic3proddocu s")
    , @NamedQuery(name = "Sic3proddocu.findByIdProd", query = "SELECT s FROM Sic3proddocu s WHERE s.sic3proddocuPK.idProd = :idProd")
    , @NamedQuery(name = "Sic3proddocu.findByIdDocu", query = "SELECT s FROM Sic3proddocu s WHERE s.sic3proddocuPK.idDocu = :idDocu")
    , @NamedQuery(name = "Sic3proddocu.findByIdTrelaprod", query = "SELECT s FROM Sic3proddocu s WHERE s.sic3proddocuPK.idTrelaprod = :idTrelaprod")
    , @NamedQuery(name = "Sic3proddocu.findByFecDesde", query = "SELECT s FROM Sic3proddocu s WHERE s.sic3proddocuPK.fecDesde = :fecDesde")
    , @NamedQuery(name = "Sic3proddocu.findByFecHasta", query = "SELECT s FROM Sic3proddocu s WHERE s.fecHasta = :fecHasta")
    , @NamedQuery(name = "Sic3proddocu.findByDesNotas", query = "SELECT s FROM Sic3proddocu s WHERE s.desNotas = :desNotas")})
public class Sic3proddocu implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected Sic3proddocuPK sic3proddocuPK;
    @Column(name = "FEC_HASTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecHasta;
    @Column(name = "DES_NOTAS")
    private String desNotas;
    @JoinColumn(name = "ID_DOCU", referencedColumnName = "ID_DOCU", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Sic1docu sic1docu;
    @JoinColumn(name = "ID_PROD", referencedColumnName = "ID_PROD", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Sic1prod sic1prod;
    @JoinColumn(name = "ID_TRELAPROD", referencedColumnName = "ID_TRELA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Sic8trela sic8trela;

    public Sic3proddocu() {
    }

    public Sic3proddocu(Sic3proddocuPK sic3proddocuPK) {
        this.sic3proddocuPK = sic3proddocuPK;
    }

    public Sic3proddocu(BigInteger idProd, BigInteger idDocu, BigInteger idTrelaprod, Date fecDesde) {
        this.sic3proddocuPK = new Sic3proddocuPK(idProd, idDocu, idTrelaprod, fecDesde);
    }

    public Sic3proddocuPK getSic3proddocuPK() {
        return sic3proddocuPK;
    }

    public void setSic3proddocuPK(Sic3proddocuPK sic3proddocuPK) {
        this.sic3proddocuPK = sic3proddocuPK;
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

    public Sic1prod getSic1prod() {
        return sic1prod;
    }

    public void setSic1prod(Sic1prod sic1prod) {
        this.sic1prod = sic1prod;
    }

    public Sic8trela getSic8trela() {
        return sic8trela;
    }

    public void setSic8trela(Sic8trela sic8trela) {
        this.sic8trela = sic8trela;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sic3proddocuPK != null ? sic3proddocuPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sic3proddocu)) {
            return false;
        }
        Sic3proddocu other = (Sic3proddocu) object;
        if ((this.sic3proddocuPK == null && other.sic3proddocuPK != null) || (this.sic3proddocuPK != null && !this.sic3proddocuPK.equals(other.sic3proddocuPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.general.entity.Sic3proddocu[ sic3proddocuPK=" + sic3proddocuPK + " ]";
    }
    
}
