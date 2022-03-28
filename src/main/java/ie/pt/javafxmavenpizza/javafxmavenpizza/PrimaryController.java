package ie.pt.javafxmavenpizza.javafxmavenpizza;

import ie.pt.javafxmavenpizza.javafxmavenpizza.dao.Pizza;
import ie.pt.javafxmavenpizza.javafxmavenpizza.dao.PizzaDao;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

public class PrimaryController implements Initializable {
    
    @FXML
    ListView lstPizzas;
    
    private PizzaDao dao = new PizzaDao();
    
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
               
        List<Pizza> pizzas = dao.getPizzas();
        
        for(Pizza p : pizzas) {
            lstPizzas.getItems().add(p);
        }
    }
}
