/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dao;

import com.example.model.*;
import java.util.*;

/**
 *
 * @author Syed Abbas
 */

// Stores the application data.

public class MockDatabase {

    // stores all the rooms
    public static final List<Room> rooms = new ArrayList<>();

    // stores all the sensors
    public static final List<Sensor> sensors = new ArrayList<>();

    // stores readings grouped from sensor ID
    public static final Map<String, List<SensorReading>> readings = new HashMap<>();

    static {
        // sample room 
        rooms.add(new Room("LIB-301", "Library Study", 50));

        // active sensor in the room
        sensors.add(new Sensor("TEMP-001", "Temperature", "ACTIVE", 22.5, "LIB-301"));
        
        // sensor currently under maintenance
        sensors.add(new Sensor("TEMP-002", "Temperature", "MAINTENANCE", 20, "LIB-301"));
        
        
        // active sensor with CO2 sensor type for filtering test
        sensors.add(new Sensor("CO2-001", "CO2", "ACTIVE", 50, "ENG-201"));

        // initialise readings 
        readings.put("TEMP-001", new ArrayList<>());

        // initialise readings
        readings.put("TEMP-002", new ArrayList<>());
        
         // initialise readings
        readings.put("CO2-001", new ArrayList<>()); 
    }
}