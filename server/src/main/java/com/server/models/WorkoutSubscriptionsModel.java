package com.server.models;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;

@Getter
@Document(collection = "workoutPlanSubscription")
public class WorkoutSubscriptionsModel {
    
    public String _id;
    public String userId;
    public String username;
    public String email;
    public String planId;
    public String title;
    public String targetMuscles;
    public String trainer;
    public String trainerId;
    public Number duration;
    public String startDate;
    public String endDate;
    public String status = "In progress";

    public WorkoutSubscriptionsModel(){}

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

    public String getTitle() {
        return title;
    }

    public String getTargetMuscles() {
        return targetMuscles;
    }

    public String getTrainer() {
        return trainer;
    }

    public String getTrainerId() {
        return trainerId;
    }

    public Number getDuration() {
        return duration;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getStatus() {
        return status;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTargetMuscles(String targetMuscles) {
        this.targetMuscles = targetMuscles;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public void setTrainerId(String trainerId) {
        this.trainerId = trainerId;
    }

    public void setDuration(Number duration) {
        this.duration = duration;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
