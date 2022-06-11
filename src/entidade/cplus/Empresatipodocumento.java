/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "EMPRESATIPODOCUMENTO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresatipodocumento.findAll", query = "SELECT e FROM Empresatipodocumento e")
    , @NamedQuery(name = "Empresatipodocumento.findByCodempresatipodocumento", query = "SELECT e FROM Empresatipodocumento e WHERE e.codempresatipodocumento = :codempresatipodocumento")
    , @NamedQuery(name = "Empresatipodocumento.findByModelodocumento", query = "SELECT e FROM Empresatipodocumento e WHERE e.modelodocumento = :modelodocumento")
    , @NamedQuery(name = "Empresatipodocumento.findBySeriedocumento", query = "SELECT e FROM Empresatipodocumento e WHERE e.seriedocumento = :seriedocumento")
    , @NamedQuery(name = "Empresatipodocumento.findByNumerodocumento", query = "SELECT e FROM Empresatipodocumento e WHERE e.numerodocumento = :numerodocumento")
    , @NamedQuery(name = "Empresatipodocumento.findByFlagimprimeservicoseparado", query = "SELECT e FROM Empresatipodocumento e WHERE e.flagimprimeservicoseparado = :flagimprimeservicoseparado")
    , @NamedQuery(name = "Empresatipodocumento.findByFlagdiscriminacomposicao", query = "SELECT e FROM Empresatipodocumento e WHERE e.flagdiscriminacomposicao = :flagdiscriminacomposicao")
    , @NamedQuery(name = "Empresatipodocumento.findByImpressorapadrao", query = "SELECT e FROM Empresatipodocumento e WHERE e.impressorapadrao = :impressorapadrao")
    , @NamedQuery(name = "Empresatipodocumento.findByIdlayoutdocumento", query = "SELECT e FROM Empresatipodocumento e WHERE e.idlayoutdocumento = :idlayoutdocumento")
    , @NamedQuery(name = "Empresatipodocumento.findByIdlayoutdanfe", query = "SELECT e FROM Empresatipodocumento e WHERE e.idlayoutdanfe = :idlayoutdanfe")
    , @NamedQuery(name = "Empresatipodocumento.findByIdlayoutrps", query = "SELECT e FROM Empresatipodocumento e WHERE e.idlayoutrps = :idlayoutrps")
    , @NamedQuery(name = "Empresatipodocumento.findByIdlayoutnfse", query = "SELECT e FROM Empresatipodocumento e WHERE e.idlayoutnfse = :idlayoutnfse")
    , @NamedQuery(name = "Empresatipodocumento.findByFlagnotafiscal", query = "SELECT e FROM Empresatipodocumento e WHERE e.flagnotafiscal = :flagnotafiscal")
    , @NamedQuery(name = "Empresatipodocumento.findByTitulonfse", query = "SELECT e FROM Empresatipodocumento e WHERE e.titulonfse = :titulonfse")
    , @NamedQuery(name = "Empresatipodocumento.findBySubtitulonfse", query = "SELECT e FROM Empresatipodocumento e WHERE e.subtitulonfse = :subtitulonfse")
    , @NamedQuery(name = "Empresatipodocumento.findBySubtitulorps", query = "SELECT e FROM Empresatipodocumento e WHERE e.subtitulorps = :subtitulorps")
    , @NamedQuery(name = "Empresatipodocumento.findBySecretariaresponsavel", query = "SELECT e FROM Empresatipodocumento e WHERE e.secretariaresponsavel = :secretariaresponsavel")
    , @NamedQuery(name = "Empresatipodocumento.findByFlagmodelonfsecomponente", query = "SELECT e FROM Empresatipodocumento e WHERE e.flagmodelonfsecomponente = :flagmodelonfsecomponente")
    , @NamedQuery(name = "Empresatipodocumento.findByFlagadicionaufcidade", query = "SELECT e FROM Empresatipodocumento e WHERE e.flagadicionaufcidade = :flagadicionaufcidade")
    , @NamedQuery(name = "Empresatipodocumento.findByFlagpermitirsaltonum", query = "SELECT e FROM Empresatipodocumento e WHERE e.flagpermitirsaltonum = :flagpermitirsaltonum")})
