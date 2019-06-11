/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.general.views;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
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
@Table(name = "VI_COMSALA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ViComsala.findAll", query = "SELECT v FROM ViComsala v")
    , @NamedQuery(name = "ViComsala.findByIdSala", query = "SELECT v FROM ViComsala v WHERE v.idSala = :idSala")
    , @NamedQuery(name = "ViComsala.findByIdEven", query = "SELECT v FROM ViComsala v WHERE v.idEven = :idEven")
    , @NamedQuery(name = "ViComsala.findByDesSclaseeven", query = "SELECT v FROM ViComsala v WHERE v.desSclaseeven = :desSclaseeven")
    , @NamedQuery(name = "ViComsala.findByCodSala", query = "SELECT v FROM ViComsala v WHERE v.codSala = :codSala")
    , @NamedQuery(name = "ViComsala.findByNomSala", query = "SELECT v FROM ViComsala v WHERE v.nomSala = :nomSala")
    , @NamedQuery(name = "ViComsala.findByDesTiposala", query = "SELECT v FROM ViComsala v WHERE v.desTiposala = :desTiposala")
    , @NamedQuery(name = "ViComsala.findByDesTipogiro", query = "SELECT v FROM ViComsala v WHERE v.desTipogiro = :desTipogiro")
    , @NamedQuery(name = "ViComsala.findByDesNomgiro", query = "SELECT v FROM ViComsala v WHERE v.desNomgiro = :desNomgiro")
    , @NamedQuery(name = "ViComsala.findByDireccionHtml", query = "SELECT v FROM ViComsala v WHERE v.direccionHtml = :direccionHtml")
    , @NamedQuery(name = "ViComsala.findByDireccion", query = "SELECT v FROM ViComsala v WHERE v.direccion = :direccion")
    , @NamedQuery(name = "ViComsala.findByUbigeo", query = "SELECT v FROM ViComsala v WHERE v.ubigeo = :ubigeo")
    , @NamedQuery(name = "ViComsala.findByDistrito", query = "SELECT v FROM ViComsala v WHERE v.distrito = :distrito")
    , @NamedQuery(name = "ViComsala.findByDepartamento", query = "SELECT v FROM ViComsala v WHERE v.departamento = :departamento")
    , @NamedQuery(name = "ViComsala.findByProvincia", query = "SELECT v FROM ViComsala v WHERE v.provincia = :provincia")
    , @NamedQuery(name = "ViComsala.findByCoordenadas", query = "SELECT v FROM ViComsala v WHERE v.coordenadas = :coordenadas")
    , @NamedQuery(name = "ViComsala.findBySigno", query = "SELECT v FROM ViComsala v WHERE v.signo = :signo")
    , @NamedQuery(name = "ViComsala.findByNomEmpres", query = "SELECT v FROM ViComsala v WHERE v.nomEmpres = :nomEmpres")
    , @NamedQuery(name = "ViComsala.findByCodRuc", query = "SELECT v FROM ViComsala v WHERE v.codRuc = :codRuc")
    , @NamedQuery(name = "ViComsala.findByIdEmpresa", query = "SELECT v FROM ViComsala v WHERE v.idEmpresa = :idEmpresa")
    , @NamedQuery(name = "ViComsala.findByFecInicio", query = "SELECT v FROM ViComsala v WHERE v.fecInicio = :fecInicio")
    , @NamedQuery(name = "ViComsala.findByFecFin", query = "SELECT v FROM ViComsala v WHERE v.fecFin = :fecFin")
    , @NamedQuery(name = "ViComsala.findByExpediente", query = "SELECT v FROM ViComsala v WHERE v.expediente = :expediente")
    , @NamedQuery(name = "ViComsala.findByFlagTipo", query = "SELECT v FROM ViComsala v WHERE v.flagTipo = :flagTipo")
    , @NamedQuery(name = "ViComsala.findByIdTrelalugar", query = "SELECT v FROM ViComsala v WHERE v.idTrelalugar = :idTrelalugar")
    , @NamedQuery(name = "ViComsala.findByCodTrelalugar", query = "SELECT v FROM ViComsala v WHERE v.codTrelalugar = :codTrelalugar")
    , @NamedQuery(name = "ViComsala.findByDesTrelalugar", query = "SELECT v FROM ViComsala v WHERE v.desTrelalugar = :desTrelalugar")
    , @NamedQuery(name = "ViComsala.findByResolucion", query = "SELECT v FROM ViComsala v WHERE v.resolucion = :resolucion")
    , @NamedQuery(name = "ViComsala.findByFecNotificacion", query = "SELECT v FROM ViComsala v WHERE v.fecNotificacion = :fecNotificacion")})

