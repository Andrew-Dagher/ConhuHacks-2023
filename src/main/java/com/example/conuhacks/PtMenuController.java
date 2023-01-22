package com.example.conuhacks;

import Func.Utils;
import com.jfoenix.controls.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PtMenuController implements Initializable {


    @FXML
    private ProgressBar complexityBar;

    @FXML
    private JFXTextField inputTestingPassword;
    


    @FXML
    private Text complexityResult;
    @FXML
    private JFXCheckBox checkListLength;

    @FXML
    private JFXCheckBox checkListCharacter;

    @FXML
    private JFXCheckBox checkListUpper;

    @FXML
    private JFXPasswordField inputPassField;

    @FXML
    private JFXCheckBox checkListNumber;

    @FXML
    private Text cracktimeResult;

    @FXML
    private JFXButton closeButtonPT;

    @FXML
    void closeButtomPGAction(ActionEvent event) {
        Func.Utils.logClose();

    }
    @FXML
    void BackButtomPTAction(ActionEvent event) {
        System.out.println("[APP] Application went back to Main-Menu");
        closeButtonPT.getScene().getWindow().hide();
        Stage stagePG = new Stage();
        stagePG.initStyle(StageStyle.UNDECORATED);
        try{
            URL fxmlLocation = HelloController.class.getResource("main-menu.fxml");
            FXMLLoader loader = new FXMLLoader(fxmlLocation);
            Parent root = loader.load(fxmlLocation);
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
            stagePG.setScene(scene);
            stagePG.show();
            stagePG.setResizable(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setComplexityBar(String strength, String crackTime){
        System.out.println("called");
        if (!(strength.equals("weak") || strength.equals("repetitive") || strength.equals("very weak") || strength.equals("common") || strength.equals("medium") || strength.equals("strong") || strength.equals("very strong"))) return;
        System.out.println("[APP] Set Complexity Bar");
        cracktimeResult.setText(crackTime);
        if (strength.equals("very weak")){
            complexityBar.setStyle("-fx-accent: #8B0000;");
            complexityBar.setProgress(0.2);
            complexityResult.setText("Very Weak");
        }else if (strength.equals("weak")){
            complexityBar.setStyle("-fx-accent: #FF0000;");
            complexityBar.setProgress(0.4);
            complexityResult.setText("Weak");
        } else if (strength.equals("medium")){
            complexityBar.setStyle("-fx-accent: #FFAC1C;");
            complexityBar.setProgress(0.6);
            complexityResult.setText("Medium");

        } else if (strength.equals("strong")){
            complexityBar.setStyle("-fx-accent: #90ee90;");
            complexityBar.setProgress(0.8);
            complexityResult.setText("Strong");
        } else if (strength.equals("very strong")){
            complexityBar.setStyle("-fx-accent: #1A6A1A;");
            complexityBar.setProgress(1.0);
            complexityResult.setText("Very Strong");
        } else if (strength.equals("common")){
            complexityBar.setStyle("-fx-accent: #8B0000");
            complexityBar.setProgress(1.0);
            complexityResult.setText("Very Common!");
        } else if (strength.equals("repetitive")){
            complexityBar.setStyle("-fx-accent: #8B0000");
            complexityBar.setProgress(1.0);
            complexityResult.setText("Very Repetitive!");
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        complexityBar.setProgress(1);
        complexityBar.setStyle("-fx-accent: #00FF00;");
    }

    public void buttonTestPassword(ActionEvent actionEvent) throws IOException {
        System.out.println("[APP] Application running password strength test");
        Utils a = new Utils();
        if (inputTestingPassword.isVisible()) {
            ArrayList<String> arr = a.runPyScript("src/main/java/Python Scripts/PassWordClass.py",new String[]{inputTestingPassword.getText()});
            setComplexityBar(arr.get(0),arr.get(1));
            return;
        }
        if (inputPassField.isVisible()){
            ArrayList<String> arr = a.runPyScript("src/main/java/Python Scripts/PassWordClass.py",new String[]{inputPassField.getText()});
            setComplexityBar(arr.get(0),arr.get(1));
            return;
        }

    }


    public void updateCheckList(KeyEvent keyEvent) throws IOException {
        Utils a = new Utils();
        if (a.hasCapitalLetter(inputTestingPassword))
            checkListUpper.setSelected(true);
        else
            checkListUpper.setSelected(false);
        if (a.hasNumbers(inputTestingPassword))
            checkListNumber.setSelected(true);
        else
            checkListNumber.setSelected(false);
        if (a.hasLength(inputTestingPassword))
            checkListLength.setSelected(true);
        else
            checkListLength.setSelected(false);
        if (a.hasSpecialCharacter(inputTestingPassword))
            checkListCharacter.setSelected(true);
        else
            checkListCharacter.setSelected(false);
    }

    public void undoCheck(ActionEvent actionEvent) {
        checkListLength.setSelected(false);
    }

    public void undoCheckChar(ActionEvent actionEvent) {
        checkListCharacter.setSelected(false);
    }

    public void undoCheckUpper(ActionEvent actionEvent) {
        checkListUpper.setSelected(false);
    }

    public void undoCheckNumber(ActionEvent actionEvent) {
        checkListNumber.setSelected(false);
    }

    public void checkHideAction(ActionEvent actionEvent) {
        if (inputPassField.isVisible()) {
            inputPassField.setVisible(false);
            inputTestingPassword.setVisible(true);
            inputTestingPassword.setText(inputPassField.getText());

            return;
        }
        if (inputTestingPassword.isVisible()){
            inputPassField.setVisible(true);
            inputTestingPassword.setVisible(false);
            inputPassField.setText(inputTestingPassword.getText());
            return;
        }

    }

    public void updateCheckListPassword(KeyEvent keyEvent) {
        Utils a = new Utils();
        if (a.hasCapitalLetterP(inputPassField))
            checkListUpper.setSelected(true);
        else
            checkListUpper.setSelected(false);
        if (a.hasNumbersP(inputPassField))
            checkListNumber.setSelected(true);
        else
            checkListNumber.setSelected(false);
        if (a.hasLengthP(inputPassField))
            checkListLength.setSelected(true);
        else
            checkListLength.setSelected(false);
        if (a.hasSpecialCharacterP(inputPassField))
            checkListCharacter.setSelected(true);
        else
            checkListCharacter.setSelected(false);
    }
}
