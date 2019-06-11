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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "SIC5EVENSOLI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sic5evensoli.findAll", query = "SELECT s FROM Sic5evensoli s")
    , @NamedQuery(name = "Sic5evensoli.findByCodExpe", query = "SELECT s FROM Sic5evensoli s WHERE s.codExpe = :codExpe")
    , @NamedQuery(name = "Sic5evensoli.findByIdEven", query = "SELECT s FROM Sic5evensoli s WHERE s.idEven = :idEven")
    , @NamedQuery(name = "Sic5evensoli.findByDesEven", query = "SELECT s FROM Sic5evensoli s WHERE s.desEven = :desEven")
    , @NamedQuery(name = "Sic5evensoli.findByFecCreacion", query = "SELECT s FROM Sic5evensoli s WHERE s.fecCreacion = :fecCreacion")
    , @NamedQuery(name = "Sic5evensoli.findByIdModocrea", query = "SELECT s FROM Sic5evensoli s WHERE s.idModocrea = :idModocrea")
    , @NamedQuery(name = "Sic5evensoli.findByDesModocrea", query = "SELECT s FROM Sic5evensoli s WHERE s.desModocrea = :desModocrea")
    , @NamedQuery(name = "Sic5evensoli.findByCodModocrea", query = "SELECT s FROM Sic5evensoli s WHERE s.codModocrea = :codModocrea")
    , @NamedQuery(name = "Sic5evensoli.findByIdPers", query = "SELECT s FROM Sic5evensoli s WHERE s.idPers = :idPers")
    , @NamedQuery(name = "Sic5evensoli.findByDesPers", query = "SELECT s FROM Sic5evensoli s WHERE s.desPers = :desPers")
    , @NamedQuery(name = "Sic5evensoli.findByIdPerscreador", query = "SELECT s FROM Sic5evensoli s WHERE s.idPerscreador = :idPerscreador")
    , @NamedQuery(name = "Sic5evensoli.findByDesPerscreador", query = "SELECT s FROM Sic5evensoli s WHERE s.desPerscreador = :desPerscreador")
    , @NamedQuery(name = "Sic5evensoli.findByIdTrolpers", query = "SELECT s FROM Sic5evensoli s WHERE s.idTrolpers = :idTrolpers")
    , @NamedQuery(name = "Sic5evensoli.findByDesTrolpers", query = "SELECT s FROM Sic5evensoli s WHERE s.desTrolpers = :desTrolpers")
    , @NamedQuery(name = "Sic5evensoli.findByIdTrolperscreador", query = "SELECT s FROM Sic5evensoli s WHERE s.idTrolperscreador = :idTrolperscreador")
    , @NamedQuery(name = "Sic5evensoli.findByDesTrolperscreador", query = "SELECT s FROM Sic5evensoli s WHERE s.desTrolperscreador = :desTrolperscreador")
    , @NamedQuery(name = "Sic5evensoli.findByIdStipoeven", query = "SELECT s FROM Sic5evensoli s WHERE s.idStipoeven = :idStipoeven")
    , @NamedQuery(name = "Sic5evensoli.findByDesStipoeven", query = "SELECT s FROM Sic5evensoli s WHERE s.desStipoeven = :desStipoeven")
    , @NamedQuery(name = "Sic5evensoli.findByCodStipoeven", query = "SELECT s FROM Sic5evensoli s WHERE s.codStipoeven = :codStipoeven")
    , @NamedQuery(name = "Sic5evensoli.findByIdTipoeven", query = "SELECT s FROM Sic5evensoli s WHERE s.idTipoeven = :idTipoeven")
    , @NamedQuery(name = "Sic5evensoli.findByDesTipoeven", query = "SELECT s FROM Sic5evensoli s WHERE s.desTipoeven = :desTipoeven")
    , @NamedQuery(name = "Sic5evensoli.findByCodTipoeven", query = "SELECT s FROM Sic5evensoli s WHERE s.codTipoeven = :codTipoeven")
    , @NamedQuery(name = "Sic5evensoli.findByIdMotieven", query = "SELECT s FROM Sic5evensoli s WHERE s.idMotieven = :idMotieven")
    , @NamedQuery(name = "Sic5evensoli.findByDesMotieven", query = "SELECT s FROM Sic5evensoli s WHERE s.desMotieven = :desMotieven")
    , @NamedQuery(name = "Sic5evensoli.findByCodMotieven", query = "SELECT s FROM Sic5evensoli s WHERE s.codMotieven = :codMotieven")
    , @NamedQuery(name = "Sic5evensoli.findByIdMedicomu", query = "SELECT s FROM Sic5evensoli s WHERE s.idMedicomu = :idMedicomu")
    , @NamedQuery(name = "Sic5evensoli.findByDesMedicomu", query = "SELECT s FROM Sic5evensoli s WHERE s.desMedicomu = :desMedicomu")
    , @NamedQuery(name = "Sic5evensoli.findByCodMedicomu", query = "SELECT s FROM Sic5evensoli s WHERE s.codMedicomu = :codMedicomu")
    , @NamedQuery(name = "Sic5evensoli.findByIdSclaseeven", query = "SELECT s FROM Sic5evensoli s WHERE s.idSclaseeven = :idSclaseeven")
    , @NamedQuery(name = "Sic5evensoli.findByDesSclaseeven", query = "SELECT s FROM Sic5evensoli s WHERE s.desSclaseeven = :desSclaseeven")
    , @NamedQuery(name = "Sic5evensoli.findByCodSclaseeven", query = "SELECT s FROM Sic5evensoli s WHERE s.codSclaseeven = :codSclaseeven")
    , @NamedQuery(name = "Sic5evensoli.findByIdTipoformato", query = "SELECT s FROM Sic5evensoli s WHERE s.idTipoformato = :idTipoformato")
    , @NamedQuery(name = "Sic5evensoli.findByDesTipoformato", query = "SELECT s FROM Sic5evensoli s WHERE s.desTipoformato = :desTipoformato")
    , @NamedQuery(name = "Sic5evensoli.findByCodTipoformato", query = "SELECT s FROM Sic5evensoli s WHERE s.codTipoformato = :codTipoformato")
    , @NamedQuery(name = "Sic5evensoli.findByIdTiposoli", query = "SELECT s FROM Sic5evensoli s WHERE s.idTiposoli = :idTiposoli")
    , @NamedQuery(name = "Sic5evensoli.findByDesTiposoli", query = "SELECT s FROM Sic5evensoli s WHERE s.desTiposoli = :desTiposoli")
    , @NamedQuery(name = "Sic5evensoli.findByCodTiposoli", query = "SELECT s FROM Sic5evensoli s WHERE s.codTiposoli = :codTiposoli")
    , @NamedQuery(name = "Sic5evensoli.findByIdClaseeven", query = "SELECT s FROM Sic5evensoli s WHERE s.idClaseeven = :idClaseeven")
    , @NamedQuery(name = "Sic5evensoli.findByDesClaseeven", query = "SELECT s FROM Sic5evensoli s WHERE s.desClaseeven = :desClaseeven")
    , @NamedQuery(name = "Sic5evensoli.findByCodClaseeven", query = "SELECT s FROM Sic5evensoli s WHERE s.codClaseeven = :codClaseeven")
    , @NamedQuery(name = "Sic5evensoli.findByDesNotassclaseeven", query = "SELECT s FROM Sic5evensoli s WHERE s.desNotassclaseeven = :desNotassclaseeven")
    , @NamedQuery(name = "Sic5evensoli.findByFecDesde", query = "SELECT s FROM Sic5evensoli s WHERE s.fecDesde = :fecDesde")
    , @NamedQuery(name = "Sic5evensoli.findByFecHasta", query = "SELECT s FROM Sic5evensoli s WHERE s.fecHasta = :fecHasta")
    , @NamedQuery(name = "Sic5evensoli.findByDesNotas", query = "SELECT s FROM Sic5evensoli s WHERE s.desNotas = :desNotas")
    , @NamedQuery(name = "Sic5evensoli.findByNumInstbpm", query = "SELECT s FROM Sic5evensoli s WHERE s.numInstbpm = :numInstbpm")
    , @NamedQuery(name = "Sic5evensoli.findByDesNotasminc", query = "SELECT s FROM Sic5evensoli s WHERE s.desNotasminc = :desNotasminc")
    , @NamedQuery(name = "Sic5evensoli.findByDesNotasadmi", query = "SELECT s FROM Sic5evensoli s WHERE s.desNotasadmi = :desNotasadmi")
    , @NamedQuery(name = "Sic5evensoli.findByDesNotasempl", query = "SELECT s FROM Sic5evensoli s WHERE s.desNotasempl = :desNotasempl")
    , @NamedQuery(name = "Sic5evensoli.findByIdEstaeven", query = "SELECT s FROM Sic5evensoli s WHERE s.idEstaeven = :idEstaeven")
    , @NamedQuery(name = "Sic5evensoli.findByDesEstaeven", query = "SELECT s FROM Sic5evensoli s WHERE s.desEstaeven = :desEstaeven")
    , @NamedQuery(name = "Sic5evensoli.findByFecDesdeesta", query = "SELECT s FROM Sic5evensoli s WHERE s.fecDesdeesta = :fecDesdeesta")
    , @NamedQuery(name = "Sic5evensoli.findByFecHastaesta", query = "SELECT s FROM Sic5evensoli s WHERE s.fecHastaesta = :fecHastaesta")
    , @NamedQuery(name = "Sic5evensoli.findByCodEstaeven", query = "SELECT s FROM Sic5evensoli s WHERE s.codEstaeven = :codEstaeven")
    , @NamedQuery(name = "Sic5evensoli.findByDesNotasevenesta", query = "SELECT s FROM Sic5evensoli s WHERE s.desNotasevenesta = :desNotasevenesta")
    , @NamedQuery(name = "Sic5evensoli.findByIdTrolestaeven", query = "SELECT s FROM Sic5evensoli s WHERE s.idTrolestaeven = :idTrolestaeven")
    , @NamedQuery(name = "Sic5evensoli.findByDesTrolestaeven", query = "SELECT s FROM Sic5evensoli s WHERE s.desTrolestaeven = :desTrolestaeven")
    , @NamedQuery(name = "Sic5evensoli.findByCodTrolestaeven", query = "SELECT s FROM Sic5evensoli s WHERE s.codTrolestaeven = :codTrolestaeven")
    , @NamedQuery(name = "Sic5evensoli.findByDesTrelaeven", query = "SELECT s FROM Sic5evensoli s WHERE s.desTrelaeven = :desTrelaeven")
    , @NamedQuery(name = "Sic5evensoli.findByIdClaserela", query = "SELECT s FROM Sic5evensoli s WHERE s.idClaserela = :idClaserela")
    , @NamedQuery(name = "Sic5evensoli.findByDesClaserela", query = "SELECT s FROM Sic5evensoli s WHERE s.desClaserela = :desClaserela")
    , @NamedQuery(name = "Sic5evensoli.findByNumDiaplazo", query = "SELECT s FROM Sic5evensoli s WHERE s.numDiaplazo = :numDiaplazo")
    , @NamedQuery(name = "Sic5evensoli.findByFlgSileadmi", query = "SELECT s FROM Sic5evensoli s WHERE s.flgSileadmi = :flgSileadmi")
    , @NamedQuery(name = "Sic5evensoli.findByDesSileadmi", query = "SELECT s FROM Sic5evensoli s WHERE s.desSileadmi = :desSileadmi")
    , @NamedQuery(name = "Sic5evensoli.findByNumCantproc", query = "SELECT s FROM Sic5evensoli s WHERE s.numCantproc = :numCantproc")
    , @NamedQuery(name = "Sic5evensoli.findByNumAlertas", query = "SELECT s FROM Sic5evensoli s WHERE s.numAlertas = :numAlertas")})
