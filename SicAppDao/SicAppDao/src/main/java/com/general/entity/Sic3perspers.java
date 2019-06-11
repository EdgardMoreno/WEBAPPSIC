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
@Table(name = "SIC3PERSPERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sic3perspers.findAll", query = "SELECT s FROM Sic3perspers s")
    , @NamedQuery(name = "Sic3perspers.findByFecDesde", query = "SELECT s FROM Sic3perspers s WHERE s.sic3perspersPK.fecDesde = :fecDesde")
    , @NamedQuery(name = "Sic3perspers.findByFecHasta", query = "SELECT s FROM Sic3perspers s WHERE s.fecHasta = :fecHasta")
    , @NamedQuery(name = "Sic3perspers.findByDesNotas", query = "SELECT s FROM Sic3perspers s WHERE s.desNotas = :desNotas")
    , @NamedQuery(name = "Sic3perspers.findByIdTrelapers", query = "SELECT s FROM Sic3perspers s WHERE s.sic3perspersPK.idTrelapers = :idTrelapers")
    , @NamedQuery(name = "Sic3perspers.findByIdTrolpers", query = "SELECT s FROM Sic3perspers s WHERE s.sic3perspersPK.idTrolpers = :idTrolpers")
    , @NamedQuery(name = "Sic3perspers.findByFlgCreaeven", query = "SELECT s FROM Sic3perspers s WHERE s.flgCreaeven = :flgCreaeven")
    , @NamedQuery(name = "Sic3perspers.findByIdPers", query = "SELECT s FROM Sic3perspers s WHERE s.sic3perspersPK.idPers = :idPers")
    , @NamedQuery(name = "Sic3perspers.findByIdTrolpersrel", query = "SELECT s FROM Sic3perspers s WHERE s.sic3perspersPK.idTrolpersrel = :idTrolpersrel")
    , @NamedQuery(name = "Sic3perspers.findByIdPersrel", query = "SELECT s FROM Sic3perspers s WHERE s.sic3perspersPK.idPersrel = :idPersrel")})
public class Sic3perspers implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected Sic3perspersPK sic3perspersPK;
    @Column(name = "FEC_HASTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecHasta;
    @Size(max = 4000)
    @Column(name = "DES_NOTAS")
    private String desNotas;
    @Column(name = "FLG_CREAEVEN")
    private BigInteger flgCreaeven;

    public Sic3perspers() {
    }

    public Sic3perspers(Sic3perspersPK sic3perspersPK) {
        this.sic3perspersPK = sic3perspersPK;
    }

    public Sic3perspers(Date fecDesde, BigInteger idTrelapers, BigInteger idTrolpers, BigInteger idPers, BigInteger idTrolpersrel, BigInteger idPersrel) {
        this.sic3perspersPK = new Sic3perspersPK(fecDesde, idTrelapers, idTrolpers, idPers, idTrolpersrel, idPersrel);
    }

    public Sic3perspersPK getSic3perspersPK() {
        return sic3perspersPK;
    }

    public void setSic3perspersPK(Sic3perspersPK sic3perspersPK) {
        this.sic3perspersPK = sic3perspersPK;
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

    public BigInteger getFlgCreaeven() {
        return flgCreaeven;
    }

    public void setFlgCreaeven(BigInteger flgCreaeven) {
        this.flgCreaeven = flgCreaeven;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sic3perspersPK != null ? sic3perspersPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sic3perspers)) {
            return false;
        }
        Sic3perspers other = (Sic3perspers) object;
        if ((this.sic3perspersPK == null && other.sic3perspersPK != null) || (this.sic3perspersPK != null && !this.sic3perspersPK.equals(other.sic3perspersPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.general.entity.Sic3perspers[ sic3perspersPK=" + sic3perspersPK + " ]";
    }
    
}
