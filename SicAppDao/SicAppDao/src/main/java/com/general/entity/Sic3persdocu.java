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
@Table(name = "SIC3PERSDOCU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sic3persdocu.findAll", query = "SELECT s FROM Sic3persdocu s")
    , @NamedQuery(name = "Sic3persdocu.findByFecDesde", query = "SELECT s FROM Sic3persdocu s WHERE s.sic3persdocuPK.fecDesde = :fecDesde")
    , @NamedQuery(name = "Sic3persdocu.findByFecHasta", query = "SELECT s FROM Sic3persdocu s WHERE s.fecHasta = :fecHasta")
    , @NamedQuery(name = "Sic3persdocu.findByDesNotas", query = "SELECT s FROM Sic3persdocu s WHERE s.desNotas = :desNotas")
    , @NamedQuery(name = "Sic3persdocu.findByIdTrolpers", query = "SELECT s FROM Sic3persdocu s WHERE s.sic3persdocuPK.idTrolpers = :idTrolpers")
    , @NamedQuery(name = "Sic3persdocu.findByIdTrelapers", query = "SELECT s FROM Sic3persdocu s WHERE s.sic3persdocuPK.idTrelapers = :idTrelapers")
    , @NamedQuery(name = "Sic3persdocu.findByIdDocu", query = "SELECT s FROM Sic3persdocu s WHERE s.sic3persdocuPK.idDocu = :idDocu")
    , @NamedQuery(name = "Sic3persdocu.findByIdPers", query = "SELECT s FROM Sic3persdocu s WHERE s.sic3persdocuPK.idPers = :idPers")
    , @NamedQuery(name = "Sic3persdocu.findByIdEven", query = "SELECT s FROM Sic3persdocu s WHERE s.idEven = :idEven")})
public class Sic3persdocu implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected Sic3persdocuPK sic3persdocuPK;
    @Column(name = "FEC_HASTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecHasta;
    @Size(max = 4000)
    @Column(name = "DES_NOTAS")
    private String desNotas;
    @Column(name = "ID_EVEN")
    private BigInteger idEven;

    public Sic3persdocu() {
    }

    public Sic3persdocu(Sic3persdocuPK sic3persdocuPK) {
        this.sic3persdocuPK = sic3persdocuPK;
    }

    public Sic3persdocu(Date fecDesde, BigInteger idTrolpers, BigInteger idTrelapers, BigInteger idDocu, BigInteger idPers) {
        this.sic3persdocuPK = new Sic3persdocuPK(fecDesde, idTrolpers, idTrelapers, idDocu, idPers);
    }

    public Sic3persdocuPK getSic3persdocuPK() {
        return sic3persdocuPK;
    }

    public void setSic3persdocuPK(Sic3persdocuPK sic3persdocuPK) {
        this.sic3persdocuPK = sic3persdocuPK;
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

    public BigInteger getIdEven() {
        return idEven;
    }

    public void setIdEven(BigInteger idEven) {
        this.idEven = idEven;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sic3persdocuPK != null ? sic3persdocuPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sic3persdocu)) {
            return false;
        }
        Sic3persdocu other = (Sic3persdocu) object;
        if ((this.sic3persdocuPK == null && other.sic3persdocuPK != null) || (this.sic3persdocuPK != null && !this.sic3persdocuPK.equals(other.sic3persdocuPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.general.entity.Sic3persdocu[ sic3persdocuPK=" + sic3persdocuPK + " ]";
    }
    
}
