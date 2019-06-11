/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
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
@Table(name = "SIC1DOCUBINA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sic1docubina.findAll", query = "SELECT s FROM Sic1docubina s")
    , @NamedQuery(name = "Sic1docubina.findByIdDocu", query = "SELECT s FROM Sic1docubina s WHERE s.sic1docubinaPK.idDocu = :idDocu")
    , @NamedQuery(name = "Sic1docubina.findByIdTreladocu", query = "SELECT s FROM Sic1docubina s WHERE s.sic1docubinaPK.idTreladocu = :idTreladocu")
    , @NamedQuery(name = "Sic1docubina.findByCodDocubina", query = "SELECT s FROM Sic1docubina s WHERE s.sic1docubinaPK.codDocubina = :codDocubina")
    , @NamedQuery(name = "Sic1docubina.findByFecDesde", query = "SELECT s FROM Sic1docubina s WHERE s.sic1docubinaPK.fecDesde = :fecDesde")
    , @NamedQuery(name = "Sic1docubina.findByDesTitulo", query = "SELECT s FROM Sic1docubina s WHERE s.desTitulo = :desTitulo")
    , @NamedQuery(name = "Sic1docubina.findByFecCreacion", query = "SELECT s FROM Sic1docubina s WHERE s.fecCreacion = :fecCreacion")
    , @NamedQuery(name = "Sic1docubina.findByNumBytes", query = "SELECT s FROM Sic1docubina s WHERE s.numBytes = :numBytes")
    , @NamedQuery(name = "Sic1docubina.findByNumFolios", query = "SELECT s FROM Sic1docubina s WHERE s.numFolios = :numFolios")
    , @NamedQuery(name = "Sic1docubina.findByDesLocauri", query = "SELECT s FROM Sic1docubina s WHERE s.desLocauri = :desLocauri")
    , @NamedQuery(name = "Sic1docubina.findByDesLocacache", query = "SELECT s FROM Sic1docubina s WHERE s.desLocacache = :desLocacache")
    , @NamedQuery(name = "Sic1docubina.findByFecHasta", query = "SELECT s FROM Sic1docubina s WHERE s.fecHasta = :fecHasta")
    , @NamedQuery(name = "Sic1docubina.findByDesNombreal", query = "SELECT s FROM Sic1docubina s WHERE s.desNombreal = :desNombreal")
    , @NamedQuery(name = "Sic1docubina.findByIdExtedocu", query = "SELECT s FROM Sic1docubina s WHERE s.idExtedocu = :idExtedocu")
    , @NamedQuery(name = "Sic1docubina.findByIdLengdocu", query = "SELECT s FROM Sic1docubina s WHERE s.idLengdocu = :idLengdocu")
    , @NamedQuery(name = "Sic1docubina.findByDesDocubina", query = "SELECT s FROM Sic1docubina s WHERE s.desDocubina = :desDocubina")
    , @NamedQuery(name = "Sic1docubina.findByNumDocubina", query = "SELECT s FROM Sic1docubina s WHERE s.numDocubina = :numDocubina")
    , @NamedQuery(name = "Sic1docubina.findByNumDocutd", query = "SELECT s FROM Sic1docubina s WHERE s.numDocutd = :numDocutd")})
