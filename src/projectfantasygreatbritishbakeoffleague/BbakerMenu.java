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

        private boolean sayHello = true;
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
        if (mainLogic.IsPlayerNew(currentPlayer.getName())) {
            if(sayHello) System.out.println("Hi "+currentPlayer.getName()+"!\nAs you are new to this system, please chose 3 contestants and make predictions.\nGood Luck!");
            mainLogic.rwFile.Log2File("User " + currentPlayer.getName() + " logs in the system [NEW USER]");
            currentPlayer.setIsNewPlayer(true);
            sayHello = false;
        } else {
            if(sayHello) System.out.println("Welcome back, " + currentPlayer.getName() +"!");
            mainLogic.rwFile.Log2File("User " + currentPlayer.getName() + " logs in the system");
            currentPlayer.setIsNewPlayer(false);
            sayHello = false;
        }
        System.out.println("...----==== MAIN MENU ====----...");
        System.out.println("[0] Exit");
        System.out.println("[1] Make my prediction");
        System.out.println("[2] Show my predictions");
        System.out.println("[3] Show all users score");
        System.out.println("[4] Show all contestants");
        //System.out.println("[9] DEBUG OPTION TEMPORARILY"); // Hidden for Debug && Test
        System.out.println("[5] Help (Rules)");
        //System.out.println("[999] Enter contestants data (Admin)"); //Hidden menu option
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
        mainLogic.rwFile.Log2File(currentPlayer.getName() +  " shutdowns the system");
        System.exit(0);
    }
    
    public void inWork() {
        System.out.println("In developing. Drop on later\n");
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
                        System.out.println("Make my prediction");
                        mainLogic.doUserPrediction();
                        break;

                    case "2":
                        //inWork();
                        mainLogic.ShowPlayerPredictions();
                        break;

                    case "3":
                        clearScreen();
                        System.out.println("Show all users score");
                        mainLogic.getAllUsersScore();
                        break;

                    case "4":
                        clearScreen();
                        System.out.println("Show all contestants");
                        mainLogic.getAllContestants();
                        break;

                    case "9": // For test purposes only. WILL BE REMOVED BEFORE DEPLOY
                        clearScreen();
                        mainLogic.ShowPlayerInfo();
                        break;

                    case "5":
                        showRules();
                        break;
                        
                    case "999": // Hidden menu option for ADMIN
                        String adminPass = userInp.getUserInput("Please, enter admin's password:");
                        if (admin.IsAdmin(adminPass)) {
                            //mainLogic.AdminEnterData();
                            inWork();
                        } else {
                            System.out.println("Wrong admin's password!");
                            System.out.println("Please, enter menu number:");
                        }
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
    
    public void showRules(){
        System.out.println("Welcome to Fantasy Great British Bake-Off League!");
        System.out.println("=================================================");
        System.out.println("The Great British Bake-Off (GBBO) is a British competition show where,\nover the course of several weeks, contestants show of their baking prowess\nin front of a panel of judges in the hopes of not being eliminated that week.\n");
        System.out.println("Each participant (player) in the league will choose three contestants\nto be part of their fantasy team. Each week, the contestants will be awarded\npoints based on what happens in the show. The winner of the league is the player with the most points\nat the end of the television season\n");
        System.out.println("Players will take turns at the console each week, entering their predictions.");
        System.out.println("The actual outcomes will be provided in a csv file each week.\n");
        
        System.out.println("Weekly points awarded up to and including episode nine:");
        System.out.println("_______________________________________________________");
        System.out.println("Correct nomination of the Best Baker = 4 points");
        System.out.println("If your nominated Best Baker is eliminated, then 1 point will be deducted from your total");
        System.out.println("Correct weekly nomination of baker to leave = 3 points");
        System.out.println("If your nominated baker to leave is the Best Baker 1 point will be deducted from your total.");
        System.out.println("Correct nomination of the winner of that week’s technical round = 2 points\n");
        
        System.out.println("Points awarded at the end of the final episode of the series:");
        System.out.println("_____________________________________________________________");        
        System.out.println("Overall winner chosen after episode one and before episode two = 7 points");
        System.out.println("The other two finalists chosen after episode one and before episode two = 2 points each");
        System.out.println("Winner of the final episode, chosen after episode nine = 4 points");
        System.out.println("No technical round or elimination nominations for the final episode\n");

    }

}

