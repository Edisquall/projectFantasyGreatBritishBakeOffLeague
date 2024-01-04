/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectfantasygreatbritishbakeoffleague;
 /**
 * @author Yevgen
 * 
 * Known issues:
 * -------------
 * - System supports only one destinct name of player. One needs enter usage of a pair of name and password as a way of solving OR DataBase!
 * - No accounting the state of contestants: elimination. If state is elimination then dont promt user to select
 * 
 */

import java.util.Scanner;

public class BbakerMainLogic {
    private Scanner sc  = new Scanner(System.in);
    private BbakerInput userInp = new BbakerInput();    
    public BbakerReadWrite rwFile =  new BbakerReadWrite();
    
    private int MaxPlayersCount = 100;
    private String[] players = new String[MaxPlayersCount];
    private String[] predictions = new String[MaxPlayersCount];
    private String[] contestants = new String[MaxPlayersCount];
    private String[] contestantsUpdated = new String[MaxPlayersCount];
    
    public int totalPlayersCount = 0;
    public int totalContestantsCount = 0;

    public BbakerMainLogic(){
        //System.out.println("Init BbakerMainLogic");
        InitPlayers();
        InitContestants();
        rwFile.Log2File("Init system");
    }    

    public void InitPlayers(){
        if (!LoadPlayers()) InitPlayersTest();
        CountPlayers();
    }

    public void InitContestants(){
        if (!LoadContestants()) InitContestantsTest();
        CountContestants();
    }
    
    public void CountPlayers(){
        totalPlayersCount = 0;
        for (String c: players ) {           
            if (c!=null ) totalPlayersCount++;
        }        
    }
    
    public void CountContestants(){
        totalContestantsCount = 0;
        for (String p: contestants) {           
            if (p!=null ) totalContestantsCount++;
        }        
    }    
    
    public void InitPlayersTest(){
        // FORMAT: PlayerName, TotalScore
        players[0] = "John,10";
        players[1] = "James,6";
        players[2] = "Sam,2";
        CountPlayers();
    }

    public void InitContestantsTest(){
        // FORMAT: ContestantName, type, points
        // type can be:
        // active - still in list
        // eliminated
        
        int ind = 0;
        contestants[ind] = "Dan,active,1";
        contestants[++ind] = "Josh,active,20";
        //contestants[++ind] = "Matty,active,30";
       // contestants[++ind] = "Tasha,active,20";
       // contestants[++ind] = "Cristy,eliminated,0";
        CountContestants();
    }
    
    public boolean LoadPlayers(){  // Load players from file
       return rwFile.loadFromFile(players, rwFile.playersFile);
    }    
 
    public boolean SavePlayers(){  // Save players 2 file
        return rwFile.Save2File(players, rwFile.playersFile);
    }     
    
    public boolean LoadContestants(){  // Load players from file
       return rwFile.loadFromFile(contestants, rwFile.contestantsFile);
    }    
 
    public boolean SaveContestants(){  // Save players 2 file
        return rwFile.Save2File(contestants, rwFile.contestantsFile);
    }   
    
    public void ShowPlayersTable(){
        if (totalPlayersCount==0) {
            System.out.println("No players found");
            return;
        }
        // List players
        int cnt=0;
        String csvSplitBy = ",";
        System.out.println("#\tName\t\tPoints\t");
        System.out.println("-----------------------------------");
        int indName = 0, indPoints = 1;
        for (String p: players) {
            if (p!=null ) {
                cnt++;
                String[] playerData = p.split(csvSplitBy);
                System.out.println(cnt + "\t" + playerData[indName] + "\t\t" + playerData[indPoints]);
            }
        }
        System.out.println("-----------------------------------");
        System.out.println("Total players: " + totalPlayersCount + "\n");        
    }    
    
    
    public void ShowContestantsTable() {
        if (totalContestantsCount==0) {
            System.out.println("No contestants found");
            return;
        }
        // List players
        int cnt=0;
        String csvSplitBy = ",";
        System.out.println("#\tName\t\tState\t\tPoints\t");
        System.out.println("---------------------------------------------------");
        int indName = 0, indState = 1, indPoints = 2;
        for (String p: contestants) {
            if (p!=null ) {
                cnt++;
                String[] ContestantData = p.split(csvSplitBy);
                System.out.println(cnt + "\t" + ContestantData[indName] + "\t\t" + ContestantData[indState] + "\t\t" + ContestantData[indPoints] );
            }
        }
        System.out.println("----------------------------------------------------");
        System.out.println("Total contestants: " + totalContestantsCount + "\n");          
    }

