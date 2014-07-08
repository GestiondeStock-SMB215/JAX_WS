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
@Table(name = "status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Status.findAll", query = "SELECT s FROM Status s"),
    @NamedQuery(name = "Status.findByStaId", query = "SELECT s FROM Status s WHERE s.staId = :staId"),
    @NamedQuery(name = "Status.findByStaRef", query = "SELECT s FROM Status s WHERE s.staRef = :staRef"),
    @NamedQuery(name = "Status.findByStaDesc", query = "SELECT s FROM Status s WHERE s.staDesc = :staDesc"),
    @NamedQuery(name = "Status.findByStaTimeStamp", query = "SELECT s FROM Status s WHERE s.staTimeStamp = :staTimeStamp")})
public class Status implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sta_id")
    private Integer staId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sta_ref")
    private int staRef;
    @Size(max = 64)
    @Column(name = "sta_desc")
    private String staDesc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sta_time_stamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date staTimeStamp;

    public Status() {
    }

    public Status(Integer staId) {
        this.staId = staId;
    }

    public Status(Integer staId, int staRef, Date staTimeStamp) {
        this.staId = staId;
        this.staRef = staRef;
        this.staTimeStamp = staTimeStamp;
    }

    public Integer getStaId() {
        return staId;
    }

    public void setStaId(Integer staId) {
        this.staId = staId;
    }

    public int getStaRef() {
        return staRef;
    }

    public void setStaRef(int staRef) {
        this.staRef = staRef;
    }

    public String getStaDesc() {
        return staDesc;
    }

    public void setStaDesc(String staDesc) {
        this.staDesc = staDesc;
    }

    public Date getStaTimeStamp() {
        return staTimeStamp;
    }

    public void setStaTimeStamp(Date staTimeStamp) {
        this.staTimeStamp = staTimeStamp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (staId != null ? staId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Status)) {
            return false;
        }
        Status other = (Status) object;
        if ((this.staId == null && other.staId != null) || (this.staId != null && !this.staId.equals(other.staId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.smb215.entities.Status[ staId=" + staId + " ]";
    }
    
}
