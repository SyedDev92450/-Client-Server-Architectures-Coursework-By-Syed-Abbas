/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.resource;

import com.example.dao.GenericDAO;
import com.example.dao.MockDatabase;
import com.example.model.Sensor;
import com.example.model.SensorReading;
import com.example.exception.SensorUnavailableException;
import com.example.exception.LinkedResourceNotFoundException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


/**
 *
 * @author Syed Abbas
 */

// sub-resource for the sensor readings
public class SensorReadingResource {

    private String sensorId;

    // receives sensorId from the resource
    public SensorReadingResource(String sensorId) {
        this.sensorId = sensorId;
    }

   
    // GET /sensors/{sensorId}/readings
    // Returns all readings for the sensor
     
    
    // get all readings for the sensor
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<SensorReading> getReadings() {

        // get the readings list
        List<SensorReading> list = MockDatabase.readings.get(sensorId);

        // throw error if not found
        if (list == null) {
            throw new LinkedResourceNotFoundException("Sensor readings not found");
        }

        return list;
    }

    
     // POST /sensors/{sensorId}/readings
     // Adds a new reading AND updates the sensor value
     

    // add new reading
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addReading(SensorReading reading) {

        // find the sensor by ID
        Sensor sensor = new GenericDAO<>(MockDatabase.sensors).getById(sensorId);

        // throw error if sensor not found
        if (sensor == null) {
            throw new LinkedResourceNotFoundException("Sensor not found");
        }

        // block if sensor is under maintenance
        if (sensor.getStatus().equalsIgnoreCase("MAINTENANCE")) {
            throw new SensorUnavailableException("Sensor is under maintenance");
        }

        // add reading to the sensor history
        MockDatabase.readings.get(sensorId).add(reading);

        // update sensor current value
        sensor.setCurrentValue(reading.getValue());
    }
}