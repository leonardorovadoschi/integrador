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
@Table(name = "DOCUMENTOENTREGA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Documentoentrega.findAll", query = "SELECT d FROM Documentoentrega d")
    , @NamedQuery(name = "Documentoentrega.findByCoddocumentoentrega", query = "SELECT d FROM Documentoentrega d WHERE d.coddocumentoentrega = :coddocumentoentrega")
    , @NamedQuery(name = "Documentoentrega.findByEntregacpfcnpj", query = "SELECT d FROM Documentoentrega d WHERE d.entregacpfcnpj = :entregacpfcnpj")
    , @NamedQuery(name = "Documentoentrega.findByEntregadestinatario", query = "SELECT d FROM Documentoentrega d WHERE d.entregadestinatario = :entregadestinatario")
    , @NamedQuery(name = "Documentoentrega.findByEntregaendereco", query = "SELECT d FROM Documentoentrega d WHERE d.entregaendereco = :entregaendereco")
    , @NamedQuery(name = "Documentoentrega.findByEntreganumerologradouro", query = "SELECT d FROM Documentoentrega d WHERE d.entreganumerologradouro = :entreganumerologradouro")
    , @NamedQuery(name = "Documentoentrega.findByEntregacomplementologradouro", query = "SELECT d FROM Documentoentrega d WHERE d.entregacomplementologradouro = :entregacomplementologradouro")
    , @NamedQuery(name = "Documentoentrega.findByEntregabairro", query = "SELECT d FROM Documentoentrega d WHERE d.entregabairro = :entregabairro")
    , @NamedQuery(name = "Documentoentrega.findByEntregacidade", query = "SELECT d FROM Documentoentrega d WHERE d.entregacidade = :entregacidade")
    , @NamedQuery(name = "Documentoentrega.findByEntregacodigoibge", query = "SELECT d FROM Documentoentrega d WHERE d.entregacodigoibge = :entregacodigoibge")
    , @NamedQuery(name = "Documentoentrega.findByEntregaestado", query = "SELECT d FROM Documentoentrega d WHERE d.entregaestado = :entregaestado")
    , @NamedQuery(name = "Documentoentrega.findByEntregacep", query = "SELECT d FROM Documentoentrega d WHERE d.entregacep = :entregacep")
    , @NamedQuery(name = "Documentoentrega.findByEntregatelefone", query = "SELECT d FROM Documentoentrega d WHERE d.entregatelefone = :entregatelefone")
    , @NamedQuery(name = "Documentoentrega.findByEntregapais", query = "SELECT d FROM Documentoentrega d WHERE d.entregapais = :entregapais")
    , @NamedQuery(name = "Documentoentrega.findByEntregacodigopais", query = "SELECT d FROM Documentoentrega d WHERE d.entregacodigopais = :entregacodigopais")
    , @NamedQuery(name = "Documentoentrega.findByEntregaflagfisica", query = "SELECT d FROM Documentoentrega d WHERE d.entregaflagfisica = :entregaflagfisica")})
public class Documentoentrega implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODDOCUMENTOENTREGA")
    private String coddocumentoentrega;
    @Column(name = "ENTREGACPFCNPJ")
    private String entregacpfcnpj;
    @Column(name = "ENTREGADESTINATARIO")
    private String entregadestinatario;
    @Column(name = "ENTREGAENDERECO")
    private String entregaendereco;
    @Column(name = "ENTREGANUMEROLOGRADOURO")
    private String entreganumerologradouro;
    @Column(name = "ENTREGACOMPLEMENTOLOGRADOURO")
    private String entregacomplementologradouro;
    @Column(name = "ENTREGABAIRRO")
    private String entregabairro;
    @Column(name = "ENTREGACIDADE")
    private String entregacidade;
    @Column(name = "ENTREGACODIGOIBGE")
    private String entregacodigoibge;
    @Column(name = "ENTREGAESTADO")
    private String entregaestado;
    @Column(name = "ENTREGACEP")
    private String entregacep;
    @Column(name = "ENTREGATELEFONE")
    private String entregatelefone;
    @Column(name = "ENTREGAPAIS")
    private String entregapais;
    @Column(name = "ENTREGACODIGOPAIS")
    private String entregacodigopais;
    @Column(name = "ENTREGAFLAGFISICA")
    private Character entregaflagfisica;
    @JoinColumn(name = "CODDOCUMENTO", referencedColumnName = "CODDOCUMENTO")
    @ManyToOne(optional = false)
    private Documento coddocumento;

    public Documentoentrega() {
    }

    public Documentoentrega(String coddocumentoentrega) {
        this.coddocumentoentrega = coddocumentoentrega;
    }

    public String getCoddocumentoentrega() {
        return coddocumentoentrega;
    }

    public void setCoddocumentoentrega(String coddocumentoentrega) {
        this.coddocumentoentrega = coddocumentoentrega;
    }

    public String getEntregacpfcnpj() {
        return entregacpfcnpj;
    }

    public void setEntregacpfcnpj(String entregacpfcnpj) {
        this.entregacpfcnpj = entregacpfcnpj;
    }

    public String getEntregadestinatario() {
        return entregadestinatario;
    }

    public void setEntregadestinatario(String entregadestinatario) {
        this.entregadestinatario = entregadestinatario;
    }

    public String getEntregaendereco() {
        return entregaendereco;
    }

    public void setEntregaendereco(String entregaendereco) {
        this.entregaendereco = entregaendereco;
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

    public String getEntregabairro() {
        return entregabairro;
    }

    public void setEntregabairro(String entregabairro) {
        this.entregabairro = entregabairro;
    }

    public String getEntregacidade() {
        return entregacidade;
    }

    public void setEntregacidade(String entregacidade) {
        this.entregacidade = entregacidade;
    }

    public String getEntregacodigoibge() {
        return entregacodigoibge;
    }

    public void setEntregacodigoibge(String entregacodigoibge) {
        this.entregacodigoibge = entregacodigoibge;
    }

    public String getEntregaestado() {
        return entregaestado;
    }

    public void setEntregaestado(String entregaestado) {
        this.entregaestado = entregaestado;
    }

    public String getEntregacep() {
        return entregacep;
    }

    public void setEntregacep(String entregacep) {
        this.entregacep = entregacep;
    }

    public String getEntregatelefone() {
        return entregatelefone;
    }

    public void setEntregatelefone(String entregatelefone) {
        this.entregatelefone = entregatelefone;
    }

    public String getEntregapais() {
        return entregapais;
    }

    public void setEntregapais(String entregapais) {
        this.entregapais = entregapais;
    }

    public String getEntregacodigopais() {
        return entregacodigopais;
    }

    public void setEntregacodigopais(String entregacodigopais) {
        this.entregacodigopais = entregacodigopais;
    }

    public Character getEntregaflagfisica() {
        return entregaflagfisica;
    }

    public void setEntregaflagfisica(Character entregaflagfisica) {
        this.entregaflagfisica = entregaflagfisica;
    }

    public Documento getCoddocumento() {
        return coddocumento;
    }

    public void setCoddocumento(Documento coddocumento) {
        this.coddocumento = coddocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coddocumentoentrega != null ? coddocumentoentrega.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documentoentrega)) {
            return false;
        }
        Documentoentrega other = (Documentoentrega) object;
        if ((this.coddocumentoentrega == null && other.coddocumentoentrega != null) || (this.coddocumentoentrega != null && !this.coddocumentoentrega.equals(other.coddocumentoentrega))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Documentoentrega[ coddocumentoentrega=" + coddocumentoentrega + " ]";
    }
    
}
