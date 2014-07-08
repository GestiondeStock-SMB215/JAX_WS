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
@Table(name = "stock")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stock.findAll", query = "SELECT s FROM Stock s"),
    @NamedQuery(name = "Stock.findByStockId", query = "SELECT s FROM Stock s WHERE s.stockId = :stockId"),
    @NamedQuery(name = "Stock.findByStockProdId", query = "SELECT s FROM Stock s WHERE s.stockProdId = :stockProdId"),
    @NamedQuery(name = "Stock.findByStockBraId", query = "SELECT s FROM Stock s WHERE s.stockBraId = :stockBraId"),
    @NamedQuery(name = "Stock.findByStockQty", query = "SELECT s FROM Stock s WHERE s.stockQty = :stockQty"),
    @NamedQuery(name = "Stock.findByStockTimeStamp", query = "SELECT s FROM Stock s WHERE s.stockTimeStamp = :stockTimeStamp")})
public class Stock implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "stock_id")
    private Integer stockId;
    @Column(name = "stock_prod_id")
    private Integer stockProdId;
    @Column(name = "stock_bra_id")
    private Integer stockBraId;
    @Column(name = "stock_qty")
    private Integer stockQty;
    @Column(name = "stock_time_stamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date stockTimeStamp;

    public Stock() {
    }

    public Stock(Integer stockId) {
        this.stockId = stockId;
    }

    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public Integer getStockProdId() {
        return stockProdId;
    }

    public void setStockProdId(Integer stockProdId) {
        this.stockProdId = stockProdId;
    }

    public Integer getStockBraId() {
        return stockBraId;
    }

    public void setStockBraId(Integer stockBraId) {
        this.stockBraId = stockBraId;
    }

    public Integer getStockQty() {
        return stockQty;
    }

    public void setStockQty(Integer stockQty) {
        this.stockQty = stockQty;
    }

    public Date getStockTimeStamp() {
        return stockTimeStamp;
    }

    public void setStockTimeStamp(Date stockTimeStamp) {
        this.stockTimeStamp = stockTimeStamp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stockId != null ? stockId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stock)) {
            return false;
        }
        Stock other = (Stock) object;
        if ((this.stockId == null && other.stockId != null) || (this.stockId != null && !this.stockId.equals(other.stockId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.smb215.entities.Stock[ stockId=" + stockId + " ]";
    }
    
}
