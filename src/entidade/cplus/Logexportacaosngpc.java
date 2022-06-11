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
@Table(name = "LOGEXPORTACAOSNGPC", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Logexportacaosngpc.findAll", query = "SELECT l FROM Logexportacaosngpc l")
    , @NamedQuery(name = "Logexportacaosngpc.findByCodlogexportacaosngpc", query = "SELECT l FROM Logexportacaosngpc l WHERE l.codlogexportacaosngpc = :codlogexportacaosngpc")
    , @NamedQuery(name = "Logexportacaosngpc.findByDescricaoretorno", query = "SELECT l FROM Logexportacaosngpc l WHERE l.descricaoretorno = :descricaoretorno")
    , @NamedQuery(name = "Logexportacaosngpc.findByCoduser", query = "SELECT l FROM Logexportacaosngpc l WHERE l.coduser = :coduser")
    , @NamedQuery(name = "Logexportacaosngpc.findByData", query = "SELECT l FROM Logexportacaosngpc l WHERE l.data = :data")
    , @NamedQuery(name = "Logexportacaosngpc.findByDatainicio", query = "SELECT l FROM Logexportacaosngpc l WHERE l.datainicio = :datainicio")
    , @NamedQuery(name = "Logexportacaosngpc.findByDatafinal", query = "SELECT l FROM Logexportacaosngpc l WHERE l.datafinal = :datafinal")
    , @NamedQuery(name = "Logexportacaosngpc.findByHashxml", query = "SELECT l FROM Logexportacaosngpc l WHERE l.hashxml = :hashxml")
    , @NamedQuery(name = "Logexportacaosngpc.findByFlagtiporetorno", query = "SELECT l FROM Logexportacaosngpc l WHERE l.flagtiporetorno = :flagtiporetorno")})
public class Logexportacaosngpc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODLOGEXPORTACAOSNGPC")
    private String codlogexportacaosngpc;
    @Column(name = "DESCRICAORETORNO")
    private String descricaoretorno;
    @Basic(optional = false)
    @Column(name = "CODUSER")
    private String coduser;
    @Column(name = "DATA")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Lob
    @Column(name = "RETORNO")
    private String retorno;
    @Column(name = "DATAINICIO")
    @Temporal(TemporalType.DATE)
    private Date datainicio;
    @Column(name = "DATAFINAL")
    @Temporal(TemporalType.DATE)
    private Date datafinal;
    @Column(name = "HASHXML")
    private String hashxml;
    @Column(name = "FLAGTIPORETORNO")
    private Character flagtiporetorno;

    public Logexportacaosngpc() {
    }

    public Logexportacaosngpc(String codlogexportacaosngpc) {
        this.codlogexportacaosngpc = codlogexportacaosngpc;
    }

    public Logexportacaosngpc(String codlogexportacaosngpc, String coduser) {
        this.codlogexportacaosngpc = codlogexportacaosngpc;
        this.coduser = coduser;
    }

    public String getCodlogexportacaosngpc() {
        return codlogexportacaosngpc;
    }

    public void setCodlogexportacaosngpc(String codlogexportacaosngpc) {
        this.codlogexportacaosngpc = codlogexportacaosngpc;
    }

    public String getDescricaoretorno() {
        return descricaoretorno;
    }

    public void setDescricaoretorno(String descricaoretorno) {
        this.descricaoretorno = descricaoretorno;
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

    public String getRetorno() {
        return retorno;
    }

    public void setRetorno(String retorno) {
        this.retorno = retorno;
    }

    public Date getDatainicio() {
        return datainicio;
    }

    public void setDatainicio(Date datainicio) {
        this.datainicio = datainicio;
    }

    public Date getDatafinal() {
        return datafinal;
    }

    public void setDatafinal(Date datafinal) {
        this.datafinal = datafinal;
    }

    public String getHashxml() {
        return hashxml;
    }

    public void setHashxml(String hashxml) {
        this.hashxml = hashxml;
    }

    public Character getFlagtiporetorno() {
        return flagtiporetorno;
    }

    public void setFlagtiporetorno(Character flagtiporetorno) {
        this.flagtiporetorno = flagtiporetorno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codlogexportacaosngpc != null ? codlogexportacaosngpc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Logexportacaosngpc)) {
            return false;
        }
        Logexportacaosngpc other = (Logexportacaosngpc) object;
        if ((this.codlogexportacaosngpc == null && other.codlogexportacaosngpc != null) || (this.codlogexportacaosngpc != null && !this.codlogexportacaosngpc.equals(other.codlogexportacaosngpc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Logexportacaosngpc[ codlogexportacaosngpc=" + codlogexportacaosngpc + " ]";
    }
    
}
