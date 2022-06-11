/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "CENTRORESPONSABILIDADE", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Centroresponsabilidade.findAll", query = "SELECT c FROM Centroresponsabilidade c")
    , @NamedQuery(name = "Centroresponsabilidade.findByCodcentroresponsabilidade", query = "SELECT c FROM Centroresponsabilidade c WHERE c.codcentroresponsabilidade = :codcentroresponsabilidade")
    , @NamedQuery(name = "Centroresponsabilidade.findByCodigo", query = "SELECT c FROM Centroresponsabilidade c WHERE c.codigo = :codigo")
    , @NamedQuery(name = "Centroresponsabilidade.findByCodcor", query = "SELECT c FROM Centroresponsabilidade c WHERE c.codcor = :codcor")
    , @NamedQuery(name = "Centroresponsabilidade.findByNomecentroresponsabilidade", query = "SELECT c FROM Centroresponsabilidade c WHERE c.nomecentroresponsabilidade = :nomecentroresponsabilidade")
    , @NamedQuery(name = "Centroresponsabilidade.findByFlagencerraatendimento", query = "SELECT c FROM Centroresponsabilidade c WHERE c.flagencerraatendimento = :flagencerraatendimento")
    , @NamedQuery(name = "Centroresponsabilidade.findByClassificacao", query = "SELECT c FROM Centroresponsabilidade c WHERE c.classificacao = :classificacao")
    , @NamedQuery(name = "Centroresponsabilidade.findByTipo", query = "SELECT c FROM Centroresponsabilidade c WHERE c.tipo = :tipo")})
public class Centroresponsabilidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCENTRORESPONSABILIDADE")
    private String codcentroresponsabilidade;
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "CODCOR")
    private Integer codcor;
    @Column(name = "NOMECENTRORESPONSABILIDADE")
    private String nomecentroresponsabilidade;
    @Lob
    @Column(name = "OBSERVACAO")
    private String observacao;
    @Column(name = "FLAGENCERRAATENDIMENTO")
    private Character flagencerraatendimento;
    @Column(name = "CLASSIFICACAO")
    private String classificacao;
    @Column(name = "TIPO")
    private Character tipo;
    @OneToMany(mappedBy = "codcentroresponsabilidade")
    private Collection<Workflowitem> workflowitemCollection;
    @OneToMany(mappedBy = "codcentroresponsabilidade")
    private Collection<Atendimento> atendimentoCollection;

    public Centroresponsabilidade() {
    }

    public Centroresponsabilidade(String codcentroresponsabilidade) {
        this.codcentroresponsabilidade = codcentroresponsabilidade;
    }

    public Centroresponsabilidade(String codcentroresponsabilidade, String codigo) {
        this.codcentroresponsabilidade = codcentroresponsabilidade;
        this.codigo = codigo;
    }

    public String getCodcentroresponsabilidade() {
        return codcentroresponsabilidade;
    }

    public void setCodcentroresponsabilidade(String codcentroresponsabilidade) {
        this.codcentroresponsabilidade = codcentroresponsabilidade;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getCodcor() {
        return codcor;
    }

    public void setCodcor(Integer codcor) {
        this.codcor = codcor;
    }

    public String getNomecentroresponsabilidade() {
        return nomecentroresponsabilidade;
    }

    public void setNomecentroresponsabilidade(String nomecentroresponsabilidade) {
        this.nomecentroresponsabilidade = nomecentroresponsabilidade;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Character getFlagencerraatendimento() {
        return flagencerraatendimento;
    }

    public void setFlagencerraatendimento(Character flagencerraatendimento) {
        this.flagencerraatendimento = flagencerraatendimento;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public Collection<Workflowitem> getWorkflowitemCollection() {
        return workflowitemCollection;
    }

    public void setWorkflowitemCollection(Collection<Workflowitem> workflowitemCollection) {
        this.workflowitemCollection = workflowitemCollection;
    }

    @XmlTransient
    public Collection<Atendimento> getAtendimentoCollection() {
        return atendimentoCollection;
    }

    public void setAtendimentoCollection(Collection<Atendimento> atendimentoCollection) {
        this.atendimentoCollection = atendimentoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcentroresponsabilidade != null ? codcentroresponsabilidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Centroresponsabilidade)) {
            return false;
        }
        Centroresponsabilidade other = (Centroresponsabilidade) object;
        if ((this.codcentroresponsabilidade == null && other.codcentroresponsabilidade != null) || (this.codcentroresponsabilidade != null && !this.codcentroresponsabilidade.equals(other.codcentroresponsabilidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Centroresponsabilidade[ codcentroresponsabilidade=" + codcentroresponsabilidade + " ]";
    }
    
}
