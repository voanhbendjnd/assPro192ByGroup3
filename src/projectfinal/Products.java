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

public class Products {
    private Long id;
    private Long code;
    private String name;
    private String brand;
    private Long price;
    private String description;
    private Long stock;
    private String dateCreate;

    public Products() {
    }

    public Products(Long code,String name, String brand, Long price, String description, Long stock, String dateCreate) {
        this.name = name;
        this.code = code;
        this.brand = brand;
        this.price = price;
        this.description = description;
        this.stock = stock;
        this.dateCreate = dateCreate;
    }

    
   
  

    public String getName() {
        return name;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Long getPrice() {
        return price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

   
    public String toStringFormatted() {
        return this.code + "?"+this.name + "?" + this.brand + "?" + this.price + "?" + this.description + "?"
                + this.stock + "?" + this.dateCreate;
    }

    @Override
    public String toString() {
        return String.format("| %-5d | %-23s | %-16s | %-9d | %-50s | %-5d | %-10s |",
                this.code, this.name, this.brand, this.price, this.description, this.stock, this.dateCreate);
    }

    public static void printTable(List<Products> productsList) {
        StringBuilder sb = new StringBuilder();
        sb.append("+-------+-------------------------+------------------+-----------+----------------------------------------------------+-------+------------+\n");
        sb.append("| Code  | Name                    | Brand            | Price     | Description                                        | Stock | Date       |\n");
        sb.append("+-------+-------------------------+------------------+-----------+----------------------------------------------------+-------+------------+\n");
        for (Products product : productsList) {
            sb.append(product.toString()).append("\n");
            sb.append("+-------+-------------------------+------------------+-----------+----------------------------------------------------+-------+------------+\n");
        }
        System.out.println(sb.toString());
    }
}
