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
@Table(name = "invoice_out_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvoiceOutDetail.findAll", query = "SELECT i FROM InvoiceOutDetail i"),
    @NamedQuery(name = "InvoiceOutDetail.findByInvOutDetId", query = "SELECT i FROM InvoiceOutDetail i WHERE i.invOutDetId = :invOutDetId"),
    @NamedQuery(name = "InvoiceOutDetail.findByInvOutDetInvId", query = "SELECT i FROM InvoiceOutDetail i WHERE i.invOutDetInvId = :invOutDetInvId"),
    @NamedQuery(name = "InvoiceOutDetail.findByInvOutDetProdId", query = "SELECT i FROM InvoiceOutDetail i WHERE i.invOutDetProdId = :invOutDetProdId"),
    @NamedQuery(name = "InvoiceOutDetail.findByInvOutDetQty", query = "SELECT i FROM InvoiceOutDetail i WHERE i.invOutDetQty = :invOutDetQty"),
    @NamedQuery(name = "InvoiceOutDetail.findByInvOutDetUp", query = "SELECT i FROM InvoiceOutDetail i WHERE i.invOutDetUp = :invOutDetUp"),
    @NamedQuery(name = "InvoiceOutDetail.findByInvOutDetTotal", query = "SELECT i FROM InvoiceOutDetail i WHERE i.invOutDetTotal = :invOutDetTotal"),
    @NamedQuery(name = "InvoiceOutDetail.findByInvOutDetDisc", query = "SELECT i FROM InvoiceOutDetail i WHERE i.invOutDetDisc = :invOutDetDisc"),
    @NamedQuery(name = "InvoiceOutDetail.findByInvOutDetTotaDue", query = "SELECT i FROM InvoiceOutDetail i WHERE i.invOutDetTotaDue = :invOutDetTotaDue"),
    @NamedQuery(name = "InvoiceOutDetail.findByInvOutDetTimeStamp", query = "SELECT i FROM InvoiceOutDetail i WHERE i.invOutDetTimeStamp = :invOutDetTimeStamp")})
public class InvoiceOutDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "inv_out_det_id")
    private Integer invOutDetId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "inv_out_det_inv_id")
    private int invOutDetInvId;
    @Column(name = "inv_out_det_prod_id")
    private Integer invOutDetProdId;
    @Column(name = "inv_out_det_qty")
    private Integer invOutDetQty;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "inv_out_det_up")
    private Double invOutDetUp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "inv_out_det_total")
    private double invOutDetTotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "inv_out_det_disc")
    private double invOutDetDisc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "inv_out_det_tota_due")
    private double invOutDetTotaDue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "inv_out_det_time_stamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date invOutDetTimeStamp;

    public InvoiceOutDetail() {
    }

    public InvoiceOutDetail(Integer invOutDetId) {
        this.invOutDetId = invOutDetId;
    }

    public InvoiceOutDetail(Integer invOutDetId, int invOutDetInvId, double invOutDetTotal, double invOutDetDisc, double invOutDetTotaDue, Date invOutDetTimeStamp) {
        this.invOutDetId = invOutDetId;
        this.invOutDetInvId = invOutDetInvId;
        this.invOutDetTotal = invOutDetTotal;
        this.invOutDetDisc = invOutDetDisc;
        this.invOutDetTotaDue = invOutDetTotaDue;
        this.invOutDetTimeStamp = invOutDetTimeStamp;
    }

    public Integer getInvOutDetId() {
        return invOutDetId;
    }

    public void setInvOutDetId(Integer invOutDetId) {
        this.invOutDetId = invOutDetId;
    }

    public int getInvOutDetInvId() {
        return invOutDetInvId;
    }

    public void setInvOutDetInvId(int invOutDetInvId) {
        this.invOutDetInvId = invOutDetInvId;
    }

    public Integer getInvOutDetProdId() {
        return invOutDetProdId;
    }

    public void setInvOutDetProdId(Integer invOutDetProdId) {
        this.invOutDetProdId = invOutDetProdId;
    }

    public Integer getInvOutDetQty() {
        return invOutDetQty;
    }

    public void setInvOutDetQty(Integer invOutDetQty) {
        this.invOutDetQty = invOutDetQty;
    }

    public Double getInvOutDetUp() {
        return invOutDetUp;
    }

    public void setInvOutDetUp(Double invOutDetUp) {
        this.invOutDetUp = invOutDetUp;
    }

    public double getInvOutDetTotal() {
        return invOutDetTotal;
    }

    public void setInvOutDetTotal(double invOutDetTotal) {
        this.invOutDetTotal = invOutDetTotal;
    }

    public double getInvOutDetDisc() {
        return invOutDetDisc;
    }

    public void setInvOutDetDisc(double invOutDetDisc) {
        this.invOutDetDisc = invOutDetDisc;
    }

    public double getInvOutDetTotaDue() {
        return invOutDetTotaDue;
    }

    public void setInvOutDetTotaDue(double invOutDetTotaDue) {
        this.invOutDetTotaDue = invOutDetTotaDue;
    }

    public Date getInvOutDetTimeStamp() {
        return invOutDetTimeStamp;
    }

    public void setInvOutDetTimeStamp(Date invOutDetTimeStamp) {
        this.invOutDetTimeStamp = invOutDetTimeStamp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invOutDetId != null ? invOutDetId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvoiceOutDetail)) {
            return false;
        }
        InvoiceOutDetail other = (InvoiceOutDetail) object;
        if ((this.invOutDetId == null && other.invOutDetId != null) || (this.invOutDetId != null && !this.invOutDetId.equals(other.invOutDetId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.smb215.entities.InvoiceOutDetail[ invOutDetId=" + invOutDetId + " ]";
    }
    
}
