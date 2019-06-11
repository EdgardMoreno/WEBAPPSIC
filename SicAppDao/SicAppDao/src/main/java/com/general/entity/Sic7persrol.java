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
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author emoreno
 */
@Entity
@Table(name = "SIC7PERSROL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sic7persrol.findAll", query = "SELECT s FROM Sic7persrol s")
    , @NamedQuery(name = "Sic7persrol.findByFecDesde", query = "SELECT s FROM Sic7persrol s WHERE s.sic7persrolPK.fecDesde = :fecDesde")
    , @NamedQuery(name = "Sic7persrol.findByFecHasta", query = "SELECT s FROM Sic7persrol s WHERE s.fecHasta = :fecHasta")
    , @NamedQuery(name = "Sic7persrol.findByDesNotas", query = "SELECT s FROM Sic7persrol s WHERE s.desNotas = :desNotas")
    , @NamedQuery(name = "Sic7persrol.findByIdTrolpers", query = "SELECT s FROM Sic7persrol s WHERE s.sic7persrolPK.idTrolpers = :idTrolpers")
    , @NamedQuery(name = "Sic7persrol.findByIdPers", query = "SELECT s FROM Sic7persrol s WHERE s.sic7persrolPK.idPers = :idPers")
    , @NamedQuery(name = "Sic7persrol.findByCodCodiauto", query = "SELECT s FROM Sic7persrol s WHERE s.codCodiauto = :codCodiauto")})
public class Sic7persrol implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected Sic7persrolPK sic7persrolPK;
    @Column(name = "FEC_HASTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecHasta;
    @Size(max = 4000)
    @Column(name = "DES_NOTAS")
    private String desNotas;
    @Size(max = 200)
    @Column(name = "COD_CODIAUTO")
    private String codCodiauto;

    public Sic7persrol() {
    }

    public Sic7persrol(Sic7persrolPK sic7persrolPK) {
        this.sic7persrolPK = sic7persrolPK;
    }

    public Sic7persrol(Date fecDesde, Integer idTrolpers, BigDecimal idPers) {
        this.sic7persrolPK = new Sic7persrolPK(fecDesde, idTrolpers, idPers);
    }

    public Sic7persrolPK getSic7persrolPK() {
        return sic7persrolPK;
    }

    public void setSic7persrolPK(Sic7persrolPK sic7persrolPK) {
        this.sic7persrolPK = sic7persrolPK;
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

    public String getCodCodiauto() {
        return codCodiauto;
    }

    public void setCodCodiauto(String codCodiauto) {
        this.codCodiauto = codCodiauto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sic7persrolPK != null ? sic7persrolPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sic7persrol)) {
            return false;
        }
        Sic7persrol other = (Sic7persrol) object;
        if ((this.sic7persrolPK == null && other.sic7persrolPK != null) || (this.sic7persrolPK != null && !this.sic7persrolPK.equals(other.sic7persrolPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.general.entity.Sic7persrol[ sic7persrolPK=" + sic7persrolPK + " ]";
    }
    
}
