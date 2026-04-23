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
public class RoomNotEmptyExceptionMapper implements ExceptionMapper<RoomNotEmptyException> {

    @Override
    public Response toResponse(RoomNotEmptyException ex) {

        // return HTTP 409 when room cannot be deleted
        return Response.status(409)
                .entity(new ErrorMessage(ex.getMessage()))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}