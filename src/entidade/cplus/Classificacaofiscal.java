/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "CLASSIFICACAOFISCAL", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Classificacaofiscal.findAll", query = "SELECT c FROM Classificacaofiscal c")
    , @NamedQuery(name = "Classificacaofiscal.findByCodclassificacaofiscal", query = "SELECT c FROM Classificacaofiscal c WHERE c.codclassificacaofiscal = :codclassificacaofiscal")
    , @NamedQuery(name = "Classificacaofiscal.findByCodigoclassificacaofiscal", query = "SELECT c FROM Classificacaofiscal c WHERE c.codigoclassificacaofiscal = :codigoclassificacaofiscal")
    , @NamedQuery(name = "Classificacaofiscal.findByCodigo", query = "SELECT c FROM Classificacaofiscal c WHERE c.codigo = :codigo")
    , @NamedQuery(name = "Classificacaofiscal.findByAliqipi", query = "SELECT c FROM Classificacaofiscal c WHERE c.aliqipi = :aliqipi")
    , @NamedQuery(name = "Classificacaofiscal.findByFlagtipointegracaoescritafical", query = "SELECT c FROM Classificacaofiscal c WHERE c.flagtipointegracaoescritafical = :flagtipointegracaoescritafical")
    , @NamedQuery(name = "Classificacaofiscal.findByGrupo", query = "SELECT c FROM Classificacaofiscal c WHERE c.grupo = :grupo")
    , @NamedQuery(name = "Classificacaofiscal.findByAliqlucrodentrouf", query = "SELECT c FROM Classificacaofiscal c WHERE c.aliqlucrodentrouf = :aliqlucrodentrouf")
    , @NamedQuery(name = "Classificacaofiscal.findByAliqlucroforauf", query = "SELECT c FROM Classificacaofiscal c WHERE c.aliqlucroforauf = :aliqlucroforauf")
    , @NamedQuery(name = "Classificacaofiscal.findByAliqii", query = "SELECT c FROM Classificacaofiscal c WHERE c.aliqii = :aliqii")
    , @NamedQuery(name = "Classificacaofiscal.findByValoripiunidade", query = "SELECT c FROM Classificacaofiscal c WHERE c.valoripiunidade = :valoripiunidade")
    , @NamedQuery(name = "Classificacaofiscal.findByFatorconversaounidade", query = "SELECT c FROM Classificacaofiscal c WHERE c.fatorconversaounidade = :fatorconversaounidade")
    , @NamedQuery(name = "Classificacaofiscal.findByFlagipiporunidade", query = "SELECT c FROM Classificacaofiscal c WHERE c.flagipiporunidade = :flagipiporunidade")
    , @NamedQuery(name = "Classificacaofiscal.findByFlagnaocalcula", query = "SELECT c FROM Classificacaofiscal c WHERE c.flagnaocalcula = :flagnaocalcula")
    , @NamedQuery(name = "Classificacaofiscal.findByFlagservico", query = "SELECT c FROM Classificacaofiscal c WHERE c.flagservico = :flagservico")
    , @NamedQuery(name = "Classificacaofiscal.findByEx", query = "SELECT c FROM Classificacaofiscal c WHERE c.ex = :ex")
    , @NamedQuery(name = "Classificacaofiscal.findByAliqnac", query = "SELECT c FROM Classificacaofiscal c WHERE c.aliqnac = :aliqnac")
    , @NamedQuery(name = "Classificacaofiscal.findByAliqimp", query = "SELECT c FROM Classificacaofiscal c WHERE c.aliqimp = :aliqimp")
    , @NamedQuery(name = "Classificacaofiscal.findByFlaginativo", query = "SELECT c FROM Classificacaofiscal c WHERE c.flaginativo = :flaginativo")})
public class Classificacaofiscal implements Serializable {

