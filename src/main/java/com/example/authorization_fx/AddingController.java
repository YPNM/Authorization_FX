package com.example.authorization_fx;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddingController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField bar_code;

    @FXML
    private Button button;

    @FXML
    private TextField count;

    @FXML
    private TextField name;

    @FXML
    private TextField price;

    @FXML
    void initialize() {
        bar_code.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    bar_code.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        price.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    price.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        count.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    count.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        EventHandler<ActionEvent> add = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(!Objects.equals(count.getText(), "") && !Objects.equals(price.getText(), "") &&
                        !Objects.equals(name.getText(), "") && !Objects.equals(bar_code.getText(), "")){
                    Connection conn = new BD_connect().DB_Connect();
                    String sql = "SELECT * FROM product WHERE bar_code ='" + bar_code.getText()+ "'";
                    try {
                        PreparedStatement st = conn.prepareStatement(sql);
                        ResultSet resultSet = st.executeQuery();
                        if(resultSet.next()){
                            int counts = resultSet.getInt("counts") + Integer.parseInt(count.getText());
                            String update_sql = "UPDATE product SET price = " + price.getText() + ", counts = " +
                                    counts + "WHERE bar_code = '" + bar_code.getText() + "'";
                            PreparedStatement updst = conn.prepareStatement(update_sql);
                            ResultSet updset = updst.executeQuery();
                        }
                        else{
                            String add_sql = "INSERT INTO product (bar_code, price, counts, pr_name) VALUES ('"
                                    + bar_code.getText() + "', " + price.getText() + ", " + count.getText() + ", '" + name.getText() + "')";
                            PreparedStatement insst = conn.prepareStatement(add_sql);
                            ResultSet insset = insst.executeQuery();
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                }
            }
        };
        button.setOnAction(add);
    }

}
