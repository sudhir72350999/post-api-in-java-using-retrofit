package com.sudhirtheindian.postapijava.model;

import java.time.LocalDateTime;

public class TModel {
    private String requestId;
    private LocalDateTime requestDateTime;
    private String orderNo;
    private String systemName;
    private String userID;
    private String userType;
    private LocalDateTime cancelOn;

    // Constructors, getters, and setters
    public TModel() {
    }

    public TModel(String requestId, LocalDateTime requestDateTime, String orderNo, String systemName, String userID, String userType, LocalDateTime cancelOn) {
        this.requestId = requestId;
        this.requestDateTime = requestDateTime;
        this.orderNo = orderNo;
        this.systemName = systemName;
        this.userID = userID;
        this.userType = userType;
        this.cancelOn = cancelOn;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public LocalDateTime getRequestDateTime() {
        return requestDateTime;
    }

    public void setRequestDateTime(LocalDateTime requestDateTime) {
        this.requestDateTime = requestDateTime;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public LocalDateTime getCancelOn() {
        return cancelOn;
    }

    public void setCancelOn(LocalDateTime cancelOn) {
        this.cancelOn = cancelOn;
    }

    @Override
    public String toString() {
        return "Request{" +
                "requestId='" + requestId + '\'' +
                ", requestDateTime=" + requestDateTime +
                ", orderNo='" + orderNo + '\'' +
                ", systemName='" + systemName + '\'' +
                ", userID='" + userID + '\'' +
                ", userType='" + userType + '\'' +
                ", cancelOn=" + cancelOn +
                '}';
    }
}