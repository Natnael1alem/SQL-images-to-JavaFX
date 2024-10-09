package com.example;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class PersonAddFormController {

    @FXML
    private TextField nameField;

    @FXML
    private void savePerson() {
        try {
            String name = nameField.getText();

            Person newP = new Person(name);
            DatabaseUtil.addPerson(newP);

            switchToMainView();
        } catch (Exception e) {
            showAlert("Error", "Failed to save person: " + e.getMessage());
        }
    }

    @FXML
    private void switchToMainView() throws IOException {
        App.setRoot("MainView");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
