module com.example.guiproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;


    opens com.example.guiproject to javafx.fxml;
    exports com.example.guiproject;
}