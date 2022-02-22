module com.example.authorization_fx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.authorization_fx to javafx.fxml;
    exports com.example.authorization_fx;
}