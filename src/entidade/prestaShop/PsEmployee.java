/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ps_employee")
@XmlRootElement

public class PsEmployee implements Serializable {
    @Basic(optional = false)
    @Column(name = "active")
    private short active;
    @Column(name = "optin")
    private Short optin;
    @Basic(optional = false)
    @Column(name = "has_enabled_gravatar")
    private short hasEnabledGravatar;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_employee")
    private Integer idEmployee;
    @Basic(optional = false)
    @Column(name = "id_profile")
    private int idProfile;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private int idLang;
    @Basic(optional = false)
    @Column(name = "lastname")
    private String lastname;
    @Basic(optional = false)
    @Column(name = "firstname")
    private String firstname;
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
    @Column(name = "stats_date_from")
    @Temporal(TemporalType.DATE)
    private Date statsDateFrom;
    @Column(name = "stats_date_to")
    @Temporal(TemporalType.DATE)
    private Date statsDateTo;
    @Column(name = "stats_compare_from")
    @Temporal(TemporalType.DATE)
    private Date statsCompareFrom;
    @Column(name = "stats_compare_to")
    @Temporal(TemporalType.DATE)
    private Date statsCompareTo;
    @Basic(optional = false)
    @Column(name = "stats_compare_option")
    private int statsCompareOption;
    @Column(name = "preselect_date_range")
    private String preselectDateRange;
    @Column(name = "bo_color")
    private String boColor;
    @Column(name = "bo_theme")
    private String boTheme;
    @Column(name = "bo_css")
    private String boCss;
    @Basic(optional = false)
    @Column(name = "default_tab")
    private int defaultTab;
    @Basic(optional = false)
    @Column(name = "bo_width")
    private int boWidth;
    @Basic(optional = false)
    @Column(name = "bo_menu")
    private boolean boMenu;
    @Basic(optional = false)
    @Column(name = "id_last_order")
    private int idLastOrder;
    @Basic(optional = false)
    @Column(name = "id_last_customer_message")
    private int idLastCustomerMessage;
    @Basic(optional = false)
    @Column(name = "id_last_customer")
    private int idLastCustomer;
    @Column(name = "last_connection_date")
    @Temporal(TemporalType.DATE)
    private Date lastConnectionDate;
    @Column(name = "reset_password_token")
    private String resetPasswordToken;
    @Column(name = "reset_password_validity")
    @Temporal(TemporalType.TIMESTAMP)
    private Date resetPasswordValidity;

    public PsEmployee() {
    }

    public PsEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    public PsEmployee(Integer idEmployee, int idProfile, int idLang, String lastname, String firstname, String email, String passwd, Date lastPasswdGen, int statsCompareOption, int defaultTab, int boWidth, boolean boMenu, short active, short optin, int idLastOrder, int idLastCustomerMessage, int idLastCustomer) {
        this.idEmployee = idEmployee;
        this.idProfile = idProfile;
        this.idLang = idLang;
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.passwd = passwd;
        this.lastPasswdGen = lastPasswdGen;
        this.statsCompareOption = statsCompareOption;
        this.defaultTab = defaultTab;
        this.boWidth = boWidth;
        this.boMenu = boMenu;
        this.active = active;
        this.optin = optin;
        this.idLastOrder = idLastOrder;
        this.idLastCustomerMessage = idLastCustomerMessage;
        this.idLastCustomer = idLastCustomer;
    }

    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    public int getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(int idProfile) {
        this.idProfile = idProfile;
    }

    public int getIdLang() {
        return idLang;
    }

