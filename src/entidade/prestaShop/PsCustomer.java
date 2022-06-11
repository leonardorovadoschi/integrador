/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ps_customer")
public class PsCustomer implements Serializable {

    @Basic(optional = false)
    @Column(name = "newsletter")
    private boolean newsletter;
    @Basic(optional = false)
    @Column(name = "optin")
    private boolean optin;
    @Basic(optional = false)
    @Column(name = "show_public_prices")
    private boolean showPublicPrices;
    @Basic(optional = false)
    @Column(name = "active")
    private boolean active;

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "idCustomer")
    //private Collection<PsModuloCpf> psModuloCpfCollection;

    @Column(name = "tipo")
    private String tipo;
    @Column(name = "cpf_cnpj")
    private String cpfCnpj;
    @Column(name = "rg_ie")
    private String rgIe;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_customer")
    private Integer idCustomer;
    @Basic(optional = false)
    @Column(name = "id_shop_group")
    private int idShopGroup;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;
    @Basic(optional = false)
    @Column(name = "id_gender")
    private int idGender;
    @Basic(optional = false)
    @Column(name = "id_default_group")
    private int idDefaultGroup;
    @Column(name = "id_lang")
    private Integer idLang;
    @Basic(optional = false)
    @Column(name = "id_risk")
    private int idRisk;
    @Column(name = "company")
    private String company;
    @Column(name = "siret")
    private String siret;
    @Column(name = "ape")
    private String ape;
    @Basic(optional = false)
    @Column(name = "firstname")
    private String firstname;
    @Basic(optional = false)
    @Column(name = "lastname")
    private String lastname;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "passwd")
    private String passwd;
    @Basic(optional = false)
    @Column(name = "last_passwd_gen")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastPasswdGen;
    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @Column(name = "ip_registration_newsletter")
    private String ipRegistrationNewsletter;
    @Column(name = "newsletter_date_add")
    @Temporal(TemporalType.TIMESTAMP)
    private Date newsletterDateAdd;
    @Column(name = "website")
    private String website;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "outstanding_allow_amount")
    private BigDecimal outstandingAllowAmount;
    @Basic(optional = false)
    @Column(name = "max_payment_days")
    private int maxPaymentDays;
    @Basic(optional = false)
    @Column(name = "secure_key")
    private String secureKey;
    @Lob
    @Column(name = "note")
    private String note;
    @Basic(optional = false)
    @Column(name = "is_guest")
    private boolean isGuest;
    @Basic(optional = false)
    @Column(name = "deleted")
    private boolean deleted;
    @Basic(optional = false)
    @Column(name = "date_add")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdd;
    @Basic(optional = false)
    @Column(name = "date_upd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpd;
    @Column(name = "reset_password_token")
    private String resetPasswordToken;
    @Column(name = "reset_password_validity")
    @Temporal(TemporalType.TIMESTAMP)
    private Date resetPasswordValidity;

    public PsCustomer() {
    }

    public PsCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public PsCustomer(Integer idCustomer, int idShopGroup, int idShop, int idGender, int idDefaultGroup, int idRisk, String firstname, String lastname, String email, String passwd, Date lastPasswdGen, boolean newsletter, boolean optin, BigDecimal outstandingAllowAmount, boolean showPublicPrices, int maxPaymentDays, String secureKey, boolean active, boolean isGuest, boolean deleted, Date dateAdd, Date dateUpd) {
        this.idCustomer = idCustomer;
        this.idShopGroup = idShopGroup;
        this.idShop = idShop;
        this.idGender = idGender;
        this.idDefaultGroup = idDefaultGroup;
        this.idRisk = idRisk;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.passwd = passwd;
        this.lastPasswdGen = lastPasswdGen;
        this.newsletter = newsletter;
        this.optin = optin;
        this.outstandingAllowAmount = outstandingAllowAmount;
        this.showPublicPrices = showPublicPrices;
        this.maxPaymentDays = maxPaymentDays;
        this.secureKey = secureKey;
        this.active = active;
        this.isGuest = isGuest;
        this.deleted = deleted;
        this.dateAdd = dateAdd;
        this.dateUpd = dateUpd;
    }

    public Integer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        Integer oldIdCustomer = this.idCustomer;
        this.idCustomer = idCustomer;
        changeSupport.firePropertyChange("idCustomer", oldIdCustomer, idCustomer);
    }

    public int getIdShopGroup() {
        return idShopGroup;
    }

    public void setIdShopGroup(int idShopGroup) {
        int oldIdShopGroup = this.idShopGroup;
        this.idShopGroup = idShopGroup;
        changeSupport.firePropertyChange("idShopGroup", oldIdShopGroup, idShopGroup);
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        int oldIdShop = this.idShop;
        this.idShop = idShop;
        changeSupport.firePropertyChange("idShop", oldIdShop, idShop);
    }

    public int getIdGender() {
        return idGender;
    }

    public void setIdGender(int idGender) {
        int oldIdGender = this.idGender;
        this.idGender = idGender;
        changeSupport.firePropertyChange("idGender", oldIdGender, idGender);
    }

    public int getIdDefaultGroup() {
        return idDefaultGroup;
    }

    public void setIdDefaultGroup(int idDefaultGroup) {
        int oldIdDefaultGroup = this.idDefaultGroup;
        this.idDefaultGroup = idDefaultGroup;
        changeSupport.firePropertyChange("idDefaultGroup", oldIdDefaultGroup, idDefaultGroup);
    }

    public Integer getIdLang() {
        return idLang;
    }

    public void setIdLang(Integer idLang) {
        Integer oldIdLang = this.idLang;
        this.idLang = idLang;
        changeSupport.firePropertyChange("idLang", oldIdLang, idLang);
    }

    public int getIdRisk() {
        return idRisk;
    }

    public void setIdRisk(int idRisk) {
        int oldIdRisk = this.idRisk;
        this.idRisk = idRisk;
        changeSupport.firePropertyChange("idRisk", oldIdRisk, idRisk);
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        String oldCompany = this.company;
        this.company = company;
        changeSupport.firePropertyChange("company", oldCompany, company);
    }

    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        String oldSiret = this.siret;
        this.siret = siret;
        changeSupport.firePropertyChange("siret", oldSiret, siret);
    }

    public String getApe() {
        return ape;
    }

    public void setApe(String ape) {
        String oldApe = this.ape;
        this.ape = ape;
        changeSupport.firePropertyChange("ape", oldApe, ape);
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        String oldFirstname = this.firstname;
        this.firstname = firstname;
        changeSupport.firePropertyChange("firstname", oldFirstname, firstname);
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        String oldLastname = this.lastname;
        this.lastname = lastname;
        changeSupport.firePropertyChange("lastname", oldLastname, lastname);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", oldEmail, email);
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        String oldPasswd = this.passwd;
        this.passwd = passwd;
        changeSupport.firePropertyChange("passwd", oldPasswd, passwd);
    }

    public Date getLastPasswdGen() {
        return lastPasswdGen;
    }

    public void setLastPasswdGen(Date lastPasswdGen) {
        Date oldLastPasswdGen = this.lastPasswdGen;
        this.lastPasswdGen = lastPasswdGen;
        changeSupport.firePropertyChange("lastPasswdGen", oldLastPasswdGen, lastPasswdGen);
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        Date oldBirthday = this.birthday;
        this.birthday = birthday;
        changeSupport.firePropertyChange("birthday", oldBirthday, birthday);
    }


    public String getIpRegistrationNewsletter() {
        return ipRegistrationNewsletter;
    }

    public void setIpRegistrationNewsletter(String ipRegistrationNewsletter) {
        String oldIpRegistrationNewsletter = this.ipRegistrationNewsletter;
        this.ipRegistrationNewsletter = ipRegistrationNewsletter;
        changeSupport.firePropertyChange("ipRegistrationNewsletter", oldIpRegistrationNewsletter, ipRegistrationNewsletter);
    }

    public Date getNewsletterDateAdd() {
        return newsletterDateAdd;
    }

    public void setNewsletterDateAdd(Date newsletterDateAdd) {
        Date oldNewsletterDateAdd = this.newsletterDateAdd;
        this.newsletterDateAdd = newsletterDateAdd;
        changeSupport.firePropertyChange("newsletterDateAdd", oldNewsletterDateAdd, newsletterDateAdd);
    }


    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        String oldWebsite = this.website;
        this.website = website;
        changeSupport.firePropertyChange("website", oldWebsite, website);
    }

    public BigDecimal getOutstandingAllowAmount() {
        return outstandingAllowAmount;
    }

    public void setOutstandingAllowAmount(BigDecimal outstandingAllowAmount) {
        BigDecimal oldOutstandingAllowAmount = this.outstandingAllowAmount;
        this.outstandingAllowAmount = outstandingAllowAmount;
        changeSupport.firePropertyChange("outstandingAllowAmount", oldOutstandingAllowAmount, outstandingAllowAmount);
    }

    public boolean getShowPublicPrices() {
        return showPublicPrices;
    }

    public void setShowPublicPrices(boolean showPublicPrices) {
        boolean oldShowPublicPrices = this.showPublicPrices;
        this.showPublicPrices = showPublicPrices;
        changeSupport.firePropertyChange("showPublicPrices", oldShowPublicPrices, showPublicPrices);
    }

    public int getMaxPaymentDays() {
        return maxPaymentDays;
    }

    public void setMaxPaymentDays(int maxPaymentDays) {
        int oldMaxPaymentDays = this.maxPaymentDays;
        this.maxPaymentDays = maxPaymentDays;
        changeSupport.firePropertyChange("maxPaymentDays", oldMaxPaymentDays, maxPaymentDays);
    }

    public String getSecureKey() {
        return secureKey;
    }

    public void setSecureKey(String secureKey) {
        String oldSecureKey = this.secureKey;
        this.secureKey = secureKey;
        changeSupport.firePropertyChange("secureKey", oldSecureKey, secureKey);
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        String oldNote = this.note;
        this.note = note;
        changeSupport.firePropertyChange("note", oldNote, note);
    }


    public boolean getIsGuest() {
        return isGuest;
    }

    public void setIsGuest(boolean isGuest) {
        boolean oldIsGuest = this.isGuest;
        this.isGuest = isGuest;
        changeSupport.firePropertyChange("isGuest", oldIsGuest, isGuest);
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        boolean oldDeleted = this.deleted;
        this.deleted = deleted;
        changeSupport.firePropertyChange("deleted", oldDeleted, deleted);
    }

    public Date getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Date dateAdd) {
        Date oldDateAdd = this.dateAdd;
        this.dateAdd = dateAdd;
        changeSupport.firePropertyChange("dateAdd", oldDateAdd, dateAdd);
    }

    public Date getDateUpd() {
        return dateUpd;
    }

    public void setDateUpd(Date dateUpd) {
        Date oldDateUpd = this.dateUpd;
        this.dateUpd = dateUpd;
        changeSupport.firePropertyChange("dateUpd", oldDateUpd, dateUpd);
    }

    public String getResetPasswordToken() {
        return resetPasswordToken;
    }

    public void setResetPasswordToken(String resetPasswordToken) {
        String oldResetPasswordToken = this.resetPasswordToken;
        this.resetPasswordToken = resetPasswordToken;
        changeSupport.firePropertyChange("resetPasswordToken", oldResetPasswordToken, resetPasswordToken);
    }

    public Date getResetPasswordValidity() {
        return resetPasswordValidity;
    }

    public void setResetPasswordValidity(Date resetPasswordValidity) {
        Date oldResetPasswordValidity = this.resetPasswordValidity;
        this.resetPasswordValidity = resetPasswordValidity;
        changeSupport.firePropertyChange("resetPasswordValidity", oldResetPasswordValidity, resetPasswordValidity);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCustomer != null ? idCustomer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCustomer)) {
            return false;
        }
        PsCustomer other = (PsCustomer) object;
        if ((this.idCustomer == null && other.idCustomer != null) || (this.idCustomer != null && !this.idCustomer.equals(other.idCustomer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCustomer[ idCustomer=" + idCustomer + " ]";
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        String oldTipo = this.tipo;
        this.tipo = tipo;
        changeSupport.firePropertyChange("tipo", oldTipo, tipo);
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        String oldCpfCnpj = this.cpfCnpj;
        this.cpfCnpj = cpfCnpj;
        changeSupport.firePropertyChange("cpfCnpj", oldCpfCnpj, cpfCnpj);
    }

    public String getRgIe() {
        return rgIe;
    }

    public void setRgIe(String rgIe) {
        String oldRgIe = this.rgIe;
        this.rgIe = rgIe;
        changeSupport.firePropertyChange("rgIe", oldRgIe, rgIe);
    }

  //  @XmlTransient
  //  public Collection<PsModuloCpf> getPsModuloCpfCollection() {
  //      return psModuloCpfCollection;
  //  }
//
  // public void setPsModuloCpfCollection(Collection<PsModuloCpf> psModuloCpfCollection) {
   //     this.psModuloCpfCollection = psModuloCpfCollection;
  //  }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

    public boolean getNewsletter() {
        return newsletter;
    }

    public void setNewsletter(boolean newsletter) {
        this.newsletter = newsletter;
    }

    public boolean getOptin() {
        return optin;
    }

    public void setOptin(boolean optin) {
        this.optin = optin;
    }
   

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
}
