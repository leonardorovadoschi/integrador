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
@Table(name = "CONFERENCIAPEDIDOITENS", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conferenciapedidoitens.findAll", query = "SELECT c FROM Conferenciapedidoitens c")
    , @NamedQuery(name = "Conferenciapedidoitens.findByCodconferenciapedidoitens", query = "SELECT c FROM Conferenciapedidoitens c WHERE c.codconferenciapedidoitens = :codconferenciapedidoitens")
    , @NamedQuery(name = "Conferenciapedidoitens.findByCodmovprod", query = "SELECT c FROM Conferenciapedidoitens c WHERE c.codmovprod = :codmovprod")
    , @NamedQuery(name = "Conferenciapedidoitens.findByQuantidadevendida", query = "SELECT c FROM Conferenciapedidoitens c WHERE c.quantidadevendida = :quantidadevendida")
    , @NamedQuery(name = "Conferenciapedidoitens.findByQuantidadeconferida", query = "SELECT c FROM Conferenciapedidoitens c WHERE c.quantidadeconferida = :quantidadeconferida")
    , @NamedQuery(name = "Conferenciapedidoitens.findByMotivo", query = "SELECT c FROM Conferenciapedidoitens c WHERE c.motivo = :motivo")})
public class Conferenciapedidoitens implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCONFERENCIAPEDIDOITENS")
    private String codconferenciapedidoitens;
    @Basic(optional = false)
    @Column(name = "CODMOVPROD")
    private String codmovprod;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "QUANTIDADEVENDIDA")
    private BigDecimal quantidadevendida;
    @Column(name = "QUANTIDADECONFERIDA")
    private BigDecimal quantidadeconferida;
    @Column(name = "MOTIVO")
    private String motivo;
    @JoinColumn(name = "CODCONFERENCIAPEDIDO", referencedColumnName = "CODCONFERENCIAPEDIDO")
    @ManyToOne(optional = false)
    private Conferenciapedido codconferenciapedido;

    public Conferenciapedidoitens() {
    }

    public Conferenciapedidoitens(String codconferenciapedidoitens) {
        this.codconferenciapedidoitens = codconferenciapedidoitens;
    }

    public Conferenciapedidoitens(String codconferenciapedidoitens, String codmovprod) {
        this.codconferenciapedidoitens = codconferenciapedidoitens;
        this.codmovprod = codmovprod;
    }

    public String getCodconferenciapedidoitens() {
        return codconferenciapedidoitens;
    }

    public void setCodconferenciapedidoitens(String codconferenciapedidoitens) {
        this.codconferenciapedidoitens = codconferenciapedidoitens;
    }

    public String getCodmovprod() {
        return codmovprod;
    }

    public void setCodmovprod(String codmovprod) {
        this.codmovprod = codmovprod;
    }

    public BigDecimal getQuantidadevendida() {
        return quantidadevendida;
    }

    public void setQuantidadevendida(BigDecimal quantidadevendida) {
        this.quantidadevendida = quantidadevendida;
    }

    public BigDecimal getQuantidadeconferida() {
        return quantidadeconferida;
    }

    public void setQuantidadeconferida(BigDecimal quantidadeconferida) {
        this.quantidadeconferida = quantidadeconferida;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Conferenciapedido getCodconferenciapedido() {
        return codconferenciapedido;
    }

    public void setCodconferenciapedido(Conferenciapedido codconferenciapedido) {
        this.codconferenciapedido = codconferenciapedido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codconferenciapedidoitens != null ? codconferenciapedidoitens.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conferenciapedidoitens)) {
            return false;
        }
        Conferenciapedidoitens other = (Conferenciapedidoitens) object;
        if ((this.codconferenciapedidoitens == null && other.codconferenciapedidoitens != null) || (this.codconferenciapedidoitens != null && !this.codconferenciapedidoitens.equals(other.codconferenciapedidoitens))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Conferenciapedidoitens[ codconferenciapedidoitens=" + codconferenciapedidoitens + " ]";
    }
    
}
