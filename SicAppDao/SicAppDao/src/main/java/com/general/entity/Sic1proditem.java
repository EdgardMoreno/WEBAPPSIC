/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.entity;

import com.general.util.beans.ComprobantePago;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author emoreno
 */
@Entity
@Table(name = "SIC1PRODITEM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sic1proditem.findAll", query = "SELECT s FROM Sic1proditem s")
    , @NamedQuery(name = "Sic1proditem.findByIdProditem", query = "SELECT s FROM Sic1proditem s WHERE s.idProditem = :idProditem")
    , @NamedQuery(name = "Sic1proditem.findByDesProditem", query = "SELECT s FROM Sic1proditem s WHERE s.desProditem = :desProditem")
    , @NamedQuery(name = "Sic1proditem.findByFecFabr", query = "SELECT s FROM Sic1proditem s WHERE s.fecFabr = :fecFabr")
    , @NamedQuery(name = "Sic1proditem.findByCodProditem", query = "SELECT s FROM Sic1proditem s WHERE s.codProditem = :codProditem")
    , @NamedQuery(name = "Sic1proditem.findByNumSerie", query = "SELECT s FROM Sic1proditem s WHERE s.numSerie = :numSerie")
    , @NamedQuery(name = "Sic1proditem.findByCodIden", query = "SELECT s FROM Sic1proditem s WHERE s.codIden = :codIden")
    , @NamedQuery(name = "Sic1proditem.findByNumTerm", query = "SELECT s FROM Sic1proditem s WHERE s.numTerm = :numTerm")
    , @NamedQuery(name = "Sic1proditem.findByIdUbic", query = "SELECT s FROM Sic1proditem s WHERE s.idUbic = :idUbic")
    , @NamedQuery(name = "Sic1proditem.findByNumFoli", query = "SELECT s FROM Sic1proditem s WHERE s.numFoli = :numFoli")
    , @NamedQuery(name = "Sic1proditem.findByIdTipodocupag", query = "SELECT s FROM Sic1proditem s WHERE s.idTipodocupag = :idTipodocupag")
    , @NamedQuery(name = "Sic1proditem.findByNumComp", query = "SELECT s FROM Sic1proditem s WHERE s.numComp = :numComp")
    , @NamedQuery(name = "Sic1proditem.findByNumMtprin", query = "SELECT s FROM Sic1proditem s WHERE s.numMtprin = :numMtprin")
    , @NamedQuery(name = "Sic1proditem.findByCodRegimode", query = "SELECT s FROM Sic1proditem s WHERE s.codRegimode = :codRegimode")
    , @NamedQuery(name = "Sic1proditem.findByIdPersfabr", query = "SELECT s FROM Sic1proditem s WHERE s.idPersfabr = :idPersfabr")
    , @NamedQuery(name = "Sic1proditem.findByIdPersensa", query = "SELECT s FROM Sic1proditem s WHERE s.idPersensa = :idPersensa")
    , @NamedQuery(name = "Sic1proditem.findByIdPersadmin", query = "SELECT s FROM Sic1proditem s WHERE s.idPersadmin = :idPersadmin")
    , @NamedQuery(name = "Sic1proditem.findByCodCodiauto", query = "SELECT s FROM Sic1proditem s WHERE s.codCodiauto = :codCodiauto")
    , @NamedQuery(name = "Sic1proditem.findByIdSala", query = "SELECT s FROM Sic1proditem s WHERE s.idSala = :idSala")
    , @NamedQuery(name = "Sic1proditem.findByIdTipomaq", query = "SELECT s FROM Sic1proditem s WHERE s.idTipomaq = :idTipomaq")
    , @NamedQuery(name = "Sic1proditem.findByCodIdenmode", query = "SELECT s FROM Sic1proditem s WHERE s.codIdenmode = :codIdenmode")})
