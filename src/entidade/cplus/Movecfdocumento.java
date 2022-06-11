/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "MOVECFDOCUMENTO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movecfdocumento.findAll", query = "SELECT m FROM Movecfdocumento m")
    , @NamedQuery(name = "Movecfdocumento.findByCodmovecfdocumento", query = "SELECT m FROM Movecfdocumento m WHERE m.codmovecfdocumento = :codmovecfdocumento")
    , @NamedQuery(name = "Movecfdocumento.findByCodecf", query = "SELECT m FROM Movecfdocumento m WHERE m.codecf = :codecf")
    , @NamedQuery(name = "Movecfdocumento.findByNumeroserieecf", query = "SELECT m FROM Movecfdocumento m WHERE m.numeroserieecf = :numeroserieecf")
    , @NamedQuery(name = "Movecfdocumento.findByNumerousuario", query = "SELECT m FROM Movecfdocumento m WHERE m.numerousuario = :numerousuario")
    , @NamedQuery(name = "Movecfdocumento.findByCcf", query = "SELECT m FROM Movecfdocumento m WHERE m.ccf = :ccf")
    , @NamedQuery(name = "Movecfdocumento.findByCoo", query = "SELECT m FROM Movecfdocumento m WHERE m.coo = :coo")
    , @NamedQuery(name = "Movecfdocumento.findByDataemissao", query = "SELECT m FROM Movecfdocumento m WHERE m.dataemissao = :dataemissao")
    , @NamedQuery(name = "Movecfdocumento.findByValortotalbruto", query = "SELECT m FROM Movecfdocumento m WHERE m.valortotalbruto = :valortotalbruto")
    , @NamedQuery(name = "Movecfdocumento.findByValordesconto", query = "SELECT m FROM Movecfdocumento m WHERE m.valordesconto = :valordesconto")
    , @NamedQuery(name = "Movecfdocumento.findByValoracrescimo", query = "SELECT m FROM Movecfdocumento m WHERE m.valoracrescimo = :valoracrescimo")
    , @NamedQuery(name = "Movecfdocumento.findByValortotalliquido", query = "SELECT m FROM Movecfdocumento m WHERE m.valortotalliquido = :valortotalliquido")
    , @NamedQuery(name = "Movecfdocumento.findByFlagcancelado", query = "SELECT m FROM Movecfdocumento m WHERE m.flagcancelado = :flagcancelado")
    , @NamedQuery(name = "Movecfdocumento.findByValorcancelamentoacrescimo", query = "SELECT m FROM Movecfdocumento m WHERE m.valorcancelamentoacrescimo = :valorcancelamentoacrescimo")
    , @NamedQuery(name = "Movecfdocumento.findByFlagordemacrescimodesconto", query = "SELECT m FROM Movecfdocumento m WHERE m.flagordemacrescimodesconto = :flagordemacrescimodesconto")
    , @NamedQuery(name = "Movecfdocumento.findByNomeadquirente", query = "SELECT m FROM Movecfdocumento m WHERE m.nomeadquirente = :nomeadquirente")
    , @NamedQuery(name = "Movecfdocumento.findByCpfCnpjadquirente", query = "SELECT m FROM Movecfdocumento m WHERE m.cpfCnpjadquirente = :cpfCnpjadquirente")
    , @NamedQuery(name = "Movecfdocumento.findByGuid", query = "SELECT m FROM Movecfdocumento m WHERE m.guid = :guid")
    , @NamedQuery(name = "Movecfdocumento.findByNumerocaixa", query = "SELECT m FROM Movecfdocumento m WHERE m.numerocaixa = :numerocaixa")
    , @NamedQuery(name = "Movecfdocumento.findByHoraemissao", query = "SELECT m FROM Movecfdocumento m WHERE m.horaemissao = :horaemissao")
    , @NamedQuery(name = "Movecfdocumento.findByTipoecf", query = "SELECT m FROM Movecfdocumento m WHERE m.tipoecf = :tipoecf")
    , @NamedQuery(name = "Movecfdocumento.findByMarcaecf", query = "SELECT m FROM Movecfdocumento m WHERE m.marcaecf = :marcaecf")
    , @NamedQuery(name = "Movecfdocumento.findByModeloecf", query = "SELECT m FROM Movecfdocumento m WHERE m.modeloecf = :modeloecf")
    , @NamedQuery(name = "Movecfdocumento.findByFlagaltpaf", query = "SELECT m FROM Movecfdocumento m WHERE m.flagaltpaf = :flagaltpaf")})
