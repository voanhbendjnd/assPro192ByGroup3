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
public class Orders {
    private Long id;
    private Long user_id;
    private String name;
    private String address;
    private Long product_id;
    private String phone;
    public Orders(Long id, Long user_id, Long product_id, String name, String address, String phone) {
        this.id = id;
        this.product_id = product_id;
        this.user_id = user_id;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAdress(String adress) {
        this.address = address;
    }
    public String toStringFormatted() {
        return this.id + "?" + this.user_id + "?" + this.product_id+ "?" + this.name + "?" + this.address + "?" + this.phone;
    }
     @Override
    public String toString() {
        return String.format("| %-5d | %-7d | %-10d | %-20s | %-30s | %-15s |",
                this.id, this.user_id, this.product_id, this.name, this.address, this.phone);
    }

    public static void printTableOrder(List<Orders> ordersList) {
        StringBuilder sb = new StringBuilder();
        sb.append("+-------+---------+------------+----------------------+--------------------------------+-----------------+\n");
        sb.append("| ID    | UserID  | ProductID  | Name                 | Address                        | Phone           |\n");
        sb.append("+-------+---------+------------+----------------------+--------------------------------+-----------------+\n");
        for (Orders order : ordersList) {
            sb.append(order.toString()).append("\n");
            sb.append("+-------+---------+------------+----------------------+--------------------------------+-----------------+\n");
        }
        System.out.println(sb.toString());
    }

    
}
