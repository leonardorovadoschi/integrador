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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "LAYOUTPRODUTOITEM", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Layoutprodutoitem.findAll", query = "SELECT l FROM Layoutprodutoitem l")
    , @NamedQuery(name = "Layoutprodutoitem.findByCodlayoutitem", query = "SELECT l FROM Layoutprodutoitem l WHERE l.codlayoutitem = :codlayoutitem")
    , @NamedQuery(name = "Layoutprodutoitem.findByPosini", query = "SELECT l FROM Layoutprodutoitem l WHERE l.posini = :posini")
    , @NamedQuery(name = "Layoutprodutoitem.findByPosfin", query = "SELECT l FROM Layoutprodutoitem l WHERE l.posfin = :posfin")
    , @NamedQuery(name = "Layoutprodutoitem.findByFlagcompletacom", query = "SELECT l FROM Layoutprodutoitem l WHERE l.flagcompletacom = :flagcompletacom")
    , @NamedQuery(name = "Layoutprodutoitem.findByCasasdecimais", query = "SELECT l FROM Layoutprodutoitem l WHERE l.casasdecimais = :casasdecimais")
    , @NamedQuery(name = "Layoutprodutoitem.findBySeparadordecimal", query = "SELECT l FROM Layoutprodutoitem l WHERE l.separadordecimal = :separadordecimal")})
public class Layoutprodutoitem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODLAYOUTITEM")
    private String codlayoutitem;
    @Basic(optional = false)
    @Column(name = "POSINI")
    private int posini;
    @Basic(optional = false)
    @Column(name = "POSFIN")
    private int posfin;
    @Column(name = "FLAGCOMPLETACOM")
    private Character flagcompletacom;
    @Column(name = "CASASDECIMAIS")
    private Integer casasdecimais;
    @Column(name = "SEPARADORDECIMAL")
    private Character separadordecimal;
    @JoinColumn(name = "CODLAYOUTPRODUTO", referencedColumnName = "CODLAYOUTPRODUTO")
    @ManyToOne
    private Layoutproduto codlayoutproduto;
    @JoinColumn(name = "CODLAYOUTPRODUTOVARIAVEL", referencedColumnName = "CODLAYOUTPRODUTOVARIAVEL")
    @ManyToOne
    private Layoutprodutovariavel codlayoutprodutovariavel;

    public Layoutprodutoitem() {
    }

    public Layoutprodutoitem(String codlayoutitem) {
        this.codlayoutitem = codlayoutitem;
    }

    public Layoutprodutoitem(String codlayoutitem, int posini, int posfin) {
        this.codlayoutitem = codlayoutitem;
        this.posini = posini;
        this.posfin = posfin;
    }

    public String getCodlayoutitem() {
        return codlayoutitem;
    }

    public void setCodlayoutitem(String codlayoutitem) {
        this.codlayoutitem = codlayoutitem;
    }

    public int getPosini() {
        return posini;
    }

    public void setPosini(int posini) {
        this.posini = posini;
    }

    public int getPosfin() {
        return posfin;
    }

    public void setPosfin(int posfin) {
        this.posfin = posfin;
    }

    public Character getFlagcompletacom() {
        return flagcompletacom;
    }

    public void setFlagcompletacom(Character flagcompletacom) {
        this.flagcompletacom = flagcompletacom;
    }

    public Integer getCasasdecimais() {
        return casasdecimais;
    }

    public void setCasasdecimais(Integer casasdecimais) {
        this.casasdecimais = casasdecimais;
    }

    public Character getSeparadordecimal() {
        return separadordecimal;
    }

    public void setSeparadordecimal(Character separadordecimal) {
        this.separadordecimal = separadordecimal;
    }

    public Layoutproduto getCodlayoutproduto() {
        return codlayoutproduto;
    }

    public void setCodlayoutproduto(Layoutproduto codlayoutproduto) {
        this.codlayoutproduto = codlayoutproduto;
    }

    public Layoutprodutovariavel getCodlayoutprodutovariavel() {
        return codlayoutprodutovariavel;
    }

    public void setCodlayoutprodutovariavel(Layoutprodutovariavel codlayoutprodutovariavel) {
        this.codlayoutprodutovariavel = codlayoutprodutovariavel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codlayoutitem != null ? codlayoutitem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Layoutprodutoitem)) {
            return false;
        }
        Layoutprodutoitem other = (Layoutprodutoitem) object;
        if ((this.codlayoutitem == null && other.codlayoutitem != null) || (this.codlayoutitem != null && !this.codlayoutitem.equals(other.codlayoutitem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Layoutprodutoitem[ codlayoutitem=" + codlayoutitem + " ]";
    }
    
}
