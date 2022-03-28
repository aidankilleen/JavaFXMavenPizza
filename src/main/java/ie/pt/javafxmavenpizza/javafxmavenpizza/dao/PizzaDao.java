/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.pt.javafxmavenpizza.javafxmavenpizza.dao;

import java.sql.*;
import java.util.*;

/**
 *
 * @author admin
 */
public class PizzaDao {
        private Connection conn;
    private String connectionString = "jdbc:derby://localhost:1527/pizzadatabase";
    
    public PizzaDao() {
        
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection(connectionString, "username", "password");
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Can't load driver");
        } catch (SQLException ex) {
            System.out.println("Can't connect to " + connectionString);
        }
        
    }
    
    public List<Pizza> getPizzas() {

        List<Pizza>pizzas = new ArrayList<Pizza>();
        
        try {

            Statement stmt = conn.createStatement();

            String sql = "SELECT * FROM pizza";

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                int id = rs.getInt("ID");
                String name = rs.getString("TYPE");
                double price = rs.getInt("PRICE");

                Pizza pizza = new Pizza(id, name, price);
                pizzas.add(pizza);
            }

            rs.close();
            stmt.close();
        } catch(Exception ex) {
            System.out.println("something went wrong...");
        }

        return pizzas;
    }
           
    public Pizza addPizza(Pizza pizzaToAdd) {
        
        try {

            Statement stmt = conn.createStatement();

            String sql = "INSERT INTO pizza (TYPE, PRICE) VALUES('" + pizzaToAdd.getType() + "', " + pizzaToAdd.getPrice() + ")";
            
            System.out.println(sql);
            
            stmt.executeUpdate(sql);
            
            stmt.close();
            
        } catch(Exception ex) {
            System.out.println("something went wrong...");
            System.out.println(ex.getMessage());
        }
        
        return pizzaToAdd;
    }

}
