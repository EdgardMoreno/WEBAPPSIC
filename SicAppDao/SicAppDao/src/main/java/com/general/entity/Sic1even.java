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
@Table(name = "SIC1EVEN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sic1even.findAll", query = "SELECT s FROM Sic1even s")
    , @NamedQuery(name = "Sic1even.findByIdEven", query = "SELECT s FROM Sic1even s WHERE s.idEven = :idEven")
    , @NamedQuery(name = "Sic1even.findByDesEven", query = "SELECT s FROM Sic1even s WHERE s.desEven = :desEven")
    , @NamedQuery(name = "Sic1even.findByFecCreacion", query = "SELECT s FROM Sic1even s WHERE s.fecCreacion = :fecCreacion")
    , @NamedQuery(name = "Sic1even.findByFecDesde", query = "SELECT s FROM Sic1even s WHERE s.fecDesde = :fecDesde")
    , @NamedQuery(name = "Sic1even.findByFecHasta", query = "SELECT s FROM Sic1even s WHERE s.fecHasta = :fecHasta")
    , @NamedQuery(name = "Sic1even.findByDesNotas", query = "SELECT s FROM Sic1even s WHERE s.desNotas = :desNotas")
    , @NamedQuery(name = "Sic1even.findByNumInstbpm", query = "SELECT s FROM Sic1even s WHERE s.numInstbpm = :numInstbpm")
    , @NamedQuery(name = "Sic1even.findByDesNotasminc", query = "SELECT s FROM Sic1even s WHERE s.desNotasminc = :desNotasminc")
    , @NamedQuery(name = "Sic1even.findByDesNotasadmi", query = "SELECT s FROM Sic1even s WHERE s.desNotasadmi = :desNotasadmi")
    , @NamedQuery(name = "Sic1even.findByDesNotasempl", query = "SELECT s FROM Sic1even s WHERE s.desNotasempl = :desNotasempl")
    , @NamedQuery(name = "Sic1even.findByCodExpe", query = "SELECT s FROM Sic1even s WHERE s.codExpe = :codExpe")
    , @NamedQuery(name = "Sic1even.findByFlgSileadmi", query = "SELECT s FROM Sic1even s WHERE s.flgSileadmi = :flgSileadmi")
    , @NamedQuery(name = "Sic1even.findByIdAlmaexpe", query = "SELECT s FROM Sic1even s WHERE s.idAlmaexpe = :idAlmaexpe")
    , @NamedQuery(name = "Sic1even.findByDesAlmaexpe", query = "SELECT s FROM Sic1even s WHERE s.desAlmaexpe = :desAlmaexpe")
    , @NamedQuery(name = "Sic1even.findByDesNotasalmaexpe", query = "SELECT s FROM Sic1even s WHERE s.desNotasalmaexpe = :desNotasalmaexpe")
    , @NamedQuery(name = "Sic1even.findByCodProctemp", query = "SELECT s FROM Sic1even s WHERE s.codProctemp = :codProctemp")
    , @NamedQuery(name = "Sic1even.findByCodExpeHist", query = "SELECT s FROM Sic1even s WHERE s.codExpeHist = :codExpeHist")
    , @NamedQuery(name = "Sic1even.findByFlgEnviando", query = "SELECT s FROM Sic1even s WHERE s.flgEnviando = :flgEnviando")
    , @NamedQuery(name = "Sic1even.findByIdDocureso", query = "SELECT s FROM Sic1even s WHERE s.idDocureso = :idDocureso")
    , @NamedQuery(name = "Sic1even.findByFlgTiposala", query = "SELECT s FROM Sic1even s WHERE s.flgTiposala = :flgTiposala")
    , @NamedQuery(name = "Sic1even.findByIdDocuMemoga", query = "SELECT s FROM Sic1even s WHERE s.idDocuMemoga = :idDocuMemoga")})
