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
@Table(name = "NFELETRONICALOG", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nfeletronicalog.findAll", query = "SELECT n FROM Nfeletronicalog n")
    , @NamedQuery(name = "Nfeletronicalog.findByIdnfeletronicalog", query = "SELECT n FROM Nfeletronicalog n WHERE n.idnfeletronicalog = :idnfeletronicalog")
    , @NamedQuery(name = "Nfeletronicalog.findByDataxml", query = "SELECT n FROM Nfeletronicalog n WHERE n.dataxml = :dataxml")
    , @NamedQuery(name = "Nfeletronicalog.findByHoraxml", query = "SELECT n FROM Nfeletronicalog n WHERE n.horaxml = :horaxml")
    , @NamedQuery(name = "Nfeletronicalog.findByTipo", query = "SELECT n FROM Nfeletronicalog n WHERE n.tipo = :tipo")
    , @NamedQuery(name = "Nfeletronicalog.findByDatacadastro", query = "SELECT n FROM Nfeletronicalog n WHERE n.datacadastro = :datacadastro")
    , @NamedQuery(name = "Nfeletronicalog.findByChave", query = "SELECT n FROM Nfeletronicalog n WHERE n.chave = :chave")
    , @NamedQuery(name = "Nfeletronicalog.findByNumerolote", query = "SELECT n FROM Nfeletronicalog n WHERE n.numerolote = :numerolote")
    , @NamedQuery(name = "Nfeletronicalog.findByNumeroprotocolo", query = "SELECT n FROM Nfeletronicalog n WHERE n.numeroprotocolo = :numeroprotocolo")
    , @NamedQuery(name = "Nfeletronicalog.findByCodigoretorno", query = "SELECT n FROM Nfeletronicalog n WHERE n.codigoretorno = :codigoretorno")
    , @NamedQuery(name = "Nfeletronicalog.findByDescricaoretornonfeletronica", query = "SELECT n FROM Nfeletronicalog n WHERE n.descricaoretornonfeletronica = :descricaoretornonfeletronica")
    , @NamedQuery(name = "Nfeletronicalog.findByNomearquivo", query = "SELECT n FROM Nfeletronicalog n WHERE n.nomearquivo = :nomearquivo")
    , @NamedQuery(name = "Nfeletronicalog.findByAmbiente", query = "SELECT n FROM Nfeletronicalog n WHERE n.ambiente = :ambiente")
    , @NamedQuery(name = "Nfeletronicalog.findByDigestvalue", query = "SELECT n FROM Nfeletronicalog n WHERE n.digestvalue = :digestvalue")})
public class Nfeletronicalog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDNFELETRONICALOG")
    private Integer idnfeletronicalog;
    @Column(name = "DATAXML")
    @Temporal(TemporalType.DATE)
    private Date dataxml;
    @Column(name = "HORAXML")
    @Temporal(TemporalType.TIME)
    private Date horaxml;
    @Lob
    @Column(name = "XML")
    private String xml;
    @Column(name = "TIPO")
    private String tipo;
    @Column(name = "DATACADASTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datacadastro;
    @Column(name = "CHAVE")
    private String chave;
    @Column(name = "NUMEROLOTE")
    private String numerolote;
    @Column(name = "NUMEROPROTOCOLO")
    private String numeroprotocolo;
    @Column(name = "CODIGORETORNO")
    private String codigoretorno;
    @Column(name = "DESCRICAORETORNONFELETRONICA")
    private String descricaoretornonfeletronica;
    @Column(name = "NOMEARQUIVO")
    private String nomearquivo;
    @Column(name = "AMBIENTE")
    private Character ambiente;
    @Column(name = "DIGESTVALUE")
    private String digestvalue;

    public Nfeletronicalog() {
    }

    public Nfeletronicalog(Integer idnfeletronicalog) {
        this.idnfeletronicalog = idnfeletronicalog;
    }

    public Integer getIdnfeletronicalog() {
        return idnfeletronicalog;
    }

    public void setIdnfeletronicalog(Integer idnfeletronicalog) {
        this.idnfeletronicalog = idnfeletronicalog;
    }

    public Date getDataxml() {
        return dataxml;
    }

    public void setDataxml(Date dataxml) {
        this.dataxml = dataxml;
    }

    public Date getHoraxml() {
        return horaxml;
    }

    public void setHoraxml(Date horaxml) {
        this.horaxml = horaxml;
    }

    public String getXml() {
        return xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getDatacadastro() {
        return datacadastro;
    }

    public void setDatacadastro(Date datacadastro) {
        this.datacadastro = datacadastro;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getNumerolote() {
        return numerolote;
    }

    public void setNumerolote(String numerolote) {
        this.numerolote = numerolote;
    }

    public String getNumeroprotocolo() {
        return numeroprotocolo;
    }

    public void setNumeroprotocolo(String numeroprotocolo) {
        this.numeroprotocolo = numeroprotocolo;
    }

    public String getCodigoretorno() {
        return codigoretorno;
    }

    public void setCodigoretorno(String codigoretorno) {
        this.codigoretorno = codigoretorno;
    }

    public String getDescricaoretornonfeletronica() {
        return descricaoretornonfeletronica;
    }

    public void setDescricaoretornonfeletronica(String descricaoretornonfeletronica) {
        this.descricaoretornonfeletronica = descricaoretornonfeletronica;
    }

    public String getNomearquivo() {
        return nomearquivo;
    }

    public void setNomearquivo(String nomearquivo) {
        this.nomearquivo = nomearquivo;
    }

    public Character getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(Character ambiente) {
        this.ambiente = ambiente;
    }

    public String getDigestvalue() {
        return digestvalue;
    }

    public void setDigestvalue(String digestvalue) {
        this.digestvalue = digestvalue;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idnfeletronicalog != null ? idnfeletronicalog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nfeletronicalog)) {
            return false;
        }
        Nfeletronicalog other = (Nfeletronicalog) object;
        if ((this.idnfeletronicalog == null && other.idnfeletronicalog != null) || (this.idnfeletronicalog != null && !this.idnfeletronicalog.equals(other.idnfeletronicalog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Nfeletronicalog[ idnfeletronicalog=" + idnfeletronicalog + " ]";
    }
    
}