public class ViComsala implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "ID_SALA")
    private Integer idSala;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_EVEN")
    private BigDecimal idEven;
    @Size(max = 1000)
    @Column(name = "DES_SCLASEEVEN")
    private String desSclaseeven;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "COD_SALA")
    private String codSala;
    @Size(max = 4000)
    @Column(name = "NOM_SALA")
    private String nomSala;
    @Size(max = 27)
    @Column(name = "DES_TIPOSALA")
    private String desTiposala;
    @Size(max = 500)
    @Column(name = "DES_TIPOGIRO")
    private String desTipogiro;
    @Size(max = 100)
    @Column(name = "DES_NOMGIRO")
    private String desNomgiro;
    @Size(max = 4000)
    @Column(name = "DIRECCION_HTML")
    private String direccionHtml;
    @Size(max = 4000)
    @Column(name = "DIRECCION")
    private String direccion;
    @Size(max = 250)
    @Column(name = "UBIGEO")
    private String ubigeo;
    @Size(max = 4000)
    @Column(name = "DISTRITO")
    private String distrito;
    @Size(max = 4000)
    @Column(name = "DEPARTAMENTO")
    private String departamento;
    @Size(max = 4000)
    @Column(name = "PROVINCIA")
    private String provincia;
    @Size(max = 31)
    @Column(name = "COORDENADAS")
    private String coordenadas;
    @Size(max = 50)
    @Column(name = "SIGNO")
    private String signo;
    @Size(max = 250)
    @Column(name = "NOM_EMPRES")
    private String nomEmpres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "COD_RUC")
    private String codRuc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_EMPRESA")
    private Integer idEmpresa;
    @Column(name = "FEC_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecInicio;
    @Column(name = "FEC_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecFin;
    @Size(max = 4000)
    @Column(name = "EXPEDIENTE")
    private String expediente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "FLAG_TIPO")
    private String flagTipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TRELALUGAR")
    private Integer idTrelalugar;
    @Size(max = 250)
    @Column(name = "COD_TRELALUGAR")
    private String codTrelalugar;
    @Size(max = 250)
    @Column(name = "DES_TRELALUGAR")
    private String desTrelalugar;
    @Size(max = 40)
    @Column(name = "RESOLUCION")
    private String resolucion;
    @Column(name = "FEC_NOTIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecNotificacion;

    /*Agregado*/
    private Integer num_cantMemorias;
    private Integer num_cantMaquinas;
    private Integer num_cantMesas;
    
    public ViComsala() {
    }

    public Integer getIdSala() {
        return idSala;
    }

    public void setIdSala(Integer idSala) {
        this.idSala = idSala;
    }

    public BigDecimal getIdEven() {
        return idEven;
    }

    public void setIdEven(BigDecimal idEven) {
        this.idEven = idEven;
    }

    public String getDesSclaseeven() {
        return desSclaseeven;
    }

    public void setDesSclaseeven(String desSclaseeven) {
        this.desSclaseeven = desSclaseeven;
    }

    public String getCodSala() {
        return codSala;
    }

    public void setCodSala(String codSala) {
        this.codSala = codSala;
    }

    public String getNomSala() {
        return nomSala;
    }

    public void setNomSala(String nomSala) {
        this.nomSala = nomSala;
    }

    public String getDesTiposala() {
        return desTiposala;
    }

    public void setDesTiposala(String desTiposala) {
        this.desTiposala = desTiposala;
    }

    public String getDesTipogiro() {
        return desTipogiro;
    }

    public void setDesTipogiro(String desTipogiro) {
        this.desTipogiro = desTipogiro;
    }

    public String getDesNomgiro() {
        return desNomgiro;
    }

    public void setDesNomgiro(String desNomgiro) {
        this.desNomgiro = desNomgiro;
    }

    public String getDireccionHtml() {
        return direccionHtml;
    }

    public void setDireccionHtml(String direccionHtml) {
        this.direccionHtml = direccionHtml;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(String ubigeo) {
        this.ubigeo = ubigeo;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }

    public String getSigno() {
        return signo;
    }

    public void setSigno(String signo) {
        this.signo = signo;
    }

    public String getNomEmpres() {
        return nomEmpres;
    }

    public void setNomEmpres(String nomEmpres) {
        this.nomEmpres = nomEmpres;
    }

    public String getCodRuc() {
        return codRuc;
    }

    public void setCodRuc(String codRuc) {
        this.codRuc = codRuc;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Date getFecInicio() {
        return fecInicio;
    }

    public void setFecInicio(Date fecInicio) {
        this.fecInicio = fecInicio;
    }

    public Date getFecFin() {
        return fecFin;
    }

    public void setFecFin(Date fecFin) {
        this.fecFin = fecFin;
    }

    public String getExpediente() {
        return expediente;
    }

    public void setExpediente(String expediente) {
        this.expediente = expediente;
    }

    public String getFlagTipo() {
        return flagTipo;
    }

    public void setFlagTipo(String flagTipo) {
        this.flagTipo = flagTipo;
    }

    public Integer getIdTrelalugar() {
        return idTrelalugar;
    }

    public void setIdTrelalugar(Integer idTrelalugar) {
        this.idTrelalugar = idTrelalugar;
    }

    public String getCodTrelalugar() {
        return codTrelalugar;
    }

    public void setCodTrelalugar(String codTrelalugar) {
        this.codTrelalugar = codTrelalugar;
    }

    public String getDesTrelalugar() {
        return desTrelalugar;
    }

    public void setDesTrelalugar(String desTrelalugar) {
        this.desTrelalugar = desTrelalugar;
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public Date getFecNotificacion() {
        return fecNotificacion;
    }

    public void setFecNotificacion(Date fecNotificacion) {
        this.fecNotificacion = fecNotificacion;
    }

    public Integer getNum_cantMemorias() {
        return num_cantMemorias;
    }

    public void setNum_cantMemorias(Integer num_cantMemorias) {
        this.num_cantMemorias = num_cantMemorias;
    }

    public Integer getNum_cantMaquinas() {
        return num_cantMaquinas;
    }

    public void setNum_cantMaquinas(Integer num_cantMaquinas) {
        this.num_cantMaquinas = num_cantMaquinas;
    }

    public Integer getNum_cantMesas() {
        return num_cantMesas;
    }

    public void setNum_cantMesas(Integer num_cantMesas) {
        this.num_cantMesas = num_cantMesas;
    }
    
    
    
}
