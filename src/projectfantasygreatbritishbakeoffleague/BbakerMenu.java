/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectfantasygreatbritishbakeoffleague;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class BbakerMenu {
    //Init

    public void Show() {
        String choice;
                
        System.out.println("USER MENU");
        System.out.println("----------");
        System.out.println("0. Exit menu");
        System.out.println("1. Make prediction");
        System.out.println("2. Show predictions");
        System.out.println("\n");
        
                
        boolean bInputOk = false;
        System.out.println("Please, enter menu number:");
        
        while (!bInputOk) {
            Scanner sc  = new Scanner(System.in);
            
            try {
                //choice = (char) System.in.read();
                choice = sc.nextLine();

                switch (choice) {
                    case "0":
                        System.out.println("Exit");
                        sc.close();
                        System.exit(0);
                        break;  

                    case "1":
                        System.out.println("Make prediction");
                        bInputOk = true;
                        // ToDO: HERE CALL to Input user data
                        break;

                    case "2":
                        System.out.println("Show predictions");
                        bInputOk = true;
                        // ToDO: HERE CALL to show user data
                        break;
                        
                    default:
                        System.out.println("Please, enter menu number:");
                        break;

                }
                
            } catch (Exception e){
                System.out.println("Ops, enter a number, please!");
            }
        }        
        

        
    }

}

