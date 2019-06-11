/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author emoreno
 */
@Entity
@Table(name = "SIC3PRODPERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sic3prodpers.findAll", query = "SELECT s FROM Sic3prodpers s")
    , @NamedQuery(name = "Sic3prodpers.findByIdProd", query = "SELECT s FROM Sic3prodpers s WHERE s.sic3prodpersPK.idProd = :idProd")
    , @NamedQuery(name = "Sic3prodpers.findByIdPers", query = "SELECT s FROM Sic3prodpers s WHERE s.sic3prodpersPK.idPers = :idPers")
    , @NamedQuery(name = "Sic3prodpers.findByIdTrelaprod", query = "SELECT s FROM Sic3prodpers s WHERE s.sic3prodpersPK.idTrelaprod = :idTrelaprod")
    , @NamedQuery(name = "Sic3prodpers.findByFecDesde", query = "SELECT s FROM Sic3prodpers s WHERE s.sic3prodpersPK.fecDesde = :fecDesde")
    , @NamedQuery(name = "Sic3prodpers.findByFecHasta", query = "SELECT s FROM Sic3prodpers s WHERE s.fecHasta = :fecHasta")
    , @NamedQuery(name = "Sic3prodpers.findByDesNotas", query = "SELECT s FROM Sic3prodpers s WHERE s.desNotas = :desNotas")
    , @NamedQuery(name = "Sic3prodpers.findByIdTrolpers", query = "SELECT s FROM Sic3prodpers s WHERE s.sic3prodpersPK.idTrolpers = :idTrolpers")})
public class Sic3prodpers implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected Sic3prodpersPK sic3prodpersPK;
    @Column(name = "FEC_HASTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecHasta;
    @Size(max = 4000)
    @Column(name = "DES_NOTAS")
    private String desNotas;
    @ManyToOne(optional = false)
    private Sic1prod sic1prod;
    @ManyToOne(optional = false)
    private Sic1pers sic1pers;

    public Sic3prodpers() {
    }

    public Sic3prodpers(Sic3prodpersPK sic3prodpersPK) {
        this.sic3prodpersPK = sic3prodpersPK;
    }

    public Sic3prodpers(BigDecimal idProd, BigDecimal idPers, Integer idTrelaprod, Date fecDesde, Integer idTrolpers) {
        this.sic3prodpersPK = new Sic3prodpersPK(idProd, idPers, idTrelaprod, fecDesde, idTrolpers);
    }

    public Sic3prodpersPK getSic3prodpersPK() {
        return sic3prodpersPK;
    }

    public void setSic3prodpersPK(Sic3prodpersPK sic3prodpersPK) {
        this.sic3prodpersPK = sic3prodpersPK;
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

    public Sic1prod getSic1prod() {
        return sic1prod;
    }

    public void setSic1prod(Sic1prod sic1prod) {
        this.sic1prod = sic1prod;
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
        hash += (sic3prodpersPK != null ? sic3prodpersPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sic3prodpers)) {
            return false;
        }
        Sic3prodpers other = (Sic3prodpers) object;
        if ((this.sic3prodpersPK == null && other.sic3prodpersPK != null) || (this.sic3prodpersPK != null && !this.sic3prodpersPK.equals(other.sic3prodpersPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.general.entity.Sic3prodpers[ sic3prodpersPK=" + sic3prodpersPK + " ]";
    }
    
}
