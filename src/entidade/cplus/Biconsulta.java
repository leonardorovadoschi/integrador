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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "BICONSULTA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Biconsulta.findAll", query = "SELECT b FROM Biconsulta b")
    , @NamedQuery(name = "Biconsulta.findByCodbiconsulta", query = "SELECT b FROM Biconsulta b WHERE b.codbiconsulta = :codbiconsulta")
    , @NamedQuery(name = "Biconsulta.findByClassificacao", query = "SELECT b FROM Biconsulta b WHERE b.classificacao = :classificacao")
    , @NamedQuery(name = "Biconsulta.findByNomebiconsulta", query = "SELECT b FROM Biconsulta b WHERE b.nomebiconsulta = :nomebiconsulta")
    , @NamedQuery(name = "Biconsulta.findByFlagsistema", query = "SELECT b FROM Biconsulta b WHERE b.flagsistema = :flagsistema")
    , @NamedQuery(name = "Biconsulta.findByFlagtipoconsulta", query = "SELECT b FROM Biconsulta b WHERE b.flagtipoconsulta = :flagtipoconsulta")})
public class Biconsulta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODBICONSULTA")
    private String codbiconsulta;
    @Column(name = "CLASSIFICACAO")
    private String classificacao;
    @Column(name = "NOMEBICONSULTA")
    private String nomebiconsulta;
    @Column(name = "FLAGSISTEMA")
    private Character flagsistema;
    @Column(name = "FLAGTIPOCONSULTA")
    private Character flagtipoconsulta;
    @Lob
    @Column(name = "DESCRICAO")
    private String descricao;
    @Lob
    @Column(name = "CONSULTASQL")
    private String consultasql;

    public Biconsulta() {
    }

    public Biconsulta(String codbiconsulta) {
        this.codbiconsulta = codbiconsulta;
    }

    public String getCodbiconsulta() {
        return codbiconsulta;
    }

    public void setCodbiconsulta(String codbiconsulta) {
        this.codbiconsulta = codbiconsulta;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public String getNomebiconsulta() {
        return nomebiconsulta;
    }

    public void setNomebiconsulta(String nomebiconsulta) {
        this.nomebiconsulta = nomebiconsulta;
    }

    public Character getFlagsistema() {
        return flagsistema;
    }

    public void setFlagsistema(Character flagsistema) {
        this.flagsistema = flagsistema;
    }

    public Character getFlagtipoconsulta() {
        return flagtipoconsulta;
    }

    public void setFlagtipoconsulta(Character flagtipoconsulta) {
        this.flagtipoconsulta = flagtipoconsulta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getConsultasql() {
        return consultasql;
    }

    public void setConsultasql(String consultasql) {
        this.consultasql = consultasql;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codbiconsulta != null ? codbiconsulta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Biconsulta)) {
            return false;
        }
        Biconsulta other = (Biconsulta) object;
        if ((this.codbiconsulta == null && other.codbiconsulta != null) || (this.codbiconsulta != null && !this.codbiconsulta.equals(other.codbiconsulta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Biconsulta[ codbiconsulta=" + codbiconsulta + " ]";
    }
    
}
