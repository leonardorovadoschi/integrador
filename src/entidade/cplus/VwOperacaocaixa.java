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
@Table(name = "VW_OPERACAOCAIXA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwOperacaocaixa.findAll", query = "SELECT v FROM VwOperacaocaixa v")
    , @NamedQuery(name = "VwOperacaocaixa.findByFlagtipo", query = "SELECT v FROM VwOperacaocaixa v WHERE v.flagtipo = :flagtipo")
    , @NamedQuery(name = "VwOperacaocaixa.findByFlagoperacao", query = "SELECT v FROM VwOperacaocaixa v WHERE v.flagoperacao = :flagoperacao")
    , @NamedQuery(name = "VwOperacaocaixa.findByDescricao", query = "SELECT v FROM VwOperacaocaixa v WHERE v.descricao = :descricao")})
public class VwOperacaocaixa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "FLAGTIPO")
    private Integer flagtipo;
    @Column(name = "FLAGOPERACAO")
    private Character flagoperacao;
    @Column(name = "DESCRICAO")
    private String descricao;

    public VwOperacaocaixa() {
    }

    public Integer getFlagtipo() {
        return flagtipo;
    }

    public void setFlagtipo(Integer flagtipo) {
        this.flagtipo = flagtipo;
    }

    public Character getFlagoperacao() {
        return flagoperacao;
    }

    public void setFlagoperacao(Character flagoperacao) {
        this.flagoperacao = flagoperacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
