/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sabonay.ejb.entities.generated;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adm-Kjo
 */
@Entity
@Table(name = "admin_user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdminUser.findAll", query = "SELECT a FROM AdminUser a"),
    @NamedQuery(name = "AdminUser.findByAdminUserId", query = "SELECT a FROM AdminUser a WHERE a.adminUserId = :adminUserId"),
    @NamedQuery(name = "AdminUser.findByUsername", query = "SELECT a FROM AdminUser a WHERE a.username = :username"),
    @NamedQuery(name = "AdminUser.findByUserPassword", query = "SELECT a FROM AdminUser a WHERE a.userPassword = :userPassword"),
    @NamedQuery(name = "AdminUser.findByAccessLevel", query = "SELECT a FROM AdminUser a WHERE a.accessLevel = :accessLevel"),
    @NamedQuery(name = "AdminUser.findByLoginBefore", query = "SELECT a FROM AdminUser a WHERE a.loginBefore = :loginBefore"),
    @NamedQuery(name = "AdminUser.findByEmailAddress", query = "SELECT a FROM AdminUser a WHERE a.emailAddress = :emailAddress"),
    @NamedQuery(name = "AdminUser.findByLastLogin", query = "SELECT a FROM AdminUser a WHERE a.lastLogin = :lastLogin"),
    @NamedQuery(name = "AdminUser.findByAccountDate", query = "SELECT a FROM AdminUser a WHERE a.accountDate = :accountDate"),
    @NamedQuery(name = "AdminUser.findBySiteId", query = "SELECT a FROM AdminUser a WHERE a.siteId = :siteId"),
    @NamedQuery(name = "AdminUser.findBySystemView", query = "SELECT a FROM AdminUser a WHERE a.systemView = :systemView")})
public class AdminUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "admin_user_id")
    private Integer adminUserId;
    @Size(max = 255)
    @Column(name = "username")
    private String username;
    @Size(max = 255)
    @Column(name = "user_password")
    private String userPassword;
    @Size(max = 50)
    @Column(name = "access_level")
    private String accessLevel;
    @Size(max = 4)
    @Column(name = "login_before")
    private String loginBefore;
    @Size(max = 255)
    @Column(name = "email_address")
    private String emailAddress;
    @Lob
    @Size(max = 65535)
    @Column(name = "user_privilege")
    private String userPrivilege;
    @Column(name = "last_login")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;
    @Column(name = "account_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date accountDate;
    @Size(max = 50)
    @Column(name = "site_id")
    private String siteId;
    @Column(name = "system_view")
    private Integer systemView;

    public AdminUser() {
    }

    public AdminUser(Integer adminUserId) {
        this.adminUserId = adminUserId;
    }

    public Integer getAdminUserId() {
        return adminUserId;
    }

    public void setAdminUserId(Integer adminUserId) {
        this.adminUserId = adminUserId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    public String getLoginBefore() {
        return loginBefore;
    }

    public void setLoginBefore(String loginBefore) {
        this.loginBefore = loginBefore;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getUserPrivilege() {
        return userPrivilege;
    }

    public void setUserPrivilege(String userPrivilege) {
        this.userPrivilege = userPrivilege;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Date getAccountDate() {
        return accountDate;
    }

    public void setAccountDate(Date accountDate) {
        this.accountDate = accountDate;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public Integer getSystemView() {
        return systemView;
    }

    public void setSystemView(Integer systemView) {
        this.systemView = systemView;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adminUserId != null ? adminUserId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdminUser)) {
            return false;
        }
        AdminUser other = (AdminUser) object;
        if ((this.adminUserId == null && other.adminUserId != null) || (this.adminUserId != null && !this.adminUserId.equals(other.adminUserId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sabonay.ejb.entities.generated.AdminUser[ adminUserId=" + adminUserId + " ]";
    }
    
}
