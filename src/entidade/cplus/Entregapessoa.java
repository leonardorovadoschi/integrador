/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "ENTREGAPESSOA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entregapessoa.findAll", query = "SELECT e FROM Entregapessoa e")
    , @NamedQuery(name = "Entregapessoa.findByCodentregapessoa", query = "SELECT e FROM Entregapessoa e WHERE e.codentregapessoa = :codentregapessoa")
    , @NamedQuery(name = "Entregapessoa.findByCodigo", query = "SELECT e FROM Entregapessoa e WHERE e.codigo = :codigo")
    , @NamedQuery(name = "Entregapessoa.findByNomeentregapessoa", query = "SELECT e FROM Entregapessoa e WHERE e.nomeentregapessoa = :nomeentregapessoa")
    , @NamedQuery(name = "Entregapessoa.findByValorcomissao", query = "SELECT e FROM Entregapessoa e WHERE e.valorcomissao = :valorcomissao")
    , @NamedQuery(name = "Entregapessoa.findByCodvended", query = "SELECT e FROM Entregapessoa e WHERE e.codvended = :codvended")
    , @NamedQuery(name = "Entregapessoa.findByCpf", query = "SELECT e FROM Entregapessoa e WHERE e.cpf = :cpf")})
public class Entregapessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODENTREGAPESSOA")
    private Integer codentregapessoa;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "NOMEENTREGAPESSOA")
    private String nomeentregapessoa;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALORCOMISSAO")
    private BigDecimal valorcomissao;
    @Column(name = "CODVENDED")
    private String codvended;
    @Column(name = "CPF")
    private String cpf;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codentregapessoa")
    private Collection<Mdfeletronicocondutor> mdfeletronicocondutorCollection;
    @OneToMany(mappedBy = "codmotorista")
    private Collection<Loteentrega> loteentregaCollection;
    @OneToMany(mappedBy = "codajudante")
    private Collection<Loteentrega> loteentregaCollection1;
    @OneToMany(mappedBy = "codajudante2")
    private Collection<Loteentrega> loteentregaCollection2;

    public Entregapessoa() {
    }

    public Entregapessoa(Integer codentregapessoa) {
        this.codentregapessoa = codentregapessoa;
    }

    public Integer getCodentregapessoa() {
        return codentregapessoa;
    }

    public void setCodentregapessoa(Integer codentregapessoa) {
        this.codentregapessoa = codentregapessoa;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomeentregapessoa() {
        return nomeentregapessoa;
    }

    public void setNomeentregapessoa(String nomeentregapessoa) {
        this.nomeentregapessoa = nomeentregapessoa;
    }

    public BigDecimal getValorcomissao() {
        return valorcomissao;
    }

    public void setValorcomissao(BigDecimal valorcomissao) {
        this.valorcomissao = valorcomissao;
    }

    public String getCodvended() {
        return codvended;
    }

    public void setCodvended(String codvended) {
        this.codvended = codvended;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @XmlTransient
    public Collection<Mdfeletronicocondutor> getMdfeletronicocondutorCollection() {
        return mdfeletronicocondutorCollection;
    }

    public void setMdfeletronicocondutorCollection(Collection<Mdfeletronicocondutor> mdfeletronicocondutorCollection) {
        this.mdfeletronicocondutorCollection = mdfeletronicocondutorCollection;
    }

    @XmlTransient
    public Collection<Loteentrega> getLoteentregaCollection() {
        return loteentregaCollection;
    }

    public void setLoteentregaCollection(Collection<Loteentrega> loteentregaCollection) {
        this.loteentregaCollection = loteentregaCollection;
    }

    @XmlTransient
    public Collection<Loteentrega> getLoteentregaCollection1() {
        return loteentregaCollection1;
    }

    public void setLoteentregaCollection1(Collection<Loteentrega> loteentregaCollection1) {
        this.loteentregaCollection1 = loteentregaCollection1;
    }

    @XmlTransient
    public Collection<Loteentrega> getLoteentregaCollection2() {
        return loteentregaCollection2;
    }

    public void setLoteentregaCollection2(Collection<Loteentrega> loteentregaCollection2) {
        this.loteentregaCollection2 = loteentregaCollection2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codentregapessoa != null ? codentregapessoa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entregapessoa)) {
            return false;
        }
        Entregapessoa other = (Entregapessoa) object;
        if ((this.codentregapessoa == null && other.codentregapessoa != null) || (this.codentregapessoa != null && !this.codentregapessoa.equals(other.codentregapessoa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Entregapessoa[ codentregapessoa=" + codentregapessoa + " ]";
    }
    
}
