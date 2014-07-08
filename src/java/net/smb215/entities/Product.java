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
import javax.persistence.Lob;
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
@Table(name = "product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findByProdId", query = "SELECT p FROM Product p WHERE p.prodId = :prodId"),
    @NamedQuery(name = "Product.findByProdCatId", query = "SELECT p FROM Product p WHERE p.prodCatId = :prodCatId"),
    @NamedQuery(name = "Product.findByProdSku", query = "SELECT p FROM Product p WHERE p.prodSku = :prodSku"),
    @NamedQuery(name = "Product.findByProdUpc", query = "SELECT p FROM Product p WHERE p.prodUpc = :prodUpc"),
    @NamedQuery(name = "Product.findByProdName", query = "SELECT p FROM Product p WHERE p.prodName = :prodName"),
    @NamedQuery(name = "Product.findByProdQty", query = "SELECT p FROM Product p WHERE p.prodQty = :prodQty"),
    @NamedQuery(name = "Product.findByProdQtyPerUnit", query = "SELECT p FROM Product p WHERE p.prodQtyPerUnit = :prodQtyPerUnit"),
    @NamedQuery(name = "Product.findByProdColor", query = "SELECT p FROM Product p WHERE p.prodColor = :prodColor"),
    @NamedQuery(name = "Product.findByProdSize", query = "SELECT p FROM Product p WHERE p.prodSize = :prodSize"),
    @NamedQuery(name = "Product.findByProdWeight", query = "SELECT p FROM Product p WHERE p.prodWeight = :prodWeight"),
    @NamedQuery(name = "Product.findByProdSupId", query = "SELECT p FROM Product p WHERE p.prodSupId = :prodSupId"),
    @NamedQuery(name = "Product.findByProdStatus", query = "SELECT p FROM Product p WHERE p.prodStatus = :prodStatus"),
    @NamedQuery(name = "Product.findByProdPic", query = "SELECT p FROM Product p WHERE p.prodPic = :prodPic"),
    @NamedQuery(name = "Product.findByProdVendId", query = "SELECT p FROM Product p WHERE p.prodVendId = :prodVendId"),
    @NamedQuery(name = "Product.findByProdTimeStamp", query = "SELECT p FROM Product p WHERE p.prodTimeStamp = :prodTimeStamp")})
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "prod_id")
    private Integer prodId;
    @Column(name = "prod_cat_id")
    private Integer prodCatId;
    @Size(max = 128)
    @Column(name = "prod_sku")
    private String prodSku;
    @Size(max = 128)
    @Column(name = "prod_upc")
    private String prodUpc;
    @Size(max = 128)
    @Column(name = "prod_name")
    private String prodName;
    @Lob
    @Size(max = 65535)
    @Column(name = "prod_desc")
    private String prodDesc;
    @Column(name = "prod_qty")
    private Integer prodQty;
    @Column(name = "prod_qty_per_unit")
    private Integer prodQtyPerUnit;
    @Column(name = "prod_color")
    private Integer prodColor;
    @Size(max = 45)
    @Column(name = "prod_size")
    private String prodSize;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "prod_weight")
    private Double prodWeight;
    @Column(name = "prod_sup_id")
    private Integer prodSupId;
    @Column(name = "prod_status")
    private Short prodStatus;
    @Size(max = 256)
    @Column(name = "prod_pic")
    private String prodPic;
    @Column(name = "prod_vend_id")
    private Integer prodVendId;
    @Column(name = "prod_time_stamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date prodTimeStamp;

    public Product() {
    }

    public Product(Integer prodId) {
        this.prodId = prodId;
    }

    public Integer getProdId() {
        return prodId;
    }

    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }

    public Integer getProdCatId() {
        return prodCatId;
    }

    public void setProdCatId(Integer prodCatId) {
        this.prodCatId = prodCatId;
    }

    public String getProdSku() {
        return prodSku;
    }

    public void setProdSku(String prodSku) {
        this.prodSku = prodSku;
    }

    public String getProdUpc() {
        return prodUpc;
    }

    public void setProdUpc(String prodUpc) {
        this.prodUpc = prodUpc;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getProdDesc() {
        return prodDesc;
    }

    public void setProdDesc(String prodDesc) {
        this.prodDesc = prodDesc;
    }

    public Integer getProdQty() {
        return prodQty;
    }

    public void setProdQty(Integer prodQty) {
        this.prodQty = prodQty;
    }

    public Integer getProdQtyPerUnit() {
        return prodQtyPerUnit;
    }

    public void setProdQtyPerUnit(Integer prodQtyPerUnit) {
        this.prodQtyPerUnit = prodQtyPerUnit;
    }

    public Integer getProdColor() {
        return prodColor;
    }

    public void setProdColor(Integer prodColor) {
        this.prodColor = prodColor;
    }

    public String getProdSize() {
        return prodSize;
    }

    public void setProdSize(String prodSize) {
        this.prodSize = prodSize;
    }

    public Double getProdWeight() {
        return prodWeight;
    }

    public void setProdWeight(Double prodWeight) {
        this.prodWeight = prodWeight;
    }

    public Integer getProdSupId() {
        return prodSupId;
    }

    public void setProdSupId(Integer prodSupId) {
        this.prodSupId = prodSupId;
    }

    public Short getProdStatus() {
        return prodStatus;
    }

    public void setProdStatus(Short prodStatus) {
        this.prodStatus = prodStatus;
    }

    public String getProdPic() {
        return prodPic;
    }

    public void setProdPic(String prodPic) {
        this.prodPic = prodPic;
    }

    public Integer getProdVendId() {
        return prodVendId;
    }

    public void setProdVendId(Integer prodVendId) {
        this.prodVendId = prodVendId;
    }

    public Date getProdTimeStamp() {
        return prodTimeStamp;
    }

    public void setProdTimeStamp(Date prodTimeStamp) {
        this.prodTimeStamp = prodTimeStamp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prodId != null ? prodId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.prodId == null && other.prodId != null) || (this.prodId != null && !this.prodId.equals(other.prodId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.smb215.entities.Product[ prodId=" + prodId + " ]";
    }
    
}
