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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author emoreno
 */
@Entity
@Table(name = "SIC3EVENPERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sic3evenpers.findAll", query = "SELECT s FROM Sic3evenpers s")
    , @NamedQuery(name = "Sic3evenpers.findByFecDesde", query = "SELECT s FROM Sic3evenpers s WHERE s.sic3evenpersPK.fecDesde = :fecDesde")
    , @NamedQuery(name = "Sic3evenpers.findByFecHasta", query = "SELECT s FROM Sic3evenpers s WHERE s.fecHasta = :fecHasta")
    , @NamedQuery(name = "Sic3evenpers.findByIdEven", query = "SELECT s FROM Sic3evenpers s WHERE s.sic3evenpersPK.idEven = :idEven")
    , @NamedQuery(name = "Sic3evenpers.findByIdTrelaeven", query = "SELECT s FROM Sic3evenpers s WHERE s.sic3evenpersPK.idTrelaeven = :idTrelaeven")
    , @NamedQuery(name = "Sic3evenpers.findByDesNotas", query = "SELECT s FROM Sic3evenpers s WHERE s.desNotas = :desNotas")
    , @NamedQuery(name = "Sic3evenpers.findByIdTrolpers", query = "SELECT s FROM Sic3evenpers s WHERE s.sic3evenpersPK.idTrolpers = :idTrolpers")
    , @NamedQuery(name = "Sic3evenpers.findByIdPers", query = "SELECT s FROM Sic3evenpers s WHERE s.sic3evenpersPK.idPers = :idPers")})
public class Sic3evenpers implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected Sic3evenpersPK sic3evenpersPK;
    @Column(name = "FEC_HASTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecHasta;
    @Size(max = 4000)
    @Column(name = "DES_NOTAS")
    private String desNotas;

    public Sic3evenpers() {
    }

    public Sic3evenpers(Sic3evenpersPK sic3evenpersPK) {
        this.sic3evenpersPK = sic3evenpersPK;
    }

    public Sic3evenpers(Date fecDesde, BigInteger idEven, BigInteger idTrelaeven, BigInteger idTrolpers, BigInteger idPers) {
        this.sic3evenpersPK = new Sic3evenpersPK(fecDesde, idEven, idTrelaeven, idTrolpers, idPers);
    }

    public Sic3evenpersPK getSic3evenpersPK() {
        return sic3evenpersPK;
    }

    public void setSic3evenpersPK(Sic3evenpersPK sic3evenpersPK) {
        this.sic3evenpersPK = sic3evenpersPK;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sic3evenpersPK != null ? sic3evenpersPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sic3evenpers)) {
            return false;
        }
        Sic3evenpers other = (Sic3evenpers) object;
        if ((this.sic3evenpersPK == null && other.sic3evenpersPK != null) || (this.sic3evenpersPK != null && !this.sic3evenpersPK.equals(other.sic3evenpersPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.general.entity.Sic3evenpers[ sic3evenpersPK=" + sic3evenpersPK + " ]";
    }
    
}
