/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "TMP_ASSISTENTECOMPRAPRODUTO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TmpAssistentecompraproduto.findAll", query = "SELECT t FROM TmpAssistentecompraproduto t")
    , @NamedQuery(name = "TmpAssistentecompraproduto.findByCodprod", query = "SELECT t FROM TmpAssistentecompraproduto t WHERE t.tmpAssistentecompraprodutoPK.codprod = :codprod")
    , @NamedQuery(name = "TmpAssistentecompraproduto.findByVendasperiodo1", query = "SELECT t FROM TmpAssistentecompraproduto t WHERE t.vendasperiodo1 = :vendasperiodo1")
    , @NamedQuery(name = "TmpAssistentecompraproduto.findByVendasperiodo2", query = "SELECT t FROM TmpAssistentecompraproduto t WHERE t.vendasperiodo2 = :vendasperiodo2")
    , @NamedQuery(name = "TmpAssistentecompraproduto.findByVendasperiodo3", query = "SELECT t FROM TmpAssistentecompraproduto t WHERE t.vendasperiodo3 = :vendasperiodo3")
    , @NamedQuery(name = "TmpAssistentecompraproduto.findByVendasmes", query = "SELECT t FROM TmpAssistentecompraproduto t WHERE t.vendasmes = :vendasmes")
    , @NamedQuery(name = "TmpAssistentecompraproduto.findByCodempresa", query = "SELECT t FROM TmpAssistentecompraproduto t WHERE t.tmpAssistentecompraprodutoPK.codempresa = :codempresa")
    , @NamedQuery(name = "TmpAssistentecompraproduto.findByQuantidadepedida", query = "SELECT t FROM TmpAssistentecompraproduto t WHERE t.quantidadepedida = :quantidadepedida")
    , @NamedQuery(name = "TmpAssistentecompraproduto.findBySugestao", query = "SELECT t FROM TmpAssistentecompraproduto t WHERE t.sugestao = :sugestao")
    , @NamedQuery(name = "TmpAssistentecompraproduto.findByDataultimavenda", query = "SELECT t FROM TmpAssistentecompraproduto t WHERE t.dataultimavenda = :dataultimavenda")
    , @NamedQuery(name = "TmpAssistentecompraproduto.findByMediavendida", query = "SELECT t FROM TmpAssistentecompraproduto t WHERE t.mediavendida = :mediavendida")
    , @NamedQuery(name = "TmpAssistentecompraproduto.findByQtdeideal", query = "SELECT t FROM TmpAssistentecompraproduto t WHERE t.qtdeideal = :qtdeideal")
    , @NamedQuery(name = "TmpAssistentecompraproduto.findByQtdemin", query = "SELECT t FROM TmpAssistentecompraproduto t WHERE t.qtdemin = :qtdemin")
    , @NamedQuery(name = "TmpAssistentecompraproduto.findByEstatu", query = "SELECT t FROM TmpAssistentecompraproduto t WHERE t.estatu = :estatu")
    , @NamedQuery(name = "TmpAssistentecompraproduto.findByQuantidadeareceber", query = "SELECT t FROM TmpAssistentecompraproduto t WHERE t.quantidadeareceber = :quantidadeareceber")
    , @NamedQuery(name = "TmpAssistentecompraproduto.findByQuantidadereservada", query = "SELECT t FROM TmpAssistentecompraproduto t WHERE t.quantidadereservada = :quantidadereservada")})
