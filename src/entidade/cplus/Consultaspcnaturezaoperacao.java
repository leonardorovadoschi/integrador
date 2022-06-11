/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "CONSULTASPCNATUREZAOPERACAO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consultaspcnaturezaoperacao.findAll", query = "SELECT c FROM Consultaspcnaturezaoperacao c")
    , @NamedQuery(name = "Consultaspcnaturezaoperacao.findByCodconsspcnaturezaop", query = "SELECT c FROM Consultaspcnaturezaoperacao c WHERE c.codconsspcnaturezaop = :codconsspcnaturezaop")
    , @NamedQuery(name = "Consultaspcnaturezaoperacao.findByCodigo", query = "SELECT c FROM Consultaspcnaturezaoperacao c WHERE c.codigo = :codigo")
    , @NamedQuery(name = "Consultaspcnaturezaoperacao.findByDescricao", query = "SELECT c FROM Consultaspcnaturezaoperacao c WHERE c.descricao = :descricao")})
public class Consultaspcnaturezaoperacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCONSSPCNATUREZAOP")
    private String codconsspcnaturezaop;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "DESCRICAO")
    private String descricao;
    @OneToMany(mappedBy = "codconsspcnaturezaop")
    private Collection<Consultaspc> consultaspcCollection;

    public Consultaspcnaturezaoperacao() {
    }

    public Consultaspcnaturezaoperacao(String codconsspcnaturezaop) {
        this.codconsspcnaturezaop = codconsspcnaturezaop;
    }

    public String getCodconsspcnaturezaop() {
        return codconsspcnaturezaop;
    }

    public void setCodconsspcnaturezaop(String codconsspcnaturezaop) {
        this.codconsspcnaturezaop = codconsspcnaturezaop;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public Collection<Consultaspc> getConsultaspcCollection() {
        return consultaspcCollection;
    }

    public void setConsultaspcCollection(Collection<Consultaspc> consultaspcCollection) {
        this.consultaspcCollection = consultaspcCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codconsspcnaturezaop != null ? codconsspcnaturezaop.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consultaspcnaturezaoperacao)) {
            return false;
        }
        Consultaspcnaturezaoperacao other = (Consultaspcnaturezaoperacao) object;
        if ((this.codconsspcnaturezaop == null && other.codconsspcnaturezaop != null) || (this.codconsspcnaturezaop != null && !this.codconsspcnaturezaop.equals(other.codconsspcnaturezaop))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Consultaspcnaturezaoperacao[ codconsspcnaturezaop=" + codconsspcnaturezaop + " ]";
    }
    
}
