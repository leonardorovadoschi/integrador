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
@Table(name = "WCPLUS_CONFIGURACAO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WcplusConfiguracao.findAll", query = "SELECT w FROM WcplusConfiguracao w")
    , @NamedQuery(name = "WcplusConfiguracao.findByCodwcplus", query = "SELECT w FROM WcplusConfiguracao w WHERE w.codwcplus = :codwcplus")
    , @NamedQuery(name = "WcplusConfiguracao.findByNomewcplus", query = "SELECT w FROM WcplusConfiguracao w WHERE w.nomewcplus = :nomewcplus")
    , @NamedQuery(name = "WcplusConfiguracao.findByCodcaracteristica", query = "SELECT w FROM WcplusConfiguracao w WHERE w.codcaracteristica = :codcaracteristica")
    , @NamedQuery(name = "WcplusConfiguracao.findByCodestoque", query = "SELECT w FROM WcplusConfiguracao w WHERE w.codestoque = :codestoque")
    , @NamedQuery(name = "WcplusConfiguracao.findByCodpreco", query = "SELECT w FROM WcplusConfiguracao w WHERE w.codpreco = :codpreco")
    , @NamedQuery(name = "WcplusConfiguracao.findByCodvended", query = "SELECT w FROM WcplusConfiguracao w WHERE w.codvended = :codvended")
    , @NamedQuery(name = "WcplusConfiguracao.findByCodcaracteristicapessoa", query = "SELECT w FROM WcplusConfiguracao w WHERE w.codcaracteristicapessoa = :codcaracteristicapessoa")
    , @NamedQuery(name = "WcplusConfiguracao.findByCodtipomovimento", query = "SELECT w FROM WcplusConfiguracao w WHERE w.codtipomovimento = :codtipomovimento")
    , @NamedQuery(name = "WcplusConfiguracao.findByUrl", query = "SELECT w FROM WcplusConfiguracao w WHERE w.url = :url")
    , @NamedQuery(name = "WcplusConfiguracao.findByIntervalo", query = "SELECT w FROM WcplusConfiguracao w WHERE w.intervalo = :intervalo")
    , @NamedQuery(name = "WcplusConfiguracao.findByLastupdate", query = "SELECT w FROM WcplusConfiguracao w WHERE w.lastupdate = :lastupdate")
    , @NamedQuery(name = "WcplusConfiguracao.findByFlagtipopessoa", query = "SELECT w FROM WcplusConfiguracao w WHERE w.flagtipopessoa = :flagtipopessoa")
    , @NamedQuery(name = "WcplusConfiguracao.findByFlagconcatenaidproduto", query = "SELECT w FROM WcplusConfiguracao w WHERE w.flagconcatenaidproduto = :flagconcatenaidproduto")
    , @NamedQuery(name = "WcplusConfiguracao.findByDiferenciadordebase", query = "SELECT w FROM WcplusConfiguracao w WHERE w.diferenciadordebase = :diferenciadordebase")
    , @NamedQuery(name = "WcplusConfiguracao.findByToken", query = "SELECT w FROM WcplusConfiguracao w WHERE w.token = :token")
    , @NamedQuery(name = "WcplusConfiguracao.findByCodprecomag", query = "SELECT w FROM WcplusConfiguracao w WHERE w.codprecomag = :codprecomag")
    , @NamedQuery(name = "WcplusConfiguracao.findByCodprecoprommag", query = "SELECT w FROM WcplusConfiguracao w WHERE w.codprecoprommag = :codprecoprommag")
    , @NamedQuery(name = "WcplusConfiguracao.findByPlataforma", query = "SELECT w FROM WcplusConfiguracao w WHERE w.plataforma = :plataforma")
    , @NamedQuery(name = "WcplusConfiguracao.findByCodempresa", query = "SELECT w FROM WcplusConfiguracao w WHERE w.codempresa = :codempresa")
    , @NamedQuery(name = "WcplusConfiguracao.findByFlagenviartodascaracteristicas", query = "SELECT w FROM WcplusConfiguracao w WHERE w.flagenviartodascaracteristicas = :flagenviartodascaracteristicas")
    , @NamedQuery(name = "WcplusConfiguracao.findByUsuarioApi", query = "SELECT w FROM WcplusConfiguracao w WHERE w.usuarioApi = :usuarioApi")
    , @NamedQuery(name = "WcplusConfiguracao.findBySenhaApi", query = "SELECT w FROM WcplusConfiguracao w WHERE w.senhaApi = :senhaApi")
    , @NamedQuery(name = "WcplusConfiguracao.findByCodcaracteristicapromo", query = "SELECT w FROM WcplusConfiguracao w WHERE w.codcaracteristicapromo = :codcaracteristicapromo")})
