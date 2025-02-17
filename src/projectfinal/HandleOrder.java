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
import java.sql.*;
import javax.swing.*; 
import javax.swing.table.DefaultTableModel; 
import java.awt.*; 
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.sql.ResultSet;
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
public class HandleOrder {
     public List<Orders> read(String fileOrder) {
        List<Orders> orderList = new ArrayList<>();
        try {
            File myFile = new File(fileOrder);
            Scanner sc = new Scanner(myFile);
            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                String[] orders = data.split("\\?");
                Long id = Long.parseLong(orders[0]);
                Long id_user = Long.parseLong(orders[1]);
                Long product_id = Long.parseLong(orders[2]);
                String name = orders[3];
                String address = orders[4];
                String phone = orders[5];
                orderList.add(new Orders(id, id_user,product_id, name, address, phone));
                
            }
            sc.close();
          
        } catch (Exception ex) {
            System.out.println("Error reading file: " + ex.getMessage());
        }
        return orderList;
    }

    public void writeFile(String fileName, List<Orders> orderList) {
        try (FileWriter fw = new FileWriter(fileName)) {
            for (Orders x : orderList) {
                fw.write(x.toStringFormatted() + "\n");
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void addOrder(String fileName, Orders order) {
        List<Orders> orderList = read("order.txt");
        orderList.add(order);
        writeFile(fileName, orderList);
    }
     public void deleteOrder(String fileName, Long id) {
        List<Orders> orderList = read(fileName);
        boolean productFound = false;
        for (Iterator<Orders> iterator = orderList.iterator(); iterator.hasNext();) {
            Orders order = iterator.next();
            if (order.getId().equals(id)) {
                iterator.remove();
                productFound = true;
                break;
            }
        }
        if (productFound) {
            writeFile(fileName, orderList);
//            System.out.println("Product deleted successfully.");
        } else {
//            System.out.println("Product not found.");
        }
    }
}
