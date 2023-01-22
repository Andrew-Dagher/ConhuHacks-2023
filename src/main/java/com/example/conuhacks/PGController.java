package com.example.conuhacks;

import Func.Utils;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class PGController {

    @FXML
    void buttonAddKeyword(ActionEvent event) {

    }
    @FXML
    private JFXTextField outputGeneratePassword;

    @FXML
    private Text keywordsList;

    @FXML
    private JFXTextField outputGeneratePassword1;

    @FXML
    private JFXCheckBox checkRandom;

    @FXML
    private JFXButton btnClearKeywords;

    @FXML
    private JFXButton buttonAddKeywords;


    @FXML
    private AnchorPane anchorPanePg;

    private boolean isGenerating = false;
    private double x = 0;
    private double y = 0;
    private ArrayList<String> keywords = new ArrayList<String>();

    public void buttonGeneratePassword(ActionEvent actionEvent) throws IOException{
        if (keywords.size() == 0 && !checkRandom.isSelected()) return;
        keywordsList.setText("Keywords: ");
        keywordsList.setVisible(false);
        buttonAddKeywords.setVisible(false);
        outputGeneratePassword.setVisible(false);
        outputGeneratePassword1.setVisible(true);
        System.out.println("[APP] Application generated a password.");
        Utils a = new Utils();
        boolean doRandom = false;
        if (checkRandom.isSelected()) {
            doRandom = true;
            ArrayList<String> arr = a.runPyScript("src/main/java/Python Scripts/Recommended_Password.py", new String[]{doRandom + "", "[]"});
            outputGeneratePassword1.setText(arr.get(0));
        } else {
            String pythonFeed= "";
            for (int i = 0; i < keywords.size(); i++){
                pythonFeed += keywords.get(i) + " ";
            }
            ArrayList<String> arr = a.runPyScript("src/main/java/Python Scripts/Recommended_Password.py", new String[]{doRandom+"",pythonFeed});
            outputGeneratePassword1.setText(arr.get(0));
        }
        btnClearKeywords.setText("Reset");
        isGenerating = true;
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

    public void btnClearKeywordsAction(ActionEvent actionEvent) {
        if (isGenerating) {
            keywords.clear();
            System.out.println("[APP] Reseting PG Menu");
            outputGeneratePassword1.setVisible(false);
            keywordsList.setText("Keywords: ");
            keywordsList.setVisible(true);
            buttonAddKeywords.setVisible(true);
            outputGeneratePassword.setVisible(true);
            return;
        }
        keywordsList.setText("Keywords: ");
        keywords.clear();
    }

    public void buttonAddKeywordsAction(ActionEvent actionEvent) {
        String keyword = outputGeneratePassword.getText();
        String curList = keywordsList.getText();
        keywordsList.setText(curList+keyword+", ");
        outputGeneratePassword.setText("");
        keywords.add(keyword);
    }
}
