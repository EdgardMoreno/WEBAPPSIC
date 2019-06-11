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
@Table(name = "SIC5EVENESTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sic5evenesta.findAll", query = "SELECT s FROM Sic5evenesta s")
    , @NamedQuery(name = "Sic5evenesta.findByIdPeri", query = "SELECT s FROM Sic5evenesta s WHERE s.sic5evenestaPK.idPeri = :idPeri")
    , @NamedQuery(name = "Sic5evenesta.findByIdEven", query = "SELECT s FROM Sic5evenesta s WHERE s.sic5evenestaPK.idEven = :idEven")
    , @NamedQuery(name = "Sic5evenesta.findByIdEstaeven", query = "SELECT s FROM Sic5evenesta s WHERE s.sic5evenestaPK.idEstaeven = :idEstaeven")
    , @NamedQuery(name = "Sic5evenesta.findByDesEstaeven", query = "SELECT s FROM Sic5evenesta s WHERE s.desEstaeven = :desEstaeven")
    , @NamedQuery(name = "Sic5evenesta.findByCodEstaeven", query = "SELECT s FROM Sic5evenesta s WHERE s.codEstaeven = :codEstaeven")
    , @NamedQuery(name = "Sic5evenesta.findByFecDesdeestaeven", query = "SELECT s FROM Sic5evenesta s WHERE s.fecDesdeestaeven = :fecDesdeestaeven")
    , @NamedQuery(name = "Sic5evenesta.findByFecHastaestaeven", query = "SELECT s FROM Sic5evenesta s WHERE s.fecHastaestaeven = :fecHastaestaeven")
    , @NamedQuery(name = "Sic5evenesta.findByNumDias", query = "SELECT s FROM Sic5evenesta s WHERE s.numDias = :numDias")
    , @NamedQuery(name = "Sic5evenesta.findByDesNotas", query = "SELECT s FROM Sic5evenesta s WHERE s.desNotas = :desNotas")
    , @NamedQuery(name = "Sic5evenesta.findByIdTarea", query = "SELECT s FROM Sic5evenesta s WHERE s.sic5evenestaPK.idTarea = :idTarea")
    , @NamedQuery(name = "Sic5evenesta.findByFecDesdetarea", query = "SELECT s FROM Sic5evenesta s WHERE s.fecDesdetarea = :fecDesdetarea")
    , @NamedQuery(name = "Sic5evenesta.findByIdTdettarea", query = "SELECT s FROM Sic5evenesta s WHERE s.idTdettarea = :idTdettarea")
    , @NamedQuery(name = "Sic5evenesta.findByDesTdettarea", query = "SELECT s FROM Sic5evenesta s WHERE s.desTdettarea = :desTdettarea")
    , @NamedQuery(name = "Sic5evenesta.findByCodTdettarea", query = "SELECT s FROM Sic5evenesta s WHERE s.codTdettarea = :codTdettarea")
    , @NamedQuery(name = "Sic5evenesta.findByDesTarea", query = "SELECT s FROM Sic5evenesta s WHERE s.desTarea = :desTarea")
    , @NamedQuery(name = "Sic5evenesta.findByFecVencimiento", query = "SELECT s FROM Sic5evenesta s WHERE s.fecVencimiento = :fecVencimiento")
    , @NamedQuery(name = "Sic5evenesta.findByIdTrelaeven", query = "SELECT s FROM Sic5evenesta s WHERE s.idTrelaeven = :idTrelaeven")
    , @NamedQuery(name = "Sic5evenesta.findByDesTrelaeven", query = "SELECT s FROM Sic5evenesta s WHERE s.desTrelaeven = :desTrelaeven")
    , @NamedQuery(name = "Sic5evenesta.findByCodTrelaeven", query = "SELECT s FROM Sic5evenesta s WHERE s.codTrelaeven = :codTrelaeven")
    , @NamedQuery(name = "Sic5evenesta.findByIdClaserela", query = "SELECT s FROM Sic5evenesta s WHERE s.idClaserela = :idClaserela")
    , @NamedQuery(name = "Sic5evenesta.findByDesClaserela", query = "SELECT s FROM Sic5evenesta s WHERE s.desClaserela = :desClaserela")
    , @NamedQuery(name = "Sic5evenesta.findByCodClaserela", query = "SELECT s FROM Sic5evenesta s WHERE s.codClaserela = :codClaserela")
    , @NamedQuery(name = "Sic5evenesta.findByIdTrolestaeven", query = "SELECT s FROM Sic5evenesta s WHERE s.idTrolestaeven = :idTrolestaeven")
    , @NamedQuery(name = "Sic5evenesta.findByDesTrolestaeven", query = "SELECT s FROM Sic5evenesta s WHERE s.desTrolestaeven = :desTrolestaeven")
    , @NamedQuery(name = "Sic5evenesta.findByCodTrolestaeven", query = "SELECT s FROM Sic5evenesta s WHERE s.codTrolestaeven = :codTrolestaeven")
    , @NamedQuery(name = "Sic5evenesta.findByCodSclaseeven", query = "SELECT s FROM Sic5evenesta s WHERE s.codSclaseeven = :codSclaseeven")
    , @NamedQuery(name = "Sic5evenesta.findByDesStipotarea", query = "SELECT s FROM Sic5evenesta s WHERE s.desStipotarea = :desStipotarea")
    , @NamedQuery(name = "Sic5evenesta.findByDesTipotarea", query = "SELECT s FROM Sic5evenesta s WHERE s.desTipotarea = :desTipotarea")
    , @NamedQuery(name = "Sic5evenesta.findByCodStipotarea", query = "SELECT s FROM Sic5evenesta s WHERE s.codStipotarea = :codStipotarea")
    , @NamedQuery(name = "Sic5evenesta.findByNumDiaplazo", query = "SELECT s FROM Sic5evenesta s WHERE s.numDiaplazo = :numDiaplazo")
    , @NamedQuery(name = "Sic5evenesta.findByFlgSileadmi", query = "SELECT s FROM Sic5evenesta s WHERE s.flgSileadmi = :flgSileadmi")
    , @NamedQuery(name = "Sic5evenesta.findByDesSileadmi", query = "SELECT s FROM Sic5evenesta s WHERE s.desSileadmi = :desSileadmi")
    , @NamedQuery(name = "Sic5evenesta.findByIdTipoinst", query = "SELECT s FROM Sic5evenesta s WHERE s.idTipoinst = :idTipoinst")
    , @NamedQuery(name = "Sic5evenesta.findByDesTipoinst", query = "SELECT s FROM Sic5evenesta s WHERE s.desTipoinst = :desTipoinst")
    , @NamedQuery(name = "Sic5evenesta.findByFlgEsentrante", query = "SELECT s FROM Sic5evenesta s WHERE s.flgEsentrante = :flgEsentrante")
    , @NamedQuery(name = "Sic5evenesta.findByFlgAcciampl", query = "SELECT s FROM Sic5evenesta s WHERE s.flgAcciampl = :flgAcciampl")
    , @NamedQuery(name = "Sic5evenesta.findByFlgAccireco", query = "SELECT s FROM Sic5evenesta s WHERE s.flgAccireco = :flgAccireco")
    , @NamedQuery(name = "Sic5evenesta.findByFlgAcciapel", query = "SELECT s FROM Sic5evenesta s WHERE s.flgAcciapel = :flgAcciapel")
    , @NamedQuery(name = "Sic5evenesta.findByFlgAccicorr", query = "SELECT s FROM Sic5evenesta s WHERE s.flgAccicorr = :flgAccicorr")
    , @NamedQuery(name = "Sic5evenesta.findByFlgAcciresp", query = "SELECT s FROM Sic5evenesta s WHERE s.flgAcciresp = :flgAcciresp")
    , @NamedQuery(name = "Sic5evenesta.findByFlgEliminado", query = "SELECT s FROM Sic5evenesta s WHERE s.flgEliminado = :flgEliminado")
    , @NamedQuery(name = "Sic5evenesta.findByFlgAcciescradic", query = "SELECT s FROM Sic5evenesta s WHERE s.flgAcciescradic = :flgAcciescradic")
    , @NamedQuery(name = "Sic5evenesta.findByFlgEmitcons", query = "SELECT s FROM Sic5evenesta s WHERE s.flgEmitcons = :flgEmitcons")
    , @NamedQuery(name = "Sic5evenesta.findByFlgPublica", query = "SELECT s FROM Sic5evenesta s WHERE s.flgPublica = :flgPublica")
    , @NamedQuery(name = "Sic5evenesta.findByFlgVisto", query = "SELECT s FROM Sic5evenesta s WHERE s.flgVisto = :flgVisto")
    , @NamedQuery(name = "Sic5evenesta.findByFlgRespsan", query = "SELECT s FROM Sic5evenesta s WHERE s.flgRespsan = :flgRespsan")
    , @NamedQuery(name = "Sic5evenesta.findByDesListDocu", query = "SELECT s FROM Sic5evenesta s WHERE s.desListDocu = :desListDocu")
    , @NamedQuery(name = "Sic5evenesta.findByFlgAccipago", query = "SELECT s FROM Sic5evenesta s WHERE s.flgAccipago = :flgAccipago")})
