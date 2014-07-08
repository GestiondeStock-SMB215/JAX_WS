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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author henry_kozhaya
 */
@Entity
@Table(name = "invoice_in_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvoiceInDetail.findAll", query = "SELECT i FROM InvoiceInDetail i"),
    @NamedQuery(name = "InvoiceInDetail.findByInvInDetId", query = "SELECT i FROM InvoiceInDetail i WHERE i.invInDetId = :invInDetId"),
    @NamedQuery(name = "InvoiceInDetail.findByInvInDetInvId", query = "SELECT i FROM InvoiceInDetail i WHERE i.invInDetInvId = :invInDetInvId"),
    @NamedQuery(name = "InvoiceInDetail.findByInvInDetProdId", query = "SELECT i FROM InvoiceInDetail i WHERE i.invInDetProdId = :invInDetProdId"),
    @NamedQuery(name = "InvoiceInDetail.findByInvInDetQty", query = "SELECT i FROM InvoiceInDetail i WHERE i.invInDetQty = :invInDetQty"),
    @NamedQuery(name = "InvoiceInDetail.findByInvInDetUp", query = "SELECT i FROM InvoiceInDetail i WHERE i.invInDetUp = :invInDetUp"),
    @NamedQuery(name = "InvoiceInDetail.findByInvInDetTotal", query = "SELECT i FROM InvoiceInDetail i WHERE i.invInDetTotal = :invInDetTotal"),
    @NamedQuery(name = "InvoiceInDetail.findByInvInDetDisc", query = "SELECT i FROM InvoiceInDetail i WHERE i.invInDetDisc = :invInDetDisc"),
    @NamedQuery(name = "InvoiceInDetail.findByInvInDetTotalDue", query = "SELECT i FROM InvoiceInDetail i WHERE i.invInDetTotalDue = :invInDetTotalDue"),
    @NamedQuery(name = "InvoiceInDetail.findByInvInDetTimeStamp", query = "SELECT i FROM InvoiceInDetail i WHERE i.invInDetTimeStamp = :invInDetTimeStamp")})
public class InvoiceInDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "inv_in_det_id")
    private Integer invInDetId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "inv_in_det_inv_id")
    private int invInDetInvId;
    @Column(name = "inv_in_det_prod_id")
    private Integer invInDetProdId;
    @Column(name = "inv_in_det_qty")
    private Integer invInDetQty;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "inv_in_det_up")
    private Double invInDetUp;
    @Column(name = "inv_in_det_total")
    private Double invInDetTotal;
    @Column(name = "inv_in_det_disc")
    private Double invInDetDisc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "inv_in_det_total_due")
    private double invInDetTotalDue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "inv_in_det_time_stamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date invInDetTimeStamp;

    public InvoiceInDetail() {
    }

    public InvoiceInDetail(Integer invInDetId) {
        this.invInDetId = invInDetId;
    }

    public InvoiceInDetail(Integer invInDetId, int invInDetInvId, double invInDetTotalDue, Date invInDetTimeStamp) {
        this.invInDetId = invInDetId;
        this.invInDetInvId = invInDetInvId;
        this.invInDetTotalDue = invInDetTotalDue;
        this.invInDetTimeStamp = invInDetTimeStamp;
    }

    public Integer getInvInDetId() {
        return invInDetId;
    }

    public void setInvInDetId(Integer invInDetId) {
        this.invInDetId = invInDetId;
    }

    public int getInvInDetInvId() {
        return invInDetInvId;
    }

    public void setInvInDetInvId(int invInDetInvId) {
        this.invInDetInvId = invInDetInvId;
    }

    public Integer getInvInDetProdId() {
        return invInDetProdId;
    }

    public void setInvInDetProdId(Integer invInDetProdId) {
        this.invInDetProdId = invInDetProdId;
    }

    public Integer getInvInDetQty() {
        return invInDetQty;
    }

    public void setInvInDetQty(Integer invInDetQty) {
        this.invInDetQty = invInDetQty;
    }

    public Double getInvInDetUp() {
        return invInDetUp;
    }

    public void setInvInDetUp(Double invInDetUp) {
        this.invInDetUp = invInDetUp;
    }

    public Double getInvInDetTotal() {
        return invInDetTotal;
    }

    public void setInvInDetTotal(Double invInDetTotal) {
        this.invInDetTotal = invInDetTotal;
    }

    public Double getInvInDetDisc() {
        return invInDetDisc;
    }

    public void setInvInDetDisc(Double invInDetDisc) {
        this.invInDetDisc = invInDetDisc;
    }

    public double getInvInDetTotalDue() {
        return invInDetTotalDue;
    }

    public void setInvInDetTotalDue(double invInDetTotalDue) {
        this.invInDetTotalDue = invInDetTotalDue;
    }

    public Date getInvInDetTimeStamp() {
        return invInDetTimeStamp;
    }

    public void setInvInDetTimeStamp(Date invInDetTimeStamp) {
        this.invInDetTimeStamp = invInDetTimeStamp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invInDetId != null ? invInDetId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvoiceInDetail)) {
            return false;
        }
        InvoiceInDetail other = (InvoiceInDetail) object;
        if ((this.invInDetId == null && other.invInDetId != null) || (this.invInDetId != null && !this.invInDetId.equals(other.invInDetId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.smb215.entities.InvoiceInDetail[ invInDetId=" + invInDetId + " ]";
    }
    
}
