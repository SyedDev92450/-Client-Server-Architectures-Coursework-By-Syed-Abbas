/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dao;

import com.example.model.BaseModel;
import java.util.List;

/**
 *
 * @author Syed Abbas
 */

// Handles data operations.
public class GenericDAO<T extends BaseModel> {

    private List<T> list; // stores all items in memory

    public GenericDAO(List<T> list) {
        this.list = list; // initialise the data source
    }

    // returns the items
    public List<T> getAll() {
        return list;
    }

    // finds the item by its ID
    public T getById(String id) {
        for (T item : list) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null; // returns null if not found
    }

    // adds a new item
    public void add(T item) {
        list.add(item);
    }

    // updates an existing item
    public void update(T item) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(item.getId())) {
                list.set(i, item);
                return;
            }
        }
    }

    // deletes item by ID
    public void delete(String id) {
        list.removeIf(item -> item.getId().equals(id));
    }
}