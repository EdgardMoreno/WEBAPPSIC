/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author emoreno
 */
@Entity
@Table(name = "SIC1PROD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sic1prod.findAll", query = "SELECT s FROM Sic1prod s")
    , @NamedQuery(name = "Sic1prod.findByDesProd", query = "SELECT s FROM Sic1prod s WHERE s.desProd = :desProd")
    , @NamedQuery(name = "Sic1prod.findByCodProd", query = "SELECT s FROM Sic1prod s WHERE s.codProd = :codProd")
    , @NamedQuery(name = "Sic1prod.findByDesProdcome", query = "SELECT s FROM Sic1prod s WHERE s.desProdcome = :desProdcome")
    , @NamedQuery(name = "Sic1prod.findByIdProd", query = "SELECT s FROM Sic1prod s WHERE s.idProd = :idProd")
    , @NamedQuery(name = "Sic1prod.findByIdStipoprod", query = "SELECT s FROM Sic1prod s WHERE s.idStipoprod = :idStipoprod")
    , @NamedQuery(name = "Sic1prod.findByCodIden", query = "SELECT s FROM Sic1prod s WHERE s.codIden = :codIden")
    , @NamedQuery(name = "Sic1prod.findByFecDesde", query = "SELECT s FROM Sic1prod s WHERE s.fecDesde = :fecDesde")
    , @NamedQuery(name = "Sic1prod.findByFecHasta", query = "SELECT s FROM Sic1prod s WHERE s.fecHasta = :fecHasta")
    , @NamedQuery(name = "Sic1prod.findByIdTipomaq", query = "SELECT s FROM Sic1prod s WHERE s.idTipomaq = :idTipomaq")})
public class Sic1prod implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "DES_PROD")
    private String desProd;
    @Basic(optional = false)
    @Column(name = "COD_PROD")
    private String codProd;
    @Column(name = "DES_PRODCOME")
    private String desProdcome;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PROD")
    private BigDecimal idProd;
    @Column(name = "ID_STIPOPROD")
    private BigInteger idStipoprod;
    @Column(name = "COD_IDEN")
    private String codIden;
    @Column(name = "FEC_DESDE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecDesde;
    @Column(name = "FEC_HASTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecHasta;
    @Column(name = "ID_TIPOMAQ")
    private BigInteger idTipomaq;
    @OneToMany(mappedBy = "idProd")
    private Collection<Sic1proditem> sic1proditemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sic1prod")
    private Collection<Sic3proddocu> sic3proddocuCollection;
    
    /*Agregado*/
    private Sic1codiauto sic1codiauto;
    private Sic1pers sic1persfab;
    private Integer numCantMemorias;
    private Integer numCantMesas;
    
    public Sic1prod() {
    }

    public Sic1prod(BigDecimal idProd) {
        this.idProd = idProd;
    }

    public Sic1prod(BigDecimal idProd, String codProd) {
        this.idProd = idProd;
        this.codProd = codProd;
    }

    public String getDesProd() {
        return desProd;
    }

    public void setDesProd(String desProd) {
        this.desProd = desProd;
    }

    public String getCodProd() {
        return codProd;
    }

    public void setCodProd(String codProd) {
        this.codProd = codProd;
    }

    public String getDesProdcome() {
        return desProdcome;
    }

    public void setDesProdcome(String desProdcome) {
        this.desProdcome = desProdcome;
    }

    public BigDecimal getIdProd() {
        return idProd;
    }

    public void setIdProd(BigDecimal idProd) {
        this.idProd = idProd;
    }

    public BigInteger getIdStipoprod() {
        return idStipoprod;
    }

    public void setIdStipoprod(BigInteger idStipoprod) {
        this.idStipoprod = idStipoprod;
    }

    public String getCodIden() {
        return codIden;
    }

    public void setCodIden(String codIden) {
        this.codIden = codIden;
    }

    public Date getFecDesde() {
        return fecDesde;
    }

    public void setFecDesde(Date fecDesde) {
        this.fecDesde = fecDesde;
    }

    public Date getFecHasta() {
        return fecHasta;
    }

    public void setFecHasta(Date fecHasta) {
        this.fecHasta = fecHasta;
    }

    public BigInteger getIdTipomaq() {
        return idTipomaq;
    }

    public void setIdTipomaq(BigInteger idTipomaq) {
        this.idTipomaq = idTipomaq;
    }

    public Sic1codiauto getSic1codiauto() {
        return sic1codiauto;
    }

    public void setSic1codiauto(Sic1codiauto sic1codiauto) {
        this.sic1codiauto = sic1codiauto;
    }

    public Sic1pers getSic1persfab() {
        return sic1persfab;
    }

    public void setSic1persfab(Sic1pers sic1persfab) {
        this.sic1persfab = sic1persfab;
    }       

    public Integer getNumCantMemorias() {
        return numCantMemorias;
    }

    public void setNumCantMemorias(Integer numCantMemorias) {
        this.numCantMemorias = numCantMemorias;
    }

    public Integer getNumCantMesas() {
        return numCantMesas;
    }

    public void setNumCantMesas(Integer numCantMesas) {
        this.numCantMesas = numCantMesas;
    }

   
    

    @XmlTransient
    public Collection<Sic1proditem> getSic1proditemCollection() {
        return sic1proditemCollection;
    }

    public void setSic1proditemCollection(Collection<Sic1proditem> sic1proditemCollection) {
        this.sic1proditemCollection = sic1proditemCollection;
    }

    @XmlTransient
    public Collection<Sic3proddocu> getSic3proddocuCollection() {
        return sic3proddocuCollection;
    }

    public void setSic3proddocuCollection(Collection<Sic3proddocu> sic3proddocuCollection) {
        this.sic3proddocuCollection = sic3proddocuCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProd != null ? idProd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sic1prod)) {
            return false;
        }
        Sic1prod other = (Sic1prod) object;
        if ((this.idProd == null && other.idProd != null) || (this.idProd != null && !this.idProd.equals(other.idProd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.general.entity.Sic1prod[ idProd=" + idProd + " ]";
    }
    
}
