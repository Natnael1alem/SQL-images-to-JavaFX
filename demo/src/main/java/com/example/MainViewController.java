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
    private TilePane pTilePane;

    @FXML
    private void initialize() {
        loadPersons();
    }

    private void loadPersons() {
        List<Person> ps = DatabaseUtil.getAllPersons();
        for (Person p : ps) {
            VBox pCard = createPersonCard(p);
            pTilePane.getChildren().add(pCard);
        }
    }

    private VBox createPersonCard(Person p) {
        VBox card = new VBox();
        card.setSpacing(10);
        card.setPadding(new Insets(10));
        card.setAlignment(Pos.CENTER_LEFT);
        card.setStyle("-fx-border-color: #2e3b4e; -fx-border-width: 2px; -fx-background-color: #f0f0f0;");
        
        Label nameLabel = new Label("Name: " + p.getName());
        nameLabel.setFont(new Font(16));
        
        card.getChildren().addAll(nameLabel);
        
        return card;
    }

    @FXML
    private void switchToPersonAddForm() throws IOException {
        App.setRoot("PersonAddForm");
    }
}
