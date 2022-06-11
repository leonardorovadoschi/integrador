/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "HISTORICOCARTEIRA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Historicocarteira.findAll", query = "SELECT h FROM Historicocarteira h")
    , @NamedQuery(name = "Historicocarteira.findByCodhistoricocarteira", query = "SELECT h FROM Historicocarteira h WHERE h.codhistoricocarteira = :codhistoricocarteira")
    , @NamedQuery(name = "Historicocarteira.findByCoduser", query = "SELECT h FROM Historicocarteira h WHERE h.coduser = :coduser")
    , @NamedQuery(name = "Historicocarteira.findByCodusercancelamento", query = "SELECT h FROM Historicocarteira h WHERE h.codusercancelamento = :codusercancelamento")
    , @NamedQuery(name = "Historicocarteira.findByCoduseremail", query = "SELECT h FROM Historicocarteira h WHERE h.coduseremail = :coduseremail")
    , @NamedQuery(name = "Historicocarteira.findByData", query = "SELECT h FROM Historicocarteira h WHERE h.data = :data")
    , @NamedQuery(name = "Historicocarteira.findByNossonumero", query = "SELECT h FROM Historicocarteira h WHERE h.nossonumero = :nossonumero")
    , @NamedQuery(name = "Historicocarteira.findByDataimpressao", query = "SELECT h FROM Historicocarteira h WHERE h.dataimpressao = :dataimpressao")
    , @NamedQuery(name = "Historicocarteira.findByDataarquivo", query = "SELECT h FROM Historicocarteira h WHERE h.dataarquivo = :dataarquivo")
    , @NamedQuery(name = "Historicocarteira.findByDataemail", query = "SELECT h FROM Historicocarteira h WHERE h.dataemail = :dataemail")
    , @NamedQuery(name = "Historicocarteira.findByDatacancelamento", query = "SELECT h FROM Historicocarteira h WHERE h.datacancelamento = :datacancelamento")
    , @NamedQuery(name = "Historicocarteira.findByTaxa", query = "SELECT h FROM Historicocarteira h WHERE h.taxa = :taxa")
    , @NamedQuery(name = "Historicocarteira.findByFlagtipoemissaocobranca", query = "SELECT h FROM Historicocarteira h WHERE h.flagtipoemissaocobranca = :flagtipoemissaocobranca")
    , @NamedQuery(name = "Historicocarteira.findByNomearquivoremessa", query = "SELECT h FROM Historicocarteira h WHERE h.nomearquivoremessa = :nomearquivoremessa")
    , @NamedQuery(name = "Historicocarteira.findByDataconfirmacao", query = "SELECT h FROM Historicocarteira h WHERE h.dataconfirmacao = :dataconfirmacao")
    , @NamedQuery(name = "Historicocarteira.findBySequencialremessa", query = "SELECT h FROM Historicocarteira h WHERE h.sequencialremessa = :sequencialremessa")})
