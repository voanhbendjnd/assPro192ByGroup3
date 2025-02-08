package projectfinal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateAccount {

    private static final String txt = "account.txt";

    // Filter role based on user and password
    private static boolean filterRole(String user, String password) {
        String Admin = "admin@@";
        if (password.length() >= Admin.length() && user.length() >= Admin.length()) {
            String rulePass = password.substring(password.length() - Admin.length());
            String ruleUser = user.substring(user.length() - Admin.length());
            return rulePass.equals(Admin) && ruleUser.equals(Admin);
        }
        return false;
    }

    public void mainMethod() {
        Scanner sc = new Scanner(System.in);
        boolean check = true;
        Menu menu = new Menu();
        AccountRole reader = new AccountRole();
        List<Account> accountList = reader.read(txt);
        List<Account> auth = new ArrayList<>();

        while (check) {
            System.out.print("Login or Sign in (1/2): ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                // Handle login
                System.out.print("Please enter username: ");
                String user = sc.nextLine();
                System.out.print("Please enter password: ");
                String password = sc.nextLine();
                boolean checkLogin = false;
                for(Account x : auth){
                    if(x.getUsername().equals(user) && x.getPassword().equals(password)){
                        checkLogin = true;
                        if(x.getRole() == 1){
                            menu.getMenu();
                            break;
                        }
                        else{
                            menu.getMenuUser();
                            break;
                        }
                    }
                }
                for (Account acc : accountList) {
                    if (acc.getUsername().equals(user) && acc.getPassword().equals(password)) {
                        checkLogin = true;
                        System.out.println("Login success!");
                        if (acc.getRole() == 1) {
                            menu.getMenu();
                        } else if (acc.getRole() == 2) {
                            menu.getMenuUser();
                        }
                        break;
                    }
                }

                if (!checkLogin) {
                    System.out.println("Username or password incorrect, please try again.");
                }
            } else if (choice == 2) {
                // Handle sign up
                System.out.print("Please enter username for new account: ");
                String user = sc.nextLine();
                System.out.print("Please enter password for new account: ");
                String password = sc.nextLine();
                System.out.print("Please enter email for new account: ");
                String email = sc.nextLine();

                boolean uniqueEmail = true;
                for (Account acc : accountList) {
                    if (acc.getEmail().equals(email) || acc.getUsername().equals(user)) {
                        uniqueEmail = false;
                        break;
                    }
                }

                if (uniqueEmail) {
                    AccountRole ar = new AccountRole();
                    Long role = filterRole(user, password) ? 1L : 2L;
                    ar.addAccount(txt, new Account(user, password, email, role));
                    auth.add(new Account(user, password, email, role));
                    System.out.println("Account created successfully!");
//                    accountList = reader.read(txt);
                } else {
                    System.out.println("Email or Username already exists!");
                }
            } else {
                System.out.println("Invalid choice, please enter 1 for Login or 2 for Sign in.");
            }
        }
    }
}