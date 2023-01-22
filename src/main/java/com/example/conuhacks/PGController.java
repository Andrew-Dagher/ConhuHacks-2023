package com.example.conuhacks;


import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class PGController {

    @FXML
    private JFXButton buttonGeneratePassword;

    @FXML
    private JFXButton closeButtonPG;

    @FXML
    void buttonGeneratePassword(ActionEvent event) {

    }

    @FXML
    void closeButtomMainMenuAction(ActionEvent event) {

    }

    public void closeButtonPasswordGenerator(ActionEvent actionEvent) {
        Platform.exit();

    }
}