public class TmpAssistentecompraproduto implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TmpAssistentecompraprodutoPK tmpAssistentecompraprodutoPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VENDASPERIODO1")
    private BigDecimal vendasperiodo1;
    @Column(name = "VENDASPERIODO2")
    private BigDecimal vendasperiodo2;
    @Column(name = "VENDASPERIODO3")
    private BigDecimal vendasperiodo3;
    @Column(name = "VENDASMES")
    private BigDecimal vendasmes;
    @Column(name = "QUANTIDADEPEDIDA")
    private BigDecimal quantidadepedida;
    @Column(name = "SUGESTAO")
    private BigDecimal sugestao;
    @Column(name = "DATAULTIMAVENDA")
    @Temporal(TemporalType.DATE)
    private Date dataultimavenda;
    @Column(name = "MEDIAVENDIDA")
    private BigDecimal mediavendida;
    @Column(name = "QTDEIDEAL")
    private BigDecimal qtdeideal;
    @Column(name = "QTDEMIN")
    private BigDecimal qtdemin;
    @Column(name = "ESTATU")
    private BigDecimal estatu;
    @Column(name = "QUANTIDADEARECEBER")
    private BigDecimal quantidadeareceber;
    @Column(name = "QUANTIDADERESERVADA")
    private BigDecimal quantidadereservada;

    public TmpAssistentecompraproduto() {
    }

    public TmpAssistentecompraproduto(TmpAssistentecompraprodutoPK tmpAssistentecompraprodutoPK) {
        this.tmpAssistentecompraprodutoPK = tmpAssistentecompraprodutoPK;
    }

    public TmpAssistentecompraproduto(String codprod, int codempresa) {
        this.tmpAssistentecompraprodutoPK = new TmpAssistentecompraprodutoPK(codprod, codempresa);
    }

    public TmpAssistentecompraprodutoPK getTmpAssistentecompraprodutoPK() {
        return tmpAssistentecompraprodutoPK;
    }

    public void setTmpAssistentecompraprodutoPK(TmpAssistentecompraprodutoPK tmpAssistentecompraprodutoPK) {
        this.tmpAssistentecompraprodutoPK = tmpAssistentecompraprodutoPK;
    }

    public BigDecimal getVendasperiodo1() {
        return vendasperiodo1;
    }

    public void setVendasperiodo1(BigDecimal vendasperiodo1) {
        this.vendasperiodo1 = vendasperiodo1;
    }

    public BigDecimal getVendasperiodo2() {
        return vendasperiodo2;
    }

    public void setVendasperiodo2(BigDecimal vendasperiodo2) {
        this.vendasperiodo2 = vendasperiodo2;
    }

    public BigDecimal getVendasperiodo3() {
        return vendasperiodo3;
    }

    public void setVendasperiodo3(BigDecimal vendasperiodo3) {
        this.vendasperiodo3 = vendasperiodo3;
    }

    public BigDecimal getVendasmes() {
        return vendasmes;
    }

    public void setVendasmes(BigDecimal vendasmes) {
        this.vendasmes = vendasmes;
    }

    public BigDecimal getQuantidadepedida() {
        return quantidadepedida;
    }

    public void setQuantidadepedida(BigDecimal quantidadepedida) {
        this.quantidadepedida = quantidadepedida;
    }

    public BigDecimal getSugestao() {
        return sugestao;
    }

    public void setSugestao(BigDecimal sugestao) {
        this.sugestao = sugestao;
    }

    public Date getDataultimavenda() {
        return dataultimavenda;
    }

    public void setDataultimavenda(Date dataultimavenda) {
        this.dataultimavenda = dataultimavenda;
    }

    public BigDecimal getMediavendida() {
        return mediavendida;
    }

    public void setMediavendida(BigDecimal mediavendida) {
        this.mediavendida = mediavendida;
    }

    public BigDecimal getQtdeideal() {
        return qtdeideal;
    }

    public void setQtdeideal(BigDecimal qtdeideal) {
        this.qtdeideal = qtdeideal;
    }

    public BigDecimal getQtdemin() {
        return qtdemin;
    }

    public void setQtdemin(BigDecimal qtdemin) {
        this.qtdemin = qtdemin;
    }

    public BigDecimal getEstatu() {
        return estatu;
    }

    public void setEstatu(BigDecimal estatu) {
        this.estatu = estatu;
    }

    public BigDecimal getQuantidadeareceber() {
        return quantidadeareceber;
    }

    public void setQuantidadeareceber(BigDecimal quantidadeareceber) {
        this.quantidadeareceber = quantidadeareceber;
    }

    public BigDecimal getQuantidadereservada() {
        return quantidadereservada;
    }

    public void setQuantidadereservada(BigDecimal quantidadereservada) {
        this.quantidadereservada = quantidadereservada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tmpAssistentecompraprodutoPK != null ? tmpAssistentecompraprodutoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TmpAssistentecompraproduto)) {
            return false;
        }
        TmpAssistentecompraproduto other = (TmpAssistentecompraproduto) object;
        if ((this.tmpAssistentecompraprodutoPK == null && other.tmpAssistentecompraprodutoPK != null) || (this.tmpAssistentecompraprodutoPK != null && !this.tmpAssistentecompraprodutoPK.equals(other.tmpAssistentecompraprodutoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.TmpAssistentecompraproduto[ tmpAssistentecompraprodutoPK=" + tmpAssistentecompraprodutoPK + " ]";
    }
    
}
