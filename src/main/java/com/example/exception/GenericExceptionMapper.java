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
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable exception) {

        // creates the generic error message
        ErrorMessage error = new ErrorMessage("Internal server error");

        // return HTTP 500 response 
        return Response.status(500)
                       .entity(error)
                       .type(MediaType.APPLICATION_JSON)
                       .build();
    }
}