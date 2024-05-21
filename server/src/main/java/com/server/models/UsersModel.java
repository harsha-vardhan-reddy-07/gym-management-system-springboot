package com.server.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;

@Getter
@Document(collection = "users")
public class UsersModel {
    
    public String _id;
    public String username;
    public String email;
    public String password;
    public String usertype;
    public List<String> workoutPlan = new ArrayList<String>();
    public String subscription = "";

    public UsersModel(){}

    public String get_id() {
        return _id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsertype() {
        return usertype;
    }

    public List<String> getWorkoutPlan() {
        return workoutPlan;
    }

    public String getSubscription() {
        return subscription;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public void setWorkoutPlan(List<String> workoutPlan) {
        this.workoutPlan = workoutPlan;
    }

    public void setSubscription(String subscription) {
        this.subscription = subscription;
    }

    

}


