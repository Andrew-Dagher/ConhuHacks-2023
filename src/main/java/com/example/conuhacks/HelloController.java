package com.example.conuhacks;

import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class HelloController {
    @FXML
    private Label welcomeText;


    @FXML
    private JFXButton closeButtonMainMenu;

    @FXML
    protected void closeButtonMainMenuAction(ActionEvent event) {
        System.out.println("clicked");
    }

    @FXML
    protected void openPasswordTestAction() {
        System.out.println("[APP] Opening Password Testing Menu");
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void closeButtomMainMenuAction(ActionEvent actionEvent) {
        System.out.println("[APP] Application closed.");
        Platform.exit();
    }
}