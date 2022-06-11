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
@Table(name = "HISTORICOSERASA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Historicoserasa.findAll", query = "SELECT h FROM Historicoserasa h")
    , @NamedQuery(name = "Historicoserasa.findByCodhistoricoserasa", query = "SELECT h FROM Historicoserasa h WHERE h.codhistoricoserasa = :codhistoricoserasa")
    , @NamedQuery(name = "Historicoserasa.findByCodigo", query = "SELECT h FROM Historicoserasa h WHERE h.codigo = :codigo")
    , @NamedQuery(name = "Historicoserasa.findByMensagem", query = "SELECT h FROM Historicoserasa h WHERE h.mensagem = :mensagem")
    , @NamedQuery(name = "Historicoserasa.findByStatus", query = "SELECT h FROM Historicoserasa h WHERE h.status = :status")
    , @NamedQuery(name = "Historicoserasa.findByCoduser", query = "SELECT h FROM Historicoserasa h WHERE h.coduser = :coduser")})
public class Historicoserasa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODHISTORICOSERASA")
    private String codhistoricoserasa;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "MENSAGEM")
    private String mensagem;
    @Column(name = "STATUS")
    private Character status;
    @Lob
    @Column(name = "XMLRETORNO")
    private String xmlretorno;
    @Column(name = "CODUSER")
    private String coduser;
    @JoinColumn(name = "CODCONSULTASERASA", referencedColumnName = "CODCONSULTASERASA")
    @ManyToOne
    private Consultaserasa codconsultaserasa;

    public Historicoserasa() {
    }

    public Historicoserasa(String codhistoricoserasa) {
        this.codhistoricoserasa = codhistoricoserasa;
    }

    public String getCodhistoricoserasa() {
        return codhistoricoserasa;
    }

    public void setCodhistoricoserasa(String codhistoricoserasa) {
        this.codhistoricoserasa = codhistoricoserasa;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public String getXmlretorno() {
        return xmlretorno;
    }

    public void setXmlretorno(String xmlretorno) {
        this.xmlretorno = xmlretorno;
    }

    public String getCoduser() {
        return coduser;
    }

    public void setCoduser(String coduser) {
        this.coduser = coduser;
    }

    public Consultaserasa getCodconsultaserasa() {
        return codconsultaserasa;
    }

    public void setCodconsultaserasa(Consultaserasa codconsultaserasa) {
        this.codconsultaserasa = codconsultaserasa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codhistoricoserasa != null ? codhistoricoserasa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Historicoserasa)) {
            return false;
        }
        Historicoserasa other = (Historicoserasa) object;
        if ((this.codhistoricoserasa == null && other.codhistoricoserasa != null) || (this.codhistoricoserasa != null && !this.codhistoricoserasa.equals(other.codhistoricoserasa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Historicoserasa[ codhistoricoserasa=" + codhistoricoserasa + " ]";
    }
    
}
