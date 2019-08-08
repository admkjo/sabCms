/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sabonay.cms.web.controller;

import com.sabonay.cms.web.common.ApplicationConstant;
import com.sabonay.cms.web.common.LoginUser;
import com.sabonay.cms.web.common.utilities.JSFUtility;
import com.sabonay.cms.web.common.utilities.SecurityHash;
import java.io.Serializable;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.TimeZone;
import javax.el.ELContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author emma
 */
@ManagedBean
@RequestScoped
public class userLogin implements Serializable {

    private String username;
    private String password;
    private String email;
    ELContext elContext = FacesContext.getCurrentInstance().getELContext();
    private CommonQuery commonQuery;

    /**
     * Creates a new instance of UserLogin
     */
    public userLogin() {
        commonQuery = (CommonQuery) FacesContext.getCurrentInstance().getApplication()
                .getELResolver().getValue(elContext, null, "commonQuery");
    }

    public String adminLogin() {
        try {
            if ("".equals(username) || "".equals(password)) {
                JSFUtility.warnMessage(JSFUtility.getResourceBundleKeyValue("USERNAME_PASSWORD_REQUIRED"));
                return "index.xhtml";

            }
            String pwd = SecurityHash.MD5HashEncryption(password);
            ResultSet rs = commonQuery.adminUserLogin(username, pwd);
            if (null == rs) {
                JSFUtility.errorMessage(JSFUtility.getResourceBundleKeyValue("WRONG_LOGIN"));
                return "index.xhtml";
            } else {
                LoginUser user = new LoginUser();
                user.setAccessFor(rs.getString("access_level"));
                user.setUserLogin(rs.getString(4));
                user.setUserScreenName(rs.getString("username"));
                user.setLoginTime(Calendar.getInstance(TimeZone.getTimeZone("GMT")).getTime());
                user.setIsAdmin(true);
                user.setIsLogin(true);

                JSFUtility.putSessionValue(ApplicationConstant.ADMIN_USER, user);
                JSFUtility.putSessionValue(ApplicationConstant.IS_ADMIN, rs.getString(4));
                return "dashboard.xhtml" + ApplicationConstant.FACES_REDIRECT;
            }
        } catch (Exception e) {
            JSFUtility.warnMessage(JSFUtility.getResourceBundleKeyValue("WRONG_LOGIN"));
            return "index.xhtml";
        }

        //return null;
    }

    public String logoutClient() {
        JSFUtility.putSessionValue(ApplicationConstant.LOGIN_USER, null);
        JSFUtility.destroySession();
        return "index.xhtml" + ApplicationConstant.FACES_REDIRECT;
    }

    public String redirectPage(String url) {
        if (url.equals("password")) {
            return "password.xhtml" + ApplicationConstant.FACES_REDIRECT;
        } else if (url.equals("user")) {
            return "member-account.xhtml" + ApplicationConstant.FACES_REDIRECT;
        } else if (url.equals("joinnow")) {
            return "register.xhtml" + ApplicationConstant.FACES_REDIRECT;
        } else if (url.equals("upgradenow")) {
            return "upgrade.xhtml" + ApplicationConstant.FACES_REDIRECT;
        } else if (url.equals("fcp-reg")) {
            return "fcp-reg.xhtml" + ApplicationConstant.FACES_REDIRECT;
        } else if (url.equals("bank-reg")) {
            return "bank-reg.xhtml" + ApplicationConstant.FACES_REDIRECT;
        } else if (url.equals("bank-upg")) {
            return "bank-upg.xhtml" + ApplicationConstant.FACES_REDIRECT;
        } else if (url.equals("fcp-upg")) {
            return "fcp-upg.xhtml" + ApplicationConstant.FACES_REDIRECT;
        } else if (url.equals("dl")) {
            return "downlines.xhtml?faces-redirect=true";
            //return "dl.xhtml?faces-redirect=true&appl=60c&cmm=" + SCapitalUtils.loggedinCapitalMember().getMobileNumber();
        } else if (url.equals("urb")) {
            return "benefit-and-investment.xhtml" + ApplicationConstant.FACES_REDIRECT;
        } else if (url.equals("acc")) {
            return "account-transaction.xhtml" + ApplicationConstant.FACES_REDIRECT;
        }

        return "";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
