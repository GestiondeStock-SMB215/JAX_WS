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
@Table(name = "order_out_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderOutDetail.findAll", query = "SELECT o FROM OrderOutDetail o"),
    @NamedQuery(name = "OrderOutDetail.findByOrdOutDetId", query = "SELECT o FROM OrderOutDetail o WHERE o.ordOutDetId = :ordOutDetId"),
    @NamedQuery(name = "OrderOutDetail.findByOrdOutDetOrdOutId", query = "SELECT o FROM OrderOutDetail o WHERE o.ordOutDetOrdOutId = :ordOutDetOrdOutId"),
    @NamedQuery(name = "OrderOutDetail.findByOrdOutDetProdId", query = "SELECT o FROM OrderOutDetail o WHERE o.ordOutDetProdId = :ordOutDetProdId"),
    @NamedQuery(name = "OrderOutDetail.findByOrdOutDetQty", query = "SELECT o FROM OrderOutDetail o WHERE o.ordOutDetQty = :ordOutDetQty"),
    @NamedQuery(name = "OrderOutDetail.findByOrdOutDetTimeStamp", query = "SELECT o FROM OrderOutDetail o WHERE o.ordOutDetTimeStamp = :ordOutDetTimeStamp")})
public class OrderOutDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ord_out_det_id")
    private Integer ordOutDetId;
    @Column(name = "ord_out_det_ord_out_id")
    private Integer ordOutDetOrdOutId;
    @Column(name = "ord_out_det_prod_id")
    private Integer ordOutDetProdId;
    @Column(name = "ord_out_det_qty")
    private Integer ordOutDetQty;
    @Column(name = "ord_out_det_time_stamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ordOutDetTimeStamp;

    public OrderOutDetail() {
    }

    public OrderOutDetail(Integer ordOutDetId) {
        this.ordOutDetId = ordOutDetId;
    }

    public Integer getOrdOutDetId() {
        return ordOutDetId;
    }

    public void setOrdOutDetId(Integer ordOutDetId) {
        this.ordOutDetId = ordOutDetId;
    }

    public Integer getOrdOutDetOrdOutId() {
        return ordOutDetOrdOutId;
    }

    public void setOrdOutDetOrdOutId(Integer ordOutDetOrdOutId) {
        this.ordOutDetOrdOutId = ordOutDetOrdOutId;
    }

    public Integer getOrdOutDetProdId() {
        return ordOutDetProdId;
    }

    public void setOrdOutDetProdId(Integer ordOutDetProdId) {
        this.ordOutDetProdId = ordOutDetProdId;
    }

    public Integer getOrdOutDetQty() {
        return ordOutDetQty;
    }

    public void setOrdOutDetQty(Integer ordOutDetQty) {
        this.ordOutDetQty = ordOutDetQty;
    }

    public Date getOrdOutDetTimeStamp() {
        return ordOutDetTimeStamp;
    }

    public void setOrdOutDetTimeStamp(Date ordOutDetTimeStamp) {
        this.ordOutDetTimeStamp = ordOutDetTimeStamp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ordOutDetId != null ? ordOutDetId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderOutDetail)) {
            return false;
        }
        OrderOutDetail other = (OrderOutDetail) object;
        if ((this.ordOutDetId == null && other.ordOutDetId != null) || (this.ordOutDetId != null && !this.ordOutDetId.equals(other.ordOutDetId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.smb215.entities.OrderOutDetail[ ordOutDetId=" + ordOutDetId + " ]";
    }
    
}
