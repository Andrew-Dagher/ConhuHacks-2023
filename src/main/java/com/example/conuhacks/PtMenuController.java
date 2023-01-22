package com.example.conuhacks;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class PtMenuController {

    @FXML
    private JFXTextField inputTestingPassword;

    @FXML
    private JFXTextField complexityResult;

    @FXML
    private JFXTextField cracktimeResult;

    @FXML
    private JFXButton closeButtonPT;

    @FXML
    void closeButtomPGAction(ActionEvent event) {
        Func.Utils.logClose();

    }

}
