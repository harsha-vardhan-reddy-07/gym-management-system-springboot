package com.server.models;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;

@Getter
@Document(collection = "subscriptions")
public class SubscriptionsModel {

    public String _id;
    public String userId;
    public String username;
    public String email;
    public String planId;
    public String planTitle;
    public Number planAmount;
    public String startDate;
    public String endDate;

    public SubscriptionsModel(){}

    public String get_id() {
        return _id;
    }

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPlanId() {
        return planId;
    }

    public String getPlanTitle() {
        return planTitle;
    }

    public Number getPlanAmount() {
        return planAmount;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public void setPlanTitle(String planTitle) {
        this.planTitle = planTitle;
    }

    public void setPlanAmount(Number planAmount) {
        this.planAmount = planAmount;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    
    
    
}