    public boolean IsPlayerNew(String UserName) {
        //String cPlayerName = currentPlayer.getName();
        if (totalPlayersCount==0) return true;
        int indName = 0, indPoints = 1;
        String csvSplitBy = ",";
        for (String p: players) {
            if (p!=null ) {
                String[] playerData = p.split(csvSplitBy);
                if (UserName.equalsIgnoreCase( playerData[indName])) {
                    ProjectFantasyGreatBritishBakeOffLeague.userMenu.currentPlayer.setScore(Double.valueOf(playerData[indPoints]));
                    return false;
                }
            }
        }
        return true;
    }

    public boolean IsContestantExists(String ContName) {
        if (totalContestantsCount==0) return false;
        int indName = 0;
        String csvSplitBy = ",";
        for (String p: contestants) {
            if (p!=null ) {
                String[] ContestantData = p.split(csvSplitBy);
                if (ContName.equalsIgnoreCase( ContestantData[indName])) return true;
            }
        }
        return false;
    }
    
    public void ShowPlayerInfo(){
        System.out.println("User name: " + ProjectFantasyGreatBritishBakeOffLeague.userMenu.currentPlayer.getName() ); 
        System.out.println("User score: " + ProjectFantasyGreatBritishBakeOffLeague.userMenu.currentPlayer.getScore() ); 
        System.out.println("----------------------------------------------------");
        //List of users predicts
    }

    public void ContListDebug(){
        int cnt=0;
        String csvSplitBy = ",";
        System.out.println("#\tName\t\tState\t\tPoints\t");
        System.out.println("----------------------------------------------------------------");
        int indName = 0, indState = 1, indPoints = 2;
        for (String p: contestants) {
            if (p!=null ) {
                cnt++;
                String[] ContestantData = p.split(csvSplitBy);
                System.out.println(cnt + "\t" + ContestantData[indName] + "\t\t" + ContestantData[indState] + "\t\t\t" + ContestantData[indPoints] );
            }
        }
        System.out.println("----------------------------------------------------------------");
        
        cnt=0;
        for (String p: contestantsUpdated) {
            if (p!=null ) {
                cnt++;
                String[] ContestantData = p.split(csvSplitBy);
                System.out.println(cnt + "\t" + ContestantData[indName] + "\t\t" + ContestantData[indState] + "\t\t\t" + ContestantData[indPoints] );
            }
        }
        System.out.println("----------------------------------------------------------------");        
    }
    
