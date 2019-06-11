/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author emoreno
 */
@Entity
@Table(name = "SIC1STIPOCODIAUTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sic1stipocodiauto.findAll", query = "SELECT s FROM Sic1stipocodiauto s")
    , @NamedQuery(name = "Sic1stipocodiauto.findByIdStipocodiauto", query = "SELECT s FROM Sic1stipocodiauto s WHERE s.idStipocodiauto = :idStipocodiauto")
    , @NamedQuery(name = "Sic1stipocodiauto.findByDesStipocodiauto", query = "SELECT s FROM Sic1stipocodiauto s WHERE s.desStipocodiauto = :desStipocodiauto")
    , @NamedQuery(name = "Sic1stipocodiauto.findByCodStipocodiauto", query = "SELECT s FROM Sic1stipocodiauto s WHERE s.codStipocodiauto = :codStipocodiauto")
    , @NamedQuery(name = "Sic1stipocodiauto.findByDesPatroncodiauto", query = "SELECT s FROM Sic1stipocodiauto s WHERE s.desPatroncodiauto = :desPatroncodiauto")
    , @NamedQuery(name = "Sic1stipocodiauto.findByIdTipoentidad", query = "SELECT s FROM Sic1stipocodiauto s WHERE s.idTipoentidad = :idTipoentidad")
    , @NamedQuery(name = "Sic1stipocodiauto.findByIdTrolpers", query = "SELECT s FROM Sic1stipocodiauto s WHERE s.idTrolpers = :idTrolpers")
    , @NamedQuery(name = "Sic1stipocodiauto.findByDesTipocodiauto", query = "SELECT s FROM Sic1stipocodiauto s WHERE s.desTipocodiauto = :desTipocodiauto")
    , @NamedQuery(name = "Sic1stipocodiauto.findByCodTipocodiauto", query = "SELECT s FROM Sic1stipocodiauto s WHERE s.codTipocodiauto = :codTipocodiauto")
    , @NamedQuery(name = "Sic1stipocodiauto.findByFlgAutosala", query = "SELECT s FROM Sic1stipocodiauto s WHERE s.flgAutosala = :flgAutosala")})
public class Sic1stipocodiauto implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_STIPOCODIAUTO")
    private BigDecimal idStipocodiauto;
    @Size(max = 500)
    @Column(name = "DES_STIPOCODIAUTO")
    private String desStipocodiauto;
    @Size(max = 50)
    @Column(name = "COD_STIPOCODIAUTO")
    private String codStipocodiauto;
    @Size(max = 250)
    @Column(name = "DES_PATRONCODIAUTO")
    private String desPatroncodiauto;
    @Column(name = "ID_TIPOENTIDAD")
    private BigInteger idTipoentidad;
    @Column(name = "ID_TROLPERS")
    private BigInteger idTrolpers;
    @Size(max = 100)
    @Column(name = "DES_TIPOCODIAUTO")
    private String desTipocodiauto;
    @Size(max = 100)
    @Column(name = "COD_TIPOCODIAUTO")
    private String codTipocodiauto;
    @Column(name = "FLG_AUTOSALA")
    private Short flgAutosala;

    public Sic1stipocodiauto() {
    }

    public Sic1stipocodiauto(BigDecimal idStipocodiauto) {
        this.idStipocodiauto = idStipocodiauto;
    }

    public BigDecimal getIdStipocodiauto() {
        return idStipocodiauto;
    }

    public void setIdStipocodiauto(BigDecimal idStipocodiauto) {
        this.idStipocodiauto = idStipocodiauto;
    }

    public String getDesStipocodiauto() {
        return desStipocodiauto;
    }

    public void setDesStipocodiauto(String desStipocodiauto) {
        this.desStipocodiauto = desStipocodiauto;
    }

    public String getCodStipocodiauto() {
        return codStipocodiauto;
    }

    public void setCodStipocodiauto(String codStipocodiauto) {
        this.codStipocodiauto = codStipocodiauto;
    }

    public String getDesPatroncodiauto() {
        return desPatroncodiauto;
    }

    public void setDesPatroncodiauto(String desPatroncodiauto) {
        this.desPatroncodiauto = desPatroncodiauto;
    }

    public BigInteger getIdTipoentidad() {
        return idTipoentidad;
    }

    public void setIdTipoentidad(BigInteger idTipoentidad) {
        this.idTipoentidad = idTipoentidad;
    }

    public BigInteger getIdTrolpers() {
        return idTrolpers;
    }

    public void setIdTrolpers(BigInteger idTrolpers) {
        this.idTrolpers = idTrolpers;
    }

    public String getDesTipocodiauto() {
        return desTipocodiauto;
    }

    public void setDesTipocodiauto(String desTipocodiauto) {
        this.desTipocodiauto = desTipocodiauto;
    }

    public String getCodTipocodiauto() {
        return codTipocodiauto;
    }

    public void setCodTipocodiauto(String codTipocodiauto) {
        this.codTipocodiauto = codTipocodiauto;
    }

    public Short getFlgAutosala() {
        return flgAutosala;
    }

    public void setFlgAutosala(Short flgAutosala) {
        this.flgAutosala = flgAutosala;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStipocodiauto != null ? idStipocodiauto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sic1stipocodiauto)) {
            return false;
        }
        Sic1stipocodiauto other = (Sic1stipocodiauto) object;
        if ((this.idStipocodiauto == null && other.idStipocodiauto != null) || (this.idStipocodiauto != null && !this.idStipocodiauto.equals(other.idStipocodiauto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.general.entity.Sic1stipocodiauto[ idStipocodiauto=" + idStipocodiauto + " ]";
    }
    
}
