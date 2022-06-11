/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "PROMOCAO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Promocao.findAll", query = "SELECT p FROM Promocao p")
    , @NamedQuery(name = "Promocao.findByCodpromocao", query = "SELECT p FROM Promocao p WHERE p.codpromocao = :codpromocao")
    , @NamedQuery(name = "Promocao.findByDataini", query = "SELECT p FROM Promocao p WHERE p.dataini = :dataini")
    , @NamedQuery(name = "Promocao.findByDatafin", query = "SELECT p FROM Promocao p WHERE p.datafin = :datafin")
    , @NamedQuery(name = "Promocao.findByNomepromocao", query = "SELECT p FROM Promocao p WHERE p.nomepromocao = :nomepromocao")})
public class Promocao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODPROMOCAO")
    private String codpromocao;
    @Column(name = "DATAINI")
    @Temporal(TemporalType.DATE)
    private Date dataini;
    @Column(name = "DATAFIN")
    @Temporal(TemporalType.DATE)
    private Date datafin;
    @Column(name = "NOMEPROMOCAO")
    private String nomepromocao;
    @OneToMany(mappedBy = "codpromocao")
    private Collection<Promocaoproduto> promocaoprodutoCollection;
    @JoinColumn(name = "CODFP", referencedColumnName = "CODFP")
    @ManyToOne
    private Formapag codfp;

    public Promocao() {
    }

    public Promocao(String codpromocao) {
        this.codpromocao = codpromocao;
    }

    public String getCodpromocao() {
        return codpromocao;
    }

    public void setCodpromocao(String codpromocao) {
        this.codpromocao = codpromocao;
    }

    public Date getDataini() {
        return dataini;
    }

    public void setDataini(Date dataini) {
        this.dataini = dataini;
    }

    public Date getDatafin() {
        return datafin;
    }

    public void setDatafin(Date datafin) {
        this.datafin = datafin;
    }

    public String getNomepromocao() {
        return nomepromocao;
    }

    public void setNomepromocao(String nomepromocao) {
        this.nomepromocao = nomepromocao;
    }

    @XmlTransient
    public Collection<Promocaoproduto> getPromocaoprodutoCollection() {
        return promocaoprodutoCollection;
    }

    public void setPromocaoprodutoCollection(Collection<Promocaoproduto> promocaoprodutoCollection) {
        this.promocaoprodutoCollection = promocaoprodutoCollection;
    }

    public Formapag getCodfp() {
        return codfp;
    }

    public void setCodfp(Formapag codfp) {
        this.codfp = codfp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codpromocao != null ? codpromocao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Promocao)) {
            return false;
        }
        Promocao other = (Promocao) object;
        if ((this.codpromocao == null && other.codpromocao != null) || (this.codpromocao != null && !this.codpromocao.equals(other.codpromocao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Promocao[ codpromocao=" + codpromocao + " ]";
    }
    
}
