/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.resource;



import com.example.dao.*;
import com.example.model.*;
import com.example.exception.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.*;

/**
 *
 * @author Syed Abbas
 */

// resource for managing the sensors
@Path("/sensors")
public class SensorResource {

    // DAO for sensors
    private GenericDAO<Sensor> sensorDAO = new GenericDAO<>(MockDatabase.sensors);

    // get sensors (with filter type)
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Sensor> getSensors(@QueryParam("type") String type) {

        // return all if no filter is applied
        if (type == null) {
            return sensorDAO.getAll();
        }

        // filtered result list
        List<Sensor> result = new ArrayList<>();

        // filter sensors by type
        for (Sensor s : sensorDAO.getAll()) {
            if (s.getType().equalsIgnoreCase(type)) {
                result.add(s);
            }
        }

        return result;
    }

    // add the new sensor
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Sensor addSensor(Sensor sensor) {

        // check if the room exists
        boolean roomExists = false;

        for (Room room : MockDatabase.rooms) {
            if (room.getId().equals(sensor.getRoomId())) {
                roomExists = true;

                // link the sensor to room
                room.getSensorIds().add(sensor.getId());
            }
        }

        // throw error if room not found
        if (!roomExists) {
            throw new LinkedResourceNotFoundException("Room does not exist");
        }

        // add sensor to the database
        sensorDAO.add(sensor);

        // list for sensor
        MockDatabase.readings.put(sensor.getId(), new ArrayList<>());

        return sensor;
    }

    // sub-resource for the sensor readings
    @Path("/{sensorId}/readings")
    public SensorReadingResource getReadings(@PathParam("sensorId") String sensorId) {

        // return readings for the sensor
        return new SensorReadingResource(sensorId);
    }
}