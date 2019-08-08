/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sabonay.cms.web.controller;


import com.sabonay.cms.web.common.ApplicationConstant;
import com.sabonay.cms.web.common.utilities.JSFUtility;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
 
/**
 *
 * @author emma
 */
@ManagedBean
@RequestScoped
public class LanguageSelectorController implements Serializable {
    
    private String userSelectedLanguage;
    /** Creates a new instance of LanguageSelectorController */
    public LanguageSelectorController() {
    }
    
    public String selectLanguage(String language){
        
        
        String lang  = JSFUtility.checkLanguage(language);
        
        JSFUtility.putSessionValue(ApplicationConstant.USER_LANGUAGE, lang);
        
        String outcome = JSFUtility.pageFullPath();
        
        outcome= outcome+ApplicationConstant.FACES_REDIRECT;
        //System.out.println("Page To Go : "+outcome);
        return outcome;
    
    }

    /**
     * @return the userSelectedLanguage
     */
    public String getUserSelectedLanguage() {
        try {
              userSelectedLanguage =JSFUtility.browserLocale();
        } catch (Exception e) {
            userSelectedLanguage =  ApplicationConstant.ENGLISH;
        }
      
        return userSelectedLanguage;
    }

    /**
     * @param userSelectedLanguage the userSelectedLanguage to set
     */
    public void setUserSelectedLanguage(String userSelectedLanguage) {
        this.userSelectedLanguage = userSelectedLanguage;
    }
}
