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
@Table(name = "SIC3PERSESTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sic3persesta.findAll", query = "SELECT s FROM Sic3persesta s")
    , @NamedQuery(name = "Sic3persesta.findByFecDesde", query = "SELECT s FROM Sic3persesta s WHERE s.sic3persestaPK.fecDesde = :fecDesde")
    , @NamedQuery(name = "Sic3persesta.findByFecHasta", query = "SELECT s FROM Sic3persesta s WHERE s.fecHasta = :fecHasta")
    , @NamedQuery(name = "Sic3persesta.findByDesNotas", query = "SELECT s FROM Sic3persesta s WHERE s.desNotas = :desNotas")
    , @NamedQuery(name = "Sic3persesta.findByIdTrelapers", query = "SELECT s FROM Sic3persesta s WHERE s.sic3persestaPK.idTrelapers = :idTrelapers")
    , @NamedQuery(name = "Sic3persesta.findByIdEstapers", query = "SELECT s FROM Sic3persesta s WHERE s.sic3persestaPK.idEstapers = :idEstapers")
    , @NamedQuery(name = "Sic3persesta.findByIdTrolestapers", query = "SELECT s FROM Sic3persesta s WHERE s.sic3persestaPK.idTrolestapers = :idTrolestapers")
    , @NamedQuery(name = "Sic3persesta.findByIdTrolpers", query = "SELECT s FROM Sic3persesta s WHERE s.sic3persestaPK.idTrolpers = :idTrolpers")
    , @NamedQuery(name = "Sic3persesta.findByIdPers", query = "SELECT s FROM Sic3persesta s WHERE s.sic3persestaPK.idPers = :idPers")})
public class Sic3persesta implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected Sic3persestaPK sic3persestaPK;
    @Column(name = "FEC_HASTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecHasta;
    @Size(max = 4000)
    @Column(name = "DES_NOTAS")
    private String desNotas;

    public Sic3persesta() {
    }

    public Sic3persesta(Sic3persestaPK sic3persestaPK) {
        this.sic3persestaPK = sic3persestaPK;
    }

    public Sic3persesta(Date fecDesde, BigInteger idTrelapers, BigInteger idEstapers, BigInteger idTrolestapers, BigInteger idTrolpers, BigInteger idPers) {
        this.sic3persestaPK = new Sic3persestaPK(fecDesde, idTrelapers, idEstapers, idTrolestapers, idTrolpers, idPers);
    }

    public Sic3persestaPK getSic3persestaPK() {
        return sic3persestaPK;
    }

    public void setSic3persestaPK(Sic3persestaPK sic3persestaPK) {
        this.sic3persestaPK = sic3persestaPK;
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
        hash += (sic3persestaPK != null ? sic3persestaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sic3persesta)) {
            return false;
        }
        Sic3persesta other = (Sic3persesta) object;
        if ((this.sic3persestaPK == null && other.sic3persestaPK != null) || (this.sic3persestaPK != null && !this.sic3persestaPK.equals(other.sic3persestaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.general.entity.Sic3persesta[ sic3persestaPK=" + sic3persestaPK + " ]";
    }
    
}
