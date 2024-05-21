package com.server.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;

@Getter
@Document(collection = "monthlyplans")
public class MonthlyPlansModel {
    
    public String _id;
    public String title;
    public String description;
    public String image;
    public Number amount;
    public Number duration;
    public List<String> subscribers = new ArrayList<String>();

    public MonthlyPlansModel(){}

    public String get_id() {
        return _id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public Number getAmount() {
        return amount;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setAmount(Number amount) {
        this.amount = amount;
    }

    public void setDuration(Number duration) {
        this.duration = duration;
    }

    public void setSubscribers(List<String> subscribers) {
        this.subscribers = subscribers;
    }

    
}
