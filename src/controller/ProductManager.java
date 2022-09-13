package controller;

import model.Products;
import storage.products.ProductFile;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import static view.MenuProduct.editMenu;

public class ProductManager {
    private static ProductFile readWriteFile = ProductFile.getInstance();
    public static List<Products> productsList = new ArrayList<>();

    public static void addProduct(Products products) {
//        productsList = readWriteFile.readData();
        productsList.add(products);
        readWriteFile.writeData(productsList);
    }

    public static void editProducts(String products) {
        productsList = readWriteFile.readData();
        for (int i = 0; i < productsList.size(); i++) {
            if (productsList.get(i).getProductCode().equals(products)) {
//                Chỗ này e chưa clean code
                System.out.println("Nhập thông tin cần sửa");
                System.out.println("Tên Sản phẩm");
                Scanner scanner1 = new Scanner(System.in);
                String name = scanner1.nextLine();
                productsList.get(i).setName(name);
                System.out.println("Giá sản phẩm");
                Scanner scanner5 = new Scanner(System.in);
                double price = scanner5.nextDouble();
                productsList.get(i).setPrice(price);

                System.out.println("Số lượng sản phẩm");
                Scanner scanner2 = new Scanner(System.in);
                int amount = scanner2.nextInt();
                productsList.get(i).setAmount(amount);

                System.out.println("Mô tả sản phẩm");
                Scanner scanner3 = new Scanner(System.in);
                String describe = scanner3.nextLine();
                productsList.get(i).setDescribe(describe);
                readWriteFile.writeData(productsList);

            }else {
                System.out.println("Bạn Nhập sai mã code ");
                editMenu();
            }
        }
    }

    public static void deleteProduct(String productCode) {
        for (int i = 0; i < productsList.size(); i++) {
            if (productsList.get(i).equals(productCode)) {
                productsList.remove(i);
                System.out.println("Bạn xóa sản phẩm thành công");
            }else {
                System.out.println("Bạn xóa sản phẩm thất bại");
            }
        }
    }

    public static void displayProducts() {
        List<Products> products;
        products = readWriteFile.readData();
        for (Products p : products) {
            System.out.println(p);
        }
    }
    public static void sortProductPriceAscending() {
        Comparator<Products> comparator = new Comparator<Products>() {
            @Override
            public int compare(Products products, Products t1) {
                return (int) ((int) (products.getPrice()) - t1.getPrice());

            }


        };
        productsList.sort(comparator);
        System.out.println("Danh sach san pham da duoc xep theo gia tang dan: ");
        displayProducts();
    }
    public static void sortProductByPriceDescending() {
        Comparator<Products> comparator = new Comparator<Products>() {
            @Override
            public int compare(Products products, Products t1) {
                return (int) ((int) (products.getPrice()) - t1.getPrice());

            }


        };
        productsList.sort(comparator);
        System.out.println("Danh sach san pham da duoc xep theo gia tang dan: ");
        displayProducts();
    }

    public static void searchPrice() {
        double max = 0;
        double price = 0;
        for (int i = 0; i < productsList.size() ; i++) {
            if (max < productsList.get(i).getPrice()) {
                max = productsList.get(i).getPrice();
                price = i;

            }
        }
        System.out.println("Sản phẩm có giá cao nhất");
        System.out.println(productsList.get((int) price));
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
