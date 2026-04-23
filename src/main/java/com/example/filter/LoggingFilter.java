/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.filter;

import javax.ws.rs.container.*;
import javax.ws.rs.ext.Provider;
import java.util.logging.Logger;

/**
 *
 * @author Syed Abbas
 */

@Provider // registers the filters for all requests and responses
public class LoggingFilter implements ContainerRequestFilter, ContainerResponseFilter {

    
    private static final Logger logger = Logger.getLogger(LoggingFilter.class.getName());

    @Override
    public void filter(ContainerRequestContext request) {

        // log incoming request details
        logger.info("--- Request ---");
        logger.info("Method: " + request.getMethod());
        logger.info("URI: " + request.getUriInfo().getAbsolutePath());
    }

    @Override
    public void filter(ContainerRequestContext req, ContainerResponseContext res) {

        // log outgoing response status
        logger.info("--- Response ---");
        logger.info("Status: " + res.getStatus());
    }
}