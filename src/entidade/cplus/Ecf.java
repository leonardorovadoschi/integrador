/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ECF", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ecf.findAll", query = "SELECT e FROM Ecf e")
    , @NamedQuery(name = "Ecf.findByCodecf", query = "SELECT e FROM Ecf e WHERE e.codecf = :codecf")
    , @NamedQuery(name = "Ecf.findByCodigo", query = "SELECT e FROM Ecf e WHERE e.codigo = :codigo")
    , @NamedQuery(name = "Ecf.findByNumeroserie", query = "SELECT e FROM Ecf e WHERE e.numeroserie = :numeroserie")
    , @NamedQuery(name = "Ecf.findByMfadicional", query = "SELECT e FROM Ecf e WHERE e.mfadicional = :mfadicional")
    , @NamedQuery(name = "Ecf.findByNumerocaixa", query = "SELECT e FROM Ecf e WHERE e.numerocaixa = :numerocaixa")
    , @NamedQuery(name = "Ecf.findByNumerousuario", query = "SELECT e FROM Ecf e WHERE e.numerousuario = :numerousuario")
    , @NamedQuery(name = "Ecf.findByTipoecf", query = "SELECT e FROM Ecf e WHERE e.tipoecf = :tipoecf")
    , @NamedQuery(name = "Ecf.findByVersaosb", query = "SELECT e FROM Ecf e WHERE e.versaosb = :versaosb")
    , @NamedQuery(name = "Ecf.findByDatainstalacaosb", query = "SELECT e FROM Ecf e WHERE e.datainstalacaosb = :datainstalacaosb")
    , @NamedQuery(name = "Ecf.findByHorainstalacaosb", query = "SELECT e FROM Ecf e WHERE e.horainstalacaosb = :horainstalacaosb")
    , @NamedQuery(name = "Ecf.findByVersaopaf", query = "SELECT e FROM Ecf e WHERE e.versaopaf = :versaopaf")
    , @NamedQuery(name = "Ecf.findByMd5paf", query = "SELECT e FROM Ecf e WHERE e.md5paf = :md5paf")
    , @NamedQuery(name = "Ecf.findByNumeroserieecf", query = "SELECT e FROM Ecf e WHERE e.numeroserieecf = :numeroserieecf")
    , @NamedQuery(name = "Ecf.findByFlagativo", query = "SELECT e FROM Ecf e WHERE e.flagativo = :flagativo")
    , @NamedQuery(name = "Ecf.findByCodempresa", query = "SELECT e FROM Ecf e WHERE e.codempresa = :codempresa")
    , @NamedQuery(name = "Ecf.findByFlagdescontoissqn", query = "SELECT e FROM Ecf e WHERE e.flagdescontoissqn = :flagdescontoissqn")
    , @NamedQuery(name = "Ecf.findByMarcaecf", query = "SELECT e FROM Ecf e WHERE e.marcaecf = :marcaecf")
    , @NamedQuery(name = "Ecf.findByModeloecf", query = "SELECT e FROM Ecf e WHERE e.modeloecf = :modeloecf")
    , @NamedQuery(name = "Ecf.findByCnpj", query = "SELECT e FROM Ecf e WHERE e.cnpj = :cnpj")
    , @NamedQuery(name = "Ecf.findByInscricaoestadual", query = "SELECT e FROM Ecf e WHERE e.inscricaoestadual = :inscricaoestadual")
    , @NamedQuery(name = "Ecf.findByLastChange", query = "SELECT e FROM Ecf e WHERE e.lastChange = :lastChange")
    , @NamedQuery(name = "Ecf.findByFlagaltpaf", query = "SELECT e FROM Ecf e WHERE e.flagaltpaf = :flagaltpaf")})
