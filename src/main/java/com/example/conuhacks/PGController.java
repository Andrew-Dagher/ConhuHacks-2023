package com.example.conuhacks;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;

public class PGController {


    @FXML
    private AnchorPane anchorPanePg;

    private double x = 0;
    private double y = 0;


    public void buttonGeneratePassword(ActionEvent actionEvent) {
        System.out.println("[APP] Application generated a password.");;
    }

    public void closeButtonPasswordGenerator(ActionEvent actionEvent) {
        Func.Utils.logClose();
    }
    @FXML
    void BackButtonPGAction(ActionEvent event) {
        System.out.println("[APP] Application went back to Main-Menu");
        anchorPanePg.getScene().getWindow().hide();
        Stage stagePG = new Stage();
        stagePG.initStyle(StageStyle.UNDECORATED);
        try{
            URL fxmlLocation = HelloController.class.getResource("main-menu.fxml");
            FXMLLoader loader = new FXMLLoader(fxmlLocation);
            Parent root = loader.load(fxmlLocation);
            Scene scene = new Scene(root);

            scene.setOnMousePressed(mouseEvent -> {
                x = mouseEvent.getSceneX();
                y = mouseEvent.getSceneY();
            });

            scene.setOnMouseDragged(mouseEvent -> {
                stagePG.setX(mouseEvent.getScreenX() - x);
                stagePG.setY(mouseEvent.getScreenY() - y);
            });
            stagePG.setTitle("Hello!");
            stagePG.setScene(scene);
            stagePG.show();


            scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
            stagePG.setScene(scene);
            stagePG.show();
            stagePG.setResizable(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
