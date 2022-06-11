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
@Table(name = "MDFELETRONICONAOENCERRADO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mdfeletroniconaoencerrado.findAll", query = "SELECT m FROM Mdfeletroniconaoencerrado m")
    , @NamedQuery(name = "Mdfeletroniconaoencerrado.findByCodmdfeletroniconaoencerrado", query = "SELECT m FROM Mdfeletroniconaoencerrado m WHERE m.codmdfeletroniconaoencerrado = :codmdfeletroniconaoencerrado")
    , @NamedQuery(name = "Mdfeletroniconaoencerrado.findByChaveacesso", query = "SELECT m FROM Mdfeletroniconaoencerrado m WHERE m.chaveacesso = :chaveacesso")
    , @NamedQuery(name = "Mdfeletroniconaoencerrado.findByNumeroprotocolo", query = "SELECT m FROM Mdfeletroniconaoencerrado m WHERE m.numeroprotocolo = :numeroprotocolo")
    , @NamedQuery(name = "Mdfeletroniconaoencerrado.findByData", query = "SELECT m FROM Mdfeletroniconaoencerrado m WHERE m.data = :data")
    , @NamedQuery(name = "Mdfeletroniconaoencerrado.findByCodempresa", query = "SELECT m FROM Mdfeletroniconaoencerrado m WHERE m.codempresa = :codempresa")
    , @NamedQuery(name = "Mdfeletroniconaoencerrado.findByCodigoretorno", query = "SELECT m FROM Mdfeletroniconaoencerrado m WHERE m.codigoretorno = :codigoretorno")
    , @NamedQuery(name = "Mdfeletroniconaoencerrado.findByDescricaoretorno", query = "SELECT m FROM Mdfeletroniconaoencerrado m WHERE m.descricaoretorno = :descricaoretorno")})
public class Mdfeletroniconaoencerrado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODMDFELETRONICONAOENCERRADO")
    private String codmdfeletroniconaoencerrado;
    @Column(name = "CHAVEACESSO")
    private String chaveacesso;
    @Column(name = "NUMEROPROTOCOLO")
    private String numeroprotocolo;
    @Column(name = "DATA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Column(name = "CODEMPRESA")
    private String codempresa;
    @Column(name = "CODIGORETORNO")
    private String codigoretorno;
    @Column(name = "DESCRICAORETORNO")
    private String descricaoretorno;

    public Mdfeletroniconaoencerrado() {
    }

    public Mdfeletroniconaoencerrado(String codmdfeletroniconaoencerrado) {
        this.codmdfeletroniconaoencerrado = codmdfeletroniconaoencerrado;
    }

    public String getCodmdfeletroniconaoencerrado() {
        return codmdfeletroniconaoencerrado;
    }

    public void setCodmdfeletroniconaoencerrado(String codmdfeletroniconaoencerrado) {
        this.codmdfeletroniconaoencerrado = codmdfeletroniconaoencerrado;
    }

    public String getChaveacesso() {
        return chaveacesso;
    }

    public void setChaveacesso(String chaveacesso) {
        this.chaveacesso = chaveacesso;
    }

    public String getNumeroprotocolo() {
        return numeroprotocolo;
    }

    public void setNumeroprotocolo(String numeroprotocolo) {
        this.numeroprotocolo = numeroprotocolo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(String codempresa) {
        this.codempresa = codempresa;
    }

    public String getCodigoretorno() {
        return codigoretorno;
    }

    public void setCodigoretorno(String codigoretorno) {
        this.codigoretorno = codigoretorno;
    }

    public String getDescricaoretorno() {
        return descricaoretorno;
    }

    public void setDescricaoretorno(String descricaoretorno) {
        this.descricaoretorno = descricaoretorno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmdfeletroniconaoencerrado != null ? codmdfeletroniconaoencerrado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mdfeletroniconaoencerrado)) {
            return false;
        }
        Mdfeletroniconaoencerrado other = (Mdfeletroniconaoencerrado) object;
        if ((this.codmdfeletroniconaoencerrado == null && other.codmdfeletroniconaoencerrado != null) || (this.codmdfeletroniconaoencerrado != null && !this.codmdfeletroniconaoencerrado.equals(other.codmdfeletroniconaoencerrado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Mdfeletroniconaoencerrado[ codmdfeletroniconaoencerrado=" + codmdfeletroniconaoencerrado + " ]";
    }
    
}