public class Ecf implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODECF")
    private String codecf;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "NUMEROSERIE")
    private String numeroserie;
    @Column(name = "MFADICIONAL")
    private Character mfadicional;
    @Column(name = "NUMEROCAIXA")
    private Integer numerocaixa;
    @Column(name = "NUMEROUSUARIO")
    private Integer numerousuario;
    @Column(name = "TIPOECF")
    private String tipoecf;
    @Column(name = "VERSAOSB")
    private String versaosb;
    @Column(name = "DATAINSTALACAOSB")
    @Temporal(TemporalType.DATE)
    private Date datainstalacaosb;
    @Column(name = "HORAINSTALACAOSB")
    @Temporal(TemporalType.TIME)
    private Date horainstalacaosb;
    @Column(name = "VERSAOPAF")
    private String versaopaf;
    @Column(name = "MD5PAF")
    private String md5paf;
    @Column(name = "NUMEROSERIEECF")
    private String numeroserieecf;
    @Column(name = "FLAGATIVO")
    private Character flagativo;
    @Column(name = "CODEMPRESA")
    private Integer codempresa;
    @Column(name = "FLAGDESCONTOISSQN")
    private Character flagdescontoissqn;
    @Column(name = "MARCAECF")
    private String marcaecf;
    @Column(name = "MODELOECF")
    private String modeloecf;
    @Column(name = "CNPJ")
    private String cnpj;
    @Column(name = "INSCRICAOESTADUAL")
    private String inscricaoestadual;
    @Column(name = "LAST_CHANGE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastChange;
    @Column(name = "FLAGALTPAF")
    private Character flagaltpaf;
    @OneToMany(mappedBy = "codecf")
    private Collection<Movecfdocumentocaixa> movecfdocumentocaixaCollection;
    @JoinColumn(name = "CODECFMARCA", referencedColumnName = "CODECFMARCA")
    @ManyToOne(optional = false)
    private Ecfmarca codecfmarca;
    @JoinColumn(name = "CODECFMODELO", referencedColumnName = "CODECFMODELO")
    @ManyToOne(optional = false)
    private Ecfmodelo codecfmodelo;

    public Ecf() {
    }

    public Ecf(String codecf) {
        this.codecf = codecf;
    }

    public String getCodecf() {
        return codecf;
    }

    public void setCodecf(String codecf) {
        this.codecf = codecf;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNumeroserie() {
        return numeroserie;
    }

    public void setNumeroserie(String numeroserie) {
        this.numeroserie = numeroserie;
    }

    public Character getMfadicional() {
        return mfadicional;
    }

    public void setMfadicional(Character mfadicional) {
        this.mfadicional = mfadicional;
    }

    public Integer getNumerocaixa() {
        return numerocaixa;
    }

    public void setNumerocaixa(Integer numerocaixa) {
        this.numerocaixa = numerocaixa;
    }

    public Integer getNumerousuario() {
        return numerousuario;
    }

    public void setNumerousuario(Integer numerousuario) {
        this.numerousuario = numerousuario;
    }

    public String getTipoecf() {
        return tipoecf;
    }

    public void setTipoecf(String tipoecf) {
        this.tipoecf = tipoecf;
    }

    public String getVersaosb() {
        return versaosb;
    }

    public void setVersaosb(String versaosb) {
        this.versaosb = versaosb;
    }

    public Date getDatainstalacaosb() {
        return datainstalacaosb;
    }

    public void setDatainstalacaosb(Date datainstalacaosb) {
        this.datainstalacaosb = datainstalacaosb;
    }

    public Date getHorainstalacaosb() {
        return horainstalacaosb;
    }

    public void setHorainstalacaosb(Date horainstalacaosb) {
        this.horainstalacaosb = horainstalacaosb;
    }

    public String getVersaopaf() {
        return versaopaf;
    }

    public void setVersaopaf(String versaopaf) {
        this.versaopaf = versaopaf;
    }

    public String getMd5paf() {
        return md5paf;
    }

    public void setMd5paf(String md5paf) {
        this.md5paf = md5paf;
    }

    public String getNumeroserieecf() {
        return numeroserieecf;
    }

    public void setNumeroserieecf(String numeroserieecf) {
        this.numeroserieecf = numeroserieecf;
    }

    public Character getFlagativo() {
        return flagativo;
    }

    public void setFlagativo(Character flagativo) {
        this.flagativo = flagativo;
    }

    public Integer getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Integer codempresa) {
        this.codempresa = codempresa;
    }

    public Character getFlagdescontoissqn() {
        return flagdescontoissqn;
    }

    public void setFlagdescontoissqn(Character flagdescontoissqn) {
        this.flagdescontoissqn = flagdescontoissqn;
    }

    public String getMarcaecf() {
        return marcaecf;
    }

    public void setMarcaecf(String marcaecf) {
        this.marcaecf = marcaecf;
    }

    public String getModeloecf() {
        return modeloecf;
    }

    public void setModeloecf(String modeloecf) {
        this.modeloecf = modeloecf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoestadual() {
        return inscricaoestadual;
    }

    public void setInscricaoestadual(String inscricaoestadual) {
        this.inscricaoestadual = inscricaoestadual;
    }

    public Date getLastChange() {
        return lastChange;
    }

    public void setLastChange(Date lastChange) {
        this.lastChange = lastChange;
    }

    public Character getFlagaltpaf() {
        return flagaltpaf;
    }

    public void setFlagaltpaf(Character flagaltpaf) {
        this.flagaltpaf = flagaltpaf;
    }

    @XmlTransient
    public Collection<Movecfdocumentocaixa> getMovecfdocumentocaixaCollection() {
        return movecfdocumentocaixaCollection;
    }

    public void setMovecfdocumentocaixaCollection(Collection<Movecfdocumentocaixa> movecfdocumentocaixaCollection) {
        this.movecfdocumentocaixaCollection = movecfdocumentocaixaCollection;
    }

    public Ecfmarca getCodecfmarca() {
        return codecfmarca;
    }

    public void setCodecfmarca(Ecfmarca codecfmarca) {
        this.codecfmarca = codecfmarca;
    }

    public Ecfmodelo getCodecfmodelo() {
        return codecfmodelo;
    }

    public void setCodecfmodelo(Ecfmodelo codecfmodelo) {
        this.codecfmodelo = codecfmodelo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codecf != null ? codecf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ecf)) {
            return false;
        }
        Ecf other = (Ecf) object;
        if ((this.codecf == null && other.codecf != null) || (this.codecf != null && !this.codecf.equals(other.codecf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Ecf[ codecf=" + codecf + " ]";
    }
    
}
