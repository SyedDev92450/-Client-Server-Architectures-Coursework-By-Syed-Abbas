/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Syed Abbas
 */

// model for representing a room
public class Room implements BaseModel {
    
    private String id;
    private String name;
    private int capacity;

    // list of sensor IDs in the room
    private List<String> sensorIds = new ArrayList<>();

    
    public Room() {}

    
    public Room(String id, String name, int capacity) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
    }

    // returns the room ID
    @Override
    public String getId() { 
        return id;
    }

    // sets the room ID
    @Override
    public void setId(String id) { 
        this.id = id; 
    }

    // returns the room name
    public String getName() { 
        return name; 
    }

    // sets the room name
    public void setName(String name) {
        this.name = name; 
    }

    // returns the capacity
    public int getCapacity() {
        return capacity; 
    }

    // sets the capacity
    public void setCapacity(int capacity) {
        this.capacity = capacity; 
    }

    // returns the  sensor IDs
    public List<String> getSensorIds() { 
        return sensorIds; 
    }

    // sets the sensor IDs
    public void setSensorIds(List<String> sensorIds) {
        this.sensorIds = sensorIds;
    }
}