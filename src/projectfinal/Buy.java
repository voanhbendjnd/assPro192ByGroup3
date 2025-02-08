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
// Locale.setDefault(Locale.US);

/**
 *
 * @author Vo Anh Ben - CE190709
 */
public class Buy {

    private static final String filetxt = "products.txt";

    public void buyProductWithId() {
        Scanner sc = new Scanner(System.in);
        boolean checkRing = true;
        List<Cart> cart = new ArrayList<>();
        while (checkRing) {
            System.out.print("Please input id by product you want to buy: ");
            Long id = sc.nextLong();
            ReadFile reader = new ReadFile();
            List<Products> proList = reader.read(filetxt);
       
            boolean check = false;
            String nameProduct = "";
            Long price = null;
            for (Products x : proList) {
                if (x.getId() == id) {
                    nameProduct += x.getName();
                    price = x.getPrice();
                    check = true;
                }
            }
            if (check) {
                System.out.println("added to cart");
                cart.add(new Cart(nameProduct, price));
                System.out.print("Do you want open cart(y/n): ");
                char c = sc.nextLine().charAt(0);
                if (c == 'y') {
                    for (Cart x : cart) {
                        System.out.println(x);
                    }
                    System.out.print("Buy more(y/n): ");
                    char question = sc.nextLine().charAt(0);
                    if (question == 'y') {
                        Menu menu = new Menu();
                        menu.getMenuUser();
                    } else {
                        checkRing = false;
                    }

                } else {
                    checkRing = false;
                }
            } else {
                System.out.println("product not exists");
                checkRing = false;
            }
        }
        System.out.println("Thanks!");
        System.exit(0);
    }
}
