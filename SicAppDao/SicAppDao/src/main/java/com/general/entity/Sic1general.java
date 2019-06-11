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
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "SIC1GENERAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sic1general.findAll", query = "SELECT s FROM Sic1general s")
    , @NamedQuery(name = "Sic1general.findByIdGeneral", query = "SELECT s FROM Sic1general s WHERE s.idGeneral = :idGeneral")
    , @NamedQuery(name = "Sic1general.findByDesGeneral", query = "SELECT s FROM Sic1general s WHERE s.desGeneral = :desGeneral")
    , @NamedQuery(name = "Sic1general.findByCodValortipogeneral", query = "SELECT s FROM Sic1general s WHERE s.codValortipogeneral = :codValortipogeneral")
    , @NamedQuery(name = "Sic1general.findByCodValorgeneral", query = "SELECT s FROM Sic1general s WHERE s.codValorgeneral = :codValorgeneral")
    , @NamedQuery(name = "Sic1general.findByIdGeneralrel", query = "SELECT s FROM Sic1general s WHERE s.idGeneralrel = :idGeneralrel")
    , @NamedQuery(name = "Sic1general.findByCodValordefecto", query = "SELECT s FROM Sic1general s WHERE s.codValordefecto = :codValordefecto")
    , @NamedQuery(name = "Sic1general.findByCodValortipoentidad", query = "SELECT s FROM Sic1general s WHERE s.codValortipoentidad = :codValortipoentidad")
    , @NamedQuery(name = "Sic1general.findByIdGeneralrelsec", query = "SELECT s FROM Sic1general s WHERE s.idGeneralrelsec = :idGeneralrelsec")
    , @NamedQuery(name = "Sic1general.findByNumValor", query = "SELECT s FROM Sic1general s WHERE s.numValor = :numValor")
    , @NamedQuery(name = "Sic1general.findByDesValor", query = "SELECT s FROM Sic1general s WHERE s.desValor = :desValor")
    , @NamedQuery(name = "Sic1general.findByFecValor", query = "SELECT s FROM Sic1general s WHERE s.fecValor = :fecValor")
    , @NamedQuery(name = "Sic1general.findByDesValor1", query = "SELECT s FROM Sic1general s WHERE s.desValor1 = :desValor1")})
public class Sic1general implements Serializable {

