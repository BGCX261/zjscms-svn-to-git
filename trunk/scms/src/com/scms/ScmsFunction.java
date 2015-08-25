package com.scms;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import cn.com.qlxc.util.Win32Utils;

/**
 * Function of the system implementation class
 * @author Zhujing
 */
public class ScmsFunction {

    /**
     * The main page display program information and menu items
     */
    public static void printMenu() {
        System.out.println("\n\n\n");
        System.out.println("                  ------------------------------------------------");
        System.out.println("                  |    " + CharInfo.SOFTWARE_NAME + " [" + CharInfo.SOFTWARE_TIME + "]    |");
        System.out.println("                  |    Instructor: " + CharInfo.SOFTWARE_TEACHER + "    Author: " + CharInfo.SOFTWARE_AUTHOR + "    |");
        System.out.println("                  ------------------------------------------------");
        System.out.println("\n\n");
        System.out.println("                                 【Function Menu】");
        System.out.println("\n");
        System.out.println("                          1. Show all products");
        System.out.println("                          2. Show all materials");
        System.out.println("                          3. Displaying the associated information");
        System.out.println("                          4. The production of goods");
        System.out.println("                          5. Quit System");
        System.out.println("\n\n\n");
        System.out.print("Please select items : ");
    }

    /**
     * Read command line input integer
     */
    public static int input() {
        Scanner scan = new Scanner(System.in);
        int inputNo = 9;
        try {
            inputNo = scan.nextInt();
        }
        catch (Exception ex) {
        }
        return inputNo;
    }

    /**
     * Back to the command line input string
     */
    public static String inputString() {
        Scanner scan = new Scanner(System.in);
        String inStr = null;
        try {
            inStr = scan.nextLine();
        }
        catch (Exception ex) {
        }
        return inStr;
    }

    /**
     * 【Function】 1 Show all products
     */
    public static void showProduct() {
        Win32Utils.clearScreen();
        //Read out information from the data file
        List<String> productStr = StringUtil.getDataListFromFile(CharInfo.PRODUCT_TABLE);
        List<ProductBean> productList = new ArrayList<ProductBean>();
        String[] tempStr = null;
        ProductBean product = null;
        //Parse out the information into an object container
        if (productStr != null && productStr.size() > 0) {
            for (String rowString : productStr) {
                tempStr = rowString.split("[|]");
                product = new ProductBean();
                product.setNo(tempStr[0]);
                product.setName(tempStr[1]);
                product.setDesc(tempStr[2]);
                product.setInvNo(tempStr[3]);
                productList.add(product);
            }
        }
        //Output to the console (you can also print directly without the object encapsulation to the console)
        System.out.println("\n\n");
        System.out.println("                                   Product List");
        System.out.println("\n");
        System.out.println("                ------------------------------------------------");
        System.out.println("\n");
        if (productStr != null && productStr.size() > 0) {
            for (ProductBean pb : productList) {
                System.out.println("    " + pb.getNo() + "  |  " + pb.getName() + "  |  " + pb.getDesc() + "  |  " + pb.getInvNo());
            }
        }
        else {
            System.out.println(StringUtil.center("No product information !", 70, " "));
        }
        System.out.println("\n");
        System.out.println("                ------------------------------------------------");
        System.out.println("\n\n");
        System.out.print("Enter any character back to the main menu : ");
        input();
        ScmsMain.main(new String[]{});
    }

    /**
     * 【Function】 2 shows all material information
     */
    public static void showInventory() {
        Win32Utils.clearScreen();
        //Read out information from the data file
        List<String> inventoryStr = StringUtil.getDataListFromFile(CharInfo.MATERIALS_TABLE);
        List<InventoryBean> inventoryList = new ArrayList<InventoryBean>();
        String[] tempStr = null;
        InventoryBean inventory = null;
        //Parse out the information into an object container
        if (inventoryStr != null && inventoryStr.size() > 0) {
            for (String rowString : inventoryStr) {
                tempStr = rowString.split("[|]");
                inventory = new InventoryBean();
                inventory.setNo(tempStr[0]);
                inventory.setName(tempStr[1]);
                inventory.setDesc(tempStr[2]);
                inventory.setQuantity(tempStr[3]);
                inventoryList.add(inventory);
            }
        }
        //Output to the console (you can also print directly without the object encapsulation to the console)
        System.out.println("\n\n");
        System.out.println("                                   Material List");
        System.out.println("\n");
        System.out.println("                ------------------------------------------------");
        System.out.println("\n");
        if (inventoryStr != null && inventoryStr.size() > 0) {
            for (InventoryBean ib : inventoryList) {
                System.out.println("              " + ib.getNo() + "  |  " + ib.getName() + "  |  " + ib.getDesc() + "  |  " + ib.getQuantity());
            }
        }
        else {
            System.out.println(StringUtil.center("There is no material information !", 70, " "));
        }
        System.out.println("\n");
        System.out.println("                ------------------------------------------------");
        System.out.println("\n\n");
        System.out.print("Enter any character back to the main menu : ");
        input();
        ScmsMain.main(new String[]{});
    }

