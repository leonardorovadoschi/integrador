/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ps_search_word")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsSearchWord.findAll", query = "SELECT p FROM PsSearchWord p")
    , @NamedQuery(name = "PsSearchWord.findByIdWord", query = "SELECT p FROM PsSearchWord p WHERE p.idWord = :idWord")
    , @NamedQuery(name = "PsSearchWord.findByIdShop", query = "SELECT p FROM PsSearchWord p WHERE p.idShop = :idShop")
    , @NamedQuery(name = "PsSearchWord.findByIdLang", query = "SELECT p FROM PsSearchWord p WHERE p.idLang = :idLang")
    , @NamedQuery(name = "PsSearchWord.findByWord", query = "SELECT p FROM PsSearchWord p WHERE p.word = :word")})
public class PsSearchWord implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_word")
    private Integer idWord;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private int idLang;
    @Basic(optional = false)
    @Column(name = "word")
    private String word;

    public PsSearchWord() {
    }

    public PsSearchWord(Integer idWord) {
        this.idWord = idWord;
    }

    public PsSearchWord(Integer idWord, int idShop, int idLang, String word) {
        this.idWord = idWord;
        this.idShop = idShop;
        this.idLang = idLang;
        this.word = word;
    }

    public Integer getIdWord() {
        return idWord;
    }

    public void setIdWord(Integer idWord) {
        this.idWord = idWord;
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    public int getIdLang() {
        return idLang;
    }

    public void setIdLang(int idLang) {
        this.idLang = idLang;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idWord != null ? idWord.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsSearchWord)) {
            return false;
        }
        PsSearchWord other = (PsSearchWord) object;
        if ((this.idWord == null && other.idWord != null) || (this.idWord != null && !this.idWord.equals(other.idWord))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsSearchWord[ idWord=" + idWord + " ]";
    }
    
}
