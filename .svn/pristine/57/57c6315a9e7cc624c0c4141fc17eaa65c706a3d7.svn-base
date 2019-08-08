/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sabonay.ejb.entities.generated;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adm-Kjo
 */
@Entity
@Table(name = "resources")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resources.findAll", query = "SELECT r FROM Resources r"),
    @NamedQuery(name = "Resources.findByResourceid", query = "SELECT r FROM Resources r WHERE r.resourceid = :resourceid"),
    @NamedQuery(name = "Resources.findByCategory", query = "SELECT r FROM Resources r WHERE r.category = :category"),
    @NamedQuery(name = "Resources.findByResourceurl", query = "SELECT r FROM Resources r WHERE r.resourceurl = :resourceurl"),
    @NamedQuery(name = "Resources.findByIspublished", query = "SELECT r FROM Resources r WHERE r.ispublished = :ispublished"),
    @NamedQuery(name = "Resources.findBySource", query = "SELECT r FROM Resources r WHERE r.source = :source")})
public class Resources implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "resourceid")
    private Integer resourceid;
    @Column(name = "category")
    private Integer category;
    @Size(max = 255)
    @Column(name = "resourceurl")
    private String resourceurl;
    @Lob
    @Size(max = 65535)
    @Column(name = "resourcedesc")
    private String resourcedesc;
    @Column(name = "ispublished")
    private Integer ispublished;
    @Size(max = 100)
    @Column(name = "source")
    private String source;
    @Lob
    @Size(max = 65535)
    @Column(name = "otherattri")
    private String otherattri;

    public Resources() {
    }

    public Resources(Integer resourceid) {
        this.resourceid = resourceid;
    }

    public Integer getResourceid() {
        return resourceid;
    }

    public void setResourceid(Integer resourceid) {
        this.resourceid = resourceid;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getResourceurl() {
        return resourceurl;
    }

    public void setResourceurl(String resourceurl) {
        this.resourceurl = resourceurl;
    }

    public String getResourcedesc() {
        return resourcedesc;
    }

    public void setResourcedesc(String resourcedesc) {
        this.resourcedesc = resourcedesc;
    }

    public Integer getIspublished() {
        return ispublished;
    }

    public void setIspublished(Integer ispublished) {
        this.ispublished = ispublished;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getOtherattri() {
        return otherattri;
    }

    public void setOtherattri(String otherattri) {
        this.otherattri = otherattri;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (resourceid != null ? resourceid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resources)) {
            return false;
        }
        Resources other = (Resources) object;
        if ((this.resourceid == null && other.resourceid != null) || (this.resourceid != null && !this.resourceid.equals(other.resourceid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sabonay.ejb.entities.generated.Resources[ resourceid=" + resourceid + " ]";
    }
    
}
