package com.example.guiproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class accountPageCtr {
    @FXML
    void editAccountBtn(MouseEvent event) {

    }

    @FXML
    void signInBtn(MouseEvent event) {

    }

    @FXML
    void signOutBtn(MouseEvent event) {

    }

    @FXML
    void signUpBtn(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("signUp.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();

    }
}
