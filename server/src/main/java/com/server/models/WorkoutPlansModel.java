package com.server.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;

@Getter
@Document(collection = "workoutplans")
public class WorkoutPlansModel {
    
    public String _id;
    public String title;
    public String image;
    public String targetMuscles;
    public String trainer;
    public String trainerId;
    public Number duration;
    public List<String> subscribers = new ArrayList<String>();

    public WorkoutPlansModel(){}

    public String get_id() {
        return _id;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
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

    public List<String> getSubscribers() {
        return subscribers;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(String image) {
        this.image = image;
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

    public void setSubscribers(List<String> subscribers) {
        this.subscribers = subscribers;
    }

    
}
