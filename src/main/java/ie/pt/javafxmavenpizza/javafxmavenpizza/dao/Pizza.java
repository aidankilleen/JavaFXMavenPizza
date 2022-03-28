/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.pt.javafxmavenpizza.javafxmavenpizza.dao;

/**
 *
 * @author admin
 */
public class Pizza {
    private int id;
    private String type;
    private double price;
    
    public Pizza() {
        
    }

    public Pizza(int id, String type, double price) {
        this.id = id;
        this.type = type;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
  
    @Override
    public String toString() {
        return type;
    }
}
