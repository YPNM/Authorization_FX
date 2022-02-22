package com.example.authorization_fx;

import java.net.URL;
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
    void initialize() {
        assert bar_code != null : "fx:id=\"bar_code\" was not injected: check your FXML file 'main-frame.fxml'.";
        assert buy != null : "fx:id=\"buy\" was not injected: check your FXML file 'main-frame.fxml'.";
        assert cost != null : "fx:id=\"cost\" was not injected: check your FXML file 'main-frame.fxml'.";
        assert count != null : "fx:id=\"count\" was not injected: check your FXML file 'main-frame.fxml'.";
        assert deny != null : "fx:id=\"deny\" was not injected: check your FXML file 'main-frame.fxml'.";
        assert main_price != null : "fx:id=\"main_price\" was not injected: check your FXML file 'main-frame.fxml'.";
        assert price != null : "fx:id=\"price\" was not injected: check your FXML file 'main-frame.fxml'.";
        assert table != null : "fx:id=\"table\" was not injected: check your FXML file 'main-frame.fxml'.";
        assert tovar != null : "fx:id=\"tovar\" was not injected: check your FXML file 'main-frame.fxml'.";

    }

}
