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
@Table(name = "TMP_SPED_0150", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TmpSped0150.findAll", query = "SELECT t FROM TmpSped0150 t")
    , @NamedQuery(name = "TmpSped0150.findByCodtmpSped0150", query = "SELECT t FROM TmpSped0150 t WHERE t.codtmpSped0150 = :codtmpSped0150")
    , @NamedQuery(name = "TmpSped0150.findByCodPart", query = "SELECT t FROM TmpSped0150 t WHERE t.codPart = :codPart")
    , @NamedQuery(name = "TmpSped0150.findByNome", query = "SELECT t FROM TmpSped0150 t WHERE t.nome = :nome")
    , @NamedQuery(name = "TmpSped0150.findByCodPais", query = "SELECT t FROM TmpSped0150 t WHERE t.codPais = :codPais")
    , @NamedQuery(name = "TmpSped0150.findByCnpj", query = "SELECT t FROM TmpSped0150 t WHERE t.cnpj = :cnpj")
    , @NamedQuery(name = "TmpSped0150.findByCpf", query = "SELECT t FROM TmpSped0150 t WHERE t.cpf = :cpf")
    , @NamedQuery(name = "TmpSped0150.findByIe", query = "SELECT t FROM TmpSped0150 t WHERE t.ie = :ie")
    , @NamedQuery(name = "TmpSped0150.findByCodMun", query = "SELECT t FROM TmpSped0150 t WHERE t.codMun = :codMun")
    , @NamedQuery(name = "TmpSped0150.findBySuframa", query = "SELECT t FROM TmpSped0150 t WHERE t.suframa = :suframa")
    , @NamedQuery(name = "TmpSped0150.findByEndereco", query = "SELECT t FROM TmpSped0150 t WHERE t.endereco = :endereco")
    , @NamedQuery(name = "TmpSped0150.findByNum", query = "SELECT t FROM TmpSped0150 t WHERE t.num = :num")
    , @NamedQuery(name = "TmpSped0150.findByCompl", query = "SELECT t FROM TmpSped0150 t WHERE t.compl = :compl")
    , @NamedQuery(name = "TmpSped0150.findByBairro", query = "SELECT t FROM TmpSped0150 t WHERE t.bairro = :bairro")
    , @NamedQuery(name = "TmpSped0150.findByCep", query = "SELECT t FROM TmpSped0150 t WHERE t.cep = :cep")})
public class TmpSped0150 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODTMP_SPED_0150")
    private Integer codtmpSped0150;
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
    @Column(name = "ENDERECO")
    private String endereco;
    @Column(name = "NUM")
    private String num;
    @Column(name = "COMPL")
    private String compl;
    @Column(name = "BAIRRO")
    private String bairro;
    @Column(name = "CEP")
    private String cep;

    public TmpSped0150() {
    }

    public TmpSped0150(Integer codtmpSped0150) {
        this.codtmpSped0150 = codtmpSped0150;
    }

    public TmpSped0150(Integer codtmpSped0150, String codPart, String nome, int codPais) {
        this.codtmpSped0150 = codtmpSped0150;
        this.codPart = codPart;
        this.nome = nome;
        this.codPais = codPais;
    }

    public Integer getCodtmpSped0150() {
        return codtmpSped0150;
    }

    public void setCodtmpSped0150(Integer codtmpSped0150) {
        this.codtmpSped0150 = codtmpSped0150;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codtmpSped0150 != null ? codtmpSped0150.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TmpSped0150)) {
            return false;
        }
        TmpSped0150 other = (TmpSped0150) object;
        if ((this.codtmpSped0150 == null && other.codtmpSped0150 != null) || (this.codtmpSped0150 != null && !this.codtmpSped0150.equals(other.codtmpSped0150))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.TmpSped0150[ codtmpSped0150=" + codtmpSped0150 + " ]";
    }
    
}