public class Sic5evensoli implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 4000)
    @Column(name = "COD_EXPE")
    private String codExpe;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_EVEN")
    private BigDecimal idEven;
    @Size(max = 250)
    @Column(name = "DES_EVEN")
    private String desEven;
    @Column(name = "FEC_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecCreacion;
    @Column(name = "ID_MODOCREA")
    private BigInteger idModocrea;
    @Size(max = 500)
    @Column(name = "DES_MODOCREA")
    private String desModocrea;
    @Size(max = 50)
    @Column(name = "COD_MODOCREA")
    private String codModocrea;
    @Column(name = "ID_PERS")
    private BigInteger idPers;
    @Size(max = 250)
    @Column(name = "DES_PERS")
    private String desPers;
    @Column(name = "ID_PERSCREADOR")
    private BigInteger idPerscreador;
    @Size(max = 250)
    @Column(name = "DES_PERSCREADOR")
    private String desPerscreador;
    @Column(name = "ID_TROLPERS")
    private BigInteger idTrolpers;
    @Size(max = 500)
    @Column(name = "DES_TROLPERS")
    private String desTrolpers;
    @Column(name = "ID_TROLPERSCREADOR")
    private BigInteger idTrolperscreador;
    @Size(max = 500)
    @Column(name = "DES_TROLPERSCREADOR")
    private String desTrolperscreador;
    @Column(name = "ID_STIPOEVEN")
    private BigInteger idStipoeven;
    @Size(max = 500)
    @Column(name = "DES_STIPOEVEN")
    private String desStipoeven;
    @Size(max = 50)
    @Column(name = "COD_STIPOEVEN")
    private String codStipoeven;
    @Column(name = "ID_TIPOEVEN")
    private BigInteger idTipoeven;
    @Size(max = 500)
    @Column(name = "DES_TIPOEVEN")
    private String desTipoeven;
    @Size(max = 50)
    @Column(name = "COD_TIPOEVEN")
    private String codTipoeven;
    @Column(name = "ID_MOTIEVEN")
    private BigInteger idMotieven;
    @Size(max = 500)
    @Column(name = "DES_MOTIEVEN")
    private String desMotieven;
    @Size(max = 50)
    @Column(name = "COD_MOTIEVEN")
    private String codMotieven;
    @Column(name = "ID_MEDICOMU")
    private BigInteger idMedicomu;
    @Size(max = 500)
    @Column(name = "DES_MEDICOMU")
    private String desMedicomu;
    @Size(max = 50)
    @Column(name = "COD_MEDICOMU")
    private String codMedicomu;
    @Column(name = "ID_SCLASEEVEN")
    private BigInteger idSclaseeven;
    @Size(max = 1000)
    @Column(name = "DES_SCLASEEVEN")
    private String desSclaseeven;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "COD_SCLASEEVEN")
    private String codSclaseeven;
    @Column(name = "ID_TIPOFORMATO")
    private BigInteger idTipoformato;
    @Size(max = 500)
    @Column(name = "DES_TIPOFORMATO")
    private String desTipoformato;
    @Size(max = 50)
    @Column(name = "COD_TIPOFORMATO")
    private String codTipoformato;
    @Column(name = "ID_TIPOSOLI")
    private BigInteger idTiposoli;
    @Size(max = 500)
    @Column(name = "DES_TIPOSOLI")
    private String desTiposoli;
    @Size(max = 50)
    @Column(name = "COD_TIPOSOLI")
    private String codTiposoli;
    @Column(name = "ID_CLASEEVEN")
    private BigInteger idClaseeven;
    @Size(max = 500)
    @Column(name = "DES_CLASEEVEN")
    private String desClaseeven;
    @Size(max = 50)
    @Column(name = "COD_CLASEEVEN")
    private String codClaseeven;
    @Size(max = 4000)
    @Column(name = "DES_NOTASSCLASEEVEN")
    private String desNotassclaseeven;
    @Column(name = "FEC_DESDE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecDesde;
    @Column(name = "FEC_HASTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecHasta;
    @Size(max = 4000)
    @Column(name = "DES_NOTAS")
    private String desNotas;
    @Size(max = 250)
    @Column(name = "NUM_INSTBPM")
    private String numInstbpm;
    @Size(max = 4000)
    @Column(name = "DES_NOTASMINC")
    private String desNotasminc;
    @Size(max = 4000)
    @Column(name = "DES_NOTASADMI")
    private String desNotasadmi;
    @Size(max = 4000)
    @Column(name = "DES_NOTASEMPL")
    private String desNotasempl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ESTAEVEN")
    private BigInteger idEstaeven;
    @Size(max = 4000)
    @Column(name = "DES_ESTAEVEN")
    private String desEstaeven;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FEC_DESDEESTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecDesdeesta;
    @Column(name = "FEC_HASTAESTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecHastaesta;
    @Size(max = 50)
    @Column(name = "COD_ESTAEVEN")
    private String codEstaeven;
    @Size(max = 4000)
    @Column(name = "DES_NOTASEVENESTA")
    private String desNotasevenesta;
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
    @Size(max = 250)
    @Column(name = "DES_TRELAEVEN")
    private String desTrelaeven;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CLASERELA")
    private BigInteger idClaserela;
    @Size(max = 500)
    @Column(name = "DES_CLASERELA")
    private String desClaserela;
    @Column(name = "NUM_DIAPLAZO")
    private BigInteger numDiaplazo;
    @Column(name = "FLG_SILEADMI")
    private BigInteger flgSileadmi;
    @Size(max = 11)
    @Column(name = "DES_SILEADMI")
    private String desSileadmi;
    @Column(name = "NUM_CANTPROC")
    private BigInteger numCantproc;
    @Column(name = "NUM_ALERTAS")
    private BigInteger numAlertas;

    public Sic5evensoli() {
    }

    public Sic5evensoli(BigDecimal idEven) {
        this.idEven = idEven;
    }

    public Sic5evensoli(BigDecimal idEven, String codSclaseeven, BigInteger idEstaeven, Date fecDesdeesta, BigInteger idTrolestaeven, BigInteger idClaserela) {
        this.idEven = idEven;
        this.codSclaseeven = codSclaseeven;
        this.idEstaeven = idEstaeven;
        this.fecDesdeesta = fecDesdeesta;
        this.idTrolestaeven = idTrolestaeven;
        this.idClaserela = idClaserela;
    }

    public String getCodExpe() {
        return codExpe;
    }

    public void setCodExpe(String codExpe) {
        this.codExpe = codExpe;
    }

    public BigDecimal getIdEven() {
        return idEven;
    }

    public void setIdEven(BigDecimal idEven) {
        this.idEven = idEven;
    }

    public String getDesEven() {
        return desEven;
    }

    public void setDesEven(String desEven) {
        this.desEven = desEven;
    }

    public Date getFecCreacion() {
        return fecCreacion;
    }

    public void setFecCreacion(Date fecCreacion) {
        this.fecCreacion = fecCreacion;
    }

    public BigInteger getIdModocrea() {
        return idModocrea;
    }

    public void setIdModocrea(BigInteger idModocrea) {
        this.idModocrea = idModocrea;
    }

    public String getDesModocrea() {
        return desModocrea;
    }

    public void setDesModocrea(String desModocrea) {
        this.desModocrea = desModocrea;
    }

    public String getCodModocrea() {
        return codModocrea;
    }

    public void setCodModocrea(String codModocrea) {
        this.codModocrea = codModocrea;
    }

    public BigInteger getIdPers() {
        return idPers;
    }

    public void setIdPers(BigInteger idPers) {
        this.idPers = idPers;
    }

    public String getDesPers() {
        return desPers;
    }

    public void setDesPers(String desPers) {
        this.desPers = desPers;
    }

    public BigInteger getIdPerscreador() {
        return idPerscreador;
    }

    public void setIdPerscreador(BigInteger idPerscreador) {
        this.idPerscreador = idPerscreador;
    }

    public String getDesPerscreador() {
        return desPerscreador;
    }

    public void setDesPerscreador(String desPerscreador) {
        this.desPerscreador = desPerscreador;
    }

    public BigInteger getIdTrolpers() {
        return idTrolpers;
    }

    public void setIdTrolpers(BigInteger idTrolpers) {
        this.idTrolpers = idTrolpers;
    }

    public String getDesTrolpers() {
        return desTrolpers;
    }

    public void setDesTrolpers(String desTrolpers) {
        this.desTrolpers = desTrolpers;
    }

    public BigInteger getIdTrolperscreador() {
        return idTrolperscreador;
    }

    public void setIdTrolperscreador(BigInteger idTrolperscreador) {
        this.idTrolperscreador = idTrolperscreador;
    }

    public String getDesTrolperscreador() {
        return desTrolperscreador;
    }

    public void setDesTrolperscreador(String desTrolperscreador) {
        this.desTrolperscreador = desTrolperscreador;
    }

    public BigInteger getIdStipoeven() {
        return idStipoeven;
    }

    public void setIdStipoeven(BigInteger idStipoeven) {
        this.idStipoeven = idStipoeven;
    }

    public String getDesStipoeven() {
        return desStipoeven;
    }

    public void setDesStipoeven(String desStipoeven) {
        this.desStipoeven = desStipoeven;
    }

    public String getCodStipoeven() {
        return codStipoeven;
    }

    public void setCodStipoeven(String codStipoeven) {
        this.codStipoeven = codStipoeven;
    }

    public BigInteger getIdTipoeven() {
        return idTipoeven;
    }

    public void setIdTipoeven(BigInteger idTipoeven) {
        this.idTipoeven = idTipoeven;
    }

    public String getDesTipoeven() {
        return desTipoeven;
    }

    public void setDesTipoeven(String desTipoeven) {
        this.desTipoeven = desTipoeven;
    }

    public String getCodTipoeven() {
        return codTipoeven;
    }

    public void setCodTipoeven(String codTipoeven) {
        this.codTipoeven = codTipoeven;
    }

    public BigInteger getIdMotieven() {
        return idMotieven;
    }

    public void setIdMotieven(BigInteger idMotieven) {
        this.idMotieven = idMotieven;
    }

    public String getDesMotieven() {
        return desMotieven;
    }

    public void setDesMotieven(String desMotieven) {
        this.desMotieven = desMotieven;
    }

    public String getCodMotieven() {
        return codMotieven;
    }

    public void setCodMotieven(String codMotieven) {
        this.codMotieven = codMotieven;
    }

    public BigInteger getIdMedicomu() {
        return idMedicomu;
    }

    public void setIdMedicomu(BigInteger idMedicomu) {
        this.idMedicomu = idMedicomu;
    }

    public String getDesMedicomu() {
        return desMedicomu;
    }

    public void setDesMedicomu(String desMedicomu) {
        this.desMedicomu = desMedicomu;
    }

    public String getCodMedicomu() {
        return codMedicomu;
    }

    public void setCodMedicomu(String codMedicomu) {
        this.codMedicomu = codMedicomu;
    }

    public BigInteger getIdSclaseeven() {
        return idSclaseeven;
    }

    public void setIdSclaseeven(BigInteger idSclaseeven) {
        this.idSclaseeven = idSclaseeven;
    }

    public String getDesSclaseeven() {
        return desSclaseeven;
    }

    public void setDesSclaseeven(String desSclaseeven) {
        this.desSclaseeven = desSclaseeven;
    }

    public String getCodSclaseeven() {
        return codSclaseeven;
    }

    public void setCodSclaseeven(String codSclaseeven) {
        this.codSclaseeven = codSclaseeven;
    }

    public BigInteger getIdTipoformato() {
        return idTipoformato;
    }

    public void setIdTipoformato(BigInteger idTipoformato) {
        this.idTipoformato = idTipoformato;
    }

    public String getDesTipoformato() {
        return desTipoformato;
    }

    public void setDesTipoformato(String desTipoformato) {
        this.desTipoformato = desTipoformato;
    }

    public String getCodTipoformato() {
        return codTipoformato;
    }

    public void setCodTipoformato(String codTipoformato) {
        this.codTipoformato = codTipoformato;
    }

    public BigInteger getIdTiposoli() {
        return idTiposoli;
    }

    public void setIdTiposoli(BigInteger idTiposoli) {
        this.idTiposoli = idTiposoli;
    }

    public String getDesTiposoli() {
        return desTiposoli;
    }

    public void setDesTiposoli(String desTiposoli) {
        this.desTiposoli = desTiposoli;
    }

    public String getCodTiposoli() {
        return codTiposoli;
    }

    public void setCodTiposoli(String codTiposoli) {
        this.codTiposoli = codTiposoli;
    }

    public BigInteger getIdClaseeven() {
        return idClaseeven;
    }

    public void setIdClaseeven(BigInteger idClaseeven) {
        this.idClaseeven = idClaseeven;
    }

    public String getDesClaseeven() {
        return desClaseeven;
    }

    public void setDesClaseeven(String desClaseeven) {
        this.desClaseeven = desClaseeven;
    }

    public String getCodClaseeven() {
        return codClaseeven;
    }

    public void setCodClaseeven(String codClaseeven) {
        this.codClaseeven = codClaseeven;
    }

    public String getDesNotassclaseeven() {
        return desNotassclaseeven;
    }

    public void setDesNotassclaseeven(String desNotassclaseeven) {
        this.desNotassclaseeven = desNotassclaseeven;
    }

    public Date getFecDesde() {
        return fecDesde;
    }

    public void setFecDesde(Date fecDesde) {
        this.fecDesde = fecDesde;
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

    public String getNumInstbpm() {
        return numInstbpm;
    }

    public void setNumInstbpm(String numInstbpm) {
        this.numInstbpm = numInstbpm;
    }

    public String getDesNotasminc() {
        return desNotasminc;
    }

    public void setDesNotasminc(String desNotasminc) {
        this.desNotasminc = desNotasminc;
    }

    public String getDesNotasadmi() {
        return desNotasadmi;
    }

    public void setDesNotasadmi(String desNotasadmi) {
        this.desNotasadmi = desNotasadmi;
    }

    public String getDesNotasempl() {
        return desNotasempl;
    }

    public void setDesNotasempl(String desNotasempl) {
        this.desNotasempl = desNotasempl;
    }

    public BigInteger getIdEstaeven() {
        return idEstaeven;
    }

    public void setIdEstaeven(BigInteger idEstaeven) {
        this.idEstaeven = idEstaeven;
    }

    public String getDesEstaeven() {
        return desEstaeven;
    }

    public void setDesEstaeven(String desEstaeven) {
        this.desEstaeven = desEstaeven;
    }

    public Date getFecDesdeesta() {
        return fecDesdeesta;
    }

    public void setFecDesdeesta(Date fecDesdeesta) {
        this.fecDesdeesta = fecDesdeesta;
    }

    public Date getFecHastaesta() {
        return fecHastaesta;
    }

    public void setFecHastaesta(Date fecHastaesta) {
        this.fecHastaesta = fecHastaesta;
    }

    public String getCodEstaeven() {
        return codEstaeven;
    }

    public void setCodEstaeven(String codEstaeven) {
        this.codEstaeven = codEstaeven;
    }

    public String getDesNotasevenesta() {
        return desNotasevenesta;
    }

    public void setDesNotasevenesta(String desNotasevenesta) {
        this.desNotasevenesta = desNotasevenesta;
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

    public String getDesTrelaeven() {
        return desTrelaeven;
    }

    public void setDesTrelaeven(String desTrelaeven) {
        this.desTrelaeven = desTrelaeven;
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

    public BigInteger getNumDiaplazo() {
        return numDiaplazo;
    }

    public void setNumDiaplazo(BigInteger numDiaplazo) {
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

    public BigInteger getNumCantproc() {
        return numCantproc;
    }

    public void setNumCantproc(BigInteger numCantproc) {
        this.numCantproc = numCantproc;
    }

    public BigInteger getNumAlertas() {
        return numAlertas;
    }

    public void setNumAlertas(BigInteger numAlertas) {
        this.numAlertas = numAlertas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEven != null ? idEven.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sic5evensoli)) {
            return false;
        }
        Sic5evensoli other = (Sic5evensoli) object;
        if ((this.idEven == null && other.idEven != null) || (this.idEven != null && !this.idEven.equals(other.idEven))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.general.entity.Sic5evensoli[ idEven=" + idEven + " ]";
    }
    
}
