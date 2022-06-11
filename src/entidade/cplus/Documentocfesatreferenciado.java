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
@Table(name = "DOCUMENTOCFESATREFERENCIADO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Documentocfesatreferenciado.findAll", query = "SELECT d FROM Documentocfesatreferenciado d")
    , @NamedQuery(name = "Documentocfesatreferenciado.findByCoddocumentocfesatreferenciado", query = "SELECT d FROM Documentocfesatreferenciado d WHERE d.coddocumentocfesatreferenciado = :coddocumentocfesatreferenciado")
    , @NamedQuery(name = "Documentocfesatreferenciado.findByNomeentidadeemitente", query = "SELECT d FROM Documentocfesatreferenciado d WHERE d.nomeentidadeemitente = :nomeentidadeemitente")
    , @NamedQuery(name = "Documentocfesatreferenciado.findByIdentidadeemitente", query = "SELECT d FROM Documentocfesatreferenciado d WHERE d.identidadeemitente = :identidadeemitente")
    , @NamedQuery(name = "Documentocfesatreferenciado.findByModelodocumento", query = "SELECT d FROM Documentocfesatreferenciado d WHERE d.modelodocumento = :modelodocumento")
    , @NamedQuery(name = "Documentocfesatreferenciado.findByNumeroseriesat", query = "SELECT d FROM Documentocfesatreferenciado d WHERE d.numeroseriesat = :numeroseriesat")
    , @NamedQuery(name = "Documentocfesatreferenciado.findByChavecfe", query = "SELECT d FROM Documentocfesatreferenciado d WHERE d.chavecfe = :chavecfe")
    , @NamedQuery(name = "Documentocfesatreferenciado.findByNumerocfe", query = "SELECT d FROM Documentocfesatreferenciado d WHERE d.numerocfe = :numerocfe")
    , @NamedQuery(name = "Documentocfesatreferenciado.findByDatadocumento", query = "SELECT d FROM Documentocfesatreferenciado d WHERE d.datadocumento = :datadocumento")})
public class Documentocfesatreferenciado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODDOCUMENTOCFESATREFERENCIADO")
    private String coddocumentocfesatreferenciado;
    @Column(name = "NOMEENTIDADEEMITENTE")
    private String nomeentidadeemitente;
    @Column(name = "IDENTIDADEEMITENTE")
    private String identidadeemitente;
    @Column(name = "MODELODOCUMENTO")
    private String modelodocumento;
    @Column(name = "NUMEROSERIESAT")
    private String numeroseriesat;
    @Column(name = "CHAVECFE")
    private String chavecfe;
    @Column(name = "NUMEROCFE")
    private Integer numerocfe;
    @Column(name = "DATADOCUMENTO")
    @Temporal(TemporalType.DATE)
    private Date datadocumento;
    @JoinColumn(name = "CODDOCUMENTO", referencedColumnName = "CODDOCUMENTO")
    @ManyToOne(optional = false)
    private Documento coddocumento;

    public Documentocfesatreferenciado() {
    }

    public Documentocfesatreferenciado(String coddocumentocfesatreferenciado) {
        this.coddocumentocfesatreferenciado = coddocumentocfesatreferenciado;
    }

    public String getCoddocumentocfesatreferenciado() {
        return coddocumentocfesatreferenciado;
    }

    public void setCoddocumentocfesatreferenciado(String coddocumentocfesatreferenciado) {
        this.coddocumentocfesatreferenciado = coddocumentocfesatreferenciado;
    }

    public String getNomeentidadeemitente() {
        return nomeentidadeemitente;
    }

    public void setNomeentidadeemitente(String nomeentidadeemitente) {
        this.nomeentidadeemitente = nomeentidadeemitente;
    }

    public String getIdentidadeemitente() {
        return identidadeemitente;
    }

    public void setIdentidadeemitente(String identidadeemitente) {
        this.identidadeemitente = identidadeemitente;
    }

    public String getModelodocumento() {
        return modelodocumento;
    }

    public void setModelodocumento(String modelodocumento) {
        this.modelodocumento = modelodocumento;
    }

    public String getNumeroseriesat() {
        return numeroseriesat;
    }

    public void setNumeroseriesat(String numeroseriesat) {
        this.numeroseriesat = numeroseriesat;
    }

    public String getChavecfe() {
        return chavecfe;
    }

    public void setChavecfe(String chavecfe) {
        this.chavecfe = chavecfe;
    }

    public Integer getNumerocfe() {
        return numerocfe;
    }

    public void setNumerocfe(Integer numerocfe) {
        this.numerocfe = numerocfe;
    }

    public Date getDatadocumento() {
        return datadocumento;
    }

    public void setDatadocumento(Date datadocumento) {
        this.datadocumento = datadocumento;
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
        hash += (coddocumentocfesatreferenciado != null ? coddocumentocfesatreferenciado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documentocfesatreferenciado)) {
            return false;
        }
        Documentocfesatreferenciado other = (Documentocfesatreferenciado) object;
        if ((this.coddocumentocfesatreferenciado == null && other.coddocumentocfesatreferenciado != null) || (this.coddocumentocfesatreferenciado != null && !this.coddocumentocfesatreferenciado.equals(other.coddocumentocfesatreferenciado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Documentocfesatreferenciado[ coddocumentocfesatreferenciado=" + coddocumentocfesatreferenciado + " ]";
    }
    
}
