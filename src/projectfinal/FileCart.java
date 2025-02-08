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
public class FileCart {
    private final static String fileCart = "cartProduct.txt";
  public List<Cart> read(String fileProducts) {
        List<Cart> productsList = new ArrayList<>();
        try {
            File myFile = new File(fileProducts);
            Scanner sc = new Scanner(myFile);
            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                String[] products = data.split("\\?");
                String nameAccount = products[0];
                String nameProduct = products[1];
               
                productsList.add(new Cart(nameAccount, nameProduct));
                
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

   
}