/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sabonay.cms.web.controller;

import com.sabonay.cms.web.common.utilities.JSFUtility;
import com.sabonay.ejb.common.CMSDataSource;
import com.sabonay.ejb.entities.generated.Settings;
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
public class SettingController implements Serializable{
    private List<Settings> settings = new ArrayList<>();
    private Settings setting = new Settings();
    private boolean inEditMode = false;

    
    public void editSetting(){
        inEditMode = true;
    }
    
    public void saveSetting(){
        if (!inEditMode){
            //Add New
            JSFUtility.errorMessage("New Settings Cannot be added.");
            
        }else{
            CMSDataSource.dataSource().settingsUpdate(setting);
            JSFUtility.infoMessage("Setting has been updated");
        }
        reset();
    }
    
    public void deleteSetting(){
        inEditMode = false;
    }
    
    public void reset(){
        setting = setting = new Settings();
        inEditMode = false;
    }
    
    public List<Settings> getSettings() {
        settings = CMSDataSource.dataSource().settingGetAll();
        return settings;
    }

    public void setSettings(List<Settings> settings) {
        this.settings = settings;
    }

    public Settings getSetting() {
        return setting;
    }

    public void setSetting(Settings setting) {
        this.setting = setting;
    }

    public boolean isInEditMode() {
        return inEditMode;
    }

    public void setInEditMode(boolean inEditMode) {
        this.inEditMode = inEditMode;
    }
}
