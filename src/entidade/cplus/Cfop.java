/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
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
 * @author leo
 */
@Entity
@Table(name = "CFOP", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cfop.findAll", query = "SELECT c FROM Cfop c")
    , @NamedQuery(name = "Cfop.findByCodcfop", query = "SELECT c FROM Cfop c WHERE c.codcfop = :codcfop")
    , @NamedQuery(name = "Cfop.findByDescricao", query = "SELECT c FROM Cfop c WHERE c.descricao = :descricao")
    , @NamedQuery(name = "Cfop.findByFlagalteraestoque", query = "SELECT c FROM Cfop c WHERE c.flagalteraestoque = :flagalteraestoque")
    , @NamedQuery(name = "Cfop.findByFlagtipo", query = "SELECT c FROM Cfop c WHERE c.flagtipo = :flagtipo")
    , @NamedQuery(name = "Cfop.findByFlagoperacao", query = "SELECT c FROM Cfop c WHERE c.flagoperacao = :flagoperacao")
    , @NamedQuery(name = "Cfop.findByFlagcalculaipi", query = "SELECT c FROM Cfop c WHERE c.flagcalculaipi = :flagcalculaipi")
    , @NamedQuery(name = "Cfop.findByCodigonatoperalterdata", query = "SELECT c FROM Cfop c WHERE c.codigonatoperalterdata = :codigonatoperalterdata")})
