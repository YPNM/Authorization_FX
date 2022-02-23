package com.example.authorization_fx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BD_connect {
    //STEP 1. Import required packages

    //  Database credentials
    static String DB_URL;
    static String DB_IP = "127.0.0.1";
    static String USER = "postgres";
    static String PASS = "Nastroika5!";
    public Connection connection = null;

    void setDB_IP(String ip){
            DB_IP = ip;
        }

    void setDBUser(String username){
            USER = username;
        }
    void setDBPass(String Password){
            PASS = Password;
        }

    Connection getConnection(){return connection;}

    void Generate_URL(){
            DB_URL = "jdbc:postgresql://" + DB_IP + ":5432/Java";
        }

        Connection DB_Connect() {
            System.out.println("Testing connection to PostgreSQL JDBC");

            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
                e.printStackTrace();
                return null;
            }

            System.out.println("PostgreSQL JDBC Driver successfully connected");
            Generate_URL();
            try {
                connection = DriverManager.getConnection(DB_URL, USER, PASS);

            } catch (SQLException e) {
                System.out.println("Connection Failed");
                System.out.println(e);
                e.printStackTrace();
                return null;
            }

            if (connection != null) {
                System.out.println("You successfully connected to database now");
            } else {
                System.out.println("Failed to make connection to database");
            }
            return connection;
        }

}