public class WcplusConfiguracao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODWCPLUS")
    private Integer codwcplus;
    @Column(name = "NOMEWCPLUS")
    private String nomewcplus;
    @Column(name = "CODCARACTERISTICA")
    private String codcaracteristica;
    @Column(name = "CODESTOQUE")
    private String codestoque;
    @Column(name = "CODPRECO")
    private String codpreco;
    @Column(name = "CODVENDED")
    private String codvended;
    @Column(name = "CODCARACTERISTICAPESSOA")
    private String codcaracteristicapessoa;
    @Column(name = "CODTIPOMOVIMENTO")
    private String codtipomovimento;
    @Column(name = "URL")
    private String url;
    @Column(name = "INTERVALO")
    private Short intervalo;
    @Column(name = "LASTUPDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastupdate;
    @Column(name = "FLAGTIPOPESSOA")
    private Character flagtipopessoa;
    @Column(name = "FLAGCONCATENAIDPRODUTO")
    private Character flagconcatenaidproduto;
    @Column(name = "DIFERENCIADORDEBASE")
    private String diferenciadordebase;
    @Column(name = "TOKEN")
    private String token;
    @Column(name = "CODPRECOMAG")
    private String codprecomag;
    @Column(name = "CODPRECOPROMMAG")
    private String codprecoprommag;
    @Column(name = "PLATAFORMA")
    private String plataforma;
    @Column(name = "CODEMPRESA")
    private Integer codempresa;
    @Column(name = "FLAGENVIARTODASCARACTERISTICAS")
    private Integer flagenviartodascaracteristicas;
    @Column(name = "USUARIO_API")
    private String usuarioApi;
    @Column(name = "SENHA_API")
    private String senhaApi;
    @Column(name = "CODCARACTERISTICAPROMO")
    private String codcaracteristicapromo;

    public WcplusConfiguracao() {
    }

    public WcplusConfiguracao(Integer codwcplus) {
        this.codwcplus = codwcplus;
    }

    public Integer getCodwcplus() {
        return codwcplus;
    }

    public void setCodwcplus(Integer codwcplus) {
        this.codwcplus = codwcplus;
    }

    public String getNomewcplus() {
        return nomewcplus;
    }

    public void setNomewcplus(String nomewcplus) {
        this.nomewcplus = nomewcplus;
    }

    public String getCodcaracteristica() {
        return codcaracteristica;
    }

    public void setCodcaracteristica(String codcaracteristica) {
        this.codcaracteristica = codcaracteristica;
    }

    public String getCodestoque() {
        return codestoque;
    }

    public void setCodestoque(String codestoque) {
        this.codestoque = codestoque;
    }

    public String getCodpreco() {
        return codpreco;
    }

    public void setCodpreco(String codpreco) {
        this.codpreco = codpreco;
    }

    public String getCodvended() {
        return codvended;
    }

    public void setCodvended(String codvended) {
        this.codvended = codvended;
    }

    public String getCodcaracteristicapessoa() {
        return codcaracteristicapessoa;
    }

    public void setCodcaracteristicapessoa(String codcaracteristicapessoa) {
        this.codcaracteristicapessoa = codcaracteristicapessoa;
    }

    public String getCodtipomovimento() {
        return codtipomovimento;
    }

    public void setCodtipomovimento(String codtipomovimento) {
        this.codtipomovimento = codtipomovimento;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Short getIntervalo() {
        return intervalo;
    }

    public void setIntervalo(Short intervalo) {
        this.intervalo = intervalo;
    }

    public Date getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(Date lastupdate) {
        this.lastupdate = lastupdate;
    }

    public Character getFlagtipopessoa() {
        return flagtipopessoa;
    }

    public void setFlagtipopessoa(Character flagtipopessoa) {
        this.flagtipopessoa = flagtipopessoa;
    }

    public Character getFlagconcatenaidproduto() {
        return flagconcatenaidproduto;
    }

    public void setFlagconcatenaidproduto(Character flagconcatenaidproduto) {
        this.flagconcatenaidproduto = flagconcatenaidproduto;
    }

    public String getDiferenciadordebase() {
        return diferenciadordebase;
    }

    public void setDiferenciadordebase(String diferenciadordebase) {
        this.diferenciadordebase = diferenciadordebase;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCodprecomag() {
        return codprecomag;
    }

    public void setCodprecomag(String codprecomag) {
        this.codprecomag = codprecomag;
    }

    public String getCodprecoprommag() {
        return codprecoprommag;
    }

    public void setCodprecoprommag(String codprecoprommag) {
        this.codprecoprommag = codprecoprommag;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public Integer getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Integer codempresa) {
        this.codempresa = codempresa;
    }

    public Integer getFlagenviartodascaracteristicas() {
        return flagenviartodascaracteristicas;
    }

    public void setFlagenviartodascaracteristicas(Integer flagenviartodascaracteristicas) {
        this.flagenviartodascaracteristicas = flagenviartodascaracteristicas;
    }

    public String getUsuarioApi() {
        return usuarioApi;
    }

    public void setUsuarioApi(String usuarioApi) {
        this.usuarioApi = usuarioApi;
    }

    public String getSenhaApi() {
        return senhaApi;
    }

    public void setSenhaApi(String senhaApi) {
        this.senhaApi = senhaApi;
    }

    public String getCodcaracteristicapromo() {
        return codcaracteristicapromo;
    }

    public void setCodcaracteristicapromo(String codcaracteristicapromo) {
        this.codcaracteristicapromo = codcaracteristicapromo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codwcplus != null ? codwcplus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WcplusConfiguracao)) {
            return false;
        }
        WcplusConfiguracao other = (WcplusConfiguracao) object;
        if ((this.codwcplus == null && other.codwcplus != null) || (this.codwcplus != null && !this.codwcplus.equals(other.codwcplus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.WcplusConfiguracao[ codwcplus=" + codwcplus + " ]";
    }
    
}
