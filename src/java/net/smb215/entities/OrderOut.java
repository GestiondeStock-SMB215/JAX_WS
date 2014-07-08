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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author henry_kozhaya
 */
@Entity
@Table(name = "order_out")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderOut.findAll", query = "SELECT o FROM OrderOut o"),
    @NamedQuery(name = "OrderOut.findByOrdOutId", query = "SELECT o FROM OrderOut o WHERE o.ordOutId = :ordOutId"),
    @NamedQuery(name = "OrderOut.findByOrdOutSupId", query = "SELECT o FROM OrderOut o WHERE o.ordOutSupId = :ordOutSupId"),
    @NamedQuery(name = "OrderOut.findByOrdOutDate", query = "SELECT o FROM OrderOut o WHERE o.ordOutDate = :ordOutDate"),
    @NamedQuery(name = "OrderOut.findByOrdOutDelDate", query = "SELECT o FROM OrderOut o WHERE o.ordOutDelDate = :ordOutDelDate"),
    @NamedQuery(name = "OrderOut.findByOrdOutStatus", query = "SELECT o FROM OrderOut o WHERE o.ordOutStatus = :ordOutStatus"),
    @NamedQuery(name = "OrderOut.findByOrdOutTimeStamp", query = "SELECT o FROM OrderOut o WHERE o.ordOutTimeStamp = :ordOutTimeStamp")})
public class OrderOut implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ord_out_id")
    private Integer ordOutId;
    @Size(max = 45)
    @Column(name = "ord_out_sup_id")
    private String ordOutSupId;
    @Column(name = "ord_out_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ordOutDate;
    @Column(name = "ord_out_del_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ordOutDelDate;
    @Column(name = "ord_out_status")
    private Integer ordOutStatus;
    @Column(name = "ord_out_time_stamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ordOutTimeStamp;

    public OrderOut() {
    }

    public OrderOut(Integer ordOutId) {
        this.ordOutId = ordOutId;
    }

    public Integer getOrdOutId() {
        return ordOutId;
    }

    public void setOrdOutId(Integer ordOutId) {
        this.ordOutId = ordOutId;
    }

    public String getOrdOutSupId() {
        return ordOutSupId;
    }

    public void setOrdOutSupId(String ordOutSupId) {
        this.ordOutSupId = ordOutSupId;
    }

    public Date getOrdOutDate() {
        return ordOutDate;
    }

    public void setOrdOutDate(Date ordOutDate) {
        this.ordOutDate = ordOutDate;
    }

    public Date getOrdOutDelDate() {
        return ordOutDelDate;
    }

    public void setOrdOutDelDate(Date ordOutDelDate) {
        this.ordOutDelDate = ordOutDelDate;
    }

    public Integer getOrdOutStatus() {
        return ordOutStatus;
    }

    public void setOrdOutStatus(Integer ordOutStatus) {
        this.ordOutStatus = ordOutStatus;
    }

    public Date getOrdOutTimeStamp() {
        return ordOutTimeStamp;
    }

    public void setOrdOutTimeStamp(Date ordOutTimeStamp) {
        this.ordOutTimeStamp = ordOutTimeStamp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ordOutId != null ? ordOutId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderOut)) {
            return false;
        }
        OrderOut other = (OrderOut) object;
        if ((this.ordOutId == null && other.ordOutId != null) || (this.ordOutId != null && !this.ordOutId.equals(other.ordOutId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.smb215.entities.OrderOut[ ordOutId=" + ordOutId + " ]";
    }
    
}
