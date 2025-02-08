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
public class Cart {
    private Long qty;
    private String name;
    private String userName;
    private Long price;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Cart(String name, Long price) {
        this.name = name;
        this.price = price;
    }
    

    public Cart(Long qty, String name) {
        this.qty = qty;
        this.name = name;
    }

    public Long getQty() {
        return qty;
    }

    public Cart(String userName, String name) {
        this.name = name;
        this.userName = userName;
    }

    public void setQty(Long qty) {
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String toString(){
        return "Your Cart: " + this.name + " " + this.price;
    }
}