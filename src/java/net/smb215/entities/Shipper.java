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
@Table(name = "shipper")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shipper.findAll", query = "SELECT s FROM Shipper s"),
    @NamedQuery(name = "Shipper.findByShipId", query = "SELECT s FROM Shipper s WHERE s.shipId = :shipId"),
    @NamedQuery(name = "Shipper.findByShipName", query = "SELECT s FROM Shipper s WHERE s.shipName = :shipName"),
    @NamedQuery(name = "Shipper.findByShipType", query = "SELECT s FROM Shipper s WHERE s.shipType = :shipType"),
    @NamedQuery(name = "Shipper.findByShipTel1", query = "SELECT s FROM Shipper s WHERE s.shipTel1 = :shipTel1"),
    @NamedQuery(name = "Shipper.findByShipTel2", query = "SELECT s FROM Shipper s WHERE s.shipTel2 = :shipTel2"),
    @NamedQuery(name = "Shipper.findByShipFax", query = "SELECT s FROM Shipper s WHERE s.shipFax = :shipFax"),
    @NamedQuery(name = "Shipper.findByShipEmail", query = "SELECT s FROM Shipper s WHERE s.shipEmail = :shipEmail"),
    @NamedQuery(name = "Shipper.findByShipTaxable", query = "SELECT s FROM Shipper s WHERE s.shipTaxable = :shipTaxable"),
    @NamedQuery(name = "Shipper.findByShipTimeStamp", query = "SELECT s FROM Shipper s WHERE s.shipTimeStamp = :shipTimeStamp")})
public class Shipper implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ship_id")
    private Integer shipId;
    @Size(max = 128)
    @Column(name = "ship_name")
    private String shipName;
    @Column(name = "ship_type")
    private Integer shipType;
    @Lob
    @Size(max = 65535)
    @Column(name = "ship_add_1")
    private String shipAdd1;
    @Lob
    @Size(max = 65535)
    @Column(name = "ship_add_2")
    private String shipAdd2;
    @Size(max = 128)
    @Column(name = "ship_tel_1")
    private String shipTel1;
    @Size(max = 128)
    @Column(name = "ship_tel_2")
    private String shipTel2;
    @Size(max = 128)
    @Column(name = "ship_fax")
    private String shipFax;
    @Size(max = 128)
    @Column(name = "ship_email")
    private String shipEmail;
    @Column(name = "ship_taxable")
    private Short shipTaxable;
    @Column(name = "ship_time_stamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date shipTimeStamp;

    public Shipper() {
    }

    public Shipper(Integer shipId) {
        this.shipId = shipId;
    }

    public Integer getShipId() {
        return shipId;
    }

    public void setShipId(Integer shipId) {
        this.shipId = shipId;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public Integer getShipType() {
        return shipType;
    }

    public void setShipType(Integer shipType) {
        this.shipType = shipType;
    }

    public String getShipAdd1() {
        return shipAdd1;
    }

    public void setShipAdd1(String shipAdd1) {
        this.shipAdd1 = shipAdd1;
    }

    public String getShipAdd2() {
        return shipAdd2;
    }

    public void setShipAdd2(String shipAdd2) {
        this.shipAdd2 = shipAdd2;
    }

    public String getShipTel1() {
        return shipTel1;
    }

    public void setShipTel1(String shipTel1) {
        this.shipTel1 = shipTel1;
    }

    public String getShipTel2() {
        return shipTel2;
    }

    public void setShipTel2(String shipTel2) {
        this.shipTel2 = shipTel2;
    }

    public String getShipFax() {
        return shipFax;
    }

    public void setShipFax(String shipFax) {
        this.shipFax = shipFax;
    }

    public String getShipEmail() {
        return shipEmail;
    }

    public void setShipEmail(String shipEmail) {
        this.shipEmail = shipEmail;
    }

    public Short getShipTaxable() {
        return shipTaxable;
    }

    public void setShipTaxable(Short shipTaxable) {
        this.shipTaxable = shipTaxable;
    }

    public Date getShipTimeStamp() {
        return shipTimeStamp;
    }

    public void setShipTimeStamp(Date shipTimeStamp) {
        this.shipTimeStamp = shipTimeStamp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shipId != null ? shipId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shipper)) {
            return false;
        }
        Shipper other = (Shipper) object;
        if ((this.shipId == null && other.shipId != null) || (this.shipId != null && !this.shipId.equals(other.shipId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.smb215.entities.Shipper[ shipId=" + shipId + " ]";
    }
    
}
