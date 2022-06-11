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
@Table(name = "CONTRATOCOBRANCAVENDEDOR", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contratocobrancavendedor.findAll", query = "SELECT c FROM Contratocobrancavendedor c")
    , @NamedQuery(name = "Contratocobrancavendedor.findByCodcontratocobrancavendedor", query = "SELECT c FROM Contratocobrancavendedor c WHERE c.codcontratocobrancavendedor = :codcontratocobrancavendedor")
    , @NamedQuery(name = "Contratocobrancavendedor.findByCodvended", query = "SELECT c FROM Contratocobrancavendedor c WHERE c.codvended = :codvended")
    , @NamedQuery(name = "Contratocobrancavendedor.findByCodcontratocobranca", query = "SELECT c FROM Contratocobrancavendedor c WHERE c.codcontratocobranca = :codcontratocobranca")
    , @NamedQuery(name = "Contratocobrancavendedor.findByAliqcomissao", query = "SELECT c FROM Contratocobrancavendedor c WHERE c.aliqcomissao = :aliqcomissao")})
public class Contratocobrancavendedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCONTRATOCOBRANCAVENDEDOR")
    private Integer codcontratocobrancavendedor;
    @Basic(optional = false)
    @Column(name = "CODVENDED")
    private String codvended;
    @Basic(optional = false)
    @Column(name = "CODCONTRATOCOBRANCA")
    private int codcontratocobranca;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ALIQCOMISSAO")
    private BigDecimal aliqcomissao;

    public Contratocobrancavendedor() {
    }

    public Contratocobrancavendedor(Integer codcontratocobrancavendedor) {
        this.codcontratocobrancavendedor = codcontratocobrancavendedor;
    }

    public Contratocobrancavendedor(Integer codcontratocobrancavendedor, String codvended, int codcontratocobranca) {
        this.codcontratocobrancavendedor = codcontratocobrancavendedor;
        this.codvended = codvended;
        this.codcontratocobranca = codcontratocobranca;
    }

    public Integer getCodcontratocobrancavendedor() {
        return codcontratocobrancavendedor;
    }

    public void setCodcontratocobrancavendedor(Integer codcontratocobrancavendedor) {
        this.codcontratocobrancavendedor = codcontratocobrancavendedor;
    }

    public String getCodvended() {
        return codvended;
    }

    public void setCodvended(String codvended) {
        this.codvended = codvended;
    }

    public int getCodcontratocobranca() {
        return codcontratocobranca;
    }

    public void setCodcontratocobranca(int codcontratocobranca) {
        this.codcontratocobranca = codcontratocobranca;
    }

    public BigDecimal getAliqcomissao() {
        return aliqcomissao;
    }

    public void setAliqcomissao(BigDecimal aliqcomissao) {
        this.aliqcomissao = aliqcomissao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcontratocobrancavendedor != null ? codcontratocobrancavendedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contratocobrancavendedor)) {
            return false;
        }
        Contratocobrancavendedor other = (Contratocobrancavendedor) object;
        if ((this.codcontratocobrancavendedor == null && other.codcontratocobrancavendedor != null) || (this.codcontratocobrancavendedor != null && !this.codcontratocobrancavendedor.equals(other.codcontratocobrancavendedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Contratocobrancavendedor[ codcontratocobrancavendedor=" + codcontratocobrancavendedor + " ]";
    }
    
}