public class Historicocarteira implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODHISTORICOCARTEIRA")
    private String codhistoricocarteira;
    @Column(name = "CODUSER")
    private String coduser;
    @Column(name = "CODUSERCANCELAMENTO")
    private String codusercancelamento;
    @Column(name = "CODUSEREMAIL")
    private String coduseremail;
    @Column(name = "DATA")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "NOSSONUMERO")
    private BigInteger nossonumero;
    @Column(name = "DATAIMPRESSAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataimpressao;
    @Column(name = "DATAARQUIVO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataarquivo;
    @Column(name = "DATAEMAIL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataemail;
    @Column(name = "DATACANCELAMENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datacancelamento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TAXA")
    private BigDecimal taxa;
    @Column(name = "FLAGTIPOEMISSAOCOBRANCA")
    private Character flagtipoemissaocobranca;
    @Column(name = "NOMEARQUIVOREMESSA")
    private String nomearquivoremessa;
    @Column(name = "DATACONFIRMACAO")
    @Temporal(TemporalType.DATE)
    private Date dataconfirmacao;
    @Column(name = "SEQUENCIALREMESSA")
    private Integer sequencialremessa;
    @JoinColumn(name = "CODCONTABANCARIA", referencedColumnName = "CODCONTABANCARIA")
    @ManyToOne(optional = false)
    private Contabancaria codcontabancaria;
    @JoinColumn(name = "CODCR", referencedColumnName = "CODCR")
    @ManyToOne(optional = false)
    private Contareceber codcr;

    public Historicocarteira() {
    }

    public Historicocarteira(String codhistoricocarteira) {
        this.codhistoricocarteira = codhistoricocarteira;
    }

    public String getCodhistoricocarteira() {
        return codhistoricocarteira;
    }

    public void setCodhistoricocarteira(String codhistoricocarteira) {
        this.codhistoricocarteira = codhistoricocarteira;
    }

    public String getCoduser() {
        return coduser;
    }

    public void setCoduser(String coduser) {
        this.coduser = coduser;
    }

    public String getCodusercancelamento() {
        return codusercancelamento;
    }

    public void setCodusercancelamento(String codusercancelamento) {
        this.codusercancelamento = codusercancelamento;
    }

    public String getCoduseremail() {
        return coduseremail;
    }

    public void setCoduseremail(String coduseremail) {
        this.coduseremail = coduseremail;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public BigInteger getNossonumero() {
        return nossonumero;
    }

    public void setNossonumero(BigInteger nossonumero) {
        this.nossonumero = nossonumero;
    }

    public Date getDataimpressao() {
        return dataimpressao;
    }

    public void setDataimpressao(Date dataimpressao) {
        this.dataimpressao = dataimpressao;
    }

    public Date getDataarquivo() {
        return dataarquivo;
    }

    public void setDataarquivo(Date dataarquivo) {
        this.dataarquivo = dataarquivo;
    }

    public Date getDataemail() {
        return dataemail;
    }

    public void setDataemail(Date dataemail) {
        this.dataemail = dataemail;
    }

    public Date getDatacancelamento() {
        return datacancelamento;
    }

    public void setDatacancelamento(Date datacancelamento) {
        this.datacancelamento = datacancelamento;
    }

    public BigDecimal getTaxa() {
        return taxa;
    }

    public void setTaxa(BigDecimal taxa) {
        this.taxa = taxa;
    }

    public Character getFlagtipoemissaocobranca() {
        return flagtipoemissaocobranca;
    }

    public void setFlagtipoemissaocobranca(Character flagtipoemissaocobranca) {
        this.flagtipoemissaocobranca = flagtipoemissaocobranca;
    }

    public String getNomearquivoremessa() {
        return nomearquivoremessa;
    }

    public void setNomearquivoremessa(String nomearquivoremessa) {
        this.nomearquivoremessa = nomearquivoremessa;
    }

    public Date getDataconfirmacao() {
        return dataconfirmacao;
    }

    public void setDataconfirmacao(Date dataconfirmacao) {
        this.dataconfirmacao = dataconfirmacao;
    }

    public Integer getSequencialremessa() {
        return sequencialremessa;
    }

    public void setSequencialremessa(Integer sequencialremessa) {
        this.sequencialremessa = sequencialremessa;
    }

    public Contabancaria getCodcontabancaria() {
        return codcontabancaria;
    }

    public void setCodcontabancaria(Contabancaria codcontabancaria) {
        this.codcontabancaria = codcontabancaria;
    }

    public Contareceber getCodcr() {
        return codcr;
    }

    public void setCodcr(Contareceber codcr) {
        this.codcr = codcr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codhistoricocarteira != null ? codhistoricocarteira.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Historicocarteira)) {
            return false;
        }
        Historicocarteira other = (Historicocarteira) object;
        if ((this.codhistoricocarteira == null && other.codhistoricocarteira != null) || (this.codhistoricocarteira != null && !this.codhistoricocarteira.equals(other.codhistoricocarteira))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Historicocarteira[ codhistoricocarteira=" + codhistoricocarteira + " ]";
    }
    
}