    public void AdminEnterData(){
        //LINE FORMAT: date,ContestantName,awardedpoints

        ShowContestantsTable(); // Show to player all contestans
        System.out.println("FORMAT: Josh,active,20 [POSSIBLE states are: active, eliminated, delete ] or enter CANCEL to exit data entering\n");

        boolean canGoOn = false, getPoints = true;
        int cnt=0;
        String tmpContestantName , tmpContState, tmpContPoints; double dblContPoints =0;
        int indName = 0, indState = 1, indPoints = 2; String csvSplitBy = ",";
        for (String p: contestants) {
            if (p!=null ) {
                String[] ContestantData = p.split(csvSplitBy);
                System.out.println("--- New data for " + ContestantData[indName] + ":");
                canGoOn = false;
                do{ // Get -- state
                    tmpContState = AskPlayerForContestantName("Enter " + ContestantData[indName] + "'s state [active, eliminated, delete]: ");
                    if(tmpContState.equalsIgnoreCase("cancel")) return; // Exit
                    if (!tmpContState.isEmpty() && ( tmpContState.equalsIgnoreCase("active") || tmpContState.equalsIgnoreCase("eliminated") || tmpContState.equalsIgnoreCase("delete") )  ) {
                        if (tmpContState.equalsIgnoreCase("delete")){
                            contestantsUpdated[cnt] = ContestantData[indName] + ",delete,0";
                            cnt++;
                            getPoints = false;
                            continue;
                        }
                        canGoOn = true;
                    } else {
                        System.out.println("Wrong state, try once again or enter CANCEL to exit");
                    }
                } while (!canGoOn);

                if (getPoints) { // Get points if state!=delete
                    canGoOn = false;
                    do{
                        tmpContPoints = AskPlayerForContestantName("Enter " + ContestantData[indName] + "'s points [number]: ");
                        if(tmpContPoints.equalsIgnoreCase("cancel")) return; // Exit
                        try{
                            dblContPoints = Double.valueOf(tmpContPoints);
                            contestantsUpdated[cnt] = ContestantData[indName] + ","+tmpContState+","+tmpContPoints;
                            cnt++;
                            canGoOn = true;
                        } catch (Exception e){
                            System.out.println("Wrong number, try once again or enter CANCEL to exit");
                        }

                    } while (!canGoOn);
                }
                
                
            }
        } //next contestant
        
        System.out.println("--- WHAT we have ------");
        //ContListDebug();

//        ---------------------------------------------------
//        1	Dan		active		1
//        2	Josh		active		20
//        3	Matty		active		30
//        4	Tasha		active		20
//        5	Cristy		eliminated	0
//        ----------------------------------------------------
//        1	Dan		active              10
//        2	Josh		delete              0
//        3	Matty		active              33
//        4	Tasha		active              44
//        5	Cristy		eliminated          10
//        ----------------------------------------------------

         //Recalculate users scores after admin update contestants data
                  
        //        Weekly points awarded up to and including episode nine:
        //            Correct nomination of the Best Baker = 4 points
        //            If your nominated Best Baker is eliminated, then 1 point will be deducted from your total
        //            Correct weekly nomination of baker to leave = 3 points
        //            If your nominated baker to leave is the Best Baker 1 point will be deducted from your total.
        //            Correct nomination of the winner of that week’s technical round = 2 points
        //
        //        Points awarded at the end of the final episode of the series:
        //            Overall winner chosen after episode one and before episode two = 7 points
        //            The other two finalists chosen after episode one and before episode two = 2 points each
        //            Winner of the final episode, chosen after episode nine = 4 points
        //            No technical round or elimination nominations for the final episode

        // Finally calc statistics
        int index = 0;
        double max_score = -1000;
        String BestBakerName, bakerToLeave, technicalRoundBaker;
        for (String p: contestants) {
 
            String[] oldContestantData = p.split(csvSplitBy);
            String[] newContestantData = contestantsUpdated[index].split(csvSplitBy);

            //System.out.println(index + "\t" + oldContestantData[indName] + "\t\t" + oldContestantData[indState] + "->" + newContestantData[indState] + "\t\t\t" + oldContestantData[indPoints] + "->" + newContestantData[indPoints] );
            
            double curContatnP = Double.valueOf(newContestantData[indPoints]);
            if (curContatnP>max_score){
                max_score = curContatnP;
                BestBakerName = oldContestantData[indName];
            }
            
            if (!oldContestantData[indState].equalsIgnoreCase("eliminated") && newContestantData[indState].equalsIgnoreCase("eliminated") ) {
                bakerToLeave = oldContestantData[indName];
            }
            
            index++;
        }

        
        // make admin input data then write to file
        //String data = " ";
        //rwFile.AdminWriteContentantsData2File(data);

    }  

    
     public void getAllUsersScore(){
        ShowPlayersTable();
     }

     public void getAllContestants(){
        ShowContestantsTable();
     }     
     
     public String getAllContestantsHintList(){
        String strOut = "";
        if (totalContestantsCount==0) {
            System.out.println("No contestants found");
            return strOut;
        }
        String csvSplitBy = ",";
        int indName = 0, indState = 1, indPoints = 2, cnt = 0;
        for (String p: contestants) {
            if (p!=null ) {
                cnt++;
                String[] ContestantData = p.split(csvSplitBy);
                strOut = strOut + ContestantData[indName]; 
                if (cnt<totalContestantsCount) strOut += ",";
            }
        }
        return "(" +strOut + ")";
     }
     
     public String getChoosenContestantName(String NameToCheck){
        String strOut = "";
        if (totalContestantsCount==0) return strOut;
        String csvSplitBy = ",";
        int indName = 0, indState = 1, indPoints = 2;
        for (String p: contestants) {
            if (p!=null ) {
                String[] ContestantData = p.split(csvSplitBy);
                if ( NameToCheck.equalsIgnoreCase( ContestantData[indName])) {
                    strOut = ContestantData[indName];
                    return strOut;
                }  
            }
        }
        return strOut;
     }     

    public String AskPlayerForContestantName(String smessage) {
        String ContestantName;
        do  {
            ContestantName = userInp.getUserInput(smessage);
        } while (ContestantName.isEmpty());
        return ContestantName;
    }
    
