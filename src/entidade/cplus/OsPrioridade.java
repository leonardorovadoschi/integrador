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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "OS_PRIORIDADE", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OsPrioridade.findAll", query = "SELECT o FROM OsPrioridade o")
    , @NamedQuery(name = "OsPrioridade.findByCodprioridade", query = "SELECT o FROM OsPrioridade o WHERE o.codprioridade = :codprioridade")
    , @NamedQuery(name = "OsPrioridade.findByPrioridade", query = "SELECT o FROM OsPrioridade o WHERE o.prioridade = :prioridade")
    , @NamedQuery(name = "OsPrioridade.findByCor", query = "SELECT o FROM OsPrioridade o WHERE o.cor = :cor")
    , @NamedQuery(name = "OsPrioridade.findByCodigo", query = "SELECT o FROM OsPrioridade o WHERE o.codigo = :codigo")
    , @NamedQuery(name = "OsPrioridade.findByPrazoatend", query = "SELECT o FROM OsPrioridade o WHERE o.prazoatend = :prazoatend")})
public class OsPrioridade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODPRIORIDADE")
    private String codprioridade;
    @Column(name = "PRIORIDADE")
    private String prioridade;
    @Column(name = "COR")
    private String cor;
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "PRAZOATEND")
    private Integer prazoatend;

    public OsPrioridade() {
    }

    public OsPrioridade(String codprioridade) {
        this.codprioridade = codprioridade;
    }

    public OsPrioridade(String codprioridade, String codigo) {
        this.codprioridade = codprioridade;
        this.codigo = codigo;
    }

    public String getCodprioridade() {
        return codprioridade;
    }

    public void setCodprioridade(String codprioridade) {
        this.codprioridade = codprioridade;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getPrazoatend() {
        return prazoatend;
    }

    public void setPrazoatend(Integer prazoatend) {
        this.prazoatend = prazoatend;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codprioridade != null ? codprioridade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OsPrioridade)) {
            return false;
        }
        OsPrioridade other = (OsPrioridade) object;
        if ((this.codprioridade == null && other.codprioridade != null) || (this.codprioridade != null && !this.codprioridade.equals(other.codprioridade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.OsPrioridade[ codprioridade=" + codprioridade + " ]";
    }
    
}
