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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adm-Kjo
 */
@Entity
@Table(name = "content")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Content.findAll", query = "SELECT c FROM Content c"),
    @NamedQuery(name = "Content.findByContentId", query = "SELECT c FROM Content c WHERE c.contentId = :contentId"),
    @NamedQuery(name = "Content.findByKeywords", query = "SELECT c FROM Content c WHERE c.keywords = :keywords"),
    @NamedQuery(name = "Content.findByPtitle", query = "SELECT c FROM Content c WHERE c.ptitle = :ptitle"),
    @NamedQuery(name = "Content.findByPbanner", query = "SELECT c FROM Content c WHERE c.pbanner = :pbanner"),
    @NamedQuery(name = "Content.findByCategoryid", query = "SELECT c FROM Content c WHERE c.categoryid = :categoryid"),
    @NamedQuery(name = "Content.findByDatecreated", query = "SELECT c FROM Content c WHERE c.datecreated = :datecreated"),
    @NamedQuery(name = "Content.findByLastmodified", query = "SELECT c FROM Content c WHERE c.lastmodified = :lastmodified"),
    @NamedQuery(name = "Content.findByIspublished", query = "SELECT c FROM Content c WHERE c.ispublished = :ispublished"),
    @NamedQuery(name = "Content.findByUrl", query = "SELECT c FROM Content c WHERE c.url = :url"),
    @NamedQuery(name = "Content.findBySource", query = "SELECT c FROM Content c WHERE c.source = :source"),
    @NamedQuery(name = "Content.findByDirectlink", query = "SELECT c FROM Content c WHERE c.directlink = :directlink"),
    @NamedQuery(name = "Content.findByPagehits", query = "SELECT c FROM Content c WHERE c.pagehits = :pagehits"),
    @NamedQuery(name = "Content.findByCattype", query = "SELECT c FROM Content c WHERE c.cattype = :cattype")})
public class Content implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "content_id")
    private Integer contentId;
    @Size(max = 255)
    @Column(name = "keywords")
    private String keywords;
    @Size(max = 255)
    @Column(name = "ptitle")
    private String ptitle;
    @Lob
    @Size(max = 65535)
    @Column(name = "pcontent")
    private String pcontent;
    @Column(name = "pbanner")
    private Integer pbanner;
    @Column(name = "categoryid")
    private Integer categoryid;
    @Column(name = "datecreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datecreated;
    @Column(name = "lastmodified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastmodified;
    @Size(max = 15)
    @Column(name = "ispublished")
    private String ispublished;
    @Size(max = 16)
    @Column(name = "url")
    private String url;
    @Size(max = 255)
    @Column(name = "source")
    private String source;
    @Size(max = 255)
    @Column(name = "directlink")
    private String directlink;
    @Lob
    @Size(max = 65535)
    @Column(name = "extracode")
    private String extracode;
    @Column(name = "pagehits")
    private Integer pagehits;
    @Size(max = 4)
    @Column(name = "cattype")
    private String cattype;

    public Content() {
    }

    public Content(Integer contentId) {
        this.contentId = contentId;
    }

    public Integer getContentId() {
        return contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getPtitle() {
        return ptitle;
    }

    public void setPtitle(String ptitle) {
        this.ptitle = ptitle;
    }

    public String getPcontent() {
        return pcontent;
    }

    public void setPcontent(String pcontent) {
        this.pcontent = pcontent;
    }

    public Integer getPbanner() {
        return pbanner;
    }

    public void setPbanner(Integer pbanner) {
        this.pbanner = pbanner;
    }

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public Date getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }

    public Date getLastmodified() {
        return lastmodified;
    }

    public void setLastmodified(Date lastmodified) {
        this.lastmodified = lastmodified;
    }

    public String getIspublished() {
        return ispublished;
    }

    public void setIspublished(String ispublished) {
        this.ispublished = ispublished;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDirectlink() {
        return directlink;
    }

    public void setDirectlink(String directlink) {
        this.directlink = directlink;
    }

    public String getExtracode() {
        return extracode;
    }

    public void setExtracode(String extracode) {
        this.extracode = extracode;
    }

    public Integer getPagehits() {
        return pagehits;
    }

    public void setPagehits(Integer pagehits) {
        this.pagehits = pagehits;
    }

    public String getCattype() {
        return cattype;
    }

    public void setCattype(String cattype) {
        this.cattype = cattype;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contentId != null ? contentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Content)) {
            return false;
        }
        Content other = (Content) object;
        if ((this.contentId == null && other.contentId != null) || (this.contentId != null && !this.contentId.equals(other.contentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sabonay.ejb.entities.generated.Content[ contentId=" + contentId + " ]";
    }
    
}
