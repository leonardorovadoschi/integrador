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
@Table(name = "LOTEENTREGAITEM", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Loteentregaitem.findAll", query = "SELECT l FROM Loteentregaitem l")
    , @NamedQuery(name = "Loteentregaitem.findByCodloteentregaitem", query = "SELECT l FROM Loteentregaitem l WHERE l.codloteentregaitem = :codloteentregaitem")
    , @NamedQuery(name = "Loteentregaitem.findByQuantidade", query = "SELECT l FROM Loteentregaitem l WHERE l.quantidade = :quantidade")
    , @NamedQuery(name = "Loteentregaitem.findByFlagnaoentregue", query = "SELECT l FROM Loteentregaitem l WHERE l.flagnaoentregue = :flagnaoentregue")
    , @NamedQuery(name = "Loteentregaitem.findByQtdenaoentregue", query = "SELECT l FROM Loteentregaitem l WHERE l.qtdenaoentregue = :qtdenaoentregue")
    , @NamedQuery(name = "Loteentregaitem.findByMotivonaoentrega", query = "SELECT l FROM Loteentregaitem l WHERE l.motivonaoentrega = :motivonaoentrega")
    , @NamedQuery(name = "Loteentregaitem.findByOrdem", query = "SELECT l FROM Loteentregaitem l WHERE l.ordem = :ordem")
    , @NamedQuery(name = "Loteentregaitem.findByQtdetransferida", query = "SELECT l FROM Loteentregaitem l WHERE l.qtdetransferida = :qtdetransferida")})
public class Loteentregaitem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODLOTEENTREGAITEM")
    private Integer codloteentregaitem;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "QUANTIDADE")
    private BigDecimal quantidade;
    @Column(name = "FLAGNAOENTREGUE")
    private Character flagnaoentregue;
    @Column(name = "QTDENAOENTREGUE")
    private BigDecimal qtdenaoentregue;
    @Column(name = "MOTIVONAOENTREGA")
    private String motivonaoentrega;
    @Column(name = "ORDEM")
    private Integer ordem;
    @Column(name = "QTDETRANSFERIDA")
    private BigDecimal qtdetransferida;
    @JoinColumn(name = "CODLOTEENTREGA", referencedColumnName = "CODLOTEENTREGA")
    @ManyToOne
    private Loteentrega codloteentrega;
    @JoinColumn(name = "CODMOVENDA", referencedColumnName = "CODMOVENDA")
    @ManyToOne
    private Movenda codmovenda;
    @JoinColumn(name = "CODMOVPROD", referencedColumnName = "CODMOVPROD")
    @ManyToOne(optional = false)
    private Movendaprod codmovprod;

    public Loteentregaitem() {
    }

    public Loteentregaitem(Integer codloteentregaitem) {
        this.codloteentregaitem = codloteentregaitem;
    }

    public Integer getCodloteentregaitem() {
        return codloteentregaitem;
    }

    public void setCodloteentregaitem(Integer codloteentregaitem) {
        this.codloteentregaitem = codloteentregaitem;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public Character getFlagnaoentregue() {
        return flagnaoentregue;
    }

    public void setFlagnaoentregue(Character flagnaoentregue) {
        this.flagnaoentregue = flagnaoentregue;
    }

    public BigDecimal getQtdenaoentregue() {
        return qtdenaoentregue;
    }

    public void setQtdenaoentregue(BigDecimal qtdenaoentregue) {
        this.qtdenaoentregue = qtdenaoentregue;
    }

    public String getMotivonaoentrega() {
        return motivonaoentrega;
    }

    public void setMotivonaoentrega(String motivonaoentrega) {
        this.motivonaoentrega = motivonaoentrega;
    }

    public Integer getOrdem() {
        return ordem;
    }

    public void setOrdem(Integer ordem) {
        this.ordem = ordem;
    }

    public BigDecimal getQtdetransferida() {
        return qtdetransferida;
    }

    public void setQtdetransferida(BigDecimal qtdetransferida) {
        this.qtdetransferida = qtdetransferida;
    }

    public Loteentrega getCodloteentrega() {
        return codloteentrega;
    }

    public void setCodloteentrega(Loteentrega codloteentrega) {
        this.codloteentrega = codloteentrega;
    }

    public Movenda getCodmovenda() {
        return codmovenda;
    }

    public void setCodmovenda(Movenda codmovenda) {
        this.codmovenda = codmovenda;
    }

    public Movendaprod getCodmovprod() {
        return codmovprod;
    }

    public void setCodmovprod(Movendaprod codmovprod) {
        this.codmovprod = codmovprod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codloteentregaitem != null ? codloteentregaitem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Loteentregaitem)) {
            return false;
        }
        Loteentregaitem other = (Loteentregaitem) object;
        if ((this.codloteentregaitem == null && other.codloteentregaitem != null) || (this.codloteentregaitem != null && !this.codloteentregaitem.equals(other.codloteentregaitem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Loteentregaitem[ codloteentregaitem=" + codloteentregaitem + " ]";
    }
    
}
