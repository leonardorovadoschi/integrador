/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "TINTASUVINILPRODUTO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tintasuvinilproduto.findAll", query = "SELECT t FROM Tintasuvinilproduto t")
    , @NamedQuery(name = "Tintasuvinilproduto.findByCodtintasuvinilproduto", query = "SELECT t FROM Tintasuvinilproduto t WHERE t.codtintasuvinilproduto = :codtintasuvinilproduto")
    , @NamedQuery(name = "Tintasuvinilproduto.findByNomeproduto", query = "SELECT t FROM Tintasuvinilproduto t WHERE t.nomeproduto = :nomeproduto")
    , @NamedQuery(name = "Tintasuvinilproduto.findByRendimento", query = "SELECT t FROM Tintasuvinilproduto t WHERE t.rendimento = :rendimento")})
public class Tintasuvinilproduto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODTINTASUVINILPRODUTO")
    private Integer codtintasuvinilproduto;
    @Column(name = "NOMEPRODUTO")
    private String nomeproduto;
    @Lob
    @Column(name = "IMAGEM")
    private byte[] imagem;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "RENDIMENTO")
    private BigDecimal rendimento;

    public Tintasuvinilproduto() {
    }

    public Tintasuvinilproduto(Integer codtintasuvinilproduto) {
        this.codtintasuvinilproduto = codtintasuvinilproduto;
    }

    public Integer getCodtintasuvinilproduto() {
        return codtintasuvinilproduto;
    }

    public void setCodtintasuvinilproduto(Integer codtintasuvinilproduto) {
        this.codtintasuvinilproduto = codtintasuvinilproduto;
    }

    public String getNomeproduto() {
        return nomeproduto;
    }

    public void setNomeproduto(String nomeproduto) {
        this.nomeproduto = nomeproduto;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public BigDecimal getRendimento() {
        return rendimento;
    }

    public void setRendimento(BigDecimal rendimento) {
        this.rendimento = rendimento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codtintasuvinilproduto != null ? codtintasuvinilproduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tintasuvinilproduto)) {
            return false;
        }
        Tintasuvinilproduto other = (Tintasuvinilproduto) object;
        if ((this.codtintasuvinilproduto == null && other.codtintasuvinilproduto != null) || (this.codtintasuvinilproduto != null && !this.codtintasuvinilproduto.equals(other.codtintasuvinilproduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Tintasuvinilproduto[ codtintasuvinilproduto=" + codtintasuvinilproduto + " ]";
    }
    
}
