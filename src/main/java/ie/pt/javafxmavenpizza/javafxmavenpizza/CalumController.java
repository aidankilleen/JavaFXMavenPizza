package ie.pt.javafxmavenpizza.javafxmavenpizza;

import java.io.IOException;
import javafx.fxml.FXML;

public class CalumController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}

