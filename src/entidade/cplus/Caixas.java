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
@Table(name = "CAIXAS", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Caixas.findAll", query = "SELECT c FROM Caixas c")
    , @NamedQuery(name = "Caixas.findByCodcaixas", query = "SELECT c FROM Caixas c WHERE c.codcaixas = :codcaixas")
    , @NamedQuery(name = "Caixas.findByCodigo", query = "SELECT c FROM Caixas c WHERE c.codigo = :codigo")
    , @NamedQuery(name = "Caixas.findByDescricao", query = "SELECT c FROM Caixas c WHERE c.descricao = :descricao")})
public class Caixas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCAIXAS")
    private String codcaixas;
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;
    @Basic(optional = false)
    @Column(name = "DESCRICAO")
    private String descricao;
    @OneToMany(mappedBy = "codcaixas")
    private Collection<Chequesfirma> chequesfirmaCollection;
    @OneToMany(mappedBy = "codcaixas")
    private Collection<Caixa> caixaCollection;
    @OneToMany(mappedBy = "codcaixas")
    private Collection<Contapagar> contapagarCollection;
    @OneToMany(mappedBy = "codcaixas")
    private Collection<Cheques> chequesCollection;
    @OneToMany(mappedBy = "codcaixas")
    private Collection<Contareceber> contareceberCollection;
    @OneToMany(mappedBy = "codcaixas")
    private Collection<Terminal> terminalCollection;
    @OneToMany(mappedBy = "codcaixas")
    private Collection<Contapagarfixa> contapagarfixaCollection;
    @OneToMany(mappedBy = "codcaixas")
    private Collection<Contabancaria> contabancariaCollection;

    public Caixas() {
    }

    public Caixas(String codcaixas) {
        this.codcaixas = codcaixas;
    }

    public Caixas(String codcaixas, String codigo, String descricao) {
        this.codcaixas = codcaixas;
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodcaixas() {
        return codcaixas;
    }

    public void setCodcaixas(String codcaixas) {
        this.codcaixas = codcaixas;
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
    public Collection<Chequesfirma> getChequesfirmaCollection() {
        return chequesfirmaCollection;
    }

    public void setChequesfirmaCollection(Collection<Chequesfirma> chequesfirmaCollection) {
        this.chequesfirmaCollection = chequesfirmaCollection;
    }

    @XmlTransient
    public Collection<Caixa> getCaixaCollection() {
        return caixaCollection;
    }

    public void setCaixaCollection(Collection<Caixa> caixaCollection) {
        this.caixaCollection = caixaCollection;
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
    public Collection<Contareceber> getContareceberCollection() {
        return contareceberCollection;
    }

    public void setContareceberCollection(Collection<Contareceber> contareceberCollection) {
        this.contareceberCollection = contareceberCollection;
    }

    @XmlTransient
    public Collection<Terminal> getTerminalCollection() {
        return terminalCollection;
    }

    public void setTerminalCollection(Collection<Terminal> terminalCollection) {
        this.terminalCollection = terminalCollection;
    }

    @XmlTransient
    public Collection<Contapagarfixa> getContapagarfixaCollection() {
        return contapagarfixaCollection;
    }

    public void setContapagarfixaCollection(Collection<Contapagarfixa> contapagarfixaCollection) {
        this.contapagarfixaCollection = contapagarfixaCollection;
    }

    @XmlTransient
    public Collection<Contabancaria> getContabancariaCollection() {
        return contabancariaCollection;
    }

    public void setContabancariaCollection(Collection<Contabancaria> contabancariaCollection) {
        this.contabancariaCollection = contabancariaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcaixas != null ? codcaixas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Caixas)) {
            return false;
        }
        Caixas other = (Caixas) object;
        if ((this.codcaixas == null && other.codcaixas != null) || (this.codcaixas != null && !this.codcaixas.equals(other.codcaixas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Caixas[ codcaixas=" + codcaixas + " ]";
    }
    
}
