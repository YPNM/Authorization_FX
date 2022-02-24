package com.example.authorization_fx;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

public class Controller {

    private ObservableList<Tovar> tovarData = FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField bar_code;

    @FXML
    private Button buy;

    @FXML
    private TableColumn<Tovar, Integer> cost;

    @FXML
    private TableColumn<Tovar, Integer> count;

    @FXML
    private Button deny;

    @FXML
    private Text main_price;

    @FXML
    private TableColumn<Tovar, Integer> price;

    @FXML
    private TableView<Tovar> table;

    @FXML
    private TableColumn<Tovar, String> tovar;

    @FXML
    void initialize() throws SQLException {
        BD_connect DB = new BD_connect();
        Connection work_db = DB.DB_Connect();
        Cart cart = new Cart();
        tovar.setCellValueFactory(new PropertyValueFactory<Tovar, String>("Name"));
        price.setCellValueFactory(new PropertyValueFactory<Tovar, Integer>("Price"));
        count.setCellValueFactory(new PropertyValueFactory<Tovar, Integer>("count"));
        cost.setCellValueFactory(new PropertyValueFactory<Tovar,Integer>("cost"));
        table.setEditable(true);

        EventHandler<ActionEvent> add_tov = new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e)
            {
                cart.add_tov(bar_code.getText());
                try {
                    Tovar tov = new Tovar(cart.last_tov(), cart.get_tov_name(cart.last_tov()),
                            cart.get_tov_price(cart.last_tov()));
                    System.out.println(tov.getName());
                    System.out.println(tov.getBar_code());
                    System.out.println(tov.getCost());
                    System.out.println(tov.getPrice());
                    System.out.println(cart.tovars);
                    table.getItems().add(tov);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                bar_code.clear();
            }

        };
        bar_code.setOnAction(add_tov);


    }

}
