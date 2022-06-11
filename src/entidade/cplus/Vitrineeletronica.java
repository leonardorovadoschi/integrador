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
@Table(name = "VITRINEELETRONICA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vitrineeletronica.findAll", query = "SELECT v FROM Vitrineeletronica v")
    , @NamedQuery(name = "Vitrineeletronica.findByCodvitrineeletronica", query = "SELECT v FROM Vitrineeletronica v WHERE v.codvitrineeletronica = :codvitrineeletronica")
    , @NamedQuery(name = "Vitrineeletronica.findByNomevitrineeletronica", query = "SELECT v FROM Vitrineeletronica v WHERE v.nomevitrineeletronica = :nomevitrineeletronica")
    , @NamedQuery(name = "Vitrineeletronica.findByOrdem", query = "SELECT v FROM Vitrineeletronica v WHERE v.ordem = :ordem")
    , @NamedQuery(name = "Vitrineeletronica.findByTempoexibicao", query = "SELECT v FROM Vitrineeletronica v WHERE v.tempoexibicao = :tempoexibicao")})
public class Vitrineeletronica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODVITRINEELETRONICA")
    private String codvitrineeletronica;
    @Column(name = "NOMEVITRINEELETRONICA")
    private String nomevitrineeletronica;
    @Lob
    @Column(name = "IMAGEM")
    private byte[] imagem;
    @Column(name = "ORDEM")
    private Integer ordem;
    @Column(name = "TEMPOEXIBICAO")
    private Integer tempoexibicao;

    public Vitrineeletronica() {
    }

    public Vitrineeletronica(String codvitrineeletronica) {
        this.codvitrineeletronica = codvitrineeletronica;
    }

    public String getCodvitrineeletronica() {
        return codvitrineeletronica;
    }

    public void setCodvitrineeletronica(String codvitrineeletronica) {
        this.codvitrineeletronica = codvitrineeletronica;
    }

    public String getNomevitrineeletronica() {
        return nomevitrineeletronica;
    }

    public void setNomevitrineeletronica(String nomevitrineeletronica) {
        this.nomevitrineeletronica = nomevitrineeletronica;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public Integer getOrdem() {
        return ordem;
    }

    public void setOrdem(Integer ordem) {
        this.ordem = ordem;
    }

    public Integer getTempoexibicao() {
        return tempoexibicao;
    }

    public void setTempoexibicao(Integer tempoexibicao) {
        this.tempoexibicao = tempoexibicao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codvitrineeletronica != null ? codvitrineeletronica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vitrineeletronica)) {
            return false;
        }
        Vitrineeletronica other = (Vitrineeletronica) object;
        if ((this.codvitrineeletronica == null && other.codvitrineeletronica != null) || (this.codvitrineeletronica != null && !this.codvitrineeletronica.equals(other.codvitrineeletronica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Vitrineeletronica[ codvitrineeletronica=" + codvitrineeletronica + " ]";
    }
    
}