    @Column(name = "GUID")
    private String guid;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCLASSIFICACAOFISCAL")
    private String codclassificacaofiscal;
    @Column(name = "CODIGOCLASSIFICACAOFISCAL")
    private String codigoclassificacaofiscal;
    @Column(name = "CODIGO")
    private String codigo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ALIQIPI")
    private BigDecimal aliqipi;
    @Column(name = "FLAGTIPOINTEGRACAOESCRITAFICAL")
    private Character flagtipointegracaoescritafical;
    @Column(name = "GRUPO")
    private String grupo;
    @Column(name = "ALIQLUCRODENTROUF")
    private BigDecimal aliqlucrodentrouf;
    @Column(name = "ALIQLUCROFORAUF")
    private BigDecimal aliqlucroforauf;
    @Column(name = "ALIQII")
    private BigDecimal aliqii;
    @Lob
    @Column(name = "DESCRICAO")
    private String descricao;
    @Column(name = "VALORIPIUNIDADE")
    private BigDecimal valoripiunidade;
    @Column(name = "FATORCONVERSAOUNIDADE")
    private BigDecimal fatorconversaounidade;
    @Column(name = "FLAGIPIPORUNIDADE")
    private Character flagipiporunidade;
    @Column(name = "FLAGNAOCALCULA")
    private Character flagnaocalcula;
    @Column(name = "FLAGSERVICO")
    private Character flagservico;
    @Column(name = "EX")
    private Integer ex;
    @Column(name = "ALIQNAC")
    private BigDecimal aliqnac;
    @Column(name = "ALIQIMP")
    private BigDecimal aliqimp;
    @Column(name = "FLAGINATIVO")
    private Character flaginativo;
    @OneToMany(mappedBy = "codclassificacaofiscal")
    private Collection<Classificacaofiscaluf> classificacaofiscalufCollection;
    @JoinColumn(name = "CODCESTICMS", referencedColumnName = "CODCESTICMS")
    @ManyToOne
    private Cesticms codcesticms;
    @JoinColumn(name = "CODUNIDADE", referencedColumnName = "CODUNIDADE")
    @ManyToOne
    private Unidade codunidade;
    @OneToMany(mappedBy = "codclassificacaofiscal")
    private Collection<Pedidoitem> pedidoitemCollection;
    @OneToMany(mappedBy = "codclassificacaofiscal")
    private Collection<Empresatipodocumentocf> empresatipodocumentocfCollection;
    @OneToMany(mappedBy = "codclassificacaofiscal")
    private Collection<Regracfopitem> regracfopitemCollection;
    @OneToMany(mappedBy = "codclassificacaofiscal")
    private Collection<Produto> produtoCollection;

    public Classificacaofiscal() {
    }

    public Classificacaofiscal(String codclassificacaofiscal) {
        this.codclassificacaofiscal = codclassificacaofiscal;
    }

    public String getCodclassificacaofiscal() {
        return codclassificacaofiscal;
    }

    public void setCodclassificacaofiscal(String codclassificacaofiscal) {
        this.codclassificacaofiscal = codclassificacaofiscal;
    }

    public String getCodigoclassificacaofiscal() {
        return codigoclassificacaofiscal;
    }

