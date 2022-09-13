package model;

import java.io.Serializable;

public class Products implements Serializable, Comparable<Products> {
    private String productCode;
    private String name;
    private double price;
    private int amount;
    private String describe;

    public Products() {
    }

    public Products(String productCode, String name, double price, int amount, String describe) {
        this.productCode = productCode;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.describe = describe;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
    public void display() {
        System.out.println("Products: ");
        System.out.println("productCode: " + getProductCode());
        System.out.println("name: " + getName());
        System.out.println("Price: " + getPrice());
        System.out.println("Amount: " + getAmount());
        System.out.println("Describe: " + getDescribe());

    }

    @Override
    public String toString() {
        return "Products{" + "productCode='" + productCode + '\'' + ", name='" + name + '\'' + ", price=" + price + ", amount=" + amount + ", describe='" + describe + '\'' + '}';
    }

    @Override
    public int compareTo(Products products) {
        return 0;
    }
}