public class Empresatipodocumento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODEMPRESATIPODOCUMENTO")
    private String codempresatipodocumento;
    @Column(name = "MODELODOCUMENTO")
    private String modelodocumento;
    @Basic(optional = false)
    @Column(name = "SERIEDOCUMENTO")
    private String seriedocumento;
    @Basic(optional = false)
    @Column(name = "NUMERODOCUMENTO")
    private int numerodocumento;
    @Column(name = "FLAGIMPRIMESERVICOSEPARADO")
    private Character flagimprimeservicoseparado;
    @Column(name = "FLAGDISCRIMINACOMPOSICAO")
    private Character flagdiscriminacomposicao;
    @Column(name = "IMPRESSORAPADRAO")
    private String impressorapadrao;
    @Column(name = "IDLAYOUTDOCUMENTO")
    private String idlayoutdocumento;
    @Column(name = "IDLAYOUTDANFE")
    private String idlayoutdanfe;
    @Column(name = "IDLAYOUTRPS")
    private String idlayoutrps;
    @Column(name = "IDLAYOUTNFSE")
    private String idlayoutnfse;
    @Lob
    @Column(name = "INFORMACOESCOMPLEMENTARES")
    private String informacoescomplementares;
    @Column(name = "FLAGNOTAFISCAL")
    private Character flagnotafiscal;
    @Column(name = "TITULONFSE")
    private String titulonfse;
    @Column(name = "SUBTITULONFSE")
    private String subtitulonfse;
    @Column(name = "SUBTITULORPS")
    private String subtitulorps;
    @Column(name = "SECRETARIARESPONSAVEL")
    private String secretariaresponsavel;
    @Column(name = "FLAGMODELONFSECOMPONENTE")
    private Character flagmodelonfsecomponente;
    @Column(name = "FLAGADICIONAUFCIDADE")
    private Character flagadicionaufcidade;
    @Column(name = "FLAGPERMITIRSALTONUM")
    private Character flagpermitirsaltonum;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codempresatipodocumento")
    private Collection<Empresatipodocumentocampo> empresatipodocumentocampoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codempresatipodocumento")
    private Collection<Empresatipodocumentocf> empresatipodocumentocfCollection;
    @JoinColumn(name = "CODEMPRESA", referencedColumnName = "CODEMPRESA")
    @ManyToOne(optional = false)
    private Empresa codempresa;
    @JoinColumn(name = "CODTIPODOCUMENTO", referencedColumnName = "CODTIPODOCUMENTO")
    @ManyToOne
    private Tipodocumento codtipodocumento;
    @OneToMany(mappedBy = "codempresatipodocumento")
    private Collection<Mdfeletronico> mdfeletronicoCollection;

    public Empresatipodocumento() {
    }

    public Empresatipodocumento(String codempresatipodocumento) {
        this.codempresatipodocumento = codempresatipodocumento;
    }

    public Empresatipodocumento(String codempresatipodocumento, String seriedocumento, int numerodocumento) {
        this.codempresatipodocumento = codempresatipodocumento;
        this.seriedocumento = seriedocumento;
        this.numerodocumento = numerodocumento;
    }

    public String getCodempresatipodocumento() {
        return codempresatipodocumento;
    }

    public void setCodempresatipodocumento(String codempresatipodocumento) {
        this.codempresatipodocumento = codempresatipodocumento;
    }

    public String getModelodocumento() {
        return modelodocumento;
    }

    public void setModelodocumento(String modelodocumento) {
        this.modelodocumento = modelodocumento;
    }

    public String getSeriedocumento() {
        return seriedocumento;
    }

    public void setSeriedocumento(String seriedocumento) {
        this.seriedocumento = seriedocumento;
    }

    public int getNumerodocumento() {
        return numerodocumento;
    }

    public void setNumerodocumento(int numerodocumento) {
        this.numerodocumento = numerodocumento;
    }

    public Character getFlagimprimeservicoseparado() {
        return flagimprimeservicoseparado;
    }

    public void setFlagimprimeservicoseparado(Character flagimprimeservicoseparado) {
        this.flagimprimeservicoseparado = flagimprimeservicoseparado;
    }

    public Character getFlagdiscriminacomposicao() {
        return flagdiscriminacomposicao;
    }

    public void setFlagdiscriminacomposicao(Character flagdiscriminacomposicao) {
        this.flagdiscriminacomposicao = flagdiscriminacomposicao;
    }

    public String getImpressorapadrao() {
        return impressorapadrao;
    }

    public void setImpressorapadrao(String impressorapadrao) {
        this.impressorapadrao = impressorapadrao;
    }

    public String getIdlayoutdocumento() {
        return idlayoutdocumento;
    }

    public void setIdlayoutdocumento(String idlayoutdocumento) {
        this.idlayoutdocumento = idlayoutdocumento;
    }

    public String getIdlayoutdanfe() {
        return idlayoutdanfe;
    }

    public void setIdlayoutdanfe(String idlayoutdanfe) {
        this.idlayoutdanfe = idlayoutdanfe;
    }

    public String getIdlayoutrps() {
        return idlayoutrps;
    }

    public void setIdlayoutrps(String idlayoutrps) {
        this.idlayoutrps = idlayoutrps;
    }

    public String getIdlayoutnfse() {
        return idlayoutnfse;
    }

    public void setIdlayoutnfse(String idlayoutnfse) {
        this.idlayoutnfse = idlayoutnfse;
    }

    public String getInformacoescomplementares() {
        return informacoescomplementares;
    }

    public void setInformacoescomplementares(String informacoescomplementares) {
        this.informacoescomplementares = informacoescomplementares;
    }

    public Character getFlagnotafiscal() {
        return flagnotafiscal;
    }

    public void setFlagnotafiscal(Character flagnotafiscal) {
        this.flagnotafiscal = flagnotafiscal;
    }

    public String getTitulonfse() {
        return titulonfse;
    }

    public void setTitulonfse(String titulonfse) {
        this.titulonfse = titulonfse;
    }

    public String getSubtitulonfse() {
        return subtitulonfse;
    }

    public void setSubtitulonfse(String subtitulonfse) {
        this.subtitulonfse = subtitulonfse;
    }

    public String getSubtitulorps() {
        return subtitulorps;
    }

    public void setSubtitulorps(String subtitulorps) {
        this.subtitulorps = subtitulorps;
    }

    public String getSecretariaresponsavel() {
        return secretariaresponsavel;
    }

    public void setSecretariaresponsavel(String secretariaresponsavel) {
        this.secretariaresponsavel = secretariaresponsavel;
    }

    public Character getFlagmodelonfsecomponente() {
        return flagmodelonfsecomponente;
    }

    public void setFlagmodelonfsecomponente(Character flagmodelonfsecomponente) {
        this.flagmodelonfsecomponente = flagmodelonfsecomponente;
    }

    public Character getFlagadicionaufcidade() {
        return flagadicionaufcidade;
    }

    public void setFlagadicionaufcidade(Character flagadicionaufcidade) {
        this.flagadicionaufcidade = flagadicionaufcidade;
    }

    public Character getFlagpermitirsaltonum() {
        return flagpermitirsaltonum;
    }

    public void setFlagpermitirsaltonum(Character flagpermitirsaltonum) {
        this.flagpermitirsaltonum = flagpermitirsaltonum;
    }

    @XmlTransient
    public Collection<Empresatipodocumentocampo> getEmpresatipodocumentocampoCollection() {
        return empresatipodocumentocampoCollection;
    }

    public void setEmpresatipodocumentocampoCollection(Collection<Empresatipodocumentocampo> empresatipodocumentocampoCollection) {
        this.empresatipodocumentocampoCollection = empresatipodocumentocampoCollection;
    }

    @XmlTransient
    public Collection<Empresatipodocumentocf> getEmpresatipodocumentocfCollection() {
        return empresatipodocumentocfCollection;
    }

    public void setEmpresatipodocumentocfCollection(Collection<Empresatipodocumentocf> empresatipodocumentocfCollection) {
        this.empresatipodocumentocfCollection = empresatipodocumentocfCollection;
    }

    public Empresa getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Empresa codempresa) {
        this.codempresa = codempresa;
    }

    public Tipodocumento getCodtipodocumento() {
        return codtipodocumento;
    }

    public void setCodtipodocumento(Tipodocumento codtipodocumento) {
        this.codtipodocumento = codtipodocumento;
    }

    @XmlTransient
    public Collection<Mdfeletronico> getMdfeletronicoCollection() {
        return mdfeletronicoCollection;
    }

    public void setMdfeletronicoCollection(Collection<Mdfeletronico> mdfeletronicoCollection) {
        this.mdfeletronicoCollection = mdfeletronicoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codempresatipodocumento != null ? codempresatipodocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresatipodocumento)) {
            return false;
        }
        Empresatipodocumento other = (Empresatipodocumento) object;
        if ((this.codempresatipodocumento == null && other.codempresatipodocumento != null) || (this.codempresatipodocumento != null && !this.codempresatipodocumento.equals(other.codempresatipodocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Empresatipodocumento[ codempresatipodocumento=" + codempresatipodocumento + " ]";
    }
    
}
