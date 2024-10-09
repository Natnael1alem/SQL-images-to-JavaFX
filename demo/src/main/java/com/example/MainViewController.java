package com.example;

import java.io.IOException;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.layout.TilePane;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class MainViewController {

    @FXML
    private TilePane carTilePane;

    @FXML
    private void initialize() {
        loadCars();
    }

    private void loadCars() {
        List<Car> cars = DatabaseUtil.getAllCars();
        for (Car car : cars) {
            VBox carCard = createCarCard(car);
            carTilePane.getChildren().add(carCard);
        }
    }

    private VBox createCarCard(Car car) {
        VBox card = new VBox();
        card.setSpacing(10);
        card.setPadding(new Insets(10));
        card.setAlignment(Pos.CENTER_LEFT);
        card.setStyle("-fx-border-color: #2e3b4e; -fx-border-width: 2px; -fx-background-color: #f0f0f0;");
        
        Label makeLabel = new Label("Make: " + car.getMake());
        makeLabel.setFont(new Font(16));
        
        Label modelLabel = new Label("Model: " + car.getModel());
        modelLabel.setFont(new Font(16));
        
        Label yearLabel = new Label("Year: " + car.getYear());
        yearLabel.setFont(new Font(16));
        
        Label priceLabel = new Label("Price: " + car.getPrice());
        priceLabel.setFont(new Font(16));
        
        card.getChildren().addAll(makeLabel, modelLabel, yearLabel, priceLabel);
        
        return card;
    }

    @FXML
    private void switchToCarAddForm() throws IOException {
        App.setRoot("CarAddForm");
    }
}
