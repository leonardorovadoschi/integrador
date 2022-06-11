/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "VW_ALIQICMSINTER", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwAliqicmsinter.findAll", query = "SELECT v FROM VwAliqicmsinter v")
    , @NamedQuery(name = "VwAliqicmsinter.findByAno", query = "SELECT v FROM VwAliqicmsinter v WHERE v.ano = :ano")
    , @NamedQuery(name = "VwAliqicmsinter.findByAliq", query = "SELECT v FROM VwAliqicmsinter v WHERE v.aliq = :aliq")})
public class VwAliqicmsinter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "ANO")
    private String ano;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ALIQ")
    private BigDecimal aliq;

    public VwAliqicmsinter() {
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public BigDecimal getAliq() {
        return aliq;
    }

    public void setAliq(BigDecimal aliq) {
        this.aliq = aliq;
    }
    
}