public class Cfop implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCFOP")
    private String codcfop;
    @Column(name = "DESCRICAO")
    private String descricao;
    @Column(name = "FLAGALTERAESTOQUE")
    private Character flagalteraestoque;
    @Column(name = "FLAGTIPO")
    private Character flagtipo;
    @Column(name = "FLAGOPERACAO")
    private Character flagoperacao;
    @Column(name = "FLAGCALCULAIPI")
    private Character flagcalculaipi;
    @Column(name = "CODIGONATOPERALTERDATA")
    private String codigonatoperalterdata;
    @OneToMany(mappedBy = "codcfop")
    private Collection<Moventrada> moventradaCollection;
    @OneToMany(mappedBy = "codcfop")
    private Collection<Calculoicmsestado> calculoicmsestadoCollection;
    @OneToMany(mappedBy = "codcfop")
    private Collection<Moventradaprod> moventradaprodCollection;
    @OneToMany(mappedBy = "codcfop")
    private Collection<Pedidoitem> pedidoitemCollection;
    @OneToMany(mappedBy = "codcfop")
    private Collection<Documento> documentoCollection;
    @OneToMany(mappedBy = "codcfopequivalente")
    private Collection<Cfop> cfopCollection;
    @JoinColumn(name = "CODCFOPEQUIVALENTE", referencedColumnName = "CODCFOP")
    @ManyToOne
    private Cfop codcfopequivalente;
    @OneToMany(mappedBy = "codcfopdevolucao")
    private Collection<Cfop> cfopCollection1;
    @JoinColumn(name = "CODCFOPDEVOLUCAO", referencedColumnName = "CODCFOP")
    @ManyToOne
    private Cfop codcfopdevolucao;
    @OneToMany(mappedBy = "codcfop")
    private Collection<Movendaprod> movendaprodCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codcfop")
    private Collection<Regracfopitem> regracfopitemCollection;
    @OneToMany(mappedBy = "codcfop")
    private Collection<Movenda> movendaCollection;
    @OneToMany(mappedBy = "codcfop")
    private Collection<Pedido> pedidoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codcfop")
    private Collection<Planocontacfop> planocontacfopCollection;

    public Cfop() {
    }

    public Cfop(String codcfop) {
        this.codcfop = codcfop;
    }

    public String getCodcfop() {
        return codcfop;
    }

    public void setCodcfop(String codcfop) {
        this.codcfop = codcfop;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Character getFlagalteraestoque() {
        return flagalteraestoque;
    }

    public void setFlagalteraestoque(Character flagalteraestoque) {
        this.flagalteraestoque = flagalteraestoque;
    }

    public Character getFlagtipo() {
        return flagtipo;
    }

    public void setFlagtipo(Character flagtipo) {
        this.flagtipo = flagtipo;
    }

    public Character getFlagoperacao() {
        return flagoperacao;
    }

    public void setFlagoperacao(Character flagoperacao) {
        this.flagoperacao = flagoperacao;
    }

    public Character getFlagcalculaipi() {
        return flagcalculaipi;
    }

    public void setFlagcalculaipi(Character flagcalculaipi) {
        this.flagcalculaipi = flagcalculaipi;
    }

    public String getCodigonatoperalterdata() {
        return codigonatoperalterdata;
    }

    public void setCodigonatoperalterdata(String codigonatoperalterdata) {
        this.codigonatoperalterdata = codigonatoperalterdata;
    }

    @XmlTransient
    public Collection<Moventrada> getMoventradaCollection() {
        return moventradaCollection;
    }

    public void setMoventradaCollection(Collection<Moventrada> moventradaCollection) {
        this.moventradaCollection = moventradaCollection;
    }

    @XmlTransient
    public Collection<Calculoicmsestado> getCalculoicmsestadoCollection() {
        return calculoicmsestadoCollection;
    }

    public void setCalculoicmsestadoCollection(Collection<Calculoicmsestado> calculoicmsestadoCollection) {
        this.calculoicmsestadoCollection = calculoicmsestadoCollection;
    }

    @XmlTransient
    public Collection<Moventradaprod> getMoventradaprodCollection() {
        return moventradaprodCollection;
    }

    public void setMoventradaprodCollection(Collection<Moventradaprod> moventradaprodCollection) {
        this.moventradaprodCollection = moventradaprodCollection;
    }

    @XmlTransient
    public Collection<Pedidoitem> getPedidoitemCollection() {
        return pedidoitemCollection;
    }

    public void setPedidoitemCollection(Collection<Pedidoitem> pedidoitemCollection) {
        this.pedidoitemCollection = pedidoitemCollection;
    }

    @XmlTransient
    public Collection<Documento> getDocumentoCollection() {
        return documentoCollection;
    }

    public void setDocumentoCollection(Collection<Documento> documentoCollection) {
        this.documentoCollection = documentoCollection;
    }

    @XmlTransient
    public Collection<Cfop> getCfopCollection() {
        return cfopCollection;
    }

    public void setCfopCollection(Collection<Cfop> cfopCollection) {
        this.cfopCollection = cfopCollection;
    }

    public Cfop getCodcfopequivalente() {
        return codcfopequivalente;
    }

    public void setCodcfopequivalente(Cfop codcfopequivalente) {
        this.codcfopequivalente = codcfopequivalente;
    }

    @XmlTransient
    public Collection<Cfop> getCfopCollection1() {
        return cfopCollection1;
    }

    public void setCfopCollection1(Collection<Cfop> cfopCollection1) {
        this.cfopCollection1 = cfopCollection1;
    }

    public Cfop getCodcfopdevolucao() {
        return codcfopdevolucao;
    }

    public void setCodcfopdevolucao(Cfop codcfopdevolucao) {
        this.codcfopdevolucao = codcfopdevolucao;
    }

    @XmlTransient
    public Collection<Movendaprod> getMovendaprodCollection() {
        return movendaprodCollection;
    }

    public void setMovendaprodCollection(Collection<Movendaprod> movendaprodCollection) {
        this.movendaprodCollection = movendaprodCollection;
    }

    @XmlTransient
    public Collection<Regracfopitem> getRegracfopitemCollection() {
        return regracfopitemCollection;
    }

    public void setRegracfopitemCollection(Collection<Regracfopitem> regracfopitemCollection) {
        this.regracfopitemCollection = regracfopitemCollection;
    }

    @XmlTransient
    public Collection<Movenda> getMovendaCollection() {
        return movendaCollection;
    }

    public void setMovendaCollection(Collection<Movenda> movendaCollection) {
        this.movendaCollection = movendaCollection;
    }

    @XmlTransient
    public Collection<Pedido> getPedidoCollection() {
        return pedidoCollection;
    }

    public void setPedidoCollection(Collection<Pedido> pedidoCollection) {
        this.pedidoCollection = pedidoCollection;
    }

    @XmlTransient
    public Collection<Planocontacfop> getPlanocontacfopCollection() {
        return planocontacfopCollection;
    }

    public void setPlanocontacfopCollection(Collection<Planocontacfop> planocontacfopCollection) {
        this.planocontacfopCollection = planocontacfopCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcfop != null ? codcfop.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cfop)) {
            return false;
        }
        Cfop other = (Cfop) object;
        if ((this.codcfop == null && other.codcfop != null) || (this.codcfop != null && !this.codcfop.equals(other.codcfop))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Cfop[ codcfop=" + codcfop + " ]";
    }
    
}
