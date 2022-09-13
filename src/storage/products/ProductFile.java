package storage.products;

import model.Products;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductFile implements IReadWriteFile{
    private static ProductFile productFile;

    public ProductFile() {
    }
    public static ProductFile getInstance() {
        if (productFile == null) {
            productFile = new ProductFile();
        }
        return productFile;
    }

    @Override
    public List<Products> readData() {
        List<Products> productsList = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream("data/Product.csv");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
            List<Products> products = (List<Products>) obj;
            ois.close();
            fis.close();
            return products;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void writeData(List<Products> list) {
        try {
            FileOutputStream fos = new FileOutputStream("data/Product.csv");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Products> readData(String path) {
        List<Products> list = new ArrayList<>();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
            list = (List<Products>) obj;
            return list;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void writeData(List<Products> list, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
