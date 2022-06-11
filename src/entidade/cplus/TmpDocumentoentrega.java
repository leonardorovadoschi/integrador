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
@Table(name = "TMP_DOCUMENTOENTREGA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TmpDocumentoentrega.findAll", query = "SELECT t FROM TmpDocumentoentrega t")
    , @NamedQuery(name = "TmpDocumentoentrega.findByCodtmpDocumentoentrega", query = "SELECT t FROM TmpDocumentoentrega t WHERE t.codtmpDocumentoentrega = :codtmpDocumentoentrega")
    , @NamedQuery(name = "TmpDocumentoentrega.findByCodtmpDocumento", query = "SELECT t FROM TmpDocumentoentrega t WHERE t.codtmpDocumento = :codtmpDocumento")
    , @NamedQuery(name = "TmpDocumentoentrega.findByEntregacpfcnpj", query = "SELECT t FROM TmpDocumentoentrega t WHERE t.entregacpfcnpj = :entregacpfcnpj")
    , @NamedQuery(name = "TmpDocumentoentrega.findByEntregadestinatario", query = "SELECT t FROM TmpDocumentoentrega t WHERE t.entregadestinatario = :entregadestinatario")
    , @NamedQuery(name = "TmpDocumentoentrega.findByEntregaendereco", query = "SELECT t FROM TmpDocumentoentrega t WHERE t.entregaendereco = :entregaendereco")
    , @NamedQuery(name = "TmpDocumentoentrega.findByEntreganumerologradouro", query = "SELECT t FROM TmpDocumentoentrega t WHERE t.entreganumerologradouro = :entreganumerologradouro")
    , @NamedQuery(name = "TmpDocumentoentrega.findByEntregacomplementologradouro", query = "SELECT t FROM TmpDocumentoentrega t WHERE t.entregacomplementologradouro = :entregacomplementologradouro")
    , @NamedQuery(name = "TmpDocumentoentrega.findByEntregabairro", query = "SELECT t FROM TmpDocumentoentrega t WHERE t.entregabairro = :entregabairro")
    , @NamedQuery(name = "TmpDocumentoentrega.findByEntregacidade", query = "SELECT t FROM TmpDocumentoentrega t WHERE t.entregacidade = :entregacidade")
    , @NamedQuery(name = "TmpDocumentoentrega.findByEntregacodigoibge", query = "SELECT t FROM TmpDocumentoentrega t WHERE t.entregacodigoibge = :entregacodigoibge")
    , @NamedQuery(name = "TmpDocumentoentrega.findByEntregaestado", query = "SELECT t FROM TmpDocumentoentrega t WHERE t.entregaestado = :entregaestado")
    , @NamedQuery(name = "TmpDocumentoentrega.findByEntregacep", query = "SELECT t FROM TmpDocumentoentrega t WHERE t.entregacep = :entregacep")
    , @NamedQuery(name = "TmpDocumentoentrega.findByEntregatelefone", query = "SELECT t FROM TmpDocumentoentrega t WHERE t.entregatelefone = :entregatelefone")
    , @NamedQuery(name = "TmpDocumentoentrega.findByEntregapais", query = "SELECT t FROM TmpDocumentoentrega t WHERE t.entregapais = :entregapais")
    , @NamedQuery(name = "TmpDocumentoentrega.findByEntregacodigopais", query = "SELECT t FROM TmpDocumentoentrega t WHERE t.entregacodigopais = :entregacodigopais")
    , @NamedQuery(name = "TmpDocumentoentrega.findByEntregaflagfisica", query = "SELECT t FROM TmpDocumentoentrega t WHERE t.entregaflagfisica = :entregaflagfisica")})
public class TmpDocumentoentrega implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODTMP_DOCUMENTOENTREGA")
    private Integer codtmpDocumentoentrega;
    @Basic(optional = false)
    @Column(name = "CODTMP_DOCUMENTO")
    private int codtmpDocumento;
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

    public TmpDocumentoentrega() {
    }

    public TmpDocumentoentrega(Integer codtmpDocumentoentrega) {
        this.codtmpDocumentoentrega = codtmpDocumentoentrega;
    }

    public TmpDocumentoentrega(Integer codtmpDocumentoentrega, int codtmpDocumento) {
        this.codtmpDocumentoentrega = codtmpDocumentoentrega;
        this.codtmpDocumento = codtmpDocumento;
    }

    public Integer getCodtmpDocumentoentrega() {
        return codtmpDocumentoentrega;
    }

    public void setCodtmpDocumentoentrega(Integer codtmpDocumentoentrega) {
        this.codtmpDocumentoentrega = codtmpDocumentoentrega;
    }

    public int getCodtmpDocumento() {
        return codtmpDocumento;
    }

    public void setCodtmpDocumento(int codtmpDocumento) {
        this.codtmpDocumento = codtmpDocumento;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codtmpDocumentoentrega != null ? codtmpDocumentoentrega.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TmpDocumentoentrega)) {
            return false;
        }
        TmpDocumentoentrega other = (TmpDocumentoentrega) object;
        if ((this.codtmpDocumentoentrega == null && other.codtmpDocumentoentrega != null) || (this.codtmpDocumentoentrega != null && !this.codtmpDocumentoentrega.equals(other.codtmpDocumentoentrega))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.TmpDocumentoentrega[ codtmpDocumentoentrega=" + codtmpDocumentoentrega + " ]";
    }
    
}
