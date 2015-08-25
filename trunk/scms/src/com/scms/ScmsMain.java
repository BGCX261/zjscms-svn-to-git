/*
 * Supply management program[ASSIGNMENT ONE]
 */
package com.scms;

import cn.com.qlxc.util.Win32Utils;

/**
 * The main program class
 * @author Zhujing
 */
public class ScmsMain {

    /**
     * Program entry main () method
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        Win32Utils.clearScreen();
        ScmsFunction.printMenu();
        int funNo = ScmsFunction.input();
        switch (funNo) {
            case 1 :
                ScmsFunction.showProduct();
                break;
            case 2 :
                ScmsFunction.showInventory();
                break;
            case 3 :
                ScmsFunction.showProductAndInventory();
                break;
            case 4 :
                ScmsFunction.createProduct();
                break;
            case 5 :
                System.out.println("\nThank you for using!");
                break;
            default :
                main(new String[]{});
        }

    }

}
