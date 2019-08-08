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
 * @author thony
 */
@Entity
@Table(name = "search_item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SearchItem.findAll", query = "SELECT s FROM SearchItem s"),
    @NamedQuery(name = "SearchItem.findBySearchItemId", query = "SELECT s FROM SearchItem s WHERE s.searchItemId = :searchItemId"),
    @NamedQuery(name = "SearchItem.findBySearchParam", query = "SELECT s FROM SearchItem s WHERE s.searchParam = :searchParam"),
    @NamedQuery(name = "SearchItem.findByMatchFound", query = "SELECT s FROM SearchItem s WHERE s.matchFound = :matchFound"),
    @NamedQuery(name = "SearchItem.findByDateMade", query = "SELECT s FROM SearchItem s WHERE s.dateMade = :dateMade"),
    @NamedQuery(name = "SearchItem.findBySiteId", query = "SELECT s FROM SearchItem s WHERE s.siteId = :siteId"),
    @NamedQuery(name = "SearchItem.findByUpdated", query = "SELECT s FROM SearchItem s WHERE s.updated = :updated"),
    @NamedQuery(name = "SearchItem.findByDeleted", query = "SELECT s FROM SearchItem s WHERE s.deleted = :deleted")})
public class SearchItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "search_item_id")
    private Integer searchItemId;
    @Size(max = 50)
    @Column(name = "search_param")
    private String searchParam;
    @Size(max = 50)
    @Column(name = "match_found")
    private String matchFound;
    @Column(name = "date_made")
    @Temporal(TemporalType.DATE)
    private Date dateMade;
    @Column(name = "site_id")
    private Integer siteId;
    @Size(max = 50)
    @Column(name = "updated")
    private String updated;
    @Size(max = 50)
    @Column(name = "deleted")
    private String deleted;

    public SearchItem() {
    }

    public SearchItem(Integer searchItemId) {
        this.searchItemId = searchItemId;
    }

    public Integer getSearchItemId() {
        return searchItemId;
    }

    public void setSearchItemId(Integer searchItemId) {
        this.searchItemId = searchItemId;
    }

    public String getSearchParam() {
        return searchParam;
    }

    public void setSearchParam(String searchParam) {
        this.searchParam = searchParam;
    }

    public String getMatchFound() {
        return matchFound;
    }

    public void setMatchFound(String matchFound) {
        this.matchFound = matchFound;
    }

    public Date getDateMade() {
        return dateMade;
    }

    public void setDateMade(Date dateMade) {
        this.dateMade = dateMade;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
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
        hash += (searchItemId != null ? searchItemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SearchItem)) {
            return false;
        }
        SearchItem other = (SearchItem) object;
        if ((this.searchItemId == null && other.searchItemId != null) || (this.searchItemId != null && !this.searchItemId.equals(other.searchItemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sabonay.ejb.entities.generated.SearchItem[ searchItemId=" + searchItemId + " ]";
    }
    
}