    public void setCodigoclassificacaofiscal(String codigoclassificacaofiscal) {
        this.codigoclassificacaofiscal = codigoclassificacaofiscal;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getAliqipi() {
        return aliqipi;
    }

    public void setAliqipi(BigDecimal aliqipi) {
        this.aliqipi = aliqipi;
    }

    public Character getFlagtipointegracaoescritafical() {
        return flagtipointegracaoescritafical;
    }

    public void setFlagtipointegracaoescritafical(Character flagtipointegracaoescritafical) {
        this.flagtipointegracaoescritafical = flagtipointegracaoescritafical;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public BigDecimal getAliqlucrodentrouf() {
        return aliqlucrodentrouf;
    }

    public void setAliqlucrodentrouf(BigDecimal aliqlucrodentrouf) {
        this.aliqlucrodentrouf = aliqlucrodentrouf;
    }

    public BigDecimal getAliqlucroforauf() {
        return aliqlucroforauf;
    }

    public void setAliqlucroforauf(BigDecimal aliqlucroforauf) {
        this.aliqlucroforauf = aliqlucroforauf;
    }

    public BigDecimal getAliqii() {
        return aliqii;
    }

    public void setAliqii(BigDecimal aliqii) {
        this.aliqii = aliqii;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValoripiunidade() {
        return valoripiunidade;
    }

    public void setValoripiunidade(BigDecimal valoripiunidade) {
        this.valoripiunidade = valoripiunidade;
    }

    public BigDecimal getFatorconversaounidade() {
        return fatorconversaounidade;
    }

    public void setFatorconversaounidade(BigDecimal fatorconversaounidade) {
        this.fatorconversaounidade = fatorconversaounidade;
    }

    public Character getFlagipiporunidade() {
        return flagipiporunidade;
    }

    public void setFlagipiporunidade(Character flagipiporunidade) {
        this.flagipiporunidade = flagipiporunidade;
    }

    public Character getFlagnaocalcula() {
        return flagnaocalcula;
    }

    public void setFlagnaocalcula(Character flagnaocalcula) {
        this.flagnaocalcula = flagnaocalcula;
    }

    public Character getFlagservico() {
        return flagservico;
    }

    public void setFlagservico(Character flagservico) {
        this.flagservico = flagservico;
    }

    public Integer getEx() {
        return ex;
    }

    public void setEx(Integer ex) {
        this.ex = ex;
    }

    public BigDecimal getAliqnac() {
        return aliqnac;
    }

    public void setAliqnac(BigDecimal aliqnac) {
        this.aliqnac = aliqnac;
    }

    public BigDecimal getAliqimp() {
        return aliqimp;
    }

    public void setAliqimp(BigDecimal aliqimp) {
        this.aliqimp = aliqimp;
    }

    public Character getFlaginativo() {
        return flaginativo;
    }

    public void setFlaginativo(Character flaginativo) {
        this.flaginativo = flaginativo;
    }

    @XmlTransient
    public Collection<Classificacaofiscaluf> getClassificacaofiscalufCollection() {
        return classificacaofiscalufCollection;
    }

    public void setClassificacaofiscalufCollection(Collection<Classificacaofiscaluf> classificacaofiscalufCollection) {
        this.classificacaofiscalufCollection = classificacaofiscalufCollection;
    }

    public Cesticms getCodcesticms() {
        return codcesticms;
    }

    public void setCodcesticms(Cesticms codcesticms) {
        this.codcesticms = codcesticms;
    }

    public Unidade getCodunidade() {
        return codunidade;
    }

    public void setCodunidade(Unidade codunidade) {
        this.codunidade = codunidade;
    }

    @XmlTransient
    public Collection<Pedidoitem> getPedidoitemCollection() {
        return pedidoitemCollection;
    }

    public void setPedidoitemCollection(Collection<Pedidoitem> pedidoitemCollection) {
        this.pedidoitemCollection = pedidoitemCollection;
    }

    @XmlTransient
    public Collection<Empresatipodocumentocf> getEmpresatipodocumentocfCollection() {
        return empresatipodocumentocfCollection;
    }

    public void setEmpresatipodocumentocfCollection(Collection<Empresatipodocumentocf> empresatipodocumentocfCollection) {
        this.empresatipodocumentocfCollection = empresatipodocumentocfCollection;
    }

    @XmlTransient
    public Collection<Regracfopitem> getRegracfopitemCollection() {
        return regracfopitemCollection;
    }

    public void setRegracfopitemCollection(Collection<Regracfopitem> regracfopitemCollection) {
        this.regracfopitemCollection = regracfopitemCollection;
    }

    @XmlTransient
    public Collection<Produto> getProdutoCollection() {
        return produtoCollection;
    }

    public void setProdutoCollection(Collection<Produto> produtoCollection) {
        this.produtoCollection = produtoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codclassificacaofiscal != null ? codclassificacaofiscal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Classificacaofiscal)) {
            return false;
        }
        Classificacaofiscal other = (Classificacaofiscal) object;
        if ((this.codclassificacaofiscal == null && other.codclassificacaofiscal != null) || (this.codclassificacaofiscal != null && !this.codclassificacaofiscal.equals(other.codclassificacaofiscal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Classificacaofiscal[ codclassificacaofiscal=" + codclassificacaofiscal + " ]";
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }
    
}
