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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author henry_kozhaya
 */
@Entity
@Table(name = "order_in")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderIn.findAll", query = "SELECT o FROM OrderIn o"),
    @NamedQuery(name = "OrderIn.findByOrdInId", query = "SELECT o FROM OrderIn o WHERE o.ordInId = :ordInId"),
    @NamedQuery(name = "OrderIn.findByOrdInCustId", query = "SELECT o FROM OrderIn o WHERE o.ordInCustId = :ordInCustId"),
    @NamedQuery(name = "OrderIn.findByOrdInDate", query = "SELECT o FROM OrderIn o WHERE o.ordInDate = :ordInDate"),
    @NamedQuery(name = "OrderIn.findByOrdInDelDate", query = "SELECT o FROM OrderIn o WHERE o.ordInDelDate = :ordInDelDate"),
    @NamedQuery(name = "OrderIn.findByOrdInStatus", query = "SELECT o FROM OrderIn o WHERE o.ordInStatus = :ordInStatus"),
    @NamedQuery(name = "OrderIn.findByOrdInTimeStamp", query = "SELECT o FROM OrderIn o WHERE o.ordInTimeStamp = :ordInTimeStamp")})
public class OrderIn implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ord_in_id")
    private Integer ordInId;
    @Column(name = "ord_in_cust_id")
    private Integer ordInCustId;
    @Column(name = "ord_in_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ordInDate;
    @Column(name = "ord_in_del_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ordInDelDate;
    @Column(name = "ord_in_status")
    private Integer ordInStatus;
    @Column(name = "ord_in_time_stamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ordInTimeStamp;

    public OrderIn() {
    }

    public OrderIn(Integer ordInId) {
        this.ordInId = ordInId;
    }

    public Integer getOrdInId() {
        return ordInId;
    }

    public void setOrdInId(Integer ordInId) {
        this.ordInId = ordInId;
    }

    public Integer getOrdInCustId() {
        return ordInCustId;
    }

    public void setOrdInCustId(Integer ordInCustId) {
        this.ordInCustId = ordInCustId;
    }

    public Date getOrdInDate() {
        return ordInDate;
    }

    public void setOrdInDate(Date ordInDate) {
        this.ordInDate = ordInDate;
    }

    public Date getOrdInDelDate() {
        return ordInDelDate;
    }

    public void setOrdInDelDate(Date ordInDelDate) {
        this.ordInDelDate = ordInDelDate;
    }

    public Integer getOrdInStatus() {
        return ordInStatus;
    }

    public void setOrdInStatus(Integer ordInStatus) {
        this.ordInStatus = ordInStatus;
    }

    public Date getOrdInTimeStamp() {
        return ordInTimeStamp;
    }

    public void setOrdInTimeStamp(Date ordInTimeStamp) {
        this.ordInTimeStamp = ordInTimeStamp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ordInId != null ? ordInId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderIn)) {
            return false;
        }
        OrderIn other = (OrderIn) object;
        if ((this.ordInId == null && other.ordInId != null) || (this.ordInId != null && !this.ordInId.equals(other.ordInId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.smb215.entities.OrderIn[ ordInId=" + ordInId + " ]";
    }
    
}
