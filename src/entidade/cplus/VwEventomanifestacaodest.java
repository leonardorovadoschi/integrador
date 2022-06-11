/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "VW_EVENTOMANIFESTACAODEST", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwEventomanifestacaodest.findAll", query = "SELECT v FROM VwEventomanifestacaodest v")
    , @NamedQuery(name = "VwEventomanifestacaodest.findByCodigoeventomanifestacaodest", query = "SELECT v FROM VwEventomanifestacaodest v WHERE v.codigoeventomanifestacaodest = :codigoeventomanifestacaodest")
    , @NamedQuery(name = "VwEventomanifestacaodest.findByDescricao", query = "SELECT v FROM VwEventomanifestacaodest v WHERE v.descricao = :descricao")})
public class VwEventomanifestacaodest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "CODIGOEVENTOMANIFESTACAODEST")
    private String codigoeventomanifestacaodest;
    @Column(name = "DESCRICAO")
    private String descricao;

    public VwEventomanifestacaodest() {
    }

    public String getCodigoeventomanifestacaodest() {
        return codigoeventomanifestacaodest;
    }

    public void setCodigoeventomanifestacaodest(String codigoeventomanifestacaodest) {
        this.codigoeventomanifestacaodest = codigoeventomanifestacaodest;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
