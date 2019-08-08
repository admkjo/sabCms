/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sabonay.cms.web.controller;

import com.sabonay.cms.web.common.utilities.JSFUtility;
import com.sabonay.ejb.common.CMSDataSource;
import com.sabonay.ejb.entities.generated.Resources;
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
public class ResourcesController implements Serializable {

    private List<Resources> resources = new ArrayList<>();
    private Resources resource = new Resources();

    private boolean inEditMode = false;

    public void editResource() {
        inEditMode = true;
    }

    public void saveResource() {
        if (!inEditMode) {
            //Add New

            CMSDataSource.dataSource().resourcesCreate(resource);
            JSFUtility.infoMessage("Resource has been saved.");

        } else {

            CMSDataSource.dataSource().resourcesUpdate(resource);
            JSFUtility.infoMessage("Resource has been updated.");

        }
        reset();
    }

    public void deleteResource() {
        CMSDataSource.dataSource().resourcesDelete(resource);
        JSFUtility.infoMessage("Resource has been deleted.");

        reset();
    }

    public void reset() {
        resource = new Resources();
        inEditMode = false;

    }

    public boolean isInEditMode() {
        return inEditMode;
    }

    public void setInEditMode(boolean inEditMode) {
        this.inEditMode = inEditMode;
    }

    public List<Resources> getResources() {
        resources = CMSDataSource.dataSource().resourcesGetAll();
        return resources;
    }

    public void setResources(List<Resources> resources) {
        this.resources = resources;
    }

    public Resources getResource() {
        return resource;
    }

    public void setResource(Resources resource) {
        this.resource = resource;
    }
}
