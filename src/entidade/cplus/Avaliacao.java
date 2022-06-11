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
@Table(name = "AVALIACAO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Avaliacao.findAll", query = "SELECT a FROM Avaliacao a")
    , @NamedQuery(name = "Avaliacao.findByCodavaliacao", query = "SELECT a FROM Avaliacao a WHERE a.codavaliacao = :codavaliacao")
    , @NamedQuery(name = "Avaliacao.findByCodigo", query = "SELECT a FROM Avaliacao a WHERE a.codigo = :codigo")
    , @NamedQuery(name = "Avaliacao.findByNota", query = "SELECT a FROM Avaliacao a WHERE a.nota = :nota")
    , @NamedQuery(name = "Avaliacao.findByDataavaliacao", query = "SELECT a FROM Avaliacao a WHERE a.dataavaliacao = :dataavaliacao")})
public class Avaliacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODAVALIACAO")
    private String codavaliacao;
    @Column(name = "CODIGO")
    private String codigo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "NOTA")
    private BigDecimal nota;
    @Column(name = "DATAAVALIACAO")
    @Temporal(TemporalType.DATE)
    private Date dataavaliacao;
    @Lob
    @Column(name = "OBS")
    private String obs;
    @JoinColumn(name = "CODFUNC", referencedColumnName = "CODFUNCIONARIO")
    @ManyToOne
    private Funcionario codfunc;
    @JoinColumn(name = "CODTIPOAVALIACAO", referencedColumnName = "CODTIPOAVALIACAO")
    @ManyToOne
    private Tipoavaliacao codtipoavaliacao;

    public Avaliacao() {
    }

    public Avaliacao(String codavaliacao) {
        this.codavaliacao = codavaliacao;
    }

    public String getCodavaliacao() {
        return codavaliacao;
    }

    public void setCodavaliacao(String codavaliacao) {
        this.codavaliacao = codavaliacao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getNota() {
        return nota;
    }

    public void setNota(BigDecimal nota) {
        this.nota = nota;
    }

    public Date getDataavaliacao() {
        return dataavaliacao;
    }

    public void setDataavaliacao(Date dataavaliacao) {
        this.dataavaliacao = dataavaliacao;
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

    public Tipoavaliacao getCodtipoavaliacao() {
        return codtipoavaliacao;
    }

    public void setCodtipoavaliacao(Tipoavaliacao codtipoavaliacao) {
        this.codtipoavaliacao = codtipoavaliacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codavaliacao != null ? codavaliacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Avaliacao)) {
            return false;
        }
        Avaliacao other = (Avaliacao) object;
        if ((this.codavaliacao == null && other.codavaliacao != null) || (this.codavaliacao != null && !this.codavaliacao.equals(other.codavaliacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Avaliacao[ codavaliacao=" + codavaliacao + " ]";
    }
    
}
