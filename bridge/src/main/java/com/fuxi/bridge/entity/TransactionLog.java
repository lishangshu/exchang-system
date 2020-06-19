package com.fuxi.bridge.entity;

import java.math.BigDecimal;
import java.util.Date;

public class TransactionLog {
    private Long id;

    private String address;

    private String blockHash;

    private Integer blockNumber;

    private Long logIndex;

    private Boolean removed;

    private String transactionHash;

    private Integer transactionIndex;

    private String eventInAddress;

    private String eventOutAddress;

    private BigDecimal eventAmount;

    private String eventMessage;

    private Date eventTimestamp;

    private Long eventTimestampv;

    private Date createTime;

    private String data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getBlockHash() {
        return blockHash;
    }

    public void setBlockHash(String blockHash) {
        this.blockHash = blockHash == null ? null : blockHash.trim();
    }

    public Integer getBlockNumber() {
        return blockNumber;
    }

    public void setBlockNumber(Integer blockNumber) {
        this.blockNumber = blockNumber;
    }

    public Long getLogIndex() {
        return logIndex;
    }

    public void setLogIndex(Long logIndex) {
        this.logIndex = logIndex;
    }

    public Boolean getRemoved() {
        return removed;
    }

    public void setRemoved(Boolean removed) {
        this.removed = removed;
    }

    public String getTransactionHash() {
        return transactionHash;
    }

    public void setTransactionHash(String transactionHash) {
        this.transactionHash = transactionHash == null ? null : transactionHash.trim();
    }

    public Integer getTransactionIndex() {
        return transactionIndex;
    }

    public void setTransactionIndex(Integer transactionIndex) {
        this.transactionIndex = transactionIndex;
    }

    public String getEventInAddress() {
        return eventInAddress;
    }

    public void setEventInAddress(String eventInAddress) {
        this.eventInAddress = eventInAddress == null ? null : eventInAddress.trim();
    }

    public String getEventOutAddress() {
        return eventOutAddress;
    }

    public void setEventOutAddress(String eventOutAddress) {
        this.eventOutAddress = eventOutAddress == null ? null : eventOutAddress.trim();
    }

    public BigDecimal getEventAmount() {
        return eventAmount;
    }

    public void setEventAmount(BigDecimal eventAmount) {
        this.eventAmount = eventAmount;
    }

    public String getEventMessage() {
        return eventMessage;
    }

    public void setEventMessage(String eventMessage) {
        this.eventMessage = eventMessage == null ? null : eventMessage.trim();
    }

    public Date getEventTimestamp() {
        return eventTimestamp;
    }

    public void setEventTimestamp(Date eventTimestamp) {
        this.eventTimestamp = eventTimestamp;
    }

    public Long getEventTimestampv() {
        return eventTimestampv;
    }

    public void setEventTimestampv(Long eventTimestampv) {
        this.eventTimestampv = eventTimestampv;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data == null ? null : data.trim();
    }

    @Override
    public String toString() {
        return "TransactionLog{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", blockHash='" + blockHash + '\'' +
                ", blockNumber=" + blockNumber +
                ", logIndex=" + logIndex +
                ", removed=" + removed +
                ", transactionHash='" + transactionHash + '\'' +
                ", transactionIndex=" + transactionIndex +
                ", eventInAddress='" + eventInAddress + '\'' +
                ", eventOutAddress='" + eventOutAddress + '\'' +
                ", eventAmount=" + eventAmount +
                ", eventMessage='" + eventMessage + '\'' +
                ", eventTimestamp=" + eventTimestamp +
                ", eventTimestampv=" + eventTimestampv +
                ", createTime=" + createTime +
                ", data='" + data + '\'' +
                '}';
    }
}