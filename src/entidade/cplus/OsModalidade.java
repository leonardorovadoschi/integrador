/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "OS_MODALIDADE", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OsModalidade.findAll", query = "SELECT o FROM OsModalidade o")
    , @NamedQuery(name = "OsModalidade.findByCodmod", query = "SELECT o FROM OsModalidade o WHERE o.codmod = :codmod")
    , @NamedQuery(name = "OsModalidade.findByModalidade", query = "SELECT o FROM OsModalidade o WHERE o.modalidade = :modalidade")
    , @NamedQuery(name = "OsModalidade.findByCodigo", query = "SELECT o FROM OsModalidade o WHERE o.codigo = :codigo")})
public class OsModalidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODMOD")
    private String codmod;
    @Column(name = "MODALIDADE")
    private String modalidade;
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;
    @OneToMany(mappedBy = "codmod")
    private Collection<Clienteequipamento> clienteequipamentoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codmod")
    private Collection<Clienteproduto> clienteprodutoCollection;

    public OsModalidade() {
    }

    public OsModalidade(String codmod) {
        this.codmod = codmod;
    }

    public OsModalidade(String codmod, String codigo) {
        this.codmod = codmod;
        this.codigo = codigo;
    }

    public String getCodmod() {
        return codmod;
    }

    public void setCodmod(String codmod) {
        this.codmod = codmod;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @XmlTransient
    public Collection<Clienteequipamento> getClienteequipamentoCollection() {
        return clienteequipamentoCollection;
    }

    public void setClienteequipamentoCollection(Collection<Clienteequipamento> clienteequipamentoCollection) {
        this.clienteequipamentoCollection = clienteequipamentoCollection;
    }

    @XmlTransient
    public Collection<Clienteproduto> getClienteprodutoCollection() {
        return clienteprodutoCollection;
    }

    public void setClienteprodutoCollection(Collection<Clienteproduto> clienteprodutoCollection) {
        this.clienteprodutoCollection = clienteprodutoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmod != null ? codmod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OsModalidade)) {
            return false;
        }
        OsModalidade other = (OsModalidade) object;
        if ((this.codmod == null && other.codmod != null) || (this.codmod != null && !this.codmod.equals(other.codmod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.OsModalidade[ codmod=" + codmod + " ]";
    }
    
}
