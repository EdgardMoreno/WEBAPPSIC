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
@Table(name = "SIC5PERSPERM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sic5persperm.findAll", query = "SELECT s FROM Sic5persperm s")
    , @NamedQuery(name = "Sic5persperm.findByIdPers", query = "SELECT s FROM Sic5persperm s WHERE s.sic5perspermPK.idPers = :idPers")
    , @NamedQuery(name = "Sic5persperm.findByIdMotiperm", query = "SELECT s FROM Sic5persperm s WHERE s.idMotiperm = :idMotiperm")
    , @NamedQuery(name = "Sic5persperm.findByFecDesde", query = "SELECT s FROM Sic5persperm s WHERE s.fecDesde = :fecDesde")
    , @NamedQuery(name = "Sic5persperm.findByFecHasta", query = "SELECT s FROM Sic5persperm s WHERE s.fecHasta = :fecHasta")
    , @NamedQuery(name = "Sic5persperm.findByFecCreacion", query = "SELECT s FROM Sic5persperm s WHERE s.fecCreacion = :fecCreacion")
    , @NamedQuery(name = "Sic5persperm.findByDesNotas", query = "SELECT s FROM Sic5persperm s WHERE s.desNotas = :desNotas")
    , @NamedQuery(name = "Sic5persperm.findByFlgActivo", query = "SELECT s FROM Sic5persperm s WHERE s.flgActivo = :flgActivo")
    , @NamedQuery(name = "Sic5persperm.findByDesPerm", query = "SELECT s FROM Sic5persperm s WHERE s.desPerm = :desPerm")
    , @NamedQuery(name = "Sic5persperm.findByNumCorr", query = "SELECT s FROM Sic5persperm s WHERE s.sic5perspermPK.numCorr = :numCorr")})
public class Sic5persperm implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected Sic5perspermPK sic5perspermPK;
    @Column(name = "ID_MOTIPERM")
    private Integer idMotiperm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FEC_DESDE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecDesde;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FEC_HASTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecHasta;
    @Column(name = "FEC_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecCreacion;
    @Size(max = 400)
    @Column(name = "DES_NOTAS")
    private String desNotas;
    @Column(name = "FLG_ACTIVO")
    private Short flgActivo;
    @Size(max = 400)
    @Column(name = "DES_PERM")
    private String desPerm;

    public Sic5persperm() {
    }

    public Sic5persperm(Sic5perspermPK sic5perspermPK) {
        this.sic5perspermPK = sic5perspermPK;
    }

    public Sic5persperm(Sic5perspermPK sic5perspermPK, Date fecDesde, Date fecHasta) {
        this.sic5perspermPK = sic5perspermPK;
        this.fecDesde = fecDesde;
        this.fecHasta = fecHasta;
    }

    public Sic5persperm(Integer idPers, BigInteger numCorr) {
        this.sic5perspermPK = new Sic5perspermPK(idPers, numCorr);
    }

    public Sic5perspermPK getSic5perspermPK() {
        return sic5perspermPK;
    }

    public void setSic5perspermPK(Sic5perspermPK sic5perspermPK) {
        this.sic5perspermPK = sic5perspermPK;
    }

    public Integer getIdMotiperm() {
        return idMotiperm;
    }

    public void setIdMotiperm(Integer idMotiperm) {
        this.idMotiperm = idMotiperm;
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

    public Date getFecCreacion() {
        return fecCreacion;
    }

    public void setFecCreacion(Date fecCreacion) {
        this.fecCreacion = fecCreacion;
    }

    public String getDesNotas() {
        return desNotas;
    }

    public void setDesNotas(String desNotas) {
        this.desNotas = desNotas;
    }

    public Short getFlgActivo() {
        return flgActivo;
    }

    public void setFlgActivo(Short flgActivo) {
        this.flgActivo = flgActivo;
    }

    public String getDesPerm() {
        return desPerm;
    }

    public void setDesPerm(String desPerm) {
        this.desPerm = desPerm;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sic5perspermPK != null ? sic5perspermPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sic5persperm)) {
            return false;
        }
        Sic5persperm other = (Sic5persperm) object;
        if ((this.sic5perspermPK == null && other.sic5perspermPK != null) || (this.sic5perspermPK != null && !this.sic5perspermPK.equals(other.sic5perspermPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.general.entity.Sic5persperm[ sic5perspermPK=" + sic5perspermPK + " ]";
    }
    
}
