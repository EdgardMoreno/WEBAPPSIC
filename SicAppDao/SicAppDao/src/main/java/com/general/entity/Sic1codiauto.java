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
@Table(name = "SIC1CODIAUTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sic1codiauto.findAll", query = "SELECT s FROM Sic1codiauto s")
    , @NamedQuery(name = "Sic1codiauto.findByCodCodiauto", query = "SELECT s FROM Sic1codiauto s WHERE s.codCodiauto = :codCodiauto")
    , @NamedQuery(name = "Sic1codiauto.findByFecDesde", query = "SELECT s FROM Sic1codiauto s WHERE s.fecDesde = :fecDesde")
    , @NamedQuery(name = "Sic1codiauto.findByIdCodiauto", query = "SELECT s FROM Sic1codiauto s WHERE s.idCodiauto = :idCodiauto")
    , @NamedQuery(name = "Sic1codiauto.findByFecHasta", query = "SELECT s FROM Sic1codiauto s WHERE s.fecHasta = :fecHasta")
    , @NamedQuery(name = "Sic1codiauto.findByIdEntidad", query = "SELECT s FROM Sic1codiauto s WHERE s.idEntidad = :idEntidad")
    , @NamedQuery(name = "Sic1codiauto.findByIdStipocodiauto", query = "SELECT s FROM Sic1codiauto s WHERE s.idStipocodiauto = :idStipocodiauto")
    , @NamedQuery(name = "Sic1codiauto.findByIdDocureso", query = "SELECT s FROM Sic1codiauto s WHERE s.idDocureso = :idDocureso")
    , @NamedQuery(name = "Sic1codiauto.findByIdEven", query = "SELECT s FROM Sic1codiauto s WHERE s.idEven = :idEven")
    , @NamedQuery(name = "Sic1codiauto.findByFecCreacion", query = "SELECT s FROM Sic1codiauto s WHERE s.fecCreacion = :fecCreacion")
    , @NamedQuery(name = "Sic1codiauto.findByFlgCodiautonoti", query = "SELECT s FROM Sic1codiauto s WHERE s.flgCodiautonoti = :flgCodiautonoti")
    , @NamedQuery(name = "Sic1codiauto.findByIdStipocodicanc", query = "SELECT s FROM Sic1codiauto s WHERE s.idStipocodicanc = :idStipocodicanc")
    , @NamedQuery(name = "Sic1codiauto.findByIdSala", query = "SELECT s FROM Sic1codiauto s WHERE s.idSala = :idSala")
    , @NamedQuery(name = "Sic1codiauto.findByIdPersadmin", query = "SELECT s FROM Sic1codiauto s WHERE s.idPersadmin = :idPersadmin")
    , @NamedQuery(name = "Sic1codiauto.findByIdMotivocierre", query = "SELECT s FROM Sic1codiauto s WHERE s.idMotivocierre = :idMotivocierre")
    , @NamedQuery(name = "Sic1codiauto.findByDesMotivocierre", query = "SELECT s FROM Sic1codiauto s WHERE s.desMotivocierre = :desMotivocierre")
    , @NamedQuery(name = "Sic1codiauto.findByFecHastaante", query = "SELECT s FROM Sic1codiauto s WHERE s.fecHastaante = :fecHastaante")
    , @NamedQuery(name = "Sic1codiauto.findByDesNumdocucierre", query = "SELECT s FROM Sic1codiauto s WHERE s.desNumdocucierre = :desNumdocucierre")
    , @NamedQuery(name = "Sic1codiauto.findByFecHastaant", query = "SELECT s FROM Sic1codiauto s WHERE s.fecHastaant = :fecHastaant")
    , @NamedQuery(name = "Sic1codiauto.findByIdDocuresoant", query = "SELECT s FROM Sic1codiauto s WHERE s.idDocuresoant = :idDocuresoant")
    , @NamedQuery(name = "Sic1codiauto.findByIdStipocodiautoant", query = "SELECT s FROM Sic1codiauto s WHERE s.idStipocodiautoant = :idStipocodiautoant")})
