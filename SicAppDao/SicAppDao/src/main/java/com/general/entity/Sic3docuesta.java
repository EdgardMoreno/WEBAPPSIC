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
@Table(name = "SIC3DOCUESTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sic3docuesta.findAll", query = "SELECT s FROM Sic3docuesta s")
    , @NamedQuery(name = "Sic3docuesta.findByFecDesde", query = "SELECT s FROM Sic3docuesta s WHERE s.sic3docuestaPK.fecDesde = :fecDesde")
    , @NamedQuery(name = "Sic3docuesta.findByFecHasta", query = "SELECT s FROM Sic3docuesta s WHERE s.fecHasta = :fecHasta")
    , @NamedQuery(name = "Sic3docuesta.findByIdTreladocu", query = "SELECT s FROM Sic3docuesta s WHERE s.sic3docuestaPK.idTreladocu = :idTreladocu")
    , @NamedQuery(name = "Sic3docuesta.findByDesNotas", query = "SELECT s FROM Sic3docuesta s WHERE s.desNotas = :desNotas")
    , @NamedQuery(name = "Sic3docuesta.findByIdEstadocu", query = "SELECT s FROM Sic3docuesta s WHERE s.sic3docuestaPK.idEstadocu = :idEstadocu")
    , @NamedQuery(name = "Sic3docuesta.findByIdTrolestadocu", query = "SELECT s FROM Sic3docuesta s WHERE s.sic3docuestaPK.idTrolestadocu = :idTrolestadocu")
    , @NamedQuery(name = "Sic3docuesta.findByIdDocu", query = "SELECT s FROM Sic3docuesta s WHERE s.sic3docuestaPK.idDocu = :idDocu")})
public class Sic3docuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected Sic3docuestaPK sic3docuestaPK;
    @Column(name = "FEC_HASTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecHasta;
    @Size(max = 4000)
    @Column(name = "DES_NOTAS")
    private String desNotas;
    
    /*CAMPOS AGREGADOS*/
    private String codTrolestadocu;
    private String codEstadocu;
    private String desEstadocu;

    public Sic3docuesta() {
    }

    public Sic3docuesta(Sic3docuestaPK sic3docuestaPK) {
        this.sic3docuestaPK = sic3docuestaPK;
    }

    public Sic3docuesta(Date fecDesde, Integer idTreladocu, Integer idEstadocu, Integer idTrolestadocu, BigDecimal idDocu) {
        this.sic3docuestaPK = new Sic3docuestaPK(fecDesde, idTreladocu, idEstadocu, idTrolestadocu, idDocu);
    }

    public Sic3docuestaPK getSic3docuestaPK() {
        return sic3docuestaPK;
    }

    public void setSic3docuestaPK(Sic3docuestaPK sic3docuestaPK) {
        this.sic3docuestaPK = sic3docuestaPK;
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

    public String getCodTrolestadocu() {
        return codTrolestadocu;
    }

    public void setCodTrolestadocu(String codTrolestadocu) {
        this.codTrolestadocu = codTrolestadocu;
    }

    public String getCodEstadocu() {
        return codEstadocu;
    }

    public void setCodEstadocu(String codEstadocu) {
        this.codEstadocu = codEstadocu;
    }

    public String getDesEstadocu() {
        return desEstadocu;
    }

    public void setDesEstadocu(String desEstadocu) {
        this.desEstadocu = desEstadocu;
    }
    
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sic3docuestaPK != null ? sic3docuestaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sic3docuesta)) {
            return false;
        }
        Sic3docuesta other = (Sic3docuesta) object;
        if ((this.sic3docuestaPK == null && other.sic3docuestaPK != null) || (this.sic3docuestaPK != null && !this.sic3docuestaPK.equals(other.sic3docuestaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.general.entity.Sic3docuesta[ sic3docuestaPK=" + sic3docuestaPK + " ]";
    }
    
}