public class Sic1even implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_EVEN")
    private BigDecimal idEven;
    @Column(name = "DES_EVEN")
    private String desEven;
    @Column(name = "FEC_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecCreacion;
    @Column(name = "FEC_DESDE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecDesde;
    @Column(name = "FEC_HASTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecHasta;
    @Column(name = "DES_NOTAS")
    private String desNotas;
    @Column(name = "NUM_INSTBPM")
    private String numInstbpm;
    @Column(name = "DES_NOTASMINC")
    private String desNotasminc;
    @Column(name = "DES_NOTASADMI")
    private String desNotasadmi;
    @Column(name = "DES_NOTASEMPL")
    private String desNotasempl;
    @Column(name = "COD_EXPE")
    private String codExpe;
    @Column(name = "FLG_SILEADMI")
    private BigInteger flgSileadmi;
    @Column(name = "ID_ALMAEXPE")
    private BigInteger idAlmaexpe;
    @Column(name = "DES_ALMAEXPE")
    private String desAlmaexpe;
    @Column(name = "DES_NOTASALMAEXPE")
    private String desNotasalmaexpe;
    @Column(name = "COD_PROCTEMP")
    private String codProctemp;
    @Column(name = "COD_EXPE_HIST")
    private String codExpeHist;
    @Column(name = "FLG_ENVIANDO")
    private Short flgEnviando;
    @Column(name = "ID_DOCURESO")
    private BigInteger idDocureso;
    @Column(name = "FLG_TIPOSALA")
    private Short flgTiposala;
    @Column(name = "ID_DOCU_MEMOGA")
    private BigInteger idDocuMemoga;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sic1even")
    private Collection<Sic3evendocu> sic3evendocuCollection;
    @JoinColumn(name = "ID_MODOCREA", referencedColumnName = "ID_GENERAL")
    @ManyToOne
    private Sic1general idModocrea;
    @JoinColumn(name = "ID_STIPOEVEN", referencedColumnName = "ID_GENERAL")
    @ManyToOne
    private Sic1general idStipoeven;
    @JoinColumn(name = "ID_MEDICOMU", referencedColumnName = "ID_GENERAL")
    @ManyToOne
    private Sic1general idMedicomu;
    @JoinColumn(name = "ID_MOTIEVEN", referencedColumnName = "ID_GENERAL")
    @ManyToOne
    private Sic1general idMotieven;
    @JoinColumn(name = "ID_SCLASEEVEN", referencedColumnName = "ID_SCLASEEVEN")
    @ManyToOne
    private Sic1sclaseeven idSclaseeven;
    @JoinColumn(name = "ID_TAREA", referencedColumnName = "ID_TAREA")
    @ManyToOne
    private Sic1tarea idTarea;
    
    /*AGREGADOS*/
    private Sic1ideneven sic1ideneven;
    private Sic1docu sic1docu;
    private Sic1pers  Sic1persfuncresp;
    private Sic1pers  Sic1persadmi;
    private String desEstaeven;
    private Integer flgMigrado;
    private Sic3evenesta sic3evenesta;
    private Sic1general objStipoeven;
    private Integer flgSubevento;
    private BigDecimal idEventopadre;

    public Sic1even() {
    }

    public Sic1even(BigDecimal idEven) {
        this.idEven = idEven;
    }

    public BigDecimal getIdEven() {
        return idEven;
    }

    public void setIdEven(BigDecimal idEven) {
        this.idEven = idEven;
    }

    public String getDesEven() {
        return desEven;
    }

    public void setDesEven(String desEven) {
        this.desEven = desEven;
    }

    public Date getFecCreacion() {
        return fecCreacion;
    }

    public void setFecCreacion(Date fecCreacion) {
        this.fecCreacion = fecCreacion;
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

    public String getDesNotas() {
        return desNotas;
    }

    public void setDesNotas(String desNotas) {
        this.desNotas = desNotas;
    }

    public String getNumInstbpm() {
        return numInstbpm;
    }

    public void setNumInstbpm(String numInstbpm) {
        this.numInstbpm = numInstbpm;
    }

    public String getDesNotasminc() {
        return desNotasminc;
    }

    public void setDesNotasminc(String desNotasminc) {
        this.desNotasminc = desNotasminc;
    }

    public String getDesNotasadmi() {
        return desNotasadmi;
    }

    public void setDesNotasadmi(String desNotasadmi) {
        this.desNotasadmi = desNotasadmi;
    }

    public String getDesNotasempl() {
        return desNotasempl;
    }

    public void setDesNotasempl(String desNotasempl) {
        this.desNotasempl = desNotasempl;
    }

    public String getCodExpe() {
        return codExpe;
    }

    public void setCodExpe(String codExpe) {
        this.codExpe = codExpe;
    }

    public BigInteger getFlgSileadmi() {
        return flgSileadmi;
    }

    public void setFlgSileadmi(BigInteger flgSileadmi) {
        this.flgSileadmi = flgSileadmi;
    }

    public BigInteger getIdAlmaexpe() {
        return idAlmaexpe;
    }

    public void setIdAlmaexpe(BigInteger idAlmaexpe) {
        this.idAlmaexpe = idAlmaexpe;
    }

    public String getDesAlmaexpe() {
        return desAlmaexpe;
    }

    public void setDesAlmaexpe(String desAlmaexpe) {
        this.desAlmaexpe = desAlmaexpe;
    }

    public String getDesNotasalmaexpe() {
        return desNotasalmaexpe;
    }

    public void setDesNotasalmaexpe(String desNotasalmaexpe) {
        this.desNotasalmaexpe = desNotasalmaexpe;
    }

    public String getCodProctemp() {
        return codProctemp;
    }

    public void setCodProctemp(String codProctemp) {
        this.codProctemp = codProctemp;
    }

    public String getCodExpeHist() {
        return codExpeHist;
    }

    public void setCodExpeHist(String codExpeHist) {
        this.codExpeHist = codExpeHist;
    }

    public Short getFlgEnviando() {
        return flgEnviando;
    }

    public void setFlgEnviando(Short flgEnviando) {
        this.flgEnviando = flgEnviando;
    }

    public BigInteger getIdDocureso() {
        return idDocureso;
    }

    public void setIdDocureso(BigInteger idDocureso) {
        this.idDocureso = idDocureso;
    }

    public Short getFlgTiposala() {
        return flgTiposala;
    }

    public void setFlgTiposala(Short flgTiposala) {
        this.flgTiposala = flgTiposala;
    }

    public BigInteger getIdDocuMemoga() {
        return idDocuMemoga;
    }

    public void setIdDocuMemoga(BigInteger idDocuMemoga) {
        this.idDocuMemoga = idDocuMemoga;
    }

    @XmlTransient
    public Collection<Sic3evendocu> getSic3evendocuCollection() {
        return sic3evendocuCollection;
    }

    public void setSic3evendocuCollection(Collection<Sic3evendocu> sic3evendocuCollection) {
        this.sic3evendocuCollection = sic3evendocuCollection;
    }

    public Sic1general getIdModocrea() {
        return idModocrea;
    }

    public void setIdModocrea(Sic1general idModocrea) {
        this.idModocrea = idModocrea;
    }

    public Sic1general getIdStipoeven() {
        return idStipoeven;
    }

    public void setIdStipoeven(Sic1general idStipoeven) {
        this.idStipoeven = idStipoeven;
    }

    public Sic1general getIdMedicomu() {
        return idMedicomu;
    }

    public void setIdMedicomu(Sic1general idMedicomu) {
        this.idMedicomu = idMedicomu;
    }

    public Sic1general getIdMotieven() {
        return idMotieven;
    }

    public void setIdMotieven(Sic1general idMotieven) {
        this.idMotieven = idMotieven;
    }

    public Sic1sclaseeven getIdSclaseeven() {
        return idSclaseeven;
    }

    public void setIdSclaseeven(Sic1sclaseeven idSclaseeven) {
        this.idSclaseeven = idSclaseeven;
    }

    public Sic1tarea getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(Sic1tarea idTarea) {
        this.idTarea = idTarea;
    }

    public Sic1ideneven getSic1ideneven() {
        return sic1ideneven;
    }

    public void setSic1ideneven(Sic1ideneven sic1ideneven) {
        this.sic1ideneven = sic1ideneven;
    }  

    public Sic1docu getSic1docu() {
        return sic1docu;
    }

    public void setSic1docu(Sic1docu sic1docu) {
        this.sic1docu = sic1docu;
    }

    public Sic1pers getSic1persfuncresp() {
        return Sic1persfuncresp;
    }

    public void setSic1persfuncresp(Sic1pers Sic1persfuncresp) {
        this.Sic1persfuncresp = Sic1persfuncresp;
    }

    public Sic1pers getSic1persadmi() {
        return Sic1persadmi;
    }

    public void setSic1persadmi(Sic1pers Sic1persadmi) {
        this.Sic1persadmi = Sic1persadmi;
    }

    public String getDesEstaeven() {
        return desEstaeven;
    }

    public void setDesEstaeven(String desEstaeven) {
        this.desEstaeven = desEstaeven;
    }

    public Integer getFlgMigrado() {
        return flgMigrado;
    }

    public void setFlgMigrado(Integer flgMigrado) {
        this.flgMigrado = flgMigrado;
    }

    public Sic3evenesta getSic3evenesta() {
        return sic3evenesta;
    }

    public void setSic3evenesta(Sic3evenesta sic3evenesta) {
        this.sic3evenesta = sic3evenesta;
    }   

    public Sic1general getObjStipoeven() {
        return objStipoeven;
    }

    public void setObjStipoeven(Sic1general objStipoeven) {
        this.objStipoeven = objStipoeven;
    }

    public Integer getFlgSubevento() {
        return flgSubevento;
    }

    public void setFlgSubevento(Integer flgSubevento) {
        this.flgSubevento = flgSubevento;
    }

    public BigDecimal getIdEventopadre() {
        return idEventopadre;
    }

    public void setIdEventopadre(BigDecimal idEventopadre) {
        this.idEventopadre = idEventopadre;
    }
    
    
    
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEven != null ? idEven.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sic1even)) {
            return false;
        }
        Sic1even other = (Sic1even) object;
        if ((this.idEven == null && other.idEven != null) || (this.idEven != null && !this.idEven.equals(other.idEven))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.general.entity.Sic1even[ idEven=" + idEven + " ]";
    }
    
}
