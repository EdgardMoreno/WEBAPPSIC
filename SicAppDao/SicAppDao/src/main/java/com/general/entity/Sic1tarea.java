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
@Table(name = "SIC1TAREA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sic1tarea.findAll", query = "SELECT s FROM Sic1tarea s")
    , @NamedQuery(name = "Sic1tarea.findByIdTarea", query = "SELECT s FROM Sic1tarea s WHERE s.idTarea = :idTarea")
    , @NamedQuery(name = "Sic1tarea.findByDesTarea", query = "SELECT s FROM Sic1tarea s WHERE s.desTarea = :desTarea")
    , @NamedQuery(name = "Sic1tarea.findByDesNotas", query = "SELECT s FROM Sic1tarea s WHERE s.desNotas = :desNotas")
    , @NamedQuery(name = "Sic1tarea.findByNumDias", query = "SELECT s FROM Sic1tarea s WHERE s.numDias = :numDias")
    , @NamedQuery(name = "Sic1tarea.findByNumDiasSoli", query = "SELECT s FROM Sic1tarea s WHERE s.numDiasSoli = :numDiasSoli")
    , @NamedQuery(name = "Sic1tarea.findByFecVencinic", query = "SELECT s FROM Sic1tarea s WHERE s.fecVencinic = :fecVencinic")
    , @NamedQuery(name = "Sic1tarea.findByFecVencfina", query = "SELECT s FROM Sic1tarea s WHERE s.fecVencfina = :fecVencfina")
    , @NamedQuery(name = "Sic1tarea.findByIdTareadesde", query = "SELECT s FROM Sic1tarea s WHERE s.idTareadesde = :idTareadesde")
    , @NamedQuery(name = "Sic1tarea.findByFlgVisto", query = "SELECT s FROM Sic1tarea s WHERE s.flgVisto = :flgVisto")
    , @NamedQuery(name = "Sic1tarea.findByFlgEstado", query = "SELECT s FROM Sic1tarea s WHERE s.flgEstado = :flgEstado")
    , @NamedQuery(name = "Sic1tarea.findByNumDiasVal", query = "SELECT s FROM Sic1tarea s WHERE s.numDiasVal = :numDiasVal")
    , @NamedQuery(name = "Sic1tarea.findByFecHasta", query = "SELECT s FROM Sic1tarea s WHERE s.fecHasta = :fecHasta")
    , @NamedQuery(name = "Sic1tarea.findByFecDesde", query = "SELECT s FROM Sic1tarea s WHERE s.fecDesde = :fecDesde")})
public class Sic1tarea implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_TAREA")
    private BigDecimal idTarea;
    @Column(name = "DES_TAREA")
    private String desTarea;
    @Column(name = "DES_NOTAS")
    private String desNotas;
    @Column(name = "NUM_DIAS")
    private BigInteger numDias;
    @Column(name = "NUM_DIAS_SOLI")
    private BigInteger numDiasSoli;
    @Column(name = "FEC_VENCINIC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecVencinic;
    @Column(name = "FEC_VENCFINA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecVencfina;
    @Column(name = "ID_TAREADESDE")
    private BigInteger idTareadesde;
    @Column(name = "FLG_VISTO")
    private BigInteger flgVisto;
    @Column(name = "FLG_ESTADO")
    private Short flgEstado;
    @Column(name = "NUM_DIAS_VAL")
    private Short numDiasVal;
    @Column(name = "FEC_HASTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecHasta;
    @Column(name = "FEC_DESDE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecDesde;
    @OneToMany(mappedBy = "idTarea")
    private Collection<Sic1even> sic1evenCollection;

    public Sic1tarea() {
    }

    public Sic1tarea(BigDecimal idTarea) {
        this.idTarea = idTarea;
    }

    public BigDecimal getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(BigDecimal idTarea) {
        this.idTarea = idTarea;
    }

    public String getDesTarea() {
        return desTarea;
    }

    public void setDesTarea(String desTarea) {
        this.desTarea = desTarea;
    }

    public String getDesNotas() {
        return desNotas;
    }

    public void setDesNotas(String desNotas) {
        this.desNotas = desNotas;
    }

    public BigInteger getNumDias() {
        return numDias;
    }

    public void setNumDias(BigInteger numDias) {
        this.numDias = numDias;
    }

    public BigInteger getNumDiasSoli() {
        return numDiasSoli;
    }

    public void setNumDiasSoli(BigInteger numDiasSoli) {
        this.numDiasSoli = numDiasSoli;
    }

    public Date getFecVencinic() {
        return fecVencinic;
    }

    public void setFecVencinic(Date fecVencinic) {
        this.fecVencinic = fecVencinic;
    }

    public Date getFecVencfina() {
        return fecVencfina;
    }

    public void setFecVencfina(Date fecVencfina) {
        this.fecVencfina = fecVencfina;
    }

    public BigInteger getIdTareadesde() {
        return idTareadesde;
    }

    public void setIdTareadesde(BigInteger idTareadesde) {
        this.idTareadesde = idTareadesde;
    }

    public BigInteger getFlgVisto() {
        return flgVisto;
    }

    public void setFlgVisto(BigInteger flgVisto) {
        this.flgVisto = flgVisto;
    }

    public Short getFlgEstado() {
        return flgEstado;
    }

    public void setFlgEstado(Short flgEstado) {
        this.flgEstado = flgEstado;
    }

    public Short getNumDiasVal() {
        return numDiasVal;
    }

    public void setNumDiasVal(Short numDiasVal) {
        this.numDiasVal = numDiasVal;
    }

    public Date getFecHasta() {
        return fecHasta;
    }

    public void setFecHasta(Date fecHasta) {
        this.fecHasta = fecHasta;
    }

    public Date getFecDesde() {
        return fecDesde;
    }

    public void setFecDesde(Date fecDesde) {
        this.fecDesde = fecDesde;
    }

    @XmlTransient
    public Collection<Sic1even> getSic1evenCollection() {
        return sic1evenCollection;
    }

    public void setSic1evenCollection(Collection<Sic1even> sic1evenCollection) {
        this.sic1evenCollection = sic1evenCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTarea != null ? idTarea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sic1tarea)) {
            return false;
        }
        Sic1tarea other = (Sic1tarea) object;
        if ((this.idTarea == null && other.idTarea != null) || (this.idTarea != null && !this.idTarea.equals(other.idTarea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.general.entity.Sic1tarea[ idTarea=" + idTarea + " ]";
    }
    
}
