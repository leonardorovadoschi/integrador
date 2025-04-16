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
 * @author leo-note
 */
@Entity
@Table(name = "ps_anblog_blog_widgets_relations")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnblogBlogWidgetsRelations.findAll", query = "SELECT p FROM PsAnblogBlogWidgetsRelations p")})
public class PsAnblogBlogWidgetsRelations implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_relation")
    private Integer idRelation;
    @Basic(optional = false)
    @Column(name = "type")
    private short type;
    @Basic(optional = false)
    @Column(name = "id_anblog_blog_widgets")
    private int idAnblogBlogWidgets;
    @Basic(optional = false)
    @Column(name = "id_type")
    private int idType;

    public PsAnblogBlogWidgetsRelations() {
    }

    public PsAnblogBlogWidgetsRelations(Integer idRelation) {
        this.idRelation = idRelation;
    }

    public PsAnblogBlogWidgetsRelations(Integer idRelation, short type, int idAnblogBlogWidgets, int idType) {
        this.idRelation = idRelation;
        this.type = type;
        this.idAnblogBlogWidgets = idAnblogBlogWidgets;
        this.idType = idType;
    }

    public Integer getIdRelation() {
        return idRelation;
    }

    public void setIdRelation(Integer idRelation) {
        this.idRelation = idRelation;
    }

    public short getType() {
        return type;
    }

    public void setType(short type) {
        this.type = type;
    }

    public int getIdAnblogBlogWidgets() {
        return idAnblogBlogWidgets;
    }

    public void setIdAnblogBlogWidgets(int idAnblogBlogWidgets) {
        this.idAnblogBlogWidgets = idAnblogBlogWidgets;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRelation != null ? idRelation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnblogBlogWidgetsRelations)) {
            return false;
        }
        PsAnblogBlogWidgetsRelations other = (PsAnblogBlogWidgetsRelations) object;
        if ((this.idRelation == null && other.idRelation != null) || (this.idRelation != null && !this.idRelation.equals(other.idRelation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnblogBlogWidgetsRelations[ idRelation=" + idRelation + " ]";
    }
    
}
