/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "SIC3EVENESTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sic3evenesta.findAll", query = "SELECT s FROM Sic3evenesta s")
    , @NamedQuery(name = "Sic3evenesta.findByIdEven", query = "SELECT s FROM Sic3evenesta s WHERE s.sic3evenestaPK.idEven = :idEven")
    , @NamedQuery(name = "Sic3evenesta.findByIdTrelaeven", query = "SELECT s FROM Sic3evenesta s WHERE s.sic3evenestaPK.idTrelaeven = :idTrelaeven")
    , @NamedQuery(name = "Sic3evenesta.findByIdEstaeven", query = "SELECT s FROM Sic3evenesta s WHERE s.sic3evenestaPK.idEstaeven = :idEstaeven")
    , @NamedQuery(name = "Sic3evenesta.findByIdTrolestaeven", query = "SELECT s FROM Sic3evenesta s WHERE s.sic3evenestaPK.idTrolestaeven = :idTrolestaeven")
    , @NamedQuery(name = "Sic3evenesta.findByIdTipoinst", query = "SELECT s FROM Sic3evenesta s WHERE s.sic3evenestaPK.idTipoinst = :idTipoinst")
    , @NamedQuery(name = "Sic3evenesta.findByFecDesde", query = "SELECT s FROM Sic3evenesta s WHERE s.sic3evenestaPK.fecDesde = :fecDesde")
    , @NamedQuery(name = "Sic3evenesta.findByFecHasta", query = "SELECT s FROM Sic3evenesta s WHERE s.fecHasta = :fecHasta")
    , @NamedQuery(name = "Sic3evenesta.findByDesNotas", query = "SELECT s FROM Sic3evenesta s WHERE s.desNotas = :desNotas")})
public class Sic3evenesta implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected Sic3evenestaPK sic3evenestaPK;
    @Column(name = "FEC_HASTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecHasta;
    @Size(max = 4000)
    @Column(name = "DES_NOTAS")
    private String desNotas;
    
    private String CodEstaeven;

    public Sic3evenesta() {
    }

    public Sic3evenesta(Sic3evenestaPK sic3evenestaPK) {
        this.sic3evenestaPK = sic3evenestaPK;
    }

    public Sic3evenesta(BigDecimal idEven, Integer idTrelaeven, Integer idEstaeven, Integer idTrolestaeven, Integer idTipoinst, Date fecDesde) {
        this.sic3evenestaPK = new Sic3evenestaPK(idEven, idTrelaeven, idEstaeven, idTrolestaeven, idTipoinst, fecDesde);
    }

    public Sic3evenestaPK getSic3evenestaPK() {
        return sic3evenestaPK;
    }

    public void setSic3evenestaPK(Sic3evenestaPK sic3evenestaPK) {
        this.sic3evenestaPK = sic3evenestaPK;
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

    public String getCodEstaeven() {
        return CodEstaeven;
    }

    public void setCodEstaeven(String CodEstaeven) {
        this.CodEstaeven = CodEstaeven;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sic3evenestaPK != null ? sic3evenestaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sic3evenesta)) {
            return false;
        }
        Sic3evenesta other = (Sic3evenesta) object;
        if ((this.sic3evenestaPK == null && other.sic3evenestaPK != null) || (this.sic3evenestaPK != null && !this.sic3evenestaPK.equals(other.sic3evenestaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.general.entity.Sic3evenesta[ sic3evenestaPK=" + sic3evenestaPK + " ]";
    }
    
}
