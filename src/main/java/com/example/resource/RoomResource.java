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
import java.util.List;

/**
 *
 * @author Syed Abbas
 */

// resource for  managing rooms

@Path("/rooms")
public class RoomResource {

    // DAO for room data
    private GenericDAO<Room> roomDAO = new GenericDAO<>(MockDatabase.rooms);

    // DAO for sensor data
    private GenericDAO<Sensor> sensorDAO = new GenericDAO<>(MockDatabase.sensors);

    // get all rooms
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Room> getAllRooms() {
        return roomDAO.getAll();
    }

    // get room by ID
    @GET
    @Path("/{roomId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Room getRoom(@PathParam("roomId") String roomId) {

        // find the room
        Room room = roomDAO.getById(roomId);

        // throw error if not found
        if (room == null) {
            throw new LinkedResourceNotFoundException("Room not found");
        }

        return room;
    }

    // add new room
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Room addRoom(Room room) {
        roomDAO.add(room);
        return room;
    }

    // delete the room by ID
    @DELETE
    @Path("/{roomId}")
    public void deleteRoom(@PathParam("roomId") String roomId) {

        // find room
        Room room = roomDAO.getById(roomId);

        // throw error if not found
        if (room == null) {
            throw new LinkedResourceNotFoundException("Room not found");
        }

        // check if room has sensors
        for (Sensor sensor : sensorDAO.getAll()) {
            if (sensor.getRoomId().equals(roomId)) {
                // prevent deletion if sensors exist
                throw new RoomNotEmptyException("Room has active sensors");
            }
        }

        // delete room
        roomDAO.delete(roomId);
    }
}