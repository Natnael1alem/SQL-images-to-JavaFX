package com.example;

import java.io.IOException;
import java.math.BigDecimal;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class CarAddFormController {

    @FXML
    private TextField makeField;
    @FXML
    private TextField modelField;
    @FXML
    private TextField yearField;
    @FXML
    private TextField priceField;

    @FXML
    private void saveCar() {
        try {
            String make = makeField.getText();
            String model = modelField.getText();
            int year = Integer.parseInt(yearField.getText());
            BigDecimal price = new BigDecimal(priceField.getText());

            Car newCar = new Car(make, model, year, price);
            DatabaseUtil.addCar(newCar);

            switchToMainView();
        } catch (Exception e) {
            showAlert("Error", "Failed to save car: " + e.getMessage());
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
