/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectfinal;

/**
 *
 * @author Vo Anh Ben - CE190709
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ReadFile {
    public List<Products> read(String fileProducts) {
        List<Products> productsList = new ArrayList<>();
        try {
            File myFile = new File(fileProducts);
            Scanner sc = new Scanner(myFile);
            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                String[] products = data.split("\\?");
                Long codePhone = Long.parseLong(products[0]);
                String name = products[1];
                String brand = products[2];
                Long price = Long.parseLong(products[3]);
                String description = products[4];
                Long stock = Long.parseLong(products[5]);
                String date = products[6];
                productsList.add(new Products(codePhone,name, brand, price, description, stock, date));
                
            }
            sc.close();
          
        } catch (Exception ex) {
            System.out.println("Error reading file: " + ex.getMessage());
        }
        return productsList;
    }

    public void writeFile(String fileName, List<Products> product) {
        try (FileWriter fw = new FileWriter(fileName)) {
            for (Products x : product) {
                fw.write(x.toStringFormatted() + "\n");
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    void addProduct(String fileName, Products product) {
        List<Products> proList = read("products.txt");
//        boolean checkExists = false;
//        for (Products x : proList) {
//            if (x.getName().equalsIgnoreCase(product.getName()) && x.getBrand().equalsIgnoreCase(product.getBrand())) {
//                x.setStock(x.getStock() + product.getStock());
//                checkExists = true;
//                break;
//            }
//        }
//        if (!checkExists) {
//            proList.add(product);
//        }
        proList.add(product);
        writeFile(fileName, proList);
    }
     public void deleteProduct(String fileName, String productName, String productBrand, Long code) {
        List<Products> proList = read(fileName);
        boolean productFound = false;
        for (Iterator<Products> iterator = proList.iterator(); iterator.hasNext();) {
            Products product = iterator.next();
            if (product.getCode().equals(code) && product.getName().equalsIgnoreCase(productName) && product.getBrand().equalsIgnoreCase(productBrand)) {
                iterator.remove();
                productFound = true;
                break;
            }
        }
        if (productFound) {
            writeFile(fileName, proList);
//            System.out.println("Product deleted successfully.");
        } else {
//            System.out.println("Product not found.");
        }
    }

//    void updateProduct(String fileName, Products product) {
//        List<Products> proList = read(fileName);
//        boolean checkExists = false;
//        for (Products x : proList) {
//            if (x.getId().equals(product.getId())) {
//                x.setName(product.getName());
//                x.setBrand(product.getBrand());
//                x.setPrice(product.getPrice());
//                x.setDescription(product.getDescription());
//                x.setStock(product.getStock());
//                x.setDateCreate(product.getDateCreate());
//                checkExists = true;
//                break;
//            }
//        }
//        if (checkExists) {
//            writeFile(fileName, proList);
//            System.out.println("Update success");
//        } else {
//            System.out.println("Product ID = " + product.getId() + "not already exist");
//        }
//    }

}
