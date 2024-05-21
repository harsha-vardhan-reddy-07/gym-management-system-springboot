package com.server.models;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;

@Getter
@Document(collection = "equipment")
public class EquipmentModel {

    public String _id;
    public String name;
    public String description;
    public String image;
    public String targetMuscles;
    public String type;
    public Number quantity;

    public EquipmentModel(){}

    public String get_id() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public String getTargetMuscles() {
        return targetMuscles;
    }

    public String getType() {
        return type;
    }

    public Number getQuantity() {
        return quantity;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setTargetMuscles(String targetMuscles) {
        this.targetMuscles = targetMuscles;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setQuantity(Number quantity) {
        this.quantity = quantity;
    }

    
    
    
}
