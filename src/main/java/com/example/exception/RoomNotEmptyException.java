/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.exception;

/**
 *
 * @author Syed Abbas
 */

// Exception when room still has sensors
public class RoomNotEmptyException extends RuntimeException {

    
    public RoomNotEmptyException(String message) {
        super(message);
    }
}