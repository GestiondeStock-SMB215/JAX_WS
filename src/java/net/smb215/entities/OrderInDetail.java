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
@Table(name = "order_in_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderInDetail.findAll", query = "SELECT o FROM OrderInDetail o"),
    @NamedQuery(name = "OrderInDetail.findByOrdInDetId", query = "SELECT o FROM OrderInDetail o WHERE o.ordInDetId = :ordInDetId"),
    @NamedQuery(name = "OrderInDetail.findByOrdInDetOrdInId", query = "SELECT o FROM OrderInDetail o WHERE o.ordInDetOrdInId = :ordInDetOrdInId"),
    @NamedQuery(name = "OrderInDetail.findByOrdInDetProdId", query = "SELECT o FROM OrderInDetail o WHERE o.ordInDetProdId = :ordInDetProdId"),
    @NamedQuery(name = "OrderInDetail.findByOrdInDetQty", query = "SELECT o FROM OrderInDetail o WHERE o.ordInDetQty = :ordInDetQty"),
    @NamedQuery(name = "OrderInDetail.findByOrdInDetTimeStamp", query = "SELECT o FROM OrderInDetail o WHERE o.ordInDetTimeStamp = :ordInDetTimeStamp")})
public class OrderInDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ord_in_det_id")
    private Integer ordInDetId;
    @Column(name = "ord_in_det_ord_in_id")
    private Integer ordInDetOrdInId;
    @Column(name = "ord_in_det_prod_id")
    private Integer ordInDetProdId;
    @Column(name = "ord_in_det_qty")
    private Integer ordInDetQty;
    @Column(name = "ord_in_det_time_stamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ordInDetTimeStamp;

    public OrderInDetail() {
    }

    public OrderInDetail(Integer ordInDetId) {
        this.ordInDetId = ordInDetId;
    }

    public Integer getOrdInDetId() {
        return ordInDetId;
    }

    public void setOrdInDetId(Integer ordInDetId) {
        this.ordInDetId = ordInDetId;
    }

    public Integer getOrdInDetOrdInId() {
        return ordInDetOrdInId;
    }

    public void setOrdInDetOrdInId(Integer ordInDetOrdInId) {
        this.ordInDetOrdInId = ordInDetOrdInId;
    }

    public Integer getOrdInDetProdId() {
        return ordInDetProdId;
    }

    public void setOrdInDetProdId(Integer ordInDetProdId) {
        this.ordInDetProdId = ordInDetProdId;
    }

    public Integer getOrdInDetQty() {
        return ordInDetQty;
    }

    public void setOrdInDetQty(Integer ordInDetQty) {
        this.ordInDetQty = ordInDetQty;
    }

    public Date getOrdInDetTimeStamp() {
        return ordInDetTimeStamp;
    }

    public void setOrdInDetTimeStamp(Date ordInDetTimeStamp) {
        this.ordInDetTimeStamp = ordInDetTimeStamp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ordInDetId != null ? ordInDetId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderInDetail)) {
            return false;
        }
        OrderInDetail other = (OrderInDetail) object;
        if ((this.ordInDetId == null && other.ordInDetId != null) || (this.ordInDetId != null && !this.ordInDetId.equals(other.ordInDetId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.smb215.entities.OrderInDetail[ ordInDetId=" + ordInDetId + " ]";
    }
    
}