public class Sic1codiauto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "COD_CODIAUTO")
    private String codCodiauto;
    @Column(name = "FEC_DESDE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecDesde;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CODIAUTO")
    private BigDecimal idCodiauto;
    @Column(name = "FEC_HASTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecHasta;
    @Column(name = "ID_ENTIDAD")
    private BigInteger idEntidad;
    @Column(name = "ID_STIPOCODIAUTO")
    private BigInteger idStipocodiauto;
    @Column(name = "ID_DOCURESO")
    private BigInteger idDocureso;
    @Column(name = "ID_EVEN")
    private BigInteger idEven;
    @Column(name = "FEC_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecCreacion;
    @Column(name = "FLG_CODIAUTONOTI")
    private BigInteger flgCodiautonoti;
    @Column(name = "ID_STIPOCODICANC")
    private BigInteger idStipocodicanc;
    @Column(name = "ID_SALA")
    private BigDecimal idSala;
    @Column(name = "ID_PERSADMIN")
    private BigInteger idPersadmin;
    @Column(name = "ID_MOTIVOCIERRE")
    private BigInteger idMotivocierre;
    @Size(max = 250)
    @Column(name = "DES_MOTIVOCIERRE")
    private String desMotivocierre;
    @Column(name = "FEC_HASTAANTE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecHastaante;
    @Size(max = 250)
    @Column(name = "DES_NUMDOCUCIERRE")
    private String desNumdocucierre;
    @Column(name = "FEC_HASTAANT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecHastaant;
    @Column(name = "ID_DOCURESOANT")
    private BigInteger idDocuresoant;
    @Column(name = "ID_STIPOCODIAUTOANT")
    private BigInteger idStipocodiautoant;

    /*Agregados*/
    private Sic1even sic1even;
    private Sic1docu sic1docu;
    private String desNombSala;
    
    public Sic1codiauto() {
    }

    public Sic1codiauto(BigDecimal idCodiauto) {
        this.idCodiauto = idCodiauto;
    }

    public Sic1codiauto(BigDecimal idCodiauto, String codCodiauto) {
        this.idCodiauto = idCodiauto;
        this.codCodiauto = codCodiauto;
    }

    public String getCodCodiauto() {
        return codCodiauto;
    }

    public void setCodCodiauto(String codCodiauto) {
        this.codCodiauto = codCodiauto;
    }

    public Date getFecDesde() {
        return fecDesde;
    }

    public void setFecDesde(Date fecDesde) {
        this.fecDesde = fecDesde;
    }

    public BigDecimal getIdCodiauto() {
        return idCodiauto;
    }

    public void setIdCodiauto(BigDecimal idCodiauto) {
        this.idCodiauto = idCodiauto;
    }

    public Date getFecHasta() {
        return fecHasta;
    }

    public void setFecHasta(Date fecHasta) {
        this.fecHasta = fecHasta;
    }

    public BigInteger getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(BigInteger idEntidad) {
        this.idEntidad = idEntidad;
    }

    public BigInteger getIdStipocodiauto() {
        return idStipocodiauto;
    }

    public void setIdStipocodiauto(BigInteger idStipocodiauto) {
        this.idStipocodiauto = idStipocodiauto;
    }

    public BigInteger getIdDocureso() {
        return idDocureso;
    }

    public void setIdDocureso(BigInteger idDocureso) {
        this.idDocureso = idDocureso;
    }

    public BigInteger getIdEven() {
        return idEven;
    }

    public void setIdEven(BigInteger idEven) {
        this.idEven = idEven;
    }

    public Date getFecCreacion() {
        return fecCreacion;
    }

    public void setFecCreacion(Date fecCreacion) {
        this.fecCreacion = fecCreacion;
    }

    public BigInteger getFlgCodiautonoti() {
        return flgCodiautonoti;
    }

    public void setFlgCodiautonoti(BigInteger flgCodiautonoti) {
        this.flgCodiautonoti = flgCodiautonoti;
    }

    public BigInteger getIdStipocodicanc() {
        return idStipocodicanc;
    }

    public void setIdStipocodicanc(BigInteger idStipocodicanc) {
        this.idStipocodicanc = idStipocodicanc;
    }

    public BigDecimal getIdSala() {
        return idSala;
    }

    public void setIdSala(BigDecimal idSala) {
        this.idSala = idSala;
    }

    public BigInteger getIdPersadmin() {
        return idPersadmin;
    }

    public void setIdPersadmin(BigInteger idPersadmin) {
        this.idPersadmin = idPersadmin;
    }

    public BigInteger getIdMotivocierre() {
        return idMotivocierre;
    }

    public void setIdMotivocierre(BigInteger idMotivocierre) {
        this.idMotivocierre = idMotivocierre;
    }

    public String getDesMotivocierre() {
        return desMotivocierre;
    }

    public void setDesMotivocierre(String desMotivocierre) {
        this.desMotivocierre = desMotivocierre;
    }

    public Date getFecHastaante() {
        return fecHastaante;
    }

    public void setFecHastaante(Date fecHastaante) {
        this.fecHastaante = fecHastaante;
    }

    public String getDesNumdocucierre() {
        return desNumdocucierre;
    }

    public void setDesNumdocucierre(String desNumdocucierre) {
        this.desNumdocucierre = desNumdocucierre;
    }

    public Date getFecHastaant() {
        return fecHastaant;
    }

    public void setFecHastaant(Date fecHastaant) {
        this.fecHastaant = fecHastaant;
    }

    public BigInteger getIdDocuresoant() {
        return idDocuresoant;
    }

    public void setIdDocuresoant(BigInteger idDocuresoant) {
        this.idDocuresoant = idDocuresoant;
    }

    public BigInteger getIdStipocodiautoant() {
        return idStipocodiautoant;
    }

    public void setIdStipocodiautoant(BigInteger idStipocodiautoant) {
        this.idStipocodiautoant = idStipocodiautoant;
    }

    public Sic1even getSic1even() {
        return sic1even;
    }

    public void setSic1even(Sic1even sic1even) {
        this.sic1even = sic1even;
    }

    public Sic1docu getSic1docu() {
        return sic1docu;
    }

    public void setSic1docu(Sic1docu sic1docu) {
        this.sic1docu = sic1docu;
    }

    public String getDesNombSala() {
        return desNombSala;
    }

    public void setDesNombSala(String desNombSala) {
        this.desNombSala = desNombSala;
    }    
        
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCodiauto != null ? idCodiauto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sic1codiauto)) {
            return false;
        }
        Sic1codiauto other = (Sic1codiauto) object;
        if ((this.idCodiauto == null && other.idCodiauto != null) || (this.idCodiauto != null && !this.idCodiauto.equals(other.idCodiauto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.general.entity.Sic1codiauto[ idCodiauto=" + idCodiauto + " ]";
    }
    
}