    public void setIdLang(int idLang) {
        this.idLang = idLang;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public Date getLastPasswdGen() {
        return lastPasswdGen;
    }

    public void setLastPasswdGen(Date lastPasswdGen) {
        this.lastPasswdGen = lastPasswdGen;
    }

    public Date getStatsDateFrom() {
        return statsDateFrom;
    }

    public void setStatsDateFrom(Date statsDateFrom) {
        this.statsDateFrom = statsDateFrom;
    }

    public Date getStatsDateTo() {
        return statsDateTo;
    }

    public void setStatsDateTo(Date statsDateTo) {
        this.statsDateTo = statsDateTo;
    }

    public Date getStatsCompareFrom() {
        return statsCompareFrom;
    }

    public void setStatsCompareFrom(Date statsCompareFrom) {
        this.statsCompareFrom = statsCompareFrom;
    }

    public Date getStatsCompareTo() {
        return statsCompareTo;
    }

    public void setStatsCompareTo(Date statsCompareTo) {
        this.statsCompareTo = statsCompareTo;
    }

    public int getStatsCompareOption() {
        return statsCompareOption;
    }

    public void setStatsCompareOption(int statsCompareOption) {
        this.statsCompareOption = statsCompareOption;
    }

    public String getPreselectDateRange() {
        return preselectDateRange;
    }

    public void setPreselectDateRange(String preselectDateRange) {
        this.preselectDateRange = preselectDateRange;
    }

    public String getBoColor() {
        return boColor;
    }

    public void setBoColor(String boColor) {
        this.boColor = boColor;
    }

    public String getBoTheme() {
        return boTheme;
    }

    public void setBoTheme(String boTheme) {
        this.boTheme = boTheme;
    }

    public String getBoCss() {
        return boCss;
    }

    public void setBoCss(String boCss) {
        this.boCss = boCss;
    }

    public int getDefaultTab() {
        return defaultTab;
    }

    public void setDefaultTab(int defaultTab) {
        this.defaultTab = defaultTab;
    }

    public int getBoWidth() {
        return boWidth;
    }

    public void setBoWidth(int boWidth) {
        this.boWidth = boWidth;
    }

    public boolean getBoMenu() {
        return boMenu;
    }

    public void setBoMenu(boolean boMenu) {
        this.boMenu = boMenu;
    }


    public int getIdLastOrder() {
        return idLastOrder;
    }

    public void setIdLastOrder(int idLastOrder) {
        this.idLastOrder = idLastOrder;
    }

    public int getIdLastCustomerMessage() {
        return idLastCustomerMessage;
    }

    public void setIdLastCustomerMessage(int idLastCustomerMessage) {
        this.idLastCustomerMessage = idLastCustomerMessage;
    }

    public int getIdLastCustomer() {
        return idLastCustomer;
    }

    public void setIdLastCustomer(int idLastCustomer) {
        this.idLastCustomer = idLastCustomer;
    }

    public Date getLastConnectionDate() {
        return lastConnectionDate;
    }

    public void setLastConnectionDate(Date lastConnectionDate) {
        this.lastConnectionDate = lastConnectionDate;
    }

    public String getResetPasswordToken() {
        return resetPasswordToken;
    }

    public void setResetPasswordToken(String resetPasswordToken) {
        this.resetPasswordToken = resetPasswordToken;
    }

    public Date getResetPasswordValidity() {
        return resetPasswordValidity;
    }

    public void setResetPasswordValidity(Date resetPasswordValidity) {
        this.resetPasswordValidity = resetPasswordValidity;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmployee != null ? idEmployee.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsEmployee)) {
            return false;
        }
        PsEmployee other = (PsEmployee) object;
        if ((this.idEmployee == null && other.idEmployee != null) || (this.idEmployee != null && !this.idEmployee.equals(other.idEmployee))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsEmployee[ idEmployee=" + idEmployee + " ]";
    }

    public short getActive() {
        return active;
    }

    public void setActive(short active) {
        this.active = active;
    }

    public Short getOptin() {
        return optin;
    }

    public void setOptin(Short optin) {
        this.optin = optin;
    }

    public short getHasEnabledGravatar() {
        return hasEnabledGravatar;
    }

    public void setHasEnabledGravatar(short hasEnabledGravatar) {
        this.hasEnabledGravatar = hasEnabledGravatar;
    }
    
}