    public boolean ShowPlayerPredictions() {
        
        String cPlayerName = ProjectFantasyGreatBritishBakeOffLeague.userMenu.currentPlayer.getName();
        boolean isNew = ProjectFantasyGreatBritishBakeOffLeague.userMenu.currentPlayer.getIsNewPlayer();        
        
        if (totalPlayersCount==0 || isNew) {
            System.out.println("No predictions found");
            return false;
        }
        
        String csvSplitBy = ",";

        int indName = 0, indPoints = 1, indBestBaker = 2, indBakertoLeave = 3, indWinnerTechnical = 4;
        
        for (String p: players) {
            if (p!=null ) {
                String[] playerData = p.split(csvSplitBy);
                if (cPlayerName.equalsIgnoreCase(playerData[indName])) {
                    System.out.println(playerData[indName] + ", your score is " + String.format("%.2f", Double.valueOf(playerData[indPoints]) ) );
                    System.out.println("---------------------------------------------------");                    
                    System.out.println("Nominate the Best Baker: " + playerData[indBestBaker]);
                    System.out.println("Nominate the Baker to Leave: " + playerData[indBakertoLeave]);
                    System.out.println("Nominate the Winner of Technical Round: " + playerData[indWinnerTechnical]);
                    System.out.println("---------------------------------------------------"); 
                    return true;
                }
                
            }
        }
        return false;
    }
    
    public boolean setPlayerPredictions(String Name1, String Name2, String Name3) {

        String cPlayerName = ProjectFantasyGreatBritishBakeOffLeague.userMenu.currentPlayer.getName();
        double score = ProjectFantasyGreatBritishBakeOffLeague.userMenu.currentPlayer.getScore() ;
        boolean isNew = ProjectFantasyGreatBritishBakeOffLeague.userMenu.currentPlayer.getIsNewPlayer();
        int Ind = 0;
        if (totalPlayersCount==0 || isNew ) {
            if (totalPlayersCount!=0) Ind = totalPlayersCount+1;
            players[Ind] = cPlayerName + "," + score + "," + Name1 + "," + Name2 + "," + Name3;
            SavePlayers();
            return true;
        } else {
            int indName = 0, indPoints = 1;
            String csvSplitBy = ",";
            for (int i=0; i<players.length; i++) {
                if (players[i]!=null ) {
                    String[] playerData = players[i].split(csvSplitBy);
                    if (cPlayerName.equalsIgnoreCase( playerData[indName] )) {
                        players[i] = playerData[indName] + "," + playerData[indPoints] + "," + Name1 + "," + Name2 + "," + Name3;
                        SavePlayers();
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public void doUserPrediction(){
        System.out.println("Select 3 contestants out of:\n" + getAllContestantsHintList() + "\nOR CANCEL to quit prediction");
        System.out.println("---------------------------------");

        boolean canGoOn = false;
        String tmpContestantName1 ="", tmpContestantName2="", tmpContestantName3="";
        
        do{
            tmpContestantName1 = AskPlayerForContestantName("Nominate the Best Baker: ");
            if(tmpContestantName1.equalsIgnoreCase("cancel")) return;
            if (!getChoosenContestantName(tmpContestantName1).isEmpty()) canGoOn = true; 
            if(!canGoOn) System.out.println("Wrong name, try one more time");
        } while (!canGoOn);
        System.out.println("For the Best Baker, ["+tmpContestantName1+"] is selected");
        //setBestBakerNomination()

        canGoOn = false;
        while (!canGoOn) {
            tmpContestantName2 = AskPlayerForContestantName("Nominate the Baker to Leave: ");
            if(tmpContestantName2.equalsIgnoreCase("cancel")) return;
            if (!getChoosenContestantName(tmpContestantName2).isEmpty()) canGoOn = true;
            if(!canGoOn) System.out.println("Wrong name, try one more time");
        }
        System.out.println("For Baker to Leave, ["+tmpContestantName2+"] is selected");
        //setBakerToLeaveNomination

        canGoOn = false;
        while (!canGoOn) {
            tmpContestantName3 = AskPlayerForContestantName("Nominate the Winner of Technical Round: ");
            if(tmpContestantName3.equalsIgnoreCase("cancel")) return;
            if (!getChoosenContestantName(tmpContestantName3).isEmpty()) canGoOn = true;
            if(!canGoOn) System.out.println("Wrong name, try one more time");
        }
        System.out.println("For the Winner of Technical Round, ["+tmpContestantName3+"] is selected");
        //setTechnicalRoundWinnerNomination
        
        if (setPlayerPredictions(tmpContestantName1, tmpContestantName2, tmpContestantName3)) {
            System.out.println("Done!");
        } else {
            System.out.println("Error while saving");
        }
        
    }  

       
}
