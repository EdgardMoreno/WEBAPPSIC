/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author emoreno
 */
@Embeddable
public class Sic5evenestaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PERI")
    private Integer idPeri;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_EVEN")
    private BigInteger idEven;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ESTAEVEN")
    private Integer idEstaeven;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TAREA")
    private BigInteger idTarea;

    public Sic5evenestaPK() {
    }

    public Sic5evenestaPK(Integer idPeri, BigInteger idEven, Integer idEstaeven, BigInteger idTarea) {
        this.idPeri = idPeri;
        this.idEven = idEven;
        this.idEstaeven = idEstaeven;
        this.idTarea = idTarea;
    }

    public Integer getIdPeri() {
        return idPeri;
    }

    public void setIdPeri(Integer idPeri) {
        this.idPeri = idPeri;
    }

    public BigInteger getIdEven() {
        return idEven;
    }

    public void setIdEven(BigInteger idEven) {
        this.idEven = idEven;
    }

    public Integer getIdEstaeven() {
        return idEstaeven;
    }

    public void setIdEstaeven(Integer idEstaeven) {
        this.idEstaeven = idEstaeven;
    }

    public BigInteger getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(BigInteger idTarea) {
        this.idTarea = idTarea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPeri != null ? idPeri.hashCode() : 0);
        hash += (idEven != null ? idEven.hashCode() : 0);
        hash += (idEstaeven != null ? idEstaeven.hashCode() : 0);
        hash += (idTarea != null ? idTarea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sic5evenestaPK)) {
            return false;
        }
        Sic5evenestaPK other = (Sic5evenestaPK) object;
        if ((this.idPeri == null && other.idPeri != null) || (this.idPeri != null && !this.idPeri.equals(other.idPeri))) {
            return false;
        }
        if ((this.idEven == null && other.idEven != null) || (this.idEven != null && !this.idEven.equals(other.idEven))) {
            return false;
        }
        if ((this.idEstaeven == null && other.idEstaeven != null) || (this.idEstaeven != null && !this.idEstaeven.equals(other.idEstaeven))) {
            return false;
        }
        if ((this.idTarea == null && other.idTarea != null) || (this.idTarea != null && !this.idTarea.equals(other.idTarea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.general.entity.Sic5evenestaPK[ idPeri=" + idPeri + ", idEven=" + idEven + ", idEstaeven=" + idEstaeven + ", idTarea=" + idTarea + " ]";
    }
    
}
