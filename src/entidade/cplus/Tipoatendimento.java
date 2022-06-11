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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "TIPOATENDIMENTO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoatendimento.findAll", query = "SELECT t FROM Tipoatendimento t")
    , @NamedQuery(name = "Tipoatendimento.findByCodtipoatend", query = "SELECT t FROM Tipoatendimento t WHERE t.codtipoatend = :codtipoatend")
    , @NamedQuery(name = "Tipoatendimento.findByCodigo", query = "SELECT t FROM Tipoatendimento t WHERE t.codigo = :codigo")
    , @NamedQuery(name = "Tipoatendimento.findByDescricao", query = "SELECT t FROM Tipoatendimento t WHERE t.descricao = :descricao")
    , @NamedQuery(name = "Tipoatendimento.findByFlagcobraatendimento", query = "SELECT t FROM Tipoatendimento t WHERE t.flagcobraatendimento = :flagcobraatendimento")
    , @NamedQuery(name = "Tipoatendimento.findByFlagativo", query = "SELECT t FROM Tipoatendimento t WHERE t.flagativo = :flagativo")
    , @NamedQuery(name = "Tipoatendimento.findByFlagprodutoobrigatorio", query = "SELECT t FROM Tipoatendimento t WHERE t.flagprodutoobrigatorio = :flagprodutoobrigatorio")
    , @NamedQuery(name = "Tipoatendimento.findByFlagbloqueiatrocaparecer", query = "SELECT t FROM Tipoatendimento t WHERE t.flagbloqueiatrocaparecer = :flagbloqueiatrocaparecer")
    , @NamedQuery(name = "Tipoatendimento.findByCodcor", query = "SELECT t FROM Tipoatendimento t WHERE t.codcor = :codcor")
    , @NamedQuery(name = "Tipoatendimento.findByFlagpermiteconfidencial", query = "SELECT t FROM Tipoatendimento t WHERE t.flagpermiteconfidencial = :flagpermiteconfidencial")
    , @NamedQuery(name = "Tipoatendimento.findByClassificacao", query = "SELECT t FROM Tipoatendimento t WHERE t.classificacao = :classificacao")
    , @NamedQuery(name = "Tipoatendimento.findByTipo", query = "SELECT t FROM Tipoatendimento t WHERE t.tipo = :tipo")
    , @NamedQuery(name = "Tipoatendimento.findByGuid", query = "SELECT t FROM Tipoatendimento t WHERE t.guid = :guid")
    , @NamedQuery(name = "Tipoatendimento.findByFlagenviaemail", query = "SELECT t FROM Tipoatendimento t WHERE t.flagenviaemail = :flagenviaemail")})
public class Tipoatendimento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODTIPOATEND")
    private Integer codtipoatend;
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "DESCRICAO")
    private String descricao;
    @Column(name = "FLAGCOBRAATENDIMENTO")
    private Character flagcobraatendimento;
    @Column(name = "FLAGATIVO")
    private Character flagativo;
    @Column(name = "FLAGPRODUTOOBRIGATORIO")
    private Character flagprodutoobrigatorio;
    @Column(name = "FLAGBLOQUEIATROCAPARECER")
    private Character flagbloqueiatrocaparecer;
    @Column(name = "CODCOR")
    private Integer codcor;
    @Column(name = "FLAGPERMITECONFIDENCIAL")
    private Character flagpermiteconfidencial;
    @Lob
    @Column(name = "OBSERVACAO")
    private String observacao;
    @Column(name = "CLASSIFICACAO")
    private String classificacao;
    @Column(name = "TIPO")
    private Character tipo;
    @Column(name = "GUID")
    private String guid;
    @Column(name = "FLAGENVIAEMAIL")
    private Character flagenviaemail;
    @OneToMany(mappedBy = "codtipoatend")
    private Collection<Atendimento> atendimentoCollection;
    @JoinColumn(name = "CODWORKFLOW", referencedColumnName = "CODWORKFLOW")
    @ManyToOne
    private Workflow codworkflow;

    public Tipoatendimento() {
    }

    public Tipoatendimento(Integer codtipoatend) {
        this.codtipoatend = codtipoatend;
    }

    public Tipoatendimento(Integer codtipoatend, String codigo) {
        this.codtipoatend = codtipoatend;
        this.codigo = codigo;
    }

    public Integer getCodtipoatend() {
        return codtipoatend;
    }

    public void setCodtipoatend(Integer codtipoatend) {
        this.codtipoatend = codtipoatend;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Character getFlagcobraatendimento() {
        return flagcobraatendimento;
    }

    public void setFlagcobraatendimento(Character flagcobraatendimento) {
        this.flagcobraatendimento = flagcobraatendimento;
    }

    public Character getFlagativo() {
        return flagativo;
    }

    public void setFlagativo(Character flagativo) {
        this.flagativo = flagativo;
    }

    public Character getFlagprodutoobrigatorio() {
        return flagprodutoobrigatorio;
    }

    public void setFlagprodutoobrigatorio(Character flagprodutoobrigatorio) {
        this.flagprodutoobrigatorio = flagprodutoobrigatorio;
    }

    public Character getFlagbloqueiatrocaparecer() {
        return flagbloqueiatrocaparecer;
    }

    public void setFlagbloqueiatrocaparecer(Character flagbloqueiatrocaparecer) {
        this.flagbloqueiatrocaparecer = flagbloqueiatrocaparecer;
    }

    public Integer getCodcor() {
        return codcor;
    }

    public void setCodcor(Integer codcor) {
        this.codcor = codcor;
    }

    public Character getFlagpermiteconfidencial() {
        return flagpermiteconfidencial;
    }

    public void setFlagpermiteconfidencial(Character flagpermiteconfidencial) {
        this.flagpermiteconfidencial = flagpermiteconfidencial;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
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

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Character getFlagenviaemail() {
        return flagenviaemail;
    }

    public void setFlagenviaemail(Character flagenviaemail) {
        this.flagenviaemail = flagenviaemail;
    }

    @XmlTransient
    public Collection<Atendimento> getAtendimentoCollection() {
        return atendimentoCollection;
    }

    public void setAtendimentoCollection(Collection<Atendimento> atendimentoCollection) {
        this.atendimentoCollection = atendimentoCollection;
    }

    public Workflow getCodworkflow() {
        return codworkflow;
    }

    public void setCodworkflow(Workflow codworkflow) {
        this.codworkflow = codworkflow;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codtipoatend != null ? codtipoatend.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoatendimento)) {
            return false;
        }
        Tipoatendimento other = (Tipoatendimento) object;
        if ((this.codtipoatend == null && other.codtipoatend != null) || (this.codtipoatend != null && !this.codtipoatend.equals(other.codtipoatend))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Tipoatendimento[ codtipoatend=" + codtipoatend + " ]";
    }
    
}