    @OneToMany(mappedBy = "idModocrea")
    private Collection<Sic1even> sic1evenCollection;
    @OneToMany(mappedBy = "idStipoeven")
    private Collection<Sic1even> sic1evenCollection1;
    @OneToMany(mappedBy = "idMedicomu")
    private Collection<Sic1even> sic1evenCollection2;
    @OneToMany(mappedBy = "idMotieven")
    private Collection<Sic1even> sic1evenCollection3;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_GENERAL")
    private BigDecimal idGeneral;
    @Column(name = "DES_GENERAL")
    private String desGeneral;
    @Column(name = "COD_VALORTIPOGENERAL")
    private String codValortipogeneral;
    @Column(name = "COD_VALORGENERAL")
    private String codValorgeneral;
    @Column(name = "ID_GENERALREL")
    private BigInteger idGeneralrel;
    @Column(name = "COD_VALORDEFECTO")
    private BigInteger codValordefecto;
    @Column(name = "COD_VALORTIPOENTIDAD")
    private String codValortipoentidad;
    @Column(name = "ID_GENERALRELSEC")
    private BigInteger idGeneralrelsec;
    @Column(name = "NUM_VALOR")
    private BigInteger numValor;
    @Column(name = "DES_VALOR")
    private String desValor;
    @Column(name = "FEC_VALOR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecValor;
    @Column(name = "DES_VALOR1")
    private String desValor1;
    @OneToMany(mappedBy = "idTrolpers")
    private List<Sic1docu> sic1docuList;

    public Sic1general() {
    }

    public Sic1general(BigDecimal idGeneral) {
        this.idGeneral = idGeneral;
    }

    public BigDecimal getIdGeneral() {
        return idGeneral;
    }

    public void setIdGeneral(BigDecimal idGeneral) {
        this.idGeneral = idGeneral;
    }

    public String getDesGeneral() {
        return desGeneral;
    }

    public void setDesGeneral(String desGeneral) {
        this.desGeneral = desGeneral;
    }

    public String getCodValortipogeneral() {
        return codValortipogeneral;
    }

    public void setCodValortipogeneral(String codValortipogeneral) {
        this.codValortipogeneral = codValortipogeneral;
    }

    public String getCodValorgeneral() {
        return codValorgeneral;
    }

    public void setCodValorgeneral(String codValorgeneral) {
        this.codValorgeneral = codValorgeneral;
    }

    public BigInteger getIdGeneralrel() {
        return idGeneralrel;
    }

    public void setIdGeneralrel(BigInteger idGeneralrel) {
        this.idGeneralrel = idGeneralrel;
    }

    public BigInteger getCodValordefecto() {
        return codValordefecto;
    }

    public void setCodValordefecto(BigInteger codValordefecto) {
        this.codValordefecto = codValordefecto;
    }

    public String getCodValortipoentidad() {
        return codValortipoentidad;
    }

    public void setCodValortipoentidad(String codValortipoentidad) {
        this.codValortipoentidad = codValortipoentidad;
    }

    public BigInteger getIdGeneralrelsec() {
        return idGeneralrelsec;
    }

    public void setIdGeneralrelsec(BigInteger idGeneralrelsec) {
        this.idGeneralrelsec = idGeneralrelsec;
    }

    public BigInteger getNumValor() {
        return numValor;
    }

    public void setNumValor(BigInteger numValor) {
        this.numValor = numValor;
    }

    public String getDesValor() {
        return desValor;
    }

    public void setDesValor(String desValor) {
        this.desValor = desValor;
    }

    public Date getFecValor() {
        return fecValor;
    }

    public void setFecValor(Date fecValor) {
        this.fecValor = fecValor;
    }

    public String getDesValor1() {
        return desValor1;
    }

    public void setDesValor1(String desValor1) {
        this.desValor1 = desValor1;
    }

    @XmlTransient
    public List<Sic1docu> getSic1docuList() {
        return sic1docuList;
    }

    public void setSic1docuList(List<Sic1docu> sic1docuList) {
        this.sic1docuList = sic1docuList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGeneral != null ? idGeneral.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sic1general)) {
            return false;
        }
        Sic1general other = (Sic1general) object;
        if ((this.idGeneral == null && other.idGeneral != null) || (this.idGeneral != null && !this.idGeneral.equals(other.idGeneral))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.general.sicappdao.Sic1general[ idGeneral=" + idGeneral + " ]";
    }

    @XmlTransient
    public Collection<Sic1even> getSic1evenCollection() {
        return sic1evenCollection;
    }

    public void setSic1evenCollection(Collection<Sic1even> sic1evenCollection) {
        this.sic1evenCollection = sic1evenCollection;
    }

    @XmlTransient
    public Collection<Sic1even> getSic1evenCollection1() {
        return sic1evenCollection1;
    }

    public void setSic1evenCollection1(Collection<Sic1even> sic1evenCollection1) {
        this.sic1evenCollection1 = sic1evenCollection1;
    }

    @XmlTransient
    public Collection<Sic1even> getSic1evenCollection2() {
        return sic1evenCollection2;
    }

    public void setSic1evenCollection2(Collection<Sic1even> sic1evenCollection2) {
        this.sic1evenCollection2 = sic1evenCollection2;
    }

    @XmlTransient
    public Collection<Sic1even> getSic1evenCollection3() {
        return sic1evenCollection3;
    }

    public void setSic1evenCollection3(Collection<Sic1even> sic1evenCollection3) {
        this.sic1evenCollection3 = sic1evenCollection3;
    }
    
}
