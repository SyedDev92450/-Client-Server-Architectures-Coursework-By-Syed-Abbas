/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;

/**
 *
 * @author Syed Abbas
 */

// The base interface used for all models with an ID
public interface BaseModel {
    
    // returns the unique ID
    String getId();

    // sets the unique ID
    void setId(String id);
}