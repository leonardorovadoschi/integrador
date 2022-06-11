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
@Table(name = "MENSAGEMAFV", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mensagemafv.findAll", query = "SELECT m FROM Mensagemafv m")
    , @NamedQuery(name = "Mensagemafv.findByCodmensagemafv", query = "SELECT m FROM Mensagemafv m WHERE m.codmensagemafv = :codmensagemafv")
    , @NamedQuery(name = "Mensagemafv.findByData", query = "SELECT m FROM Mensagemafv m WHERE m.data = :data")
    , @NamedQuery(name = "Mensagemafv.findByMensagem", query = "SELECT m FROM Mensagemafv m WHERE m.mensagem = :mensagem")})
public class Mensagemafv implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODMENSAGEMAFV")
    private String codmensagemafv;
    @Column(name = "DATA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Column(name = "MENSAGEM")
    private String mensagem;

    public Mensagemafv() {
    }

    public Mensagemafv(String codmensagemafv) {
        this.codmensagemafv = codmensagemafv;
    }

    public String getCodmensagemafv() {
        return codmensagemafv;
    }

    public void setCodmensagemafv(String codmensagemafv) {
        this.codmensagemafv = codmensagemafv;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmensagemafv != null ? codmensagemafv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mensagemafv)) {
            return false;
        }
        Mensagemafv other = (Mensagemafv) object;
        if ((this.codmensagemafv == null && other.codmensagemafv != null) || (this.codmensagemafv != null && !this.codmensagemafv.equals(other.codmensagemafv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Mensagemafv[ codmensagemafv=" + codmensagemafv + " ]";
    }
    
}
