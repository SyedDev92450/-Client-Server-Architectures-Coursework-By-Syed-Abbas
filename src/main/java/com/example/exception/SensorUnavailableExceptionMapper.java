/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.exception;

import com.example.model.ErrorMessage;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.*;


/**
 *
 * @author Syed Abbas
 */

@Provider 
public class SensorUnavailableExceptionMapper implements ExceptionMapper<SensorUnavailableException> {

    @Override
    public Response toResponse(SensorUnavailableException ex) {

        // return HTTP 403 when sensor is unavailable
        return Response.status(403)
                .entity(new ErrorMessage(ex.getMessage()))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}