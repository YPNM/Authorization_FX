package com.example.authorization_fx;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Controller {
    @FXML
    private Button admin;

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
        cost.setCellValueFactory(new PropertyValueFactory<Tovar, Integer>("Price"));
        count.setCellValueFactory(new PropertyValueFactory<Tovar, Integer>("count"));
        price.setCellValueFactory(new PropertyValueFactory<Tovar,Integer>("cost"));
        table.setEditable(true);
        ArrayList<Tovar> tovars = new ArrayList<>();
        Cassa cassa = new Cassa();

        EventHandler<ActionEvent> add_tov = new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e)
            {
                int counter = 0;
                int over_count = 0;
                cart.add_tov(bar_code.getText());

                try {
                    if(tovars.size() > 0) {
                        for (int i = 0; i < tovars.size(); ++i) {
                            if (Objects.equals(tovars.get(i).getBar_code(), bar_code.getText())) {
                                tovars.get(i).setCount();
                                counter++;
                            }
                        }
                        if(counter == 0){
                            tovars.add(new Tovar(cart.last_tov(), cart.get_tov_name(cart.last_tov()),
                                        cart.get_tov_price(cart.last_tov())));
                        }
                    }
                    else {
                        tovars.add(new Tovar(cart.last_tov(), cart.get_tov_name(cart.last_tov()),
                                cart.get_tov_price(cart.last_tov())));
                    }

                    table.getItems().clear();
                    table.getItems().addAll(tovars);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

                for(int i = 0;i<tovars.size();++i){
                    over_count += tovars.get(i).getCost();
                }
                main_price.setText(Integer.toString(over_count));
                bar_code.clear();
            }

        };
        bar_code.setOnAction(add_tov);

        EventHandler<ActionEvent> selling = new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e){
                cassa.setMoney(Integer.parseInt(main_price.getText()));
                for(int i = 0;i<tovars.size();++i){
                    cart.del_from_db(tovars.get(i));
                }
                table.getItems().clear();
                main_price.setText("0");
                tovars.clear();
            }
        };

        buy.setOnAction(selling);
        EventHandler<ActionEvent> clearing = new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e){
                table.getItems().clear();
                main_price.setText("0");
                tovars.clear();
            }
        };
        deny.setOnAction(clearing);

        EventHandler<ActionEvent> login = new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e){
                Parent root;
                try {
                    root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
                    Stage stage = new Stage();
                    stage.setTitle("Log In");
                    stage.setScene(new Scene(root));
                    stage.setResizable(false);
                    stage.show();
                }
                catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        };
        admin.setOnAction(login);
    }

}
