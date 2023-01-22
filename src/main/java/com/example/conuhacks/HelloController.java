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
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void closeButtomMainMenuAction(ActionEvent actionEvent) {
        System.out.println("[APP] Application closed.");
        Platform.exit();
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
            stagePG.setScene(scene);
            stagePG.show();
            stagePG.setResizable(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void dragBar_trigger(MouseDragEvent mouseDragEvent) {
        System.out.println("clicked enter");
        Stage stage = (Stage) openPasswordGenerator.getScene().getWindow();
        stage.setY(mouseDragEvent.getScreenY() - y);
        stage.setX(mouseDragEvent.getScreenX() - x);
    }

    public void dragBar_trigger_exit(MouseDragEvent mouseDragEvent) {
        System.out.println("clicked exit");
        x = mouseDragEvent.getSceneX();
        y = mouseDragEvent.getSceneY();
    }

    public void dragBar_trigger_drag(DragEvent dragEvent) {
        System.out.println("drag enter");
    }

    public void dragBar_trigger_drag_exit(DragEvent dragEvent) {
        System.out.println("drag exit");
    }
}