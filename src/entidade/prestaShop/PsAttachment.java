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
@Table(name = "ps_attachment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAttachment.findAll", query = "SELECT p FROM PsAttachment p")
    , @NamedQuery(name = "PsAttachment.findByIdAttachment", query = "SELECT p FROM PsAttachment p WHERE p.idAttachment = :idAttachment")
    , @NamedQuery(name = "PsAttachment.findByFile", query = "SELECT p FROM PsAttachment p WHERE p.file = :file")
    , @NamedQuery(name = "PsAttachment.findByFileName", query = "SELECT p FROM PsAttachment p WHERE p.fileName = :fileName")
    , @NamedQuery(name = "PsAttachment.findByFileSize", query = "SELECT p FROM PsAttachment p WHERE p.fileSize = :fileSize")
    , @NamedQuery(name = "PsAttachment.findByMime", query = "SELECT p FROM PsAttachment p WHERE p.mime = :mime")})
public class PsAttachment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_attachment")
    private Integer idAttachment;
    @Basic(optional = false)
    @Column(name = "file")
    private String file;
    @Basic(optional = false)
    @Column(name = "file_name")
    private String fileName;
    @Basic(optional = false)
    @Column(name = "file_size")
    private long fileSize;
    @Basic(optional = false)
    @Column(name = "mime")
    private String mime;

    public PsAttachment() {
    }

    public PsAttachment(Integer idAttachment) {
        this.idAttachment = idAttachment;
    }

    public PsAttachment(Integer idAttachment, String file, String fileName, long fileSize, String mime) {
        this.idAttachment = idAttachment;
        this.file = file;
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.mime = mime;
    }

    public Integer getIdAttachment() {
        return idAttachment;
    }

    public void setIdAttachment(Integer idAttachment) {
        this.idAttachment = idAttachment;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getMime() {
        return mime;
    }

    public void setMime(String mime) {
        this.mime = mime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAttachment != null ? idAttachment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAttachment)) {
            return false;
        }
        PsAttachment other = (PsAttachment) object;
        if ((this.idAttachment == null && other.idAttachment != null) || (this.idAttachment != null && !this.idAttachment.equals(other.idAttachment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAttachment[ idAttachment=" + idAttachment + " ]";
    }
    
}
