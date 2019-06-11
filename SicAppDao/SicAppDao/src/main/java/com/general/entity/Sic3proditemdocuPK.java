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

/**
 *
 * @author emoreno
 */
@Embeddable
public class Sic3proditemdocuPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ID_PRODITEM")
    private BigInteger idProditem;
    @Basic(optional = false)
    @Column(name = "ID_TRELAPRODITEM")
    private BigInteger idTrelaproditem;
    @Basic(optional = false)
    @Column(name = "ID_DOCU")
    private BigInteger idDocu;

    public Sic3proditemdocuPK() {
    }

    public Sic3proditemdocuPK(BigInteger idProditem, BigInteger idTrelaproditem, BigInteger idDocu) {
        this.idProditem = idProditem;
        this.idTrelaproditem = idTrelaproditem;
        this.idDocu = idDocu;
    }

    public BigInteger getIdProditem() {
        return idProditem;
    }

    public void setIdProditem(BigInteger idProditem) {
        this.idProditem = idProditem;
    }

    public BigInteger getIdTrelaproditem() {
        return idTrelaproditem;
    }

    public void setIdTrelaproditem(BigInteger idTrelaproditem) {
        this.idTrelaproditem = idTrelaproditem;
    }

    public BigInteger getIdDocu() {
        return idDocu;
    }

    public void setIdDocu(BigInteger idDocu) {
        this.idDocu = idDocu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProditem != null ? idProditem.hashCode() : 0);
        hash += (idTrelaproditem != null ? idTrelaproditem.hashCode() : 0);
        hash += (idDocu != null ? idDocu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sic3proditemdocuPK)) {
            return false;
        }
        Sic3proditemdocuPK other = (Sic3proditemdocuPK) object;
        if ((this.idProditem == null && other.idProditem != null) || (this.idProditem != null && !this.idProditem.equals(other.idProditem))) {
            return false;
        }
        if ((this.idTrelaproditem == null && other.idTrelaproditem != null) || (this.idTrelaproditem != null && !this.idTrelaproditem.equals(other.idTrelaproditem))) {
            return false;
        }
        if ((this.idDocu == null && other.idDocu != null) || (this.idDocu != null && !this.idDocu.equals(other.idDocu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.general.entity.Sic3proditemdocuPK[ idProditem=" + idProditem + ", idTrelaproditem=" + idTrelaproditem + ", idDocu=" + idDocu + " ]";
    }
    
}
