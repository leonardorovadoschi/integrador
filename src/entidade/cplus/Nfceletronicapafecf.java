/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "NFCELETRONICAPAFECF", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nfceletronicapafecf.findAll", query = "SELECT n FROM Nfceletronicapafecf n")
    , @NamedQuery(name = "Nfceletronicapafecf.findByCodnfceletronicapafecf", query = "SELECT n FROM Nfceletronicapafecf n WHERE n.codnfceletronicapafecf = :codnfceletronicapafecf")
    , @NamedQuery(name = "Nfceletronicapafecf.findByGuid", query = "SELECT n FROM Nfceletronicapafecf n WHERE n.guid = :guid")
    , @NamedQuery(name = "Nfceletronicapafecf.findByCodempresa", query = "SELECT n FROM Nfceletronicapafecf n WHERE n.codempresa = :codempresa")
    , @NamedQuery(name = "Nfceletronicapafecf.findByNumeroserieecf", query = "SELECT n FROM Nfceletronicapafecf n WHERE n.numeroserieecf = :numeroserieecf")
    , @NamedQuery(name = "Nfceletronicapafecf.findByCoorg", query = "SELECT n FROM Nfceletronicapafecf n WHERE n.coorg = :coorg")
    , @NamedQuery(name = "Nfceletronicapafecf.findByNumerodav", query = "SELECT n FROM Nfceletronicapafecf n WHERE n.numerodav = :numerodav")
    , @NamedQuery(name = "Nfceletronicapafecf.findByData", query = "SELECT n FROM Nfceletronicapafecf n WHERE n.data = :data")
    , @NamedQuery(name = "Nfceletronicapafecf.findByValortotalnota", query = "SELECT n FROM Nfceletronicapafecf n WHERE n.valortotalnota = :valortotalnota")
    , @NamedQuery(name = "Nfceletronicapafecf.findByCodcli", query = "SELECT n FROM Nfceletronicapafecf n WHERE n.codcli = :codcli")
    , @NamedQuery(name = "Nfceletronicapafecf.findByCnpjemitente", query = "SELECT n FROM Nfceletronicapafecf n WHERE n.cnpjemitente = :cnpjemitente")
    , @NamedQuery(name = "Nfceletronicapafecf.findByNumeroserie", query = "SELECT n FROM Nfceletronicapafecf n WHERE n.numeroserie = :numeroserie")
    , @NamedQuery(name = "Nfceletronicapafecf.findBySerie", query = "SELECT n FROM Nfceletronicapafecf n WHERE n.serie = :serie")
    , @NamedQuery(name = "Nfceletronicapafecf.findByChaveacessonfceletronica", query = "SELECT n FROM Nfceletronicapafecf n WHERE n.chaveacessonfceletronica = :chaveacessonfceletronica")
    , @NamedQuery(name = "Nfceletronicapafecf.findByFlagaltpaf", query = "SELECT n FROM Nfceletronicapafecf n WHERE n.flagaltpaf = :flagaltpaf")})
