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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adm-Kjo
 */
@Entity
@Table(name = "quick_links")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QuickLinks.findAll", query = "SELECT q FROM QuickLinks q"),
    @NamedQuery(name = "QuickLinks.findByLinkId", query = "SELECT q FROM QuickLinks q WHERE q.linkId = :linkId"),
    @NamedQuery(name = "QuickLinks.findByLinkName", query = "SELECT q FROM QuickLinks q WHERE q.linkName = :linkName"),
    @NamedQuery(name = "QuickLinks.findByLinkUrl", query = "SELECT q FROM QuickLinks q WHERE q.linkUrl = :linkUrl"),
    @NamedQuery(name = "QuickLinks.findByLinkTarget", query = "SELECT q FROM QuickLinks q WHERE q.linkTarget = :linkTarget"),
    @NamedQuery(name = "QuickLinks.findByLastModifiedBy", query = "SELECT q FROM QuickLinks q WHERE q.lastModifiedBy = :lastModifiedBy"),
    @NamedQuery(name = "QuickLinks.findByLastModifiedDate", query = "SELECT q FROM QuickLinks q WHERE q.lastModifiedDate = :lastModifiedDate"),
    @NamedQuery(name = "QuickLinks.findByUpdated", query = "SELECT q FROM QuickLinks q WHERE q.updated = :updated"),
    @NamedQuery(name = "QuickLinks.findByDeleted", query = "SELECT q FROM QuickLinks q WHERE q.deleted = :deleted")})
public class QuickLinks implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "link_id")
    private Integer linkId;
    @Size(max = 225)
    @Column(name = "link_name")
    private String linkName;
    @Size(max = 225)
    @Column(name = "link_url")
    private String linkUrl;
    @Size(max = 79)
    @Column(name = "link_target")
    private String linkTarget;
    @Size(max = 79)
    @Column(name = "last_modified_by")
    private String lastModifiedBy;
    @Column(name = "last_modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    @Size(max = 15)
    @Column(name = "updated")
    private String updated;
    @Size(max = 15)
    @Column(name = "deleted")
    private String deleted;

    public QuickLinks() {
    }

    public QuickLinks(Integer linkId) {
        this.linkId = linkId;
    }

    public Integer getLinkId() {
        return linkId;
    }

    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getLinkTarget() {
        return linkTarget;
    }

    public void setLinkTarget(String linkTarget) {
        this.linkTarget = linkTarget;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (linkId != null ? linkId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuickLinks)) {
            return false;
        }
        QuickLinks other = (QuickLinks) object;
        if ((this.linkId == null && other.linkId != null) || (this.linkId != null && !this.linkId.equals(other.linkId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sabonay.ejb.entities.generated.QuickLinks[ linkId=" + linkId + " ]";
    }
    
}
