/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;

/**
 *
 * @author Syed Abbas
 */

// model representing a sensor reading
public class SensorReading implements BaseModel {

    // The sensor reading ID
    private String id;

    // time of reading (in ms)
    private long timestamp;

    //  the recorded value
    private double value;

    
    public SensorReading() {}

    
    public SensorReading(String id, long timestamp, double value) {
        this.id = id;
        this.timestamp = timestamp;
        this.value = value;
    }

    // returns the sensor reading ID
    @Override
    public String getId() {
        return id; 
    }

    // sets the reading ID
    @Override
    public void setId(String id) {
        this.id = id;
    }

    // returns the timestamp
    public long getTimestamp() {
        return timestamp; 
    }

    // sets the timestamp
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp; 
    }

    // returns the value
    public double getValue() {
        return value; 
    }

    // sets the value
    public void setValue(double value) {
        this.value = value; 
    }
}