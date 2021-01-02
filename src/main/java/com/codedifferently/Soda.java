package com.codedifferently;

import java.util.Map;

public class Soda {
    private String name;
    private Double price;
    private String exp;
    public Soda(Map<String,String> rawDataMap) {
        this.name = rawDataMap.get("name");
        this.price = Double.parseDouble(rawDataMap.get("price"));
        this.exp = rawDataMap.get("exp");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String toString(){
        return name + " " + price + " " + exp;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }
}
