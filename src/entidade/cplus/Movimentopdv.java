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
@Table(name = "MOVIMENTOPDV", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movimentopdv.findAll", query = "SELECT m FROM Movimentopdv m")
    , @NamedQuery(name = "Movimentopdv.findByCodmovimentopdv", query = "SELECT m FROM Movimentopdv m WHERE m.codmovimentopdv = :codmovimentopdv")
    , @NamedQuery(name = "Movimentopdv.findByNomearquivo", query = "SELECT m FROM Movimentopdv m WHERE m.nomearquivo = :nomearquivo")
    , @NamedQuery(name = "Movimentopdv.findByTamanhoarquivo", query = "SELECT m FROM Movimentopdv m WHERE m.tamanhoarquivo = :tamanhoarquivo")
    , @NamedQuery(name = "Movimentopdv.findByDataupload", query = "SELECT m FROM Movimentopdv m WHERE m.dataupload = :dataupload")
    , @NamedQuery(name = "Movimentopdv.findByDatadownload", query = "SELECT m FROM Movimentopdv m WHERE m.datadownload = :datadownload")
    , @NamedQuery(name = "Movimentopdv.findByCodigoterminal", query = "SELECT m FROM Movimentopdv m WHERE m.codigoterminal = :codigoterminal")
    , @NamedQuery(name = "Movimentopdv.findByIp", query = "SELECT m FROM Movimentopdv m WHERE m.ip = :ip")
    , @NamedQuery(name = "Movimentopdv.findByNomemaquina", query = "SELECT m FROM Movimentopdv m WHERE m.nomemaquina = :nomemaquina")
    , @NamedQuery(name = "Movimentopdv.findByNomemaquinaServer", query = "SELECT m FROM Movimentopdv m WHERE m.nomemaquinaServer = :nomemaquinaServer")
    , @NamedQuery(name = "Movimentopdv.findByIpServer", query = "SELECT m FROM Movimentopdv m WHERE m.ipServer = :ipServer")
    , @NamedQuery(name = "Movimentopdv.findByNomemaquinaTerminal", query = "SELECT m FROM Movimentopdv m WHERE m.nomemaquinaTerminal = :nomemaquinaTerminal")
    , @NamedQuery(name = "Movimentopdv.findByIpTerminal", query = "SELECT m FROM Movimentopdv m WHERE m.ipTerminal = :ipTerminal")
    , @NamedQuery(name = "Movimentopdv.findByVersaows", query = "SELECT m FROM Movimentopdv m WHERE m.versaows = :versaows")})
public class Movimentopdv implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODMOVIMENTOPDV")
    private String codmovimentopdv;
    @Column(name = "NOMEARQUIVO")
    private String nomearquivo;
    @Column(name = "TAMANHOARQUIVO")
    private Integer tamanhoarquivo;
    @Column(name = "DATAUPLOAD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataupload;
    @Column(name = "DATADOWNLOAD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datadownload;
    @Column(name = "CODIGOTERMINAL")
    private String codigoterminal;
    @Column(name = "IP")
    private String ip;
    @Column(name = "NOMEMAQUINA")
    private String nomemaquina;
    @Column(name = "NOMEMAQUINA_SERVER")
    private String nomemaquinaServer;
    @Column(name = "IP_SERVER")
    private String ipServer;
    @Column(name = "NOMEMAQUINA_TERMINAL")
    private String nomemaquinaTerminal;
    @Column(name = "IP_TERMINAL")
    private String ipTerminal;
    @Column(name = "VERSAOWS")
    private String versaows;

    public Movimentopdv() {
    }

    public Movimentopdv(String codmovimentopdv) {
        this.codmovimentopdv = codmovimentopdv;
    }

    public String getCodmovimentopdv() {
        return codmovimentopdv;
    }

    public void setCodmovimentopdv(String codmovimentopdv) {
        this.codmovimentopdv = codmovimentopdv;
    }

    public String getNomearquivo() {
        return nomearquivo;
    }

    public void setNomearquivo(String nomearquivo) {
        this.nomearquivo = nomearquivo;
    }

    public Integer getTamanhoarquivo() {
        return tamanhoarquivo;
    }

    public void setTamanhoarquivo(Integer tamanhoarquivo) {
        this.tamanhoarquivo = tamanhoarquivo;
    }

    public Date getDataupload() {
        return dataupload;
    }

    public void setDataupload(Date dataupload) {
        this.dataupload = dataupload;
    }

    public Date getDatadownload() {
        return datadownload;
    }

    public void setDatadownload(Date datadownload) {
        this.datadownload = datadownload;
    }

    public String getCodigoterminal() {
        return codigoterminal;
    }

    public void setCodigoterminal(String codigoterminal) {
        this.codigoterminal = codigoterminal;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getNomemaquina() {
        return nomemaquina;
    }

    public void setNomemaquina(String nomemaquina) {
        this.nomemaquina = nomemaquina;
    }

    public String getNomemaquinaServer() {
        return nomemaquinaServer;
    }

    public void setNomemaquinaServer(String nomemaquinaServer) {
        this.nomemaquinaServer = nomemaquinaServer;
    }

    public String getIpServer() {
        return ipServer;
    }

    public void setIpServer(String ipServer) {
        this.ipServer = ipServer;
    }

    public String getNomemaquinaTerminal() {
        return nomemaquinaTerminal;
    }

    public void setNomemaquinaTerminal(String nomemaquinaTerminal) {
        this.nomemaquinaTerminal = nomemaquinaTerminal;
    }

    public String getIpTerminal() {
        return ipTerminal;
    }

    public void setIpTerminal(String ipTerminal) {
        this.ipTerminal = ipTerminal;
    }

    public String getVersaows() {
        return versaows;
    }

    public void setVersaows(String versaows) {
        this.versaows = versaows;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmovimentopdv != null ? codmovimentopdv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movimentopdv)) {
            return false;
        }
        Movimentopdv other = (Movimentopdv) object;
        if ((this.codmovimentopdv == null && other.codmovimentopdv != null) || (this.codmovimentopdv != null && !this.codmovimentopdv.equals(other.codmovimentopdv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Movimentopdv[ codmovimentopdv=" + codmovimentopdv + " ]";
    }
    
}
