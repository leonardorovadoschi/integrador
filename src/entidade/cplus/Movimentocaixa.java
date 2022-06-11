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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "MOVIMENTOCAIXA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movimentocaixa.findAll", query = "SELECT m FROM Movimentocaixa m")
    , @NamedQuery(name = "Movimentocaixa.findByCodmovimentocaixa", query = "SELECT m FROM Movimentocaixa m WHERE m.codmovimentocaixa = :codmovimentocaixa")
    , @NamedQuery(name = "Movimentocaixa.findByValor", query = "SELECT m FROM Movimentocaixa m WHERE m.valor = :valor")
    , @NamedQuery(name = "Movimentocaixa.findByFlagtroco", query = "SELECT m FROM Movimentocaixa m WHERE m.flagtroco = :flagtroco")
    , @NamedQuery(name = "Movimentocaixa.findByMeiopagamento", query = "SELECT m FROM Movimentocaixa m WHERE m.meiopagamento = :meiopagamento")
    , @NamedQuery(name = "Movimentocaixa.findByFlagtipo", query = "SELECT m FROM Movimentocaixa m WHERE m.flagtipo = :flagtipo")
    , @NamedQuery(name = "Movimentocaixa.findByGuid", query = "SELECT m FROM Movimentocaixa m WHERE m.guid = :guid")
    , @NamedQuery(name = "Movimentocaixa.findByMeiopagamentoecf", query = "SELECT m FROM Movimentocaixa m WHERE m.meiopagamentoecf = :meiopagamentoecf")
    , @NamedQuery(name = "Movimentocaixa.findByFlagaltpaf", query = "SELECT m FROM Movimentocaixa m WHERE m.flagaltpaf = :flagaltpaf")})
public class Movimentocaixa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODMOVIMENTOCAIXA")
    private String codmovimentocaixa;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALOR")
    private BigDecimal valor;
    @Column(name = "FLAGTROCO")
    private Character flagtroco;
    @Column(name = "MEIOPAGAMENTO")
    private String meiopagamento;
    @Column(name = "FLAGTIPO")
    private Character flagtipo;
    @Column(name = "GUID")
    private String guid;
    @Column(name = "MEIOPAGAMENTOECF")
    private String meiopagamentoecf;
    @Column(name = "FLAGALTPAF")
    private Character flagaltpaf;
    @JoinColumn(name = "CODDOCUMENTOCAIXA", referencedColumnName = "CODDOCUMENTOCAIXA")
    @ManyToOne
    private Documentocaixa coddocumentocaixa;
    @JoinColumn(name = "CODREC", referencedColumnName = "CODREC")
    @ManyToOne
    private Recebimento codrec;

    public Movimentocaixa() {
    }

    public Movimentocaixa(String codmovimentocaixa) {
        this.codmovimentocaixa = codmovimentocaixa;
    }

    public String getCodmovimentocaixa() {
        return codmovimentocaixa;
    }

    public void setCodmovimentocaixa(String codmovimentocaixa) {
        this.codmovimentocaixa = codmovimentocaixa;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Character getFlagtroco() {
        return flagtroco;
    }

    public void setFlagtroco(Character flagtroco) {
        this.flagtroco = flagtroco;
    }

    public String getMeiopagamento() {
        return meiopagamento;
    }

    public void setMeiopagamento(String meiopagamento) {
        this.meiopagamento = meiopagamento;
    }

    public Character getFlagtipo() {
        return flagtipo;
    }

    public void setFlagtipo(Character flagtipo) {
        this.flagtipo = flagtipo;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getMeiopagamentoecf() {
        return meiopagamentoecf;
    }

    public void setMeiopagamentoecf(String meiopagamentoecf) {
        this.meiopagamentoecf = meiopagamentoecf;
    }

    public Character getFlagaltpaf() {
        return flagaltpaf;
    }

    public void setFlagaltpaf(Character flagaltpaf) {
        this.flagaltpaf = flagaltpaf;
    }

    public Documentocaixa getCoddocumentocaixa() {
        return coddocumentocaixa;
    }

    public void setCoddocumentocaixa(Documentocaixa coddocumentocaixa) {
        this.coddocumentocaixa = coddocumentocaixa;
    }

    public Recebimento getCodrec() {
        return codrec;
    }

    public void setCodrec(Recebimento codrec) {
        this.codrec = codrec;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmovimentocaixa != null ? codmovimentocaixa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movimentocaixa)) {
            return false;
        }
        Movimentocaixa other = (Movimentocaixa) object;
        if ((this.codmovimentocaixa == null && other.codmovimentocaixa != null) || (this.codmovimentocaixa != null && !this.codmovimentocaixa.equals(other.codmovimentocaixa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Movimentocaixa[ codmovimentocaixa=" + codmovimentocaixa + " ]";
    }
    
}
