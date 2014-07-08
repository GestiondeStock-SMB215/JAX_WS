/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.smb215.entities;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author henry_kozhaya
 */
@Entity
@Table(name = "country")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Country.findAll", query = "SELECT c FROM Country c"),
    @NamedQuery(name = "Country.findByCntId", query = "SELECT c FROM Country c WHERE c.cntId = :cntId"),
    @NamedQuery(name = "Country.findByCntIso", query = "SELECT c FROM Country c WHERE c.cntIso = :cntIso"),
    @NamedQuery(name = "Country.findByCntName", query = "SELECT c FROM Country c WHERE c.cntName = :cntName"),
    @NamedQuery(name = "Country.findByCntNicename", query = "SELECT c FROM Country c WHERE c.cntNicename = :cntNicename"),
    @NamedQuery(name = "Country.findByCntIso3", query = "SELECT c FROM Country c WHERE c.cntIso3 = :cntIso3"),
    @NamedQuery(name = "Country.findByCntNumcode", query = "SELECT c FROM Country c WHERE c.cntNumcode = :cntNumcode"),
    @NamedQuery(name = "Country.findByCntPhonecode", query = "SELECT c FROM Country c WHERE c.cntPhonecode = :cntPhonecode"),
    @NamedQuery(name = "Country.findByCntTimeStamp", query = "SELECT c FROM Country c WHERE c.cntTimeStamp = :cntTimeStamp")})
public class Country implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cnt_id")
    private Integer cntId;
    @Size(max = 2)
    @Column(name = "cnt_iso")
    private String cntIso;
    @Size(max = 80)
    @Column(name = "cnt_name")
    private String cntName;
    @Size(max = 80)
    @Column(name = "cnt_nicename")
    private String cntNicename;
    @Size(max = 3)
    @Column(name = "cnt_iso3")
    private String cntIso3;
    @Column(name = "cnt_numcode")
    private Short cntNumcode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cnt_phonecode")
    private int cntPhonecode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cnt_time_stamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cntTimeStamp;

    public Country() {
    }

    public Country(Integer cntId) {
        this.cntId = cntId;
    }

    public Country(Integer cntId, int cntPhonecode, Date cntTimeStamp) {
        this.cntId = cntId;
        this.cntPhonecode = cntPhonecode;
        this.cntTimeStamp = cntTimeStamp;
    }

    public Integer getCntId() {
        return cntId;
    }

    public void setCntId(Integer cntId) {
        this.cntId = cntId;
    }

    public String getCntIso() {
        return cntIso;
    }

    public void setCntIso(String cntIso) {
        this.cntIso = cntIso;
    }

    public String getCntName() {
        return cntName;
    }

    public void setCntName(String cntName) {
        this.cntName = cntName;
    }

    public String getCntNicename() {
        return cntNicename;
    }

    public void setCntNicename(String cntNicename) {
        this.cntNicename = cntNicename;
    }

    public String getCntIso3() {
        return cntIso3;
    }

    public void setCntIso3(String cntIso3) {
        this.cntIso3 = cntIso3;
    }

    public Short getCntNumcode() {
        return cntNumcode;
    }

    public void setCntNumcode(Short cntNumcode) {
        this.cntNumcode = cntNumcode;
    }

    public int getCntPhonecode() {
        return cntPhonecode;
    }

    public void setCntPhonecode(int cntPhonecode) {
        this.cntPhonecode = cntPhonecode;
    }

    public Date getCntTimeStamp() {
        return cntTimeStamp;
    }

    public void setCntTimeStamp(Date cntTimeStamp) {
        this.cntTimeStamp = cntTimeStamp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cntId != null ? cntId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Country)) {
            return false;
        }
        Country other = (Country) object;
        if ((this.cntId == null && other.cntId != null) || (this.cntId != null && !this.cntId.equals(other.cntId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.smb215.entities.Country[ cntId=" + cntId + " ]";
    }
    
}
