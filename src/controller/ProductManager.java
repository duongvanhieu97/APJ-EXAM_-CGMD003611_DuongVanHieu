package controller;

import model.Products;
import storage.products.ProductFile;

import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private static ProductFile readWriteFile = ProductFile.getInstance();
    public static List<Products> productsList = new ArrayList<>();

    public static void addProduct(Products products) {
//        productsList = readWriteFile.readData();
        productsList.add(products);
        readWriteFile.writeData(productsList);
    }

    public static void editProducts(String productCode, String name, double price, int amount, String describe) {
        productsList = readWriteFile.readData();
//Viết code edit
    }

    public static void deleteProduct() {

    }

    public static void displayProducts() {
        List<Products> products;
        products = readWriteFile.readData();
        for (Products p : products) {
            System.out.println(p);
        }
    }

    public static boolean checkProductCode(String productCode) {
        boolean check = false;
        for (Products p : productsList) {
            if (productsList.equals(p.getProductCode())) {
                check = true;
            }
        }
        return check;
    }
}
