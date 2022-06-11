/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
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
@Table(name = "EMPRESATIPODOCUMENTOCF", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresatipodocumentocf.findAll", query = "SELECT e FROM Empresatipodocumentocf e")
    , @NamedQuery(name = "Empresatipodocumentocf.findByCodempresatipodocumentocf", query = "SELECT e FROM Empresatipodocumentocf e WHERE e.codempresatipodocumentocf = :codempresatipodocumentocf")
    , @NamedQuery(name = "Empresatipodocumentocf.findByOrdem", query = "SELECT e FROM Empresatipodocumentocf e WHERE e.ordem = :ordem")})
public class Empresatipodocumentocf implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODEMPRESATIPODOCUMENTOCF")
    private String codempresatipodocumentocf;
    @Column(name = "ORDEM")
    private Integer ordem;
    @JoinColumn(name = "CODCLASSIFICACAOFISCAL", referencedColumnName = "CODCLASSIFICACAOFISCAL")
    @ManyToOne
    private Classificacaofiscal codclassificacaofiscal;
    @JoinColumn(name = "CODEMPRESATIPODOCUMENTO", referencedColumnName = "CODEMPRESATIPODOCUMENTO")
    @ManyToOne(optional = false)
    private Empresatipodocumento codempresatipodocumento;

    public Empresatipodocumentocf() {
    }

    public Empresatipodocumentocf(String codempresatipodocumentocf) {
        this.codempresatipodocumentocf = codempresatipodocumentocf;
    }

    public String getCodempresatipodocumentocf() {
        return codempresatipodocumentocf;
    }

    public void setCodempresatipodocumentocf(String codempresatipodocumentocf) {
        this.codempresatipodocumentocf = codempresatipodocumentocf;
    }

    public Integer getOrdem() {
        return ordem;
    }

    public void setOrdem(Integer ordem) {
        this.ordem = ordem;
    }

    public Classificacaofiscal getCodclassificacaofiscal() {
        return codclassificacaofiscal;
    }

    public void setCodclassificacaofiscal(Classificacaofiscal codclassificacaofiscal) {
        this.codclassificacaofiscal = codclassificacaofiscal;
    }

    public Empresatipodocumento getCodempresatipodocumento() {
        return codempresatipodocumento;
    }

    public void setCodempresatipodocumento(Empresatipodocumento codempresatipodocumento) {
        this.codempresatipodocumento = codempresatipodocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codempresatipodocumentocf != null ? codempresatipodocumentocf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresatipodocumentocf)) {
            return false;
        }
        Empresatipodocumentocf other = (Empresatipodocumentocf) object;
        if ((this.codempresatipodocumentocf == null && other.codempresatipodocumentocf != null) || (this.codempresatipodocumentocf != null && !this.codempresatipodocumentocf.equals(other.codempresatipodocumentocf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Empresatipodocumentocf[ codempresatipodocumentocf=" + codempresatipodocumentocf + " ]";
    }
    
}
