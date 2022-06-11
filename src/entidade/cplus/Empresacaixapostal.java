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
@Table(name = "EMPRESACAIXAPOSTAL", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresacaixapostal.findAll", query = "SELECT e FROM Empresacaixapostal e")
    , @NamedQuery(name = "Empresacaixapostal.findByCodempresa", query = "SELECT e FROM Empresacaixapostal e WHERE e.codempresa = :codempresa")
    , @NamedQuery(name = "Empresacaixapostal.findByCodigocaixapostal", query = "SELECT e FROM Empresacaixapostal e WHERE e.codigocaixapostal = :codigocaixapostal")
    , @NamedQuery(name = "Empresacaixapostal.findByPastarecebimento", query = "SELECT e FROM Empresacaixapostal e WHERE e.pastarecebimento = :pastarecebimento")
    , @NamedQuery(name = "Empresacaixapostal.findByPastaenvio", query = "SELECT e FROM Empresacaixapostal e WHERE e.pastaenvio = :pastaenvio")
    , @NamedQuery(name = "Empresacaixapostal.findByCodterminalintegracao", query = "SELECT e FROM Empresacaixapostal e WHERE e.codterminalintegracao = :codterminalintegracao")
    , @NamedQuery(name = "Empresacaixapostal.findByArquivosexportacao", query = "SELECT e FROM Empresacaixapostal e WHERE e.arquivosexportacao = :arquivosexportacao")
    , @NamedQuery(name = "Empresacaixapostal.findByArquivosimportacao", query = "SELECT e FROM Empresacaixapostal e WHERE e.arquivosimportacao = :arquivosimportacao")
    , @NamedQuery(name = "Empresacaixapostal.findByNumerosequencialpacote", query = "SELECT e FROM Empresacaixapostal e WHERE e.numerosequencialpacote = :numerosequencialpacote")
    , @NamedQuery(name = "Empresacaixapostal.findByCodempresacaixapostal", query = "SELECT e FROM Empresacaixapostal e WHERE e.codempresacaixapostal = :codempresacaixapostal")})
public class Empresacaixapostal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "CODEMPRESA")
    private int codempresa;
    @Basic(optional = false)
    @Column(name = "CODIGOCAIXAPOSTAL")
    private String codigocaixapostal;
    @Column(name = "PASTARECEBIMENTO")
    private String pastarecebimento;
    @Column(name = "PASTAENVIO")
    private String pastaenvio;
    @Column(name = "CODTERMINALINTEGRACAO")
    private String codterminalintegracao;
    @Column(name = "ARQUIVOSEXPORTACAO")
    private String arquivosexportacao;
    @Column(name = "ARQUIVOSIMPORTACAO")
    private String arquivosimportacao;
    @Column(name = "NUMEROSEQUENCIALPACOTE")
    private Integer numerosequencialpacote;
    @Id
    @Basic(optional = false)
    @Column(name = "CODEMPRESACAIXAPOSTAL")
    private String codempresacaixapostal;

    public Empresacaixapostal() {
    }

    public Empresacaixapostal(String codempresacaixapostal) {
        this.codempresacaixapostal = codempresacaixapostal;
    }

    public Empresacaixapostal(String codempresacaixapostal, int codempresa, String codigocaixapostal) {
        this.codempresacaixapostal = codempresacaixapostal;
        this.codempresa = codempresa;
        this.codigocaixapostal = codigocaixapostal;
    }

    public int getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(int codempresa) {
        this.codempresa = codempresa;
    }

    public String getCodigocaixapostal() {
        return codigocaixapostal;
    }

    public void setCodigocaixapostal(String codigocaixapostal) {
        this.codigocaixapostal = codigocaixapostal;
    }

    public String getPastarecebimento() {
        return pastarecebimento;
    }

    public void setPastarecebimento(String pastarecebimento) {
        this.pastarecebimento = pastarecebimento;
    }

    public String getPastaenvio() {
        return pastaenvio;
    }

    public void setPastaenvio(String pastaenvio) {
        this.pastaenvio = pastaenvio;
    }

    public String getCodterminalintegracao() {
        return codterminalintegracao;
    }

    public void setCodterminalintegracao(String codterminalintegracao) {
        this.codterminalintegracao = codterminalintegracao;
    }

    public String getArquivosexportacao() {
        return arquivosexportacao;
    }

    public void setArquivosexportacao(String arquivosexportacao) {
        this.arquivosexportacao = arquivosexportacao;
    }

    public String getArquivosimportacao() {
        return arquivosimportacao;
    }

    public void setArquivosimportacao(String arquivosimportacao) {
        this.arquivosimportacao = arquivosimportacao;
    }

    public Integer getNumerosequencialpacote() {
        return numerosequencialpacote;
    }

    public void setNumerosequencialpacote(Integer numerosequencialpacote) {
        this.numerosequencialpacote = numerosequencialpacote;
    }

    public String getCodempresacaixapostal() {
        return codempresacaixapostal;
    }

    public void setCodempresacaixapostal(String codempresacaixapostal) {
        this.codempresacaixapostal = codempresacaixapostal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codempresacaixapostal != null ? codempresacaixapostal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresacaixapostal)) {
            return false;
        }
        Empresacaixapostal other = (Empresacaixapostal) object;
        if ((this.codempresacaixapostal == null && other.codempresacaixapostal != null) || (this.codempresacaixapostal != null && !this.codempresacaixapostal.equals(other.codempresacaixapostal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Empresacaixapostal[ codempresacaixapostal=" + codempresacaixapostal + " ]";
    }
    
}
