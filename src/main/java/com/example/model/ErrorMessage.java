/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;

/**
 *
 * @author Syed Abbas
 */

// model for error responses
public class ErrorMessage {

    // stores error message 
    private String message;

    
    public ErrorMessage() {}

    
    public ErrorMessage(String message) {
        this.message = message;
    }

    // returns the error message
    public String getMessage() { 
        return message; 
    }

    // sets the error message
    public void setMessage(String message) {
        this.message = message;
    }
}