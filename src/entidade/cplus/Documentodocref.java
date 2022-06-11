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
@Table(name = "DOCUMENTODOCREF", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Documentodocref.findAll", query = "SELECT d FROM Documentodocref d")
    , @NamedQuery(name = "Documentodocref.findByCoddocumentodocref", query = "SELECT d FROM Documentodocref d WHERE d.coddocumentodocref = :coddocumentodocref")
    , @NamedQuery(name = "Documentodocref.findByCodmovenda", query = "SELECT d FROM Documentodocref d WHERE d.codmovenda = :codmovenda")
    , @NamedQuery(name = "Documentodocref.findByCodmoventr", query = "SELECT d FROM Documentodocref d WHERE d.codmoventr = :codmoventr")
    , @NamedQuery(name = "Documentodocref.findByModelonota", query = "SELECT d FROM Documentodocref d WHERE d.modelonota = :modelonota")
    , @NamedQuery(name = "Documentodocref.findByNumdoc", query = "SELECT d FROM Documentodocref d WHERE d.numdoc = :numdoc")
    , @NamedQuery(name = "Documentodocref.findBySerie", query = "SELECT d FROM Documentodocref d WHERE d.serie = :serie")
    , @NamedQuery(name = "Documentodocref.findByChaveacessonfeletronica", query = "SELECT d FROM Documentodocref d WHERE d.chaveacessonfeletronica = :chaveacessonfeletronica")
    , @NamedQuery(name = "Documentodocref.findByDataemissao", query = "SELECT d FROM Documentodocref d WHERE d.dataemissao = :dataemissao")
    , @NamedQuery(name = "Documentodocref.findByEstado", query = "SELECT d FROM Documentodocref d WHERE d.estado = :estado")
    , @NamedQuery(name = "Documentodocref.findByCnpj", query = "SELECT d FROM Documentodocref d WHERE d.cnpj = :cnpj")
    , @NamedQuery(name = "Documentodocref.findByCpf", query = "SELECT d FROM Documentodocref d WHERE d.cpf = :cpf")
    , @NamedQuery(name = "Documentodocref.findByIe", query = "SELECT d FROM Documentodocref d WHERE d.ie = :ie")
    , @NamedQuery(name = "Documentodocref.findByNomeentidadeorigem", query = "SELECT d FROM Documentodocref d WHERE d.nomeentidadeorigem = :nomeentidadeorigem")
    , @NamedQuery(name = "Documentodocref.findByIdentidadeorigem", query = "SELECT d FROM Documentodocref d WHERE d.identidadeorigem = :identidadeorigem")
    , @NamedQuery(name = "Documentodocref.findByNomeentidadeorigemref", query = "SELECT d FROM Documentodocref d WHERE d.nomeentidadeorigemref = :nomeentidadeorigemref")
    , @NamedQuery(name = "Documentodocref.findByIdentidadeorigemref", query = "SELECT d FROM Documentodocref d WHERE d.identidadeorigemref = :identidadeorigemref")})
public class Documentodocref implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODDOCUMENTODOCREF")
    private String coddocumentodocref;
    @Column(name = "CODMOVENDA")
    private String codmovenda;
    @Column(name = "CODMOVENTR")
    private String codmoventr;
    @Column(name = "MODELONOTA")
    private String modelonota;
    @Column(name = "NUMDOC")
    private Integer numdoc;
    @Column(name = "SERIE")
    private String serie;
    @Column(name = "CHAVEACESSONFELETRONICA")
    private String chaveacessonfeletronica;
    @Column(name = "DATAEMISSAO")
    @Temporal(TemporalType.DATE)
    private Date dataemissao;
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "CNPJ")
    private String cnpj;
    @Column(name = "CPF")
    private String cpf;
    @Column(name = "IE")
    private String ie;
    @Column(name = "NOMEENTIDADEORIGEM")
    private String nomeentidadeorigem;
    @Column(name = "IDENTIDADEORIGEM")
    private String identidadeorigem;
    @Column(name = "NOMEENTIDADEORIGEMREF")
    private String nomeentidadeorigemref;
    @Column(name = "IDENTIDADEORIGEMREF")
    private String identidadeorigemref;
    @JoinColumn(name = "CODDOCUMENTO", referencedColumnName = "CODDOCUMENTO")
    @ManyToOne(optional = false)
    private Documento coddocumento;

    public Documentodocref() {
    }

    public Documentodocref(String coddocumentodocref) {
        this.coddocumentodocref = coddocumentodocref;
    }

    public String getCoddocumentodocref() {
        return coddocumentodocref;
    }

    public void setCoddocumentodocref(String coddocumentodocref) {
        this.coddocumentodocref = coddocumentodocref;
    }

    public String getCodmovenda() {
        return codmovenda;
    }

    public void setCodmovenda(String codmovenda) {
        this.codmovenda = codmovenda;
    }

    public String getCodmoventr() {
        return codmoventr;
    }

    public void setCodmoventr(String codmoventr) {
        this.codmoventr = codmoventr;
    }

    public String getModelonota() {
        return modelonota;
    }

    public void setModelonota(String modelonota) {
        this.modelonota = modelonota;
    }

    public Integer getNumdoc() {
        return numdoc;
    }

    public void setNumdoc(Integer numdoc) {
        this.numdoc = numdoc;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getChaveacessonfeletronica() {
        return chaveacessonfeletronica;
    }

    public void setChaveacessonfeletronica(String chaveacessonfeletronica) {
        this.chaveacessonfeletronica = chaveacessonfeletronica;
    }

    public Date getDataemissao() {
        return dataemissao;
    }

    public void setDataemissao(Date dataemissao) {
        this.dataemissao = dataemissao;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public String getNomeentidadeorigem() {
        return nomeentidadeorigem;
    }

    public void setNomeentidadeorigem(String nomeentidadeorigem) {
        this.nomeentidadeorigem = nomeentidadeorigem;
    }

    public String getIdentidadeorigem() {
        return identidadeorigem;
    }

    public void setIdentidadeorigem(String identidadeorigem) {
        this.identidadeorigem = identidadeorigem;
    }

    public String getNomeentidadeorigemref() {
        return nomeentidadeorigemref;
    }

    public void setNomeentidadeorigemref(String nomeentidadeorigemref) {
        this.nomeentidadeorigemref = nomeentidadeorigemref;
    }

    public String getIdentidadeorigemref() {
        return identidadeorigemref;
    }

    public void setIdentidadeorigemref(String identidadeorigemref) {
        this.identidadeorigemref = identidadeorigemref;
    }

    public Documento getCoddocumento() {
        return coddocumento;
    }

    public void setCoddocumento(Documento coddocumento) {
        this.coddocumento = coddocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coddocumentodocref != null ? coddocumentodocref.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documentodocref)) {
            return false;
        }
        Documentodocref other = (Documentodocref) object;
        if ((this.coddocumentodocref == null && other.coddocumentodocref != null) || (this.coddocumentodocref != null && !this.coddocumentodocref.equals(other.coddocumentodocref))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Documentodocref[ coddocumentodocref=" + coddocumentodocref + " ]";
    }
    
}
