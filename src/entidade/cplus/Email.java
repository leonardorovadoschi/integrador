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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "EMAIL", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Email.findAll", query = "SELECT e FROM Email e")
    , @NamedQuery(name = "Email.findByCodemail", query = "SELECT e FROM Email e WHERE e.codemail = :codemail")
    , @NamedQuery(name = "Email.findByCodforn", query = "SELECT e FROM Email e WHERE e.codforn = :codforn")
    , @NamedQuery(name = "Email.findByCoduser", query = "SELECT e FROM Email e WHERE e.coduser = :coduser")
    , @NamedQuery(name = "Email.findByData", query = "SELECT e FROM Email e WHERE e.data = :data")
    , @NamedQuery(name = "Email.findByHora", query = "SELECT e FROM Email e WHERE e.hora = :hora")
    , @NamedQuery(name = "Email.findByEndereco", query = "SELECT e FROM Email e WHERE e.endereco = :endereco")
    , @NamedQuery(name = "Email.findByAssunto", query = "SELECT e FROM Email e WHERE e.assunto = :assunto")
    , @NamedQuery(name = "Email.findByTipo", query = "SELECT e FROM Email e WHERE e.tipo = :tipo")
    , @NamedQuery(name = "Email.findByStatus", query = "SELECT e FROM Email e WHERE e.status = :status")
    , @NamedQuery(name = "Email.findByContenttype", query = "SELECT e FROM Email e WHERE e.contenttype = :contenttype")
    , @NamedQuery(name = "Email.findByEnderecoscc", query = "SELECT e FROM Email e WHERE e.enderecoscc = :enderecoscc")
    , @NamedQuery(name = "Email.findByEnderecoorigem", query = "SELECT e FROM Email e WHERE e.enderecoorigem = :enderecoorigem")
    , @NamedQuery(name = "Email.findByEnderecodestino", query = "SELECT e FROM Email e WHERE e.enderecodestino = :enderecodestino")})
public class Email implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODEMAIL")
    private String codemail;
    @Column(name = "CODFORN")
    private String codforn;
    @Column(name = "CODUSER")
    private String coduser;
    @Column(name = "DATA")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "HORA")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @Lob
    @Column(name = "MENSAGEM")
    private String mensagem;
    @Column(name = "ENDERECO")
    private String endereco;
    @Column(name = "ASSUNTO")
    private String assunto;
    @Column(name = "TIPO")
    private Character tipo;
    @Column(name = "STATUS")
    private Character status;
    @Lob
    @Column(name = "CABECALHO")
    private String cabecalho;
    @Column(name = "CONTENTTYPE")
    private String contenttype;
    @Column(name = "ENDERECOSCC")
    private String enderecoscc;
    @Column(name = "ENDERECOORIGEM")
    private String enderecoorigem;
    @Column(name = "ENDERECODESTINO")
    private String enderecodestino;
    @JoinColumn(name = "CODCLI", referencedColumnName = "CODCLI")
    @ManyToOne
    private Cliente codcli;
    @OneToMany(mappedBy = "codemail")
    private Collection<Emailanexo> emailanexoCollection;

    public Email() {
    }

    public Email(String codemail) {
        this.codemail = codemail;
    }

    public String getCodemail() {
        return codemail;
    }

    public void setCodemail(String codemail) {
        this.codemail = codemail;
    }

    public String getCodforn() {
        return codforn;
    }

    public void setCodforn(String codforn) {
        this.codforn = codforn;
    }

    public String getCoduser() {
        return coduser;
    }

    public void setCoduser(String coduser) {
        this.coduser = coduser;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public String getCabecalho() {
        return cabecalho;
    }

    public void setCabecalho(String cabecalho) {
        this.cabecalho = cabecalho;
    }

    public String getContenttype() {
        return contenttype;
    }

    public void setContenttype(String contenttype) {
        this.contenttype = contenttype;
    }

    public String getEnderecoscc() {
        return enderecoscc;
    }

    public void setEnderecoscc(String enderecoscc) {
        this.enderecoscc = enderecoscc;
    }

    public String getEnderecoorigem() {
        return enderecoorigem;
    }

    public void setEnderecoorigem(String enderecoorigem) {
        this.enderecoorigem = enderecoorigem;
    }

    public String getEnderecodestino() {
        return enderecodestino;
    }

    public void setEnderecodestino(String enderecodestino) {
        this.enderecodestino = enderecodestino;
    }

    public Cliente getCodcli() {
        return codcli;
    }

    public void setCodcli(Cliente codcli) {
        this.codcli = codcli;
    }

    @XmlTransient
    public Collection<Emailanexo> getEmailanexoCollection() {
        return emailanexoCollection;
    }

    public void setEmailanexoCollection(Collection<Emailanexo> emailanexoCollection) {
        this.emailanexoCollection = emailanexoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codemail != null ? codemail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Email)) {
            return false;
        }
        Email other = (Email) object;
        if ((this.codemail == null && other.codemail != null) || (this.codemail != null && !this.codemail.equals(other.codemail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Email[ codemail=" + codemail + " ]";
    }
    
}
