/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "ESPECIALIZACAO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Especializacao.findAll", query = "SELECT e FROM Especializacao e")
    , @NamedQuery(name = "Especializacao.findByCodespecializacao", query = "SELECT e FROM Especializacao e WHERE e.codespecializacao = :codespecializacao")
    , @NamedQuery(name = "Especializacao.findByCodigo", query = "SELECT e FROM Especializacao e WHERE e.codigo = :codigo")
    , @NamedQuery(name = "Especializacao.findByNomeespecializacao", query = "SELECT e FROM Especializacao e WHERE e.nomeespecializacao = :nomeespecializacao")
    , @NamedQuery(name = "Especializacao.findByCargahoraria", query = "SELECT e FROM Especializacao e WHERE e.cargahoraria = :cargahoraria")
    , @NamedQuery(name = "Especializacao.findByInstituicao", query = "SELECT e FROM Especializacao e WHERE e.instituicao = :instituicao")
    , @NamedQuery(name = "Especializacao.findByDataregistro", query = "SELECT e FROM Especializacao e WHERE e.dataregistro = :dataregistro")
    , @NamedQuery(name = "Especializacao.findByDataconclusao", query = "SELECT e FROM Especializacao e WHERE e.dataconclusao = :dataconclusao")})
public class Especializacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODESPECIALIZACAO")
    private String codespecializacao;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "NOMEESPECIALIZACAO")
    private String nomeespecializacao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CARGAHORARIA")
    private BigDecimal cargahoraria;
    @Column(name = "INSTITUICAO")
    private String instituicao;
    @Column(name = "DATAREGISTRO")
    @Temporal(TemporalType.DATE)
    private Date dataregistro;
    @Column(name = "DATACONCLUSAO")
    @Temporal(TemporalType.DATE)
    private Date dataconclusao;
    @Lob
    @Column(name = "OBS")
    private String obs;
    @JoinColumn(name = "CODFUNC", referencedColumnName = "CODFUNCIONARIO")
    @ManyToOne
    private Funcionario codfunc;
    @JoinColumn(name = "CODTIPOESPECIALIZACAO", referencedColumnName = "CODTIPOESPECIALIZACAO")
    @ManyToOne
    private Tipoespecializacao codtipoespecializacao;

    public Especializacao() {
    }

    public Especializacao(String codespecializacao) {
        this.codespecializacao = codespecializacao;
    }

    public String getCodespecializacao() {
        return codespecializacao;
    }

    public void setCodespecializacao(String codespecializacao) {
        this.codespecializacao = codespecializacao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomeespecializacao() {
        return nomeespecializacao;
    }

    public void setNomeespecializacao(String nomeespecializacao) {
        this.nomeespecializacao = nomeespecializacao;
    }

    public BigDecimal getCargahoraria() {
        return cargahoraria;
    }

    public void setCargahoraria(BigDecimal cargahoraria) {
        this.cargahoraria = cargahoraria;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public Date getDataregistro() {
        return dataregistro;
    }

    public void setDataregistro(Date dataregistro) {
        this.dataregistro = dataregistro;
    }

    public Date getDataconclusao() {
        return dataconclusao;
    }

    public void setDataconclusao(Date dataconclusao) {
        this.dataconclusao = dataconclusao;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Funcionario getCodfunc() {
        return codfunc;
    }

    public void setCodfunc(Funcionario codfunc) {
        this.codfunc = codfunc;
    }

    public Tipoespecializacao getCodtipoespecializacao() {
        return codtipoespecializacao;
    }

    public void setCodtipoespecializacao(Tipoespecializacao codtipoespecializacao) {
        this.codtipoespecializacao = codtipoespecializacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codespecializacao != null ? codespecializacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Especializacao)) {
            return false;
        }
        Especializacao other = (Especializacao) object;
        if ((this.codespecializacao == null && other.codespecializacao != null) || (this.codespecializacao != null && !this.codespecializacao.equals(other.codespecializacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Especializacao[ codespecializacao=" + codespecializacao + " ]";
    }
    
}
