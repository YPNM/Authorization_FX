package com.example.authorization_fx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
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
    private MenuItem about;

    @FXML
    private MenuItem add_tovar;

    @FXML
    private TextField bar_code;

    @FXML
    private TableColumn<?, ?> cost;

    @FXML
    private TableColumn<?, ?> count;

    @FXML
    private Button deny;

    @FXML
    private Text final_price;

    @FXML
    private TableView<?> main_table;

    @FXML
    private Button pay;

    @FXML
    private TableColumn<?, ?> price;

    @FXML
    private TableColumn<?, ?> tovar;

    @FXML
    void initialize() {
        assert about != null : "fx:id=\"about\" was not injected: check your FXML file 'fxml.fxml'.";
        assert add_tovar != null : "fx:id=\"add_tovar\" was not injected: check your FXML file 'fxml.fxml'.";
        assert bar_code != null : "fx:id=\"bar_code\" was not injected: check your FXML file 'fxml.fxml'.";
        assert cost != null : "fx:id=\"cost\" was not injected: check your FXML file 'fxml.fxml'.";
        assert count != null : "fx:id=\"count\" was not injected: check your FXML file 'fxml.fxml'.";
        assert deny != null : "fx:id=\"deny\" was not injected: check your FXML file 'fxml.fxml'.";
        assert final_price != null : "fx:id=\"final_price\" was not injected: check your FXML file 'fxml.fxml'.";
        assert main_table != null : "fx:id=\"main_table\" was not injected: check your FXML file 'fxml.fxml'.";
        assert pay != null : "fx:id=\"pay\" was not injected: check your FXML file 'fxml.fxml'.";
        assert price != null : "fx:id=\"price\" was not injected: check your FXML file 'fxml.fxml'.";
        assert tovar != null : "fx:id=\"tovar\" was not injected: check your FXML file 'fxml.fxml'.";

    }

}