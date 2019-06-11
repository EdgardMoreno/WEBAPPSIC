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
@Table(name = "SIC3EVENDOCU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sic3evendocu.findAll", query = "SELECT s FROM Sic3evendocu s")
    , @NamedQuery(name = "Sic3evendocu.findByFecHasta", query = "SELECT s FROM Sic3evendocu s WHERE s.fecHasta = :fecHasta")
    , @NamedQuery(name = "Sic3evendocu.findByDesNotas", query = "SELECT s FROM Sic3evendocu s WHERE s.desNotas = :desNotas")
    , @NamedQuery(name = "Sic3evendocu.findByFecDesde", query = "SELECT s FROM Sic3evendocu s WHERE s.sic3evendocuPK.fecDesde = :fecDesde")
    , @NamedQuery(name = "Sic3evendocu.findByIdEven", query = "SELECT s FROM Sic3evendocu s WHERE s.sic3evendocuPK.idEven = :idEven")
    , @NamedQuery(name = "Sic3evendocu.findByIdTrelaeven", query = "SELECT s FROM Sic3evendocu s WHERE s.sic3evendocuPK.idTrelaeven = :idTrelaeven")
    , @NamedQuery(name = "Sic3evendocu.findByIdDocu", query = "SELECT s FROM Sic3evendocu s WHERE s.sic3evendocuPK.idDocu = :idDocu")
    , @NamedQuery(name = "Sic3evendocu.findByFlgCumple", query = "SELECT s FROM Sic3evendocu s WHERE s.flgCumple = :flgCumple")
    , @NamedQuery(name = "Sic3evendocu.findByDesComelega", query = "SELECT s FROM Sic3evendocu s WHERE s.desComelega = :desComelega")
    , @NamedQuery(name = "Sic3evendocu.findByDesComefina", query = "SELECT s FROM Sic3evendocu s WHERE s.desComefina = :desComefina")
    , @NamedQuery(name = "Sic3evendocu.findByDesCometecn", query = "SELECT s FROM Sic3evendocu s WHERE s.desCometecn = :desCometecn")
    , @NamedQuery(name = "Sic3evendocu.findByDesCome", query = "SELECT s FROM Sic3evendocu s WHERE s.desCome = :desCome")
    , @NamedQuery(name = "Sic3evendocu.findByFlgCumplefina", query = "SELECT s FROM Sic3evendocu s WHERE s.flgCumplefina = :flgCumplefina")
    , @NamedQuery(name = "Sic3evendocu.findByFlgCumpletecn", query = "SELECT s FROM Sic3evendocu s WHERE s.flgCumpletecn = :flgCumpletecn")
    , @NamedQuery(name = "Sic3evendocu.findByFlgCumplelega", query = "SELECT s FROM Sic3evendocu s WHERE s.flgCumplelega = :flgCumplelega")
    , @NamedQuery(name = "Sic3evendocu.findByDesNotasfina", query = "SELECT s FROM Sic3evendocu s WHERE s.desNotasfina = :desNotasfina")
    , @NamedQuery(name = "Sic3evendocu.findByDesNotastecn", query = "SELECT s FROM Sic3evendocu s WHERE s.desNotastecn = :desNotastecn")
    , @NamedQuery(name = "Sic3evendocu.findByDesNotaslega", query = "SELECT s FROM Sic3evendocu s WHERE s.desNotaslega = :desNotaslega")})
