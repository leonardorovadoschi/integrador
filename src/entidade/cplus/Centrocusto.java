/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "CENTROCUSTO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Centrocusto.findAll", query = "SELECT c FROM Centrocusto c")
    , @NamedQuery(name = "Centrocusto.findByCodcentrocusto", query = "SELECT c FROM Centrocusto c WHERE c.codcentrocusto = :codcentrocusto")
    , @NamedQuery(name = "Centrocusto.findByCodigo", query = "SELECT c FROM Centrocusto c WHERE c.codigo = :codigo")
    , @NamedQuery(name = "Centrocusto.findByNomecentrocusto", query = "SELECT c FROM Centrocusto c WHERE c.nomecentrocusto = :nomecentrocusto")
    , @NamedQuery(name = "Centrocusto.findByLastChange", query = "SELECT c FROM Centrocusto c WHERE c.lastChange = :lastChange")})
public class Centrocusto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCENTROCUSTO")
    private String codcentrocusto;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "NOMECENTROCUSTO")
    private String nomecentrocusto;
    @Column(name = "LAST_CHANGE")
    @Temporal(TemporalType.DATE)
    private Date lastChange;
    @OneToMany(mappedBy = "codcentrocusto")
    private Collection<Chequesfirma> chequesfirmaCollection;
    @OneToMany(mappedBy = "codcentrocusto")
    private Collection<Moventrada> moventradaCollection;
    @OneToMany(mappedBy = "codcentrocusto")
    private Collection<Contapagar> contapagarCollection;
    @OneToMany(mappedBy = "codcentrocusto")
    private Collection<Cheques> chequesCollection;
    @OneToMany(mappedBy = "codcentrocusto")
    private Collection<Recebimento> recebimentoCollection;
    @OneToMany(mappedBy = "codcentrocusto")
    private Collection<Contareceber> contareceberCollection;
    @OneToMany(mappedBy = "codcentrocusto")
    private Collection<Contapagarfixa> contapagarfixaCollection;
    @OneToMany(mappedBy = "codcentrocusto")
    private Collection<Pedido> pedidoCollection;

    public Centrocusto() {
    }

    public Centrocusto(String codcentrocusto) {
        this.codcentrocusto = codcentrocusto;
    }

    public String getCodcentrocusto() {
        return codcentrocusto;
    }

    public void setCodcentrocusto(String codcentrocusto) {
        this.codcentrocusto = codcentrocusto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomecentrocusto() {
        return nomecentrocusto;
    }

    public void setNomecentrocusto(String nomecentrocusto) {
        this.nomecentrocusto = nomecentrocusto;
    }

    public Date getLastChange() {
        return lastChange;
    }

    public void setLastChange(Date lastChange) {
        this.lastChange = lastChange;
    }

    @XmlTransient
    public Collection<Chequesfirma> getChequesfirmaCollection() {
        return chequesfirmaCollection;
    }

    public void setChequesfirmaCollection(Collection<Chequesfirma> chequesfirmaCollection) {
        this.chequesfirmaCollection = chequesfirmaCollection;
    }

    @XmlTransient
    public Collection<Moventrada> getMoventradaCollection() {
        return moventradaCollection;
    }

    public void setMoventradaCollection(Collection<Moventrada> moventradaCollection) {
        this.moventradaCollection = moventradaCollection;
    }

    @XmlTransient
    public Collection<Contapagar> getContapagarCollection() {
        return contapagarCollection;
    }

    public void setContapagarCollection(Collection<Contapagar> contapagarCollection) {
        this.contapagarCollection = contapagarCollection;
    }

    @XmlTransient
    public Collection<Cheques> getChequesCollection() {
        return chequesCollection;
    }

    public void setChequesCollection(Collection<Cheques> chequesCollection) {
        this.chequesCollection = chequesCollection;
    }

    @XmlTransient
    public Collection<Recebimento> getRecebimentoCollection() {
        return recebimentoCollection;
    }

    public void setRecebimentoCollection(Collection<Recebimento> recebimentoCollection) {
        this.recebimentoCollection = recebimentoCollection;
    }

    @XmlTransient
    public Collection<Contareceber> getContareceberCollection() {
        return contareceberCollection;
    }

    public void setContareceberCollection(Collection<Contareceber> contareceberCollection) {
        this.contareceberCollection = contareceberCollection;
    }

    @XmlTransient
    public Collection<Contapagarfixa> getContapagarfixaCollection() {
        return contapagarfixaCollection;
    }

    public void setContapagarfixaCollection(Collection<Contapagarfixa> contapagarfixaCollection) {
        this.contapagarfixaCollection = contapagarfixaCollection;
    }

    @XmlTransient
    public Collection<Pedido> getPedidoCollection() {
        return pedidoCollection;
    }

    public void setPedidoCollection(Collection<Pedido> pedidoCollection) {
        this.pedidoCollection = pedidoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcentrocusto != null ? codcentrocusto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Centrocusto)) {
            return false;
        }
        Centrocusto other = (Centrocusto) object;
        if ((this.codcentrocusto == null && other.codcentrocusto != null) || (this.codcentrocusto != null && !this.codcentrocusto.equals(other.codcentrocusto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Centrocusto[ codcentrocusto=" + codcentrocusto + " ]";
    }
    
}