public class Nfceletronicapafecf implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODNFCELETRONICAPAFECF")
    private String codnfceletronicapafecf;
    @Column(name = "GUID")
    private String guid;
    @Column(name = "CODEMPRESA")
    private Integer codempresa;
    @Column(name = "NUMEROSERIEECF")
    private String numeroserieecf;
    @Column(name = "COORG")
    private Integer coorg;
    @Column(name = "NUMERODAV")
    private Integer numerodav;
    @Column(name = "DATA")
    @Temporal(TemporalType.DATE)
    private Date data;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALORTOTALNOTA")
    private BigDecimal valortotalnota;
    @Column(name = "CODCLI")
    private String codcli;
    @Column(name = "CNPJEMITENTE")
    private String cnpjemitente;
    @Column(name = "NUMEROSERIE")
    private Integer numeroserie;
    @Column(name = "SERIE")
    private Short serie;
    @Column(name = "CHAVEACESSONFCELETRONICA")
    private String chaveacessonfceletronica;
    @Column(name = "FLAGALTPAF")
    private Character flagaltpaf;
    @JoinColumn(name = "CODNFCELETRONICA", referencedColumnName = "CODNFCELETRONICA")
    @ManyToOne
    private Nfceletronica codnfceletronica;
    @OneToMany(mappedBy = "codnfceletronicapafecf")
    private Collection<Nfceletronicapafecfprod> nfceletronicapafecfprodCollection;

    public Nfceletronicapafecf() {
    }

    public Nfceletronicapafecf(String codnfceletronicapafecf) {
        this.codnfceletronicapafecf = codnfceletronicapafecf;
    }

    public String getCodnfceletronicapafecf() {
        return codnfceletronicapafecf;
    }

    public void setCodnfceletronicapafecf(String codnfceletronicapafecf) {
        this.codnfceletronicapafecf = codnfceletronicapafecf;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Integer getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Integer codempresa) {
        this.codempresa = codempresa;
    }

    public String getNumeroserieecf() {
        return numeroserieecf;
    }

    public void setNumeroserieecf(String numeroserieecf) {
        this.numeroserieecf = numeroserieecf;
    }

    public Integer getCoorg() {
        return coorg;
    }

    public void setCoorg(Integer coorg) {
        this.coorg = coorg;
    }

    public Integer getNumerodav() {
        return numerodav;
    }

    public void setNumerodav(Integer numerodav) {
        this.numerodav = numerodav;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public BigDecimal getValortotalnota() {
        return valortotalnota;
    }

    public void setValortotalnota(BigDecimal valortotalnota) {
        this.valortotalnota = valortotalnota;
    }

    public String getCodcli() {
        return codcli;
    }

    public void setCodcli(String codcli) {
        this.codcli = codcli;
    }

    public String getCnpjemitente() {
        return cnpjemitente;
    }

    public void setCnpjemitente(String cnpjemitente) {
        this.cnpjemitente = cnpjemitente;
    }

    public Integer getNumeroserie() {
        return numeroserie;
    }

    public void setNumeroserie(Integer numeroserie) {
        this.numeroserie = numeroserie;
    }

    public Short getSerie() {
        return serie;
    }

    public void setSerie(Short serie) {
        this.serie = serie;
    }

    public String getChaveacessonfceletronica() {
        return chaveacessonfceletronica;
    }

    public void setChaveacessonfceletronica(String chaveacessonfceletronica) {
        this.chaveacessonfceletronica = chaveacessonfceletronica;
    }

    public Character getFlagaltpaf() {
        return flagaltpaf;
    }

    public void setFlagaltpaf(Character flagaltpaf) {
        this.flagaltpaf = flagaltpaf;
    }

    public Nfceletronica getCodnfceletronica() {
        return codnfceletronica;
    }

    public void setCodnfceletronica(Nfceletronica codnfceletronica) {
        this.codnfceletronica = codnfceletronica;
    }

    @XmlTransient
    public Collection<Nfceletronicapafecfprod> getNfceletronicapafecfprodCollection() {
        return nfceletronicapafecfprodCollection;
    }

    public void setNfceletronicapafecfprodCollection(Collection<Nfceletronicapafecfprod> nfceletronicapafecfprodCollection) {
        this.nfceletronicapafecfprodCollection = nfceletronicapafecfprodCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codnfceletronicapafecf != null ? codnfceletronicapafecf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nfceletronicapafecf)) {
            return false;
        }
        Nfceletronicapafecf other = (Nfceletronicapafecf) object;
        if ((this.codnfceletronicapafecf == null && other.codnfceletronicapafecf != null) || (this.codnfceletronicapafecf != null && !this.codnfceletronicapafecf.equals(other.codnfceletronicapafecf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Nfceletronicapafecf[ codnfceletronicapafecf=" + codnfceletronicapafecf + " ]";
    }
    
}
