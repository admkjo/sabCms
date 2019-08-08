/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sabonay.cms.web.common;

/*
 * SmtpAuthenticator.java
 *
 * Created on March 17, 2006, 11:47 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 *
 * Required by SendMail for mail servers that needs authentication
 * even before they send/forward emails on their client's behalf.
 */
import javax.mail.*;

/**
 *
 * @author agyepong
 */
public class SmtpAuthenticator extends Authenticator {
    private java.lang.String userName;
    private java.lang.String password;
    
    /** Creates a new instance of PopupAuthenticator */
    public SmtpAuthenticator() {
    }

    public SmtpAuthenticator( java.lang.String userName, java.lang.String password ) {
        this.userName = userName;
        this.password = password;
                System.out.println("Auth: "+ password+ " "+userName);

    }
    
    @Override
    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication( userName, password );
    }
    
}
