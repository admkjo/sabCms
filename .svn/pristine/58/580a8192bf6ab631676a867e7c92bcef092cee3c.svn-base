/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sabonay.cms.web.controller;

import com.sabonay.cms.web.common.utilities.JSFUtility;
import com.sabonay.cms.web.common.utilities.SecurityHash;
import com.sabonay.ejb.common.CMSDataSource;
import com.sabonay.ejb.entities.generated.AdminUser;
import com.sabonay.ejb.entities.generated.Settings;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author emma
 */
@Named
@ViewScoped
public class UserController implements Serializable {

    private List<AdminUser> users = new ArrayList<>();
    private AdminUser user = new AdminUser();
    private String userPassword = null;
    private boolean inEditMode = false;

    public void editAdminUser() {
        inEditMode = true;
    }
    
    public void addNewUser() {
        inEditMode = false;
        user = new AdminUser();

    }

    public void saveAdminUser() {
        if (!inEditMode) {
            //Add New
            user.setSystemView(1);
            user.setSiteId("common");
            user.setUserPrivilege("Content#Category#Resource#Setting#Contact#Users#EmailFriend#5328");
            user.setUserPassword(SecurityHash.MD5HashEncryption(userPassword));
            user.setAccountDate(Calendar.getInstance().getTime());
            CMSDataSource.dataSource().adminUserCreate(user);
                        JSFUtility.infoMessage("User has been added.");

        } else {
            if (!userPassword.trim().isEmpty()) {
                user.setUserPassword(SecurityHash.MD5HashEncryption(userPassword));
            }
            CMSDataSource.dataSource().adminUserUpdate(user);
                                    JSFUtility.infoMessage("User has been updated.");

        }
        reset();
    }

    public void deleteAdminUser() { 
        CMSDataSource.dataSource().adminUserDelete(user);
                                JSFUtility.infoMessage("User has been deleted.");

        reset();
    }

    public void reset() {
        user = new AdminUser();
        inEditMode = false;
        userPassword = null;
    }

    public boolean isInEditMode() {
        return inEditMode;
    }

    public void setInEditMode(boolean inEditMode) {
        this.inEditMode = inEditMode;
    }

    public List<AdminUser> getUsers() {
        users = CMSDataSource.dataSource().adminUserGetAll();
        return users;
    }

    public void setUsers(List<AdminUser> users) {
        this.users = users;
    }

    public AdminUser getUser() {
        return user;
    }

    public void setUser(AdminUser user) {
        this.user = user;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
