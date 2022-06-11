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
@Table(name = "WORKFLOW", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Workflow.findAll", query = "SELECT w FROM Workflow w")
    , @NamedQuery(name = "Workflow.findByCodworkflow", query = "SELECT w FROM Workflow w WHERE w.codworkflow = :codworkflow")
    , @NamedQuery(name = "Workflow.findByCodigo", query = "SELECT w FROM Workflow w WHERE w.codigo = :codigo")
    , @NamedQuery(name = "Workflow.findByNomeworkflow", query = "SELECT w FROM Workflow w WHERE w.nomeworkflow = :nomeworkflow")})
public class Workflow implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODWORKFLOW")
    private String codworkflow;
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "NOMEWORKFLOW")
    private String nomeworkflow;
    @OneToMany(mappedBy = "codworkflow")
    private Collection<Workflowitem> workflowitemCollection;
    @OneToMany(mappedBy = "codworkflowencadeado")
    private Collection<Workflowitem> workflowitemCollection1;
    @OneToMany(mappedBy = "codworkflow")
    private Collection<Tipoatendimento> tipoatendimentoCollection;

    public Workflow() {
    }

    public Workflow(String codworkflow) {
        this.codworkflow = codworkflow;
    }

    public Workflow(String codworkflow, String codigo) {
        this.codworkflow = codworkflow;
        this.codigo = codigo;
    }

    public String getCodworkflow() {
        return codworkflow;
    }

    public void setCodworkflow(String codworkflow) {
        this.codworkflow = codworkflow;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomeworkflow() {
        return nomeworkflow;
    }

    public void setNomeworkflow(String nomeworkflow) {
        this.nomeworkflow = nomeworkflow;
    }

    @XmlTransient
    public Collection<Workflowitem> getWorkflowitemCollection() {
        return workflowitemCollection;
    }

    public void setWorkflowitemCollection(Collection<Workflowitem> workflowitemCollection) {
        this.workflowitemCollection = workflowitemCollection;
    }

    @XmlTransient
    public Collection<Workflowitem> getWorkflowitemCollection1() {
        return workflowitemCollection1;
    }

    public void setWorkflowitemCollection1(Collection<Workflowitem> workflowitemCollection1) {
        this.workflowitemCollection1 = workflowitemCollection1;
    }

    @XmlTransient
    public Collection<Tipoatendimento> getTipoatendimentoCollection() {
        return tipoatendimentoCollection;
    }

    public void setTipoatendimentoCollection(Collection<Tipoatendimento> tipoatendimentoCollection) {
        this.tipoatendimentoCollection = tipoatendimentoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codworkflow != null ? codworkflow.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Workflow)) {
            return false;
        }
        Workflow other = (Workflow) object;
        if ((this.codworkflow == null && other.codworkflow != null) || (this.codworkflow != null && !this.codworkflow.equals(other.codworkflow))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Workflow[ codworkflow=" + codworkflow + " ]";
    }
    
}
