/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade.prestaShop;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo-note
 */
@Entity
@Table(name = "ps_an_productextratabs_labels_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnProductextratabsLabelsLang.findAll", query = "SELECT p FROM PsAnProductextratabsLabelsLang p")})
public class PsAnProductextratabsLabelsLang implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsAnProductextratabsLabelsLangPK psAnProductextratabsLabelsLangPK;
    @Basic(optional = false)
    @Column(name = "label")
    private String label;

    public PsAnProductextratabsLabelsLang() {
    }

    public PsAnProductextratabsLabelsLang(PsAnProductextratabsLabelsLangPK psAnProductextratabsLabelsLangPK) {
        this.psAnProductextratabsLabelsLangPK = psAnProductextratabsLabelsLangPK;
    }

    public PsAnProductextratabsLabelsLang(PsAnProductextratabsLabelsLangPK psAnProductextratabsLabelsLangPK, String label) {
        this.psAnProductextratabsLabelsLangPK = psAnProductextratabsLabelsLangPK;
        this.label = label;
    }

    public PsAnProductextratabsLabelsLang(int idLabel, String idLang) {
        this.psAnProductextratabsLabelsLangPK = new PsAnProductextratabsLabelsLangPK(idLabel, idLang);
    }

    public PsAnProductextratabsLabelsLangPK getPsAnProductextratabsLabelsLangPK() {
        return psAnProductextratabsLabelsLangPK;
    }

    public void setPsAnProductextratabsLabelsLangPK(PsAnProductextratabsLabelsLangPK psAnProductextratabsLabelsLangPK) {
        this.psAnProductextratabsLabelsLangPK = psAnProductextratabsLabelsLangPK;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psAnProductextratabsLabelsLangPK != null ? psAnProductextratabsLabelsLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnProductextratabsLabelsLang)) {
            return false;
        }
        PsAnProductextratabsLabelsLang other = (PsAnProductextratabsLabelsLang) object;
        if ((this.psAnProductextratabsLabelsLangPK == null && other.psAnProductextratabsLabelsLangPK != null) || (this.psAnProductextratabsLabelsLangPK != null && !this.psAnProductextratabsLabelsLangPK.equals(other.psAnProductextratabsLabelsLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnProductextratabsLabelsLang[ psAnProductextratabsLabelsLangPK=" + psAnProductextratabsLabelsLangPK + " ]";
    }
    
}
