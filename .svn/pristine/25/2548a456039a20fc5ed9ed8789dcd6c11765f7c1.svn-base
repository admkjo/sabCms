/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sabonay.cms.web.controller;

import com.sabonay.cms.web.common.utilities.JSFUtility;
import com.sabonay.ejb.common.CMSDataSource;
import com.sabonay.ejb.entities.generated.Category;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author emma
 */
@Named
@ViewScoped
public class CategoryController implements Serializable {

    private List<Category> contents = new ArrayList<>();
    private Category category = new Category();
    private String userPassword = null;
    private boolean inEditMode = false;
    private boolean formShow = false;
    private String categoryBody = "";

    public void editCategory() {
        inEditMode = true;
//        category = category.getPcategory();
        formShow = true;

    }

    public void addNewCategory() {
        inEditMode = false;
        category = new Category();
        formShow = true;
    }

    public void saveCategory() {
        if (!inEditMode) {
            //Add New

            CMSDataSource.dataSource().categoryCreate(category);
                        JSFUtility.errorMessage("Category has been added.");

        } else {

            CMSDataSource.dataSource().categoryUpdate(category);
                                    JSFUtility.errorMessage("Category has been updated.");

        }
        reset();
    }

    public void deleteCategory() {
        CMSDataSource.dataSource().categoryDelete(category);
                                JSFUtility.errorMessage("Category has been deleted.");

        reset();
    }

    public void saveResource() {
//        if (!inEditMode){
//            //Add New
//            user.setUserPassword(SecurityHash.MD5HashEncryption(userPassword)); 
//            user.setAccountDate(Calendar.getInstance().getTime());
//            CMSDataSource.dataSource().adminUserCreate(user);
//            
//        }else{
//            if (!userPassword.trim().isEmpty()) {
//                user.setUserPassword(SecurityHash.MD5HashEncryption(userPassword));
//            }
//            CMSDataSource.dataSource().adminUserUpdate(user);
//        }
//        reset();
    }

    public void deleteResource() {
        reset();
    }

    public void reset() {
        category = new Category();
        inEditMode = false;
        userPassword = null;
    }
    
    

    public boolean isInEditMode() {
        return inEditMode;
    }

    public String getListType(){
        CMSDataSource.dataSource().categoryFindByAttribute("parent_id", 1, categoryBody);
        return "yes";
    }
//    public String parent(String cattype, Integer catid) {
//        if ("cat".equals(cattype)) {
//            Category c = CMSDataSource.dataSource().categoryFind(catid);
//            return c != null ? c.getCategoryName() : "";
//        } else {
//            Category c = CMSDataSource.dataSource().categoryFind(catid);
//            return c != null ? c.getPtitle() : "";
//        }
//    }

    public void setInEditMode(boolean inEditMode) {
        this.inEditMode = inEditMode;
    }

    public List<Category> getCategories() {
        contents = CMSDataSource.dataSource().categoryGetAll();
        return contents;
    }

    public boolean isFormShow() {
        return formShow;
    }

    public void setFormShow(boolean formShow) {
        this.formShow = formShow;
    }
    

    public void setCategories(List<Category> contents) {
        this.contents = contents;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getCategoryBody() {
        return categoryBody;
    }

    public void setCategoryBody(String contentBody) {
        this.categoryBody = categoryBody;
    }
}
