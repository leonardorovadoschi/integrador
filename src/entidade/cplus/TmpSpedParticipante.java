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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "TMP_SPED_PARTICIPANTE", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TmpSpedParticipante.findAll", query = "SELECT t FROM TmpSpedParticipante t")
    , @NamedQuery(name = "TmpSpedParticipante.findByCodtmpSpedParticipante", query = "SELECT t FROM TmpSpedParticipante t WHERE t.codtmpSpedParticipante = :codtmpSpedParticipante")
    , @NamedQuery(name = "TmpSpedParticipante.findByCodPart", query = "SELECT t FROM TmpSpedParticipante t WHERE t.codPart = :codPart")
    , @NamedQuery(name = "TmpSpedParticipante.findByNome", query = "SELECT t FROM TmpSpedParticipante t WHERE t.nome = :nome")
    , @NamedQuery(name = "TmpSpedParticipante.findByCodPais", query = "SELECT t FROM TmpSpedParticipante t WHERE t.codPais = :codPais")
    , @NamedQuery(name = "TmpSpedParticipante.findByCnpj", query = "SELECT t FROM TmpSpedParticipante t WHERE t.cnpj = :cnpj")
    , @NamedQuery(name = "TmpSpedParticipante.findByCpf", query = "SELECT t FROM TmpSpedParticipante t WHERE t.cpf = :cpf")
    , @NamedQuery(name = "TmpSpedParticipante.findByIe", query = "SELECT t FROM TmpSpedParticipante t WHERE t.ie = :ie")
    , @NamedQuery(name = "TmpSpedParticipante.findByCodMun", query = "SELECT t FROM TmpSpedParticipante t WHERE t.codMun = :codMun")
    , @NamedQuery(name = "TmpSpedParticipante.findBySuframa", query = "SELECT t FROM TmpSpedParticipante t WHERE t.suframa = :suframa")
    , @NamedQuery(name = "TmpSpedParticipante.findByLogradouro", query = "SELECT t FROM TmpSpedParticipante t WHERE t.logradouro = :logradouro")
    , @NamedQuery(name = "TmpSpedParticipante.findByNum", query = "SELECT t FROM TmpSpedParticipante t WHERE t.num = :num")
    , @NamedQuery(name = "TmpSpedParticipante.findByCompl", query = "SELECT t FROM TmpSpedParticipante t WHERE t.compl = :compl")
    , @NamedQuery(name = "TmpSpedParticipante.findByBairro", query = "SELECT t FROM TmpSpedParticipante t WHERE t.bairro = :bairro")
    , @NamedQuery(name = "TmpSpedParticipante.findByCep", query = "SELECT t FROM TmpSpedParticipante t WHERE t.cep = :cep")
    , @NamedQuery(name = "TmpSpedParticipante.findByTipoParticipante", query = "SELECT t FROM TmpSpedParticipante t WHERE t.tipoParticipante = :tipoParticipante")})
public class TmpSpedParticipante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODTMP_SPED_PARTICIPANTE")
    private Integer codtmpSpedParticipante;
    @Basic(optional = false)
    @Column(name = "COD_PART")
    private String codPart;
    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;
    @Basic(optional = false)
    @Column(name = "COD_PAIS")
    private int codPais;
    @Column(name = "CNPJ")
    private String cnpj;
    @Column(name = "CPF")
    private String cpf;
    @Column(name = "IE")
    private String ie;
    @Column(name = "COD_MUN")
    private Integer codMun;
    @Column(name = "SUFRAMA")
    private String suframa;
    @Column(name = "LOGRADOURO")
    private String logradouro;
    @Column(name = "NUM")
    private String num;
    @Column(name = "COMPL")
    private String compl;
    @Column(name = "BAIRRO")
    private String bairro;
    @Column(name = "CEP")
    private String cep;
    @Column(name = "TIPO_PARTICIPANTE")
    private Character tipoParticipante;

    public TmpSpedParticipante() {
    }

    public TmpSpedParticipante(Integer codtmpSpedParticipante) {
        this.codtmpSpedParticipante = codtmpSpedParticipante;
    }

    public TmpSpedParticipante(Integer codtmpSpedParticipante, String codPart, String nome, int codPais) {
        this.codtmpSpedParticipante = codtmpSpedParticipante;
        this.codPart = codPart;
        this.nome = nome;
        this.codPais = codPais;
    }

    public Integer getCodtmpSpedParticipante() {
        return codtmpSpedParticipante;
    }

    public void setCodtmpSpedParticipante(Integer codtmpSpedParticipante) {
        this.codtmpSpedParticipante = codtmpSpedParticipante;
    }

    public String getCodPart() {
        return codPart;
    }

    public void setCodPart(String codPart) {
        this.codPart = codPart;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodPais() {
        return codPais;
    }

    public void setCodPais(int codPais) {
        this.codPais = codPais;
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

    public Integer getCodMun() {
        return codMun;
    }

    public void setCodMun(Integer codMun) {
        this.codMun = codMun;
    }

    public String getSuframa() {
        return suframa;
    }

    public void setSuframa(String suframa) {
        this.suframa = suframa;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getCompl() {
        return compl;
    }

    public void setCompl(String compl) {
        this.compl = compl;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Character getTipoParticipante() {
        return tipoParticipante;
    }

    public void setTipoParticipante(Character tipoParticipante) {
        this.tipoParticipante = tipoParticipante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codtmpSpedParticipante != null ? codtmpSpedParticipante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TmpSpedParticipante)) {
            return false;
        }
        TmpSpedParticipante other = (TmpSpedParticipante) object;
        if ((this.codtmpSpedParticipante == null && other.codtmpSpedParticipante != null) || (this.codtmpSpedParticipante != null && !this.codtmpSpedParticipante.equals(other.codtmpSpedParticipante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.TmpSpedParticipante[ codtmpSpedParticipante=" + codtmpSpedParticipante + " ]";
    }
    
}
