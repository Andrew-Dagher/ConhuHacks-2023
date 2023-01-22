package com.example.conuhacks;

import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;


public class HelloController {
    @FXML
    private Label welcomeText;


    @FXML
    private JFXButton closeButtonMainMenu;

    @FXML
    private JFXButton openPasswordGenerator;

    @FXML
    private JFXButton openPasswordTest;

    @FXML
    private BorderPane dragBar;

    private double x = 0;
    private double y = 0;

    @FXML
    protected void closeButtonMainMenuAction(ActionEvent event) {
        System.out.println("clicked");
    }

    @FXML
    protected void openPasswordTestAction() {
        System.out.println("[APP] Opening Password Testing Menu");
        openPasswordGenerator.getScene().getWindow().hide();
        Stage stagePG = new Stage();
        stagePG.initStyle(StageStyle.UNDECORATED);
        try{
            URL fxmlLocation = HelloController.class.getResource("pt-menu.fxml");
            FXMLLoader loader = new FXMLLoader(fxmlLocation);
            Parent root = loader.load(fxmlLocation);
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("PTstyle.css").toExternalForm());
            stagePG.setScene(scene);
            stagePG.show();
            stagePG.setResizable(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void closeButtomMainMenuAction(ActionEvent actionEvent) {
        Func.Utils.logClose();
    }

    public void openPasswordGeneratorMenu(ActionEvent actionEvent) {
        System.out.println("[APP] Password Generator Menu Opened");
        openPasswordGenerator.getScene().getWindow().hide();
        Stage stagePG = new Stage();
        stagePG.initStyle(StageStyle.UNDECORATED);
        try{
            URL fxmlLocation = HelloController.class.getResource("pg-menu.fxml");
//            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("menu.fxml"));
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
            scene.getStylesheets().add(getClass().getResource("PgStyle.css").toExternalForm());
            stagePG.setScene(scene);
            stagePG.show();
            stagePG.setResizable(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}