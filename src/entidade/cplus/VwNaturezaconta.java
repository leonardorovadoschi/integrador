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
@Table(name = "VW_NATUREZACONTA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwNaturezaconta.findAll", query = "SELECT v FROM VwNaturezaconta v")
    , @NamedQuery(name = "VwNaturezaconta.findByCodigonaturezaconta", query = "SELECT v FROM VwNaturezaconta v WHERE v.codigonaturezaconta = :codigonaturezaconta")
    , @NamedQuery(name = "VwNaturezaconta.findByDescricao", query = "SELECT v FROM VwNaturezaconta v WHERE v.descricao = :descricao")})
public class VwNaturezaconta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "CODIGONATUREZACONTA")
    private String codigonaturezaconta;
    @Column(name = "DESCRICAO")
    private String descricao;

    public VwNaturezaconta() {
    }

    public String getCodigonaturezaconta() {
        return codigonaturezaconta;
    }

    public void setCodigonaturezaconta(String codigonaturezaconta) {
        this.codigonaturezaconta = codigonaturezaconta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
