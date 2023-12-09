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
        String PlayerName;
                
        System.out.println("...----==== USER MENU ====----...");
        System.out.println("0. Exit menu");
        System.out.println("1. Make prediction");
        System.out.println("2. Show predictions");
        System.out.println("3. Show all users predictions");
        System.out.println("4. Enter contestant data (Admin)");
        System.out.println("--------------------------------\n");
                
        boolean bInputOk = false;
        System.out.println("Please, enter menu number:");
        
        while (!bInputOk) {
            Scanner sc  = new Scanner(System.in);
            
            BbakerMainLogic mainLogic =  new BbakerMainLogic();
            BbakerInput userInp = new BbakerInput();
            BbakerPlayer admin = new BbakerPlayer("1234");
            
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
                        System.out.println("Make prediction\n");
                        bInputOk = true;
                        PlayerName = userInp.getUserName("Please, enter your name:");
                        mainLogic.doUserPrediction(PlayerName);
                        break;

                    case "2":
                        System.out.println("Show predictions\n");
                        bInputOk = true;
                        PlayerName = userInp.getUserName("Please, enter your name:");
                        mainLogic.getUserPredictions(PlayerName);
                        break;

                    case "3":
                        System.out.println("Show all users predictions\n");
                        bInputOk = true;
                        mainLogic.getAllUsersPredictions();
                        break;
                        
                    case "4":
                        String adminPass = userInp.getUserName("Please, enter admin's password:");
                        if (admin.IsAdmin(adminPass)) {
                            bInputOk = true;
                            mainLogic.AdminEnterData();
                        } else {
                            System.out.println("Wrong admin's password!");
                            System.out.println("Please, enter menu number:");
                        }
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

