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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "SIC1DOCU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sic1docu.findAll", query = "SELECT s FROM Sic1docu s")
    , @NamedQuery(name = "Sic1docu.findByDesTitulo", query = "SELECT s FROM Sic1docu s WHERE s.desTitulo = :desTitulo")
    , @NamedQuery(name = "Sic1docu.findByDesNotas", query = "SELECT s FROM Sic1docu s WHERE s.desNotas = :desNotas")
    , @NamedQuery(name = "Sic1docu.findByFecCreacion", query = "SELECT s FROM Sic1docu s WHERE s.fecCreacion = :fecCreacion")
    , @NamedQuery(name = "Sic1docu.findByDesDocu", query = "SELECT s FROM Sic1docu s WHERE s.desDocu = :desDocu")
    , @NamedQuery(name = "Sic1docu.findByIdStipodocu", query = "SELECT s FROM Sic1docu s WHERE s.idStipodocu = :idStipodocu")
    , @NamedQuery(name = "Sic1docu.findByFecDesde", query = "SELECT s FROM Sic1docu s WHERE s.fecDesde = :fecDesde")
    , @NamedQuery(name = "Sic1docu.findByFecHasta", query = "SELECT s FROM Sic1docu s WHERE s.fecHasta = :fecHasta")
    , @NamedQuery(name = "Sic1docu.findByIdDocu", query = "SELECT s FROM Sic1docu s WHERE s.idDocu = :idDocu")
    , @NamedQuery(name = "Sic1docu.findByIdTareaobsreq", query = "SELECT s FROM Sic1docu s WHERE s.idTareaobsreq = :idTareaobsreq")})

