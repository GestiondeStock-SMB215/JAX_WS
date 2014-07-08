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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author henry_kozhaya
 */
@Entity
@Table(name = "trans_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TransDetail.findAll", query = "SELECT t FROM TransDetail t"),
    @NamedQuery(name = "TransDetail.findByTransDetId", query = "SELECT t FROM TransDetail t WHERE t.transDetId = :transDetId"),
    @NamedQuery(name = "TransDetail.findByTransDetTransId", query = "SELECT t FROM TransDetail t WHERE t.transDetTransId = :transDetTransId"),
    @NamedQuery(name = "TransDetail.findByTransDetProdId", query = "SELECT t FROM TransDetail t WHERE t.transDetProdId = :transDetProdId"),
    @NamedQuery(name = "TransDetail.findByTransDetQty", query = "SELECT t FROM TransDetail t WHERE t.transDetQty = :transDetQty"),
    @NamedQuery(name = "TransDetail.findByTransDetTimeStamp", query = "SELECT t FROM TransDetail t WHERE t.transDetTimeStamp = :transDetTimeStamp")})
public class TransDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "trans_det_id")
    private Integer transDetId;
    @Column(name = "trans_det_trans_id")
    private Integer transDetTransId;
    @Column(name = "trans_det_prod_id")
    private Integer transDetProdId;
    @Column(name = "trans_det_qty")
    private Integer transDetQty;
    @Column(name = "trans_det_time_stamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transDetTimeStamp;

    public TransDetail() {
    }

    public TransDetail(Integer transDetId) {
        this.transDetId = transDetId;
    }

    public Integer getTransDetId() {
        return transDetId;
    }

    public void setTransDetId(Integer transDetId) {
        this.transDetId = transDetId;
    }

    public Integer getTransDetTransId() {
        return transDetTransId;
    }

    public void setTransDetTransId(Integer transDetTransId) {
        this.transDetTransId = transDetTransId;
    }

    public Integer getTransDetProdId() {
        return transDetProdId;
    }

    public void setTransDetProdId(Integer transDetProdId) {
        this.transDetProdId = transDetProdId;
    }

    public Integer getTransDetQty() {
        return transDetQty;
    }

    public void setTransDetQty(Integer transDetQty) {
        this.transDetQty = transDetQty;
    }

    public Date getTransDetTimeStamp() {
        return transDetTimeStamp;
    }

    public void setTransDetTimeStamp(Date transDetTimeStamp) {
        this.transDetTimeStamp = transDetTimeStamp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transDetId != null ? transDetId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransDetail)) {
            return false;
        }
        TransDetail other = (TransDetail) object;
        if ((this.transDetId == null && other.transDetId != null) || (this.transDetId != null && !this.transDetId.equals(other.transDetId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.smb215.entities.TransDetail[ transDetId=" + transDetId + " ]";
    }
    
}
