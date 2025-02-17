/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectfinal;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.sql.ResultSet;
import java.util.stream.Collectors;
import java.io.PrintStream;
import static java.lang.Character.isDigit;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.List;
import projectfinal.Products;
// Locale.setDefault(Locale.US);

/**
 *
 * @author Vo Anh Ben - CE190709
 */
public class HandleCart {

    private String fileCart = "cart.txt";

    public List<Cart> read(String cartFile) {
        List<Cart> cartList = new ArrayList<>();
        try {
            File myFile = new File(cartFile);
            Scanner sc = new Scanner(myFile);
            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                String[] carts = data.split("\\?");
                Long id = Long.parseLong(carts[0]);
                String name = carts[1];
                Long price = Long.parseLong(carts[2]);
                Long qty = Long.parseLong(carts[3]);
                Long total = Long.parseLong(carts[4]);
                Long userId = Long.parseLong(carts[5]);
                cartList.add(new Cart(id, name, price, qty, total, userId));

            }
            sc.close();

        } catch (Exception ex) {
            System.out.println("Error reading file: " + ex.getMessage());
        }
        return cartList;
    }

    public void writeFile(String fileName, List<Cart> cart) {
        try (FileWriter fw = new FileWriter(fileName)) {
            for (Cart x : cart) {
                fw.write(x.toStringFormatted() + "\n");
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
       void addProduct(String fileName, Cart cart) {
        List<Cart> cartList = read(fileCart);
        cartList.add(cart);
        writeFile(fileName, cartList);
    }
     public void deleteProduct(String fileName,Long code) {
        List<Cart> cartList = read(fileName);
        boolean productFound = false;
        for (Iterator<Cart> iterator = cartList.iterator(); iterator.hasNext();) {
            Cart cart = iterator.next();
            if (cart.getCartId().equals(code)) {
                iterator.remove();
                productFound = true;
                break;
            }
        }
        if (productFound) {
            writeFile(fileName, cartList);
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }


}
