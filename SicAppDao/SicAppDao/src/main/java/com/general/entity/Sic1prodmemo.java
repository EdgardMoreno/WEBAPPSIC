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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author emoreno
 */
@Entity
@Table(name = "SIC1PRODMEMO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sic1prodmemo.findAll", query = "SELECT s FROM Sic1prodmemo s")
    , @NamedQuery(name = "Sic1prodmemo.findByIdProdmemo", query = "SELECT s FROM Sic1prodmemo s WHERE s.idProdmemo = :idProdmemo")
    , @NamedQuery(name = "Sic1prodmemo.findByFecFabr", query = "SELECT s FROM Sic1prodmemo s WHERE s.fecFabr = :fecFabr")
    , @NamedQuery(name = "Sic1prodmemo.findByIdClasememo", query = "SELECT s FROM Sic1prodmemo s WHERE s.idClasememo = :idClasememo")
    , @NamedQuery(name = "Sic1prodmemo.findByIdTipomemo", query = "SELECT s FROM Sic1prodmemo s WHERE s.idTipomemo = :idTipomemo")
    , @NamedQuery(name = "Sic1prodmemo.findByIdTipoalma", query = "SELECT s FROM Sic1prodmemo s WHERE s.idTipoalma = :idTipoalma")
    , @NamedQuery(name = "Sic1prodmemo.findByFecCertcump", query = "SELECT s FROM Sic1prodmemo s WHERE s.fecCertcump = :fecCertcump")
    , @NamedQuery(name = "Sic1prodmemo.findByCodIden", query = "SELECT s FROM Sic1prodmemo s WHERE s.codIden = :codIden")
    , @NamedQuery(name = "Sic1prodmemo.findByIdPaisfabr", query = "SELECT s FROM Sic1prodmemo s WHERE s.idPaisfabr = :idPaisfabr")
    , @NamedQuery(name = "Sic1prodmemo.findByFlgFormorig", query = "SELECT s FROM Sic1prodmemo s WHERE s.flgFormorig = :flgFormorig")
    , @NamedQuery(name = "Sic1prodmemo.findByFlgMultjueg", query = "SELECT s FROM Sic1prodmemo s WHERE s.flgMultjueg = :flgMultjueg")
    , @NamedQuery(name = "Sic1prodmemo.findByCodPosicion", query = "SELECT s FROM Sic1prodmemo s WHERE s.codPosicion = :codPosicion")
    , @NamedQuery(name = "Sic1prodmemo.findByNumCertcump", query = "SELECT s FROM Sic1prodmemo s WHERE s.numCertcump = :numCertcump")
    , @NamedQuery(name = "Sic1prodmemo.findByDesChipjuris", query = "SELECT s FROM Sic1prodmemo s WHERE s.desChipjuris = :desChipjuris")
    , @NamedQuery(name = "Sic1prodmemo.findByNumCapaalma", query = "SELECT s FROM Sic1prodmemo s WHERE s.numCapaalma = :numCapaalma")})
public class Sic1prodmemo implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PRODMEMO")
    private BigDecimal idProdmemo;
    @Column(name = "FEC_FABR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecFabr;
    @Column(name = "ID_CLASEMEMO")
    private BigInteger idClasememo;
    @Column(name = "ID_TIPOMEMO")
    private BigInteger idTipomemo;
    @Column(name = "ID_TIPOALMA")
    private BigInteger idTipoalma;
    @Column(name = "FEC_CERTCUMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecCertcump;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "COD_IDEN")
    private String codIden;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PAISFABR")
    private BigInteger idPaisfabr;
    @Column(name = "FLG_FORMORIG")
    private Short flgFormorig;
    @Column(name = "FLG_MULTJUEG")
    private Short flgMultjueg;
    @Size(max = 50)
    @Column(name = "COD_POSICION")
    private String codPosicion;
    @Size(max = 50)
    @Column(name = "NUM_CERTCUMP")
    private String numCertcump;
    @Size(max = 200)
    @Column(name = "DES_CHIPJURIS")
    private String desChipjuris;
    @Size(max = 50)
    @Column(name = "NUM_CAPAALMA")
    private String numCapaalma;

    public Sic1prodmemo() {
    }

    public Sic1prodmemo(BigDecimal idProdmemo) {
        this.idProdmemo = idProdmemo;
    }

    public Sic1prodmemo(BigDecimal idProdmemo, String codIden, BigInteger idPaisfabr) {
        this.idProdmemo = idProdmemo;
        this.codIden = codIden;
        this.idPaisfabr = idPaisfabr;
    }

    public BigDecimal getIdProdmemo() {
        return idProdmemo;
    }

    public void setIdProdmemo(BigDecimal idProdmemo) {
        this.idProdmemo = idProdmemo;
    }

    public Date getFecFabr() {
        return fecFabr;
    }

    public void setFecFabr(Date fecFabr) {
        this.fecFabr = fecFabr;
    }

    public BigInteger getIdClasememo() {
        return idClasememo;
    }

    public void setIdClasememo(BigInteger idClasememo) {
        this.idClasememo = idClasememo;
    }

    public BigInteger getIdTipomemo() {
        return idTipomemo;
    }

    public void setIdTipomemo(BigInteger idTipomemo) {
        this.idTipomemo = idTipomemo;
    }

    public BigInteger getIdTipoalma() {
        return idTipoalma;
    }

    public void setIdTipoalma(BigInteger idTipoalma) {
        this.idTipoalma = idTipoalma;
    }

    public Date getFecCertcump() {
        return fecCertcump;
    }

    public void setFecCertcump(Date fecCertcump) {
        this.fecCertcump = fecCertcump;
    }

    public String getCodIden() {
        return codIden;
    }

    public void setCodIden(String codIden) {
        this.codIden = codIden;
    }

    public BigInteger getIdPaisfabr() {
        return idPaisfabr;
    }

    public void setIdPaisfabr(BigInteger idPaisfabr) {
        this.idPaisfabr = idPaisfabr;
    }

    public Short getFlgFormorig() {
        return flgFormorig;
    }

    public void setFlgFormorig(Short flgFormorig) {
        this.flgFormorig = flgFormorig;
    }

    public Short getFlgMultjueg() {
        return flgMultjueg;
    }

    public void setFlgMultjueg(Short flgMultjueg) {
        this.flgMultjueg = flgMultjueg;
    }

    public String getCodPosicion() {
        return codPosicion;
    }

    public void setCodPosicion(String codPosicion) {
        this.codPosicion = codPosicion;
    }

    public String getNumCertcump() {
        return numCertcump;
    }

    public void setNumCertcump(String numCertcump) {
        this.numCertcump = numCertcump;
    }

    public String getDesChipjuris() {
        return desChipjuris;
    }

    public void setDesChipjuris(String desChipjuris) {
        this.desChipjuris = desChipjuris;
    }

    public String getNumCapaalma() {
        return numCapaalma;
    }

    public void setNumCapaalma(String numCapaalma) {
        this.numCapaalma = numCapaalma;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProdmemo != null ? idProdmemo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sic1prodmemo)) {
            return false;
        }
        Sic1prodmemo other = (Sic1prodmemo) object;
        if ((this.idProdmemo == null && other.idProdmemo != null) || (this.idProdmemo != null && !this.idProdmemo.equals(other.idProdmemo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.general.entity.Sic1prodmemo[ idProdmemo=" + idProdmemo + " ]";
    }
    
}
