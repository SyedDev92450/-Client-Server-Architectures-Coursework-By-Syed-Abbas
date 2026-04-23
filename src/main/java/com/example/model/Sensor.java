/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;

/**
 *
 * @author Syed Abbas
 */

// model for representing a sensor
public class Sensor implements BaseModel {
    
    private String id;

    // sensor type i.e: temperature, CO2)
    private String type;
    
    private String status;
    
    // latest recorded value
    private double currentValue;

    // ID of the room the sensor belongs to
    private String roomId;

   
    public Sensor() {}

    
    public Sensor(String id, String type, String status, double currentValue, String roomId) {
        this.id = id;
        this.type = type;
        this.status = status;
        this.currentValue = currentValue;
        this.roomId = roomId;
    }

    // returns the sensor ID
    @Override
    public String getId() { 
        return id;
    }

    // sets  the sensor ID
    @Override
    public void setId(String id) {
        this.id = id;
    }

    // returns the sensor type
    public String getType() {
        return type; 
    }

    // sets the sensor type
    public void setType(String type) {
        this.type = type; 
    }

    // returns the sensor status
    public String getStatus() {
        return status; 
    }

    // sets the sensor status
    public void setStatus(String status) {
        this.status = status; 
    }

    // returns the current value
    public double getCurrentValue() {
        return currentValue; 
    }

    // updates the current value
    public void setCurrentValue(double currentValue) {
        this.currentValue = currentValue; 
    }

    // returns the room ID
    public String getRoomId() {
        return roomId; 
    }

    // sets the room ID
    public void setRoomId(String roomId) {
        this.roomId = roomId; 
    }
}