public class Sic5evenesta implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected Sic5evenestaPK sic5evenestaPK;
    @Size(max = 500)
    @Column(name = "DES_ESTAEVEN")
    private String desEstaeven;
    @Size(max = 50)
    @Column(name = "COD_ESTAEVEN")
    private String codEstaeven;
    @Column(name = "FEC_DESDEESTAEVEN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecDesdeestaeven;
    @Column(name = "FEC_HASTAESTAEVEN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecHastaestaeven;
    @Column(name = "NUM_DIAS")
    private Integer numDias;
    @Size(max = 4000)
    @Column(name = "DES_NOTAS")
    private String desNotas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FEC_DESDETAREA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecDesdetarea;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TDETTAREA")
    private BigInteger idTdettarea;
    @Size(max = 4000)
    @Column(name = "DES_TDETTAREA")
    private String desTdettarea;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "COD_TDETTAREA")
    private String codTdettarea;
    @Size(max = 4000)
    @Column(name = "DES_TAREA")
    private String desTarea;
    @Column(name = "FEC_VENCIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecVencimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TRELAEVEN")
    private BigInteger idTrelaeven;
    @Size(max = 250)
    @Column(name = "DES_TRELAEVEN")
    private String desTrelaeven;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "COD_TRELAEVEN")
    private String codTrelaeven;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CLASERELA")
    private BigInteger idClaserela;
    @Size(max = 500)
    @Column(name = "DES_CLASERELA")
    private String desClaserela;
    @Size(max = 50)
    @Column(name = "COD_CLASERELA")
    private String codClaserela;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TROLESTAEVEN")
    private BigInteger idTrolestaeven;
    @Size(max = 500)
    @Column(name = "DES_TROLESTAEVEN")
    private String desTrolestaeven;
    @Size(max = 50)
    @Column(name = "COD_TROLESTAEVEN")
    private String codTrolestaeven;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "COD_SCLASEEVEN")
    private String codSclaseeven;
    @Size(max = 500)
    @Column(name = "DES_STIPOTAREA")
    private String desStipotarea;
    @Size(max = 500)
    @Column(name = "DES_TIPOTAREA")
    private String desTipotarea;
    @Size(max = 50)
    @Column(name = "COD_STIPOTAREA")
    private String codStipotarea;
    @Column(name = "NUM_DIAPLAZO")
    private Integer numDiaplazo;
    @Column(name = "FLG_SILEADMI")
    private BigInteger flgSileadmi;
    @Size(max = 11)
    @Column(name = "DES_SILEADMI")
    private String desSileadmi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPOINST")
    private BigInteger idTipoinst;
    @Size(max = 500)
    @Column(name = "DES_TIPOINST")
    private String desTipoinst;
    @Column(name = "FLG_ESENTRANTE")
    private BigInteger flgEsentrante;
    @Column(name = "FLG_ACCIAMPL")
    private BigInteger flgAcciampl;
    @Column(name = "FLG_ACCIRECO")
    private BigInteger flgAccireco;
    @Column(name = "FLG_ACCIAPEL")
    private BigInteger flgAcciapel;
    @Column(name = "FLG_ACCICORR")
    private BigInteger flgAccicorr;
    @Column(name = "FLG_ACCIRESP")
    private BigInteger flgAcciresp;
    @Column(name = "FLG_ELIMINADO")
    private Short flgEliminado;
    @Column(name = "FLG_ACCIESCRADIC")
    private BigInteger flgAcciescradic;
    @Column(name = "FLG_EMITCONS")
    private BigInteger flgEmitcons;
    @Column(name = "FLG_PUBLICA")
    private BigInteger flgPublica;
    @Column(name = "FLG_VISTO")
    private BigInteger flgVisto;
    @Column(name = "FLG_RESPSAN")
    private BigInteger flgRespsan;
    @Size(max = 4000)
    @Column(name = "DES_LIST_DOCU")
    private String desListDocu;
    @Column(name = "FLG_ACCIPAGO")
    private BigInteger flgAccipago;

    /*Agregado*/
    private Sic1pers sic1pers;
    
    public Sic5evenesta() {
    }

    public Sic5evenesta(Sic5evenestaPK sic5evenestaPK) {
        this.sic5evenestaPK = sic5evenestaPK;
    }

    public Sic5evenesta(Sic5evenestaPK sic5evenestaPK, Date fecDesdetarea, BigInteger idTdettarea, String codTdettarea, BigInteger idTrelaeven, String codTrelaeven, BigInteger idClaserela, BigInteger idTrolestaeven, String codSclaseeven, BigInteger idTipoinst) {
        this.sic5evenestaPK = sic5evenestaPK;
        this.fecDesdetarea = fecDesdetarea;
        this.idTdettarea = idTdettarea;
        this.codTdettarea = codTdettarea;
        this.idTrelaeven = idTrelaeven;
        this.codTrelaeven = codTrelaeven;
        this.idClaserela = idClaserela;
        this.idTrolestaeven = idTrolestaeven;
        this.codSclaseeven = codSclaseeven;
        this.idTipoinst = idTipoinst;
    }

    public Sic5evenesta(Integer idPeri, BigInteger idEven, Integer idEstaeven, BigInteger idTarea) {
        this.sic5evenestaPK = new Sic5evenestaPK(idPeri, idEven, idEstaeven, idTarea);
    }

    public Sic5evenestaPK getSic5evenestaPK() {
        return sic5evenestaPK;
    }

    public void setSic5evenestaPK(Sic5evenestaPK sic5evenestaPK) {
        this.sic5evenestaPK = sic5evenestaPK;
    }

    public String getDesEstaeven() {
        return desEstaeven;
    }

    public void setDesEstaeven(String desEstaeven) {
        this.desEstaeven = desEstaeven;
    }

    public String getCodEstaeven() {
        return codEstaeven;
    }

    public void setCodEstaeven(String codEstaeven) {
        this.codEstaeven = codEstaeven;
    }

    public Date getFecDesdeestaeven() {
        return fecDesdeestaeven;
    }

    public void setFecDesdeestaeven(Date fecDesdeestaeven) {
        this.fecDesdeestaeven = fecDesdeestaeven;
    }

    public Date getFecHastaestaeven() {
        return fecHastaestaeven;
    }

    public void setFecHastaestaeven(Date fecHastaestaeven) {
        this.fecHastaestaeven = fecHastaestaeven;
    }

    public Integer getNumDias() {
        return numDias;
    }

    public void setNumDias(Integer numDias) {
        this.numDias = numDias;
    }

    public String getDesNotas() {
        return desNotas;
    }

    public void setDesNotas(String desNotas) {
        this.desNotas = desNotas;
    }

    public Date getFecDesdetarea() {
        return fecDesdetarea;
    }

    public void setFecDesdetarea(Date fecDesdetarea) {
        this.fecDesdetarea = fecDesdetarea;
    }

    public BigInteger getIdTdettarea() {
        return idTdettarea;
    }

    public void setIdTdettarea(BigInteger idTdettarea) {
        this.idTdettarea = idTdettarea;
    }

    public String getDesTdettarea() {
        return desTdettarea;
    }

    public void setDesTdettarea(String desTdettarea) {
        this.desTdettarea = desTdettarea;
    }

    public String getCodTdettarea() {
        return codTdettarea;
    }

    public void setCodTdettarea(String codTdettarea) {
        this.codTdettarea = codTdettarea;
    }

    public String getDesTarea() {
        return desTarea;
    }

    public void setDesTarea(String desTarea) {
        this.desTarea = desTarea;
    }

    public Date getFecVencimiento() {
        return fecVencimiento;
    }

    public void setFecVencimiento(Date fecVencimiento) {
        this.fecVencimiento = fecVencimiento;
    }

    public BigInteger getIdTrelaeven() {
        return idTrelaeven;
    }

    public void setIdTrelaeven(BigInteger idTrelaeven) {
        this.idTrelaeven = idTrelaeven;
    }

    public String getDesTrelaeven() {
        return desTrelaeven;
    }

    public void setDesTrelaeven(String desTrelaeven) {
        this.desTrelaeven = desTrelaeven;
    }

    public String getCodTrelaeven() {
        return codTrelaeven;
    }

    public void setCodTrelaeven(String codTrelaeven) {
        this.codTrelaeven = codTrelaeven;
    }

    public BigInteger getIdClaserela() {
        return idClaserela;
    }

    public void setIdClaserela(BigInteger idClaserela) {
        this.idClaserela = idClaserela;
    }

    public String getDesClaserela() {
        return desClaserela;
    }

    public void setDesClaserela(String desClaserela) {
        this.desClaserela = desClaserela;
    }

    public String getCodClaserela() {
        return codClaserela;
    }

    public void setCodClaserela(String codClaserela) {
        this.codClaserela = codClaserela;
    }

    public BigInteger getIdTrolestaeven() {
        return idTrolestaeven;
    }

    public void setIdTrolestaeven(BigInteger idTrolestaeven) {
        this.idTrolestaeven = idTrolestaeven;
    }

    public String getDesTrolestaeven() {
        return desTrolestaeven;
    }

    public void setDesTrolestaeven(String desTrolestaeven) {
        this.desTrolestaeven = desTrolestaeven;
    }

    public String getCodTrolestaeven() {
        return codTrolestaeven;
    }

    public void setCodTrolestaeven(String codTrolestaeven) {
        this.codTrolestaeven = codTrolestaeven;
    }

    public String getCodSclaseeven() {
        return codSclaseeven;
    }

    public void setCodSclaseeven(String codSclaseeven) {
        this.codSclaseeven = codSclaseeven;
    }

    public String getDesStipotarea() {
        return desStipotarea;
    }

    public void setDesStipotarea(String desStipotarea) {
        this.desStipotarea = desStipotarea;
    }

    public String getDesTipotarea() {
        return desTipotarea;
    }

    public void setDesTipotarea(String desTipotarea) {
        this.desTipotarea = desTipotarea;
    }

    public String getCodStipotarea() {
        return codStipotarea;
    }

    public void setCodStipotarea(String codStipotarea) {
        this.codStipotarea = codStipotarea;
    }

    public Integer getNumDiaplazo() {
        return numDiaplazo;
    }

    public void setNumDiaplazo(Integer numDiaplazo) {
        this.numDiaplazo = numDiaplazo;
    }

    public BigInteger getFlgSileadmi() {
        return flgSileadmi;
    }

    public void setFlgSileadmi(BigInteger flgSileadmi) {
        this.flgSileadmi = flgSileadmi;
    }

    public String getDesSileadmi() {
        return desSileadmi;
    }

    public void setDesSileadmi(String desSileadmi) {
        this.desSileadmi = desSileadmi;
    }

    public BigInteger getIdTipoinst() {
        return idTipoinst;
    }

    public void setIdTipoinst(BigInteger idTipoinst) {
        this.idTipoinst = idTipoinst;
    }

    public String getDesTipoinst() {
        return desTipoinst;
    }

    public void setDesTipoinst(String desTipoinst) {
        this.desTipoinst = desTipoinst;
    }

    public BigInteger getFlgEsentrante() {
        return flgEsentrante;
    }

    public void setFlgEsentrante(BigInteger flgEsentrante) {
        this.flgEsentrante = flgEsentrante;
    }

    public BigInteger getFlgAcciampl() {
        return flgAcciampl;
    }

    public void setFlgAcciampl(BigInteger flgAcciampl) {
        this.flgAcciampl = flgAcciampl;
    }

    public BigInteger getFlgAccireco() {
        return flgAccireco;
    }

    public void setFlgAccireco(BigInteger flgAccireco) {
        this.flgAccireco = flgAccireco;
    }

    public BigInteger getFlgAcciapel() {
        return flgAcciapel;
    }

    public void setFlgAcciapel(BigInteger flgAcciapel) {
        this.flgAcciapel = flgAcciapel;
    }

    public BigInteger getFlgAccicorr() {
        return flgAccicorr;
    }

    public void setFlgAccicorr(BigInteger flgAccicorr) {
        this.flgAccicorr = flgAccicorr;
    }

    public BigInteger getFlgAcciresp() {
        return flgAcciresp;
    }

    public void setFlgAcciresp(BigInteger flgAcciresp) {
        this.flgAcciresp = flgAcciresp;
    }

    public Short getFlgEliminado() {
        return flgEliminado;
    }

    public void setFlgEliminado(Short flgEliminado) {
        this.flgEliminado = flgEliminado;
    }

    public BigInteger getFlgAcciescradic() {
        return flgAcciescradic;
    }

    public void setFlgAcciescradic(BigInteger flgAcciescradic) {
        this.flgAcciescradic = flgAcciescradic;
    }

    public BigInteger getFlgEmitcons() {
        return flgEmitcons;
    }

    public void setFlgEmitcons(BigInteger flgEmitcons) {
        this.flgEmitcons = flgEmitcons;
    }

    public BigInteger getFlgPublica() {
        return flgPublica;
    }

    public void setFlgPublica(BigInteger flgPublica) {
        this.flgPublica = flgPublica;
    }

    public BigInteger getFlgVisto() {
        return flgVisto;
    }

    public void setFlgVisto(BigInteger flgVisto) {
        this.flgVisto = flgVisto;
    }

    public BigInteger getFlgRespsan() {
        return flgRespsan;
    }

    public void setFlgRespsan(BigInteger flgRespsan) {
        this.flgRespsan = flgRespsan;
    }

    public String getDesListDocu() {
        return desListDocu;
    }

    public void setDesListDocu(String desListDocu) {
        this.desListDocu = desListDocu;
    }

    public BigInteger getFlgAccipago() {
        return flgAccipago;
    }

    public void setFlgAccipago(BigInteger flgAccipago) {
        this.flgAccipago = flgAccipago;
    }

    public Sic1pers getSic1pers() {
        return sic1pers;
    }

    public void setSic1pers(Sic1pers sic1pers) {
        this.sic1pers = sic1pers;
    }    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sic5evenestaPK != null ? sic5evenestaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sic5evenesta)) {
            return false;
        }
        Sic5evenesta other = (Sic5evenesta) object;
        if ((this.sic5evenestaPK == null && other.sic5evenestaPK != null) || (this.sic5evenestaPK != null && !this.sic5evenestaPK.equals(other.sic5evenestaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.general.entity.Sic5evenesta[ sic5evenestaPK=" + sic5evenestaPK + " ]";
    }
    
}
