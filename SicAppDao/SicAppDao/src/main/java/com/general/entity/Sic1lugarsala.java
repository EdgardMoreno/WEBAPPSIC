/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author emoreno
 */
@Entity
@Table(name = "SIC1LUGARSALA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sic1lugarsala.findAll", query = "SELECT s FROM Sic1lugarsala s")
    , @NamedQuery(name = "Sic1lugarsala.findByIdLugarsala", query = "SELECT s FROM Sic1lugarsala s WHERE s.sic1lugarsalaPK.idLugarsala = :idLugarsala")
    , @NamedQuery(name = "Sic1lugarsala.findByIdTiposala", query = "SELECT s FROM Sic1lugarsala s WHERE s.sic1lugarsalaPK.idTiposala = :idTiposala")
    , @NamedQuery(name = "Sic1lugarsala.findByFlgEstasala", query = "SELECT s FROM Sic1lugarsala s WHERE s.flgEstasala = :flgEstasala")
    , @NamedQuery(name = "Sic1lugarsala.findByFlgEstasusp", query = "SELECT s FROM Sic1lugarsala s WHERE s.flgEstasusp = :flgEstasusp")
    , @NamedQuery(name = "Sic1lugarsala.findByIdTipogiro", query = "SELECT s FROM Sic1lugarsala s WHERE s.idTipogiro = :idTipogiro")
    , @NamedQuery(name = "Sic1lugarsala.findByDesNomgiro", query = "SELECT s FROM Sic1lugarsala s WHERE s.desNomgiro = :desNomgiro")
    , @NamedQuery(name = "Sic1lugarsala.findByFlgModmt", query = "SELECT s FROM Sic1lugarsala s WHERE s.flgModmt = :flgModmt")
    , @NamedQuery(name = "Sic1lugarsala.findByFlgModmls", query = "SELECT s FROM Sic1lugarsala s WHERE s.flgModmls = :flgModmls")
    , @NamedQuery(name = "Sic1lugarsala.findByFlgModmesa", query = "SELECT s FROM Sic1lugarsala s WHERE s.flgModmesa = :flgModmesa")})
public class Sic1lugarsala implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected Sic1lugarsalaPK sic1lugarsalaPK;
    @Column(name = "FLG_ESTASALA")
    private BigInteger flgEstasala;
    @Column(name = "FLG_ESTASUSP")
    private BigInteger flgEstasusp;
    @Column(name = "ID_TIPOGIRO")
    private BigInteger idTipogiro;
    @Size(max = 100)
    @Column(name = "DES_NOMGIRO")
    private String desNomgiro;
    @Column(name = "FLG_MODMT")
    private Short flgModmt;
    @Column(name = "FLG_MODMLS")
    private Short flgModmls;
    @Column(name = "FLG_MODMESA")
    private Short flgModmesa;
    @JoinColumn(name = "ID_LUGARSALA", referencedColumnName = "ID_LUGAR", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Sic1lugar sic1lugar;

    public Sic1lugarsala() {
    }

    public Sic1lugarsala(Sic1lugarsalaPK sic1lugarsalaPK) {
        this.sic1lugarsalaPK = sic1lugarsalaPK;
    }

    public Sic1lugarsala(BigInteger idLugarsala, BigInteger idTiposala) {
        this.sic1lugarsalaPK = new Sic1lugarsalaPK(idLugarsala, idTiposala);
    }

    public Sic1lugarsalaPK getSic1lugarsalaPK() {
        return sic1lugarsalaPK;
    }

    public void setSic1lugarsalaPK(Sic1lugarsalaPK sic1lugarsalaPK) {
        this.sic1lugarsalaPK = sic1lugarsalaPK;
    }

    public BigInteger getFlgEstasala() {
        return flgEstasala;
    }

    public void setFlgEstasala(BigInteger flgEstasala) {
        this.flgEstasala = flgEstasala;
    }

    public BigInteger getFlgEstasusp() {
        return flgEstasusp;
    }

    public void setFlgEstasusp(BigInteger flgEstasusp) {
        this.flgEstasusp = flgEstasusp;
    }

    public BigInteger getIdTipogiro() {
        return idTipogiro;
    }

    public void setIdTipogiro(BigInteger idTipogiro) {
        this.idTipogiro = idTipogiro;
    }

    public String getDesNomgiro() {
        return desNomgiro;
    }

    public void setDesNomgiro(String desNomgiro) {
        this.desNomgiro = desNomgiro;
    }

    public Short getFlgModmt() {
        return flgModmt;
    }

    public void setFlgModmt(Short flgModmt) {
        this.flgModmt = flgModmt;
    }

    public Short getFlgModmls() {
        return flgModmls;
    }

    public void setFlgModmls(Short flgModmls) {
        this.flgModmls = flgModmls;
    }

    public Short getFlgModmesa() {
        return flgModmesa;
    }

    public void setFlgModmesa(Short flgModmesa) {
        this.flgModmesa = flgModmesa;
    }

    public Sic1lugar getSic1lugar() {
        return sic1lugar;
    }

    public void setSic1lugar(Sic1lugar sic1lugar) {
        this.sic1lugar = sic1lugar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sic1lugarsalaPK != null ? sic1lugarsalaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sic1lugarsala)) {
            return false;
        }
        Sic1lugarsala other = (Sic1lugarsala) object;
        if ((this.sic1lugarsalaPK == null && other.sic1lugarsalaPK != null) || (this.sic1lugarsalaPK != null && !this.sic1lugarsalaPK.equals(other.sic1lugarsalaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.general.entity.Sic1lugarsala[ sic1lugarsalaPK=" + sic1lugarsalaPK + " ]";
    }
    
}
