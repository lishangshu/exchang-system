package com.fuxi.entity;

import java.util.Date;

public class ExchangeDomain {
    private Long id;

    private String domain;

    private String domainHash;

    private String hashCode;

    private String owner;

    private String position;

    private String mailAddress;

    private String maillNo;

    private String email;

    private String contactPhone;

    private Date createTime;

    private Date updateTime;

    private Long customerId;

    private String customerAddress;

    private Integer contentItems;

    private String wiRegistrarSupport;

    private String wiCreateTime;

    private String wiExpirationTime;

    private String wiServerIp;

    private String wiDns;

    private Boolean logicalDel;

    private Boolean status;

    private String transactionHash;

    private String dnsParseRecord;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain == null ? null : domain.trim();
    }

    public String getDomainHash() {
        return domainHash;
    }

    public void setDomainHash(String domainHash) {
        this.domainHash = domainHash == null ? null : domainHash.trim();
    }

    public String getHashCode() {
        return hashCode;
    }

    public void setHashCode(String hashCode) {
        this.hashCode = hashCode == null ? null : hashCode.trim();
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner == null ? null : owner.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress == null ? null : mailAddress.trim();
    }

    public String getMaillNo() {
        return maillNo;
    }

    public void setMaillNo(String maillNo) {
        this.maillNo = maillNo == null ? null : maillNo.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress == null ? null : customerAddress.trim();
    }

    public Integer getContentItems() {
        return contentItems;
    }

    public void setContentItems(Integer contentItems) {
        this.contentItems = contentItems;
    }

    public String getWiRegistrarSupport() {
        return wiRegistrarSupport;
    }

    public void setWiRegistrarSupport(String wiRegistrarSupport) {
        this.wiRegistrarSupport = wiRegistrarSupport == null ? null : wiRegistrarSupport.trim();
    }

    public String getWiCreateTime() {
        return wiCreateTime;
    }

    public void setWiCreateTime(String wiCreateTime) {
        this.wiCreateTime = wiCreateTime == null ? null : wiCreateTime.trim();
    }

    public String getWiExpirationTime() {
        return wiExpirationTime;
    }

    public void setWiExpirationTime(String wiExpirationTime) {
        this.wiExpirationTime = wiExpirationTime == null ? null : wiExpirationTime.trim();
    }

    public String getWiServerIp() {
        return wiServerIp;
    }

    public void setWiServerIp(String wiServerIp) {
        this.wiServerIp = wiServerIp == null ? null : wiServerIp.trim();
    }

    public String getWiDns() {
        return wiDns;
    }

    public void setWiDns(String wiDns) {
        this.wiDns = wiDns == null ? null : wiDns.trim();
    }

    public Boolean getLogicalDel() {
        return logicalDel;
    }

    public void setLogicalDel(Boolean logicalDel) {
        this.logicalDel = logicalDel;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getTransactionHash() {
        return transactionHash;
    }

    public void setTransactionHash(String transactionHash) {
        this.transactionHash = transactionHash == null ? null : transactionHash.trim();
    }

    public String getDnsParseRecord() {
        return dnsParseRecord;
    }

    public void setDnsParseRecord(String dnsParseRecord) {
        this.dnsParseRecord = dnsParseRecord == null ? null : dnsParseRecord.trim();
    }
}