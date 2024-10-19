/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "CARACTERISTICAPESSOA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Caracteristicapessoa.findAll", query = "SELECT c FROM Caracteristicapessoa c")
    , @NamedQuery(name = "Caracteristicapessoa.findByCodcaracteristicapessoa", query = "SELECT c FROM Caracteristicapessoa c WHERE c.codcaracteristicapessoa = :codcaracteristicapessoa")
    , @NamedQuery(name = "Caracteristicapessoa.findByCodigo", query = "SELECT c FROM Caracteristicapessoa c WHERE c.codigo = :codigo")
    , @NamedQuery(name = "Caracteristicapessoa.findByNomecaracteristicapessoa", query = "SELECT c FROM Caracteristicapessoa c WHERE c.nomecaracteristicapessoa = :nomecaracteristicapessoa")
    , @NamedQuery(name = "Caracteristicapessoa.findByClassificacao", query = "SELECT c FROM Caracteristicapessoa c WHERE c.classificacao = :classificacao")
    , @NamedQuery(name = "Caracteristicapessoa.findByFlagtipo", query = "SELECT c FROM Caracteristicapessoa c WHERE c.flagtipo = :flagtipo")
    , @NamedQuery(name = "Caracteristicapessoa.findByTipo", query = "SELECT c FROM Caracteristicapessoa c WHERE c.tipo = :tipo")
    , @NamedQuery(name = "Caracteristicapessoa.findByCodregistropai", query = "SELECT c FROM Caracteristicapessoa c WHERE c.codregistropai = :codregistropai")
    , @NamedQuery(name = "Caracteristicapessoa.findByGuid", query = "SELECT c FROM Caracteristicapessoa c WHERE c.guid = :guid")})
public class Caracteristicapessoa implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCARACTERISTICAPESSOA")
    private String codcaracteristicapessoa;
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "NOMECARACTERISTICAPESSOA")
    private String nomecaracteristicapessoa;
    @Column(name = "CLASSIFICACAO")
    private String classificacao;
    @Column(name = "FLAGTIPO")
    private Character flagtipo;
    @Lob
    @Column(name = "IMAGEM")
    private byte[] imagem;
    @Lob
    @Column(name = "OBSERVACAO")
    private String observacao;
    @Column(name = "TIPO")
    private Character tipo;
    @Column(name = "CODREGISTROPAI")
    private String codregistropai;
    @Column(name = "GUID")
    private String guid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codcaracteristicapessoa")
    private Collection<Clientecaracteristica> clientecaracteristicaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codcaracteristicapessoa")
    private Collection<Vendedorcaracteristica> vendedorcaracteristicaCollection;

    public Caracteristicapessoa() {
    }

    public Caracteristicapessoa(String codcaracteristicapessoa) {
        this.codcaracteristicapessoa = codcaracteristicapessoa;
    }

    public Caracteristicapessoa(String codcaracteristicapessoa, String codigo) {
        this.codcaracteristicapessoa = codcaracteristicapessoa;
        this.codigo = codigo;
    }

    public String getCodcaracteristicapessoa() {
        return codcaracteristicapessoa;
    }

    public void setCodcaracteristicapessoa(String codcaracteristicapessoa) {
        String oldCodcaracteristicapessoa = this.codcaracteristicapessoa;
        this.codcaracteristicapessoa = codcaracteristicapessoa;
        changeSupport.firePropertyChange("codcaracteristicapessoa", oldCodcaracteristicapessoa, codcaracteristicapessoa);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        String oldCodigo = this.codigo;
        this.codigo = codigo;
        changeSupport.firePropertyChange("codigo", oldCodigo, codigo);
    }

    public String getNomecaracteristicapessoa() {
        return nomecaracteristicapessoa;
    }

    public void setNomecaracteristicapessoa(String nomecaracteristicapessoa) {
        String oldNomecaracteristicapessoa = this.nomecaracteristicapessoa;
        this.nomecaracteristicapessoa = nomecaracteristicapessoa;
        changeSupport.firePropertyChange("nomecaracteristicapessoa", oldNomecaracteristicapessoa, nomecaracteristicapessoa);
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        String oldClassificacao = this.classificacao;
        this.classificacao = classificacao;
        changeSupport.firePropertyChange("classificacao", oldClassificacao, classificacao);
    }

    public Character getFlagtipo() {
        return flagtipo;
    }

    public void setFlagtipo(Character flagtipo) {
        Character oldFlagtipo = this.flagtipo;
        this.flagtipo = flagtipo;
        changeSupport.firePropertyChange("flagtipo", oldFlagtipo, flagtipo);
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        byte[] oldImagem = this.imagem;
        this.imagem = imagem;
        changeSupport.firePropertyChange("imagem", oldImagem, imagem);
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        String oldObservacao = this.observacao;
        this.observacao = observacao;
        changeSupport.firePropertyChange("observacao", oldObservacao, observacao);
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        Character oldTipo = this.tipo;
        this.tipo = tipo;
        changeSupport.firePropertyChange("tipo", oldTipo, tipo);
    }

    public String getCodregistropai() {
        return codregistropai;
    }

    public void setCodregistropai(String codregistropai) {
        String oldCodregistropai = this.codregistropai;
        this.codregistropai = codregistropai;
        changeSupport.firePropertyChange("codregistropai", oldCodregistropai, codregistropai);
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        String oldGuid = this.guid;
        this.guid = guid;
        changeSupport.firePropertyChange("guid", oldGuid, guid);
    }

    @XmlTransient
    public Collection<Clientecaracteristica> getClientecaracteristicaCollection() {
        return clientecaracteristicaCollection;
    }

    public void setClientecaracteristicaCollection(Collection<Clientecaracteristica> clientecaracteristicaCollection) {
        this.clientecaracteristicaCollection = clientecaracteristicaCollection;
    }

    @XmlTransient
    public Collection<Vendedorcaracteristica> getVendedorcaracteristicaCollection() {
        return vendedorcaracteristicaCollection;
    }

    public void setVendedorcaracteristicaCollection(Collection<Vendedorcaracteristica> vendedorcaracteristicaCollection) {
        this.vendedorcaracteristicaCollection = vendedorcaracteristicaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcaracteristicapessoa != null ? codcaracteristicapessoa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Caracteristicapessoa)) {
            return false;
        }
        Caracteristicapessoa other = (Caracteristicapessoa) object;
        if ((this.codcaracteristicapessoa == null && other.codcaracteristicapessoa != null) || (this.codcaracteristicapessoa != null && !this.codcaracteristicapessoa.equals(other.codcaracteristicapessoa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Caracteristicapessoa[ codcaracteristicapessoa=" + codcaracteristicapessoa + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