public class Sic3evendocu implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected Sic3evendocuPK sic3evendocuPK;
    @Column(name = "FEC_HASTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecHasta;
    @Column(name = "DES_NOTAS")
    private String desNotas;
    @Column(name = "FLG_CUMPLE")
    private Integer flgCumple;
    @Column(name = "DES_COMELEGA")
    private String desComelega;
    @Column(name = "DES_COMEFINA")
    private String desComefina;
    @Column(name = "DES_COMETECN")
    private String desCometecn;
    @Column(name = "DES_COME")
    private String desCome;
    @Column(name = "FLG_CUMPLEFINA")
    private Integer flgCumplefina;
    @Column(name = "FLG_CUMPLETECN")
    private Integer flgCumpletecn;
    @Column(name = "FLG_CUMPLELEGA")
    private Integer flgCumplelega;
    @Column(name = "DES_NOTASFINA")
    private String desNotasfina;
    @Column(name = "DES_NOTASTECN")
    private String desNotastecn;
    @Column(name = "DES_NOTASLEGA")
    private String desNotaslega;
    @JoinColumn(name = "ID_DOCU", referencedColumnName = "ID_DOCU", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Sic1docu sic1docu;
    @JoinColumn(name = "ID_EVEN", referencedColumnName = "ID_EVEN", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Sic1even sic1even;
    @JoinColumn(name = "ID_TRELAEVEN", referencedColumnName = "ID_TRELA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Sic8trela sic8trela;
    
    /*Agregado*/
    private Integer idTrelaeven;

    
    
    public Sic3evendocu() {
    }

    public Sic3evendocu(Sic3evendocuPK sic3evendocuPK) {
        this.sic3evendocuPK = sic3evendocuPK;
    }

    public Sic3evendocu(Date fecDesde, BigInteger idEven, BigInteger idTrelaeven, BigInteger idDocu) {
        this.sic3evendocuPK = new Sic3evendocuPK(fecDesde, idEven, idTrelaeven, idDocu);
    }

    public Sic3evendocuPK getSic3evendocuPK() {
        return sic3evendocuPK;
    }

    public void setSic3evendocuPK(Sic3evendocuPK sic3evendocuPK) {
        this.sic3evendocuPK = sic3evendocuPK;
    }

    /**************************************/
    /********* PROPIEDADES ****************/
    /**************************************/
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

    public Integer getFlgCumple() {
        return flgCumple;
    }

    public void setFlgCumple(Integer flgCumple) {
        this.flgCumple = flgCumple;
    }

    public String getDesComelega() {
        return desComelega;
    }

    public void setDesComelega(String desComelega) {
        this.desComelega = desComelega;
    }

    public String getDesComefina() {
        return desComefina;
    }

    public void setDesComefina(String desComefina) {
        this.desComefina = desComefina;
    }

    public String getDesCometecn() {
        return desCometecn;
    }

    public void setDesCometecn(String desCometecn) {
        this.desCometecn = desCometecn;
    }

    public String getDesCome() {
        return desCome;
    }

    public void setDesCome(String desCome) {
        this.desCome = desCome;
    }

    public Integer getFlgCumplefina() {
        return flgCumplefina;
    }

    public void setFlgCumplefina(Integer flgCumplefina) {
        this.flgCumplefina = flgCumplefina;
    }

    public Integer getFlgCumpletecn() {
        return flgCumpletecn;
    }

    public void setFlgCumpletecn(Integer flgCumpletecn) {
        this.flgCumpletecn = flgCumpletecn;
    }

    public Integer getFlgCumplelega() {
        return flgCumplelega;
    }

    public void setFlgCumplelega(Integer flgCumplelega) {
        this.flgCumplelega = flgCumplelega;
    }

    public String getDesNotasfina() {
        return desNotasfina;
    }

    public void setDesNotasfina(String desNotasfina) {
        this.desNotasfina = desNotasfina;
    }

    public String getDesNotastecn() {
        return desNotastecn;
    }

    public void setDesNotastecn(String desNotastecn) {
        this.desNotastecn = desNotastecn;
    }

    public String getDesNotaslega() {
        return desNotaslega;
    }

    public void setDesNotaslega(String desNotaslega) {
        this.desNotaslega = desNotaslega;
    }

    public Sic1docu getSic1docu() {
        return sic1docu;
    }

    public void setSic1docu(Sic1docu sic1docu) {
        this.sic1docu = sic1docu;
    }

    public Sic1even getSic1even() {
        return sic1even;
    }

    public void setSic1even(Sic1even sic1even) {
        this.sic1even = sic1even;
    }

    public Sic8trela getSic8trela() {
        return sic8trela;
    }

    public void setSic8trela(Sic8trela sic8trela) {
        this.sic8trela = sic8trela;
    }

    public Integer getIdTrelaeven() {
        return idTrelaeven;
    }

    public void setIdTrelaeven(Integer idTrelaeven) {
        this.idTrelaeven = idTrelaeven;
    }

    
    
    
    
    
    /**************************************/
    /******* METODOS **********************/
    /**************************************/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sic3evendocuPK != null ? sic3evendocuPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sic3evendocu)) {
            return false;
        }
        Sic3evendocu other = (Sic3evendocu) object;
        if ((this.sic3evendocuPK == null && other.sic3evendocuPK != null) || (this.sic3evendocuPK != null && !this.sic3evendocuPK.equals(other.sic3evendocuPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.general.entity.Sic3evendocu[ sic3evendocuPK=" + sic3evendocuPK + " ]";
    }
    
}
