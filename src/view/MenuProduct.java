package view;

import controller.ProductManager;
import model.Products;
import storage.products.ProductFile;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static controller.ProductManager.*;

public class MenuProduct {
    public void menu() {
        try {
            menuProduct();
        } catch (Exception e) {
            System.out.println("Vui lòng nhập lại dữ liệu");
            menu();
        }
    }

    private void menuProduct() throws IOException {
        System.out.println("1: Xem danh sách");
        System.out.println("2: Thêm mới");
        System.out.println("3: Cập nhập");
        System.out.println("4: Xóa");
        System.out.println("5: Sắp Xếp");
        System.out.println("6: Tìm sản phẩm có giá trị đắt nhất");
        System.out.println("7: Đọc từ file");
        System.out.println("8: Ghi vào file");
        System.out.println("9: Thoát");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
//                Xem dánh sách
                displayProducts();
                break;
            case 2:
//                Thêm mới
                addToProduct(productsList);
                break;
            case 3:
//                Cập nhập
                editMenu();
                break;
            case 4:
//                Xóa
                deleteMenu();
                break;
            case 5:
//                Sắp xếp
                int choice1;
                System.out.println("1. Sap xep tang dan");
                System.out.println("2. Sap xep giam dan");
                choice1 = Integer.parseInt(scanner.nextLine());
                switch (choice1) {
                    case 1:
                        ProductManager.sortProductPriceAscending();
                    case 2:
                        ProductManager.sortProductByPriceDescending();
                }
                break;
            case 6:
//                Tìm sản phẩm có giá trị đắt nhất
                searchPrice();
            case 7:
//                dọc từ file
                menuReadFile();
                break;
            case 8:
//                ghi vào file
                ProductFile.getInstance().writeData(productsList);
            case 9:
//                thoat
                System.exit(9);
                break;
            default:
                System.out.println("Vui lòng nhập lại");
                menuProduct();
        }

    }

    private void deleteMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã sản phẩm cần xóa");
        String productCode = scanner.nextLine();
        deleteProduct(productCode);
    }

    public static void editMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã sản phẩm");
        String productCode = scanner.nextLine();
        editProducts(productCode);
    }

    private void addToProduct(List<Products> productsList) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập thông tin đăng ký sản phẩm");
        System.out.println("Mã sản phẩm");
        String productCode = scanner.nextLine();
        System.out.println("Tên Sản phẩm");
        Scanner scanner1 = new Scanner(System.in);
        String name = scanner1.nextLine();
        System.out.println("Giá sản phẩm");
        Scanner scanner5 = new Scanner(System.in);
        double price = scanner5.nextDouble();
        System.out.println("Số lượng sản phẩm");
        Scanner scanner2 = new Scanner(System.in);
        int amount = scanner2.nextInt();
        System.out.println("Mô tả sản phẩm");
        Scanner scanner3 = new Scanner(System.in);
        String describe = scanner3.nextLine();

        checkProduct(productCode, name, price, amount, describe);

    }

    private void checkProduct(String productCode, String name, double price, int amount, String describe) throws IOException {
        if (checkProductCode(productCode)) {
            System.out.println("Đã có sản phẩm");
        } else {
            System.out.println("Bạn đăng sản phẩm thành công");
            addProduct(new Products(productCode, name, price, amount, describe));
            System.out.println("Mời bạn quay lại menu");
        }
        menuProduct();
    }

    private void menuReadFile() throws IOException {
        System.out.println("Bán có muốn xóa toàn bộ dữ liệu không");
        System.out.println("Vui lòng bạn nhập");
        System.out.println("1: Bạn muốn xóa toàn bộ dữ liệu");
        System.out.println("2: Quay lại trang menu");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                ProductFile.getInstance().readData();
            case 2:
                menuProduct();
        }

    }
}
