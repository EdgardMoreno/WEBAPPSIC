/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author emoreno
 */
@Embeddable
public class Sic1idendocuPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ID_TIPOIDEN")
    private Integer idTipoiden;
    @Basic(optional = false)
    @Column(name = "COD_IDEN")
    private String codIden;

    public Sic1idendocuPK() {
    }

    public Sic1idendocuPK(Integer idTipoiden, String codIden) {
        this.idTipoiden = idTipoiden;
        this.codIden = codIden;
    }

    public Integer getIdTipoiden() {
        return idTipoiden;
    }

    public void setIdTipoiden(Integer idTipoiden) {
        this.idTipoiden = idTipoiden;
    }

    public String getCodIden() {
        return codIden;
    }

    public void setCodIden(String codIden) {
        this.codIden = codIden;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoiden != null ? idTipoiden.hashCode() : 0);
        hash += (codIden != null ? codIden.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sic1idendocuPK)) {
            return false;
        }
        Sic1idendocuPK other = (Sic1idendocuPK) object;
        if ((this.idTipoiden == null && other.idTipoiden != null) || (this.idTipoiden != null && !this.idTipoiden.equals(other.idTipoiden))) {
            return false;
        }
        if ((this.codIden == null && other.codIden != null) || (this.codIden != null && !this.codIden.equals(other.codIden))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.general.sicappdao.Sic1idendocuPK[ idTipoiden=" + idTipoiden + ", codIden=" + codIden + " ]";
    }
    
}
