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
import javax.persistence.Lob;
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
@Table(name = "EMAILANEXO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Emailanexo.findAll", query = "SELECT e FROM Emailanexo e")
    , @NamedQuery(name = "Emailanexo.findByCodemailanexo", query = "SELECT e FROM Emailanexo e WHERE e.codemailanexo = :codemailanexo")
    , @NamedQuery(name = "Emailanexo.findByArquivo", query = "SELECT e FROM Emailanexo e WHERE e.arquivo = :arquivo")
    , @NamedQuery(name = "Emailanexo.findByContentid", query = "SELECT e FROM Emailanexo e WHERE e.contentid = :contentid")
    , @NamedQuery(name = "Emailanexo.findByEnderecoscc", query = "SELECT e FROM Emailanexo e WHERE e.enderecoscc = :enderecoscc")})
public class Emailanexo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODEMAILANEXO")
    private String codemailanexo;
    @Lob
    @Column(name = "ANEXO")
    private byte[] anexo;
    @Column(name = "ARQUIVO")
    private String arquivo;
    @Column(name = "CONTENTID")
    private String contentid;
    @Column(name = "ENDERECOSCC")
    private String enderecoscc;
    @JoinColumn(name = "CODEMAIL", referencedColumnName = "CODEMAIL")
    @ManyToOne
    private Email codemail;

    public Emailanexo() {
    }

    public Emailanexo(String codemailanexo) {
        this.codemailanexo = codemailanexo;
    }

    public String getCodemailanexo() {
        return codemailanexo;
    }

    public void setCodemailanexo(String codemailanexo) {
        this.codemailanexo = codemailanexo;
    }

    public byte[] getAnexo() {
        return anexo;
    }

    public void setAnexo(byte[] anexo) {
        this.anexo = anexo;
    }

    public String getArquivo() {
        return arquivo;
    }

    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }

    public String getContentid() {
        return contentid;
    }

    public void setContentid(String contentid) {
        this.contentid = contentid;
    }

    public String getEnderecoscc() {
        return enderecoscc;
    }

    public void setEnderecoscc(String enderecoscc) {
        this.enderecoscc = enderecoscc;
    }

    public Email getCodemail() {
        return codemail;
    }

    public void setCodemail(Email codemail) {
        this.codemail = codemail;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codemailanexo != null ? codemailanexo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Emailanexo)) {
            return false;
        }
        Emailanexo other = (Emailanexo) object;
        if ((this.codemailanexo == null && other.codemailanexo != null) || (this.codemailanexo != null && !this.codemailanexo.equals(other.codemailanexo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Emailanexo[ codemailanexo=" + codemailanexo + " ]";
    }
    
}