public class Sic1docu implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sic1docu")
    private Collection<Sic3evendocu> sic3evendocuCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sic1docu")
    private Collection<Sic3proddocu> sic3proddocuCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sic1docu")
    private Collection<Sic3proditemdocu> sic3proditemdocuCollection;

    private static final long serialVersionUID = 1L;
    @Column(name = "DES_TITULO")
    private String desTitulo;
    @Column(name = "DES_NOTAS")
    private String desNotas;
    @Column(name = "FEC_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecCreacion;
    @Column(name = "DES_DOCU")
    private String desDocu;
    @Column(name = "ID_STIPODOCU")
    private Integer idStipodocu;
    @Column(name = "FEC_DESDE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecDesde;
    @Column(name = "FEC_HASTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecHasta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_DOCU")
    private BigDecimal idDocu;
    @Column(name = "ID_TAREAOBSREQ")
    private BigInteger idTareaobsreq;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sic1docu")
    private List<Sic1docubina> sic1docubinaList;
    
    //@JoinColumn(name = "ID_TROLPERS", referencedColumnName = "ID_GENERAL")
    //@ManyToOne
    private Integer idTrolpers;
    
    @JoinColumn(name = "ID_PERS", referencedColumnName = "ID_PERS")
    @ManyToOne
    private Sic1pers idPers;
    
    private Sic3docuesta sic3docuesta;
    
    /**************************************************/
    /*Agregado*/
    private Sic1idendocu sic1idendocu;
    private String codIden;
    private Sic1stipodocu sic1stipodocu;
    private Sic1docubina sic1docubina;
    private Integer idEven;
    private Integer numOrden;

    
    /*************************/
    /****** CONSTRUCTOR ******/
    /*************************/
    public Sic1docu() {
    }

    public Sic1docu(BigDecimal idDocu) {
        this.idDocu = idDocu;
    }

    /*************************/
    /****** PROPIEDADES ******/
    /*************************/
    public String getDesTitulo() {
        return desTitulo;
    }

    public void setDesTitulo(String desTitulo) {
        this.desTitulo = desTitulo;
    }

    public String getDesNotas() {
        return desNotas;
    }

    public void setDesNotas(String desNotas) {
        this.desNotas = desNotas;
    }

    public Date getFecCreacion() {
        return fecCreacion;
    }

    public void setFecCreacion(Date fecCreacion) {
        this.fecCreacion = fecCreacion;
    }

    public String getDesDocu() {
        return desDocu;
    }

    public void setDesDocu(String desDocu) {
        this.desDocu = desDocu;
    }

    public Integer getIdStipodocu() {
        return idStipodocu;
    }

    public void setIdStipodocu(Integer idStipodocu) {
        this.idStipodocu = idStipodocu;
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

    public BigDecimal getIdDocu() {
        return idDocu;
    }

    public void setIdDocu(BigDecimal idDocu) {
        this.idDocu = idDocu;
    }

    public BigInteger getIdTareaobsreq() {
        return idTareaobsreq;
    }

    public void setIdTareaobsreq(BigInteger idTareaobsreq) {
        this.idTareaobsreq = idTareaobsreq;
    }

    @XmlTransient
    public List<Sic1docubina> getSic1docubinaList() {
        return sic1docubinaList;
    }

    public void setSic1docubinaList(List<Sic1docubina> sic1docubinaList) {
        this.sic1docubinaList = sic1docubinaList;
    }

//    public Sic1general getIdTrolpers() {
//        return idTrolpers;
//    }
//
//    public void setIdTrolpers(Sic1general idTrolpers) {
//        this.idTrolpers = idTrolpers;
//    }

    public Integer getIdTrolpers() {
        return idTrolpers;
    }

    public void setIdTrolpers(Integer idTrolpers) {
        this.idTrolpers = idTrolpers;
    }
    
    
    

    public Sic1pers getIdPers() {
        return idPers;
    }

    public void setIdPers(Sic1pers idPers) {
        this.idPers = idPers;
    }

    public Sic1idendocu getSic1idendocu() {
        return sic1idendocu;
    }

    public void setSic1idendocu(Sic1idendocu sic1idendocu) {
        this.sic1idendocu = sic1idendocu;
    }   

    public Sic1docubina getSic1docubina() {
        return sic1docubina;
    }

    public void setSic1docubina(Sic1docubina sic1docubina) {
        this.sic1docubina = sic1docubina;
    }

    public String getCodIden() {
        return codIden;
    }

    public void setCodIden(String codIden) {
        this.codIden = codIden;
    }

    public Integer getIdEven() {
        return idEven;
    }

    public void setIdEven(Integer idEven) {
        this.idEven = idEven;
    }

    

    public Sic3docuesta getSic3docuesta() {
        return sic3docuesta;
    }

    public void setSic3docuesta(Sic3docuesta sic3docuesta) {
        this.sic3docuesta = sic3docuesta;
    }

    public Integer getNumOrden() {
        return numOrden;
    }

    public void setNumOrden(Integer numOrden) {
        this.numOrden = numOrden;
    }

    public Sic1stipodocu getSic1stipodocu() {
        return sic1stipodocu;
    }

    public void setSic1stipodocu(Sic1stipodocu sic1stipodocu) {
        this.sic1stipodocu = sic1stipodocu;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDocu != null ? idDocu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sic1docu)) {
            return false;
        }
        Sic1docu other = (Sic1docu) object;
        if ((this.idDocu == null && other.idDocu != null) || (this.idDocu != null && !this.idDocu.equals(other.idDocu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.general.sicappdao.Sic1docu[ idDocu=" + idDocu + " ]";
    }

    @XmlTransient
    public Collection<Sic3evendocu> getSic3evendocuCollection() {
        return sic3evendocuCollection;
    }

    public void setSic3evendocuCollection(Collection<Sic3evendocu> sic3evendocuCollection) {
        this.sic3evendocuCollection = sic3evendocuCollection;
    }

    @XmlTransient
    public Collection<Sic3proddocu> getSic3proddocuCollection() {
        return sic3proddocuCollection;
    }

    public void setSic3proddocuCollection(Collection<Sic3proddocu> sic3proddocuCollection) {
        this.sic3proddocuCollection = sic3proddocuCollection;
    }

    @XmlTransient
    public Collection<Sic3proditemdocu> getSic3proditemdocuCollection() {
        return sic3proditemdocuCollection;
    }

    public void setSic3proditemdocuCollection(Collection<Sic3proditemdocu> sic3proditemdocuCollection) {
        this.sic3proditemdocuCollection = sic3proditemdocuCollection;
    }
    
}
