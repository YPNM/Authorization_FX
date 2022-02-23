package com.example.authorization_fx;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Cart {
    BD_connect bd = new BD_connect();
    ArrayList<String> tovars = new ArrayList<String>();

    void Check_count(String Bar_Code) throws SQLException {
        String sql = "SELECT count FROM product WHERE bar_code = " + Bar_CODE;
        Statement statement = bd.getConnection().createStatement();
        ResultSet result = statement.executeQuery(sql);
        if(result.getInt("count") > 0) {
            System.out.println("Товар нашли");
        }
    }

    void add_tov(String Bar_Code){
        tovars.add(Bar_Code);
    }

    String get_tov_name(String Bar_Code) throws SQLException {
        String sql = "SELECT pr_name FROM product WHERE bar_code = " + Bar_Code;
        Statement statement = bd.getConnection().createStatement();
        ResultSet result = statement.executeQuery(sql);
        return result.getString("pr_name");
    }

}
