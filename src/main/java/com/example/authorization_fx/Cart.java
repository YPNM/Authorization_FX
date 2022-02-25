package com.example.authorization_fx;

import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;
import java.util.function.DoubleToIntFunction;
import java.util.jar.Attributes;

public class Cart {
    BD_connect bd = new BD_connect();
    ArrayList<String> tovars = new ArrayList<String>();

    void Check_count(String Bar_Code) throws SQLException {
        String sql = "SELECT count FROM product WHERE bar_code = " + Bar_Code;
        Statement statement = bd.getConnection().createStatement();
        ResultSet result = statement.executeQuery(sql);
        if(result.getInt("count") > 0) {
            System.out.println("Товар нашли");
        }
    }

    void add_tov(String Bar_Code){
        tovars.add(Bar_Code);
    }

    String last_tov(){return tovars.get(tovars.size()-1);}

    String get_tov_name(String Bar_Code) throws SQLException {
        String sql = "SELECT pr_name FROM product WHERE bar_code = '" + Bar_Code + "'";
        Connection conn = bd.DB_Connect();
        String Name = "";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Name = resultSet.getString("pr_name");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return Name;

    }
    int get_tov_price(String Bar_Code) throws SQLException {
        String sql = "SELECT price FROM product WHERE bar_code = '" + Bar_Code + "'";
        Connection conn = bd.DB_Connect();
        int Price = 0;
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Price = resultSet.getInt("price");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return Price;
    }

    int get_tov_count(String Bar_Code){
        int counter = 1;
        for(int i = 0;i<tovars.size();i++){
            if(tovars.get(i) == Bar_Code){
                counter++;
            }
        }
        return counter;
    }

    boolean del_from_db(Tovar tovar){
        Connection conn = bd.DB_Connect();
        String sql_get = "SELECT counts from product where bar_code = '" + tovar.getBar_code() + "'";
        int count = 0;
        try {
            PreparedStatement statement = conn.prepareStatement(sql_get);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                count = resultSet.getInt("counts");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        count -= tovar.getCount();
        String sql = "UPDATE product SET counts = '" + count + "' where bar_code = '" + tovar.getBar_code() + "'";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
        return true;
    }
}
