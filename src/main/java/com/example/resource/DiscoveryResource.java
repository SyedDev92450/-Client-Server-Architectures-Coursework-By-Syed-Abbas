/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.resource;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.*;

/**
 *
 * @author Syed Abbas
 */

// root endpoint for all the information
@Path("")
public class DiscoveryResource {

    
    @GET

    // returns the response
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getInfo() {

        // main response data
        Map<String, Object> data = new HashMap<>();

        // version info
        data.put("version", "v1");

        // admin contact details
        data.put("contact", "admin@campus.com");

        // available resource endpoints
        Map<String, String> resources = new HashMap<>();
        resources.put("rooms", "/api/v1/rooms");
        resources.put("sensors", "/api/v1/sensors");

        
        data.put("resources", resources);
        
        return data;
    }
}