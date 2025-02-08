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
public class Utils {
   boolean filterRole(String user, String password) {
        String Admin = "admin@@";
        if (password.length() >= Admin.length() && user.length() >= Admin.length()) {

            String rulePass = password.substring(password.length() - Admin.length());
            String ruleUser = user.substring(user.length() - Admin.length());

            return (rulePass.equals(Admin) && ruleUser.equals(Admin));
        }
        return false;
    }
}