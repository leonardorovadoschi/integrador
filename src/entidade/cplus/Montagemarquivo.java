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
@Table(name = "MONTAGEMARQUIVO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Montagemarquivo.findAll", query = "SELECT m FROM Montagemarquivo m")
    , @NamedQuery(name = "Montagemarquivo.findByCodmontagemarquivo", query = "SELECT m FROM Montagemarquivo m WHERE m.codmontagemarquivo = :codmontagemarquivo")
    , @NamedQuery(name = "Montagemarquivo.findByCodigo", query = "SELECT m FROM Montagemarquivo m WHERE m.codigo = :codigo")
    , @NamedQuery(name = "Montagemarquivo.findByFormatodata", query = "SELECT m FROM Montagemarquivo m WHERE m.formatodata = :formatodata")
    , @NamedQuery(name = "Montagemarquivo.findByMascaranomearquivo", query = "SELECT m FROM Montagemarquivo m WHERE m.mascaranomearquivo = :mascaranomearquivo")
    , @NamedQuery(name = "Montagemarquivo.findByNomemontagemarquivo", query = "SELECT m FROM Montagemarquivo m WHERE m.nomemontagemarquivo = :nomemontagemarquivo")
    , @NamedQuery(name = "Montagemarquivo.findByNomearquivo", query = "SELECT m FROM Montagemarquivo m WHERE m.nomearquivo = :nomearquivo")
    , @NamedQuery(name = "Montagemarquivo.findByFlagretiraquebralinha", query = "SELECT m FROM Montagemarquivo m WHERE m.flagretiraquebralinha = :flagretiraquebralinha")
    , @NamedQuery(name = "Montagemarquivo.findByFlagtipoarquivo", query = "SELECT m FROM Montagemarquivo m WHERE m.flagtipoarquivo = :flagtipoarquivo")
    , @NamedQuery(name = "Montagemarquivo.findByFlagfinalidade", query = "SELECT m FROM Montagemarquivo m WHERE m.flagfinalidade = :flagfinalidade")
    , @NamedQuery(name = "Montagemarquivo.findByFlagvalorutilizado", query = "SELECT m FROM Montagemarquivo m WHERE m.flagvalorutilizado = :flagvalorutilizado")
    , @NamedQuery(name = "Montagemarquivo.findByDiretorioarquivo", query = "SELECT m FROM Montagemarquivo m WHERE m.diretorioarquivo = :diretorioarquivo")})
public class Montagemarquivo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODMONTAGEMARQUIVO")
    private String codmontagemarquivo;
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "FORMATODATA")
    private String formatodata;
    @Column(name = "MASCARANOMEARQUIVO")
    private String mascaranomearquivo;
    @Column(name = "NOMEMONTAGEMARQUIVO")
    private String nomemontagemarquivo;
    @Column(name = "NOMEARQUIVO")
    private String nomearquivo;
    @Column(name = "FLAGRETIRAQUEBRALINHA")
    private Character flagretiraquebralinha;
    @Column(name = "FLAGTIPOARQUIVO")
    private String flagtipoarquivo;
    @Column(name = "FLAGFINALIDADE")
    private String flagfinalidade;
    @Column(name = "FLAGVALORUTILIZADO")
    private Character flagvalorutilizado;
    @Column(name = "DIRETORIOARQUIVO")
    private String diretorioarquivo;
    @JoinColumn(name = "CODBANCO", referencedColumnName = "CODBANCO")
    @ManyToOne
    private Banco codbanco;
    @OneToMany(mappedBy = "codmontagemarquivo")
    private Collection<Montagemarquivoitem> montagemarquivoitemCollection;

    public Montagemarquivo() {
    }

    public Montagemarquivo(String codmontagemarquivo) {
        this.codmontagemarquivo = codmontagemarquivo;
    }

    public Montagemarquivo(String codmontagemarquivo, String codigo) {
        this.codmontagemarquivo = codmontagemarquivo;
        this.codigo = codigo;
    }

    public String getCodmontagemarquivo() {
        return codmontagemarquivo;
    }

    public void setCodmontagemarquivo(String codmontagemarquivo) {
        this.codmontagemarquivo = codmontagemarquivo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFormatodata() {
        return formatodata;
    }

    public void setFormatodata(String formatodata) {
        this.formatodata = formatodata;
    }

    public String getMascaranomearquivo() {
        return mascaranomearquivo;
    }

    public void setMascaranomearquivo(String mascaranomearquivo) {
        this.mascaranomearquivo = mascaranomearquivo;
    }

    public String getNomemontagemarquivo() {
        return nomemontagemarquivo;
    }

    public void setNomemontagemarquivo(String nomemontagemarquivo) {
        this.nomemontagemarquivo = nomemontagemarquivo;
    }

    public String getNomearquivo() {
        return nomearquivo;
    }

    public void setNomearquivo(String nomearquivo) {
        this.nomearquivo = nomearquivo;
    }

    public Character getFlagretiraquebralinha() {
        return flagretiraquebralinha;
    }

    public void setFlagretiraquebralinha(Character flagretiraquebralinha) {
        this.flagretiraquebralinha = flagretiraquebralinha;
    }

    public String getFlagtipoarquivo() {
        return flagtipoarquivo;
    }

    public void setFlagtipoarquivo(String flagtipoarquivo) {
        this.flagtipoarquivo = flagtipoarquivo;
    }

    public String getFlagfinalidade() {
        return flagfinalidade;
    }

    public void setFlagfinalidade(String flagfinalidade) {
        this.flagfinalidade = flagfinalidade;
    }

    public Character getFlagvalorutilizado() {
        return flagvalorutilizado;
    }

    public void setFlagvalorutilizado(Character flagvalorutilizado) {
        this.flagvalorutilizado = flagvalorutilizado;
    }

    public String getDiretorioarquivo() {
        return diretorioarquivo;
    }

    public void setDiretorioarquivo(String diretorioarquivo) {
        this.diretorioarquivo = diretorioarquivo;
    }

    public Banco getCodbanco() {
        return codbanco;
    }

    public void setCodbanco(Banco codbanco) {
        this.codbanco = codbanco;
    }

    @XmlTransient
    public Collection<Montagemarquivoitem> getMontagemarquivoitemCollection() {
        return montagemarquivoitemCollection;
    }

    public void setMontagemarquivoitemCollection(Collection<Montagemarquivoitem> montagemarquivoitemCollection) {
        this.montagemarquivoitemCollection = montagemarquivoitemCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmontagemarquivo != null ? codmontagemarquivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Montagemarquivo)) {
            return false;
        }
        Montagemarquivo other = (Montagemarquivo) object;
        if ((this.codmontagemarquivo == null && other.codmontagemarquivo != null) || (this.codmontagemarquivo != null && !this.codmontagemarquivo.equals(other.codmontagemarquivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Montagemarquivo[ codmontagemarquivo=" + codmontagemarquivo + " ]";
    }
    
}