public class Sic1docubina implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected Sic1docubinaPK sic1docubinaPK;
    @Column(name = "DES_TITULO")
    private String desTitulo;
    @Column(name = "FEC_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecCreacion;
    @Column(name = "NUM_BYTES")
    private BigInteger numBytes;
    @Column(name = "NUM_FOLIOS")
    private BigInteger numFolios;
    @Column(name = "DES_LOCAURI")
    private String desLocauri;
    @Column(name = "DES_LOCACACHE")
    private String desLocacache;
    @Column(name = "FEC_HASTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecHasta;
    @Column(name = "DES_NOMBREAL")
    private String desNombreal;
    @Basic(optional = false)
    @Column(name = "ID_EXTEDOCU")
    private BigInteger idExtedocu;
    @Column(name = "ID_LENGDOCU")
    private BigInteger idLengdocu;
    @Column(name = "DES_DOCUBINA")
    private String desDocubina;
    @Column(name = "NUM_DOCUBINA")
    private String numDocubina;
    @Column(name = "NUM_DOCUTD")
    private String numDocutd;
    @JoinColumn(name = "ID_DOCU", referencedColumnName = "ID_DOCU", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Sic1docu sic1docu;
    
    /*AGREGADO*/
    private String desExtedocu;
    private String codExtedocu;

    public Sic1docubina() {
    }

    public Sic1docubina(Sic1docubinaPK sic1docubinaPK) {
        this.sic1docubinaPK = sic1docubinaPK;
    }

    public Sic1docubina(Sic1docubinaPK sic1docubinaPK, BigInteger idExtedocu) {
        this.sic1docubinaPK = sic1docubinaPK;
        this.idExtedocu = idExtedocu;
    }

    public Sic1docubina(BigInteger idDocu, BigInteger idTreladocu, String codDocubina, Date fecDesde) {
        this.sic1docubinaPK = new Sic1docubinaPK(idDocu, idTreladocu, codDocubina, fecDesde);
    }

    public Sic1docubinaPK getSic1docubinaPK() {
        return sic1docubinaPK;
    }

    public void setSic1docubinaPK(Sic1docubinaPK sic1docubinaPK) {
        this.sic1docubinaPK = sic1docubinaPK;
    }

    public String getDesTitulo() {
        return desTitulo;
    }

    public void setDesTitulo(String desTitulo) {
        this.desTitulo = desTitulo;
    }

    public Date getFecCreacion() {
        return fecCreacion;
    }

    public void setFecCreacion(Date fecCreacion) {
        this.fecCreacion = fecCreacion;
    }

    public BigInteger getNumBytes() {
        return numBytes;
    }

    public void setNumBytes(BigInteger numBytes) {
        this.numBytes = numBytes;
    }

    public BigInteger getNumFolios() {
        return numFolios;
    }

    public void setNumFolios(BigInteger numFolios) {
        this.numFolios = numFolios;
    }

    public String getDesLocauri() {
        return desLocauri;
    }

    public void setDesLocauri(String desLocauri) {
        this.desLocauri = desLocauri;
    }

    public String getDesLocacache() {
        return desLocacache;
    }

    public void setDesLocacache(String desLocacache) {
        this.desLocacache = desLocacache;
    }

    public Date getFecHasta() {
        return fecHasta;
    }

    public void setFecHasta(Date fecHasta) {
        this.fecHasta = fecHasta;
    }

    public String getDesNombreal() {
        return desNombreal;
    }

    public void setDesNombreal(String desNombreal) {
        this.desNombreal = desNombreal;
    }

    public BigInteger getIdExtedocu() {
        return idExtedocu;
    }

    public void setIdExtedocu(BigInteger idExtedocu) {
        this.idExtedocu = idExtedocu;
    }

    public BigInteger getIdLengdocu() {
        return idLengdocu;
    }

    public void setIdLengdocu(BigInteger idLengdocu) {
        this.idLengdocu = idLengdocu;
    }

    public String getDesDocubina() {
        return desDocubina;
    }

    public void setDesDocubina(String desDocubina) {
        this.desDocubina = desDocubina;
    }

    public String getNumDocubina() {
        return numDocubina;
    }

    public void setNumDocubina(String numDocubina) {
        this.numDocubina = numDocubina;
    }

    public String getNumDocutd() {
        return numDocutd;
    }

    public void setNumDocutd(String numDocutd) {
        this.numDocutd = numDocutd;
    }

    public Sic1docu getSic1docu() {
        return sic1docu;
    }

    public void setSic1docu(Sic1docu sic1docu) {
        this.sic1docu = sic1docu;
    }

    public String getDesExtedocu() {
        return desExtedocu;
    }

    public void setDesExtedocu(String desExtedocu) {
        this.desExtedocu = desExtedocu;
    }

    public String getCodExtedocu() {
        return codExtedocu;
    }

    public void setCodExtedocu(String codExtedocu) {
        this.codExtedocu = codExtedocu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sic1docubinaPK != null ? sic1docubinaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sic1docubina)) {
            return false;
        }
        Sic1docubina other = (Sic1docubina) object;
        if ((this.sic1docubinaPK == null && other.sic1docubinaPK != null) || (this.sic1docubinaPK != null && !this.sic1docubinaPK.equals(other.sic1docubinaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.general.sicappdao.Sic1docubina[ sic1docubinaPK=" + sic1docubinaPK + " ]";
    }
    
}
