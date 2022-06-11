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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "MONTADOR", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Montador.findAll", query = "SELECT m FROM Montador m")
    , @NamedQuery(name = "Montador.findByCodmontador", query = "SELECT m FROM Montador m WHERE m.codmontador = :codmontador")
    , @NamedQuery(name = "Montador.findByDescricao", query = "SELECT m FROM Montador m WHERE m.descricao = :descricao")
    , @NamedQuery(name = "Montador.findByCodigo", query = "SELECT m FROM Montador m WHERE m.codigo = :codigo")
    , @NamedQuery(name = "Montador.findByComissao", query = "SELECT m FROM Montador m WHERE m.comissao = :comissao")})
public class Montador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODMONTADOR")
    private Integer codmontador;
    @Column(name = "DESCRICAO")
    private String descricao;
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "COMISSAO")
    private BigDecimal comissao;

    public Montador() {
    }

    public Montador(Integer codmontador) {
        this.codmontador = codmontador;
    }

    public Montador(Integer codmontador, String codigo) {
        this.codmontador = codmontador;
        this.codigo = codigo;
    }

    public Integer getCodmontador() {
        return codmontador;
    }

    public void setCodmontador(Integer codmontador) {
        this.codmontador = codmontador;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getComissao() {
        return comissao;
    }

    public void setComissao(BigDecimal comissao) {
        this.comissao = comissao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmontador != null ? codmontador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Montador)) {
            return false;
        }
        Montador other = (Montador) object;
        if ((this.codmontador == null && other.codmontador != null) || (this.codmontador != null && !this.codmontador.equals(other.codmontador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Montador[ codmontador=" + codmontador + " ]";
    }
    
}
