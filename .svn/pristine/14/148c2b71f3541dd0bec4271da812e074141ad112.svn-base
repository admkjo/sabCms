/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sabonay.ejb.common;

import com.sabonay.ejb.sessionbean.CMSSessionBean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author emma
 */
public class CMSDataSource {
    public static CMSSessionBean session;
    static String JNDI_APPL_SESSION = "java:global/ama/CMSSessionBean";
    static String APPL_SESSION_BEAN_FULL_PATH = "com.sabonay.ejb.sessionbean.CMSSessionBean";

    public static CMSSessionBean dataSource() {

        if (session != null) {
            return session;
        }
        try {
            Context context = new InitialContext();
            session = (CMSSessionBean) context.lookup(JNDI_APPL_SESSION+"!"+APPL_SESSION_BEAN_FULL_PATH);
            return session;
        } catch (NamingException ne) {
            //dataSource();
            ne.printStackTrace();
            System.out.println("Error During Invocation "+ne.toString());
            dataSource();
            Logger.getLogger(CMSSessionBean.class.getName()).log(Level.SEVERE, "exception caught during invocation", ne);
            throw new RuntimeException(ne);

        }

    }
}
