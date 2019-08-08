/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sabonay.cms.web.common;

import com.sabonay.cms.web.common.utilities.JSFUtility;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author emma
 */
@ManagedBean
@RequestScoped
public class AdminAccessController {

    /**
     * Creates a new instance of OperatorAccessController
     */
    public AdminAccessController() {
    }

    private boolean isLogin = false;
    private boolean isAdmin = false;
    private boolean isComplainOnly = false;
    private LoginUser loginUser = null;
    private boolean subUser = false;
    private String loginUsername = "";

    /**
     * Creates a new instance of UserAccessController
     */
    /**
     * @return the isLogin
     */
    public boolean isIsLogin() {

        LoginUser user = getLoginUser();
        if (user == null) {
            isLogin = false;
        } else {
            isLogin = user.isIsLogin();
        }

        return isLogin;
    }

    /**
     * @param isLogin the isLogin to set
     */
    public void setIsLogin(boolean isLogin) {
        this.isLogin = isLogin;
    }

    /**
     * @return the isAdmin
     */
    public boolean isIsAdmin() {
        String isit = (String) JSFUtility.getSessionValue(ApplicationConstant.IS_ADMIN);

           if(isit.equalsIgnoreCase("admin")) {
            isAdmin = true;
        }else if(isit.equalsIgnoreCase("pro")) {
            isAdmin = false;
        } 
           
        return isAdmin;
    }

    /**
     * @param isAdmin the isAdmin to set
     */
    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    /**
     * @return the loginUser
     */
    public LoginUser getLoginUser() {
        try {
            loginUser = (LoginUser) JSFUtility.getSessionValue(ApplicationConstant.ADMIN_USER);
        } catch (Exception e) {
            loginUser = null;
        }
        return loginUser;
    }

    /**
     * @param loginUser the loginUser to set
     */
    public void setLoginUser(LoginUser loginUser) {
        this.loginUser = loginUser;
    }

    /**
     * @return the isComplainOnly
     */
    /**
     * @param isComplainOnly the isComplainOnly to set
     */
    public void setIsComplainOnly(boolean isComplainOnly) {
        this.isComplainOnly = isComplainOnly;
    }

    /**
     * @return the subUser
     */
    /**
     * @param subUser the subUser to set
     */
    public void setSubUser(boolean subUser) {
        this.subUser = subUser;
    }

    /**
     * @return the loginUsername
     */
    public String getLoginUsername() {
        try {

            LoginUser user = getLoginUser();
            loginUsername = user.getUserScreenName();
        } catch (Exception e) {
        }
        return loginUsername;
    }

    /**
     * @param loginUsername the loginUsername to set
     */
    public void setLoginUsername(String loginUsername) {
        this.loginUsername = loginUsername;
    }

}

//<!--                            <li class="rlink square-border">
//                                <ul id="countrytabs" class="shadetabs">
//                                    <h:outputText value="#{commonQuery.listCategoryDataTab(23, false, false)}" escape="false"/>
//                                                                        <li><a href="#" rel="country1" class="selected">Tab 1</a></li>
//                                                                        <li><a href="#" rel="country2">Tab 2</a></li>
//                                                                        <li><a href="#" rel="country3">Tab 3</a></li>
//                                </ul>
//                                <div style="margin-bottom: 1em; padding: 10px" class="border">
//                                    <div id="tcont1" class="tabcontent">
//                                        Tab content 1 here<br />Tab content 1 here<br />
//                                    </div>
//
//                                    <div id="tcont2" class="tabcontent">
//                                        Tab content 2 here<br />Tab content 2 here<br />
//                                    </div>
//
//                                    <div id="tcont3" class="tabcontent">
//                                        Tab content 3 here<br />Tab content 3 here<br />
//                                    </div>
//                                </div>
//                            </li>-->
