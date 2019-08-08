/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sabonay.cms.web.controller;

import com.sabonay.cms.web.common.SendEmail;
import com.sabonay.cms.web.common.SendEmailDetail;
import com.sabonay.cms.web.common.utilities.JSFUtility;
import java.io.Serializable;
import java.sql.SQLException;
import javax.inject.Named;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

/**
 *
 * @author Yaw
 * 
 * Notes: Add in functionality where bean can change 
 * who to send the email to, dynamically.
 */
@Named(value = "contactBean")
@javax.faces.bean.RequestScoped
public class ContactBean implements Serializable{
    
    SendEmailDetail sed;
    boolean showEmail = true;

    /** Creates a new instance of ContactBean */
    public ContactBean() 
    {
    }

    public boolean isShowEmail() 
    {
        return showEmail;
    }

    public void setShowEmail(boolean showEmail) 
    {
        this.showEmail = showEmail;
    }
    
    
    
    public void setEmailTo(String EmailTo)
    {
        
    }
    
    public SendEmailDetail getSelected()
    {
        if(sed == null)
        {
            sed = new SendEmailDetail();
        }
        
        return sed;
    }

    public String send() throws SQLException
    {
        String message = "", outcome = "";        
        
        if(isShowEmail() == true)
        {
            message = "Email: " + getSelected().getEmailfrom() + "\n" + getSelected().getContent();
        }
        else if(isShowEmail() == false)   
        {
            message = getSelected().getContent();
        }
        
        try  
        {
            new SendEmail().send(getSelected().getEmailfrom(), "info@ama.gov.gh", getSelected().getSubject(), message, null);
            outcome = "feedbackreceived";
        }
        catch(AddressException ae)
        {
            JSFUtility.errorMessage("Email could not be sent. Address may be incorrect.");
        }
        catch(MessagingException me)
        {
            JSFUtility.errorMessage("Email could not be sent. Something may be wrong with the message.");
        }
        
        //Add FacesMessage/Growl/whatever
        return outcome;
    }
    
}