public class Movecfdocumento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODMOVECFDOCUMENTO")
    private String codmovecfdocumento;
    @Column(name = "CODECF")
    private String codecf;
    @Column(name = "NUMEROSERIEECF")
    private String numeroserieecf;
    @Column(name = "NUMEROUSUARIO")
    private Integer numerousuario;
    @Column(name = "CCF")
    private Integer ccf;
    @Column(name = "COO")
    private Integer coo;
    @Column(name = "DATAEMISSAO")
    @Temporal(TemporalType.DATE)
    private Date dataemissao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALORTOTALBRUTO")
    private BigDecimal valortotalbruto;
    @Column(name = "VALORDESCONTO")
    private BigDecimal valordesconto;
    @Column(name = "VALORACRESCIMO")
    private BigDecimal valoracrescimo;
    @Column(name = "VALORTOTALLIQUIDO")
    private BigDecimal valortotalliquido;
    @Column(name = "FLAGCANCELADO")
    private Character flagcancelado;
    @Column(name = "VALORCANCELAMENTOACRESCIMO")
    private BigDecimal valorcancelamentoacrescimo;
    @Column(name = "FLAGORDEMACRESCIMODESCONTO")
    private Character flagordemacrescimodesconto;
    @Column(name = "NOMEADQUIRENTE")
    private String nomeadquirente;
    @Column(name = "CPF_CNPJADQUIRENTE")
    private String cpfCnpjadquirente;
    @Column(name = "GUID")
    private String guid;
    @Column(name = "NUMEROCAIXA")
    private Integer numerocaixa;
    @Column(name = "HORAEMISSAO")
    @Temporal(TemporalType.TIME)
    private Date horaemissao;
    @Column(name = "TIPOECF")
    private String tipoecf;
    @Column(name = "MARCAECF")
    private String marcaecf;
    @Column(name = "MODELOECF")
    private String modeloecf;
    @Column(name = "FLAGALTPAF")
    private Character flagaltpaf;
    @JoinColumn(name = "CODCLI", referencedColumnName = "CODCLI")
    @ManyToOne
    private Cliente codcli;
    @JoinColumn(name = "CODEMPRESA", referencedColumnName = "CODEMPRESA")
    @ManyToOne
    private Empresa codempresa;
    @JoinColumn(name = "CODMOVENDA", referencedColumnName = "CODMOVENDA")
    @ManyToOne
    private Movenda codmovenda;
    @OneToMany(mappedBy = "codmovecfdocumento")
    private Collection<Movecfdocumentoitem> movecfdocumentoitemCollection;

    public Movecfdocumento() {
    }

    public Movecfdocumento(String codmovecfdocumento) {
        this.codmovecfdocumento = codmovecfdocumento;
    }

    public String getCodmovecfdocumento() {
        return codmovecfdocumento;
    }

    public void setCodmovecfdocumento(String codmovecfdocumento) {
        this.codmovecfdocumento = codmovecfdocumento;
    }

    public String getCodecf() {
        return codecf;
    }

    public void setCodecf(String codecf) {
        this.codecf = codecf;
    }

    public String getNumeroserieecf() {
        return numeroserieecf;
    }

    public void setNumeroserieecf(String numeroserieecf) {
        this.numeroserieecf = numeroserieecf;
    }

    public Integer getNumerousuario() {
        return numerousuario;
    }

    public void setNumerousuario(Integer numerousuario) {
        this.numerousuario = numerousuario;
    }

    public Integer getCcf() {
        return ccf;
    }

    public void setCcf(Integer ccf) {
        this.ccf = ccf;
    }

    public Integer getCoo() {
        return coo;
    }

    public void setCoo(Integer coo) {
        this.coo = coo;
    }

    public Date getDataemissao() {
        return dataemissao;
    }

    public void setDataemissao(Date dataemissao) {
        this.dataemissao = dataemissao;
    }

    public BigDecimal getValortotalbruto() {
        return valortotalbruto;
    }

    public void setValortotalbruto(BigDecimal valortotalbruto) {
        this.valortotalbruto = valortotalbruto;
    }

    public BigDecimal getValordesconto() {
        return valordesconto;
    }

    public void setValordesconto(BigDecimal valordesconto) {
        this.valordesconto = valordesconto;
    }

    public BigDecimal getValoracrescimo() {
        return valoracrescimo;
    }

    public void setValoracrescimo(BigDecimal valoracrescimo) {
        this.valoracrescimo = valoracrescimo;
    }

    public BigDecimal getValortotalliquido() {
        return valortotalliquido;
    }

    public void setValortotalliquido(BigDecimal valortotalliquido) {
        this.valortotalliquido = valortotalliquido;
    }

    public Character getFlagcancelado() {
        return flagcancelado;
    }

    public void setFlagcancelado(Character flagcancelado) {
        this.flagcancelado = flagcancelado;
    }

    public BigDecimal getValorcancelamentoacrescimo() {
        return valorcancelamentoacrescimo;
    }

    public void setValorcancelamentoacrescimo(BigDecimal valorcancelamentoacrescimo) {
        this.valorcancelamentoacrescimo = valorcancelamentoacrescimo;
    }

    public Character getFlagordemacrescimodesconto() {
        return flagordemacrescimodesconto;
    }

    public void setFlagordemacrescimodesconto(Character flagordemacrescimodesconto) {
        this.flagordemacrescimodesconto = flagordemacrescimodesconto;
    }

    public String getNomeadquirente() {
        return nomeadquirente;
    }

    public void setNomeadquirente(String nomeadquirente) {
        this.nomeadquirente = nomeadquirente;
    }

    public String getCpfCnpjadquirente() {
        return cpfCnpjadquirente;
    }

    public void setCpfCnpjadquirente(String cpfCnpjadquirente) {
        this.cpfCnpjadquirente = cpfCnpjadquirente;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Integer getNumerocaixa() {
        return numerocaixa;
    }

    public void setNumerocaixa(Integer numerocaixa) {
        this.numerocaixa = numerocaixa;
    }

    public Date getHoraemissao() {
        return horaemissao;
    }

    public void setHoraemissao(Date horaemissao) {
        this.horaemissao = horaemissao;
    }

    public String getTipoecf() {
        return tipoecf;
    }

    public void setTipoecf(String tipoecf) {
        this.tipoecf = tipoecf;
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

    public Character getFlagaltpaf() {
        return flagaltpaf;
    }

    public void setFlagaltpaf(Character flagaltpaf) {
        this.flagaltpaf = flagaltpaf;
    }

    public Cliente getCodcli() {
        return codcli;
    }

    public void setCodcli(Cliente codcli) {
        this.codcli = codcli;
    }

    public Empresa getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Empresa codempresa) {
        this.codempresa = codempresa;
    }

    public Movenda getCodmovenda() {
        return codmovenda;
    }

    public void setCodmovenda(Movenda codmovenda) {
        this.codmovenda = codmovenda;
    }

    @XmlTransient
    public Collection<Movecfdocumentoitem> getMovecfdocumentoitemCollection() {
        return movecfdocumentoitemCollection;
    }

    public void setMovecfdocumentoitemCollection(Collection<Movecfdocumentoitem> movecfdocumentoitemCollection) {
        this.movecfdocumentoitemCollection = movecfdocumentoitemCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmovecfdocumento != null ? codmovecfdocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movecfdocumento)) {
            return false;
        }
        Movecfdocumento other = (Movecfdocumento) object;
        if ((this.codmovecfdocumento == null && other.codmovecfdocumento != null) || (this.codmovecfdocumento != null && !this.codmovecfdocumento.equals(other.codmovecfdocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Movecfdocumento[ codmovecfdocumento=" + codmovecfdocumento + " ]";
    }
    
}
