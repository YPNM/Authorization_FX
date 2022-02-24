package com.example.authorization_fx;

import javafx.beans.property.*;

public class Tovar extends Cart {
    private final SimpleStringProperty Name;
    private final SimpleStringProperty  Bar_code;
    private final SimpleIntegerProperty  Price;
    private final SimpleIntegerProperty count;
    private final SimpleIntegerProperty cost;

    public Tovar(String Bar_code, String Name, int price){
        this.Name = new SimpleStringProperty(Name);
        this.Bar_code = new SimpleStringProperty(Bar_code);
        this.Price = new SimpleIntegerProperty(price);
        count = new SimpleIntegerProperty(get_tov_count(Bar_code));
        cost = new SimpleIntegerProperty(0);
    }
    public String getName(){return Name.get();}
    public String getBar_code(){return Bar_code.get();}
    public int getPrice(){return Price.get();}
    public int getCount(){return count.get();}
    public int getCost(){return Price.get()*count.get();}
    public void setName(String Name){this.Name.set(Name);}
    public void setBar_code(String Bar_code){this.Bar_code.set(Bar_code);}
    public void setPrice(int Price){this.Price.set(Price);}
    public void setCount(){count.set(count.get()+1);}
}
