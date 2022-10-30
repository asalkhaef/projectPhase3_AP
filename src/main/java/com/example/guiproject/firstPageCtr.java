package com.example.guiproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class firstPageCtr {
    @FXML
    void GoBuyProcess(MouseEvent event) {


    }

    @FXML
    void GoExit(MouseEvent event) {

    }

    @FXML
    void GoProductPage(MouseEvent event) {

    }

    @FXML
    void goAccountPage(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("accountPage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

}
