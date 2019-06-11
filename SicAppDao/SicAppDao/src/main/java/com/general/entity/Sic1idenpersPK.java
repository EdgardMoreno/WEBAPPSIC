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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author emoreno
 */
@Embeddable
public class Sic1idenpersPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPOIDEN")
    private Integer idTipoiden;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "COD_IDEN")
    private String codIden;
    
    /*AGREGADO*/
    private String desTipoiden;

    public Sic1idenpersPK() {
    }

    
    /*CONSTRUCTOR*/
    public Sic1idenpersPK(Integer idTipoiden, String codIden) {
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

    public String getDesTipoiden() {
        return desTipoiden;
    }

    public void setDesTipoiden(String desTipoiden) {
        this.desTipoiden = desTipoiden;
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
        if (!(object instanceof Sic1idenpersPK)) {
            return false;
        }
        Sic1idenpersPK other = (Sic1idenpersPK) object;
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
        return "com.general.entity.Sic1idenpersPK[ idTipoiden=" + idTipoiden + ", codIden=" + codIden + " ]";
    }
    
}
