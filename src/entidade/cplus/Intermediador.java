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
@Table(name = "INTERMEDIADOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Intermediador.findAll", query = "SELECT i FROM Intermediador i")
    , @NamedQuery(name = "Intermediador.findByCodintermediador", query = "SELECT i FROM Intermediador i WHERE i.codintermediador = :codintermediador")
    , @NamedQuery(name = "Intermediador.findByCodigo", query = "SELECT i FROM Intermediador i WHERE i.codigo = :codigo")
    , @NamedQuery(name = "Intermediador.findByIdentidade", query = "SELECT i FROM Intermediador i WHERE i.identidade = :identidade")
    , @NamedQuery(name = "Intermediador.findByNomeentidade", query = "SELECT i FROM Intermediador i WHERE i.nomeentidade = :nomeentidade")
    , @NamedQuery(name = "Intermediador.findByIdentificadorintermediador", query = "SELECT i FROM Intermediador i WHERE i.identificadorintermediador = :identificadorintermediador")
    , @NamedQuery(name = "Intermediador.findByCnpj", query = "SELECT i FROM Intermediador i WHERE i.cnpj = :cnpj")})
public class Intermediador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODINTERMEDIADOR")
    private String codintermediador;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "IDENTIDADE")
    private String identidade;
    @Column(name = "NOMEENTIDADE")
    private String nomeentidade;
    @Column(name = "IDENTIFICADORINTERMEDIADOR")
    private String identificadorintermediador;
    @Column(name = "CNPJ")
    private String cnpj;
    @OneToMany(mappedBy = "codintermediador")
    private Collection<Orcamento> orcamentoCollection;
    @OneToMany(mappedBy = "codintermediador")
    private Collection<Vendedor> vendedorCollection;
    @OneToMany(mappedBy = "codintermediador")
    private Collection<Tipomovimento> tipomovimentoCollection;

    public Intermediador() {
    }

    public Intermediador(String codintermediador) {
        this.codintermediador = codintermediador;
    }

    public String getCodintermediador() {
        return codintermediador;
    }

    public void setCodintermediador(String codintermediador) {
        this.codintermediador = codintermediador;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    public String getNomeentidade() {
        return nomeentidade;
    }

    public void setNomeentidade(String nomeentidade) {
        this.nomeentidade = nomeentidade;
    }

    public String getIdentificadorintermediador() {
        return identificadorintermediador;
    }

    public void setIdentificadorintermediador(String identificadorintermediador) {
        this.identificadorintermediador = identificadorintermediador;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @XmlTransient
    public Collection<Orcamento> getOrcamentoCollection() {
        return orcamentoCollection;
    }

    public void setOrcamentoCollection(Collection<Orcamento> orcamentoCollection) {
        this.orcamentoCollection = orcamentoCollection;
    }

    @XmlTransient
    public Collection<Vendedor> getVendedorCollection() {
        return vendedorCollection;
    }

    public void setVendedorCollection(Collection<Vendedor> vendedorCollection) {
        this.vendedorCollection = vendedorCollection;
    }

    @XmlTransient
    public Collection<Tipomovimento> getTipomovimentoCollection() {
        return tipomovimentoCollection;
    }

    public void setTipomovimentoCollection(Collection<Tipomovimento> tipomovimentoCollection) {
        this.tipomovimentoCollection = tipomovimentoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codintermediador != null ? codintermediador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Intermediador)) {
            return false;
        }
        Intermediador other = (Intermediador) object;
        if ((this.codintermediador == null && other.codintermediador != null) || (this.codintermediador != null && !this.codintermediador.equals(other.codintermediador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Intermediador[ codintermediador=" + codintermediador + " ]";
    }
    
}
