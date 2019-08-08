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
 * @author thony
 */
@Entity
@Table(name = "settings")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Settings.findAll", query = "SELECT s FROM Settings s"),
    @NamedQuery(name = "Settings.findBySettingsId", query = "SELECT s FROM Settings s WHERE s.settingsId = :settingsId"),
    @NamedQuery(name = "Settings.findBySettingname", query = "SELECT s FROM Settings s WHERE s.settingname = :settingname"),
    @NamedQuery(name = "Settings.findBySettingView", query = "SELECT s FROM Settings s WHERE s.settingView = :settingView")})
public class Settings implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "settings_id")
    private String settingsId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "settingname")
    private String settingname;
    @Lob
    @Size(max = 65535)
    @Column(name = "settingvalue")
    private String settingvalue;
    @Column(name = "setting_view")
    private Character settingView;

    public Settings() {
    }

    public Settings(String settingsId) {
        this.settingsId = settingsId;
    }

    public Settings(String settingsId, String settingname) {
        this.settingsId = settingsId;
        this.settingname = settingname;
    }

    public String getSettingsId() {
        return settingsId;
    }

    public void setSettingsId(String settingsId) {
        this.settingsId = settingsId;
    }

    public String getSettingname() {
        return settingname;
    }

    public void setSettingname(String settingname) {
        this.settingname = settingname;
    }

    public String getSettingvalue() {
        return settingvalue;
    }

    public void setSettingvalue(String settingvalue) {
        this.settingvalue = settingvalue;
    }

    public Character getSettingView() {
        return settingView;
    }

    public void setSettingView(Character settingView) {
        this.settingView = settingView;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (settingsId != null ? settingsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Settings)) {
            return false;
        }
        Settings other = (Settings) object;
        if ((this.settingsId == null && other.settingsId != null) || (this.settingsId != null && !this.settingsId.equals(other.settingsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sabonay.ejb.entities.generated.Settings[ settingsId=" + settingsId + " ]";
    }
    
}
