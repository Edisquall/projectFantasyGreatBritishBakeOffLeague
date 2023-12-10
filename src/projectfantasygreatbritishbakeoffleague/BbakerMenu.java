/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectfantasygreatbritishbakeoffleague;

import java.util.Scanner;

/**
 *
 * @author Yevhen
 */
public class BbakerMenu {
//      InitIdeally, there should be a menu system to help players navigate the system.
//      Ideally, a player should be able to see a list of all the players and their cumulative point total so far.
//      Ideally, a player should be able to see their own history of predictions and point scoring.

        private Scanner sc  = new Scanner(System.in);
        private BbakerMainLogic mainLogic;
        private BbakerInput userInp = new BbakerInput();
        private BbakerPlayer admin = new BbakerPlayer("1234");
        public BbakerPlayer currentPlayer = new BbakerPlayer();

    public BbakerMenu() {
        //System.out.println("Init Menu");
        //mainLogic.InitPlayers();
        mainLogic =  new BbakerMainLogic();
    }

    public static void clearScreen() {  
        for (int i = 0; i < 50; ++i) System.out.println();
    }      
    
    public void ShowPromt() {
        if (currentPlayer.getName()==null) AskPlayerForName();
        System.out.println("...----==== MAIN MENU ====----...");
        System.out.println("[0] Exit menu");
        System.out.println("[1] Make my prediction");
        System.out.println("[2] Show my predictions");
        System.out.println("[3] Show all users score");
        System.out.println("[4] Show all contestants");
        System.out.println("[5] Enter contestants data (Admin)");
        System.out.println("[6] DEBUG OPTION TEMPORARILY");
        System.out.println("---------------------------------");
        System.out.println(currentPlayer.getName() + ", please, enter menu command number:");        
    }
    
    public void AskPlayerForName() {
        String PlayerName;
        do  {
            PlayerName = userInp.getUserInput("Please, enter your name:");
        } while (PlayerName.isEmpty()); //Wait for Player's name not empty!
        currentPlayer.setName(PlayerName);        
    }
    
    public void menuShutDown() {
        System.out.println("Bye, " +currentPlayer.getName() + "!" );
        System.out.println("Exiting...");
        sc.close();
        System.exit(0);
    }
    
    public void Show() {
        String choice;

        ShowPromt();
        while (true) {
            
            try {
                choice = sc.nextLine(); //choice = (char) System.in.read();

                switch (choice) {
                    case "0":
                        menuShutDown();
                        break;  

                    case "1":
                        System.out.println("Make my prediction\n");
                        mainLogic.doUserPrediction(currentPlayer.getName());
                        break;

                    case "2":
                        System.out.println("Show my predictions\n");
                        mainLogic.getUserPredictions(currentPlayer.getName());
                        break;

                    case "3":
                        clearScreen();
                        System.out.println("Show all users score\n");
                        mainLogic.getAllUsersScore();
                        break;

                    case "4":
                        clearScreen();
                        System.out.println("Show all contestants\n");
                        mainLogic.getAllContestants();
                        break;
                        
                    case "5":
                        String adminPass = userInp.getUserInput("Please, enter admin's password:");
                        if (admin.IsAdmin(adminPass)) {
                            mainLogic.AdminEnterData();
                        } else {
                            System.out.println("Wrong admin's password!");
                            System.out.println("Please, enter menu number:");
                        }
                        break;                        

                    case "6":
                        clearScreen();
                        System.out.println("DEBUG\n");
                        mainLogic.getAllUsersScore();
                        break;
                        
                    default:
                        System.out.println("Please, enter correct menu number:");
                        break;

                }
                ShowPromt();
                
            } catch (Exception e){
                System.out.println("Ops, enter a number, please!");
            }
        }        
  
    }

}

