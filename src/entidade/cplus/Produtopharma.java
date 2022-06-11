/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "PRODUTOPHARMA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produtopharma.findAll", query = "SELECT p FROM Produtopharma p")
    , @NamedQuery(name = "Produtopharma.findByCodprod", query = "SELECT p FROM Produtopharma p WHERE p.codprod = :codprod")
    , @NamedQuery(name = "Produtopharma.findByCodigodcb", query = "SELECT p FROM Produtopharma p WHERE p.codigodcb = :codigodcb")
    , @NamedQuery(name = "Produtopharma.findByDescricaodcb", query = "SELECT p FROM Produtopharma p WHERE p.descricaodcb = :descricaodcb")
    , @NamedQuery(name = "Produtopharma.findByPrincipioativo", query = "SELECT p FROM Produtopharma p WHERE p.principioativo = :principioativo")
    , @NamedQuery(name = "Produtopharma.findByApresentacao", query = "SELECT p FROM Produtopharma p WHERE p.apresentacao = :apresentacao")
    , @NamedQuery(name = "Produtopharma.findByFlagcontrolado", query = "SELECT p FROM Produtopharma p WHERE p.flagcontrolado = :flagcontrolado")
    , @NamedQuery(name = "Produtopharma.findByFlagfarmaciapopular", query = "SELECT p FROM Produtopharma p WHERE p.flagfarmaciapopular = :flagfarmaciapopular")
    , @NamedQuery(name = "Produtopharma.findByAliqdescpopular", query = "SELECT p FROM Produtopharma p WHERE p.aliqdescpopular = :aliqdescpopular")
    , @NamedQuery(name = "Produtopharma.findByRegistroms", query = "SELECT p FROM Produtopharma p WHERE p.registroms = :registroms")
    , @NamedQuery(name = "Produtopharma.findByCodigoinsumo", query = "SELECT p FROM Produtopharma p WHERE p.codigoinsumo = :codigoinsumo")
    , @NamedQuery(name = "Produtopharma.findByUnidadeinsumo", query = "SELECT p FROM Produtopharma p WHERE p.unidadeinsumo = :unidadeinsumo")
    , @NamedQuery(name = "Produtopharma.findByFlaginsumo", query = "SELECT p FROM Produtopharma p WHERE p.flaginsumo = :flaginsumo")
    , @NamedQuery(name = "Produtopharma.findByUnmedidamedicamento", query = "SELECT p FROM Produtopharma p WHERE p.unmedidamedicamento = :unmedidamedicamento")
    , @NamedQuery(name = "Produtopharma.findByClasseterapeutica", query = "SELECT p FROM Produtopharma p WHERE p.classeterapeutica = :classeterapeutica")
    , @NamedQuery(name = "Produtopharma.findByUsoprolongado", query = "SELECT p FROM Produtopharma p WHERE p.usoprolongado = :usoprolongado")})
public class Produtopharma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODPROD")
    private String codprod;
    @Column(name = "CODIGODCB")
    private String codigodcb;
    @Column(name = "DESCRICAODCB")
    private String descricaodcb;
    @Column(name = "PRINCIPIOATIVO")
    private String principioativo;
    @Column(name = "APRESENTACAO")
    private String apresentacao;
    @Column(name = "FLAGCONTROLADO")
    private Character flagcontrolado;
    @Column(name = "FLAGFARMACIAPOPULAR")
    private Character flagfarmaciapopular;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ALIQDESCPOPULAR")
    private BigDecimal aliqdescpopular;
    @Column(name = "REGISTROMS")
    private String registroms;
    @Column(name = "CODIGOINSUMO")
    private String codigoinsumo;
    @Column(name = "UNIDADEINSUMO")
    private String unidadeinsumo;
    @Column(name = "FLAGINSUMO")
    private Character flaginsumo;
    @Column(name = "UNMEDIDAMEDICAMENTO")
    private String unmedidamedicamento;
    @Column(name = "CLASSETERAPEUTICA")
    private String classeterapeutica;
    @Column(name = "USOPROLONGADO")
    private String usoprolongado;
    @JoinColumn(name = "CODPROD", referencedColumnName = "CODPROD", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Produto produto;

    public Produtopharma() {
    }

    public Produtopharma(String codprod) {
        this.codprod = codprod;
    }

    public String getCodprod() {
        return codprod;
    }

    public void setCodprod(String codprod) {
        this.codprod = codprod;
    }

    public String getCodigodcb() {
        return codigodcb;
    }

    public void setCodigodcb(String codigodcb) {
        this.codigodcb = codigodcb;
    }

    public String getDescricaodcb() {
        return descricaodcb;
    }

    public void setDescricaodcb(String descricaodcb) {
        this.descricaodcb = descricaodcb;
    }

    public String getPrincipioativo() {
        return principioativo;
    }

    public void setPrincipioativo(String principioativo) {
        this.principioativo = principioativo;
    }

    public String getApresentacao() {
        return apresentacao;
    }

    public void setApresentacao(String apresentacao) {
        this.apresentacao = apresentacao;
    }

    public Character getFlagcontrolado() {
        return flagcontrolado;
    }

    public void setFlagcontrolado(Character flagcontrolado) {
        this.flagcontrolado = flagcontrolado;
    }

    public Character getFlagfarmaciapopular() {
        return flagfarmaciapopular;
    }

    public void setFlagfarmaciapopular(Character flagfarmaciapopular) {
        this.flagfarmaciapopular = flagfarmaciapopular;
    }

    public BigDecimal getAliqdescpopular() {
        return aliqdescpopular;
    }

    public void setAliqdescpopular(BigDecimal aliqdescpopular) {
        this.aliqdescpopular = aliqdescpopular;
    }

    public String getRegistroms() {
        return registroms;
    }

    public void setRegistroms(String registroms) {
        this.registroms = registroms;
    }

    public String getCodigoinsumo() {
        return codigoinsumo;
    }

    public void setCodigoinsumo(String codigoinsumo) {
        this.codigoinsumo = codigoinsumo;
    }

    public String getUnidadeinsumo() {
        return unidadeinsumo;
    }

    public void setUnidadeinsumo(String unidadeinsumo) {
        this.unidadeinsumo = unidadeinsumo;
    }

    public Character getFlaginsumo() {
        return flaginsumo;
    }

    public void setFlaginsumo(Character flaginsumo) {
        this.flaginsumo = flaginsumo;
    }

    public String getUnmedidamedicamento() {
        return unmedidamedicamento;
    }

    public void setUnmedidamedicamento(String unmedidamedicamento) {
        this.unmedidamedicamento = unmedidamedicamento;
    }

    public String getClasseterapeutica() {
        return classeterapeutica;
    }

    public void setClasseterapeutica(String classeterapeutica) {
        this.classeterapeutica = classeterapeutica;
    }

    public String getUsoprolongado() {
        return usoprolongado;
    }

    public void setUsoprolongado(String usoprolongado) {
        this.usoprolongado = usoprolongado;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codprod != null ? codprod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produtopharma)) {
            return false;
        }
        Produtopharma other = (Produtopharma) object;
        if ((this.codprod == null && other.codprod != null) || (this.codprod != null && !this.codprod.equals(other.codprod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Produtopharma[ codprod=" + codprod + " ]";
    }
    
}
