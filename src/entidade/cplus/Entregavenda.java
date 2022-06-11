/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ENTREGAVENDA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entregavenda.findAll", query = "SELECT e FROM Entregavenda e")
    , @NamedQuery(name = "Entregavenda.findByCodentregavenda", query = "SELECT e FROM Entregavenda e WHERE e.codentregavenda = :codentregavenda")
    , @NamedQuery(name = "Entregavenda.findByDestinatario", query = "SELECT e FROM Entregavenda e WHERE e.destinatario = :destinatario")
    , @NamedQuery(name = "Entregavenda.findByTelefone", query = "SELECT e FROM Entregavenda e WHERE e.telefone = :telefone")
    , @NamedQuery(name = "Entregavenda.findByEndereco", query = "SELECT e FROM Entregavenda e WHERE e.endereco = :endereco")
    , @NamedQuery(name = "Entregavenda.findByBairro", query = "SELECT e FROM Entregavenda e WHERE e.bairro = :bairro")
    , @NamedQuery(name = "Entregavenda.findByCidade", query = "SELECT e FROM Entregavenda e WHERE e.cidade = :cidade")
    , @NamedQuery(name = "Entregavenda.findByEstado", query = "SELECT e FROM Entregavenda e WHERE e.estado = :estado")
    , @NamedQuery(name = "Entregavenda.findByCep", query = "SELECT e FROM Entregavenda e WHERE e.cep = :cep")
    , @NamedQuery(name = "Entregavenda.findByReferencias", query = "SELECT e FROM Entregavenda e WHERE e.referencias = :referencias")
    , @NamedQuery(name = "Entregavenda.findByCodmovenda", query = "SELECT e FROM Entregavenda e WHERE e.codmovenda = :codmovenda")
    , @NamedQuery(name = "Entregavenda.findByDatentr", query = "SELECT e FROM Entregavenda e WHERE e.datentr = :datentr")
    , @NamedQuery(name = "Entregavenda.findByEntreganumerologradouro", query = "SELECT e FROM Entregavenda e WHERE e.entreganumerologradouro = :entreganumerologradouro")
    , @NamedQuery(name = "Entregavenda.findByEntregacomplementologradouro", query = "SELECT e FROM Entregavenda e WHERE e.entregacomplementologradouro = :entregacomplementologradouro")})
public class Entregavenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODENTREGAVENDA")
    private String codentregavenda;
    @Column(name = "DESTINATARIO")
    private String destinatario;
    @Column(name = "TELEFONE")
    private String telefone;
    @Column(name = "ENDERECO")
    private String endereco;
    @Column(name = "BAIRRO")
    private String bairro;
    @Column(name = "CIDADE")
    private String cidade;
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "CEP")
    private String cep;
    @Column(name = "REFERENCIAS")
    private String referencias;
    @Column(name = "CODMOVENDA")
    private String codmovenda;
    @Column(name = "DATENTR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datentr;
    @Lob
    @Column(name = "OBS")
    private String obs;
    @Column(name = "ENTREGANUMEROLOGRADOURO")
    private String entreganumerologradouro;
    @Column(name = "ENTREGACOMPLEMENTOLOGRADOURO")
    private String entregacomplementologradouro;

    public Entregavenda() {
    }

    public Entregavenda(String codentregavenda) {
        this.codentregavenda = codentregavenda;
    }

    public String getCodentregavenda() {
        return codentregavenda;
    }

    public void setCodentregavenda(String codentregavenda) {
        this.codentregavenda = codentregavenda;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getReferencias() {
        return referencias;
    }

    public void setReferencias(String referencias) {
        this.referencias = referencias;
    }

    public String getCodmovenda() {
        return codmovenda;
    }

    public void setCodmovenda(String codmovenda) {
        this.codmovenda = codmovenda;
    }

    public Date getDatentr() {
        return datentr;
    }

    public void setDatentr(Date datentr) {
        this.datentr = datentr;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getEntreganumerologradouro() {
        return entreganumerologradouro;
    }

    public void setEntreganumerologradouro(String entreganumerologradouro) {
        this.entreganumerologradouro = entreganumerologradouro;
    }

    public String getEntregacomplementologradouro() {
        return entregacomplementologradouro;
    }

    public void setEntregacomplementologradouro(String entregacomplementologradouro) {
        this.entregacomplementologradouro = entregacomplementologradouro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codentregavenda != null ? codentregavenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entregavenda)) {
            return false;
        }
        Entregavenda other = (Entregavenda) object;
        if ((this.codentregavenda == null && other.codentregavenda != null) || (this.codentregavenda != null && !this.codentregavenda.equals(other.codentregavenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Entregavenda[ codentregavenda=" + codentregavenda + " ]";
    }
    
}