public class Sic1proditem implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PRODITEM")
    private BigDecimal idProditem;
    @Column(name = "DES_PRODITEM")
    private String desProditem;
    @Column(name = "FEC_FABR")
    private String fecFabr;
    @Column(name = "COD_PRODITEM")
    private String codProditem;
    @Column(name = "NUM_SERIE")
    private String numSerie;
    @Column(name = "COD_IDEN")
    private String codIden;
    @Column(name = "NUM_TERM")
    private Integer numTerm;
    @Column(name = "ID_UBIC")
    private Integer idUbic;
    @Column(name = "NUM_FOLI")
    private String numFoli;
    @Column(name = "ID_TIPODOCUPAG")
    private Integer idTipodocupag;
    @Column(name = "NUM_COMP")
    private String numComp;
    @Column(name = "NUM_MTPRIN")
    private String numMtprin;
    @Column(name = "COD_REGIMODE")
    private String codRegimode;
    @Column(name = "ID_PERSFABR")
    private Integer idPersfabr;
    @Column(name = "ID_PERSENSA")
    private Integer idPersensa;
    @Column(name = "ID_PERSADMIN")
    private Integer idPersadmin;
    @Column(name = "COD_CODIAUTO")
    private String codCodiauto;
    @Column(name = "ID_SALA")
    private Integer idSala;
    @Column(name = "ID_TIPOMAQ")
    private Integer idTipomaq;
    @Column(name = "COD_IDENMODE")
    private String codIdenmode;
    @JoinColumn(name = "ID_PROD", referencedColumnName = "ID_PROD")
    @ManyToOne
    private Sic1prod idProd;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sic1proditem")
    private Collection<Sic3proditempers> sic3proditempersCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sic1proditem")
    private Collection<Sic3proditemdocu> sic3proditemdocuCollection;

    
    /*AGREGADOS*/
    private String desTipomaq;
    private String desPersadmin; //Nombre del administrado que registro el bien
    private String desPersfab;
    private Sic1codiauto sic1codiauto;
    private ComprobantePago compPago;
    
    
    /*CONSTRUCTOR*/
    public Sic1proditem() {
    }

    /*METODOS*/
    public Sic1proditem(BigDecimal idProditem) {
        this.idProditem = idProditem;
    }

    public BigDecimal getIdProditem() {
        return idProditem;
    }

    public void setIdProditem(BigDecimal idProditem) {
        this.idProditem = idProditem;
    }

    public String getDesProditem() {
        return desProditem;
    }

    public void setDesProditem(String desProditem) {
        this.desProditem = desProditem;
    }

    public String getFecFabr() {
        return fecFabr;
    }

    public void setFecFabr(String fecFabr) {
        this.fecFabr = fecFabr;
    }

    public String getCodProditem() {
        return codProditem;
    }

    public void setCodProditem(String codProditem) {
        this.codProditem = codProditem;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public String getCodIden() {
        return codIden;
    }

    public void setCodIden(String codIden) {
        this.codIden = codIden;
    }

    public Integer getNumTerm() {
        return numTerm;
    }

    public void setNumTerm(Integer numTerm) {
        this.numTerm = numTerm;
    }

    public Integer getIdUbic() {
        return idUbic;
    }

    public void setIdUbic(Integer idUbic) {
        this.idUbic = idUbic;
    }

    public String getNumFoli() {
        return numFoli;
    }

    public void setNumFoli(String numFoli) {
        this.numFoli = numFoli;
    }

    public Integer getIdTipodocupag() {
        return idTipodocupag;
    }

    public void setIdTipodocupag(Integer idTipodocupag) {
        this.idTipodocupag = idTipodocupag;
    }

    public String getNumComp() {
        return numComp;
    }

    public void setNumComp(String numComp) {
        this.numComp = numComp;
    }

    public String getNumMtprin() {
        return numMtprin;
    }

    public void setNumMtprin(String numMtprin) {
        this.numMtprin = numMtprin;
    }

    public String getCodRegimode() {
        return codRegimode;
    }

    public void setCodRegimode(String codRegimode) {
        this.codRegimode = codRegimode;
    }

    public Integer getIdPersfabr() {
        return idPersfabr;
    }

    public void setIdPersfabr(Integer idPersfabr) {
        this.idPersfabr = idPersfabr;
    }

    public Integer getIdPersensa() {
        return idPersensa;
    }

    public void setIdPersensa(Integer idPersensa) {
        this.idPersensa = idPersensa;
    }

    public Integer getIdPersadmin() {
        return idPersadmin;
    }

    public void setIdPersadmin(Integer idPersadmin) {
        this.idPersadmin = idPersadmin;
    }

    public String getCodCodiauto() {
        return codCodiauto;
    }

    public void setCodCodiauto(String codCodiauto) {
        this.codCodiauto = codCodiauto;
    }

    public Integer getIdSala() {
        return idSala;
    }

    public void setIdSala(Integer idSala) {
        this.idSala = idSala;
    }

    public Integer getIdTipomaq() {
        return idTipomaq;
    }

    public void setIdTipomaq(Integer idTipomaq) {
        this.idTipomaq = idTipomaq;
    }

    public String getCodIdenmode() {
        return codIdenmode;
    }

    public void setCodIdenmode(String codIdenmode) {
        this.codIdenmode = codIdenmode;
    }

    public Sic1prod getIdProd() {
        return idProd;
    }

    public void setIdProd(Sic1prod idProd) {
        this.idProd = idProd;
    }

    public String getDesTipomaq() {
        return desTipomaq;
    }

    public void setDesTipomaq(String desTipomaq) {
        this.desTipomaq = desTipomaq;
    }

    public String getDesPersadmin() {
        return desPersadmin;
    }

    public void setDesPersadmin(String desPersadmin) {
        this.desPersadmin = desPersadmin;
    }

    public String getDesPersfab() {
        return desPersfab;
    }

    public void setDesPersfab(String desPersfab) {
        this.desPersfab = desPersfab;
    }

    public Sic1codiauto getSic1codiauto() {
        return sic1codiauto;
    }

    public ComprobantePago getCompPago() {
        return compPago;
    }

    public void setCompPago(ComprobantePago compPago) {
        this.compPago = compPago;
    }   
    

    public void setSic1codiauto(Sic1codiauto sic1codiauto) {
        this.sic1codiauto = sic1codiauto;
    }

    @XmlTransient
    public Collection<Sic3proditempers> getSic3proditempersCollection() {
        return sic3proditempersCollection;
    }

    public void setSic3proditempersCollection(Collection<Sic3proditempers> sic3proditempersCollection) {
        this.sic3proditempersCollection = sic3proditempersCollection;
    }

    @XmlTransient
    public Collection<Sic3proditemdocu> getSic3proditemdocuCollection() {
        return sic3proditemdocuCollection;
    }

    public void setSic3proditemdocuCollection(Collection<Sic3proditemdocu> sic3proditemdocuCollection) {
        this.sic3proditemdocuCollection = sic3proditemdocuCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProditem != null ? idProditem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sic1proditem)) {
            return false;
        }
        Sic1proditem other = (Sic1proditem) object;
        if ((this.idProditem == null && other.idProditem != null) || (this.idProditem != null && !this.idProditem.equals(other.idProditem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.general.entity.Sic1proditem[ idProditem=" + idProditem + " ]";
    }
    
}
