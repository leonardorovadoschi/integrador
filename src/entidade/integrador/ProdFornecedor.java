/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade.integrador;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leonardo
 */
@Entity
@Table(name = "prod_fornecedor")
@XmlRootElement

public class ProdFornecedor implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_produtos")
    private Integer idProdutos;   
    @Column(name = "preco_custo_com_st")
    private BigDecimal precoCustoComSt;
    @Column(name = "ativo")
    private Integer ativo;
    @Column(name = "categoria")
    private String categoria;
    @Column(name = "codigo_fornecedor")
    private String codigoFornecedor;
    @Column(name = "nome_fornecedor")
    private String nomeFornecedor;
    @Lob
    @Column(name = "descr_tec")
    private String descrTec;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "disponivel")
    private Integer disponivel;
    @Column(name = "ean")
    private String ean;
    @Column(name = "estoque")
    private String estoque;
    @Column(name = "fabricante")
    private String fabricante;
    @Column(name = "garantia")
    private Integer garantia;
    @Column(name = "valor_custo_rs")
    private BigDecimal valorCustoRs;
    @Column(name = "ncm")
    private String ncm;
    @Column(name = "origem_produto")
    private String origemProduto;
    @Column(name = "part_number")
    private String partNumber;
    @Column(name = "porcentagem_outros_custos")
    private BigDecimal porcentagemOutrosCustos;
    @Column(name = "preco_custo")
    private BigDecimal precoCusto;
    @Column(name = "valor_st_rs")
    private BigDecimal valorStRs;
    @Column(name = "subcategoria")
    private String subcategoria;
    @Column(name = "subst_tributaria")
    private Integer substTributaria;
    @Column(name = "ultima_importacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimaImportacao;
    @Column(name = "url_foto_produto")
    private String urlFotoProduto;
    @Column(name = "procentagem_st_rs")
    private BigDecimal porcentagemStRs;
    @Column(name = "reference_cplus")
    private String referenceCplus;
    

    public ProdFornecedor() {
    }

    public ProdFornecedor(Integer idProdutos) {
        this.idProdutos = idProdutos;
    }

    public String getReferenceCplus() {
        return referenceCplus;
    }

    public void setReferenceCplus(String referenceCplus) {
        this.referenceCplus = referenceCplus;
    }
    
    

    public Integer getIdProdutos() {
        return idProdutos;
    }

    public void setIdProdutos(Integer idProdutos) {
        Integer oldIdProdutos = this.idProdutos;
        this.idProdutos = idProdutos;
        changeSupport.firePropertyChange("idProdutos", oldIdProdutos, idProdutos);
    }
   
    public Integer getAtivo() {
        return ativo;
    }

    public void setAtivo(Integer ativo) {
        Integer oldAtivo = this.ativo;
        this.ativo = ativo;
        changeSupport.firePropertyChange("ativo", oldAtivo, ativo);
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        String oldCategoria = this.categoria;
        this.categoria = categoria;
        changeSupport.firePropertyChange("categoria", oldCategoria, categoria);
    }

    public String getCodigoFornecedor() {
        return codigoFornecedor;
    }

    public void setCodigoFornecedor(String codigoFornecedor) {
        String oldCodigo = this.codigoFornecedor;
        this.codigoFornecedor = codigoFornecedor;
        changeSupport.firePropertyChange("codigo", oldCodigo, codigoFornecedor);
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        String oldDepartamento = this.nomeFornecedor;
        this.nomeFornecedor = nomeFornecedor;
        changeSupport.firePropertyChange("departamento", oldDepartamento, nomeFornecedor);
    }

    public String getDescrTec() {
        return descrTec;
    }

    public void setDescrTec(String descrTec) {
        String oldDescrTec = this.descrTec;
        this.descrTec = descrTec;
        changeSupport.firePropertyChange("descrTec", oldDescrTec, descrTec);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        String oldDescricao = this.descricao;
        this.descricao = descricao;
        changeSupport.firePropertyChange("descricao", oldDescricao, descricao);
    }

    public Integer getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Integer disponivel) {
        Integer oldDisponivel = this.disponivel;
        this.disponivel = disponivel;
        changeSupport.firePropertyChange("disponivel", oldDisponivel, disponivel);
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        String oldEan = this.ean;
        this.ean = ean;
        changeSupport.firePropertyChange("ean", oldEan, ean);
    }

    public String getEstoque() {
        return estoque;
    }

    public void setEstoque(String estoque) {
        String oldEstoque = this.estoque;
        this.estoque = estoque;
        changeSupport.firePropertyChange("estoque", oldEstoque, estoque);
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        String oldFabricante = this.fabricante;
        this.fabricante = fabricante;
        changeSupport.firePropertyChange("fabricante", oldFabricante, fabricante);
    }

    public Integer getGarantia() {
        return garantia;
    }

    public void setGarantia(Integer garantia) {
        Integer oldGarantia = this.garantia;
        this.garantia = garantia;
        changeSupport.firePropertyChange("garantia", oldGarantia, garantia);
    }
    
    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        String oldNcm = this.ncm;
        this.ncm = ncm;
        changeSupport.firePropertyChange("ncm", oldNcm, ncm);
    }

    public String getOrigemProduto() {
        return origemProduto;
    }

    public void setOrigemProduto(String origemProduto) {
        String oldOrigemProduto = this.origemProduto;
        this.origemProduto = origemProduto;
        changeSupport.firePropertyChange("origemProduto", oldOrigemProduto, origemProduto);
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        String oldPartNumber = this.partNumber;
        this.partNumber = partNumber;
        changeSupport.firePropertyChange("partNumber", oldPartNumber, partNumber);
    }

    public BigDecimal getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(BigDecimal precoCusto) {
        BigDecimal oldPrecoCusto = this.precoCusto;
        this.precoCusto = precoCusto;
        changeSupport.firePropertyChange("precoCusto", oldPrecoCusto, precoCusto);
    }

    public BigDecimal getValorStRs() {
        return valorStRs;
    }

    public void setValorStRs(BigDecimal valorStRs) {
        BigDecimal oldValorStRs = this.valorStRs;
        this.valorStRs = valorStRs;
        changeSupport.firePropertyChange("valorStRs", oldValorStRs, valorStRs);
    }

    public BigDecimal getPorcentagemStRs() {
        return porcentagemStRs;
    }

    public void setPorcentagemStRs(BigDecimal porcentagemStRs) {
        BigDecimal oldPorcentagemStRs = this.porcentagemStRs;
        this.porcentagemStRs = porcentagemStRs;
        changeSupport.firePropertyChange("porcentagemStRs", oldPorcentagemStRs, porcentagemStRs);
    }
  

    public String getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(String subcategoria) {
        String oldSubcategoria = this.subcategoria;
        this.subcategoria = subcategoria;
        changeSupport.firePropertyChange("subcategoria", oldSubcategoria, subcategoria);
    }

    public Integer getSubstTributaria() {
        return substTributaria;
    }

    public void setSubstTributaria(Integer substTributaria) {
        Integer oldSubstTributaria = this.substTributaria;
        this.substTributaria = substTributaria;
        changeSupport.firePropertyChange("substTributaria", oldSubstTributaria, substTributaria);
    }

    public Date getUltimaImportacao() {
        return ultimaImportacao;
    }

    public void setUltimaImportacao(Date ultimaImportacao) {
        Date oldUltimaImportacao = this.ultimaImportacao;
        this.ultimaImportacao = ultimaImportacao;
        changeSupport.firePropertyChange("ultimaImportacao", oldUltimaImportacao, ultimaImportacao);
    }

    public BigDecimal getPrecoCustoComSt() {
        return precoCustoComSt;
    }

    public void setPrecoCustoComSt(BigDecimal precoCustoComSt) {
        BigDecimal oldPrecoCustoComSt = this.precoCustoComSt;
        this.precoCustoComSt = precoCustoComSt;
        changeSupport.firePropertyChange("precoCustoComSt", oldPrecoCustoComSt, precoCustoComSt);
    }

    public BigDecimal getValorCustoRs() {
        return valorCustoRs;
    }

    public void setValorCustoRs(BigDecimal valorCustoRs) {
        BigDecimal oldValorCustoRs = this.valorCustoRs;
        this.valorCustoRs = valorCustoRs;
        changeSupport.firePropertyChange("valorCustoRs", oldValorCustoRs, valorCustoRs);
    }

    public BigDecimal getPorcentagemOutrosCustos() {
        return porcentagemOutrosCustos;
    }

    public void setPorcentagemOutrosCustos(BigDecimal porcentagemOutrosCustos) {
        BigDecimal oldPorcentagemOutrosCustos = this.porcentagemOutrosCustos;
        this.porcentagemOutrosCustos = porcentagemOutrosCustos;
        changeSupport.firePropertyChange("porcentagemOutrosCustos", oldPorcentagemOutrosCustos, porcentagemOutrosCustos);
    }
   

    public String getUrlFotoProduto() {
        return urlFotoProduto;
    }

    public void setUrlFotoProduto(String urlFotoProduto) {
        String oldUrlFotoProduto = this.urlFotoProduto;
        this.urlFotoProduto = urlFotoProduto;
        changeSupport.firePropertyChange("urlFotoProduto", oldUrlFotoProduto, urlFotoProduto);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProdutos != null ? idProdutos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProdFornecedor)) {
            return false;
        }
        ProdFornecedor other = (ProdFornecedor) object;
        if ((this.idProdutos == null && other.idProdutos != null) || (this.idProdutos != null && !this.idProdutos.equals(other.idProdutos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.integrador.ProdutosAllnations[ idProdutos=" + idProdutos + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
