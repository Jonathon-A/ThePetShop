package thepetshop;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class ThePetShop {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println("Please Login or Register:");
        System.out.println("1: Login");
        System.out.println("2: Register");

        Scanner input = new Scanner(System.in);
        int choose;
        if (input.hasNextInt()) {
            choose = input.nextInt();
        } else {
            choose = 100;
        }
        switch (choose) {
            case (1):
                login();
                break;
            case (2):
                register();
                break;
            default:
                System.out.println("");
                System.out.println("Invalid choice");
                System.out.println("");
                main(args);
                break;
        }
    }

    public static void register() throws NoSuchAlgorithmException {
        Scanner input = new Scanner(System.in);
        System.out.println("");
        System.out.println("Please Register an account.");
        System.out.println("");
        System.out.println("Enter Username:");
        String Username = input.nextLine();
        System.out.println("Enter Password:");
        String Password = input.nextLine();
        System.out.println("");

        int hashedPassword = Password.hashCode();
        String mystr = Username + " " + hashedPassword;

        String fullDir = System.getProperty("user.dir") + "\\login.txt";

        try {
            FileWriter writeToFile = new FileWriter(fullDir, true);
            PrintWriter printToFile = new PrintWriter(writeToFile);
            printToFile.println(mystr);
            printToFile.close();
            writeToFile.close();
        } catch (Exception e) {

        }
        System.out.println("Account Registered");
        login();
    }

    public static void login() throws NoSuchAlgorithmException {
        Scanner input = new Scanner(System.in);
        System.out.println("");
        System.out.println("Please Login to your account.");
        System.out.println("");
        System.out.println("Enter Username:");
        String Username = input.nextLine();
        System.out.println("Enter Password:");
        String Password = input.nextLine();

        int hashedPassword = Password.hashCode();
        String mystr = Username + " " + hashedPassword;

        String fullDir = System.getProperty("user.dir") + "\\login.txt";
        boolean logged = false;
        boolean admin = false;
        String inputLine;
        try {
            BufferedReader read = new BufferedReader(new FileReader(fullDir));
            while ((inputLine = read.readLine()) != null) {
                if (mystr.equals(inputLine)) {
                    logged = true;
                    System.out.println("");
                    System.out.println("Logged in");
                    System.out.println("");
                }
                if ((mystr.equals("admin" + " " + "adminpassword".hashCode())) && (logged == true)) {
                    admin = true;

                }
            }
            if (logged == false) {
                System.out.println("");
                System.out.println("Invalid credentials, please try again");
                login();
            }
        } catch (Exception e) {
        }

        menu(admin);

    }

    public static void menu(boolean admin) {

        if (admin == true) {

            System.out.println("Welcome Admin, please selcet an option:");
            System.out.println("1: Display current pet store items");
            System.out.println("2: Stock pet store item");
            System.out.println("3: Display customer purchases");

            Scanner input = new Scanner(System.in);
            int choose;
            if (input.hasNextInt()) {
                choose = input.nextInt();
            } else {
                choose = 100;
            }
            switch (choose) {
                case (1):
                    String inputLine3;
                    System.out.println("All shop items ad stocks:");
                    String fullDir3 = System.getProperty("user.dir") + "\\items.txt";
                    try {
                        BufferedReader read = new BufferedReader(new FileReader(fullDir3));
                        while ((inputLine3 = read.readLine()) != null) {
                            System.out.println(inputLine3);

                        }

                    } catch (Exception e) {
                    }
                    menu(admin);
                    break;
                case (2):

                    System.out.println("How many pets do you want to stock");
                    int p = input.nextInt();

                    System.out.println("How many toys do you want to stock");
                    int t = input.nextInt();

                    System.out.println("How much food do you want to stock");
                    int f = input.nextInt();

                    String itemstr1 = "Pets: " + p;
                    String itemstr2 = "Toys: " + t;
                    String itemstr3 = "Food: " + f;

                    fullDir3 = System.getProperty("user.dir") + "\\items.txt";
                    try {

                        FileWriter writeToFile = new FileWriter(fullDir3, true);
                        PrintWriter printToFile = new PrintWriter(writeToFile);
                        
                        FileOutputStream Clearer = new FileOutputStream(fullDir3);
                        Clearer.write(("").getBytes());
                        Clearer.close();
                        
                        printToFile.println(itemstr1);
                        printToFile.println(itemstr2);
                        printToFile.println(itemstr3);
                        printToFile.close();
                        writeToFile.close();
                    } catch (Exception e) {

                    }
                    menu(admin);

                    break;
                case (3):
                    String inputLine2;
                    System.out.println("All customer purcheses");
                    String fullDir2 = System.getProperty("user.dir") + "\\purchases.txt";
                    try {
                        BufferedReader read = new BufferedReader(new FileReader(fullDir2));
                        while ((inputLine2 = read.readLine()) != null) {
                            System.out.println(inputLine2);
                        }

                    } catch (Exception e) {
                    }
                    menu(admin);
                    break;

                default:
                    System.out.println("");
                    System.out.println("Invalid choice");
                    System.out.println("");
                    menu(admin);
                    break;

            }

        } else {

            System.out.println("Welcome Customer, please selcet an option:");
            System.out.println("1: Display current pet store items");
            System.out.println("2: Purchase a pet store items");

            Scanner input = new Scanner(System.in);
            int choose;
            if (input.hasNextInt()) {
                choose = input.nextInt();
            } else {
                choose = 100;
            }
            switch (choose) {
                case (1):
                    String inputLine3;
                    System.out.println("All shop items and stocks:");
                    String fullDir3 = System.getProperty("user.dir") + "\\items.txt";
                    try {
                        BufferedReader read = new BufferedReader(new FileReader(fullDir3));
                        while ((inputLine3 = read.readLine()) != null) {
                            System.out.println(inputLine3);

                        }

                    } catch (Exception e) {
                    }
                    menu(admin);
                    break;
                case (2):
                    System.out.println("How many pets do you want to buy");
                    int p = input.nextInt();

                    System.out.println("How many toys do you want to buy");
                    int t = input.nextInt();

                    System.out.println("How much food do you want to buy");
                    int f = input.nextInt();

                    String itemstr1 = "Pets: " + p;
                    String itemstr2 = "Toys: " + t;
                    String itemstr3 = "Food: " + f;
                    String total = "Total: " + (f + t + p);

                    String fullDir4 = System.getProperty("user.dir") + "\\purchases.txt";
                    try {
                         FileOutputStream Clearer = new FileOutputStream(fullDir4);
                        Clearer.write(("").getBytes());
                        Clearer.close();
                        
                        FileWriter writeToFile = new FileWriter(fullDir4, true);
                        PrintWriter printToFile = new PrintWriter(writeToFile);
                        printToFile.println(itemstr1);
                        printToFile.println(itemstr2);
                        printToFile.println(itemstr3);
                        printToFile.println(total);
                        printToFile.close();
                        writeToFile.close();
                    } catch (Exception e) {

                    }
                    menu(admin);
                    break;
                default:
                    System.out.println("");
                    System.out.println("Invalid choice");
                    System.out.println("");
                    menu(admin);
                    break;

            }

        }
    }
}