    /**
     * 【Function】 3 displays information of all products and materials
     */
    public static void showProductAndInventory() {
        Win32Utils.clearScreen();
        //Extraction of produce information to the object
        List<String> productStr = StringUtil.getDataListFromFile(CharInfo.PRODUCT_TABLE);
        List<ProductBean> productList = new ArrayList<ProductBean>();
        String[] tempStr = null;
        ProductBean product = null;
        if (productStr != null && productStr.size() > 0) {
            for (String rowString : productStr) {
                tempStr = rowString.split("[|]");
                product = new ProductBean();
                product.setNo(tempStr[0]);
                product.setName(tempStr[1]);
                product.setDesc(tempStr[2]);
                product.setInvNo(tempStr[3]);
                productList.add(product);
            }
        }
        //Extraction of material information to the object
        List<String> inventoryStr = StringUtil.getDataListFromFile(CharInfo.MATERIALS_TABLE);
        Map<String, InventoryBean> inventoryMap = new HashMap<String, InventoryBean>();
        tempStr = null;
        InventoryBean inventory = null;
        //Parse out the information into an object container
        if (inventoryStr != null && inventoryStr.size() > 0) {
            for (String rowString : inventoryStr) {
                tempStr = rowString.split("[|]");
                inventory = new InventoryBean();
                inventory.setNo(tempStr[0]);
                inventory.setName(tempStr[1]);
                inventory.setDesc(tempStr[2]);
                inventory.setQuantity(tempStr[3]);
                inventoryMap.put(tempStr[0], inventory);
            }
        }

        System.out.println("\n\n");
        System.out.println("                    List of Products and Materials Information");
        System.out.println("\n");
        System.out.println("                ------------------------------------------------");
        System.out.println("\n");
        //Output
        if (productStr != null && productStr.size() > 0) {
            String[] invNoTemp = null;
            for (ProductBean pb : productList) {
                System.out.println("                 " + pb.getNo() + "  |  " + pb.getName() + "  |  " + pb.getDesc());
                invNoTemp = pb.getInvNo().split(",");
                for (String tempInvNo : invNoTemp) {
                    inventory = inventoryMap.get(tempInvNo);
                    System.out.println("                 ---> " + inventory.getNo() + "  |  " + inventory.getName() + "  |  " + inventory.getDesc());
                }
                System.out.println("\n");
            }
        }
        else {
            System.out.println(StringUtil.center("No product information !", 70, " "));
        }
        System.out.println("                ------------------------------------------------");
        System.out.println("\n\n");
        System.out.print("Enter any character back to the main menu : ");
        input();
        ScmsMain.main(new String[]{});
    }

    /**
     * 【Function】 4 products
     */
    public static void createProduct() {
        Win32Utils.clearScreen();
        System.out.println("\n\n");
        System.out.println("                                    Production");
        System.out.println("\n");
        System.out.println("                ------------------------------------------------");
        System.out.println("\n");

        System.out.print("                     Produce number: ");
        String productNo = StringUtil.trim(inputString());
        System.out.print("                     Produce name: ");
        String productName = StringUtil.trim(inputString());
        System.out.print("                     Product Description: ");
        String productDisc = StringUtil.trim(inputString());
        System.out.print("                     Required materials: ");
        String productInv = StringUtil.trim(inputString());

        String insertRow = "\r\n" + productNo + "|" + productName + "|" + productDisc + "|" + productInv;
        StringUtil.writeLines(CharInfo.PRODUCT_TABLE, insertRow);

        System.out.println("\n");
        System.out.println("                              >> Creating Success <<");
        System.out.println("\n");
        System.out.println("       " + productNo + "  |  " + productName + "  |  " + productDisc + "  |  " + productInv);

        System.out.println("\n");
        System.out.println("                ------------------------------------------------");
        System.out.println("\n\n");
        System.out.print("Enter any character back to the main menu : ");
        input();
        ScmsMain.main(new String[]{});
    }

}
