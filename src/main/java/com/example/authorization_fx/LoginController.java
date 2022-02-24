package com.example.authorization_fx;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label ident;

    @FXML
    private TextField log;

    @FXML
    private Button log_button;

    @FXML
    private PasswordField pass;

    @FXML
    void initialize() {
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Connection conn = new BD_connect().DB_Connect();
                String sql = "SELECT * FROM autorization WHERE login ='" + log.getText() + "'";
                try {
                    PreparedStatement statement = conn.prepareStatement(sql);
                    ResultSet resultSet = statement.executeQuery();
                    if(resultSet.next()){
                        if(Objects.equals(resultSet.getString("pass"), pass.getText())){
                            Parent root;
                            try {
                                root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("adding.fxml")));
                                Stage stage = new Stage();
                                stage.setTitle("Добавить товар");
                                stage.setScene(new Scene(root));
                                stage.setResizable(false);
                                stage.show();
                                // Hide this current window (if this is what you want)
                                ((Node) actionEvent.getSource()).getScene().getWindow().hide();
                            }
                            catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        else{
                            ident.setText("Пароль неверный!");
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        } ;
        log_button.setOnAction(event);
    }

}
