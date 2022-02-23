package com.example.authorization_fx;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField bar_code;

    @FXML
    private Button buy;

    @FXML
    private TableColumn<?, ?> cost;

    @FXML
    private TableColumn<?, ?> count;

    @FXML
    private Button deny;

    @FXML
    private Text main_price;

    @FXML
    private TableColumn<?, ?> price;

    @FXML
    private TableView<?> table;

    @FXML
    private TableColumn<?, ?> tovar;

    @FXML
    void initialize() throws SQLException {
        BD_connect DB = new BD_connect();
        Connection work_db = DB.DB_Connect();
        Cart cart = new Cart();
        cart.Check_count("4870071000195");
    }

}
