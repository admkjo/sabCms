/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sabonay.ejb.entities.generated;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adm-Kjo
 */
@Entity
@Table(name = "content_resource")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContentResource.findAll", query = "SELECT c FROM ContentResource c"),
    @NamedQuery(name = "ContentResource.findByResourceid", query = "SELECT c FROM ContentResource c WHERE c.resourceid = :resourceid"),
    @NamedQuery(name = "ContentResource.findByContentid", query = "SELECT c FROM ContentResource c WHERE c.contentid = :contentid"),
    @NamedQuery(name = "ContentResource.findByDatecreated", query = "SELECT c FROM ContentResource c WHERE c.datecreated = :datecreated"),
    @NamedQuery(name = "ContentResource.findByResourceorder", query = "SELECT c FROM ContentResource c WHERE c.resourceorder = :resourceorder")})
public class ContentResource implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "resourceid")
    private Integer resourceid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "contentid")
    private int contentid;
    @Column(name = "datecreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datecreated;
    @Column(name = "resourceorder")
    private Integer resourceorder;

    public ContentResource() {
    }

    public ContentResource(Integer resourceid) {
        this.resourceid = resourceid;
    }

    public ContentResource(Integer resourceid, int contentid) {
        this.resourceid = resourceid;
        this.contentid = contentid;
    }

    public Integer getResourceid() {
        return resourceid;
    }

    public void setResourceid(Integer resourceid) {
        this.resourceid = resourceid;
    }

    public int getContentid() {
        return contentid;
    }

    public void setContentid(int contentid) {
        this.contentid = contentid;
    }

    public Date getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }

    public Integer getResourceorder() {
        return resourceorder;
    }

    public void setResourceorder(Integer resourceorder) {
        this.resourceorder = resourceorder;
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
        if (!(object instanceof ContentResource)) {
            return false;
        }
        ContentResource other = (ContentResource) object;
        if ((this.resourceid == null && other.resourceid != null) || (this.resourceid != null && !this.resourceid.equals(other.resourceid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sabonay.ejb.entities.generated.ContentResource[ resourceid=" + resourceid + " ]";
    }
    
}
