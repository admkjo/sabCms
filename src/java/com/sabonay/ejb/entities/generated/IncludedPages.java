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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adm-Kjo
 */
@Entity
@Table(name = "included_pages")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IncludedPages.findAll", query = "SELECT i FROM IncludedPages i"),
    @NamedQuery(name = "IncludedPages.findByIpageid", query = "SELECT i FROM IncludedPages i WHERE i.ipageid = :ipageid"),
    @NamedQuery(name = "IncludedPages.findByPageloc", query = "SELECT i FROM IncludedPages i WHERE i.pageloc = :pageloc"),
    @NamedQuery(name = "IncludedPages.findByContentid", query = "SELECT i FROM IncludedPages i WHERE i.contentid = :contentid")})
public class IncludedPages implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ipageid")
    private Integer ipageid;
    @Size(max = 255)
    @Column(name = "pageloc")
    private String pageloc;
    @Size(max = 255)
    @Column(name = "contentid")
    private String contentid;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;

    public IncludedPages() {
    }

    public IncludedPages(Integer ipageid) {
        this.ipageid = ipageid;
    }

    public Integer getIpageid() {
        return ipageid;
    }

    public void setIpageid(Integer ipageid) {
        this.ipageid = ipageid;
    }

    public String getPageloc() {
        return pageloc;
    }

    public void setPageloc(String pageloc) {
        this.pageloc = pageloc;
    }

    public String getContentid() {
        return contentid;
    }

    public void setContentid(String contentid) {
        this.contentid = contentid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ipageid != null ? ipageid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IncludedPages)) {
            return false;
        }
        IncludedPages other = (IncludedPages) object;
        if ((this.ipageid == null && other.ipageid != null) || (this.ipageid != null && !this.ipageid.equals(other.ipageid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sabonay.ejb.entities.generated.IncludedPages[ ipageid=" + ipageid + " ]";
    }
    
}
