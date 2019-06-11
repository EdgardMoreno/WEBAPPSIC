/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author emoreno
 */
@Entity
@Table(name = "SIC1PRODPROG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sic1prodprog.findAll", query = "SELECT s FROM Sic1prodprog s")
    , @NamedQuery(name = "Sic1prodprog.findByIdProdprog", query = "SELECT s FROM Sic1prodprog s WHERE s.idProdprog = :idProdprog")
    , @NamedQuery(name = "Sic1prodprog.findByNumPorcretomin", query = "SELECT s FROM Sic1prodprog s WHERE s.numPorcretomin = :numPorcretomin")
    , @NamedQuery(name = "Sic1prodprog.findByNumPorcretomax", query = "SELECT s FROM Sic1prodprog s WHERE s.numPorcretomax = :numPorcretomax")})
public class Sic1prodprog implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PRODPROG")
    private BigDecimal idProdprog;
    @Column(name = "NUM_PORCRETOMIN")
    private BigDecimal numPorcretomin;
    @Column(name = "NUM_PORCRETOMAX")
    private BigDecimal numPorcretomax;

    public Sic1prodprog() {
    }

    public Sic1prodprog(BigDecimal idProdprog) {
        this.idProdprog = idProdprog;
    }

    public BigDecimal getIdProdprog() {
        return idProdprog;
    }

    public void setIdProdprog(BigDecimal idProdprog) {
        this.idProdprog = idProdprog;
    }

    public BigDecimal getNumPorcretomin() {
        return numPorcretomin;
    }

    public void setNumPorcretomin(BigDecimal numPorcretomin) {
        this.numPorcretomin = numPorcretomin;
    }

    public BigDecimal getNumPorcretomax() {
        return numPorcretomax;
    }

    public void setNumPorcretomax(BigDecimal numPorcretomax) {
        this.numPorcretomax = numPorcretomax;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProdprog != null ? idProdprog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sic1prodprog)) {
            return false;
        }
        Sic1prodprog other = (Sic1prodprog) object;
        if ((this.idProdprog == null && other.idProdprog != null) || (this.idProdprog != null && !this.idProdprog.equals(other.idProdprog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.general.entity.Sic1prodprog[ idProdprog=" + idProdprog + " ]";
    }
    
}
